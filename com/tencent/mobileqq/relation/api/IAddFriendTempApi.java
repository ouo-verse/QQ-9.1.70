package com.tencent.mobileqq.relation.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.newfriend.msg.r;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface IAddFriendTempApi extends QRouteApi {
    public static final int ENTER_FROM_CONTACT_TAB = 1;
    public static final int ENTER_FROM_DEFAULT = 0;
    public static final int ENTER_FROM_MESSAGE_TAB = 2;
    public static final int ENTER_FROM_NEW_FRIEND = 3;
    public static final int ENTER_FROM_NEW_FRIEND_MORE = 4;
    public static final int ENTER_FROM_UNITED_SEARCH_FIND_USER_BUTTON = 5;

    void addBatchQIMFriends(List<QIMNotifyAddFriend> list, AppInterface appInterface);

    void addFriendToFriendList(AppInterface appInterface, String str, int i3, int i16, String str2, boolean z16, boolean z17, long j3);

    void addListener(Object obj, AppInterface appInterface);

    void cancelMayKnowRecommend(String str, AppInterface appInterface);

    void changeStructMsgActions(structmsg$StructMsg structmsg_structmsg, int i3, String str, int i16);

    boolean changeStructMsgActionsWhenFail(structmsg$StructMsg structmsg_structmsg, int i3, String str, String str2);

    void checkReadContactPermission(Runnable runnable, AppInterface appInterface);

    void checkUpdate(AppInterface appInterface, String str);

    void clearAllSystemMsg(AppInterface appInterface);

    void clickQIMSource(Context context, MessageRecord messageRecord, AppInterface appInterface);

    Intent composeReturnIntent(Class<?> cls, String str, Activity activity);

    void deleteAllSuspiciousMsg(AppInterface appInterface);

    void deleteQIMNotifyAddFriendData(QIMNotifyAddFriend qIMNotifyAddFriend, AppInterface appInterface);

    boolean enableCheckPermission();

    void followUser(String str, boolean z16);

    Intent getAddRequestIntent(Context context);

    Intent getBindNumberIntent(Context context);

    Intent getChatActivityIntent(Context context);

    void getDiscussInfo(long j3, AppInterface appInterface);

    String getDiscussionNameCanNull(AppInterface appInterface, String str);

    int getForwardSelectionRequest();

    Intent getFriendProfileMoreInfoIntent(Context context);

    int getMayKnowLoadConnectionBizTypeFirstLoad();

    boolean getMayKnowRecommendRemoteFromNewFrd(AppInterface appInterface);

    String getQIMNewFriendSource(AppInterface appInterface);

    ArrayList<r> getQIMNotifyAddFriendsMsg(boolean z16, AppInterface appInterface);

    String getQQInfoFromQQUin(long j3, long j16, AppInterface appInterface);

    HashMap<String, String> getQidianExternal(HashMap<String, Object> hashMap);

    String getRecommendLabelString(List<MayKnowRecommend.MayKnowRecommendLabel> list);

    int getRequestForSetting();

    int getSizeSmall();

    void getSuspiciousFriendsUnreadNum(AppInterface appInterface);

    int getTypeSetConnectionsSwitch();

    Object getValue(String str, String str2, int i3, int i16);

    void gotoFriendSettingBrowser(Context context);

    boolean hasQidianExternal(HashMap<String, Object> hashMap);

    boolean hasQimSource(AppInterface appInterface);

    void insertCommonHobbyIfNeeded(AppInterface appInterface, String str);

    boolean isNewFrdMiniCardSwitchOn(AppInterface appInterface);

    boolean isQidianMaster(AppInterface appInterface, String str);

    boolean isStudyMode(AppInterface appInterface);

    boolean isSuspiciousSwitchOpen();

    void jumpToMoveGroup(Activity activity, Fragment fragment, String str, int i3, int i16);

    void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context context);

    void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context context, Intent intent, int i3);

    void jumpToQidianProfile(String str, Activity activity);

    void jumpToSplash(Activity activity);

    void launchPluginBroadcastWhenToggleSwitch(String str, AppInterface appInterface, boolean z16);

    void markQIMNotifyAddFriendsRead(AppInterface appInterface);

    void openSecCheckWebForFragment(AppInterface appInterface, Context context, QBaseFragment qBaseFragment, int i3, String str, String str2);

    void removeListener(Object obj, AppInterface appInterface);

    void reportExtendFriend(int i3, String str, Intent intent);

    void reportRecommend(AppInterface appInterface, String str, String str2, int i3, int i16, String str3, int i17, byte[] bArr, String str4, int i18);

    void reportRecommendExpose(AppInterface appInterface, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<byte[]> arrayList4, int i16);

    void sendAddFriendNoticeForBaby(AppInterface appInterface, Intent intent);

    void sendDelSingleSystemMsg(structmsg$StructMsg structmsg_structmsg, String str, int i3, long j3, AppInterface appInterface);

    void sendFriendSystemMsgAction(int i3, long j3, long j16, int i16, int i17, int i18, int i19, structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo, int i26, structmsg$StructMsg structmsg_structmsg, boolean z16, AppInterface appInterface);

    void sendFriendSystemMsgReadedReport(AppInterface appInterface);

    void sendGetNextFriendSystemMsg(AppInterface appInterface);

    void sendPokeMsg(AppInterface appInterface, Context context, String str);

    boolean shouldShowMayKnowInNewFriend(AppInterface appInterface);

    void startAddContactsPage(Context context, int i3, int i16, LaunchMode launchMode, @Nullable Bundle bundle);

    void startAddContactsPageForResult(Activity activity, int i3, int i16, int i17);

    void startAddRequestPage(Context context, Intent intent);

    void startAddRequestPageForResult(Activity activity, Intent intent, int i3);

    void startAddRequestSuspiciousPage(Context context, Intent intent);

    void startContactBindFromOther(AppInterface appInterface, int i3, int i16, Intent intent);

    void startContactBindFromOther(AppInterface appInterface, int i3, ArrayList<PhoneContact> arrayList);

    void startRemarkAfterAgree(Activity activity, int i3, String str, long j3, Bundle bundle);

    void updateCustomNoteTxt(TextView textView, int i3, int i16);
}
