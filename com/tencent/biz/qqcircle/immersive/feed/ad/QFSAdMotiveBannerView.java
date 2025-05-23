package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b#\u0010$B\u001d\b\u0016\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b#\u0010'B%\b\u0016\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010(\u001a\u00020\u001b\u00a2\u0006\u0004\b#\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdMotiveBannerView;", "Landroid/view/View;", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "mPath", "", "f", "Z", "mIsRotation", tl.h.F, "mIsGradient", "", "i", UserInfo.SEX_FEMALE, "mGradientLength", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTriangleRadio", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mStartColor", "D", "mEndColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAdMotiveBannerView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private int mStartColor;

    /* renamed from: D, reason: from kotlin metadata */
    private int mEndColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Path mPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRotation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsGradient;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mGradientLength;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mTriangleRadio;

    public QFSAdMotiveBannerView(@Nullable Context context) {
        super(context);
        this.mTriangleRadio = 0.8f;
        a();
    }

    private final void a() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPath = new Path();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Paint paint;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mIsRotation) {
            Path path = this.mPath;
            if (path != null) {
                path.moveTo(0.0f, 0.0f);
            }
            Path path2 = this.mPath;
            if (path2 != null) {
                path2.lineTo(getWidth(), 0.0f);
            }
            Path path3 = this.mPath;
            if (path3 != null) {
                path3.lineTo(getWidth(), getHeight());
            }
            Path path4 = this.mPath;
            if (path4 != null) {
                path4.lineTo(getHeight() * this.mTriangleRadio, getHeight());
            }
        } else {
            Path path5 = this.mPath;
            if (path5 != null) {
                path5.moveTo(0.0f, getHeight());
            }
            Path path6 = this.mPath;
            if (path6 != null) {
                path6.lineTo(getWidth(), getHeight());
            }
            Path path7 = this.mPath;
            if (path7 != null) {
                path7.lineTo(getWidth() - (getHeight() * this.mTriangleRadio), 0.0f);
            }
            Path path8 = this.mPath;
            if (path8 != null) {
                path8.lineTo(0.0f, 0.0f);
            }
        }
        Path path9 = this.mPath;
        if (path9 != null) {
            path9.close();
        }
        Path path10 = this.mPath;
        if (path10 != null && (paint = this.mPaint) != null) {
            canvas.drawPath(path10, paint);
        }
    }

    public QFSAdMotiveBannerView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTriangleRadio = 0.8f;
        a();
        TypedArray obtainStyledAttributes = BaseApplication.context.getTheme().obtainStyledAttributes(attributeSet, y91.a.C3, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl\u2026rStyle,\n            0, 0)");
        try {
            this.mIsRotation = obtainStyledAttributes.getBoolean(y91.a.J3, false);
            this.mTriangleRadio = obtainStyledAttributes.getFloat(y91.a.F3, 0.8f);
            boolean z16 = obtainStyledAttributes.getBoolean(y91.a.I3, false);
            this.mIsGradient = z16;
            if (z16) {
                this.mStartColor = obtainStyledAttributes.getColor(y91.a.G3, -16776961);
                this.mEndColor = obtainStyledAttributes.getColor(y91.a.E3, SupportMenu.CATEGORY_MASK);
                this.mGradientLength = com.tencent.biz.qqcircle.utils.cx.a(obtainStyledAttributes.getDimension(y91.a.H3, 110.0f));
                float[] fArr = {0.0f, 0.25f};
                Paint paint = this.mPaint;
                if (paint != null) {
                    paint.setShader(new LinearGradient(0.0f, 0.0f, this.mGradientLength, 0.0f, new int[]{this.mStartColor, this.mEndColor}, fArr, Shader.TileMode.CLAMP));
                }
            } else {
                int color = obtainStyledAttributes.getColor(y91.a.D3, -16776961);
                Paint paint2 = this.mPaint;
                if (paint2 != null) {
                    paint2.setColor(color);
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public QFSAdMotiveBannerView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTriangleRadio = 0.8f;
        a();
    }
}
