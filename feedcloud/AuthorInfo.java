package feedcloud;

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
/* loaded from: classes28.dex */
public final class AuthorInfo extends Message<AuthorInfo, a> {
    public static final ProtoAdapter<AuthorInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cateInfo", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String cate_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "organName", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String organ_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "outSourceConfirm", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String out_source_confirm;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "pubKind", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String pub_kind;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "pubQuality", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String pub_quality;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String source;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<AuthorInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f398412a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f398413b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f398414c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f398415d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f398416e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f398417f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthorInfo build() {
            return new AuthorInfo(this.f398412a, this.f398413b, this.f398414c, this.f398415d, this.f398416e, this.f398417f, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398413b = str;
            return this;
        }

        public a c(String str) {
            this.f398417f = str;
            return this;
        }

        public a d(String str) {
            this.f398416e = str;
            return this;
        }

        public a e(String str) {
            this.f398414c = str;
            return this;
        }

        public a f(String str) {
            this.f398415d = str;
            return this;
        }

        public a g(String str) {
            this.f398412a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<AuthorInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AuthorInfo.class, "type.googleapis.com/trpc.feedcloud.client_debug.AuthorInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthorInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AuthorInfo authorInfo) throws IOException {
            if (!Objects.equals(authorInfo.source, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, authorInfo.source);
            }
            if (!Objects.equals(authorInfo.cate_info, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, authorInfo.cate_info);
            }
            if (!Objects.equals(authorInfo.pub_kind, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, authorInfo.pub_kind);
            }
            if (!Objects.equals(authorInfo.pub_quality, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, authorInfo.pub_quality);
            }
            if (!Objects.equals(authorInfo.out_source_confirm, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, authorInfo.out_source_confirm);
            }
            if (!Objects.equals(authorInfo.organ_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, authorInfo.organ_name);
            }
            protoWriter.writeBytes(authorInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AuthorInfo authorInfo) {
            int i3 = 0;
            if (!Objects.equals(authorInfo.source, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, authorInfo.source);
            }
            if (!Objects.equals(authorInfo.cate_info, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, authorInfo.cate_info);
            }
            if (!Objects.equals(authorInfo.pub_kind, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, authorInfo.pub_kind);
            }
            if (!Objects.equals(authorInfo.pub_quality, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, authorInfo.pub_quality);
            }
            if (!Objects.equals(authorInfo.out_source_confirm, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, authorInfo.out_source_confirm);
            }
            if (!Objects.equals(authorInfo.organ_name, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, authorInfo.organ_name);
            }
            return i3 + authorInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AuthorInfo redact(AuthorInfo authorInfo) {
            a newBuilder = authorInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AuthorInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthorInfo)) {
            return false;
        }
        AuthorInfo authorInfo = (AuthorInfo) obj;
        if (unknownFields().equals(authorInfo.unknownFields()) && Internal.equals(this.source, authorInfo.source) && Internal.equals(this.cate_info, authorInfo.cate_info) && Internal.equals(this.pub_kind, authorInfo.pub_kind) && Internal.equals(this.pub_quality, authorInfo.pub_quality) && Internal.equals(this.out_source_confirm, authorInfo.out_source_confirm) && Internal.equals(this.organ_name, authorInfo.organ_name)) {
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
            String str = this.source;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.cate_info;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str3 = this.pub_kind;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str4 = this.pub_quality;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            String str5 = this.out_source_confirm;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            String str6 = this.organ_name;
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
        if (this.source != null) {
            sb5.append(", source=");
            sb5.append(Internal.sanitize(this.source));
        }
        if (this.cate_info != null) {
            sb5.append(", cate_info=");
            sb5.append(Internal.sanitize(this.cate_info));
        }
        if (this.pub_kind != null) {
            sb5.append(", pub_kind=");
            sb5.append(Internal.sanitize(this.pub_kind));
        }
        if (this.pub_quality != null) {
            sb5.append(", pub_quality=");
            sb5.append(Internal.sanitize(this.pub_quality));
        }
        if (this.out_source_confirm != null) {
            sb5.append(", out_source_confirm=");
            sb5.append(Internal.sanitize(this.out_source_confirm));
        }
        if (this.organ_name != null) {
            sb5.append(", organ_name=");
            sb5.append(Internal.sanitize(this.organ_name));
        }
        StringBuilder replace = sb5.replace(0, 2, "AuthorInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AuthorInfo(String str, String str2, String str3, String str4, String str5, String str6, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.source = str;
            if (str2 != null) {
                this.cate_info = str2;
                if (str3 != null) {
                    this.pub_kind = str3;
                    if (str4 != null) {
                        this.pub_quality = str4;
                        if (str5 != null) {
                            this.out_source_confirm = str5;
                            if (str6 != null) {
                                this.organ_name = str6;
                                return;
                            }
                            throw new IllegalArgumentException("organ_name == null");
                        }
                        throw new IllegalArgumentException("out_source_confirm == null");
                    }
                    throw new IllegalArgumentException("pub_quality == null");
                }
                throw new IllegalArgumentException("pub_kind == null");
            }
            throw new IllegalArgumentException("cate_info == null");
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398412a = this.source;
        aVar.f398413b = this.cate_info;
        aVar.f398414c = this.pub_kind;
        aVar.f398415d = this.pub_quality;
        aVar.f398416e = this.out_source_confirm;
        aVar.f398417f = this.organ_name;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
