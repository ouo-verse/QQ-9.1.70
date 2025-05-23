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

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdFeedHeaderInfo extends Message<AdFeedHeaderInfo, a> {
    public static final ProtoAdapter<AdFeedHeaderInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adIpIconUrl", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String ad_ip_icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adIpIconUrlDark", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String ad_ip_icon_url_dark;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String message;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QQWinkConstants.TAB_SUBTITLE, label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String sub_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String title;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdFeedHeaderInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383578a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383579b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383580c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383581d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f383582e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383583f = "";

        public a a(String str) {
            this.f383582e = str;
            return this;
        }

        public a b(String str) {
            this.f383583f = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdFeedHeaderInfo build() {
            return new AdFeedHeaderInfo(this.f383578a, this.f383579b, this.f383580c, this.f383581d, this.f383582e, this.f383583f, super.buildUnknownFields());
        }

        public a d(String str) {
            this.f383578a = str;
            return this;
        }

        public a e(String str) {
            this.f383581d = str;
            return this;
        }

        public a f(String str) {
            this.f383580c = str;
            return this;
        }

        public a g(String str) {
            this.f383579b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdFeedHeaderInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdFeedHeaderInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdFeedHeaderInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdFeedHeaderInfo decode(ProtoReader protoReader) throws IOException {
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
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
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
        public void encode(ProtoWriter protoWriter, AdFeedHeaderInfo adFeedHeaderInfo) throws IOException {
            if (!Objects.equals(adFeedHeaderInfo.icon_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adFeedHeaderInfo.icon_url);
            }
            if (!Objects.equals(adFeedHeaderInfo.title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adFeedHeaderInfo.title);
            }
            if (!Objects.equals(adFeedHeaderInfo.sub_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adFeedHeaderInfo.sub_title);
            }
            if (!Objects.equals(adFeedHeaderInfo.message, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adFeedHeaderInfo.message);
            }
            if (!Objects.equals(adFeedHeaderInfo.ad_ip_icon_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, adFeedHeaderInfo.ad_ip_icon_url);
            }
            if (!Objects.equals(adFeedHeaderInfo.ad_ip_icon_url_dark, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adFeedHeaderInfo.ad_ip_icon_url_dark);
            }
            protoWriter.writeBytes(adFeedHeaderInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdFeedHeaderInfo adFeedHeaderInfo) {
            int i3 = 0;
            if (!Objects.equals(adFeedHeaderInfo.icon_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adFeedHeaderInfo.icon_url);
            }
            if (!Objects.equals(adFeedHeaderInfo.title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adFeedHeaderInfo.title);
            }
            if (!Objects.equals(adFeedHeaderInfo.sub_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adFeedHeaderInfo.sub_title);
            }
            if (!Objects.equals(adFeedHeaderInfo.message, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adFeedHeaderInfo.message);
            }
            if (!Objects.equals(adFeedHeaderInfo.ad_ip_icon_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, adFeedHeaderInfo.ad_ip_icon_url);
            }
            if (!Objects.equals(adFeedHeaderInfo.ad_ip_icon_url_dark, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adFeedHeaderInfo.ad_ip_icon_url_dark);
            }
            return i3 + adFeedHeaderInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdFeedHeaderInfo redact(AdFeedHeaderInfo adFeedHeaderInfo) {
            a newBuilder = adFeedHeaderInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdFeedHeaderInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdFeedHeaderInfo)) {
            return false;
        }
        AdFeedHeaderInfo adFeedHeaderInfo = (AdFeedHeaderInfo) obj;
        if (unknownFields().equals(adFeedHeaderInfo.unknownFields()) && Internal.equals(this.icon_url, adFeedHeaderInfo.icon_url) && Internal.equals(this.title, adFeedHeaderInfo.title) && Internal.equals(this.sub_title, adFeedHeaderInfo.sub_title) && Internal.equals(this.message, adFeedHeaderInfo.message) && Internal.equals(this.ad_ip_icon_url, adFeedHeaderInfo.ad_ip_icon_url) && Internal.equals(this.ad_ip_icon_url_dark, adFeedHeaderInfo.ad_ip_icon_url_dark)) {
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
            String str = this.icon_url;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.title;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str3 = this.sub_title;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str4 = this.message;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            String str5 = this.ad_ip_icon_url;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            String str6 = this.ad_ip_icon_url_dark;
            if (str6 != null) {
                i27 = str6.hashCode();
            }
            int i39 = i38 + i27;
            this.hashCode = i39;
            return i39;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.icon_url != null) {
            sb5.append(", icon_url=");
            sb5.append(Internal.sanitize(this.icon_url));
        }
        if (this.title != null) {
            sb5.append(", title=");
            sb5.append(Internal.sanitize(this.title));
        }
        if (this.sub_title != null) {
            sb5.append(", sub_title=");
            sb5.append(Internal.sanitize(this.sub_title));
        }
        if (this.message != null) {
            sb5.append(", message=");
            sb5.append(Internal.sanitize(this.message));
        }
        if (this.ad_ip_icon_url != null) {
            sb5.append(", ad_ip_icon_url=");
            sb5.append(Internal.sanitize(this.ad_ip_icon_url));
        }
        if (this.ad_ip_icon_url_dark != null) {
            sb5.append(", ad_ip_icon_url_dark=");
            sb5.append(Internal.sanitize(this.ad_ip_icon_url_dark));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdFeedHeaderInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdFeedHeaderInfo(String str, String str2, String str3, String str4, String str5, String str6, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.icon_url = str;
            if (str2 != null) {
                this.title = str2;
                if (str3 != null) {
                    this.sub_title = str3;
                    if (str4 != null) {
                        this.message = str4;
                        if (str5 != null) {
                            this.ad_ip_icon_url = str5;
                            if (str6 != null) {
                                this.ad_ip_icon_url_dark = str6;
                                return;
                            }
                            throw new IllegalArgumentException("ad_ip_icon_url_dark == null");
                        }
                        throw new IllegalArgumentException("ad_ip_icon_url == null");
                    }
                    throw new IllegalArgumentException("message == null");
                }
                throw new IllegalArgumentException("sub_title == null");
            }
            throw new IllegalArgumentException("title == null");
        }
        throw new IllegalArgumentException("icon_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383578a = this.icon_url;
        aVar.f383579b = this.title;
        aVar.f383580c = this.sub_title;
        aVar.f383581d = this.message;
        aVar.f383582e = this.ad_ip_icon_url;
        aVar.f383583f = this.ad_ip_icon_url_dark;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
