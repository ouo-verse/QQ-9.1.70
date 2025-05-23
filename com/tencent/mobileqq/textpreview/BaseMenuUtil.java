package com.tencent.mobileqq.textpreview;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BaseMenuUtil {
    static IPatchRedirector $redirector_ = null;
    private static final long COPY_FREQUENT_THRESHOLD = 1050;
    private static long sLastCopyTimestamp;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sLastCopyTimestamp = 0L;
        }
    }

    public BaseMenuUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean checkCopyFrequent() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sLastCopyTimestamp < 1050) {
            QQToast.makeText(BaseApplication.getContext(), R.string.zou, 0).show();
            return false;
        }
        sLastCopyTimestamp = currentTimeMillis;
        return true;
    }

    public static void copy(String str, String str2) {
        copy(str, str2, true);
    }

    public static void copy(String str, String str2, boolean z16) {
        ClipboardManager clipboardManager;
        if (TextUtils.isEmpty(str) || !checkCopyFrequent() || (clipboardManager = (ClipboardManager) BaseApplication.getContext().getSystemService("clipboard")) == null) {
            return;
        }
        ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText(str2, str));
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.qqStr(R.string.o0i), 0).show();
        }
    }
}
