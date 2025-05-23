package com.tencent.qq.minibox.ui.view.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010'J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002R\"\u0010\u0015\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001d\u00a8\u0006)"}, d2 = {"Lcom/tencent/qq/minibox/ui/view/indicator/BaseIndicator;", "Landroid/view/View;", "", "count", "currentPosition", "", "c", "position", "", "positionOffset", "positionOffsetPixels", "e", "f", "state", "d", "Lcom/tencent/qq/minibox/ui/view/indicator/a;", "Lcom/tencent/qq/minibox/ui/view/indicator/a;", "a", "()Lcom/tencent/qq/minibox/ui/view/indicator/a;", "setHelper", "(Lcom/tencent/qq/minibox/ui/view/indicator/a;)V", "helper", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "b", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "mPaint", UserInfo.SEX_FEMALE, "offset", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class BaseIndicator extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a helper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint mPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float offset;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: a, reason: from getter */
    public final a getHelper() {
        return this.helper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: b, reason: from getter */
    public final Paint getMPaint() {
        return this.mPaint;
    }

    public final void c(int count, int currentPosition) {
        QLog.i("BaseIndicator", 1, "onPageChanged count:" + count + ", currentPosition:" + currentPosition);
        this.helper.i(count);
        this.helper.h(currentPosition);
        requestLayout();
    }

    public final void e(int position, float positionOffset, int positionOffsetPixels) {
        QLog.i("BaseIndicator", 1, "onPageScrolled position:" + position + ", positionOffset:" + positionOffset);
        this.offset = positionOffset;
        invalidate();
    }

    public final void f(int position) {
        QLog.i("BaseIndicator", 1, "onPageSelected position:" + position);
        this.helper.h(position);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new a();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(0);
        this.mPaint.setColor(this.helper.getNormalColor());
    }

    public final void d(int state) {
    }
}
