package com.tencent.aio.widget.bounce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.aio.api.c;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.refreshLoad.HeadFooterViewHolder;
import com.tencent.aio.api.refreshLoad.e;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.RefreshType;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 v2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B3\b\u0007\u0012\u0006\u0010p\u001a\u00020o\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q\u0012\b\b\u0002\u0010s\u001a\u00020\u0005\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010k\u00a2\u0006\u0004\bt\u0010uJ3\u0010\u000b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J(\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016J+\u0010#\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J+\u0010$\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\u0017\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020+H\u0000\u00a2\u0006\u0004\b-\u0010.J\b\u00100\u001a\u00020\u0011H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0018\u00103\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0005H\u0016J\u0010\u00104\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0011H\u0016J\u0010\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\u001fH\u0016J\u0010\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u000209H\u0016J\b\u0010<\u001a\u00020\tH\u0016J\u0018\u0010=\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0014J0\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0014J\u0010\u0010D\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010@\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0005H\u0016J\u0010\u0010K\u001a\u00020\t2\u0006\u0010J\u001a\u00020IH\u0016J\b\u0010L\u001a\u00020\tH\u0016R\u001b\u0010Q\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010YR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u0002090\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010]R\u0016\u0010`\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010_R\u0016\u0010a\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010_R\u0016\u0010b\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010_R\u0016\u0010c\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010_R\u0016\u0010f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u0004\u0018\u00010k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010m\u00a8\u0006w"}, d2 = {"Lcom/tencent/aio/widget/bounce/AIORefreshLayout;", "Lcom/tencent/aio/widget/bounce/AIOBusinessLayout;", "Lcom/tencent/aio/api/list/IBounceScrollApi;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/b;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "detail", "", "complete", "X", Element.ELEMENT_NAME_DISTANCE, "W", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "type", "", "scrollDistance", "U", "widthMeasureSpec", "heightMeasureSpec", "T", "left", "top", "right", "bottom", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl;", "refresher", "setRefresher", "", "enable", "c", "k", "j", h.F, "b", "d", "f", "g", "a", "e", "Landroidx/recyclerview/widget/AIORecycleView;", "view", "setContentView$sdk_debug", "(Landroidx/recyclerview/widget/AIORecycleView;)V", "setContentView", "w", "t", "moveType", "D", "E", "spinnerDistance", HippyTKDListViewAdapter.X, "isAllowOverScroll", "setIsAllowOverScroll", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "listener", BdhLogUtil.LogTag.Tag_Conn, "Y", "onMeasure", "changed", "l", "r", "onLayout", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "setNestedBottomPadding", "dy", "maxDragHeight", "setMaxDragHeight", "Lcom/tencent/aio/api/list/IBounceScrollApi$a;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "setOverScrollStrategy", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "M", "Lkotlin/Lazy;", "V", "()F", "maxFlingDistance", "N", "Landroidx/recyclerview/widget/AIORecycleView;", "child", "P", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl;", "refreshImpl", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "refreshHeadHolder", "loadMoreFootHolder", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Z", "enableRefresh", "enableLoadMore", "isHeadLoading", "isFooterLoading", "a0", "I", "nestBottomPadding", "b0", "c0", "Lcom/tencent/aio/api/list/IBounceScrollApi$a;", "scrollStrategy", "Lcom/tencent/aio/api/refreshLoad/e;", "d0", "Lcom/tencent/aio/api/refreshLoad/e;", "factory", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/aio/api/refreshLoad/e;)V", "e0", "sdk_debug"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class AIORefreshLayout extends AIOBusinessLayout implements IBounceScrollApi, b {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy maxFlingDistance;

    /* renamed from: N, reason: from kotlin metadata */
    private AIORecycleView child;

    /* renamed from: P, reason: from kotlin metadata */
    private AIORefreshImpl refreshImpl;

    /* renamed from: Q, reason: from kotlin metadata */
    private HeadFooterViewHolder refreshHeadHolder;

    /* renamed from: R, reason: from kotlin metadata */
    private HeadFooterViewHolder loadMoreFootHolder;

    /* renamed from: S, reason: from kotlin metadata */
    private CopyOnWriteArraySet<IBounceScrollApi.b> listeners;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean enableRefresh;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean enableLoadMore;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isHeadLoading;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isFooterLoading;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int nestBottomPadding;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int maxDragHeight;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private IBounceScrollApi.a scrollStrategy;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final e factory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/widget/bounce/AIORefreshLayout$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.bounce.AIORefreshLayout$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54186);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public AIORefreshLayout(@NotNull Context context) {
        this(context, null, 0, null, 14, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            return;
        }
        iPatchRedirector.redirect((short) 36, (Object) this, (Object) context);
    }

    private final void Q() {
        HeadFooterViewHolder headFooterViewHolder;
        if (this.loadMoreFootHolder == null && this.enableLoadMore) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "checkRefreshHeadState");
            e eVar = this.factory;
            if (eVar != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                headFooterViewHolder = eVar.a(1, context);
                if (headFooterViewHolder != null) {
                    headFooterViewHolder.a(this);
                    Unit unit = Unit.INSTANCE;
                    this.loadMoreFootHolder = headFooterViewHolder;
                }
            }
            headFooterViewHolder = null;
            this.loadMoreFootHolder = headFooterViewHolder;
        }
    }

    private final void R() {
        HeadFooterViewHolder headFooterViewHolder;
        if (this.refreshHeadHolder == null && this.enableRefresh) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "checkRefreshHeadState");
            e eVar = this.factory;
            if (eVar != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                headFooterViewHolder = eVar.a(0, context);
                if (headFooterViewHolder != null) {
                    headFooterViewHolder.a(this);
                    Unit unit = Unit.INSTANCE;
                    this.refreshHeadHolder = headFooterViewHolder;
                }
            }
            headFooterViewHolder = null;
            this.refreshHeadHolder = headFooterViewHolder;
        }
    }

    private final void S(int left, int top, int right, int bottom) {
        final int paddingTop = getPaddingTop();
        final int paddingBottom = ((bottom - top) - getPaddingBottom()) - this.nestBottomPadding;
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = (right - left) - getPaddingRight();
        AIORefreshImpl aIORefreshImpl = this.refreshImpl;
        if (aIORefreshImpl != null) {
            aIORefreshImpl.s(new Function0<Unit>(paddingLeft, paddingTop, paddingRight) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$defaultLayout$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $layoutLeft;
                final /* synthetic */ int $layoutRight;
                final /* synthetic */ int $layoutTop;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$layoutLeft = paddingLeft;
                    this.$layoutTop = paddingTop;
                    this.$layoutRight = paddingRight;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, AIORefreshLayout.this, Integer.valueOf(paddingLeft), Integer.valueOf(paddingTop), Integer.valueOf(paddingRight));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HeadFooterViewHolder headFooterViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    headFooterViewHolder = AIORefreshLayout.this.refreshHeadHolder;
                    if (headFooterViewHolder != null) {
                        int i3 = this.$layoutLeft;
                        int i16 = -headFooterViewHolder.f();
                        int i17 = this.$layoutTop;
                        headFooterViewHolder.j(i3, i16 + i17, this.$layoutRight, i17);
                    }
                }
            });
        }
        AIORefreshImpl aIORefreshImpl2 = this.refreshImpl;
        if (aIORefreshImpl2 != null) {
            aIORefreshImpl2.r(new Function0<Unit>(paddingLeft, paddingBottom, paddingRight) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$defaultLayout$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $layoutBottom;
                final /* synthetic */ int $layoutLeft;
                final /* synthetic */ int $layoutRight;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$layoutLeft = paddingLeft;
                    this.$layoutBottom = paddingBottom;
                    this.$layoutRight = paddingRight;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, AIORefreshLayout.this, Integer.valueOf(paddingLeft), Integer.valueOf(paddingBottom), Integer.valueOf(paddingRight));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HeadFooterViewHolder headFooterViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    headFooterViewHolder = AIORefreshLayout.this.loadMoreFootHolder;
                    if (headFooterViewHolder != null) {
                        int i3 = this.$layoutLeft;
                        int i16 = this.$layoutBottom;
                        headFooterViewHolder.j(i3, i16, this.$layoutRight, headFooterViewHolder.f() + i16);
                    }
                }
            });
        }
        AIORecycleView aIORecycleView = this.child;
        if (aIORecycleView != null) {
            aIORecycleView.layout(paddingLeft, paddingTop, paddingRight, paddingBottom + this.nestBottomPadding);
        }
    }

    private final void T(final int widthMeasureSpec, final int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        final c cVar = new c(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        cVar.e(this.nestBottomPadding);
        AIORefreshImpl aIORefreshImpl = this.refreshImpl;
        if (aIORefreshImpl != null) {
            aIORefreshImpl.s(new Function0<Unit>(widthMeasureSpec, heightMeasureSpec, cVar) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$defaultMeasure$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $heightMeasureSpec;
                final /* synthetic */ c $padding;
                final /* synthetic */ int $widthMeasureSpec;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$widthMeasureSpec = widthMeasureSpec;
                    this.$heightMeasureSpec = heightMeasureSpec;
                    this.$padding = cVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, AIORefreshLayout.this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec), cVar);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HeadFooterViewHolder headFooterViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    headFooterViewHolder = AIORefreshLayout.this.refreshHeadHolder;
                    if (headFooterViewHolder != null) {
                        headFooterViewHolder.k(this.$widthMeasureSpec, this.$heightMeasureSpec, this.$padding);
                    }
                }
            });
        }
        AIORefreshImpl aIORefreshImpl2 = this.refreshImpl;
        if (aIORefreshImpl2 != null) {
            aIORefreshImpl2.r(new Function0<Unit>(widthMeasureSpec, heightMeasureSpec, cVar) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$defaultMeasure$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $heightMeasureSpec;
                final /* synthetic */ c $padding;
                final /* synthetic */ int $widthMeasureSpec;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$widthMeasureSpec = widthMeasureSpec;
                    this.$heightMeasureSpec = heightMeasureSpec;
                    this.$padding = cVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, AIORefreshLayout.this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec), cVar);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HeadFooterViewHolder headFooterViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    headFooterViewHolder = AIORefreshLayout.this.loadMoreFootHolder;
                    if (headFooterViewHolder != null) {
                        headFooterViewHolder.k(this.$widthMeasureSpec, this.$heightMeasureSpec, this.$padding);
                    }
                }
            });
        }
        AIORecycleView aIORecycleView = this.child;
        if (aIORecycleView != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, aIORecycleView, widthMeasureSpec, 0, heightMeasureSpec, 0, cVar.b(), cVar.c(), cVar.d(), cVar.a(), 20, null);
        }
    }

    private final void U(int type, float distance, int scrollDistance) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((IBounceScrollApi.b) it.next()).a(type, scrollDistance, distance);
        }
    }

    private final float V() {
        return ((Number) this.maxFlingDistance.getValue()).floatValue();
    }

    private final void W(int distance) {
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIORefreshLayout", "holderVisible " + distance);
        }
        if (distance == 0) {
            HeadFooterViewHolder headFooterViewHolder = this.refreshHeadHolder;
            if (headFooterViewHolder != null) {
                headFooterViewHolder.d();
            }
            HeadFooterViewHolder headFooterViewHolder2 = this.loadMoreFootHolder;
            if (headFooterViewHolder2 != null) {
                headFooterViewHolder2.d();
                return;
            }
            return;
        }
        if (distance > 0) {
            R();
            HeadFooterViewHolder headFooterViewHolder3 = this.refreshHeadHolder;
            if (headFooterViewHolder3 != null) {
                headFooterViewHolder3.e();
            }
            HeadFooterViewHolder headFooterViewHolder4 = this.loadMoreFootHolder;
            if (headFooterViewHolder4 != null) {
                headFooterViewHolder4.d();
                return;
            }
            return;
        }
        Q();
        HeadFooterViewHolder headFooterViewHolder5 = this.refreshHeadHolder;
        if (headFooterViewHolder5 != null) {
            headFooterViewHolder5.d();
        }
        HeadFooterViewHolder headFooterViewHolder6 = this.loadMoreFootHolder;
        if (headFooterViewHolder6 != null) {
            headFooterViewHolder6.e();
        }
    }

    private final void X(Function1<? super Integer, Unit> complete, int detail) {
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "innerCloseState " + u());
        if (u()) {
            AIORecycleView aIORecycleView = this.child;
            if (!(aIORecycleView instanceof RecyclerView)) {
                aIORecycleView = null;
            }
            if (aIORecycleView != null) {
                aIORecycleView.stopScroll();
                aIORecycleView.stopNestedScroll();
                aIORecycleView.stopNestedScroll(1);
            }
            y();
            complete.invoke(Integer.valueOf(detail));
            return;
        }
        y();
        complete.invoke(Integer.valueOf(detail));
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void C(@NotNull IBounceScrollApi.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listeners.add(listener);
        }
    }

    @Override // com.tencent.aio.widget.bounce.AIOBounceLayout
    public void D(float distance, int moveType) {
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(distance), Integer.valueOf(moveType));
            return;
        }
        com.tencent.aio.base.a aVar = com.tencent.aio.base.a.f69150c;
        if (aVar.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIORefreshLayout", "onMoveDistance " + distance);
        }
        int scrollY = getScrollY();
        if (aVar.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIORefreshLayout", "onMoveDistance " + distance + "   origiDistance  " + (-scrollY) + TokenParser.SP);
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(distance);
        W(roundToInt);
        U(moveType, distance, (int) (scrollY + distance));
        AIORefreshImpl aIORefreshImpl = this.refreshImpl;
        if (aIORefreshImpl != null) {
            aIORefreshImpl.t(distance);
        }
    }

    @Override // com.tencent.aio.widget.bounce.AIOBounceLayout
    public void E(final float distance) {
        AIORefreshImpl aIORefreshImpl;
        AIORefreshImpl aIORefreshImpl2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(distance));
            return;
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIORefreshLayout", "onMoveEnd " + distance);
        }
        this.isHeadLoading = false;
        this.isFooterLoading = false;
        float f16 = 0;
        if (distance > f16 && (aIORefreshImpl2 = this.refreshImpl) != null) {
            aIORefreshImpl2.s(new Function0<Unit>(distance) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$onMoveEnd$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ float $distance;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$distance = distance;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, AIORefreshLayout.this, Float.valueOf(distance));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HeadFooterViewHolder headFooterViewHolder;
                    AIORefreshImpl aIORefreshImpl3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    headFooterViewHolder = AIORefreshLayout.this.refreshHeadHolder;
                    if (headFooterViewHolder == null || Math.abs(this.$distance) < headFooterViewHolder.f()) {
                        return;
                    }
                    AIORefreshLayout.this.isHeadLoading = true;
                    aIORefreshImpl3 = AIORefreshLayout.this.refreshImpl;
                    if (aIORefreshImpl3 != null) {
                        aIORefreshImpl3.v(RefreshType.LoadingRefresh);
                    }
                }
            });
        }
        if (distance < f16 && (aIORefreshImpl = this.refreshImpl) != null) {
            aIORefreshImpl.r(new Function0<Unit>(distance) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$onMoveEnd$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ float $distance;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$distance = distance;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, AIORefreshLayout.this, Float.valueOf(distance));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HeadFooterViewHolder headFooterViewHolder;
                    AIORefreshImpl aIORefreshImpl3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    headFooterViewHolder = AIORefreshLayout.this.loadMoreFootHolder;
                    if (headFooterViewHolder == null || Math.abs(this.$distance) < headFooterViewHolder.f()) {
                        return;
                    }
                    AIORefreshLayout.this.isFooterLoading = true;
                    aIORefreshImpl3 = AIORefreshLayout.this.refreshImpl;
                    if (aIORefreshImpl3 != null) {
                        aIORefreshImpl3.u(RefreshType.LoadingLoadMore);
                    }
                }
            });
        }
        AIORefreshImpl aIORefreshImpl3 = this.refreshImpl;
        if (aIORefreshImpl3 != null) {
            aIORefreshImpl3.M();
        }
    }

    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "resetBounceLayout ");
        }
        scrollTo(0, 0);
        y();
        this.isHeadLoading = false;
        this.isFooterLoading = false;
        this.scrollStrategy = null;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        HeadFooterViewHolder headFooterViewHolder = this.refreshHeadHolder;
        if (headFooterViewHolder != null) {
            return headFooterViewHolder.h();
        }
        return false;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        HeadFooterViewHolder headFooterViewHolder = this.refreshHeadHolder;
        if (headFooterViewHolder != null) {
            return headFooterViewHolder.f();
        }
        return 0;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public void c(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, enable);
            return;
        }
        if (this.enableRefresh == enable) {
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "enableRefresh " + enable);
        this.enableRefresh = enable;
        if (!enable) {
            HeadFooterViewHolder headFooterViewHolder = this.refreshHeadHolder;
            if (headFooterViewHolder != null) {
                headFooterViewHolder.c(this);
            }
            this.isHeadLoading = false;
            return;
        }
        HeadFooterViewHolder headFooterViewHolder2 = this.refreshHeadHolder;
        if (headFooterViewHolder2 != null) {
            headFooterViewHolder2.a(this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        HeadFooterViewHolder headFooterViewHolder = this.loadMoreFootHolder;
        if (headFooterViewHolder != null) {
            return headFooterViewHolder.f();
        }
        return 0;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        HeadFooterViewHolder headFooterViewHolder = this.loadMoreFootHolder;
        if (headFooterViewHolder != null) {
            return headFooterViewHolder.h();
        }
        return false;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isHeadLoading;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isFooterLoading;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public void h(@NotNull Function1<? super Integer, Unit> complete) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) complete);
            return;
        }
        Intrinsics.checkNotNullParameter(complete, "complete");
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "closeFooterLayout " + v() + "  mNestedInProgress " + u());
        X(complete, (int) v());
        this.isFooterLoading = false;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public void j(@NotNull Function1<? super Integer, Unit> complete) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) complete);
            return;
        }
        Intrinsics.checkNotNullParameter(complete, "complete");
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "closeHeadLayout " + v() + "  mNestedInProgress " + u());
        X(complete, (int) v());
        this.isHeadLoading = false;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public void k(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, enable);
            return;
        }
        if (this.enableLoadMore == enable) {
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshLayout", "enableLoadMore " + enable);
        this.enableLoadMore = enable;
        if (!enable) {
            this.isFooterLoading = false;
            HeadFooterViewHolder headFooterViewHolder = this.loadMoreFootHolder;
            if (headFooterViewHolder != null) {
                headFooterViewHolder.c(this);
                return;
            }
            return;
        }
        HeadFooterViewHolder headFooterViewHolder2 = this.loadMoreFootHolder;
        if (headFooterViewHolder2 != null) {
            headFooterViewHolder2.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aio.widget.bounce.AIOBusinessLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(changed), Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16));
            return;
        }
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            S(l3, t16, r16, b16);
        } else {
            aVar.b("AIORefreshLayoutonLayout");
            String str = "AIO#AIORefreshLayoutonLayout";
            if (!aVar.h()) {
                S(l3, t16, r16, b16);
                Unit unit = Unit.INSTANCE;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                S(l3, t16, r16, b16);
                Unit unit2 = Unit.INSTANCE;
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        super.onLayout(changed, l3, t16, r16, b16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aio.widget.bounce.AIOBusinessLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            T(widthMeasureSpec, heightMeasureSpec);
        } else {
            aVar.b("AIORefreshLayoutonMeasure");
            String str = "AIO#AIORefreshLayoutonMeasure";
            if (!aVar.h()) {
                T(widthMeasureSpec, heightMeasureSpec);
                Unit unit = Unit.INSTANCE;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                T(widthMeasureSpec, heightMeasureSpec);
                Unit unit2 = Unit.INSTANCE;
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // com.tencent.aio.widget.bounce.AIOBounceLayout, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        AIORecycleView aIORecycleView = this.child;
        if (aIORecycleView != null) {
            return aIORecycleView.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            this.scrollStrategy = null;
        }
    }

    @Override // com.tencent.aio.widget.bounce.AIOBounceLayout
    public boolean r(int dy5, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, this, Integer.valueOf(dy5), Integer.valueOf(type))).booleanValue();
        }
        IBounceScrollApi.a aVar = this.scrollStrategy;
        if (aVar == null) {
            return false;
        }
        return aVar.a(dy5, type);
    }

    public final void setContentView$sdk_debug(@NotNull AIORecycleView view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        this.child = view;
        addViewInLayout(view, 0, new FrameLayout.LayoutParams(new FrameLayout.LayoutParams(-1, -1)));
    }

    public void setIsAllowOverScroll(boolean isAllowOverScroll) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, isAllowOverScroll);
        } else {
            H(isAllowOverScroll);
        }
    }

    public void setMaxDragHeight(int maxDragHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, maxDragHeight);
        } else {
            this.maxDragHeight = maxDragHeight;
        }
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void setNestedBottomPadding(int distance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, distance);
            return;
        }
        com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b).d("AIORefreshLayout", "setNestedBottomPadding " + distance + "  original " + this.nestBottomPadding);
        if (this.nestBottomPadding != distance) {
            this.nestBottomPadding = distance;
            AIORecycleView aIORecycleView = this.child;
            if (aIORecycleView != null) {
                aIORecycleView.setPadding(aIORecycleView.getPaddingLeft(), aIORecycleView.getPaddingTop(), aIORecycleView.getPaddingRight(), this.nestBottomPadding);
                if (this.nestBottomPadding != 0) {
                    aIORecycleView.setClipToPadding(false);
                }
            }
            requestLayout();
        }
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void setOverScrollStrategy(@NotNull IBounceScrollApi.a strategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) strategy);
        } else {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.scrollStrategy = strategy;
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.b
    public void setRefresher(@NotNull AIORefreshImpl refresher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) refresher);
        } else {
            Intrinsics.checkNotNullParameter(refresher, "refresher");
            this.refreshImpl = refresher;
        }
    }

    @Override // com.tencent.aio.widget.bounce.AIOBounceLayout
    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.maxDragHeight;
    }

    @Override // com.tencent.aio.widget.bounce.AIOBounceLayout
    public float w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        return V();
    }

    @Override // com.tencent.aio.widget.bounce.AIOBounceLayout
    public float x(final float spinnerDistance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Float) iPatchRedirector.redirect((short) 19, this, Float.valueOf(spinnerDistance))).floatValue();
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        if (spinnerDistance > 0) {
            AIORefreshImpl aIORefreshImpl = this.refreshImpl;
            if (aIORefreshImpl != null) {
                aIORefreshImpl.s(new Function0<Unit>(spinnerDistance, intRef) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$getOverEndSpinner$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.IntRef $endSpinner;
                    final /* synthetic */ float $spinnerDistance;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$spinnerDistance = spinnerDistance;
                        this.$endSpinner = intRef;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, AIORefreshLayout.this, Float.valueOf(spinnerDistance), intRef);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        HeadFooterViewHolder headFooterViewHolder;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this);
                            return;
                        }
                        headFooterViewHolder = AIORefreshLayout.this.refreshHeadHolder;
                        if (headFooterViewHolder == null || this.$spinnerDistance < headFooterViewHolder.f()) {
                            return;
                        }
                        this.$endSpinner.element = headFooterViewHolder.f();
                    }
                });
            }
        } else {
            AIORefreshImpl aIORefreshImpl2 = this.refreshImpl;
            if (aIORefreshImpl2 != null) {
                aIORefreshImpl2.r(new Function0<Unit>(spinnerDistance, intRef) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$getOverEndSpinner$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Ref.IntRef $endSpinner;
                    final /* synthetic */ float $spinnerDistance;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$spinnerDistance = spinnerDistance;
                        this.$endSpinner = intRef;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, AIORefreshLayout.this, Float.valueOf(spinnerDistance), intRef);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        HeadFooterViewHolder headFooterViewHolder;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this);
                            return;
                        }
                        headFooterViewHolder = AIORefreshLayout.this.loadMoreFootHolder;
                        if (headFooterViewHolder == null || Math.abs(this.$spinnerDistance) < headFooterViewHolder.f()) {
                            return;
                        }
                        this.$endSpinner.element = -headFooterViewHolder.f();
                    }
                });
            }
        }
        return intRef.element;
    }

    @JvmOverloads
    public AIORefreshLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            return;
        }
        iPatchRedirector.redirect((short) 35, (Object) this, (Object) context, (Object) attributeSet);
    }

    @JvmOverloads
    public AIORefreshLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            return;
        }
        iPatchRedirector.redirect((short) 34, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ AIORefreshLayout(Context context, AttributeSet attributeSet, int i3, e eVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) == 0 ? eVar : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            return;
        }
        iPatchRedirector.redirect((short) 33, this, context, attributeSet, Integer.valueOf(i3), eVar, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIORefreshLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3, @Nullable e eVar) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, context, attributeSet, Integer.valueOf(i3), eVar);
            return;
        }
        this.factory = eVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>(context) { // from class: com.tencent.aio.widget.bounce.AIORefreshLayout$maxFlingDistance$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final float invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return ((Float) iPatchRedirector2.redirect((short) 1, (Object) this)).floatValue();
                }
                Intrinsics.checkNotNullExpressionValue(this.$context.getResources(), "context.resources");
                return r0.getDisplayMetrics().heightPixels / 10.0f;
            }
        });
        this.maxFlingDistance = lazy;
        this.listeners = new CopyOnWriteArraySet<>();
        this.maxDragHeight = 250;
    }
}
