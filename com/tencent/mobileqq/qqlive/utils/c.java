package com.tencent.mobileqq.qqlive.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends SimpleImageLoadingListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f273447a;

        a(View view) {
            this.f273447a = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, view, bitmap);
            } else {
                if (bitmap == null) {
                    return;
                }
                this.f273447a.setBackground(new BitmapDrawable(this.f273447a.getContext().getResources(), bitmap));
            }
        }
    }

    public static void a(ImageView imageView, String str) {
        ImageLoader.getInstance().displayImage(str, imageView, un3.a.f439281b);
    }

    public static void b(View view, com.tencent.mobileqq.qqlive.download.a aVar) {
        c(view, aVar.a(MobileQQ.sMobileQQ));
    }

    public static void c(View view, String str) {
        ImageLoader.getInstance().loadImage(str, un3.a.f439281b, new a(view));
    }
}
