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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RewardAdInfo extends Message<RewardAdInfo, a> {
    public static final ProtoAdapter<RewardAdInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdAction#ADAPTER", jsonName = "actionDict", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Map<Integer, AdAction> action_dict;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adExtraDict", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> ad_extra_dict;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RewardAdItem#ADAPTER", jsonName = "adRewardItem", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RewardAdItem ad_reward_item;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdOrderItem#ADAPTER", jsonName = "orderItem", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdOrderItem order_item;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<RewardAdInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public RewardAdItem f383752a;

        /* renamed from: b, reason: collision with root package name */
        public AdOrderItem f383753b;

        /* renamed from: c, reason: collision with root package name */
        public Map<Integer, AdAction> f383754c = Internal.newMutableMap();

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String> f383755d = Internal.newMutableMap();

        public a a(RewardAdItem rewardAdItem) {
            this.f383752a = rewardAdItem;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RewardAdInfo build() {
            return new RewardAdInfo(this.f383752a, this.f383753b, this.f383754c, this.f383755d, super.buildUnknownFields());
        }

        public a c(AdOrderItem adOrderItem) {
            this.f383753b = adOrderItem;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<RewardAdInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<Integer, AdAction>> f383756a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383757b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RewardAdInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.RewardAdInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<Integer, AdAction>> a() {
            ProtoAdapter<Map<Integer, AdAction>> protoAdapter = this.f383756a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<Integer, AdAction>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, AdAction.ADAPTER);
                this.f383756a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        private ProtoAdapter<Map<String, String>> b() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383757b;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383757b = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public RewardAdInfo decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.f383755d.putAll(b().decode(protoReader));
                                }
                            } else {
                                aVar.f383754c.putAll(a().decode(protoReader));
                            }
                        } else {
                            aVar.c(AdOrderItem.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.a(RewardAdItem.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RewardAdInfo rewardAdInfo) throws IOException {
            if (!Objects.equals(rewardAdInfo.ad_reward_item, null)) {
                RewardAdItem.ADAPTER.encodeWithTag(protoWriter, 1, rewardAdInfo.ad_reward_item);
            }
            if (!Objects.equals(rewardAdInfo.order_item, null)) {
                AdOrderItem.ADAPTER.encodeWithTag(protoWriter, 2, rewardAdInfo.order_item);
            }
            a().encodeWithTag(protoWriter, 3, rewardAdInfo.action_dict);
            b().encodeWithTag(protoWriter, 4, rewardAdInfo.ad_extra_dict);
            protoWriter.writeBytes(rewardAdInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RewardAdInfo rewardAdInfo) {
            int i3 = 0;
            if (!Objects.equals(rewardAdInfo.ad_reward_item, null)) {
                i3 = 0 + RewardAdItem.ADAPTER.encodedSizeWithTag(1, rewardAdInfo.ad_reward_item);
            }
            if (!Objects.equals(rewardAdInfo.order_item, null)) {
                i3 += AdOrderItem.ADAPTER.encodedSizeWithTag(2, rewardAdInfo.order_item);
            }
            return i3 + a().encodedSizeWithTag(3, rewardAdInfo.action_dict) + b().encodedSizeWithTag(4, rewardAdInfo.ad_extra_dict) + rewardAdInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public RewardAdInfo redact(RewardAdInfo rewardAdInfo) {
            a newBuilder = rewardAdInfo.newBuilder();
            RewardAdItem rewardAdItem = newBuilder.f383752a;
            if (rewardAdItem != null) {
                newBuilder.f383752a = RewardAdItem.ADAPTER.redact(rewardAdItem);
            }
            AdOrderItem adOrderItem = newBuilder.f383753b;
            if (adOrderItem != null) {
                newBuilder.f383753b = AdOrderItem.ADAPTER.redact(adOrderItem);
            }
            Internal.redactElements(newBuilder.f383754c, AdAction.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RewardAdInfo(RewardAdItem rewardAdItem, AdOrderItem adOrderItem, Map<Integer, AdAction> map, Map<String, String> map2) {
        this(rewardAdItem, adOrderItem, map, map2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RewardAdInfo)) {
            return false;
        }
        RewardAdInfo rewardAdInfo = (RewardAdInfo) obj;
        if (unknownFields().equals(rewardAdInfo.unknownFields()) && Internal.equals(this.ad_reward_item, rewardAdInfo.ad_reward_item) && Internal.equals(this.order_item, rewardAdInfo.order_item) && this.action_dict.equals(rewardAdInfo.action_dict) && this.ad_extra_dict.equals(rewardAdInfo.ad_extra_dict)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RewardAdItem rewardAdItem = this.ad_reward_item;
            int i17 = 0;
            if (rewardAdItem != null) {
                i3 = rewardAdItem.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            AdOrderItem adOrderItem = this.order_item;
            if (adOrderItem != null) {
                i17 = adOrderItem.hashCode();
            }
            int hashCode2 = ((((i18 + i17) * 37) + this.action_dict.hashCode()) * 37) + this.ad_extra_dict.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.ad_reward_item != null) {
            sb5.append(", ad_reward_item=");
            sb5.append(this.ad_reward_item);
        }
        if (this.order_item != null) {
            sb5.append(", order_item=");
            sb5.append(this.order_item);
        }
        if (!this.action_dict.isEmpty()) {
            sb5.append(", action_dict=");
            sb5.append(this.action_dict);
        }
        if (!this.ad_extra_dict.isEmpty()) {
            sb5.append(", ad_extra_dict=");
            sb5.append(this.ad_extra_dict);
        }
        StringBuilder replace = sb5.replace(0, 2, "RewardAdInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RewardAdInfo(RewardAdItem rewardAdItem, AdOrderItem adOrderItem, Map<Integer, AdAction> map, Map<String, String> map2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_reward_item = rewardAdItem;
        this.order_item = adOrderItem;
        this.action_dict = Internal.immutableCopyOf("action_dict", map);
        this.ad_extra_dict = Internal.immutableCopyOf("ad_extra_dict", map2);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383752a = this.ad_reward_item;
        aVar.f383753b = this.order_item;
        aVar.f383754c = Internal.copyOf(this.action_dict);
        aVar.f383755d = Internal.copyOf(this.ad_extra_dict);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
