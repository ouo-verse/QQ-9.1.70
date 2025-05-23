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
public final class ExtraVideoInfo extends Message<ExtraVideoInfo, a> {
    public static final ProtoAdapter<ExtraVideoInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String cid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String vid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "videoLeftInterval", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final long video_left_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "videoWatchedTime", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final long video_watched_time;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<ExtraVideoInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public long f383748a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f383749b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f383750c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383751d = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtraVideoInfo build() {
            return new ExtraVideoInfo(this.f383748a, this.f383749b, this.f383750c, this.f383751d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383751d = str;
            return this;
        }

        public a c(String str) {
            this.f383750c = str;
            return this;
        }

        public a d(long j3) {
            this.f383749b = j3;
            return this;
        }

        public a e(long j3) {
            this.f383748a = j3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<ExtraVideoInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ExtraVideoInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.ExtraVideoInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtraVideoInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    protoReader.readUnknownField(nextTag);
                                } else {
                                    aVar.b(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.INT64.decode(protoReader).longValue());
                        }
                    } else {
                        aVar.e(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, ExtraVideoInfo extraVideoInfo) throws IOException {
            if (!Objects.equals(Long.valueOf(extraVideoInfo.video_watched_time), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(extraVideoInfo.video_watched_time));
            }
            if (!Objects.equals(Long.valueOf(extraVideoInfo.video_left_interval), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, Long.valueOf(extraVideoInfo.video_left_interval));
            }
            if (!Objects.equals(extraVideoInfo.vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, extraVideoInfo.vid);
            }
            if (!Objects.equals(extraVideoInfo.cid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, extraVideoInfo.cid);
            }
            protoWriter.writeBytes(extraVideoInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ExtraVideoInfo extraVideoInfo) {
            int i3 = 0;
            if (!Objects.equals(Long.valueOf(extraVideoInfo.video_watched_time), 0L)) {
                i3 = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(extraVideoInfo.video_watched_time));
            }
            if (!Objects.equals(Long.valueOf(extraVideoInfo.video_left_interval), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(extraVideoInfo.video_left_interval));
            }
            if (!Objects.equals(extraVideoInfo.vid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, extraVideoInfo.vid);
            }
            if (!Objects.equals(extraVideoInfo.cid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, extraVideoInfo.cid);
            }
            return i3 + extraVideoInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ExtraVideoInfo redact(ExtraVideoInfo extraVideoInfo) {
            a newBuilder = extraVideoInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ExtraVideoInfo(long j3, long j16, String str, String str2) {
        this(j3, j16, str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExtraVideoInfo)) {
            return false;
        }
        ExtraVideoInfo extraVideoInfo = (ExtraVideoInfo) obj;
        if (unknownFields().equals(extraVideoInfo.unknownFields()) && Internal.equals(Long.valueOf(this.video_watched_time), Long.valueOf(extraVideoInfo.video_watched_time)) && Internal.equals(Long.valueOf(this.video_left_interval), Long.valueOf(extraVideoInfo.video_left_interval)) && Internal.equals(this.vid, extraVideoInfo.vid) && Internal.equals(this.cid, extraVideoInfo.cid)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.video_watched_time)) * 37) + androidx.fragment.app.a.a(this.video_left_interval)) * 37;
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
        sb5.append(", video_watched_time=");
        sb5.append(this.video_watched_time);
        sb5.append(", video_left_interval=");
        sb5.append(this.video_left_interval);
        if (this.vid != null) {
            sb5.append(", vid=");
            sb5.append(Internal.sanitize(this.vid));
        }
        if (this.cid != null) {
            sb5.append(", cid=");
            sb5.append(Internal.sanitize(this.cid));
        }
        StringBuilder replace = sb5.replace(0, 2, "ExtraVideoInfo{");
        replace.append('}');
        return replace.toString();
    }

    public ExtraVideoInfo(long j3, long j16, String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_watched_time = j3;
        this.video_left_interval = j16;
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
        aVar.f383748a = this.video_watched_time;
        aVar.f383749b = this.video_left_interval;
        aVar.f383750c = this.vid;
        aVar.f383751d = this.cid;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
