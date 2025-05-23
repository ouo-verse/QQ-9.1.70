package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetTagsReply extends MessageMicro<GameStrategyQA$GetTagsReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{null}, GameStrategyQA$GetTagsReply.class);
    public final PBRepeatMessageField<GameStrategyQA$TagInfo> tags = PBField.initRepeatMessage(GameStrategyQA$TagInfo.class);
}
