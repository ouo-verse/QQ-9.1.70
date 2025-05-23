package com.tencent.mobileqq.qsec.qsecurity;

import android.content.Context;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.fe.c;
import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qsec.qsecdandelionsdk.Dandelion;
import com.tencent.mobileqq.qsec.qsecest.QsecEst;
import com.tencent.mobileqq.qsec.qsecprotocol.ByteData;
import com.tencent.mobileqq.qsec.qsecurity.utils.Logger;
import com.tencent.startrail.T;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QSec {
    static IPatchRedirector $redirector_ = null;
    private static final char[] HEX_ARRAY;
    private static final String LOG_TAG = "QSEC_SDK";
    private static final String TAG = "FEKit_QSec";
    private static final long TASK_DELAY = 5000;
    public static final int TASK_START = 1;
    public static final int TASK_STOP = 2;
    private static final String sVersion = "0.0.1";
    private static int xpskeyPt;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class QSecHolder {
        static IPatchRedirector $redirector_;
        private static final QSec sInstance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20341);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                sInstance = new QSec(null);
            }
        }

        QSecHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            xpskeyPt = 0;
            HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        }
    }

    /* synthetic */ QSec(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this, (Object) anonymousClass1);
    }

    public static String bytesToHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }

    private void closeXps() {
        int i3 = xpskeyPt;
        if (i3 != 0) {
            T.ac(i3);
            xpskeyPt = 0;
        }
    }

    private native int doReport(String str, String str2, String str3, String str4);

    private native int doSomething(Context context, int i3);

    public static QSec getInstance() {
        return QSecHolder.sInstance;
    }

    private native byte[] getXwDebugID(String str);

    private int initXps() {
        if (xpskeyPt == 0) {
            xpskeyPt = T.ab("qq.key");
        }
        return xpskeyPt;
    }

    public boolean detectMethod(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        try {
            for (Method method : Class.forName(str).getDeclaredMethods()) {
                if (method.getName().equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th5) {
            c.a(TAG, 1, "DM:" + th5);
        }
        return false;
    }

    public int execTasks(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, i3)).intValue();
        }
        return doSomething(context, i3);
    }

    public String getEstInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? QsecEst.a(QSecConfig.sContext, QSecConfig.business_guid, "") : (String) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    public byte[] getFeKitAttach(Context context, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, this, context, str, str2, str3);
        }
        byte[] bArr = null;
        try {
            if (!FEKit.getInstance().mInit) {
                e.b().i();
            }
            bArr = getXwDebugID(str);
            c.c(TAG, 1, "attach cmd:" + str2 + ",subcmd:" + str3 + " ,xw pb is:" + bytesToHex(bArr));
        } catch (Throwable th5) {
            c.a(TAG, 1, "exception:" + th5);
        }
        if (bArr == null) {
            return new byte[]{0};
        }
        return bArr;
    }

    public byte[] getLiteSign(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bArr);
        }
        return Dandelion.getInstance().fly(str, bArr);
    }

    public byte[] getSign(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bArr);
        }
        return ByteData.getInstance().getSign(QSecConfig.business_uin, str, bArr);
    }

    public byte[] getSignEntry(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) bArr);
        }
        if (QSecConfig.sign_strategy == 0) {
            return getLiteSign(str, bArr);
        }
        return getSign(str, bArr);
    }

    public synchronized byte[] getXpsInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        byte[] bArr = new byte[1];
        int i3 = xpskeyPt;
        if (i3 != 0) {
            bArr = T.ad(i3, 0);
        }
        return bArr;
    }

    public void init(Context context, String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2, str3, str4, str5);
            return;
        }
        Logger.initDebug(false);
        QSecConfig.setupBusinessInfo(context, str, str2, "", str3, str4, str5);
        Dandelion.getInstance().init();
        ByteData.getInstance().init(context);
    }

    public void initSign() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            Dandelion.getInstance().init();
            ByteData.getInstance().init(null);
        }
    }

    public int reportLog(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, str, str2, str3, str4)).intValue();
        }
        return doReport(str, str2, str3, str4);
    }

    public void updateO3DID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            QSecConfig.business_o3did = str;
        }
    }

    public void updateUserID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            QSecConfig.business_uin = str;
        }
    }

    QSec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String getEstInfo(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? QsecEst.a(context, str, "") : (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) str);
    }
}
