package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import co4.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiAvatarSpeakingMicImageViewImpl extends RelativeLayout implements co4.b {
    private ViewGroup.LayoutParams C;
    private boolean D;
    private String E;
    private ImageView F;
    private TextView G;
    private View.OnClickListener H;

    /* renamed from: d, reason: collision with root package name */
    private CommonOuterClass$QQUserId f380233d;

    /* renamed from: e, reason: collision with root package name */
    private d f380234e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f380235f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f380236h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f380237i;

    /* renamed from: m, reason: collision with root package name */
    private float f380238m;

    public TimiAvatarSpeakingMicImageViewImpl(Context context) {
        super(context);
        this.f380235f = false;
        this.f380236h = true;
        this.D = false;
        this.H = new a();
        i(context, null);
    }

    private void i(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f380234e = new com.tencent.timi.game.userinfo.impl.view.a(this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, mr2.a.X6)) != null) {
            this.f380235f = obtainStyledAttributes.getBoolean(mr2.a.Z6, false);
            obtainStyledAttributes.recycle();
        }
        if (this.f380235f) {
            setOnClickListener(this.H);
        }
    }

    private void j() {
        int i3 = (int) ((this.f380238m * 5.0f) / 8.0f);
        if (this.F == null) {
            ImageView imageView = new ImageView(getContext());
            this.F = imageView;
            addView(imageView);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.addRule(15, -1);
        this.F.setId(R.id.t1q);
        this.F.setLayoutParams(layoutParams);
        if (this.f380237i) {
            this.F.setImageResource(R.drawable.ovi);
        } else {
            this.F.setImageResource(R.drawable.ovh);
        }
        if (o()) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = ViewUtils.dip2px(3.0f);
            }
            this.F.setLayoutParams(layoutParams2);
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.addRule(14, -1);
        }
        this.F.setLayoutParams(layoutParams3);
    }

    private void k() {
        if (o()) {
            if (this.G == null) {
                TextView textView = new TextView(getContext());
                this.G = textView;
                addView(textView);
                this.G.setTextSize(0, (this.f380238m * 9.0f) / 16.0f);
                this.G.setTextColor(-1);
                this.G.setText(this.E);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(1, R.id.t1q);
                layoutParams.addRule(15, -1);
                layoutParams.rightMargin = ViewUtils.dip2px(5.0f);
                this.G.setLayoutParams(layoutParams);
            }
            this.G.setVisibility(0);
            return;
        }
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private void l(IUserInfo iUserInfo) {
        if (p(iUserInfo)) {
            setBackgroundResource(R.drawable.f162577lu0);
        } else if (q(iUserInfo)) {
            setBackgroundResource(R.drawable.f162579lu2);
        } else {
            setBackgroundResource(R.drawable.f162577lu0);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.C = layoutParams;
        if (layoutParams != null) {
            this.f380238m = layoutParams.height;
            if (o()) {
                ViewGroup.LayoutParams layoutParams2 = this.C;
                layoutParams2.width = -2;
                setLayoutParams(layoutParams2);
            } else {
                ViewGroup.LayoutParams layoutParams3 = this.C;
                layoutParams3.width = (int) this.f380238m;
                setLayoutParams(layoutParams3);
            }
        }
    }

    private boolean o() {
        if (this.D && !TextUtils.isEmpty(this.E)) {
            return true;
        }
        return false;
    }

    private boolean p(IUserInfo iUserInfo) {
        if (iUserInfo != null && "\u7537".equals(iUserInfo.m(this.f380233d))) {
            return true;
        }
        return false;
    }

    private boolean q(IUserInfo iUserInfo) {
        if (iUserInfo != null && "\u5973".equals(iUserInfo.m(this.f380233d))) {
            return true;
        }
        return false;
    }

    @Override // co4.b
    public void a() {
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        setVisibility(8);
    }

    @Override // co4.b
    public void b() {
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        setVisibility(8);
    }

    @Override // co4.b
    public boolean c() {
        if (h() == null) {
            return true;
        }
        return false;
    }

    @Override // co4.b
    public void d() {
        a();
    }

    @Override // co4.b
    public void e(IUserInfo iUserInfo) {
        if (this.f380234e.d() == null) {
            return;
        }
        l(iUserInfo);
        j();
        k();
        setVisibility(0);
    }

    public void g() {
        this.f380234e.g(null);
    }

    @Nullable
    public CommonOuterClass$QQUserId h() {
        return this.f380234e.d();
    }

    public void m(boolean z16) {
        n(z16, "\u4e3b\u6301");
    }

    public void n(boolean z16, String str) {
        this.D = z16;
        this.E = str;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f380234e.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f380234e.f();
    }

    public void setAutoVisible(boolean z16) {
        this.f380236h = z16;
    }

    public void setData(CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16) {
        this.f380233d = commonOuterClass$QQUserId;
        setData(commonOuterClass$QQUserId, z16, true);
    }

    public void setData(CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, boolean z17) {
        this.f380233d = commonOuterClass$QQUserId;
        this.f380237i = z16;
        this.f380234e.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarSpeakingMicImageViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f380235f = false;
        this.f380236h = true;
        this.D = false;
        this.H = new a();
        i(context, attributeSet);
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
