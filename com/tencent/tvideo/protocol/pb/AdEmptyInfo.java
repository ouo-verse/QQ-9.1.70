package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdEmptyInfo extends Message<AdEmptyInfo, a> {
    public static final ProtoAdapter<AdEmptyInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String cookies;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdReport#ADAPTER", jsonName = "emptyReport", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdReport empty_report;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "insertIndex", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int insert_index;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "mtaReportDict", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> mta_report_dict;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reporterDict", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> reporter_dict;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String unique_id;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdEmptyInfo, a> {

        /* renamed from: b, reason: collision with root package name */
        public AdReport f383554b;

        /* renamed from: a, reason: collision with root package name */
        public int f383553a = 0;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, String> f383555c = Internal.newMutableMap();

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String> f383556d = Internal.newMutableMap();

        /* renamed from: e, reason: collision with root package name */
        public String f383557e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383558f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdEmptyInfo build() {
            return new AdEmptyInfo(this.f383553a, this.f383554b, this.f383555c, this.f383556d, this.f383557e, this.f383558f, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383557e = str;
            return this;
        }

        public a c(AdReport adReport) {
            this.f383554b = adReport;
            return this;
        }

        public a d(int i3) {
            this.f383553a = i3;
            return this;
        }

        public a e(String str) {
            this.f383558f = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdEmptyInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383559a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383560b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdEmptyInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdEmptyInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383560b;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383560b = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        private ProtoAdapter<Map<String, String>> f() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383559a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383559a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdEmptyInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.c(AdReport.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            aVar.f383555c.putAll(f().decode(protoReader));
                            break;
                        case 4:
                            aVar.f383556d.putAll(d().decode(protoReader));
                            break;
                        case 5:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdEmptyInfo adEmptyInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(adEmptyInfo.insert_index), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(adEmptyInfo.insert_index));
            }
            if (!Objects.equals(adEmptyInfo.empty_report, null)) {
                AdReport.ADAPTER.encodeWithTag(protoWriter, 2, adEmptyInfo.empty_report);
            }
            f().encodeWithTag(protoWriter, 3, adEmptyInfo.reporter_dict);
            d().encodeWithTag(protoWriter, 4, adEmptyInfo.mta_report_dict);
            if (!Objects.equals(adEmptyInfo.cookies, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, adEmptyInfo.cookies);
            }
            if (!Objects.equals(adEmptyInfo.unique_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adEmptyInfo.unique_id);
            }
            protoWriter.writeBytes(adEmptyInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdEmptyInfo adEmptyInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(adEmptyInfo.insert_index), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(adEmptyInfo.insert_index));
            }
            if (!Objects.equals(adEmptyInfo.empty_report, null)) {
                i3 += AdReport.ADAPTER.encodedSizeWithTag(2, adEmptyInfo.empty_report);
            }
            int encodedSizeWithTag = i3 + f().encodedSizeWithTag(3, adEmptyInfo.reporter_dict) + d().encodedSizeWithTag(4, adEmptyInfo.mta_report_dict);
            if (!Objects.equals(adEmptyInfo.cookies, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(5, adEmptyInfo.cookies);
            }
            if (!Objects.equals(adEmptyInfo.unique_id, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(6, adEmptyInfo.unique_id);
            }
            return encodedSizeWithTag + adEmptyInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AdEmptyInfo redact(AdEmptyInfo adEmptyInfo) {
            a newBuilder = adEmptyInfo.newBuilder();
            AdReport adReport = newBuilder.f383554b;
            if (adReport != null) {
                newBuilder.f383554b = AdReport.ADAPTER.redact(adReport);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdEmptyInfo(int i3, AdReport adReport, Map<String, String> map, Map<String, String> map2, String str, String str2) {
        this(i3, adReport, map, map2, str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdEmptyInfo)) {
            return false;
        }
        AdEmptyInfo adEmptyInfo = (AdEmptyInfo) obj;
        if (unknownFields().equals(adEmptyInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.insert_index), Integer.valueOf(adEmptyInfo.insert_index)) && Internal.equals(this.empty_report, adEmptyInfo.empty_report) && this.reporter_dict.equals(adEmptyInfo.reporter_dict) && this.mta_report_dict.equals(adEmptyInfo.mta_report_dict) && Internal.equals(this.cookies, adEmptyInfo.cookies) && Internal.equals(this.unique_id, adEmptyInfo.unique_id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.insert_index) * 37;
            AdReport adReport = this.empty_report;
            int i18 = 0;
            if (adReport != null) {
                i3 = adReport.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = (((((hashCode + i3) * 37) + this.reporter_dict.hashCode()) * 37) + this.mta_report_dict.hashCode()) * 37;
            String str = this.cookies;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (hashCode2 + i16) * 37;
            String str2 = this.unique_id;
            if (str2 != null) {
                i18 = str2.hashCode();
            }
            int i26 = i19 + i18;
            this.hashCode = i26;
            return i26;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", insert_index=");
        sb5.append(this.insert_index);
        if (this.empty_report != null) {
            sb5.append(", empty_report=");
            sb5.append(this.empty_report);
        }
        if (!this.reporter_dict.isEmpty()) {
            sb5.append(", reporter_dict=");
            sb5.append(this.reporter_dict);
        }
        if (!this.mta_report_dict.isEmpty()) {
            sb5.append(", mta_report_dict=");
            sb5.append(this.mta_report_dict);
        }
        if (this.cookies != null) {
            sb5.append(", cookies=");
            sb5.append(Internal.sanitize(this.cookies));
        }
        if (this.unique_id != null) {
            sb5.append(", unique_id=");
            sb5.append(Internal.sanitize(this.unique_id));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdEmptyInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdEmptyInfo(int i3, AdReport adReport, Map<String, String> map, Map<String, String> map2, String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.insert_index = i3;
        this.empty_report = adReport;
        this.reporter_dict = Internal.immutableCopyOf("reporter_dict", map);
        this.mta_report_dict = Internal.immutableCopyOf("mta_report_dict", map2);
        if (str != null) {
            this.cookies = str;
            if (str2 != null) {
                this.unique_id = str2;
                return;
            }
            throw new IllegalArgumentException("unique_id == null");
        }
        throw new IllegalArgumentException("cookies == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383553a = this.insert_index;
        aVar.f383554b = this.empty_report;
        aVar.f383555c = Internal.copyOf(this.reporter_dict);
        aVar.f383556d = Internal.copyOf(this.mta_report_dict);
        aVar.f383557e = this.cookies;
        aVar.f383558f = this.unique_id;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
