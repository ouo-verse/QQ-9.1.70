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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdFeedInfo extends Message<AdFeedInfo, a> {
    public static final ProtoAdapter<AdFeedInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdAction#ADAPTER", jsonName = "actionDict", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Map<Integer, AdAction> action_dict;

    @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AnyMessage data;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFeedStyle#ADAPTER", jsonName = "feedStyle", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdFeedStyle feed_style;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdOrderItem#ADAPTER", jsonName = "orderItem", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdOrderItem order_item;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFeedInfo, a> {

        /* renamed from: b, reason: collision with root package name */
        public AnyMessage f383585b;

        /* renamed from: c, reason: collision with root package name */
        public AdOrderItem f383586c;

        /* renamed from: a, reason: collision with root package name */
        public AdFeedStyle f383584a = AdFeedStyle.AD_FEED_STYLE_NONE;

        /* renamed from: d, reason: collision with root package name */
        public Map<Integer, AdAction> f383587d = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedInfo build() {
            return new AdFeedInfo(this.f383584a, this.f383585b, this.f383586c, this.f383587d, super.buildUnknownFields());
        }

        public a b(AnyMessage anyMessage) {
            this.f383585b = anyMessage;
            return this;
        }

        public a c(AdFeedStyle adFeedStyle) {
            this.f383584a = adFeedStyle;
            return this;
        }

        public a d(AdOrderItem adOrderItem) {
            this.f383586c = adOrderItem;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFeedInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<Integer, AdAction>> f383588a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFeedInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFeedInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<Integer, AdAction>> a() {
            ProtoAdapter<Map<Integer, AdAction>> protoAdapter = this.f383588a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<Integer, AdAction>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, AdAction.ADAPTER);
                this.f383588a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdFeedInfo decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.f383587d.putAll(a().decode(protoReader));
                                }
                            } else {
                                aVar.d(AdOrderItem.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.b(AnyMessage.ADAPTER.decode(protoReader));
                        }
                    } else {
                        try {
                            aVar.c(AdFeedStyle.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                        }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdFeedInfo adFeedInfo) throws IOException {
            if (!Objects.equals(adFeedInfo.feed_style, AdFeedStyle.AD_FEED_STYLE_NONE)) {
                AdFeedStyle.ADAPTER.encodeWithTag(protoWriter, 1, adFeedInfo.feed_style);
            }
            if (!Objects.equals(adFeedInfo.data, null)) {
                AnyMessage.ADAPTER.encodeWithTag(protoWriter, 2, adFeedInfo.data);
            }
            if (!Objects.equals(adFeedInfo.order_item, null)) {
                AdOrderItem.ADAPTER.encodeWithTag(protoWriter, 3, adFeedInfo.order_item);
            }
            a().encodeWithTag(protoWriter, 4, adFeedInfo.action_dict);
            protoWriter.writeBytes(adFeedInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFeedInfo adFeedInfo) {
            int i3 = 0;
            if (!Objects.equals(adFeedInfo.feed_style, AdFeedStyle.AD_FEED_STYLE_NONE)) {
                i3 = 0 + AdFeedStyle.ADAPTER.encodedSizeWithTag(1, adFeedInfo.feed_style);
            }
            if (!Objects.equals(adFeedInfo.data, null)) {
                i3 += AnyMessage.ADAPTER.encodedSizeWithTag(2, adFeedInfo.data);
            }
            if (!Objects.equals(adFeedInfo.order_item, null)) {
                i3 += AdOrderItem.ADAPTER.encodedSizeWithTag(3, adFeedInfo.order_item);
            }
            return i3 + a().encodedSizeWithTag(4, adFeedInfo.action_dict) + adFeedInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AdFeedInfo redact(AdFeedInfo adFeedInfo) {
            a newBuilder = adFeedInfo.newBuilder();
            AnyMessage anyMessage = newBuilder.f383585b;
            if (anyMessage != null) {
                newBuilder.f383585b = AnyMessage.ADAPTER.redact(anyMessage);
            }
            AdOrderItem adOrderItem = newBuilder.f383586c;
            if (adOrderItem != null) {
                newBuilder.f383586c = AdOrderItem.ADAPTER.redact(adOrderItem);
            }
            Internal.redactElements(newBuilder.f383587d, AdAction.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFeedInfo(AdFeedStyle adFeedStyle, AnyMessage anyMessage, AdOrderItem adOrderItem, Map<Integer, AdAction> map) {
        this(adFeedStyle, anyMessage, adOrderItem, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFeedInfo)) {
            return false;
        }
        AdFeedInfo adFeedInfo = (AdFeedInfo) obj;
        if (unknownFields().equals(adFeedInfo.unknownFields()) && Internal.equals(this.feed_style, adFeedInfo.feed_style) && Internal.equals(this.data, adFeedInfo.data) && Internal.equals(this.order_item, adFeedInfo.order_item) && this.action_dict.equals(adFeedInfo.action_dict)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdFeedStyle adFeedStyle = this.feed_style;
            int i18 = 0;
            if (adFeedStyle != null) {
                i3 = adFeedStyle.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            AnyMessage anyMessage = this.data;
            if (anyMessage != null) {
                i16 = anyMessage.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            AdOrderItem adOrderItem = this.order_item;
            if (adOrderItem != null) {
                i18 = adOrderItem.hashCode();
            }
            int hashCode2 = ((i26 + i18) * 37) + this.action_dict.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.feed_style != null) {
            sb5.append(", feed_style=");
            sb5.append(this.feed_style);
        }
        if (this.data != null) {
            sb5.append(", data=");
            sb5.append(this.data);
        }
        if (this.order_item != null) {
            sb5.append(", order_item=");
            sb5.append(this.order_item);
        }
        if (!this.action_dict.isEmpty()) {
            sb5.append(", action_dict=");
            sb5.append(this.action_dict);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdFeedInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdFeedInfo(AdFeedStyle adFeedStyle, AnyMessage anyMessage, AdOrderItem adOrderItem, Map<Integer, AdAction> map, ByteString byteString) {
        super(ADAPTER, byteString);
        if (adFeedStyle != null) {
            this.feed_style = adFeedStyle;
            this.data = anyMessage;
            this.order_item = adOrderItem;
            this.action_dict = Internal.immutableCopyOf("action_dict", map);
            return;
        }
        throw new IllegalArgumentException("feed_style == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383584a = this.feed_style;
        aVar.f383585b = this.data;
        aVar.f383586c = this.order_item;
        aVar.f383587d = Internal.copyOf(this.action_dict);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
