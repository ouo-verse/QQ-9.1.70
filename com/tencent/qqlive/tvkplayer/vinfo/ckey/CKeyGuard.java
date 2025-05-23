package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.LibLoadUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CKeyGuard {
    private static final String SONAME = "ckguard";
    private static String TAG = "ckeyguard";
    public static boolean bLoadSucc = false;
    private static boolean isInit = false;
    private static Context mContext = null;
    public static CKeyGuard mInstance = null;
    private static String mSoVersion = "";

    CKeyGuard() {
    }

    public static String genGuard(Context context) {
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(mContext, "ckguard");
        }
        try {
            return new String(sGuard(System.currentTimeMillis() / 1000, ""));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getJarVersion() {
        return CKeyFacade.mJarVersion;
    }

    public static String getSoVersion() {
        return mSoVersion;
    }

    public static String getVersion() {
        try {
            return sVersion();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void guardInit(final Context context) {
        mContext = context;
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(context, "ckguard");
        }
        mSoVersion = getVersion();
        try {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyGuard.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Context context2 = context;
                        if (context2 != null) {
                            CKeyGuard.sGuardInit(context2);
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        CKeyGuard.bLoadSucc = false;
                        VsLog.info(CKeyGuard.TAG, " guard init err");
                    }
                }
            });
            baseThread.setName("TVK_guardthread");
            baseThread.start();
        } catch (Throwable unused) {
            VsLog.error(TAG, "guard init catch");
        }
    }

    private static native byte[] sGuard(long j3, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void sGuardInit(Context context);

    private static native String sVersion();
}
