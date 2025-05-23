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
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public class CardContainerHelper {

    /* renamed from: a, reason: collision with root package name */
    Context f339702a;

    /* renamed from: b, reason: collision with root package name */
    final int f339703b;

    /* renamed from: c, reason: collision with root package name */
    List<hp3.e> f339704c;

    /* renamed from: d, reason: collision with root package name */
    Drawable f339705d;

    /* renamed from: g, reason: collision with root package name */
    LinearLayout f339708g;

    /* renamed from: h, reason: collision with root package name */
    ImageView f339709h;

    /* renamed from: i, reason: collision with root package name */
    URLImageView f339710i;

    /* renamed from: l, reason: collision with root package name */
    private View f339713l;

    /* renamed from: e, reason: collision with root package name */
    boolean f339706e = false;

    /* renamed from: f, reason: collision with root package name */
    int f339707f = -1;

    /* renamed from: j, reason: collision with root package name */
    Handler f339711j = new a(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    protected URLDrawableDownListener.Adapter f339712k = new b();

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
                CardContainerHelper.this.c();
                CardContainerHelper cardContainerHelper = CardContainerHelper.this;
                cardContainerHelper.f339710i.setImageDrawable(cardContainerHelper.f339705d);
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
            CardContainerHelper.this.c();
            ((URLImageView) view).setImageDrawable(uRLDrawable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f339718d;

        c(ImageView imageView) {
            this.f339718d = imageView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f339718d.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f339718d.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f339720d;

        d(ImageView imageView) {
            this.f339720d = imageView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CardContainerHelper.this.f339713l.setBackgroundColor(0);
            this.f339720d.getLayoutParams().width = -1;
            this.f339720d.requestLayout();
        }
    }

    public CardContainerHelper(View view) {
        this.f339713l = view;
        Context context = view.getContext();
        this.f339702a = context;
        this.f339703b = context.getResources().getDisplayMetrics().widthPixels;
        this.f339704c = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URLDrawable d(String str) {
        final URLDrawable uRLDrawable;
        URLImageView uRLImageView;
        Drawable e16 = e();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = e16;
        obtain.mFailedDrawable = e16;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e17) {
            t.e("BaseCardContainer", "genGameUrlImg exception url=", str, ",excption=", e17.toString());
            uRLDrawable = null;
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() == 2) {
            t.b("BaseCardContainer", "-->-->genGameUrlImg: failed");
            uRLDrawable.restartDownload();
        }
        if ((uRLDrawable == null || uRLDrawable.getStatus() != 1) && (uRLImageView = this.f339710i) != null) {
            uRLImageView.setURLDrawableDownListener(this.f339712k);
            this.f339711j.post(new Runnable() { // from class: com.tencent.open.agent.CardContainerHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    t.b("BaseCardContainer", "-->genGameUrlImg: set error img");
                    CardContainerHelper.this.f339710i.setImageDrawable(uRLDrawable);
                }
            });
        }
        return uRLDrawable;
    }

    private Drawable e() {
        try {
            return com.tencent.open.agent.util.p.i(this.f339703b);
        } catch (OutOfMemoryError e16) {
            t.d("BaseCardContainer", "-->create empty drawable oom.", e16);
            return null;
        }
    }

    public String f(String str) {
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

    public void g() {
        this.f339708g = (LinearLayout) this.f339713l.findViewById(R.id.jpy);
        this.f339709h = (ImageView) this.f339713l.findViewById(R.id.jpz);
        this.f339710i = (URLImageView) this.f339713l.findViewById(R.id.cr5);
    }

    public void h(ImageView imageView, int i3, int i16, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
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

    public void i(URLImageView uRLImageView, String str) {
        URLDrawable uRLDrawable;
        if (uRLImageView == null) {
            uRLImageView = this.f339710i;
        }
        Drawable e16 = e();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = e16;
        obtain.mFailedDrawable = e16;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e17) {
            t.e("BaseCardContainer", "setAdImageByURL exception url=", str, ",excption=", e17.toString());
            uRLDrawable = null;
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() == 2) {
            uRLDrawable.restartDownload();
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
            c();
            t.b("BaseCardContainer", "getStatus SUCCESSED: ");
            uRLImageView.setVisibility(0);
        } else {
            t.b("BaseCardContainer", "getStatus OTHERS: ");
            uRLImageView.setURLDrawableDownListener(this.f339712k);
        }
        if (uRLDrawable != null) {
            uRLImageView.setImageDrawable(uRLDrawable);
        }
    }

    public void j(final String str) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.agent.CardContainerHelper.6
            @Override // java.lang.Runnable
            public void run() {
                String f16 = CardContainerHelper.this.f(str);
                CardContainerHelper.this.f339705d = Drawable.createFromPath(com.tencent.open.agent.util.p.h(f16));
                CardContainerHelper cardContainerHelper = CardContainerHelper.this;
                if (cardContainerHelper.f339705d == null) {
                    URLDrawable d16 = cardContainerHelper.d(f16);
                    if (d16 != null && d16.getStatus() == 1) {
                        CardContainerHelper cardContainerHelper2 = CardContainerHelper.this;
                        cardContainerHelper2.f339705d = d16;
                        Message.obtain(cardContainerHelper2.f339711j, 10001).sendToTarget();
                        return;
                    }
                    return;
                }
                Message.obtain(cardContainerHelper.f339711j, 10001).sendToTarget();
            }
        });
    }

    public void c() {
    }
}
