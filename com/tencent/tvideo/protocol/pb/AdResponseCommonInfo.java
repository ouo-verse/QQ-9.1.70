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
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdResponseCommonInfo extends Message<AdResponseCommonInfo, a> {
    public static final ProtoAdapter<AdResponseCommonInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "ipServerUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String ip_server_url;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdResponseCommonInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383713a = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdResponseCommonInfo build() {
            return new AdResponseCommonInfo(this.f383713a, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383713a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdResponseCommonInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdResponseCommonInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdResponseCommonInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdResponseCommonInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdResponseCommonInfo adResponseCommonInfo) throws IOException {
            if (!Objects.equals(adResponseCommonInfo.ip_server_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adResponseCommonInfo.ip_server_url);
            }
            protoWriter.writeBytes(adResponseCommonInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdResponseCommonInfo adResponseCommonInfo) {
            int i3 = 0;
            if (!Objects.equals(adResponseCommonInfo.ip_server_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adResponseCommonInfo.ip_server_url);
            }
            return i3 + adResponseCommonInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdResponseCommonInfo redact(AdResponseCommonInfo adResponseCommonInfo) {
            a newBuilder = adResponseCommonInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdResponseCommonInfo(String str) {
        this(str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdResponseCommonInfo)) {
            return false;
        }
        AdResponseCommonInfo adResponseCommonInfo = (AdResponseCommonInfo) obj;
        if (unknownFields().equals(adResponseCommonInfo.unknownFields()) && Internal.equals(this.ip_server_url, adResponseCommonInfo.ip_server_url)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.ip_server_url;
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
        if (this.ip_server_url != null) {
            sb5.append(", ip_server_url=");
            sb5.append(Internal.sanitize(this.ip_server_url));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdResponseCommonInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdResponseCommonInfo(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.ip_server_url = str;
            return;
        }
        throw new IllegalArgumentException("ip_server_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383713a = this.ip_server_url;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
