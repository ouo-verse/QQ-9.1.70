package com.tencent.icgame.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import fy0.d;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimiAvatarSexImageViewImpl extends ImageView implements fy0.b {

    /* renamed from: d, reason: collision with root package name */
    private d f116030d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f116031e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f116032f;

    /* renamed from: h, reason: collision with root package name */
    private CommonOuterClass$QQUserId f116033h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f116034i;

    public TimiAvatarSexImageViewImpl(Context context) {
        super(context);
        this.f116031e = false;
        this.f116032f = true;
        this.f116034i = new a();
        i(null);
    }

    private Drawable g(IUserInfo iUserInfo) {
        if (iUserInfo != null) {
            return ly0.b.f415756a.d(this, iUserInfo.f(this.f116033h));
        }
        return null;
    }

    private void i(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f116030d = new com.tencent.icgame.game.userinfo.impl.view.a(this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d52.a.W6)) != null) {
            this.f116031e = obtainStyledAttributes.getBoolean(d52.a.X6, false);
            obtainStyledAttributes.recycle();
        }
        if (this.f116031e) {
            setOnClickListener(this.f116034i);
        }
    }

    @Override // fy0.b
    public void a() {
        setImageDrawable(null);
        setVisibility(8);
    }

    @Override // fy0.b
    public void b() {
        setImageDrawable(null);
        setVisibility(8);
    }

    @Override // fy0.b
    public boolean c() {
        if (h() == null) {
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
        int i3 = 8;
        if (iUserInfo != null) {
            Drawable g16 = g(iUserInfo);
            if (this.f116032f) {
                if (g16 != null) {
                    i3 = 0;
                }
                setVisibility(i3);
            }
            setImageDrawable(g16);
            return;
        }
        setImageDrawable(null);
        setVisibility(8);
    }

    @Nullable
    public CommonOuterClass$QQUserId h() {
        return this.f116030d.d();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f116030d.e();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f116030d.f();
    }

    public void setAutoVisible(boolean z16) {
        this.f116032f = z16;
    }

    public void setClickJumpPersonalPage(boolean z16) {
        this.f116031e = z16;
        if (z16) {
            setOnClickListener(this.f116034i);
        } else {
            setOnClickListener(null);
        }
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f116033h = commonOuterClass$QQUserId;
        this.f116030d.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarSexImageViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f116031e = false;
        this.f116032f = true;
        this.f116034i = new a();
        i(attributeSet);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
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
