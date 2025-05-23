package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import co4.d;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiAvatarSexImageViewImpl extends ImageView implements co4.b {

    /* renamed from: d, reason: collision with root package name */
    private d f380227d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f380228e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f380229f;

    /* renamed from: h, reason: collision with root package name */
    private CommonOuterClass$QQUserId f380230h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f380231i;

    public TimiAvatarSexImageViewImpl(Context context) {
        super(context);
        this.f380228e = false;
        this.f380229f = true;
        this.f380231i = new a();
        i(null);
    }

    private Drawable g(IUserInfo iUserInfo) {
        if (iUserInfo != null) {
            return io4.b.f408106a.d(this, iUserInfo.m(this.f380230h));
        }
        return null;
    }

    private void i(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f380227d = new com.tencent.timi.game.userinfo.impl.view.a(this);
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, mr2.a.V6)) != null) {
            this.f380228e = obtainStyledAttributes.getBoolean(mr2.a.W6, false);
            obtainStyledAttributes.recycle();
        }
        if (this.f380228e) {
            setOnClickListener(this.f380231i);
        }
    }

    @Override // co4.b
    public void a() {
        setImageDrawable(null);
        setVisibility(8);
    }

    @Override // co4.b
    public void b() {
        setImageDrawable(null);
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
        int i3 = 8;
        if (iUserInfo != null) {
            Drawable g16 = g(iUserInfo);
            if (this.f380229f) {
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
        return this.f380227d.d();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f380227d.e();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f380227d.f();
    }

    public void setAutoVisible(boolean z16) {
        this.f380229f = z16;
    }

    public void setClickJumpPersonalPage(boolean z16) {
        this.f380228e = z16;
        if (z16) {
            setOnClickListener(this.f380231i);
        } else {
            setOnClickListener(null);
        }
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f380230h = commonOuterClass$QQUserId;
        this.f380227d.g(commonOuterClass$QQUserId);
    }

    public TimiAvatarSexImageViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f380228e = false;
        this.f380229f = true;
        this.f380231i = new a();
        i(attributeSet);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
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
