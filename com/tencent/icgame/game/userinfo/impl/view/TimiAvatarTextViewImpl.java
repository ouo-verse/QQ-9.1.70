package com.tencent.icgame.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.game.widget.MediumBoldTextView;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import fy0.d;
import ly0.n;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimiAvatarTextViewImpl extends MediumBoldTextView implements fy0.b {
    private CommonOuterClass$QQUserId C;
    private IUserInfo D;
    private String E;
    private String F;
    private int G;
    private View.OnClickListener H;

    /* renamed from: f, reason: collision with root package name */
    private d f116043f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f116044h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f116045i;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f116046m;

    public TimiAvatarTextViewImpl(Context context) {
        super(context);
        this.f116044h = false;
        this.f116045i = false;
        this.E = "";
        this.F = null;
        this.G = 0;
        this.H = new a();
        k(null);
    }

    private void k(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        setGravity(17);
        if (!isInEditMode()) {
            this.f116043f = new com.tencent.icgame.game.userinfo.impl.view.a(this);
        }
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        this.f116108e = false;
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d52.a.Y6)) != null) {
            this.f116044h = obtainStyledAttributes.getBoolean(d52.a.f392810a7, false);
            this.f116045i = obtainStyledAttributes.getBoolean(d52.a.Z6, false);
            this.f116046m = obtainStyledAttributes.getString(d52.a.f392820b7);
            this.f116108e = obtainStyledAttributes.getBoolean(d52.a.f392830c7, false);
            obtainStyledAttributes.recycle();
        }
        if (this.f116044h) {
            setOnClickListener(this.H);
        }
    }

    private boolean l() {
        return n.f415773a.h(this.C, this.G);
    }

    private void m() {
        String h16 = this.D.h(this.C);
        this.E = h16;
        if (TextUtils.isEmpty(h16)) {
            g.a("ICGameAvatarTextViewImpl", "setShowName error name is null " + this.F);
        }
        setText(this.E);
    }

    private void n() {
        setText(n.f415773a.c(this.G));
    }

    @Override // fy0.b
    public void a() {
        CharSequence charSequence;
        if (TextUtils.isEmpty(this.f116046m)) {
            charSequence = "";
        } else {
            charSequence = this.f116046m;
        }
        setText(charSequence);
    }

    @Override // fy0.b
    public boolean c() {
        return TextUtils.isEmpty(getText());
    }

    @Override // fy0.b
    public void d() {
        a();
    }

    @Override // fy0.b
    public void f(IUserInfo iUserInfo) {
        if (j() == null) {
            return;
        }
        if (iUserInfo != null) {
            this.D = iUserInfo;
            if (this.f116045i) {
                setTextColor(ly0.b.f415756a.e(iUserInfo.f(this.C)));
            }
            m();
            return;
        }
        a();
        this.D = null;
        if (this.f116045i) {
            setTextColor(ly0.b.f415756a.e("\u672a\u77e5"));
        }
    }

    public String g() {
        IUserInfo iUserInfo = this.D;
        if (iUserInfo != null) {
            return iUserInfo.h(this.C);
        }
        return "";
    }

    public void h() {
        this.f116043f.g(null);
        this.F = "";
    }

    public CommonOuterClass$QQUserId i() {
        return this.C;
    }

    @Nullable
    public CommonOuterClass$QQUserId j() {
        return this.f116043f.d();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f116043f;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f116043f;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void setClickJumpPersonalPage(boolean z16) {
        this.f116044h = z16;
        if (z16) {
            setOnClickListener(this.H);
        } else {
            setOnClickListener(null);
        }
    }

    public void setDefaultText(CharSequence charSequence) {
        this.f116046m = charSequence;
        if (j() == null) {
            a();
        }
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        setUserId(commonOuterClass$QQUserId, 0);
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3) {
        this.E = "";
        this.C = commonOuterClass$QQUserId;
        this.G = i3;
        this.F = g.i(n.f415773a.e(commonOuterClass$QQUserId));
        g.a("ICGameAvatarTextViewImpl", "setUserId " + this.F + "," + this.C.user_from.get() + "," + i3);
        if (l()) {
            this.f116043f.f();
            this.f116043f.a();
            n();
            return;
        }
        this.f116043f.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarTextViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f116044h = false;
        this.f116045i = false;
        this.E = "";
        this.F = null;
        this.G = 0;
        this.H = new a();
        k(attributeSet);
    }

    @Override // fy0.b
    public void b() {
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
