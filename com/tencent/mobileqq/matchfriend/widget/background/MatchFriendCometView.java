package com.tencent.mobileqq.matchfriend.widget.background;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendCometView extends FrameLayout {
    private boolean C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private final Runnable I;
    private final Runnable J;

    /* renamed from: d, reason: collision with root package name */
    private final Context f245678d;

    /* renamed from: e, reason: collision with root package name */
    private final ImageView f245679e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f245680f;

    /* renamed from: h, reason: collision with root package name */
    private final Random f245681h;

    /* renamed from: i, reason: collision with root package name */
    private ApngDrawable f245682i;

    /* renamed from: m, reason: collision with root package name */
    private ApngDrawable f245683m;

    public MatchFriendCometView(Context context) {
        this(context, null);
    }

    private ImageView h() {
        ImageView imageView = new ImageView(this.f245678d);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewUtils.dpToPx(375.0f), ViewUtils.dpToPx(90.0f)));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    private float i(float f16, float f17) {
        return f16 + (this.f245681h.nextFloat() * (f17 - f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j(int i3, int i16) {
        return i3 + this.f245681h.nextInt(i16 - i3);
    }

    private URLDrawable k(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.dpToPx(375.0f);
        obtain.mRequestHeight = ViewUtils.dpToPx(90.0f);
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mUseApngImage = true;
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 1);
        obtain.mExtraInfo = bundle;
        obtain.mPlayGifImage = true;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setURLDrawableListener(new a(str));
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(URLDrawable uRLDrawable, String str) {
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable instanceof ApngDrawable) {
            if ("https://downv6.qq.com/extendfriend/comet_new.png".equals(str)) {
                QLog.d("MatchFriendCometView", 1, "initCometDrawable success");
                ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
                apngDrawable.getImage().setSupportGlobalPasued(false);
                this.f245682i = apngDrawable;
                r();
                return;
            }
            if ("https://downv6.qq.com/extendfriend/shadow_comet_new.png".equals(str)) {
                QLog.d("MatchFriendCometView", 1, "initShadowCometDrawable success");
                ApngDrawable apngDrawable2 = (ApngDrawable) currDrawable;
                apngDrawable2.getImage().setSupportGlobalPasued(false);
                this.f245683m = apngDrawable2;
                this.f245680f.setVisibility(8);
            }
        }
    }

    private void n(Runnable runnable) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Runnable runnable, long j3) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        float i3;
        if (this.f245682i == null) {
            return;
        }
        this.D = this.f245681h.nextFloat() * 600.0f;
        this.F = i(1.0f, 1.8f) * 375.0f;
        if (this.f245681h.nextBoolean()) {
            i3 = i(-10.0f, -70.0f);
        } else {
            i3 = i(-110.0f, -170.0f);
        }
        this.H = i3;
        s(this.f245679e, this.F, this.D, i3);
        this.f245682i.repaly();
        long j3 = j(2000, 4000);
        n(this.I);
        o(this.I, j3 + 2200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f245683m == null) {
            return;
        }
        this.E = this.D - i(30.0f, 60.0f);
        float i3 = i(1.0f, 1.8f) * 375.0f;
        this.G = i3;
        s(this.f245680f, i3, this.E, this.H);
        this.f245683m.repaly();
        n(this.J);
    }

    private void s(ImageView imageView, float f16, float f17, float f18) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = ViewUtils.dpToPx(f16);
        imageView.setLayoutParams(layoutParams);
        imageView.setTranslationY(ViewUtils.dpToPx(f17));
        imageView.setRotation(f18);
        imageView.setVisibility(0);
    }

    public MatchFriendCometView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void m() {
        this.C = true;
        this.f245679e.setVisibility(8);
        this.f245680f.setVisibility(8);
        n(this.I);
        n(this.J);
    }

    public void r() {
        this.C = false;
        p();
    }

    public MatchFriendCometView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.I = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.widget.background.MatchFriendCometView.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MatchFriendCometView", 1, "showCometRunnable");
                MatchFriendCometView.this.p();
                if (MatchFriendCometView.this.f245681h.nextFloat() < 0.2f) {
                    int j3 = MatchFriendCometView.this.j(400, 600);
                    MatchFriendCometView matchFriendCometView = MatchFriendCometView.this;
                    matchFriendCometView.o(matchFriendCometView.J, j3);
                }
            }
        };
        this.J = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.widget.background.MatchFriendCometView.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MatchFriendCometView", 1, "showShadowCometRunnable");
                MatchFriendCometView.this.q();
            }
        };
        this.f245678d = context;
        this.f245681h = new Random();
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout);
        ImageView h16 = h();
        this.f245679e = h16;
        ImageView h17 = h();
        this.f245680f = h17;
        frameLayout.addView(h16);
        frameLayout.addView(h17);
        URLDrawable k3 = k("https://downv6.qq.com/extendfriend/comet_new.png");
        h16.setImageDrawable(k3);
        if (k3.getCurrDrawable() instanceof ApngDrawable) {
            l(k3, "https://downv6.qq.com/extendfriend/comet_new.png");
        }
        URLDrawable k16 = k("https://downv6.qq.com/extendfriend/shadow_comet_new.png");
        h17.setImageDrawable(k16);
        if (k16.getCurrDrawable() instanceof ApngDrawable) {
            l(k16, "https://downv6.qq.com/extendfriend/shadow_comet_new.png");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f245684d;

        a(String str) {
            this.f245684d = str;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            MatchFriendCometView.this.l(uRLDrawable, this.f245684d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
