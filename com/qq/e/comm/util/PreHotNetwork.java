package com.qq.e.comm.util;

import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public class PreHotNetwork {
    private static volatile PreHotNetwork INSTANCE = null;
    public static final int PRE_DNS = 1;
    public static final int PRE_SSL = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PreType {
    }

    public static PreHotNetwork getInstance() {
        if (INSTANCE == null) {
            synchronized (PreHotNetwork.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PreHotNetwork();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preDns(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            InetAddress.getAllByName(str);
            GDTLogger.d("DNS pre success : " + str);
            a.d(System.currentTimeMillis() - currentTimeMillis, 4010);
        } catch (UnknownHostException e16) {
            e16.printStackTrace();
            GDTLogger.d("DNS pre failed : " + str);
            a.d(System.currentTimeMillis() - currentTimeMillis, 4011);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preSsl(String str) {
        Exception e16;
        HttpURLConnection httpURLConnection;
        long currentTimeMillis = System.currentTimeMillis();
        ?? r26 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Exception e17) {
                e16 = e17;
                httpURLConnection = null;
            } catch (Throwable th5) {
                th = th5;
                if (r26 != 0) {
                }
                throw th;
            }
            try {
                httpURLConnection.connect();
                GDTLogger.d("SSL pre success");
                a.d(System.currentTimeMillis() - currentTimeMillis, 4012);
                httpURLConnection.disconnect();
            } catch (Exception e18) {
                e16 = e18;
                e16.printStackTrace();
                GDTLogger.d("SSL pre failed");
                a.d(System.currentTimeMillis() - currentTimeMillis, 4013);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            r26 = str;
            if (r26 != 0) {
                r26.disconnect();
            }
            throw th;
        }
    }

    public void preRequest(final int i3) {
        SM sm5;
        String str;
        String str2;
        if (GDTADManager.getInstance().getSM() == null) {
            return;
        }
        boolean z16 = true;
        if (i3 == 1) {
            if (GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.PRE_DNS_REQUEST, 0) != 1) {
                z16 = false;
            }
            if (z16) {
                sm5 = GDTADManager.getInstance().getSM();
                str = Constants.KEYS.PRE_DNS_REQUEST_LIST;
                str2 = sm5.getString(str);
            }
            str2 = "";
        } else {
            if (i3 == 2) {
                if (GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.PRE_SSL_REQUEST, 0) != 1) {
                    z16 = false;
                }
                if (z16) {
                    sm5 = GDTADManager.getInstance().getSM();
                    str = Constants.KEYS.PRE_SSL_REQUEST_LIST;
                    str2 = sm5.getString(str);
                }
            }
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            String[] split = str2.split(",");
            if (split.length > 0) {
                for (final String str3 : split) {
                    GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.util.PreHotNetwork.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i16 = i3;
                            if (i16 == 1) {
                                PreHotNetwork.this.preDns(str3);
                            } else if (i16 == 2) {
                                PreHotNetwork.this.preSsl(str3);
                            }
                        }
                    });
                }
            }
        }
    }
}
