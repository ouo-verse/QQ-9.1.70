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
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes27.dex */
public final class DynamicAdProxyRequest extends Message<DynamicAdProxyRequest, a> {
    public static final ProtoAdapter<DynamicAdProxyRequest> ADAPTER = new b();
    public static final String PB_METHOD_NAME = "GetAds";
    public static final String PB_PACKAGE_NAME = "com.tencent.tvideo.protocol.pb";
    public static final String PB_SERVICE_NAME = "QQDynamicAdService";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.ExtraVideoInfo#ADAPTER", jsonName = "lastVideoInfo", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final ExtraVideoInfo last_video_info;

    @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "midAdRequest", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final AnyMessage mid_ad_request;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String request_id;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.RequestType#ADAPTER", jsonName = "requestType", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final RequestType request_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "strategyParams", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> strategy_params;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "totalPlayTime", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final long total_play_time;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.ADVideoInfo#ADAPTER", jsonName = QCircleScheme.AttrDetail.VIDEO_INFO, label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final ADVideoInfo video_info;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<DynamicAdProxyRequest, a> {

        /* renamed from: c, reason: collision with root package name */
        public ADVideoInfo f383731c;

        /* renamed from: d, reason: collision with root package name */
        public ExtraVideoInfo f383732d;

        /* renamed from: g, reason: collision with root package name */
        public AnyMessage f383735g;

        /* renamed from: a, reason: collision with root package name */
        public String f383729a = "";

        /* renamed from: b, reason: collision with root package name */
        public RequestType f383730b = RequestType.REQUEST_TYPE_UNKNOWN;

        /* renamed from: e, reason: collision with root package name */
        public long f383733e = 0;

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f383734f = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicAdProxyRequest build() {
            return new DynamicAdProxyRequest(this.f383729a, this.f383730b, this.f383731c, this.f383732d, this.f383733e, this.f383734f, this.f383735g, super.buildUnknownFields());
        }

        public a b(ExtraVideoInfo extraVideoInfo) {
            this.f383732d = extraVideoInfo;
            return this;
        }

        public a c(AnyMessage anyMessage) {
            this.f383735g = anyMessage;
            return this;
        }

        public a d(String str) {
            this.f383729a = str;
            return this;
        }

        public a e(RequestType requestType) {
            this.f383730b = requestType;
            return this;
        }

        public a f(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f383734f = map;
            return this;
        }

        public a g(long j3) {
            this.f383733e = j3;
            return this;
        }

