package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_service$RspGetMusicListConfig extends MessageMicro<qqstory_service$RspGetMusicListConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"result", "music_config"}, new Object[]{null, null}, qqstory_service$RspGetMusicListConfig.class);
    public qqstory_struct$ErrorInfo result = new qqstory_struct$ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct$MusicConfigInfo> music_config = PBField.initRepeatMessage(qqstory_struct$MusicConfigInfo.class);
}
