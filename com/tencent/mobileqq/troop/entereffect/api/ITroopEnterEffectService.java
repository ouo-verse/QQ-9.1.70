package com.tencent.mobileqq.troop.entereffect.api;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.entereffect.e;
import com.tencent.mobileqq.troop.entereffect.f;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;
import tencent.qun.group_effect.group_effect_commu$TGetMyEffectRsp0x2;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopEnterEffectService extends IRuntimeService {
    public static final int JS_IPC_SUB_CMD_NOTIFY_CHANGE_STATUS = 2;
    public static final int JS_IPC_SUB_CMD_NOTIFY_SET_EFFECT = 1;
    public static final String SP_KEY_NO_LONGER_TIPS_ID = "gray_tips_no_longer_";
    public static final String SP_KEY_SHOW_GRAY_TIPS_TIME = "show_gray_tips_time";
    public static final String TAG = "TroopEnterEffect";

    void addTroopEnterEffectData(f fVar);

    e.b getAllEffectInfo();

    int getEffectId();

    int getEffectId(String str);

    e.c getEffectInfo(String str);

    f getFirstEffectData(String str);

    int getGroupLevel();

    int getMode();

    long getNotifyInterval();

    SharedPreferences getSharedPreferences();

    int getSvipLevel();

    int getSvipType();

    e getTroopEnterEffectConfig();

    boolean hasSetEffect(String str);

    boolean hasShowGrayTipsToday();

    boolean isAllTroopShowEnterance();

    boolean isEffectOn(String str);

    void notifyEnterTroop(String str);

    void readEffectConfigData(boolean z16);

    void removeAllEffectDatas(String str);

    void removeEnterEffectData(f fVar);

    void report(String str, String str2, String... strArr);

    void saveEffectConfigData(group_effect_commu$TGetMyEffectRsp0x2 group_effect_commu_tgetmyeffectrsp0x2);

    void setGroupLevel(int i3);

    void setMode(int i3);

    void setNotifyInterval(long j3);

    void setSvipLevel(int i3);

    void setSvipType(int i3);

    void updateEffectInfo(long j3, int i3, String str, int i16, int i17);

    void updateEffectInfo(e.b bVar);

    void updateEffectStatus(ArrayList<String> arrayList);

    void updateGlobalEffectInfo(int i3, String str, int i16, int i17);

    void updateNoLongerShowTips(String str);
}
