package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$BuyerOrder extends MessageMicro<ECOrder$BuyerOrder> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82, 162, 242, 322, 800}, new String[]{"basic_info", "seller", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "product", "evaluation", QCircleDaTongConstant.ElementParamValue.SHOW_WINDOW, "enable_buy_one_more"}, new Object[]{null, null, null, null, null, null, Boolean.FALSE}, ECOrder$BuyerOrder.class);
    public ECOrder$BasicInfo basic_info = new ECOrder$BasicInfo();
    public ECOrder$SellerInfo seller = new MessageMicro<ECOrder$SellerInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$SellerInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_id", AudienceReportConst.USER_NAME, "icon_url"}, new Object[]{"", "", ""}, ECOrder$SellerInfo.class);
        public final PBStringField user_id = PBField.initString("");
        public final PBStringField user_name = PBField.initString("");
        public final PBStringField icon_url = PBField.initString("");
    };
    public ECOrder$LinkInfo link = new ECOrder$LinkInfo();
    public ECOrder$ProductInfo product = new ECOrder$ProductInfo();
    public ECOrder$EvaluationInfo evaluation = new MessageMicro<ECOrder$EvaluationInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$EvaluationInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"evaluation_state"}, new Object[]{0}, ECOrder$EvaluationInfo.class);
        public final PBInt32Field evaluation_state = PBField.initInt32(0);
    };
    public ECOrder$ShowWindowInfo show_window = new MessageMicro<ECOrder$ShowWindowInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_order.ECOrder$ShowWindowInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"url"}, new Object[]{""}, ECOrder$ShowWindowInfo.class);
        public final PBStringField url = PBField.initString("");
    };
    public final PBBoolField enable_buy_one_more = PBField.initBool(false);
}
