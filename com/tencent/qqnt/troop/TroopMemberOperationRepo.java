package com.tencent.qqnt.troop;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.handler.TroopMemberMngHandler;
import com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bean.InviteToTroopParam;
import com.tencent.qqnt.bean.InviteToTroopUserInfo;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberShutUpInfo;
import com.tencent.qqnt.kernel.nativeinterface.IInviteToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKickMemberCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.InviteToGroupRsp;
import com.tencent.qqnt.kernel.nativeinterface.KickMemberResult;
import com.tencent.qqnt.kernel.nativeinterface.KickMemberV2Result;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J(\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002JB\u0010\u0013\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u00112\u0006\u0010\u0003\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J@\u0010\u001c\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J8\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016JJ\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J>\u0010#\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0016J,\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J,\u0010'\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010&H\u0016R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010+R!\u00102\u001a\b\u0012\u0004\u0012\u00020-0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/troop/TroopMemberOperationRepo;", "Lcom/tencent/qqnt/troop/ITroopMemberOperationRepoApi;", "Lcom/tencent/qqnt/bean/InviteToTroopParam;", "param", "", "id", "", "from", "uniqueFrom", "", "inviteToGroupInner", "Lcom/tencent/qqnt/bean/b;", "callbackId", "deleteTroopMemberInner", "troopUin", "retCode", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "deleteUids", "notifyDeleteTroopMemberResult", "Lcom/tencent/qqnt/troop/i;", "asyncCallback", "onIllegalParams", "memberUid", "", "gagTimeStamp", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setMemberShutUp", "groupCode", "inviteToGroup", "invitedUidList", "", "Lcom/tencent/mobileqq/troop/data/TroopCreateInfo$a;", "invitedMemberList", "inviteMembersToGroup", "", "securityPass", "Lcom/tencent/qqnt/troop/c;", "deleteTroopMember", "TAG", "Ljava/lang/String;", "CODE_GAG_TROOP_MEMBER_EXCEED_LIMIT", "I", "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "", "callbackStore$delegate", "Lkotlin/Lazy;", "getCallbackStore", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "callbackStore", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberOperationRepo implements ITroopMemberOperationRepoApi {
    static IPatchRedirector $redirector_ = null;
    private static final int CODE_GAG_TROOP_MEMBER_EXCEED_LIMIT = 10;

    @NotNull
    public static final TroopMemberOperationRepo INSTANCE;

    @NotNull
    private static final String TAG = "TroopMemberOperationRepo";

    /* renamed from: callbackStore$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy callbackStore;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new TroopMemberOperationRepo();
        lazy = LazyKt__LazyJVMKt.lazy(TroopMemberOperationRepo$callbackStore$2.INSTANCE);
        callbackStore = lazy;
    }

    TroopMemberOperationRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteTroopMember$lambda$23(com.tencent.qqnt.bean.b param, String from, String uniqueFrom, int i3, Map uin2UidMap) {
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullExpressionValue(uin2UidMap, "uin2UidMap");
        if (!uin2UidMap.isEmpty()) {
            param.e(uin2UidMap);
            INSTANCE.deleteTroopMemberInner(param, from, uniqueFrom, i3);
            return;
        }
        QLog.e(TAG, 1, "[deleteTroopMember] fetchUin2UidMap error, from:" + uniqueFrom);
        INSTANCE.notifyDeleteTroopMemberResult(param.troopUin, i3, 3, new ArrayList<>(), param);
    }

    private final void deleteTroopMemberInner(final com.tencent.qqnt.bean.b param, String from, final String uniqueFrom, final int callbackId) {
        c cVar;
        QLog.i(TAG, 1, "[deleteTroopMemberInner] from:" + uniqueFrom + ", uid:" + param.g());
        if (com.tencent.qqnt.e.c() == null) {
            QLog.e(TAG, 1, "[inviteToGroupInner] groupService is null");
            Object f16 = getCallbackStore().f(callbackId);
            if (f16 instanceof c) {
                cVar = (c) f16;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.a(false, -1, new ArrayList<>());
                return;
            }
            return;
        }
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("kickMemberV2", param.troopUin, "TroopMemberOperationRepo-" + from, false, true, 8, null);
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.kickMemberV2(param.f(), new IKickMemberCallback() { // from class: com.tencent.qqnt.troop.bl
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKickMemberCallback
                public final void onResult(int i3, String str, KickMemberV2Result kickMemberV2Result) {
                    TroopMemberOperationRepo.deleteTroopMemberInner$lambda$30(com.tencent.qqnt.report.m.this, param, callbackId, uniqueFrom, i3, str, kickMemberV2Result);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteTroopMemberInner$lambda$30(final com.tencent.qqnt.report.m report, final com.tencent.qqnt.bean.b param, final int i3, final String uniqueFrom, final int i16, final String str, final KickMemberV2Result kickMemberV2Result) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.bi
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberOperationRepo.deleteTroopMemberInner$lambda$30$lambda$29(com.tencent.qqnt.bean.b.this, i16, kickMemberV2Result, i3, report, str, uniqueFrom);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        if (r7 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void deleteTroopMemberInner$lambda$30$lambda$29(com.tencent.qqnt.bean.b param, int i3, KickMemberV2Result kickMemberV2Result, int i16, com.tencent.qqnt.report.m report, String str, String uniqueFrom) {
        int i17;
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        String str2 = param.troopUin;
        ArrayList<String> arrayList = new ArrayList<>();
        if (com.tencent.qqnt.e.d(i3)) {
            ArrayList<KickMemberResult> arrayList2 = kickMemberV2Result.rptKickResult;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "result.rptKickResult");
            Iterator<T> it = arrayList2.iterator();
            boolean z16 = false;
            while (true) {
                i17 = 2;
                if (!it.hasNext()) {
                    break;
                }
                KickMemberResult kickMemberResult = (KickMemberResult) it.next();
                if (com.tencent.qqnt.e.d(kickMemberResult.result)) {
                    arrayList.add(kickMemberResult.getUid());
                } else if (kickMemberResult.result == 2) {
                    z16 = true;
                }
            }
            if (!arrayList.isEmpty()) {
                ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopMemberInfoService.class);
                if (iTroopMemberInfoService != null) {
                    Iterator<String> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        iTroopMemberInfoService.deleteTroopMember(str2, param.i().get(it5.next()));
                    }
                }
                i17 = 1;
            }
            QLog.i(TAG, 1, "[deleteTroopMemberInner] errCode:" + i3 + ", errMsg:" + str + ", retCode:" + i17 + ", from:" + uniqueFrom + ", deleteUidList:" + arrayList);
            INSTANCE.notifyDeleteTroopMemberResult(str2, i16, i17, arrayList, param);
            com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, str, 2, null);
        }
        i17 = 3;
        QLog.i(TAG, 1, "[deleteTroopMemberInner] errCode:" + i3 + ", errMsg:" + str + ", retCode:" + i17 + ", from:" + uniqueFrom + ", deleteUidList:" + arrayList);
        INSTANCE.notifyDeleteTroopMemberResult(str2, i16, i17, arrayList, param);
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, str, 2, null);
    }

    private final TroopLifecycleCallback<Object> getCallbackStore() {
        return (TroopLifecycleCallback) callbackStore.getValue();
    }

    private final void inviteToGroupInner(final InviteToTroopParam param, final int id5, final String from, final String uniqueFrom) {
        i iVar;
        if (com.tencent.qqnt.e.c() == null) {
            QLog.e(TAG, 1, "[inviteToGroupInner] groupService is null");
            Object f16 = getCallbackStore().f(id5);
            if (f16 instanceof i) {
                iVar = (i) f16;
            } else {
                iVar = null;
            }
            onIllegalParams(iVar);
            return;
        }
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("inviteToGroupV2", param.troopUin, "TroopMemberOperationRepo-" + from, false, true, 8, null);
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.inviteToGroupV2(param.a(), new IInviteToGroupCallback() { // from class: com.tencent.qqnt.troop.bh
                @Override // com.tencent.qqnt.kernel.nativeinterface.IInviteToGroupCallback
                public final void onResult(int i3, String str, InviteToGroupRsp inviteToGroupRsp) {
                    TroopMemberOperationRepo.inviteToGroupInner$lambda$20(com.tencent.qqnt.report.m.this, param, from, id5, uniqueFrom, i3, str, inviteToGroupRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inviteToGroupInner$lambda$20(final com.tencent.qqnt.report.m report, final InviteToTroopParam param, final String from, final int i3, final String uniqueFrom, final int i16, final String str, final InviteToGroupRsp inviteToGroupRsp) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.bj
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberOperationRepo.inviteToGroupInner$lambda$20$lambda$19(i16, inviteToGroupRsp, param, from, i3, str, report, uniqueFrom);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inviteToGroupInner$lambda$20$lambda$19(int i3, InviteToGroupRsp inviteToGroupRsp, InviteToTroopParam param, String from, int i16, String msg2, com.tencent.qqnt.report.m report, String uniqueFrom) {
        TroopInfo troopInfo;
        TroopCreateInfo troopCreateInfo;
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        QLog.i(TAG, 1, "[inviteToGroupInner] from:" + uniqueFrom + ", code:" + i3 + ", msg:" + i3 + ", result:" + inviteToGroupRsp);
        i iVar = null;
        if (com.tencent.qqnt.e.d(i3)) {
            if (inviteToGroupRsp.currentMaxMsgSeq != 0) {
                ITroopCreateInfoService iTroopCreateInfoService = (ITroopCreateInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopCreateInfoService.class);
                if (iTroopCreateInfoService != null) {
                    troopCreateInfo = iTroopCreateInfoService.getTroopCreateInfo();
                } else {
                    troopCreateInfo = null;
                }
                if (troopCreateInfo != null) {
                    troopCreateInfo.maxSeq = inviteToGroupRsp.currentMaxMsgSeq;
                }
                QLog.i(TAG, 1, "[inviteToGroupInner] maxSeq:" + inviteToGroupRsp.currentMaxMsgSeq);
            }
            ITroopInfoService iTroopInfoService = (ITroopInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopInfoService.class);
            if (iTroopInfoService != null && (troopInfo = iTroopInfoService.getTroopInfo(param.troopUin)) != null && !troopInfo.hasSetTroopHead()) {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchNewTroopHeadUinList(param.troopUin);
            }
        } else if (i3 == 1537) {
            String str = inviteToGroupRsp.verifyUrl;
            int i17 = inviteToGroupRsp.verifyType;
            if (!TextUtils.isEmpty(str)) {
                param.from = from;
                param.callbackId = i16;
                com.tencent.mobileqq.troop.api.config.ag.g(str, i17, param);
                return;
            }
        }
        Object f16 = INSTANCE.getCallbackStore().f(i16);
        if (f16 instanceof i) {
            iVar = (i) f16;
        }
        if (iVar != null) {
            boolean d16 = com.tencent.qqnt.e.d(i3);
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            iVar.onResult(d16, i3, msg2);
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, msg2, 2, null);
    }

    private final void notifyDeleteTroopMemberResult(String troopUin, int callbackId, int retCode, ArrayList<String> deleteUids, com.tencent.qqnt.bean.b param) {
        c cVar;
        Object businessHandler;
        ArrayList<String> arrayList = new ArrayList<>(deleteUids.size());
        boolean z16 = true;
        if (!deleteUids.isEmpty()) {
            Iterator<T> it = deleteUids.iterator();
            while (it.hasNext()) {
                String str = param.i().get((String) it.next());
                if (str != null) {
                    arrayList.add(str);
                }
            }
        }
        Object f16 = getCallbackStore().f(callbackId);
        com.tencent.mobileqq.troop.api.handler.g gVar = null;
        if (f16 instanceof c) {
            cVar = (c) f16;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            if (retCode != 1) {
                z16 = false;
            }
            cVar.a(z16, retCode, arrayList);
        }
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null && (businessHandler = e16.getBusinessHandler(TroopMemberMngHandler.class.getName())) != null) {
            if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.g) {
                gVar = (com.tencent.mobileqq.troop.api.handler.g) businessHandler;
            }
            if (gVar != null) {
                gVar.i(retCode, troopUin, arrayList);
            }
        }
    }

    private final void onIllegalParams(i asyncCallback) {
        if (asyncCallback != null) {
            asyncCallback.onResult(false, -1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMemberShutUp$lambda$6(final com.tencent.qqnt.report.m report, String uniqueFrom, final int i3, final long j3, final String str, final String str2, final int i16, final String str3) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        report.f();
        QLog.i(TAG, 1, "[setMemberShutUp] from:" + uniqueFrom + " result:" + i16 + ", err:" + str3);
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.bn
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberOperationRepo.setMemberShutUp$lambda$6$lambda$5(i16, i3, str3, j3, report, str, str2);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMemberShutUp$lambda$6$lambda$5(int i3, int i16, String err, long j3, com.tencent.qqnt.report.m report, String str, String str2) {
        boolean z16;
        i iVar;
        Object businessHandler;
        com.tencent.mobileqq.troop.troopgag.api.a aVar;
        Intrinsics.checkNotNullParameter(report, "$report");
        if (i3 == 10) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        boolean d16 = com.tencent.qqnt.e.d(i3);
        Object f16 = INSTANCE.getCallbackStore().f(i16);
        if (f16 instanceof i) {
            iVar = (i) f16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            Intrinsics.checkNotNullExpressionValue(err, "err");
            iVar.onResult(d16, i3, err);
        }
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null && (businessHandler = e16.getBusinessHandler(TroopGagHandler.class.getName())) != null) {
            if (businessHandler instanceof com.tencent.mobileqq.troop.troopgag.api.a) {
                aVar = (com.tencent.mobileqq.troop.troopgag.api.a) businessHandler;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.u0(str, str2, d16, j3);
            }
        }
        com.tencent.mobileqq.troop.api.config.aa.a().c(com.tencent.mobileqq.troop.utils.bg.e(), j3, d16, z17);
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, err, 2, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void deleteTroopMember(@NotNull final com.tencent.qqnt.bean.b param, @Nullable LifecycleOwner owner, @NotNull final String from, @Nullable c asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, param, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(from, "from");
        final String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
        final int h16 = getCallbackStore().h(owner, asyncCallback);
        ArrayList<String> h17 = param.h();
        if (!h17.isEmpty()) {
            QLog.i(TAG, 1, "[deleteTroopMember] covertUin uinStringList:" + h17);
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).fetchUin2UidMap(h17, true, true, new IRelationNTUinAndUidApi.c() { // from class: com.tencent.qqnt.troop.bm
                @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.c
                public final void a(Map map) {
                    TroopMemberOperationRepo.deleteTroopMember$lambda$23(com.tencent.qqnt.bean.b.this, from, o16, h16, map);
                }
            });
            return;
        }
        deleteTroopMemberInner(param, from, o16, h16);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteMembersToGroup(@Nullable String groupCode, @Nullable List<? extends TroopCreateInfo.a> invitedMemberList, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, groupCode, invitedMemberList, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        InviteToTroopParam inviteToTroopParam = new InviteToTroopParam();
        inviteToTroopParam.troopUin = groupCode;
        if (invitedMemberList != null) {
            ArrayList<InviteToTroopUserInfo> arrayList = inviteToTroopParam.invitedUserList;
            List<? extends TroopCreateInfo.a> list = invitedMemberList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                TroopCreateInfo.a aVar = (TroopCreateInfo.a) it.next();
                arrayList2.add(new InviteToTroopUserInfo(aVar.f294787a, aVar.f294788b, aVar.f294792f, 0, 8, null));
            }
            arrayList.addAll(arrayList2);
        }
        inviteToGroup(inviteToTroopParam, owner, from, asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@Nullable String groupCode, @Nullable String memberUid, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupCode, memberUid, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (!(groupCode == null || groupCode.length() == 0)) {
            if (!(memberUid == null || memberUid.length() == 0)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(memberUid);
                inviteToGroup(groupCode, arrayListOf, owner, from, asyncCallback);
                return;
            }
        }
        QLog.i(TAG, 1, "[inviteToGroupWithUid] illegal params");
        onIllegalParams(asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void setMemberShutUp(@Nullable final String troopUin, @Nullable final String memberUid, final long gagTimeStamp, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        boolean z16;
        String str;
        boolean z17;
        Long longOrNull;
        ArrayList<GroupMemberShutUpInfo> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, memberUid, Long.valueOf(gagTimeStamp), owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (memberUid != null && memberUid.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17 && !Intrinsics.areEqual(troopUin, "0")) {
                final String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
                QLog.i(TAG, 1, "[setMemberShutUp] troopUin:" + troopUin + ", memberUid:" + memberUid + ", gagTimeStamp:" + gagTimeStamp + ", from:" + o16);
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                if (com.tencent.qqnt.e.c() != null && longOrNull != null) {
                    GroupMemberShutUpInfo groupMemberShutUpInfo = new GroupMemberShutUpInfo();
                    groupMemberShutUpInfo.uid = memberUid;
                    groupMemberShutUpInfo.timeStamp = (int) gagTimeStamp;
                    final int h16 = getCallbackStore().h(owner, asyncCallback);
                    final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("setMemberShutUp", troopUin, "TroopMemberOperationRepo-" + from, false, true, 8, null);
                    com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
                    if (c16 != null) {
                        long longValue = longOrNull.longValue();
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(groupMemberShutUpInfo);
                        c16.setMemberShutUp(longValue, arrayListOf, new IOperateCallback() { // from class: com.tencent.qqnt.troop.bk
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                            public final void onResult(int i3, String str2) {
                                TroopMemberOperationRepo.setMemberShutUp$lambda$6(com.tencent.qqnt.report.m.this, o16, h16, gagTimeStamp, troopUin, memberUid, i3, str2);
                            }
                        });
                        return;
                    }
                    return;
                }
                QLog.i(TAG, 1, "[setMemberShutUp] illegal params");
                onIllegalParams(asyncCallback);
                return;
            }
        }
        if (gagTimeStamp == 0) {
            str = "\u89e3\u9664\u7981\u8a00\u5931\u8d25";
        } else {
            str = "\u8bbe\u7f6e\u7981\u8a00\u5931\u8d25";
        }
        com.tencent.qqnt.e.k(null, 1, str, 0, null, 25, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@Nullable String groupCode, @Nullable ArrayList<String> invitedUidList, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, groupCode, invitedUidList, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        InviteToTroopParam inviteToTroopParam = new InviteToTroopParam();
        inviteToTroopParam.troopUin = groupCode;
        if (invitedUidList != null) {
            ArrayList<InviteToTroopUserInfo> arrayList = inviteToTroopParam.invitedUserList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(invitedUidList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = invitedUidList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new InviteToTroopUserInfo(null, (String) it.next(), null, 0, 13, null));
            }
            arrayList.addAll(arrayList2);
        }
        inviteToGroup(inviteToTroopParam, owner, from, asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@NotNull InviteToTroopParam param, @NotNull String from, boolean securityPass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, param, from, Boolean.valueOf(securityPass));
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(from, "from");
        if (securityPass) {
            inviteToGroupInner(param, param.callbackId, from + "-" + param.from, from + "-" + param.from + "-" + param.callbackId);
            return;
        }
        Object f16 = getCallbackStore().f(param.callbackId);
        i iVar = f16 instanceof i ? (i) f16 : null;
        if (iVar != null) {
            iVar.onResult(false, -1, "");
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@NotNull InviteToTroopParam param, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, param, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(from, "from");
        String o16 = com.tencent.qqnt.e.o(from, asyncCallback);
        QLog.i(TAG, 1, "[inviteToGroup] param:" + param + ", from:" + o16);
        inviteToGroupInner(param, getCallbackStore().h(owner, asyncCallback), from, o16);
    }
}
