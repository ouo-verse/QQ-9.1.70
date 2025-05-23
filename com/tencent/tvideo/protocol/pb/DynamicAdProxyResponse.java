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
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes27.dex */
public final class DynamicAdProxyResponse extends Message<DynamicAdProxyResponse, a> {
    public static final ProtoAdapter<DynamicAdProxyResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdType#ADAPTER", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdType ad_type;

    @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "midAdResponse", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AnyMessage mid_ad_response;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdType#ADAPTER", jsonName = "nextAdType", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final AdType next_ad_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "requestInterval", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final long request_interval;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.SegmentRewardItem#ADAPTER", jsonName = "segmentRewardItem", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final SegmentRewardItem segment_reward_item;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "stopTiming", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final boolean stop_timing;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "strategyParams", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final Map<String, String> strategy_params;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<DynamicAdProxyResponse, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdType f383737a;

        /* renamed from: b, reason: collision with root package name */
        public long f383738b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f383739c;

        /* renamed from: d, reason: collision with root package name */
        public SegmentRewardItem f383740d;

        /* renamed from: e, reason: collision with root package name */
        public AnyMessage f383741e;

        /* renamed from: f, reason: collision with root package name */
        public AdType f383742f;

        /* renamed from: g, reason: collision with root package name */
        public Map<String, String> f383743g;

        public a() {
            AdType adType = AdType.AD_TYPE_UNKNOWN;
            this.f383737a = adType;
            this.f383738b = 0L;
            this.f383739c = false;
            this.f383742f = adType;
            this.f383743g = Internal.newMutableMap();
        }

