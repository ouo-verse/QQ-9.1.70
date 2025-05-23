package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
final class e implements PreloadManager.OnGetPathListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f245850a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f245851b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str) {
        this.f245851b = dVar;
        this.f245850a = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) str);
        }
    }

    public void onResult(int i3, PreloadManager.PathResult pathResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) pathResult);
            return;
        }
        if (i3 == 0 && com.tencent.mobileqq.microapp.a.c.a(new File(pathResult.filePath).getAbsolutePath(), this.f245850a)) {
            OnUpdateListener onUpdateListener = this.f245851b.f245848b;
            if (onUpdateListener != null) {
                onUpdateListener.onUpdateSucc(true);
                return;
            }
            return;
        }
        OnUpdateListener onUpdateListener2 = this.f245851b.f245848b;
        if (onUpdateListener2 != null) {
            onUpdateListener2.onUpdateSucc(false);
        }
    }
}
