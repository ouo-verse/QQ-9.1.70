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
public final class AdResponseInfo extends Message<AdResponseInfo, a> {
    public static final ProtoAdapter<AdResponseInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFreshInfo#ADAPTER", jsonName = "adFreshInfo", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdFreshInfo ad_fresh_info;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdResponseInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdFreshInfo f383714a;

        public a a(AdFreshInfo adFreshInfo) {
            this.f383714a = adFreshInfo;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdResponseInfo build() {
            return new AdResponseInfo(this.f383714a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdResponseInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdResponseInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdResponseInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdResponseInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.a(AdFreshInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdResponseInfo adResponseInfo) throws IOException {
            if (!Objects.equals(adResponseInfo.ad_fresh_info, null)) {
                AdFreshInfo.ADAPTER.encodeWithTag(protoWriter, 1, adResponseInfo.ad_fresh_info);
            }
            protoWriter.writeBytes(adResponseInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdResponseInfo adResponseInfo) {
            int i3 = 0;
            if (!Objects.equals(adResponseInfo.ad_fresh_info, null)) {
                i3 = 0 + AdFreshInfo.ADAPTER.encodedSizeWithTag(1, adResponseInfo.ad_fresh_info);
            }
            return i3 + adResponseInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdResponseInfo redact(AdResponseInfo adResponseInfo) {
            a newBuilder = adResponseInfo.newBuilder();
            AdFreshInfo adFreshInfo = newBuilder.f383714a;
            if (adFreshInfo != null) {
                newBuilder.f383714a = AdFreshInfo.ADAPTER.redact(adFreshInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdResponseInfo(AdFreshInfo adFreshInfo) {
        this(adFreshInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdResponseInfo)) {
            return false;
        }
        AdResponseInfo adResponseInfo = (AdResponseInfo) obj;
        if (unknownFields().equals(adResponseInfo.unknownFields()) && Internal.equals(this.ad_fresh_info, adResponseInfo.ad_fresh_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdFreshInfo adFreshInfo = this.ad_fresh_info;
            if (adFreshInfo != null) {
                i3 = adFreshInfo.hashCode();
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
        if (this.ad_fresh_info != null) {
            sb5.append(", ad_fresh_info=");
            sb5.append(this.ad_fresh_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdResponseInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdResponseInfo(AdFreshInfo adFreshInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_fresh_info = adFreshInfo;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383714a = this.ad_fresh_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
