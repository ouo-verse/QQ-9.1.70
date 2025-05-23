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
public final class AdFeedVideoInfo extends Message<AdFeedVideoInfo, a> {
    public static final ProtoAdapter<AdFeedVideoInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "fileSize", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final long file_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isVerticalStream", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final boolean is_vertical_stream;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "playDuration", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long play_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String sdtfrom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String vid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = AppConstants.Key.KEY_QZONE_VIDEO_URL, label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String video_url;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFeedVideoInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383591a = "";

        /* renamed from: b, reason: collision with root package name */
        public long f383592b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f383593c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f383594d = "";

        /* renamed from: e, reason: collision with root package name */
        public boolean f383595e = false;

        /* renamed from: f, reason: collision with root package name */
        public String f383596f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedVideoInfo build() {
            return new AdFeedVideoInfo(this.f383591a, this.f383592b, this.f383593c, this.f383594d, this.f383595e, this.f383596f, super.buildUnknownFields());
        }

        public a b(long j3) {
            this.f383592b = j3;
            return this;
        }

        public a c(boolean z16) {
            this.f383595e = z16;
            return this;
        }

        public a d(long j3) {
            this.f383593c = j3;
            return this;
        }

        public a e(String str) {
            this.f383596f = str;
            return this;
        }

        public a f(String str) {
            this.f383591a = str;
            return this;
        }

        public a g(String str) {
            this.f383594d = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFeedVideoInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFeedVideoInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFeedVideoInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedVideoInfo decode(ProtoReader protoReader) throws IOException {
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
                            aVar.b(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 3:
                            aVar.d(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 4:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
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
        public void encode(ProtoWriter protoWriter, AdFeedVideoInfo adFeedVideoInfo) throws IOException {
            if (!Objects.equals(adFeedVideoInfo.vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adFeedVideoInfo.vid);
            }
            if (!Objects.equals(Long.valueOf(adFeedVideoInfo.file_size), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, Long.valueOf(adFeedVideoInfo.file_size));
            }
            if (!Objects.equals(Long.valueOf(adFeedVideoInfo.play_duration), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, Long.valueOf(adFeedVideoInfo.play_duration));
            }
            if (!Objects.equals(adFeedVideoInfo.video_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adFeedVideoInfo.video_url);
            }
            if (!Objects.equals(Boolean.valueOf(adFeedVideoInfo.is_vertical_stream), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, Boolean.valueOf(adFeedVideoInfo.is_vertical_stream));
            }
            if (!Objects.equals(adFeedVideoInfo.sdtfrom, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adFeedVideoInfo.sdtfrom);
            }
            protoWriter.writeBytes(adFeedVideoInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFeedVideoInfo adFeedVideoInfo) {
            int i3 = 0;
            if (!Objects.equals(adFeedVideoInfo.vid, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adFeedVideoInfo.vid);
            }
            if (!Objects.equals(Long.valueOf(adFeedVideoInfo.file_size), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(adFeedVideoInfo.file_size));
            }
            if (!Objects.equals(Long.valueOf(adFeedVideoInfo.play_duration), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(adFeedVideoInfo.play_duration));
            }
            if (!Objects.equals(adFeedVideoInfo.video_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adFeedVideoInfo.video_url);
            }
            if (!Objects.equals(Boolean.valueOf(adFeedVideoInfo.is_vertical_stream), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(5, Boolean.valueOf(adFeedVideoInfo.is_vertical_stream));
            }
            if (!Objects.equals(adFeedVideoInfo.sdtfrom, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adFeedVideoInfo.sdtfrom);
            }
            return i3 + adFeedVideoInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFeedVideoInfo redact(AdFeedVideoInfo adFeedVideoInfo) {
            a newBuilder = adFeedVideoInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFeedVideoInfo(String str, long j3, long j16, String str2, boolean z16, String str3) {
        this(str, j3, j16, str2, z16, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFeedVideoInfo)) {
            return false;
        }
        AdFeedVideoInfo adFeedVideoInfo = (AdFeedVideoInfo) obj;
        if (unknownFields().equals(adFeedVideoInfo.unknownFields()) && Internal.equals(this.vid, adFeedVideoInfo.vid) && Internal.equals(Long.valueOf(this.file_size), Long.valueOf(adFeedVideoInfo.file_size)) && Internal.equals(Long.valueOf(this.play_duration), Long.valueOf(adFeedVideoInfo.play_duration)) && Internal.equals(this.video_url, adFeedVideoInfo.video_url) && Internal.equals(Boolean.valueOf(this.is_vertical_stream), Boolean.valueOf(adFeedVideoInfo.is_vertical_stream)) && Internal.equals(this.sdtfrom, adFeedVideoInfo.sdtfrom)) {
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
            int a16 = (((((hashCode + i3) * 37) + androidx.fragment.app.a.a(this.file_size)) * 37) + androidx.fragment.app.a.a(this.play_duration)) * 37;
            String str2 = this.video_url;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int a17 = (((a16 + i16) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_vertical_stream)) * 37;
            String str3 = this.sdtfrom;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int i19 = a17 + i18;
            this.hashCode = i19;
            return i19;
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
        sb5.append(", file_size=");
        sb5.append(this.file_size);
        sb5.append(", play_duration=");
        sb5.append(this.play_duration);
        if (this.video_url != null) {
            sb5.append(", video_url=");
            sb5.append(Internal.sanitize(this.video_url));
        }
        sb5.append(", is_vertical_stream=");
        sb5.append(this.is_vertical_stream);
        if (this.sdtfrom != null) {
            sb5.append(", sdtfrom=");
            sb5.append(Internal.sanitize(this.sdtfrom));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdFeedVideoInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdFeedVideoInfo(String str, long j3, long j16, String str2, boolean z16, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.vid = str;
            this.file_size = j3;
            this.play_duration = j16;
            if (str2 != null) {
                this.video_url = str2;
                this.is_vertical_stream = z16;
                if (str3 != null) {
                    this.sdtfrom = str3;
                    return;
                }
                throw new IllegalArgumentException("sdtfrom == null");
            }
            throw new IllegalArgumentException("video_url == null");
        }
        throw new IllegalArgumentException("vid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383591a = this.vid;
        aVar.f383592b = this.file_size;
        aVar.f383593c = this.play_duration;
        aVar.f383594d = this.video_url;
        aVar.f383595e = this.is_vertical_stream;
        aVar.f383596f = this.sdtfrom;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
