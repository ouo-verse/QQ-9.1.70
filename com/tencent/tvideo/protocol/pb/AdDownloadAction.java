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
public final class AdDownloadAction extends Message<AdDownloadAction, a> {
    public static final ProtoAdapter<AdDownloadAction> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdAndroidMarketInfo#ADAPTER", jsonName = "androidMarketInfo", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final AdAndroidMarketInfo android_market_info;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdDownloadType#ADAPTER", jsonName = "downloadType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AdDownloadType download_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "downloadUrl", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String download_url;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdWebAction#ADAPTER", jsonName = "failedWebAction", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final AdWebAction failed_web_action;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "packageName", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String package_name;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdDownloadAction, a> {

        /* renamed from: a, reason: collision with root package name */
        public AdDownloadType f383548a = AdDownloadType.AD_DOWNLOAD_TYPE_UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        public String f383549b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f383550c = "";

        /* renamed from: d, reason: collision with root package name */
        public AdWebAction f383551d;

        /* renamed from: e, reason: collision with root package name */
        public AdAndroidMarketInfo f383552e;

        public a a(AdAndroidMarketInfo adAndroidMarketInfo) {
            this.f383552e = adAndroidMarketInfo;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdDownloadAction build() {
            return new AdDownloadAction(this.f383548a, this.f383549b, this.f383550c, this.f383551d, this.f383552e, super.buildUnknownFields());
        }

        public a c(AdDownloadType adDownloadType) {
            this.f383548a = adDownloadType;
            return this;
        }

        public a d(String str) {
            this.f383549b = str;
            return this;
        }

        public a e(AdWebAction adWebAction) {
            this.f383551d = adWebAction;
            return this;
        }

        public a f(String str) {
            this.f383550c = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdDownloadAction> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdDownloadAction.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdDownloadAction", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdDownloadAction decode(ProtoReader protoReader) throws IOException {
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
                                        aVar.a(AdAndroidMarketInfo.ADAPTER.decode(protoReader));
                                    }
                                } else {
                                    aVar.e(AdWebAction.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        try {
                            aVar.c(AdDownloadType.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                        }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdDownloadAction adDownloadAction) throws IOException {
            if (!Objects.equals(adDownloadAction.download_type, AdDownloadType.AD_DOWNLOAD_TYPE_UNKNOWN)) {
                AdDownloadType.ADAPTER.encodeWithTag(protoWriter, 1, adDownloadAction.download_type);
            }
            if (!Objects.equals(adDownloadAction.download_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adDownloadAction.download_url);
            }
            if (!Objects.equals(adDownloadAction.package_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, adDownloadAction.package_name);
            }
            if (!Objects.equals(adDownloadAction.failed_web_action, null)) {
                AdWebAction.ADAPTER.encodeWithTag(protoWriter, 4, adDownloadAction.failed_web_action);
            }
            if (!Objects.equals(adDownloadAction.android_market_info, null)) {
                AdAndroidMarketInfo.ADAPTER.encodeWithTag(protoWriter, 5, adDownloadAction.android_market_info);
            }
            protoWriter.writeBytes(adDownloadAction.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdDownloadAction adDownloadAction) {
            int i3 = 0;
            if (!Objects.equals(adDownloadAction.download_type, AdDownloadType.AD_DOWNLOAD_TYPE_UNKNOWN)) {
                i3 = 0 + AdDownloadType.ADAPTER.encodedSizeWithTag(1, adDownloadAction.download_type);
            }
            if (!Objects.equals(adDownloadAction.download_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adDownloadAction.download_url);
            }
            if (!Objects.equals(adDownloadAction.package_name, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, adDownloadAction.package_name);
            }
            if (!Objects.equals(adDownloadAction.failed_web_action, null)) {
                i3 += AdWebAction.ADAPTER.encodedSizeWithTag(4, adDownloadAction.failed_web_action);
            }
            if (!Objects.equals(adDownloadAction.android_market_info, null)) {
                i3 += AdAndroidMarketInfo.ADAPTER.encodedSizeWithTag(5, adDownloadAction.android_market_info);
            }
            return i3 + adDownloadAction.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdDownloadAction redact(AdDownloadAction adDownloadAction) {
            a newBuilder = adDownloadAction.newBuilder();
            AdWebAction adWebAction = newBuilder.f383551d;
            if (adWebAction != null) {
                newBuilder.f383551d = AdWebAction.ADAPTER.redact(adWebAction);
            }
            AdAndroidMarketInfo adAndroidMarketInfo = newBuilder.f383552e;
            if (adAndroidMarketInfo != null) {
                newBuilder.f383552e = AdAndroidMarketInfo.ADAPTER.redact(adAndroidMarketInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdDownloadAction(AdDownloadType adDownloadType, String str, String str2, AdWebAction adWebAction, AdAndroidMarketInfo adAndroidMarketInfo) {
        this(adDownloadType, str, str2, adWebAction, adAndroidMarketInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdDownloadAction)) {
            return false;
        }
        AdDownloadAction adDownloadAction = (AdDownloadAction) obj;
        if (unknownFields().equals(adDownloadAction.unknownFields()) && Internal.equals(this.download_type, adDownloadAction.download_type) && Internal.equals(this.download_url, adDownloadAction.download_url) && Internal.equals(this.package_name, adDownloadAction.package_name) && Internal.equals(this.failed_web_action, adDownloadAction.failed_web_action) && Internal.equals(this.android_market_info, adDownloadAction.android_market_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AdDownloadType adDownloadType = this.download_type;
            int i26 = 0;
            if (adDownloadType != null) {
                i3 = adDownloadType.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            String str = this.download_url;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            String str2 = this.package_name;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            AdWebAction adWebAction = this.failed_web_action;
            if (adWebAction != null) {
                i18 = adWebAction.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            AdAndroidMarketInfo adAndroidMarketInfo = this.android_market_info;
            if (adAndroidMarketInfo != null) {
                i26 = adAndroidMarketInfo.hashCode();
            }
            int i37 = i36 + i26;
            this.hashCode = i37;
            return i37;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.download_type != null) {
            sb5.append(", download_type=");
            sb5.append(this.download_type);
        }
        if (this.download_url != null) {
            sb5.append(", download_url=");
            sb5.append(Internal.sanitize(this.download_url));
        }
        if (this.package_name != null) {
            sb5.append(", package_name=");
            sb5.append(Internal.sanitize(this.package_name));
        }
        if (this.failed_web_action != null) {
            sb5.append(", failed_web_action=");
            sb5.append(this.failed_web_action);
        }
        if (this.android_market_info != null) {
            sb5.append(", android_market_info=");
            sb5.append(this.android_market_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdDownloadAction{");
        replace.append('}');
        return replace.toString();
    }

    public AdDownloadAction(AdDownloadType adDownloadType, String str, String str2, AdWebAction adWebAction, AdAndroidMarketInfo adAndroidMarketInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        if (adDownloadType != null) {
            this.download_type = adDownloadType;
            if (str != null) {
                this.download_url = str;
                if (str2 != null) {
                    this.package_name = str2;
                    this.failed_web_action = adWebAction;
                    this.android_market_info = adAndroidMarketInfo;
                    return;
                }
                throw new IllegalArgumentException("package_name == null");
            }
            throw new IllegalArgumentException("download_url == null");
        }
        throw new IllegalArgumentException("download_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383548a = this.download_type;
        aVar.f383549b = this.download_url;
        aVar.f383550c = this.package_name;
        aVar.f383551d = this.failed_web_action;
        aVar.f383552e = this.android_market_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
