package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdReport extends Message<AdReport, a> {
    public static final ProtoAdapter<AdReport> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "apiUrls", label = WireField.Label.REPEATED, tag = 4)
    public final List<String> api_urls;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "headerInfo", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String header_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "reportBegin", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int report_begin;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "reportEnd", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int report_end;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reportUrls", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> report_urls;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "sdkUrls", label = WireField.Label.REPEATED, tag = 5)
    public final List<String> sdk_urls;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdReport, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f383690a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f383691b = 0;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f383692c = Internal.newMutableList();

        /* renamed from: d, reason: collision with root package name */
        public List<String> f383693d = Internal.newMutableList();

        /* renamed from: e, reason: collision with root package name */
        public List<String> f383694e = Internal.newMutableList();

        /* renamed from: f, reason: collision with root package name */
        public String f383695f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdReport build() {
            return new AdReport(this.f383690a, this.f383691b, this.f383692c, this.f383693d, this.f383694e, this.f383695f, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383695f = str;
            return this;
        }

        public a c(int i3) {
            this.f383690a = i3;
            return this;
        }

        public a d(int i3) {
            this.f383691b = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdReport> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdReport.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdReport", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdReport decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.f383692c.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.f383693d.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.f383694e.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdReport adReport) throws IOException {
            if (!Objects.equals(Integer.valueOf(adReport.report_begin), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(adReport.report_begin));
            }
            if (!Objects.equals(Integer.valueOf(adReport.report_end), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adReport.report_end));
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 3, adReport.report_urls);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 4, adReport.api_urls);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 5, adReport.sdk_urls);
            if (!Objects.equals(adReport.header_info, "")) {
                protoAdapter.encodeWithTag(protoWriter, 6, adReport.header_info);
            }
            protoWriter.writeBytes(adReport.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdReport adReport) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(adReport.report_begin), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(adReport.report_begin));
            }
            if (!Objects.equals(Integer.valueOf(adReport.report_end), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adReport.report_end));
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = i3 + protoAdapter.asRepeated().encodedSizeWithTag(3, adReport.report_urls) + protoAdapter.asRepeated().encodedSizeWithTag(4, adReport.api_urls) + protoAdapter.asRepeated().encodedSizeWithTag(5, adReport.sdk_urls);
            if (!Objects.equals(adReport.header_info, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(6, adReport.header_info);
            }
            return encodedSizeWithTag + adReport.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdReport redact(AdReport adReport) {
            a newBuilder = adReport.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdReport(int i3, int i16, List<String> list, List<String> list2, List<String> list3, String str) {
        this(i3, i16, list, list2, list3, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdReport)) {
            return false;
        }
        AdReport adReport = (AdReport) obj;
        if (unknownFields().equals(adReport.unknownFields()) && Internal.equals(Integer.valueOf(this.report_begin), Integer.valueOf(adReport.report_begin)) && Internal.equals(Integer.valueOf(this.report_end), Integer.valueOf(adReport.report_end)) && this.report_urls.equals(adReport.report_urls) && this.api_urls.equals(adReport.api_urls) && this.sdk_urls.equals(adReport.sdk_urls) && Internal.equals(this.header_info, adReport.header_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((((((unknownFields().hashCode() * 37) + this.report_begin) * 37) + this.report_end) * 37) + this.report_urls.hashCode()) * 37) + this.api_urls.hashCode()) * 37) + this.sdk_urls.hashCode()) * 37;
            String str = this.header_info;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", report_begin=");
        sb5.append(this.report_begin);
        sb5.append(", report_end=");
        sb5.append(this.report_end);
        if (!this.report_urls.isEmpty()) {
            sb5.append(", report_urls=");
            sb5.append(Internal.sanitize(this.report_urls));
        }
        if (!this.api_urls.isEmpty()) {
            sb5.append(", api_urls=");
            sb5.append(Internal.sanitize(this.api_urls));
        }
        if (!this.sdk_urls.isEmpty()) {
            sb5.append(", sdk_urls=");
            sb5.append(Internal.sanitize(this.sdk_urls));
        }
        if (this.header_info != null) {
            sb5.append(", header_info=");
            sb5.append(Internal.sanitize(this.header_info));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdReport{");
        replace.append('}');
        return replace.toString();
    }

    public AdReport(int i3, int i16, List<String> list, List<String> list2, List<String> list3, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.report_begin = i3;
        this.report_end = i16;
        this.report_urls = Internal.immutableCopyOf("report_urls", list);
        this.api_urls = Internal.immutableCopyOf("api_urls", list2);
        this.sdk_urls = Internal.immutableCopyOf("sdk_urls", list3);
        if (str != null) {
            this.header_info = str;
            return;
        }
        throw new IllegalArgumentException("header_info == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383690a = this.report_begin;
        aVar.f383691b = this.report_end;
        aVar.f383692c = Internal.copyOf(this.report_urls);
        aVar.f383693d = Internal.copyOf(this.api_urls);
        aVar.f383694e = Internal.copyOf(this.sdk_urls);
        aVar.f383695f = this.header_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
