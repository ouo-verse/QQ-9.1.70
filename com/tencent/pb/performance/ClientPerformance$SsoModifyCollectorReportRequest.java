package com.tencent.pb.performance;

import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes22.dex */
public final class ClientPerformance$SsoModifyCollectorReportRequest extends MessageMicro<ClientPerformance$SsoModifyCollectorReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56}, new String[]{"app", "branch", "tapd_id", QCircleAlphaUserReporter.KEY_USER, "data", TVKDataBinder.KEY_REPORT_TYPE, "report_id"}, new Object[]{0, "", "", "", null, 1, 0}, ClientPerformance$SsoModifyCollectorReportRequest.class);
    public final PBEnumField app = PBField.initEnum(0);
    public final PBStringField branch = PBField.initString("");
    public final PBStringField tapd_id = PBField.initString("");
    public final PBStringField user = PBField.initString("");
    public ClientPerformance$PerformanceReport data = new MessageMicro<ClientPerformance$PerformanceReport>() { // from class: com.tencent.pb.performance.ClientPerformance$PerformanceReport
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"id", "tapd", "device", "memory", "cpu", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "delay"}, new Object[]{"", null, null, null, null, null, null}, ClientPerformance$PerformanceReport.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f342160id = PBField.initString("");
        public ClientPerformance$TapdInfo tapd = new MessageMicro<ClientPerformance$TapdInfo>() { // from class: com.tencent.pb.performance.ClientPerformance$TapdInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"flag", "project", "id", "developer", "tester", "milestone", "risk", "url"}, new Object[]{0, "", "", "", "", "", "", ""}, ClientPerformance$TapdInfo.class);
            public final PBRepeatField<String> developer;
            public final PBStringField milestone;
            public final PBStringField risk;
            public final PBRepeatField<String> tester;
            public final PBStringField url;
            public final PBEnumField flag = PBField.initEnum(0);
            public final PBStringField project = PBField.initString("");

            /* renamed from: id, reason: collision with root package name */
            public final PBStringField f342167id = PBField.initString("");

            {
                PBStringField pBStringField = PBStringField.__repeatHelper__;
                this.developer = PBField.initRepeat(pBStringField);
                this.tester = PBField.initRepeat(pBStringField);
                this.milestone = PBField.initString("");
                this.risk = PBField.initString("");
                this.url = PBField.initString("");
            }
        };
        public ClientPerformance$DeviceInfo device = new MessageMicro<ClientPerformance$DeviceInfo>() { // from class: com.tencent.pb.performance.ClientPerformance$DeviceInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"flag", "phone", "network", "version", "comment"}, new Object[]{0, "", "", "", ""}, ClientPerformance$DeviceInfo.class);
            public final PBEnumField flag = PBField.initEnum(0);
            public final PBStringField phone = PBField.initString("");
            public final PBStringField network = PBField.initString("");
            public final PBStringField version = PBField.initString("");
            public final PBStringField comment = PBField.initString("");
        };
        public ClientPerformance$MemoryIndicator memory = new MessageMicro<ClientPerformance$MemoryIndicator>() { // from class: com.tencent.pb.performance.ClientPerformance$MemoryIndicator
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"modify_memory_diff", "memory_diff", "modify_memory_leak", "memory_leak"}, new Object[]{null, null, null, null}, ClientPerformance$MemoryIndicator.class);
            public ClientPerformance$IndicatorBasicInfo modify_memory_diff = new ClientPerformance$IndicatorBasicInfo();
            public ClientPerformance$MemoryDiff memory_diff = new MessageMicro<ClientPerformance$MemoryDiff>() { // from class: com.tencent.pb.performance.ClientPerformance$MemoryDiff
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56}, new String[]{"process_mode", "test_case", "feature", "master", "audit_result", "audit_extra", MiniAppPlugin.ATTR_PAGE_TYPE}, new Object[]{"", "", null, null, 0, null, 1}, ClientPerformance$MemoryDiff.class);
                public final PBStringField process_mode = PBField.initString("");
                public final PBStringField test_case = PBField.initString("");
                public BranchMemoryDiff feature = new BranchMemoryDiff();
                public BranchMemoryDiff master = new BranchMemoryDiff();
                public final PBEnumField audit_result = PBField.initEnum(0);
                public ClientPerformance$AuditExtra audit_extra = new ClientPerformance$AuditExtra();
                public final PBEnumField page_type = PBField.initEnum(1);

                /* loaded from: classes22.dex */
                public static final class BranchMemoryDiff extends MessageMicro<BranchMemoryDiff> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"before", "process", "exit", "process_diff", "exit_diff"}, new Object[]{null, null, null, null, null}, BranchMemoryDiff.class);
                    public MemoryDiffIndicator before = new MemoryDiffIndicator();
                    public MemoryDiffIndicator process = new MemoryDiffIndicator();
                    public MemoryDiffIndicator exit = new MemoryDiffIndicator();
                    public MemoryDiffIndicator process_diff = new MemoryDiffIndicator();
                    public MemoryDiffIndicator exit_diff = new MemoryDiffIndicator();
                }

                /* loaded from: classes22.dex */
                public static final class MemoryDiffIndicator extends MessageMicro<MemoryDiffIndicator> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"pss0", "javaheap0"}, new Object[]{0, 0}, MemoryDiffIndicator.class);
                    public final PBInt32Field pss0 = PBField.initInt32(0);
                    public final PBInt32Field javaheap0 = PBField.initInt32(0);
                }
            };
            public ClientPerformance$IndicatorBasicInfo modify_memory_leak = new ClientPerformance$IndicatorBasicInfo();
            public ClientPerformance$MemoryLeak memory_leak = new MessageMicro<ClientPerformance$MemoryLeak>() { // from class: com.tencent.pb.performance.ClientPerformance$MemoryLeak
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"leak_memory", "url", "audit_result", "audit_extra"}, new Object[]{0, "", 0, null}, ClientPerformance$MemoryLeak.class);
                public final PBInt32Field leak_memory = PBField.initInt32(0);
                public final PBStringField url = PBField.initString("");
                public final PBEnumField audit_result = PBField.initEnum(0);
                public ClientPerformance$AuditExtra audit_extra = new ClientPerformance$AuditExtra();
            };
        };
        public ClientPerformance$CPUIndicator cpu = new MessageMicro<ClientPerformance$CPUIndicator>() { // from class: com.tencent.pb.performance.ClientPerformance$CPUIndicator
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 72, 82}, new String[]{"modify_cpu", "count_times", "feature_frontend", "feature_backend", "master_backend", "feature_frontend_avg", "feature_backend_avg", "master_backend_avg", "audit_result", "audit_extra"}, new Object[]{null, 0, 0, 0, 0, 0, 0, 0, 0, null}, ClientPerformance$CPUIndicator.class);
            public ClientPerformance$AuditExtra audit_extra;
            public final PBEnumField audit_result;
            public final PBRepeatField<Integer> feature_backend;
            public final PBInt32Field feature_backend_avg;
            public final PBRepeatField<Integer> feature_frontend;
            public final PBInt32Field feature_frontend_avg;
            public final PBRepeatField<Integer> master_backend;
            public final PBInt32Field master_backend_avg;
            public ClientPerformance$IndicatorBasicInfo modify_cpu = new ClientPerformance$IndicatorBasicInfo();
            public final PBInt32Field count_times = PBField.initInt32(0);

            {
                PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
                this.feature_frontend = PBField.initRepeat(pBInt32Field);
                this.feature_backend = PBField.initRepeat(pBInt32Field);
                this.master_backend = PBField.initRepeat(pBInt32Field);
                this.feature_frontend_avg = PBField.initInt32(0);
                this.feature_backend_avg = PBField.initInt32(0);
                this.master_backend_avg = PBField.initInt32(0);
                this.audit_result = PBField.initEnum(0);
                this.audit_extra = new ClientPerformance$AuditExtra();
            }
        };
        public ClientPerformance$RenderIndicator render = new MessageMicro<ClientPerformance$RenderIndicator>() { // from class: com.tencent.pb.performance.ClientPerformance$RenderIndicator
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"modify_fps", "fps", "modify_ui_redraw", "redraw"}, new Object[]{null, null, null, null}, ClientPerformance$RenderIndicator.class);
            public ClientPerformance$IndicatorBasicInfo modify_fps = new ClientPerformance$IndicatorBasicInfo();
            public ClientPerformance$FPS fps = new MessageMicro<ClientPerformance$FPS>() { // from class: com.tencent.pb.performance.ClientPerformance$FPS
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{"count_times", "feature_fps", "master_fps", "feature_avg", "master_avg", "audit_result", "audit_extra"}, new Object[]{0, 0, 0, 0, 0, 0, null}, ClientPerformance$FPS.class);
                public ClientPerformance$AuditExtra audit_extra;
                public final PBEnumField audit_result;
                public final PBRepeatField<Integer> count_times;
                public final PBInt32Field feature_avg;
                public final PBRepeatField<Integer> feature_fps;
                public final PBInt32Field master_avg;
                public final PBRepeatField<Integer> master_fps;

                {
                    PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
                    this.count_times = PBField.initRepeat(pBInt32Field);
                    this.feature_fps = PBField.initRepeat(pBInt32Field);
                    this.master_fps = PBField.initRepeat(pBInt32Field);
                    this.feature_avg = PBField.initInt32(0);
                    this.master_avg = PBField.initInt32(0);
                    this.audit_result = PBField.initEnum(0);
                    this.audit_extra = new ClientPerformance$AuditExtra();
                }
            };
            public ClientPerformance$IndicatorBasicInfo modify_ui_redraw = new ClientPerformance$IndicatorBasicInfo();
            public ClientPerformance$UIRedraw redraw = new MessageMicro<ClientPerformance$UIRedraw>() { // from class: com.tencent.pb.performance.ClientPerformance$UIRedraw
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"red_ratio", "pink_ratio", "url", "audit_result", "audit_extra"}, new Object[]{0, 0, "", 0, null}, ClientPerformance$UIRedraw.class);
                public final PBInt32Field red_ratio = PBField.initInt32(0);
                public final PBInt32Field pink_ratio = PBField.initInt32(0);
                public final PBStringField url = PBField.initString("");
                public final PBEnumField audit_result = PBField.initEnum(0);
                public ClientPerformance$AuditExtra audit_extra = new ClientPerformance$AuditExtra();
            };
        };
        public ClientPerformance$Delay delay = new MessageMicro<ClientPerformance$Delay>() { // from class: com.tencent.pb.performance.ClientPerformance$Delay
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"master_delay", "branch_delay", "audit_result", "audit_extra"}, new Object[]{null, null, 0, null}, ClientPerformance$Delay.class);
            public ClientPerformance$DelayIndicator master_delay = new MessageMicro<ClientPerformance$DelayIndicator>() { // from class: com.tencent.pb.performance.ClientPerformance$DelayIndicator
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"modify_start_activity", "start_activity_delay", "modify_start_process", "start_process_delay"}, new Object[]{null, 0, null, 0}, ClientPerformance$DelayIndicator.class);
                public ClientPerformance$IndicatorBasicInfo modify_start_activity = new ClientPerformance$IndicatorBasicInfo();
                public final PBInt32Field start_activity_delay = PBField.initInt32(0);
                public ClientPerformance$IndicatorBasicInfo modify_start_process = new ClientPerformance$IndicatorBasicInfo();
                public final PBInt32Field start_process_delay = PBField.initInt32(0);
            };
            public ClientPerformance$DelayIndicator branch_delay = new MessageMicro<ClientPerformance$DelayIndicator>() { // from class: com.tencent.pb.performance.ClientPerformance$DelayIndicator
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"modify_start_activity", "start_activity_delay", "modify_start_process", "start_process_delay"}, new Object[]{null, 0, null, 0}, ClientPerformance$DelayIndicator.class);
                public ClientPerformance$IndicatorBasicInfo modify_start_activity = new ClientPerformance$IndicatorBasicInfo();
                public final PBInt32Field start_activity_delay = PBField.initInt32(0);
                public ClientPerformance$IndicatorBasicInfo modify_start_process = new ClientPerformance$IndicatorBasicInfo();
                public final PBInt32Field start_process_delay = PBField.initInt32(0);
            };
            public final PBEnumField audit_result = PBField.initEnum(0);
            public ClientPerformance$AuditExtra audit_extra = new ClientPerformance$AuditExtra();
        };
    };
    public final PBEnumField report_type = PBField.initEnum(1);
    public final PBInt32Field report_id = PBField.initInt32(0);
}
