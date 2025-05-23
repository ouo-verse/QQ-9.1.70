package com.tencent.icgame.game.userinfo.impl.view;

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
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import fy0.d;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimiAvatarSpeakingMicImageViewImpl extends RelativeLayout implements fy0.b {
    private ViewGroup.LayoutParams C;
    private boolean D;
    private String E;
    private ImageView F;
    private TextView G;
    private View.OnClickListener H;

    /* renamed from: d, reason: collision with root package name */
    private CommonOuterClass$QQUserId f116036d;

    /* renamed from: e, reason: collision with root package name */
    private d f116037e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f116038f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f116039h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f116040i;

    /* renamed from: m, reason: collision with root package name */
    private float f116041m;

    public TimiAvatarSpeakingMicImageViewImpl(Context context) {
        super(context);
        this.f116038f = false;
        this.f116039h = true;
        this.D = false;
        this.H = new a();
        h(context, null);
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f116037e = new com.tencent.icgame.game.userinfo.impl.view.a(this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d52.a.Y6)) != null) {
            this.f116038f = obtainStyledAttributes.getBoolean(d52.a.f392810a7, false);
            obtainStyledAttributes.recycle();
        }
        if (this.f116038f) {
            setOnClickListener(this.H);
        }
    }

    private void i() {
        int i3 = (int) ((this.f116041m * 5.0f) / 8.0f);
        if (this.F == null) {
            ImageView imageView = new ImageView(getContext());
            this.F = imageView;
            addView(imageView);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.addRule(15, -1);
        this.F.setId(R.id.t1q);
        this.F.setLayoutParams(layoutParams);
        if (this.f116040i) {
            this.F.setImageResource(R.drawable.ovi);
        } else {
            this.F.setImageResource(R.drawable.ovh);
        }
        if (l()) {
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

    private void j() {
        if (l()) {
            if (this.G == null) {
                TextView textView = new TextView(getContext());
                this.G = textView;
                addView(textView);
                this.G.setTextSize(0, (this.f116041m * 9.0f) / 16.0f);
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

    private void k(IUserInfo iUserInfo) {
        if (m(iUserInfo)) {
            setBackgroundResource(R.drawable.f162577lu0);
        } else if (n(iUserInfo)) {
            setBackgroundResource(R.drawable.f162579lu2);
        } else {
            setBackgroundResource(R.drawable.f162577lu0);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.C = layoutParams;
        if (layoutParams != null) {
            this.f116041m = layoutParams.height;
            if (l()) {
                ViewGroup.LayoutParams layoutParams2 = this.C;
                layoutParams2.width = -2;
                setLayoutParams(layoutParams2);
            } else {
                ViewGroup.LayoutParams layoutParams3 = this.C;
                layoutParams3.width = (int) this.f116041m;
                setLayoutParams(layoutParams3);
            }
        }
    }

    private boolean l() {
        if (this.D && !TextUtils.isEmpty(this.E)) {
            return true;
        }
        return false;
    }

    private boolean m(IUserInfo iUserInfo) {
        if (iUserInfo != null && "\u7537".equals(iUserInfo.f(this.f116036d))) {
            return true;
        }
        return false;
    }

    private boolean n(IUserInfo iUserInfo) {
        if (iUserInfo != null && "\u5973".equals(iUserInfo.f(this.f116036d))) {
            return true;
        }
        return false;
    }

    @Override // fy0.b
    public void a() {
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        setVisibility(8);
    }

    @Override // fy0.b
    public void b() {
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        setVisibility(8);
    }

    @Override // fy0.b
    public boolean c() {
        if (g() == null) {
            return true;
        }
        return false;
    }

    @Override // fy0.b
    public void d() {
        a();
    }

    @Override // fy0.b
    public void f(IUserInfo iUserInfo) {
        if (this.f116037e.d() == null) {
            return;
        }
        k(iUserInfo);
        i();
        j();
        setVisibility(0);
    }

    @Nullable
    public CommonOuterClass$QQUserId g() {
        return this.f116037e.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f116037e.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f116037e.f();
    }

    public void setAutoVisible(boolean z16) {
        this.f116039h = z16;
    }

    public void setData(CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16) {
        this.f116036d = commonOuterClass$QQUserId;
        setData(commonOuterClass$QQUserId, z16, true);
    }

    public void setData(CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, boolean z17) {
        this.f116036d = commonOuterClass$QQUserId;
        this.f116040i = z16;
        this.f116037e.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarSpeakingMicImageViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f116038f = false;
        this.f116039h = true;
        this.D = false;
        this.H = new a();
        h(context, attributeSet);
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
