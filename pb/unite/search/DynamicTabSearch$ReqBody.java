package pb.unite.search;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import unite.DynamicSearch$ExtensionRequestInfo;
import unite.DynamicSearch$RootSearcherRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicTabSearch$ReqBody extends MessageMicro<DynamicTabSearch$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public DynamicSearch$ExtensionRequestInfo extension_request_info;
    public final PBUInt32Field from_sub_hot_word_id;
    public final PBBytesField key_word;
    public DynamicSearch$RootSearcherRequest search_request;
    public final PBBytesField version;

    static {
        String[] strArr = {QCircleSchemeAttr.Detail.KEY_WORD, "version", "search_request", "extension_request_info", "from_sub_hot_word_id"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 802, 808}, strArr, new Object[]{byteStringMicro, byteStringMicro, null, null, 0}, DynamicTabSearch$ReqBody.class);
    }

    public DynamicTabSearch$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key_word = PBField.initBytes(byteStringMicro);
        this.version = PBField.initBytes(byteStringMicro);
        this.search_request = new DynamicSearch$RootSearcherRequest();
        this.extension_request_info = new DynamicSearch$ExtensionRequestInfo();
        this.from_sub_hot_word_id = PBField.initUInt32(0);
    }
}
