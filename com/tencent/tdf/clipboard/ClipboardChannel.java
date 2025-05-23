package com.tencent.tdf.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ClipboardChannel {
    static IPatchRedirector $redirector_ = null;
    public static final int FORMAT_TEXT = 0;
    private static final String TAG = "ClipboardChannel";
    private Context mContext;

    public ClipboardChannel(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
        }
    }

    public String getClipboardData(int i3) {
        ClipData primaryClip;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        ClipboardManager clipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        if (clipboardManager == null || !ClipboardMonitor.hasPrimaryClip(clipboardManager) || (primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager)) == null || i3 != 0) {
            return "";
        }
        return primaryClip.getItemAt(0).coerceToText(this.mContext).toString();
    }

    public void setClipboardData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        ClipboardManager clipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        ClipData newPlainText = ClipData.newPlainText("text label?", str);
        if (clipboardManager == null) {
            return;
        }
        ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
    }
}
