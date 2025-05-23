package com.tencent.mobileqq.activity.selectmember.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ISelectMemberRefatorHelperApi extends QRouteApi {
    List<Groups> asyncGetGroupListForUI(AppInterface appInterface);

    boolean batchAddFriendForTroopMembers(AppInterface appInterface, String str, String str2, String str3, List<String> list, boolean z16, int i3, int i16);

    boolean batchAddFriendForTroopMembers(AppInterface appInterface, String str, String str2, String str3, List<String> list, boolean z16, int i3, int i16, int i17, int i18);

    void enterTroopAio(Context context, String str, boolean z16);

    String getAccountNickName(AppInterface appInterface, String str);

    Bitmap getFaceBitmap(AppInterface appInterface, int i3, String str, boolean z16, int i16);

    int getMemberType(AppInterface appInterface, String str, String str2);

    String getNickName(AppInterface appInterface, String str, int i3);

    long getPublicAccountInfoCertifiedGrade(Object obj);

    String getPublicAccountInfoName(Object obj);

    String getPublicAccountInfoSummary(Object obj);

    long getPublicAccountInfoUin(Object obj);

    int getSCENE_TYPE_DEFAULT_Value();

    String getScene_SP_KEY_BAF_DATA_CHECK_FLAG_MEMBERS_KeyString();

    List<MessageRecord> getSelectedMsg();

    int getSubSourceId_multi(int i3);

    int getSubSourceId_single(int i3);

    String getUnitedVerifyMsgEditFragment_VERIFY_MSG_KeyString();

    boolean isPublicAccountInfoInstance(Object obj);

    boolean isPublicAccountInfoLooker(Object obj);

    void launchContactSearchComponentActivityForResult(Activity activity, String str, String str2, int i3, int i16, int i17, Bundle bundle);

    List<MessageRecord> loadHistoryMsg(String str, long j3, int i3);

    void notifyResultReceiver(Intent intent, Object obj);

    Object showAsDropDown(View view, Object obj, View.OnClickListener onClickListener, Object obj2);

    void showResultForBatchAddFriendData(AppInterface appInterface, Activity activity, String str, Object obj);

    void startCreateCreateFaceToFaceInviteActivity(Activity activity, String str);

    void startCreateFaceToFaceDiscussionActivity(Activity activity);

    void startGroupManager(Activity activity);

    void startUnitedVerifyMsgEditFragment(Activity activity, String str, int i3);

    void updateSelectGradeIcon(ImageView imageView, String str);
}
