package com.tencent.mobileqq.microapp.appbrand.ui;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.net.URLDecoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppConfig f246017a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppBrandUI f246018b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppBrandUI appBrandUI, MiniAppConfig miniAppConfig) {
        this.f246018b = appBrandUI;
        this.f246017a = miniAppConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appBrandUI, (Object) miniAppConfig);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Bitmap a16 = com.tencent.mobileqq.microapp.a.c.a(URLDrawable.getDrawable(URLDecoder.decode(this.f246017a.config.icon_url), (URLDrawable.URLDrawableOptions) null));
            if (a16 != null) {
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.f246018b.getResources(), a16);
                create.setCornerRadius((int) (a16.getWidth() / 4.0f));
                create.setAntiAlias(true);
                this.f246018b.setTaskDescription(new ActivityManager.TaskDescription(this.f246017a.config.app_name, BaseImageUtil.drawableToBitmap(create)));
                if (!a16.isRecycled()) {
                    a16.recycle();
                }
            }
        } catch (Exception unused) {
        }
    }
}
