package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import s4.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$RefMaterialInfo extends MessageMicro<GameStrategyQA$RefMaterialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 64, 74, 82, 88, 96}, new String[]{"ref", "userinfo", "create_ts", "title", "content", c.PICS, "videos", "like_count", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "url", "appid", "is_self"}, new Object[]{null, null, 0L, "", "", null, null, 0, "", "", 0, Boolean.FALSE}, GameStrategyQA$RefMaterialInfo.class);
    public GameStrategyQA$RefInfo ref = new GameStrategyQA$RefInfo();
    public GameStrategyQA$UserInfo userinfo = new GameStrategyQA$UserInfo();
    public final PBUInt64Field create_ts = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public GameStrategyQA$Pics pics = new GameStrategyQA$Pics();
    public GameStrategyQA$Videos videos = new GameStrategyQA$Videos();
    public final PBUInt32Field like_count = PBField.initUInt32(0);
    public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBBoolField is_self = PBField.initBool(false);
}
