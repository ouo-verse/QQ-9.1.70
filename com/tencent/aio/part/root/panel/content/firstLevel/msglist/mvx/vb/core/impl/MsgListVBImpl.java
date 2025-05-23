package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.g;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.SubmitTaskQueue;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0002J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u001a\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"0!H\u0016J\u001a\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"0!H\u0016J\b\u0010&\u001a\u00020\u0007H\u0017R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/MsgListVBImpl;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/a;", "task", "Lkotlin/Function0;", "", "callback", "J1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "", "refreshHide", "loadMoreHide", "", Constants.APK_CERTIFICATE, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "T0", "S0", "uiHelper", "u0", "Lcom/tencent/aio/base/mvvm/b;", "F0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "I1", "p", "", "Lkotlin/Pair;", "", "e", h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "L", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/SubmitTaskQueue;", "M", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/SubmitTaskQueue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>", "()V", "N", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class MsgListVBImpl extends AbsMsgListVB<at.b, MsgListUiState> {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: L, reason: from kotlin metadata */
    private IListUIOperationApi helper;

    /* renamed from: M, reason: from kotlin metadata */
    private SubmitTaskQueue queue;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/MsgListVBImpl$a", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a implements AbsMsgListVB.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
        public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) state, (Object) helper);
                return;
            }
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(helper, "helper");
            long focusIndex = state.getFocusIndex();
            if (focusIndex == -1) {
                if (!helper.t().isEmpty()) {
                    com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "index " + (state.size() - 1));
                    a.C11562a.a(helper, state.size() + (-1), true, null, 4, null);
                    return;
                }
                return;
            }
            if (focusIndex == -2) {
                a.C11562a.a(helper, 0, false, null, 6, null);
                return;
            }
            if (focusIndex != -3) {
                Iterator<com.tencent.aio.data.msglist.a> it = state.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getMsgSeq() == state.getFocusIndex()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 < 0) {
                    com.tencent.aio.base.log.a.f69187b.e("MsgListVBImpl", "focusIndex Pos: " + i3 + ", size: " + state.size() + ", seq: " + state.getFocusIndex());
                    return;
                }
                a.C11562a.c(helper, i3, null, 2, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/MsgListVBImpl$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.MsgListVBImpl$b, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/MsgListVBImpl$onCreateView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOLayoutManager f69608d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MsgListVBImpl f69609e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IListUIOperationApi f69610f;

        c(AIOLayoutManager aIOLayoutManager, MsgListVBImpl msgListVBImpl, IListUIOperationApi iListUIOperationApi) {
            this.f69608d = aIOLayoutManager;
            this.f69609e = msgListVBImpl;
            this.f69610f = iListUIOperationApi;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aIOLayoutManager, msgListVBImpl, iListUIOperationApi);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            MsgListVBImpl msgListVBImpl = this.f69609e;
            msgListVBImpl.sendIntent(new MsgListIntent.b(newState, msgListVBImpl.I1(recyclerView)));
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "onScrollStateChanged  " + newState);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            int i3;
            com.tencent.aio.data.msglist.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int findFirstVisibleItemPosition = this.f69608d.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.f69608d.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0) {
                Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J = this.f69610f.J(findFirstVisibleItemPosition, findLastVisibleItemPosition);
                com.tencent.aio.api.vo.a first = J.getFirst();
                com.tencent.aio.data.msglist.a aVar2 = null;
                if (first != null) {
                    aVar = first.a();
                    i3 = first.b();
                } else {
                    i3 = findFirstVisibleItemPosition;
                    aVar = null;
                }
                com.tencent.aio.api.vo.a second = J.getSecond();
                if (second != null) {
                    aVar2 = second.a();
                    findLastVisibleItemPosition = second.b();
                }
                int i16 = findLastVisibleItemPosition;
                com.tencent.aio.data.msglist.a aVar3 = aVar2;
                int ordinal = MsgListIntent.ScrollType.DEFAULT.ordinal();
                if (dy5 > 0) {
                    ordinal = MsgListIntent.ScrollType.DOWN.ordinal();
                } else if (dy5 < 0) {
                    ordinal = MsgListIntent.ScrollType.UP.ordinal();
                }
                int i17 = ordinal;
                boolean I1 = this.f69609e.I1(recyclerView);
                this.f69609e.sendIntent(MsgListIntent.a.INSTANCE.a(aVar, aVar3, i3, i16, I1, i17, recyclerView.getScrollState()));
                com.tencent.aio.base.log.a aVar4 = com.tencent.aio.base.log.a.f69187b;
                com.tencent.aio.base.log.b.b(aVar4).d("MsgListVBImpl", "onScroll " + dy5 + "   state " + recyclerView.getScrollState() + " isAtBottom " + I1);
                if (com.tencent.aio.base.a.f69150c.a() && I1) {
                    aVar4.d("MsgListVBImpl", "scroll to bottom " + dy5);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgListVBImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.queue = new SubmitTaskQueue(new MsgListVBImpl$queue$1(this));
            C1(new a());
        }
    }

    public static final /* synthetic */ IListUIOperationApi E1(MsgListVBImpl msgListVBImpl) {
        IListUIOperationApi iListUIOperationApi = msgListVBImpl.helper;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        return iListUIOperationApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G1(MsgListState state, Function0<? extends Object> refreshHide, Function0<? extends Object> loadMoreHide) {
        MsgListState.Companion.UpdateType.Companion companion = MsgListState.Companion.UpdateType.INSTANCE;
        if (companion.a(state.getUpdateType(), 4)) {
            if (refreshHide != null) {
                refreshHide.invoke();
            }
            return true;
        }
        if (companion.a(state.getUpdateType(), 8)) {
            if (loadMoreHide != null) {
                loadMoreHide.invoke();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean H1(MsgListVBImpl msgListVBImpl, MsgListState msgListState, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        if ((i3 & 4) != 0) {
            function02 = null;
        }
        return msgListVBImpl.G1(msgListState, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.a task, final Function0<Unit> callback) {
        List list;
        final MsgListState b16 = task.b();
        boolean a16 = task.a();
        IListUIOperationApi iListUIOperationApi = this.helper;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        list = CollectionsKt___CollectionsKt.toList(b16);
        iListUIOperationApi.n(new g.b(list, null, a16, new g.a(b16, callback) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.MsgListVBImpl$submitAction$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MsgListState f69612b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Function0 f69613c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f69612b = b16;
                this.f69613c = callback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, MsgListVBImpl.this, b16, callback);
                }
            }

            @Override // com.tencent.aio.api.list.g.a
            public void a() {
                List list2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
                if (aVar.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("state submit complete: ");
                    sb5.append(this.f69612b.getUpdateType());
                    sb5.append(", ");
                    list2 = CollectionsKt___CollectionsKt.toList(this.f69612b);
                    sb5.append(list2.size());
                    sb5.append(", focusIndex: ");
                    sb5.append(this.f69612b.getFocusIndex());
                    sb5.append(", des ");
                    sb5.append(MsgListState.Companion.UpdateType.INSTANCE.c(this.f69612b.getUpdateType()));
                    aVar.d("MsgListVBImpl", sb5.toString());
                }
                this.f69613c.invoke();
                MsgListVBImpl.this.G1(this.f69612b, new MsgListVBImpl$submitAction$1$completeSubmit$2(MsgListVBImpl.E1(MsgListVBImpl.this)), new MsgListVBImpl$submitAction$1$completeSubmit$3(MsgListVBImpl.E1(MsgListVBImpl.this)));
                MsgListVBImpl.this.s1().a(this.f69612b, MsgListVBImpl.E1(MsgListVBImpl.this));
                MsgListState.Companion.UpdateType.Companion companion = MsgListState.Companion.UpdateType.INSTANCE;
                if (companion.a(128, this.f69612b.getUpdateType())) {
                    MsgListVBImpl.E1(MsgListVBImpl.this).setEnableLoadMore(false);
                }
                if (companion.a(64, this.f69612b.getUpdateType())) {
                    MsgListVBImpl.E1(MsgListVBImpl.this).a(false);
                }
                if (companion.a(32, this.f69612b.getUpdateType())) {
                    MsgListVBImpl.E1(MsgListVBImpl.this).setEnableLoadMore(true);
                }
                if (companion.a(16, this.f69612b.getUpdateType())) {
                    MsgListVBImpl.E1(MsgListVBImpl.this).a(true);
                }
            }
        }, 2, null));
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a();
    }

    public boolean I1(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        try {
            return !recyclerView.canScrollVertically(1);
        } catch (NullPointerException unused) {
            com.tencent.aio.base.log.a.f69187b.a("MsgListVBImpl", "isSlideToBottom NPE", new Throwable());
            return false;
        }
    }

    @Override // com.tencent.aio.api.list.j
    public void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            com.tencent.aio.pref.a.f69788j.k();
            sendIntent(new a.d("MsgListVBImpl"));
        }
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, this, createViewParams, childView, helper);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(helper, "helper");
        AIORecycleView i3 = helper.i();
        i3.addOnScrollListener(new c(i3.getLayoutManager(), this, helper));
        return childView;
    }

    @Override // et.a
    @NotNull
    public List<Pair<Integer, Integer>> e() {
        List<Pair<Integer, Integer>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // et.a
    @NotNull
    public List<Pair<Integer, Integer>> h() {
        List<Pair<Integer, Integer>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @SuppressLint({"MissingSuperCall"})
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.queue.e();
            com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.aio.api.list.j
    public void p(@NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        uiHelper.n(new g.b(null, null, false, null, 15, null));
        uiHelper.i().swapAdapter(uiHelper.i().getAdapter(), true);
        uiHelper.i().setFirstValidDraw$sdk_debug(false);
    }

    @Override // com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            this.helper = uiHelper;
            if (state instanceof MsgListState) {
                MsgListState.Companion.UpdateType.Companion companion = MsgListState.Companion.UpdateType.INSTANCE;
                MsgListState msgListState = (MsgListState) state;
                if (companion.b(msgListState.getUpdateType())) {
                    com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "handleRecycleView, state: " + msgListState.getUpdateType() + ", " + msgListState.getFocusIndex() + ", size = " + msgListState.size());
                } else if (com.tencent.aio.base.a.f69150c.a()) {
                    com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "handleRecycleView, state: " + msgListState.getUpdateType() + ", " + msgListState.getFocusIndex());
                }
                if (companion.a(2, msgListState.getUpdateType()) && !companion.a(1, msgListState.getUpdateType())) {
                    s1().a(msgListState, uiHelper);
                    return;
                } else if (companion.a(1, msgListState.getUpdateType())) {
                    this.queue.b(new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.a(System.currentTimeMillis(), msgListState.clone(), H1(this, msgListState, null, null, 6, null) | companion.a(2, msgListState.getUpdateType())));
                    return;
                } else {
                    G1(msgListState, new MsgListVBImpl$handleRecycleViewState$1$2(uiHelper), new MsgListVBImpl$handleRecycleViewState$1$3(uiHelper));
                    return;
                }
            }
            return;
        }
        aVar.b("handleRecycleViewState");
        String str = "AIO#handleRecycleViewState";
        if (!aVar.h()) {
            this.helper = uiHelper;
            if (state instanceof MsgListState) {
                MsgListState.Companion.UpdateType.Companion companion2 = MsgListState.Companion.UpdateType.INSTANCE;
                MsgListState msgListState2 = (MsgListState) state;
                if (companion2.b(msgListState2.getUpdateType())) {
                    com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "handleRecycleView, state: " + msgListState2.getUpdateType() + ", " + msgListState2.getFocusIndex() + ", size = " + msgListState2.size());
                } else if (com.tencent.aio.base.a.f69150c.a()) {
                    com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "handleRecycleView, state: " + msgListState2.getUpdateType() + ", " + msgListState2.getFocusIndex());
                }
                if (companion2.a(2, msgListState2.getUpdateType()) && !companion2.a(1, msgListState2.getUpdateType())) {
                    s1().a(msgListState2, uiHelper);
                    return;
                } else if (companion2.a(1, msgListState2.getUpdateType())) {
                    this.queue.b(new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.a(System.currentTimeMillis(), msgListState2.clone(), H1(this, msgListState2, null, null, 6, null) | companion2.a(2, msgListState2.getUpdateType())));
                } else {
                    G1(msgListState2, new MsgListVBImpl$handleRecycleViewState$1$2(uiHelper), new MsgListVBImpl$handleRecycleViewState$1$3(uiHelper));
                }
            }
            Unit unit = Unit.INSTANCE;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.helper = uiHelper;
            if (state instanceof MsgListState) {
                MsgListState.Companion.UpdateType.Companion companion3 = MsgListState.Companion.UpdateType.INSTANCE;
                MsgListState msgListState3 = (MsgListState) state;
                if (companion3.b(msgListState3.getUpdateType())) {
                    com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "handleRecycleView, state: " + msgListState3.getUpdateType() + ", " + msgListState3.getFocusIndex() + ", size = " + msgListState3.size());
                } else if (com.tencent.aio.base.a.f69150c.a()) {
                    com.tencent.aio.base.log.a.f69187b.d("MsgListVBImpl", "handleRecycleView, state: " + msgListState3.getUpdateType() + ", " + msgListState3.getFocusIndex());
                }
                if (companion3.a(2, msgListState3.getUpdateType())) {
                    i3 = 1;
                    if (!companion3.a(1, msgListState3.getUpdateType())) {
                        s1().a(msgListState3, uiHelper);
                        return;
                    }
                } else {
                    i3 = 1;
                }
                if (companion3.a(i3, msgListState3.getUpdateType())) {
                    this.queue.b(new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.a(System.currentTimeMillis(), msgListState3.clone(), H1(this, msgListState3, null, null, 6, null) | companion3.a(2, msgListState3.getUpdateType())));
                } else {
                    G1(msgListState3, new MsgListVBImpl$handleRecycleViewState$1$2(uiHelper), new MsgListVBImpl$handleRecycleViewState$1$3(uiHelper));
                }
            }
            Unit unit2 = Unit.INSTANCE;
            Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
        }
        aVar.e();
    }
}
