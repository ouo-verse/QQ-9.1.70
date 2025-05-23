package com.tencent.mobileqq.tvideo.danmaku.protocol;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tvideo.danmaku.model.VideoDmSwitchData;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class VideoDmSwitchResponse extends Message<VideoDmSwitchResponse, a> {
    public static final ProtoAdapter<VideoDmSwitchResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.VideoDmSwitchData#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final VideoDmSwitchData data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "errCode", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int err_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "errMsg", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String err_msg;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class a extends Message.Builder<VideoDmSwitchResponse, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f304419a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f304420b = "";

        /* renamed from: c, reason: collision with root package name */
        public VideoDmSwitchData f304421c;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchResponse build() {
            return new VideoDmSwitchResponse(this.f304419a, this.f304420b, this.f304421c, super.buildUnknownFields());
        }

        public a b(VideoDmSwitchData videoDmSwitchData) {
            this.f304421c = videoDmSwitchData;
            return this;
        }

        public a c(int i3) {
            this.f304419a = i3;
            return this;
        }

        public a d(String str) {
            this.f304420b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static final class b extends ProtoAdapter<VideoDmSwitchResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoDmSwitchResponse.class, "type.googleapis.com/tvideo.VideoDmSwitchResponse", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchResponse decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                protoReader.readUnknownField(nextTag);
                            } else {
                                aVar.b(VideoDmSwitchData.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VideoDmSwitchResponse videoDmSwitchResponse) throws IOException {
            if (!Objects.equals(Integer.valueOf(videoDmSwitchResponse.err_code), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(videoDmSwitchResponse.err_code));
            }
            if (!Objects.equals(videoDmSwitchResponse.err_msg, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, videoDmSwitchResponse.err_msg);
            }
            if (!Objects.equals(videoDmSwitchResponse.data, null)) {
                VideoDmSwitchData.ADAPTER.encodeWithTag(protoWriter, 3, videoDmSwitchResponse.data);
            }
            protoWriter.writeBytes(videoDmSwitchResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoDmSwitchResponse videoDmSwitchResponse) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(videoDmSwitchResponse.err_code), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(videoDmSwitchResponse.err_code));
            }
            if (!Objects.equals(videoDmSwitchResponse.err_msg, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, videoDmSwitchResponse.err_msg);
            }
            if (!Objects.equals(videoDmSwitchResponse.data, null)) {
                i3 += VideoDmSwitchData.ADAPTER.encodedSizeWithTag(3, videoDmSwitchResponse.data);
            }
            return i3 + videoDmSwitchResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VideoDmSwitchResponse redact(VideoDmSwitchResponse videoDmSwitchResponse) {
            a newBuilder = videoDmSwitchResponse.newBuilder();
            VideoDmSwitchData videoDmSwitchData = newBuilder.f304421c;
            if (videoDmSwitchData != null) {
                newBuilder.f304421c = VideoDmSwitchData.ADAPTER.redact(videoDmSwitchData);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoDmSwitchResponse(int i3, String str, VideoDmSwitchData videoDmSwitchData) {
        this(i3, str, videoDmSwitchData, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoDmSwitchResponse)) {
            return false;
        }
        VideoDmSwitchResponse videoDmSwitchResponse = (VideoDmSwitchResponse) obj;
        if (unknownFields().equals(videoDmSwitchResponse.unknownFields()) && Internal.equals(Integer.valueOf(this.err_code), Integer.valueOf(videoDmSwitchResponse.err_code)) && Internal.equals(this.err_msg, videoDmSwitchResponse.err_msg) && Internal.equals(this.data, videoDmSwitchResponse.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.err_code) * 37;
            String str = this.err_msg;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            VideoDmSwitchData videoDmSwitchData = this.data;
            if (videoDmSwitchData != null) {
                i17 = videoDmSwitchData.hashCode();
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
        sb5.append(", err_code=");
        sb5.append(this.err_code);
        if (this.err_msg != null) {
            sb5.append(", err_msg=");
            sb5.append(Internal.sanitize(this.err_msg));
        }
        if (this.data != null) {
            sb5.append(", data=");
            sb5.append(this.data);
        }
        StringBuilder replace = sb5.replace(0, 2, "VideoDmSwitchResponse{");
        replace.append('}');
        return replace.toString();
    }

    public VideoDmSwitchResponse(int i3, String str, VideoDmSwitchData videoDmSwitchData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.err_code = i3;
        if (str != null) {
            this.err_msg = str;
            this.data = videoDmSwitchData;
            return;
        }
        throw new IllegalArgumentException("err_msg == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f304419a = this.err_code;
        aVar.f304420b = this.err_msg;
        aVar.f304421c = this.data;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
