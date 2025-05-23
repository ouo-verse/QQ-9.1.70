package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.AnyMessage;
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
public final class RewardAdNewUpdateRequest extends Message<RewardAdNewUpdateRequest, a> {
    public static final ProtoAdapter<RewardAdNewUpdateRequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdRequestContextInfo#ADAPTER", jsonName = "contextInfo", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final AdRequestContextInfo context_info;

    @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "sceneInfo", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AnyMessage scene_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdSceneType#ADAPTER", jsonName = "sceneType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RewardAdSceneType scene_type;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdUpdateType#ADAPTER", jsonName = "updateType", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final RewardAdUpdateType update_type;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdNewUpdateRequest, a> {

        /* renamed from: a, reason: collision with root package name */
        public RewardAdSceneType f383774a = RewardAdSceneType.REWARD_AD_SCENE_TYPE_UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        public RewardAdUpdateType f383775b = RewardAdUpdateType.REWARD_AD_UPDATE_TYPE_UNKNOWN;

        /* renamed from: c, reason: collision with root package name */
        public AnyMessage f383776c;

        /* renamed from: d, reason: collision with root package name */
        public AdRequestContextInfo f383777d;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUpdateRequest build() {
            return new RewardAdNewUpdateRequest(this.f383774a, this.f383775b, this.f383776c, this.f383777d, super.buildUnknownFields());
        }

        public a b(AdRequestContextInfo adRequestContextInfo) {
            this.f383777d = adRequestContextInfo;
            return this;
        }

        public a c(AnyMessage anyMessage) {
            this.f383776c = anyMessage;
            return this;
        }

        public a d(RewardAdSceneType rewardAdSceneType) {
            this.f383774a = rewardAdSceneType;
            return this;
        }

