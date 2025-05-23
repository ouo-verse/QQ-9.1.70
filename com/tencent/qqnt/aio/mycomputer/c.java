package com.tencent.qqnt.aio.mycomputer;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.mycomputer.MyComputerUIState;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0013\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/mycomputer/c;", "Lcom/tencent/aio/base/mvvm/b;", "", "Lcom/tencent/qqnt/aio/mycomputer/MyComputerUIState;", "", "stop", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "view", "toRemove", "p", "isEmpty", "o", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/qqnt/aio/mycomputer/c$a", "d", "Lcom/tencent/qqnt/aio/mycomputer/c$a;", "mAction", "", "Lkotlin/Pair;", "", "e", "Ljava/util/List;", "messageList", "", "f", "mViewTypeList", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c extends com.tencent.aio.base.mvvm.b<Object, MyComputerUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, a>> messageList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> mViewTypeList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/mycomputer/c$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            boolean z16 = true;
            if (i3 instanceof AIOMsgListEvent.MsgCountChange) {
                c cVar = c.this;
                if (((AIOMsgListEvent.MsgCountChange) i3).a() != null) {
                    z16 = false;
                }
                cVar.o(z16);
                return;
            }
            if (i3 instanceof AIOMsgListEvent.EmptyMsgList) {
                c.this.o(true);
                return;
            }
            if (i3 instanceof FullBackgroundMviIntent.UpdateAIOBackground) {
                FullBackgroundMviIntent.UpdateAIOBackground updateAIOBackground = (FullBackgroundMviIntent.UpdateAIOBackground) i3;
                c.this.p(updateAIOBackground.b(), updateAIOBackground.a());
            } else if (i3 instanceof FullBackgroundMviIntent.AIOBackgroundPlayEvent) {
                c.this.n(((FullBackgroundMviIntent.AIOBackgroundPlayEvent) i3).a());
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

    public c() {
        List<Pair<String, a>> listOf;
        List<Integer> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        a aVar = new a();
        this.mAction = aVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MsgCountChange.class)), aVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.EmptyMsgList.class)), aVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(FullBackgroundMviIntent.UpdateAIOBackground.class)), aVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(FullBackgroundMviIntent.AIOBackgroundPlayEvent.class)), aVar)});
        this.messageList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(1);
        this.mViewTypeList = listOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean stop) {
        updateUI(new MyComputerUIState.UpdateAIOBackgroundPlayEvent(stop));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void o(boolean isEmpty) {
        if (isEmpty) {
            String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
            int hashCode = j3.hashCode();
            if (hashCode != -1834626455) {
                if (hashCode != -1656358474) {
                    if (hashCode == 1930502276 && j3.equals(PeerUid.DATALINE_PC_UID)) {
                        updateUI(MyComputerUIState.AddPCBackgroundView.f351660d);
                        return;
                    }
                    return;
                }
                if (j3.equals(PeerUid.DATALINE_PAD_UID)) {
                    updateUI(MyComputerUIState.AddPadBackgroundView.f351661d);
                    return;
                }
                return;
            }
            if (j3.equals(PeerUid.DATALINE_PHONE_UID)) {
                updateUI(MyComputerUIState.AddPhoneBackgroundView.f351662d);
                return;
            }
            return;
        }
        updateUI(MyComputerUIState.RemoveBackgroundView.f351663d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void p(View view, boolean toRemove) {
        if (!(view instanceof com.tencent.qqnt.aio.api.b)) {
            QLog.i(FrameworkVM.TAG, 1, "[handleUpdateAIOBackground]: view is not instance of IAIOBackgroudnView");
            return;
        }
        int type = ((com.tencent.qqnt.aio.api.b) view).type();
        if (this.mViewTypeList.contains(Integer.valueOf(type))) {
            QLog.i(FrameworkVM.TAG, 1, "[handleUpdateAIOBackground]: update fullbackgroundView, current viewType is " + type);
            updateUI(new MyComputerUIState.UpdateAIOBackgroundView(view, toRemove));
            return;
        }
        QLog.i(FrameworkVM.TAG, 1, "[handleUpdateAIOBackground]: remove fullbackgroundView, current viewType is " + type);
        updateUI(MyComputerUIState.RemoveBackgroundView.f351663d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
