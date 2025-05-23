package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/widget/LoginFormItemRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "bgType", "setBGType", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "mPaint", "f", "I", "mBgType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", tl.h.F, "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class LoginFormItemRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect mRect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mBgType;

    /* renamed from: i, reason: collision with root package name */
    private static final int f315806i = ViewUtils.dip2px(0.5f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f315807m = ViewUtils.dip2px(72.0f);
    private static final int C = ViewUtils.dip2px(16.0f);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginFormItemRelativeLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i3 = this.mBgType;
        if (i3 == 1 || i3 == 2) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.mRect.set(f315807m, measuredHeight - f315806i, measuredWidth - C, measuredHeight);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }

    public final void setBGType(int bgType) {
        this.mBgType = bgType;
        if (bgType != 0) {
            if (bgType != 1) {
                if (bgType != 2) {
                    if (bgType == 3) {
                        setBackgroundResource(R.drawable.ks6);
                        return;
                    }
                    return;
                }
                setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_selector);
                return;
            }
            setBackgroundResource(R.drawable.ks8);
            return;
        }
        setBackgroundResource(R.drawable.ks7);
    }

    public /* synthetic */ LoginFormItemRelativeLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoginFormItemRelativeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRect = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(ContextCompat.getColor(context, R.color.qui_common_border_standard));
        setBackgroundResource(R.drawable.ks7);
    }
}
