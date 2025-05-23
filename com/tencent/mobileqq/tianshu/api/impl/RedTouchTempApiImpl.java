package com.tencent.mobileqq.tianshu.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchTempApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.BaseActivity;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RedTouchTempApiImpl implements IRedTouchTempApi {
    static IPatchRedirector $redirector_ = null;
    public static final String LEBA_APNG_DIR = "leba/apng/";
    public static final String PATH_SPLIT = "/";
    private static final String TAG = "RedTouchTempApiImpl";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TextView C;
        final /* synthetic */ Animation D;
        final /* synthetic */ ImageView E;
        final /* synthetic */ TextView F;
        final /* synthetic */ TextView G;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Animation f293034d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f293035e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f293036f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f293037h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextView f293038i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f293039m;

        a(Animation animation, ImageView imageView, Context context, String str, TextView textView, boolean z16, TextView textView2, Animation animation2, ImageView imageView2, TextView textView3, TextView textView4) {
            this.f293034d = animation;
            this.f293035e = imageView;
            this.f293036f = context;
            this.f293037h = str;
            this.f293038i = textView;
            this.f293039m = z16;
            this.C = textView2;
            this.D = animation2;
            this.E = imageView2;
            this.F = textView3;
            this.G = textView4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, RedTouchTempApiImpl.this, animation, imageView, context, str, textView, Boolean.valueOf(z16), textView2, animation2, imageView2, textView3, textView4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            if (animation == this.f293034d) {
                this.f293035e.setVisibility(8);
                this.f293035e.setImageDrawable(RedTouchTempApiImpl.this.getApngDrawable(this.f293036f, this.f293037h));
                TextView textView = this.f293038i;
                if (textView != null && this.f293039m) {
                    textView.setVisibility(8);
                    this.C.setVisibility(8);
                    return;
                }
                return;
            }
            if (animation == this.D) {
                this.E.setVisibility(4);
                TextView textView2 = this.F;
                if (textView2 != null && this.f293039m) {
                    textView2.setVisibility(8);
                }
                TextView textView3 = this.G;
                if (textView3 != null && this.f293039m) {
                    textView3.setVisibility(8);
                }
                ApngImage.playByTag(39);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    public RedTouchTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTextAnim(TextView textView, TextView textView2, TextView textView3, AtomicBoolean atomicBoolean) {
        if (textView != null && textView2 != null) {
            Context context = textView2.getContext();
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f154674pv);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.f154675pw);
            if (atomicBoolean.get()) {
                Animation loadAnimation3 = AnimationUtils.loadAnimation(context, R.anim.f154674pv);
                textView2.setVisibility(0);
                textView3.setVisibility(0);
                textView.startAnimation(loadAnimation2);
                textView2.startAnimation(loadAnimation);
                textView3.startAnimation(loadAnimation3);
                return;
            }
            Animation loadAnimation4 = AnimationUtils.loadAnimation(context, R.anim.f154675pw);
            textView.setVisibility(0);
            textView.startAnimation(loadAnimation);
            textView2.startAnimation(loadAnimation2);
            textView3.startAnimation(loadAnimation4);
            return;
        }
        QLog.e(TAG, 1, "startTextAnim, but text view is null");
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchTempApi
    public URLDrawable getApngDrawable(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str);
        }
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.ckj);
        if (context == null) {
            QLog.e(TAG, 1, "apngUrl is empty");
            return URLDrawable.getDrawable("", drawable, drawable);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "apngUrl is empty");
            return URLDrawable.getDrawable("", drawable, drawable);
        }
        int[] iArr = {39};
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_use_cache", false);
        String[] split = str.split("/");
        String str2 = split[split.length - 1];
        File file = new File(context.getFilesDir() + LEBA_APNG_DIR, str2);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return VasApngUtil.getApngDrawable(file.getAbsolutePath(), str, drawable, iArr, str2, bundle);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchTempApi
    public Bitmap getDefaultFaceBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return BaseImageUtil.getDefaultFaceBitmap(true);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchTempApi
    public Drawable getFaceDrawable(Context context, String str) {
        QQAppInterface qQAppInterface;
        FaceDrawable faceDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        }
        if (context instanceof BaseActivity) {
            qQAppInterface = (QQAppInterface) ((BaseActivity) context).waitAppRuntime();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null || (faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 1, 4, str)) == null) {
            return null;
        }
        return faceDrawable;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchTempApi
    public void onProcessAddRedPoint(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.khb);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchTempApi
    public void removeLebaIconAnim(ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, imageView, imageView2, textView, textView2, textView3);
            return;
        }
        if (imageView2 != null && imageView != null && textView2 != null && textView != null) {
            Runnable runnable = (Runnable) imageView.getTag();
            if (runnable == null) {
                QLog.e(TAG, 1, "removeLebaIconAnim, but no anim is start");
                return;
            }
            ThreadManager.getUIHandler().removeCallbacks(runnable);
            imageView2.clearAnimation();
            imageView.clearAnimation();
            imageView.setTag(null);
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            textView.setVisibility(0);
            ApngImage.pauseByTag(39);
            return;
        }
        QLog.e(TAG, 1, "removeLebaIconAnim, but leba view is null");
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchTempApi
    public void startLebaIconAnim(ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, boolean z16, long j3, long j16, String str) {
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, imageView, imageView2, textView, textView2, textView3, textView4, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str);
            return;
        }
        if (imageView2 != null && imageView != null) {
            if (imageView.getTag() != null) {
                QLog.e(TAG, 1, "icon anim is started");
                return;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            Context context = imageView2.getContext();
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f154674pv);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.f154675pw);
            Animation loadAnimation3 = AnimationUtils.loadAnimation(context, R.anim.f154676px);
            Animation loadAnimation4 = AnimationUtils.loadAnimation(context, R.anim.f154677py);
            a aVar = new a(loadAnimation, imageView, context, str, textView2, z16, textView3, loadAnimation2, imageView2, textView4, textView);
            loadAnimation.setAnimationListener(aVar);
            loadAnimation2.setAnimationListener(aVar);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            if (atomicBoolean.get()) {
                j17 = j3;
            } else {
                j17 = j16;
            }
            Runnable runnable = new Runnable(atomicBoolean, imageView, imageView2, loadAnimation2, loadAnimation3, loadAnimation, loadAnimation4, z16, textView, textView2, textView3, j16, j3, uIHandler) { // from class: com.tencent.mobileqq.tianshu.api.impl.RedTouchTempApiImpl.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Animation C;
                final /* synthetic */ boolean D;
                final /* synthetic */ TextView E;
                final /* synthetic */ TextView F;
                final /* synthetic */ TextView G;
                final /* synthetic */ long H;
                final /* synthetic */ long I;
                final /* synthetic */ MqqHandler J;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AtomicBoolean f293028d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ImageView f293029e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ ImageView f293030f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Animation f293031h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ Animation f293032i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ Animation f293033m;

                {
                    this.f293028d = atomicBoolean;
                    this.f293029e = imageView;
                    this.f293030f = imageView2;
                    this.f293031h = loadAnimation2;
                    this.f293032i = loadAnimation3;
                    this.f293033m = loadAnimation;
                    this.C = loadAnimation4;
                    this.D = z16;
                    this.E = textView;
                    this.F = textView2;
                    this.G = textView3;
                    this.H = j16;
                    this.I = j3;
                    this.J = uIHandler;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RedTouchTempApiImpl.this, atomicBoolean, imageView, imageView2, loadAnimation2, loadAnimation3, loadAnimation, loadAnimation4, Boolean.valueOf(z16), textView, textView2, textView3, Long.valueOf(j16), Long.valueOf(j3), uIHandler);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    long j18;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f293028d.get()) {
                        this.f293029e.setVisibility(0);
                        this.f293030f.startAnimation(this.f293031h);
                        this.f293029e.startAnimation(this.f293032i);
                    } else {
                        ApngImage.pauseByTag(39);
                        this.f293030f.setVisibility(0);
                        this.f293030f.startAnimation(this.f293033m);
                        this.f293029e.startAnimation(this.C);
                    }
                    if (this.D) {
                        RedTouchTempApiImpl.this.startTextAnim(this.E, this.F, this.G, this.f293028d);
                    }
                    this.f293028d.set(!r0.get());
                    if (!this.f293028d.get()) {
                        j18 = this.H;
                    } else {
                        j18 = this.I;
                    }
                    this.J.postDelayed(this, j18);
                }
            };
            uIHandler.postDelayed(runnable, j17);
            imageView.setTag(runnable);
            return;
        }
        QLog.e(TAG, 1, "startLebaIconAnim but image view is null");
    }
}
