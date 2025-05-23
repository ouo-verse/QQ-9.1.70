package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMemberDetectSvr$DuplicateMember extends MessageMicro<TroopMemberDetectSvr$DuplicateMember> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uin", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "avatar", "groups"}, new Object[]{0L, "", "", null}, TroopMemberDetectSvr$DuplicateMember.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBRepeatMessageField<TroopMemberDetectSvr$GroupInfo> groups = PBField.initRepeatMessage(TroopMemberDetectSvr$GroupInfo.class);
}
