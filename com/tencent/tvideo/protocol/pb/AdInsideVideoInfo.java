package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.app.AppConstants;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdInsideVideoInfo extends Message<AdInsideVideoInfo, a> {
    public static final ProtoAdapter<AdInsideVideoInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdVideoEncodeProtocolType#ADAPTER", jsonName = "encodeProtocolType", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final AdVideoEncodeProtocolType encode_protocol_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "fileSize", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long file_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "playDuration", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final long play_duration;

    /* renamed from: vh, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final long f383625vh;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String vid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = AppConstants.Key.KEY_QZONE_VIDEO_URL, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String video_url;

    /* renamed from: vw, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final long f383626vw;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdInsideVideoInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383627a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383628b = "";

        /* renamed from: c, reason: collision with root package name */
        public long f383629c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f383630d = 0;

        /* renamed from: e, reason: collision with root package name */
        public long f383631e = 0;

        /* renamed from: f, reason: collision with root package name */
        public long f383632f = 0;

        /* renamed from: g, reason: collision with root package name */
        public AdVideoEncodeProtocolType f383633g = AdVideoEncodeProtocolType.AD_VIDEO_ENCODE_PROTOCOL_H264;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdInsideVideoInfo build() {
            return new AdInsideVideoInfo(this.f383627a, this.f383628b, this.f383629c, this.f383630d, this.f383631e, this.f383632f, this.f383633g, super.buildUnknownFields());
        }

        public a b(AdVideoEncodeProtocolType adVideoEncodeProtocolType) {
            this.f383633g = adVideoEncodeProtocolType;
            return this;
        }

        public a c(long j3) {
            this.f383629c = j3;
            return this;
        }

        public a d(long j3) {
            this.f383630d = j3;
            return this;
        }

        public a e(long j3) {
            this.f383631e = j3;
            return this;
        }

        public a f(String str) {
            this.f383627a = str;
            return this;
        }

        public a g(String str) {
            this.f383628b = str;
            return this;
        }

        public a h(long j3) {
            this.f383632f = j3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdInsideVideoInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdInsideVideoInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdInsideVideoInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdInsideVideoInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.c(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 4:
                            aVar.d(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 5:
                            aVar.e(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 6:
                            aVar.h(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 7:
                            try {
                                aVar.b(AdVideoEncodeProtocolType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
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
        public void encode(ProtoWriter protoWriter, AdInsideVideoInfo adInsideVideoInfo) throws IOException {
            if (!Objects.equals(adInsideVideoInfo.vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adInsideVideoInfo.vid);
            }
            if (!Objects.equals(adInsideVideoInfo.video_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adInsideVideoInfo.video_url);
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.file_size), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, Long.valueOf(adInsideVideoInfo.file_size));
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.play_duration), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, Long.valueOf(adInsideVideoInfo.play_duration));
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.f383625vh), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, Long.valueOf(adInsideVideoInfo.f383625vh));
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.f383626vw), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 6, Long.valueOf(adInsideVideoInfo.f383626vw));
            }
            if (!Objects.equals(adInsideVideoInfo.encode_protocol_type, AdVideoEncodeProtocolType.AD_VIDEO_ENCODE_PROTOCOL_H264)) {
                AdVideoEncodeProtocolType.ADAPTER.encodeWithTag(protoWriter, 7, adInsideVideoInfo.encode_protocol_type);
            }
            protoWriter.writeBytes(adInsideVideoInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdInsideVideoInfo adInsideVideoInfo) {
            int i3 = 0;
            if (!Objects.equals(adInsideVideoInfo.vid, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adInsideVideoInfo.vid);
            }
            if (!Objects.equals(adInsideVideoInfo.video_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adInsideVideoInfo.video_url);
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.file_size), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(adInsideVideoInfo.file_size));
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.play_duration), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(adInsideVideoInfo.play_duration));
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.f383625vh), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(5, Long.valueOf(adInsideVideoInfo.f383625vh));
            }
            if (!Objects.equals(Long.valueOf(adInsideVideoInfo.f383626vw), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(6, Long.valueOf(adInsideVideoInfo.f383626vw));
            }
            if (!Objects.equals(adInsideVideoInfo.encode_protocol_type, AdVideoEncodeProtocolType.AD_VIDEO_ENCODE_PROTOCOL_H264)) {
                i3 += AdVideoEncodeProtocolType.ADAPTER.encodedSizeWithTag(7, adInsideVideoInfo.encode_protocol_type);
            }
            return i3 + adInsideVideoInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdInsideVideoInfo redact(AdInsideVideoInfo adInsideVideoInfo) {
            a newBuilder = adInsideVideoInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdInsideVideoInfo(String str, String str2, long j3, long j16, long j17, long j18, AdVideoEncodeProtocolType adVideoEncodeProtocolType) {
        this(str, str2, j3, j16, j17, j18, adVideoEncodeProtocolType, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdInsideVideoInfo)) {
            return false;
        }
        AdInsideVideoInfo adInsideVideoInfo = (AdInsideVideoInfo) obj;
        if (unknownFields().equals(adInsideVideoInfo.unknownFields()) && Internal.equals(this.vid, adInsideVideoInfo.vid) && Internal.equals(this.video_url, adInsideVideoInfo.video_url) && Internal.equals(Long.valueOf(this.file_size), Long.valueOf(adInsideVideoInfo.file_size)) && Internal.equals(Long.valueOf(this.play_duration), Long.valueOf(adInsideVideoInfo.play_duration)) && Internal.equals(Long.valueOf(this.f383625vh), Long.valueOf(adInsideVideoInfo.f383625vh)) && Internal.equals(Long.valueOf(this.f383626vw), Long.valueOf(adInsideVideoInfo.f383626vw)) && Internal.equals(this.encode_protocol_type, adInsideVideoInfo.encode_protocol_type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.vid;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.video_url;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int a16 = (((((((((i19 + i16) * 37) + androidx.fragment.app.a.a(this.file_size)) * 37) + androidx.fragment.app.a.a(this.play_duration)) * 37) + androidx.fragment.app.a.a(this.f383625vh)) * 37) + androidx.fragment.app.a.a(this.f383626vw)) * 37;
            AdVideoEncodeProtocolType adVideoEncodeProtocolType = this.encode_protocol_type;
            if (adVideoEncodeProtocolType != null) {
                i18 = adVideoEncodeProtocolType.hashCode();
            }
            int i26 = a16 + i18;
            this.hashCode = i26;
            return i26;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.vid != null) {
            sb5.append(", vid=");
            sb5.append(Internal.sanitize(this.vid));
        }
        if (this.video_url != null) {
            sb5.append(", video_url=");
            sb5.append(Internal.sanitize(this.video_url));
        }
        sb5.append(", file_size=");
        sb5.append(this.file_size);
        sb5.append(", play_duration=");
        sb5.append(this.play_duration);
        sb5.append(", vh=");
        sb5.append(this.f383625vh);
        sb5.append(", vw=");
        sb5.append(this.f383626vw);
        if (this.encode_protocol_type != null) {
            sb5.append(", encode_protocol_type=");
            sb5.append(this.encode_protocol_type);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdInsideVideoInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdInsideVideoInfo(String str, String str2, long j3, long j16, long j17, long j18, AdVideoEncodeProtocolType adVideoEncodeProtocolType, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.vid = str;
            if (str2 != null) {
                this.video_url = str2;
                this.file_size = j3;
                this.play_duration = j16;
                this.f383625vh = j17;
                this.f383626vw = j18;
                if (adVideoEncodeProtocolType != null) {
                    this.encode_protocol_type = adVideoEncodeProtocolType;
                    return;
                }
                throw new IllegalArgumentException("encode_protocol_type == null");
            }
            throw new IllegalArgumentException("video_url == null");
        }
        throw new IllegalArgumentException("vid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383627a = this.vid;
        aVar.f383628b = this.video_url;
        aVar.f383629c = this.file_size;
        aVar.f383630d = this.play_duration;
        aVar.f383631e = this.f383625vh;
        aVar.f383632f = this.f383626vw;
        aVar.f383633g = this.encode_protocol_type;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
