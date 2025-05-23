package com.tencent.filament.zplanservice.pbjava;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ResourceEtagInfo$etag_info extends MessageMicro<ResourceEtagInfo$etag_info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{Headers.ETAG, "save_path", "url"}, new Object[]{"", "", ""}, ResourceEtagInfo$etag_info.class);
    public final PBStringField etag = PBField.initString("");
    public final PBStringField save_path = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
