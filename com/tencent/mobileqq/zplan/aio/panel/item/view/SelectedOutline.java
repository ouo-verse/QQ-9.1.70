package com.tencent.mobileqq.zplan.aio.panel.item.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/view/SelectedOutline;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "d", UserInfo.SEX_FEMALE, "cornerRadius", "e", "thickness", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "outlinePaint", "Landroid/graphics/Path;", h.F, "Lkotlin/Lazy;", "c", "()Landroid/graphics/Path;", "outlinePath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SelectedOutline extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float cornerRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float thickness;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Paint outlinePaint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy outlinePath;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectedOutline(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Path c() {
        return (Path) this.outlinePath.getValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawPath(c(), this.outlinePaint);
        super.onDraw(canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectedOutline(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectedOutline(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SelectedOutline(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedOutline(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.cornerRadius = g.c(this, 10.0f);
        float c16 = g.c(this, 1.0f);
        this.thickness = c16;
        Paint paint = new Paint();
        paint.setColor(Color.rgb(0, 153, 255));
        paint.setStrokeWidth(c16);
        paint.setStyle(Paint.Style.STROKE);
        this.outlinePaint = paint;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Path>() { // from class: com.tencent.mobileqq.zplan.aio.panel.item.view.SelectedOutline$outlinePath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Path invoke() {
                float f16;
                float f17;
                float f18;
                float f19;
                float f26;
                float f27;
                Path path = new Path();
                SelectedOutline selectedOutline = SelectedOutline.this;
                f16 = selectedOutline.thickness;
                f17 = selectedOutline.thickness;
                float width = selectedOutline.getWidth();
                f18 = selectedOutline.thickness;
                float f28 = width - (f18 / 2.0f);
                float height = selectedOutline.getHeight();
                f19 = selectedOutline.thickness;
                float f29 = height - (f19 / 2.0f);
                f26 = selectedOutline.cornerRadius;
                f27 = selectedOutline.cornerRadius;
                path.addRoundRect(f16 / 2.0f, f17 / 2.0f, f28, f29, f26, f27, Path.Direction.CCW);
                return path;
            }
        });
        this.outlinePath = lazy;
    }
}
