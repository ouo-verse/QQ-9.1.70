package com.tencent.mobileqq.aio.msglist.childvm;

import android.graphics.drawable.Drawable;
import com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msglist.childvm.ScrollMsgListVM$scrollListener$2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0015B#\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/ScrollMsgListVM;", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "", "k", "j", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/aio/msglist/childvm/ScrollMsgListVM$scrollListener$2$a", h.F, "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/aio/msglist/childvm/ScrollMsgListVM$scrollListener$2$a;", "scrollListener", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "mParentVm", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;Lcom/tencent/aio/api/runtime/a;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ScrollMsgListVM extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/childvm/ScrollMsgListVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.childvm.ScrollMsgListVM$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58920);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollMsgListVM(@NotNull MsgListVMWrapper<at.b, MsgListUiState> mParentVm, @NotNull com.tencent.aio.api.runtime.a mAioContext) {
        super(mAioContext, mParentVm);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mParentVm, "mParentVm");
        Intrinsics.checkNotNullParameter(mAioContext, "mAioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ScrollMsgListVM$scrollListener$2.a>() { // from class: com.tencent.mobileqq.aio.msglist.childvm.ScrollMsgListVM$scrollListener$2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/childvm/ScrollMsgListVM$scrollListener$2$a", "Lcom/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack;", "", "state", "", "onScrollStateChange", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes11.dex */
                public static final class a implements AIOServiceContact$IRecycleViewScrollCallBack {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ScrollMsgListVM f190483d;

                    a(ScrollMsgListVM scrollMsgListVM) {
                        this.f190483d = scrollMsgListVM;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scrollMsgListVM);
                        }
                    }

                    @Override // com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack
                    public void onScrollStateChange(int state) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, state);
                            return;
                        }
                        if (state == 0) {
                            this.f190483d.k();
                        } else if (state == 1 || state == 2) {
                            this.f190483d.j();
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScrollMsgListVM.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(ScrollMsgListVM.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.scrollListener = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mParentVm, (Object) mAioContext);
        }
    }

    private final ScrollMsgListVM$scrollListener$2.a i() {
        return (ScrollMsgListVM$scrollListener$2.a) this.scrollListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        HashMap<Integer, Drawable> n26;
        y03.c cVar;
        y03.c cVar2;
        for (com.tencent.aio.data.msglist.a aVar : d().l()) {
            if (aVar instanceof ae) {
                Object q26 = ((ae) aVar).q2();
                if (q26 instanceof y03.c) {
                    cVar2 = (y03.c) q26;
                } else {
                    cVar2 = null;
                }
                if (cVar2 != null) {
                    cVar2.m();
                }
            }
            if ((aVar instanceof o) && (n26 = ((o) aVar).n2()) != null) {
                Iterator<Map.Entry<Integer, Drawable>> it = n26.entrySet().iterator();
                while (it.hasNext()) {
                    Object value = it.next().getValue();
                    if (value instanceof y03.c) {
                        cVar = (y03.c) value;
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        cVar.m();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        HashMap<Integer, Drawable> n26;
        y03.c cVar;
        y03.c cVar2;
        for (com.tencent.aio.data.msglist.a aVar : d().l()) {
            if (aVar instanceof ae) {
                Object q26 = ((ae) aVar).q2();
                if (q26 instanceof y03.c) {
                    cVar2 = (y03.c) q26;
                } else {
                    cVar2 = null;
                }
                if (cVar2 != null) {
                    cVar2.g();
                }
            }
            if ((aVar instanceof o) && (n26 = ((o) aVar).n2()) != null) {
                Iterator<Map.Entry<Integer, Drawable>> it = n26.entrySet().iterator();
                while (it.hasNext()) {
                    Object value = it.next().getValue();
                    if (value instanceof y03.c) {
                        cVar = (y03.c) value;
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        cVar.g();
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            c().b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).a(i());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            c().b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).c(i());
        }
    }
}
