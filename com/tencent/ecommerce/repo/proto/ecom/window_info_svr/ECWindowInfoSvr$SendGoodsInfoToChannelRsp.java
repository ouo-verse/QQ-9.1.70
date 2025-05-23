package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.ecommerce.repo.proto.ecom.shop_sales_center.ECShopSalesCenter$SelectionCenter;
import com.tencent.ecommerce.repo.proto.ecom.shop_sales_center.ECShopSalesCenter$ShowWindow;
import com.tencent.ecommerce.repo.proto.ecom.shop_sales_center.ECShopSalesCenter$TodayTurnover;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$SendGoodsInfoToChannelRsp extends MessageMicro<ECWindowInfoSvr$SendGoodsInfoToChannelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 74}, new String[]{"today_turnover", "selection_center", QCircleDaTongConstant.ElementParamValue.SHOW_WINDOW, "right_status", "open_right_url", "goods_url", "media_id", "window_master_url", "window_guest_url"}, new Object[]{null, null, null, 0, "", "", "", "", ""}, ECWindowInfoSvr$SendGoodsInfoToChannelRsp.class);
    public ECShopSalesCenter$TodayTurnover today_turnover = new ECShopSalesCenter$TodayTurnover();
    public ECShopSalesCenter$SelectionCenter selection_center = new ECShopSalesCenter$SelectionCenter();
    public ECShopSalesCenter$ShowWindow show_window = new ECShopSalesCenter$ShowWindow();
    public final PBInt32Field right_status = PBField.initInt32(0);
    public final PBStringField open_right_url = PBField.initString("");
    public final PBStringField goods_url = PBField.initString("");
    public final PBStringField media_id = PBField.initString("");
    public final PBStringField window_master_url = PBField.initString("");
    public final PBStringField window_guest_url = PBField.initString("");
}
