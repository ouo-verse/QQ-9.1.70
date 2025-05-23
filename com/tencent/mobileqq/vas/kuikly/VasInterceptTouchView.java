package com.tencent.mobileqq.vas.kuikly;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB\u000f\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R;\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasInterceptTouchView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "propKey", "", "propValue", "", "b", "", "w", tl.h.F, "oldw", "oldh", "", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "d", "Lkotlin/jvm/functions/Function1;", "onInterceptClickCallback", "e", "Z", "getShouldIntercept", "()Z", "setShouldIntercept", "(Z)V", "shouldIntercept", "Landroid/graphics/RectF;", "f", "Landroid/graphics/RectF;", "getInterceptClickRect", "()Landroid/graphics/RectF;", "setInterceptClickRect", "(Landroid/graphics/RectF;)V", "interceptClickRect", "I", "getViewWidth", "()I", "setViewWidth", "(I)V", "viewWidth", "i", "getViewHeight", "setViewHeight", "viewHeight", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "getDownX", "()F", "setDownX", "(F)V", "downX", BdhLogUtil.LogTag.Tag_Conn, "getDownY", "setDownY", "downY", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasInterceptTouchView extends FrameLayout implements i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    private float downY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onInterceptClickCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean shouldIntercept;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RectF interceptClickRect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int viewWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int viewHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float downX;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasInterceptTouchView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interceptClickRect = new RectF();
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "onInterceptClick")) {
            this.onInterceptClickCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        if (Intrinsics.areEqual(propKey, "interceptClickRect")) {
            JSONObject jSONObject = new JSONObject((String) propValue);
            this.interceptClickRect.set((float) jSONObject.optDouble("left", 0.0d), (float) jSONObject.optDouble("top", 0.0d), (float) jSONObject.optDouble("right", 0.0d), (float) jSONObject.optDouble("bottom", 0.0d));
            return true;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        float x16 = ev5.getX();
        float y16 = ev5.getY();
        QLog.e("VasInterceptTouchView", 1, "onInterceptTouchEvent action=" + ev5.getAction() + " x=" + x16 + " y=" + y16);
        if (ev5.getAction() == 0) {
            int i3 = this.viewWidth;
            RectF rectF = this.interceptClickRect;
            if (x16 > i3 * rectF.left && x16 < i3 * rectF.right) {
                int i16 = this.viewHeight;
                if (y16 > i16 * rectF.top && y16 < i16 * rectF.bottom) {
                    this.downX = x16;
                    this.downY = y16;
                    this.shouldIntercept = true;
                }
            }
            this.shouldIntercept = false;
            QLog.e("VasInterceptTouchView", 1, "x=" + x16 + " y=" + y16 + " not in viewWidth=" + i3 + " viewHeight=" + this.viewHeight + " interceptClickRect=" + rectF);
        }
        if (this.shouldIntercept) {
            if (ev5.getAction() == 1) {
                Function1<Object, Unit> function1 = this.onInterceptClickCallback;
                if (function1 != null) {
                    function1.invoke(null);
                }
                return true;
            }
            if (ev5.getAction() == 2 && (Math.abs(x16 - this.downX) > 32.0f || Math.abs(y16 - this.downY) > 32.0f)) {
                this.shouldIntercept = false;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        this.viewWidth = w3;
        this.viewHeight = h16;
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    public final void setDownX(float f16) {
        this.downX = f16;
    }

    public final void setDownY(float f16) {
        this.downY = f16;
    }

    public final void setInterceptClickRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.interceptClickRect = rectF;
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    public final void setShouldIntercept(boolean z16) {
        this.shouldIntercept = z16;
    }

    public final void setViewHeight(int i3) {
        this.viewHeight = i3;
    }

    public final void setViewWidth(int i3) {
        this.viewWidth = i3;
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }
}
