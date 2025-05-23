package com.tencent.mobileqq.troop.troopcreate;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bean.InviteToTroopUserInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Dialog f299971a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class DialogInterfaceOnDismissListenerC8800a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        DialogInterfaceOnDismissListenerC8800a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (dialogInterface == a.f299971a) {
                a.f299971a = null;
            }
        }
    }

    public static void a(AppRuntime appRuntime, List<ResultRecord> list) {
        Iterator<ResultRecord> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().uin.equals(appRuntime.getCurrentAccountUin())) {
                z16 = true;
            }
        }
        if (!z16) {
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uin = appRuntime.getCurrentUin();
            resultRecord.type = 0;
            String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(resultRecord.uin), "TroopCreateUtils");
            if (nickWithUid == null) {
                nickWithUid = String.valueOf(resultRecord.name);
            }
            resultRecord.name = nickWithUid;
            list.add(resultRecord);
        }
    }

    public static void b(AppRuntime appRuntime, List<TroopCreateInfo.a> list) {
        boolean z16 = false;
        for (TroopCreateInfo.a aVar : list) {
            if (aVar.f294787a.equals(appRuntime.getCurrentAccountUin())) {
                if (TextUtils.isEmpty(aVar.f294788b)) {
                    aVar.f294788b = appRuntime.getCurrentUid();
                }
                z16 = true;
            }
        }
        if (!z16) {
            TroopCreateInfo.a aVar2 = new TroopCreateInfo.a();
            aVar2.f294787a = appRuntime.getCurrentUin();
            aVar2.f294787a = appRuntime.getCurrentUid();
            aVar2.f294790d = 0;
            String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(aVar2.f294787a), "TroopCreateUtils");
            if (nickWithUid == null) {
                nickWithUid = String.valueOf(aVar2.f294789c);
            }
            aVar2.f294789c = nickWithUid;
            list.add(aVar2);
        }
    }

    public static List<TroopCreateInfo.a> c(List<ResultRecord> list) {
        ArrayList arrayList = new ArrayList();
        for (ResultRecord resultRecord : list) {
            arrayList.add(new TroopCreateInfo.a(resultRecord.uin, resultRecord.name, resultRecord.type, resultRecord.uinType, resultRecord.groupUin, resultRecord.phone, resultRecord.lastChooseTime, resultRecord.isNewTroop, resultRecord.gameLevelIcon, resultRecord.memberNickInfo));
        }
        return arrayList;
    }

    public static List<InviteToTroopUserInfo> d(List<ResultRecord> list) {
        ArrayList arrayList = new ArrayList();
        for (ResultRecord resultRecord : list) {
            arrayList.add(new InviteToTroopUserInfo(resultRecord.uin, "", resultRecord.groupUin, resultRecord.type));
        }
        return arrayList;
    }

    public static void e() {
        Dialog dialog = f299971a;
        if (dialog != null) {
            if (dialog.isShowing()) {
                f299971a.dismiss();
            }
            f299971a = null;
        }
    }

    public static void f(Activity activity) {
        ((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).openCreateTroopByCategoryPage(activity);
    }

    public static String g(AppRuntime appRuntime, TroopCreateInfo.a aVar, String str) {
        if (aVar == null) {
            return "";
        }
        if (appRuntime == null) {
            return aVar.f294787a + "";
        }
        TroopMemberNickInfo troopMemberNickInfo = aVar.f294793g;
        if (troopMemberNickInfo != null) {
            String friendNick = troopMemberNickInfo.getFriendNick();
            if (!TextUtils.equals(friendNick, aVar.f294787a)) {
                return friendNick;
            }
        }
        if (appRuntime.getAccount().equals(aVar.f294787a)) {
            return aVar.f294789c;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(aVar.f294787a);
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "TroopCreateUtils")) {
            String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uidFromUin, "TroopCreateUtils");
            if (TextUtils.isEmpty(nickWithUid)) {
                return aVar.f294787a;
            }
            return nickWithUid;
        }
        int i3 = aVar.f294790d;
        if (i3 == 1) {
            String noFriendRemark = ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).getNoFriendRemark(aVar.f294787a);
            if (!TextUtils.isEmpty(noFriendRemark)) {
                return noFriendRemark;
            }
            QLog.e("TroopCreateUtils", 1, "getNickName: error, uin type troop but memberNickInfo is null");
        } else if (i3 == 2) {
            String discussionMemberNickName = ((IDiscussionService) appRuntime.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNickName(appRuntime, aVar.f294792f, aVar.f294787a);
            if (!TextUtils.isEmpty(discussionMemberNickName)) {
                return discussionMemberNickName;
            }
        }
        return aVar.f294787a + "";
    }

    public static void h(Context context, String str, String str2, boolean z16) {
        Intent intent = new Intent();
        BaseAIOUtils.m(intent, null);
        intent.putExtra("uin", str);
        intent.putExtra("uintype", 1);
        intent.putExtra("uinname", str2);
        intent.putExtra("isBack2Root", true);
        intent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
        if (z16) {
            intent.putExtra("fromWebCreation", true);
        }
        k(context, intent, RouterConstants.UI_ROUTER_SPLASH);
    }

    public static void i(Context context, String str, String str2) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        activityURIRequest.extra().putBoolean("open_chatfragment", true);
        activityURIRequest.extra().putString("uin", str);
        activityURIRequest.extra().putString("troop_uin", str);
        activityURIRequest.extra().putInt("uintype", 1);
        activityURIRequest.extra().putString("uinname", str2);
        activityURIRequest.extra().putString("key_from", "39");
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static void j(Activity activity, String str) {
        if (!(activity instanceof QBaseActivity)) {
            return;
        }
        Dialog dialog = f299971a;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) activity;
        if (qBaseActivity.isFinishing()) {
            return;
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
        qQProgressDialog.setMessage(str);
        qQProgressDialog.setCancelable(false);
        qQProgressDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC8800a());
        f299971a = qQProgressDialog;
        try {
            qQProgressDialog.show();
        } catch (WindowManager.BadTokenException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopCreateUtils", 2, e16.getMessage());
            }
        }
    }

    public static void k(Context context, Intent intent, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static void l(Context context, Intent intent, String str, int i3) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        activityURIRequest.setRequestCode(i3);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (o) null);
    }
}
