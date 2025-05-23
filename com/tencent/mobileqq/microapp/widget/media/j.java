package com.tencent.mobileqq.microapp.widget.media;

import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class j implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246233a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    @Override // com.tencent.mobileqq.microapp.widget.media.c
    public void a(File file) {
        ImageView imageView;
        ImageView imageView2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            imageView = this.f246233a.f246211w;
            if (imageView != null) {
                imageView2 = this.f246233a.f246211w;
                imageView2.setImageBitmap(com.tencent.mobileqq.microapp.a.c.q(file.getAbsolutePath()));
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) file);
    }
}
