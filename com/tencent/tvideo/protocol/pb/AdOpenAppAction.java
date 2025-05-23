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
public final class AdOpenAppAction extends Message<AdOpenAppAction, a> {
    public static final ProtoAdapter<AdOpenAppAction> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "clipboardStr", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String clipboard_str;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdDownloadAction#ADAPTER", jsonName = "downloadItem", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final AdDownloadAction download_item;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdOpenWxProgramAction#ADAPTER", jsonName = "failedMiniappAction", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final AdOpenWxProgramAction failed_miniapp_action;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdWebAction#ADAPTER", jsonName = "failedWebAction", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AdWebAction failed_web_action;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdOpenAppFailedAction#ADAPTER", jsonName = "openFailedAction", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdOpenAppFailedAction open_failed_action;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "openUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String open_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "universalLinkUrl", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String universal_link_url;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdOpenAppAction, a> {

        /* renamed from: d, reason: collision with root package name */
        public AdDownloadAction f383637d;

        /* renamed from: e, reason: collision with root package name */
        public AdWebAction f383638e;

        /* renamed from: g, reason: collision with root package name */
        public AdOpenWxProgramAction f383640g;

        /* renamed from: a, reason: collision with root package name */
        public String f383634a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f383635b = "";

        /* renamed from: c, reason: collision with root package name */
        public AdOpenAppFailedAction f383636c = AdOpenAppFailedAction.AD_OPEN_APP_FAILED_UNKNOWN;

