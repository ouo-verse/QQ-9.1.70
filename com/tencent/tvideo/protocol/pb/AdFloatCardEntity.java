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
public final class AdFloatCardEntity extends Message<AdFloatCardEntity, a> {
    public static final ProtoAdapter<AdFloatCardEntity> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdActionButton#ADAPTER", jsonName = "actionButton", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final AdActionButton action_button;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "cardDelayShowTime", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final int card_delay_show_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "cardDoShowAnimation", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final boolean card_do_show_animation;

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

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdFloatCardEntityType#ADAPTER", jsonName = "cardType", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final AdFloatCardEntityType card_type;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFloatCardEntity, a> {

        /* renamed from: h, reason: collision with root package name */
        public AdActionButton f383604h;

        /* renamed from: a, reason: collision with root package name */
        public String f383597a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383598b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383599c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383600d = "";

        /* renamed from: e, reason: collision with root package name */
        public AdFloatCardStyle f383601e = AdFloatCardStyle.DEFAULT_STYLE;

        /* renamed from: f, reason: collision with root package name */
        public int f383602f = 0;

        /* renamed from: g, reason: collision with root package name */
        public AdFloatCardEntityType f383603g = AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_IDLE;

        /* renamed from: i, reason: collision with root package name */
        public boolean f383605i = false;

