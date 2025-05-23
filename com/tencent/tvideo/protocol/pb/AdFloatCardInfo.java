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
public final class AdFloatCardInfo extends Message<AdFloatCardInfo, a> {
    public static final ProtoAdapter<AdFloatCardInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFloatCardEntity#ADAPTER", jsonName = "cardEntity", label = WireField.Label.REPEATED, tag = 6)
    public final List<AdFloatCardEntity> card_entity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardImageUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String card_image_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardPosterUrl", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String card_poster_url;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFloatCardStyle#ADAPTER", jsonName = "cardStyle", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AdFloatCardStyle card_style;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardSubTitle", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String card_subTitle;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardTitle", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String card_title;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFloatCardEntity#ADAPTER", jsonName = "horizontalCardEntity", label = WireField.Label.REPEATED, tag = 7)
    public final List<AdFloatCardEntity> horizontal_card_entity;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFloatCardInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383606a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383607b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383608c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383609d = "";

        /* renamed from: e, reason: collision with root package name */
        public AdFloatCardStyle f383610e = AdFloatCardStyle.DEFAULT_STYLE;

        /* renamed from: f, reason: collision with root package name */
        public List<AdFloatCardEntity> f383611f = Internal.newMutableList();

        /* renamed from: g, reason: collision with root package name */
        public List<AdFloatCardEntity> f383612g = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFloatCardInfo build() {
            return new AdFloatCardInfo(this.f383606a, this.f383607b, this.f383608c, this.f383609d, this.f383610e, this.f383611f, this.f383612g, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383606a = str;
            return this;
        }

        public a c(String str) {
            this.f383609d = str;
            return this;
        }

        public a d(AdFloatCardStyle adFloatCardStyle) {
            this.f383610e = adFloatCardStyle;
            return this;
        }

        public a e(String str) {
            this.f383608c = str;
            return this;
        }

        public a f(String str) {
            this.f383607b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFloatCardInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFloatCardInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFloatCardInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFloatCardInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            try {
                                aVar.d(AdFloatCardStyle.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 6:
                            aVar.f383611f.add(AdFloatCardEntity.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            aVar.f383612g.add(AdFloatCardEntity.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdFloatCardInfo adFloatCardInfo) throws IOException {
            if (!Objects.equals(adFloatCardInfo.card_image_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adFloatCardInfo.card_image_url);
            }
            if (!Objects.equals(adFloatCardInfo.card_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adFloatCardInfo.card_title);
            }
            if (!Objects.equals(adFloatCardInfo.card_subTitle, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adFloatCardInfo.card_subTitle);
            }
            if (!Objects.equals(adFloatCardInfo.card_poster_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adFloatCardInfo.card_poster_url);
            }
            if (!Objects.equals(adFloatCardInfo.card_style, AdFloatCardStyle.DEFAULT_STYLE)) {
                AdFloatCardStyle.ADAPTER.encodeWithTag(protoWriter, 5, adFloatCardInfo.card_style);
            }
            ProtoAdapter<AdFloatCardEntity> protoAdapter = AdFloatCardEntity.ADAPTER;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 6, adFloatCardInfo.card_entity);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 7, adFloatCardInfo.horizontal_card_entity);
            protoWriter.writeBytes(adFloatCardInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFloatCardInfo adFloatCardInfo) {
            int i3 = 0;
            if (!Objects.equals(adFloatCardInfo.card_image_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adFloatCardInfo.card_image_url);
            }
            if (!Objects.equals(adFloatCardInfo.card_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adFloatCardInfo.card_title);
            }
            if (!Objects.equals(adFloatCardInfo.card_subTitle, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adFloatCardInfo.card_subTitle);
            }
            if (!Objects.equals(adFloatCardInfo.card_poster_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adFloatCardInfo.card_poster_url);
            }
            if (!Objects.equals(adFloatCardInfo.card_style, AdFloatCardStyle.DEFAULT_STYLE)) {
                i3 += AdFloatCardStyle.ADAPTER.encodedSizeWithTag(5, adFloatCardInfo.card_style);
            }
            ProtoAdapter<AdFloatCardEntity> protoAdapter = AdFloatCardEntity.ADAPTER;
            return i3 + protoAdapter.asRepeated().encodedSizeWithTag(6, adFloatCardInfo.card_entity) + protoAdapter.asRepeated().encodedSizeWithTag(7, adFloatCardInfo.horizontal_card_entity) + adFloatCardInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFloatCardInfo redact(AdFloatCardInfo adFloatCardInfo) {
            a newBuilder = adFloatCardInfo.newBuilder();
            List<AdFloatCardEntity> list = newBuilder.f383611f;
            ProtoAdapter<AdFloatCardEntity> protoAdapter = AdFloatCardEntity.ADAPTER;
            Internal.redactElements(list, protoAdapter);
            Internal.redactElements(newBuilder.f383612g, protoAdapter);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFloatCardInfo(String str, String str2, String str3, String str4, AdFloatCardStyle adFloatCardStyle, List<AdFloatCardEntity> list, List<AdFloatCardEntity> list2) {
        this(str, str2, str3, str4, adFloatCardStyle, list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFloatCardInfo)) {
            return false;
        }
        AdFloatCardInfo adFloatCardInfo = (AdFloatCardInfo) obj;
        if (unknownFields().equals(adFloatCardInfo.unknownFields()) && Internal.equals(this.card_image_url, adFloatCardInfo.card_image_url) && Internal.equals(this.card_title, adFloatCardInfo.card_title) && Internal.equals(this.card_subTitle, adFloatCardInfo.card_subTitle) && Internal.equals(this.card_poster_url, adFloatCardInfo.card_poster_url) && Internal.equals(this.card_style, adFloatCardInfo.card_style) && this.card_entity.equals(adFloatCardInfo.card_entity) && this.horizontal_card_entity.equals(adFloatCardInfo.horizontal_card_entity)) {
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
            String str = this.card_image_url;
            int i26 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            String str2 = this.card_title;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            String str3 = this.card_subTitle;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            String str4 = this.card_poster_url;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            AdFloatCardStyle adFloatCardStyle = this.card_style;
            if (adFloatCardStyle != null) {
                i26 = adFloatCardStyle.hashCode();
            }
            int hashCode2 = ((((i36 + i26) * 37) + this.card_entity.hashCode()) * 37) + this.horizontal_card_entity.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.card_image_url != null) {
            sb5.append(", card_image_url=");
            sb5.append(Internal.sanitize(this.card_image_url));
        }
        if (this.card_title != null) {
            sb5.append(", card_title=");
            sb5.append(Internal.sanitize(this.card_title));
        }
        if (this.card_subTitle != null) {
            sb5.append(", card_subTitle=");
            sb5.append(Internal.sanitize(this.card_subTitle));
        }
        if (this.card_poster_url != null) {
            sb5.append(", card_poster_url=");
            sb5.append(Internal.sanitize(this.card_poster_url));
        }
        if (this.card_style != null) {
            sb5.append(", card_style=");
            sb5.append(this.card_style);
        }
        if (!this.card_entity.isEmpty()) {
            sb5.append(", card_entity=");
            sb5.append(this.card_entity);
        }
        if (!this.horizontal_card_entity.isEmpty()) {
            sb5.append(", horizontal_card_entity=");
            sb5.append(this.horizontal_card_entity);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdFloatCardInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdFloatCardInfo(String str, String str2, String str3, String str4, AdFloatCardStyle adFloatCardStyle, List<AdFloatCardEntity> list, List<AdFloatCardEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.card_image_url = str;
            if (str2 != null) {
                this.card_title = str2;
                if (str3 != null) {
                    this.card_subTitle = str3;
                    if (str4 != null) {
                        this.card_poster_url = str4;
                        if (adFloatCardStyle != null) {
                            this.card_style = adFloatCardStyle;
                            this.card_entity = Internal.immutableCopyOf("card_entity", list);
                            this.horizontal_card_entity = Internal.immutableCopyOf("horizontal_card_entity", list2);
                            return;
                        }
                        throw new IllegalArgumentException("card_style == null");
                    }
                    throw new IllegalArgumentException("card_poster_url == null");
                }
                throw new IllegalArgumentException("card_subTitle == null");
            }
            throw new IllegalArgumentException("card_title == null");
        }
        throw new IllegalArgumentException("card_image_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383606a = this.card_image_url;
        aVar.f383607b = this.card_title;
        aVar.f383608c = this.card_subTitle;
        aVar.f383609d = this.card_poster_url;
        aVar.f383610e = this.card_style;
        aVar.f383611f = Internal.copyOf(this.card_entity);
        aVar.f383612g = Internal.copyOf(this.horizontal_card_entity);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
