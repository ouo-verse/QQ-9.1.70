package expand.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MatchedInfo extends MessageMicro<MatchedInfo> {
    public static final int FromApplet = 9;
    public static final int FromExpandMatch = 0;
    public static final int FromExpandSignal = 8;
    public static final int FromFindSamePreference = 3;
    public static final int FromFindTeammate = 1;
    public static final int FromFindTreeHole = 2;
    public static final int FromHeatbeatLab = 102;
    public static final int FromKingDD = 12;
    public static final int FromKingOnGame = 302;
    public static final int FromLuckyBox = 16;
    public static final int FromMakeQFriend = 4;
    public static final int FromMatchDailyPush = 15;
    public static final int FromMatchWall = 14;
    public static final int FromMyVoice = 11;
    public static final int FromOnGameVoiceRoom = 303;
    public static final int FromSamePreferenceWave = 13;
    public static final int FromSmallGameHall = 301;
    public static final int FromSocialExperimentStation = 106;
    public static final int FromSweetCoupleVoucher = 105;
    public static final int FromTopicMatch = 7;
    public static final int FromVoiceLink = 5;
    public static final int FromWalmSay = 10;
    public static final int FromWalmTalk = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"MatchedUin", "Timestamp", "OldMatchSrcId", "MatchSrcId", "MatchSrcDes", "NewMatchTip"}, new Object[]{0L, 0L, 0, 0, "", ""}, MatchedInfo.class);
    public final PBUInt64Field MatchedUin = PBField.initUInt64(0);
    public final PBUInt64Field Timestamp = PBField.initUInt64(0);
    public final PBUInt32Field OldMatchSrcId = PBField.initUInt32(0);
    public final PBUInt32Field MatchSrcId = PBField.initUInt32(0);
    public final PBStringField MatchSrcDes = PBField.initString("");
    public final PBStringField NewMatchTip = PBField.initString("");
}
