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
public final class AdActionTitle extends Message<AdActionTitle, a> {
    public static final ProtoAdapter<AdActionTitle> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "firstIconUrl", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String first_icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "firstTitle", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String first_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "secondIconUrl", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String second_icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "secondTitle", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String second_title;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdActionTitle, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383519a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383520b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383521c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383522d = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdActionTitle build() {
            return new AdActionTitle(this.f383519a, this.f383520b, this.f383521c, this.f383522d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383521c = str;
            return this;
        }

        public a c(String str) {
            this.f383519a = str;
            return this;
        }

        public a d(String str) {
            this.f383522d = str;
            return this;
        }

        public a e(String str) {
            this.f383520b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdActionTitle> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdActionTitle.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdActionTitle", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdActionTitle decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.d(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdActionTitle adActionTitle) throws IOException {
            if (!Objects.equals(adActionTitle.first_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adActionTitle.first_title);
            }
            if (!Objects.equals(adActionTitle.second_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adActionTitle.second_title);
            }
            if (!Objects.equals(adActionTitle.first_icon_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adActionTitle.first_icon_url);
            }
            if (!Objects.equals(adActionTitle.second_icon_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adActionTitle.second_icon_url);
            }
            protoWriter.writeBytes(adActionTitle.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdActionTitle adActionTitle) {
            int i3 = 0;
            if (!Objects.equals(adActionTitle.first_title, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adActionTitle.first_title);
            }
            if (!Objects.equals(adActionTitle.second_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adActionTitle.second_title);
            }
            if (!Objects.equals(adActionTitle.first_icon_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adActionTitle.first_icon_url);
            }
            if (!Objects.equals(adActionTitle.second_icon_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adActionTitle.second_icon_url);
            }
            return i3 + adActionTitle.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdActionTitle redact(AdActionTitle adActionTitle) {
            a newBuilder = adActionTitle.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdActionTitle(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdActionTitle)) {
            return false;
        }
        AdActionTitle adActionTitle = (AdActionTitle) obj;
        if (unknownFields().equals(adActionTitle.unknownFields()) && Internal.equals(this.first_title, adActionTitle.first_title) && Internal.equals(this.second_title, adActionTitle.second_title) && Internal.equals(this.first_icon_url, adActionTitle.first_icon_url) && Internal.equals(this.second_icon_url, adActionTitle.second_icon_url)) {
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
            String str = this.first_title;
            int i19 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            String str2 = this.second_title;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            String str3 = this.first_icon_url;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            String str4 = this.second_icon_url;
            if (str4 != null) {
                i19 = str4.hashCode();
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
        if (this.first_title != null) {
            sb5.append(", first_title=");
            sb5.append(Internal.sanitize(this.first_title));
        }
        if (this.second_title != null) {
            sb5.append(", second_title=");
            sb5.append(Internal.sanitize(this.second_title));
        }
        if (this.first_icon_url != null) {
            sb5.append(", first_icon_url=");
            sb5.append(Internal.sanitize(this.first_icon_url));
        }
        if (this.second_icon_url != null) {
            sb5.append(", second_icon_url=");
            sb5.append(Internal.sanitize(this.second_icon_url));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdActionTitle{");
        replace.append('}');
        return replace.toString();
    }

    public AdActionTitle(String str, String str2, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.first_title = str;
            if (str2 != null) {
                this.second_title = str2;
                if (str3 != null) {
                    this.first_icon_url = str3;
                    if (str4 != null) {
                        this.second_icon_url = str4;
                        return;
                    }
                    throw new IllegalArgumentException("second_icon_url == null");
                }
                throw new IllegalArgumentException("first_icon_url == null");
            }
            throw new IllegalArgumentException("second_title == null");
        }
        throw new IllegalArgumentException("first_title == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383519a = this.first_title;
        aVar.f383520b = this.second_title;
        aVar.f383521c = this.first_icon_url;
        aVar.f383522d = this.second_icon_url;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
