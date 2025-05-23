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
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdAndroidMarketInfo extends Message<AdAndroidMarketInfo, a> {
    public static final ProtoAdapter<AdAndroidMarketInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "enableMarketDownload", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean enable_market_download;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "marketDeepLink", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String market_deep_link;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "marketPackageName", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> market_package_name;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdAndroidMarketInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f383523a = false;

        /* renamed from: b, reason: collision with root package name */
        public String f383524b = "";

        /* renamed from: c, reason: collision with root package name */
        public List<String> f383525c = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdAndroidMarketInfo build() {
            return new AdAndroidMarketInfo(this.f383523a, this.f383524b, this.f383525c, super.buildUnknownFields());
        }

        public a b(boolean z16) {
            this.f383523a = z16;
            return this;
        }

        public a c(String str) {
            this.f383524b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdAndroidMarketInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdAndroidMarketInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdAndroidMarketInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdAndroidMarketInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.f383525c.add(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdAndroidMarketInfo adAndroidMarketInfo) throws IOException {
            if (!Objects.equals(Boolean.valueOf(adAndroidMarketInfo.enable_market_download), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(adAndroidMarketInfo.enable_market_download));
            }
            if (!Objects.equals(adAndroidMarketInfo.market_deep_link, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, adAndroidMarketInfo.market_deep_link);
            }
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 3, adAndroidMarketInfo.market_package_name);
            protoWriter.writeBytes(adAndroidMarketInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdAndroidMarketInfo adAndroidMarketInfo) {
            int i3 = 0;
            if (!Objects.equals(Boolean.valueOf(adAndroidMarketInfo.enable_market_download), Boolean.FALSE)) {
                i3 = 0 + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(adAndroidMarketInfo.enable_market_download));
            }
            if (!Objects.equals(adAndroidMarketInfo.market_deep_link, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, adAndroidMarketInfo.market_deep_link);
            }
            return i3 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, adAndroidMarketInfo.market_package_name) + adAndroidMarketInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdAndroidMarketInfo redact(AdAndroidMarketInfo adAndroidMarketInfo) {
            a newBuilder = adAndroidMarketInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdAndroidMarketInfo(boolean z16, String str, List<String> list) {
        this(z16, str, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdAndroidMarketInfo)) {
            return false;
        }
        AdAndroidMarketInfo adAndroidMarketInfo = (AdAndroidMarketInfo) obj;
        if (unknownFields().equals(adAndroidMarketInfo.unknownFields()) && Internal.equals(Boolean.valueOf(this.enable_market_download), Boolean.valueOf(adAndroidMarketInfo.enable_market_download)) && Internal.equals(this.market_deep_link, adAndroidMarketInfo.market_deep_link) && this.market_package_name.equals(adAndroidMarketInfo.market_package_name)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.enable_market_download)) * 37;
            String str = this.market_deep_link;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((hashCode + i3) * 37) + this.market_package_name.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", enable_market_download=");
        sb5.append(this.enable_market_download);
        if (this.market_deep_link != null) {
            sb5.append(", market_deep_link=");
            sb5.append(Internal.sanitize(this.market_deep_link));
        }
        if (!this.market_package_name.isEmpty()) {
            sb5.append(", market_package_name=");
            sb5.append(Internal.sanitize(this.market_package_name));
        }
        StringBuilder replace = sb5.replace(0, 2, "AdAndroidMarketInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AdAndroidMarketInfo(boolean z16, String str, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.enable_market_download = z16;
        if (str != null) {
            this.market_deep_link = str;
            this.market_package_name = Internal.immutableCopyOf("market_package_name", list);
            return;
        }
        throw new IllegalArgumentException("market_deep_link == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383523a = this.enable_market_download;
        aVar.f383524b = this.market_deep_link;
        aVar.f383525c = Internal.copyOf(this.market_package_name);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
