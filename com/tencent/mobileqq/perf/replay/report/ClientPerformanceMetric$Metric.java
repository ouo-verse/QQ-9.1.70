package com.tencent.mobileqq.perf.replay.report;

import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;

/* loaded from: classes16.dex */
public final class ClientPerformanceMetric$Metric extends MessageMicro<ClientPerformanceMetric$Metric> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"statistic_type", j.T0, "perf_data_list"}, new Object[]{1, null, null}, ClientPerformanceMetric$Metric.class);
    public final PBEnumField statistic_type = PBField.initEnum(1);
    public AppInfo app_info = new AppInfo();
    public final PBRepeatMessageField<PerfData> perf_data_list = PBField.initRepeatMessage(PerfData.class);

    /* loaded from: classes16.dex */
    public static final class AppInfo extends MessageMicro<AppInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"parent_commit_id", "commit_id", "branch_name", "app_version_num", "build_num", "test_type"}, new Object[]{"", "", "", "", 0L, 1}, AppInfo.class);
        public final PBStringField parent_commit_id = PBField.initString("");
        public final PBStringField commit_id = PBField.initString("");
        public final PBStringField branch_name = PBField.initString("");
        public final PBStringField app_version_num = PBField.initString("");
        public final PBInt64Field build_num = PBField.initInt64(0);
        public final PBEnumField test_type = PBField.initEnum(1);
    }

    /* loaded from: classes16.dex */
    public static final class PerfData extends MessageMicro<PerfData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 34, 42}, new String[]{"type", "value", "detail_data_list", "url_list"}, new Object[]{1, Double.valueOf(0.0d), null, null}, PerfData.class);
        public final PBEnumField type = PBField.initEnum(1);
        public final PBDoubleField value = PBField.initDouble(0.0d);
        public final PBRepeatMessageField<DetailValue> detail_data_list = PBField.initRepeatMessage(DetailValue.class);
        public final PBRepeatMessageField<UrlItem> url_list = PBField.initRepeatMessage(UrlItem.class);

        /* loaded from: classes16.dex */
        public static final class DetailValue extends MessageMicro<DetailValue> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17}, new String[]{PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "value"}, new Object[]{"", Double.valueOf(0.0d)}, DetailValue.class);
            public final PBStringField timeStamp = PBField.initString("");
            public final PBDoubleField value = PBField.initDouble(0.0d);
        }

        /* loaded from: classes16.dex */
        public static final class UrlItem extends MessageMicro<UrlItem> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "url"}, new Object[]{"", ""}, UrlItem.class);
            public final PBStringField name = PBField.initString("");
            public final PBStringField url = PBField.initString("");
        }
    }
}
