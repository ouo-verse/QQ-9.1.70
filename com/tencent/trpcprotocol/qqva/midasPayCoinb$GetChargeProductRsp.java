package com.tencent.trpcprotocol.qqva;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class midasPayCoinb$GetChargeProductRsp extends MessageMicro<midasPayCoinb$GetChargeProductRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381634msg = PBField.initString("");
    public midasPayCoinb$Balance balance = new midasPayCoinb$Balance();
    public final PBRepeatMessageField<midasPayCoinb$ChargeProductItem> products = PBField.initRepeatMessage(midasPayCoinb$ChargeProductItem.class);
    public final PBInt32Field default_coin_num = PBField.initInt32(0);
    public final PBBoolField is_coinb = PBField.initBool(false);
    public final PBStringField coinb_offerid = PBField.initString("");
    public final PBBoolField is_first_save = PBField.initBool(false);
    public final PBStringField first_save_title = PBField.initString("");
    public final PBBoolField is_rebate = PBField.initBool(false);
    public final PBStringField rebate_banner_jump_url = PBField.initString("");
    public final PBStringField rebate_banner_image_url = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 90, 98}, new String[]{"code", "msg", "balance", "products", "default_coin_num", "is_coinb", "coinb_offerid", "is_first_save", "first_save_title", "is_rebate", "rebate_banner_jump_url", "rebate_banner_image_url"}, new Object[]{0, "", null, null, 0, bool, "", bool, "", bool, "", ""}, midasPayCoinb$GetChargeProductRsp.class);
    }
}
