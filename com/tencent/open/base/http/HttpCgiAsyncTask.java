package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.base.f;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import cooperation.qzone.QzoneIPCModule;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import mqq.app.MobileQQ;
import org.apache.http.ConnectionClosedException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HttpCgiAsyncTask extends com.tencent.open.base.http.a<Bundle, Void, HashMap<String, Object>> {

    /* renamed from: c, reason: collision with root package name */
    protected Handler f341004c;

    /* renamed from: d, reason: collision with root package name */
    protected a f341005d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f341006e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void f(JSONObject jSONObject);

        void onException(Exception exc);
    }

    public HttpCgiAsyncTask(String str, String str2, a aVar) {
        super(str, str2);
        this.f341004c = new Handler(Looper.getMainLooper());
        this.f341005d = aVar;
    }

    public static int e(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        if (iOException instanceof ZipException) {
            return -54;
        }
        return -2;
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    public void b(Bundle bundle) {
        Executor a16 = a();
        if (a16 != null) {
            executeOnExecutor(a16, bundle);
        } else {
            execute(bundle);
        }
    }

    public void c() {
        Handler handler = this.f341004c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f341005d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public HashMap<String, Object> doInBackground(Bundle... bundleArr) {
        return f(bundleArr);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:14|(18:15|16|17|18|19|(1:21)(1:(1:98)(1:99))|22|23|24|25|(2:27|(1:29)(1:30))|31|(2:33|(1:35))(2:83|84)|36|38|39|41|42)|43|44|45|(1:47)|49|50|12) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x02ec, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02ed, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02df A[Catch: Exception -> 0x02ec, TRY_LEAVE, TryCatch #4 {Exception -> 0x02ec, blocks: (B:45:0x02d7, B:47:0x02df), top: B:44:0x02d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0305 A[LOOP:0: B:12:0x00aa->B:93:0x0305, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0271 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, Object> f(Bundle... bundleArr) {
        boolean z16;
        String str;
        int e16;
        int i3;
        long j3;
        long j16;
        long elapsedRealtime;
        int i16;
        long j17;
        long j18;
        long j19;
        SimpleAccount firstSimpleAccount;
        String str2 = "";
        HashMap<String, Object> hashMap = new HashMap<>();
        if (isCancelled()) {
            return hashMap;
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        String insertMtype = MsfSdkUtils.insertMtype("yingyongbao", this.f341008a);
        String string = bundleArr[0].getString("appid_for_getting_config");
        try {
            z16 = bundleArr[0].getBoolean("from_h5", false);
        } catch (Exception unused) {
            z16 = false;
        }
        int j26 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), string).j("Common_HttpRetryCount");
        f.a("OpenConfig_agent", "config 1:Common_HttpRetryCount            config_value:" + j26 + "   appid:" + string + "     url:" + insertMtype);
        if (j26 == 0) {
            j26 = 3;
        }
        StringBuilder sb5 = new StringBuilder();
        long j27 = elapsedRealtime2;
        sb5.append("config 1:Common_HttpRetryCount            result_value:");
        sb5.append(j26);
        sb5.append("   appid:");
        sb5.append(string);
        sb5.append("     url:");
        sb5.append(insertMtype);
        f.a("OpenConfig_agent", sb5.toString());
        String string2 = bundleArr[0].getString("downloadfile");
        int i17 = 0;
        while (!isCancelled()) {
            int i18 = i17 + 1;
            long j28 = 0;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    HttpBaseUtil.c h16 = h(this.f341008a, this.f341009b, bundleArr[0]);
                                    String str3 = h16.f340999a;
                                    JSONObject jSONObject = new JSONObject();
                                    if (string2 != null) {
                                        jSONObject.put("content", h16.f341003e);
                                    } else if (z16) {
                                        str3 = HttpBaseUtil.p(str3);
                                        jSONObject.put("content", str3);
                                    } else {
                                        jSONObject = HttpBaseUtil.o(str3);
                                    }
                                    StringBuilder sb6 = new StringBuilder();
                                    str = string2;
                                    try {
                                        sb6.append("response.isModified= ");
                                        sb6.append(h16.f341002d);
                                        f.h("HttpCgiAsyncTask", sb6.toString());
                                        int i19 = h16.f341002d;
                                        if (i19 == 0) {
                                            if (z16) {
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put("httpdatamodified", h16.f341002d);
                                                jSONObject.put(QFSEdgeItem.KEY_EXTEND, jSONObject2);
                                            } else {
                                                jSONObject.put("httpdatamodified", i19);
                                            }
                                        }
                                        hashMap.put("ResultType", 1);
                                        hashMap.put("ResultValue", jSONObject);
                                        i16 = -55;
                                        if (z16) {
                                            Matcher matcher = Pattern.compile("\"(?:ret|resultCode)\"\\s*\\:\\s*(\\d+)").matcher(str3);
                                            if (matcher.find()) {
                                                i16 = Integer.parseInt(matcher.group(1));
                                            }
                                        } else {
                                            try {
                                                try {
                                                    i16 = jSONObject.getInt("ret");
                                                } catch (JSONException unused2) {
                                                    i16 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                                                }
                                            } catch (JSONException unused3) {
                                            }
                                        }
                                        long j29 = h16.f341000b;
                                        try {
                                            j18 = h16.f341001c;
                                            j19 = j29;
                                            j17 = j27;
                                        } catch (HttpBaseUtil.HttpStatusException e17) {
                                            e = e17;
                                            j3 = j29;
                                            i3 = 0;
                                            e.printStackTrace();
                                            hashMap.put("ResultType", Integer.valueOf(i3));
                                            hashMap.put("ResultValue", e);
                                            try {
                                                ReportManager.h().k(insertMtype, j27, j3, 0L, Integer.parseInt(e.getMessage().replace(HttpBaseUtil.HttpStatusException.ERROR_INFO, str2)), com.tencent.open.adapter.a.f().l(), "1000002", null, this.f341006e);
                                            } catch (Exception e18) {
                                                e18.printStackTrace();
                                            }
                                            return hashMap;
                                        } catch (Exception e19) {
                                            e = e19;
                                            j16 = j29;
                                            if (e instanceof HttpBaseUtil.NetworkUnavailableException) {
                                                e.printStackTrace();
                                                hashMap.put("ResultType", 0);
                                                hashMap.put("ResultValue", e);
                                                return hashMap;
                                            }
                                            if (e instanceof HttpBaseUtil.HttpStatusException) {
                                                e.printStackTrace();
                                                hashMap.put("ResultType", 0);
                                                hashMap.put("ResultValue", e);
                                                try {
                                                    ReportManager.h().k(insertMtype, j27, j16, 0L, Integer.parseInt(e.getMessage().replace(HttpBaseUtil.HttpStatusException.ERROR_INFO, str2)), com.tencent.open.adapter.a.f().l(), "1000002", null, this.f341006e);
                                                } catch (Exception e26) {
                                                    e26.printStackTrace();
                                                }
                                                return hashMap;
                                            }
                                            if (e instanceof IOException) {
                                                e.printStackTrace();
                                                hashMap.put("ResultType", 0);
                                                hashMap.put("ResultValue", e);
                                                e16 = e((IOException) e);
                                            } else {
                                                e.printStackTrace();
                                                hashMap.put("ResultType", 0);
                                                hashMap.put("ResultValue", e);
                                                e16 = -6;
                                            }
                                            i16 = e16;
                                            j17 = j27;
                                            j18 = 0;
                                            j19 = 0;
                                            f.a("ReportManager", insertMtype + APLogFileUtil.SEPARATOR_LOG + j17 + APLogFileUtil.SEPARATOR_LOG + j19 + APLogFileUtil.SEPARATOR_LOG + j18 + APLogFileUtil.SEPARATOR_LOG + i16);
                                            firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
                                            if (firstSimpleAccount != null) {
                                            }
                                            ReportManager.h().k(insertMtype, j17, j19, j18, i16, j28, "1000002", null, this.f341006e);
                                            return hashMap;
                                        }
                                    } catch (SocketTimeoutException e27) {
                                        e = e27;
                                        e.printStackTrace();
                                        hashMap.put("ResultType", 0);
                                        hashMap.put("ResultValue", e);
                                        elapsedRealtime = SystemClock.elapsedRealtime();
                                        e16 = -8;
                                        j27 = elapsedRealtime;
                                        if (i18 < j26) {
                                            i16 = e16;
                                            j17 = j27;
                                            j18 = 0;
                                            j19 = 0;
                                            f.a("ReportManager", insertMtype + APLogFileUtil.SEPARATOR_LOG + j17 + APLogFileUtil.SEPARATOR_LOG + j19 + APLogFileUtil.SEPARATOR_LOG + j18 + APLogFileUtil.SEPARATOR_LOG + i16);
                                            firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
                                            if (firstSimpleAccount != null) {
                                            }
                                            ReportManager.h().k(insertMtype, j17, j19, j18, i16, j28, "1000002", null, this.f341006e);
                                            return hashMap;
                                        }
                                        i17 = i18;
                                        string2 = str;
                                    } catch (ConnectTimeoutException e28) {
                                        e = e28;
                                        e.printStackTrace();
                                        hashMap.put("ResultType", 0);
                                        hashMap.put("ResultValue", e);
                                        elapsedRealtime = SystemClock.elapsedRealtime();
                                        e16 = -7;
                                        j27 = elapsedRealtime;
                                        if (i18 < j26) {
                                        }
                                    }
                                } catch (HttpBaseUtil.HttpStatusException e29) {
                                    e = e29;
                                    j3 = 0;
                                }
                            } catch (SocketTimeoutException e36) {
                                e = e36;
                                str = string2;
                            } catch (ConnectTimeoutException e37) {
                                e = e37;
                                str = string2;
                            }
                        } catch (HttpBaseUtil.NetworkUnavailableException e38) {
                            e38.printStackTrace();
                            hashMap.put("ResultType", 0);
                            hashMap.put("ResultValue", e38);
                            return hashMap;
                        } catch (IOException e39) {
                            e39.printStackTrace();
                            hashMap.put("ResultType", 0);
                            hashMap.put("ResultValue", e39);
                            e16 = e(e39);
                            i16 = e16;
                            j17 = j27;
                            j18 = 0;
                            j19 = 0;
                            f.a("ReportManager", insertMtype + APLogFileUtil.SEPARATOR_LOG + j17 + APLogFileUtil.SEPARATOR_LOG + j19 + APLogFileUtil.SEPARATOR_LOG + j18 + APLogFileUtil.SEPARATOR_LOG + i16);
                            firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
                            if (firstSimpleAccount != null) {
                            }
                            ReportManager.h().k(insertMtype, j17, j19, j18, i16, j28, "1000002", null, this.f341006e);
                            return hashMap;
                        }
                    } catch (HttpBaseUtil.HttpStatusException e46) {
                        e = e46;
                        i3 = 0;
                        j3 = 0;
                    }
                } catch (Exception e47) {
                    e = e47;
                    j16 = 0;
                }
            } catch (JSONException e48) {
                e48.printStackTrace();
                hashMap.put("ResultType", 0);
                hashMap.put("ResultValue", e48);
                e16 = -4;
                i16 = e16;
                j17 = j27;
                j18 = 0;
                j19 = 0;
                f.a("ReportManager", insertMtype + APLogFileUtil.SEPARATOR_LOG + j17 + APLogFileUtil.SEPARATOR_LOG + j19 + APLogFileUtil.SEPARATOR_LOG + j18 + APLogFileUtil.SEPARATOR_LOG + i16);
                firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
                if (firstSimpleAccount != null) {
                }
                ReportManager.h().k(insertMtype, j17, j19, j18, i16, j28, "1000002", null, this.f341006e);
                return hashMap;
            }
            f.a("ReportManager", insertMtype + APLogFileUtil.SEPARATOR_LOG + j17 + APLogFileUtil.SEPARATOR_LOG + j19 + APLogFileUtil.SEPARATOR_LOG + j18 + APLogFileUtil.SEPARATOR_LOG + i16);
            firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount != null) {
                j28 = Long.valueOf(firstSimpleAccount.getUin()).longValue();
            }
            ReportManager.h().k(insertMtype, j17, j19, j18, i16, j28, "1000002", null, this.f341006e);
            return hashMap;
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(final HashMap<String, Object> hashMap) {
        if (!isCancelled()) {
            this.f341004c.post(new Runnable() { // from class: com.tencent.open.base.http.HttpCgiAsyncTask.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HttpCgiAsyncTask.this.f341005d != null) {
                        if (((Integer) hashMap.get("ResultType")).intValue() == 1) {
                            HttpCgiAsyncTask.this.f341005d.f((JSONObject) hashMap.get("ResultValue"));
                        } else {
                            HttpCgiAsyncTask.this.f341005d.onException((Exception) hashMap.get("ResultValue"));
                        }
                    }
                }
            });
        }
    }

    public HttpBaseUtil.c h(String str, String str2, Bundle bundle) throws Exception {
        return HttpBaseUtil.m(str, str2, bundle);
    }

    public void i() {
        this.f341005d = null;
    }

    public HttpCgiAsyncTask(String str, String str2, a aVar, boolean z16) {
        super(str, str2);
        this.f341004c = new Handler(Looper.getMainLooper());
        this.f341005d = aVar;
        this.f341006e = z16;
    }
}