        public a e(RewardAdUpdateType rewardAdUpdateType) {
            this.f383775b = rewardAdUpdateType;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdNewUpdateRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdNewUpdateRequest.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdNewUpdateRequest", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUpdateRequest decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.b(AdRequestContextInfo.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.c(AnyMessage.ADAPTER.decode(protoReader));
                            }
                        } else {
                            try {
                                aVar.e(RewardAdUpdateType.ADAPTER.decode(protoReader));
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                        }
                    } else {
                        try {
                            aVar.d(RewardAdSceneType.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                        }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdNewUpdateRequest rewardAdNewUpdateRequest) throws IOException {
            if (!Objects.equals(rewardAdNewUpdateRequest.scene_type, RewardAdSceneType.REWARD_AD_SCENE_TYPE_UNKNOWN)) {
                RewardAdSceneType.ADAPTER.encodeWithTag(protoWriter, 1, rewardAdNewUpdateRequest.scene_type);
            }
            if (!Objects.equals(rewardAdNewUpdateRequest.update_type, RewardAdUpdateType.REWARD_AD_UPDATE_TYPE_UNKNOWN)) {
                RewardAdUpdateType.ADAPTER.encodeWithTag(protoWriter, 2, rewardAdNewUpdateRequest.update_type);
            }
            if (!Objects.equals(rewardAdNewUpdateRequest.scene_info, null)) {
                AnyMessage.ADAPTER.encodeWithTag(protoWriter, 3, rewardAdNewUpdateRequest.scene_info);
            }
            if (!Objects.equals(rewardAdNewUpdateRequest.context_info, null)) {
                AdRequestContextInfo.ADAPTER.encodeWithTag(protoWriter, 4, rewardAdNewUpdateRequest.context_info);
            }
            protoWriter.writeBytes(rewardAdNewUpdateRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdNewUpdateRequest rewardAdNewUpdateRequest) {
            int i3 = 0;
            if (!Objects.equals(rewardAdNewUpdateRequest.scene_type, RewardAdSceneType.REWARD_AD_SCENE_TYPE_UNKNOWN)) {
                i3 = 0 + RewardAdSceneType.ADAPTER.encodedSizeWithTag(1, rewardAdNewUpdateRequest.scene_type);
            }
            if (!Objects.equals(rewardAdNewUpdateRequest.update_type, RewardAdUpdateType.REWARD_AD_UPDATE_TYPE_UNKNOWN)) {
                i3 += RewardAdUpdateType.ADAPTER.encodedSizeWithTag(2, rewardAdNewUpdateRequest.update_type);
            }
            if (!Objects.equals(rewardAdNewUpdateRequest.scene_info, null)) {
                i3 += AnyMessage.ADAPTER.encodedSizeWithTag(3, rewardAdNewUpdateRequest.scene_info);
            }
            if (!Objects.equals(rewardAdNewUpdateRequest.context_info, null)) {
                i3 += AdRequestContextInfo.ADAPTER.encodedSizeWithTag(4, rewardAdNewUpdateRequest.context_info);
            }
            return i3 + rewardAdNewUpdateRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUpdateRequest redact(RewardAdNewUpdateRequest rewardAdNewUpdateRequest) {
            a newBuilder = rewardAdNewUpdateRequest.newBuilder();
            AnyMessage anyMessage = newBuilder.f383776c;
            if (anyMessage != null) {
                newBuilder.f383776c = AnyMessage.ADAPTER.redact(anyMessage);
            }
            AdRequestContextInfo adRequestContextInfo = newBuilder.f383777d;
            if (adRequestContextInfo != null) {
                newBuilder.f383777d = AdRequestContextInfo.ADAPTER.redact(adRequestContextInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdNewUpdateRequest(RewardAdSceneType rewardAdSceneType, RewardAdUpdateType rewardAdUpdateType, AnyMessage anyMessage, AdRequestContextInfo adRequestContextInfo) {
        this(rewardAdSceneType, rewardAdUpdateType, anyMessage, adRequestContextInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdNewUpdateRequest)) {
            return false;
        }
        RewardAdNewUpdateRequest rewardAdNewUpdateRequest = (RewardAdNewUpdateRequest) obj;
        if (unknownFields().equals(rewardAdNewUpdateRequest.unknownFields()) && Internal.equals(this.scene_type, rewardAdNewUpdateRequest.scene_type) && Internal.equals(this.update_type, rewardAdNewUpdateRequest.update_type) && Internal.equals(this.scene_info, rewardAdNewUpdateRequest.scene_info) && Internal.equals(this.context_info, rewardAdNewUpdateRequest.context_info)) {
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
            RewardAdSceneType rewardAdSceneType = this.scene_type;
            int i19 = 0;
            if (rewardAdSceneType != null) {
                i3 = rewardAdSceneType.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            RewardAdUpdateType rewardAdUpdateType = this.update_type;
            if (rewardAdUpdateType != null) {
                i16 = rewardAdUpdateType.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            AnyMessage anyMessage = this.scene_info;
            if (anyMessage != null) {
                i17 = anyMessage.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            AdRequestContextInfo adRequestContextInfo = this.context_info;
            if (adRequestContextInfo != null) {
                i19 = adRequestContextInfo.hashCode();
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
        if (this.scene_type != null) {
            sb5.append(", scene_type=");
            sb5.append(this.scene_type);
        }
        if (this.update_type != null) {
            sb5.append(", update_type=");
            sb5.append(this.update_type);
        }
        if (this.scene_info != null) {
            sb5.append(", scene_info=");
            sb5.append(this.scene_info);
        }
        if (this.context_info != null) {
            sb5.append(", context_info=");
            sb5.append(this.context_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdNewUpdateRequest{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdNewUpdateRequest(RewardAdSceneType rewardAdSceneType, RewardAdUpdateType rewardAdUpdateType, AnyMessage anyMessage, AdRequestContextInfo adRequestContextInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        if (rewardAdSceneType != null) {
            this.scene_type = rewardAdSceneType;
            if (rewardAdUpdateType != null) {
                this.update_type = rewardAdUpdateType;
                this.scene_info = anyMessage;
                this.context_info = adRequestContextInfo;
                return;
            }
            throw new IllegalArgumentException("update_type == null");
        }
        throw new IllegalArgumentException("scene_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383774a = this.scene_type;
        aVar.f383775b = this.update_type;
        aVar.f383776c = this.scene_info;
        aVar.f383777d = this.context_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
