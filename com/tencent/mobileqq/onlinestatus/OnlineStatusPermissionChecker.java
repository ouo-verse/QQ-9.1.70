package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class OnlineStatusPermissionChecker {

    /* loaded from: classes16.dex */
    public static class OnlineStatusPermissionItem implements Serializable {
        private boolean allHasPermission;
        private long onlineStateType;
        private List<Long> permissionUins;

        OnlineStatusPermissionItem(long j3, boolean z16) {
            this.onlineStateType = j3;
            this.allHasPermission = z16;
        }

        public static OnlineStatusPermissionItem create(long j3, boolean z16, List<Long> list) {
            OnlineStatusPermissionItem onlineStatusPermissionItem = new OnlineStatusPermissionItem(j3, z16);
            if (list == null) {
                list = new ArrayList<>();
            }
            onlineStatusPermissionItem.permissionUins = list;
            return onlineStatusPermissionItem;
        }

        public List<Long> filterNotFriend() {
            ArrayList arrayList = new ArrayList();
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            List<Long> list = this.permissionUins;
            if (list != null) {
                for (Long l3 : list) {
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(l3.toString());
                    if (uidFromUin != null && iFriendsInfoService.isFriend(uidFromUin, "OnlineStatusPermissionChecker")) {
                        arrayList.add(l3);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusPermissionChecker", 2, "filterNotFriend: invoked. ", " uin: ", l3);
                    }
                }
            }
            this.permissionUins = arrayList;
            return arrayList;
        }

        public long getOnlineStateType() {
            return this.onlineStateType;
        }

        public List<Long> getPermissionUins() {
            return this.permissionUins;
        }

        public boolean isAllHasPermission() {
            return this.allHasPermission;
        }
    }

    public static ResultRecord a(String str, String str2, int i3, String str3) {
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.uin = str;
        resultRecord.name = str2;
        resultRecord.type = i3;
        resultRecord.groupUin = str3;
        return resultRecord;
    }

    public static OnlineStatusPermissionItem b(Intent intent, int i3, Context context, AppRuntime appRuntime, boolean z16) {
        String str;
        if (context != null && appRuntime != null) {
            int i16 = 0;
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionChecker", 2, "onActivityResult param is error responseCode=", Integer.valueOf(i3), " data=", intent);
            }
            if (i3 == -1) {
                str = "0X800AE77";
            } else {
                str = "0X800AE78";
            }
            String str2 = str;
            ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            if (i3 == -1 && intent != null) {
                OnlineStatusPermissionItem onlineStatusPermissionItem = (OnlineStatusPermissionItem) intent.getSerializableExtra("online_status_permission_item");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                if (onlineStatusPermissionItem != null && parcelableArrayListExtra != null && parcelableArrayListExtra.size() != 0) {
                    ArrayList arrayList = new ArrayList(parcelableArrayListExtra.size());
                    Iterator it = parcelableArrayListExtra.iterator();
                    while (it.hasNext()) {
                        ResultRecord resultRecord = (ResultRecord) it.next();
                        arrayList.add(Long.valueOf(resultRecord.uin));
                        if (QLog.isColorLevel()) {
                            QLog.d("OnlineStatusPermissionChecker", 2, "onActivityResult param uin=", resultRecord.uin);
                        }
                    }
                    onlineStatusPermissionItem.allHasPermission = false;
                    onlineStatusPermissionItem.permissionUins = arrayList;
                    if (z16) {
                        c(context, onlineStatusPermissionItem);
                    }
                    return onlineStatusPermissionItem;
                }
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[4];
                    objArr[0] = "onActivityResult param is error onlineItem=";
                    objArr[1] = onlineStatusPermissionItem;
                    objArr[2] = " friendlistSize=";
                    if (parcelableArrayListExtra != null) {
                        i16 = parcelableArrayListExtra.size();
                    }
                    objArr[3] = Integer.valueOf(i16);
                    QLog.d("OnlineStatusPermissionChecker", 2, objArr);
                }
            }
        }
        return null;
    }

    public static void c(Context context, OnlineStatusPermissionItem onlineStatusPermissionItem) {
        Intent intent = new Intent();
        intent.putExtra("online_status_permission_item", onlineStatusPermissionItem);
        intent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.online);
        intent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
        intent.putExtra("KEY_ONLINE_EXT_STATUS", onlineStatusPermissionItem.onlineStateType);
        QPublicFragmentActivity.start(context, intent, AccountOnlineStateActivity.class);
    }

    public static void d(AppRuntime appRuntime, Activity activity, OnlineStatusPermissionItem onlineStatusPermissionItem, boolean z16) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Long l3 : onlineStatusPermissionItem.permissionUins) {
            ResultRecord resultRecord = new ResultRecord();
            String valueOf = String.valueOf(l3);
            resultRecord.uin = valueOf;
            arrayList.add(a(valueOf, "", 0, "-1"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        bundle.putParcelableArrayList(ISelectMemberActivityConstants.PARAM_SELECTED_RECORDS_FOR_CREATE_DISCURRION, arrayList);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_ENTRANCE, 40);
        bundle.putBoolean(ISelectMemberActivityConstants.PARAM_ADD_PASSED_MEMBERS_TO_RESULT_SET, true);
        bundle.putInt(ISelectMemberActivityConstants.PARAM_MAX, 1000);
        bundle.putString(ISelectMemberActivityConstants.PARAM_TITLE, activity.getString(R.string.f196874ih));
        bundle.putSerializable("online_status_permission_item", onlineStatusPermissionItem);
        bundle.putString(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, activity.getString(R.string.f196884ii));
        bundle.putString(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, activity.getString(R.string.f196894ij));
        ArrayList<String> arrayList2 = new ArrayList<>(1);
        bundle.putStringArrayList(ISelectMemberActivityConstants.PARAM_HIDE_UIN_LIST, arrayList2);
        bundle.putBoolean(ISelectMemberActivityConstants.PARAM_FILTER_ROBOT, true);
        arrayList2.add(appRuntime.getCurrentAccountUin());
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(activity, bundle, 100);
        if (z16) {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        }
    }
}
