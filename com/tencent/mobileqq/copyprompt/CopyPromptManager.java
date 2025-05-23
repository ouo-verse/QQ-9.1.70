package com.tencent.mobileqq.copyprompt;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* loaded from: classes10.dex */
public class CopyPromptManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ClipboardManager f203015d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f203016e;

    /* renamed from: f, reason: collision with root package name */
    private a f203017f;

    /* renamed from: h, reason: collision with root package name */
    private long f203018h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences f203019i;

    /* loaded from: classes10.dex */
    public interface a {
        void onResult(String str);
    }

    public CopyPromptManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f203019i = null;
            this.f203016e = qQAppInterface;
        }
    }

    private ClipboardManager c() {
        if (this.f203015d == null) {
            this.f203015d = (ClipboardManager) this.f203016e.getApp().getApplicationContext().getSystemService("clipboard");
        }
        return this.f203015d;
    }

    private SharedPreferences d() {
        if (this.f203019i == null) {
            this.f203019i = PreferenceManager.getDefaultSharedPreferences(this.f203016e.getApp());
        }
        return this.f203019i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        long timestamp;
        ClipData primaryClip;
        CharSequence text;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f203018h < 1500) {
            return "";
        }
        this.f203018h = currentTimeMillis;
        long j3 = d().getLong("KEY_LAST_COPY_TIME", 0L);
        ClipDescription primaryClipDescription = ClipboardMonitor.getPrimaryClipDescription(c());
        if (primaryClipDescription != null) {
            timestamp = primaryClipDescription.getTimestamp();
            long currentTimeMillis2 = System.currentTimeMillis() - timestamp;
            if (timestamp != j3 && currentTimeMillis2 < 180000) {
                d().edit().putLong("KEY_LAST_COPY_TIME", timestamp).apply();
                if (ClipboardMonitor.hasPrimaryClip(c()) && (primaryClip = ClipboardMonitor.getPrimaryClip(c())) != null && primaryClip.getItemCount() > 0) {
                    ClipData.Item itemAt = primaryClip.getItemAt(0);
                    if (QLog.isColorLevel()) {
                        QLog.d("CopyPromptManager", 2, "origin copy data : " + itemAt);
                    }
                    if (itemAt != null && (text = itemAt.getText()) != null && !TextUtils.isEmpty(text)) {
                        return String.valueOf(text);
                    }
                }
            }
        }
        return "";
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return g();
        }
        return "";
    }

    public String f(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        if (Build.VERSION.SDK_INT > 27) {
            this.f203017f = aVar;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.copyprompt.CopyPromptManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CopyPromptManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            String g16 = CopyPromptManager.this.g();
                            if (CopyPromptManager.this.f203017f == null) {
                                return;
                            }
                            CopyPromptManager.this.f203017f.onResult(g16);
                            return;
                        } catch (Exception e16) {
                            QLog.d("CopyPromptManager", 1, "getPromptInSubThread error: ", e16);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 16, null, false);
            return "";
        }
        return "";
    }

    public void h(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f203017f = aVar;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f203019i = null;
        }
    }
}
