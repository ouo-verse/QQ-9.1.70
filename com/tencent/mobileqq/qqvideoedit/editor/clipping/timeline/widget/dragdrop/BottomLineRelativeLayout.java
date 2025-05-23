package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u0001\u0006B\u0013\b\u0016\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b-\u0010.B\u001d\b\u0016\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b-\u00101B%\b\u0016\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\u0007\u00a2\u0006\u0004\b-\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0015J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bJ\u0014\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u000f\u0010\u001a\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "b", "a", "", "c", "d", "onDraw", "", "drawBottomLine", "setDrawBottomLine", "needDrawTrackBackground", "setNeedDrawTrackBackground", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/y;", "trackModels", "setTrackList", "color", "setBottomLineColor", "setTrackColor", "", "radius", "setTrackRadius", "e", "()Z", "Ljava/util/ArrayList;", "Z", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "paint", tl.h.F, "i", "I", "bottomLineColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "trackColor", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "trackRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class BottomLineRelativeLayout extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float trackRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<y> trackModels;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needDrawTrackBackground;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean drawBottomLine;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int bottomLineColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int trackColor;

    public BottomLineRelativeLayout(@Nullable Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        paint.setStrokeWidth(eVar.a(2.0f));
        this.paint = paint;
        this.bottomLineColor = getResources().getColor(R.color.f157926co1);
        this.trackColor = getResources().getColor(R.color.bkc);
        this.trackRadius = eVar.a(2.0f);
    }

    private final void a(Canvas canvas) {
        if (this.drawBottomLine) {
            this.paint.setColor(getBottomLineColor());
            canvas.drawLine(0.0f, getHeight() - this.paint.getStrokeWidth(), getWidth(), getHeight(), this.paint);
        }
    }

    @RequiresApi(21)
    private final void b(Canvas canvas) {
        if (!this.needDrawTrackBackground) {
            return;
        }
        ArrayList<y> arrayList = this.trackModels;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackModels");
            arrayList = null;
        }
        for (y yVar : arrayList) {
            this.paint.setColor(getTrackColor());
            float bottom = yVar.getBottom();
            float f16 = this.trackRadius;
            canvas.drawRoundRect(yVar.getLeftMargin(), yVar.getTop(), getRight() - yVar.getRightMargin(), bottom, f16, f16, this.paint);
        }
    }

    /* renamed from: c, reason: from getter */
    private final int getBottomLineColor() {
        return this.bottomLineColor;
    }

    /* renamed from: d, reason: from getter */
    private final int getTrackColor() {
        return this.trackColor;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getDrawBottomLine() {
        return this.drawBottomLine;
    }

    @Override // android.view.View
    @RequiresApi(21)
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    public final void setBottomLineColor(int color) {
        this.bottomLineColor = color;
    }

    public final void setDrawBottomLine(boolean drawBottomLine) {
        this.drawBottomLine = drawBottomLine;
        invalidate();
    }

    public final void setNeedDrawTrackBackground(boolean needDrawTrackBackground) {
        this.needDrawTrackBackground = needDrawTrackBackground;
        invalidate();
    }

    public final void setTrackColor(int color) {
        this.trackColor = color;
    }

    public final void setTrackList(@NotNull ArrayList<y> trackModels) {
        Intrinsics.checkNotNullParameter(trackModels, "trackModels");
        this.trackModels = trackModels;
    }

    public final void setTrackRadius(float radius) {
        this.trackRadius = radius;
    }

    public BottomLineRelativeLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        paint.setStrokeWidth(eVar.a(2.0f));
        this.paint = paint;
        this.bottomLineColor = getResources().getColor(R.color.f157926co1);
        this.trackColor = getResources().getColor(R.color.bkc);
        this.trackRadius = eVar.a(2.0f);
    }

    public BottomLineRelativeLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        paint.setStrokeWidth(eVar.a(2.0f));
        this.paint = paint;
        this.bottomLineColor = getResources().getColor(R.color.f157926co1);
        this.trackColor = getResources().getColor(R.color.bkc);
        this.trackRadius = eVar.a(2.0f);
    }
}
