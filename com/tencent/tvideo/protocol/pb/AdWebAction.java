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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdWebAction extends Message<AdWebAction, a> {
    public static final ProtoAdapter<AdWebAction> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "dstLinkUrlAppendParams", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> dst_link_url_append_params;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "landingUrlValid", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final boolean landing_url_valid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "packageName", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String package_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "webviewType", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int webview_type;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdWebAction, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383723a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f383724b = 0;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, String> f383725c = Internal.newMutableMap();

        /* renamed from: d, reason: collision with root package name */
        public String f383726d = "";

        /* renamed from: e, reason: collision with root package name */
        public boolean f383727e = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdWebAction build() {
            return new AdWebAction(this.f383723a, this.f383724b, this.f383725c, this.f383726d, this.f383727e, super.buildUnknownFields());
        }

        public a b(boolean z16) {
            this.f383727e = z16;
            return this;
        }

        public a c(String str) {
            this.f383726d = str;
            return this;
        }

        public a d(String str) {
            this.f383723a = str;
            return this;
        }

        public a e(int i3) {
            this.f383724b = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdWebAction> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383728a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdWebAction.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdWebAction", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> b() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383728a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383728a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdWebAction decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 5) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.b(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                    }
                                } else {
                                    aVar.c(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.f383725c.putAll(b().decode(protoReader));
                            }
                        } else {
                            aVar.e(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.d(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdWebAction adWebAction) throws IOException {
            if (!Objects.equals(adWebAction.url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adWebAction.url);
            }
            if (!Objects.equals(Integer.valueOf(adWebAction.webview_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(adWebAction.webview_type));
            }
            b().encodeWithTag(protoWriter, 3, adWebAction.dst_link_url_append_params);
            if (!Objects.equals(adWebAction.package_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adWebAction.package_name);
            }
            if (!Objects.equals(Boolean.valueOf(adWebAction.landing_url_valid), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, Boolean.valueOf(adWebAction.landing_url_valid));
            }
            protoWriter.writeBytes(adWebAction.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdWebAction adWebAction) {
            int i3;
            if (!Objects.equals(adWebAction.url, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, adWebAction.url) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(adWebAction.webview_type), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(adWebAction.webview_type));
            }
            int encodedSizeWithTag = i3 + b().encodedSizeWithTag(3, adWebAction.dst_link_url_append_params);
            if (!Objects.equals(adWebAction.package_name, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(4, adWebAction.package_name);
            }
            if (!Objects.equals(Boolean.valueOf(adWebAction.landing_url_valid), Boolean.FALSE)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(5, Boolean.valueOf(adWebAction.landing_url_valid));
            }
            return encodedSizeWithTag + adWebAction.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AdWebAction redact(AdWebAction adWebAction) {
            a newBuilder = adWebAction.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdWebAction(String str, int i3, Map<String, String> map, String str2, boolean z16) {
        this(str, i3, map, str2, z16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdWebAction)) {
            return false;
        }
        AdWebAction adWebAction = (AdWebAction) obj;
        if (unknownFields().equals(adWebAction.unknownFields()) && Internal.equals(this.url, adWebAction.url) && Internal.equals(Integer.valueOf(this.webview_type), Integer.valueOf(adWebAction.webview_type)) && this.dst_link_url_append_params.equals(adWebAction.dst_link_url_append_params) && Internal.equals(this.package_name, adWebAction.package_name) && Internal.equals(Boolean.valueOf(this.landing_url_valid), Boolean.valueOf(adWebAction.landing_url_valid))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.url;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = (((((hashCode + i3) * 37) + this.webview_type) * 37) + this.dst_link_url_append_params.hashCode()) * 37;
            String str2 = this.package_name;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int a16 = ((hashCode2 + i17) * 37) + com.tencent.aio.widget.textView.param.a.a(this.landing_url_valid);
            this.hashCode = a16;
            return a16;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.url != null) {
            sb5.append(", url=");
            sb5.append(Internal.sanitize(this.url));
        }
        sb5.append(", webview_type=");
        sb5.append(this.webview_type);
        if (!this.dst_link_url_append_params.isEmpty()) {
            sb5.append(", dst_link_url_append_params=");
            sb5.append(this.dst_link_url_append_params);
        }
        if (this.package_name != null) {
            sb5.append(", package_name=");
            sb5.append(Internal.sanitize(this.package_name));
        }
        sb5.append(", landing_url_valid=");
        sb5.append(this.landing_url_valid);
        StringBuilder replace = sb5.replace(0, 2, "AdWebAction{");
        replace.append('}');
        return replace.toString();
    }

    public AdWebAction(String str, int i3, Map<String, String> map, String str2, boolean z16, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.url = str;
            this.webview_type = i3;
            this.dst_link_url_append_params = Internal.immutableCopyOf("dst_link_url_append_params", map);
            if (str2 != null) {
                this.package_name = str2;
                this.landing_url_valid = z16;
                return;
            }
            throw new IllegalArgumentException("package_name == null");
        }
        throw new IllegalArgumentException("url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383723a = this.url;
        aVar.f383724b = this.webview_type;
        aVar.f383725c = Internal.copyOf(this.dst_link_url_append_params);
        aVar.f383726d = this.package_name;
        aVar.f383727e = this.landing_url_valid;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
