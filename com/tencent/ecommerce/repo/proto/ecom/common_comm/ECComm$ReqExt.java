package com.tencent.ecommerce.repo.proto.ecom.common_comm;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.uf.l;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECComm$ReqExt extends MessageMicro<ECComm$ReqExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, l.CTRL_INDEX, 800, 810, 818, 1602}, new String[]{"pindao_id", "content_id", "qqlive_room_id", "origin_product_id", "media_product_id", "xworld_comment_id", "qqlive_session_id", "detail_product_id", "wechat_appid", "qq_appid", "scene_source", WadlProxyConsts.CHANNEL, "promotion_type", "seller_media_id", "trace_key", "active_id"}, new Object[]{"", "", "", "", "", "", "", "", "", "", 0, 0, 0, "", "", ""}, ECComm$ReqExt.class);
    public final PBStringField pindao_id = PBField.initString("");
    public final PBStringField content_id = PBField.initString("");
    public final PBStringField qqlive_room_id = PBField.initString("");
    public final PBStringField origin_product_id = PBField.initString("");
    public final PBStringField media_product_id = PBField.initString("");
    public final PBStringField xworld_comment_id = PBField.initString("");
    public final PBStringField qqlive_session_id = PBField.initString("");
    public final PBStringField detail_product_id = PBField.initString("");
    public final PBStringField wechat_appid = PBField.initString("");
    public final PBStringField qq_appid = PBField.initString("");
    public final PBUInt32Field scene_source = PBField.initUInt32(0);
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBUInt32Field promotion_type = PBField.initUInt32(0);
    public final PBStringField seller_media_id = PBField.initString("");
    public final PBStringField trace_key = PBField.initString("");
    public final PBStringField active_id = PBField.initString("");
}
