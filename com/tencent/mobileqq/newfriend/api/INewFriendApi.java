package com.tencent.mobileqq.newfriend.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.config.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INewFriendApi extends QRouteApi {
    void clearStructMsgMap();

    void clearSystemMsgData();

    FrameLayout createUnverifyBlock(Context context);

    long getCurrStructMsgKey();

    long getCurrentUniseq();

    int getMsgNumber();

    Intent getNewFriendJumpIntent(Context context);

    String getNewFriendTag();

    long getOldestSysMsgTime(AppInterface appInterface);

    Intent getStartNewFriendMoreSysMsgActivityIntent(Context context, int i3);

    structmsg$StructMsg getStructMsgFromMap(Long l3);

    boolean getSysMsgOverValue(AppInterface appInterface);

    int getUiBuilderExposeCnt();

    int getUnReadFriendSystemMsgNum(AppInterface appInterface);

    int getZPlanUnreadNum();

    boolean isHasNoMoreMsg(AppInterface appInterface);

    boolean isSuspiciousSysMsg(MessageRecord messageRecord);

    void jumpToNewFriendVerifyListAct(Activity activity);

    a loadNewFriendContactGuideConfig();

    void logMsg(String str, List<? extends MessageRecord> list);

    boolean openProfileCard(AppRuntime appRuntime, Context context, String str, long j3, int i3, int i16, Intent intent);

    void openProfileCardNeedTrackBack(Context context, String str);

    void putStructMsgToMap(Long l3, structmsg$StructMsg structmsg_structmsg);

    void report(AppRuntime appRuntime, String str);

    void setBtnNewStyle(Button button);

    void setCurrStructMsgKey(long j3);

    void setCurrentUniseq(long j3);

    void setFromSysSubMsgType(int i3);

    void setHasNoMoreMsg(boolean z16, AppInterface appInterface);

    void setOldestSysMsgTime(AppInterface appInterface, long j3);

    void setStructMsgToMap(structmsg$StructMsg structmsg_structmsg, long j3);

    void setSysMsgOverValue(AppInterface appInterface, boolean z16);

    void setTextNewStyle(TextView textView, TextView textView2, TextView textView3);

    void setUiBuilderExposeCnt(int i3);

    void setUnReadFriendSystemMsgNum(AppInterface appInterface, int i3);

    boolean shouldMergeNewFriendContact(AppInterface appInterface, String str);

    void showGenderAge(TextView textView, int i3, int i16, StringBuilder sb5);

    void showGenderAgeNewStyle(TextView textView, int i3, int i16, StringBuilder sb5);

    void startActivity(Context context, Intent intent, int i3);

    void startNewFriendMoreSysMsgActivityForResult(Activity activity, int i3, int i16);

    void startZPlanNewFriendFragment(Context context, Intent intent);

    void updateItemBg(View view, boolean z16);

    void updateItemBgKeepPadding(View view, boolean z16);

    void updateItemViewHeightForList(View view, int i3);
}
