package com.tencent.qqnt.inner.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.ac;
import com.tencent.mobileqq.troop.utils.ai;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.ITroopInfoInnerService;
import com.tencent.qqnt.inner.compator.troopinfo.processor.j;
import com.tencent.qqnt.inner.observer.TroopInfoChangedDispatcher;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troop.TroopListRepo;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J0\u0010\u0012\u001a\u00020\u00052\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001f0!H\u0016J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0#H\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020%H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0010H\u0016J(\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u0002032\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\u0012\u00108\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u000209H\u0016J\u001e\u0010?\u001a\u00020\u00052\u0006\u00104\u001a\u00020<2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\nH\u0016J\u001a\u0010B\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010@H\u0016R\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010JR\u0016\u0010R\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010S\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010JR\u0016\u0010T\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010JR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010WR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010J\u00a8\u0006a"}, d2 = {"Lcom/tencent/qqnt/inner/impl/TroopInfoInnerServiceImpl;", "Lcom/tencent/qqnt/inner/ITroopInfoInnerService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Ljava/lang/Runnable;", "task", "", "postTask", "checkNeedFetchTroopList", "reInitTroopList", "reInitTroopDetail", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "Lkotlin/collections/ArrayList;", "groupList", "Lcom/tencent/qqnt/inner/compator/troopinfo/b;", "comparator", "", "fromNet", "resetSimpleData", "loadBusinessDataAfterTroopListUpdate", "", "groupCode", "Lkotlin/Function0;", "callback", "updateInfoWithComparator", "initAfterNTCreated", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getCache", "", "getCacheMap", "Lfx3/a;", "getTroopListLiveData", "", IProfileProtocolConst.PARAM_TROOP_CODE, "getTroopUinByTroopCode", "troopUin", "onJceExitTroop", "troopInfo", "onDetailInfoUpdate", "isCacheInited", "isCacheAllInited", "Lcom/tencent/qqnt/troop/f;", "getDispatcher", "onLoadTroopExtInfoFinish", "listEmpty", "onGroupListInited", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupListUpdateType;", "updateType", "onGroupListUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/JoinGroupNotifyMsg;", "notifies", "onJoinGroupNotify", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "onGroupDetailInfoChange", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtListUpdateType;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "groupExtList", "onGroupExtListUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberLevelInfo;", "memberLevelInfo", "onGroupMemberLevelInfoChange", "Lcom/tencent/qqnt/inner/impl/a;", "cache", "Lcom/tencent/qqnt/inner/impl/a;", "", "loadGroupDetailInfoSize", "I", "hadLoadAllGroupDetailInfo", "Z", "Lcom/tencent/qqnt/report/f;", "troopListReport", "Lcom/tencent/qqnt/report/f;", "", "loadDataLock", "Ljava/lang/Object;", "hadCallTroopListInit", "hadCallReInit", "hadReInitTroopList", "hadReInitTroopDetail", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "taskHandler", "Lcom/tencent/qqnt/inner/observer/TroopInfoChangedDispatcher;", "dispatcher", "Lcom/tencent/qqnt/inner/observer/TroopInfoChangedDispatcher;", "getAllTroopListFinish", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopInfoInnerServiceImpl implements ITroopInfoInnerService, IKernelGroupListener {
    static IPatchRedirector $redirector_ = null;
    public static final long CHECK_FETCH_TROOP_LIST_DELAY_TIME = 5000;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "TroopInfoInnerServiceImp";

    @NotNull
    private final a cache;

    @NotNull
    private final TroopInfoChangedDispatcher dispatcher;
    private volatile boolean getAllTroopListFinish;
    private boolean hadCallReInit;
    private boolean hadCallTroopListInit;
    private boolean hadLoadAllGroupDetailInfo;
    private boolean hadReInitTroopDetail;
    private boolean hadReInitTroopList;

    @NotNull
    private final Handler handler;

    @NotNull
    private final Object loadDataLock;
    private int loadGroupDetailInfoSize;

    @NotNull
    private final Handler taskHandler;

    @Nullable
    private com.tencent.qqnt.report.f troopListReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/inner/impl/TroopInfoInnerServiceImpl$a;", "", "", "CHECK_FETCH_TROOP_LIST_DELAY_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f357174a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f357175b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62276);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupListUpdateType.values().length];
            try {
                iArr[GroupListUpdateType.GETALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupListUpdateType.REFRESHALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GroupListUpdateType.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GroupListUpdateType.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GroupListUpdateType.NOTHINGCHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f357174a = iArr;
            int[] iArr2 = new int[GroupExtListUpdateType.values().length];
            try {
                iArr2[GroupExtListUpdateType.GETALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[GroupExtListUpdateType.REFRESHALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[GroupExtListUpdateType.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[GroupExtListUpdateType.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f357175b = iArr2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62322);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoInnerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.cache = new a();
        this.troopListReport = new com.tencent.qqnt.report.f();
        this.loadDataLock = new Object();
        this.handler = new Handler(Looper.getMainLooper());
        this.taskHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.dispatcher = new TroopInfoChangedDispatcher();
    }

    private final void checkNeedFetchTroopList() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102870", true)) {
            return;
        }
        if (this.hadCallTroopListInit) {
            QLog.d(TAG, 1, "checkNeedFetchTroopList: hadCallTroopListInit");
            return;
        }
        QLog.d(TAG, 1, "checkNeedFetchTroopList: initTroopList");
        if (!this.hadCallReInit) {
            this.hadCallReInit = true;
            if (this.cache.c()) {
                reInitTroopDetail();
            } else {
                reInitTroopList();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAfterNTCreated$lambda$0() {
        TroopListRepo troopListRepo = TroopListRepo.INSTANCE;
        TroopMemberListRepo.INSTANCE.initAfterNTInit();
        com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAfterNTCreated$lambda$1(TroopInfoInnerServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkNeedFetchTroopList();
    }

    private final void loadBusinessDataAfterTroopListUpdate() {
        bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.inner.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoInnerServiceImpl.loadBusinessDataAfterTroopListUpdate$lambda$6(TroopInfoInnerServiceImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadBusinessDataAfterTroopListUpdate$lambda$6(TroopInfoInnerServiceImpl this$0) {
        AppInterface e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.loadDataLock) {
            AppInterface e17 = bg.e();
            if (e17 != null) {
                ac.b(e17);
                if (this$0.hadLoadAllGroupDetailInfo) {
                    ac.c(e17);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = this$0.cache.d().iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                TroopInfo troopInfo = (TroopInfo) it.next();
                String str = troopInfo.discussUin;
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it.discussUin ?: \"\"");
                }
                if (str.length() <= 0) {
                    z16 = false;
                }
                if (z16 && !Intrinsics.areEqual(str, "0")) {
                    arrayList.add(troopInfo);
                }
            }
            if ((!arrayList.isEmpty()) && (e16 = bg.e()) != null) {
                ac.d(e16, arrayList);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGroupDetailInfoChange$lambda$11(final TroopInfoInnerServiceImpl this$0, final GroupDetailInfo groupDetail) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupDetail, "$groupDetail");
        if (!this$0.hadLoadAllGroupDetailInfo) {
            this$0.loadGroupDetailInfoSize++;
            if (this$0.getAllTroopListFinish && this$0.loadGroupDetailInfoSize >= this$0.cache.d().size()) {
                this$0.hadLoadAllGroupDetailInfo = true;
                bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.inner.impl.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopInfoInnerServiceImpl.onGroupDetailInfoChange$lambda$11$lambda$10();
                    }
                });
            }
        }
        this$0.updateInfoWithComparator(groupDetail.groupCode, new Function0<Unit>(groupDetail) { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupDetailInfoChange$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ GroupDetailInfo $groupDetail;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$groupDetail = groupDetail;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoInnerServiceImpl.this, (Object) groupDetail);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    aVar = TroopInfoInnerServiceImpl.this.cache;
                    aVar.i(this.$groupDetail);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGroupDetailInfoChange$lambda$11$lambda$10() {
        AppInterface e16 = bg.e();
        if (e16 != null) {
            ac.c(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGroupExtListUpdate$lambda$12(TroopInfoInnerServiceImpl this$0, GroupExtListUpdateType updateType, ArrayList groupExtList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updateType, "$updateType");
        Intrinsics.checkNotNullParameter(groupExtList, "$groupExtList");
        final com.tencent.qqnt.inner.compator.troopinfo.c cVar = new com.tencent.qqnt.inner.compator.troopinfo.c();
        cVar.a(new j(this$0.dispatcher));
        int i3 = b.f357175b[updateType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this$0.cache.m(groupExtList, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupExtListUpdate$1$5
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.c.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                            invoke2(troopInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable TroopInfo troopInfo) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                com.tencent.qqnt.inner.compator.troopinfo.c.this.c(troopInfo);
                            } else {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                            }
                        }
                    }, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupExtListUpdate$1$6
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.c.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                            invoke2(troopInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull TroopInfo it) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                            } else {
                                Intrinsics.checkNotNullParameter(it, "it");
                                com.tencent.qqnt.inner.compator.troopinfo.c.this.b(it);
                            }
                        }
                    });
                    cVar.d();
                    return;
                }
                return;
            }
            this$0.cache.m(groupExtList, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupExtListUpdate$1$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.c.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable TroopInfo troopInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        com.tencent.qqnt.inner.compator.troopinfo.c.this.c(troopInfo);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                    }
                }
            }, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupExtListUpdate$1$4
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.c.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                    invoke2(troopInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopInfo it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.qqnt.inner.compator.troopinfo.c.this.b(it);
                    }
                }
            });
            cVar.d();
            return;
        }
        this$0.cache.m(groupExtList, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupExtListUpdate$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.c.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                invoke2(troopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopInfo troopInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    com.tencent.qqnt.inner.compator.troopinfo.c.this.c(troopInfo);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                }
            }
        }, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupExtListUpdate$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.c.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                invoke2(troopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopInfo it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.qqnt.inner.compator.troopinfo.c.this.b(it);
                }
            }
        });
        cVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGroupListUpdate$lambda$8(TroopInfoInnerServiceImpl this$0, GroupListUpdateType updateType, ArrayList groupList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updateType, "$updateType");
        Intrinsics.checkNotNullParameter(groupList, "$groupList");
        final com.tencent.qqnt.inner.compator.troopinfo.b bVar = new com.tencent.qqnt.inner.compator.troopinfo.b();
        bVar.a(new j(this$0.dispatcher));
        int i3 = b.f357174a[updateType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && groupList.size() == 0 && !this$0.isCacheInited()) {
                            this$0.cache.j();
                            com.tencent.qqnt.report.f fVar = this$0.troopListReport;
                            if (fVar != null) {
                                fVar.g(groupList.size());
                            }
                            com.tencent.qqnt.report.f fVar2 = this$0.troopListReport;
                            if (fVar2 != null) {
                                fVar2.e();
                            }
                            if (this$0.troopListReport != null) {
                                QLog.i(TAG, 1, "[onGroupListUpdate] updateType:" + updateType);
                            }
                            this$0.troopListReport = null;
                            return;
                        }
                        return;
                    }
                    this$0.cache.a(groupList, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupListUpdate$1$3
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.b.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                            invoke2(troopInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable TroopInfo troopInfo) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                com.tencent.qqnt.inner.compator.troopinfo.b.this.c(troopInfo);
                            } else {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                            }
                        }
                    }, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupListUpdate$1$4
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.b.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                            invoke2(troopInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull TroopInfo it) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                            } else {
                                Intrinsics.checkNotNullParameter(it, "it");
                                com.tencent.qqnt.inner.compator.troopinfo.b.this.b(it);
                            }
                        }
                    });
                    bVar.d();
                    TroopExtDBInfoRepo troopExtDBInfoRepo = TroopExtDBInfoRepo.INSTANCE;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(groupList, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = groupList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((GroupSimpleInfo) it.next()).groupCode));
                    }
                    troopExtDBInfoRepo.removeTroopExtInfo$qqtroop_impl_release(arrayList);
                    return;
                }
                this$0.cache.n(groupList, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupListUpdate$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.b.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                        invoke2(troopInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable TroopInfo troopInfo) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            com.tencent.qqnt.inner.compator.troopinfo.b.this.c(troopInfo);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                        }
                    }
                }, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$onGroupListUpdate$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.b.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                        invoke2(troopInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TroopInfo it5) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it5);
                        } else {
                            Intrinsics.checkNotNullParameter(it5, "it");
                            com.tencent.qqnt.inner.compator.troopinfo.b.this.b(it5);
                        }
                    }
                });
                bVar.d();
                return;
            }
            com.tencent.qqnt.report.f fVar3 = this$0.troopListReport;
            if (fVar3 != null) {
                fVar3.g(groupList.size());
            }
            this$0.resetSimpleData(groupList, bVar, true);
            com.tencent.qqnt.report.f fVar4 = this$0.troopListReport;
            if (fVar4 != null) {
                fVar4.e();
            }
            if (this$0.troopListReport != null) {
                QLog.i(TAG, 1, "[onGroupListUpdate] updateType:" + updateType);
            }
            this$0.troopListReport = null;
            return;
        }
        com.tencent.qqnt.report.f fVar5 = this$0.troopListReport;
        if (fVar5 != null) {
            fVar5.g(groupList.size());
        }
        this$0.resetSimpleData(groupList, bVar, false);
        com.tencent.qqnt.report.f fVar6 = this$0.troopListReport;
        if (fVar6 != null) {
            fVar6.e();
        }
        if (this$0.troopListReport != null) {
            QLog.i(TAG, 1, "[onGroupListUpdate] updateType:" + updateType);
        }
        this$0.troopListReport = null;
    }

    private final void postTask(Runnable task) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103061", true)) {
            this.taskHandler.post(task);
        } else {
            task.run();
        }
    }

    private final void reInitTroopDetail() {
        Long longOrNull;
        if (this.hadReInitTroopDetail) {
            return;
        }
        this.hadReInitTroopDetail = true;
        QLog.d(TAG, 1, "initTroopList: fetchTroopDetail");
        ArrayList<Long> arrayList = new ArrayList<>();
        for (TroopInfo troopInfo : this.cache.d()) {
            if (!troopInfo.hadInitDetail) {
                String str = troopInfo.troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                if (longOrNull != null) {
                    arrayList.add(Long.valueOf(longOrNull.longValue()));
                }
            }
        }
        TroopInfoRepo.INSTANCE.batchFetchTroopBasicInfo(arrayList);
    }

    private final void reInitTroopList() {
        if (this.hadReInitTroopList) {
            return;
        }
        this.hadReInitTroopList = true;
        QLog.d(TAG, 1, "initTroopList: fetchTroopList");
        TroopListRepo.INSTANCE.fetchTroopList$qqtroop_impl_release(false, false);
    }

    private final void resetSimpleData(ArrayList<GroupSimpleInfo> groupList, final com.tencent.qqnt.inner.compator.troopinfo.b comparator, boolean fromNet) {
        this.cache.k(groupList, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$resetSimpleData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.b.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                invoke2(troopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopInfo troopInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    com.tencent.qqnt.inner.compator.troopinfo.b.this.c(troopInfo);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                }
            }
        }, new Function1<TroopInfo, Unit>() { // from class: com.tencent.qqnt.inner.impl.TroopInfoInnerServiceImpl$resetSimpleData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.inner.compator.troopinfo.b.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                invoke2(troopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopInfo it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.qqnt.inner.compator.troopinfo.b.this.b(it);
                }
            }
        });
        comparator.d();
        this.cache.o("onGroupListUpdate-getAll");
        this.getAllTroopListFinish = true;
        if (this.loadGroupDetailInfoSize >= this.cache.d().size()) {
            this.hadLoadAllGroupDetailInfo = true;
        }
        if (this.hadCallReInit) {
            reInitTroopDetail();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102902", true);
        if (fromNet || !isSwitchOn) {
            loadBusinessDataAfterTroopListUpdate();
        }
    }

    private final void updateInfoWithComparator(long groupCode, Function0<Unit> callback) {
        String str;
        String str2;
        com.tencent.qqnt.inner.compator.troopinfo.b bVar = new com.tencent.qqnt.inner.compator.troopinfo.b();
        bVar.a(new j(this.dispatcher));
        TroopInfo troopInfo = getCacheMap().get(Long.valueOf(groupCode));
        TroopInfo troopInfo2 = null;
        if (troopInfo != null) {
            str = troopInfo.getTroopUin();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, String.valueOf(groupCode))) {
            troopInfo = null;
        }
        bVar.c(troopInfo);
        callback.invoke();
        TroopInfo troopInfo3 = getCacheMap().get(Long.valueOf(groupCode));
        if (troopInfo3 != null) {
            str2 = troopInfo3.getTroopUin();
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str2, String.valueOf(groupCode))) {
            troopInfo2 = troopInfo3;
        }
        bVar.b(troopInfo2);
        bVar.d();
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    @NotNull
    public List<TroopInfo> getCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.cache.d();
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    @NotNull
    public Map<Long, TroopInfo> getCacheMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.cache.e();
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    @NotNull
    public com.tencent.qqnt.troop.f getDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.qqnt.troop.f) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.dispatcher;
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    @NotNull
    public fx3.a<List<TroopInfo>> getTroopListLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (fx3.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.cache.f();
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    @NotNull
    public String getTroopUinByTroopCode(@NotNull String troopCode) {
        String l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopCode);
        }
        Intrinsics.checkNotNullParameter(troopCode, "troopCode");
        Long l16 = this.cache.g().get(troopCode);
        if (l16 == null || (l3 = l16.toString()) == null) {
            return "";
        }
        return l3;
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    public void initAfterNTCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.qqnt.f fVar = com.tencent.qqnt.f.f356721a;
        QLog.d(TAG, 1, "initAfterNTInit: groupService=" + fVar.b());
        com.tencent.qqnt.report.f fVar2 = this.troopListReport;
        if (fVar2 != null) {
            fVar2.d();
        }
        s b16 = fVar.b();
        if (b16 != null) {
            b16.D(this);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.inner.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoInnerServiceImpl.initAfterNTCreated$lambda$0();
            }
        }, 16, null, true);
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.qqnt.inner.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoInnerServiceImpl.initAfterNTCreated$lambda$1(TroopInfoInnerServiceImpl.this);
            }
        }, 5000L);
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    public boolean isCacheAllInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.cache.b();
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    public boolean isCacheInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.cache.c();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDestroy: groupService=" + com.tencent.qqnt.f.f356721a.b());
        }
        getTroopListLiveData().a();
        s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.x0(this);
        }
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    public void onDetailInfoUpdate(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            this.cache.h(troopInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
        am.a(this, j3, str, groupBulletinListResult);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupAdd(long j3) {
        am.b(this, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
        am.c(this, groupAllInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
        am.d(this, j3, groupArkInviteStateInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
        am.e(this, j3, groupBulletin);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
        am.f(this, j3, remindGroupBulletinMsg);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
        am.g(this, bulletinFeedsDownloadInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
        am.h(this, bulletinFeedsDownloadInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
        am.i(this, j3, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupDetailInfoChange(@NotNull final GroupDetailInfo groupDetail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) groupDetail);
            return;
        }
        Intrinsics.checkNotNullParameter(groupDetail, "groupDetail");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGroupDetailInfoChange: " + ai.f302012a.a(groupDetail));
        }
        postTask(new Runnable() { // from class: com.tencent.qqnt.inner.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoInnerServiceImpl.onGroupDetailInfoChange$lambda$11(TroopInfoInnerServiceImpl.this, groupDetail);
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupEssenceListChange(long j3) {
        am.k(this, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupExtListUpdate(@NotNull final GroupExtListUpdateType updateType, @NotNull final ArrayList<GroupExtInfo> groupExtList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) updateType, (Object) groupExtList);
            return;
        }
        Intrinsics.checkNotNullParameter(updateType, "updateType");
        Intrinsics.checkNotNullParameter(groupExtList, "groupExtList");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onGroupExtListUpdate] updateType=" + updateType + ", groupExtList=" + groupExtList.size());
        }
        postTask(new Runnable() { // from class: com.tencent.qqnt.inner.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoInnerServiceImpl.onGroupExtListUpdate$lambda$12(TroopInfoInnerServiceImpl.this, updateType, groupExtList);
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
        am.m(this, firstGroupBulletinInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupListInited(boolean listEmpty) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, listEmpty);
            return;
        }
        QLog.i(TAG, 1, "[onGroupListInited] listEmpty:" + listEmpty);
        com.tencent.qqnt.report.f fVar = this.troopListReport;
        if (fVar != null) {
            fVar.f();
        }
        this.hadCallTroopListInit = true;
        if (listEmpty) {
            this.cache.j();
            com.tencent.qqnt.report.f fVar2 = this.troopListReport;
            if (fVar2 != null) {
                fVar2.g(0);
            }
            com.tencent.qqnt.report.f fVar3 = this.troopListReport;
            if (fVar3 != null) {
                fVar3.e();
            }
            this.troopListReport = null;
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupListUpdate(@NotNull final GroupListUpdateType updateType, @NotNull final ArrayList<GroupSimpleInfo> groupList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) updateType, (Object) groupList);
            return;
        }
        Intrinsics.checkNotNullParameter(updateType, "updateType");
        Intrinsics.checkNotNullParameter(groupList, "groupList");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGroupListUpdate: " + updateType + ", groupList.size=" + groupList.size() + ", isCacheInit:" + isCacheInited());
        }
        com.tencent.qqnt.report.f fVar = this.troopListReport;
        if (fVar != null) {
            fVar.h();
        }
        postTask(new Runnable() { // from class: com.tencent.qqnt.inner.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoInnerServiceImpl.onGroupListUpdate$lambda$8(TroopInfoInnerServiceImpl.this, updateType, groupList);
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onGroupMemberLevelInfoChange(long groupCode, @Nullable GroupMemberLevelInfo memberLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(groupCode), memberLevelInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGroupMemberLevelInfoChange: groupCode=" + groupCode + ", levelInfo=" + memberLevelInfo);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
        am.q(this, z16, j3, i3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
        am.r(this, z16, j3, i3, i16, i17, i18);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
        am.s(this, z16, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
        am.t(this, z16, j3, arrayList, arrayList2);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
        am.u(this, z16, j3, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
        am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
        am.w(this, j3, groupStatisticInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
        am.x(this, arrayList);
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    public void onJceExitTroop(@NotNull String troopUin) {
        Long longOrNull;
        ArrayList<GroupSimpleInfo> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull == null) {
            QLog.e(TAG, 2, "onJceExitTroop: error uin=" + troopUin);
            return;
        }
        TroopInfo troopInfo = this.cache.e().get(longOrNull);
        if (troopInfo != null) {
            troopInfo.isExitByJce = true;
        }
        GroupSimpleInfo groupSimpleInfo = new GroupSimpleInfo();
        groupSimpleInfo.groupCode = longOrNull.longValue();
        GroupListUpdateType groupListUpdateType = GroupListUpdateType.REMOVE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(groupSimpleInfo);
        onGroupListUpdate(groupListUpdateType, arrayListOf);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
        am.y(this, j3, z16, z17);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onJoinGroupNotify(@Nullable JoinGroupNotifyMsg notifies) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) notifies);
            return;
        }
        am.z(this, notifies);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[onJoinGroupNotify] " + notifies);
        }
    }

    @Override // com.tencent.qqnt.inner.ITroopInfoInnerService
    public void onLoadTroopExtInfoFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.getAllTroopListFinish) {
            this.cache.o("loadExtFinish");
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
        am.A(this, j3, dataSource, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
        am.B(this, groupMemberListChangeInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
        am.C(this, str, str2, arrayList, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
        am.D(this, j3, arrayList);
    }
}
