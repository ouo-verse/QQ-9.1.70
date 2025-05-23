package com.tencent.qwallet;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class CodeGenerate$CodeGenerateRes extends MessageMicro<CodeGenerate$CodeGenerateRes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"retcode", "retmsg", "uin", "cn", "token", "token_md5", DefaultTVKDataProvider.KEY_PAY_TYPE, "valid_end", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "pay_desc", "code_prefix", "forbid_watch"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", ""}, CodeGenerate$CodeGenerateRes.class);
    public final PBStringField retcode = PBField.initString("");
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField uin = PBField.initString("");

    /* renamed from: cn, reason: collision with root package name */
    public final PBStringField f364003cn = PBField.initString("");
    public final PBStringField token = PBField.initString("");
    public final PBStringField token_md5 = PBField.initString("");
    public final PBStringField pay_type = PBField.initString("");
    public final PBStringField valid_end = PBField.initString("");
    public final PBStringField random = PBField.initString("");
    public final PBStringField pay_desc = PBField.initString("");
    public final PBStringField code_prefix = PBField.initString("");
    public final PBStringField forbid_watch = PBField.initString("");
}
