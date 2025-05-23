package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorInflater;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.mini.ui.RoundImageView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes35.dex */
public class MatchingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private RoundImageView f264161d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f264162e;

    /* renamed from: f, reason: collision with root package name */
    private View f264163f;

    /* renamed from: h, reason: collision with root package name */
    private LottieDrawable f264164h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f264165i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f264166m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.widget.MatchingView$2, reason: invalid class name */
    /* loaded from: classes35.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LottieComposition.Factory.fromInputStream(new BufferedInputStream(new FileInputStream(com.tencent.mobileqq.qqexpand.utils.c.b("expend_match_ellipisis.json"))), new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.qqexpand.widget.MatchingView.2.1
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(LottieComposition lottieComposition) {
                        if (lottieComposition == null) {
                            QLog.e("MatchingView", 1, "onCompositionLoaded lottieComposition is null");
                            return;
                        }
                        LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setComposition(lottieComposition);
                        lottieDrawable.loop(true);
                        MatchingView.this.f264164h = lottieDrawable;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.MatchingView.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MatchingView.this.f264163f != null) {
                                    MatchingView.this.f264163f.setBackgroundDrawable(MatchingView.this.f264164h);
                                }
                            }
                        });
                    }
                });
            } catch (Exception e16) {
                QLog.e("MatchingView", 1, "loadEllipsisAnimation fail.", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements DecodeTaskCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f264169d;

        a(String str) {
            this.f264169d = str;
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            if (TextUtils.equals(this.f264169d, str)) {
                MatchingView.this.f264161d.setImageDrawable(new BitmapDrawable(MatchingView.this.getResources(), bitmap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (MatchingView.this.f264166m) {
                MatchingView.this.f264165i.start();
            }
        }
    }

    public MatchingView(Context context) {
        this(context, null);
    }

    private void g(Context context) {
        LayoutInflater.from(context).inflate(R.layout.czw, (ViewGroup) this, true);
        this.f264161d = (RoundImageView) findViewById(R.id.p0b);
        this.f264162e = (TextView) findViewById(R.id.p0c);
        this.f264163f = findViewById(R.id.p0e);
        this.f264161d.setBorderColor(-1);
        this.f264161d.setBorderWidth(6);
        i();
        h();
    }

    private void h() {
        ThreadManagerV2.post(new AnonymousClass2(), 5, null, true);
    }

    private void i() {
        Drawable bitmapDrawable;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        iQQAvatarService.setDecodeTaskCompletionListener(new a(currentAccountUin));
        Bitmap bitmapFromCacheFrom = iQQAvatarService.getBitmapFromCacheFrom(1, currentAccountUin, 6);
        if (bitmapFromCacheFrom == null) {
            if (!iQQAvatarService.isPausing()) {
                iQQAvatarService.requestDecodeFace(currentAccountUin, 1, true);
            }
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(getResources(), bitmapFromCacheFrom);
        }
        if (bitmapDrawable == null) {
            bitmapDrawable = BaseImageUtil.getDefaultFaceDrawable();
        }
        this.f264161d.setImageDrawable(bitmapDrawable);
    }

    public void j(String str) {
        this.f264161d.setImageDrawable(null);
        this.f264162e.setText((CharSequence) null);
        i();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f264162e.setText(str);
    }

    public void k() {
        if (this.f264165i == null) {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.f155149a);
            this.f264165i = animatorSet;
            animatorSet.setTarget(this.f264161d);
            this.f264165i.setStartDelay(1000L);
            this.f264165i.addListener(new b());
        }
        LottieDrawable lottieDrawable = this.f264164h;
        if (lottieDrawable != null) {
            lottieDrawable.playAnimation();
        }
        this.f264165i.start();
        this.f264166m = true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
    }

    public MatchingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void l() {
        this.f264166m = false;
        AnimatorSet animatorSet = this.f264165i;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f264165i.end();
        }
        LottieDrawable lottieDrawable = this.f264164h;
        if (lottieDrawable != null) {
            lottieDrawable.endAnimation();
        }
    }

    public MatchingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264166m = false;
        g(context);
    }
}
