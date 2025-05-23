package pb.unify.search;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import unify.search.UnifySearchCommon$ExtensionRequestInfo;
import unify.search.UnifySearchCommon$RootSearcherRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchUnite$ReqBody extends MessageMicro<UnifySearchUnite$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field client_has_people_and_qun;
    public UnifySearchCommon$ExtensionRequestInfo extension_request_info;
    public final PBUInt32Field from_action;
    public final PBUInt32Field from_tabbar_index;
    public final PBBytesField key_word;
    public final PBUInt32Field locate_result_count;
    public UnifySearchCommon$RootSearcherRequest req_entity;
    public UnifySearchCommon$RootSearcherRequest req_topic;
    public final PBUInt32Field source;
    public final PBUInt32Field use_req_mask_only;
    public final PBBytesField version;

    static {
        String[] strArr = {QCircleSchemeAttr.Detail.KEY_WORD, "version", "req_entity", "req_topic", "from_action", "client_has_people_and_qun", "from_tabbar_index", "source", "locate_result_count", "use_req_mask_only", "extension_request_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 72, 80, 802}, strArr, new Object[]{byteStringMicro, byteStringMicro, null, null, 0, 0, 0, 0, 0, 0, null}, UnifySearchUnite$ReqBody.class);
    }

    public UnifySearchUnite$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key_word = PBField.initBytes(byteStringMicro);
        this.version = PBField.initBytes(byteStringMicro);
        this.req_entity = new UnifySearchCommon$RootSearcherRequest();
        this.req_topic = new UnifySearchCommon$RootSearcherRequest();
        this.from_action = PBField.initUInt32(0);
        this.client_has_people_and_qun = PBField.initUInt32(0);
        this.from_tabbar_index = PBField.initUInt32(0);
        this.source = PBField.initUInt32(0);
        this.locate_result_count = PBField.initUInt32(0);
        this.use_req_mask_only = PBField.initUInt32(0);
        this.extension_request_info = new UnifySearchCommon$ExtensionRequestInfo();
    }
}
