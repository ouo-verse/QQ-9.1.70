package com.tencent.mobileqq.leba.feed;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.core.BasePluginDataManager;
import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.data.LebaUnitedConfigHelper;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.m;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002JO\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2'\u0010\u0013\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u00a2\u0006\u0002\b\u0012H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/FeedPluginDataManager;", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "", "from", "", "reason", "", "B", "D", "", UserInfo.SEX_FEMALE, "", "delayMs", "Lkotlinx/coroutines/CoroutineScope;", "parentScope", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)V", "j", "Lkotlinx/coroutines/Job;", "k", "Lkotlinx/coroutines/Job;", "debounceJob", "<init>", "()V", "l", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FeedPluginDataManager extends BasePluginDataManager {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job debounceJob;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/FeedPluginDataManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.feed.FeedPluginDataManager$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17809);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FeedPluginDataManager() {
        super(2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static /* synthetic */ void A(FeedPluginDataManager feedPluginDataManager, long j3, CoroutineScope coroutineScope, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 100;
        }
        if ((i3 & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }
        feedPluginDataManager.z(j3, coroutineScope, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(final int from, final String reason) {
        QLog.i("FeedPluginDataManager", 1, "doLoadPluginList from: " + from + ", reason: " + reason);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.a
            @Override // java.lang.Runnable
            public final void run() {
                FeedPluginDataManager.C(from, reason, this);
            }
        }, 176, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(int i3, String str, FeedPluginDataManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.leba.report.e.f240760a.b(i3, str, true);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            this$0.m(null, null);
            return;
        }
        int i16 = LebaPluginLogic.i();
        int a16 = com.tencent.mobileqq.leba.utils.c.a(i16);
        List<LebaPluginInfo> h16 = this$0.h(a16, 2);
        QLog.d("FeedPluginDataManager", 2, "loadPluginList mode: " + a16 + ", lebaConfigList size = " + h16.size());
        if (h16.isEmpty()) {
            this$0.m(null, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (LebaPluginInfo lebaPluginInfo : h16) {
            n nVar = new n();
            try {
                nVar.f240504a = lebaPluginInfo.uiResId;
                nVar.f240505b = lebaPluginInfo;
                if (this$0.b().f(nVar, i16, 2)) {
                    QLog.i("FeedPluginDataManager", 1, "loadPluginList filterPlugin: [" + nVar.f240504a + " - " + nVar.f240505b.strResName + "]");
                } else {
                    arrayList.add(nVar);
                }
            } catch (Exception e16) {
                QLog.d(LogTag.LEBA_MGR, 1, "", e16);
            }
        }
        com.tencent.mobileqq.leba.core.f.x(arrayList);
        QLog.d("FeedPluginDataManager", 2, "loadPluginList lebaPluginList size = " + arrayList.size() + " ");
        Collections.sort(arrayList, new f.a());
        m k3 = LebaPluginLogic.k(peekAppRuntime, arrayList, LebaPluginLogic.f(LebaPluginLogic.i()), true);
        QLog.d("FeedPluginDataManager", 2, "loadPluginList showPlugin size = " + k3.f240502a.size() + " ");
        ArrayList arrayList2 = new ArrayList();
        List<n> list = k3.f240502a;
        Intrinsics.checkNotNullExpressionValue(list, "lebaShowData.showPlugin");
        arrayList2.addAll(list);
        int e17 = LebaPluginLogic.e();
        if (e17 == 0 || e17 == 2) {
            n nVar2 = new n();
            nVar2.f240507d = 2;
            arrayList2.add(nVar2);
        }
        QLog.d("FeedPluginDataManager", 2, "loadPluginList resultList size = " + arrayList2.size() + " ");
        synchronized (this$0) {
            this$0.d().clear();
            this$0.d().addAll(arrayList2);
            this$0.c().clear();
            List<n> c16 = this$0.c();
            List<n> list2 = k3.f240503b;
            Intrinsics.checkNotNullExpressionValue(list2, "lebaShowData.morePlugin");
            c16.addAll(list2);
            this$0.m(this$0.d(), this$0.c());
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int from, String reason) {
        QLog.i("FeedPluginDataManager", 1, "doLoadPluginListForTeenager from: " + from + ", reason: " + reason);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.b
            @Override // java.lang.Runnable
            public final void run() {
                FeedPluginDataManager.E(FeedPluginDataManager.this);
            }
        }, 176, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(FeedPluginDataManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<LebaPluginInfo> h16 = LebaUnitedConfigHelper.f240392a.h();
        if (h16.isEmpty()) {
            this$0.m(null, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (LebaPluginInfo lebaPluginInfo : h16) {
            n nVar = new n();
            try {
                nVar.f240504a = lebaPluginInfo.uiResId;
                nVar.f240505b = lebaPluginInfo;
                arrayList.add(nVar);
            } catch (Exception e16) {
                QLog.d(LogTag.LEBA_MGR, 1, "", e16);
            }
        }
        com.tencent.mobileqq.leba.core.f.x(arrayList);
        Collections.sort(arrayList, new f.a());
        synchronized (this$0) {
            this$0.d().clear();
            this$0.d().addAll(arrayList);
            this$0.m(this$0.d(), this$0.c());
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F() {
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).isShowQZoneFrameForTeenage();
    }

    private final void z(long delayMs, CoroutineScope parentScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> action) {
        Job launch$default;
        Job job = this.debounceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(parentScope, null, null, new FeedPluginDataManager$debounce$1(delayMs, action, null), 3, null);
        this.debounceJob = launch$default;
    }

    @Override // com.tencent.mobileqq.leba.core.BasePluginDataManager
    public void j(int from, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, from, (Object) reason);
            return;
        }
        QLog.d("FeedPluginDataManager", 4, "loadPluginList from: " + from + ", reason: " + reason);
        A(this, 0L, null, new FeedPluginDataManager$loadPluginList$1(this, from, reason, null), 3, null);
    }
}
