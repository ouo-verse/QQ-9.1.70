package com.tencent.mobileqq.together.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    RelativeLayout f293414a;

    /* renamed from: b, reason: collision with root package name */
    List<ImageView> f293415b;

    /* renamed from: c, reason: collision with root package name */
    ImageView f293416c;

    /* renamed from: d, reason: collision with root package name */
    ImageView f293417d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f293418e;

    /* renamed from: f, reason: collision with root package name */
    Handler f293419f;

    /* renamed from: g, reason: collision with root package name */
    private int f293420g;

    /* renamed from: j, reason: collision with root package name */
    ImageView f293423j;

    /* renamed from: k, reason: collision with root package name */
    volatile boolean f293424k;

    /* renamed from: h, reason: collision with root package name */
    List<String> f293421h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    List<String> f293422i = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    Handler.Callback f293425l = new c();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    ArrayList arrayList = (ArrayList) message.obj;
                    if (!a.this.f293424k) {
                        a.this.k(arrayList);
                    } else {
                        a.this.f293419f.sendMessageDelayed(Message.obtain(a.this.f293419f, 2, arrayList), 500L);
                    }
                }
            } else {
                List<String> list = a.this.f293421h;
                if (list != null && list.size() != 0) {
                    a.this.i();
                    if (a.this.f293419f.hasMessages(1)) {
                        a.this.f293419f.removeMessages(1);
                    }
                    List<String> list2 = a.this.f293421h;
                    if (list2 != null && list2.size() > 3) {
                        String str = a.this.f293421h.get(3);
                        Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable(true);
                        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                        if (qQAppInterface != null) {
                            FaceDrawable.getFaceDrawable(qQAppInterface, 1, str, 4, defaultFaceDrawable, defaultFaceDrawable);
                        }
                    }
                    a.this.f293419f.sendEmptyMessageDelayed(1, 5000L);
                } else {
                    QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty or null!");
                    return false;
                }
            }
            return false;
        }
    }

    public a() {
        BaseApplication context = BaseApplication.getContext();
        this.f293419f = new Handler(Looper.getMainLooper(), this.f293425l);
        this.f293420g = BaseAIOUtils.f(4.0f, context.getResources());
        this.f293415b = new ArrayList();
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(context, R.layout.aek, null);
        this.f293414a = relativeLayout;
        this.f293416c = (ImageView) relativeLayout.findViewById(R.id.d2q);
        this.f293417d = (ImageView) this.f293414a.findViewById(R.id.d2r);
        this.f293418e = (ImageView) this.f293414a.findViewById(R.id.d2s);
        for (int i3 = 0; i3 < this.f293414a.getChildCount(); i3++) {
            ImageView imageView = (ImageView) this.f293414a.getChildAt(i3);
            imageView.setVisibility(8);
            this.f293415b.add(imageView);
        }
        this.f293414a.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<String> arrayList) {
        boolean z16;
        String str;
        if (arrayList != null && arrayList.size() != 0) {
            if (b(this.f293422i, arrayList)) {
                if (QLog.isColorLevel()) {
                    QLog.d("MatchViewHolder", 2, "updateData return for same data");
                    return;
                }
                return;
            }
            if (this.f293419f.hasMessages(1)) {
                this.f293419f.removeMessages(1);
            }
            this.f293421h.clear();
            this.f293421h.addAll(arrayList);
            this.f293422i.clear();
            this.f293422i.addAll(arrayList);
            int size = this.f293421h.size();
            if (QLog.isColorLevel()) {
                QLog.d("MatchViewHolder", 2, "updateData _ infoListSize = " + size);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (size > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f293414a.setVisibility(0);
                int size2 = this.f293415b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ImageView imageView = this.f293415b.get(i3);
                    if (i3 < size) {
                        str = arrayList.get(i3);
                    } else {
                        str = null;
                    }
                    String str2 = str;
                    if (!TextUtils.isEmpty(str2)) {
                        if (qQAppInterface != null) {
                            Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable(true);
                            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 1, str2, 4, defaultFaceDrawable, defaultFaceDrawable);
                            Drawable drawable = imageView.getDrawable();
                            if (drawable != null && drawable != faceDrawable && (drawable instanceof FaceDrawable)) {
                                ((FaceDrawable) drawable).cancel();
                            }
                            imageView.setImageDrawable(faceDrawable);
                            imageView.setVisibility(0);
                        } else {
                            imageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable(true));
                            imageView.setVisibility(0);
                        }
                    } else {
                        imageView.setVisibility(8);
                    }
                }
                if (size > 3) {
                    String str3 = this.f293421h.get(3);
                    if (qQAppInterface != null) {
                        Drawable defaultFaceDrawable2 = BaseImageUtil.getDefaultFaceDrawable(true);
                        FaceDrawable.getFaceDrawable(qQAppInterface, 1, str3, 4, defaultFaceDrawable2, defaultFaceDrawable2);
                    }
                    this.f293419f.sendEmptyMessageDelayed(1, 5000L);
                    return;
                }
                return;
            }
            this.f293414a.setVisibility(8);
            return;
        }
        QLog.e("MatchViewHolder", 2, "updateData _ uins is null ");
    }

    boolean b(List<String> list, List<String> list2) {
        int size = list.size();
        boolean z16 = false;
        if (size == list2.size()) {
            boolean z17 = true;
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    String str = list.get(i3);
                    String str2 = list2.get(i3);
                    if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                        z17 = false;
                    }
                }
            }
            z16 = z17;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MatchViewHolder", 2, "checkListEqual _ result = " + z16);
        }
        return z16;
    }

    public void c() {
        this.f293419f.removeCallbacksAndMessages(null);
    }

    void d() {
        float width = this.f293416c.getWidth() - BaseAIOUtils.f(5.0f, BaseApplication.getContext().getResources());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f293418e, "translationX", 0.0f, width);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f293418e, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        long j3 = 300;
        ofFloat.setDuration(j3);
        ofFloat2.setDuration(j3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        b bVar = new b(animatorSet);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, width, 0.0f, 0.0f);
            translateAnimation.setDuration(j3);
            translateAnimation.setFillAfter(true);
            arrayList.add(translateAnimation);
        }
        ((TranslateAnimation) arrayList.get(0)).setAnimationListener(bVar);
        for (int i16 = 0; i16 < 2; i16++) {
            ImageView imageView = this.f293415b.get(i16);
            imageView.clearAnimation();
            imageView.startAnimation((Animation) arrayList.get(i16));
        }
        animatorSet.start();
    }

    public View e() {
        return this.f293414a;
    }

    public void f() {
        c();
        this.f293419f = null;
        this.f293425l = null;
    }

    public void g() {
        Handler handler = this.f293419f;
        if (handler != null && !handler.hasMessages(1)) {
            this.f293419f.sendEmptyMessageDelayed(1, 5000L);
        }
    }

    public void h(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MatchViewHolder", 2, "setUinList uins = " + arrayList);
            }
            if (this.f293419f.hasMessages(2)) {
                this.f293419f.removeMessages(2);
            }
            this.f293419f.sendMessage(Message.obtain(this.f293419f, 2, arrayList));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MatchViewHolder", 2, "setUinList uins = 0");
        }
    }

    void i() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface == null) {
            return;
        }
        this.f293424k = true;
        ImageView imageView = this.f293423j;
        if (imageView != null) {
            imageView.clearAnimation();
            this.f293414a.removeView(this.f293423j);
        }
        BaseApplication context = BaseApplication.getContext();
        this.f293423j = new ImageView(context);
        int f16 = BaseAIOUtils.f(1.0f, context.getResources());
        this.f293423j.setPadding(f16, f16, f16, f16);
        this.f293423j.setBackgroundResource(R.drawable.acd);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f293416c.getWidth(), this.f293416c.getHeight());
        layoutParams.addRule(7, R.id.d2q);
        layoutParams.addRule(6, R.id.d2q);
        this.f293414a.addView(this.f293423j, layoutParams);
        try {
            List<String> list = this.f293421h;
            String remove = list.remove(list.size() - 1);
            if (QLog.isColorLevel()) {
                QLog.d("MatchViewHolder", 2, "startAnimation targetUin = " + remove);
            }
            this.f293421h.add(0, remove);
            Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable(true);
            this.f293423j.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 1, remove, 4, defaultFaceDrawable, defaultFaceDrawable));
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setAnimationListener(new AnimationAnimationListenerC8657a());
            this.f293423j.startAnimation(scaleAnimation);
        } catch (Exception e16) {
            QLog.d("MatchViewHolder", 1, "startAnimation Exception!", e16);
        }
    }

    public void j() {
        Handler handler = this.f293419f;
        if (handler != null && handler.hasMessages(1)) {
            this.f293419f.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.together.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class AnimationAnimationListenerC8657a implements Animation.AnimationListener {
        AnimationAnimationListenerC8657a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setAnimationListener(new AnimationAnimationListenerC8658a());
            a.this.f293423j.startAnimation(scaleAnimation);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.together.ui.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class AnimationAnimationListenerC8658a implements Animation.AnimationListener {
            AnimationAnimationListenerC8658a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.d();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f293428d;

        b(AnimatorSet animatorSet) {
            this.f293428d = animatorSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            for (int i3 = 0; i3 < 3; i3++) {
                ImageView imageView = a.this.f293415b.get(i3);
                imageView.clearAnimation();
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (qQAppInterface != null && i3 < a.this.f293421h.size()) {
                    String str = a.this.f293421h.get(i3);
                    Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable(true);
                    FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 1, str, 4, defaultFaceDrawable, defaultFaceDrawable);
                    Drawable drawable = imageView.getDrawable();
                    if (drawable != null && drawable != faceDrawable && (drawable instanceof FaceDrawable)) {
                        ((FaceDrawable) drawable).cancel();
                    }
                    imageView.setImageDrawable(faceDrawable);
                }
            }
            a.this.f293423j.clearAnimation();
            this.f293428d.cancel();
            a.this.f293418e.setTranslationX(0.0f);
            a.this.f293418e.setAlpha(1.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setAnimationListener(new AnimationAnimationListenerC8659a());
            a.this.f293423j.startAnimation(alphaAnimation);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.together.ui.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class AnimationAnimationListenerC8659a implements Animation.AnimationListener {
            AnimationAnimationListenerC8659a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.f293423j.setVisibility(8);
                a.this.f293424k = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
