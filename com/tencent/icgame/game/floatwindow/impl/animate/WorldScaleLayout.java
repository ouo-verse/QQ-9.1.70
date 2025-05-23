package com.tencent.icgame.game.floatwindow.impl.animate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cy0.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xu0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0006\u000b\u0088\u0001B.\b\u0007\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0002\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00052\n\u0010\b\u001a\u00060\u0007R\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010\b\u001a\u00060\u0007R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001bR\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010.R\u001e\u00108\u001a\n 6*\u0004\u0018\u000105058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00107R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u001bR\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u001bR\u0016\u0010>\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010.R\u0016\u0010@\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010.R\u0016\u0010B\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010.R\u0016\u0010D\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010.R\u0016\u0010F\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010.R\u0016\u0010H\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010.R\"\u0010N\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010.\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010V\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010QR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010.R\u0016\u0010b\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010.R\u0016\u0010d\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010 R\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010.R\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR%\u0010{\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout;", "Landroid/widget/FrameLayout;", "", "w", h.F, "", "a", "Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$b;", "currentStatusInfo", "Landroid/graphics/RectF;", "destRectF", "b", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "d", "Ljava/lang/String;", "TAG", "Landroid/view/WindowManager;", "e", "Landroid/view/WindowManager;", "mWindowManager", "f", "I", "mScreenWidth", "mScreenHeight", "", "i", "J", "stage1Duration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "stage2Duration", "Landroid/graphics/Path;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Path;", "path", "D", "Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$b;", "E", "Landroid/graphics/RectF;", "currentRectF", "", UserInfo.SEX_FEMALE, "Z", "animating", "G", "H", "", "originAspectRatio", "Landroid/view/animation/Interpolator;", "kotlin.jvm.PlatformType", "Landroid/view/animation/Interpolator;", "interpolator", "K", "stage1CenterX", "L", "stage1CenterY", "M", "stage1StartScale", "N", "stage1MinScale", "P", "stage1Progress", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "stage2StartScale", BdhLogUtil.LogTag.Tag_Req, "stage2MinScale", ExifInterface.LATITUDE_SOUTH, "stage2Progress", "T", "getMaxRoundRate", "()F", "setMaxRoundRate", "(F)V", "maxRoundRate", "Lxu0/b;", "U", "Lxu0/b;", "s3DPoint", "V", "v3DPoint", "W", "cur3DPoint", "Lxu0/a;", "a0", "Lxu0/a;", "r2DPoint", "Lxu0/c;", "b0", "Lxu0/c;", "world", "c0", "maxWorldZ", "d0", "minWorldZ", "e0", "coverColor", "Landroid/graphics/Bitmap;", "f0", "Landroid/graphics/Bitmap;", "preDrawBitmap", "g0", "coverAlphaChangeRate", "Landroid/graphics/Paint;", "h0", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$a;", "i0", "Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$a;", "avatarDefaultListener", "Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$c;", "worldScaleListener", "Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$c;", "getWorldScaleListener", "()Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$c;", "setWorldScaleListener", "(Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$c;)V", "Lvu0/a;", "updateAnimateInfo", "Lvu0/a;", "getUpdateAnimateInfo", "()Lvu0/a;", "setUpdateAnimateInfo", "(Lvu0/a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class WorldScaleLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Path path;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ScaleStatusInfo currentStatusInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private RectF currentRectF;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean animating;

    /* renamed from: G, reason: from kotlin metadata */
    private int w;

    /* renamed from: H, reason: from kotlin metadata */
    private int h;

    /* renamed from: I, reason: from kotlin metadata */
    private float originAspectRatio;

    /* renamed from: J, reason: from kotlin metadata */
    private Interpolator interpolator;

    /* renamed from: K, reason: from kotlin metadata */
    private int stage1CenterX;

    /* renamed from: L, reason: from kotlin metadata */
    private int stage1CenterY;

    /* renamed from: M, reason: from kotlin metadata */
    private float stage1StartScale;

    /* renamed from: N, reason: from kotlin metadata */
    private float stage1MinScale;

    /* renamed from: P, reason: from kotlin metadata */
    private float stage1Progress;

    /* renamed from: Q, reason: from kotlin metadata */
    private float stage2StartScale;

    /* renamed from: R, reason: from kotlin metadata */
    private float stage2MinScale;

    /* renamed from: S, reason: from kotlin metadata */
    private float stage2Progress;

    /* renamed from: T, reason: from kotlin metadata */
    private float maxRoundRate;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private b s3DPoint;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private b v3DPoint;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private b cur3DPoint;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private xu0.a r2DPoint;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private xu0.c world;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private float maxWorldZ;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private float minWorldZ;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WindowManager mWindowManager;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long coverColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mScreenWidth;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap preDrawBitmap;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private float coverAlphaChangeRate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mScreenHeight;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long stage1Duration;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a avatarDefaultListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long stage2Duration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$a;", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001f\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$b;", "", "", "toString", "", "a", "I", "b", "()I", "setCenterX", "(I)V", "centerX", "c", "setCenterY", "centerY", "", UserInfo.SEX_FEMALE, "f", "()F", "setScaleSize", "(F)V", "scaleSize", "d", "setCoverAlpha", "coverAlpha", "e", "setAspectRatio", "aspectRatio", "g", "setWidthRoundRatio", "widthRoundRatio", "setPreDrawBitmapAlpha", "preDrawBitmapAlpha", "<init>", "(Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.floatwindow.impl.animate.WorldScaleLayout$b, reason: from toString */
    /* loaded from: classes7.dex */
    public final class ScaleStatusInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int centerX;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int centerY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private float coverAlpha;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private float widthRoundRatio;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float preDrawBitmapAlpha;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private float scaleSize = 1.0f;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private float aspectRatio = 1.0f;

        public ScaleStatusInfo() {
        }

        /* renamed from: a, reason: from getter */
        public final float getAspectRatio() {
            return this.aspectRatio;
        }

        /* renamed from: b, reason: from getter */
        public final int getCenterX() {
            return this.centerX;
        }

        /* renamed from: c, reason: from getter */
        public final int getCenterY() {
            return this.centerY;
        }

        /* renamed from: d, reason: from getter */
        public final float getCoverAlpha() {
            return this.coverAlpha;
        }

        /* renamed from: e, reason: from getter */
        public final float getPreDrawBitmapAlpha() {
            return this.preDrawBitmapAlpha;
        }

        /* renamed from: f, reason: from getter */
        public final float getScaleSize() {
            return this.scaleSize;
        }

        /* renamed from: g, reason: from getter */
        public final float getWidthRoundRatio() {
            return this.widthRoundRatio;
        }

        @NotNull
        public String toString() {
            return "ScaleStatusInfo(centerX=" + this.centerX + ", centerY=" + this.centerY + ", scaleSize=" + this.scaleSize + ", coverAlpha=" + this.coverAlpha + ", aspectRatio=" + this.aspectRatio + ", widthRoundRatio=" + this.widthRoundRatio + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$c;", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$d", "Lcom/tencent/icgame/game/floatwindow/impl/animate/WorldScaleLayout$a;", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements a {
        d() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WorldScaleLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(int w3, int h16) {
        int e16 = uu0.b.e(this);
        int f16 = uu0.b.f(this);
        if (h16 > 0) {
            this.originAspectRatio = w3 / h16;
        }
        int i3 = (int) (e16 + (w3 * 0.5f));
        this.stage1CenterX = i3;
        int i16 = (int) (f16 + (h16 * 0.5f));
        this.stage1CenterY = i16;
        b bVar = this.s3DPoint;
        bVar.f448689a = i3;
        bVar.f448690b = i16;
        bVar.f448691c = this.minWorldZ;
        b bVar2 = this.v3DPoint;
        bVar2.f448689a = i3;
        bVar2.f448690b = i16;
        bVar2.f448691c = this.maxWorldZ;
        this.world.a(bVar2, this.stage2MinScale / this.stage2StartScale);
    }

    private final void b(ScaleStatusInfo currentStatusInfo, RectF destRectF) {
        float scaleSize = currentStatusInfo.getScaleSize() * this.w * 0.5f;
        float scaleSize2 = ((currentStatusInfo.getScaleSize() * this.w) / currentStatusInfo.getAspectRatio()) * 0.5f;
        destRectF.left = currentStatusInfo.getCenterX() - scaleSize;
        destRectF.right = currentStatusInfo.getCenterX() + scaleSize;
        destRectF.top = currentStatusInfo.getCenterY() - scaleSize2;
        destRectF.bottom = currentStatusInfo.getCenterY() + scaleSize2;
    }

    @Override // android.view.View
    public void draw(@Nullable Canvas canvas) {
        boolean z16;
        Bitmap bitmap;
        if (this.animating) {
            b(this.currentStatusInfo, this.currentRectF);
            float width = this.currentRectF.width() * this.maxRoundRate * this.currentStatusInfo.getWidthRoundRatio();
            this.path.reset();
            this.path.addRoundRect(this.currentRectF, width, width, Path.Direction.CW);
            if (canvas != null) {
                canvas.clipPath(this.path);
            }
            float f16 = 255;
            int argb = Color.argb((int) (this.currentStatusInfo.getCoverAlpha() * f16), 146, 146, 146);
            if (this.currentStatusInfo.getCoverAlpha() == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (canvas != null) {
                    canvas.scale(this.currentStatusInfo.getScaleSize(), this.currentStatusInfo.getScaleSize(), this.stage1CenterX, this.stage1CenterY);
                }
                g.a(this.TAG, "draw before super");
                super.draw(canvas);
                g.a(this.TAG, "draw after super");
                if (canvas != null) {
                    canvas.drawColor(argb);
                }
            } else {
                if (canvas != null) {
                    canvas.drawColor(argb);
                }
                if (this.currentStatusInfo.getPreDrawBitmapAlpha() > 0.0f && (bitmap = this.preDrawBitmap) != null) {
                    this.paint.setAlpha((int) (this.currentStatusInfo.getPreDrawBitmapAlpha() * f16));
                    if (canvas != null) {
                        canvas.drawBitmap(bitmap, (Rect) null, this.currentRectF, this.paint);
                    }
                }
            }
            if (canvas != null) {
                canvas.translate(this.currentStatusInfo.getCenterX() - this.stage1CenterX, this.currentStatusInfo.getCenterY() - this.stage1CenterY);
                return;
            }
            return;
        }
        g.a(this.TAG, "draw before super");
        super.draw(canvas);
        g.a(this.TAG, "draw after super");
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.w = w3;
        this.h = h16;
        if (w3 > 0) {
            a(w3, h16);
        }
    }

    public final void setMaxRoundRate(float f16) {
        this.maxRoundRate = f16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WorldScaleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ WorldScaleLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WorldScaleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ICGameWorldScaleLayout";
        this.stage1Duration = 300L;
        this.stage2Duration = 400L;
        this.path = new Path();
        this.currentStatusInfo = new ScaleStatusInfo();
        this.currentRectF = new RectF();
        this.originAspectRatio = 1.0f;
        this.interpolator = a.f.f392377b;
        this.stage1StartScale = 1.0f;
        this.stage1MinScale = 0.7f;
        this.stage1Progress = 1.0f;
        this.stage2StartScale = 0.7f;
        this.stage2MinScale = 0.25f;
        this.stage2Progress = 1.0f;
        this.maxRoundRate = 0.5f;
        this.s3DPoint = new b();
        this.v3DPoint = new b();
        this.cur3DPoint = new b();
        this.r2DPoint = new xu0.a();
        this.world = new xu0.c();
        this.maxWorldZ = 100.0f;
        this.coverColor = 4289111718L;
        this.coverAlphaChangeRate = 1.25f;
        this.paint = new Paint();
        this.avatarDefaultListener = new d();
        this.path.setFillType(Path.FillType.EVEN_ODD);
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        this.mWindowManager = windowManager;
        if (windowManager != null) {
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        }
        setWillNotDraw(false);
        this.paint.setColor(SupportMenu.CATEGORY_MASK);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public final void setUpdateAnimateInfo(@Nullable vu0.a aVar) {
    }

    public final void setWorldScaleListener(@Nullable c cVar) {
    }
}
