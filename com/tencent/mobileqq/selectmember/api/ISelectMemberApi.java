package com.tencent.mobileqq.selectmember.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.e;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectmember.wechat.b;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISelectMemberApi extends QRouteApi {
    void addFriend(Context context, Object obj, String str, boolean z16);

    Object getContactsInnerFrameHandler(AppInterface appInterface);

    int getContactsInnerFrame_RELOAD_CONTACTS_Value();

    void getCreatedTroopListAsync(boolean z16, Consumer<List<TroopInfo>> consumer);

    @Nullable
    @WorkerThread
    Map<Groups, List<Friends>> getGroupFriendsMap(int i3, boolean z16, @Nullable List<String> list);

    @Deprecated
    void getGroupFriendsMapAsync(int i3, boolean z16, @Nullable List<String> list, Consumer<Map<Groups, List<Friends>>> consumer);

    Map<String, List<TroopMemberInfo>> getIndexedFriends(Activity activity);

    e getMemberListAdapter(Activity activity);

    @Nullable
    @WorkerThread
    List<d> getRecentFriends(int i3, boolean z16, @Nullable List<String> list);

    void getRecentFriendsAsync(int i3, boolean z16, @Nullable List<String> list, Consumer<List<Friends>> consumer);

    boolean getSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg();

    Intent getStartSelectMemberActivityIntentForJsPlugin(Context context);

    ArrayList<String> getTopayTips(Activity activity);

    b getWxShareOrganizer();

    boolean isSelectMemberActivityInstance(Activity activity);

    void notifyListOrSearchChange(Activity activity, boolean z16);

    void setSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg(boolean z16);

    @Deprecated
    void startBindRobotTroop(Activity activity, int i3, List<String> list, int i16);

    void startBlessSelectMemberActivity(Context context, Intent intent);

    void startBlessSelectMemberActivityForResult(Activity activity, Intent intent, int i3);

    void startSelectMemberActivity(Context context, Intent intent);

    void startSelectMemberActivityForResult(Activity activity, Intent intent, int i3);

    void startSelectMemberActivityForResult(Activity activity, Bundle bundle, int i3);

    void startSelectMemberActivityForResult(Fragment fragment, Intent intent, int i3);

    Intent startSelectTroopListForJsPlugin(Context context);

    @Deprecated
    void startSelectTroopListForResult(Fragment fragment, Intent intent, int i3);

    void updateGameData(Activity activity, Map<String, List<TroopMemberInfo>> map, int[] iArr, String[] strArr);
}
