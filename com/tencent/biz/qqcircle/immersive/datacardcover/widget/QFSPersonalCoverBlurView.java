package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverBlurView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverSelectLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import i40.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00016B\u0019\u0012\u0006\u00100\u001a\u00020/\u0012\b\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J(\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0014J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00067"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBlurView;", "Landroid/view/View;", "", "j", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "c", "Landroid/graphics/Canvas;", PM.CANVAS, "g", "f", "e", h.F, "Landroid/graphics/LinearGradient;", "i", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverSelectLayout;", "selectLayout", "setSelectLayout", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "setFeed", "", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "onDraw", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "regionRectF", "blurBitmapRectF", "Landroid/graphics/PorterDuffXfermode;", "Landroid/graphics/PorterDuffXfermode;", "xfermode", "Landroid/graphics/LinearGradient;", NodeProps.LINEAR_GRADIENT, "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverSelectLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lfeedcloud/FeedCloudMeta$StFeed;", "D", "Landroid/graphics/Bitmap;", "coverBitmap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverBlurView extends View {
    private static final int F = Color.parseColor("#00FFFFFF");
    private static final int G = Color.parseColor("#FFFFFFFF");
    private static final int H = cx.a(20.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private FeedCloudMeta$StFeed feed;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private volatile Bitmap coverBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF regionRectF;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF blurBitmapRectF;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PorterDuffXfermode xfermode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient linearGradient;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QFSPersonalCoverSelectLayout selectLayout;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBlurView$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            QLog.d("QFSPersonalCoverBlurView", 1, "loadCoverBitmap, onStateChange, state: " + state);
            if (state == LoadState.STATE_SUCCESS) {
                QFSPersonalCoverBlurView qFSPersonalCoverBlurView = QFSPersonalCoverBlurView.this;
                Bitmap resultBitMap = option.getResultBitMap();
                Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
                qFSPersonalCoverBlurView.c(resultBitMap);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverBlurView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.regionRectF = new RectF();
        this.blurBitmapRectF = new RectF();
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.paint = new Paint(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(final Bitmap bitmap) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: k40.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalCoverBlurView.d(QFSPersonalCoverBlurView.this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QFSPersonalCoverBlurView this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        a aVar = a.f407180a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this$0.coverBitmap = a.b(aVar, context, bitmap, 0.0f, 6, 0, 20, null);
        this$0.postInvalidate();
    }

    private final void e(Canvas canvas, Bitmap bitmap) {
        float a16 = QFSPersonalCoverSelectLayout.INSTANCE.a();
        QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout = this.selectLayout;
        if (qFSPersonalCoverSelectLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
            qFSPersonalCoverSelectLayout = null;
        }
        float height = (((a16 / qFSPersonalCoverSelectLayout.e().getHeight()) - 1) * this.regionRectF.width()) / 2;
        RectF rectF = this.blurBitmapRectF;
        RectF rectF2 = this.regionRectF;
        rectF.left = rectF2.left - height;
        rectF.top = rectF2.top;
        rectF.right = rectF2.right + height;
        rectF.bottom = rectF2.bottom;
        Unit unit = Unit.INSTANCE;
        canvas.drawBitmap(bitmap, (Rect) null, rectF, this.paint);
    }

    private final void f(Canvas canvas) {
        Bitmap bitmap = this.coverBitmap;
        if (bitmap != null) {
            int saveLayer = canvas.saveLayer(this.regionRectF, null);
            e(canvas, bitmap);
            h(canvas);
            canvas.restoreToCount(saveLayer);
        }
    }

    private final void g(Canvas canvas) {
        QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout = this.selectLayout;
        if (qFSPersonalCoverSelectLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
            qFSPersonalCoverSelectLayout = null;
        }
        if (!qFSPersonalCoverSelectLayout.j()) {
            try {
                f(canvas);
            } catch (Exception e16) {
                QLog.w("QFSPersonalCoverBlurView", 1, "drawBlurIfNeed, error", e16);
            }
        }
    }

    private final void h(Canvas canvas) {
        this.paint.setXfermode(this.xfermode);
        this.paint.setShader(i());
        canvas.drawRect(this.regionRectF, this.paint);
        this.paint.setXfermode(null);
        this.paint.setShader(null);
    }

    private final LinearGradient i() {
        QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout;
        LinearGradient linearGradient = this.linearGradient;
        if (linearGradient == null) {
            float centerX = this.regionRectF.centerX();
            RectF rectF = this.regionRectF;
            float f16 = rectF.top;
            float centerX2 = rectF.centerX();
            float f17 = this.regionRectF.bottom;
            int i3 = G;
            int i16 = F;
            int[] iArr = {i3, i3, i16, i16, i3, i3};
            float[] fArr = new float[6];
            fArr[0] = 0.0f;
            QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout2 = this.selectLayout;
            if (qFSPersonalCoverSelectLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
                qFSPersonalCoverSelectLayout2 = null;
            }
            float top = qFSPersonalCoverSelectLayout2.e().getTop();
            RectF rectF2 = this.regionRectF;
            fArr[1] = (top - rectF2.top) / rectF2.height();
            QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout3 = this.selectLayout;
            if (qFSPersonalCoverSelectLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
                qFSPersonalCoverSelectLayout3 = null;
            }
            float top2 = qFSPersonalCoverSelectLayout3.e().getTop();
            RectF rectF3 = this.regionRectF;
            float f18 = top2 - rectF3.top;
            int i17 = H;
            fArr[2] = (f18 + i17) / rectF3.height();
            QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout4 = this.selectLayout;
            if (qFSPersonalCoverSelectLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
                qFSPersonalCoverSelectLayout4 = null;
            }
            float bottom = qFSPersonalCoverSelectLayout4.e().getBottom();
            RectF rectF4 = this.regionRectF;
            fArr[3] = ((bottom - rectF4.top) - i17) / rectF4.height();
            QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout5 = this.selectLayout;
            if (qFSPersonalCoverSelectLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
                qFSPersonalCoverSelectLayout = null;
            } else {
                qFSPersonalCoverSelectLayout = qFSPersonalCoverSelectLayout5;
            }
            float bottom2 = qFSPersonalCoverSelectLayout.e().getBottom();
            RectF rectF5 = this.regionRectF;
            fArr[4] = (bottom2 - rectF5.top) / rectF5.height();
            fArr[5] = 1.0f;
            linearGradient = new LinearGradient(centerX, f16, centerX2, f17, iArr, fArr, Shader.TileMode.CLAMP);
            this.linearGradient = linearGradient;
        }
        return linearGradient;
    }

    private final void j() {
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option obtain = Option.obtain();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed = null;
        }
        obtain.setUrl(feedCloudMeta$StFeed.cover.picUrl.get());
        obtain.setPredecode(true);
        obtain.disableHardwareDecode();
        obtain.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        g16.loadImage(obtain, new b());
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        g(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        RectF rectF = this.regionRectF;
        rectF.left = 0.0f;
        QFSPersonalCoverSelectLayout.Companion companion = QFSPersonalCoverSelectLayout.INSTANCE;
        float a16 = (h16 / 2.0f) - (companion.a() / 2.0f);
        rectF.top = a16;
        rectF.right = w3;
        rectF.bottom = a16 + companion.a();
    }

    public final void setFeed(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        j();
    }

    public final void setSelectLayout(@NotNull QFSPersonalCoverSelectLayout selectLayout) {
        Intrinsics.checkNotNullParameter(selectLayout, "selectLayout");
        this.selectLayout = selectLayout;
    }
}
