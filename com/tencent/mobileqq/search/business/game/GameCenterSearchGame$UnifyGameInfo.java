package com.tencent.mobileqq.search.business.game;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class GameCenterSearchGame$UnifyGameInfo extends MessageMicro<GameCenterSearchGame$UnifyGameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"appid", "name", "icon", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "jump_url"}, new Object[]{"", "", "", "", ""}, GameCenterSearchGame$UnifyGameInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField jump_url = PBField.initString("");
}
