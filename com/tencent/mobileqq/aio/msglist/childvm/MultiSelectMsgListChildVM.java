package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0018\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B+\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/MultiSelectMsgListChildVM;", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "", "isSelectMode", "", "j", "", "dividingLine", "l", h.F, "dividingLineTop", "g", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigationResultNotify;", "intent", "k", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mobileqq/aio/msglist/w;", "Lcom/tencent/mobileqq/aio/msglist/w;", "getMListFetcher", "()Lcom/tencent/mobileqq/aio/msglist/w;", "mListFetcher", "com/tencent/mobileqq/aio/msglist/childvm/MultiSelectMsgListChildVM$b", "Lcom/tencent/mobileqq/aio/msglist/childvm/MultiSelectMsgListChildVM$b;", "mAction", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "mParentVm", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/w;Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;Lcom/tencent/aio/api/runtime/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MultiSelectMsgListChildVM extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final w mListFetcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/MultiSelectMsgListChildVM$a;", "", "", "MSG_SELECT_LIMIT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.childvm.MultiSelectMsgListChildVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/childvm/MultiSelectMsgListChildVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiSelectMsgListChildVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                MultiSelectMsgListChildVM.this.i(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58813);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSelectMsgListChildVM(@NotNull w mListFetcher, @NotNull MsgListVMWrapper<at.b, MsgListUiState> mParentVm, @NotNull com.tencent.aio.api.runtime.a mAioContext) {
        super(mAioContext, mParentVm);
        Intrinsics.checkNotNullParameter(mListFetcher, "mListFetcher");
        Intrinsics.checkNotNullParameter(mParentVm, "mParentVm");
        Intrinsics.checkNotNullParameter(mAioContext, "mAioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mListFetcher, mParentVm, mAioContext);
        } else {
            this.mListFetcher = mListFetcher;
            this.mAction = new b();
        }
    }

    private final void g(int dividingLineTop) {
        if (this.mListFetcher.x0(dividingLineTop) < h()) {
            c().e().h(new MultiSelectEvent.SetTouchBarVisibility(4));
        } else {
            c().e().h(new MultiSelectEvent.SetTouchBarVisibility(0));
        }
    }

    private final int h() {
        List<com.tencent.aio.data.msglist.a> b16 = b();
        if (!b16.isEmpty()) {
            int i3 = 0;
            for (com.tencent.aio.data.msglist.a aVar : b16) {
                int i16 = i3 + 1;
                com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b bVar = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a;
                com.tencent.aio.api.runtime.a c16 = c();
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                if (!bVar.h(c16, (AIOMsgItem) aVar)) {
                    i3 = i16;
                } else {
                    return i3;
                }
            }
        }
        return -1;
    }

    private final void j(boolean isSelectMode) {
        int i3;
        if (isSelectMode) {
            i3 = -1;
        } else {
            i3 = 120;
        }
        QLog.i("MultiSelectMsgListChildVM", 1, "[handleMultiSelectModeChange]: update msgListCount of msgRepo " + i3);
        d().G().X(i3);
    }

    private final void k(MsgNavigationEvent.NavigationResultNotify intent) {
        if (intent.b().e()) {
            BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MultiSelectMsgListChildVM$handleNavigateByResultEvent$1(this, intent, null), 2, null);
        }
    }

    private final void l(int dividingLine) {
        int h16 = h();
        int x06 = this.mListFetcher.x0(dividingLine);
        if (h16 < 0 || x06 < 0 || h16 >= x06) {
            return;
        }
        List<com.tencent.aio.data.msglist.a> subList = d().l().subList(h16, x06 + 1);
        Intrinsics.checkNotNull(subList, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.AIOMsgItem>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : subList) {
            if (((AIOMsgItem) obj).e2()) {
                arrayList.add(obj);
            }
        }
        com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b bVar = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a;
        int f16 = bVar.f(c());
        int d16 = bVar.d(arrayList);
        QLog.i("AbsMsgListVM", 1, "hasCount is " + f16 + ", willTotalCount is " + d16);
        if (d16 > 100) {
            String string = BaseApplication.context.getString(R.string.f6w, 100);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026haoguo, MSG_SELECT_LIMIT)");
            QQToast.makeText(BaseApplication.context, string, 0).show();
        } else {
            c().e().h(new MultiSelectEvent.SetSelectMsgList(arrayList));
            c().e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
            BuildersKt__Builders_commonKt.launch$default(d().vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MultiSelectMsgListChildVM$multiSelectToBottom$1(this, null), 2, null);
            HashMap hashMap = new HashMap();
            hashMap.put("selection_bars_number", Integer.valueOf(d16));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_multi_selection_selector", hashMap);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            c().e().f(this, this.mAction);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectToBottom");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.ComputeTouchBarVisibility");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgNavigationEvent.NavigationResultNotify");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new HashSet();
    }

    public final void i(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgListEvent.MultiSelectToBottom) {
            l(((AIOMsgListEvent.MultiSelectToBottom) intent).a());
            return;
        }
        if (intent instanceof MultiSelectEvent.ComputeTouchBarVisibility) {
            g(((MultiSelectEvent.ComputeTouchBarVisibility) intent).a());
        } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            j(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
        } else if (intent instanceof MsgNavigationEvent.NavigationResultNotify) {
            k((MsgNavigationEvent.NavigationResultNotify) intent);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c().e().i(this, this.mAction);
        }
    }
}
