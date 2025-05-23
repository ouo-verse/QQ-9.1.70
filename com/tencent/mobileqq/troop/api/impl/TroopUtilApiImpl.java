package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.webviewplugin.NTJuBaoUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.webviewplugin.O3ReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.troop.activity.f;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.ai;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.utils.as;
import com.tencent.mobileqq.troop.utils.aw;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopReportApi;
import com.tencent.qqnt.bean.InviteToTroopParam;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopUtilApiImpl implements ITroopUtilApi {
    static IPatchRedirector $redirector_;

    public TroopUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ArrayList<ResultRecord> convertToResultRecordList(List<com.tencent.mobileqq.troop.b> list) {
        ArrayList<ResultRecord> arrayList = new ArrayList<>();
        if (list != null) {
            for (com.tencent.mobileqq.troop.b bVar : list) {
                arrayList.add(new ResultRecord(bVar.f294565a, bVar.f294566b, bVar.f294567c, bVar.f294568d, bVar.f294569e, bVar.f294570f, bVar.f294571g, bVar.f294572h, bVar.f294573i));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchTroopMemberInfoByUins$3(com.tencent.mobileqq.troop.d dVar, boolean z16, List list) {
        dVar.a(Boolean.valueOf(z16), new ArrayList(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchTroopMemberList$1(com.tencent.mobileqq.troop.d dVar, boolean z16, List list) {
        dVar.a(Boolean.valueOf(z16), new ArrayList(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchTroopMemberListUseWeakRef$2(WeakReference weakReference, boolean z16, List list) {
        com.tencent.mobileqq.troop.d dVar = (com.tencent.mobileqq.troop.d) weakReference.get();
        if (dVar != null) {
            dVar.a(Boolean.valueOf(z16), new ArrayList(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$joinRecommendTroop$0(int i3, String str, int i16) {
        QLog.d("TroopManageHelper", 1, "joinRecommendTroop: troopUin=" + str + ", retCode=" + i16 + ", source=" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$reportRobotProfile$4(QBaseActivity qBaseActivity, String str, String str2, String str3, AppRuntime appRuntime, int i3, Bundle bundle, String str4) {
        O3ReportUtil.d(qBaseActivity, str, str2, str3, appRuntime.getCurrentUin(), i3, str4, 0, "", bundle);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public int QAVHrMeeting_hrExtra(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this, j3)).intValue();
        }
        return QAVHrMeeting.j(j3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void addLocalSetTopDataIgnore(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            ea.h(appRuntime.getApplication().getApplicationContext(), appRuntime.getCurrentAccountUin(), str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void clearTroopShortCutBarAppRedPoint(AppRuntime appRuntime, String str, long j3) {
        TroopShortcutBarHandler troopShortcutBarHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, appRuntime, str, Long.valueOf(j3));
        } else if ((appRuntime instanceof AppInterface) && (troopShortcutBarHandler = (TroopShortcutBarHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)) != null) {
            troopShortcutBarHandler.notifyUI(6, true, new Object[]{str, Long.valueOf(j3)});
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void configTroopCmdReportObj(ToServiceMsg toServiceMsg, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 61)) {
            ((ITroopReportApi) QRoute.api(ITroopReportApi.class)).configTroopCmdReportObj(toServiceMsg, "", str);
        } else {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) toServiceMsg, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public Serializable createTroopCmdReportObj(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (Serializable) iPatchRedirector.redirect((short) 64, this, str, str2, str3);
        }
        return ((ITroopReportApi) QRoute.api(ITroopReportApi.class)).createTroopCmdReportObj(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void doReqGameFriends(AppInterface appInterface, String str, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, appInterface, str, activity);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).e(str, (QBaseActivity) activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void doTroopCmdReport(ToServiceMsg toServiceMsg, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 63)) {
            ((ITroopReportApi) QRoute.api(ITroopReportApi.class)).doTroopCmdReport(toServiceMsg, i3, i16);
        } else {
            iPatchRedirector.redirect((short) 63, this, toServiceMsg, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void fetchNewTroopHeadUinList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
        } else {
            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void fetchRobotShareInfo(AppRuntime appRuntime, String str, com.tencent.mobileqq.troop.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appRuntime, str, aVar);
        } else {
            com.tencent.mobileqq.troop.utils.k.g(appRuntime, str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void fetchTroopMemberInfoByUins(String str, List<String> list, boolean z16, Object obj, String str2, final com.tencent.mobileqq.troop.d dVar) {
        LifecycleOwner lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, str, list, Boolean.valueOf(z16), obj, str2, dVar);
            return;
        }
        if (obj instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) obj;
        } else {
            lifecycleOwner = null;
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (dVar == null) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUinListInfo(str, list, z16, lifecycleOwner2, str2, null);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberUinListInfo(str, list, z16, lifecycleOwner2, str2, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troop.api.impl.t
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z17, List list2) {
                    TroopUtilApiImpl.lambda$fetchTroopMemberInfoByUins$3(com.tencent.mobileqq.troop.d.this, z17, list2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void fetchTroopMemberInfoFromDB(String str, String str2, Object obj, String str3, com.tencent.mobileqq.troop.c cVar) {
        LifecycleOwner lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, str, str2, obj, str3, cVar);
            return;
        }
        if (obj instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) obj;
        } else {
            lifecycleOwner = null;
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (cVar == null) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(str, str2, false, lifecycleOwner2, str3, null);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(str, str2, false, lifecycleOwner2, str3, new p(cVar));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void fetchTroopMemberList(String str, boolean z16, Object obj, String str2, final com.tencent.mobileqq.troop.d dVar) {
        LifecycleOwner lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, str, Boolean.valueOf(z16), obj, str2, dVar);
            return;
        }
        if (obj instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) obj;
        } else {
            lifecycleOwner = null;
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (dVar == null) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, lifecycleOwner2, z16, str2, null);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, lifecycleOwner2, z16, str2, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troop.api.impl.s
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z17, List list) {
                    TroopUtilApiImpl.lambda$fetchTroopMemberList$1(com.tencent.mobileqq.troop.d.this, z17, list);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void fetchTroopMemberListUseWeakRef(String str, boolean z16, String str2, final WeakReference<com.tencent.mobileqq.troop.d> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, str, Boolean.valueOf(z16), str2, weakReference);
        } else if (weakReference == null) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, null, z16, str2, null);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, null, z16, str2, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troop.api.impl.u
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z17, List list) {
                    TroopUtilApiImpl.lambda$fetchTroopMemberListUseWeakRef$2(weakReference, z17, list);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void fillResultRecordLevelIcon(ArrayList<com.tencent.mobileqq.troop.b> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) arrayList);
        } else {
            QQGameTroopManager.g(convertToResultRecordList(arrayList));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void forwardRobotCard(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, str, str2);
        } else {
            com.tencent.mobileqq.troop.utils.k.a(context, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void forwardRobotList(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) str);
        } else {
            com.tencent.mobileqq.troop.utils.k.b(context, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public String fuzzyLog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (String) iPatchRedirector.redirect((short) 78, (Object) this, (Object) str);
        }
        return ai.f302012a.d(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public Bundle getForwardRobotCardBundle(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bundle) iPatchRedirector.redirect((short) 9, this, context, str, str2);
        }
        return com.tencent.mobileqq.troop.utils.k.c(context, str, str2);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public Bundle getForwardRobotListBundle(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) str);
        }
        return com.tencent.mobileqq.troop.utils.k.d(context, str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public String getNoFriendRemark(String str) {
        Map<String, String> buddyRemark;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (!TextUtils.isEmpty(uidFromUin)) {
            arrayList.add(uidFromUin);
            com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
            if (b16 != null && !arrayList.isEmpty() && (buddyRemark = b16.getBuddyRemark(arrayList)) != null && buddyRemark.containsKey(uidFromUin)) {
                return buddyRemark.get(uidFromUin);
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public String getQQGameTroopManager_TASK_NAME_MEMBER_StringValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "member";
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public Class<? extends QPublicBaseFragment> getTroopManageClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (Class) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return com.tencent.mobileqq.troopmanage.base.b.c();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public Object getTroopMemberFromCacheOrFetchAsync(String str, String str2, Object obj, String str3, com.tencent.mobileqq.troop.c cVar) {
        LifecycleOwner lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return iPatchRedirector.redirect((short) 51, this, str, str2, obj, str3, cVar);
        }
        if (obj instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) obj;
        } else {
            lifecycleOwner = null;
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (cVar == null) {
            return ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberFromCacheOrFetchAsync(str, str2, lifecycleOwner2, str3, null);
        }
        return ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberFromCacheOrFetchAsync(str, str2, lifecycleOwner2, str3, new p(cVar));
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    @Deprecated
    public Object getTroopMemberInfoSync(String str, String str2, Object obj, String str3) {
        LifecycleOwner lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return iPatchRedirector.redirect((short) 53, this, str, str2, obj, str3);
        }
        if (obj instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) obj;
        } else {
            lifecycleOwner = null;
        }
        return ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, lifecycleOwner, str3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void handleGameClockData(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) appInterface);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).i();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean hasSetTroopHead(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        return TroopUtils.n(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean hasSetTroopHeadFromDb(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return TroopUtils.o(str, z16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean hasUnReadRepeatTroopNotification(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this, (Object) str)).booleanValue();
        }
        try {
            as d16 = aw.d((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), str);
            if (d16 != null) {
                if (!d16.f302081a.isEmpty()) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e16) {
            QLog.i("TroopManageHelper", 1, "[hasUnReadRepeatTroopNotification] troopUin = " + str + ", exception = " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void initTaskSet(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) appInterface);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).k();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isColorSpan(CharacterStyle characterStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, (Object) characterStyle)).booleanValue();
        }
        return characterStyle instanceof com.tencent.mobileqq.vas.i;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isDiscToTroopEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return TroopUtils.s();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isFilterUpdateInRecent(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, this, str, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        return TroopUtils.t(str, i3, j3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isGameClockBusiness(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity)).booleanValue();
        }
        return QQGameTroopManager.l(activity);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isInviteOrJoinTroopParam(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof InviteToTroopParam) && !(obj instanceof JoinTroopParam)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isLocalSetTopDataIgnoreContain(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        return ea.t0(appRuntime.getApplication(), appRuntime.getCurrentAccountUin()).contains(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isNeedReqGameInfo(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity)).booleanValue();
        }
        return QQGameTroopManager.m(activity);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isStudyMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        if (com.tencent.mobileqq.studymode.g.a() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isTroopGuildPushMsg(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        return ((ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class)).isTroopGuildPushMsg((Message) obj);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean isUsingCameraOnVideo(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        return ((QQAppInterface) appRuntime).isUsingCameraOnVideo();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void joinRecommendTroop(Context context, Object obj, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, obj, Integer.valueOf(i3));
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106038", true)) {
            RecommendTroopItem recommendTroopItem = (RecommendTroopItem) obj;
            com.tencent.mobileqq.troop.g gVar = new com.tencent.mobileqq.troop.g();
            gVar.f296167a = recommendTroopItem.uin;
            gVar.f296168b = recommendTroopItem.name;
            gVar.f296169c = i3;
            gVar.f296171e = recommendTroopItem.authSig;
            gVar.f296172f = true;
            com.tencent.mobileqq.troop.activity.f.i0(context, gVar, new f.c() { // from class: com.tencent.mobileqq.troop.api.impl.r
                @Override // com.tencent.mobileqq.troop.activity.f.c
                public final void a(String str, int i16) {
                    TroopUtilApiImpl.lambda$joinRecommendTroop$0(i3, str, i16);
                }
            });
            return;
        }
        TroopUtils.E(context, obj, i3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void joinTroop(Context context, com.tencent.mobileqq.troop.g gVar, final com.tencent.mobileqq.troop.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, context, gVar, fVar);
        } else {
            Objects.requireNonNull(fVar);
            com.tencent.mobileqq.troop.activity.f.i0(context, gVar, new f.c() { // from class: com.tencent.mobileqq.troop.api.impl.q
                @Override // com.tencent.mobileqq.troop.activity.f.c
                public final void a(String str, int i3) {
                    com.tencent.mobileqq.troop.f.this.a(str, i3);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void joinTroopSafely(Context context, String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, context, str, Integer.valueOf(i3), str2, str3);
        } else {
            TroopUtils.F(context, str, i3, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void jumpRecmmendTroopFrag(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) context);
        } else {
            QPublicFragmentActivity.start(context, new Intent(), RecommendTroopFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void notifyTopBanner(AppInterface appInterface, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, appInterface, str, Integer.valueOf(i3), str2);
        } else if (appInterface == null) {
            QLog.i("TroopManageHelper", 1, "[notifyTopBanner] app is null");
        } else {
            ((com.tencent.mobileqq.troop.troopaiobanner.c) appInterface.getManager(QQManagerFactory.TROOP_GAME_BANNER_MANAGER)).c(str, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void notifyTroopCenter(AppInterface appInterface, long j3, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, appInterface, Long.valueOf(j3), Integer.valueOf(i3), str);
            return;
        }
        if (appInterface == null) {
            QLog.i("TroopManageHelper", 1, "[notifyTroopCenter] app is null");
            return;
        }
        TroopFeedsDataManager e16 = ((com.tencent.mobileqq.model.d) appInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).e(Long.valueOf(j3), true);
        if (e16 != null && 1 == i3) {
            e16.o(str, Integer.valueOf(i3));
            appInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER).notifyUI(com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_TROOP_NEW_FEED_NEED_AUTO_PULL_DOWN, true, new Object[]{String.valueOf(j3), str, Integer.valueOf(i3)});
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void onClickEnterAddFriendAndTroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("101210.101211");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void onDestroyForQQGameTroopManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) appInterface);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void onLuckyCharInfoChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(com.tencent.qqnt.bus.event.s.f353245a);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void onOnlineRsp(AppInterface appInterface, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) appInterface, (Object) list);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).n(list);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void onSearchBarDone(AppInterface appInterface, Activity activity, List<com.tencent.mobileqq.troop.b> list, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, appInterface, activity, list, Integer.valueOf(i3), str, str2);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).o(activity, convertToResultRecordList(list), i3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void onTroopFlameDataUpdate(String str, GroupExtFlameData groupExtFlameData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) str, (Object) groupExtFlameData);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TroopManageHelper", 1, "[onTroopFlameDataUpdate] troopUin isEmpty");
            return;
        }
        QLog.i("TroopManageHelper", 1, "[onTroopFlameDataUpdate] flameState = " + groupExtFlameData.state);
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.mobileqq.troop.flame.event.a(str, groupExtFlameData));
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.x(str, com.tencent.qqnt.chats.core.adapter.itemdata.payload.j.f354601a));
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void onTroopMemberHonorInfoChanged(String str, String str2, String str3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, str, str2, str3, Byte.valueOf(b16));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str3 == null) {
                str3 = "";
            }
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.r(str2, str, str3, b16));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void openRecommendTroop(Context context, Object obj, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, obj, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            TroopUtils.H(context, obj, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void openSearchTabPageFromTroopSquare(AppInterface appInterface, Activity activity, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, appInterface, activity, str);
            return;
        }
        if (appInterface != null && activity != null) {
            try {
                str2 = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                QLog.e("TroopManageHelper", 1, "[openSearchTabPageFromTroopSquare] encode keyword failed, because UTF-8 is unknown");
                str2 = "";
            }
            String builder = Uri.parse("mqqapi://kuikly/open?src_type=internal&version=1&source=1&target=52&channel=2&page_name=qsearch_detail").buildUpon().appendQueryParameter("sessionId", com.tencent.biz.qqcircle.immersive.views.search.util.p.r()).appendQueryParameter("keyword", str2).appendQueryParameter("hide_tab", "1").appendQueryParameter("tab_mask", "6").appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, String.valueOf(26)).appendQueryParameter("user_source", String.valueOf(15)).appendQueryParameter("study_mode_status", String.valueOf(StudyModeManager.t())).appendQueryParameter("start_search_stamp", String.valueOf(System.currentTimeMillis())).toString();
            SearchUtils.Q0(appInterface, activity, builder);
            SearchUtils.j1(str, builder);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void openTroopInfoActivity(Context context, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            TroopUtils.I(context, bundle, i3);
        } else {
            iPatchRedirector.redirect((short) 2, this, context, bundle, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void openTroopSearchHistoryPageFromTroopSquare(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) SearchContactsActivity.class);
        intent.putExtra("from_key", 1);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 30);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void popBack(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            return;
        }
        if (activity instanceof SplashActivity) {
            SplashActivity splashActivity = (SplashActivity) activity;
            if (splashActivity.getqFragmentStackManager() == null) {
                activity.finish();
            }
            splashActivity.getqFragmentStackManager().p();
            return;
        }
        if (activity instanceof QBaseActivity) {
            ((QBaseActivity) activity).finish();
        } else {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean qAVHrMeeting_isHRConf(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, j3)).booleanValue();
        }
        return QAVHrMeeting.k(j3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean qAVHrMeeting_isNoRight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, i3)).booleanValue();
        }
        return QAVHrMeeting.m(i3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public boolean qAVHrMeeting_isPSTNConf(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, j3)).booleanValue();
        }
        return QAVHrMeeting.n(j3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void recordDiscussToTroopOp(String str, String str2, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, str, str2, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            TroopUtils.N((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), str, str2, j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void report(String str, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str, (Object) map);
        } else {
            ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report(str, map);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void reportFinishClick(String str, ArrayList<com.tencent.mobileqq.troop.b> arrayList, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, arrayList, str2);
        } else {
            QQGameTroopManager.q(str, convertToResultRecordList(arrayList), str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void reportNotificationConfig(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) context);
        } else {
            g.a(context);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void reportRobotProfile(@NonNull final QBaseActivity qBaseActivity, @NonNull final String str, @NonNull final String str2, boolean z16) {
        int i3;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, qBaseActivity, str, str2, Boolean.valueOf(z16));
            return;
        }
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!str2.isEmpty()) {
            i3 = 101082;
        } else {
            i3 = 101064;
            i16 = 0;
        }
        if (z16) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        final String str4 = str3;
        final Bundle G = NewReportPlugin.G(str, i16);
        final int i17 = i3;
        NTJuBaoUtil.b("", str, str2, i3, G, new Function1() { // from class: com.tencent.mobileqq.troop.api.impl.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$reportRobotProfile$4;
                lambda$reportRobotProfile$4 = TroopUtilApiImpl.lambda$reportRobotProfile$4(QBaseActivity.this, str, str4, str2, peekAppRuntime, i17, G, (String) obj);
                return lambda$reportRobotProfile$4;
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void reqGameInfoWhenIdle(AppInterface appInterface, Object obj, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, appInterface, obj, activity);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).u((PinnedDividerListView) obj, activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void sendReadConfirm(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str;
        sessionInfo.f179555d = 1;
        ChatActivityFacade.Q0((QQAppInterface) appRuntime, sessionInfo);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void smallScreenUtils_getTrace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        } else {
            SmallScreenUtils.n(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void sortAndPreloadIfNeed(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) appInterface, (Object) str);
        } else {
            ((QQGameTroopManager) appInterface.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).w(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void updateGameView(AppInterface appInterface, Activity activity, Object obj, TextView textView, ImageView imageView, TextView textView2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, appInterface, activity, obj, textView, imageView, textView2);
        } else {
            QQGameTroopManager.x(activity, (TroopMemberInfo) obj, textView, imageView, textView2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void updateNewTroopNameTimeStamp(String str, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, this, str, Long.valueOf(j3), str2);
        } else {
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateNewTroopNameTimeStamp(str, j3, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void updateTroopInfoAvatarId(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, str, Integer.valueOf(i3), str2);
        } else {
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateAvatarId(str, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void updateTroopInfoPicListJson(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, str, str2, str3);
        } else {
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updatePicListJson(str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void updateTroopTypeAndSpecialClass(String str, Integer num, Integer num2, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, str, num, num2, str2);
            return;
        }
        if (num != null) {
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateTroopType(str, num.intValue(), str2);
        }
        if (num2 != null) {
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateSpecialClass(str, num2.intValue(), str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void configTroopCmdReportObj(ToServiceMsg toServiceMsg, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 62)) {
            ((ITroopReportApi) QRoute.api(ITroopReportApi.class)).configTroopCmdReportObj(toServiceMsg, str, str2);
        } else {
            iPatchRedirector.redirect((short) 62, this, toServiceMsg, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void doTroopCmdReport(Serializable serializable, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 65)) {
            ((ITroopReportApi) QRoute.api(ITroopReportApi.class)).doTroopCmdReport(serializable, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            iPatchRedirector.redirect((short) 65, this, serializable, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopUtilApi
    public void openTroopInfoActivity(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
            return;
        }
        Bundle b16 = aq.b(str, 4);
        b16.putInt("t_s_f", 1001);
        TroopUtils.I(context, b16, 2);
    }
}
