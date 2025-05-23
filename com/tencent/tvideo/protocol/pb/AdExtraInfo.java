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
public final class AdExtraInfo extends Message<AdExtraInfo, a> {
    public static final ProtoAdapter<AdExtraInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adExtraDict", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> ad_extra_dict;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdExtraInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, String> f383561a = Internal.newMutableMap();

        public a a(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f383561a = map;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdExtraInfo build() {
            return new AdExtraInfo(this.f383561a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdExtraInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383562a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdExtraInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdExtraInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> a() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383562a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383562a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdExtraInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f383561a.putAll(a().decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdExtraInfo adExtraInfo) throws IOException {
            a().encodeWithTag(protoWriter, 1, adExtraInfo.ad_extra_dict);
            protoWriter.writeBytes(adExtraInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdExtraInfo adExtraInfo) {
            return a().encodedSizeWithTag(1, adExtraInfo.ad_extra_dict) + 0 + adExtraInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AdExtraInfo redact(AdExtraInfo adExtraInfo) {
            a newBuilder = adExtraInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdExtraInfo(Map<String, String> map) {
        this(map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdExtraInfo)) {
            return false;
        }
        AdExtraInfo adExtraInfo = (AdExtraInfo) obj;
        if (unknownFields().equals(adExtraInfo.unknownFields()) && this.ad_extra_dict.equals(adExtraInfo.ad_extra_dict)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.ad_extra_dict.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.ad_extra_dict.isEmpty()) {
            sb5.append(", ad_extra_dict=");
            sb5.append(this.ad_extra_dict);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdExtraInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdExtraInfo(Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_extra_dict = Internal.immutableCopyOf("ad_extra_dict", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383561a = Internal.copyOf(this.ad_extra_dict);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
