package com.tencent.mobileqq.vas.svip.api;

import MQQ.GetRoamToastRsp;
import QC.Hamlet;
import QC.LoginInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

/* loaded from: classes20.dex */
public interface ISVIPHandler {
    void addSendingBubbleId(MessageRecord messageRecord);

    void changeSubBubbleId();

    void closeToast(GetRoamToastRsp getRoamToastRsp);

    ToServiceMsg createToServiceMsg(String str, BusinessObserver businessObserver, boolean z16);

    void doFriendCloneAuth(String str, boolean z16, int i3);

    void getBigTroopExpiredInfo(long j3);

    int getBubbleIdFromMessageRecord(MessageRecord messageRecord);

    int getBubbleMsgLimit();

    void getBubbleRecommend();

    int getColorScreenId(String str);

    int getCurrentUserVipType();

    void getFontRecommend();

    LoginInfo getLoginInfo(AppRuntime appRuntime);

    void getRoamToast();

    int getSelfBubbleDiyTextId();

    int getSelfBubbleId();

    int getSelfBubbleVoicePrintId();

    int getSelfFontId();

    NTVasSimpleInfo getSelfFontInfo();

    int getSubBubbleId();

    void gxhLoginCheck(ArrayList<Hamlet> arrayList, BusinessObserver businessObserver, boolean z16);

    void gxhLoginCheckForTroopKeywork(BusinessObserver businessObserver, boolean z16);

    void handleFriendClone(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    void handleRequestDefaultCard(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    boolean isBubblePackage(int i3, int i16);

    void notifyUI(int i3, boolean z16, Object obj);

    void pbGetDiyFontConfig(Map<String, Integer> map);

    void requestColorNickPanel(int i3);

    void requestDefaultCardInfo(int i3);

    void setColorScreenId(String str, int i3);

    void setColorScreenTestId(int i3);

    void setDefaultCardFlag(int i3);

    void setDefaultCardId(int i3);

    void setFace(int i3);

    void setFontBubble(int i3, int i16, int i17);

    void setFontEffect(int i3);

    void setMagicFont(int i3);

    void setSelfBubbleDiyTextId(int i3, boolean z16);

    void setSelfBubbleId(int i3);

    void setSelfBubbleVoicePrintId(int i3);

    void setSelfFontInfo(int i3, int i16);

    void setSelfPendantDiyId(int i3, boolean z16);

    boolean shouldShowToast(GetRoamToastRsp getRoamToastRsp);

    void updateSelfMsgBubbleId();
}