        /* renamed from: f, reason: collision with root package name */
        public String f383639f = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdOpenAppAction build() {
            return new AdOpenAppAction(this.f383634a, this.f383635b, this.f383636c, this.f383637d, this.f383638e, this.f383639f, this.f383640g, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f383635b = str;
            return this;
        }

        public a c(AdDownloadAction adDownloadAction) {
            this.f383637d = adDownloadAction;
            return this;
        }

        public a d(AdOpenWxProgramAction adOpenWxProgramAction) {
            this.f383640g = adOpenWxProgramAction;
            return this;
        }

        public a e(AdWebAction adWebAction) {
            this.f383638e = adWebAction;
            return this;
        }

        public a f(AdOpenAppFailedAction adOpenAppFailedAction) {
            this.f383636c = adOpenAppFailedAction;
            return this;
        }

        public a g(String str) {
            this.f383634a = str;
            return this;
        }

        public a h(String str) {
            this.f383639f = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdOpenAppAction> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdOpenAppAction.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdOpenAppAction", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdOpenAppAction decode(ProtoReader protoReader) throws IOException {
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
                            try {
                                aVar.f(AdOpenAppFailedAction.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 4:
                            aVar.c(AdDownloadAction.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.e(AdWebAction.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.d(AdOpenWxProgramAction.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdOpenAppAction adOpenAppAction) throws IOException {
            if (!Objects.equals(adOpenAppAction.open_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adOpenAppAction.open_url);
            }
            if (!Objects.equals(adOpenAppAction.clipboard_str, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adOpenAppAction.clipboard_str);
            }
            if (!Objects.equals(adOpenAppAction.open_failed_action, AdOpenAppFailedAction.AD_OPEN_APP_FAILED_UNKNOWN)) {
                AdOpenAppFailedAction.ADAPTER.encodeWithTag(protoWriter, 3, adOpenAppAction.open_failed_action);
            }
            if (!Objects.equals(adOpenAppAction.download_item, null)) {
                AdDownloadAction.ADAPTER.encodeWithTag(protoWriter, 4, adOpenAppAction.download_item);
            }
            if (!Objects.equals(adOpenAppAction.failed_web_action, null)) {
                AdWebAction.ADAPTER.encodeWithTag(protoWriter, 5, adOpenAppAction.failed_web_action);
            }
            if (!Objects.equals(adOpenAppAction.universal_link_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adOpenAppAction.universal_link_url);
            }
            if (!Objects.equals(adOpenAppAction.failed_miniapp_action, null)) {
                AdOpenWxProgramAction.ADAPTER.encodeWithTag(protoWriter, 7, adOpenAppAction.failed_miniapp_action);
            }
            protoWriter.writeBytes(adOpenAppAction.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdOpenAppAction adOpenAppAction) {
            int i3 = 0;
            if (!Objects.equals(adOpenAppAction.open_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adOpenAppAction.open_url);
            }
            if (!Objects.equals(adOpenAppAction.clipboard_str, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adOpenAppAction.clipboard_str);
            }
            if (!Objects.equals(adOpenAppAction.open_failed_action, AdOpenAppFailedAction.AD_OPEN_APP_FAILED_UNKNOWN)) {
                i3 += AdOpenAppFailedAction.ADAPTER.encodedSizeWithTag(3, adOpenAppAction.open_failed_action);
            }
            if (!Objects.equals(adOpenAppAction.download_item, null)) {
                i3 += AdDownloadAction.ADAPTER.encodedSizeWithTag(4, adOpenAppAction.download_item);
            }
            if (!Objects.equals(adOpenAppAction.failed_web_action, null)) {
                i3 += AdWebAction.ADAPTER.encodedSizeWithTag(5, adOpenAppAction.failed_web_action);
            }
            if (!Objects.equals(adOpenAppAction.universal_link_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, adOpenAppAction.universal_link_url);
            }
            if (!Objects.equals(adOpenAppAction.failed_miniapp_action, null)) {
                i3 += AdOpenWxProgramAction.ADAPTER.encodedSizeWithTag(7, adOpenAppAction.failed_miniapp_action);
            }
            return i3 + adOpenAppAction.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdOpenAppAction redact(AdOpenAppAction adOpenAppAction) {
            a newBuilder = adOpenAppAction.newBuilder();
            AdDownloadAction adDownloadAction = newBuilder.f383637d;
            if (adDownloadAction != null) {
                newBuilder.f383637d = AdDownloadAction.ADAPTER.redact(adDownloadAction);
            }
            AdWebAction adWebAction = newBuilder.f383638e;
            if (adWebAction != null) {
                newBuilder.f383638e = AdWebAction.ADAPTER.redact(adWebAction);
            }
            AdOpenWxProgramAction adOpenWxProgramAction = newBuilder.f383640g;
            if (adOpenWxProgramAction != null) {
                newBuilder.f383640g = AdOpenWxProgramAction.ADAPTER.redact(adOpenWxProgramAction);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdOpenAppAction(String str, String str2, AdOpenAppFailedAction adOpenAppFailedAction, AdDownloadAction adDownloadAction, AdWebAction adWebAction, String str3, AdOpenWxProgramAction adOpenWxProgramAction) {
        this(str, str2, adOpenAppFailedAction, adDownloadAction, adWebAction, str3, adOpenWxProgramAction, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdOpenAppAction)) {
            return false;
        }
        AdOpenAppAction adOpenAppAction = (AdOpenAppAction) obj;
        if (unknownFields().equals(adOpenAppAction.unknownFields()) && Internal.equals(this.open_url, adOpenAppAction.open_url) && Internal.equals(this.clipboard_str, adOpenAppAction.clipboard_str) && Internal.equals(this.open_failed_action, adOpenAppAction.open_failed_action) && Internal.equals(this.download_item, adOpenAppAction.download_item) && Internal.equals(this.failed_web_action, adOpenAppAction.failed_web_action) && Internal.equals(this.universal_link_url, adOpenAppAction.universal_link_url) && Internal.equals(this.failed_miniapp_action, adOpenAppAction.failed_miniapp_action)) {
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
            String str = this.open_url;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            String str2 = this.clipboard_str;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            AdOpenAppFailedAction adOpenAppFailedAction = this.open_failed_action;
            if (adOpenAppFailedAction != null) {
                i17 = adOpenAppFailedAction.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 37;
            AdDownloadAction adDownloadAction = this.download_item;
            if (adDownloadAction != null) {
                i18 = adDownloadAction.hashCode();
            } else {
                i18 = 0;
            }
            int i38 = (i37 + i18) * 37;
            AdWebAction adWebAction = this.failed_web_action;
            if (adWebAction != null) {
                i19 = adWebAction.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (i38 + i19) * 37;
            String str3 = this.universal_link_url;
            if (str3 != null) {
                i26 = str3.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 37;
            AdOpenWxProgramAction adOpenWxProgramAction = this.failed_miniapp_action;
            if (adOpenWxProgramAction != null) {
                i28 = adOpenWxProgramAction.hashCode();
            }
            int i47 = i46 + i28;
            this.hashCode = i47;
            return i47;
        }
        return i27;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.open_url != null) {
            sb5.append(", open_url=");
            sb5.append(Internal.sanitize(this.open_url));
        }
        if (this.clipboard_str != null) {
            sb5.append(", clipboard_str=");
            sb5.append(Internal.sanitize(this.clipboard_str));
        }
        if (this.open_failed_action != null) {
            sb5.append(", open_failed_action=");
            sb5.append(this.open_failed_action);
        }
        if (this.download_item != null) {
            sb5.append(", download_item=");
            sb5.append(this.download_item);
        }
        if (this.failed_web_action != null) {
            sb5.append(", failed_web_action=");
            sb5.append(this.failed_web_action);
        }
        if (this.universal_link_url != null) {
            sb5.append(", universal_link_url=");
            sb5.append(Internal.sanitize(this.universal_link_url));
        }
        if (this.failed_miniapp_action != null) {
            sb5.append(", failed_miniapp_action=");
            sb5.append(this.failed_miniapp_action);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdOpenAppAction{");
        replace.append('}');
        return replace.toString();
    }

    public AdOpenAppAction(String str, String str2, AdOpenAppFailedAction adOpenAppFailedAction, AdDownloadAction adDownloadAction, AdWebAction adWebAction, String str3, AdOpenWxProgramAction adOpenWxProgramAction, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.open_url = str;
            if (str2 != null) {
                this.clipboard_str = str2;
                if (adOpenAppFailedAction != null) {
                    this.open_failed_action = adOpenAppFailedAction;
                    this.download_item = adDownloadAction;
                    this.failed_web_action = adWebAction;
                    if (str3 != null) {
                        this.universal_link_url = str3;
                        this.failed_miniapp_action = adOpenWxProgramAction;
                        return;
                    }
                    throw new IllegalArgumentException("universal_link_url == null");
                }
                throw new IllegalArgumentException("open_failed_action == null");
            }
            throw new IllegalArgumentException("clipboard_str == null");
        }
        throw new IllegalArgumentException("open_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383634a = this.open_url;
        aVar.f383635b = this.clipboard_str;
        aVar.f383636c = this.open_failed_action;
        aVar.f383637d = this.download_item;
        aVar.f383638e = this.failed_web_action;
        aVar.f383639f = this.universal_link_url;
        aVar.f383640g = this.failed_miniapp_action;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
