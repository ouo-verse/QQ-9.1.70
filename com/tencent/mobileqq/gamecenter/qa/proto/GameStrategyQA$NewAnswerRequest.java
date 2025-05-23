package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import s4.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$NewAnswerRequest extends MessageMicro<GameStrategyQA$NewAnswerRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64, 74, 82}, new String[]{"appid", "question_id", "content", c.PICS, "source", "videos", "id", "scene", "refs", "rich_content"}, new Object[]{0, 0L, "", null, 0, null, 0L, 0, null, ""}, GameStrategyQA$NewAnswerRequest.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field question_id = PBField.initInt64(0);
    public final PBStringField content = PBField.initString("");
    public GameStrategyQA$Pics pics = new GameStrategyQA$Pics();
    public final PBEnumField source = PBField.initEnum(0);
    public GameStrategyQA$Videos videos = new GameStrategyQA$Videos();

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f212672id = PBField.initInt64(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public GameStrategyQA$Refs refs = new GameStrategyQA$Refs();
    public final PBStringField rich_content = PBField.initString("");
}
