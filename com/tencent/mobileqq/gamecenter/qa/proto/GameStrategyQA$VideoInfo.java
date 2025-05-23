package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$VideoInfo extends MessageMicro<GameStrategyQA$VideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"video_url", QZoneJsConstants.DYNAMIC_ALBUM_COVER_PIC, "duration"}, new Object[]{"", null, 0L}, GameStrategyQA$VideoInfo.class);
    public final PBStringField video_url = PBField.initString("");
    public GameStrategyQA$PicInfo cover_pic = new GameStrategyQA$PicInfo();
    public final PBUInt64Field duration = PBField.initUInt64(0);
}
