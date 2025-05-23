package com.qwallet.temp;

import Wallet.AcsMsg;
import Wallet.PfaFriendRqt;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.data.c;
import d4.b;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;
import tk2.GoldMsgTipsElemBean;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQWalletTemp extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        boolean notify(String str, String str2, String str3);
    }

    void addAndSendMessage(AppRuntime appRuntime, MessageRecord messageRecord, BaseMessageObserver baseMessageObserver);

    void addQBaseActivityObserver(QBaseActivity qBaseActivity, b bVar);

    void checkUpByBusinessId(String str, AppRuntime appRuntime, boolean z16, d4.a aVar);

    MessageRecord createMsgRecordByMsgType(int i3);

    Dialog createNewUpgradeYYBInstalledDialog(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2);

    Animation createRotate3dAnimation(float f16, float f17, float f18, float f19, float f26, boolean z16);

    void decodePBMsgElemsRichMsg(Object obj, List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, c cVar);

    void decodePBMsgElemsText(Object obj, List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, c cVar);

    String getAppInfoFromHistory();

    String getCJ2021AvGamePreloadModuleName();

    View getChatXListViewFromChatFragment(QBaseActivity qBaseActivity);

    String getConfig(BaseQQAppInterface baseQQAppInterface, String str);

    String getConfigPath();

    String getDiscussMemberName(BaseQQAppInterface baseQQAppInterface, String str, String str2);

    int getDiscussionMemberNum(AppRuntime appRuntime, String str);

    long getFreeSpace(String str);

    int getGetRecentListType();

    String getGroupNicknameByType(AppInterface appInterface, int i3, String str);

    int getInnerDnsCFTDomain();

    boolean getJumpLock(Context context, String str);

    ChatMessage getMessageByMID(String str);

    String getPrefActivateFriends();

    Class<? extends Activity> getQQLSUnlockActivityClazz();

    String getQQNotifyHelperKey(AcsMsg acsMsg);

    BusinessObserver getQWalletAuthObserver(Handler handler);

    String getRedPacket2024PreloadModuleName();

    String getRedPacket2025PreloadModuleName();

    int getReportConstantRes(String str);

    View getViewByPosition(View view, ChatMessage chatMessage);

    boolean isResultOk(int i3);

    boolean isScreenLocked(Context context);

    boolean isSplashNotExist();

    boolean isTempConv(int i3);

    boolean isUpdateNetUnavailable(int i3);

    boolean isUpdateOk(int i3);

    Bundle newPay(AppInterface appInterface, Activity activity, ResultReceiver resultReceiver, int i3, Bundle bundle);

    g newQWalletArkNotifyTemp(a aVar);

    void onPayMsgRsp(int i3, String str, String str2);

    void panelReport(AppRuntime appRuntime, String str, int i3);

    GoldMsgTipsElemBean parseGoldMsgPush(byte[] bArr);

    void removeQBaseActivityObserver(QBaseActivity qBaseActivity, b bVar);

    void reportDeviceCantPlayBackground(String str);

    void reportResPreload(kl2.a aVar, String str, String str2, int i3);

    void reportResRealTimeDownload(String str, String str2, int i3);

    void reset();

    void sendGetRecentList(BaseQQAppInterface baseQQAppInterface, PfaFriendRqt pfaFriendRqt);

    void sendMessage(AppRuntime appRuntime, Context context, Object obj, String str, ArrayList<AtTroopMemberInfo> arrayList);

    void showQQCustomDialogWithInputAndChoose(Activity activity, String str, DialogInterface.OnClickListener onClickListener);

    void startBirthdayHbSuccessFragment(Context context, Intent intent);

    void startForwardActivity(Context context, Intent intent);
}
