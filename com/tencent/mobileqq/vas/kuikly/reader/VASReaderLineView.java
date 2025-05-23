package com.tencent.mobileqq.vas.kuikly.reader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import i01.b;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002JX\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014JI\u0010'\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00032+\u0010&\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0018\u00010!j\u0004\u0018\u0001`%H\u0016R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010)R\u0016\u0010-\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010/R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010/R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010/\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/VASReaderLineView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "data", "", "c", "content", "", "textSize", "textSpacing", "", "textColor", "fontFamily", HippyTKDListViewAdapter.X, "y", "", "w", h.F, "fontWeight", "d", "", "value", "g", "propKey", "propValue", "", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "textPaint", "e", "Ljava/lang/String;", "textContent", "f", UserInfo.SEX_FEMALE, "textX", "textY", "i", "textWith", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "textHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VASReaderLineView extends FrameLayout implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint textPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String textContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float textX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float textY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float textWith;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float textHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VASReaderLineView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textPaint = new Paint();
        this.textContent = "";
    }

    private final void c(String data) {
        boolean z16;
        if (data.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                JSONObject jSONObject = new JSONObject(data);
                String optString = jSONObject.optString("textContent");
                Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"textContent\")");
                float g16 = g(jSONObject.opt("textSize"));
                float g17 = g(jSONObject.opt("textSpacing"));
                long optLong = jSONObject.optLong("textColor");
                String optString2 = jSONObject.optString("fontFamily");
                Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"fontFamily\")");
                d(optString, g16, g17, optLong, optString2, g(jSONObject.opt(HippyTKDListViewAdapter.X)), g(jSONObject.opt("y")), jSONObject.optInt("w"), jSONObject.optInt(h.F), jSONObject.optInt("fontWeight"));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    private final void d(String content, float textSize, float textSpacing, long textColor, String fontFamily, float x16, float y16, int w3, int h16, final int fontWeight) {
        this.textContent = content;
        Paint paint = new Paint();
        this.textPaint = paint;
        boolean z16 = true;
        paint.setAntiAlias(true);
        this.textPaint.setTextSize(ViewUtils.dpToPx(textSize));
        this.textPaint.setLetterSpacing(textSpacing);
        this.textPaint.setColor((int) textColor);
        if (fontFamily.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            a.f309900a.a(fontFamily, new Function1<Typeface, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.reader.VASReaderLineView$renderText$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Typeface typeface) {
                    invoke2(typeface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Typeface typeface) {
                    Paint paint2;
                    Paint paint3;
                    Typeface create;
                    Paint paint4;
                    int i3 = fontWeight;
                    if (i3 == FontWeight.BOLD.ordinal()) {
                        paint4 = this.textPaint;
                        paint4.setTypeface(Typeface.create(typeface, 1));
                        return;
                    }
                    if (i3 == FontWeight.THIN.ordinal()) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            paint3 = this.textPaint;
                            create = Typeface.create(typeface, 100, false);
                            paint3.setTypeface(create);
                            return;
                        }
                        return;
                    }
                    if (i3 == FontWeight.NORMAL.ordinal()) {
                        paint2 = this.textPaint;
                        paint2.setTypeface(typeface);
                    }
                }
            });
        }
        this.textWith = ViewUtils.dpToPx(w3);
        this.textHeight = ViewUtils.dpToPx(h16);
        this.textX = x16;
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float f16 = fontMetrics.bottom;
        this.textY = (this.textHeight / 2.0f) + (((f16 - fontMetrics.top) / 2) - f16);
        postInvalidate();
    }

    private final float g(Object value) {
        if (value instanceof Integer) {
            return ((Number) value).intValue();
        }
        if (value instanceof Double) {
            return (float) ((Number) value).doubleValue();
        }
        if (value instanceof String) {
            return Float.parseFloat((String) value);
        }
        if (value instanceof Float) {
            return ((Number) value).floatValue();
        }
        return 0.0f;
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "renderText")) {
            c((String) propValue);
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

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawText(this.textContent, this.textX, this.textY, this.textPaint);
        }
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.b(this, method, params, callback);
    }
}
