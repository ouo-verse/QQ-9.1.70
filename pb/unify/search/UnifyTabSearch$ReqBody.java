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
public final class UnifyTabSearch$ReqBody extends MessageMicro<UnifyTabSearch$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public UnifySearchCommon$ExtensionRequestInfo extension_request_info;
    public final PBUInt32Field from_sub_hot_word_id;
    public final PBUInt32Field from_tabbar_index;
    public final PBBytesField key_word;
    public UnifySearchCommon$RootSearcherRequest search_request;
    public final PBBytesField version;

    static {
        String[] strArr = {QCircleSchemeAttr.Detail.KEY_WORD, "version", "search_request", "extension_request_info", "from_sub_hot_word_id", "from_tabbar_index"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 802, 808, 816}, strArr, new Object[]{byteStringMicro, byteStringMicro, null, null, 0, 0}, UnifyTabSearch$ReqBody.class);
    }

    public UnifyTabSearch$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key_word = PBField.initBytes(byteStringMicro);
        this.version = PBField.initBytes(byteStringMicro);
        this.search_request = new UnifySearchCommon$RootSearcherRequest();
        this.extension_request_info = new UnifySearchCommon$ExtensionRequestInfo();
        this.from_sub_hot_word_id = PBField.initUInt32(0);
        this.from_tabbar_index = PBField.initUInt32(0);
    }
}
