package com.tencent.mobileqq.aio.shop;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.aio.factory.param.o;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.msglist.y;
import com.tencent.mobileqq.aio.shop.api.IShopAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B/\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/AIOShopMsgRepo;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "", Constants.BASE_IN_PLUGIN_ID, "g1", "", "P0", "W0", "Lcom/tencent/aio/api/runtime/a;", "H", "Lcom/tencent/aio/api/runtime/a;", "C1", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "Lkotlin/collections/ArrayList;", "I", "Lkotlin/Lazy;", "S0", "()Ljava/util/ArrayList;", "mMsgProcessors", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/y;", "weakMsgListVMApi", "Lcom/tencent/mobileqq/aio/factory/param/o;", "msgDelegate", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/aio/factory/param/o;)V", "J", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOShopMsgRepo extends AIOMsgRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMsgProcessors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/AIOShopMsgRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.shop.AIOShopMsgRepo$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57657);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOShopMsgRepo(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull final CoroutineScope scope, @NotNull WeakReference<y> weakMsgListVMApi, @Nullable o oVar) {
        super(aioContext, scope, weakMsgListVMApi, oVar);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(weakMsgListVMApi, "weakMsgListVMApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aioContext, scope, weakMsgListVMApi, oVar);
            return;
        }
        this.aioContext = aioContext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<AbsAIOMsgProcessor>>(scope) { // from class: com.tencent.mobileqq.aio.shop.AIOShopMsgRepo$mMsgProcessors$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ CoroutineScope $scope;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$scope = scope;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOShopMsgRepo.this, (Object) scope);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<AbsAIOMsgProcessor> invoke() {
                ArrayList<AbsAIOMsgProcessor> S0;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                S0 = super/*com.tencent.mobileqq.aio.msglist.AIOMsgRepo*/.S0();
                AIOShopMsgRepo aIOShopMsgRepo = AIOShopMsgRepo.this;
                S0.add(new h(aIOShopMsgRepo.C1(), this.$scope));
                return S0;
            }
        });
        this.mMsgProcessors = lazy;
    }

    private final void D1(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        Object lastOrNull;
        if (rsp.d() && (!rsp.a().isEmpty())) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar instanceof g) {
                g gVar = (g) aVar;
                gVar.x2(true);
                QLog.d("AIOShopMsgRepo", 1, "updateShopLastMsg lastMsgId = " + gVar.getMsgId());
            }
        }
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a C1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.aioContext;
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo
    public int P0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        if (((IShopAIOApi) companion.a(IShopAIOApi.class)).getQQShopIs2Tab()) {
            return ((IShopAIOApi) companion.a(IShopAIOApi.class)).getMsgPageCount();
        }
        return super.P0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo
    @NotNull
    public ArrayList<AbsAIOMsgProcessor> S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (ArrayList) this.mMsgProcessors.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo
    public int W0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        if (((IShopAIOApi) companion.a(IShopAIOApi.class)).getQQShopIs2Tab()) {
            return ((IShopAIOApi) companion.a(IShopAIOApi.class)).getMsgPageCount();
        }
        return super.W0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo
    public void g1(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rsp);
            return;
        }
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        super.g1(rsp);
        D1(rsp);
        QLog.d("AIOShopMsgRepo", 1, "initEnterLatestMsg");
    }
}
