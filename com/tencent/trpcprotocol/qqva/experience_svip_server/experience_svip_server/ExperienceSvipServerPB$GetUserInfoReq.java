package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$GetUserInfoReq extends MessageMicro<ExperienceSvipServerPB$GetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE}, new Object[]{0}, ExperienceSvipServerPB$GetUserInfoReq.class);
    public final PBRepeatField<Integer> info_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
