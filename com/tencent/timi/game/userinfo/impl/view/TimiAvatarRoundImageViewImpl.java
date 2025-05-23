package com.tencent.timi.game.userinfo.impl.view;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.view.widget.InnerExtraIconView;
import com.tencent.timi.game.userinfo.impl.view.widget.InnerSexView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import io4.n;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiAvatarRoundImageViewImpl extends FrameLayout implements co4.b {
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
    public View.OnClickListener f380216d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnClickListener f380217e;

    /* renamed from: f, reason: collision with root package name */
    co4.d f380218f;

    /* renamed from: h, reason: collision with root package name */
    private int f380219h;

    /* renamed from: i, reason: collision with root package name */
    private int f380220i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f380221m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("jumpPersonalPage") && (onClickListener = TimiAvatarRoundImageViewImpl.this.f380216d) != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
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
    /* loaded from: classes26.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f380225d;

        c(boolean z16) {
            this.f380225d = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TimiAvatarRoundImageViewImpl.h(TimiAvatarRoundImageViewImpl.this);
            if (this.f380225d) {
                TimiAvatarRoundImageViewImpl.this.f380217e.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface d {
    }

    public TimiAvatarRoundImageViewImpl(Context context) {
        super(context);
        this.f380217e = new a();
        this.f380220i = 128;
        this.f380221m = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.L = null;
        this.M = true;
        this.N = 0;
        r(context, null);
    }

    static /* bridge */ /* synthetic */ d h(TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl) {
        timiAvatarRoundImageViewImpl.getClass();
        return null;
    }

    private String j(IUserInfo iUserInfo) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.H;
        if (commonOuterClass$QQUserId != null) {
            return iUserInfo.f(commonOuterClass$QQUserId);
        }
        return "";
    }

    private void l() {
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
        p();
    }

    private void m() {
        l.i("TimiAvatarRoundImageViewImpl", "drawSex " + this.D + "," + this.G + "," + this.L);
        if (this.D) {
            if (this.K == null) {
                this.K = new InnerSexView(getContext());
                addView(this.K, new ViewGroup.LayoutParams(-1, -1));
            }
            this.K.setVisibility(0);
            this.K.setSexInco(this.G);
            return;
        }
        q();
    }

    private Drawable o(int i3) {
        return io4.b.f408106a.f(i3, this);
    }

    private void p() {
        InnerExtraIconView innerExtraIconView = this.J;
        if (innerExtraIconView != null) {
            innerExtraIconView.setVisibility(8);
        }
    }

    private void q() {
        InnerSexView innerSexView = this.K;
        if (innerSexView != null) {
            innerSexView.setVisibility(8);
        }
    }

    private void r(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        setWillNotDraw(false);
        this.I = new TimiRoundImageView(context);
        addView(this.I, new ViewGroup.LayoutParams(-1, -1));
        this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f380219h = R.drawable.ovu;
        this.f380218f = new com.tencent.timi.game.userinfo.impl.view.a(this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, mr2.a.S6)) != null) {
            this.f380221m = obtainStyledAttributes.getBoolean(mr2.a.T6, false);
            this.C = obtainStyledAttributes.getBoolean(mr2.a.U6, false);
            obtainStyledAttributes.recycle();
        }
        if (this.C) {
            setBackgroundDrawable(o(R.drawable.f162578lu1));
        }
        if (this.f380221m) {
            setOnClickListener(this.f380217e);
        } else {
            setOnClickListener(new b());
        }
    }

    private boolean s() {
        return n.f408123a.i(this.H, this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            l.e("TimiAvatarRoundImageViewImpl", "setAvatarUrl error" + str + "," + this.L);
        } else {
            l.i("TimiAvatarRoundImageViewImpl", "setAvatarUrl " + str + "," + this.L);
        }
        io4.b.f408106a.g(str, this.I, this.f380220i);
    }

    private void v() {
        String b16 = n.f408123a.b(this.N);
        if (!TextUtils.isEmpty(b16)) {
            io4.b.f408106a.g(b16, this.I, this.f380220i);
        } else {
            a();
        }
    }

    @Override // co4.b
    public void a() {
        l.i("TimiAvatarRoundImageViewImpl", "renderIfUidInvalid " + this.L);
        this.G = null;
        this.I.setImageResource(this.f380219h);
        q();
    }

    @Override // co4.b
    public void b() {
        u("", true);
    }

    @Override // co4.b
    public boolean c() {
        if (this.I.getDrawable() != null && this.I.getDrawable().getIntrinsicWidth() >= 0 && this.I.getDrawable().getIntrinsicHeight() >= 0) {
            return false;
        }
        return true;
    }

    @Override // co4.b
    public void d() {
        a();
    }

    @Override // co4.b
    public void e(IUserInfo iUserInfo) {
        if (n() == null) {
            return;
        }
        if (iUserInfo != null) {
            l.i("TimiAvatarRoundImageViewImpl", "renderWithUserInfo " + this.L);
            this.G = io4.b.f408106a.c(this, iUserInfo.m(this.H));
            String j3 = j(iUserInfo);
            if (!TextUtils.isEmpty(j3)) {
                u(j3, true);
            } else {
                a();
            }
            m();
            return;
        }
        a();
        l.i("TimiAvatarRoundImageViewImpl", "renderWithUserInfo null " + this.L);
    }

    public void k() {
        this.f380218f.g(null);
        l.i("TimiAvatarRoundImageViewImpl", "showDefaultImage " + this.L);
        q();
        this.L = "";
    }

    @Nullable
    public CommonOuterClass$QQUserId n() {
        return this.f380218f.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        co4.d dVar = this.f380218f;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        co4.d dVar = this.f380218f;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void setAvatarDrawable(Drawable drawable) {
        this.I.setImageDrawable(drawable);
    }

    public void setAvatarSize(int i3) {
        this.f380220i = i3;
    }

    public void setAvatarUrl(final String str) {
        this.G = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!TextUtils.isEmpty(str)) {
                u(str, false);
                return;
            } else {
                a();
                return;
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    TimiAvatarRoundImageViewImpl.this.u(str, false);
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
        this.f380221m = z16;
        setOnClickListener(new c(z16));
    }

    public void setDefaultImage(int i3) {
        this.f380219h = i3;
    }

    public void setExtraIcon(Drawable drawable) {
        this.F = drawable;
        l();
    }

    public void setNeedDefaultBg(boolean z16) {
        this.C = z16;
    }

    public void setNeedDrawExtraIcon(boolean z16) {
        this.E = z16;
        l();
    }

    public void setNeedDrawSex(boolean z16) {
        this.D = z16;
        m();
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
            this.G = o(R.drawable.ovs);
        } else if (str.equals("\u7537")) {
            this.G = o(R.drawable.ovt);
        } else {
            this.G = null;
        }
        m();
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

    public void t(View.OnClickListener onClickListener) {
        this.f380216d = onClickListener;
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3) {
        this.H = commonOuterClass$QQUserId;
        this.N = i3;
        this.L = l.j(n.f408123a.f(commonOuterClass$QQUserId));
        l.b("TimiAvatarRoundImageViewImpl", "setUserId " + this.L + "," + this.H.user_from.get() + "," + i3);
        if (s()) {
            this.f380218f.f();
            this.f380218f.a();
            q();
            v();
            return;
        }
        this.f380218f.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarRoundImageViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f380217e = new a();
        this.f380220i = 128;
        this.f380221m = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.L = null;
        this.M = true;
        this.N = 0;
        r(context, attributeSet);
    }

    public void setOnAvatarClickListener(d dVar) {
    }
}
