package com.tencent.mobileqq.troop.halfscreennotification;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.halfscreennotification.api.impl.TroopHalfScreenNotificationApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 -2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00012B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001b\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0017J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f` H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010'R!\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/TroopHalfScreenNotificationHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/halfscreennotification/api/impl/TroopHalfScreenNotificationApiImpl$HalfScreenNotificationEvent;", "", "g", "e", "i", "k", "", "troopUin", "", "j", "Lcom/tencent/mobileqq/troop/halfscreennotification/a;", "data", "c", "(Lcom/tencent/mobileqq/troop/halfscreennotification/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "fetchJob", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "Lcom/tencent/mobileqq/troop/halfscreennotification/c;", "f", "Lkotlin/Lazy;", tl.h.F, "()Ljava/util/List;", "processor", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class TroopHalfScreenNotificationHelper implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<TroopHalfScreenNotificationApiImpl.HalfScreenNotificationEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job fetchJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy processor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/TroopHalfScreenNotificationHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationHelper$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopHalfScreenNotificationHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopHalfScreenNotificationHelper$processor$2.INSTANCE);
            this.processor = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0092 -> B:10:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(a aVar, Continuation<? super Unit> continuation) {
        TroopHalfScreenNotificationHelper$dispatchData$1 troopHalfScreenNotificationHelper$dispatchData$1;
        Object coroutine_suspended;
        int i3;
        TroopHalfScreenNotificationHelper troopHalfScreenNotificationHelper;
        Iterator it;
        int i16;
        boolean z16;
        if (continuation instanceof TroopHalfScreenNotificationHelper$dispatchData$1) {
            troopHalfScreenNotificationHelper$dispatchData$1 = (TroopHalfScreenNotificationHelper$dispatchData$1) continuation;
            int i17 = troopHalfScreenNotificationHelper$dispatchData$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                troopHalfScreenNotificationHelper$dispatchData$1.label = i17 - Integer.MIN_VALUE;
                Object obj = troopHalfScreenNotificationHelper$dispatchData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopHalfScreenNotificationHelper$dispatchData$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        int i18 = troopHalfScreenNotificationHelper$dispatchData$1.I$0;
                        c cVar = (c) troopHalfScreenNotificationHelper$dispatchData$1.L$3;
                        it = (Iterator) troopHalfScreenNotificationHelper$dispatchData$1.L$2;
                        a aVar2 = (a) troopHalfScreenNotificationHelper$dispatchData$1.L$1;
                        troopHalfScreenNotificationHelper = (TroopHalfScreenNotificationHelper) troopHalfScreenNotificationHelper$dispatchData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            i16 = i18;
                            if (i16 == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            QLog.i("TroopHalfScreenNotificationHelper", 1, "cancelled: " + z16 + "; consumed: " + cVar);
                            return Unit.INSTANCE;
                        }
                        aVar = aVar2;
                        if (!it.hasNext()) {
                            cVar = (c) it.next();
                            i16 = !JobKt.isActive(troopHalfScreenNotificationHelper$dispatchData$1.get$context()) ? 1 : 0;
                            if (i16 == 0) {
                                com.tencent.aio.api.runtime.a aVar3 = troopHalfScreenNotificationHelper.aioContext;
                                if (aVar3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                                    aVar3 = null;
                                }
                                troopHalfScreenNotificationHelper$dispatchData$1.L$0 = troopHalfScreenNotificationHelper;
                                troopHalfScreenNotificationHelper$dispatchData$1.L$1 = aVar;
                                troopHalfScreenNotificationHelper$dispatchData$1.L$2 = it;
                                troopHalfScreenNotificationHelper$dispatchData$1.L$3 = cVar;
                                troopHalfScreenNotificationHelper$dispatchData$1.I$0 = i16;
                                troopHalfScreenNotificationHelper$dispatchData$1.label = 1;
                                Object a16 = cVar.a(aVar3, aVar, troopHalfScreenNotificationHelper$dispatchData$1);
                                if (a16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                aVar2 = aVar;
                                i18 = i16;
                                obj = a16;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            }
                            if (i16 == 0) {
                            }
                            QLog.i("TroopHalfScreenNotificationHelper", 1, "cancelled: " + z16 + "; consumed: " + cVar);
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                QLog.i("TroopHalfScreenNotificationHelper", 1, "start dispatch");
                troopHalfScreenNotificationHelper = this;
                it = h().iterator();
                if (!it.hasNext()) {
                }
            }
        }
        troopHalfScreenNotificationHelper$dispatchData$1 = new TroopHalfScreenNotificationHelper$dispatchData$1(this, continuation);
        Object obj2 = troopHalfScreenNotificationHelper$dispatchData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopHalfScreenNotificationHelper$dispatchData$1.label;
        if (i3 == 0) {
        }
    }

    private final void e() {
        Job job = this.fetchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        k();
    }

    private final void g() {
        Job job = this.fetchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    private final List<c> h() {
        return (List) this.processor.getValue();
    }

    private final void i() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final boolean j(String troopUin) {
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache == null) {
            return true;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = troopInfoFromCache.dwCmdUinJoinTime;
        if (j3 <= 0 || serverTime - j3 <= 5) {
            return true;
        }
        return false;
    }

    private final void k() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<TroopHalfScreenNotificationApiImpl.HalfScreenNotificationEvent>> getEventClass() {
        ArrayList<Class<TroopHalfScreenNotificationApiImpl.HalfScreenNotificationEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopHalfScreenNotificationApiImpl.HalfScreenNotificationEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.I1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopHalfScreenNotificationHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u539f\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.aioContext = param.a();
        i();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, state);
        } else {
            if (state != 8) {
                if (state == 12) {
                    e();
                    return;
                }
                return;
            }
            g();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof TroopHalfScreenNotificationApiImpl.HalfScreenNotificationEvent)) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        long a16 = su3.c.a(g16);
        if (j(String.valueOf(a16))) {
            QLog.w("TroopHalfScreenNotificationHelper", 1, "receive event but discard");
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar2 = null;
        }
        Fragment c16 = aVar2.c();
        Intrinsics.checkNotNullExpressionValue(c16, "aioContext.fragment");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(c16), Dispatchers.getMain(), null, new TroopHalfScreenNotificationHelper$onReceiveEvent$2(a16, this, null), 2, null);
        this.fetchJob = launch$default;
    }
}
