package com.tencent.pb.mqqcomic;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class MqqComicHeadPb$ComicReqHead extends MessageMicro<MqqComicHeadPb$ComicReqHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 66, 74, 82, 90, 98, 106, 114, 122}, new String[]{"optTs", "src", "os", "clientVer", "net", "uin", "cmd", "screenQuality", Headers.ETAG, "skey", "unifiedImei", "biz_subid", "cs_id", "obj_pos", "page_id"}, new Object[]{0L, 0, 0, "", 0, 0L, "", "", "", "", "", "", "", "", ""}, MqqComicHeadPb$ComicReqHead.class);
    public final PBInt64Field optTs = PBField.initInt64(0);
    public final PBInt32Field src = PBField.initInt32(0);

    /* renamed from: os, reason: collision with root package name */
    public final PBInt32Field f342128os = PBField.initInt32(0);
    public final PBStringField clientVer = PBField.initString("");
    public final PBInt32Field net = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField cmd = PBField.initString("");
    public final PBStringField screenQuality = PBField.initString("");
    public final PBStringField etag = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBStringField unifiedImei = PBField.initString("");
    public final PBStringField biz_subid = PBField.initString("");
    public final PBStringField cs_id = PBField.initString("");
    public final PBStringField obj_pos = PBField.initString("");
    public final PBStringField page_id = PBField.initString("");
}
