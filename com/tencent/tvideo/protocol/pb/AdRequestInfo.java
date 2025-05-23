package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdRequestInfo extends Message<AdRequestInfo, a> {
    public static final ProtoAdapter<AdRequestInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adQqOpenId", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String ad_qqOpenId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adRedirectContexts", label = WireField.Label.REPEATED, tag = 4)
    public final List<String> ad_redirect_contexts;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdSceneDesc#ADAPTER", jsonName = "adSceneDesc", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final AdSceneDesc ad_scene_desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "appVersion", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String app_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "requestCookie", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String request_cookie;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String request_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "vrPublicParamsDict", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> vr_public_params_dict;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.WechatVersionInfo#ADAPTER", jsonName = "wechatVersionInfo", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final WechatVersionInfo wechat_version_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "wxVersionCode", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final int wx_version_code;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdRequestInfo, a> {

        /* renamed from: g, reason: collision with root package name */
        public AdSceneDesc f383709g;

        /* renamed from: i, reason: collision with root package name */
        public WechatVersionInfo f383711i;

        /* renamed from: a, reason: collision with root package name */
        public String f383703a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383704b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383705c = "";

        /* renamed from: d, reason: collision with root package name */
        public List<String> f383706d = Internal.newMutableList();

        /* renamed from: e, reason: collision with root package name */
        public String f383707e = "";

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f383708f = Internal.newMutableMap();

        /* renamed from: h, reason: collision with root package name */
        public int f383710h = 0;

        public a a(String str) {
            this.f383707e = str;
            return this;
        }

        public a b(AdSceneDesc adSceneDesc) {
            this.f383709g = adSceneDesc;
            return this;
        }

        public a c(String str) {
            this.f383704b = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdRequestInfo build() {
            return new AdRequestInfo(this.f383703a, this.f383704b, this.f383705c, this.f383706d, this.f383707e, this.f383708f, this.f383709g, this.f383710h, this.f383711i, super.buildUnknownFields());
        }

        public a e(String str) {
            this.f383705c = str;
            return this;
        }

        public a f(String str) {
            this.f383703a = str;
            return this;
        }

        public a g(WechatVersionInfo wechatVersionInfo) {
            this.f383711i = wechatVersionInfo;
            return this;
        }

        public a h(int i3) {
            this.f383710h = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdRequestInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f383712a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdRequestInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdRequestInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f383712a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f383712a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdRequestInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.f383706d.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.f383708f.putAll(e().decode(protoReader));
                            break;
                        case 7:
                            aVar.b(AdSceneDesc.ADAPTER.decode(protoReader));
                            break;
                        case 8:
                            aVar.h(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 9:
                            aVar.g(WechatVersionInfo.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdRequestInfo adRequestInfo) throws IOException {
            if (!Objects.equals(adRequestInfo.request_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adRequestInfo.request_id);
            }
            if (!Objects.equals(adRequestInfo.app_version, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adRequestInfo.app_version);
            }
            if (!Objects.equals(adRequestInfo.request_cookie, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adRequestInfo.request_cookie);
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 4, adRequestInfo.ad_redirect_contexts);
            if (!Objects.equals(adRequestInfo.ad_qqOpenId, "")) {
                protoAdapter.encodeWithTag(protoWriter, 5, adRequestInfo.ad_qqOpenId);
            }
            e().encodeWithTag(protoWriter, 6, adRequestInfo.vr_public_params_dict);
            if (!Objects.equals(adRequestInfo.ad_scene_desc, null)) {
                AdSceneDesc.ADAPTER.encodeWithTag(protoWriter, 7, adRequestInfo.ad_scene_desc);
            }
            if (!Objects.equals(Integer.valueOf(adRequestInfo.wx_version_code), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 8, Integer.valueOf(adRequestInfo.wx_version_code));
            }
            if (!Objects.equals(adRequestInfo.wechat_version_info, null)) {
                WechatVersionInfo.ADAPTER.encodeWithTag(protoWriter, 9, adRequestInfo.wechat_version_info);
            }
            protoWriter.writeBytes(adRequestInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdRequestInfo adRequestInfo) {
            int i3;
            if (!Objects.equals(adRequestInfo.request_id, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, adRequestInfo.request_id) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(adRequestInfo.app_version, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adRequestInfo.app_version);
            }
            if (!Objects.equals(adRequestInfo.request_cookie, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adRequestInfo.request_cookie);
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = i3 + protoAdapter.asRepeated().encodedSizeWithTag(4, adRequestInfo.ad_redirect_contexts);
            if (!Objects.equals(adRequestInfo.ad_qqOpenId, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(5, adRequestInfo.ad_qqOpenId);
            }
            int encodedSizeWithTag2 = encodedSizeWithTag + e().encodedSizeWithTag(6, adRequestInfo.vr_public_params_dict);
            if (!Objects.equals(adRequestInfo.ad_scene_desc, null)) {
                encodedSizeWithTag2 += AdSceneDesc.ADAPTER.encodedSizeWithTag(7, adRequestInfo.ad_scene_desc);
            }
            if (!Objects.equals(Integer.valueOf(adRequestInfo.wx_version_code), 0)) {
                encodedSizeWithTag2 += ProtoAdapter.INT32.encodedSizeWithTag(8, Integer.valueOf(adRequestInfo.wx_version_code));
            }
            if (!Objects.equals(adRequestInfo.wechat_version_info, null)) {
                encodedSizeWithTag2 += WechatVersionInfo.ADAPTER.encodedSizeWithTag(9, adRequestInfo.wechat_version_info);
            }
            return encodedSizeWithTag2 + adRequestInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdRequestInfo redact(AdRequestInfo adRequestInfo) {
            a newBuilder = adRequestInfo.newBuilder();
            AdSceneDesc adSceneDesc = newBuilder.f383709g;
            if (adSceneDesc != null) {
                newBuilder.f383709g = AdSceneDesc.ADAPTER.redact(adSceneDesc);
            }
            WechatVersionInfo wechatVersionInfo = newBuilder.f383711i;
            if (wechatVersionInfo != null) {
                newBuilder.f383711i = WechatVersionInfo.ADAPTER.redact(wechatVersionInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdRequestInfo(String str, String str2, String str3, List<String> list, String str4, Map<String, String> map, AdSceneDesc adSceneDesc, int i3, WechatVersionInfo wechatVersionInfo) {
        this(str, str2, str3, list, str4, map, adSceneDesc, i3, wechatVersionInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdRequestInfo)) {
            return false;
        }
        AdRequestInfo adRequestInfo = (AdRequestInfo) obj;
        if (unknownFields().equals(adRequestInfo.unknownFields()) && Internal.equals(this.request_id, adRequestInfo.request_id) && Internal.equals(this.app_version, adRequestInfo.app_version) && Internal.equals(this.request_cookie, adRequestInfo.request_cookie) && this.ad_redirect_contexts.equals(adRequestInfo.ad_redirect_contexts) && Internal.equals(this.ad_qqOpenId, adRequestInfo.ad_qqOpenId) && this.vr_public_params_dict.equals(adRequestInfo.vr_public_params_dict) && Internal.equals(this.ad_scene_desc, adRequestInfo.ad_scene_desc) && Internal.equals(Integer.valueOf(this.wx_version_code), Integer.valueOf(adRequestInfo.wx_version_code)) && Internal.equals(this.wechat_version_info, adRequestInfo.wechat_version_info)) {
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
            String str = this.request_id;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.app_version;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str3 = this.request_cookie;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((i29 + i17) * 37) + this.ad_redirect_contexts.hashCode()) * 37;
            String str4 = this.ad_qqOpenId;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode3 = (((hashCode2 + i18) * 37) + this.vr_public_params_dict.hashCode()) * 37;
            AdSceneDesc adSceneDesc = this.ad_scene_desc;
            if (adSceneDesc != null) {
                i19 = adSceneDesc.hashCode();
            } else {
                i19 = 0;
            }
            int i36 = (((hashCode3 + i19) * 37) + this.wx_version_code) * 37;
            WechatVersionInfo wechatVersionInfo = this.wechat_version_info;
            if (wechatVersionInfo != null) {
                i27 = wechatVersionInfo.hashCode();
            }
            int i37 = i36 + i27;
            this.hashCode = i37;
            return i37;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.request_id != null) {
            sb5.append(", request_id=");
            sb5.append(Internal.sanitize(this.request_id));
        }
        if (this.app_version != null) {
            sb5.append(", app_version=");
            sb5.append(Internal.sanitize(this.app_version));
        }
        if (this.request_cookie != null) {
            sb5.append(", request_cookie=");
            sb5.append(Internal.sanitize(this.request_cookie));
        }
        if (!this.ad_redirect_contexts.isEmpty()) {
            sb5.append(", ad_redirect_contexts=");
            sb5.append(Internal.sanitize(this.ad_redirect_contexts));
        }
        if (this.ad_qqOpenId != null) {
            sb5.append(", ad_qqOpenId=");
            sb5.append(Internal.sanitize(this.ad_qqOpenId));
        }
        if (!this.vr_public_params_dict.isEmpty()) {
            sb5.append(", vr_public_params_dict=");
            sb5.append(this.vr_public_params_dict);
        }
        if (this.ad_scene_desc != null) {
            sb5.append(", ad_scene_desc=");
            sb5.append(this.ad_scene_desc);
        }
        sb5.append(", wx_version_code=");
        sb5.append(this.wx_version_code);
        if (this.wechat_version_info != null) {
            sb5.append(", wechat_version_info=");
            sb5.append(this.wechat_version_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdRequestInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdRequestInfo(String str, String str2, String str3, List<String> list, String str4, Map<String, String> map, AdSceneDesc adSceneDesc, int i3, WechatVersionInfo wechatVersionInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.request_id = str;
            if (str2 != null) {
                this.app_version = str2;
                if (str3 != null) {
                    this.request_cookie = str3;
                    this.ad_redirect_contexts = Internal.immutableCopyOf("ad_redirect_contexts", list);
                    if (str4 != null) {
                        this.ad_qqOpenId = str4;
                        this.vr_public_params_dict = Internal.immutableCopyOf("vr_public_params_dict", map);
                        this.ad_scene_desc = adSceneDesc;
                        this.wx_version_code = i3;
                        this.wechat_version_info = wechatVersionInfo;
                        return;
                    }
                    throw new IllegalArgumentException("ad_qqOpenId == null");
                }
                throw new IllegalArgumentException("request_cookie == null");
            }
            throw new IllegalArgumentException("app_version == null");
        }
        throw new IllegalArgumentException("request_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383703a = this.request_id;
        aVar.f383704b = this.app_version;
        aVar.f383705c = this.request_cookie;
        aVar.f383706d = Internal.copyOf(this.ad_redirect_contexts);
        aVar.f383707e = this.ad_qqOpenId;
        aVar.f383708f = Internal.copyOf(this.vr_public_params_dict);
        aVar.f383709g = this.ad_scene_desc;
        aVar.f383710h = this.wx_version_code;
        aVar.f383711i = this.wechat_version_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
