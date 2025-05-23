package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import com.tencent.mobileqq.matchfriend.reborn.widget.QQKLAvatarView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0000\u00a8\u0006\t"}, d2 = {"Landroid/content/Context;", "context", "", "borderSize", "", "avatarSize", NodeProps.BORDER_COLOR, "Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQKLAvatarView;", "a", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQKLAvatarViewExtKt {
    public static final QQKLAvatarView a(Context context, final float f16, int i3, final int i16) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(context, "context");
        QQKLAvatarView qQKLAvatarView = new QQKLAvatarView(context) { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.QQKLAvatarViewExtKt$createBorderQQKLAvatarView$1

            /* renamed from: i, reason: collision with root package name and from kotlin metadata */
            private final Lazy strokeBgPaint;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Paint>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.QQKLAvatarViewExtKt$createBorderQQKLAvatarView$1$strokeBgPaint$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Paint invoke() {
                        Paint paint = new Paint();
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setStrokeWidth(o.d(2.0f));
                        paint.setAntiAlias(true);
                        return paint;
                    }
                });
                this.strokeBgPaint = lazy;
                setWillNotDraw(false);
            }

            private final Paint h() {
                return (Paint) this.strokeBgPaint.getValue();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                Paint h16 = h();
                int i17 = i16;
                float f17 = f16;
                h16.setColor(i17);
                h16.setStrokeWidth(f17);
                canvas.drawCircle(getMeasuredWidth() >> 1, getMeasuredHeight() >> 1, (getMeasuredHeight() >> 1) - f17, h16);
                super.onDraw(canvas);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        };
        qQKLAvatarView.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
        roundToInt = MathKt__MathJVMKt.roundToInt(f16);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(f16);
        roundToInt3 = MathKt__MathJVMKt.roundToInt(f16);
        roundToInt4 = MathKt__MathJVMKt.roundToInt(f16);
        qQKLAvatarView.setPadding(roundToInt, roundToInt2, roundToInt3, roundToInt4);
        return qQKLAvatarView;
    }

    public static /* synthetic */ QQKLAvatarView b(Context context, float f16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            f16 = o.d(0.5f);
        }
        if ((i17 & 4) != 0) {
            i3 = o.e(20);
        }
        if ((i17 & 8) != 0) {
            i16 = -1;
        }
        return a(context, f16, i3, i16);
    }
}
