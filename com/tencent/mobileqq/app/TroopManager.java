package com.tencent.mobileqq.app;

import GROUP.MessageRemindRsp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.config.c;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqguildsdk.data.type.IPermissionType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
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
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.nt.api.IRelationMsgService;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.troop.honor.troop_honor$HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor$UserHonor;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TroopManager implements Manager, c.b {
    static IPatchRedirector $redirector_;
    public static String L;
    public static String M;
    public static String N;
    public static String P;
    public static String Q;
    public static String R;
    public static String S;
    public static String T;
    public static String U;
    public static String V;
    public static String W;
    public static ArrayList<String> X;
    public static ArrayList<String> Y;
    private com.tencent.qqnt.kernel.api.s C;
    private final Object D;
    private IKernelGroupListener E;
    protected ArrayList<String> F;
    HashMap<String, String> G;
    private com.tencent.mobileqq.relationx.batchAdd.c H;
    protected Set<String> I;
    protected Set<String> J;
    private e K;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f195134d;

    /* renamed from: e, reason: collision with root package name */
    protected EntityManager f195135e;

    /* renamed from: f, reason: collision with root package name */
    private gf0.a f195136f;

    /* renamed from: h, reason: collision with root package name */
    Queue<Integer> f195137h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.e f195138i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.troop.troopmanager.api.b f195139m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements IOperateCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManager.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopManager", 2, "deleteTroopWithoutDB deleteRecentContacts! result " + i3 + " errMsg " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements IAddJsonGrayTipMsgCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManager.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
        public void onResult(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            QLog.d("TroopManager", 1, "[addLocalGrayTip] GROUP_AIO_UPLOAD_PERMISSIONS_GRAY_TIP_ID result = " + i3 + ", msgId = " + j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManager.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onModifyTroopInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList, str);
                return;
            }
            if (arrayList != null && arrayList.size() > 0) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TroopMemberCardInfo troopMemberCardInfo = arrayList.get(i3);
                    ((ITroopMemberInfoService) TroopManager.this.f195134d.getRuntimeService(ITroopMemberInfoService.class, "")).notifyChangeMember(troopMemberCardInfo.troopuin, troopMemberCardInfo.memberuin);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d extends com.tencent.mobileqq.troop.troopmanager.api.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManager.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.b
        protected void onActiveExtTroop(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            QLog.i("troop_ext", 1, "onActiveExtTroop success: " + z16 + " troopUin: " + str);
            if (z16 && !TextUtils.isEmpty(str)) {
                ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(str, "TroopManager", null, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f195145a;

        /* renamed from: b, reason: collision with root package name */
        private int f195146b;

        e(QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
                return;
            }
            this.f195145a = 0;
            this.f195146b = 0;
            TroopManager.D0(qQAppInterface);
        }

        public String a(QQAppInterface qQAppInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, i3);
            }
            if (i3 == 0) {
                this.f195145a = (int) (Math.random() * TroopManager.X.size());
                if (TroopManager.X.size() == 1) {
                    String str = TroopManager.X.get(0);
                    TroopManager.D0(qQAppInterface);
                    return str;
                }
                if (this.f195145a < TroopManager.X.size()) {
                    String str2 = TroopManager.X.get(this.f195145a);
                    TroopManager.X.remove(this.f195145a);
                    return str2;
                }
            } else if (this.f195146b < TroopManager.Y.size()) {
                String str3 = TroopManager.Y.get(this.f195146b);
                this.f195146b = (this.f195146b + 1) % TroopManager.Y.size();
                return str3;
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface f extends ITroopMemberInfoService.a {
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        public static boolean a(int i3) {
            if ((i3 & 2) != 0) {
                return true;
            }
            return false;
        }

        public static boolean b(int i3) {
            if (i3 != 0) {
                return true;
            }
            return false;
        }

        public static boolean c(int i3) {
            if ((i3 & 1) != 0) {
                return true;
            }
            return false;
        }

        public static void d(Context context, String str, String str2) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", QVIPPrettyTroopProcessor.get().getMineUrl(str2, str));
            intent.putExtra("hide_operation_bar", true);
            context.startActivity(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class h implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f195147a;

        /* renamed from: b, reason: collision with root package name */
        public String f195148b;

        /* renamed from: c, reason: collision with root package name */
        public int f195149c;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManager.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
        public void a(TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
                return;
            }
            if (troopMemberInfo != null && !TextUtils.isEmpty(this.f195147a) && !TextUtils.isEmpty(this.f195148b) && this.f195147a.equals(troopMemberInfo.memberuin)) {
                com.tencent.mobileqq.troop.change.troopmemberinfo.b bVar = new com.tencent.mobileqq.troop.change.troopmemberinfo.b();
                bVar.b(troopMemberInfo);
                troopMemberInfo.realLevel = this.f195149c;
                bVar.a(troopMemberInfo);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopManager", 2, "newRealLevel:" + this.f195149c + ",troopUin : " + this.f195148b + ",memberUin" + this.f195147a);
                }
                bVar.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class i implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private void a(String str, long j3, int i3) {
            JSONObject jSONObject = new JSONObject();
            String valueOf = String.valueOf(j3);
            String valueOf2 = String.valueOf(i3);
            try {
                jSONObject.put(Utils.KEY_BUSINESS_ID, str);
                jSONObject.put("gc", valueOf);
                jSONObject.put("action", valueOf2);
            } catch (JSONException e16) {
                QLog.e("TroopManager", 1, "jsonObj.put", e16);
            }
            try {
                ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.mannounce", "", "UpdateAnnounce", jSONObject.toString());
                ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.announce.lua", "", "UpdateAnnounce", jSONObject.toString());
            } catch (UnsatisfiedLinkError e17) {
                QLog.e("TroopManager", 1, "Error: troop arkNotify com.tencent.mannounce error. UpdateAnnounce.", e17);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
            com.tencent.qqnt.kernel.nativeinterface.am.a(this, j3, str, groupBulletinListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAdd(long j3) {
            com.tencent.qqnt.kernel.nativeinterface.am.b(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.c(this, groupAllInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.d(this, j3, groupArkInviteStateInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
            com.tencent.qqnt.kernel.nativeinterface.am.e(this, j3, groupBulletin);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), remindGroupBulletinMsg);
                return;
            }
            if (remindGroupBulletinMsg == null) {
                QLog.e("TroopManager", 1, "onGroupBulletinRemindNotify groupCode: " + j3 + " notifies is null");
                return;
            }
            int action = remindGroupBulletinMsg.getAction();
            if (action != 0) {
                if (action == 1 || action == 2) {
                    a(remindGroupBulletinMsg.getFeedId(), remindGroupBulletinMsg.getGroupCode(), remindGroupBulletinMsg.getAction());
                    return;
                }
                return;
            }
            com.tencent.mobileqq.troop.utils.aw.f(j3, remindGroupBulletinMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.g(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.h(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.i(this, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.j(this, groupDetailInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupEssenceListChange(long j3) {
            com.tencent.qqnt.kernel.nativeinterface.am.k(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.l(this, groupExtListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) firstGroupBulletinInfo);
                return;
            }
            com.tencent.mobileqq.troop.utils.aw.g(firstGroupBulletinInfo);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (firstGroupBulletinInfo != null && (peekAppRuntime instanceof QQAppInterface)) {
                com.tencent.mobileqq.service.message.p.I(firstGroupBulletinInfo.getFromUin(), (int) firstGroupBulletinInfo.getMsgSeq(), firstGroupBulletinInfo.getMsgUid(), (int) firstGroupBulletinInfo.getMsgType(), ((QQAppInterface) peekAppRuntime).getMsgHandler().getApp());
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListInited(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.am.n(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.o(this, groupListUpdateType, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.p(this, j3, groupMemberLevelInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
            com.tencent.qqnt.kernel.nativeinterface.am.q(this, z16, j3, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
            com.tencent.qqnt.kernel.nativeinterface.am.r(this, z16, j3, i3, i16, i17, i18);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.s(this, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            com.tencent.qqnt.kernel.nativeinterface.am.t(this, z16, j3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.u(this, z16, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
            com.tencent.qqnt.kernel.nativeinterface.am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.w(this, j3, groupStatisticInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
            com.tencent.qqnt.kernel.nativeinterface.am.y(this, j3, z16, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
            com.tencent.qqnt.kernel.nativeinterface.am.z(this, joinGroupNotifyMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.am.A(this, j3, dataSource, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onMemberListChange(GroupMemberListChangeInfo groupMemberListChangeInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.B(this, groupMemberListChangeInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.am.C(this, str, str2, arrayList, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.D(this, j3, arrayList);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(IPermissionType.MODIFY_CHANNEL_VIEW);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 101)) {
            redirector.redirect((short) 101);
            return;
        }
        L = "next_get_expire_time";
        M = "big_troop_expired_info";
        N = "troop_expired_notify_tips_count";
        P = "troop_expired_notify_tips_last_time";
        Q = "troop_expired_notify_tips_one_day_count";
        R = "troop_expired_notify_tips_close_count";
        S = "troop_expired_notify_count";
        T = "troop_expired_notify_dialog_last_time";
        U = "troop_expired_notify_dialog_is_show";
        V = "troop_expired_notify_dialog_one_day_count";
        W = "troop_expired_notify_dialog_last_day";
        X = new ArrayList<>();
        Y = new ArrayList<>();
    }

    public TroopManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195137h = new LinkedList();
        this.f195138i = new c();
        this.f195139m = new d();
        this.D = new Object();
        this.F = new ArrayList<>();
        this.G = new HashMap<>();
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.f195134d = qQAppInterface;
        this.f195135e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        qQAppInterface.addObserver(this.f195139m, true);
        qQAppInterface.addObserver(this.f195138i, true);
        P();
    }

    public static void D0(QQAppInterface qQAppInterface) {
        X.clear();
        Y.clear();
        c0(qQAppInterface, X, Y);
        if (X.isEmpty()) {
            X.addAll(Arrays.asList(HardCodeUtil.qqStr(R.string.ukc), HardCodeUtil.qqStr(R.string.ujz), HardCodeUtil.qqStr(R.string.ujv), HardCodeUtil.qqStr(R.string.uk6), HardCodeUtil.qqStr(R.string.ujf), HardCodeUtil.qqStr(R.string.ujl), HardCodeUtil.qqStr(R.string.f172831uk3)));
        }
        if (Y.isEmpty()) {
            Y.addAll(Arrays.asList(HardCodeUtil.qqStr(R.string.uke), HardCodeUtil.qqStr(R.string.ujp), HardCodeUtil.qqStr(R.string.ukd), HardCodeUtil.qqStr(R.string.f172829uk0), HardCodeUtil.qqStr(R.string.ukf), HardCodeUtil.qqStr(R.string.uk5), HardCodeUtil.qqStr(R.string.uj7), HardCodeUtil.qqStr(R.string.f172827uj3), HardCodeUtil.qqStr(R.string.ujj)));
        }
    }

    private SearchConfig.a E(TroopInfo troopInfo, boolean z16) {
        SearchConfigManager.d(this.f195134d);
        ArrayList<SearchConfig.a> arrayList = SearchConfig.troopMemberUpdateConfigs;
        SearchConfig.a aVar = null;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        Iterator<SearchConfig.a> it = SearchConfig.troopMemberUpdateConfigs.iterator();
        while (it.hasNext()) {
            SearchConfig.a next = it.next();
            if (z16) {
                if (aVar == null || aVar.f283101b > next.f283101b) {
                    aVar = next;
                }
            } else {
                int i3 = troopInfo.wMemberNum;
                if (i3 > next.f283100a && i3 < next.f283101b) {
                    return next;
                }
            }
        }
        return aVar;
    }

    private void P() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.df
            @Override // java.lang.Runnable
            public final void run() {
                TroopManager.this.b0();
            }
        }, 16, null, true);
    }

    public static boolean T(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord.isOpenTroopMessage) {
            return true;
        }
        if (messageRecord.istroop != 1) {
            return false;
        }
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && troopManager.Q(messageRecord.frienduin)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        if ((r10 % r3) != (r0 % r3)) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006b, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[Catch: Exception -> 0x00af, TRY_LEAVE, TryCatch #0 {Exception -> 0x00af, blocks: (B:32:0x008e, B:34:0x00a3), top: B:31:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean U(TroopInfo troopInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        boolean z19 = false;
        int i16 = this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin(), 0).getInt(ITroopMemberInfoService.IS_FIRST_UPGRADE_TO_500, 0);
        if (i16 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        SearchConfig.a E = E(troopInfo, z16);
        if (E == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z16 && E != null) {
            int i17 = troopInfo.wMemberNum;
            if (i17 > E.f283100a && i17 < E.f283101b) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        long abs = Math.abs(System.currentTimeMillis() - p(this.f195134d, troopInfo.troopuin));
        if (z17) {
            if (NetworkUtil.isWifiConnected(this.f195134d.getApp())) {
                if (z17 && abs > E.f283102c * 3600000 * 2 && abs > E.f283103d * 3600000) {
                    z18 = true;
                }
            } else if (z17) {
                z18 = true;
            }
            if (i16 == 2 && z17 && !z18) {
                try {
                    long parseLong = Long.parseLong(troopInfo.troopuin);
                    int i18 = Calendar.getInstance().get(5);
                    i3 = E.f283102c / 24;
                    if (i3 != 0) {
                    }
                    z19 = z17;
                    z17 = z19;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TroopManagertroop", 2, String.format("needGetMemberListForFTS, except: %s", e16.getMessage()));
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopManagertroop", 2, "isOverTimeForMemberList: (" + z17 + ") " + troopInfo.troopuin + " " + troopInfo.troopname + "seq(" + troopInfo.mMemberCardSeq + "/" + troopInfo.mMemberNumSeq + ") timeDiff: " + abs + " " + E);
            }
            return z17;
        }
        z18 = false;
        if (i16 == 2) {
            long parseLong2 = Long.parseLong(troopInfo.troopuin);
            int i182 = Calendar.getInstance().get(5);
            i3 = E.f283102c / 24;
            if (i3 != 0) {
            }
            z19 = z17;
            z17 = z19;
        }
        if (QLog.isColorLevel()) {
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        QRoute.api(ITroopLinkApi.class);
        com.tencent.mobileqq.relationx.batchAdd.d.f280711a.a();
        synchronized (this.D) {
            com.tencent.qqnt.kernel.api.s groupService = ((IKernelService) this.f195134d.getRuntimeService(IKernelService.class, "")).getGroupService();
            this.C = groupService;
            if (groupService != null) {
                i iVar = new i();
                this.E = iVar;
                this.C.D(iVar);
            }
        }
    }

    private static void c0(QQAppInterface qQAppInterface, List<String> list, List<String> list2) {
        PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp());
        String currentUin = qQAppInterface.getCurrentUin();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String decodeString = from.decodeString("troop_pobing_config_left_wording_" + currentUin, "");
        String decodeString2 = from.decodeString("troop_pobing_config_right_wording_" + currentUin, "");
        if (!TextUtils.isEmpty(decodeString)) {
            try {
                JSONArray jSONArray = new JSONArray(decodeString);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String optString = jSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        list.add(optString);
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(decodeString2)) {
            try {
                JSONArray jSONArray2 = new JSONArray(decodeString2);
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    String optString2 = jSONArray2.optString(i16);
                    if (!TextUtils.isEmpty(optString2)) {
                        list2.add(optString2);
                    }
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    private void h(AppRuntime appRuntime, TroopInfo troopInfo) {
        if (appRuntime != null && troopInfo != null && ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopInfo)) {
            QLog.d("TroopManager", 1, "cleanTroopGuildUnread troopUin = " + troopInfo.troopuin);
            ((ITroopGuildUnreadCntService) appRuntime.getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(troopInfo.troopuin, GuildGroupSceneType.KALL, true);
        }
    }

    public static void i0(QQAppInterface qQAppInterface, String str, JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null && jSONArray2 != null) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            from.encodeString("troop_pobing_config_left_wording_" + str, jSONArray.toString());
            from.encodeString("troop_pobing_config_right_wording_" + str, jSONArray2.toString());
        }
    }

    public static long p(AppRuntime appRuntime, String str) {
        return appRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("key_check_stamp" + appRuntime.getAccount() + "_" + str, 0L);
    }

    public static MessageRemindRsp t(AppRuntime appRuntime, String str) {
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            String str2 = M + "_" + appRuntime.getCurrentAccountUin() + "_" + str;
            String str3 = str2 + "_migrate_key";
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            if (!from.decodeBool(str3, false)) {
                from.encodeString(str2, appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin() + "_" + str, 4).getString(M, ""));
                from.encodeBool(str3, true);
            }
            String decodeString = from.decodeString(str2, "");
            if (!TextUtils.isEmpty(decodeString)) {
                MessageRemindRsp messageRemindRsp = new MessageRemindRsp();
                messageRemindRsp.readFrom(new JceInputStream(com.tencent.weiyun.utils.Utils.hexStr2Bytes(decodeString)));
                return messageRemindRsp;
            }
        }
        return null;
    }

    public int A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Integer) iPatchRedirector.redirect((short) 72, (Object) this, (Object) str)).intValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(P, 0);
    }

    @Deprecated
    public void A0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            ((IUniqueTitleService) this.f195134d.getRuntimeService(IUniqueTitleService.class, "")).setUniqueTitleNewFlag(i3);
        }
    }

    @Deprecated
    public TroopInfo B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
    }

    public void B0(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, str, Integer.valueOf(i3), str2);
            return;
        }
        String str3 = str2 + "upgrade_troop_notify_" + this.f195134d.getCurrentAccountUin() + "_" + str;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeBool(str3 + "_migrate_key", true);
        from.encodeInt(str3, i3);
    }

    public ArrayList<String> C(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (ArrayList) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).getTroopMemberForTroopHead(str);
    }

    @Deprecated
    public void C0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) str, i3);
        } else {
            B0(str, i3, "");
        }
    }

    @Deprecated
    public void D(String str, String str2, String str3, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, str2, str3, fVar);
        } else {
            ((ITroopMemberInfoService) this.f195134d.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(str, str2, str3, fVar);
        }
    }

    @Deprecated
    public String F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).getTroopNameByID(str);
    }

    @Deprecated
    public String G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).getTroopUin(str);
    }

    public String H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).getTroopUinByTroopCode(str);
    }

    @Deprecated
    public int I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return ((IUniqueTitleService) this.f195134d.getRuntimeService(IUniqueTitleService.class, "")).getUniqueTitleNewFlag();
    }

    public List<TroopNotificationCache> J(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (List) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        }
        if (str == null || this.f195134d == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<? extends Entity> query = this.f195135e.query(TroopNotificationCache.class, true, "troopUin=? and read=? and currentUin=?", new String[]{str, "0", this.f195134d.getCurrentAccountUin()}, null, null, "time ASC", null);
        if (query == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < query.size(); i3++) {
            TroopNotificationCache troopNotificationCache = (TroopNotificationCache) query.get(i3);
            if (!hashMap.containsKey(troopNotificationCache.feedsId)) {
                arrayList.add(troopNotificationCache);
                hashMap.put(troopNotificationCache.feedsId, 1);
            }
        }
        return arrayList;
    }

    public int K(String str, String str2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Integer) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        String str3 = str2 + "upgrade_troop_notify_" + this.f195134d.getCurrentAccountUin() + "_" + str;
        String str4 = str3 + "_migrate_key";
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (!from.decodeBool(str4, false) && (i3 = this.f195134d.getPreferences().getInt(str3, 0)) > 0) {
            from.encodeInt(str3, i3);
        }
        return from.decodeInt(str3, 0);
    }

    @Deprecated
    public int L(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this, (Object) str)).intValue();
        }
        return K(str, "");
    }

    public e M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return (e) iPatchRedirector.redirect((short) 94, (Object) this);
        }
        if (this.K == null) {
            this.K = new e(this.f195134d);
        }
        return this.K;
    }

    public void N(String str, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, this, str, bArr, Integer.valueOf(i3));
            return;
        }
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            try {
                troop_honor$HonorChangeGrayTipsReserved troop_honor_honorchangegraytipsreserved = new troop_honor$HonorChangeGrayTipsReserved();
                troop_honor_honorchangegraytipsreserved.mergeFrom(bArr);
                List<troop_honor$UserHonor> list = troop_honor_honorchangegraytipsreserved.user_honor.get();
                if (list != null && list.size() > 0) {
                    for (troop_honor$UserHonor troop_honor_userhonor : list) {
                        if (troop_honor_userhonor.uin.has() && troop_honor_userhonor.level.has()) {
                            String valueOf = String.valueOf(troop_honor_userhonor.uin.get());
                            int i16 = troop_honor_userhonor.level.get();
                            h hVar = new h();
                            hVar.f195147a = valueOf;
                            hVar.f195148b = str;
                            hVar.f195149c = i16;
                            D(str, valueOf, "TroopManager", hVar);
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopManager", 2, String.format("handleTroopMemberNewLevelChange, pushType: %s, troopUin: %s, memberUin: %s, newRealLevel: %s", Integer.valueOf(i3), str, valueOf, Integer.valueOf(i16)));
                            }
                        }
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                QLog.d("TroopManager", 1, "handleTroopMemberNewLevelChange", e16);
            }
        }
    }

    @Deprecated
    public boolean O(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return ((IUniqueTitleService) this.f195134d.getRuntimeService(IUniqueTitleService.class, "")).hasUniqueTitleExpireNotified(str, str2);
    }

    public synchronized boolean Q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str)).booleanValue();
        }
        return ((IBizTroopInfoService) this.f195134d.getRuntimeService(IBizTroopInfoService.class, "")).isCurrentOpenTroop(str);
    }

    public boolean R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return ((Boolean) iPatchRedirector.redirect((short) 99, (Object) this, (Object) str)).booleanValue();
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).isHomeworkTroop(str);
    }

    public boolean S(String str) {
        TroopInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this, (Object) str)).booleanValue();
        }
        if (!QVIPPrettyTroopProcessor.get().groupCareLimitOff && (k3 = k(str)) != null && k3.checkFlagExt4(3)) {
            if (QLog.isColorLevel()) {
                QLog.d("vip_pretty.TroopManager", 1, "troop " + str + " is pretty so req group care");
            }
            return true;
        }
        BaseApplication app = this.f195134d.getApp();
        if (app.getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(L, 0) < System.currentTimeMillis() / 1000) {
            return true;
        }
        return false;
    }

    public boolean V(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Boolean) iPatchRedirector.redirect((short) 98, (Object) this, (Object) str)).booleanValue();
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(str);
    }

    public boolean W(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return ((Boolean) iPatchRedirector.redirect((short) 82, (Object) this, (Object) str)).booleanValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getBoolean(U, true);
    }

    public synchronized boolean X(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && this.F.contains(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized boolean Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        return ((IBizTroopInfoService) this.f195134d.getRuntimeService(IBizTroopInfoService.class, "")).isTroopAIOOpen();
    }

    public synchronized boolean a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        return ((IBizTroopInfoService) this.f195134d.getRuntimeService(IBizTroopInfoService.class, "")).isTroopConfessPanelOpen();
    }

    public void b(String str, long j3, long j16, int i3) {
        String str2;
        long j17;
        Message lastMessage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
            return;
        }
        if (i3 == 131081) {
            str2 = HardCodeUtil.qqStr(R.string.ujb);
        } else if (i3 == 131080) {
            str2 = HardCodeUtil.qqStr(R.string.ujs);
        } else {
            str2 = "";
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, str, str3, 1, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, i3, j3);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(this.f195134d, gVar);
        messageForUniteGrayTip.isread = true;
        if (j16 == 0 && (lastMessage = this.f195134d.getMessageFacade().getLastMessage(str, 1)) != null) {
            j17 = lastMessage.shmsgseq;
            if (QLog.isColorLevel()) {
                QLog.d("TroopManager", 2, String.format("addAIOGrayTips, shmsgseq: %s, msgseq: %s", Long.valueOf(lastMessage.shmsgseq), Long.valueOf(lastMessage.msgseq)));
            }
        } else {
            j17 = j16;
        }
        messageForUniteGrayTip.shmsgseq = j17;
        com.tencent.mobileqq.graytip.f.a(this.f195134d, messageForUniteGrayTip);
        if (QLog.isColorLevel()) {
            QLog.d("TroopManager", 2, String.format("addAIOGrayTips, troopUin: %s, msgTime: %s, wording: %s, msgSeq: %s", str, Long.valueOf(j3), str3, Long.valueOf(j17)));
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TroopManager", 1, "addPassiveExitGrayTips, troopUin is empty");
        }
        TroopInfo k3 = k(str);
        if (k3 == null) {
            QLog.e("TroopManager", 1, "addPassiveExitGrayTips, troopInfo == null");
            return;
        }
        int i3 = k3.exitTroopReason;
        if (i3 != 1) {
            if (i3 == 2) {
                b(k3.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131081);
                return;
            }
            return;
        }
        b(k3.troopuin, NetConnInfoCenter.getServerTime(), 0L, 131080);
    }

    public void d(TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) troopInfo);
        } else {
            e(troopInfo, NetConnInfoCenter.getServerTime());
        }
    }

    public boolean d0(TroopInfo troopInfo, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, this, troopInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if (!z16) {
            z17 = U(troopInfo);
        } else {
            z17 = true;
        }
        if (!z17 || (troopInfo.mMemberNumSeq != -1 && troopInfo.mMemberCardSeq != -1)) {
            return false;
        }
        return true;
    }

    public void e(TroopInfo troopInfo, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, troopInfo, Long.valueOf(j3));
            return;
        }
        if (troopInfo == null) {
            return;
        }
        ProxyManager proxyManager = this.f195134d.getProxyManager();
        RecentUser findRecentUserByUin = proxyManager.m().findRecentUserByUin(troopInfo.troopuin, 1);
        findRecentUserByUin.displayName = troopInfo.getTroopDisplayName();
        if (findRecentUserByUin.getStatus() == 1000) {
            findRecentUserByUin.lastmsgtime = j3;
            proxyManager.m().saveRecentUser(findRecentUserByUin);
            ((MessageHandler) this.f195134d.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(6003, true, new String[]{troopInfo.troopuin, "0"});
        }
    }

    public void e0(String str, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) troopInfo);
            return;
        }
        QQAppInterface qQAppInterface = this.f195134d;
        if (qQAppInterface == null) {
            return;
        }
        h(qQAppInterface, troopInfo);
        com.tencent.mobileqq.troop.utils.aw.e(str, this.f195134d);
        this.f195134d.getMessageFacade().q(str, 1);
        ((IRelationMsgService) QRoute.api(IRelationMsgService.class)).deleteRecentContacts(new com.tencent.relation.common.nt.data.a(str, 1, ""), new a());
        j(str, true);
        this.f195134d.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER).notifyUI(com.tencent.mobileqq.troop.api.observer.b.G, true, str);
        ((ITroopMemberInfoService) this.f195134d.getRuntimeService(ITroopMemberInfoService.class, "")).notifyQuitTroop(str);
        try {
            if (this.f195134d.getAVNotifyCenter().S(Long.parseLong(str))) {
                BaseApplication.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            }
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopManager", 2, "tm->deleteTroop-->NumberFormatException, troopUin:" + str);
            }
        }
    }

    public void f(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, str2, Long.valueOf(j3));
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ProxyManager proxyManager = this.f195134d.getProxyManager();
            RecentUser findRecentUserByUin = proxyManager.m().findRecentUserByUin(str, 1);
            findRecentUserByUin.displayName = str2;
            if (findRecentUserByUin.getStatus() == 1000) {
                findRecentUserByUin.lastmsgtime = j3;
                proxyManager.m().saveRecentUser(findRecentUserByUin);
                ((MessageHandler) this.f195134d.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(6003, true, new String[]{str, "0"});
            }
        }
    }

    public void f0(int i3, long j3, long j16, long j17, long j18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), str);
            return;
        }
        Iterator<Integer> it = this.f195137h.iterator();
        while (it.hasNext()) {
            if (i3 == it.next().intValue()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TroopManager", 4, String.format("Discard message", new Object[0]));
                    return;
                }
                return;
            }
        }
        if (this.f195137h.size() > 30) {
            this.f195137h.poll();
        }
        this.f195137h.offer(Integer.valueOf(i3));
        String valueOf = String.valueOf(j3);
        TroopInfo findTroopInfo = ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(j3));
        if (findTroopInfo == null) {
            findTroopInfo = new TroopInfo(valueOf);
        }
        long j19 = findTroopInfo.troopPrivilegeFlag;
        long j26 = j18 & j17;
        if ((j19 & j17) != j26) {
            if (j26 == j17) {
                findTroopInfo.troopPrivilegeFlag = j19 & j17;
            } else {
                findTroopInfo.troopPrivilegeFlag = j19 & (~j17);
            }
        }
        g(valueOf, j16, i3, j17, j18, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(String str, long j3, int i3, long j16, long j17, String str2) {
        String str3;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j17), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopManager", 2, "----------addTroopPrivilegeTipsMr troopUin: " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            if ((j16 & 1) == 1) {
                if ((j17 & 1) == 1) {
                    string = this.f195134d.getApplication().getString(R.string.et_);
                } else {
                    string = this.f195134d.getApplication().getString(R.string.eta);
                }
            } else if ((j16 & 2) == 2) {
                if ((j17 & 2) == 2) {
                    string = this.f195134d.getApplication().getString(R.string.et8);
                } else {
                    string = this.f195134d.getApplication().getString(R.string.et9);
                }
            }
            str3 = string;
            if (!TextUtils.isEmpty(str3)) {
                return;
            }
            ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(this.f195134d, new LocalGrayTip.LocalGrayTipBuilder(str, 2, 2403L, 1, true, true, null).g(str3, 1).m(), new b());
            return;
        }
        str3 = str2;
        if (!TextUtils.isEmpty(str3)) {
        }
    }

    @Deprecated
    public void g0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        } else {
            ((IBizTroopInfoService) this.f195134d.getRuntimeService(IBizTroopInfoService.class, "")).onTroopReceiveOrSendMsg(str);
        }
    }

    public synchronized void h0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.G.remove(str + str2);
        if (QLog.isColorLevel()) {
            QLog.d("TroopManager.troopgroup_vedio.invite", 2, "removeGroupInviteStatus groupUin : " + str);
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0);
        if (sharedPreferences.contains(N) || sharedPreferences.contains(S)) {
            sharedPreferences.edit().remove(N).remove(Q).remove(R).remove(S).remove(U).remove(V).remove(W).commit();
        }
    }

    public void j(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, str, Boolean.valueOf(z16));
            return;
        }
        if (str != null && str.length() != 0) {
            if (z16) {
                ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.app.TroopManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f195140d;

                    {
                        this.f195140d = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopManager.this, (Object) str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            TroopManager.this.k0(this.f195140d, -1L);
                        }
                    }
                }, 8, null, true);
            } else {
                k0(str, -1L);
            }
        }
    }

    public synchronized void j0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        } else {
            ((IBizTroopInfoService) this.f195134d.getRuntimeService(IBizTroopInfoService.class, "")).setCurrentOpenTroop(str);
        }
    }

    @Deprecated
    public TroopInfo k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
    }

    public void k0(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Long.valueOf(j3));
        } else {
            ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).setInsertJoinTroopMsgTime(str, j3);
        }
    }

    @Deprecated
    public TroopInfo l(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 16, this, str, Boolean.valueOf(z16));
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str, z16);
    }

    public void l0(String str, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) str, (Object) bool);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putBoolean(U, bool.booleanValue()).commit();
    }

    @Deprecated
    public TroopInfo m(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 17, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str, z16, z17);
    }

    public void m0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(L, i3).commit();
    }

    @Deprecated
    public TroopInfo n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfoInUI(str);
    }

    @Deprecated
    public void n0(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3));
        } else {
            ((IUniqueTitleService) this.f195134d.getRuntimeService(IUniqueTitleService.class, "")).setOldestUniqueTitleExpireTime(str, j3);
        }
    }

    public com.tencent.mobileqq.relationx.batchAdd.c o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (com.tencent.mobileqq.relationx.batchAdd.c) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        if (this.H == null) {
            this.H = com.tencent.mobileqq.relationx.batchAdd.d.f280711a.a();
        }
        return this.H;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f195134d.getConfigProcess().h(this);
        this.f195134d.removeObserver(this.f195139m);
        this.f195134d.removeObserver(this.f195138i);
        synchronized (this.D) {
            com.tencent.qqnt.kernel.api.s sVar = this.C;
            if (sVar != null) {
                sVar.x0(this.E);
                this.C = null;
                QLog.i("TroopManager", 1, "group service has removed group listener");
            }
        }
        this.f195135e.close();
    }

    @Override // com.tencent.mobileqq.config.c.b
    public void onGetConfig(QQAppInterface qQAppInterface, int i3, String str, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, qQAppInterface, Integer.valueOf(i3), str, aVar);
        }
    }

    public void p0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
            return;
        }
        DBMethodProxy.execSQL(this.f195135e, "update TroopNotificationCache set read=1 where troopUin=" + str);
    }

    public String q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        }
        return ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(str);
    }

    public void q0(String str, MessageRemindRsp messageRemindRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) str, (Object) messageRemindRsp);
            return;
        }
        String str2 = M + "_" + this.f195134d.getCurrentAccountUin() + "_" + str;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeBool(str2 + "_migrate_key", true);
        m0(str, (int) messageRemindRsp.iNextReqTime);
        from.encodeString(str2, com.tencent.weiyun.utils.Utils.bytes2HexStr(messageRemindRsp.toByteArray()));
    }

    public void r(String str, ITroopInfoService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, (Object) aVar);
        } else {
            ((ITroopInfoService) this.f195134d.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUinAsync(str, aVar);
        }
    }

    public void r0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(S, i3).commit();
    }

    @NonNull
    public gf0.a s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (gf0.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f195136f == null) {
            this.f195136f = new gf0.a(this.f195134d.getApp(), this.f195134d.getCurrentAccountUin());
        }
        return this.f195136f;
    }

    public void s0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(W, i3).commit();
    }

    public void t0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(T, i3).commit();
    }

    public int u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Integer) iPatchRedirector.redirect((short) 78, (Object) this, (Object) str)).intValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(S, 0);
    }

    public void u0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(V, i3).commit();
    }

    public int v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return ((Integer) iPatchRedirector.redirect((short) 86, (Object) this, (Object) str)).intValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(W, 0);
    }

    public void v0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(R, i3).commit();
    }

    public int w(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return ((Integer) iPatchRedirector.redirect((short) 80, (Object) this, (Object) str)).intValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(T, 0);
    }

    public void w0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(N, i3).commit();
    }

    public int x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return ((Integer) iPatchRedirector.redirect((short) 84, (Object) this, (Object) str)).intValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(V, 0);
    }

    public void x0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(P, i3).commit();
    }

    public int y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Integer) iPatchRedirector.redirect((short) 76, (Object) this, (Object) str)).intValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(R, 0);
    }

    public void y0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) str, i3);
            return;
        }
        this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).edit().putInt(Q, i3).commit();
    }

    public int z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Integer) iPatchRedirector.redirect((short) 70, (Object) this, (Object) str)).intValue();
        }
        return this.f195134d.getApp().getSharedPreferences(this.f195134d.getCurrentAccountUin() + "_" + str, 0).getInt(N, 0);
    }

    @Deprecated
    public void z0(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Boolean.valueOf(z16));
        } else {
            ((IUniqueTitleService) this.f195134d.getRuntimeService(IUniqueTitleService.class, "")).setUniqueTitleExpireNotified(str, str2, z16);
        }
    }

    @Deprecated
    public TroopManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f195137h = new LinkedList();
        this.f195138i = new c();
        this.f195139m = new d();
        this.D = new Object();
        this.F = new ArrayList<>();
        this.G = new HashMap<>();
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
    }
}
