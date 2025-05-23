package com.tencent.mobileqq.highway.netprobe;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes9.dex */
public class EchoTask {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_2G_TIMEOUT = 20000;
    private static final int DEFAULT_3G_TIMEOUT = 15000;
    private static final int DEFAULT_4G_TIMEOUT = 10000;
    private static final int DEFAULT_WIFI_TIMEOUT = 10000;
    private static Pair<String, String>[] ECHO_ADDRESS = null;
    public static final int ECHO_EXCEPTION = 3;
    public static final int ECHO_NORMAL = 1;
    public static final int ECHO_REDIRECT_EXCEPTION = -1000;
    public static final int ECHO_RESPONSECODE_EXCEPTION = -999;
    public static final int ECHO_RESP_LENGTH = 20;
    public static final int ECHO_SERVER_EXCEPTION = -998;
    public static final int ECHO_UNKONW_EXCEPTION = -997;
    public static final int ECHO_WRONG_CONTENT = 2;
    private static final int MAX_REDIRECT_TIME = 5;
    private String errorMsg;
    private Context mContext;
    private String mExpectContent;
    private String mRealResponse;
    private String mRequestURL;
    private String mResponseURL;
    private int mTimeout;
    public int mType;
    private int responseCode;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface ECHO_TYPE {
        public static final int HTTP_GET = 1;
        public static final int HTTP_POST = 2;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    interface NetType {
        public static final int CABLE = 5;
        public static final int G2 = 2;
        public static final int G3 = 3;
        public static final int G4 = 4;
        public static final int NONE = 0;
        public static final int WIFI = 1;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            ECHO_ADDRESS = new Pair[]{new Pair<>("http://183.60.50.149:8080/cgi-bin/httpecho?len=20", null), new Pair<>("http://112.90.137.111:8080/cgi-bin/httpecho?len=20", null), new Pair<>("http://120.198.191.71:8080/cgi-bin/httpecho?len=20", null)};
        }
    }

    public EchoTask(Context context) {
        this(context, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void fillErrorMsg(int i3, String str) {
        switch (i3) {
            case -1000:
                this.errorMsg = "echo connect redirect error:" + str;
                return;
            case -999:
                this.errorMsg = "echo response exception,the responseCode is:" + str;
                return;
            case ECHO_SERVER_EXCEPTION /* -998 */:
                this.errorMsg = "echo connect exception:" + str;
                return;
            case ECHO_UNKONW_EXCEPTION /* -997 */:
                this.errorMsg = "echo unkonw exception:" + str;
                return;
            default:
                return;
        }
    }

    private String getMethod(int i3) {
        if (i3 != 2) {
            return "GET";
        }
        return "POST";
    }

    private int getSystemNetwork() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 9) {
                switch (type) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        switch (NetworkMonitor.getNetworkType((TelephonyManager) this.mContext.getSystemService("phone"))) {
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return 3;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                return 2;
                            case 13:
                                return 4;
                        }
                    case 1:
                    case 6:
                        return 1;
                }
            }
            return 5;
        }
        return 0;
    }

    private int getTimeoutMills() {
        int systemNetwork = getSystemNetwork();
        if (systemNetwork == 1) {
            return 10000;
        }
        if (systemNetwork != 3) {
            if (systemNetwork == 4) {
                return 10000;
            }
            return 20000;
        }
        return 15000;
    }

    public boolean checkEchoResp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        char[] charArray = str.toCharArray();
        if (charArray.length != 20) {
            return false;
        }
        for (char c16 : charArray) {
            if ('A' > c16 || c16 > 'Z') {
                return false;
            }
        }
        return true;
    }

    public int doEcho() {
        HttpURLConnection httpURLConnection;
        IOException e16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        HttpURLConnection httpURLConnection2 = null;
        for (Pair<String, String> pair : ECHO_ADDRESS) {
            try {
                String str = (String) pair.first;
                this.mRequestURL = str;
                this.mExpectContent = (String) pair.second;
                int i3 = 0;
                while (true) {
                    if (i3 < 5) {
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            try {
                                httpURLConnection.setDoInput(true);
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setUseCaches(false);
                                httpURLConnection.setRequestMethod(getMethod(this.mType));
                                httpURLConnection.setConnectTimeout(this.mTimeout);
                                httpURLConnection.setReadTimeout(this.mTimeout);
                                httpURLConnection.connect();
                                if (this.mType == 2) {
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    byte[] bArr = new byte[2048];
                                    new Random().nextBytes(bArr);
                                    outputStream.write(bArr);
                                    outputStream.flush();
                                }
                                int responseCode = httpURLConnection.getResponseCode();
                                this.responseCode = responseCode;
                                if (responseCode != 301 && responseCode != 302) {
                                    if (responseCode != 404) {
                                        z16 = false;
                                        httpURLConnection2 = httpURLConnection;
                                    }
                                }
                                i3++;
                                if (i3 == 5) {
                                    fillErrorMsg(-1000, "redirect to many!");
                                    break;
                                }
                                String headerField = httpURLConnection.getHeaderField("Location");
                                if (headerField == null) {
                                    fillErrorMsg(-1000, " redirect and location header can't get ");
                                    break;
                                }
                                httpURLConnection2 = httpURLConnection;
                                str = headerField;
                            } catch (IOException e17) {
                                e16 = e17;
                                try {
                                    do {
                                    } while (httpURLConnection.getErrorStream().read() != -1);
                                } catch (Exception unused) {
                                }
                                fillErrorMsg(ECHO_UNKONW_EXCEPTION, e16.toString());
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                httpURLConnection2 = httpURLConnection;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                httpURLConnection2 = httpURLConnection;
                z16 = true;
            } catch (IOException e18) {
                httpURLConnection = httpURLConnection2;
                e16 = e18;
            } catch (Throwable th6) {
                th = th6;
            }
            if (!z16) {
                this.mResponseURL = httpURLConnection2.getURL().toString();
                int i16 = this.responseCode;
                if (i16 != 200 && i16 != 206) {
                    fillErrorMsg(-999, this.responseCode + "");
                    httpURLConnection2.disconnect();
                    return 3;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine + "\n");
                }
                bufferedReader.close();
                String trim = sb5.toString().trim();
                this.mRealResponse = trim;
                if (checkEchoResp(trim)) {
                    httpURLConnection2.disconnect();
                    return 1;
                }
                httpURLConnection2.disconnect();
                return 2;
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        }
        return 3;
    }

    public String getErrorMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.errorMsg;
    }

    public String getExpectContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mExpectContent;
    }

    public String getResponseContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mRealResponse;
    }

    public String getResponseUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mResponseURL;
    }

    public int getTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mTimeout;
    }

    public EchoTask(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.errorMsg = "unkonw";
        this.mContext = context;
        this.mType = i3;
        this.mTimeout = getTimeoutMills();
    }
}
