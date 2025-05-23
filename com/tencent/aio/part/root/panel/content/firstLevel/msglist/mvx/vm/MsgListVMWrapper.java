package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import at.b;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u00020\u0006B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J'\u0010\r\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0003H\u0017J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0017J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020#H\u0007J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0010\u00a2\u0006\u0004\b*\u0010+R\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/c;", "", "H", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", PM.BASE, BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/a;)V", "u", "w", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "intent", "r", "t", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, "implState", "D", "(Lcom/tencent/aio/base/mvi/part/MsgListUiState;)Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "state", "b", "", "Lcom/tencent/aio/data/msglist/a;", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$b;", ReportConstant.COSTREPORT_PREFIX, "j", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "G", "", "updateType", "v", "", "isAtBottom", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/a;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "i", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "upDateQueue", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "updateRunnable", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class MsgListVMWrapper<I extends at.b, S extends MsgListUiState> extends a<I, S> implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private a<I, S> base;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentLinkedQueue<Runnable> upDateQueue;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Runnable updateRunnable;

    public MsgListVMWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.upDateQueue = new ConcurrentLinkedQueue<>();
            this.updateRunnable = new Runnable() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper$updateRunnable$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) MsgListVMWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ConcurrentLinkedQueue concurrentLinkedQueue;
                    ConcurrentLinkedQueue concurrentLinkedQueue2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                        concurrentLinkedQueue = MsgListVMWrapper.this.upDateQueue;
                        Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                        if (runnable != null) {
                            runnable.run();
                        }
                        concurrentLinkedQueue2 = MsgListVMWrapper.this.upDateQueue;
                        if (!concurrentLinkedQueue2.isEmpty()) {
                            MsgListVMWrapper.this.H();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        getMMainHandler().postAtFrontOfQueue(this.updateRunnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(@NotNull a<? extends at.b, ? extends MsgListUiState> base) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) base);
        } else {
            Intrinsics.checkNotNullParameter(base, "base");
            this.base = base;
        }
    }

    @Nullable
    public S D(@NotNull MsgListUiState implState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (S) iPatchRedirector.redirect((short) 9, (Object) this, (Object) implState);
        }
        Intrinsics.checkNotNullParameter(implState, "implState");
        return null;
    }

    @NotNull
    public d F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new b();
    }

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getMsgRepo", imports = {}))
    @NotNull
    public final MsgListRepo G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (MsgListRepo) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        return aVar.m();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.c
    @CallSuper
    public void b(@NotNull MsgListUiState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        final S D = D(state);
        if (D != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                updateUI(D);
            } else {
                this.upDateQueue.offer(new Runnable(this) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper$updateMsgList$$inlined$let$lambda$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ MsgListVMWrapper this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.this$0 = this;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgListUiState.this, (Object) this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.this$0.updateUI(MsgListUiState.this);
                        }
                    }
                });
                getMMainHandler().postAtFrontOfQueue(this.updateRunnable);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d("AbsMsgListVM", "updateMsgList spend " + currentTimeMillis2);
            }
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar.j();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    @NotNull
    public List<com.tencent.aio.data.msglist.a> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        return aVar.l();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    @CallSuper
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroy();
        MsgListRepo x16 = x();
        if (x16 != null) {
            x16.onDestroy();
        }
        this.upDateQueue.clear();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void q(boolean isAtBottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, isAtBottom);
            return;
        }
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar.q(isAtBottom);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void r(@NotNull MsgListIntent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar.r(intent);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void s(@NotNull MsgListIntent.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar.s(intent);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void t(@NotNull MsgListIntent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar.t(intent);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar.u();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public int v(int updateType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, updateType)).intValue();
        }
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        return aVar.v(updateType);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar.w();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        a<I, S> aVar = this.base;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        MsgListRepo m3 = m();
        m3.Q();
        Unit unit = Unit.INSTANCE;
        aVar.z(m3);
        a<I, S> aVar2 = this.base;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar2.y(F());
        a<I, S> aVar3 = this.base;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        if (aVar3 instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a) {
            a<I, S> aVar4 = this.base;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
            }
            if (aVar4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.MsgListVMImpl");
            }
            ((com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.impl.a) aVar4).F(this);
        }
        a<I, S> aVar5 = this.base;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PM.BASE);
        }
        aVar5.attach(context);
        super.onCreate(context);
    }
}
