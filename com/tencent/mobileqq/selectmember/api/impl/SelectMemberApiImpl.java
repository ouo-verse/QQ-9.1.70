package com.tencent.mobileqq.selectmember.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.adapter.e;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.BlessSelectMemberActivity;
import com.tencent.mobileqq.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.selectmember.troop.SelectTroopListFragment;
import com.tencent.mobileqq.selectmember.troop.SelectTroopListHelper;
import com.tencent.mobileqq.selectmember.wechat.b;
import com.tencent.mobileqq.selectmember.wechat.c;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectMemberApiImpl implements ISelectMemberApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SelectMemberApiImpl";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements RecentContactListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f285960a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f285961b;

        a(Intent intent, Context context) {
            this.f285960a = intent;
            this.f285961b = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectMemberApiImpl.this, intent, context);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NonNull List<RecentUser> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            QLog.i(SelectMemberApiImpl.TAG, 1, "startSelectMemberActivity get recent data from nt success!");
            this.f285960a.setClass(this.f285961b, SelectMemberActivity.class);
            this.f285961b.startActivity(this.f285960a);
        }
    }

    public SelectMemberApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static AppInterface getAppInterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e(TAG, 1, "getAppInterface appRuntime error");
            return null;
        }
        return (AppInterface) peekAppRuntime;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void addFriend(Context context, Object obj, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, context, obj, str, Boolean.valueOf(z16));
        } else {
            TroopAddFrdsInnerFrame.C(context, (TroopMemberInfo) obj, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public Object getContactsInnerFrameHandler(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface);
        }
        return appInterface.getHandler(ContactsInnerFrame.class);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public int getContactsInnerFrame_RELOAD_CONTACTS_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void getCreatedTroopListAsync(boolean z16, Consumer<List<TroopInfo>> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), consumer);
        } else {
            SelectTroopListHelper.b(z16, consumer);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    @Nullable
    @WorkerThread
    public Map<Groups, List<Friends>> getGroupFriendsMap(int i3, boolean z16, @Nullable List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Map) iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Boolean.valueOf(z16), list);
        }
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 1, "getFriendsList  app == null");
            return null;
        }
        List<Groups> asyncGetGroupListForUI = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).asyncGetGroupListForUI(appInterface);
        if (bl.b(asyncGetGroupListForUI)) {
            QLog.w(TAG, 1, "getGroupFriendList fullGroups == null");
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        loop0: for (Groups groups : asyncGetGroupListForUI) {
            ArrayList arrayList = new ArrayList();
            linkedHashMap.put(groups, arrayList);
            List<Friends> h16 = com.tencent.mobileqq.selectmember.util.a.h(appInterface, String.valueOf(groups.group_id));
            if (!bl.b(h16)) {
                com.tencent.mobileqq.selectmember.util.a.o(h16);
                for (Friends friends : h16) {
                    if (friends != null) {
                        String str = friends.uin;
                        if (!com.tencent.mobileqq.selectmember.util.a.m(appInterface, str) && com.tencent.mobileqq.selectmember.util.a.l(appInterface, str, z16, list)) {
                            arrayList.add(friends);
                            if (arrayList.size() >= i3) {
                                break loop0;
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    @Deprecated
    public void getGroupFriendsMapAsync(int i3, boolean z16, @Nullable List<String> list, Consumer<Map<Groups, List<Friends>>> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Boolean.valueOf(z16), list, consumer);
        } else {
            ThreadManagerV2.excute(new Runnable(i3, z16, list, consumer) { // from class: com.tencent.mobileqq.selectmember.api.impl.SelectMemberApiImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f285956d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f285957e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ List f285958f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Consumer f285959h;

                {
                    this.f285956d = i3;
                    this.f285957e = z16;
                    this.f285958f = list;
                    this.f285959h = consumer;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SelectMemberApiImpl.this, Integer.valueOf(i3), Boolean.valueOf(z16), list, consumer);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f285959h.accept(SelectMemberApiImpl.this.getGroupFriendsMap(this.f285956d, this.f285957e, this.f285958f));
                    }
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public Map<String, List<TroopMemberInfo>> getIndexedFriends(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Map) iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
        }
        return ((SelectMemberActivity) activity).getIndexedFriends();
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public e getMemberListAdapter(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (e) iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity);
        }
        return ((SelectMemberActivity) activity).getMemberListAdapter();
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    @Nullable
    @WorkerThread
    public List<d> getRecentFriends(int i3, boolean z16, @Nullable List<String> list) {
        String uidFromUin;
        d friendsSimpleInfoWithUid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (List) iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Boolean.valueOf(z16), list);
        }
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 1, "getRecentFriends  app == null");
            return null;
        }
        if (((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache() == null) {
            QLog.e(TAG, 1, "getRecentFriends  rup == null");
            return null;
        }
        List<RecentUser> recentListFromCache = ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentListFromCache();
        if (bl.b(recentListFromCache)) {
            QLog.w(TAG, 1, "getRecentFriends recentUser == null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : recentListFromCache) {
            if (recentUser != null) {
                String str = recentUser.uin;
                if (recentUser.getType() == 0 && bv.a(str) >= 10000 && com.tencent.mobileqq.selectmember.util.a.l(appInterface, str, z16, list) && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid((uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str)), TAG)) != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG) && !com.tencent.mobileqq.selectmember.util.a.m(appInterface, str)) {
                    arrayList.add(friendsSimpleInfoWithUid);
                    if (arrayList.size() >= i3) {
                        return arrayList;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            QLog.e(TAG, 1, "getRecentFriends friend list is empty!!!");
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    @Deprecated
    public void getRecentFriendsAsync(int i3, boolean z16, @Nullable List<String> list, Consumer<List<Friends>> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Boolean.valueOf(z16), list, consumer);
        } else {
            ThreadManagerV2.excute(new Runnable(consumer, i3, z16, list) { // from class: com.tencent.mobileqq.selectmember.api.impl.SelectMemberApiImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Consumer f285951d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f285952e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f285953f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ List f285954h;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.selectmember.api.impl.SelectMemberApiImpl$2$a */
                /* loaded from: classes18.dex */
                class a implements RecentContactListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // com.tencent.relation.common.nt.listener.RecentContactListener
                    public void onResult(@NonNull List<RecentUser> list) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                            return;
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        AnonymousClass2.this.f285951d.accept(SelectMemberApiImpl.this.getRecentFriends(anonymousClass2.f285952e, anonymousClass2.f285953f, anonymousClass2.f285954h, list));
                    }
                }

                {
                    this.f285951d = consumer;
                    this.f285952e = i3;
                    this.f285953f = z16;
                    this.f285954h = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SelectMemberApiImpl.this, consumer, Integer.valueOf(i3), Boolean.valueOf(z16), list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        QLog.e(SelectMemberApiImpl.TAG, 1, "getRecentFriendsAsync is error! appruntime is invalid!");
                        this.f285951d.accept(new ArrayList());
                    } else {
                        ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(peekAppRuntime, new a(), false);
                    }
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public boolean getSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public Intent getStartSelectMemberActivityIntentForJsPlugin(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Intent) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        return new Intent(context, (Class<?>) SelectMemberActivity.class);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public ArrayList<String> getTopayTips(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ArrayList) iPatchRedirector.redirect((short) 22, (Object) this, (Object) activity);
        }
        return ((SelectMemberActivity) activity).mTopayTips;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public b getWxShareOrganizer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (b) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public boolean isSelectMemberActivityInstance(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) activity)).booleanValue();
        }
        return activity instanceof SelectMemberActivity;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void notifyListOrSearchChange(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, activity, Boolean.valueOf(z16));
        } else {
            ((SelectMemberActivity) activity).notifyListOrSearchChange(z16);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void setSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = z16;
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startBindRobotTroop(Activity activity, int i3, List<String> list, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, Integer.valueOf(i3), list, Integer.valueOf(i16));
            return;
        }
        if (activity == null) {
            QLog.e(TAG, 1, "[startBindRobotTroop] activity is null.");
            return;
        }
        QLog.i(TAG, 1, "[startBindRobotTroop] maxSize:" + i3 + ", bindTroopList:" + list);
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_CREATE_TROOP, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_MANAGE_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_JOIN_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_UN_NAME_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_SET_TOP_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_TYPE, 2);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_MAX_NUM, i3);
        if (list != null && !list.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i17 = 0; i17 < list.size(); i17++) {
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uin = list.get(i17);
                resultRecord.uinType = 1;
                arrayList.add(resultRecord);
            }
            intent.putParcelableArrayListExtra("selected_target_list", arrayList);
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) SelectTroopListFragment.class, i16);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startBlessSelectMemberActivity(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (context != null && intent != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, " call startBlessSelectMemberActivity");
            }
            intent.setClass(context, BlessSelectMemberActivity.class);
            context.startActivity(intent);
            return;
        }
        QLog.e(TAG, 1, "startBlessSelectMemberActivity return, context = " + context + ",intent = " + intent);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startBlessSelectMemberActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, intent, Integer.valueOf(i3));
            return;
        }
        if (activity != null && intent != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, " call startBlessSelectMemberActivityForResult by Intent");
            }
            intent.setClass(activity, BlessSelectMemberActivity.class);
            activity.startActivityForResult(intent, i3);
            return;
        }
        QLog.e(TAG, 1, "startBlessSelectMemberActivityForResult by Intent, activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startSelectMemberActivity(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (context != null && intent != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (peekAppRuntime instanceof BaseQQAppInterface)) {
                ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(peekAppRuntime, new a(intent, context), false);
                return;
            } else {
                intent.setClass(context, SelectMemberActivity.class);
                context.startActivity(intent);
                return;
            }
        }
        QLog.e(TAG, 1, "startSelectMemberActivity return, context = " + context + ",intent = " + intent);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startSelectMemberActivityForResult(Activity activity, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, bundle, Integer.valueOf(i3));
            return;
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, " call startSelectMemberActivityForResult");
            }
            Intent intent = new Intent(activity, (Class<?>) SelectMemberActivity.class);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i3);
            return;
        }
        QLog.e(TAG, 1, "startSelectMemberActivityForResult, activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public Intent startSelectTroopListForJsPlugin(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, " call startSelectTroopListForResult");
        }
        Intent intent = new Intent();
        intent.setClass(context, QPublicFragmentActivity.class);
        intent.putExtra("public_fragment_class", SelectTroopListFragment.class.getName());
        return intent;
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startSelectTroopListForResult(Fragment fragment, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, fragment, intent, Integer.valueOf(i3));
            return;
        }
        if (fragment != null && intent != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, " call startSelectTroopListForResult");
            }
            QPublicFragmentActivity.startForResult((QBaseFragment) fragment, intent, (Class<? extends QPublicBaseFragment>) SelectTroopListFragment.class, i3);
        } else {
            QLog.e(TAG, 1, "startSelectTroopListForResult return, fragment = " + fragment + ",intent = " + intent);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void updateGameData(Activity activity, Map<String, List<TroopMemberInfo>> map, int[] iArr, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, activity, map, iArr, strArr);
        } else {
            ((SelectMemberActivity) activity).updateGameData(map, iArr, strArr);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startSelectMemberActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, intent, Integer.valueOf(i3));
            return;
        }
        if (activity != null && intent != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, " call startSelectMemberActivityForResult by Intent,intent.extra = " + intent.getExtras());
            }
            intent.setClass(activity, SelectMemberActivity.class);
            activity.startActivityForResult(intent, i3);
            return;
        }
        QLog.e(TAG, 1, "startSelectMemberActivityForResult by Intent, activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
    }

    @Override // com.tencent.mobileqq.selectmember.api.ISelectMemberApi
    public void startSelectMemberActivityForResult(Fragment fragment, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fragment, intent, Integer.valueOf(i3));
            return;
        }
        if (fragment != null && intent != null && fragment.getActivity() != null && !fragment.getActivity().isFinishing() && !fragment.getActivity().isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, " call startSelectMemberActivityForResult by Intent,intent.extra = " + intent.getExtras());
            }
            intent.setClass(fragment.getActivity(), SelectMemberActivity.class);
            fragment.startActivityForResult(intent, i3);
            return;
        }
        QLog.e(TAG, 1, "startSelectMemberActivityForResult by Intent, activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public List<Friends> getRecentFriends(int i3, boolean z16, @Nullable List<String> list, @Nullable List<RecentUser> list2) {
        Friends b16;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 1, "getRecentFriends  app == null");
            return null;
        }
        if (((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache() == null) {
            QLog.e(TAG, 1, "getRecentFriends  rup == null");
            return null;
        }
        if (bl.b(list2)) {
            QLog.w(TAG, 1, "getRecentFriends recentUser == null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list2) {
            if (recentUser != null) {
                String str = recentUser.uin;
                if (recentUser.getType() == 0 && bv.a(str) >= 10000 && com.tencent.mobileqq.selectmember.util.a.l(appInterface, str, z16, list) && (b16 = com.tencent.mobileqq.selectmember.util.a.b(appInterface, str)) != null && b16.isFriend() && !com.tencent.mobileqq.selectmember.util.a.m(appInterface, b16.uin)) {
                    arrayList.add(b16);
                    if (arrayList.size() >= i3) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }
}
