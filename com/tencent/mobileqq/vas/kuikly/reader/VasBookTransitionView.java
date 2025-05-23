package com.tencent.mobileqq.vas.kuikly.reader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate;
import com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDirection;
import com.tencent.mobileqq.vas.kuikly.reader.delegate.k;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00b1\u00012\u00020\u00012\u00020\u0002:\u0001,B\u0013\u0012\b\u0010\u00ae\u0001\u001a\u00030\u00ad\u0001\u00a2\u0006\u0006\b\u00af\u0001\u0010\u00b0\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016JI\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072+\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u0013H\u0016J0\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J(\u0010 \u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0014J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0014J\b\u0010$\u001a\u00020\u0003H\u0016J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020%H\u0017J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*J \u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020\u000bJ \u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020\u000bJ\b\u00102\u001a\u00020\u0003H\u0014J\u0006\u00103\u001a\u00020\u0003J\u0006\u00104\u001a\u00020\u0003R\u001a\u00109\u001a\u00020\u00178\u0006X\u0086D\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\"\u0010B\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u00106\u001a\u0004\b?\u00108\"\u0004\b@\u0010AR\"\u0010E\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00106\u001a\u0004\bC\u00108\"\u0004\bD\u0010AR;\u0010G\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010FR;\u0010I\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR;\u0010K\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010FR.\u0010S\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010L8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\b.\u0010RR$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010^\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010V\u001a\u0004\b5\u0010X\"\u0004\b]\u0010ZR$\u0010b\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010V\u001a\u0004\b`\u0010X\"\u0004\ba\u0010ZR\u0016\u0010c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010;R\u0016\u0010e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010;R\"\u0010k\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010U\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010o\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010U\u001a\u0004\bm\u0010h\"\u0004\bn\u0010jR\"\u0010s\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010U\u001a\u0004\bq\u0010h\"\u0004\br\u0010jR\"\u0010w\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010U\u001a\u0004\bu\u0010h\"\u0004\bv\u0010jR\"\u0010{\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010U\u001a\u0004\by\u0010h\"\u0004\bz\u0010jR\"\u0010\u007f\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b|\u0010U\u001a\u0004\b}\u0010h\"\u0004\b~\u0010jR(\u0010\u0081\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0080\u0001\u0010;\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001f\u0010\u0088\u0001\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0005\b\u0087\u0001\u00108R\u0018\u0010\u008a\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u00106R&\u0010\u008e\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008b\u0001\u00106\u001a\u0005\b\u008c\u0001\u00108\"\u0005\b\u008d\u0001\u0010AR\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0091\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0091\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0091\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0091\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0091\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u0091\u0001R\u0018\u0010\u00a0\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0091\u0001R\u0018\u0010\u00a2\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u0091\u0001R\u0016\u0010\u00a4\u0001\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u00106R\u0018\u0010\u00a6\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010;R\u0018\u0010\u00a8\u0001\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a7\u0001\u0010UR\u0018\u0010\u00aa\u0001\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a9\u0001\u0010UR\u0013\u0010\u00ac\u0001\u001a\u00020\u00178F\u00a2\u0006\u0007\u001a\u0005\b\u00ab\u0001\u00108\u00a8\u0006\u00b2\u0001"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", HippyTKDListViewAdapter.X, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "propKey", "", "propValue", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "changed", "", "left", "top", "right", "bottom", "onLayout", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "computeScroll", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDirection;", "direction", "a", "", "y", "invalidate", "setStartPoint", "setTouchPoint", NodeProps.ON_DETACHED_FROM_WINDOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "d", "I", "i", "()I", "defaultAnimSpeed", "e", "Z", "isFirst", "f", "isCoverTransition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setPageCount", "(I)V", "pageCount", "g", "setCurrentIndex", "currentIndex", "Lkotlin/jvm/functions/Function1;", "updatePrePageCallback", BdhLogUtil.LogTag.Tag_Conn, "updateNextPageCallback", "D", "updateCenterClickCallback", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDelegate;", "value", "E", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDelegate;", "getPageDelegate", "()Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDelegate;", "(Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDelegate;)V", "pageDelegate", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "p", "()Landroid/view/View;", "setPrevPage", "(Landroid/view/View;)V", "prevPage", "G", "setCurPage", "curPage", "H", "l", "setNextPage", "nextPage", "pressDown", "J", "isMove", "K", "r", "()F", "setStartX", "(F)V", "startX", "L", "t", "setStartY", "startY", "M", "j", "setLastX", "lastX", "N", "getLastY", "setLastY", "lastY", "P", "u", "setTouchX", "touchX", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "v", "setTouchY", "touchY", BdhLogUtil.LogTag.Tag_Req, "isAbortAnim", "()Z", "setAbortAnim", "(Z)V", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "slopSquare", "T", "pageSlopSquare", "U", "o", "setPageSlopSquare2", "pageSlopSquare2", "Landroid/graphics/RectF;", "V", "Landroid/graphics/RectF;", "tlRect", "W", "tcRect", "a0", "trRect", "b0", "mlRect", "c0", "mcRect", "d0", "mrRect", "e0", "blRect", "f0", "bcRect", "g0", "brRect", "h0", "touchSlop", "i0", "interceptFlag", "j0", "interceptDownX", "k0", "interceptDownY", "c", "animSpeed", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "l0", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasBookTransitionView extends FrameLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> updateNextPageCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> updateCenterClickCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private PageDelegate pageDelegate;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View prevPage;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View curPage;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View nextPage;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean pressDown;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isMove;

    /* renamed from: K, reason: from kotlin metadata */
    private float startX;

    /* renamed from: L, reason: from kotlin metadata */
    private float startY;

    /* renamed from: M, reason: from kotlin metadata */
    private float lastX;

    /* renamed from: N, reason: from kotlin metadata */
    private float lastY;

    /* renamed from: P, reason: from kotlin metadata */
    private float touchX;

    /* renamed from: Q, reason: from kotlin metadata */
    private float touchY;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isAbortAnim;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy slopSquare;

    /* renamed from: T, reason: from kotlin metadata */
    private int pageSlopSquare;

    /* renamed from: U, reason: from kotlin metadata */
    private int pageSlopSquare2;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final RectF tlRect;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final RectF tcRect;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF trRect;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mlRect;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mcRect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int defaultAnimSpeed;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mrRect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFirst;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF blRect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isCoverTransition;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF bcRect;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF brRect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int pageCount;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final int touchSlop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentIndex;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean interceptFlag;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private float interceptDownX;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private float interceptDownY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> updatePrePageCallback;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309899a;

        static {
            int[] iArr = new int[PageDirection.values().length];
            try {
                iArr[PageDirection.PREV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageDirection.NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f309899a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBookTransitionView(@NotNull final Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultAnimSpeed = 300;
        this.isFirst = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.vas.kuikly.reader.VasBookTransitionView$slopSquare$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(context).getScaledTouchSlop());
            }
        });
        this.slopSquare = lazy;
        int q16 = q();
        this.pageSlopSquare = q16;
        this.pageSlopSquare2 = q16 * q16;
        this.tlRect = new RectF();
        this.tcRect = new RectF();
        this.trRect = new RectF();
        this.mlRect = new RectF();
        this.mcRect = new RectF();
        this.mrRect = new RectF();
        this.blRect = new RectF();
        this.bcRect = new RectF();
        this.brRect = new RectF();
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private final int q() {
        return ((Number) this.slopSquare.getValue()).intValue();
    }

    public static /* synthetic */ void setStartPoint$default(VasBookTransitionView vasBookTransitionView, float f16, float f17, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        vasBookTransitionView.setStartPoint(f16, f17, z16);
    }

    public static /* synthetic */ void setTouchPoint$default(VasBookTransitionView vasBookTransitionView, float f16, float f17, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        vasBookTransitionView.setTouchPoint(f16, f17, z16);
    }

    private final void w() {
        A();
        B();
    }

    private final void x() {
        if (getChildCount() >= 3) {
            this.prevPage = getChildAt(0);
            this.curPage = getChildAt(1);
            this.nextPage = getChildAt(2);
            View view = this.curPage;
            if (view != null) {
                view.bringToFront();
            }
            this.isFirst = false;
        }
    }

    private final void y(PageDelegate pageDelegate) {
        PageDelegate pageDelegate2 = this.pageDelegate;
        if (pageDelegate2 != null) {
            pageDelegate2.w();
        }
        this.pageDelegate = pageDelegate;
    }

    private final void z() {
        this.tlRect.set(0.0f, 0.0f, getWidth() * 0.33f, getHeight() * 0.33f);
        this.tcRect.set(getWidth() * 0.33f, 0.0f, getWidth() * 0.66f, getHeight() * 0.33f);
        this.trRect.set(getWidth() * 0.36f, 0.0f, getWidth(), getHeight() * 0.33f);
        this.mlRect.set(0.0f, getHeight() * 0.33f, getWidth() * 0.33f, getHeight() * 0.66f);
        this.mcRect.set(getWidth() * 0.33f, getHeight() * 0.33f, getWidth() * 0.66f, getHeight() * 0.66f);
        this.mrRect.set(getWidth() * 0.66f, getHeight() * 0.33f, getWidth(), getHeight() * 0.66f);
        this.blRect.set(0.0f, getHeight() * 0.66f, getWidth() * 0.33f, getHeight());
        this.bcRect.set(getWidth() * 0.33f, getHeight() * 0.66f, getWidth() * 0.66f, getHeight());
        this.brRect.set(getWidth() * 0.66f, getHeight() * 0.66f, getWidth(), getHeight());
    }

    public final void A() {
        PageDelegate kVar;
        if (this.isCoverTransition) {
            kVar = new com.tencent.mobileqq.vas.kuikly.reader.delegate.h(this);
        } else {
            kVar = new k(this);
        }
        y(kVar);
        PageDelegate pageDelegate = this.pageDelegate;
        if (pageDelegate != null) {
            pageDelegate.I(getWidth(), getHeight());
        }
    }

    public final void B() {
        int q16 = q();
        this.pageSlopSquare = q16;
        this.pageSlopSquare2 = q16 * q16;
    }

    public final boolean a(@NotNull PageDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        int i3 = b.f309899a[direction.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            View view = this.curPage;
            View view2 = this.nextPage;
            this.curPage = view2;
            this.nextPage = this.prevPage;
            this.prevPage = view;
            if (view2 != null) {
                view2.bringToFront();
            }
            this.currentIndex++;
            Function1<Object, Unit> function1 = this.updateNextPageCallback;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("current_index", this.currentIndex);
                function1.invoke(jSONObject);
            }
            QLog.d("VasBookTransitionView", 1, "next " + this.currentIndex);
            return true;
        }
        View view3 = this.curPage;
        View view4 = this.prevPage;
        this.curPage = view4;
        this.prevPage = this.nextPage;
        this.nextPage = view3;
        if (view4 != null) {
            view4.bringToFront();
        }
        this.currentIndex--;
        Function1<Object, Unit> function12 = this.updatePrePageCallback;
        if (function12 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("current_index", this.currentIndex);
            function12.invoke(jSONObject2);
        }
        QLog.d("VasBookTransitionView", 1, "pre " + this.currentIndex);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -2000522229:
                if (propKey.equals("updateNextPage")) {
                    this.updateNextPageCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1815274807:
                if (propKey.equals("updatePrePage")) {
                    this.updatePrePageCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 107258988:
                if (propKey.equals("coverTransition")) {
                    this.isCoverTransition = ((Boolean) propValue).booleanValue();
                    A();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 110549828:
                if (propKey.equals("total")) {
                    this.pageCount = ((Integer) propValue).intValue();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1126940025:
                if (propKey.equals("current")) {
                    this.currentIndex = ((Integer) propValue).intValue();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1645966899:
                if (propKey.equals("centerClick")) {
                    this.updateCenterClickCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    public final int c() {
        if (this.pageDelegate instanceof k) {
            return 300;
        }
        return 200;
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // android.view.View
    public void computeScroll() {
        PageDelegate pageDelegate = this.pageDelegate;
        if (pageDelegate != null) {
            pageDelegate.a();
        }
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final View getCurPage() {
        return this.curPage;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        PageDelegate pageDelegate = this.pageDelegate;
        if (pageDelegate != null) {
            pageDelegate.y(canvas);
        }
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    /* renamed from: g, reason: from getter */
    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    /* renamed from: i, reason: from getter */
    public final int getDefaultAnimSpeed() {
        return this.defaultAnimSpeed;
    }

    /* renamed from: j, reason: from getter */
    public final float getLastX() {
        return this.lastX;
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final View getNextPage() {
        return this.nextPage;
    }

    /* renamed from: m, reason: from getter */
    public final int getPageCount() {
        return this.pageCount;
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    /* renamed from: o, reason: from getter */
    public final int getPageSlopSquare2() {
        return this.pageSlopSquare2;
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        float x16 = ev5.getX();
        float y16 = ev5.getY();
        if (ev5.getAction() == 0) {
            this.interceptDownX = x16;
            this.interceptDownY = y16;
            onTouchEvent(ev5);
            this.interceptFlag = false;
            return false;
        }
        if (this.interceptFlag) {
            return true;
        }
        if (ev5.getAction() != 2 || (Math.abs(x16 - this.interceptDownX) <= this.touchSlop && Math.abs(y16 - this.interceptDownY) <= this.touchSlop)) {
            return false;
        }
        this.interceptFlag = true;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.isFirst) {
            x();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        z();
        PageDelegate pageDelegate = this.pageDelegate;
        if (pageDelegate != null) {
            pageDelegate.I(w3, h16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        r1 = r1.getCurrentWindowMetrics();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        r1 = r1.getBounds();
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        PageDelegate pageDelegate;
        PageDelegate pageDelegate2;
        PageDelegate pageDelegate3;
        PageDelegate pageDelegate4;
        int mandatorySystemGestures;
        Insets insetsIgnoringVisibility;
        Integer num;
        int i3;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsets rootWindowInsets = getRootWindowInsets();
            mandatorySystemGestures = WindowInsets.Type.mandatorySystemGestures();
            insetsIgnoringVisibility = rootWindowInsets.getInsetsIgnoringVisibility(mandatorySystemGestures);
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "this.rootWindowInsets.ge\u2026andatorySystemGestures())");
            Activity activity = getActivity();
            if (activity != null && (r1 = activity.getWindowManager()) != null && currentWindowMetrics != null && bounds != null) {
                num = Integer.valueOf(bounds.height());
            } else {
                num = null;
            }
            if (num != null) {
                float y16 = event.getY();
                int intValue = num.intValue();
                i3 = insetsIgnoringVisibility.bottom;
                if (y16 > intValue - i3 && event.getAction() != 1 && event.getAction() != 3) {
                    return true;
                }
            }
        }
        if ((event.getActionMasked() == 5 || event.getActionMasked() == 6) && (pageDelegate = this.pageDelegate) != null) {
            pageDelegate.A(event);
        }
        int action = event.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3 || !this.pressDown) {
                        return true;
                    }
                    this.pressDown = false;
                    PageDelegate pageDelegate5 = this.pageDelegate;
                    Intrinsics.checkNotNull(pageDelegate5);
                    if (pageDelegate5.r() && (pageDelegate4 = this.pageDelegate) != null) {
                        pageDelegate4.A(event);
                    }
                } else {
                    if (!this.pressDown) {
                        return true;
                    }
                    float abs = Math.abs(this.startX - event.getX());
                    float abs2 = Math.abs(this.startY - event.getY());
                    if (!this.isMove) {
                        if (abs > q() || abs2 > q()) {
                            z16 = true;
                        }
                        this.isMove = z16;
                    }
                    if (this.isMove && (pageDelegate3 = this.pageDelegate) != null) {
                        pageDelegate3.A(event);
                    }
                }
            } else {
                if (!this.pressDown) {
                    return true;
                }
                this.pressDown = false;
                PageDelegate pageDelegate6 = this.pageDelegate;
                Intrinsics.checkNotNull(pageDelegate6);
                if (!pageDelegate6.r() && !this.isMove) {
                    return true;
                }
                PageDelegate pageDelegate7 = this.pageDelegate;
                Intrinsics.checkNotNull(pageDelegate7);
                if (pageDelegate7.r() && (pageDelegate2 = this.pageDelegate) != null) {
                    pageDelegate2.A(event);
                }
            }
        } else {
            this.pressDown = true;
            this.isMove = false;
            PageDelegate pageDelegate8 = this.pageDelegate;
            if (pageDelegate8 != null) {
                pageDelegate8.A(event);
            }
            PageDelegate pageDelegate9 = this.pageDelegate;
            if (pageDelegate9 != null) {
                pageDelegate9.x();
            }
            setStartPoint(event.getX(), event.getY(), false);
        }
        return true;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final View getPrevPage() {
        return this.prevPage;
    }

    /* renamed from: r, reason: from getter */
    public final float getStartX() {
        return this.startX;
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    public final void setAbortAnim(boolean z16) {
        this.isAbortAnim = z16;
    }

    public final void setCurPage(@Nullable View view) {
        this.curPage = view;
    }

    public final void setCurrentIndex(int i3) {
        this.currentIndex = i3;
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    public final void setLastX(float f16) {
        this.lastX = f16;
    }

    public final void setLastY(float f16) {
        this.lastY = f16;
    }

    public final void setNextPage(@Nullable View view) {
        this.nextPage = view;
    }

    public final void setPageCount(int i3) {
        this.pageCount = i3;
    }

    public final void setPageSlopSquare2(int i3) {
        this.pageSlopSquare2 = i3;
    }

    public final void setPrevPage(@Nullable View view) {
        this.prevPage = view;
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    public final void setStartPoint(float x16, float y16, boolean invalidate) {
        this.startX = x16;
        this.startY = y16;
        this.lastX = x16;
        this.lastY = y16;
        this.touchX = x16;
        this.touchY = y16;
        if (invalidate) {
            invalidate();
        }
    }

    public final void setStartX(float f16) {
        this.startX = f16;
    }

    public final void setStartY(float f16) {
        this.startY = f16;
    }

    public final void setTouchPoint(float x16, float y16, boolean invalidate) {
        this.lastX = this.touchX;
        this.lastY = this.touchY;
        this.touchX = x16;
        this.touchY = y16;
        if (invalidate) {
            invalidate();
        }
        PageDelegate pageDelegate = this.pageDelegate;
        if (pageDelegate != null) {
            pageDelegate.z();
        }
    }

    public final void setTouchX(float f16) {
        this.touchX = f16;
    }

    public final void setTouchY(float f16) {
        this.touchY = f16;
    }

    /* renamed from: t, reason: from getter */
    public final float getStartY() {
        return this.startY;
    }

    /* renamed from: u, reason: from getter */
    public final float getTouchX() {
        return this.touchX;
    }

    /* renamed from: v, reason: from getter */
    public final float getTouchY() {
        return this.touchY;
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        PageDelegate pageDelegate;
        PageDelegate pageDelegate2;
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1354815177) {
            if (hashCode != -303702422) {
                if (hashCode == 594765962 && method.equals("scrollToPrePage") && (pageDelegate2 = this.pageDelegate) != null) {
                    pageDelegate2.B(this.defaultAnimSpeed);
                }
            } else if (method.equals("scrollToNextPage") && (pageDelegate = this.pageDelegate) != null) {
                pageDelegate.t(this.defaultAnimSpeed);
            }
        } else if (method.equals("commit")) {
            w();
        }
        return c.a.b(this, method, params, callback);
    }
}
