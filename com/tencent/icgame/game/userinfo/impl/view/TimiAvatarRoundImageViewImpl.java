package com.tencent.icgame.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.icgame.game.ui.widget.TimiRoundImageView;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.view.widget.InnerExtraIconView;
import com.tencent.icgame.game.userinfo.impl.view.widget.InnerSexView;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.o;
import ly0.n;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimiAvatarRoundImageViewImpl extends FrameLayout implements fy0.b {
    private boolean C;
    private boolean D;
    private boolean E;
    private Drawable F;
    private Drawable G;
    private CommonOuterClass$QQUserId H;
    private TimiRoundImageView I;
    private InnerExtraIconView J;
    private InnerSexView K;
    private String L;
    private boolean M;
    private int N;

    /* renamed from: d, reason: collision with root package name */
    public View.OnClickListener f116019d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnClickListener f116020e;

    /* renamed from: f, reason: collision with root package name */
    fy0.d f116021f;

    /* renamed from: h, reason: collision with root package name */
    private int f116022h;

    /* renamed from: i, reason: collision with root package name */
    private int f116023i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f116024m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("jumpPersonalPage") && (onClickListener = TimiAvatarRoundImageViewImpl.this.f116019d) != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TimiAvatarRoundImageViewImpl.h(TimiAvatarRoundImageViewImpl.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f116028d;

        c(boolean z16) {
            this.f116028d = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TimiAvatarRoundImageViewImpl.h(TimiAvatarRoundImageViewImpl.this);
            if (this.f116028d) {
                TimiAvatarRoundImageViewImpl.this.f116020e.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface d {
    }

    public TimiAvatarRoundImageViewImpl(Context context) {
        super(context);
        this.f116020e = new a();
        this.f116023i = 128;
        this.f116024m = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.L = null;
        this.M = true;
        this.N = 0;
        q(context, null);
    }

    static /* bridge */ /* synthetic */ d h(TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl) {
        timiAvatarRoundImageViewImpl.getClass();
        return null;
    }

    private String j(IUserInfo iUserInfo) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.H;
        if (commonOuterClass$QQUserId != null) {
            return iUserInfo.g(commonOuterClass$QQUserId);
        }
        return "";
    }

    private void k() {
        if (this.E) {
            if (this.J == null) {
                InnerExtraIconView innerExtraIconView = new InnerExtraIconView(getContext());
                this.J = innerExtraIconView;
                addView(innerExtraIconView, new ViewGroup.LayoutParams(-1, -1));
            }
            this.J.setVisibility(0);
            this.J.setExtraIcon(this.F);
            return;
        }
        o();
    }

    private void l() {
        g.h("ICGameAvatarRoundImageViewImpl", "drawSex " + this.D + "," + this.G + "," + this.L);
        if (this.D) {
            if (this.K == null) {
                this.K = new InnerSexView(getContext());
                addView(this.K, new ViewGroup.LayoutParams(-1, -1));
            }
            this.K.setVisibility(0);
            this.K.setSexInco(this.G);
            return;
        }
        p();
    }

    private Drawable n(int i3) {
        return ly0.b.f415756a.f(i3, this);
    }

    private void o() {
        InnerExtraIconView innerExtraIconView = this.J;
        if (innerExtraIconView != null) {
            innerExtraIconView.setVisibility(8);
        }
    }

    private void p() {
        InnerSexView innerSexView = this.K;
        if (innerSexView != null) {
            innerSexView.setVisibility(8);
        }
    }

    private void q(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        setWillNotDraw(false);
        this.I = new TimiRoundImageView(context);
        addView(this.I, new ViewGroup.LayoutParams(-1, -1));
        this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f116022h = R.drawable.ovu;
        this.f116021f = new com.tencent.icgame.game.userinfo.impl.view.a(this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d52.a.T6)) != null) {
            this.f116024m = obtainStyledAttributes.getBoolean(d52.a.U6, false);
            this.C = obtainStyledAttributes.getBoolean(d52.a.V6, false);
            obtainStyledAttributes.recycle();
        }
        if (this.C) {
            setBackgroundDrawable(n(R.drawable.f162578lu1));
        }
        if (this.f116024m) {
            setOnClickListener(this.f116020e);
        } else {
            setOnClickListener(new b());
        }
    }

    private boolean r() {
        return n.f415773a.h(this.H, this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            g.d("ICGameAvatarRoundImageViewImpl", "setAvatarUrl error" + str + "," + this.L);
        } else {
            g.h("ICGameAvatarRoundImageViewImpl", "setAvatarUrl " + str + "," + this.L);
        }
        ly0.b.f415756a.g(str, this.I, this.f116023i);
    }

    private void t() {
        String b16 = n.f415773a.b(this.N);
        if (!TextUtils.isEmpty(b16)) {
            ly0.b.f415756a.g(b16, this.I, this.f116023i);
        } else {
            a();
        }
    }

    @Override // fy0.b
    public void a() {
        g.h("ICGameAvatarRoundImageViewImpl", "renderIfUidInvalid " + this.L);
        this.G = null;
        this.I.setImageResource(this.f116022h);
        p();
    }

    @Override // fy0.b
    public void b() {
        s("", true);
    }

    @Override // fy0.b
    public boolean c() {
        if (this.I.getDrawable() != null && this.I.getDrawable().getIntrinsicWidth() >= 0 && this.I.getDrawable().getIntrinsicHeight() >= 0) {
            return false;
        }
        return true;
    }

    @Override // fy0.b
    public void d() {
        a();
    }

    @Override // fy0.b
    public void f(IUserInfo iUserInfo) {
        if (m() == null) {
            return;
        }
        if (iUserInfo != null) {
            g.h("ICGameAvatarRoundImageViewImpl", "renderWithUserInfo " + this.L);
            this.G = ly0.b.f415756a.c(this, iUserInfo.f(this.H));
            String j3 = j(iUserInfo);
            if (!TextUtils.isEmpty(j3)) {
                s(j3, true);
            } else {
                a();
            }
            l();
            return;
        }
        a();
        g.h("ICGameAvatarRoundImageViewImpl", "renderWithUserInfo null " + this.L);
    }

    @Nullable
    public CommonOuterClass$QQUserId m() {
        return this.f116021f.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fy0.d dVar = this.f116021f;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fy0.d dVar = this.f116021f;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void setAvatarDrawable(Drawable drawable) {
        this.I.setImageDrawable(drawable);
    }

    public void setAvatarSize(int i3) {
        this.f116023i = i3;
    }

    public void setAvatarUrl(final String str) {
        this.G = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!TextUtils.isEmpty(str)) {
                s(str, false);
                return;
            } else {
                a();
                return;
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.icgame.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    TimiAvatarRoundImageViewImpl.this.s(str, false);
                } else {
                    TimiAvatarRoundImageViewImpl.this.a();
                }
            }
        });
    }

    public void setBottomLeftRadius(int i3) {
        TimiRoundImageView timiRoundImageView = this.I;
        if (timiRoundImageView != null) {
            timiRoundImageView.setBottomLeftRadius(i3);
        }
    }

    public void setBottomRightRadius(int i3) {
        TimiRoundImageView timiRoundImageView = this.I;
        if (timiRoundImageView != null) {
            timiRoundImageView.setBottomRightRadius(i3);
        }
    }

    public void setClickJumpPersonalPage(boolean z16) {
        this.f116024m = z16;
        setOnClickListener(new c(z16));
    }

    public void setDefaultImage(int i3) {
        this.f116022h = i3;
    }

    public void setExtraIcon(Drawable drawable) {
        this.F = drawable;
        k();
    }

    public void setNeedDefaultBg(boolean z16) {
        this.C = z16;
    }

    public void setNeedDrawExtraIcon(boolean z16) {
        this.E = z16;
        k();
    }

    public void setNeedDrawSex(boolean z16) {
        this.D = z16;
        l();
    }

    public void setNeedRound(boolean z16) {
        this.M = z16;
        TimiRoundImageView timiRoundImageView = this.I;
        if (timiRoundImageView != null) {
            timiRoundImageView.setNeedRound(z16);
        }
    }

    public void setSexIcon(String str) {
        if (str.equals("\u5973")) {
            this.G = n(R.drawable.ovs);
        } else if (str.equals("\u7537")) {
            this.G = n(R.drawable.ovt);
        } else {
            this.G = null;
        }
        l();
    }

    public void setTopLeftRadius(int i3) {
        TimiRoundImageView timiRoundImageView = this.I;
        if (timiRoundImageView != null) {
            timiRoundImageView.setTopLeftRadius(i3);
        }
    }

    public void setTopRightRadius(int i3) {
        TimiRoundImageView timiRoundImageView = this.I;
        if (timiRoundImageView != null) {
            timiRoundImageView.setTopRightRadius(i3);
        }
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        setUserId(commonOuterClass$QQUserId, 0);
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3) {
        this.H = commonOuterClass$QQUserId;
        this.N = i3;
        this.L = g.i(n.f415773a.e(commonOuterClass$QQUserId));
        g.a("ICGameAvatarRoundImageViewImpl", "setUserId " + this.L + "," + this.H.user_from.get() + "," + i3);
        if (r()) {
            this.f116021f.f();
            this.f116021f.a();
            p();
            t();
            return;
        }
        this.f116021f.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarRoundImageViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f116020e = new a();
        this.f116023i = 128;
        this.f116024m = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.L = null;
        this.M = true;
        this.N = 0;
        q(context, attributeSet);
    }

    public void setOnAvatarClickListener(d dVar) {
    }
}
