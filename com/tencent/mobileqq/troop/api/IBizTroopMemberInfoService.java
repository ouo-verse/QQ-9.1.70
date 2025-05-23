package com.tencent.mobileqq.troop.api;

import android.graphics.drawable.Drawable;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.HWTroopMemberCard;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IBizTroopMemberInfoService extends IRuntimeService {
    void asynSaveHomeworkTroopMemberIdentity(String str, String str2, String str3, int i3, String str4, String str5);

    boolean getCalendarNoticeTroopMember(String str, String str2, long j3, ProtoUtils.TroopProtocolObserver troopProtocolObserver);

    HWTroopMemberCard getHWTroopMemberCard(String str, String str2);

    MessageRecord getRobotLastSpeakMessage(String str, String str2);

    TroopMemberCard getTroopMemberCard(String str, String str2);

    Drawable getTroopMemberLevelDrawable(int i3, String str);

    String getTroopMemberNickNoEmpty(String str, String str2);

    void handleAgreeJion(String str, String str2, String str3);

    void saveHWTroopMemberCard(String str, String str2, HWTroopMemberCard hWTroopMemberCard);

    void saveHomeworkTroopMemberIdentity(String str, String str2, String str3, int i3, String str4, String str5);

    void saveTroopMemberLevelDrawable(int i3, String str, Drawable drawable);

    boolean saveTroopMemberSpearkFlag(String str, String str2, byte b16);
}
