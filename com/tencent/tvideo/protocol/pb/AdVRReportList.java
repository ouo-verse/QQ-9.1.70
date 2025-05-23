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
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdVRReportList extends Message<AdVRReportList, a> {
    public static final ProtoAdapter<AdVRReportList> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reportDict", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> report_dict;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdVRReportList, a> {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, String> f383721a = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdVRReportList build() {
            return new AdVRReportList(this.f383721a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdVRReportList> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383722a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdVRReportList.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdVRReportList", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383722a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383722a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdVRReportList decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f383721a.putAll(e().decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdVRReportList adVRReportList) throws IOException {
            e().encodeWithTag(protoWriter, 1, adVRReportList.report_dict);
            protoWriter.writeBytes(adVRReportList.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdVRReportList adVRReportList) {
            return e().encodedSizeWithTag(1, adVRReportList.report_dict) + 0 + adVRReportList.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdVRReportList redact(AdVRReportList adVRReportList) {
            a newBuilder = adVRReportList.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdVRReportList(Map<String, String> map) {
        this(map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdVRReportList)) {
            return false;
        }
        AdVRReportList adVRReportList = (AdVRReportList) obj;
        if (unknownFields().equals(adVRReportList.unknownFields()) && this.report_dict.equals(adVRReportList.report_dict)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.report_dict.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.report_dict.isEmpty()) {
            sb5.append(", report_dict=");
            sb5.append(this.report_dict);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdVRReportList{");
        replace.append('}');
        return replace.toString();
    }

    public AdVRReportList(Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.report_dict = Internal.immutableCopyOf("report_dict", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383721a = Internal.copyOf(this.report_dict);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
