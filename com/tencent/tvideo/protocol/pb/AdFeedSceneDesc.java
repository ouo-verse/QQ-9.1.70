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
public final class AdFeedSceneDesc extends Message<AdFeedSceneDesc, a> {
    public static final ProtoAdapter<AdFeedSceneDesc> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdChannelStatus#ADAPTER", jsonName = "channelStatus", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdChannelStatus channel_status;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFeedDeviceStatus#ADAPTER", jsonName = "feedDeviceStatus", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdFeedDeviceStatus feed_device_status;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFeedSceneDesc, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdChannelStatus f383589a;

        /* renamed from: b, reason: collision with root package name */
        public AdFeedDeviceStatus f383590b;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedSceneDesc build() {
            return new AdFeedSceneDesc(this.f383589a, this.f383590b, super.buildUnknownFields());
        }

        public a b(AdChannelStatus adChannelStatus) {
            this.f383589a = adChannelStatus;
            return this;
        }

        public a c(AdFeedDeviceStatus adFeedDeviceStatus) {
            this.f383590b = adFeedDeviceStatus;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFeedSceneDesc> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFeedSceneDesc.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFeedSceneDesc", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedSceneDesc decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.c(AdFeedDeviceStatus.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.b(AdChannelStatus.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdFeedSceneDesc adFeedSceneDesc) throws IOException {
            if (!Objects.equals(adFeedSceneDesc.channel_status, null)) {
                AdChannelStatus.ADAPTER.encodeWithTag(protoWriter, 1, adFeedSceneDesc.channel_status);
            }
            if (!Objects.equals(adFeedSceneDesc.feed_device_status, null)) {
                AdFeedDeviceStatus.ADAPTER.encodeWithTag(protoWriter, 2, adFeedSceneDesc.feed_device_status);
            }
            protoWriter.writeBytes(adFeedSceneDesc.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFeedSceneDesc adFeedSceneDesc) {
            int i3 = 0;
            if (!Objects.equals(adFeedSceneDesc.channel_status, null)) {
                i3 = 0 + AdChannelStatus.ADAPTER.encodedSizeWithTag(1, adFeedSceneDesc.channel_status);
            }
            if (!Objects.equals(adFeedSceneDesc.feed_device_status, null)) {
                i3 += AdFeedDeviceStatus.ADAPTER.encodedSizeWithTag(2, adFeedSceneDesc.feed_device_status);
            }
            return i3 + adFeedSceneDesc.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFeedSceneDesc redact(AdFeedSceneDesc adFeedSceneDesc) {
            a newBuilder = adFeedSceneDesc.newBuilder();
            AdChannelStatus adChannelStatus = newBuilder.f383589a;
            if (adChannelStatus != null) {
                newBuilder.f383589a = AdChannelStatus.ADAPTER.redact(adChannelStatus);
            }
            AdFeedDeviceStatus adFeedDeviceStatus = newBuilder.f383590b;
            if (adFeedDeviceStatus != null) {
                newBuilder.f383590b = AdFeedDeviceStatus.ADAPTER.redact(adFeedDeviceStatus);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFeedSceneDesc(AdChannelStatus adChannelStatus, AdFeedDeviceStatus adFeedDeviceStatus) {
        this(adChannelStatus, adFeedDeviceStatus, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFeedSceneDesc)) {
            return false;
        }
        AdFeedSceneDesc adFeedSceneDesc = (AdFeedSceneDesc) obj;
        if (unknownFields().equals(adFeedSceneDesc.unknownFields()) && Internal.equals(this.channel_status, adFeedSceneDesc.channel_status) && Internal.equals(this.feed_device_status, adFeedSceneDesc.feed_device_status)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdChannelStatus adChannelStatus = this.channel_status;
            int i17 = 0;
            if (adChannelStatus != null) {
                i3 = adChannelStatus.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            AdFeedDeviceStatus adFeedDeviceStatus = this.feed_device_status;
            if (adFeedDeviceStatus != null) {
                i17 = adFeedDeviceStatus.hashCode();
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
        if (this.channel_status != null) {
            sb5.append(", channel_status=");
            sb5.append(this.channel_status);
        }
        if (this.feed_device_status != null) {
            sb5.append(", feed_device_status=");
            sb5.append(this.feed_device_status);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdFeedSceneDesc{");
        replace.append('}');
        return replace.toString();
    }

    public AdFeedSceneDesc(AdChannelStatus adChannelStatus, AdFeedDeviceStatus adFeedDeviceStatus, ByteString byteString) {
        super(ADAPTER, byteString);
        this.channel_status = adChannelStatus;
        this.feed_device_status = adFeedDeviceStatus;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383589a = this.channel_status;
        aVar.f383590b = this.feed_device_status;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
