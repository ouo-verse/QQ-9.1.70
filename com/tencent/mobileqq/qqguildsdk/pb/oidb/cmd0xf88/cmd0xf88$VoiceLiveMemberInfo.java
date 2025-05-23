package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class cmd0xf88$VoiceLiveMemberInfo extends MessageMicro<cmd0xf88$VoiceLiveMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_avatar_meta;
    public final PBBytesField bytes_trans_data;
    public final PBBytesField nick_name;
    public final PBUInt64Field tiny_id;
    public final PBUInt32Field uint32_gender;

    static {
        String[] strArr = {IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "bytes_avatar_meta", "bytes_trans_data", "uint32_gender", INetChannelCallback.KEY_TINY_ID};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0L}, cmd0xf88$VoiceLiveMemberInfo.class);
    }

    public cmd0xf88$VoiceLiveMemberInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.nick_name = PBField.initBytes(byteStringMicro);
        this.bytes_avatar_meta = PBField.initBytes(byteStringMicro);
        this.bytes_trans_data = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.tiny_id = PBField.initUInt64(0L);
    }
}
