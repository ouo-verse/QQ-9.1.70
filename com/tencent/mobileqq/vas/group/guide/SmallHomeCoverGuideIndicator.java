package com.tencent.mobileqq.vas.group.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/group/guide/SmallHomeCoverGuideIndicator;", "Landroid/view/View;", "", "value", "", "setSelectItemPosition", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "I", "curPosition", "e", WidgetCacheConstellationData.INTERVAL, "", "f", UserInfo.SEX_FEMALE, "radius", "Landroid/graphics/Paint;", h.F, "Landroid/graphics/Paint;", "mCirclePaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeCoverGuideIndicator extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int interval;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float radius;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Paint mCirclePaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallHomeCoverGuideIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interval = UIUtil.dp2px(BaseApplication.getContext(), 5.0f);
        this.radius = UIUtil.dp2px(BaseApplication.getContext(), 2.5f);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.mCirclePaint = paint;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            float f16 = this.radius;
            float f17 = f16 + (i3 * (this.interval + (2 * f16)));
            if (i3 == this.curPosition) {
                this.mCirclePaint.setColor(-16777216);
            } else {
                this.mCirclePaint.setColor(Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
            }
            canvas.drawCircle(f17, getHeight() / 2.0f, this.radius, this.mCirclePaint);
        }
    }

    public final void setSelectItemPosition(int value) {
        this.curPosition = value;
        invalidate();
    }
}
