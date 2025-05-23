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

/* loaded from: classes27.dex */
public final class AdOpenWxProgramAction extends Message<AdOpenWxProgramAction, a> {
    public static final ProtoAdapter<AdOpenWxProgramAction> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adTraceData", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String ad_trace_data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "appName", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String app_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "disableDialog", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final boolean disable_dialog;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdWebAction#ADAPTER", jsonName = "failedWebAction", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdWebAction failed_web_action;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "openUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String open_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "wxaAppId", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String wxa_app_id;

    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdOpenWxProgramAction, a> {

        /* renamed from: c, reason: collision with root package name */
        public AdWebAction f383643c;

        /* renamed from: a, reason: collision with root package name */
        public String f383641a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383642b = "";

        /* renamed from: d, reason: collision with root package name */
        public boolean f383644d = false;

        /* renamed from: e, reason: collision with root package name */
        public String f383645e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383646f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f383647g = "";

        public a a(String str) {
            this.f383646f = str;
            return this;
        }

        public a b(String str) {
            this.f383642b = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdOpenWxProgramAction build() {
            return new AdOpenWxProgramAction(this.f383641a, this.f383642b, this.f383643c, this.f383644d, this.f383645e, this.f383646f, this.f383647g, super.buildUnknownFields());
        }

        public a d(boolean z16) {
            this.f383644d = z16;
            return this;
        }

        public a e(AdWebAction adWebAction) {
            this.f383643c = adWebAction;
            return this;
        }

        public a f(String str) {
            this.f383641a = str;
            return this;
        }

        public a g(String str) {
            this.f383645e = str;
            return this;
        }

        public a h(String str) {
            this.f383647g = str;
            return this;
        }
    }

    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdOpenWxProgramAction> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdOpenWxProgramAction.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdOpenWxProgramAction", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdOpenWxProgramAction decode(ProtoReader protoReader) throws IOException {
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
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.e(AdWebAction.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            break;
                        case 5:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdOpenWxProgramAction adOpenWxProgramAction) throws IOException {
            if (!Objects.equals(adOpenWxProgramAction.open_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adOpenWxProgramAction.open_url);
            }
            if (!Objects.equals(adOpenWxProgramAction.app_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adOpenWxProgramAction.app_name);
            }
            if (!Objects.equals(adOpenWxProgramAction.failed_web_action, null)) {
                AdWebAction.ADAPTER.encodeWithTag(protoWriter, 3, adOpenWxProgramAction.failed_web_action);
            }
            if (!Objects.equals(Boolean.valueOf(adOpenWxProgramAction.disable_dialog), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, Boolean.valueOf(adOpenWxProgramAction.disable_dialog));
            }
            if (!Objects.equals(adOpenWxProgramAction.token, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, adOpenWxProgramAction.token);
            }
            if (!Objects.equals(adOpenWxProgramAction.ad_trace_data, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adOpenWxProgramAction.ad_trace_data);
            }
            if (!Objects.equals(adOpenWxProgramAction.wxa_app_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, adOpenWxProgramAction.wxa_app_id);
            }
            protoWriter.writeBytes(adOpenWxProgramAction.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdOpenWxProgramAction adOpenWxProgramAction) {
            int i3 = 0;
            if (!Objects.equals(adOpenWxProgramAction.open_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adOpenWxProgramAction.open_url);
            }
            if (!Objects.equals(adOpenWxProgramAction.app_name, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adOpenWxProgramAction.app_name);
            }
            if (!Objects.equals(adOpenWxProgramAction.failed_web_action, null)) {
                i3 += AdWebAction.ADAPTER.encodedSizeWithTag(3, adOpenWxProgramAction.failed_web_action);
            }
            if (!Objects.equals(Boolean.valueOf(adOpenWxProgramAction.disable_dialog), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(4, Boolean.valueOf(adOpenWxProgramAction.disable_dialog));
            }
            if (!Objects.equals(adOpenWxProgramAction.token, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, adOpenWxProgramAction.token);
            }
            if (!Objects.equals(adOpenWxProgramAction.ad_trace_data, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adOpenWxProgramAction.ad_trace_data);
            }
            if (!Objects.equals(adOpenWxProgramAction.wxa_app_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, adOpenWxProgramAction.wxa_app_id);
            }
            return i3 + adOpenWxProgramAction.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdOpenWxProgramAction redact(AdOpenWxProgramAction adOpenWxProgramAction) {
            a newBuilder = adOpenWxProgramAction.newBuilder();
            AdWebAction adWebAction = newBuilder.f383643c;
            if (adWebAction != null) {
                newBuilder.f383643c = AdWebAction.ADAPTER.redact(adWebAction);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdOpenWxProgramAction(String str, String str2, AdWebAction adWebAction, boolean z16, String str3, String str4, String str5) {
        this(str, str2, adWebAction, z16, str3, str4, str5, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdOpenWxProgramAction)) {
            return false;
        }
        AdOpenWxProgramAction adOpenWxProgramAction = (AdOpenWxProgramAction) obj;
        if (unknownFields().equals(adOpenWxProgramAction.unknownFields()) && Internal.equals(this.open_url, adOpenWxProgramAction.open_url) && Internal.equals(this.app_name, adOpenWxProgramAction.app_name) && Internal.equals(this.failed_web_action, adOpenWxProgramAction.failed_web_action) && Internal.equals(Boolean.valueOf(this.disable_dialog), Boolean.valueOf(adOpenWxProgramAction.disable_dialog)) && Internal.equals(this.token, adOpenWxProgramAction.token) && Internal.equals(this.ad_trace_data, adOpenWxProgramAction.ad_trace_data) && Internal.equals(this.wxa_app_id, adOpenWxProgramAction.wxa_app_id)) {
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
            String str = this.open_url;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.app_name;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            AdWebAction adWebAction = this.failed_web_action;
            if (adWebAction != null) {
                i17 = adWebAction.hashCode();
            } else {
                i17 = 0;
            }
            int a16 = (((i29 + i17) * 37) + com.tencent.aio.widget.textView.param.a.a(this.disable_dialog)) * 37;
            String str3 = this.token;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (a16 + i18) * 37;
            String str4 = this.ad_trace_data;
            if (str4 != null) {
                i19 = str4.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (i36 + i19) * 37;
            String str5 = this.wxa_app_id;
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
        if (this.open_url != null) {
            sb5.append(", open_url=");
            sb5.append(Internal.sanitize(this.open_url));
        }
        if (this.app_name != null) {
            sb5.append(", app_name=");
            sb5.append(Internal.sanitize(this.app_name));
        }
        if (this.failed_web_action != null) {
            sb5.append(", failed_web_action=");
            sb5.append(this.failed_web_action);
        }
        sb5.append(", disable_dialog=");
        sb5.append(this.disable_dialog);
        if (this.token != null) {
            sb5.append(", token=");
            sb5.append(Internal.sanitize(this.token));
        }
        if (this.ad_trace_data != null) {
            sb5.append(", ad_trace_data=");
            sb5.append(Internal.sanitize(this.ad_trace_data));
        }
        if (this.wxa_app_id != null) {
            sb5.append(", wxa_app_id=");
            sb5.append(Internal.sanitize(this.wxa_app_id));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdOpenWxProgramAction{");
        replace.append('}');
        return replace.toString();
    }

    public AdOpenWxProgramAction(String str, String str2, AdWebAction adWebAction, boolean z16, String str3, String str4, String str5, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.open_url = str;
            if (str2 != null) {
                this.app_name = str2;
                this.failed_web_action = adWebAction;
                this.disable_dialog = z16;
                if (str3 != null) {
                    this.token = str3;
                    if (str4 != null) {
                        this.ad_trace_data = str4;
                        if (str5 != null) {
                            this.wxa_app_id = str5;
                            return;
                        }
                        throw new IllegalArgumentException("wxa_app_id == null");
                    }
                    throw new IllegalArgumentException("ad_trace_data == null");
                }
                throw new IllegalArgumentException("token == null");
            }
            throw new IllegalArgumentException("app_name == null");
        }
        throw new IllegalArgumentException("open_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383641a = this.open_url;
        aVar.f383642b = this.app_name;
        aVar.f383643c = this.failed_web_action;
        aVar.f383644d = this.disable_dialog;
        aVar.f383645e = this.token;
        aVar.f383646f = this.ad_trace_data;
        aVar.f383647g = this.wxa_app_id;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
