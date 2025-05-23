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
public final class AdSceneDesc extends Message<AdSceneDesc, a> {
    public static final ProtoAdapter<AdSceneDesc> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "coldStart", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int cold_start;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdDeviceStatus#ADAPTER", jsonName = "deviceStatus", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AdDeviceStatus device_status;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "dwellTime", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int dwell_time;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFeedSceneDesc#ADAPTER", jsonName = "feedSceneDesc", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final AdFeedSceneDesc feed_scene_desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "sessionId", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String session_id;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdAppStartType#ADAPTER", jsonName = "startType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdAppStartType start_type;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdSceneDesc, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdAppStartType f383715a = AdAppStartType.AD_APP_START_TYPE_OTHER;

        /* renamed from: b, reason: collision with root package name */
        public int f383716b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f383717c = "";

        /* renamed from: d, reason: collision with root package name */
        public int f383718d = 0;

        /* renamed from: e, reason: collision with root package name */
        public AdDeviceStatus f383719e;

        /* renamed from: f, reason: collision with root package name */
        public AdFeedSceneDesc f383720f;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdSceneDesc build() {
            return new AdSceneDesc(this.f383715a, this.f383716b, this.f383717c, this.f383718d, this.f383719e, this.f383720f, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f383716b = i3;
            return this;
        }

        public a c(AdDeviceStatus adDeviceStatus) {
            this.f383719e = adDeviceStatus;
            return this;
        }

        public a d(int i3) {
            this.f383718d = i3;
            return this;
        }

        public a e(AdFeedSceneDesc adFeedSceneDesc) {
            this.f383720f = adFeedSceneDesc;
            return this;
        }

        public a f(String str) {
            this.f383717c = str;
            return this;
        }

        public a g(AdAppStartType adAppStartType) {
            this.f383715a = adAppStartType;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdSceneDesc> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdSceneDesc.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdSceneDesc", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdSceneDesc decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            try {
                                aVar.g(AdAppStartType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 2:
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 5:
                            aVar.c(AdDeviceStatus.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.e(AdFeedSceneDesc.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdSceneDesc adSceneDesc) throws IOException {
            if (!Objects.equals(adSceneDesc.start_type, AdAppStartType.AD_APP_START_TYPE_OTHER)) {
                AdAppStartType.ADAPTER.encodeWithTag(protoWriter, 1, adSceneDesc.start_type);
            }
            if (!Objects.equals(Integer.valueOf(adSceneDesc.cold_start), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adSceneDesc.cold_start));
            }
            if (!Objects.equals(adSceneDesc.session_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adSceneDesc.session_id);
            }
            if (!Objects.equals(Integer.valueOf(adSceneDesc.dwell_time), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, Integer.valueOf(adSceneDesc.dwell_time));
            }
            if (!Objects.equals(adSceneDesc.device_status, null)) {
                AdDeviceStatus.ADAPTER.encodeWithTag(protoWriter, 5, adSceneDesc.device_status);
            }
            if (!Objects.equals(adSceneDesc.feed_scene_desc, null)) {
                AdFeedSceneDesc.ADAPTER.encodeWithTag(protoWriter, 6, adSceneDesc.feed_scene_desc);
            }
            protoWriter.writeBytes(adSceneDesc.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdSceneDesc adSceneDesc) {
            int i3 = 0;
            if (!Objects.equals(adSceneDesc.start_type, AdAppStartType.AD_APP_START_TYPE_OTHER)) {
                i3 = 0 + AdAppStartType.ADAPTER.encodedSizeWithTag(1, adSceneDesc.start_type);
            }
            if (!Objects.equals(Integer.valueOf(adSceneDesc.cold_start), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adSceneDesc.cold_start));
            }
            if (!Objects.equals(adSceneDesc.session_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adSceneDesc.session_id);
            }
            if (!Objects.equals(Integer.valueOf(adSceneDesc.dwell_time), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(adSceneDesc.dwell_time));
            }
            if (!Objects.equals(adSceneDesc.device_status, null)) {
                i3 += AdDeviceStatus.ADAPTER.encodedSizeWithTag(5, adSceneDesc.device_status);
            }
            if (!Objects.equals(adSceneDesc.feed_scene_desc, null)) {
                i3 += AdFeedSceneDesc.ADAPTER.encodedSizeWithTag(6, adSceneDesc.feed_scene_desc);
            }
            return i3 + adSceneDesc.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdSceneDesc redact(AdSceneDesc adSceneDesc) {
            a newBuilder = adSceneDesc.newBuilder();
            AdDeviceStatus adDeviceStatus = newBuilder.f383719e;
            if (adDeviceStatus != null) {
                newBuilder.f383719e = AdDeviceStatus.ADAPTER.redact(adDeviceStatus);
            }
            AdFeedSceneDesc adFeedSceneDesc = newBuilder.f383720f;
            if (adFeedSceneDesc != null) {
                newBuilder.f383720f = AdFeedSceneDesc.ADAPTER.redact(adFeedSceneDesc);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdSceneDesc(AdAppStartType adAppStartType, int i3, String str, int i16, AdDeviceStatus adDeviceStatus, AdFeedSceneDesc adFeedSceneDesc) {
        this(adAppStartType, i3, str, i16, adDeviceStatus, adFeedSceneDesc, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSceneDesc)) {
            return false;
        }
        AdSceneDesc adSceneDesc = (AdSceneDesc) obj;
        if (unknownFields().equals(adSceneDesc.unknownFields()) && Internal.equals(this.start_type, adSceneDesc.start_type) && Internal.equals(Integer.valueOf(this.cold_start), Integer.valueOf(adSceneDesc.cold_start)) && Internal.equals(this.session_id, adSceneDesc.session_id) && Internal.equals(Integer.valueOf(this.dwell_time), Integer.valueOf(adSceneDesc.dwell_time)) && Internal.equals(this.device_status, adSceneDesc.device_status) && Internal.equals(this.feed_scene_desc, adSceneDesc.feed_scene_desc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdAppStartType adAppStartType = this.start_type;
            int i19 = 0;
            if (adAppStartType != null) {
                i3 = adAppStartType.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (((hashCode + i3) * 37) + this.cold_start) * 37;
            String str = this.session_id;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (((i26 + i16) * 37) + this.dwell_time) * 37;
            AdDeviceStatus adDeviceStatus = this.device_status;
            if (adDeviceStatus != null) {
                i17 = adDeviceStatus.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            AdFeedSceneDesc adFeedSceneDesc = this.feed_scene_desc;
            if (adFeedSceneDesc != null) {
                i19 = adFeedSceneDesc.hashCode();
            }
            int i29 = i28 + i19;
            this.hashCode = i29;
            return i29;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.start_type != null) {
            sb5.append(", start_type=");
            sb5.append(this.start_type);
        }
        sb5.append(", cold_start=");
        sb5.append(this.cold_start);
        if (this.session_id != null) {
            sb5.append(", session_id=");
            sb5.append(Internal.sanitize(this.session_id));
        }
        sb5.append(", dwell_time=");
        sb5.append(this.dwell_time);
        if (this.device_status != null) {
            sb5.append(", device_status=");
            sb5.append(this.device_status);
        }
        if (this.feed_scene_desc != null) {
            sb5.append(", feed_scene_desc=");
            sb5.append(this.feed_scene_desc);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdSceneDesc{");
        replace.append('}');
        return replace.toString();
    }

    public AdSceneDesc(AdAppStartType adAppStartType, int i3, String str, int i16, AdDeviceStatus adDeviceStatus, AdFeedSceneDesc adFeedSceneDesc, ByteString byteString) {
        super(ADAPTER, byteString);
        if (adAppStartType != null) {
            this.start_type = adAppStartType;
            this.cold_start = i3;
            if (str != null) {
                this.session_id = str;
                this.dwell_time = i16;
                this.device_status = adDeviceStatus;
                this.feed_scene_desc = adFeedSceneDesc;
                return;
            }
            throw new IllegalArgumentException("session_id == null");
        }
        throw new IllegalArgumentException("start_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383715a = this.start_type;
        aVar.f383716b = this.cold_start;
        aVar.f383717c = this.session_id;
        aVar.f383718d = this.dwell_time;
        aVar.f383719e = this.device_status;
        aVar.f383720f = this.feed_scene_desc;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
