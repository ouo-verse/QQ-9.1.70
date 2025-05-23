package com.tencent.mobileqq.troop.topicrecommend.api.impl;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.e;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupAuthority;
import com.tencent.qqnt.kernel.nativeinterface.GroupPermission;
import com.tencent.qqnt.kernel.nativeinterface.GroupPermissions;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITopicRecallCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITopicReportCallback;
import com.tencent.qqnt.kernel.nativeinterface.TopicFeedbackReq;
import com.tencent.qqnt.kernel.nativeinterface.TopicRecallReq;
import com.tencent.qqnt.kernel.nativeinterface.TopicReportReq;
import com.tencent.qqnt.kernel.nativeinterface.TopicReportRsp;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/topicrecommend/api/impl/TroopTopicRecommendApiImpl;", "Lcom/tencent/mobileqq/troop/topicrecommend/api/ITroopTopicRecommendApi;", "", "groupCode", "recallId", "Lcom/tencent/qqnt/kernel/nativeinterface/ITopicRecallCallback;", "callback", "", "getTopicRecall", "Lcom/tencent/mobileqq/troop/topicrecommend/a;", "data", "topicFeedback", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "isPushAIO", "troopUin", "isSwitchOn", "Lcom/tencent/mobileqq/troop/topicrecommend/b;", "getTroopExpandInfo", "onClickNavigation", "isTroopAIVoiceChatActive", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTopicRecommendApiImpl implements ITroopTopicRecommendApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String GET_STOP_REPORT_SECONDS = "get_stop_report_seconds";

    @NotNull
    private static final String TAG = "TroopTopicRecommendApiImpl";

    @NotNull
    private static final String TOPIC_SWITCH_GROUP_ID = "103169";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/topicrecommend/api/impl/TroopTopicRecommendApiImpl$a;", "", "", "GET_STOP_REPORT_SECONDS", "Ljava/lang/String;", "TAG", "TOPIC_SWITCH_GROUP_ID", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.topicrecommend.api.impl.TroopTopicRecommendApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTopicRecommendApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClickNavigation$lambda$6(int i3, String str, TopicReportRsp topicReportRsp) {
        if (e.d(i3)) {
            QLog.i(TAG, 1, "topicReport result" + i3 + " stopReportSeconds: " + topicReportRsp.stopReportSeconds);
            if (topicReportRsp.stopReportSeconds > 0) {
                com.tencent.mobileqq.troop.config.a.f294689a.w(GET_STOP_REPORT_SECONDS, NetConnInfoCenter.getServerTime() + topicReportRsp.stopReportSeconds, true);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "topicReport result" + i3 + " err: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void topicFeedback$lambda$2(com.tencent.mobileqq.troop.topicrecommend.a data, int i3, String str) {
        Intrinsics.checkNotNullParameter(data, "$data");
        QLog.i(TAG, 1, "topicFeedback result " + i3 + " err: " + str + " " + data.e());
    }

    @Override // com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi
    public void getTopicRecall(@NotNull String groupCode, @Nullable String recallId, @NotNull ITopicRecallCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, groupCode, recallId, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TopicRecallReq topicRecallReq = new TopicRecallReq();
        topicRecallReq.groupCode = StringUtils.toLong(groupCode);
        if (recallId != null) {
            topicRecallReq.recallId = recallId;
        }
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.getTopicRecall(topicRecallReq, callback);
        }
    }

    @Override // com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi
    @NotNull
    public com.tencent.mobileqq.troop.topicrecommend.b getTroopExpandInfo(@NotNull String troopUin) {
        GroupPermissions groupPermissions;
        ArrayList<GroupPermission> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.topicrecommend.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        com.tencent.mobileqq.troop.topicrecommend.b bVar = new com.tencent.mobileqq.troop.topicrecommend.b(false, 0L, 3, null);
        bVar.d(isSwitchOn(troopUin));
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null && (groupPermissions = troopInfoFromCache.groupPermissions) != null && (arrayList = groupPermissions.permissions) != null) {
            for (GroupPermission groupPermission : arrayList) {
                if (groupPermission.key == 10001) {
                    bVar.c(groupPermission.authority.eventIntVal);
                }
            }
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi
    public boolean isPushAIO(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        String string = aioContext.g().l().getString("key_from", "");
        QLog.d(TAG, 1, "enter aio from " + string);
        return Intrinsics.areEqual(string, "10");
    }

    @Override // com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi
    public boolean isSwitchOn(@NotNull String troopUin) {
        boolean z16;
        ArrayList<GroupPermission> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache == null || troopInfoFromCache.isExited()) {
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(TOPIC_SWITCH_GROUP_ID, false);
        GroupPermissions groupPermissions = troopInfoFromCache.groupPermissions;
        long j3 = 0;
        if (groupPermissions != null && (arrayList = groupPermissions.permissions) != null) {
            z16 = false;
            for (GroupPermission groupPermission : arrayList) {
                if (groupPermission.key == 10001) {
                    GroupAuthority groupAuthority = groupPermission.authority;
                    if (groupAuthority.switchVal == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    j3 = groupAuthority.eventIntVal;
                }
            }
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "isSwitchOn,troopUin is " + troopUin + " mainSwitchOn:" + isSwitchOn + ", childSwitchOn:" + z16 + " ,time:" + j3);
        if (!isSwitchOn || !z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi
    public boolean isTroopAIVoiceChatActive(@Nullable com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aioContext)).booleanValue();
        }
        if (aioContext == null) {
            return false;
        }
        boolean z16 = aioContext.g().l().getBoolean(ITroopAIVoiceChatApi.PARAMS_KEY_IS_AI_VOICE_CHAT_ACTIVE, false);
        QLog.d(TAG, 1, "[isTroopAIVoiceChatActive] rtn " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi
    public void onClickNavigation(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        boolean isSwitchOn = isSwitchOn(troopUin);
        long k3 = com.tencent.mobileqq.troop.config.a.f294689a.k(GET_STOP_REPORT_SECONDS, 0L, true);
        if (isSwitchOn && NetConnInfoCenter.getServerTime() > k3) {
            TopicReportReq topicReportReq = new TopicReportReq();
            topicReportReq.groupCode = StringUtils.toLong(troopUin);
            topicReportReq.reportType = 1;
            s i3 = bg.i(null, 1, null);
            if (i3 != null) {
                i3.topicReport(topicReportReq, new ITopicReportCallback() { // from class: com.tencent.mobileqq.troop.topicrecommend.api.impl.b
                    @Override // com.tencent.qqnt.kernel.nativeinterface.ITopicReportCallback
                    public final void onResult(int i16, String str, TopicReportRsp topicReportRsp) {
                        TroopTopicRecommendApiImpl.onClickNavigation$lambda$6(i16, str, topicReportRsp);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.topicrecommend.api.ITroopTopicRecommendApi
    public void topicFeedback(@NotNull final com.tencent.mobileqq.troop.topicrecommend.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        TopicFeedbackReq topicFeedbackReq = new TopicFeedbackReq();
        topicFeedbackReq.groupCode = StringUtils.toLong(data.a());
        topicFeedbackReq.type = data.e();
        topicFeedbackReq.source = data.d();
        topicFeedbackReq.recallId = data.c();
        topicFeedbackReq.itemId = data.b();
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.topicFeedback(topicFeedbackReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.topicrecommend.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    TroopTopicRecommendApiImpl.topicFeedback$lambda$2(com.tencent.mobileqq.troop.topicrecommend.a.this, i16, str);
                }
            });
        }
    }
}
