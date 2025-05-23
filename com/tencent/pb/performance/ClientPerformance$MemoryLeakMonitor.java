package com.tencent.pb.performance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ClientPerformance$MemoryLeakMonitor extends MessageMicro<ClientPerformance$MemoryLeakMonitor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"type", "leak_object_id", "hprof_url", "leak_reference_chain", "info"}, new Object[]{"", "", "", "", null}, ClientPerformance$MemoryLeakMonitor.class);
    public final PBStringField type = PBField.initString("");
    public final PBStringField leak_object_id = PBField.initString("");
    public final PBStringField hprof_url = PBField.initString("");
    public final PBStringField leak_reference_chain = PBField.initString("");
    public ClientPerformance$MonitorInfo info = new ClientPerformance$MonitorInfo();
}
