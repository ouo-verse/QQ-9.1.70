package com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewCommon$RptData extends MessageMicro<ECQshopProductReviewCommon$RptData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"data_type", "text_data", "emoji_data", "href_data", "at_data"}, new Object[]{0, null, null, null, null}, ECQshopProductReviewCommon$RptData.class);
    public final PBInt32Field data_type = PBField.initInt32(0);
    public ECQshopProductReviewCommon$TextData text_data = new ECQshopProductReviewCommon$TextData();
    public ECQshopProductReviewCommon$EmojiData emoji_data = new MessageMicro<ECQshopProductReviewCommon$EmojiData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$EmojiData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"emoji"}, new Object[]{ByteStringMicro.EMPTY}, ECQshopProductReviewCommon$EmojiData.class);
        public final PBBytesField emoji = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public ECQshopProductReviewCommon$HrefData href_data = new MessageMicro<ECQshopProductReviewCommon$HrefData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$HrefData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"content", "url", "topic_id"}, new Object[]{"", "", ""}, ECQshopProductReviewCommon$HrefData.class);
        public final PBStringField content = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBStringField topic_id = PBField.initString("");
    };
    public ECQshopProductReviewCommon$AtData at_data = new MessageMicro<ECQshopProductReviewCommon$AtData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$AtData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"uid", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "avatar", "homepage", "content"}, new Object[]{"", "", "", "", ""}, ECQshopProductReviewCommon$AtData.class);
        public final PBStringField uid = PBField.initString("");
        public final PBStringField nick_name = PBField.initString("");
        public final PBStringField avatar = PBField.initString("");
        public final PBStringField homepage = PBField.initString("");
        public final PBStringField content = PBField.initString("");
    };
}
