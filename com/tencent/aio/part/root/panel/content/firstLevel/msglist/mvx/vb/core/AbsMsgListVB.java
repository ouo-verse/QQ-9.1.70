package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.AIOBaseRecyclePool;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.IViewHolderDiscard;
import androidx.recyclerview.widget.RecyclerView;
import at.b;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.f;
import com.tencent.aio.api.list.g;
import com.tencent.aio.api.list.j;
import com.tencent.aio.api.list.k;
import com.tencent.aio.api.list.n;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.data.msglist.a;
import com.tencent.aio.monitor.trace.TraceTimeReport;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListUIOperationApiImpl;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.pool.AIORecyclePool;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.aio.widget.bounce.AIORefreshLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u0000 \u0096\u0001*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u00020\u00062\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u00020\b2\u00020\t:\u0004\u0097\u0001\u0098\u0001B\t\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\f\u0010\u0010\u001a\u00020\r*\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011J*\u0010\u001c\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u0019\u0012\u0006\b\u0001\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00180\u00172\u0006\u0010\u0016\u001a\u00020\u0015J\u000f\u0010\u001e\u001a\u00020\u001dH\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 J\u0010\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0017J,\u0010.\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+J\u0016\u00102\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020'J\u0006\u00103\u001a\u00020\rJ\u0017\u00105\u001a\u00020\r2\u0006\u00104\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b5\u00106J\b\u00107\u001a\u00020\rH\u0016J\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u000108J\"\u0010<\u001a\u00020\r2\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001b\u0018\u00010:J#\u0010>\u001a\u00020\r2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000108H\u0010\u00a2\u0006\u0004\b>\u0010?J\u000e\u0010B\u001a\u00020\r2\u0006\u0010A\u001a\u00020@J\u0006\u0010C\u001a\u00020@J\b\u0010D\u001a\u00020\nH\u0016J\u001b\u0010F\u001a\u00020E2\u0006\u00101\u001a\u00020'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\u0011\u0010I\u001a\u0004\u0018\u00010HH\u0000\u00a2\u0006\u0004\bI\u0010JJ\u0012\u0010L\u001a\u00020\r2\b\u0010K\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010N\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u000fH\u0016R(\u0010S\u001a\u0014\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0P0O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010Y\u001a\u0004\b_\u0010`R\u001d\u0010f\u001a\u0004\u0018\u00010b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010Y\u001a\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001d\u0010r\u001a\u0004\u0018\u00010n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010Y\u001a\u0004\bp\u0010qR\u001b\u0010w\u001a\u00020s8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010Y\u001a\u0004\bu\u0010vR\"\u0010\u007f\u001a\u00020x8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R*\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0000@\u0000X\u0080.\u00a2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\"\u0010\u008b\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001e\u0010\u0012\u001a\u00030\u008c\u00018@X\u0080\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u0002\u0010Y\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0093\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0090\u0001\u0010Y\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0099\u0001"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/a;", "Let/a;", "Lcom/tencent/aio/api/list/j;", "Landroidx/recyclerview/widget/IViewHolderDiscard;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/c;", "", "isPreload", "f1", "", "z1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/holder/a;", "y1", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/aio/api/list/n;", "v1", "Landroid/view/View;", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/a;", "initializeChildVB", "Lkotlinx/coroutines/CoroutineScope;", "h1", "()Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "vh", "", "position", "Lcom/tencent/aio/data/msglist/a;", "data", "", "", "payloads", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "R0", "bindViewAndData", "state", "u1", "(Lcom/tencent/aio/base/mvi/part/MsgListUiState;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/b;", "g1", "Lcom/tencent/mvi/mvvm/BaseVM;", "mUIModel", "afterCreateVM", "vm", "e1", "(Lcom/tencent/aio/base/mvvm/b;)V", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "update", "C1", ICustomDataEditor.STRING_PARAM_1, "w1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "x1", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "m1", "()Ljava/lang/Long;", "scrap", "onViewHolderDiscard", "viewHolder", "U", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", Node.CHILDREN_ATTR, "e", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "updateFocusIndex", "Lcom/tencent/aio/api/factory/j;", "f", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_1, "()Lcom/tencent/aio/api/factory/j;", "msgAdornApi", "Lcom/tencent/aio/api/list/f;", h.F, "l1", "()Lcom/tencent/aio/api/list/f;", "cellFactory", "Lcom/tencent/aio/api/refreshLoad/e;", "i", "r1", "()Lcom/tencent/aio/api/refreshLoad/e;", "refreshLoadFactory", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollDispatcher", "Lcom/tencent/aio/api/list/k;", "D", "p1", "()Lcom/tencent/aio/api/list/k;", "recycleViewPoolProvider", "Lcom/tencent/aio/widget/bounce/AIORefreshLayout;", "E", "k1", "()Lcom/tencent/aio/widget/bounce/AIORefreshLayout;", "bounceGroup", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "j1", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "B1", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;)V", "aioAdapter", "Lcom/tencent/aio/api/list/d;", "G", "Lcom/tencent/aio/api/list/d;", "i1", "()Lcom/tencent/aio/api/list/d;", "A1", "(Lcom/tencent/aio/api/list/d;)V", "adapterNotifyImpl", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/impl/a;", "H", "Ljava/lang/ref/WeakReference;", "vMImpl", "Landroidx/recyclerview/widget/AIORecycleView;", "q1", "()Landroidx/recyclerview/widget/AIORecycleView;", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "J", "o1", "()Lcom/tencent/aio/api/list/IListUIOperationApi;", "operationHelper", "<init>", "()V", "K", "a", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes3.dex */
public abstract class AbsMsgListVB<I extends at.b, S extends MsgListUiState> extends com.tencent.aio.base.mvvm.a<I, S> implements et.a, j<I, S>, IViewHolderDiscard, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.c {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView.OnScrollListener scrollDispatcher;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy recycleViewPoolProvider;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy bounceGroup;

    /* renamed from: F, reason: from kotlin metadata */
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aioAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    public com.tencent.aio.api.list.d adapterNotifyImpl;

    /* renamed from: H, reason: from kotlin metadata */
    private WeakReference<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a> vMImpl;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy recyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy operationHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<Integer, WeakReference<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a>> children;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b updateFocusIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy msgAdornApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy cellFactory;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy refreshLoadFactory;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CoroutineScope scope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$c", "Lcom/tencent/aio/api/list/n;", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class c implements n {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a f69576a;

        c(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar) {
            this.f69576a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.aio.api.list.n
        public void a(@NotNull List<? extends com.tencent.aio.data.msglist.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            } else {
                Intrinsics.checkNotNullParameter(list, "list");
                this.f69576a.j0().n(new g.b<>(list, null, true, null, 8, null));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47167);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AbsMsgListVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        this.children = new ConcurrentHashMap<>();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.aio.api.factory.j>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$msgAdornApi$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.factory.j invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (com.tencent.aio.api.factory.j) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                com.tencent.mvi.runtime.strategy.b mStrategyService = AbsMsgListVB.this.getMStrategyService();
                Intrinsics.checkNotNull(mStrategyService);
                Object b16 = mStrategyService.b(com.tencent.aio.api.factory.j.class);
                Intrinsics.checkNotNull(b16);
                return (com.tencent.aio.api.factory.j) b16;
            }
        });
        this.msgAdornApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<f>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$cellFactory$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final f invoke() {
                com.tencent.aio.api.factory.j n16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (f) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                n16 = AbsMsgListVB.this.n1();
                return n16.b();
            }
        });
        this.cellFactory = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.aio.api.refreshLoad.e>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$refreshLoadFactory$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.aio.api.refreshLoad.e invoke() {
                com.tencent.aio.api.factory.j n16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (com.tencent.aio.api.refreshLoad.e) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                n16 = AbsMsgListVB.this.n1();
                return n16.f();
            }
        });
        this.refreshLoadFactory = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<k>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$recycleViewPoolProvider$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final k invoke() {
                f l16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (k) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                l16 = AbsMsgListVB.this.l1();
                return l16.c();
            }
        });
        this.recycleViewPoolProvider = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AIORefreshLayout>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$bounceGroup$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIORefreshLayout invoke() {
                com.tencent.aio.api.refreshLoad.e r16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (AIORefreshLayout) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                Context mContext = AbsMsgListVB.this.getMContext();
                r16 = AbsMsgListVB.this.r1();
                AIORefreshLayout aIORefreshLayout = new AIORefreshLayout(mContext, null, 0, r16, 6, null);
                aIORefreshLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(AbsMsgListVB.this.getMContext(), -1, -1));
                aIORefreshLayout.setContentView$sdk_debug(AbsMsgListVB.this.q1());
                return aIORefreshLayout;
            }
        });
        this.bounceGroup = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new AbsMsgListVB$recyclerView$2(this));
        this.recyclerView = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ListUIOperationApiImpl>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$operationHelper$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ListUIOperationApiImpl invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new ListUIOperationApiImpl(AbsMsgListVB.this) : (ListUIOperationApiImpl) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.operationHelper = lazy7;
    }

    private final boolean f1(boolean isPreload) {
        final RecyclerView.RecycledViewPool recycledViewPool;
        Object b16 = getMStrategyService().b(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b.class);
        Intrinsics.checkNotNull(b16);
        Fragment a16 = ((com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.b) b16).a();
        k p16 = p1();
        if (p16 != null) {
            Context context = q1().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
            recycledViewPool = p16.b(context, a16);
        } else {
            recycledViewPool = null;
        }
        if (recycledViewPool instanceof AIORecyclePool) {
            AIORecyclePool aIORecyclePool = (AIORecyclePool) recycledViewPool;
            aIORecyclePool.setViewHolderDiscardCallBack$sdk_debug(null);
            q1().setRecycledViewPool(recycledViewPool);
            aIORecyclePool.setViewHolderDiscardCallBack$sdk_debug(this);
            if (isPreload) {
                if (!AIOBaseRecyclePool.access$isPreLoad$p(aIORecyclePool)) {
                    com.tencent.aio.base.log.a.f69187b.d("AbsMsgListVB", "preLoadViewHolder");
                    k p17 = p1();
                    if (p17 != null) {
                        p17.a(recycledViewPool, q1(), h1());
                    }
                    AIOBaseRecyclePool.access$setPreLoad$p(aIORecyclePool, true);
                }
                if (com.tencent.aio.base.a.f69150c.b()) {
                    new Handler().postDelayed(new Runnable(recycledViewPool) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$checkSetBusinessRecycleViewPool$$inlined$withDevelop$lambda$1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ RecyclerView.RecycledViewPool f69575d;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f69575d = recycledViewPool;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsMsgListVB.this, (Object) recycledViewPool);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AbsMsgListVB", AbsMsgListVB.this.hashCode() + "--preload----");
                            ((AIORecyclePool) this.f69575d).output();
                        }
                    }, 2000L);
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f l1() {
        return (f) this.cellFactory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.api.factory.j n1() {
        return (com.tencent.aio.api.factory.j) this.msgAdornApi.getValue();
    }

    private final IListUIOperationApi o1() {
        return (IListUIOperationApi) this.operationHelper.getValue();
    }

    private final k p1() {
        return (k) this.recycleViewPoolProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.api.refreshLoad.e r1() {
        return (com.tencent.aio.api.refreshLoad.e) this.refreshLoadFactory.getValue();
    }

    private final void y1(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar) {
        int hashCode = aVar.hashCode();
        if (this.children.containsKey(Integer.valueOf(hashCode))) {
            aVar.m().destroy();
            this.children.remove(Integer.valueOf(hashCode));
            aVar.p(null);
        }
    }

    private final void z1() {
        com.tencent.aio.base.log.a.f69187b.d("AbsMsgListVB", "releaseCellVb " + this.children.size());
        Collection<WeakReference<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a>> values = this.children.values();
        Intrinsics.checkNotNullExpressionValue(values, "children.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                y1(aVar);
            }
        }
        this.children.clear();
    }

    public final void A1(@NotNull com.tencent.aio.api.list.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.adapterNotifyImpl = dVar;
        }
    }

    public final void B1(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.aioAdapter = aVar;
        }
    }

    public final void C1(@NotNull b update) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) update);
        } else {
            Intrinsics.checkNotNullParameter(update, "update");
            this.updateFocusIndex = update;
        }
    }

    @Override // et.a
    @NotNull
    public final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a R0(@NotNull ViewGroup parent, int viewType) {
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onCreateViewHolder");
        a.Companion companion = com.tencent.aio.data.msglist.a.INSTANCE;
        sb5.append(com.tencent.aio.base.b.d(companion, viewType));
        sb5.append("-subViewType-");
        sb5.append(com.tencent.aio.base.b.c(companion, viewType));
        String sb6 = sb5.toString();
        com.tencent.aio.pref.a aVar2 = com.tencent.aio.pref.a.f69788j;
        if (!aVar2.g()) {
            com.tencent.aio.api.list.a<?, ?> a16 = com.tencent.aio.base.b.a(l1(), parent, viewType);
            a16.buildViewTree(getMContext(), parent, getMStrategyService());
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar3 = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a(a16);
            aVar3.p(this);
            this.children.put(Integer.valueOf(aVar3.hashCode()), new WeakReference<>(aVar3));
            return aVar3;
        }
        aVar2.b(sb6);
        String str = "AIO#" + sb6;
        if (!aVar2.h()) {
            com.tencent.aio.api.list.a<?, ?> a17 = com.tencent.aio.base.b.a(l1(), parent, viewType);
            a17.buildViewTree(getMContext(), parent, getMStrategyService());
            aVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a(a17);
            aVar.p(this);
            this.children.put(Integer.valueOf(aVar.hashCode()), new WeakReference<>(aVar));
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.aio.api.list.a<?, ?> a18 = com.tencent.aio.base.b.a(l1(), parent, viewType);
            a18.buildViewTree(getMContext(), parent, getMStrategyService());
            aVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a(a18);
            aVar.p(this);
            this.children.put(Integer.valueOf(aVar.hashCode()), new WeakReference<>(aVar));
            Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
        }
        aVar2.e();
        return aVar;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.c
    public void U(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) viewHolder);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b).d("AbsMsgListVB", "onViewRecycled " + viewHolder);
        y1(viewHolder);
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public final void afterCreateVM(@Nullable BaseVM<I, S, com.tencent.aio.api.runtime.a> mUIModel) {
        LifecycleOwner d16;
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        com.tencent.aio.api.runtime.a mAIOContext$sdk_debug = getMAIOContext$sdk_debug();
        if (mAIOContext$sdk_debug != null && (d16 = mAIOContext$sdk_debug.d()) != null && (lifecycle = d16.getLifecycle()) != null) {
            IListUIOperationApi o16 = o1();
            if (o16 != null) {
                lifecycle.addObserver((ListUIOperationApiImpl) o16);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListUIOperationApiImpl");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public final void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.bindViewAndData();
        com.tencent.aio.base.log.a.f69187b.d("AbsMsgListVB", hashCode() + " bindViewAndData ");
        com.tencent.aio.api.runtime.a mAIOContext$sdk_debug = getMAIOContext$sdk_debug();
        Intrinsics.checkNotNull(mAIOContext$sdk_debug);
        this.scrollDispatcher = new e(mAIOContext$sdk_debug);
        AIORecycleView q16 = q1();
        RecyclerView.OnScrollListener onScrollListener = this.scrollDispatcher;
        Intrinsics.checkNotNull(onScrollListener);
        q16.addOnScrollListener(onScrollListener);
        S0();
    }

    public void e1(@NotNull com.tencent.aio.base.mvvm.b<I, S> vm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) vm5);
        } else {
            Intrinsics.checkNotNullParameter(vm5, "vm");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public final com.tencent.aio.base.mvvm.b<I, S> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        com.tencent.aio.base.mvvm.b<I, S> F0 = F0();
        if (F0 instanceof MsgListVMWrapper) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a aVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a();
            this.vMImpl = new WeakReference<>(aVar);
            Unit unit = Unit.INSTANCE;
            ((MsgListVMWrapper) F0).C(aVar);
        }
        e1(F0);
        return F0;
    }

    @NotNull
    public final CoroutineScope h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.scope == null) {
            this.scope = CoroutineScopeKt.MainScope();
        }
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @NotNull
    public final com.tencent.aio.api.list.d i1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.list.d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.aio.api.list.d dVar = this.adapterNotifyImpl;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterNotifyImpl");
        }
        return dVar;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public final List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> initializeChildVB(@NotNull View hostView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return super.initializeChildVB(hostView);
    }

    @NotNull
    public final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a j1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar = this.aioAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioAdapter");
        }
        return aVar;
    }

    @NotNull
    public final AIORefreshLayout k1() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            value = iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            value = this.bounceGroup.getValue();
        }
        return (AIORefreshLayout) value;
    }

    @Nullable
    public final Long m1() {
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Long) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        WeakReference<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a> weakReference = this.vMImpl;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return Long.valueOf(aVar.B());
        }
        return null;
    }

    @Override // et.a
    public final void o(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a vh5, int position, @NotNull com.tencent.aio.data.msglist.a data, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, vh5, Integer.valueOf(position), data, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(vh5, "vh");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (vh5.m() != null && getMAIOContext$sdk_debug() != null) {
            if (vh5.m().getMUIModel() == null) {
                com.tencent.aio.base.mvvm.a<?, ?> m3 = vh5.m();
                com.tencent.aio.api.runtime.a mAIOContext$sdk_debug = getMAIOContext$sdk_debug();
                Intrinsics.checkNotNull(mAIOContext$sdk_debug);
                m3.buildVM(mAIOContext$sdk_debug);
            } else {
                FrameworkVM mUIModel = vh5.m().getMUIModel();
                if (mUIModel != null) {
                    com.tencent.aio.api.list.b bVar = (com.tencent.aio.api.list.b) mUIModel;
                    com.tencent.aio.api.runtime.a mAIOContext$sdk_debug2 = getMAIOContext$sdk_debug();
                    Intrinsics.checkNotNull(mAIOContext$sdk_debug2);
                    bVar.attach(mAIOContext$sdk_debug2);
                    bVar.create();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.api.list.BaseMessageCellVM<out com.tencent.mvi.base.mvi.MviIntent, out com.tencent.mvi.base.mvi.MviUIState>");
                }
            }
            FrameworkVM mUIModel2 = vh5.m().getMUIModel();
            if (!(mUIModel2 instanceof com.tencent.aio.api.list.b)) {
                mUIModel2 = null;
            }
            com.tencent.aio.api.list.b bVar2 = (com.tencent.aio.api.list.b) mUIModel2;
            if (bVar2 != null) {
                int viewType = data.getViewType();
                String str = "BVH-" + viewType + "-subViewType-" + data.getSubViewType(viewType);
                TraceTimeReport traceTimeReport = TraceTimeReport.f69439e;
                traceTimeReport.f("AbsMsgListVB", str);
                String str2 = "onBindViewHolder" + viewType + "-subViewType-" + data.getSubViewType(viewType);
                com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
                if (!aVar.g()) {
                    bVar2.j(data, position, payloads);
                } else {
                    aVar.b(str2);
                    String str3 = "AIO#" + str2;
                    if (!aVar.h()) {
                        bVar2.j(data, position, payloads);
                        Unit unit = Unit.INSTANCE;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        bVar2.j(data, position, payloads);
                        Unit unit2 = Unit.INSTANCE;
                        Log.w("AIO#", str3 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    aVar.e();
                }
                traceTimeReport.c("AbsMsgListVB", str);
            }
            if (this.children.containsKey(Integer.valueOf(vh5.hashCode()))) {
                return;
            }
            vh5.p(this);
            this.children.put(Integer.valueOf(vh5.hashCode()), new WeakReference<>(vh5));
            return;
        }
        com.tencent.aio.base.log.a.f69187b.e("AbsMsgListVB", "illegal parameter in onBindViewHolder vh-> " + vh5 + " mAIOContext " + getMAIOContext$sdk_debug());
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public final View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        RecyclerView.RecycledViewPool recycledViewPool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ViewParent parent = k1().getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(k1());
        }
        View T0 = T0(createViewParams, k1(), o1());
        if (f1(isPreload())) {
            return T0;
        }
        if (isPreload()) {
            if (w1()) {
                com.tencent.aio.base.log.a.f69187b.i("AbsMsgListVB", "recyclerview use global cache, isPreload: " + isPreload());
                recycledViewPool = a.f69578b.a(l1().b(), e(), new Function1<RecyclerView.RecycledViewPool, Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$onCreateView$$inlined$also$lambda$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsMsgListVB.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.RecycledViewPool recycledViewPool2) {
                        invoke2(recycledViewPool2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RecyclerView.RecycledViewPool pool) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pool);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(pool, "pool");
                        Iterator<T> it = AbsMsgListVB.this.h().iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            int intValue = ((Number) pair.getSecond()).intValue();
                            for (int i3 = 0; i3 < intValue; i3++) {
                                pool.putRecycledView(AbsMsgListVB.this.j1().createViewHolder(AbsMsgListVB.this.q1(), ((Number) pair.getFirst()).intValue()));
                            }
                        }
                    }
                });
            } else {
                com.tencent.aio.base.log.a.f69187b.i("AbsMsgListVB", "recyclerview use new cache, isPreload: " + isPreload());
                recycledViewPool = new RecyclerView.RecycledViewPool();
                Iterator<T> it = e().iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    recycledViewPool.setMaxRecycledViews(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
                }
                if (isPreload()) {
                    BuildersKt__Builders_commonKt.launch$default(h1(), Dispatchers.getIO(), null, new AbsMsgListVB$onCreateView$$inlined$also$lambda$2(recycledViewPool, null, this), 2, null);
                }
            }
            q1().setRecycledViewPool(recycledViewPool);
        }
        return T0;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        aVar.d("AbsMsgListVB", hashCode() + " onDestroy");
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.scope = null;
        z1();
        RecyclerView.RecycledViewPool recycledViewPool = q1().getRecycledViewPool();
        if (!(recycledViewPool instanceof AIOBaseRecyclePool)) {
            recycledViewPool = null;
        }
        AIOBaseRecyclePool aIOBaseRecyclePool = (AIOBaseRecyclePool) recycledViewPool;
        if (aIOBaseRecyclePool != null) {
            aIOBaseRecyclePool.setViewHolderDiscardCallBack$sdk_debug(null);
            aVar.d("AbsMsgListVB", hashCode() + " release viewHolderDiscardCallBack");
        }
        RecyclerView.OnScrollListener onScrollListener = this.scrollDispatcher;
        if (onScrollListener != null) {
            q1().removeOnScrollListener(onScrollListener);
        }
        this.scrollDispatcher = null;
        if (this.aioAdapter != null) {
            o1().n(new g.b(null, null, false, null, 15, null));
            o1().A();
            o1().g();
            if (q1().getChildCount() > 0) {
                q1().removeAllViewsInLayout();
                q1().getChildCount();
            }
            q1().getLayoutManager().release$sdk_debug();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @CallSuper
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        this.scope = CoroutineScopeKt.MainScope();
        o1().reset();
        p(o1());
        f1(false);
    }

    @Override // androidx.recyclerview.widget.IViewHolderDiscard
    public void onViewHolderDiscard(@Nullable RecyclerView.ViewHolder scrap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) scrap);
            return;
        }
        if (!(scrap instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a)) {
            scrap = null;
        }
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) scrap;
        if (aVar != null) {
            com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b).d("AbsMsgListVB", "onViewHolderDiscard " + aVar);
            y1(aVar);
        }
    }

    @NotNull
    public final AIORecycleView q1() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            value = iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            value = this.recyclerView.getValue();
        }
        return (AIORecycleView) value;
    }

    @NotNull
    public final b s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (b) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        b bVar = this.updateFocusIndex;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updateFocusIndex");
        }
        return bVar;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull S state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
            u0(state, o1());
        }
    }

    @NotNull
    public final n v1(@NotNull final RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (n) iPatchRedirector.redirect((short) 6, (Object) this, (Object) recyclerView);
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a(this);
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.d dVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.d(new ListNotifyImpl(aVar, recyclerView, new Function0<CoroutineScope>(recyclerView) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$initScreenRecyclerView$$inlined$apply$lambda$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ RecyclerView $recyclerView$inlined;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$recyclerView$inlined = recyclerView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsMsgListVB.this, (Object) recyclerView);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? AbsMsgListVB.this.h1() : (CoroutineScope) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        }));
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.a a16 = new a.C0643a(new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.c()).a();
        Intrinsics.checkNotNullExpressionValue(a16, "AIODifferConfig.Builder(\u2026                 .build()");
        aVar.w0(new AutoCancelAsyncListDiffer<>(dVar, a16));
        aVar.setHasStableIds(false);
        recyclerView.setAdapter(aVar);
        return new c(aVar);
    }

    public boolean w1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object x1(int i3, Continuation<? super RecyclerView.ViewHolder> continuation) {
        AbsMsgListVB$preCreateViewHolder$1 absMsgListVB$preCreateViewHolder$1;
        Object coroutine_suspended;
        int i16;
        if (continuation instanceof AbsMsgListVB$preCreateViewHolder$1) {
            absMsgListVB$preCreateViewHolder$1 = (AbsMsgListVB$preCreateViewHolder$1) continuation;
            int i17 = absMsgListVB$preCreateViewHolder$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                absMsgListVB$preCreateViewHolder$1.label = i17 - Integer.MIN_VALUE;
                Object obj = absMsgListVB$preCreateViewHolder$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = absMsgListVB$preCreateViewHolder$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    AbsMsgListVB$preCreateViewHolder$2 absMsgListVB$preCreateViewHolder$2 = new AbsMsgListVB$preCreateViewHolder$2(this, i3, null);
                    absMsgListVB$preCreateViewHolder$1.label = 1;
                    obj = BuildersKt.withContext(io5, absMsgListVB$preCreateViewHolder$2, absMsgListVB$preCreateViewHolder$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Intrinsics.checkNotNullExpressionValue(obj, "withContext(Dispatchers.\u2026clerView, viewType)\n    }");
                return obj;
            }
        }
        absMsgListVB$preCreateViewHolder$1 = new AbsMsgListVB$preCreateViewHolder$1(this, continuation);
        Object obj2 = absMsgListVB$preCreateViewHolder$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = absMsgListVB$preCreateViewHolder$1.label;
        if (i16 == 0) {
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "withContext(Dispatchers.\u2026clerView, viewType)\n    }");
        return obj2;
    }
}
