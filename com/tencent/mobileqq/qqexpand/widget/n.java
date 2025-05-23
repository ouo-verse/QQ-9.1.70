package com.tencent.mobileqq.qqexpand.widget;

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
/* loaded from: classes35.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    RelativeLayout f264210a;

    /* renamed from: c, reason: collision with root package name */
    ImageView f264212c;

    /* renamed from: d, reason: collision with root package name */
    ImageView f264213d;

    /* renamed from: h, reason: collision with root package name */
    int f264217h;

    /* renamed from: i, reason: collision with root package name */
    ImageView f264218i;

    /* renamed from: j, reason: collision with root package name */
    volatile boolean f264219j;

    /* renamed from: f, reason: collision with root package name */
    List<String> f264215f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    List<String> f264216g = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    Handler.Callback f264220k = new a();

    /* renamed from: e, reason: collision with root package name */
    Handler f264214e = new Handler(Looper.getMainLooper(), this.f264220k);

    /* renamed from: b, reason: collision with root package name */
    List<ImageView> f264211b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    ArrayList arrayList = (ArrayList) message.obj;
                    if (!n.this.f264219j) {
                        n.this.k(arrayList);
                    } else {
                        n.this.f264214e.sendMessageDelayed(Message.obtain(n.this.f264214e, 2, arrayList), 500L);
                    }
                }
            } else {
                if (n.this.f264215f.size() == 0) {
                    QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty!");
                    return false;
                }
                n.this.j();
                if (n.this.f264214e.hasMessages(1)) {
                    n.this.f264214e.removeMessages(1);
                }
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                List<String> list = n.this.f264215f;
                com.tencent.mobileqq.extendfriend.apollo.face.b.d(qQAppInterface, list.get(list.size() - 1));
                n.this.f264214e.sendEmptyMessageDelayed(1, 3000L);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f264224d;

        c(AnimatorSet animatorSet) {
            this.f264224d = animatorSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            for (int i3 = 0; i3 < n.this.f264211b.size(); i3++) {
                ImageView imageView = n.this.f264211b.get(i3);
                imageView.clearAnimation();
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (qQAppInterface != null && i3 < n.this.f264215f.size()) {
                    FaceDrawable d16 = com.tencent.mobileqq.extendfriend.apollo.face.b.d(qQAppInterface, n.this.f264215f.get(i3));
                    Drawable drawable = imageView.getDrawable();
                    if (drawable != null && drawable != d16 && (drawable instanceof FaceDrawable)) {
                        ((FaceDrawable) drawable).cancel();
                    }
                    imageView.setImageDrawable(d16);
                }
            }
            n.this.f264218i.clearAnimation();
            this.f264224d.cancel();
            n.this.f264213d.setTranslationX(0.0f);
            n.this.f264213d.setAlpha(1.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setAnimationListener(new a());
            n.this.f264218i.startAnimation(alphaAnimation);
        }

        /* compiled from: P */
        /* loaded from: classes35.dex */
        class a implements Animation.AnimationListener {
            a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                n.this.f264218i.setVisibility(8);
                n.this.f264219j = false;
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

    public n(int i3) {
        this.f264217h = 1;
        this.f264217h = i3;
        g(i3);
    }

    private boolean b(int i3) {
        if (i3 > 0 && i3 <= 4) {
            return true;
        }
        return false;
    }

    private boolean g(int i3) {
        if (!b(i3)) {
            return false;
        }
        BaseApplication context = BaseApplication.getContext();
        if (i3 == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(context, R.layout.f168799cb0, null);
            this.f264210a = relativeLayout;
            if (relativeLayout != null) {
                this.f264212c = (ImageView) relativeLayout.findViewById(R.id.d2q);
                this.f264213d = (ImageView) this.f264210a.findViewById(R.id.d2u);
            }
        } else if (i3 == 2) {
            RelativeLayout relativeLayout2 = (RelativeLayout) View.inflate(context, R.layout.f168806b02, null);
            this.f264210a = relativeLayout2;
            if (relativeLayout2 != null) {
                this.f264212c = (ImageView) relativeLayout2.findViewById(R.id.d2q);
                this.f264213d = (ImageView) this.f264210a.findViewById(R.id.d2r);
            }
        } else if (i3 == 3) {
            RelativeLayout relativeLayout3 = (RelativeLayout) View.inflate(context, R.layout.avs, null);
            this.f264210a = relativeLayout3;
            if (relativeLayout3 != null) {
                this.f264212c = (ImageView) relativeLayout3.findViewById(R.id.d2q);
                this.f264213d = (ImageView) this.f264210a.findViewById(R.id.d2r);
            }
        } else if (i3 == 4) {
            RelativeLayout relativeLayout4 = (RelativeLayout) View.inflate(context, R.layout.f168802gx0, null);
            this.f264210a = relativeLayout4;
            if (relativeLayout4 != null) {
                this.f264212c = (ImageView) relativeLayout4.findViewById(R.id.d2q);
                this.f264213d = (ImageView) this.f264210a.findViewById(R.id.d2v);
            }
        }
        ImageView imageView = this.f264213d;
        if (imageView != null) {
            imageView.setLayerType(1, null);
        }
        RelativeLayout relativeLayout5 = this.f264210a;
        if (relativeLayout5 != null && relativeLayout5.getChildCount() > 0) {
            for (int i16 = 0; i16 < this.f264210a.getChildCount(); i16++) {
                View childAt = this.f264210a.getChildAt(i16);
                if (childAt instanceof ImageView) {
                    ImageView imageView2 = (ImageView) childAt;
                    imageView2.setVisibility(8);
                    this.f264211b.add(imageView2);
                }
            }
            this.f264210a.setVisibility(8);
        }
        return true;
    }

    boolean c(List<String> list, List<String> list2) {
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

    public void d() {
        this.f264214e.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void e() {
        int i3;
        int dimensionPixelSize;
        int width = this.f264212c.getWidth();
        BaseApplication context = BaseApplication.getContext();
        int dimensionPixelSize2 = width - context.getResources().getDimensionPixelSize(R.dimen.b9s);
        int i16 = this.f264217h;
        if (i16 == 2) {
            dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.b9y);
            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.b9w);
        } else if (i16 == 3) {
            dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.b_1);
            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.b9z);
        } else {
            i3 = dimensionPixelSize2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f264213d, "translationX", 0.0f, dimensionPixelSize2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f264213d, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            long j3 = 300;
            ofFloat.setDuration(j3);
            ofFloat2.setDuration(j3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            c cVar = new c(animatorSet);
            ArrayList arrayList = new ArrayList();
            if (this.f264211b.size() > 1) {
                for (int i17 = 0; i17 < this.f264211b.size() - 1; i17++) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i3, 0.0f, 0.0f);
                    translateAnimation.setDuration(j3);
                    translateAnimation.setFillAfter(true);
                    arrayList.add(translateAnimation);
                }
                ((TranslateAnimation) arrayList.get(0)).setAnimationListener(cVar);
                for (int i18 = 0; i18 < this.f264211b.size() - 1; i18++) {
                    ImageView imageView = this.f264211b.get(i18);
                    imageView.clearAnimation();
                    imageView.startAnimation((Animation) arrayList.get(i18));
                }
            }
            animatorSet.start();
        }
        i3 = width - dimensionPixelSize;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f264213d, "translationX", 0.0f, dimensionPixelSize2);
        ObjectAnimator ofFloat22 = ObjectAnimator.ofFloat(this.f264213d, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        long j36 = 300;
        ofFloat3.setDuration(j36);
        ofFloat22.setDuration(j36);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ofFloat3, ofFloat22);
        c cVar2 = new c(animatorSet2);
        ArrayList arrayList2 = new ArrayList();
        if (this.f264211b.size() > 1) {
        }
        animatorSet2.start();
    }

    public View f() {
        return this.f264210a;
    }

    public void h() {
        d();
        this.f264220k = null;
    }

    public void i(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MatchViewHolder", 2, "setUinList uins = " + arrayList);
            }
            if (this.f264214e.hasMessages(2)) {
                this.f264214e.removeMessages(2);
            }
            this.f264214e.sendMessage(Message.obtain(this.f264214e, 2, arrayList));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MatchViewHolder", 2, "setUinList uins = 0");
        }
    }

    void j() {
        int f16;
        if (this.f264212c != null && this.f264213d != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (qQAppInterface == null) {
                return;
            }
            this.f264219j = true;
            ImageView imageView = this.f264218i;
            if (imageView != null) {
                imageView.clearAnimation();
                this.f264210a.removeView(this.f264218i);
            }
            BaseApplication context = BaseApplication.getContext();
            ImageView imageView2 = new ImageView(context);
            this.f264218i = imageView2;
            imageView2.setLayerType(1, null);
            int i3 = this.f264217h;
            if (i3 != 2 && i3 != 3) {
                f16 = BaseAIOUtils.f(1.0f, context.getResources());
            } else {
                f16 = BaseAIOUtils.f(2.0f, context.getResources());
            }
            this.f264218i.setPadding(f16, f16, f16, f16);
            this.f264218i.setBackgroundResource(R.drawable.cac);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f264212c.getWidth(), this.f264212c.getHeight());
            layoutParams.addRule(7, R.id.d2q);
            layoutParams.addRule(6, R.id.d2q);
            this.f264210a.addView(this.f264218i, layoutParams);
            if (this.f264215f.size() > 0) {
                try {
                    List<String> list = this.f264215f;
                    String remove = list.remove(list.size() - 1);
                    if (QLog.isColorLevel()) {
                        QLog.d("MatchViewHolder", 2, "startAnimation targetUin = " + remove);
                    }
                    this.f264215f.add(0, remove);
                    FaceDrawable d16 = com.tencent.mobileqq.extendfriend.apollo.face.b.d(qQAppInterface, remove);
                    d16.mutate();
                    this.f264218i.setImageDrawable(d16);
                } catch (Exception e16) {
                    QLog.d("MatchViewHolder", 1, "startAnimation Exception!", e16);
                    return;
                }
            }
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setAnimationListener(new b());
            this.f264218i.startAnimation(scaleAnimation);
            return;
        }
        QLog.d("MatchViewHolder", 2, "startAnimation headFirst headLast null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (c(this.f264216g, arrayList)) {
                if (QLog.isColorLevel()) {
                    QLog.d("MatchViewHolder", 2, "updateData return for same data");
                    return;
                }
                return;
            }
            if (this.f264214e.hasMessages(1)) {
                this.f264214e.removeMessages(1);
            }
            this.f264215f.clear();
            this.f264215f.addAll(arrayList);
            this.f264216g.clear();
            this.f264216g.addAll(arrayList);
            int size = this.f264215f.size();
            if (QLog.isColorLevel()) {
                QLog.d("MatchViewHolder", 2, "updateData _ infoListSize = " + size);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (size > 0) {
                this.f264210a.setVisibility(0);
                int size2 = this.f264211b.size();
                int i3 = 0;
                while (i3 < size2) {
                    ImageView imageView = this.f264211b.get(i3);
                    String str = i3 < size ? arrayList.get(i3) : null;
                    if (TextUtils.isEmpty(str)) {
                        imageView.setVisibility(8);
                    } else if (qQAppInterface != null) {
                        FaceDrawable d16 = com.tencent.mobileqq.extendfriend.apollo.face.b.d(qQAppInterface, str);
                        d16.mutate();
                        Drawable drawable = imageView.getDrawable();
                        if (drawable != null && drawable != d16 && (drawable instanceof FaceDrawable)) {
                            ((FaceDrawable) drawable).cancel();
                        }
                        imageView.setImageDrawable(d16);
                        imageView.setVisibility(0);
                    } else {
                        imageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable(true));
                        imageView.setVisibility(0);
                    }
                    i3++;
                }
                if (size > this.f264211b.size()) {
                    List<String> list = this.f264215f;
                    String str2 = list.get(list.size() - 1);
                    if (qQAppInterface != null) {
                        com.tencent.mobileqq.extendfriend.apollo.face.b.d(qQAppInterface, str2);
                    }
                    this.f264214e.sendEmptyMessageDelayed(1, 3000L);
                    return;
                }
                return;
            }
            this.f264210a.setVisibility(8);
            return;
        }
        QLog.e("MatchViewHolder", 2, "updateData _ uins is null ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setAnimationListener(new a());
            n.this.f264218i.startAnimation(scaleAnimation);
        }

        /* compiled from: P */
        /* loaded from: classes35.dex */
        class a implements Animation.AnimationListener {
            a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                n.this.e();
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
