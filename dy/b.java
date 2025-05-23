package dy;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.aio.PAInputUIState;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0013\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00130\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Ldy/b;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "o", "p", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "visibility", DomainData.DOMAIN_NAME, "l", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dy/b$b", "d", "Ldy/b$b;", "mAction", "", "Lkotlin/Pair;", "", "e", "Ljava/util/List;", "messageList", "<init>", "()V", "f", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.tencent.aio.base.mvvm.b<PAInputIntent, PAInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final C10206b mAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<Pair<String, C10206b>> messageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"dy/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dy.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10206b implements com.tencent.mvi.base.route.a {
        C10206b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            b.this.E(intent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b() {
        List<Pair<String, C10206b>> listOf;
        C10206b c10206b = new C10206b();
        this.mAction = c10206b;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Reflection.getOrCreateKotlinClass(PAInputIntent.CustomMenuSwitchBtnVisibleIntent.class).getQualifiedName(), c10206b));
        this.messageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof PAInputIntent.CustomMenuSwitchBtnVisibleIntent) {
            n(((PAInputIntent.CustomMenuSwitchBtnVisibleIntent) intent).getVisibility());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("PublicAccountInputContainerVM", true));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PAInputIntent.SwitchMenuIntent(2, true));
    }

    private final void n(int visibility) {
        updateUI(new PAInputUIState.CustomMenuSwitchBtnVisibleState(visibility));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(PAInputIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof PAInputIntent.InputMenuSwitchBtnClickIntent) {
            l();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        p();
        super.onDestroy();
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        o();
    }
}
