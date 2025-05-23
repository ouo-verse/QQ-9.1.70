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

/* loaded from: classes27.dex */
public final class RewardAdNewPlayResponse extends Message<RewardAdNewPlayResponse, a> {
    public static final ProtoAdapter<RewardAdNewPlayResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo#ADAPTER", jsonName = "unlockedInfo", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RewardAdNewUnlockInfo unlocked_info;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdNewPlayResponse, a> {

        /* renamed from: a, reason: collision with root package name */
        public RewardAdNewUnlockInfo f383770a;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewPlayResponse build() {
            return new RewardAdNewPlayResponse(this.f383770a, super.buildUnknownFields());
        }

        public a b(RewardAdNewUnlockInfo rewardAdNewUnlockInfo) {
            this.f383770a = rewardAdNewUnlockInfo;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdNewPlayResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdNewPlayResponse.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdNewPlayResponse", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdNewPlayResponse decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.b(RewardAdNewUnlockInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdNewPlayResponse rewardAdNewPlayResponse) throws IOException {
            if (!Objects.equals(rewardAdNewPlayResponse.unlocked_info, null)) {
                RewardAdNewUnlockInfo.ADAPTER.encodeWithTag(protoWriter, 1, rewardAdNewPlayResponse.unlocked_info);
            }
            protoWriter.writeBytes(rewardAdNewPlayResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdNewPlayResponse rewardAdNewPlayResponse) {
            int i3 = 0;
            if (!Objects.equals(rewardAdNewPlayResponse.unlocked_info, null)) {
                i3 = 0 + RewardAdNewUnlockInfo.ADAPTER.encodedSizeWithTag(1, rewardAdNewPlayResponse.unlocked_info);
            }
            return i3 + rewardAdNewPlayResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdNewPlayResponse redact(RewardAdNewPlayResponse rewardAdNewPlayResponse) {
            a newBuilder = rewardAdNewPlayResponse.newBuilder();
            RewardAdNewUnlockInfo rewardAdNewUnlockInfo = newBuilder.f383770a;
            if (rewardAdNewUnlockInfo != null) {
                newBuilder.f383770a = RewardAdNewUnlockInfo.ADAPTER.redact(rewardAdNewUnlockInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdNewPlayResponse(RewardAdNewUnlockInfo rewardAdNewUnlockInfo) {
        this(rewardAdNewUnlockInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdNewPlayResponse)) {
            return false;
        }
        RewardAdNewPlayResponse rewardAdNewPlayResponse = (RewardAdNewPlayResponse) obj;
        if (unknownFields().equals(rewardAdNewPlayResponse.unknownFields()) && Internal.equals(this.unlocked_info, rewardAdNewPlayResponse.unlocked_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RewardAdNewUnlockInfo rewardAdNewUnlockInfo = this.unlocked_info;
            if (rewardAdNewUnlockInfo != null) {
                i3 = rewardAdNewUnlockInfo.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.unlocked_info != null) {
            sb5.append(", unlocked_info=");
            sb5.append(this.unlocked_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdNewPlayResponse{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdNewPlayResponse(RewardAdNewUnlockInfo rewardAdNewUnlockInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.unlocked_info = rewardAdNewUnlockInfo;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383770a = this.unlocked_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
