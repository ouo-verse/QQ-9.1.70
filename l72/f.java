package l72;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.matchfriend.aio.input.QQStrangerInputBarUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.utils.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l72.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0006*\u0001(\u0018\u0000 \u000b2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006:\u0001,B\u000f\u0012\u0006\u0010!\u001a\u00020\u0005\u00a2\u0006\u0004\b+\u0010 J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016R\"\u0010!\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)\u00a8\u0006-"}, d2 = {"Ll72/f;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "e", "i", "", "isSelected", h.F, "g", "showPanel", "", "panelId", "k", "Ljava/lang/Class;", "d0", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "j", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "f", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "l", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "", "Ljava/util/List;", "messageList", "l72/f$b", "Ll72/f$b;", "action", "<init>", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<String> messageList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"l72/f$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            f.this.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public f(com.tencent.mobileqq.aio.input.adorn.c mHost) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{jVar.a(Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.EditTextChangedMsgIntent.class)), jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), jVar.a(Reflection.getOrCreateKotlinClass(KeyboardMsgIntent.OnKeyboardStateChanged.class))});
        this.messageList = listOf;
        this.action = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent msgIntent) {
        if (msgIntent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            n(QQStrangerInputBarUIState.UpdateSendBtnState.f243903d);
        } else if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent;
            k(onPanelStateChangedMsgIntent.b(), onPanelStateChangedMsgIntent.a());
        }
    }

    private final void i() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(InputEvent.AIOShortcutBarHide.f188562d);
        }
        n(new QQStrangerInputBarUIState.DisplayInputBar(false));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(at.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: d, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    public Class<? extends at.a> d0() {
        return l72.b.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void J(at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            i();
        } else if (intent instanceof b.OnEmoticonClick) {
            h(((b.OnEmoticonClick) intent).getIsSelected());
        } else if (intent instanceof b.OnAssistedChatClick) {
            g(((b.OnAssistedChatClick) intent).getIsSelected());
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void b(com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.aioContext = context;
        for (String str : this.messageList) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            if (e16 != null) {
                b bVar = this.action;
                com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                } else {
                    aVar2 = aVar3;
                }
                LifecycleOwner d16 = aVar2.d();
                Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
                e16.c(str, bVar, d16);
            }
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void L0(com.tencent.mobileqq.aio.input.adorn.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void n(InputUIState inputUIState) {
        e.a.b(this, inputUIState);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        for (String str : this.messageList) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            if (e16 != null) {
                e16.b(str, this.action);
            }
        }
    }

    private final void g(boolean isSelected) {
        com.tencent.aio.api.runtime.a aVar = null;
        if (isSelected) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            if (e16 != null) {
                e16.h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
                return;
            }
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar3;
        }
        com.tencent.mvi.base.route.j e17 = aVar.e();
        if (e17 != null) {
            e17.h(new PanelContainerMsgIntent.ShowPanelMsgIntent("QQStrangerInputBarVMDelegate", 1014, false, 0, 12, null));
        }
    }

    private final void h(boolean isSelected) {
        com.tencent.aio.api.runtime.a aVar = null;
        if (isSelected) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            if (e16 != null) {
                e16.h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
                return;
            }
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar3;
        }
        com.tencent.mvi.base.route.j e17 = aVar.e();
        if (e17 != null) {
            e17.h(new PanelContainerMsgIntent.ShowPanelMsgIntent("QQStrangerInputBarVMDelegate", 1001, false, 0, 12, null));
        }
    }

    private final void k(boolean showPanel, int panelId) {
        n(new QQStrangerInputBarUIState.UpdateIconState(showPanel && panelId == 1001, showPanel && panelId == 1014));
    }
}
