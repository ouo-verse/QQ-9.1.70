package NS_MINI_INTERFACE;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.raft.codegenmeta.utils.Constants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$ControlInfo extends MessageMicro<CONTAINER_INTERFACE$ControlInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cookies", Constants.Service.CONFIG_NAME_SPACE, MosaicConstants$JsProperty.PROP_ENV}, new Object[]{ByteStringMicro.EMPTY, "", ""}, CONTAINER_INTERFACE$ControlInfo.class);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField namespace = PBField.initString("");
    public final PBStringField env = PBField.initString("");
}
