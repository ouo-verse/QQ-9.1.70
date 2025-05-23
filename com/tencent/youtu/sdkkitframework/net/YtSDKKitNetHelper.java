package com.tencent.youtu.sdkkitframework.net;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.youtu.sdkkitframework.common.EncryptUtil;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtSDKKitNetHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "YtSDKKitNetHelper";
    private static final int TIME_OUT = 10000;
    private static YtSDKKitNetHelper _instane;
    private HttpsURLConnection conn;
    private Thread networkThread;
    private HashMap<Integer, Thread> runningMap;

    YtSDKKitNetHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.runningMap = new HashMap<>();
        }
    }

    public static synchronized void clearInstance() {
        synchronized (YtSDKKitNetHelper.class) {
            YtSDKKitNetHelper ytSDKKitNetHelper = _instane;
            if (ytSDKKitNetHelper != null) {
                ytSDKKitNetHelper.stopNetworkRequest();
            }
            _instane = null;
        }
    }

    public static synchronized YtSDKKitNetHelper getInstance() {
        YtSDKKitNetHelper ytSDKKitNetHelper;
        synchronized (YtSDKKitNetHelper.class) {
            if (_instane == null) {
                _instane = new YtSDKKitNetHelper();
            }
            ytSDKKitNetHelper = _instane;
        }
        return ytSDKKitNetHelper;
    }

    public void sendNetworkRequest(String str, String str2, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, hashMap, iYtSDKKitNetResponseParser);
            return;
        }
        BaseThread baseThread = new BaseThread(new Runnable(str, hashMap, str2, iYtSDKKitNetResponseParser) { // from class: com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper.1
            static IPatchRedirector $redirector_;
            public final /* synthetic */ YtSDKKitFramework.IYtSDKKitNetResponseParser val$parser;
            public final /* synthetic */ String val$requestContent;
            public final /* synthetic */ HashMap val$requestHeader;
            public final /* synthetic */ String val$url;

            {
                this.val$url = str;
                this.val$requestHeader = hashMap;
                this.val$requestContent = str2;
                this.val$parser = iYtSDKKitNetResponseParser;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, YtSDKKitNetHelper.this, str, hashMap, str2, iYtSDKKitNetResponseParser);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    YtSDKKitNetHelper.this.runningMap.put(Integer.valueOf(Process.myTid()), YtSDKKitNetHelper.this.networkThread);
                    YtSDKKitNetHelper.this.conn = (HttpsURLConnection) new URL(this.val$url).openConnection();
                    YtSDKKitNetHelper.this.conn.setRequestMethod("POST");
                    YtSDKKitNetHelper.this.conn.setConnectTimeout(YtSDKKitFramework.getInstance().getNetworkRequestTimeoutMS());
                    HashMap hashMap2 = this.val$requestHeader;
                    if (hashMap2 != null) {
                        for (Map.Entry entry : hashMap2.entrySet()) {
                            YtSDKKitNetHelper.this.conn.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Write buffer");
                    OutputStream outputStream = YtSDKKitNetHelper.this.conn.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(this.val$requestContent);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Wait response");
                    int responseCode = YtSDKKitNetHelper.this.conn.getResponseCode();
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Get response");
                    if (!YtSDKKitNetHelper.this.runningMap.containsKey(Integer.valueOf(Process.myTid()))) {
                        YtLogger.i(YtSDKKitNetHelper.TAG, "Exit network response handling");
                        YtSDKKitNetHelper.this.conn.disconnect();
                        return;
                    }
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(YtSDKKitNetHelper.this.conn.getInputStream()));
                        StringBuffer stringBuffer = new StringBuffer("");
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        }
                        bufferedReader.close();
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put("response", stringBuffer.toString());
                        this.val$parser.onNetworkResponseEvent(hashMap3, null);
                    } else {
                        YtLogger.e(YtSDKKitNetHelper.TAG, "Network response failed " + responseCode, null);
                        this.val$parser.onNetworkResponseEvent(null, new Exception("Https Response Failed with code:" + responseCode));
                    }
                } catch (IOException e16) {
                    YtLogger.e(YtSDKKitNetHelper.TAG, "Network response failed ", e16);
                    this.val$parser.onNetworkResponseEvent(null, e16);
                } finally {
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Network disconnected");
                    YtSDKKitNetHelper.this.conn.disconnect();
                }
            }
        });
        this.networkThread = baseThread;
        baseThread.setName("YtNetworkRequestThread");
        this.networkThread.start();
    }

    public void sendNetworkRequestEncry(String str, String str2, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, hashMap, iYtSDKKitNetResponseParser);
            return;
        }
        BaseThread baseThread = new BaseThread(new Runnable(str, hashMap, str2, iYtSDKKitNetResponseParser) { // from class: com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper.2
            static IPatchRedirector $redirector_;
            public final /* synthetic */ YtSDKKitFramework.IYtSDKKitNetResponseParser val$parser;
            public final /* synthetic */ String val$requestContent;
            public final /* synthetic */ HashMap val$requestHeader;
            public final /* synthetic */ String val$url;

            {
                this.val$url = str;
                this.val$requestHeader = hashMap;
                this.val$requestContent = str2;
                this.val$parser = iYtSDKKitNetResponseParser;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, YtSDKKitNetHelper.this, str, hashMap, str2, iYtSDKKitNetResponseParser);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int responseCode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    try {
                        try {
                            try {
                                YtSDKKitNetHelper.this.runningMap.put(Integer.valueOf(Process.myTid()), YtSDKKitNetHelper.this.networkThread);
                                YtSDKKitNetHelper.this.conn = (HttpsURLConnection) new URL(this.val$url).openConnection();
                                YtSDKKitNetHelper.this.conn.setRequestMethod("POST");
                                YtSDKKitNetHelper.this.conn.setConnectTimeout(YtSDKKitFramework.getInstance().getNetworkRequestTimeoutMS());
                                HashMap hashMap2 = this.val$requestHeader;
                                if (hashMap2 != null) {
                                    for (Map.Entry entry : hashMap2.entrySet()) {
                                        YtSDKKitNetHelper.this.conn.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    }
                                }
                                String generateEncReq = new EncryptUtil().generateEncReq(this.val$requestContent, "testid", "", "");
                                YtLogger.d(YtSDKKitNetHelper.TAG, "Write buffer");
                                OutputStream outputStream = YtSDKKitNetHelper.this.conn.getOutputStream();
                                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                bufferedWriter.write(generateEncReq);
                                bufferedWriter.flush();
                                bufferedWriter.close();
                                outputStream.close();
                                YtLogger.d(YtSDKKitNetHelper.TAG, "Wait response");
                                responseCode = YtSDKKitNetHelper.this.conn.getResponseCode();
                                YtLogger.d(YtSDKKitNetHelper.TAG, "Get response");
                            } catch (InvalidAlgorithmParameterException e16) {
                                e16.printStackTrace();
                            } catch (InvalidKeyException e17) {
                                e17.printStackTrace();
                            } catch (BadPaddingException e18) {
                                e18.printStackTrace();
                            }
                        } catch (IOException e19) {
                            YtLogger.e(YtSDKKitNetHelper.TAG, "Network response failed ", e19);
                            this.val$parser.onNetworkResponseEvent(null, e19);
                            YtLogger.d(YtSDKKitNetHelper.TAG, "Network disconnected");
                            YtSDKKitNetHelper.this.conn.disconnect();
                            return;
                        } catch (NoSuchAlgorithmException e26) {
                            e26.printStackTrace();
                        }
                    } catch (IllegalBlockSizeException e27) {
                        e27.printStackTrace();
                    } catch (NoSuchPaddingException e28) {
                        e28.printStackTrace();
                    }
                    if (!YtSDKKitNetHelper.this.runningMap.containsKey(Integer.valueOf(Process.myTid()))) {
                        YtLogger.i(YtSDKKitNetHelper.TAG, "Exit network response handling");
                        YtSDKKitNetHelper.this.conn.disconnect();
                        YtLogger.d(YtSDKKitNetHelper.TAG, "Network disconnected");
                        YtSDKKitNetHelper.this.conn.disconnect();
                        return;
                    }
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(YtSDKKitNetHelper.this.conn.getInputStream()));
                        StringBuffer stringBuffer = new StringBuffer("");
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        }
                        bufferedReader.close();
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put("response", stringBuffer.toString());
                        this.val$parser.onNetworkResponseEvent(hashMap3, null);
                    } else {
                        YtLogger.e(YtSDKKitNetHelper.TAG, "Network response failed " + responseCode, null);
                        this.val$parser.onNetworkResponseEvent(null, new Exception("Https Response Failed with code:" + responseCode));
                    }
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Network disconnected");
                    YtSDKKitNetHelper.this.conn.disconnect();
                } catch (Throwable th5) {
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Network disconnected");
                    YtSDKKitNetHelper.this.conn.disconnect();
                    throw th5;
                }
            }
        });
        this.networkThread = baseThread;
        baseThread.setName("YtNetworkRequestThread");
        this.networkThread.start();
    }

    public void stopNetworkRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        for (Map.Entry<Integer, Thread> entry : this.runningMap.entrySet()) {
            if (entry.getValue() == this.networkThread) {
                this.runningMap.remove(entry.getKey());
                YtLogger.d(TAG, "network remove " + entry.getKey());
                return;
            }
        }
    }
}
