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
public final class AdExtraSystemInfo extends Message<AdExtraSystemInfo, a> {
    public static final ProtoAdapter<AdExtraSystemInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "chromeVersion", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String chrome_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "javaVmVersion", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String java_vm_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "swSize", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final int sw_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "systemBuildId", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String system_build_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "systemBuildVersionCodeName", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String system_build_version_code_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "systemBuildVersionRelease", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String system_build_version_release;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "systemIncremental", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String system_incremental;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "systemReleaseOrCodename", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final String system_release_or_codename;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "webviewUserAgent", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final String webview_user_agent;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdExtraSystemInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f383568a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383569b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383570c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f383571d = "";

        /* renamed from: e, reason: collision with root package name */
        public int f383572e = 0;

        /* renamed from: f, reason: collision with root package name */
        public String f383573f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f383574g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f383575h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f383576i = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdExtraSystemInfo build() {
            return new AdExtraSystemInfo(this.f383568a, this.f383569b, this.f383570c, this.f383571d, this.f383572e, this.f383573f, this.f383574g, this.f383575h, this.f383576i, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383571d = str;
            return this;
        }

        public a c(String str) {
            this.f383573f = str;
            return this;
        }

        public a d(int i3) {
            this.f383572e = i3;
            return this;
        }

        public a e(String str) {
            this.f383570c = str;
            return this;
        }

        public a f(String str) {
            this.f383569b = str;
            return this;
        }

        public a g(String str) {
            this.f383568a = str;
            return this;
        }

        public a h(String str) {
            this.f383574g = str;
            return this;
        }

        public a i(String str) {
            this.f383575h = str;
            return this;
        }

        public a j(String str) {
            this.f383576i = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdExtraSystemInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdExtraSystemInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdExtraSystemInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdExtraSystemInfo decode(ProtoReader protoReader) throws IOException {
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
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 6:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            aVar.i(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            aVar.j(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdExtraSystemInfo adExtraSystemInfo) throws IOException {
            if (!Objects.equals(adExtraSystemInfo.system_build_version_release, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adExtraSystemInfo.system_build_version_release);
            }
            if (!Objects.equals(adExtraSystemInfo.system_build_version_code_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adExtraSystemInfo.system_build_version_code_name);
            }
            if (!Objects.equals(adExtraSystemInfo.system_build_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adExtraSystemInfo.system_build_id);
            }
            if (!Objects.equals(adExtraSystemInfo.chrome_version, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adExtraSystemInfo.chrome_version);
            }
            if (!Objects.equals(Integer.valueOf(adExtraSystemInfo.sw_size), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, Integer.valueOf(adExtraSystemInfo.sw_size));
            }
            if (!Objects.equals(adExtraSystemInfo.java_vm_version, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adExtraSystemInfo.java_vm_version);
            }
            if (!Objects.equals(adExtraSystemInfo.system_incremental, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, adExtraSystemInfo.system_incremental);
            }
            if (!Objects.equals(adExtraSystemInfo.system_release_or_codename, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, adExtraSystemInfo.system_release_or_codename);
            }
            if (!Objects.equals(adExtraSystemInfo.webview_user_agent, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, adExtraSystemInfo.webview_user_agent);
            }
            protoWriter.writeBytes(adExtraSystemInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdExtraSystemInfo adExtraSystemInfo) {
            int i3;
            if (!Objects.equals(adExtraSystemInfo.system_build_version_release, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, adExtraSystemInfo.system_build_version_release) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(adExtraSystemInfo.system_build_version_code_name, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adExtraSystemInfo.system_build_version_code_name);
            }
            if (!Objects.equals(adExtraSystemInfo.system_build_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adExtraSystemInfo.system_build_id);
            }
            if (!Objects.equals(adExtraSystemInfo.chrome_version, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, adExtraSystemInfo.chrome_version);
            }
            if (!Objects.equals(Integer.valueOf(adExtraSystemInfo.sw_size), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(adExtraSystemInfo.sw_size));
            }
            if (!Objects.equals(adExtraSystemInfo.java_vm_version, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adExtraSystemInfo.java_vm_version);
            }
            if (!Objects.equals(adExtraSystemInfo.system_incremental, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, adExtraSystemInfo.system_incremental);
            }
            if (!Objects.equals(adExtraSystemInfo.system_release_or_codename, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(8, adExtraSystemInfo.system_release_or_codename);
            }
            if (!Objects.equals(adExtraSystemInfo.webview_user_agent, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(9, adExtraSystemInfo.webview_user_agent);
            }
            return i3 + adExtraSystemInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdExtraSystemInfo redact(AdExtraSystemInfo adExtraSystemInfo) {
            a newBuilder = adExtraSystemInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdExtraSystemInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8) {
        this(str, str2, str3, str4, i3, str5, str6, str7, str8, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdExtraSystemInfo)) {
            return false;
        }
        AdExtraSystemInfo adExtraSystemInfo = (AdExtraSystemInfo) obj;
        if (unknownFields().equals(adExtraSystemInfo.unknownFields()) && Internal.equals(this.system_build_version_release, adExtraSystemInfo.system_build_version_release) && Internal.equals(this.system_build_version_code_name, adExtraSystemInfo.system_build_version_code_name) && Internal.equals(this.system_build_id, adExtraSystemInfo.system_build_id) && Internal.equals(this.chrome_version, adExtraSystemInfo.chrome_version) && Internal.equals(Integer.valueOf(this.sw_size), Integer.valueOf(adExtraSystemInfo.sw_size)) && Internal.equals(this.java_vm_version, adExtraSystemInfo.java_vm_version) && Internal.equals(this.system_incremental, adExtraSystemInfo.system_incremental) && Internal.equals(this.system_release_or_codename, adExtraSystemInfo.system_release_or_codename) && Internal.equals(this.webview_user_agent, adExtraSystemInfo.webview_user_agent)) {
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
        int i27;
        int i28 = this.hashCode;
        if (i28 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.system_build_version_release;
            int i29 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i36 = (hashCode + i3) * 37;
            String str2 = this.system_build_version_code_name;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i37 = (i36 + i16) * 37;
            String str3 = this.system_build_id;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i38 = (i37 + i17) * 37;
            String str4 = this.chrome_version;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i39 = (((i38 + i18) * 37) + this.sw_size) * 37;
            String str5 = this.java_vm_version;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i46 = (i39 + i19) * 37;
            String str6 = this.system_incremental;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i47 = (i46 + i26) * 37;
            String str7 = this.system_release_or_codename;
            if (str7 != null) {
                i27 = str7.hashCode();
            } else {
                i27 = 0;
            }
            int i48 = (i47 + i27) * 37;
            String str8 = this.webview_user_agent;
            if (str8 != null) {
                i29 = str8.hashCode();
            }
            int i49 = i48 + i29;
            this.hashCode = i49;
            return i49;
        }
        return i28;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.system_build_version_release != null) {
            sb5.append(", system_build_version_release=");
            sb5.append(Internal.sanitize(this.system_build_version_release));
        }
        if (this.system_build_version_code_name != null) {
            sb5.append(", system_build_version_code_name=");
            sb5.append(Internal.sanitize(this.system_build_version_code_name));
        }
        if (this.system_build_id != null) {
            sb5.append(", system_build_id=");
            sb5.append(Internal.sanitize(this.system_build_id));
        }
        if (this.chrome_version != null) {
            sb5.append(", chrome_version=");
            sb5.append(Internal.sanitize(this.chrome_version));
        }
        sb5.append(", sw_size=");
        sb5.append(this.sw_size);
        if (this.java_vm_version != null) {
            sb5.append(", java_vm_version=");
            sb5.append(Internal.sanitize(this.java_vm_version));
        }
        if (this.system_incremental != null) {
            sb5.append(", system_incremental=");
            sb5.append(Internal.sanitize(this.system_incremental));
        }
        if (this.system_release_or_codename != null) {
            sb5.append(", system_release_or_codename=");
            sb5.append(Internal.sanitize(this.system_release_or_codename));
        }
        if (this.webview_user_agent != null) {
            sb5.append(", webview_user_agent=");
            sb5.append(Internal.sanitize(this.webview_user_agent));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdExtraSystemInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdExtraSystemInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.system_build_version_release = str;
            if (str2 != null) {
                this.system_build_version_code_name = str2;
                if (str3 != null) {
                    this.system_build_id = str3;
                    if (str4 != null) {
                        this.chrome_version = str4;
                        this.sw_size = i3;
                        if (str5 != null) {
                            this.java_vm_version = str5;
                            if (str6 != null) {
                                this.system_incremental = str6;
                                if (str7 != null) {
                                    this.system_release_or_codename = str7;
                                    if (str8 != null) {
                                        this.webview_user_agent = str8;
                                        return;
                                    }
                                    throw new IllegalArgumentException("webview_user_agent == null");
                                }
                                throw new IllegalArgumentException("system_release_or_codename == null");
                            }
                            throw new IllegalArgumentException("system_incremental == null");
                        }
                        throw new IllegalArgumentException("java_vm_version == null");
                    }
                    throw new IllegalArgumentException("chrome_version == null");
                }
                throw new IllegalArgumentException("system_build_id == null");
            }
            throw new IllegalArgumentException("system_build_version_code_name == null");
        }
        throw new IllegalArgumentException("system_build_version_release == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383568a = this.system_build_version_release;
        aVar.f383569b = this.system_build_version_code_name;
        aVar.f383570c = this.system_build_id;
        aVar.f383571d = this.chrome_version;
        aVar.f383572e = this.sw_size;
        aVar.f383573f = this.java_vm_version;
        aVar.f383574g = this.system_incremental;
        aVar.f383575h = this.system_release_or_codename;
        aVar.f383576i = this.webview_user_agent;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
