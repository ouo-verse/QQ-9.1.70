package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0006B\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareNewFeedNavBar;", "Landroid/widget/FrameLayout;", "", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "a", "dispatchDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "path", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareNewFeedNavBar extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    private static float f219436h = ViewUtils.dpToPx(20.0f);

    /* renamed from: i, reason: collision with root package name */
    private static float f219437i = ViewUtils.dpToPx(20.0f);

    /* renamed from: m, reason: collision with root package name */
    private static float f219438m = ViewUtils.dpToPx(2.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareNewFeedNavBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0);
        paint.setShadowLayer(f219437i, 0.0f, f219438m, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_SUPERFAST_AVAIL_RAM);
        this.paint = paint;
        this.path = new Path();
        View.inflate(context, R.layout.er9, this);
        if (Build.VERSION.SDK_INT < 28 && getLayerType() != 1) {
            setLayerType(1, null);
        }
    }

    private final void a(Canvas canvas) {
        b();
        canvas.drawPath(this.path, this.paint);
    }

    private final void b() {
        this.path.reset();
        Path path = this.path;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f16 = f219436h;
        path.addRoundRect(rectF, new float[]{f16, f16, 0.0f, 0.0f, 0.0f, 0.0f, f16, f16}, Path.Direction.CW);
        this.path.close();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        a(canvas);
        super.dispatchDraw(canvas);
    }
}
