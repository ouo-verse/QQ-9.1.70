package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ControlData extends Message<ControlData, a> {
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.AttaInfraConfig#ADAPTER", tag = 4)
    public final AttaInfraConfig atta_infra_config;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.BeaconInfraConfig#ADAPTER", tag = 6)
    public final BeaconInfraConfig beacon_infra_config;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.DatongInfraConfig#ADAPTER", tag = 5)
    public final DatongInfraConfig datong_infra_config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean enable_report;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer refresh_duration;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.ReportInfra#ADAPTER", tag = 3)
    public final ReportInfra report_infra;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer report_time_interval;
    public static final ProtoAdapter<ControlData> ADAPTER = new b();
    public static final Integer DEFAULT_REFRESH_DURATION = 0;
    public static final Boolean DEFAULT_ENABLE_REPORT = Boolean.FALSE;
    public static final ReportInfra DEFAULT_REPORT_INFRA = ReportInfra.REPORT_INFRA_UNSPECIFIED;
    public static final Integer DEFAULT_REPORT_TIME_INTERVAL = 0;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<ControlData, a> {

        /* renamed from: a, reason: collision with root package name */
        public Integer f374188a;

        /* renamed from: b, reason: collision with root package name */
        public Boolean f374189b;

        /* renamed from: c, reason: collision with root package name */
        public ReportInfra f374190c;

        /* renamed from: d, reason: collision with root package name */
        public AttaInfraConfig f374191d;

        /* renamed from: e, reason: collision with root package name */
        public DatongInfraConfig f374192e;

        /* renamed from: f, reason: collision with root package name */
        public BeaconInfraConfig f374193f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f374194g;

        public a a(AttaInfraConfig attaInfraConfig) {
            this.f374191d = attaInfraConfig;
            return this;
        }

        public a b(BeaconInfraConfig beaconInfraConfig) {
            this.f374193f = beaconInfraConfig;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ControlData build() {
            return new ControlData(this.f374188a, this.f374189b, this.f374190c, this.f374191d, this.f374192e, this.f374193f, this.f374194g, super.buildUnknownFields());
        }

        public a d(DatongInfraConfig datongInfraConfig) {
            this.f374192e = datongInfraConfig;
            return this;
        }

        public a e(Boolean bool) {
            this.f374189b = bool;
            return this;
        }

        public a f(Integer num) {
            this.f374188a = num;
            return this;
        }

        public a g(ReportInfra reportInfra) {
            this.f374190c = reportInfra;
            return this;
        }

        public a h(Integer num) {
            this.f374194g = num;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<ControlData> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ControlData.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlData decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.f(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 2:
                            aVar.e(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 3:
                            try {
                                aVar.g(ReportInfra.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 4:
                            aVar.a(AttaInfraConfig.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.d(DatongInfraConfig.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.b(BeaconInfraConfig.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            aVar.h(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        default:
                            FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                            aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, ControlData controlData) throws IOException {
            Integer num = controlData.refresh_duration;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            Boolean bool = controlData.enable_report;
            if (bool != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, bool);
            }
            ReportInfra reportInfra = controlData.report_infra;
            if (reportInfra != null) {
                ReportInfra.ADAPTER.encodeWithTag(protoWriter, 3, reportInfra);
            }
            AttaInfraConfig attaInfraConfig = controlData.atta_infra_config;
            if (attaInfraConfig != null) {
                AttaInfraConfig.ADAPTER.encodeWithTag(protoWriter, 4, attaInfraConfig);
            }
            DatongInfraConfig datongInfraConfig = controlData.datong_infra_config;
            if (datongInfraConfig != null) {
                DatongInfraConfig.ADAPTER.encodeWithTag(protoWriter, 5, datongInfraConfig);
            }
            BeaconInfraConfig beaconInfraConfig = controlData.beacon_infra_config;
            if (beaconInfraConfig != null) {
                BeaconInfraConfig.ADAPTER.encodeWithTag(protoWriter, 6, beaconInfraConfig);
            }
            Integer num2 = controlData.report_time_interval;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, num2);
            }
            protoWriter.writeBytes(controlData.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ControlData controlData) {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26;
            Integer num = controlData.refresh_duration;
            int i27 = 0;
            if (num != null) {
                i3 = ProtoAdapter.INT32.encodedSizeWithTag(1, num);
            } else {
                i3 = 0;
            }
            Boolean bool = controlData.enable_report;
            if (bool != null) {
                i16 = ProtoAdapter.BOOL.encodedSizeWithTag(2, bool);
            } else {
                i16 = 0;
            }
            int i28 = i3 + i16;
            ReportInfra reportInfra = controlData.report_infra;
            if (reportInfra != null) {
                i17 = ReportInfra.ADAPTER.encodedSizeWithTag(3, reportInfra);
            } else {
                i17 = 0;
            }
            int i29 = i28 + i17;
            AttaInfraConfig attaInfraConfig = controlData.atta_infra_config;
            if (attaInfraConfig != null) {
                i18 = AttaInfraConfig.ADAPTER.encodedSizeWithTag(4, attaInfraConfig);
            } else {
                i18 = 0;
            }
            int i36 = i29 + i18;
            DatongInfraConfig datongInfraConfig = controlData.datong_infra_config;
            if (datongInfraConfig != null) {
                i19 = DatongInfraConfig.ADAPTER.encodedSizeWithTag(5, datongInfraConfig);
            } else {
                i19 = 0;
            }
            int i37 = i36 + i19;
            BeaconInfraConfig beaconInfraConfig = controlData.beacon_infra_config;
            if (beaconInfraConfig != null) {
                i26 = BeaconInfraConfig.ADAPTER.encodedSizeWithTag(6, beaconInfraConfig);
            } else {
                i26 = 0;
            }
            int i38 = i37 + i26;
            Integer num2 = controlData.report_time_interval;
            if (num2 != null) {
                i27 = ProtoAdapter.INT32.encodedSizeWithTag(7, num2);
            }
            return i38 + i27 + controlData.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ControlData redact(ControlData controlData) {
            a newBuilder = controlData.newBuilder();
            AttaInfraConfig attaInfraConfig = newBuilder.f374191d;
            if (attaInfraConfig != null) {
                newBuilder.f374191d = AttaInfraConfig.ADAPTER.redact(attaInfraConfig);
            }
            DatongInfraConfig datongInfraConfig = newBuilder.f374192e;
            if (datongInfraConfig != null) {
                newBuilder.f374192e = DatongInfraConfig.ADAPTER.redact(datongInfraConfig);
            }
            BeaconInfraConfig beaconInfraConfig = newBuilder.f374193f;
            if (beaconInfraConfig != null) {
                newBuilder.f374193f = BeaconInfraConfig.ADAPTER.redact(beaconInfraConfig);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ControlData(Integer num, Boolean bool, ReportInfra reportInfra, AttaInfraConfig attaInfraConfig, DatongInfraConfig datongInfraConfig, BeaconInfraConfig beaconInfraConfig, Integer num2) {
        this(num, bool, reportInfra, attaInfraConfig, datongInfraConfig, beaconInfraConfig, num2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ControlData)) {
            return false;
        }
        ControlData controlData = (ControlData) obj;
        if (unknownFields().equals(controlData.unknownFields()) && Internal.equals(this.refresh_duration, controlData.refresh_duration) && Internal.equals(this.enable_report, controlData.enable_report) && Internal.equals(this.report_infra, controlData.report_infra) && Internal.equals(this.atta_infra_config, controlData.atta_infra_config) && Internal.equals(this.datong_infra_config, controlData.datong_infra_config) && Internal.equals(this.beacon_infra_config, controlData.beacon_infra_config) && Internal.equals(this.report_time_interval, controlData.report_time_interval)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27 = this.hashCode;
        if (i27 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Integer num = this.refresh_duration;
            int i28 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            Boolean bool = this.enable_report;
            if (bool != null) {
                i16 = bool.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            ReportInfra reportInfra = this.report_infra;
            if (reportInfra != null) {
                i17 = reportInfra.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 37;
            AttaInfraConfig attaInfraConfig = this.atta_infra_config;
            if (attaInfraConfig != null) {
                i18 = attaInfraConfig.hashCode();
            } else {
                i18 = 0;
            }
            int i38 = (i37 + i18) * 37;
            DatongInfraConfig datongInfraConfig = this.datong_infra_config;
            if (datongInfraConfig != null) {
                i19 = datongInfraConfig.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (i38 + i19) * 37;
            BeaconInfraConfig beaconInfraConfig = this.beacon_infra_config;
            if (beaconInfraConfig != null) {
                i26 = beaconInfraConfig.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 37;
            Integer num2 = this.report_time_interval;
            if (num2 != null) {
                i28 = num2.hashCode();
            }
            int i47 = i46 + i28;
            this.hashCode = i47;
            return i47;
        }
        return i27;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.refresh_duration != null) {
            sb5.append(", refresh_duration=");
            sb5.append(this.refresh_duration);
        }
        if (this.enable_report != null) {
            sb5.append(", enable_report=");
            sb5.append(this.enable_report);
        }
        if (this.report_infra != null) {
            sb5.append(", report_infra=");
            sb5.append(this.report_infra);
        }
        if (this.atta_infra_config != null) {
            sb5.append(", atta_infra_config=");
            sb5.append(this.atta_infra_config);
        }
        if (this.datong_infra_config != null) {
            sb5.append(", datong_infra_config=");
            sb5.append(this.datong_infra_config);
        }
        if (this.beacon_infra_config != null) {
            sb5.append(", beacon_infra_config=");
            sb5.append(this.beacon_infra_config);
        }
        if (this.report_time_interval != null) {
            sb5.append(", report_time_interval=");
            sb5.append(this.report_time_interval);
        }
        StringBuilder replace = sb5.replace(0, 2, "ControlData{");
        replace.append('}');
        return replace.toString();
    }

    public ControlData(Integer num, Boolean bool, ReportInfra reportInfra, AttaInfraConfig attaInfraConfig, DatongInfraConfig datongInfraConfig, BeaconInfraConfig beaconInfraConfig, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.refresh_duration = num;
        this.enable_report = bool;
        this.report_infra = reportInfra;
        this.atta_infra_config = attaInfraConfig;
        this.datong_infra_config = datongInfraConfig;
        this.beacon_infra_config = beaconInfraConfig;
        this.report_time_interval = num2;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374188a = this.refresh_duration;
        aVar.f374189b = this.enable_report;
        aVar.f374190c = this.report_infra;
        aVar.f374191d = this.atta_infra_config;
        aVar.f374192e = this.datong_infra_config;
        aVar.f374193f = this.beacon_infra_config;
        aVar.f374194g = this.report_time_interval;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
