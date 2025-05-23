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
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes27.dex */
public final class RewardAdNewPlayRequest extends Message<RewardAdNewPlayRequest, a> {
    public static final ProtoAdapter<RewardAdNewPlayRequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "penetrateInfo", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String penetrate_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdPlayType#ADAPTER", jsonName = TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final RewardAdPlayType play_type;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdPlayRequestInfo#ADAPTER", jsonName = "requestInfo", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final RewardAdPlayRequestInfo request_info;

    @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "sceneInfo", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AnyMessage scene_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdSceneType#ADAPTER", jsonName = "sceneType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RewardAdSceneType scene_type;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdNewPlayRequest, a> {

        /* renamed from: c, reason: collision with root package name */
        public AnyMessage f383767c;

        /* renamed from: d, reason: collision with root package name */
        public RewardAdPlayRequestInfo f383768d;

        /* renamed from: a, reason: collision with root package name */
        public RewardAdSceneType f383765a = RewardAdSceneType.REWARD_AD_SCENE_TYPE_UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        public RewardAdPlayType f383766b = RewardAdPlayType.REWARD_AD_PLAY_TYPE_UNKNOWN;

        /* renamed from: e, reason: collision with root package name */
        public String f383769e = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewPlayRequest build() {
            return new RewardAdNewPlayRequest(this.f383765a, this.f383766b, this.f383767c, this.f383768d, this.f383769e, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383769e = str;
            return this;
        }

        public a c(RewardAdPlayType rewardAdPlayType) {
            this.f383766b = rewardAdPlayType;
            return this;
        }

        public a d(RewardAdPlayRequestInfo rewardAdPlayRequestInfo) {
            this.f383768d = rewardAdPlayRequestInfo;
            return this;
        }

        public a e(AnyMessage anyMessage) {
            this.f383767c = anyMessage;
            return this;
        }

        public a f(RewardAdSceneType rewardAdSceneType) {
            this.f383765a = rewardAdSceneType;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdNewPlayRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdNewPlayRequest.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdNewPlayRequest", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewPlayRequest decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 5) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                                    }
                                } else {
                                    aVar.d(RewardAdPlayRequestInfo.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.e(AnyMessage.ADAPTER.decode(protoReader));
                            }
                        } else {
                            try {
                                aVar.c(RewardAdPlayType.ADAPTER.decode(protoReader));
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                        }
                    } else {
                        try {
                            aVar.f(RewardAdSceneType.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, RewardAdNewPlayRequest rewardAdNewPlayRequest) throws IOException {
            if (!Objects.equals(rewardAdNewPlayRequest.scene_type, RewardAdSceneType.REWARD_AD_SCENE_TYPE_UNKNOWN)) {
                RewardAdSceneType.ADAPTER.encodeWithTag(protoWriter, 1, rewardAdNewPlayRequest.scene_type);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.play_type, RewardAdPlayType.REWARD_AD_PLAY_TYPE_UNKNOWN)) {
                RewardAdPlayType.ADAPTER.encodeWithTag(protoWriter, 2, rewardAdNewPlayRequest.play_type);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.scene_info, null)) {
                AnyMessage.ADAPTER.encodeWithTag(protoWriter, 3, rewardAdNewPlayRequest.scene_info);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.request_info, null)) {
                RewardAdPlayRequestInfo.ADAPTER.encodeWithTag(protoWriter, 4, rewardAdNewPlayRequest.request_info);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.penetrate_info, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, rewardAdNewPlayRequest.penetrate_info);
            }
            protoWriter.writeBytes(rewardAdNewPlayRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdNewPlayRequest rewardAdNewPlayRequest) {
            int i3 = 0;
            if (!Objects.equals(rewardAdNewPlayRequest.scene_type, RewardAdSceneType.REWARD_AD_SCENE_TYPE_UNKNOWN)) {
                i3 = 0 + RewardAdSceneType.ADAPTER.encodedSizeWithTag(1, rewardAdNewPlayRequest.scene_type);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.play_type, RewardAdPlayType.REWARD_AD_PLAY_TYPE_UNKNOWN)) {
                i3 += RewardAdPlayType.ADAPTER.encodedSizeWithTag(2, rewardAdNewPlayRequest.play_type);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.scene_info, null)) {
                i3 += AnyMessage.ADAPTER.encodedSizeWithTag(3, rewardAdNewPlayRequest.scene_info);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.request_info, null)) {
                i3 += RewardAdPlayRequestInfo.ADAPTER.encodedSizeWithTag(4, rewardAdNewPlayRequest.request_info);
            }
            if (!Objects.equals(rewardAdNewPlayRequest.penetrate_info, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, rewardAdNewPlayRequest.penetrate_info);
            }
            return i3 + rewardAdNewPlayRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdNewPlayRequest redact(RewardAdNewPlayRequest rewardAdNewPlayRequest) {
            a newBuilder = rewardAdNewPlayRequest.newBuilder();
            AnyMessage anyMessage = newBuilder.f383767c;
            if (anyMessage != null) {
                newBuilder.f383767c = AnyMessage.ADAPTER.redact(anyMessage);
            }
            RewardAdPlayRequestInfo rewardAdPlayRequestInfo = newBuilder.f383768d;
            if (rewardAdPlayRequestInfo != null) {
                newBuilder.f383768d = RewardAdPlayRequestInfo.ADAPTER.redact(rewardAdPlayRequestInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdNewPlayRequest(RewardAdSceneType rewardAdSceneType, RewardAdPlayType rewardAdPlayType, AnyMessage anyMessage, RewardAdPlayRequestInfo rewardAdPlayRequestInfo, String str) {
        this(rewardAdSceneType, rewardAdPlayType, anyMessage, rewardAdPlayRequestInfo, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdNewPlayRequest)) {
            return false;
        }
        RewardAdNewPlayRequest rewardAdNewPlayRequest = (RewardAdNewPlayRequest) obj;
        if (unknownFields().equals(rewardAdNewPlayRequest.unknownFields()) && Internal.equals(this.scene_type, rewardAdNewPlayRequest.scene_type) && Internal.equals(this.play_type, rewardAdNewPlayRequest.play_type) && Internal.equals(this.scene_info, rewardAdNewPlayRequest.scene_info) && Internal.equals(this.request_info, rewardAdNewPlayRequest.request_info) && Internal.equals(this.penetrate_info, rewardAdNewPlayRequest.penetrate_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RewardAdSceneType rewardAdSceneType = this.scene_type;
            int i26 = 0;
            if (rewardAdSceneType != null) {
                i3 = rewardAdSceneType.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            RewardAdPlayType rewardAdPlayType = this.play_type;
            if (rewardAdPlayType != null) {
                i16 = rewardAdPlayType.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            AnyMessage anyMessage = this.scene_info;
            if (anyMessage != null) {
                i17 = anyMessage.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            RewardAdPlayRequestInfo rewardAdPlayRequestInfo = this.request_info;
            if (rewardAdPlayRequestInfo != null) {
                i18 = rewardAdPlayRequestInfo.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str = this.penetrate_info;
            if (str != null) {
                i26 = str.hashCode();
            }
            int i37 = i36 + i26;
            this.hashCode = i37;
            return i37;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.scene_type != null) {
            sb5.append(", scene_type=");
            sb5.append(this.scene_type);
        }
        if (this.play_type != null) {
            sb5.append(", play_type=");
            sb5.append(this.play_type);
        }
        if (this.scene_info != null) {
            sb5.append(", scene_info=");
            sb5.append(this.scene_info);
        }
        if (this.request_info != null) {
            sb5.append(", request_info=");
            sb5.append(this.request_info);
        }
        if (this.penetrate_info != null) {
            sb5.append(", penetrate_info=");
            sb5.append(Internal.sanitize(this.penetrate_info));
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdNewPlayRequest{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdNewPlayRequest(RewardAdSceneType rewardAdSceneType, RewardAdPlayType rewardAdPlayType, AnyMessage anyMessage, RewardAdPlayRequestInfo rewardAdPlayRequestInfo, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        if (rewardAdSceneType != null) {
            this.scene_type = rewardAdSceneType;
            if (rewardAdPlayType != null) {
                this.play_type = rewardAdPlayType;
                this.scene_info = anyMessage;
                this.request_info = rewardAdPlayRequestInfo;
                if (str != null) {
                    this.penetrate_info = str;
                    return;
                }
                throw new IllegalArgumentException("penetrate_info == null");
            }
            throw new IllegalArgumentException("play_type == null");
        }
        throw new IllegalArgumentException("scene_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383765a = this.scene_type;
        aVar.f383766b = this.play_type;
        aVar.f383767c = this.scene_info;
        aVar.f383768d = this.request_info;
        aVar.f383769e = this.penetrate_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
