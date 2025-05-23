package com.tencent.open.agent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.open.agent.util.t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseCardContainer extends RelativeLayout {
    protected LinearLayout C;
    protected ImageView D;
    protected URLImageView E;
    protected Handler F;
    protected URLDrawableDownListener.Adapter G;

    /* renamed from: d, reason: collision with root package name */
    protected Context f339595d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f339596e;

    /* renamed from: f, reason: collision with root package name */
    protected List<hp3.e> f339597f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f339598h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f339599i;

    /* renamed from: m, reason: collision with root package name */
    protected int f339600m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10001) {
                t.b("BaseCardContainer", "-->handleMessage MSG_UPDATE");
                BaseCardContainer.this.e();
                BaseCardContainer baseCardContainer = BaseCardContainer.this;
                baseCardContainer.E.setImageDrawable(baseCardContainer.f339598h);
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends URLDrawableDownListener.Adapter {
        b() {
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            super.onLoadCancelled(view, uRLDrawable);
            t.b("BaseCardContainer", "-->drawabel onLoadCancelled, view: " + view);
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            t.b("BaseCardContainer", "-->drawabel onLoadFailed, view: " + view);
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            super.onLoadInterrupted(view, uRLDrawable, interruptedException);
            t.b("BaseCardContainer", "-->drawabel onLoadInterrupted, view: " + view);
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            super.onLoadProgressed(view, uRLDrawable, i3);
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            t.b("BaseCardContainer", "-->drawabel onLoadSuccessed, view: " + view);
            BaseCardContainer.this.e();
            ((URLImageView) view).setImageDrawable(uRLDrawable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f339605d;

        c(ImageView imageView) {
            this.f339605d = imageView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f339605d.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f339605d.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f339607d;

        d(ImageView imageView) {
            this.f339607d = imageView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseCardContainer.this.setBackgroundColor(0);
            this.f339607d.getLayoutParams().width = -1;
            this.f339607d.requestLayout();
        }
    }

    public BaseCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f339599i = false;
        this.f339600m = -1;
        this.F = new a(Looper.getMainLooper());
        this.G = new b();
        this.f339595d = context;
        this.f339596e = getResources().getDisplayMetrics().widthPixels;
        this.f339597f = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URLDrawable f(String str) {
        final URLDrawable uRLDrawable;
        URLImageView uRLImageView;
        Drawable g16 = g();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = g16;
        obtain.mFailedDrawable = g16;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e16) {
            t.e("BaseCardContainer", "genGameUrlImg exception url=", str, ",excption=", e16.toString());
            uRLDrawable = null;
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() == 2) {
            t.b("BaseCardContainer", "-->-->genGameUrlImg: failed");
            uRLDrawable.restartDownload();
        }
        if ((uRLDrawable == null || uRLDrawable.getStatus() != 1) && (uRLImageView = this.E) != null) {
            uRLImageView.setURLDrawableDownListener(this.G);
            this.F.post(new Runnable() { // from class: com.tencent.open.agent.BaseCardContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    t.b("BaseCardContainer", "-->genGameUrlImg: set error img");
                    BaseCardContainer.this.E.setImageDrawable(uRLDrawable);
                }
            });
        }
        return uRLDrawable;
    }

    private Drawable g() {
        try {
            return com.tencent.open.agent.util.p.i(this.f339596e);
        } catch (OutOfMemoryError e16) {
            t.d("BaseCardContainer", "-->create empty drawable oom.", e16);
            return null;
        }
    }

    public int d(int i3) {
        if (!AppSetting.o(this.f339595d)) {
            return i3;
        }
        try {
            int i16 = getResources().getConfiguration().orientation;
            t.b("BaseCardContainer", "showOrHideAdImageView, orientation = " + i16 + "width = " + getHeight());
            if (i16 == 2) {
                i3 = getHeight() / 3;
                this.E.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                this.E.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        } catch (Exception e16) {
            t.e("BaseCardContainer", "showOrHideAdImageView error : " + e16);
        }
        return i3;
    }

    protected abstract void e();

    /* JADX INFO: Access modifiers changed from: protected */
    public String h(String str) {
        String sb5;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        if (length >= 8) {
            sb5 = str.substring(length - 8);
        } else {
            int i3 = 8 - length;
            StringBuilder sb6 = new StringBuilder();
            for (int i16 = 0; i16 < i3; i16++) {
                sb6.append("0");
            }
            sb6.append(str);
            sb5 = sb6.toString();
        }
        StringBuilder sb7 = new StringBuilder("https://open.gtimg.cn/open/app_icon");
        int i17 = 0;
        int i18 = 2;
        while (i17 < 8) {
            sb7.append("/");
            sb7.append(sb5.substring(i17, i18));
            i17 += 2;
            i18 += 2;
        }
        sb7.append("/");
        sb7.append(str);
        sb7.append("_");
        sb7.append("android");
        sb7.append("_");
        sb7.append("ad");
        sb7.append("_");
        sb7.append("0.jpg");
        sb7.replace(0, 5, ProtocolDownloaderConstants.PROTOCOL_GAMEAD);
        t.b("BaseCardContainer", "--> result: " + sb7.toString());
        return sb7.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ImageView imageView, int i3, int i16, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        t.e("BaseCardContainer", "performAnim height =" + i3 + ", topMargin =" + i16);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, i16);
        ofInt.addUpdateListener(new c(imageView));
        ofInt.addListener(new d(imageView));
        if (animatorUpdateListener != null) {
            ofInt2.addUpdateListener(animatorUpdateListener);
        }
        ofInt.setDuration(300L);
        ofInt2.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(URLImageView uRLImageView, String str) {
        URLDrawable uRLDrawable;
        if (uRLImageView == null) {
            uRLImageView = this.E;
        }
        Drawable g16 = g();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = g16;
        obtain.mFailedDrawable = g16;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e16) {
            t.e("BaseCardContainer", "setAdImageByURL exception url=", str, ",excption=", e16.toString());
            uRLDrawable = null;
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() == 2) {
            uRLDrawable.restartDownload();
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
            e();
            t.b("BaseCardContainer", "getStatus SUCCESSED: ");
            uRLImageView.setVisibility(0);
        } else {
            t.b("BaseCardContainer", "getStatus OTHERS: ");
            uRLImageView.setURLDrawableDownListener(this.G);
        }
        if (uRLDrawable != null) {
            uRLImageView.setImageDrawable(uRLDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.BaseCardContainer.6
            @Override // java.lang.Runnable
            public void run() {
                String h16 = BaseCardContainer.this.h(str);
                BaseCardContainer.this.f339598h = Drawable.createFromPath(com.tencent.open.agent.util.p.h(h16));
                if (BaseCardContainer.this.f339598h == null) {
                    URLDrawable f16 = BaseCardContainer.this.f(h16);
                    if (f16 != null && f16.getStatus() == 1) {
                        BaseCardContainer.this.f339598h = f16;
                        Message.obtain(BaseCardContainer.this.F, 10001).sendToTarget();
                        return;
                    }
                    return;
                }
                Message.obtain(BaseCardContainer.this.F, 10001).sendToTarget();
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.C = (LinearLayout) super.findViewById(R.id.jpy);
        this.D = (ImageView) super.findViewById(R.id.jpz);
        this.E = (URLImageView) super.findViewById(R.id.cr5);
    }
}