        public a a(AdType adType) {
            this.f383737a = adType;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DynamicAdProxyResponse build() {
            return new DynamicAdProxyResponse(this.f383737a, this.f383738b, this.f383739c, this.f383740d, this.f383741e, this.f383742f, this.f383743g, super.buildUnknownFields());
        }

        public a c(AnyMessage anyMessage) {
            this.f383741e = anyMessage;
            return this;
        }

        public a d(AdType adType) {
            this.f383742f = adType;
            return this;
        }

        public a e(long j3) {
            this.f383738b = j3;
            return this;
        }

        public a f(SegmentRewardItem segmentRewardItem) {
            this.f383740d = segmentRewardItem;
            return this;
        }

        public a g(boolean z16) {
            this.f383739c = z16;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<DynamicAdProxyResponse> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383744a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DynamicAdProxyResponse.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.DynamicAdProxyResponse", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383744a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383744a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicAdProxyResponse decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            try {
                                aVar.a(AdType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 2:
                            aVar.e(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 3:
                            aVar.g(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            break;
                        case 4:
                            aVar.f(SegmentRewardItem.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(AnyMessage.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            try {
                                aVar.d(AdType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                break;
                            }
                        case 7:
                            aVar.f383743g.putAll(e().decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, DynamicAdProxyResponse dynamicAdProxyResponse) throws IOException {
            AdType adType = dynamicAdProxyResponse.ad_type;
            AdType adType2 = AdType.AD_TYPE_UNKNOWN;
            if (!Objects.equals(adType, adType2)) {
                AdType.ADAPTER.encodeWithTag(protoWriter, 1, dynamicAdProxyResponse.ad_type);
            }
            if (!Objects.equals(Long.valueOf(dynamicAdProxyResponse.request_interval), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, Long.valueOf(dynamicAdProxyResponse.request_interval));
            }
            if (!Objects.equals(Boolean.valueOf(dynamicAdProxyResponse.stop_timing), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, Boolean.valueOf(dynamicAdProxyResponse.stop_timing));
            }
            if (!Objects.equals(dynamicAdProxyResponse.segment_reward_item, null)) {
                SegmentRewardItem.ADAPTER.encodeWithTag(protoWriter, 4, dynamicAdProxyResponse.segment_reward_item);
            }
            if (!Objects.equals(dynamicAdProxyResponse.mid_ad_response, null)) {
                AnyMessage.ADAPTER.encodeWithTag(protoWriter, 5, dynamicAdProxyResponse.mid_ad_response);
            }
            if (!Objects.equals(dynamicAdProxyResponse.next_ad_type, adType2)) {
                AdType.ADAPTER.encodeWithTag(protoWriter, 6, dynamicAdProxyResponse.next_ad_type);
            }
            e().encodeWithTag(protoWriter, 7, dynamicAdProxyResponse.strategy_params);
            protoWriter.writeBytes(dynamicAdProxyResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(DynamicAdProxyResponse dynamicAdProxyResponse) {
            AdType adType = dynamicAdProxyResponse.ad_type;
            AdType adType2 = AdType.AD_TYPE_UNKNOWN;
            int i3 = 0;
            if (!Objects.equals(adType, adType2)) {
                i3 = 0 + AdType.ADAPTER.encodedSizeWithTag(1, dynamicAdProxyResponse.ad_type);
            }
            if (!Objects.equals(Long.valueOf(dynamicAdProxyResponse.request_interval), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(dynamicAdProxyResponse.request_interval));
            }
            if (!Objects.equals(Boolean.valueOf(dynamicAdProxyResponse.stop_timing), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(dynamicAdProxyResponse.stop_timing));
            }
            if (!Objects.equals(dynamicAdProxyResponse.segment_reward_item, null)) {
                i3 += SegmentRewardItem.ADAPTER.encodedSizeWithTag(4, dynamicAdProxyResponse.segment_reward_item);
            }
            if (!Objects.equals(dynamicAdProxyResponse.mid_ad_response, null)) {
                i3 += AnyMessage.ADAPTER.encodedSizeWithTag(5, dynamicAdProxyResponse.mid_ad_response);
            }
            if (!Objects.equals(dynamicAdProxyResponse.next_ad_type, adType2)) {
                i3 += AdType.ADAPTER.encodedSizeWithTag(6, dynamicAdProxyResponse.next_ad_type);
            }
            return i3 + e().encodedSizeWithTag(7, dynamicAdProxyResponse.strategy_params) + dynamicAdProxyResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DynamicAdProxyResponse redact(DynamicAdProxyResponse dynamicAdProxyResponse) {
            a newBuilder = dynamicAdProxyResponse.newBuilder();
            SegmentRewardItem segmentRewardItem = newBuilder.f383740d;
            if (segmentRewardItem != null) {
                newBuilder.f383740d = SegmentRewardItem.ADAPTER.redact(segmentRewardItem);
            }
            AnyMessage anyMessage = newBuilder.f383741e;
            if (anyMessage != null) {
                newBuilder.f383741e = AnyMessage.ADAPTER.redact(anyMessage);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public DynamicAdProxyResponse(AdType adType, long j3, boolean z16, SegmentRewardItem segmentRewardItem, AnyMessage anyMessage, AdType adType2, Map<String, String> map) {
        this(adType, j3, z16, segmentRewardItem, anyMessage, adType2, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicAdProxyResponse)) {
            return false;
        }
        DynamicAdProxyResponse dynamicAdProxyResponse = (DynamicAdProxyResponse) obj;
        if (unknownFields().equals(dynamicAdProxyResponse.unknownFields()) && Internal.equals(this.ad_type, dynamicAdProxyResponse.ad_type) && Internal.equals(Long.valueOf(this.request_interval), Long.valueOf(dynamicAdProxyResponse.request_interval)) && Internal.equals(Boolean.valueOf(this.stop_timing), Boolean.valueOf(dynamicAdProxyResponse.stop_timing)) && Internal.equals(this.segment_reward_item, dynamicAdProxyResponse.segment_reward_item) && Internal.equals(this.mid_ad_response, dynamicAdProxyResponse.mid_ad_response) && Internal.equals(this.next_ad_type, dynamicAdProxyResponse.next_ad_type) && this.strategy_params.equals(dynamicAdProxyResponse.strategy_params)) {
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
            AdType adType = this.ad_type;
            int i19 = 0;
            if (adType != null) {
                i3 = adType.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = (((((hashCode + i3) * 37) + androidx.fragment.app.a.a(this.request_interval)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.stop_timing)) * 37;
            SegmentRewardItem segmentRewardItem = this.segment_reward_item;
            if (segmentRewardItem != null) {
                i16 = segmentRewardItem.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (a16 + i16) * 37;
            AnyMessage anyMessage = this.mid_ad_response;
            if (anyMessage != null) {
                i17 = anyMessage.hashCode();
            } else {
                i17 = 0;
            }
            int i27 = (i26 + i17) * 37;
            AdType adType2 = this.next_ad_type;
            if (adType2 != null) {
                i19 = adType2.hashCode();
            }
            int hashCode2 = ((i27 + i19) * 37) + this.strategy_params.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.ad_type != null) {
            sb5.append(", ad_type=");
            sb5.append(this.ad_type);
        }
        sb5.append(", request_interval=");
        sb5.append(this.request_interval);
        sb5.append(", stop_timing=");
        sb5.append(this.stop_timing);
        if (this.segment_reward_item != null) {
            sb5.append(", segment_reward_item=");
            sb5.append(this.segment_reward_item);
        }
        if (this.mid_ad_response != null) {
            sb5.append(", mid_ad_response=");
            sb5.append(this.mid_ad_response);
        }
        if (this.next_ad_type != null) {
            sb5.append(", next_ad_type=");
            sb5.append(this.next_ad_type);
        }
        if (!this.strategy_params.isEmpty()) {
            sb5.append(", strategy_params=");
            sb5.append(this.strategy_params);
        }
        StringBuilder replace = sb5.replace(0, 2, "DynamicAdProxyResponse{");
        replace.append('}');
        return replace.toString();
    }

    public DynamicAdProxyResponse(AdType adType, long j3, boolean z16, SegmentRewardItem segmentRewardItem, AnyMessage anyMessage, AdType adType2, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        if (adType != null) {
            this.ad_type = adType;
            this.request_interval = j3;
            this.stop_timing = z16;
            this.segment_reward_item = segmentRewardItem;
            this.mid_ad_response = anyMessage;
            if (adType2 != null) {
                this.next_ad_type = adType2;
                this.strategy_params = Internal.immutableCopyOf("strategy_params", map);
                return;
            }
            throw new IllegalArgumentException("next_ad_type == null");
        }
        throw new IllegalArgumentException("ad_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383737a = this.ad_type;
        aVar.f383738b = this.request_interval;
        aVar.f383739c = this.stop_timing;
        aVar.f383740d = this.segment_reward_item;
        aVar.f383741e = this.mid_ad_response;
        aVar.f383742f = this.next_ad_type;
        aVar.f383743g = Internal.copyOf(this.strategy_params);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
