package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import co4.d;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.widget.MediumBoldTextView;
import io4.n;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiAvatarTextViewImpl extends MediumBoldTextView implements co4.b {
    private CommonOuterClass$QQUserId C;
    private IUserInfo D;
    private String E;
    private String F;
    private int G;
    private View.OnClickListener H;

    /* renamed from: f, reason: collision with root package name */
    private d f380240f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f380241h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f380242i;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f380243m;

    public TimiAvatarTextViewImpl(Context context) {
        super(context);
        this.f380241h = false;
        this.f380242i = false;
        this.E = "";
        this.F = null;
        this.G = 0;
        this.H = new a();
        l(null);
    }

    private void l(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        setGravity(17);
        if (!isInEditMode()) {
            this.f380240f = new com.tencent.timi.game.userinfo.impl.view.a(this);
        }
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        this.f380351e = false;
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, mr2.a.X6)) != null) {
            this.f380241h = obtainStyledAttributes.getBoolean(mr2.a.Z6, false);
            this.f380242i = obtainStyledAttributes.getBoolean(mr2.a.Y6, false);
            this.f380243m = obtainStyledAttributes.getString(mr2.a.f417234a7);
            this.f380351e = obtainStyledAttributes.getBoolean(mr2.a.f417244b7, false);
            obtainStyledAttributes.recycle();
        }
        if (this.f380241h) {
            setOnClickListener(this.H);
        }
    }

    private boolean m() {
        return n.f408123a.i(this.C, this.G);
    }

    private void n() {
        String i3 = this.D.i(this.C);
        this.E = i3;
        if (TextUtils.isEmpty(i3)) {
            l.b("TimiAvatarTextViewImpl", "setShowName error name is null " + this.F);
        }
        setText(this.E);
    }

    private void o() {
        setText(n.f408123a.c(this.G));
    }

    @Override // co4.b
    public void a() {
        CharSequence charSequence;
        if (TextUtils.isEmpty(this.f380243m)) {
            charSequence = "";
        } else {
            charSequence = this.f380243m;
        }
        setText(charSequence);
    }

    @Override // co4.b
    public boolean c() {
        return TextUtils.isEmpty(getText());
    }

    @Override // co4.b
    public void d() {
        a();
    }

    @Override // co4.b
    public void e(IUserInfo iUserInfo) {
        if (k() == null) {
            return;
        }
        if (iUserInfo != null) {
            this.D = iUserInfo;
            if (this.f380242i) {
                setTextColor(io4.b.f408106a.e(iUserInfo.m(this.C)));
            }
            n();
            return;
        }
        a();
        this.D = null;
        if (this.f380242i) {
            setTextColor(io4.b.f408106a.e("\u672a\u77e5"));
        }
    }

    public String g() {
        IUserInfo iUserInfo = this.D;
        if (iUserInfo != null) {
            return iUserInfo.i(this.C);
        }
        return "";
    }

    public String h() {
        return this.E;
    }

    public void i() {
        this.f380240f.g(null);
        this.F = "";
    }

    public CommonOuterClass$QQUserId j() {
        return this.C;
    }

    @Nullable
    public CommonOuterClass$QQUserId k() {
        return this.f380240f.d();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f380240f;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f380240f;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void setClickJumpPersonalPage(boolean z16) {
        this.f380241h = z16;
        if (z16) {
            setOnClickListener(this.H);
        } else {
            setOnClickListener(null);
        }
    }

    public void setDefaultText(CharSequence charSequence) {
        this.f380243m = charSequence;
        if (k() == null) {
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
        this.F = l.j(n.f408123a.f(commonOuterClass$QQUserId));
        l.b("TimiAvatarTextViewImpl", "setUserId " + this.F + "," + this.C.user_from.get() + "," + i3);
        if (m()) {
            this.f380240f.f();
            this.f380240f.a();
            o();
            return;
        }
        this.f380240f.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarTextViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f380241h = false;
        this.f380242i = false;
        this.E = "";
        this.F = null;
        this.G = 0;
        this.H = new a();
        l(attributeSet);
    }

    @Override // co4.b
    public void b() {
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
