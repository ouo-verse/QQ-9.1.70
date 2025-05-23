package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes27.dex */
public final class AdImmersivePoster extends Message<AdImmersivePoster, a> {
    public static final ProtoAdapter<AdImmersivePoster> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdActionButton#ADAPTER", jsonName = "actionButton", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final AdActionButton action_button;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFloatCardInfo#ADAPTER", jsonName = "floatCardInfo", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AdFloatCardInfo float_card_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFeedHeaderInfo#ADAPTER", jsonName = "imageHeaderInfo", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final AdFeedHeaderInfo image_header_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdImmersiveType#ADAPTER", jsonName = "immersiveType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdImmersiveType immersive_type;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdPlayFinishMaskInfo#ADAPTER", jsonName = "maskInfo", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final AdPlayFinishMaskInfo mask_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdPoster#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdPoster poster;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFeedVideoInfo#ADAPTER", jsonName = QCircleScheme.AttrDetail.VIDEO_INFO, label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdFeedVideoInfo video_info;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdImmersivePoster, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdImmersiveType f383618a = AdImmersiveType.AD_IMMERSIVE_TYPE_UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        public AdPoster f383619b;

        /* renamed from: c, reason: collision with root package name */
        public AdFeedVideoInfo f383620c;

        /* renamed from: d, reason: collision with root package name */
        public AdActionButton f383621d;

        /* renamed from: e, reason: collision with root package name */
        public AdFloatCardInfo f383622e;

        /* renamed from: f, reason: collision with root package name */
        public AdPlayFinishMaskInfo f383623f;

        /* renamed from: g, reason: collision with root package name */
        public AdFeedHeaderInfo f383624g;

