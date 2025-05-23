package com.tencent.mobileqq.tvideo.danmaku.protocol;

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
/* loaded from: classes19.dex */
public final class VideoDmSwitchRequest extends Message<VideoDmSwitchRequest, a> {
    public static final ProtoAdapter<VideoDmSwitchRequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String cid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String vid;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class a extends Message.Builder<VideoDmSwitchRequest, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f304417a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f304418b = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchRequest build() {
            return new VideoDmSwitchRequest(this.f304417a, this.f304418b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f304418b = str;
            return this;
        }

        public a c(String str) {
            this.f304417a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static final class b extends ProtoAdapter<VideoDmSwitchRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoDmSwitchRequest.class, "type.googleapis.com/tvideo.VideoDmSwitchRequest", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchRequest decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VideoDmSwitchRequest videoDmSwitchRequest) throws IOException {
            if (!Objects.equals(videoDmSwitchRequest.vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, videoDmSwitchRequest.vid);
            }
            if (!Objects.equals(videoDmSwitchRequest.cid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, videoDmSwitchRequest.cid);
            }
            protoWriter.writeBytes(videoDmSwitchRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoDmSwitchRequest videoDmSwitchRequest) {
            int i3 = 0;
            if (!Objects.equals(videoDmSwitchRequest.vid, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, videoDmSwitchRequest.vid);
            }
            if (!Objects.equals(videoDmSwitchRequest.cid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, videoDmSwitchRequest.cid);
            }
            return i3 + videoDmSwitchRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchRequest redact(VideoDmSwitchRequest videoDmSwitchRequest) {
            a newBuilder = videoDmSwitchRequest.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoDmSwitchRequest(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoDmSwitchRequest)) {
            return false;
        }
        VideoDmSwitchRequest videoDmSwitchRequest = (VideoDmSwitchRequest) obj;
        if (unknownFields().equals(videoDmSwitchRequest.unknownFields()) && Internal.equals(this.vid, videoDmSwitchRequest.vid) && Internal.equals(this.cid, videoDmSwitchRequest.cid)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.vid;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.cid;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.vid != null) {
            sb5.append(", vid=");
            sb5.append(Internal.sanitize(this.vid));
        }
        if (this.cid != null) {
            sb5.append(", cid=");
            sb5.append(Internal.sanitize(this.cid));
        }
        StringBuilder replace = sb5.replace(0, 2, "VideoDmSwitchRequest{");
        replace.append('}');
        return replace.toString();
    }

    public VideoDmSwitchRequest(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.vid = str;
            if (str2 != null) {
                this.cid = str2;
                return;
            }
            throw new IllegalArgumentException("cid == null");
        }
        throw new IllegalArgumentException("vid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f304417a = this.vid;
        aVar.f304418b = this.cid;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
