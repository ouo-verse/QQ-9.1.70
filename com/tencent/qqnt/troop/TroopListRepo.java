package com.tencent.qqnt.troop;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.ITroopInfoInnerService;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatus;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberExtInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.MemberExtSourceType;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bR\u0010SJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\"\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0018H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020 H\u0016J\u001a\u0010#\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00020 H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0003H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016JU\u00105\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010$\u001a\u00020\r2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2)\u00104\u001a%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0005\u0018\u00010/j\u0004\u0018\u0001`3H\u0016J\u0010\u00106\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0018\u00107\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0014\u00108\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0014\u0010>\u001a\u00020:8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010@\u001a\u00020?8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020:8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u0010<R@\u0010H\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00050/j\u0002`30C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020?0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006T"}, d2 = {"Lcom/tencent/qqnt/troop/TroopListRepo;", "Lcom/tencent/qqnt/troop/ITroopListRepoApi;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "validList", "", "setupValidListConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "groupMemberExtList", "dealTroopLevelInfo", "", "isTroopListInited", "isTroopListCacheAllInited", "", "troopUin", "from", "printLog", "isExit", "preloadTroopList", "forceNet", "fetchTroopList", "needCheck", "fetchTroopList$qqtroop_impl_release", "(ZZ)V", "Lfx3/a;", "getTroopListLiveData", "getFetchTroopListResultLiveData", "getTroopListFromCache", "getTroopInfoFromCache", "getSortedJoinedTroopInfoFromCache", "getSortedJoinedValidTroopInfoFromCache", "getJoinedTroopInfoFromCache", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "getTroopListWithMsgMask", "getTroopUinListWithMsgMask", IProfileProtocolConst.PARAM_TROOP_CODE, "getTroopUinByTroopCode", "deleteTroopInCache", "troopInfo", "saveTroopInCache", "getTopTroopListFromCache", "getSortedJoinedTopTroopInfoFromCache", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "isTop", "needToast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/qqnt/troop/SetTroopTopCallback;", "callback", "requestSetTroopTop", "fetchTroopLevelInfoForEnterAIO", "fetchTroopLevelInfo", "TAG", "Ljava/lang/String;", "", "ERROR_CODE_REACH_THE_LIMIT", "I", "TROOP_LEVEL_CONFIG_ID", "DEFAULT_MAX_TROOP_LEVEL_REQUESTING_SIZE", "", "DEFAULT_TROOP_LEVEL_REQUEST_DELAY_TIME", "J", "TROOP_MEMBER_LEVEL_INFO_EXPIRED_TIME", "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "setTroopTopLifecycleCallback$delegate", "Lkotlin/Lazy;", "getSetTroopTopLifecycleCallback", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "setTroopTopLifecycleCallback", "Lcom/tencent/mobileqq/livedata/f;", "fetchTroopListResultLiveData", "Lcom/tencent/mobileqq/livedata/f;", "", "troopLevelInfoReqTimeMap", "Ljava/util/Map;", "Lcom/tencent/qqnt/inner/b;", "troopLevelFrequencyControl", "Lcom/tencent/qqnt/inner/b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopListRepo implements ITroopListRepoApi {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_MAX_TROOP_LEVEL_REQUESTING_SIZE = 3;
    private static final long DEFAULT_TROOP_LEVEL_REQUEST_DELAY_TIME = 200;
    private static final int ERROR_CODE_REACH_THE_LIMIT = 1213;

    @NotNull
    public static final TroopListRepo INSTANCE;

    @NotNull
    private static final String TAG = "TroopListRepoApi";

    @NotNull
    private static final String TROOP_LEVEL_CONFIG_ID = "102489";
    private static final int TROOP_MEMBER_LEVEL_INFO_EXPIRED_TIME = 30000;

    @NotNull
    private static final com.tencent.mobileqq.livedata.f<Boolean> fetchTroopListResultLiveData;

    /* renamed from: setTroopTopLifecycleCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy setTroopTopLifecycleCallback;

    @NotNull
    private static final com.tencent.qqnt.inner.b troopLevelFrequencyControl;

    @NotNull
    private static final Map<String, Long> troopLevelInfoReqTimeMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((TroopInfo) t17).setTopTime), Long.valueOf(((TroopInfo) t16).setTopTime));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63051);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        INSTANCE = new TroopListRepo();
        lazy = LazyKt__LazyJVMKt.lazy(TroopListRepo$setTroopTopLifecycleCallback$2.INSTANCE);
        setTroopTopLifecycleCallback = lazy;
        fetchTroopListResultLiveData = new com.tencent.mobileqq.livedata.f<>();
        troopLevelInfoReqTimeMap = new LinkedHashMap();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.troop.be
            @Override // java.lang.Runnable
            public final void run() {
                TroopListRepo._init_$lambda$0();
            }
        }, 16, null, false);
        troopLevelFrequencyControl = new com.tencent.qqnt.inner.b("fetchTroopLevelInfo", TROOP_LEVEL_CONFIG_ID, 3, DEFAULT_TROOP_LEVEL_REQUEST_DELAY_TIME);
    }

    TroopListRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0() {
        com.tencent.mobileqq.troop.api.config.ac.a();
        com.tencent.mobileqq.troop.api.config.ab.a();
        com.tencent.mobileqq.troop.api.config.y.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealTroopLevelInfo(TroopInfo troopInfo, GroupMemberExtListResult groupMemberExtListResult) {
        com.tencent.qqnt.inner.compator.troopinfo.d dVar = new com.tencent.qqnt.inner.compator.troopinfo.d();
        dVar.b(troopInfo);
        com.tencent.qqnt.inner.g.f357168a.c(groupMemberExtListResult, troopInfo, true);
        dVar.a(troopInfo);
        dVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopLevelInfoForEnterAIO$lambda$16(com.tencent.qqnt.report.m cmdReport, int i3, String str) {
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        cmdReport.f();
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopList$lambda$2(com.tencent.qqnt.kernel.api.s sVar, final boolean z16, final com.tencent.qqnt.report.m cmdReport) {
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        if (sVar != null) {
            sVar.getGroupList(z16, new IOperateCallback() { // from class: com.tencent.qqnt.troop.bb
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    TroopListRepo.fetchTroopList$lambda$2$lambda$1(com.tencent.qqnt.report.m.this, z16, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopList$lambda$2$lambda$1(com.tencent.qqnt.report.m cmdReport, boolean z16, int i3, String str) {
        boolean z17;
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        cmdReport.f();
        com.tencent.mobileqq.livedata.f<Boolean> fVar = fetchTroopListResultLiveData;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        fVar.m(Boolean.valueOf(z17));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchTroopList: result=" + i3 + ", errMsg=" + str + ", forceNet:" + z16);
        }
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function1<Boolean, Unit>> getSetTroopTopLifecycleCallback() {
        return (TroopLifecycleCallback) setTroopTopLifecycleCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestSetTroopTop$lambda$15(final com.tencent.qqnt.report.m cmdReport, final int i3, final boolean z16, final boolean z17, final int i16, final String str) {
        boolean z18;
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        cmdReport.f();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "requestSetTroopTop: result=" + i16 + ", errMsg=" + str);
        }
        if (i16 == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        final boolean z19 = z18;
        com.tencent.mobileqq.troop.utils.p.f302196a.b(new Function0<Unit>(i3, z16, z19, z17, i16, cmdReport, str) { // from class: com.tencent.qqnt.troop.TroopListRepo$requestSetTroopTop$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.report.m $cmdReport;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ boolean $isSuccess;
            final /* synthetic */ boolean $isTop;
            final /* synthetic */ boolean $needToast;
            final /* synthetic */ int $result;
            final /* synthetic */ int $token;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$token = i3;
                this.$needToast = z16;
                this.$isSuccess = z19;
                this.$isTop = z17;
                this.$result = i16;
                this.$cmdReport = cmdReport;
                this.$errMsg = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z19), Boolean.valueOf(z17), Integer.valueOf(i16), cmdReport, str);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TroopLifecycleCallback setTroopTopLifecycleCallback2;
                String string;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                setTroopTopLifecycleCallback2 = TroopListRepo.INSTANCE.getSetTroopTopLifecycleCallback();
                Function1 function1 = (Function1) setTroopTopLifecycleCallback2.f(this.$token);
                if (this.$needToast && function1 != null) {
                    BaseApplication baseApplication = BaseApplication.context;
                    if (this.$isSuccess) {
                        if (this.$isTop) {
                            string = baseApplication.getResources().getString(R.string.f235607c4);
                        } else {
                            string = baseApplication.getResources().getString(R.string.f23260750);
                        }
                        Intrinsics.checkNotNullExpressionValue(string, "if (isTop) {\n           \u2026                        }");
                        QQToast.makeText(baseApplication, 2, string, 0).show();
                    } else if (this.$result == 1213) {
                        String string2 = baseApplication.getResources().getString(R.string.f225616m4);
                        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026.set_top_reach_the_limit)");
                        QQToast.makeText(baseApplication, 1, string2, 0).show();
                    } else {
                        String string3 = baseApplication.getResources().getString(R.string.cpo);
                        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026R.string.operation_error)");
                        QQToast.makeText(baseApplication, 1, string3, 0).show();
                    }
                }
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(this.$isSuccess));
                }
                com.tencent.qqnt.report.m.c(this.$cmdReport, Integer.valueOf(this.$result), null, this.$errMsg, 2, null);
            }
        });
    }

    private final void setupValidListConfig(List<? extends TroopInfo> validList) {
        boolean z16;
        for (TroopInfo troopInfo : validList) {
            String str = troopInfo.extDBInfo.compareSpell;
            if (str != null) {
                Intrinsics.checkNotNullExpressionValue(str, "it.extDBInfo.compareSpell");
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                }
            }
            com.tencent.mobileqq.troop.api.utils.a.d(troopInfo);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void deleteTroopInCache(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo troopInfoFromCache = getTroopInfoFromCache(troopUin);
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 != null) {
            e16.onJceExitTroop(troopUin);
        }
        com.tencent.mobileqq.troop.api.config.ab.c(troopUin, troopInfoFromCache);
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void fetchTroopLevelInfo(@NotNull String troopUin, boolean forceNet) {
        Long longOrNull;
        long j3;
        boolean z16;
        ArrayList<Long> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, Boolean.valueOf(forceNet));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull == null) {
            QLog.e(TAG, 2, "fetchTroopLevelInfo: troop code null, troopCode=" + troopUin);
            return;
        }
        Long l3 = troopLevelInfoReqTimeMap.get(troopUin);
        long j16 = 0;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        if (System.currentTimeMillis() - j3 > 30000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || forceNet) {
            com.tencent.qqnt.f fVar = com.tencent.qqnt.f.f356721a;
            com.tencent.qqnt.kernel.api.s b16 = fVar.b();
            GroupMemberExtReq groupMemberExtReq = new GroupMemberExtReq();
            groupMemberExtReq.sourceType = MemberExtSourceType.TITLETYPE.ordinal();
            groupMemberExtReq.groupCode = longOrNull.longValue();
            groupMemberExtReq.beginUin = "0";
            groupMemberExtReq.dataTime = "0";
            Long[] lArr = new Long[1];
            AppInterface a16 = fVar.a();
            if (a16 != null) {
                j16 = a16.getLongAccountUin();
            }
            lArr[0] = Long.valueOf(j16);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(lArr);
            groupMemberExtReq.uinList = arrayListOf;
            MemberExtInfoFilter memberExtInfoFilter = new MemberExtInfoFilter();
            memberExtInfoFilter.memberLevelInfoUin = 1;
            memberExtInfoFilter.memberLevelInfoPoint = 1;
            memberExtInfoFilter.memberLevelInfoActiveDay = 1;
            memberExtInfoFilter.memberLevelInfoLevel = 1;
            memberExtInfoFilter.levelName = 1;
            memberExtInfoFilter.dataTime = 1;
            memberExtInfoFilter.sysShowFlag = 1;
            memberExtInfoFilter.userShowFlag = 1;
            memberExtInfoFilter.userShowFlagNew = 1;
            memberExtInfoFilter.levelNameNew = 1;
            groupMemberExtReq.memberExtFilter = memberExtInfoFilter;
            troopLevelFrequencyControl.d(troopUin, new TroopListRepo$fetchTroopLevelInfo$2(troopUin, forceNet, b16, groupMemberExtReq, new com.tencent.qqnt.report.g("fetchTroopLevelInfo")));
        }
    }

    public final void fetchTroopLevelInfoForEnterAIO(@Nullable String troopUin) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) troopUin);
            return;
        }
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 == null) {
            QLog.e(TAG, 2, "fetchTroopLevelInfoForEnterAIO: troop code null, troopCode=" + troopUin);
            return;
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null && troopInfoFromCache.isMember()) {
            if (troopInfoFromCache.extDBInfo.hadInitLevelInfo == 0) {
                fetchTroopLevelInfo(troopUin, true);
                return;
            }
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupMemberLevelInfo", troopUin, "TroopListRepoApi-fetchTroopLevelInfoForEnterAIO", false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupMemberLevelInfo(l3.longValue(), new IOperateCallback() { // from class: com.tencent.qqnt.troop.bc
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        TroopListRepo.fetchTroopLevelInfoForEnterAIO$lambda$16(com.tencent.qqnt.report.m.this, i3, str);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void fetchTroopList(boolean forceNet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, forceNet);
        } else {
            fetchTroopList$qqtroop_impl_release(forceNet, true);
        }
    }

    public final void fetchTroopList$qqtroop_impl_release(final boolean forceNet, boolean needCheck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(forceNet), Boolean.valueOf(needCheck));
            return;
        }
        if (needCheck) {
            ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
            if (!forceNet) {
                if (e16 == null || !e16.isCacheInited()) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
            }
        }
        final com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupList", "", "TroopListRepoApi-fetchTroopList", forceNet, false, 16, null);
        com.tencent.mobileqq.troop.utils.bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.troop.ba
            @Override // java.lang.Runnable
            public final void run() {
                TroopListRepo.fetchTroopList$lambda$2(com.tencent.qqnt.kernel.api.s.this, forceNet, mVar);
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public fx3.a<Boolean> getFetchTroopListResultLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (fx3.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return fetchTroopListResultLiveData;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getJoinedTroopInfoFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        List<TroopInfo> troopListFromCache = getTroopListFromCache();
        ArrayList arrayList = new ArrayList();
        for (Object obj : troopListFromCache) {
            if (((TroopInfo) obj).hadJoinTroop()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getSortedJoinedTopTroopInfoFromCache() {
        List<TroopInfo> sortedWith;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        List<TroopInfo> troopListFromCache = getTroopListFromCache();
        ArrayList arrayList = new ArrayList();
        for (Object obj : troopListFromCache) {
            TroopInfo troopInfo = (TroopInfo) obj;
            if (troopInfo.hadJoinTroop() && troopInfo.isTop) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        Object LOCK = com.tencent.mobileqq.troop.api.utils.a.f294337a;
        Intrinsics.checkNotNullExpressionValue(LOCK, "LOCK");
        synchronized (LOCK) {
            INSTANCE.setupValidListConfig(arrayList);
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
        }
        return sortedWith;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getSortedJoinedTroopInfoFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        List<TroopInfo> troopListFromCache = getTroopListFromCache();
        List arrayList = new ArrayList();
        for (Object obj : troopListFromCache) {
            if (((TroopInfo) obj).hadJoinTroop()) {
                arrayList.add(obj);
            }
        }
        Object LOCK = com.tencent.mobileqq.troop.api.utils.a.f294337a;
        Intrinsics.checkNotNullExpressionValue(LOCK, "LOCK");
        synchronized (LOCK) {
            INSTANCE.setupValidListConfig(arrayList);
            try {
                Comparator<TroopInfo> sEntityComparor = com.tencent.mobileqq.troop.api.utils.a.f294338b;
                Intrinsics.checkNotNullExpressionValue(sEntityComparor, "sEntityComparor");
                arrayList = CollectionsKt___CollectionsKt.sortedWith(arrayList, sEntityComparor);
            } catch (IllegalArgumentException e16) {
                QLog.e(TAG, 1, "getSortedJoinedTroopInfoFromCache: ", e16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getSortedJoinedValidTroopInfoFromCache() {
        List<TroopInfo> sortedWith;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        List<TroopInfo> troopListFromCache = getTroopListFromCache();
        ArrayList arrayList = new ArrayList();
        for (Object obj : troopListFromCache) {
            TroopInfo troopInfo = (TroopInfo) obj;
            if (troopInfo.hadJoinTroop() && !troopInfo.isTroopBlocked) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        Object LOCK = com.tencent.mobileqq.troop.api.utils.a.f294337a;
        Intrinsics.checkNotNullExpressionValue(LOCK, "LOCK");
        synchronized (LOCK) {
            INSTANCE.setupValidListConfig(arrayList);
            Comparator<TroopInfo> sEntityComparor = com.tencent.mobileqq.troop.api.utils.a.f294338b;
            Intrinsics.checkNotNullExpressionValue(sEntityComparor, "sEntityComparor");
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, sEntityComparor);
        }
        return sortedWith;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getTopTroopListFromCache() {
        List<TroopInfo> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 == null || (emptyList = e16.getCache()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : emptyList) {
            if (((TroopInfo) obj).isTop) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @Nullable
    public TroopInfo getTroopInfoFromCache(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin);
        }
        return TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getTroopListFromCache() {
        List<TroopInfo> emptyList;
        List<TroopInfo> cache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 == null || (cache = e16.getCache()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return cache;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @Nullable
    public fx3.a<List<TroopInfo>> getTroopListLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (fx3.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 != null) {
            return e16.getTroopListLiveData();
        }
        return null;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public Map<GroupMsgMask, List<TroopInfo>> getTroopListWithMsgMask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Map) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        List<TroopInfo> joinedTroopInfoFromCache = getJoinedTroopInfoFromCache();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TroopInfo troopInfo : joinedTroopInfoFromCache) {
            GroupMsgMask groupMsgMask = troopInfo.troopmask;
            Intrinsics.checkNotNullExpressionValue(groupMsgMask, "info.troopmask");
            Object obj = linkedHashMap.get(groupMsgMask);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(groupMsgMask, obj);
            }
            List list = (List) obj;
            if (!TypeIntrinsics.isMutableList(list)) {
                list = null;
            }
            if (list != null) {
                list.add(troopInfo);
            }
        }
        return linkedHashMap;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public String getTroopUinByTroopCode(@NotNull String troopCode) {
        String troopUinByTroopCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) troopCode);
        }
        Intrinsics.checkNotNullParameter(troopCode, "troopCode");
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 == null || (troopUinByTroopCode = e16.getTroopUinByTroopCode(troopCode)) == null) {
            return "";
        }
        return troopUinByTroopCode;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public Map<GroupMsgMask, List<String>> getTroopUinListWithMsgMask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Map) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        List<TroopInfo> joinedTroopInfoFromCache = getJoinedTroopInfoFromCache();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TroopInfo troopInfo : joinedTroopInfoFromCache) {
            GroupMsgMask groupMsgMask = troopInfo.troopmask;
            Intrinsics.checkNotNullExpressionValue(groupMsgMask, "info.troopmask");
            Object obj = linkedHashMap.get(groupMsgMask);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(groupMsgMask, obj);
            }
            List list = (List) obj;
            if (!TypeIntrinsics.isMutableList(list)) {
                list = null;
            }
            if (list != null) {
                String str = troopInfo.troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "info.troopuin");
                list.add(str);
            }
        }
        return linkedHashMap;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public boolean isExit(@Nullable String troopUin, @NotNull String from, boolean printLog) {
        Long l3;
        TroopInfo troopInfo;
        boolean z16;
        GroupStatus groupStatus;
        MemberRole memberRole;
        Map<Long, TroopInfo> cacheMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, troopUin, from, Boolean.valueOf(printLog))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(from, "from");
        boolean isTroopListCacheAllInited = isTroopListCacheAllInited();
        Integer num = null;
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 == null) {
            if (printLog) {
                QLog.i(TAG, 1, "[isExit] troopUin:" + troopUin + ", from:" + from);
            }
            return true;
        }
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 != null && (cacheMap = e16.getCacheMap()) != null) {
            troopInfo = cacheMap.get(l3);
        } else {
            troopInfo = null;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102971", false)) {
            if (printLog) {
                if (troopInfo != null) {
                    num = Integer.valueOf(troopInfo.exitTroopReason);
                }
                QLog.i(TAG, 1, "[isExit] troopUin:" + troopUin + ", from:" + from + ", exitTroopReason:" + num);
            }
            if (troopInfo == null || !troopInfo.isExited()) {
                return false;
            }
            return true;
        }
        if (printLog) {
            if (troopInfo != null) {
                groupStatus = troopInfo.groupStatus;
            } else {
                groupStatus = null;
            }
            if (troopInfo != null) {
                memberRole = troopInfo.memberRole;
            } else {
                memberRole = null;
            }
            if (troopInfo != null) {
                num = Integer.valueOf(troopInfo.exitTroopReason);
            }
            QLog.i(TAG, 1, "[isExit] troopUin:" + troopUin + ", cacheInit:" + isTroopListCacheAllInited + ", groupStatus:" + groupStatus + ", memberRole:" + memberRole + ", exitTroopReason:" + num + ", from:" + from);
        }
        if (!isTroopListCacheAllInited) {
            return false;
        }
        if (troopInfo != null && troopInfo.hadJoinTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public boolean isTroopListCacheAllInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 == null || !e16.isCacheAllInited()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public boolean isTroopListInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 == null || !e16.isCacheInited()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void preloadTroopList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ITroopListRepoApi.a.a(this, false, 1, null);
            TroopExtDBInfoRepo.INSTANCE.preloadTroopExtInfo$qqtroop_impl_release();
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void requestSetTroopTop(@Nullable LifecycleOwner lifecycleOwner, @NotNull String troopCode, final boolean isTop, final boolean needToast, @Nullable Function1<? super Boolean, Unit> callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, lifecycleOwner, troopCode, Boolean.valueOf(isTop), Boolean.valueOf(needToast), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopCode, "troopCode");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopCode);
        if (longOrNull == null) {
            QLog.e(TAG, 2, "requestSetTroopTop: troop code null, troopCode=" + troopCode);
            return;
        }
        com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        final int h16 = getSetTroopTopLifecycleCallback().h(lifecycleOwner, callback);
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setTop", troopCode, "TroopListRepoApi-requestSetTroopTop", false, true, 8, null);
        if (b16 != null) {
            b16.setTop(longOrNull.longValue(), isTop, new IOperateCallback() { // from class: com.tencent.qqnt.troop.bd
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    TroopListRepo.requestSetTroopTop$lambda$15(com.tencent.qqnt.report.m.this, h16, needToast, isTop, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void saveTroopInCache(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) troopInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 != null) {
            e16.onDetailInfoUpdate(troopInfo);
        }
    }
}
