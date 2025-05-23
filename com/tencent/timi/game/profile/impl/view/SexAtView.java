package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import co4.b;
import co4.d;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SexAtView extends TextView implements b {

    /* renamed from: d, reason: collision with root package name */
    private d f378999d;

    /* renamed from: e, reason: collision with root package name */
    private CommonOuterClass$QQUserId f379000e;

    /* renamed from: f, reason: collision with root package name */
    private String f379001f;

    /* renamed from: h, reason: collision with root package name */
    private float f379002h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f379003i;

    public SexAtView(Context context) {
        super(context);
        this.f379001f = "@\u4ed6";
        this.f379002h = 0.9f;
        this.f379003i = false;
        i(null);
    }

    private String g(IUserInfo iUserInfo) {
        if (iUserInfo != null) {
            String m3 = iUserInfo.m(this.f379000e);
            if (m3 == "\u7537") {
                return "@\u4ed6";
            }
            if (m3 == "\u5973") {
                return "@\u5979";
            }
        }
        return this.f379001f;
    }

    private void i(AttributeSet attributeSet) {
        this.f378999d = ((bo4.d) mm4.b.b(bo4.d.class)).n2(this);
    }

    @Override // co4.b
    public void a() {
        setText(this.f379001f);
    }

    @Override // co4.b
    public void b() {
        setText(this.f379001f);
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
        setText(g(iUserInfo));
    }

    @Nullable
    public CommonOuterClass$QQUserId h() {
        return this.f378999d.d();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f378999d.e();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f378999d.f();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f379003i) {
            TextPaint paint = getPaint();
            paint.setStrokeWidth(this.f379002h);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    public void setEnableBold(boolean z16) {
        this.f379003i = z16;
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f379000e = commonOuterClass$QQUserId;
        this.f378999d.g(commonOuterClass$QQUserId);
    }

    public SexAtView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379001f = "@\u4ed6";
        this.f379002h = 0.9f;
        this.f379003i = false;
        i(attributeSet);
    }
}
