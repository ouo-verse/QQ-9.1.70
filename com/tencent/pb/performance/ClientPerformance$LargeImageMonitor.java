package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$LargeImageMonitor extends MessageMicro<ClientPerformance$LargeImageMonitor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"type", "image_layout_relation", "stage", "page", "img_size", "view_size", "info"}, new Object[]{"", "", "", "", "", "", null}, ClientPerformance$LargeImageMonitor.class);
    public final PBStringField type = PBField.initString("");
    public final PBStringField image_layout_relation = PBField.initString("");
    public final PBStringField stage = PBField.initString("");
    public final PBStringField page = PBField.initString("");
    public final PBStringField img_size = PBField.initString("");
    public final PBStringField view_size = PBField.initString("");
    public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();
}
