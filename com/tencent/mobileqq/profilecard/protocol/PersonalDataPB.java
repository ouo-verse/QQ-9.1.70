package com.tencent.mobileqq.profilecard.protocol;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes35.dex */
public final class PersonalDataPB {

    /* loaded from: classes35.dex */
    public static final class MedalHallCard extends MessageMicro<MedalHallCard> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"title", "number", "picUrl", WadlProxyConsts.KEY_JUMP_URL}, new Object[]{"", 0, "", ""}, MedalHallCard.class);
        public final PBStringField title = PBField.initString("");
        public final PBUInt32Field number = PBField.initUInt32(0);
        public final PBRepeatField<String> picUrl = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField jumpUrl = PBField.initString("");
    }

    /* loaded from: classes35.dex */
    public static final class MusicGeneCard extends MessageMicro<MusicGeneCard> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"title", WadlProxyConsts.KEY_JUMP_URL, "leftTile", "leftValue", "rightTile", "rightValue"}, new Object[]{"", "", "", "", "", ""}, MusicGeneCard.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField jumpUrl = PBField.initString("");
        public final PBStringField leftTile = PBField.initString("");
        public final PBStringField leftValue = PBField.initString("");
        public final PBStringField rightTile = PBField.initString("");
        public final PBStringField rightValue = PBField.initString("");
    }

    /* loaded from: classes35.dex */
    public static final class PersonalData extends MessageMicro<PersonalData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"medalHall", "musicGene", "recentListening"}, new Object[]{null, null, ""}, PersonalData.class);
        public MedalHallCard medalHall = new MedalHallCard();
        public MusicGeneCard musicGene = new MusicGeneCard();
        public final PBStringField recentListening = PBField.initString("");
    }

    PersonalDataPB() {
    }
}
