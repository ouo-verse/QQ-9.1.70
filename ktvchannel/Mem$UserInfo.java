package ktvchannel;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Mem$UserInfo extends MessageMicro<Mem$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{INetChannelCallback.KEY_TINY_ID, IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME}, new Object[]{0L, ByteStringMicro.EMPTY}, Mem$UserInfo.class);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
