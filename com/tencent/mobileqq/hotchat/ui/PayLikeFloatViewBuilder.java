package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* loaded from: classes9.dex */
public class PayLikeFloatViewBuilder extends com.tencent.mobileqq.hotchat.ui.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f236913f;

    /* renamed from: e, reason: collision with root package name */
    private Drawable[] f236914e;

    /* loaded from: classes9.dex */
    public static class AnimationView extends TextView {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        protected com.tencent.mobileqq.hotchat.ui.a f236915d;

        /* renamed from: e, reason: collision with root package name */
        protected QQAppInterface f236916e;

        /* renamed from: f, reason: collision with root package name */
        protected AnimationDrawable f236917f;

        public AnimationView(Context context, QQAppInterface qQAppInterface, com.tencent.mobileqq.hotchat.ui.a aVar) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, aVar);
                return;
            }
            super.setGravity(17);
            this.f236916e = qQAppInterface;
            this.f236915d = aVar;
            if (super.getVisibility() == 0) {
                setVisibility(0);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            AnimationDrawable animationDrawable = this.f236917f;
            if (animationDrawable == null || animationDrawable.getNumberOfFrames() != 20) {
                this.f236917f = new AnimationDrawable();
                Drawable[] b16 = this.f236915d.b(this.f236916e);
                if (b16 == null) {
                    return;
                }
                for (int i3 = 0; i3 < 20; i3++) {
                    this.f236917f.addFrame(b16[i3], 50);
                }
                this.f236917f.setOneShot(false);
                super.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f236917f, (Drawable) null, (Drawable) null);
            }
            this.f236917f.start();
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            super.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            AnimationDrawable animationDrawable = this.f236917f;
            if (animationDrawable != null) {
                animationDrawable.stop();
                for (int i3 = 0; i3 < this.f236917f.getNumberOfFrames(); i3++) {
                    Drawable frame = this.f236917f.getFrame(i3);
                    if (frame != null) {
                        frame.setCallback(null);
                    }
                }
                this.f236917f.setCallback(null);
                this.f236917f = null;
            }
        }

        @Override // android.view.View
        public void setVisibility(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (super.getVisibility() != i3) {
                super.setVisibility(i3);
            }
            if (i3 == 0) {
                a();
            } else {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f236918a;

        a(String str) {
            this.f236918a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PayLikeFloatViewBuilder.f236913f = false;
                if (gVar.f313006d == 0) {
                    File file = new File(this.f236918a + ".tmp");
                    if (file.exists()) {
                        file.renameTo(new File(this.f236918a));
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72534);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f236913f = false;
        }
    }

    public PayLikeFloatViewBuilder(Context context, int i3, HeartAnimator heartAnimator) {
        super(context, i3, heartAnimator);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), heartAnimator);
        }
    }

    private static Bitmap e(Context context, QQAppInterface qQAppInterface) {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.nearby/nearby_pay_zan_anim.png";
        if (new File(str).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 320;
            options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
            try {
                return BaseImageUtil.decodeFileWithBufferedStream(str, options);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        if (f236913f) {
            return null;
        }
        f236913f = true;
        Bundle bundle = new Bundle();
        g gVar = new g("https://pub.idqqimg.com/pc/misc/nearby_pay_zan_anim.png", new File(str + ".tmp"));
        gVar.f313008f = 2;
        ((DownloaderFactory) qQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(gVar, new a(str), bundle);
        return null;
    }

    @Override // com.tencent.mobileqq.hotchat.ui.a
    public Drawable[] b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
        }
        if (this.f236914e == null) {
            Bitmap e16 = e(this.f236921c, qQAppInterface);
            if (e16 == null) {
                return null;
            }
            this.f236914e = new Drawable[20];
            int width = e16.getWidth();
            int height = e16.getHeight() / 20;
            for (int i3 = 0; i3 < 20; i3++) {
                this.f236914e[i3] = new BitmapDrawable(this.f236921c.getResources(), Bitmap.createBitmap(e16, 0, i3 * height, width, height));
            }
        }
        return this.f236914e;
    }

    @Override // com.tencent.mobileqq.hotchat.ui.a
    public Bitmap c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        super.c();
        if (this.f236919a == null) {
            try {
                this.f236919a = BitmapFactory.decodeResource(this.f236921c.getResources(), this.f236920b);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return this.f236919a;
    }
}
