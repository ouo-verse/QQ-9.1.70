package com.tencent.qwallet;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class CodeGenerate$CodeGenerateReq extends MessageMicro<CodeGenerate$CodeGenerateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 122}, new String[]{"uin", "cn", "guid", "device_id", "device_type", "device_name", "token_md5", "timestamp", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "sign", "h_location", "h_model", "h_edition", "h_qq_appid", "h_qq_guid"}, new Object[]{"", "", "", "", "", "", "", 0L, "", "", "", "", "", "", ""}, CodeGenerate$CodeGenerateReq.class);
    public final PBStringField uin = PBField.initString("");

    /* renamed from: cn, reason: collision with root package name */
    public final PBStringField f364002cn = PBField.initString("");
    public final PBStringField guid = PBField.initString("");
    public final PBStringField device_id = PBField.initString("");
    public final PBStringField device_type = PBField.initString("");
    public final PBStringField device_name = PBField.initString("");
    public final PBStringField token_md5 = PBField.initString("");
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBStringField random = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBStringField h_location = PBField.initString("");
    public final PBStringField h_model = PBField.initString("");
    public final PBStringField h_edition = PBField.initString("");
    public final PBStringField h_qq_appid = PBField.initString("");
    public final PBStringField h_qq_guid = PBField.initString("");
}
