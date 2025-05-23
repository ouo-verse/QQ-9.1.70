package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#B\u001b\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b\"\u0010&B#\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010'\u001a\u00020\u0006\u00a2\u0006\u0004\b\"\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildRoundBubbleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "dp", "Landroid/content/res/Resources;", "res", "", "l", "", "init", "radius", "setRadiusDP", "", "rectRadius", "setRadii", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/graphics/RectF;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/RectF;", "mRectF", BdhLogUtil.LogTag.Tag_Conn, "[F", "mRadiusList", "Landroid/graphics/Path;", "D", "Landroid/graphics/Path;", "mPath", "E", "Landroid/content/res/Resources;", "mRes", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRoundBubbleImageView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private float[] mRadiusList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* renamed from: E, reason: from kotlin metadata */
    private Resources mRes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mRectF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoundBubbleImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        init();
    }

    private final int l(float dp5, Resources res) {
        return (int) ((res.getDisplayMetrics().density * dp5) + 0.5f);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        this.mRectF.left = getPaddingLeft();
        this.mRectF.top = getPaddingTop();
        this.mRectF.right = getPaddingLeft() + width;
        this.mRectF.bottom = getPaddingTop() + height;
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRectF, this.mRadiusList, Path.Direction.CCW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public final void init() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
        this.mRes = resources;
    }

    public final void setRadii(@NotNull float[] rectRadius) {
        Intrinsics.checkNotNullParameter(rectRadius, "rectRadius");
        this.mRadiusList = rectRadius;
    }

    public final void setRadiusDP(float radius) {
        Resources resources = this.mRes;
        if (resources == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRes");
            resources = null;
        }
        Arrays.fill(this.mRadiusList, l(radius, resources));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoundBubbleImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoundBubbleImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        init();
    }
}
