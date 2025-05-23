package com.tencent.timi.game.floatwindow.impl.animate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh4.b;
import yn4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0006\u009f\u0001\u00a0\u0001\u00a1\u0001B.\b\u0007\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\f\b\u0002\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u0001\u0012\t\b\u0002\u0010\u009c\u0001\u001a\u00020\u0002\u00a2\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u001c\u0010\u0015\u001a\u00020\u00052\n\u0010\u0012\u001a\u00060\u0011R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J*\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R\u0014\u0010-\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00103R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00107R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010\u0012\u001a\u00060\u0011R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00103R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u00103R\u0016\u0010J\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010ER\u001e\u0010N\u001a\n L*\u0004\u0018\u00010K0K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010MR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u00103R\u0016\u0010R\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u00103R\u0016\u0010T\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010ER\u0016\u0010V\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010ER\u0016\u0010X\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010ER\u0016\u0010Z\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u00103R\u0016\u0010\\\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u00103R\u0016\u0010^\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010ER\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010ER\u0016\u0010b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010ER\"\u0010h\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010E\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010kR\u0016\u0010p\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010kR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010z\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010ER\u0016\u0010|\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010ER\u0016\u0010~\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u00107R\u0019\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010ER,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001a\u0010\u008e\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R*\u0010\u0094\u0001\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0005\b9\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u00a8\u0006\u00a2\u0001"}, d2 = {"Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout;", "Landroid/widget/FrameLayout;", "", "w", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "from", "to", "Landroid/animation/ValueAnimator;", "i", "k", "progress", "u", "v", "r", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$b;", "currentStatusInfo", "Landroid/graphics/RectF;", "destRectF", ReportConstant.COSTREPORT_PREFIX, "", "url", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$a;", "listener", "o", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "destCenterX", "destCenterY", "destWidth", "Landroid/graphics/Bitmap;", "preDrawBitmap", "t", "g", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Luh4/b;", "floatingAnimateInfo", "p", "d", "Ljava/lang/String;", "TAG", "Landroid/view/WindowManager;", "e", "Landroid/view/WindowManager;", "mWindowManager", "f", "I", "mScreenWidth", "mScreenHeight", "", "J", "stage1Duration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "stage2Duration", "Landroid/graphics/Path;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Path;", "path", "D", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$b;", "E", "Landroid/graphics/RectF;", "currentRectF", "", UserInfo.SEX_FEMALE, "Z", "animating", "G", "H", "originAspectRatio", "Landroid/view/animation/Interpolator;", "kotlin.jvm.PlatformType", "Landroid/view/animation/Interpolator;", "interpolator", "K", "stage1CenterX", "L", "stage1CenterY", "M", "stage1StartScale", "N", "stage1MinScale", "P", "stage1Progress", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "stage2CenterX", BdhLogUtil.LogTag.Tag_Req, "stage2CenterY", ExifInterface.LATITUDE_SOUTH, "stage2StartScale", "T", "stage2MinScale", "U", "stage2Progress", "V", "getMaxRoundRate", "()F", "setMaxRoundRate", "(F)V", "maxRoundRate", "Lwh4/b;", "W", "Lwh4/b;", "s3DPoint", "a0", "v3DPoint", "b0", "cur3DPoint", "Lwh4/a;", "c0", "Lwh4/a;", "r2DPoint", "Lwh4/c;", "d0", "Lwh4/c;", "world", "e0", "maxWorldZ", "f0", "minWorldZ", "g0", "coverColor", "h0", "Landroid/graphics/Bitmap;", "i0", "coverAlphaChangeRate", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$c;", "j0", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$c;", DomainData.DOMAIN_NAME, "()Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$c;", "setWorldScaleListener", "(Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$c;)V", "worldScaleListener", "Landroid/graphics/Paint;", "k0", "Landroid/graphics/Paint;", "paint", "l0", "Luh4/b;", "()Luh4/b;", "setUpdateAnimateInfo", "(Luh4/b;)V", "updateAnimateInfo", "m0", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$a;", "avatarDefaultListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
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
    private int stage2CenterX;

    /* renamed from: R, reason: from kotlin metadata */
    private int stage2CenterY;

    /* renamed from: S, reason: from kotlin metadata */
    private float stage2StartScale;

    /* renamed from: T, reason: from kotlin metadata */
    private float stage2MinScale;

    /* renamed from: U, reason: from kotlin metadata */
    private float stage2Progress;

    /* renamed from: V, reason: from kotlin metadata */
    private float maxRoundRate;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private b s3DPoint;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b v3DPoint;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b cur3DPoint;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private wh4.a r2DPoint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private wh4.c world;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WindowManager mWindowManager;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private float maxWorldZ;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mScreenWidth;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private float minWorldZ;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private long coverColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mScreenHeight;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap preDrawBitmap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long stage1Duration;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private float coverAlphaChangeRate;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c worldScaleListener;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private uh4.b updateAnimateInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long stage2Duration;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a avatarDefaultListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "onLoadFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@Nullable Bitmap bitmap);

        void onLoadFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001f\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$b;", "", "", "toString", "", "a", "I", "b", "()I", "i", "(I)V", "centerX", "c", "j", "centerY", "", UserInfo.SEX_FEMALE, "f", "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(F)V", "scaleSize", "d", "k", "coverAlpha", "e", tl.h.F, "aspectRatio", "g", DomainData.DOMAIN_NAME, "widthRoundRatio", "l", "preDrawBitmapAlpha", "<init>", "(Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout$b, reason: from toString */
    /* loaded from: classes26.dex */
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

        public final void h(float f16) {
            this.aspectRatio = f16;
        }

        public final void i(int i3) {
            this.centerX = i3;
        }

        public final void j(int i3) {
            this.centerY = i3;
        }

        public final void k(float f16) {
            this.coverAlpha = f16;
        }

        public final void l(float f16) {
            this.preDrawBitmapAlpha = f16;
        }

        public final void m(float f16) {
            this.scaleSize = f16;
        }

        public final void n(float f16) {
            this.widthRoundRatio = f16;
        }

        @NotNull
        public String toString() {
            return "ScaleStatusInfo(centerX=" + this.centerX + ", centerY=" + this.centerY + ", scaleSize=" + this.scaleSize + ", coverAlpha=" + this.coverAlpha + ", aspectRatio=" + this.aspectRatio + ", widthRoundRatio=" + this.widthRoundRatio + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$c;", "", "", "c", "d", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface c {
        void a();

        void b();

        void c();

        void d();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WorldScaleLayout this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.animating = false;
            this$0.r();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            c worldScaleListener = WorldScaleLayout.this.getWorldScaleListener();
            if (worldScaleListener != null) {
                worldScaleListener.d();
            }
            final WorldScaleLayout worldScaleLayout = WorldScaleLayout.this;
            worldScaleLayout.post(new Runnable() { // from class: wh4.f
                @Override // java.lang.Runnable
                public final void run() {
                    WorldScaleLayout.e.b(WorldScaleLayout.this);
                }
            });
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            WorldScaleLayout.this.animating = true;
            c worldScaleListener = WorldScaleLayout.this.getWorldScaleListener();
            if (worldScaleListener != null) {
                worldScaleListener.c();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            WorldScaleLayout.this.animating = false;
            c worldScaleListener = WorldScaleLayout.this.getWorldScaleListener();
            if (worldScaleListener != null) {
                worldScaleListener.b();
            }
            WorldScaleLayout.this.r();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            WorldScaleLayout.this.animating = true;
            c worldScaleListener = WorldScaleLayout.this.getWorldScaleListener();
            if (worldScaleListener != null) {
                worldScaleListener.a();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f377086e;

        g(float f16) {
            this.f377086e = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            WorldScaleLayout.this.u(this.f377086e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$h", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f377088e;

        h(float f16) {
            this.f377088e = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            WorldScaleLayout.this.v(this.f377088e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$i", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class i implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f377089d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f377090e;

        i(URLDrawable uRLDrawable, a aVar) {
            this.f377089d = uRLDrawable;
            this.f377090e = aVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.f377090e.onLoadFailed();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
            Bitmap bitmap;
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Drawable currDrawable = this.f377089d.getCurrDrawable();
            if ((currDrawable instanceof RegionDrawable) && (bitmap = ((RegionDrawable) currDrawable).getBitmap()) != null) {
                this.f377090e.a(bitmap);
            } else {
                this.f377090e.onLoadFailed();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WorldScaleLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ValueAnimator i(float from, float to5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(from, to5);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(from, to)");
        ofFloat.setDuration(this.stage1Duration);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: wh4.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WorldScaleLayout.j(WorldScaleLayout.this, valueAnimator);
            }
        });
        ofFloat.addListener(new g(from));
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(WorldScaleLayout this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.u(((Float) animatedValue).floatValue());
        this$0.r();
    }

    private final ValueAnimator k(float from, float to5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(from, to5);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(from, to)");
        ofFloat.setDuration(this.stage2Duration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: wh4.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WorldScaleLayout.l(WorldScaleLayout.this, valueAnimator);
            }
        });
        ofFloat.addListener(new h(from));
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(WorldScaleLayout this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.v(((Float) animatedValue).floatValue());
        this$0.r();
    }

    private final void o(String url, a listener) {
        Bitmap bitmap;
        URLDrawable drawable = URLDrawable.getDrawable(url, com.tencent.timi.game.utils.d.f380295a.b(128, R.drawable.ovu));
        Drawable currDrawable = drawable.getCurrDrawable();
        if ((currDrawable instanceof RegionDrawable) && (bitmap = ((RegionDrawable) currDrawable).getBitmap()) != null) {
            listener.a(bitmap);
        } else {
            drawable.setURLDrawableListener(new i(drawable, listener));
            drawable.startDownload(true);
        }
    }

    private final void q(int w3, int h16) {
        int g16 = fh4.g.g(this);
        int i3 = fh4.g.i(this);
        if (h16 > 0) {
            this.originAspectRatio = w3 / h16;
        }
        int i16 = (int) (g16 + (w3 * 0.5f));
        this.stage1CenterX = i16;
        int i17 = (int) (i3 + (h16 * 0.5f));
        this.stage1CenterY = i17;
        b bVar = this.s3DPoint;
        bVar.f445677a = i16;
        bVar.f445678b = i17;
        bVar.f445679c = this.minWorldZ;
        b bVar2 = this.v3DPoint;
        bVar2.f445677a = i16;
        bVar2.f445678b = i17;
        bVar2.f445679c = this.maxWorldZ;
        this.world.b(bVar2, this.stage2MinScale / this.stage2StartScale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        postInvalidateOnAnimation();
    }

    private final void s(ScaleStatusInfo currentStatusInfo, RectF destRectF) {
        float scaleSize = currentStatusInfo.getScaleSize() * this.w * 0.5f;
        float scaleSize2 = ((currentStatusInfo.getScaleSize() * this.w) / currentStatusInfo.getAspectRatio()) * 0.5f;
        destRectF.left = currentStatusInfo.getCenterX() - scaleSize;
        destRectF.right = currentStatusInfo.getCenterX() + scaleSize;
        destRectF.top = currentStatusInfo.getCenterY() - scaleSize2;
        destRectF.bottom = currentStatusInfo.getCenterY() + scaleSize2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(float progress) {
        float coerceAtMost;
        this.stage1Progress = progress;
        ScaleStatusInfo scaleStatusInfo = this.currentStatusInfo;
        float f16 = 1.0f - progress;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.coverAlphaChangeRate * f16, 1.0f);
        scaleStatusInfo.k(coerceAtMost);
        this.currentStatusInfo.i(this.stage1CenterX);
        this.currentStatusInfo.j(this.stage1CenterY);
        ScaleStatusInfo scaleStatusInfo2 = this.currentStatusInfo;
        float f17 = this.stage1StartScale;
        float f18 = this.stage1MinScale;
        scaleStatusInfo2.m(((f17 - f18) * progress) + f18);
        this.currentStatusInfo.n(f16);
        ScaleStatusInfo scaleStatusInfo3 = this.currentStatusInfo;
        float f19 = this.originAspectRatio;
        scaleStatusInfo3.h(((1.0f - f19) * f16) + f19);
        this.currentStatusInfo.l(0.0f);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(float progress) {
        this.stage2Progress = progress;
        b bVar = this.cur3DPoint;
        float f16 = 1.0f - progress;
        bVar.f445679c = this.maxWorldZ * f16;
        float f17 = this.v3DPoint.f445678b;
        b bVar2 = this.s3DPoint;
        float f18 = bVar2.f445678b;
        bVar.f445678b = ((f17 - f18) * f16) + f18;
        bVar.f445677a = bVar2.f445677a;
        this.world.a(bVar, this.r2DPoint);
        this.currentStatusInfo.k(1.0f);
        this.currentStatusInfo.i((int) this.r2DPoint.f445674a);
        this.currentStatusInfo.j((int) this.r2DPoint.f445675b);
        this.currentStatusInfo.m(this.stage2StartScale * this.r2DPoint.f445676c);
        this.currentStatusInfo.l(f16);
        this.currentStatusInfo.n(1.0f);
        this.currentStatusInfo.h(1.0f);
        r();
    }

    @Override // android.view.View
    public void draw(@Nullable Canvas canvas) {
        boolean z16;
        Bitmap bitmap;
        if (this.animating) {
            s(this.currentStatusInfo, this.currentRectF);
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
                l.b(this.TAG, "draw before super");
                super.draw(canvas);
                l.b(this.TAG, "draw after super");
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
        l.b(this.TAG, "draw before super");
        super.draw(canvas);
        l.b(this.TAG, "draw after super");
    }

    public final void g() {
        if (!this.animating) {
            ValueAnimator i3 = i(1.0f, 0.0f);
            i3.setInterpolator(new AccelerateInterpolator());
            ValueAnimator k3 = k(1.0f, 0.0f);
            k3.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(i3, k3);
            animatorSet.addListener(new e());
            animatorSet.start();
        }
    }

    public final void h() {
        if (!this.animating) {
            ValueAnimator k3 = k(0.0f, 1.0f);
            k3.setInterpolator(new AccelerateInterpolator());
            ValueAnimator i3 = i(0.0f, 1.0f);
            i3.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new f());
            animatorSet.playSequentially(k3, i3);
            animatorSet.start();
        }
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final uh4.b getUpdateAnimateInfo() {
        return this.updateAnimateInfo;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final c getWorldScaleListener() {
        return this.worldScaleListener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.w = w3;
        this.h = h16;
        if (w3 > 0) {
            q(w3, h16);
        }
    }

    public final void p(@NotNull uh4.b floatingAnimateInfo, @Nullable String url) {
        Intrinsics.checkNotNullParameter(floatingAnimateInfo, "floatingAnimateInfo");
        this.updateAnimateInfo = floatingAnimateInfo;
        if (!TextUtils.isEmpty(url) && !Intrinsics.areEqual("null", url)) {
            o(url, this.avatarDefaultListener);
        }
    }

    public final void setMaxRoundRate(float f16) {
        this.maxRoundRate = f16;
    }

    public final void setUpdateAnimateInfo(@Nullable uh4.b bVar) {
        this.updateAnimateInfo = bVar;
    }

    public final void setWorldScaleListener(@Nullable c cVar) {
        this.worldScaleListener = cVar;
    }

    public final void t(float destCenterX, float destCenterY, float destWidth, @Nullable Bitmap preDrawBitmap) {
        int i3 = (int) destCenterX;
        this.stage2CenterX = i3;
        int i16 = (int) destCenterY;
        this.stage2CenterY = i16;
        float f16 = destWidth / this.w;
        this.stage2MinScale = f16;
        this.preDrawBitmap = preDrawBitmap;
        b bVar = this.v3DPoint;
        bVar.f445677a = i3;
        bVar.f445678b = i16;
        bVar.f445679c = this.maxWorldZ;
        this.world.b(bVar, f16 / this.stage2StartScale);
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
        this.TAG = "WorldScaleLayout";
        this.stage1Duration = 300L;
        this.stage2Duration = 400L;
        this.path = new Path();
        this.currentStatusInfo = new ScaleStatusInfo();
        this.currentRectF = new RectF();
        this.originAspectRatio = 1.0f;
        this.interpolator = b.f.f450694b;
        this.stage1StartScale = 1.0f;
        this.stage1MinScale = 0.7f;
        this.stage1Progress = 1.0f;
        this.stage2StartScale = 0.7f;
        this.stage2MinScale = 0.25f;
        this.stage2Progress = 1.0f;
        this.maxRoundRate = 0.5f;
        this.s3DPoint = new wh4.b();
        this.v3DPoint = new wh4.b();
        this.cur3DPoint = new wh4.b();
        this.r2DPoint = new wh4.a();
        this.world = new wh4.c();
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$d", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "onLoadFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements a {
        d() {
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.a
        public void a(@Nullable Bitmap bitmap) {
            uh4.b updateAnimateInfo = WorldScaleLayout.this.getUpdateAnimateInfo();
            if (updateAnimateInfo != null) {
                updateAnimateInfo.i(bitmap);
            }
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.a
        public void onLoadFailed() {
        }
    }
}
