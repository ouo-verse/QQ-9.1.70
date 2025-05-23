package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.StartWrapperResult;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* loaded from: classes15.dex */
public class MsgBackupJniProxy {
    static IPatchRedirector $redirector_;

    public MsgBackupJniProxy(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                a(context, "c++_shared", SoLoadCore.PATH_LIB);
            } else {
                SoLoadUtil.m(context, "c++_shared", 0, false);
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                a(context, "xplatform", SoLoadCore.PATH_TX_LIB);
            } else {
                SoLoadUtil.m(context, "xplatform", 0, false);
            }
        } catch (UnsatisfiedLinkError e17) {
            e17.printStackTrace();
        }
        try {
            SoLoadUtilNew.loadSoByName(context, "msgbackup");
        } catch (UnsatisfiedLinkError e18) {
            QLog.e("MsgBackup-Proxy", 1, e18, new Object[0]);
        }
    }

    public static synchronized boolean a(Context context, String str, String str2) {
        Context context2;
        boolean z16;
        synchronized (MsgBackupJniProxy.class) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup-Proxy", 2, "start load native library. " + str);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            String str3 = "";
            String str4 = RFixConstants.SO_PATH + str + ".so";
            if (context == null) {
                context2 = BaseApplication.getContext();
            } else {
                context2 = context;
            }
            String str5 = context2.getFilesDir().getParent() + str2;
            QLog.i("MsgBackup-Proxy", 1, "try to load lib so");
            File file = new File(str5 + str4);
            String str6 = "key_so_crc" + str;
            boolean z17 = false;
            SharedPreferences sharedPreferences = context2.getSharedPreferences("so_sp", 0);
            if (SoLoadUtil.o(context2, str) && file.exists()) {
                file.delete();
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup-Proxy", 2, "start to decode so, decode with 7z : ");
            }
            if (!file.exists()) {
                int s16 = SoLoadUtil.s(context2, str5, "txlib", str4);
                QLog.i("MsgBackup-Proxy", 1, "uncompress so result: " + s16);
                if (s16 != 0) {
                    file.delete();
                    str3 = "copy asset so fail. file size not match";
                    QLog.e("MsgBackup-Proxy", 1, str3);
                } else {
                    sharedPreferences.edit().putLong(str6, IOUtil.getCRC32Value(file)).commit();
                }
            }
            String str7 = str3;
            QLog.i("MsgBackup-Proxy", 1, "load txlib so");
            if (file.exists()) {
                try {
                    System.load(file.getAbsolutePath());
                    z17 = true;
                } catch (UnsatisfiedLinkError e16) {
                    long cRC32Value = IOUtil.getCRC32Value(file);
                    long j3 = sharedPreferences.getLong(str6, -1L);
                    if (cRC32Value != -1 && cRC32Value != j3) {
                        file.delete();
                        str7 = str7 + "load asset so fail, crc not match." + cRC32Value + ":" + j3 + " path:" + file + ", exception info : " + QLog.getStackTraceString(e16);
                        QLog.e("MsgBackup-Proxy", 1, str7);
                    } else {
                        str7 = str7 + "load asset so fail. path:" + file + ", exception info : " + QLog.getStackTraceString(e16);
                        QLog.e("MsgBackup-Proxy", 1, str7);
                    }
                }
            }
            if (!z17) {
                QLog.i("MsgBackup-Proxy", 1, "finally try to use system way to load so");
                try {
                    System.loadLibrary(str);
                    z16 = true;
                } catch (UnsatisfiedLinkError e17) {
                    QLog.e("MsgBackup-Proxy", 1, str7 + "load system way failed, exception info : " + QLog.getStackTraceString(e17));
                }
                QLog.i("MsgBackup-Proxy", 1, "load so " + str + " cost time: " + (SystemClock.uptimeMillis() - uptimeMillis));
            }
            z16 = z17;
            QLog.i("MsgBackup-Proxy", 1, "load so " + str + " cost time: " + (SystemClock.uptimeMillis() - uptimeMillis));
        }
        return z16;
    }

    public static native byte[] decryptFromByteArray(byte[] bArr, String str);

    public static native String decryptFromString(String str, String str2);

    public static native byte[] encryptFromByteArray(byte[] bArr, String str);

    public static native String encryptFromString(String str, String str2);

    public void b(long j3, long j16, String str, String str2, boolean z16, long j17, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, Boolean.valueOf(z16), Long.valueOf(j17), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup-Proxy", 2, "received File url = " + str + ", fid = " + j16 + ", path = " + str2 + ", trivial = " + z16 + ", isResTask = " + z17);
        }
        if (z16 && z17) {
            com.tencent.mobileqq.msgbackup.util.d.b();
            MsgBackupManager.x().f251040d.add(Long.valueOf(j16));
            com.tencent.mobileqq.msgbackup.util.d.f251402a.f251385o++;
        }
        recvFile(j3, j16, str, str2, z16, j17, 0L);
    }

    public void c(long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Long.valueOf(j16), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup-Proxy", 2, "received from Buffer url = " + str + ", fid = " + j16);
        }
        recvToBuffer(j3, j16, str, 0L);
    }

    public native void cancelAllRecvTasks(long j3);

    public native void cancelAllSendTasks(long j3);

    public native int cancelRecvFile(long j3, long j16);

    public native int cancelSendFile(long j3, long j16, long j17);

    public native long createSession(int i3, long j3, int i16, MsgBackupNotifier msgBackupNotifier);

    public void d(long j3, long j16, long j17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup-Proxy", 2, "sendBuffer buffer = " + str + ", fid = " + j17 + ", sessionId = " + j16);
        }
        sendBuffer(j3, j16, j17, str, 0L);
    }

    public native void destroySession(long j3);

    public void e(long j3, long j16, long j17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup-Proxy", 2, "sendFile path = " + str + ", fid = " + j17 + ", sessionId = " + j16);
        }
        sendFile(j3, j16, j17, str, 0L);
    }

    public void f(long j3, int i3, String str, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Integer.valueOf(i3), str, Long.valueOf(j16));
        } else {
            sendMessage(j3, i3, str, j16, 0L);
        }
    }

    public void g(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), str);
        } else {
            setEncryptKey(j3, str, f.f251422b);
        }
    }

    public native byte[] getRecvBuffer(long j3, long j16);

    public native int getVersoEndpoint(long j3, MsgBackupEndPoint6 msgBackupEndPoint6);

    public native int queryReachability(long j3, MsgBackupNetState msgBackupNetState);

    public native void recvFile(long j3, long j16, String str, String str2, boolean z16, long j17, long j18);

    public native void recvToBuffer(long j3, long j16, String str, long j17);

    public native void refuseFileRequest(long j3, long j16, long j17, String str);

    public native void sendBuffer(long j3, long j16, long j17, String str, long j18);

    public native void sendFile(long j3, long j16, long j17, String str, long j18);

    public native void sendMessage(long j3, int i3, String str, long j16, long j17);

    public native void setEncryptKey(long j3, String str, boolean z16);

    public native void setPeerEndpoint(long j3, String[] strArr, int i3, int i16);

    public native int start(long j3, StartWrapperResult startWrapperResult);

    public native void stop(long j3);
}
