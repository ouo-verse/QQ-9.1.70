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
public final class RewardAdNewUnlockInfo extends Message<RewardAdNewUnlockInfo, a> {
    public static final ProtoAdapter<RewardAdNewUnlockInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int lockStatus;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdRewardUnlockType#ADAPTER", jsonName = "rewardUnlockType", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final RewardAdRewardUnlockType reward_unlock_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "unlockTips", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String unlock_tips;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdNewUnlockInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383771a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f383772b = 0;

        /* renamed from: c, reason: collision with root package name */
        public RewardAdRewardUnlockType f383773c = RewardAdRewardUnlockType.REWARD_AD_UNLOCK_REWARD_TYPE_UNKNOWN;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUnlockInfo build() {
            return new RewardAdNewUnlockInfo(this.f383771a, this.f383772b, this.f383773c, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f383772b = i3;
            return this;
        }

        public a c(RewardAdRewardUnlockType rewardAdRewardUnlockType) {
            this.f383773c = rewardAdRewardUnlockType;
            return this;
        }

        public a d(String str) {
            this.f383771a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdNewUnlockInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdNewUnlockInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUnlockInfo decode(ProtoReader protoReader) throws IOException {
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
                                try {
                                    aVar.c(RewardAdRewardUnlockType.ADAPTER.decode(protoReader));
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                }
                            }
                        } else {
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.d(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdNewUnlockInfo rewardAdNewUnlockInfo) throws IOException {
            if (!Objects.equals(rewardAdNewUnlockInfo.unlock_tips, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, rewardAdNewUnlockInfo.unlock_tips);
            }
            if (!Objects.equals(Integer.valueOf(rewardAdNewUnlockInfo.lockStatus), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(rewardAdNewUnlockInfo.lockStatus));
            }
            if (!Objects.equals(rewardAdNewUnlockInfo.reward_unlock_type, RewardAdRewardUnlockType.REWARD_AD_UNLOCK_REWARD_TYPE_UNKNOWN)) {
                RewardAdRewardUnlockType.ADAPTER.encodeWithTag(protoWriter, 3, rewardAdNewUnlockInfo.reward_unlock_type);
            }
            protoWriter.writeBytes(rewardAdNewUnlockInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdNewUnlockInfo rewardAdNewUnlockInfo) {
            int i3;
            if (!Objects.equals(rewardAdNewUnlockInfo.unlock_tips, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, rewardAdNewUnlockInfo.unlock_tips) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(rewardAdNewUnlockInfo.lockStatus), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(rewardAdNewUnlockInfo.lockStatus));
            }
            if (!Objects.equals(rewardAdNewUnlockInfo.reward_unlock_type, RewardAdRewardUnlockType.REWARD_AD_UNLOCK_REWARD_TYPE_UNKNOWN)) {
                i3 += RewardAdRewardUnlockType.ADAPTER.encodedSizeWithTag(3, rewardAdNewUnlockInfo.reward_unlock_type);
            }
            return i3 + rewardAdNewUnlockInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdNewUnlockInfo redact(RewardAdNewUnlockInfo rewardAdNewUnlockInfo) {
            a newBuilder = rewardAdNewUnlockInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdNewUnlockInfo(String str, int i3, RewardAdRewardUnlockType rewardAdRewardUnlockType) {
        this(str, i3, rewardAdRewardUnlockType, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdNewUnlockInfo)) {
            return false;
        }
        RewardAdNewUnlockInfo rewardAdNewUnlockInfo = (RewardAdNewUnlockInfo) obj;
        if (unknownFields().equals(rewardAdNewUnlockInfo.unknownFields()) && Internal.equals(this.unlock_tips, rewardAdNewUnlockInfo.unlock_tips) && Internal.equals(Integer.valueOf(this.lockStatus), Integer.valueOf(rewardAdNewUnlockInfo.lockStatus)) && Internal.equals(this.reward_unlock_type, rewardAdNewUnlockInfo.reward_unlock_type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.unlock_tips;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (((hashCode + i3) * 37) + this.lockStatus) * 37;
            RewardAdRewardUnlockType rewardAdRewardUnlockType = this.reward_unlock_type;
            if (rewardAdRewardUnlockType != null) {
                i17 = rewardAdRewardUnlockType.hashCode();
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
        if (this.unlock_tips != null) {
            sb5.append(", unlock_tips=");
            sb5.append(Internal.sanitize(this.unlock_tips));
        }
        sb5.append(", lockStatus=");
        sb5.append(this.lockStatus);
        if (this.reward_unlock_type != null) {
            sb5.append(", reward_unlock_type=");
            sb5.append(this.reward_unlock_type);
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdNewUnlockInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdNewUnlockInfo(String str, int i3, RewardAdRewardUnlockType rewardAdRewardUnlockType, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.unlock_tips = str;
            this.lockStatus = i3;
            if (rewardAdRewardUnlockType != null) {
                this.reward_unlock_type = rewardAdRewardUnlockType;
                return;
            }
            throw new IllegalArgumentException("reward_unlock_type == null");
        }
        throw new IllegalArgumentException("unlock_tips == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383771a = this.unlock_tips;
        aVar.f383772b = this.lockStatus;
        aVar.f383773c = this.reward_unlock_type;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
