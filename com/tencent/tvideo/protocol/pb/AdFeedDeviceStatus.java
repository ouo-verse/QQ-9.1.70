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
public final class AdFeedDeviceStatus extends Message<AdFeedDeviceStatus, a> {
    public static final ProtoAdapter<AdFeedDeviceStatus> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "autoPlayNext", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int auto_play_next;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFeedDeviceStatus, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f383577a = 0;

        public a a(int i3) {
            this.f383577a = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdFeedDeviceStatus build() {
            return new AdFeedDeviceStatus(this.f383577a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFeedDeviceStatus> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFeedDeviceStatus.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFeedDeviceStatus", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedDeviceStatus decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdFeedDeviceStatus adFeedDeviceStatus) throws IOException {
            if (!Objects.equals(Integer.valueOf(adFeedDeviceStatus.auto_play_next), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(adFeedDeviceStatus.auto_play_next));
            }
            protoWriter.writeBytes(adFeedDeviceStatus.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFeedDeviceStatus adFeedDeviceStatus) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(adFeedDeviceStatus.auto_play_next), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(adFeedDeviceStatus.auto_play_next));
            }
            return i3 + adFeedDeviceStatus.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFeedDeviceStatus redact(AdFeedDeviceStatus adFeedDeviceStatus) {
            a newBuilder = adFeedDeviceStatus.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFeedDeviceStatus(int i3) {
        this(i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFeedDeviceStatus)) {
            return false;
        }
        AdFeedDeviceStatus adFeedDeviceStatus = (AdFeedDeviceStatus) obj;
        if (unknownFields().equals(adFeedDeviceStatus.unknownFields()) && Internal.equals(Integer.valueOf(this.auto_play_next), Integer.valueOf(adFeedDeviceStatus.auto_play_next))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.auto_play_next;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", auto_play_next=");
        sb5.append(this.auto_play_next);
        StringBuilder replace = sb5.replace(0, 2, "AdFeedDeviceStatus{");
        replace.append('}');
        return replace.toString();
    }

    public AdFeedDeviceStatus(int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.auto_play_next = i3;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383577a = this.auto_play_next;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
