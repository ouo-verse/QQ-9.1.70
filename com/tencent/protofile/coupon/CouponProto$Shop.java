package com.tencent.protofile.coupon;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class CouponProto$Shop extends MessageMicro<CouponProto$Shop> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 130, 138, 144}, new String[]{"shid", "bid", "name", "addr", "detail", "city", TtmlNode.TAG_REGION, GdtGetUserInfoHandler.KEY_AREA, "tag", "contact", "tel", "maplng", "maplat", "mt", "couponids", "cname", "qlife_url", "source_id"}, new Object[]{0, 0, "", "", "", "", "", "", "", "", "", 0, 0, 0L, 0, "", "", 0}, CouponProto$Shop.class);
    public final PBUInt32Field shid = PBField.initUInt32(0);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField addr = PBField.initString("");
    public final PBStringField detail = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField region = PBField.initString("");
    public final PBStringField area = PBField.initString("");
    public final PBStringField tag = PBField.initString("");
    public final PBStringField contact = PBField.initString("");
    public final PBStringField tel = PBField.initString("");
    public final PBUInt32Field maplng = PBField.initUInt32(0);
    public final PBUInt32Field maplat = PBField.initUInt32(0);

    /* renamed from: mt, reason: collision with root package name */
    public final PBUInt64Field f342195mt = PBField.initUInt64(0);
    public final PBRepeatField<Integer> couponids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField cname = PBField.initString("");
    public final PBStringField qlife_url = PBField.initString("");
    public final PBUInt32Field source_id = PBField.initUInt32(0);
}
