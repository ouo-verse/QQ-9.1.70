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
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RewardAdUnlockInfo extends Message<RewardAdUnlockInfo, a> {
    public static final ProtoAdapter<RewardAdUnlockInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdPointItem#ADAPTER", jsonName = "adPointInfo", label = WireField.Label.REPEATED, tag = 1)
    public final List<RewardAdPointItem> ad_point_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int lockStatus;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String unlockTips;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdUnlockInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<RewardAdPointItem> f383802a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public String f383803b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f383804c = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdUnlockInfo build() {
            return new RewardAdUnlockInfo(this.f383802a, this.f383803b, this.f383804c, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f383804c = i3;
            return this;
        }

        public a c(String str) {
            this.f383803b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdUnlockInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdUnlockInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdUnlockInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardAdUnlockInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.f383802a.add(RewardAdPointItem.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdUnlockInfo rewardAdUnlockInfo) throws IOException {
            RewardAdPointItem.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, rewardAdUnlockInfo.ad_point_info);
            if (!Objects.equals(rewardAdUnlockInfo.unlockTips, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, rewardAdUnlockInfo.unlockTips);
            }
            if (!Objects.equals(Integer.valueOf(rewardAdUnlockInfo.lockStatus), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(rewardAdUnlockInfo.lockStatus));
            }
            protoWriter.writeBytes(rewardAdUnlockInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdUnlockInfo rewardAdUnlockInfo) {
            int encodedSizeWithTag = RewardAdPointItem.ADAPTER.asRepeated().encodedSizeWithTag(1, rewardAdUnlockInfo.ad_point_info) + 0;
            if (!Objects.equals(rewardAdUnlockInfo.unlockTips, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(2, rewardAdUnlockInfo.unlockTips);
            }
            if (!Objects.equals(Integer.valueOf(rewardAdUnlockInfo.lockStatus), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(rewardAdUnlockInfo.lockStatus));
            }
            return encodedSizeWithTag + rewardAdUnlockInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RewardAdUnlockInfo redact(RewardAdUnlockInfo rewardAdUnlockInfo) {
            a newBuilder = rewardAdUnlockInfo.newBuilder();
            Internal.redactElements(newBuilder.f383802a, RewardAdPointItem.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdUnlockInfo(List<RewardAdPointItem> list, String str, int i3) {
        this(list, str, i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdUnlockInfo)) {
            return false;
        }
        RewardAdUnlockInfo rewardAdUnlockInfo = (RewardAdUnlockInfo) obj;
        if (unknownFields().equals(rewardAdUnlockInfo.unknownFields()) && this.ad_point_info.equals(rewardAdUnlockInfo.ad_point_info) && Internal.equals(this.unlockTips, rewardAdUnlockInfo.unlockTips) && Internal.equals(Integer.valueOf(this.lockStatus), Integer.valueOf(rewardAdUnlockInfo.lockStatus))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.ad_point_info.hashCode()) * 37;
            String str = this.unlockTips;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = ((hashCode + i3) * 37) + this.lockStatus;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.ad_point_info.isEmpty()) {
            sb5.append(", ad_point_info=");
            sb5.append(this.ad_point_info);
        }
        if (this.unlockTips != null) {
            sb5.append(", unlockTips=");
            sb5.append(Internal.sanitize(this.unlockTips));
        }
        sb5.append(", lockStatus=");
        sb5.append(this.lockStatus);
        StringBuilder replace = sb5.replace(0, 2, "RewardAdUnlockInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdUnlockInfo(List<RewardAdPointItem> list, String str, int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_point_info = Internal.immutableCopyOf("ad_point_info", list);
        if (str != null) {
            this.unlockTips = str;
            this.lockStatus = i3;
            return;
        }
        throw new IllegalArgumentException("unlockTips == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383802a = Internal.copyOf(this.ad_point_info);
        aVar.f383803b = this.unlockTips;
        aVar.f383804c = this.lockStatus;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