        public a a(AdActionButton adActionButton) {
            this.f383604h = adActionButton;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdFloatCardEntity build() {
            return new AdFloatCardEntity(this.f383597a, this.f383598b, this.f383599c, this.f383600d, this.f383601e, this.f383602f, this.f383603g, this.f383604h, this.f383605i, super.buildUnknownFields());
        }

        public a c(int i3) {
            this.f383602f = i3;
            return this;
        }

        public a d(boolean z16) {
            this.f383605i = z16;
            return this;
        }

        public a e(String str) {
            this.f383597a = str;
            return this;
        }

        public a f(String str) {
            this.f383600d = str;
            return this;
        }

        public a g(AdFloatCardStyle adFloatCardStyle) {
            this.f383601e = adFloatCardStyle;
            return this;
        }

        public a h(String str) {
            this.f383599c = str;
            return this;
        }

        public a i(String str) {
            this.f383598b = str;
            return this;
        }

        public a j(AdFloatCardEntityType adFloatCardEntityType) {
            this.f383603g = adFloatCardEntityType;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFloatCardEntity> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFloatCardEntity.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFloatCardEntity", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFloatCardEntity decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.i(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            try {
                                aVar.g(AdFloatCardStyle.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 6:
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 7:
                            try {
                                aVar.j(AdFloatCardEntityType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                break;
                            }
                        case 8:
                            aVar.a(AdActionButton.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
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
        public void encode(ProtoWriter protoWriter, AdFloatCardEntity adFloatCardEntity) throws IOException {
            if (!Objects.equals(adFloatCardEntity.card_image_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adFloatCardEntity.card_image_url);
            }
            if (!Objects.equals(adFloatCardEntity.card_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adFloatCardEntity.card_title);
            }
            if (!Objects.equals(adFloatCardEntity.card_subTitle, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adFloatCardEntity.card_subTitle);
            }
            if (!Objects.equals(adFloatCardEntity.card_poster_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adFloatCardEntity.card_poster_url);
            }
            if (!Objects.equals(adFloatCardEntity.card_style, AdFloatCardStyle.DEFAULT_STYLE)) {
                AdFloatCardStyle.ADAPTER.encodeWithTag(protoWriter, 5, adFloatCardEntity.card_style);
            }
            if (!Objects.equals(Integer.valueOf(adFloatCardEntity.card_delay_show_time), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, Integer.valueOf(adFloatCardEntity.card_delay_show_time));
            }
            if (!Objects.equals(adFloatCardEntity.card_type, AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_IDLE)) {
                AdFloatCardEntityType.ADAPTER.encodeWithTag(protoWriter, 7, adFloatCardEntity.card_type);
            }
            if (!Objects.equals(adFloatCardEntity.action_button, null)) {
                AdActionButton.ADAPTER.encodeWithTag(protoWriter, 8, adFloatCardEntity.action_button);
            }
            if (!Objects.equals(Boolean.valueOf(adFloatCardEntity.card_do_show_animation), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 9, Boolean.valueOf(adFloatCardEntity.card_do_show_animation));
            }
            protoWriter.writeBytes(adFloatCardEntity.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFloatCardEntity adFloatCardEntity) {
            int i3;
            if (!Objects.equals(adFloatCardEntity.card_image_url, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, adFloatCardEntity.card_image_url) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(adFloatCardEntity.card_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adFloatCardEntity.card_title);
            }
            if (!Objects.equals(adFloatCardEntity.card_subTitle, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adFloatCardEntity.card_subTitle);
            }
            if (!Objects.equals(adFloatCardEntity.card_poster_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adFloatCardEntity.card_poster_url);
            }
            if (!Objects.equals(adFloatCardEntity.card_style, AdFloatCardStyle.DEFAULT_STYLE)) {
                i3 += AdFloatCardStyle.ADAPTER.encodedSizeWithTag(5, adFloatCardEntity.card_style);
            }
            if (!Objects.equals(Integer.valueOf(adFloatCardEntity.card_delay_show_time), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(6, Integer.valueOf(adFloatCardEntity.card_delay_show_time));
            }
            if (!Objects.equals(adFloatCardEntity.card_type, AdFloatCardEntityType.AD_FLOAT_CARD_TYPE_IDLE)) {
                i3 += AdFloatCardEntityType.ADAPTER.encodedSizeWithTag(7, adFloatCardEntity.card_type);
            }
            if (!Objects.equals(adFloatCardEntity.action_button, null)) {
                i3 += AdActionButton.ADAPTER.encodedSizeWithTag(8, adFloatCardEntity.action_button);
            }
            if (!Objects.equals(Boolean.valueOf(adFloatCardEntity.card_do_show_animation), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(9, Boolean.valueOf(adFloatCardEntity.card_do_show_animation));
            }
            return i3 + adFloatCardEntity.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFloatCardEntity redact(AdFloatCardEntity adFloatCardEntity) {
            a newBuilder = adFloatCardEntity.newBuilder();
            AdActionButton adActionButton = newBuilder.f383604h;
            if (adActionButton != null) {
                newBuilder.f383604h = AdActionButton.ADAPTER.redact(adActionButton);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFloatCardEntity(String str, String str2, String str3, String str4, AdFloatCardStyle adFloatCardStyle, int i3, AdFloatCardEntityType adFloatCardEntityType, AdActionButton adActionButton, boolean z16) {
        this(str, str2, str3, str4, adFloatCardStyle, i3, adFloatCardEntityType, adActionButton, z16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFloatCardEntity)) {
            return false;
        }
        AdFloatCardEntity adFloatCardEntity = (AdFloatCardEntity) obj;
        if (unknownFields().equals(adFloatCardEntity.unknownFields()) && Internal.equals(this.card_image_url, adFloatCardEntity.card_image_url) && Internal.equals(this.card_title, adFloatCardEntity.card_title) && Internal.equals(this.card_subTitle, adFloatCardEntity.card_subTitle) && Internal.equals(this.card_poster_url, adFloatCardEntity.card_poster_url) && Internal.equals(this.card_style, adFloatCardEntity.card_style) && Internal.equals(Integer.valueOf(this.card_delay_show_time), Integer.valueOf(adFloatCardEntity.card_delay_show_time)) && Internal.equals(this.card_type, adFloatCardEntity.card_type) && Internal.equals(this.action_button, adFloatCardEntity.action_button) && Internal.equals(Boolean.valueOf(this.card_do_show_animation), Boolean.valueOf(adFloatCardEntity.card_do_show_animation))) {
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
            String str = this.card_image_url;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            String str2 = this.card_title;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            String str3 = this.card_subTitle;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 37;
            String str4 = this.card_poster_url;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i38 = (i37 + i18) * 37;
            AdFloatCardStyle adFloatCardStyle = this.card_style;
            if (adFloatCardStyle != null) {
                i19 = adFloatCardStyle.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (((i38 + i19) * 37) + this.card_delay_show_time) * 37;
            AdFloatCardEntityType adFloatCardEntityType = this.card_type;
            if (adFloatCardEntityType != null) {
                i26 = adFloatCardEntityType.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 37;
            AdActionButton adActionButton = this.action_button;
            if (adActionButton != null) {
                i28 = adActionButton.hashCode();
            }
            int a16 = ((i46 + i28) * 37) + com.tencent.aio.widget.textView.param.a.a(this.card_do_show_animation);
            this.hashCode = a16;
            return a16;
        }
        return i27;
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
        sb5.append(", card_delay_show_time=");
        sb5.append(this.card_delay_show_time);
        if (this.card_type != null) {
            sb5.append(", card_type=");
            sb5.append(this.card_type);
        }
        if (this.action_button != null) {
            sb5.append(", action_button=");
            sb5.append(this.action_button);
        }
        sb5.append(", card_do_show_animation=");
        sb5.append(this.card_do_show_animation);
        StringBuilder replace = sb5.replace(0, 2, "AdFloatCardEntity{");
        replace.append('}');
        return replace.toString();
    }

    public AdFloatCardEntity(String str, String str2, String str3, String str4, AdFloatCardStyle adFloatCardStyle, int i3, AdFloatCardEntityType adFloatCardEntityType, AdActionButton adActionButton, boolean z16, ByteString byteString) {
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
                            this.card_delay_show_time = i3;
                            if (adFloatCardEntityType != null) {
                                this.card_type = adFloatCardEntityType;
                                this.action_button = adActionButton;
                                this.card_do_show_animation = z16;
                                return;
                            }
                            throw new IllegalArgumentException("card_type == null");
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
        aVar.f383597a = this.card_image_url;
        aVar.f383598b = this.card_title;
        aVar.f383599c = this.card_subTitle;
        aVar.f383600d = this.card_poster_url;
        aVar.f383601e = this.card_style;
        aVar.f383602f = this.card_delay_show_time;
        aVar.f383603g = this.card_type;
        aVar.f383604h = this.action_button;
        aVar.f383605i = this.card_do_show_animation;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
