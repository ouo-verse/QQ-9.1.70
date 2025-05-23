package com.tencent.mobileqq.gamecenter.qa.proto;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$StarUser extends MessageMicro<GameStrategyQA$StarUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"author", "answer_num", PictureConst.PHOTO_LIKE_NUM}, new Object[]{null, 0L, 0L}, GameStrategyQA$StarUser.class);
    public GameStrategyQA$UserInfo author = new GameStrategyQA$UserInfo();
    public final PBInt64Field answer_num = PBField.initInt64(0);
    public final PBInt64Field like_num = PBField.initInt64(0);
}
