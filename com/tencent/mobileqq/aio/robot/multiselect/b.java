package com.tencent.mobileqq.aio.robot.multiselect;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectUIState;
import com.tencent.mobileqq.aio.robot.multiselect.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001$\b\u0017\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R&\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020$0)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/multiselect/b;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/robot/multiselect/c;", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "", "t", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "v", "", "visibility", "u", "state", "o", ReportConstant.COSTREPORT_PREFIX, "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/input/multiselect/a;", "e", "Lcom/tencent/mobileqq/aio/input/multiselect/a;", "fetcher", "f", "I", "mCount", "com/tencent/mobileqq/aio/robot/multiselect/b$b", h.F, "Lcom/tencent/mobileqq/aio/robot/multiselect/b$b;", "mAction", "", "Lkotlin/Pair;", "", "i", "Ljava/util/List;", "mMessageList", "<init>", "(Lcom/tencent/mobileqq/aio/input/multiselect/a;)V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public class b extends com.tencent.qqnt.aio.baseVM.a<c, RobotMultiSelectUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.input.multiselect.a fetcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7355b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, C7355b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/robot/multiselect/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.robot.multiselect.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7355b implements com.tencent.mvi.base.route.a {
        C7355b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b(@NotNull com.tencent.mobileqq.aio.input.multiselect.a fetcher) {
        List<Pair<String, C7355b>> listOf;
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        C7355b c7355b = new C7355b();
        this.mAction = c7355b;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MultiSelectEvent.UpdateSelectCount.class)), c7355b), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MultiSelectEvent.SetTouchBarVisibility.class)), c7355b), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ListScrollStateChanged.class)), c7355b), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(MultiSelectEvent.SetSelectMsgList.class)), c7355b)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof MultiSelectEvent.UpdateSelectCount) {
            w();
            return;
        }
        if (intent instanceof MultiSelectEvent.SetTouchBarVisibility) {
            u(((MultiSelectEvent.SetTouchBarVisibility) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.ListScrollStateChanged) {
            o(((AIOMsgListEvent.ListScrollStateChanged) intent).a());
        } else if (intent instanceof MultiSelectEvent.SetSelectMsgList) {
            int size = ((MultiSelectEvent.SetSelectMsgList) intent).a().size();
            this.mCount = size;
            updateUI(new RobotMultiSelectUIState.UpdateSelectCount(size));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long m() {
        AIOParam g16;
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (g16 = aVar.g()) != null) {
            return su3.c.a(g16);
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o(int state) {
        if (state == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MultiSelectEvent.ComputeTouchBarVisibility(this.fetcher.N()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        if (t()) {
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MultiSelectEvent.MultiDeleteMessageEvent.f188668d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.e((com.tencent.aio.api.runtime.a) getMContext()));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new RobotMsgIntent.RobotMultiFavClickEvent(arrayList, m()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgForwardEvent.MultiReportEvent(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.e((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        if (QLog.isColorLevel()) {
            QLog.i("RobotMultiSelectBarVM", 1, "handleShareClick");
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(RobotMsgIntent.MultiMsgShare.f188695d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean t() {
        if (com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.f((com.tencent.aio.api.runtime.a) getMContext()) == 0) {
            return true;
        }
        return false;
    }

    private final void u(int visibility) {
        if (this.mCount == 0) {
            return;
        }
        updateUI(new RobotMultiSelectUIState.SetTouchBarVisibility(visibility));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() != 103 && ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() != 118 && ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() != 201) {
            updateUI(new RobotMultiSelectUIState.UpdateOperation(1));
        } else {
            updateUI(new RobotMultiSelectUIState.UpdateOperation(2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        int g16 = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.g((com.tencent.aio.api.runtime.a) getMContext());
        this.mCount = g16;
        updateUI(new RobotMultiSelectUIState.UpdateSelectCount(g16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull c intent) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            p();
            return;
        }
        if (intent instanceof c.b) {
            q();
            return;
        }
        if (intent instanceof c.SelectToBottom) {
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.h(new AIOMsgListEvent.MultiSelectToBottom(((c.SelectToBottom) intent).getDividingLineTop()));
                return;
            }
            return;
        }
        if (intent instanceof c.C7356c) {
            r();
        } else if (intent instanceof c.d) {
            s();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
        w();
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        super.onDestroy();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
            }
        }
        this.mCount = 0;
    }
}
