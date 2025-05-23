package com.tencent.qqnt.troopmemberlist.cache.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.cache.api.Business;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.utils.ai;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.f;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.report.i;
import com.tencent.qqnt.troop.ITroopGagUtils;
import com.tencent.qqnt.troopmemberlist.cache.AllInOneWithAIOCache;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import com.tencent.qqnt.troopmemberlist.cache.d;
import com.tencent.qqnt.troopmemberlist.w;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ&\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J>\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0002J\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0002J\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0012\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\u001e\u0010#\u001a\u0004\u0018\u00010\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u001e\u0010$\u001a\u0004\u0018\u00010\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J2\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0006\u0010&\u001a\u00020\u0006H\u0016J$\u0010'\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010&\u001a\u00020\u0006H\u0016J0\u0010)\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00150\n2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0016J \u0010*\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016J \u0010/\u001a\u00020\b2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-H\u0016J\u0010\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H\u0016JB\u00106\u001a\u00020\b2\u0006\u00105\u001a\u0002042\b\u0010\r\u001a\u0004\u0018\u00010\f2&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0016J\u0016\u0010\u001e\u001a\u00020\b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0016J\u0012\u0010:\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u000108H\u0016R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020>0A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010@R \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010CR \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010CR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/impl/TroopMemberCacheServiceImpl;", "Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "", "troopUin", "memberUin", "", "isRemove", "", "updateExtCache", "", "groupUin", "Lcom/tencent/qqnt/kernel/nativeinterface/DataSource;", "dataSource", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/collections/HashMap;", "members", "handleMemberInfoChange", "allChangedMemberList", "dealAllChangedMember", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "changedMemberInfoList", "dealCacheChangedMember", "newMemberInfoList", "dealUnusedMember", "deleteMemberList", "dealDeleteMember", "member", "mergeExtInfo", "saveUinUid", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getMemberInfo", "getMemberInfoWithExtInfo", "memberUins", "withExt", "putMemberInfo", "allInCache", "putMemberList", "remove", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "Lkotlin/collections/ArrayList;", "extInfos", "putExtInfo", "uid", "getUinFromUid", "uin", "getUidFromUin", "", "groupCode", "onMemberInfoChange", "memberList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberListChangeInfo;", "info", "onMemberListChange", "Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$c;", "memberCache", "Lcom/tencent/qqnt/troopmemberlist/cache/ITroopMemberCacheService$c;", "", "membersCacheLockObj", "Ljava/lang/Object;", "Lcom/tencent/cache/api/collection/a;", "extCache", "Lcom/tencent/cache/api/collection/a;", "extCacheLockObj", "uinCache", "uidCache", "Lcom/tencent/qqnt/inner/f;", "gatherTaskControl", "Lcom/tencent/qqnt/inner/f;", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberCacheServiceImpl implements ITroopMemberCacheService, IKernelGroupListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final boolean DEBUG_LOG = false;
    private static final int DEFAULT_UIN_UID_CACHE_SIZE = 5000;
    private static final long GATHER_TASK_DELAY_TIME = 100;
    private static final int PLACE_HOLDER = 0;

    @NotNull
    public static final String TAG = "TroopMemberCacheServiceImpl";

    @NotNull
    private final com.tencent.cache.api.collection.a<String, Object> extCache;

    @NotNull
    private final Object extCacheLockObj;

    @NotNull
    private final f gatherTaskControl;

    @NotNull
    private final ITroopMemberCacheService.c memberCache;

    @NotNull
    private final Object membersCacheLockObj;

    @NotNull
    private final com.tencent.cache.api.collection.a<String, String> uidCache;

    @NotNull
    private final com.tencent.cache.api.collection.a<String, String> uinCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/cache/impl/TroopMemberCacheServiceImpl$a;", "", "", "troopUin", "memberUin", "b", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "info", "a", "", "DEBUG_LOG", "Z", "", "DEFAULT_UIN_UID_CACHE_SIZE", "I", "", "GATHER_TASK_DELAY_TIME", "J", "PLACE_HOLDER", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.cache.impl.TroopMemberCacheServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a(@NotNull TroopMemberInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            String str = info.troopuin;
            Intrinsics.checkNotNullExpressionValue(str, "info.troopuin");
            String str2 = info.memberuin;
            Intrinsics.checkNotNullExpressionValue(str2, "info.memberuin");
            return b(str, str2);
        }

        @NotNull
        public final String b(@NotNull String troopUin, @NotNull String memberUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) memberUin);
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            return troopUin + " " + memberUin;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberCacheServiceImpl() {
        ITroopMemberCacheService.c aVar;
        ITroopMemberCacheService.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.membersCacheLockObj = new Object();
        this.extCacheLockObj = new Object();
        Business business = Business.AIO;
        this.uinCache = new com.tencent.cache.api.collection.a<>(business, "TroopMemberUin", 5000);
        this.uidCache = new com.tencent.cache.api.collection.a<>(business, "TroopMemberUid", 5000);
        f fVar = new f(TAG, "105653", 100L);
        this.gatherTaskControl = fVar;
        ITroopMemberCacheService.Companion companion = ITroopMemberCacheService.INSTANCE;
        int c16 = companion.c();
        int e16 = companion.e();
        if (c16 != 2) {
            if (c16 != 3) {
                if (c16 != 4) {
                    cVar = new com.tencent.qqnt.troopmemberlist.cache.c();
                    this.memberCache = cVar;
                    QLog.d(TAG, 1, "init member cache strategy=" + c16 + ", gatherMemberChangeTask=" + fVar.g());
                    this.extCache = new com.tencent.cache.api.collection.a<>(business, "TroopMemberExt", cVar.b());
                }
                aVar = new AllInOneWithAIOCache(e16);
            } else {
                aVar = new d(e16);
            }
        } else {
            aVar = new com.tencent.qqnt.troopmemberlist.cache.a(e16);
        }
        cVar = aVar;
        this.memberCache = cVar;
        QLog.d(TAG, 1, "init member cache strategy=" + c16 + ", gatherMemberChangeTask=" + fVar.g());
        this.extCache = new com.tencent.cache.api.collection.a<>(business, "TroopMemberExt", cVar.b());
    }

    private final void dealAllChangedMember(String troopUin, List<MemberInfo> allChangedMemberList) {
        String str;
        boolean z16;
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentUin();
        } else {
            str = null;
        }
        Iterator<MemberInfo> it = allChangedMemberList.iterator();
        while (true) {
            if (it.hasNext()) {
                MemberInfo next = it.next();
                TroopMemberInfo troopMemberInfo = this.memberCache.get(troopUin, String.valueOf(next.uin));
                if (!Intrinsics.areEqual(String.valueOf(next.uin), str) && troopMemberInfo != null && next.shutUpTime != troopMemberInfo.gagTimeStamp) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (z16) {
            ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).onPushOtherMemberGagMsg(troopUin);
        }
    }

    private final void dealCacheChangedMember(final String groupUin, final List<? extends TroopMemberInfo> changedMemberInfoList) {
        for (TroopMemberInfo troopMemberInfo : changedMemberInfoList) {
            com.tencent.mobileqq.troop.change.troopmemberinfo.b bVar = new com.tencent.mobileqq.troop.change.troopmemberinfo.b();
            bVar.b(getMemberInfo(groupUin, troopMemberInfo.memberuin));
            putMemberInfo(groupUin, troopMemberInfo, false);
            bVar.a(troopMemberInfo);
            bVar.c();
        }
        if (!changedMemberInfoList.isEmpty()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.cache.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberCacheServiceImpl.dealCacheChangedMember$lambda$7(groupUin, changedMemberInfoList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealCacheChangedMember$lambda$7(String groupUin, List changedMemberInfoList) {
        Intrinsics.checkNotNullParameter(groupUin, "$groupUin");
        Intrinsics.checkNotNullParameter(changedMemberInfoList, "$changedMemberInfoList");
        ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) bg.l(ITroopMemberInfoService.class);
        if (iTroopMemberInfoService != null) {
            iTroopMemberInfoService.notifyChangeMemberWithInfo(groupUin, changedMemberInfoList);
        }
    }

    private final void dealDeleteMember(final String groupUin, List<MemberInfo> deleteMemberList) {
        TroopInfo troopInfo;
        String str;
        boolean contains$default;
        String replace$default;
        ITroopInfoService iTroopInfoService;
        if (!deleteMemberList.isEmpty()) {
            AppInterface a16 = com.tencent.qqnt.f.f356721a.a();
            if (a16 != null && (iTroopInfoService = (ITroopInfoService) a16.getRuntimeService(ITroopInfoService.class, "")) != null) {
                troopInfo = iTroopInfoService.findTroopInfo(groupUin);
            } else {
                troopInfo = null;
            }
            for (final MemberInfo memberInfo : deleteMemberList) {
                if (memberInfo.role == MemberRole.ADMIN && troopInfo != null && (str = troopInfo.Administrator) != null) {
                    Intrinsics.checkNotNullExpressionValue(str, "troopInfo.Administrator");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) String.valueOf(memberInfo.uin), false, 2, (Object) null);
                    if (contains$default) {
                        String str2 = troopInfo.Administrator;
                        Intrinsics.checkNotNullExpressionValue(str2, "troopInfo.Administrator");
                        replace$default = StringsKt__StringsJVMKt.replace$default(str2, String.valueOf(memberInfo.uin), "", false, 4, (Object) null);
                        troopInfo.Administrator = replace$default;
                    }
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.cache.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberCacheServiceImpl.dealDeleteMember$lambda$9(groupUin, memberInfo);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealDeleteMember$lambda$9(String groupUin, MemberInfo info) {
        Intrinsics.checkNotNullParameter(groupUin, "$groupUin");
        Intrinsics.checkNotNullParameter(info, "$info");
        ((ITroopMemberInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopMemberInfoService.class, "")).notifyKickoutMember(groupUin, String.valueOf(info.uin));
    }

    private final void dealUnusedMember(String groupUin, List<? extends TroopMemberInfo> newMemberInfoList) {
        Iterator<? extends TroopMemberInfo> it = newMemberInfoList.iterator();
        while (it.hasNext()) {
            putMemberInfo(groupUin, it.next(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMemberInfoChange(String groupUin, DataSource dataSource, HashMap<String, MemberInfo> members) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleMemberInfoChange: groupCode=" + groupUin + " members.size=" + members.size() + " dataSource=" + dataSource);
        }
        for (MemberInfo member : members.values()) {
            if (member.uin != 0) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(String.valueOf(member.uin), member.uid);
                Intrinsics.checkNotNullExpressionValue(member, "member");
                saveUinUid(member);
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator<Map.Entry<String, MemberInfo>> it = members.entrySet().iterator();
        while (it.hasNext()) {
            MemberInfo value = it.next().getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            MemberInfo memberInfo = value;
            long j3 = memberInfo.uin;
            if (j3 != 0) {
                String valueOf = String.valueOf(j3);
                arrayList.add(memberInfo);
                if (memberInfo.isDelete) {
                    arrayList2.add(memberInfo);
                    arrayList3.add(valueOf);
                } else if (getMemberInfo(groupUin, valueOf) != null) {
                    arrayList4.add(w.f362959a.a(memberInfo, groupUin));
                } else {
                    arrayList5.add(w.f362959a.a(memberInfo, groupUin));
                }
            }
        }
        dealAllChangedMember(groupUin, arrayList);
        dealCacheChangedMember(groupUin, arrayList4);
        if (ITroopMemberCacheService.INSTANCE.f()) {
            dealUnusedMember(groupUin, arrayList5);
        }
        if (dataSource == DataSource.REMOTE) {
            remove(groupUin, arrayList3);
            dealDeleteMember(groupUin, arrayList2);
        }
    }

    private final void mergeExtInfo(String troopUin, TroopMemberInfo member) {
        TroopMemberInfoExt troopMemberInfoExt;
        ITroopMemberCacheService.c cVar = this.memberCache;
        String str = member.memberuin;
        Intrinsics.checkNotNullExpressionValue(str, "member.memberuin");
        TroopMemberInfo troopMemberInfo = cVar.get(troopUin, str);
        if (member.extInfo == null) {
            if (troopMemberInfo != null) {
                troopMemberInfoExt = troopMemberInfo.extInfo;
            } else {
                troopMemberInfoExt = null;
            }
            if (troopMemberInfoExt != null) {
                member.extInfo = troopMemberInfo.extInfo;
            }
        }
    }

    private final void updateExtCache(String troopUin, String memberUin, boolean isRemove) {
        if (troopUin == null || memberUin == null) {
            return;
        }
        synchronized (this.extCacheLockObj) {
            if (isRemove) {
                this.extCache.g(INSTANCE.b(troopUin, memberUin));
            } else {
                this.extCache.f(INSTANCE.b(troopUin, memberUin), 0);
            }
        }
    }

    static /* synthetic */ void updateExtCache$default(TroopMemberCacheServiceImpl troopMemberCacheServiceImpl, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        troopMemberCacheServiceImpl.updateExtCache(str, str2, z16);
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    @Nullable
    public TroopMemberInfo getMemberInfo(@Nullable String troopUin, @Nullable String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        if (troopUin == null || memberUin == null) {
            return null;
        }
        return this.memberCache.get(troopUin, memberUin);
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    @Nullable
    public TroopMemberInfo getMemberInfoWithExtInfo(@Nullable String troopUin, @Nullable String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        if (troopUin == null || memberUin == null) {
            return null;
        }
        if (this.extCache.e(INSTANCE.b(troopUin, memberUin)) != null) {
            TroopMemberInfo memberInfo = getMemberInfo(troopUin, memberUin);
            if (memberInfo != null && memberInfo.extInfo != null) {
                return memberInfo;
            }
            updateExtCache(troopUin, memberUin, true);
        }
        return null;
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    @NotNull
    public String getUidFromUin(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        String e16 = this.uidCache.e(uin);
        if (e16 == null) {
            return "";
        }
        return e16;
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    @NotNull
    public String getUinFromUid(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        String e16 = this.uinCache.e(uid);
        if (e16 == null) {
            return "";
        }
        return e16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        s groupService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        IKernelService iKernelService = (IKernelService) bg.l(IKernelService.class);
        if (iKernelService != null && (groupService = iKernelService.getGroupService()) != null) {
            groupService.D(this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        s groupService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IKernelService iKernelService = (IKernelService) bg.l(IKernelService.class);
        if (iKernelService != null && (groupService = iKernelService.getGroupService()) != null) {
            groupService.x0(this);
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
    public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
        am.j(this, groupDetailInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupEssenceListChange(long j3) {
        am.k(this, j3);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
        am.l(this, groupExtListUpdateType, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
        am.m(this, firstGroupBulletinInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupListInited(boolean z16) {
        am.n(this, z16);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
        am.o(this, groupListUpdateType, arrayList);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
        am.p(this, j3, groupMemberLevelInfo);
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

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
        am.y(this, j3, z16, z17);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
        am.z(this, joinGroupNotifyMsg);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onMemberInfoChange(long groupCode, @Nullable final DataSource dataSource, @Nullable final HashMap<String, MemberInfo> members) {
        Object firstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(groupCode), dataSource, members);
            return;
        }
        if (members == null) {
            return;
        }
        final String valueOf = String.valueOf(groupCode);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onMemberInfoChange: groupCode=" + groupCode + " members.size=" + members.size() + " dataSource=" + dataSource);
            ai aiVar = ai.f302012a;
            Collection<MemberInfo> values = members.values();
            Intrinsics.checkNotNullExpressionValue(values, "members.values");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(values);
            QLog.d(TAG, 2, "onMemberInfoChange: groupCode=" + groupCode + " members[0]=" + aiVar.c((MemberInfo) firstOrNull) + "}");
        }
        this.gatherTaskControl.h(new Function0<Unit>(valueOf, dataSource, members) { // from class: com.tencent.qqnt.troopmemberlist.cache.impl.TroopMemberCacheServiceImpl$onMemberInfoChange$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DataSource $dataSource;
            final /* synthetic */ String $groupUin;
            final /* synthetic */ HashMap<String, MemberInfo> $members;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$groupUin = valueOf;
                this.$dataSource = dataSource;
                this.$members = members;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopMemberCacheServiceImpl.this, valueOf, dataSource, members);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopMemberCacheServiceImpl.this.handleMemberInfoChange(this.$groupUin, this.$dataSource, this.$members);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public void onMemberListChange(@Nullable GroupMemberListChangeInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) info);
            return;
        }
        if (info == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onMemberListChange: group=" + info.groupCode + ", changeSize=" + info.infos.size());
        }
        onMemberInfoChange(info.groupCode, DataSource.REMOTE, info.infos);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
        am.C(this, str, str2, arrayList, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
    public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
        am.D(this, j3, arrayList);
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    public void putExtInfo(@NotNull ArrayList<TroopMemberInfoExt> extInfos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) extInfos);
            return;
        }
        Intrinsics.checkNotNullParameter(extInfos, "extInfos");
        Iterator<TroopMemberInfoExt> it = extInfos.iterator();
        while (it.hasNext()) {
            TroopMemberInfoExt next = it.next();
            TroopMemberInfo memberInfo = getMemberInfo(next.troopUin, next.memberUin);
            if (memberInfo != null) {
                memberInfo.extInfo = next;
                putMemberInfo(next.troopUin, memberInfo, true);
            }
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    public void putMemberInfo(@Nullable String troopUin, @Nullable TroopMemberInfo member, boolean withExt) {
        List<? extends TroopMemberInfo> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, member, Boolean.valueOf(withExt));
            return;
        }
        if (troopUin == null || member == null) {
            return;
        }
        synchronized (this.membersCacheLockObj) {
            mergeExtInfo(troopUin, member);
            ITroopMemberCacheService.c cVar = this.memberCache;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(member);
            cVar.put(troopUin, listOf);
            saveUinUid(member);
            Unit unit = Unit.INSTANCE;
        }
        if (withExt) {
            updateExtCache$default(this, troopUin, member.memberuin, false, 4, (Object) null);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    public void putMemberList(@Nullable String troopUin, @NotNull List<? extends TroopMemberInfo> members, boolean withExt, boolean allInCache) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, members, Boolean.valueOf(withExt), Boolean.valueOf(allInCache));
            return;
        }
        Intrinsics.checkNotNullParameter(members, "members");
        if (troopUin == null) {
            return;
        }
        if (!allInCache && !i.f361953d.f()) {
            return;
        }
        synchronized (this.membersCacheLockObj) {
            if (!allInCache) {
                int a16 = this.memberCache.a(troopUin);
                if (a16 > 0) {
                    members = CollectionsKt___CollectionsKt.take(members, a16);
                } else {
                    return;
                }
            }
            for (TroopMemberInfo troopMemberInfo : members) {
                mergeExtInfo(troopUin, troopMemberInfo);
                saveUinUid(troopMemberInfo);
            }
            this.memberCache.put(troopUin, members);
            if (withExt) {
                List<? extends TroopMemberInfo> list = members;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((TroopMemberInfo) it.next()).memberuin);
                }
                updateExtCache$default(this, troopUin, (List) arrayList, false, 4, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    public void remove(@Nullable String troopUin, @NotNull List<String> members) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopUin, (Object) members);
            return;
        }
        Intrinsics.checkNotNullParameter(members, "members");
        if (troopUin == null) {
            return;
        }
        synchronized (this.membersCacheLockObj) {
            this.memberCache.remove(troopUin, members);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    public void saveUinUid(@NotNull List<? extends TroopMemberInfo> memberList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) memberList);
            return;
        }
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        Iterator<? extends TroopMemberInfo> it = memberList.iterator();
        while (it.hasNext()) {
            saveUinUid(it.next());
        }
    }

    static /* synthetic */ void updateExtCache$default(TroopMemberCacheServiceImpl troopMemberCacheServiceImpl, String str, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        troopMemberCacheServiceImpl.updateExtCache(str, (List<String>) list, z16);
    }

    @Override // com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService
    @Nullable
    public List<TroopMemberInfo> getMemberInfo(@Nullable String troopUin, @Nullable List<String> memberUins, boolean withExt) {
        TroopMemberInfo memberInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, troopUin, memberUins, Boolean.valueOf(withExt));
        }
        if (troopUin == null || memberUins == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : memberUins) {
            if (withExt) {
                memberInfo = getMemberInfoWithExtInfo(troopUin, str);
            } else {
                memberInfo = getMemberInfo(troopUin, str);
            }
            if (memberInfo == null) {
                return null;
            }
            arrayList.add(memberInfo);
        }
        return arrayList;
    }

    private final void saveUinUid(TroopMemberInfo member) {
        this.uinCache.f(member.memberUid, member.memberuin);
        this.uidCache.f(member.memberuin, member.memberUid);
    }

    private final void saveUinUid(MemberInfo member) {
        this.uinCache.f(member.uid, String.valueOf(member.uin));
        this.uidCache.f(String.valueOf(member.uin), member.uid);
    }

    private final void updateExtCache(String troopUin, List<String> memberUin, boolean isRemove) {
        if (troopUin == null || memberUin == null) {
            return;
        }
        synchronized (this.extCacheLockObj) {
            for (String str : memberUin) {
                if (isRemove) {
                    this.extCache.g(INSTANCE.b(troopUin, str));
                } else {
                    this.extCache.f(INSTANCE.b(troopUin, str), 0);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