        public a h(ADVideoInfo aDVideoInfo) {
            this.f383731c = aDVideoInfo;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<DynamicAdProxyRequest> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383736a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DynamicAdProxyRequest.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.DynamicAdProxyRequest", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383736a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383736a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicAdProxyRequest decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            try {
                                aVar.e(RequestType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 3:
                            aVar.h(ADVideoInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.b(ExtraVideoInfo.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.g(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 6:
                            aVar.f383734f.putAll(e().decode(protoReader));
                            break;
                        case 7:
                            aVar.c(AnyMessage.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, DynamicAdProxyRequest dynamicAdProxyRequest) throws IOException {
            if (!Objects.equals(dynamicAdProxyRequest.request_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, dynamicAdProxyRequest.request_id);
            }
            if (!Objects.equals(dynamicAdProxyRequest.request_type, RequestType.REQUEST_TYPE_UNKNOWN)) {
                RequestType.ADAPTER.encodeWithTag(protoWriter, 2, dynamicAdProxyRequest.request_type);
            }
            if (!Objects.equals(dynamicAdProxyRequest.video_info, null)) {
                ADVideoInfo.ADAPTER.encodeWithTag(protoWriter, 3, dynamicAdProxyRequest.video_info);
            }
            if (!Objects.equals(dynamicAdProxyRequest.last_video_info, null)) {
                ExtraVideoInfo.ADAPTER.encodeWithTag(protoWriter, 4, dynamicAdProxyRequest.last_video_info);
            }
            if (!Objects.equals(Long.valueOf(dynamicAdProxyRequest.total_play_time), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, Long.valueOf(dynamicAdProxyRequest.total_play_time));
            }
            e().encodeWithTag(protoWriter, 6, dynamicAdProxyRequest.strategy_params);
            if (!Objects.equals(dynamicAdProxyRequest.mid_ad_request, null)) {
                AnyMessage.ADAPTER.encodeWithTag(protoWriter, 7, dynamicAdProxyRequest.mid_ad_request);
            }
            protoWriter.writeBytes(dynamicAdProxyRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(DynamicAdProxyRequest dynamicAdProxyRequest) {
            int i3 = 0;
            if (!Objects.equals(dynamicAdProxyRequest.request_id, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, dynamicAdProxyRequest.request_id);
            }
            if (!Objects.equals(dynamicAdProxyRequest.request_type, RequestType.REQUEST_TYPE_UNKNOWN)) {
                i3 += RequestType.ADAPTER.encodedSizeWithTag(2, dynamicAdProxyRequest.request_type);
            }
            if (!Objects.equals(dynamicAdProxyRequest.video_info, null)) {
                i3 += ADVideoInfo.ADAPTER.encodedSizeWithTag(3, dynamicAdProxyRequest.video_info);
            }
            if (!Objects.equals(dynamicAdProxyRequest.last_video_info, null)) {
                i3 += ExtraVideoInfo.ADAPTER.encodedSizeWithTag(4, dynamicAdProxyRequest.last_video_info);
            }
            if (!Objects.equals(Long.valueOf(dynamicAdProxyRequest.total_play_time), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(5, Long.valueOf(dynamicAdProxyRequest.total_play_time));
            }
            int encodedSizeWithTag = i3 + e().encodedSizeWithTag(6, dynamicAdProxyRequest.strategy_params);
            if (!Objects.equals(dynamicAdProxyRequest.mid_ad_request, null)) {
                encodedSizeWithTag += AnyMessage.ADAPTER.encodedSizeWithTag(7, dynamicAdProxyRequest.mid_ad_request);
            }
            return encodedSizeWithTag + dynamicAdProxyRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DynamicAdProxyRequest redact(DynamicAdProxyRequest dynamicAdProxyRequest) {
            a newBuilder = dynamicAdProxyRequest.newBuilder();
            ADVideoInfo aDVideoInfo = newBuilder.f383731c;
            if (aDVideoInfo != null) {
                newBuilder.f383731c = ADVideoInfo.ADAPTER.redact(aDVideoInfo);
            }
            ExtraVideoInfo extraVideoInfo = newBuilder.f383732d;
            if (extraVideoInfo != null) {
                newBuilder.f383732d = ExtraVideoInfo.ADAPTER.redact(extraVideoInfo);
            }
            AnyMessage anyMessage = newBuilder.f383735g;
            if (anyMessage != null) {
                newBuilder.f383735g = AnyMessage.ADAPTER.redact(anyMessage);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public DynamicAdProxyRequest(String str, RequestType requestType, ADVideoInfo aDVideoInfo, ExtraVideoInfo extraVideoInfo, long j3, Map<String, String> map, AnyMessage anyMessage) {
        this(str, requestType, aDVideoInfo, extraVideoInfo, j3, map, anyMessage, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicAdProxyRequest)) {
            return false;
        }
        DynamicAdProxyRequest dynamicAdProxyRequest = (DynamicAdProxyRequest) obj;
        if (unknownFields().equals(dynamicAdProxyRequest.unknownFields()) && Internal.equals(this.request_id, dynamicAdProxyRequest.request_id) && Internal.equals(this.request_type, dynamicAdProxyRequest.request_type) && Internal.equals(this.video_info, dynamicAdProxyRequest.video_info) && Internal.equals(this.last_video_info, dynamicAdProxyRequest.last_video_info) && Internal.equals(Long.valueOf(this.total_play_time), Long.valueOf(dynamicAdProxyRequest.total_play_time)) && this.strategy_params.equals(dynamicAdProxyRequest.strategy_params) && Internal.equals(this.mid_ad_request, dynamicAdProxyRequest.mid_ad_request)) {
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
            String str = this.request_id;
            int i26 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            RequestType requestType = this.request_type;
            if (requestType != null) {
                i16 = requestType.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            ADVideoInfo aDVideoInfo = this.video_info;
            if (aDVideoInfo != null) {
                i17 = aDVideoInfo.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            ExtraVideoInfo extraVideoInfo = this.last_video_info;
            if (extraVideoInfo != null) {
                i18 = extraVideoInfo.hashCode();
            } else {
                i18 = 0;
            }
            int a16 = (((((i29 + i18) * 37) + androidx.fragment.app.a.a(this.total_play_time)) * 37) + this.strategy_params.hashCode()) * 37;
            AnyMessage anyMessage = this.mid_ad_request;
            if (anyMessage != null) {
                i26 = anyMessage.hashCode();
            }
            int i36 = a16 + i26;
            this.hashCode = i36;
            return i36;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.request_id != null) {
            sb5.append(", request_id=");
            sb5.append(Internal.sanitize(this.request_id));
        }
        if (this.request_type != null) {
            sb5.append(", request_type=");
            sb5.append(this.request_type);
        }
        if (this.video_info != null) {
            sb5.append(", video_info=");
            sb5.append(this.video_info);
        }
        if (this.last_video_info != null) {
            sb5.append(", last_video_info=");
            sb5.append(this.last_video_info);
        }
        sb5.append(", total_play_time=");
        sb5.append(this.total_play_time);
        if (!this.strategy_params.isEmpty()) {
            sb5.append(", strategy_params=");
            sb5.append(this.strategy_params);
        }
        if (this.mid_ad_request != null) {
            sb5.append(", mid_ad_request=");
            sb5.append(this.mid_ad_request);
        }
        StringBuilder replace = sb5.replace(0, 2, "DynamicAdProxyRequest{");
        replace.append('}');
        return replace.toString();
    }

    public DynamicAdProxyRequest(String str, RequestType requestType, ADVideoInfo aDVideoInfo, ExtraVideoInfo extraVideoInfo, long j3, Map<String, String> map, AnyMessage anyMessage, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.request_id = str;
            if (requestType != null) {
                this.request_type = requestType;
                this.video_info = aDVideoInfo;
                this.last_video_info = extraVideoInfo;
                this.total_play_time = j3;
                this.strategy_params = Internal.immutableCopyOf("strategy_params", map);
                this.mid_ad_request = anyMessage;
                return;
            }
            throw new IllegalArgumentException("request_type == null");
        }
        throw new IllegalArgumentException("request_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383729a = this.request_id;
        aVar.f383730b = this.request_type;
        aVar.f383731c = this.video_info;
        aVar.f383732d = this.last_video_info;
        aVar.f383733e = this.total_play_time;
        aVar.f383734f = Internal.copyOf(this.strategy_params);
        aVar.f383735g = this.mid_ad_request;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
