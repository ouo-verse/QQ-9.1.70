package com.tencent.mobileqq.aio.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIORecycleView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0092\u0001BQ\b\u0007\u0012\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001\u0012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u0012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0004\u0012!\u0010\\\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\t0W\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u001c\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0018\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0014J0\u0010-\u001a\u00020\t2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0014J%\u00101\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010.2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0000\u00a2\u0006\u0004\b1\u00102J%\u00103\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010.2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0000\u00a2\u0006\u0004\b3\u00102J(\u00106\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J(\u00107\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u00108\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J@\u0010<\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J8\u0010<\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u0010>\u001a\u00020=H\u0017J0\u0010B\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010F\u001a\u00020'2\u0006\u00104\u001a\u00020\u00152\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020CH\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020 H\u0016J%\u0010K\u001a\u00020\t2\u0006\u0010H\u001a\u00020\u00042\f\u0010J\u001a\b\u0012\u0004\u0012\u00020C0IH\u0016\u00a2\u0006\u0004\bK\u0010LJ\u0018\u0010M\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0016J\u0014\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040NH\u0016J\b\u0010P\u001a\u00020\tH\u0016J\u0010\u0010R\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0004H\u0016J\u0010\u0010S\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0004H\u0016J\u0010\u0010U\u001a\u00020\t2\u0006\u0010T\u001a\u00020'H\u0016J\u0010\u0010V\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R/\u0010\\\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\t0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010aR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR$\u0010s\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001b\u0010\u0011\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010t\u001a\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u001b\u0010\u0013\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010t\u001a\u0004\b{\u0010|R\u0016\u0010T\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010^R\u0016\u0010\u007f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010xR\u0016\u0010\u0081\u0001\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bx\u0010\u0080\u0001R\u0017\u0010\u0083\u0001\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u0017\u0010\u0085\u0001\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0080\u0001R\u001a\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/AIOMsgListGroup;", "Landroid/widget/FrameLayout;", "", "Landroidx/core/view/NestedScrollingParent3;", "", "dyUnconsumed", "type", "", "consumed", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "content", "y", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Landroid/graphics/Paint;", "paint", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "child", "addView", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "width", "height", "view", "removeView", "removeViewAt", "Lcom/tencent/mobileqq/aio/widget/AIOMsgAvatarAreaGroup;", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "T", "Lkotlin/Function0;", "block", "D", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", ReportConstant.COSTREPORT_PREFIX, "target", "axes", "onStartNestedScroll", "onNestedScrollAccepted", "onStopNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "onNestedScroll", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "dx", "dy", "onNestedPreScroll", "", "velocityX", "velocityY", "onNestedPreFling", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "position", "", "drawSize", "setImmersiveArea", "(I[Ljava/lang/Float;)V", "setTransparentArea", "Lkotlin/Pair;", "w", "B", Element.ELEMENT_NAME_DISTANCE, "setAvatarTransitionHeight", "setAvatarCoincideHeight", "debugDraw", "setDrawDebug", "dispatchDraw", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "d", "Lkotlin/jvm/functions/Function1;", "listener", "e", "Z", "layoutValid", "f", "Landroid/view/View;", "avatarAreaView", "Lcom/tencent/mobileqq/aio/widget/EdgeTransparentView;", tl.h.F, "Lcom/tencent/mobileqq/aio/widget/EdgeTransparentView;", "msgAreaView", "i", "backgroundView", "Landroidx/core/view/NestedScrollingParentHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/core/view/NestedScrollingParentHelper;", "mParentHelper", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "Lcom/tencent/aio/api/list/IListUIOperationApi;", HippyTKDListViewAdapter.X, "()Lcom/tencent/aio/api/list/IListUIOperationApi;", "setUiHelper", "(Lcom/tencent/aio/api/list/IListUIOperationApi;)V", "uiHelper", "Lkotlin/Lazy;", "u", "()Landroid/graphics/Rect;", "E", "I", "avatarCoincideHeight", UserInfo.SEX_FEMALE, "t", "()Landroid/graphics/Paint;", "G", "H", "avatarHeadTopDistance", "[I", "mReusableIntPair", "J", "mScrollOffset", "K", "mNestedOffsets", "Landroidx/recyclerview/widget/AIORecycleView;", "v", "()Landroidx/recyclerview/widget/AIORecycleView;", "recycleView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/jvm/functions/Function1;)V", "L", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class AIOMsgListGroup extends FrameLayout implements NestedScrollingParent3 {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a L;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private IListUIOperationApi uiHelper;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy rect;

    /* renamed from: E, reason: from kotlin metadata */
    private int avatarCoincideHeight;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy paint;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean debugDraw;

    /* renamed from: H, reason: from kotlin metadata */
    private int avatarHeadTopDistance;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final int[] mReusableIntPair;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final int[] mScrollOffset;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final int[] mNestedOffsets;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean layoutValid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View avatarAreaView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EdgeTransparentView msgAreaView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View backgroundView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NestedScrollingParentHelper mParentHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/AIOMsgListGroup$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65324);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            L = new a(null);
        }
    }

    public /* synthetic */ AIOMsgListGroup(Context context, AttributeSet attributeSet, int i3, Function1 function1, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, function1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), function1, Integer.valueOf(i16), defaultConstructorMarker);
    }

    private final void C(Canvas canvas, Rect rect, Paint paint) {
        canvas.drawRect(rect, paint);
    }

    private final Paint t() {
        return (Paint) this.paint.getValue();
    }

    private final Rect u() {
        return (Rect) this.rect.getValue();
    }

    private final AIORecycleView v() {
        IListUIOperationApi iListUIOperationApi = this.uiHelper;
        if (iListUIOperationApi != null) {
            return iListUIOperationApi.i();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String content) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOMsgListGroup", 1, content);
        }
    }

    private final void z(int dyUnconsumed, int type, int[] consumed) {
        if (consumed != null) {
            consumed[1] = dyUnconsumed;
        }
    }

    public void A(@NotNull AIOMsgAvatarAreaGroup view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            D(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$removeAvatarAreaView$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListGroup.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    View view2;
                    EdgeTransparentView edgeTransparentView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AIOMsgListGroup aIOMsgListGroup = AIOMsgListGroup.this;
                    view2 = aIOMsgListGroup.avatarAreaView;
                    aIOMsgListGroup.removeView(view2);
                    AIOMsgListGroup.this.avatarAreaView = null;
                    IListUIOperationApi x16 = AIOMsgListGroup.this.x();
                    if (x16 != null) {
                        x16.setNestedBottomPadding(0);
                    }
                    AIOMsgListGroup.this.avatarHeadTopDistance = 0;
                    edgeTransparentView = AIOMsgListGroup.this.msgAreaView;
                    if (edgeTransparentView != null) {
                        Float[] fArr = new Float[4];
                        for (int i3 = 0; i3 < 4; i3++) {
                            fArr[i3] = Float.valueOf(0.0f);
                        }
                        edgeTransparentView.setPositionAndDrawSize(0, fArr);
                    }
                    AIOMsgListGroup.this.avatarCoincideHeight = 0;
                    AIOMsgListGroup.this.y("removeAvatarAreaView");
                }
            });
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            D(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$removeBackgroundView$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListGroup.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    View view;
                    View view2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    view = AIOMsgListGroup.this.backgroundView;
                    if (view != null) {
                        AIOMsgListGroup aIOMsgListGroup = AIOMsgListGroup.this;
                        view2 = aIOMsgListGroup.backgroundView;
                        aIOMsgListGroup.removeView(view2);
                        AIOMsgListGroup.this.y("removeBackgroundView");
                    }
                    AIOMsgListGroup.this.backgroundView = null;
                }
            });
        }
    }

    @Nullable
    public final <T> T D(@NotNull Function0<? extends T> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (T) iPatchRedirector.redirect((short) 16, (Object) this, (Object) block);
        }
        Intrinsics.checkNotNullParameter(block, "block");
        this.layoutValid = true;
        return block.invoke();
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable final View child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            s(new Function0<Unit>(child) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$addView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $child;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$child = child;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListGroup.this, (Object) child);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*android.widget.FrameLayout*/.addView(this.$child);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) child);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        AIORecycleView i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (!this.debugDraw) {
            return;
        }
        EdgeTransparentView edgeTransparentView = this.msgAreaView;
        if (edgeTransparentView != null) {
            Rect u16 = u();
            u16.top = edgeTransparentView.getTop();
            u16.left = edgeTransparentView.getLeft();
            u16.bottom = edgeTransparentView.getBottom();
            u16.right = 10;
            Unit unit = Unit.INSTANCE;
            Paint t16 = t();
            t16.setColor(SupportMenu.CATEGORY_MASK);
            t16.setStyle(Paint.Style.FILL);
            C(canvas, u16, t16);
            IListUIOperationApi iListUIOperationApi = this.uiHelper;
            if (iListUIOperationApi != null && (i3 = iListUIOperationApi.i()) != null) {
                i3.setBackgroundColor(-12303292);
            }
        }
        View view = this.avatarAreaView;
        if (view != null) {
            Rect u17 = u();
            u17.top = view.getTop();
            u17.left = view.getRight() - 10;
            u17.bottom = view.getBottom();
            u17.right = view.getRight();
            Unit unit2 = Unit.INSTANCE;
            Paint t17 = t();
            t17.setColor(-16711936);
            t17.setStyle(Paint.Style.FILL);
            C(canvas, u17, t17);
            Rect u18 = u();
            u18.top = view.getTop();
            u18.left = view.getLeft();
            u18.right = view.getRight();
            u18.bottom = view.getTop() + this.avatarCoincideHeight;
            Paint t18 = t();
            t18.setColor(-256);
            t18.setStyle(Paint.Style.STROKE);
            C(canvas, u18, t18);
            Rect u19 = u();
            u19.top = view.getTop() + this.avatarCoincideHeight;
            u19.left = view.getLeft();
            u19.right = view.getRight();
            u19.bottom = view.getTop() + this.avatarCoincideHeight + this.avatarHeadTopDistance;
            Paint t19 = t();
            t19.setColor(-16776961);
            t19.setStyle(Paint.Style.STROKE);
            C(canvas, u19, t19);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @CallSuper
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        AIORecycleView v3;
        AIORecycleView v16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
        if (this.avatarAreaView != null && dispatchTouchEvent && ev5.getAction() == 0 && (v3 = v()) != null && ((v3.getScrollState() == 1 || v3.getScrollState() == 2) && (v16 = v()) != null)) {
            v16.stopScroll();
        }
        return dispatchTouchEvent;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        int i3 = right - left;
        int paddingBottom = (bottom - top) - getPaddingBottom();
        View view = this.backgroundView;
        if (view != null) {
            view.layout(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), getPaddingBottom() + paddingBottom);
        }
        View view2 = this.avatarAreaView;
        if (view2 != null) {
            view2.layout(getPaddingLeft(), paddingBottom - view2.getMeasuredHeight(), i3 - getPaddingRight(), paddingBottom);
            paddingBottom = (paddingBottom - view2.getMeasuredHeight()) + this.avatarHeadTopDistance + this.avatarCoincideHeight;
        }
        EdgeTransparentView edgeTransparentView = this.msgAreaView;
        if (edgeTransparentView != null) {
            edgeTransparentView.layout(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), paddingBottom);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        View view = this.backgroundView;
        if (view != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, view, widthMeasureSpec, 0, heightMeasureSpec, 0, getPaddingLeft(), getPaddingRight(), getPaddingTop(), 0, 20, null);
        }
        View view2 = this.avatarAreaView;
        if (view2 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, view2, widthMeasureSpec, 0, heightMeasureSpec, 0, getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom(), 20, null);
            i3 = (view2.getMeasuredHeight() - this.avatarCoincideHeight) - this.avatarHeadTopDistance;
        }
        int i16 = i3;
        EdgeTransparentView edgeTransparentView = this.msgAreaView;
        if (edgeTransparentView != null) {
            try {
                com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, edgeTransparentView, widthMeasureSpec, 0, heightMeasureSpec, i16, getPaddingLeft(), getPaddingRight(), getPaddingTop(), getPaddingBottom(), 4, null);
            } catch (Exception e16) {
                QLog.e("AIOMsgListGroup", 1, "msgAreaView  measure error", e16);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View target, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, this, target, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        AIORecycleView v3 = v();
        if (v3 != null) {
            v3.startNestedScroll(2, 1);
        }
        AIORecycleView v16 = v();
        if (v16 != null) {
            v16.fling(0, (int) velocityY);
        }
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, target, Integer.valueOf(dx5), Integer.valueOf(dy5), consumed, Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        AIORecycleView v3 = v();
        if (v3 != null) {
            v3.startNestedScroll(2, type);
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        AIORecycleView v16 = v();
        Intrinsics.checkNotNull(v16);
        if (v16.dispatchNestedPreScroll(0, dy5, this.mReusableIntPair, this.mScrollOffset, type)) {
            i3 = dy5 - this.mReusableIntPair[1];
            int[] iArr2 = this.mNestedOffsets;
            int i16 = iArr2[0];
            int[] iArr3 = this.mScrollOffset;
            iArr2[0] = i16 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else {
            i3 = dy5;
        }
        AIORecycleView v17 = v();
        Intrinsics.checkNotNull(v17, "null cannot be cast to non-null type androidx.recyclerview.widget.AIORecycleView");
        v17.scrollByInternal(0, i3, null);
        this.listener.invoke(Integer.valueOf(i3));
        consumed[1] = dy5;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NotNull int[] consumed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, target, Integer.valueOf(dxConsumed), Integer.valueOf(dyConsumed), Integer.valueOf(dxUnconsumed), Integer.valueOf(dyUnconsumed), Integer.valueOf(type), consumed);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        z(dyUnconsumed, type, consumed);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int axes, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, child, target, Integer.valueOf(axes), Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, child, target, Integer.valueOf(axes), Integer.valueOf(type))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if ((axes & 2) != 0 && Intrinsics.areEqual(target, this.avatarAreaView)) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View target, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) target, type);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        this.mParentHelper.onStopNestedScroll(target, type);
        AIORecycleView v3 = v();
        if (v3 != null) {
            v3.stopNestedScroll(type);
        }
    }

    public void p(@NotNull final AIOMsgAvatarAreaGroup view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            D(new Function0<Unit>(view) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$addAvatarAreaView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AIOMsgAvatarAreaGroup $view;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$view = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListGroup.this, (Object) view);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AIOMsgListGroup.this.addView(this.$view);
                    AIOMsgListGroup.this.avatarAreaView = this.$view;
                    AIOMsgListGroup.this.y("addAvatarAreaView");
                }
            });
        }
    }

    public void q(@NotNull final View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            D(new Function0<Unit>(view) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$addBackgroundAreaView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $view;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$view = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListGroup.this, (Object) view);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AIOMsgListGroup.this.addView(this.$view, 0);
                    AIOMsgListGroup.this.backgroundView = this.$view;
                    AIOMsgListGroup.this.y("addBackgroundAreaView");
                }
            });
        }
    }

    public void r(@NotNull final View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            D(new Function0<Unit>(view, this) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$addMsgAreaView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $view;
                final /* synthetic */ AIOMsgListGroup this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$view = view;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) view, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Context context = this.$view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "view.context");
                    EdgeTransparentView edgeTransparentView = new EdgeTransparentView(context, null, 0, 6, null);
                    edgeTransparentView.addView(this.$view);
                    this.this$0.addView(edgeTransparentView);
                    this.this$0.msgAreaView = edgeTransparentView;
                    this.this$0.y("addMsgAreaView");
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@Nullable final View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            s(new Function0<Unit>(view) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$removeView$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $view;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$view = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListGroup.this, (Object) view);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*android.widget.FrameLayout*/.removeView(this.$view);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(final int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, index);
        } else {
            s(new Function0<Unit>(index) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$removeViewAt$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $index;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$index = index;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListGroup.this, index);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*android.widget.FrameLayout*/.removeViewAt(this.$index);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Nullable
    public final <T> T s(@NotNull Function0<? extends T> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (T) iPatchRedirector.redirect((short) 17, (Object) this, (Object) block);
        }
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.layoutValid) {
            T invoke = block.invoke();
            this.layoutValid = false;
            return invoke;
        }
        throw new IllegalStateException("do not support method !!");
    }

    public void setAvatarCoincideHeight(int distance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, distance);
            return;
        }
        if (this.avatarCoincideHeight != distance) {
            y("setAvatarCoincideHeight " + distance);
            this.avatarCoincideHeight = distance;
            requestLayout();
        }
    }

    public void setAvatarTransitionHeight(int distance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, distance);
            return;
        }
        if (this.avatarHeadTopDistance != distance) {
            y("setAvatarTopAreaDistance " + distance);
            this.avatarHeadTopDistance = distance;
            IListUIOperationApi iListUIOperationApi = this.uiHelper;
            if (iListUIOperationApi != null) {
                iListUIOperationApi.setNestedBottomPadding(distance);
            }
            Float[] fArr = new Float[4];
            for (int i3 = 0; i3 < 4; i3++) {
                fArr[i3] = Float.valueOf(0.0f);
            }
            fArr[3] = Float.valueOf(distance);
            EdgeTransparentView edgeTransparentView = this.msgAreaView;
            if (edgeTransparentView != null) {
                edgeTransparentView.setPositionAndDrawSize(2, fArr);
            }
            requestLayout();
        }
    }

    public void setDrawDebug(boolean debugDraw) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, debugDraw);
        } else if (this.debugDraw != debugDraw) {
            this.debugDraw = debugDraw;
            invalidate();
        }
    }

    public void setImmersiveArea(int position, @NotNull Float[] drawSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, position, (Object) drawSize);
            return;
        }
        Intrinsics.checkNotNullParameter(drawSize, "drawSize");
        EdgeTransparentView edgeTransparentView = this.msgAreaView;
        if (edgeTransparentView != null) {
            edgeTransparentView.setPositionAndDrawSize(position, drawSize);
        }
    }

    public void setTransparentArea(int top, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(top), Integer.valueOf(bottom));
            return;
        }
        EdgeTransparentView edgeTransparentView = this.msgAreaView;
        if (edgeTransparentView != null) {
            edgeTransparentView.setTransparentSize(top, bottom);
        }
    }

    public final void setUiHelper(@Nullable IListUIOperationApi iListUIOperationApi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iListUIOperationApi);
        } else {
            this.uiHelper = iListUIOperationApi;
        }
    }

    @NotNull
    public Pair<Integer, Integer> w() {
        Pair<Integer, Integer> d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Pair) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        EdgeTransparentView edgeTransparentView = this.msgAreaView;
        if (edgeTransparentView == null || (d16 = edgeTransparentView.d()) == null) {
            return new Pair<>(0, 0);
        }
        return d16;
    }

    @Nullable
    public final IListUIOperationApi x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IListUIOperationApi) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uiHelper;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOMsgListGroup(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull Function1<? super Integer, Unit> listener) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), listener);
            return;
        }
        this.listener = listener;
        this.mParentHelper = new NestedScrollingParentHelper(this);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOMsgListGroup$rect$2.INSTANCE);
        this.rect = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOMsgListGroup$paint$2.INSTANCE);
        this.paint = lazy2;
        this.mReusableIntPair = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable final View child, final int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            s(new Function0<Unit>(child, index) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$addView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $child;
                final /* synthetic */ int $index;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$child = child;
                    this.$index = index;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOMsgListGroup.this, child, Integer.valueOf(index));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*android.widget.FrameLayout*/.addView(this.$child, this.$index);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) child, index);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, target, Integer.valueOf(dxConsumed), Integer.valueOf(dyConsumed), Integer.valueOf(dxUnconsumed), Integer.valueOf(dyUnconsumed), Integer.valueOf(type));
        } else {
            Intrinsics.checkNotNullParameter(target, "target");
            z(dyUnconsumed, type, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(@Nullable final View child, @Nullable final ViewGroup.LayoutParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            s(new Function0<Unit>(child, params) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$addView$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $child;
                final /* synthetic */ ViewGroup.LayoutParams $params;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$child = child;
                    this.$params = params;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOMsgListGroup.this, child, params);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*android.widget.FrameLayout*/.addView(this.$child, this.$params);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) child, (Object) params);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable final View child, final int width, final int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            s(new Function0<Unit>(child, width, height) { // from class: com.tencent.mobileqq.aio.widget.AIOMsgListGroup$addView$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $child;
                final /* synthetic */ int $height;
                final /* synthetic */ int $width;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$child = child;
                    this.$width = width;
                    this.$height = height;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOMsgListGroup.this, child, Integer.valueOf(width), Integer.valueOf(height));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        super/*android.widget.FrameLayout*/.addView(this.$child, this.$width, this.$height);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 8, this, child, Integer.valueOf(width), Integer.valueOf(height));
        }
    }
}
