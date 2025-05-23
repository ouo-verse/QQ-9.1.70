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
public final class AdPoster extends Message<AdPoster, a> {
    public static final ProtoAdapter<AdPoster> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String image_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QQWinkConstants.TAB_SUBTITLE, label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String sub_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String title;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdPoster, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383687a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383688b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383689c = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdPoster build() {
            return new AdPoster(this.f383687a, this.f383688b, this.f383689c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383687a = str;
            return this;
        }

        public a c(String str) {
            this.f383689c = str;
            return this;
        }

        public a d(String str) {
            this.f383688b = str;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdPoster> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdPoster.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdPoster", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdPoster decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                protoReader.readUnknownField(nextTag);
                            } else {
                                aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdPoster adPoster) throws IOException {
            if (!Objects.equals(adPoster.image_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adPoster.image_url);
            }
            if (!Objects.equals(adPoster.title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adPoster.title);
            }
            if (!Objects.equals(adPoster.sub_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adPoster.sub_title);
            }
            protoWriter.writeBytes(adPoster.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdPoster adPoster) {
            int i3 = 0;
            if (!Objects.equals(adPoster.image_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adPoster.image_url);
            }
            if (!Objects.equals(adPoster.title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adPoster.title);
            }
            if (!Objects.equals(adPoster.sub_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adPoster.sub_title);
            }
            return i3 + adPoster.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdPoster redact(AdPoster adPoster) {
            a newBuilder = adPoster.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdPoster(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdPoster)) {
            return false;
        }
        AdPoster adPoster = (AdPoster) obj;
        if (unknownFields().equals(adPoster.unknownFields()) && Internal.equals(this.image_url, adPoster.image_url) && Internal.equals(this.title, adPoster.title) && Internal.equals(this.sub_title, adPoster.sub_title)) {
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
            String str = this.image_url;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.title;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str3 = this.sub_title;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int i27 = i26 + i18;
            this.hashCode = i27;
            return i27;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.image_url != null) {
            sb5.append(", image_url=");
            sb5.append(Internal.sanitize(this.image_url));
        }
        if (this.title != null) {
            sb5.append(", title=");
            sb5.append(Internal.sanitize(this.title));
        }
        if (this.sub_title != null) {
            sb5.append(", sub_title=");
            sb5.append(Internal.sanitize(this.sub_title));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdPoster{");
        replace.append('}');
        return replace.toString();
    }

    public AdPoster(String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.image_url = str;
            if (str2 != null) {
                this.title = str2;
                if (str3 != null) {
                    this.sub_title = str3;
                    return;
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
        aVar.f383687a = this.image_url;
        aVar.f383688b = this.title;
        aVar.f383689c = this.sub_title;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
