package com.tencent.mobileqq.gamecenter.qa.proto;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import s4.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$AnswerBase extends MessageMicro<GameStrategyQA$AnswerBase> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f212669id = PBField.initInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field browse_count = PBField.initInt64(0);
    public final PBInt64Field question_id = PBField.initInt64(0);
    public final PBStringField content = PBField.initString("");
    public GameStrategyQA$Pics pics = new GameStrategyQA$Pics();
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field like_count = PBField.initInt64(0);
    public final PBBoolField is_star = PBField.initBool(false);
    public final PBInt64Field comment_count = PBField.initInt64(0);
    public final PBBoolField is_liked = PBField.initBool(false);
    public final PBStringField encode_author_uin = PBField.initString("");
    public final PBBoolField questioner_like = PBField.initBool(false);
    public final PBInt32Field source = PBField.initInt32(0);
    public GameStrategyQA$Videos videos = new GameStrategyQA$Videos();
    public GameStrategyQA$UserInfo2 author = new GameStrategyQA$UserInfo2();

    static {
        String[] strArr = {"id", "status", "appid", "browse_count", "question_id", "content", c.PICS, AlbumCacheData.CREATE_TIME, "like_count", "is_star", "comment_count", "is_liked", "encode_author_uin", "questioner_like", "source", "videos", "author"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64, 72, 80, 88, 96, 106, 112, 120, 130, 138}, strArr, new Object[]{0L, 0, 0, 0L, 0L, "", null, 0L, 0L, bool, 0L, bool, "", bool, 0, null, null}, GameStrategyQA$AnswerBase.class);
    }
}
