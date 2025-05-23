package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchDiscovery$RspBody extends MessageMicro<UnifySearchDiscovery$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bucket_id;
    public final PBBytesField error_msg;
    public final PBUInt32Field expire_time;
    public final PBBoolField is_jump_to_net_result_page;
    public final PBBytesField rsp_ext;
    public final PBRepeatMessageField<UnifySearchDiscovery$TabBizPair> tab_config;
    public final PBRepeatMessageField<UnifySearchDiscovery$Result> result_items = PBField.initRepeatMessage(UnifySearchDiscovery$Result.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);

    static {
        String[] strArr = {"result_items", "result_code", "error_msg", VasQQSettingMeImpl.EXPIRE_TIME, "bucket_id", "rsp_ext", "is_jump_to_net_result_page", "tab_config"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 56, 66}, strArr, new Object[]{null, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, Boolean.FALSE, null}, UnifySearchDiscovery$RspBody.class);
    }

    public UnifySearchDiscovery$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.error_msg = PBField.initBytes(byteStringMicro);
        this.expire_time = PBField.initUInt32(0);
        this.bucket_id = PBField.initBytes(byteStringMicro);
        this.rsp_ext = PBField.initBytes(byteStringMicro);
        this.is_jump_to_net_result_page = PBField.initBool(false);
        this.tab_config = PBField.initRepeatMessage(UnifySearchDiscovery$TabBizPair.class);
    }
}
