package com.tencent.mobileqq.leba.list;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.core.BasePluginDataManager;
import com.tencent.mobileqq.leba.core.f;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.m;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002JO\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010\u00a2\u0006\u0002\b\u0013H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/leba/list/ListPluginDataManager;", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "", "from", "", "reason", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/mobileqq/leba/entity/n;", "list", BdhLogUtil.LogTag.Tag_Conn, "", "delayMs", "Lkotlinx/coroutines/CoroutineScope;", "parentScope", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", HippyTKDListViewAdapter.X, "(JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)V", "j", "Lkotlinx/coroutines/Job;", "k", "Lkotlinx/coroutines/Job;", "debounceJob", "<init>", "()V", "l", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ListPluginDataManager extends BasePluginDataManager {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job debounceJob;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/list/ListPluginDataManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.list.ListPluginDataManager$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ListPluginDataManager() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(int i3, String str, final ListPluginDataManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.leba.report.e.f240760a.b(i3, str, false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            this$0.m(null, null);
            return;
        }
        int i16 = LebaPluginLogic.i();
        List<LebaPluginInfo> h16 = this$0.h(com.tencent.mobileqq.leba.utils.c.a(i16), 1);
        if (h16.isEmpty()) {
            QLog.e("ListPluginDataManager", 1, "loadPluginList return null or empty ");
            this$0.m(null, null);
            return;
        }
        QLog.d("ListPluginDataManager", 2, "loadPluginList configList: " + h16.size() + " ");
        ArrayList arrayList = new ArrayList();
        for (LebaPluginInfo lebaPluginInfo : h16) {
            n nVar = new n();
            try {
                nVar.f240504a = lebaPluginInfo.uiResId;
                nVar.f240505b = lebaPluginInfo;
                if (this$0.b().f(nVar, i16, 1)) {
                    QLog.i("ListPluginDataManager", 1, "loadPluginList filterPlugin: [" + nVar.f240504a + " - " + nVar.f240505b.strResName + "]");
                } else {
                    arrayList.add(nVar);
                }
            } catch (Exception e16) {
                QLog.d(LogTag.LEBA_MGR, 1, "", e16);
            }
        }
        QLog.d("ListPluginDataManager", 2, "loadPluginList viewItemList: " + arrayList.size() + "  ");
        com.tencent.mobileqq.leba.core.f.x(arrayList);
        Collections.sort(arrayList, new f.a());
        int f16 = LebaPluginLogic.f(LebaPluginLogic.i());
        m k3 = LebaPluginLogic.k(peekAppRuntime, arrayList, f16, false);
        QLog.d("ListPluginDataManager", 2, "loadPluginList showPlugin: " + k3.f240502a.size());
        ArrayList arrayList2 = new ArrayList();
        List<n> list = k3.f240502a;
        Intrinsics.checkNotNullExpressionValue(list, "lebaShowData.showPlugin");
        arrayList2.addAll(list);
        if (f16 != 2) {
            this$0.C(arrayList2);
        }
        QLog.d("ListPluginDataManager", 2, "loadPluginList resultList: " + arrayList2.size());
        synchronized (this$0) {
            this$0.d().clear();
            this$0.d().addAll(arrayList2);
            this$0.c().clear();
            List<n> c16 = this$0.c();
            List<n> list2 = k3.f240503b;
            Intrinsics.checkNotNullExpressionValue(list2, "lebaShowData.morePlugin");
            c16.addAll(list2);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.g
                @Override // java.lang.Runnable
                public final void run() {
                    ListPluginDataManager.B(ListPluginDataManager.this);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ListPluginDataManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(this$0.d(), this$0.c());
    }

    private final void C(List<? extends n> list) {
        String str;
        boolean z16;
        int i3 = -1;
        int i16 = 0;
        for (n nVar : list) {
            int i17 = i16 + 1;
            LebaPluginInfo lebaPluginInfo = nVar.f240505b;
            Integer num = null;
            if (lebaPluginInfo != null) {
                str = lebaPluginInfo.strResName;
            } else {
                str = null;
            }
            if (lebaPluginInfo != null) {
                num = Integer.valueOf(lebaPluginInfo.groupId);
            }
            QLog.d("ListPluginDataManager", 4, "updateLastGroupInfo item [" + i3 + "][" + i16 + " " + str + " " + num + "]");
            if (i16 != 0 && nVar.f240507d != 2) {
                LebaPluginInfo lebaPluginInfo2 = nVar.f240505b;
                if (lebaPluginInfo2 != null && lebaPluginInfo2.groupId == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    nVar.f240508e = true;
                }
            }
            LebaPluginInfo lebaPluginInfo3 = nVar.f240505b;
            if (lebaPluginInfo3 != null) {
                i3 = lebaPluginInfo3.groupId;
            } else {
                i3 = -1;
            }
            i16 = i17;
        }
    }

    private final void x(long delayMs, CoroutineScope parentScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> action) {
        Job launch$default;
        Job job = this.debounceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(parentScope, null, null, new ListPluginDataManager$debounce$1(delayMs, action, null), 3, null);
        this.debounceJob = launch$default;
    }

    static /* synthetic */ void y(ListPluginDataManager listPluginDataManager, long j3, CoroutineScope coroutineScope, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 100;
        }
        if ((i3 & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }
        listPluginDataManager.x(j3, coroutineScope, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final int from, final String reason) {
        QLog.i("ListPluginDataManager", 1, "doLoadPluginList from: " + from + ", reason: " + reason);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.list.f
            @Override // java.lang.Runnable
            public final void run() {
                ListPluginDataManager.A(from, reason, this);
            }
        }, 176, null, false);
    }

    @Override // com.tencent.mobileqq.leba.core.BasePluginDataManager
    public void j(int from, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, from, (Object) reason);
            return;
        }
        QLog.i("ListPluginDataManager", 1, "loadPluginList from: " + from + ", reason: " + reason);
        y(this, 0L, null, new ListPluginDataManager$loadPluginList$1(this, from, reason, null), 3, null);
    }
}
