package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$ToastInfo;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IBizTroopInfoService extends IRuntimeService {
    int getAssociatedTroopCount(String str);

    String getCurrentOpenTroop();

    oidb_cmd0xb36$ToastInfo getTroopSurveyList(String str);

    boolean getmIsShowTroopBigClub();

    boolean isChangedTroopBigClub();

    boolean isCurrentOpenTroop(String str);

    boolean isFansTroop(String str);

    boolean isShowTroopBigClub();

    boolean isTroopAIOOpen();

    boolean isTroopConfessPanelOpen();

    void onTroopReceiveOrSendMsg(String str);

    void setAssociatedTroopCount(String str, int i3);

    void setCurrentOpenTroop(String str);

    void setShowTroopBigClub(boolean z16);

    void setTroopAIOOpen(boolean z16);

    void setTroopConfessPanelOpen(boolean z16);

    void updateTroopSurveyList(oidb_cmd0xb36$RspBody oidb_cmd0xb36_rspbody);
}
