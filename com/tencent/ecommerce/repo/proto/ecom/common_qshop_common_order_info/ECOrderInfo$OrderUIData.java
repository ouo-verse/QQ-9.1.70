package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderInfo$OrderUIData extends MessageMicro<ECOrderInfo$OrderUIData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField allow_delay_receipt = PBField.initBool(false);
    public final PBBoolField allow_update_address = PBField.initBool(false);
    public final PBBoolField allow_cancel_order = PBField.initBool(false);
    public final PBBoolField allow_pay_order = PBField.initBool(false);
    public final PBBoolField allow_confirm_received = PBField.initBool(false);
    public final PBBoolField allow_comment = PBField.initBool(false);
    public final PBBoolField allow_view_shipping = PBField.initBool(false);
    public final PBBoolField allow_launch_after_sales = PBField.initBool(false);
    public final PBBoolField allow_view_comment = PBField.initBool(false);
    public final PBBoolField allow_refund_order = PBField.initBool(false);
    public final PBBoolField allow_view_refund_detail = PBField.initBool(false);
    public final PBBoolField allow_view_after_sales_detail = PBField.initBool(false);
    public final PBStringField apply_refund_or_after_sales_url = PBField.initString("");
    public final PBStringField view_refund_or_after_sales_url = PBField.initString("");
    public final PBStringField order_state_desc_str = PBField.initString("");
    public final PBStringField exceeded_apply_after_sales_deadline_str = PBField.initString("");
    public final PBStringField exceeded_update_address_deadline_str = PBField.initString("");
    public final PBBoolField allow_show_virtual_account = PBField.initBool(false);
    public final PBBoolField allow_view_address = PBField.initBool(false);
    public final PBBoolField allow_view_shipping_cost = PBField.initBool(false);
    public final PBBoolField show_bulletin = PBField.initBool(false);
    public final PBBoolField allow_send_box = PBField.initBool(false);
    public final PBStringField delivery_msg = PBField.initString("");
    public final PBBoolField allow_lanch_platform_service = PBField.initBool(false);
    public final PBStringField order_state_preferred_str = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106, 114, 122, 130, 138, 144, 152, 160, 168, 176, 186, 192, 202}, new String[]{"allow_delay_receipt", "allow_update_address", "allow_cancel_order", "allow_pay_order", "allow_confirm_received", "allow_comment", "allow_view_shipping", "allow_launch_after_sales", "allow_view_comment", "allow_refund_order", "allow_view_refund_detail", "allow_view_after_sales_detail", "apply_refund_or_after_sales_url", "view_refund_or_after_sales_url", "order_state_desc_str", "exceeded_apply_after_sales_deadline_str", "exceeded_update_address_deadline_str", "allow_show_virtual_account", "allow_view_address", "allow_view_shipping_cost", "show_bulletin", "allow_send_box", "delivery_msg", "allow_lanch_platform_service", "order_state_preferred_str"}, new Object[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, "", "", "", "", "", bool, bool, bool, bool, bool, "", bool, ""}, ECOrderInfo$OrderUIData.class);
    }
}
