package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes27.dex */
public final class AdPlayFinishMaskInfo extends Message<AdPlayFinishMaskInfo, a> {
    public static final ProtoAdapter<AdPlayFinishMaskInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdActionButton#ADAPTER", jsonName = "actionButton", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdActionButton action_button;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "backgroundColor", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String background_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String image_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "shortTitle", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String short_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "showDuration", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long show_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QQWinkConstants.TAB_SUBTITLE, label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String sub_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String title;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdPlayFinishMaskInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdActionButton f383680a;

        /* renamed from: b, reason: collision with root package name */
        public String f383681b = "";

        /* renamed from: c, reason: collision with root package name */
        public long f383682c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f383683d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f383684e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383685f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f383686g = "";

        public a a(AdActionButton adActionButton) {
            this.f383680a = adActionButton;
            return this;
        }

        public a b(String str) {
            this.f383686g = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdPlayFinishMaskInfo build() {
            return new AdPlayFinishMaskInfo(this.f383680a, this.f383681b, this.f383682c, this.f383683d, this.f383684e, this.f383685f, this.f383686g, super.buildUnknownFields());
        }

        public a d(String str) {
            this.f383681b = str;
            return this;
        }

        public a e(String str) {
            this.f383685f = str;
            return this;
        }

        public a f(long j3) {
            this.f383682c = j3;
            return this;
        }

        public a g(String str) {
            this.f383684e = str;
            return this;
        }

        public a h(String str) {
            this.f383683d = str;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdPlayFinishMaskInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdPlayFinishMaskInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdPlayFinishMaskInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdPlayFinishMaskInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.a(AdActionButton.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.f(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 4:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdPlayFinishMaskInfo adPlayFinishMaskInfo) throws IOException {
            if (!Objects.equals(adPlayFinishMaskInfo.action_button, null)) {
                AdActionButton.ADAPTER.encodeWithTag(protoWriter, 1, adPlayFinishMaskInfo.action_button);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.image_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adPlayFinishMaskInfo.image_url);
            }
            if (!Objects.equals(Long.valueOf(adPlayFinishMaskInfo.show_duration), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, Long.valueOf(adPlayFinishMaskInfo.show_duration));
            }
            if (!Objects.equals(adPlayFinishMaskInfo.title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adPlayFinishMaskInfo.title);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.sub_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, adPlayFinishMaskInfo.sub_title);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.short_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adPlayFinishMaskInfo.short_title);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.background_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, adPlayFinishMaskInfo.background_color);
            }
            protoWriter.writeBytes(adPlayFinishMaskInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdPlayFinishMaskInfo adPlayFinishMaskInfo) {
            int i3 = 0;
            if (!Objects.equals(adPlayFinishMaskInfo.action_button, null)) {
                i3 = 0 + AdActionButton.ADAPTER.encodedSizeWithTag(1, adPlayFinishMaskInfo.action_button);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.image_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adPlayFinishMaskInfo.image_url);
            }
            if (!Objects.equals(Long.valueOf(adPlayFinishMaskInfo.show_duration), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(adPlayFinishMaskInfo.show_duration));
            }
            if (!Objects.equals(adPlayFinishMaskInfo.title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adPlayFinishMaskInfo.title);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.sub_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, adPlayFinishMaskInfo.sub_title);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.short_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adPlayFinishMaskInfo.short_title);
            }
            if (!Objects.equals(adPlayFinishMaskInfo.background_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, adPlayFinishMaskInfo.background_color);
            }
            return i3 + adPlayFinishMaskInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdPlayFinishMaskInfo redact(AdPlayFinishMaskInfo adPlayFinishMaskInfo) {
            a newBuilder = adPlayFinishMaskInfo.newBuilder();
            AdActionButton adActionButton = newBuilder.f383680a;
            if (adActionButton != null) {
                newBuilder.f383680a = AdActionButton.ADAPTER.redact(adActionButton);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdPlayFinishMaskInfo(AdActionButton adActionButton, String str, long j3, String str2, String str3, String str4, String str5) {
        this(adActionButton, str, j3, str2, str3, str4, str5, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdPlayFinishMaskInfo)) {
            return false;
        }
        AdPlayFinishMaskInfo adPlayFinishMaskInfo = (AdPlayFinishMaskInfo) obj;
        if (unknownFields().equals(adPlayFinishMaskInfo.unknownFields()) && Internal.equals(this.action_button, adPlayFinishMaskInfo.action_button) && Internal.equals(this.image_url, adPlayFinishMaskInfo.image_url) && Internal.equals(Long.valueOf(this.show_duration), Long.valueOf(adPlayFinishMaskInfo.show_duration)) && Internal.equals(this.title, adPlayFinishMaskInfo.title) && Internal.equals(this.sub_title, adPlayFinishMaskInfo.sub_title) && Internal.equals(this.short_title, adPlayFinishMaskInfo.short_title) && Internal.equals(this.background_color, adPlayFinishMaskInfo.background_color)) {
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
        int i26 = this.hashCode;
        if (i26 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdActionButton adActionButton = this.action_button;
            int i27 = 0;
            if (adActionButton != null) {
                i3 = adActionButton.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str = this.image_url;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int a16 = (((i28 + i16) * 37) + androidx.fragment.app.a.a(this.show_duration)) * 37;
            String str2 = this.title;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (a16 + i17) * 37;
            String str3 = this.sub_title;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str4 = this.short_title;
            if (str4 != null) {
                i19 = str4.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (i36 + i19) * 37;
            String str5 = this.background_color;
            if (str5 != null) {
                i27 = str5.hashCode();
            }
            int i38 = i37 + i27;
            this.hashCode = i38;
            return i38;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.action_button != null) {
            sb5.append(", action_button=");
            sb5.append(this.action_button);
        }
        if (this.image_url != null) {
            sb5.append(", image_url=");
            sb5.append(Internal.sanitize(this.image_url));
        }
        sb5.append(", show_duration=");
        sb5.append(this.show_duration);
        if (this.title != null) {
            sb5.append(", title=");
            sb5.append(Internal.sanitize(this.title));
        }
        if (this.sub_title != null) {
            sb5.append(", sub_title=");
            sb5.append(Internal.sanitize(this.sub_title));
        }
        if (this.short_title != null) {
            sb5.append(", short_title=");
            sb5.append(Internal.sanitize(this.short_title));
        }
        if (this.background_color != null) {
            sb5.append(", background_color=");
            sb5.append(Internal.sanitize(this.background_color));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdPlayFinishMaskInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdPlayFinishMaskInfo(AdActionButton adActionButton, String str, long j3, String str2, String str3, String str4, String str5, ByteString byteString) {
        super(ADAPTER, byteString);
        this.action_button = adActionButton;
        if (str != null) {
            this.image_url = str;
            this.show_duration = j3;
            if (str2 != null) {
                this.title = str2;
                if (str3 != null) {
                    this.sub_title = str3;
                    if (str4 != null) {
                        this.short_title = str4;
                        if (str5 != null) {
                            this.background_color = str5;
                            return;
                        }
                        throw new IllegalArgumentException("background_color == null");
                    }
                    throw new IllegalArgumentException("short_title == null");
                }
                throw new IllegalArgumentException("sub_title == null");
            }
            throw new IllegalArgumentException("title == null");
        }
        throw new IllegalArgumentException("image_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383680a = this.action_button;
        aVar.f383681b = this.image_url;
        aVar.f383682c = this.show_duration;
        aVar.f383683d = this.title;
        aVar.f383684e = this.sub_title;
        aVar.f383685f = this.short_title;
        aVar.f383686g = this.background_color;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
