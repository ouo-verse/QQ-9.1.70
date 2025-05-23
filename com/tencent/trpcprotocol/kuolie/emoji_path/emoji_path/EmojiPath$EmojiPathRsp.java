package com.tencent.trpcprotocol.kuolie.emoji_path.emoji_path;

import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class EmojiPath$EmojiPathRsp extends MessageMicro<EmojiPath$EmojiPathRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{IQQGameCommApi.K_ABTEST_MODELS}, new Object[]{null}, EmojiPath$EmojiPathRsp.class);
    public final PBRepeatMessageField<EmojiPath$EmojiPathModel> models = PBField.initRepeatMessage(EmojiPath$EmojiPathModel.class);
}
