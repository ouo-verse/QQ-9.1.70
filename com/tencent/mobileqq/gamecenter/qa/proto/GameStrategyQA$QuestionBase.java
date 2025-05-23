package com.tencent.mobileqq.gamecenter.qa.proto;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import s4.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$QuestionBase extends MessageMicro<GameStrategyQA$QuestionBase> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f212674id = PBField.initInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field browse_count = PBField.initInt64(0);
    public final PBRepeatField<Long> answer_ids = PBField.initRepeat(PBInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<GameStrategyQA$TagInfo> tags = PBField.initRepeatMessage(GameStrategyQA$TagInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public GameStrategyQA$Pics pics = new GameStrategyQA$Pics();
    public final PBBoolField is_star = PBField.initBool(false);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field like_count = PBField.initInt64(0);
    public final PBInt64Field answer_count = PBField.initInt64(0);
    public final PBStringField encode_author_uin = PBField.initString("");
    public final PBBoolField not_recommend = PBField.initBool(false);
    public final PBInt32Field source = PBField.initInt32(0);
    public GameStrategyQA$Videos videos = new GameStrategyQA$Videos();
    public GameStrategyQA$UserInfo2 author = new GameStrategyQA$UserInfo2();
    public final PBBoolField is_answered = PBField.initBool(false);
    public final PBBoolField is_liked_question = PBField.initBool(false);

    static {
        String[] strArr = {"id", "status", "appid", "browse_count", "answer_ids", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "title", "content", c.PICS, "is_star", AlbumCacheData.CREATE_TIME, "like_count", "answer_count", "encode_author_uin", "not_recommend", "source", "videos", "author", "is_answered", "is_liked_question"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 74, 80, 88, 96, 104, 122, 128, 136, 146, 154, 160, 168}, strArr, new Object[]{0L, 0, 0, 0L, 0L, null, "", "", null, bool, 0L, 0L, 0L, "", bool, 0, null, null, bool, bool}, GameStrategyQA$QuestionBase.class);
    }
}
