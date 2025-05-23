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
public final class AdAction extends Message<AdAction, a> {
    public static final ProtoAdapter<AdAction> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdActionItem#ADAPTER", jsonName = "actionItem", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final AdActionItem action_item;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdActionType#ADAPTER", jsonName = "actionType", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdActionType action_type;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdPageType#ADAPTER", jsonName = "pageType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdPageType page_type;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdParseType#ADAPTER", jsonName = "parseType", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final AdParseType parse_type;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdAction, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdPageType f383504a = AdPageType.AD_PAGE_TYPE_UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        public AdParseType f383505b = AdParseType.AD_PARSE_TYPE_UNKNOWN;

        /* renamed from: c, reason: collision with root package name */
        public AdActionType f383506c = AdActionType.AD_ACTION_TYPE_UNKNOWN;

        /* renamed from: d, reason: collision with root package name */
        public AdActionItem f383507d;

        public a a(AdActionItem adActionItem) {
            this.f383507d = adActionItem;
            return this;
        }

        public a b(AdActionType adActionType) {
            this.f383506c = adActionType;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdAction build() {
            return new AdAction(this.f383504a, this.f383505b, this.f383506c, this.f383507d, super.buildUnknownFields());
        }

        public a d(AdPageType adPageType) {
            this.f383504a = adPageType;
            return this;
        }

        public a e(AdParseType adParseType) {
            this.f383505b = adParseType;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdAction> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdAction.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdAction", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdAction decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.a(AdActionItem.ADAPTER.decode(protoReader));
                                }
                            } else {
                                try {
                                    aVar.b(AdActionType.ADAPTER.decode(protoReader));
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                }
                            }
                        } else {
                            try {
                                aVar.e(AdParseType.ADAPTER.decode(protoReader));
                            } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                            }
                        }
                    } else {
                        try {
                            aVar.d(AdPageType.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e18) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e18.value));
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
        public void encode(ProtoWriter protoWriter, AdAction adAction) throws IOException {
            if (!Objects.equals(adAction.page_type, AdPageType.AD_PAGE_TYPE_UNKNOWN)) {
                AdPageType.ADAPTER.encodeWithTag(protoWriter, 1, adAction.page_type);
            }
            if (!Objects.equals(adAction.parse_type, AdParseType.AD_PARSE_TYPE_UNKNOWN)) {
                AdParseType.ADAPTER.encodeWithTag(protoWriter, 2, adAction.parse_type);
            }
            if (!Objects.equals(adAction.action_type, AdActionType.AD_ACTION_TYPE_UNKNOWN)) {
                AdActionType.ADAPTER.encodeWithTag(protoWriter, 3, adAction.action_type);
            }
            if (!Objects.equals(adAction.action_item, null)) {
                AdActionItem.ADAPTER.encodeWithTag(protoWriter, 4, adAction.action_item);
            }
            protoWriter.writeBytes(adAction.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdAction adAction) {
            int i3 = 0;
            if (!Objects.equals(adAction.page_type, AdPageType.AD_PAGE_TYPE_UNKNOWN)) {
                i3 = 0 + AdPageType.ADAPTER.encodedSizeWithTag(1, adAction.page_type);
            }
            if (!Objects.equals(adAction.parse_type, AdParseType.AD_PARSE_TYPE_UNKNOWN)) {
                i3 += AdParseType.ADAPTER.encodedSizeWithTag(2, adAction.parse_type);
            }
            if (!Objects.equals(adAction.action_type, AdActionType.AD_ACTION_TYPE_UNKNOWN)) {
                i3 += AdActionType.ADAPTER.encodedSizeWithTag(3, adAction.action_type);
            }
            if (!Objects.equals(adAction.action_item, null)) {
                i3 += AdActionItem.ADAPTER.encodedSizeWithTag(4, adAction.action_item);
            }
            return i3 + adAction.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdAction redact(AdAction adAction) {
            a newBuilder = adAction.newBuilder();
            AdActionItem adActionItem = newBuilder.f383507d;
            if (adActionItem != null) {
                newBuilder.f383507d = AdActionItem.ADAPTER.redact(adActionItem);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdAction(AdPageType adPageType, AdParseType adParseType, AdActionType adActionType, AdActionItem adActionItem) {
        this(adPageType, adParseType, adActionType, adActionItem, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdAction)) {
            return false;
        }
        AdAction adAction = (AdAction) obj;
        if (unknownFields().equals(adAction.unknownFields()) && Internal.equals(this.page_type, adAction.page_type) && Internal.equals(this.parse_type, adAction.parse_type) && Internal.equals(this.action_type, adAction.action_type) && Internal.equals(this.action_item, adAction.action_item)) {
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
            AdPageType adPageType = this.page_type;
            int i19 = 0;
            if (adPageType != null) {
                i3 = adPageType.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            AdParseType adParseType = this.parse_type;
            if (adParseType != null) {
                i16 = adParseType.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            AdActionType adActionType = this.action_type;
            if (adActionType != null) {
                i17 = adActionType.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            AdActionItem adActionItem = this.action_item;
            if (adActionItem != null) {
                i19 = adActionItem.hashCode();
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
        if (this.page_type != null) {
            sb5.append(", page_type=");
            sb5.append(this.page_type);
        }
        if (this.parse_type != null) {
            sb5.append(", parse_type=");
            sb5.append(this.parse_type);
        }
        if (this.action_type != null) {
            sb5.append(", action_type=");
            sb5.append(this.action_type);
        }
        if (this.action_item != null) {
            sb5.append(", action_item=");
            sb5.append(this.action_item);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdAction{");
        replace.append('}');
        return replace.toString();
    }

    public AdAction(AdPageType adPageType, AdParseType adParseType, AdActionType adActionType, AdActionItem adActionItem, ByteString byteString) {
        super(ADAPTER, byteString);
        if (adPageType != null) {
            this.page_type = adPageType;
            if (adParseType != null) {
                this.parse_type = adParseType;
                if (adActionType != null) {
                    this.action_type = adActionType;
                    this.action_item = adActionItem;
                    return;
                }
                throw new IllegalArgumentException("action_type == null");
            }
            throw new IllegalArgumentException("parse_type == null");
        }
        throw new IllegalArgumentException("page_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383504a = this.page_type;
        aVar.f383505b = this.parse_type;
        aVar.f383506c = this.action_type;
        aVar.f383507d = this.action_item;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
