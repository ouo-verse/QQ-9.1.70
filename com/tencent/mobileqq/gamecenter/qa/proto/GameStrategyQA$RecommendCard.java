package com.tencent.mobileqq.gamecenter.qa.proto;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$RecommendCard extends MessageMicro<GameStrategyQA$RecommendCard> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt64Field question_id = PBField.initInt64(0);
    public final PBStringField question_title = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public GameStrategyQA$UserInfo author = new GameStrategyQA$UserInfo();
    public final PBInt64Field hot_answer_id = PBField.initInt64(0);
    public final PBBoolField is_answered = PBField.initBool(false);
    public final PBBoolField is_liked_question = PBField.initBool(false);
    public final PBInt64Field like = PBField.initInt64(0);
    public final PBEnumField source = PBField.initEnum(0);

    static {
        String[] strArr = {"question_id", "question_title", AlbumCacheData.CREATE_TIME, "author", "hot_answer_id", "is_answered", "is_liked_question", "like", "source"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64, 72}, strArr, new Object[]{0L, "", 0L, null, 0L, bool, bool, 0L, 0}, GameStrategyQA$RecommendCard.class);
    }
}
