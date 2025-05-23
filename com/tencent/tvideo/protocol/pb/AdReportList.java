package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdReportList extends Message<AdReportList, a> {
    public static final ProtoAdapter<AdReportList> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdReport#ADAPTER", jsonName = "reportList", label = WireField.Label.REPEATED, tag = 1)
    public final List<AdReport> report_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reporterDict", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> reporter_dict;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdReportList, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<AdReport> f383696a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f383697b = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdReportList build() {
            return new AdReportList(this.f383696a, this.f383697b, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdReportList> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383698a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdReportList.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdReportList", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383698a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383698a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdReportList decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f383697b.putAll(e().decode(protoReader));
                        }
                    } else {
                        aVar.f383696a.add(AdReport.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdReportList adReportList) throws IOException {
            AdReport.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, adReportList.report_list);
            e().encodeWithTag(protoWriter, 2, adReportList.reporter_dict);
            protoWriter.writeBytes(adReportList.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdReportList adReportList) {
            return AdReport.ADAPTER.asRepeated().encodedSizeWithTag(1, adReportList.report_list) + 0 + e().encodedSizeWithTag(2, adReportList.reporter_dict) + adReportList.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdReportList redact(AdReportList adReportList) {
            a newBuilder = adReportList.newBuilder();
            Internal.redactElements(newBuilder.f383696a, AdReport.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdReportList(List<AdReport> list, Map<String, String> map) {
        this(list, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdReportList)) {
            return false;
        }
        AdReportList adReportList = (AdReportList) obj;
        if (unknownFields().equals(adReportList.unknownFields()) && this.report_list.equals(adReportList.report_list) && this.reporter_dict.equals(adReportList.reporter_dict)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.report_list.hashCode()) * 37) + this.reporter_dict.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.report_list.isEmpty()) {
            sb5.append(", report_list=");
            sb5.append(this.report_list);
        }
        if (!this.reporter_dict.isEmpty()) {
            sb5.append(", reporter_dict=");
            sb5.append(this.reporter_dict);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdReportList{");
        replace.append('}');
        return replace.toString();
    }

    public AdReportList(List<AdReport> list, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.report_list = Internal.immutableCopyOf(WadlReportBuilder.KEY_REPORT_LIST, list);
        this.reporter_dict = Internal.immutableCopyOf("reporter_dict", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383696a = Internal.copyOf(this.report_list);
        aVar.f383697b = Internal.copyOf(this.reporter_dict);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
