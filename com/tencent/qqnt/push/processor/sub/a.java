package com.tencent.qqnt.push.processor.sub;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopPushHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.onlinepush.api.impl.TroopOnlinePushHandler;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x857.TroopTips0x857$GroupInfoChange;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/push/processor/sub/a;", "Lcom/tencent/qqnt/push/b;", "", "troopUin", "Ltencent/im/oidb/cmd0x857/TroopTips0x857$GroupInfoChange;", "groupInfoChange", "", "f", "d", "c", "e", "b", "", "notifyMsgBody", "Lcom/tencent/qqnt/push/bean/a;", "commonInfo", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements com.tencent.qqnt.push.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/push/processor/sub/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.sub.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(String troopUin, TroopTips0x857$GroupInfoChange groupInfoChange) {
        boolean z16;
        long serverTime;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && groupInfoChange.uint64_conf_uin.has() && groupInfoChange.uint32_conf_max_msg_seq.has()) {
            String valueOf = String.valueOf(groupInfoChange.uint64_conf_uin.get());
            long j3 = groupInfoChange.uint32_conf_max_msg_seq.get();
            if (groupInfoChange.has()) {
                serverTime = groupInfoChange.uint32_conf_to_group_time.get();
            } else {
                serverTime = NetConnInfoCenter.getServerTime();
            }
            long j16 = serverTime;
            QLog.d("GroupInfoChangeSubProcessor", 1, "[handleDiscussToTroopPush] troopUin:" + troopUin + ", discussUin:" + valueOf + ", maxSeq:" + j3);
            if (!TextUtils.isEmpty(valueOf) && j3 > 0) {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).recordDiscussToTroopOp(troopUin, valueOf, j3, j16);
            }
        }
    }

    private final void c(String troopUin, TroopTips0x857$GroupInfoChange groupInfoChange) {
        BusinessHandler businessHandler;
        AppInterface e16 = bg.e();
        ITroopPushHandler iTroopPushHandler = null;
        if (e16 != null) {
            businessHandler = e16.getBusinessHandler(TroopPushHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof ITroopPushHandler) {
            iTroopPushHandler = (ITroopPushHandler) businessHandler;
        }
        if (groupInfoChange.uint32_group_class_ext.has() && iTroopPushHandler != null) {
            iTroopPushHandler.I1(troopUin, groupInfoChange.uint32_group_class_ext.get());
        }
    }

    private final void d(String troopUin, TroopTips0x857$GroupInfoChange groupInfoChange) {
        TroopInfo troopInfo;
        if (!groupInfoChange.uint32_group_member_level_switch.has()) {
            return;
        }
        int i3 = groupInfoChange.uint32_group_member_level_switch.get();
        QLog.d("GroupInfoChangeSubProcessor", 1, "[tryUpdateMemberLevelSwitch] troopUin:" + troopUin + ", switch:" + i3);
        ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
        if (iTroopInfoService != null) {
            troopInfo = iTroopInfoService.getTroopInfo(troopUin);
        } else {
            troopInfo = null;
        }
        if (troopInfo != null) {
            QLog.d("GroupInfoChangeSubProcessor", 1, "[tryUpdateMemberLevelSwitch] updateTroopLevelSwitch troopUin:" + troopUin);
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopLevelSwitch(troopUin, null, Byte.valueOf((byte) i3));
            AppInterface e16 = bg.e();
            if (e16 != null) {
                e16.getBusinessHandler(TroopInfoHandler.class.getName()).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, troopUin);
                BusinessHandler businessHandler = e16.getBusinessHandler(TroopOnlinePushHandler.class.getName());
                int i16 = com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_TROOP_RANK_SWITCH_CHANGE;
                Object[] objArr = new Object[2];
                boolean z16 = false;
                objArr[0] = troopUin;
                if (i3 == 0) {
                    z16 = true;
                }
                objArr[1] = Boolean.valueOf(z16);
                businessHandler.notifyUI(i16, true, objArr);
            }
        }
    }

    private final void e(String troopUin, TroopTips0x857$GroupInfoChange groupInfoChange) {
        TroopInfo troopInfo;
        boolean z16;
        BusinessHandler businessHandler;
        if (!groupInfoChange.uint32_group_flag.has()) {
            return;
        }
        int i3 = groupInfoChange.uint32_group_flag.get();
        QLog.d("GroupInfoChangeSubProcessor", 1, "[process] troopUin:" + troopUin + ", flag:" + i3);
        ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
        Long l3 = null;
        if (iTroopInfoService != null) {
            troopInfo = iTroopInfoService.getTroopInfo(troopUin);
        } else {
            troopInfo = null;
        }
        if (troopInfo != null) {
            if ((i3 & 128) == 128) {
                z16 = true;
            } else {
                z16 = false;
            }
            troopInfo.isTroopBlocked = z16;
            if (groupInfoChange.uint32_appeal_deadline.has()) {
                long j3 = groupInfoChange.uint32_appeal_deadline.get();
                troopInfo.appealDeadline = j3;
                l3 = Long.valueOf(j3);
            }
            QLog.d("GroupInfoChangeSubProcessor", 1, "[tryUpdateTroopFlag] isTroopBlocked:" + z16 + ", dealLine:" + l3);
            AppInterface e16 = bg.e();
            if (e16 != null && (businessHandler = e16.getBusinessHandler(TroopOnlinePushHandler.class.getName())) != null) {
                businessHandler.notifyUI(com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_TROOP_BLOCK_STATUS_CHANGED, true, new Object[]{troopUin});
                return;
            }
            return;
        }
        QLog.d("GroupInfoChangeSubProcessor", 1, "[tryUpdateTroopFlag] troopInfo = null!!");
    }

    private final void f(String troopUin, TroopTips0x857$GroupInfoChange groupInfoChange) {
        if (!groupInfoChange.uint32_group_honor_switch.has()) {
            return;
        }
        int i3 = groupInfoChange.uint32_group_honor_switch.get();
        boolean z16 = true;
        QLog.d("GroupInfoChangeSubProcessor", 1, "[tryUpdateTroopHonor] troopUin:" + troopUin + ", switch:" + i3);
        ITroopHonorService iTroopHonorService = (ITroopHonorService) bg.l(ITroopHonorService.class);
        if (iTroopHonorService != null) {
            if (i3 != 0) {
                z16 = false;
            }
            iTroopHonorService.updateTroopHonorAIOSwitch(troopUin, z16);
        }
    }

    @Override // com.tencent.qqnt.push.b
    public void a(@Nullable Object notifyMsgBody, @NotNull com.tencent.qqnt.push.bean.a commonInfo) {
        TroopTips0x857$GroupInfoChange troopTips0x857$GroupInfoChange;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, notifyMsgBody, (Object) commonInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        if (notifyMsgBody instanceof TroopTips0x857$NotifyMsgBody) {
            TroopTips0x857$NotifyMsgBody troopTips0x857$NotifyMsgBody = (TroopTips0x857$NotifyMsgBody) notifyMsgBody;
            if (troopTips0x857$NotifyMsgBody.opt_msg_group_info_change.has() && (troopTips0x857$GroupInfoChange = troopTips0x857$NotifyMsgBody.opt_msg_group_info_change.get()) != null) {
                String valueOf = String.valueOf(commonInfo.a());
                f(valueOf, troopTips0x857$GroupInfoChange);
                d(valueOf, troopTips0x857$GroupInfoChange);
                c(valueOf, troopTips0x857$GroupInfoChange);
                e(valueOf, troopTips0x857$GroupInfoChange);
                b(valueOf, troopTips0x857$GroupInfoChange);
            }
        }
    }
}