        public a a(AdActionButton adActionButton) {
            this.f383621d = adActionButton;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdImmersivePoster build() {
            return new AdImmersivePoster(this.f383618a, this.f383619b, this.f383620c, this.f383621d, this.f383622e, this.f383623f, this.f383624g, super.buildUnknownFields());
        }

        public a c(AdFloatCardInfo adFloatCardInfo) {
            this.f383622e = adFloatCardInfo;
            return this;
        }

        public a d(AdFeedHeaderInfo adFeedHeaderInfo) {
            this.f383624g = adFeedHeaderInfo;
            return this;
        }

        public a e(AdImmersiveType adImmersiveType) {
            this.f383618a = adImmersiveType;
            return this;
        }

        public a f(AdPlayFinishMaskInfo adPlayFinishMaskInfo) {
            this.f383623f = adPlayFinishMaskInfo;
            return this;
        }

        public a g(AdPoster adPoster) {
            this.f383619b = adPoster;
            return this;
        }

        public a h(AdFeedVideoInfo adFeedVideoInfo) {
            this.f383620c = adFeedVideoInfo;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdImmersivePoster> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdImmersivePoster.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdImmersivePoster", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdImmersivePoster decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            try {
                                aVar.e(AdImmersiveType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 2:
                            aVar.g(AdPoster.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            aVar.h(AdFeedVideoInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.a(AdActionButton.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(AdFloatCardInfo.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.f(AdPlayFinishMaskInfo.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            aVar.d(AdFeedHeaderInfo.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdImmersivePoster adImmersivePoster) throws IOException {
            if (!Objects.equals(adImmersivePoster.immersive_type, AdImmersiveType.AD_IMMERSIVE_TYPE_UNKNOWN)) {
                AdImmersiveType.ADAPTER.encodeWithTag(protoWriter, 1, adImmersivePoster.immersive_type);
            }
            if (!Objects.equals(adImmersivePoster.poster, null)) {
                AdPoster.ADAPTER.encodeWithTag(protoWriter, 2, adImmersivePoster.poster);
            }
            if (!Objects.equals(adImmersivePoster.video_info, null)) {
                AdFeedVideoInfo.ADAPTER.encodeWithTag(protoWriter, 3, adImmersivePoster.video_info);
            }
            if (!Objects.equals(adImmersivePoster.action_button, null)) {
                AdActionButton.ADAPTER.encodeWithTag(protoWriter, 4, adImmersivePoster.action_button);
            }
            if (!Objects.equals(adImmersivePoster.float_card_info, null)) {
                AdFloatCardInfo.ADAPTER.encodeWithTag(protoWriter, 5, adImmersivePoster.float_card_info);
            }
            if (!Objects.equals(adImmersivePoster.mask_info, null)) {
                AdPlayFinishMaskInfo.ADAPTER.encodeWithTag(protoWriter, 6, adImmersivePoster.mask_info);
            }
            if (!Objects.equals(adImmersivePoster.image_header_info, null)) {
                AdFeedHeaderInfo.ADAPTER.encodeWithTag(protoWriter, 7, adImmersivePoster.image_header_info);
            }
            protoWriter.writeBytes(adImmersivePoster.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdImmersivePoster adImmersivePoster) {
            int i3 = 0;
            if (!Objects.equals(adImmersivePoster.immersive_type, AdImmersiveType.AD_IMMERSIVE_TYPE_UNKNOWN)) {
                i3 = 0 + AdImmersiveType.ADAPTER.encodedSizeWithTag(1, adImmersivePoster.immersive_type);
            }
            if (!Objects.equals(adImmersivePoster.poster, null)) {
                i3 += AdPoster.ADAPTER.encodedSizeWithTag(2, adImmersivePoster.poster);
            }
            if (!Objects.equals(adImmersivePoster.video_info, null)) {
                i3 += AdFeedVideoInfo.ADAPTER.encodedSizeWithTag(3, adImmersivePoster.video_info);
            }
            if (!Objects.equals(adImmersivePoster.action_button, null)) {
                i3 += AdActionButton.ADAPTER.encodedSizeWithTag(4, adImmersivePoster.action_button);
            }
            if (!Objects.equals(adImmersivePoster.float_card_info, null)) {
                i3 += AdFloatCardInfo.ADAPTER.encodedSizeWithTag(5, adImmersivePoster.float_card_info);
            }
            if (!Objects.equals(adImmersivePoster.mask_info, null)) {
                i3 += AdPlayFinishMaskInfo.ADAPTER.encodedSizeWithTag(6, adImmersivePoster.mask_info);
            }
            if (!Objects.equals(adImmersivePoster.image_header_info, null)) {
                i3 += AdFeedHeaderInfo.ADAPTER.encodedSizeWithTag(7, adImmersivePoster.image_header_info);
            }
            return i3 + adImmersivePoster.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdImmersivePoster redact(AdImmersivePoster adImmersivePoster) {
            a newBuilder = adImmersivePoster.newBuilder();
            AdPoster adPoster = newBuilder.f383619b;
            if (adPoster != null) {
                newBuilder.f383619b = AdPoster.ADAPTER.redact(adPoster);
            }
            AdFeedVideoInfo adFeedVideoInfo = newBuilder.f383620c;
            if (adFeedVideoInfo != null) {
                newBuilder.f383620c = AdFeedVideoInfo.ADAPTER.redact(adFeedVideoInfo);
            }
            AdActionButton adActionButton = newBuilder.f383621d;
            if (adActionButton != null) {
                newBuilder.f383621d = AdActionButton.ADAPTER.redact(adActionButton);
            }
            AdFloatCardInfo adFloatCardInfo = newBuilder.f383622e;
            if (adFloatCardInfo != null) {
                newBuilder.f383622e = AdFloatCardInfo.ADAPTER.redact(adFloatCardInfo);
            }
            AdPlayFinishMaskInfo adPlayFinishMaskInfo = newBuilder.f383623f;
            if (adPlayFinishMaskInfo != null) {
                newBuilder.f383623f = AdPlayFinishMaskInfo.ADAPTER.redact(adPlayFinishMaskInfo);
            }
            AdFeedHeaderInfo adFeedHeaderInfo = newBuilder.f383624g;
            if (adFeedHeaderInfo != null) {
                newBuilder.f383624g = AdFeedHeaderInfo.ADAPTER.redact(adFeedHeaderInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdImmersivePoster(AdImmersiveType adImmersiveType, AdPoster adPoster, AdFeedVideoInfo adFeedVideoInfo, AdActionButton adActionButton, AdFloatCardInfo adFloatCardInfo, AdPlayFinishMaskInfo adPlayFinishMaskInfo, AdFeedHeaderInfo adFeedHeaderInfo) {
        this(adImmersiveType, adPoster, adFeedVideoInfo, adActionButton, adFloatCardInfo, adPlayFinishMaskInfo, adFeedHeaderInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdImmersivePoster)) {
            return false;
        }
        AdImmersivePoster adImmersivePoster = (AdImmersivePoster) obj;
        if (unknownFields().equals(adImmersivePoster.unknownFields()) && Internal.equals(this.immersive_type, adImmersivePoster.immersive_type) && Internal.equals(this.poster, adImmersivePoster.poster) && Internal.equals(this.video_info, adImmersivePoster.video_info) && Internal.equals(this.action_button, adImmersivePoster.action_button) && Internal.equals(this.float_card_info, adImmersivePoster.float_card_info) && Internal.equals(this.mask_info, adImmersivePoster.mask_info) && Internal.equals(this.image_header_info, adImmersivePoster.image_header_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27 = this.hashCode;
        if (i27 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdImmersiveType adImmersiveType = this.immersive_type;
            int i28 = 0;
            if (adImmersiveType != null) {
                i3 = adImmersiveType.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            AdPoster adPoster = this.poster;
            if (adPoster != null) {
                i16 = adPoster.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            AdFeedVideoInfo adFeedVideoInfo = this.video_info;
            if (adFeedVideoInfo != null) {
                i17 = adFeedVideoInfo.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 37;
            AdActionButton adActionButton = this.action_button;
            if (adActionButton != null) {
                i18 = adActionButton.hashCode();
            } else {
                i18 = 0;
            }
            int i38 = (i37 + i18) * 37;
            AdFloatCardInfo adFloatCardInfo = this.float_card_info;
            if (adFloatCardInfo != null) {
                i19 = adFloatCardInfo.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (i38 + i19) * 37;
            AdPlayFinishMaskInfo adPlayFinishMaskInfo = this.mask_info;
            if (adPlayFinishMaskInfo != null) {
                i26 = adPlayFinishMaskInfo.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 37;
            AdFeedHeaderInfo adFeedHeaderInfo = this.image_header_info;
            if (adFeedHeaderInfo != null) {
                i28 = adFeedHeaderInfo.hashCode();
            }
            int i47 = i46 + i28;
            this.hashCode = i47;
            return i47;
        }
        return i27;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.immersive_type != null) {
            sb5.append(", immersive_type=");
            sb5.append(this.immersive_type);
        }
        if (this.poster != null) {
            sb5.append(", poster=");
            sb5.append(this.poster);
        }
        if (this.video_info != null) {
            sb5.append(", video_info=");
            sb5.append(this.video_info);
        }
        if (this.action_button != null) {
            sb5.append(", action_button=");
            sb5.append(this.action_button);
        }
        if (this.float_card_info != null) {
            sb5.append(", float_card_info=");
            sb5.append(this.float_card_info);
        }
        if (this.mask_info != null) {
            sb5.append(", mask_info=");
            sb5.append(this.mask_info);
        }
        if (this.image_header_info != null) {
            sb5.append(", image_header_info=");
            sb5.append(this.image_header_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdImmersivePoster{");
        replace.append('}');
        return replace.toString();
    }

    public AdImmersivePoster(AdImmersiveType adImmersiveType, AdPoster adPoster, AdFeedVideoInfo adFeedVideoInfo, AdActionButton adActionButton, AdFloatCardInfo adFloatCardInfo, AdPlayFinishMaskInfo adPlayFinishMaskInfo, AdFeedHeaderInfo adFeedHeaderInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        if (adImmersiveType != null) {
            this.immersive_type = adImmersiveType;
            this.poster = adPoster;
            this.video_info = adFeedVideoInfo;
            this.action_button = adActionButton;
            this.float_card_info = adFloatCardInfo;
            this.mask_info = adPlayFinishMaskInfo;
            this.image_header_info = adFeedHeaderInfo;
            return;
        }
        throw new IllegalArgumentException("immersive_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383618a = this.immersive_type;
        aVar.f383619b = this.poster;
        aVar.f383620c = this.video_info;
        aVar.f383621d = this.action_button;
        aVar.f383622e = this.float_card_info;
        aVar.f383623f = this.mask_info;
        aVar.f383624g = this.image_header_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
