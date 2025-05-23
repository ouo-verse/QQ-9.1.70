package com.tencent.guild.aio.input.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\u0006\u0012\u0006\u0010'\u001a\u00020\u0018\u00a2\u0006\u0004\b(\u0010)B#\b\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010'\u001a\u00020\u0018\u00a2\u0006\u0004\b(\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0015J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/aio/input/widget/MutliSeletedBottomLine;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "d", UserInfo.SEX_FEMALE, "LIT_ALPHA", "e", "BIG_ALPHA", "f", "POINT_RADIUS", h.F, "POINT_MARGIN", "i", "mWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mHeight", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsBigStart", "D", "I", "mPointCount", "Landroid/graphics/Paint;", "E", "Landroid/graphics/Paint;", "mPaint", "Landroid/content/Context;", "context", "width", "height", "bigstart", "<init>", "(Landroid/content/Context;IIZ)V", "(Landroid/content/Context;IZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class MutliSeletedBottomLine extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsBigStart;

    /* renamed from: D, reason: from kotlin metadata */
    private final int mPointCount;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float LIT_ALPHA;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float BIG_ALPHA;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float POINT_RADIUS;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float POINT_MARGIN;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mHeight;

    public MutliSeletedBottomLine(@Nullable Context context, int i3, int i16, boolean z16) {
        super(context);
        this.LIT_ALPHA = 0.2f;
        this.BIG_ALPHA = 1.0f;
        this.POINT_RADIUS = 2.0f;
        this.POINT_MARGIN = 6.0f;
        this.mHeight = 29.0f;
        this.mPaint = new Paint();
        float f16 = i3;
        this.mWidth = f16;
        this.mHeight = i16;
        this.mIsBigStart = z16;
        this.mPointCount = (int) (f16 / (2.0f + 6.0f));
    }

    @Override // android.view.View
    @SuppressLint({"ResourceAsColor"})
    protected void onDraw(@NotNull Canvas canvas) {
        float f16;
        double d16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.mPaint.setColor(getResources().getColor(R.color.alu));
        this.mPaint.setAntiAlias(true);
        if (!this.mIsBigStart) {
            f16 = this.LIT_ALPHA;
        } else {
            f16 = this.BIG_ALPHA;
        }
        int i3 = this.mPointCount;
        for (int i16 = 0; i16 < i3; i16++) {
            double d17 = f16;
            if (!this.mIsBigStart) {
                d16 = d17 + ((i16 / this.mPointCount) * 0.8d);
            } else {
                d16 = d17 - ((i16 / this.mPointCount) * 0.8d);
            }
            this.mPaint.setAlpha((int) (255 * ((float) d16)));
            float f17 = this.POINT_MARGIN;
            float f18 = this.POINT_RADIUS;
            canvas.drawCircle((i16 * (f17 + f18)) + f18, this.mHeight / 2, f18, this.mPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) this.mWidth, getMeasuredHeight());
    }

    public MutliSeletedBottomLine(@Nullable Context context, int i3, boolean z16) {
        this(context, i3, x.c(context, 29.0f), z16);
    }
}
