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
public final class AdDeviceStatus extends Message<AdDeviceStatus, a> {
    public static final ProtoAdapter<AdDeviceStatus> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "autoPlay", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int auto_play;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int muted;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int volume;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdDeviceStatus, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f383545a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f383546b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f383547c = 0;

        public a a(int i3) {
            this.f383547c = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdDeviceStatus build() {
            return new AdDeviceStatus(this.f383545a, this.f383546b, this.f383547c, super.buildUnknownFields());
        }

        public a c(int i3) {
            this.f383546b = i3;
            return this;
        }

        public a d(int i3) {
            this.f383545a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdDeviceStatus> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdDeviceStatus.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdDeviceStatus", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdDeviceStatus decode(ProtoReader protoReader) throws IOException {
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
                                aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdDeviceStatus adDeviceStatus) throws IOException {
            if (!Objects.equals(Integer.valueOf(adDeviceStatus.volume), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(adDeviceStatus.volume));
            }
            if (!Objects.equals(Integer.valueOf(adDeviceStatus.muted), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adDeviceStatus.muted));
            }
            if (!Objects.equals(Integer.valueOf(adDeviceStatus.auto_play), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(adDeviceStatus.auto_play));
            }
            protoWriter.writeBytes(adDeviceStatus.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdDeviceStatus adDeviceStatus) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(adDeviceStatus.volume), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(adDeviceStatus.volume));
            }
            if (!Objects.equals(Integer.valueOf(adDeviceStatus.muted), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adDeviceStatus.muted));
            }
            if (!Objects.equals(Integer.valueOf(adDeviceStatus.auto_play), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(adDeviceStatus.auto_play));
            }
            return i3 + adDeviceStatus.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdDeviceStatus redact(AdDeviceStatus adDeviceStatus) {
            a newBuilder = adDeviceStatus.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdDeviceStatus(int i3, int i16, int i17) {
        this(i3, i16, i17, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdDeviceStatus)) {
            return false;
        }
        AdDeviceStatus adDeviceStatus = (AdDeviceStatus) obj;
        if (unknownFields().equals(adDeviceStatus.unknownFields()) && Internal.equals(Integer.valueOf(this.volume), Integer.valueOf(adDeviceStatus.volume)) && Internal.equals(Integer.valueOf(this.muted), Integer.valueOf(adDeviceStatus.muted)) && Internal.equals(Integer.valueOf(this.auto_play), Integer.valueOf(adDeviceStatus.auto_play))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.volume) * 37) + this.muted) * 37) + this.auto_play;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", volume=");
        sb5.append(this.volume);
        sb5.append(", muted=");
        sb5.append(this.muted);
        sb5.append(", auto_play=");
        sb5.append(this.auto_play);
        StringBuilder replace = sb5.replace(0, 2, "AdDeviceStatus{");
        replace.append('}');
        return replace.toString();
    }

    public AdDeviceStatus(int i3, int i16, int i17, ByteString byteString) {
        super(ADAPTER, byteString);
        this.volume = i3;
        this.muted = i16;
        this.auto_play = i17;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383545a = this.volume;
        aVar.f383546b = this.muted;
        aVar.f383547c = this.auto_play;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
