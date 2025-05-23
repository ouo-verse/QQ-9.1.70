package com.tencent.mobileqq.gamecenter.qa.proto;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import s4.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$QuestionInfo extends MessageMicro<GameStrategyQA$QuestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<Long> answer_ids;
    public final PBStringField content;
    public final PBInt64Field create_time;
    public final PBStringField encode_author_uin;
    public final PBBoolField is_star;
    public final PBBoolField not_recommend;
    public final PBInt64Field op_time;
    public final PBUInt64Field op_uin;
    public GameStrategyQA$Pics pics;
    public final PBRepeatField<Long> tag_ids;
    public final PBStringField title;
    public final PBInt64Field update_time;

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f212675id = PBField.initInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt64Field author_uin = PBField.initUInt64(0);

    static {
        String[] strArr = {"id", "status", "appid", "author_uin", "answer_ids", "tag_ids", "title", "content", c.PICS, "is_star", AlbumCacheData.CREATE_TIME, "update_time", "op_uin", "op_time", "encode_author_uin", "not_recommend"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74, 80, 88, 96, 104, 112, 122, 128}, strArr, new Object[]{0L, 0, 0, 0L, 0L, 0L, "", "", null, bool, 0L, 0L, 0L, 0L, "", bool}, GameStrategyQA$QuestionInfo.class);
    }

    public GameStrategyQA$QuestionInfo() {
        PBInt64Field pBInt64Field = PBInt64Field.__repeatHelper__;
        this.answer_ids = PBField.initRepeat(pBInt64Field);
        this.tag_ids = PBField.initRepeat(pBInt64Field);
        this.title = PBField.initString("");
        this.content = PBField.initString("");
        this.pics = new GameStrategyQA$Pics();
        this.is_star = PBField.initBool(false);
        this.create_time = PBField.initInt64(0L);
        this.update_time = PBField.initInt64(0L);
        this.op_uin = PBField.initUInt64(0L);
        this.op_time = PBField.initInt64(0L);
        this.encode_author_uin = PBField.initString("");
        this.not_recommend = PBField.initBool(false);
    }
}
