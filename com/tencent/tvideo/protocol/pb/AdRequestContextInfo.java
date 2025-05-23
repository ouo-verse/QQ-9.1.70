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
public final class AdRequestContextInfo extends Message<AdRequestContextInfo, a> {
    public static final ProtoAdapter<AdRequestContextInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFreeFlowItem#ADAPTER", jsonName = "adFreeFlowItem", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final AdFreeFlowItem ad_free_flow_item;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFreshInfo#ADAPTER", jsonName = "adFreshInfo", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdFreshInfo ad_fresh_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdRequestInfo#ADAPTER", jsonName = "adRequestInfo", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdRequestInfo ad_request_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdPlatformInfo#ADAPTER", jsonName = "platformInfo", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdPlatformInfo platform_info;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdRequestContextInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdFreshInfo f383699a;

        /* renamed from: b, reason: collision with root package name */
        public AdRequestInfo f383700b;

        /* renamed from: c, reason: collision with root package name */
        public AdPlatformInfo f383701c;

        /* renamed from: d, reason: collision with root package name */
        public AdFreeFlowItem f383702d;

        public a a(AdFreeFlowItem adFreeFlowItem) {
            this.f383702d = adFreeFlowItem;
            return this;
        }

        public a b(AdFreshInfo adFreshInfo) {
            this.f383699a = adFreshInfo;
            return this;
        }

