package com.tencent.mobileqq.nearbypro.feeds.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001d\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0018\u0010\u001cB%\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u0018\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feeds/widget/StateTimeLineView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPointPaint", "e", "mLinePaint", "", "f", "Z", "showTop", "", h.F, UserInfo.SEX_FEMALE, "mTopHeight", "i", "mCircleRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class StateTimeLineView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPointPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mLinePaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showTop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mTopHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float mCircleRadius;

    public StateTimeLineView(@Nullable Context context) {
        super(context);
        Paint paint = new Paint();
        this.mPointPaint = paint;
        Paint paint2 = new Paint();
        this.mLinePaint = paint2;
        this.mCircleRadius = ViewUtils.dip2px(4.0f);
        paint.setColor(Color.parseColor("#D9D9D9"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(ViewUtils.dip2px(4.0f));
        paint2.setColor(Color.parseColor("#D9D9D9"));
        paint2.setStrokeWidth(ViewUtils.dip2px(1.0f));
        paint2.setPathEffect(new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f));
    }

    @Override // android.view.View
    public void draw(@Nullable Canvas canvas) {
        if (canvas != null) {
            if (this.showTop) {
                canvas.drawLine(getWidth() / 2, 0.0f, getWidth() / 2, this.mTopHeight, this.mLinePaint);
            }
            float width = getWidth() / 2;
            float f16 = this.mTopHeight;
            float f17 = this.mCircleRadius;
            canvas.drawCircle(width, f16 + f17, f17, this.mPointPaint);
            float width2 = getWidth() / 2;
            float f18 = this.mTopHeight;
            float f19 = this.mCircleRadius;
            canvas.drawLine(width2, f18 + f19 + f19, getWidth() / 2, getHeight(), this.mLinePaint);
        }
        super.draw(canvas);
    }

    public StateTimeLineView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mPointPaint = paint;
        Paint paint2 = new Paint();
        this.mLinePaint = paint2;
        this.mCircleRadius = ViewUtils.dip2px(4.0f);
        paint.setColor(Color.parseColor("#D9D9D9"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(ViewUtils.dip2px(4.0f));
        paint2.setColor(Color.parseColor("#D9D9D9"));
        paint2.setStrokeWidth(ViewUtils.dip2px(1.0f));
        paint2.setPathEffect(new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f));
    }

    public StateTimeLineView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        this.mPointPaint = paint;
        Paint paint2 = new Paint();
        this.mLinePaint = paint2;
        this.mCircleRadius = ViewUtils.dip2px(4.0f);
        paint.setColor(Color.parseColor("#D9D9D9"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(ViewUtils.dip2px(4.0f));
        paint2.setColor(Color.parseColor("#D9D9D9"));
        paint2.setStrokeWidth(ViewUtils.dip2px(1.0f));
        paint2.setPathEffect(new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f));
    }
}