        public a c(AdRequestInfo adRequestInfo) {
            this.f383700b = adRequestInfo;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdRequestContextInfo build() {
            return new AdRequestContextInfo(this.f383699a, this.f383700b, this.f383701c, this.f383702d, super.buildUnknownFields());
        }

        public a e(AdPlatformInfo adPlatformInfo) {
            this.f383701c = adPlatformInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdRequestContextInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdRequestContextInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdRequestContextInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdRequestContextInfo decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.a(AdFreeFlowItem.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.e(AdPlatformInfo.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.c(AdRequestInfo.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.b(AdFreshInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdRequestContextInfo adRequestContextInfo) throws IOException {
            if (!Objects.equals(adRequestContextInfo.ad_fresh_info, null)) {
                AdFreshInfo.ADAPTER.encodeWithTag(protoWriter, 1, adRequestContextInfo.ad_fresh_info);
            }
            if (!Objects.equals(adRequestContextInfo.ad_request_info, null)) {
                AdRequestInfo.ADAPTER.encodeWithTag(protoWriter, 2, adRequestContextInfo.ad_request_info);
            }
            if (!Objects.equals(adRequestContextInfo.platform_info, null)) {
                AdPlatformInfo.ADAPTER.encodeWithTag(protoWriter, 3, adRequestContextInfo.platform_info);
            }
            if (!Objects.equals(adRequestContextInfo.ad_free_flow_item, null)) {
                AdFreeFlowItem.ADAPTER.encodeWithTag(protoWriter, 4, adRequestContextInfo.ad_free_flow_item);
            }
            protoWriter.writeBytes(adRequestContextInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdRequestContextInfo adRequestContextInfo) {
            int i3 = 0;
            if (!Objects.equals(adRequestContextInfo.ad_fresh_info, null)) {
                i3 = 0 + AdFreshInfo.ADAPTER.encodedSizeWithTag(1, adRequestContextInfo.ad_fresh_info);
            }
            if (!Objects.equals(adRequestContextInfo.ad_request_info, null)) {
                i3 += AdRequestInfo.ADAPTER.encodedSizeWithTag(2, adRequestContextInfo.ad_request_info);
            }
            if (!Objects.equals(adRequestContextInfo.platform_info, null)) {
                i3 += AdPlatformInfo.ADAPTER.encodedSizeWithTag(3, adRequestContextInfo.platform_info);
            }
            if (!Objects.equals(adRequestContextInfo.ad_free_flow_item, null)) {
                i3 += AdFreeFlowItem.ADAPTER.encodedSizeWithTag(4, adRequestContextInfo.ad_free_flow_item);
            }
            return i3 + adRequestContextInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdRequestContextInfo redact(AdRequestContextInfo adRequestContextInfo) {
            a newBuilder = adRequestContextInfo.newBuilder();
            AdFreshInfo adFreshInfo = newBuilder.f383699a;
            if (adFreshInfo != null) {
                newBuilder.f383699a = AdFreshInfo.ADAPTER.redact(adFreshInfo);
            }
            AdRequestInfo adRequestInfo = newBuilder.f383700b;
            if (adRequestInfo != null) {
                newBuilder.f383700b = AdRequestInfo.ADAPTER.redact(adRequestInfo);
            }
            AdPlatformInfo adPlatformInfo = newBuilder.f383701c;
            if (adPlatformInfo != null) {
                newBuilder.f383701c = AdPlatformInfo.ADAPTER.redact(adPlatformInfo);
            }
            AdFreeFlowItem adFreeFlowItem = newBuilder.f383702d;
            if (adFreeFlowItem != null) {
                newBuilder.f383702d = AdFreeFlowItem.ADAPTER.redact(adFreeFlowItem);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdRequestContextInfo(AdFreshInfo adFreshInfo, AdRequestInfo adRequestInfo, AdPlatformInfo adPlatformInfo, AdFreeFlowItem adFreeFlowItem) {
        this(adFreshInfo, adRequestInfo, adPlatformInfo, adFreeFlowItem, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdRequestContextInfo)) {
            return false;
        }
        AdRequestContextInfo adRequestContextInfo = (AdRequestContextInfo) obj;
        if (unknownFields().equals(adRequestContextInfo.unknownFields()) && Internal.equals(this.ad_fresh_info, adRequestContextInfo.ad_fresh_info) && Internal.equals(this.ad_request_info, adRequestContextInfo.ad_request_info) && Internal.equals(this.platform_info, adRequestContextInfo.platform_info) && Internal.equals(this.ad_free_flow_item, adRequestContextInfo.ad_free_flow_item)) {
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
            AdFreshInfo adFreshInfo = this.ad_fresh_info;
            int i19 = 0;
            if (adFreshInfo != null) {
                i3 = adFreshInfo.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            AdRequestInfo adRequestInfo = this.ad_request_info;
            if (adRequestInfo != null) {
                i16 = adRequestInfo.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            AdPlatformInfo adPlatformInfo = this.platform_info;
            if (adPlatformInfo != null) {
                i17 = adPlatformInfo.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            AdFreeFlowItem adFreeFlowItem = this.ad_free_flow_item;
            if (adFreeFlowItem != null) {
                i19 = adFreeFlowItem.hashCode();
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
        if (this.ad_fresh_info != null) {
            sb5.append(", ad_fresh_info=");
            sb5.append(this.ad_fresh_info);
        }
        if (this.ad_request_info != null) {
            sb5.append(", ad_request_info=");
            sb5.append(this.ad_request_info);
        }
        if (this.platform_info != null) {
            sb5.append(", platform_info=");
            sb5.append(this.platform_info);
        }
        if (this.ad_free_flow_item != null) {
            sb5.append(", ad_free_flow_item=");
            sb5.append(this.ad_free_flow_item);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdRequestContextInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdRequestContextInfo(AdFreshInfo adFreshInfo, AdRequestInfo adRequestInfo, AdPlatformInfo adPlatformInfo, AdFreeFlowItem adFreeFlowItem, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_fresh_info = adFreshInfo;
        this.ad_request_info = adRequestInfo;
        this.platform_info = adPlatformInfo;
        this.ad_free_flow_item = adFreeFlowItem;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383699a = this.ad_fresh_info;
        aVar.f383700b = this.ad_request_info;
        aVar.f383701c = this.platform_info;
        aVar.f383702d = this.ad_free_flow_item;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
