package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParamKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class AdOrderItem extends Message<AdOrderItem, a> {
    public static final ProtoAdapter<AdOrderItem> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adRefreshContext", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String ad_refresh_context;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String ad_report_key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "adReportParam", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String ad_report_param;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdExtraReportItem#ADAPTER", jsonName = "extraReportParam", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdExtraReportItem extra_report_param;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String order_id;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdReportList#ADAPTER", jsonName = "reportDict", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Map<Integer, AdReportList> report_dict;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String unique_id;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdVRReportList#ADAPTER", jsonName = "vrReportDict", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    public final Map<Integer, AdVRReportList> vr_report_dict;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<AdOrderItem, a> {

        /* renamed from: c, reason: collision with root package name */
        public AdExtraReportItem f383650c;

        /* renamed from: a, reason: collision with root package name */
        public String f383648a = "";

        /* renamed from: b, reason: collision with root package name */
        public Map<Integer, AdReportList> f383649b = Internal.newMutableMap();

        /* renamed from: d, reason: collision with root package name */
        public String f383651d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f383652e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383653f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f383654g = "";

        /* renamed from: h, reason: collision with root package name */
        public Map<Integer, AdVRReportList> f383655h = Internal.newMutableMap();

        public a a(String str) {
            this.f383654g = str;
            return this;
        }

        public a b(String str) {
            this.f383651d = str;
            return this;
        }

        public a c(String str) {
            this.f383652e = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdOrderItem build() {
            return new AdOrderItem(this.f383648a, this.f383649b, this.f383650c, this.f383651d, this.f383652e, this.f383653f, this.f383654g, this.f383655h, super.buildUnknownFields());
        }

        public a e(AdExtraReportItem adExtraReportItem) {
            this.f383650c = adExtraReportItem;
            return this;
        }

        public a f(String str) {
            this.f383648a = str;
            return this;
        }

        public a g(String str) {
            this.f383653f = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<AdOrderItem> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<Integer, AdReportList>> f383656a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoAdapter<Map<Integer, AdVRReportList>> f383657b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdOrderItem.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.AdOrderItem", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<Integer, AdReportList>> e() {
            ProtoAdapter<Map<Integer, AdReportList>> protoAdapter = this.f383656a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<Integer, AdReportList>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, AdReportList.ADAPTER);
                this.f383656a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        private ProtoAdapter<Map<Integer, AdVRReportList>> f() {
            ProtoAdapter<Map<Integer, AdVRReportList>> protoAdapter = this.f383657b;
            if (protoAdapter == null) {
                ProtoAdapter<Map<Integer, AdVRReportList>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, AdVRReportList.ADAPTER);
                this.f383657b = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdOrderItem decode(ProtoReader protoReader) throws IOException {
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
                            aVar.f383649b.putAll(e().decode(protoReader));
                            break;
                        case 3:
                            aVar.e(AdExtraReportItem.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            aVar.f383655h.putAll(f().decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, AdOrderItem adOrderItem) throws IOException {
            if (!Objects.equals(adOrderItem.order_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, adOrderItem.order_id);
            }
            e().encodeWithTag(protoWriter, 2, adOrderItem.report_dict);
            if (!Objects.equals(adOrderItem.extra_report_param, null)) {
                AdExtraReportItem.ADAPTER.encodeWithTag(protoWriter, 3, adOrderItem.extra_report_param);
            }
            if (!Objects.equals(adOrderItem.ad_report_key, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, adOrderItem.ad_report_key);
            }
            if (!Objects.equals(adOrderItem.ad_report_param, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, adOrderItem.ad_report_param);
            }
            if (!Objects.equals(adOrderItem.unique_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, adOrderItem.unique_id);
            }
            if (!Objects.equals(adOrderItem.ad_refresh_context, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, adOrderItem.ad_refresh_context);
            }
            f().encodeWithTag(protoWriter, 8, adOrderItem.vr_report_dict);
            protoWriter.writeBytes(adOrderItem.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdOrderItem adOrderItem) {
            int i3 = 0;
            if (!Objects.equals(adOrderItem.order_id, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, adOrderItem.order_id);
            }
            int encodedSizeWithTag = i3 + e().encodedSizeWithTag(2, adOrderItem.report_dict);
            if (!Objects.equals(adOrderItem.extra_report_param, null)) {
                encodedSizeWithTag += AdExtraReportItem.ADAPTER.encodedSizeWithTag(3, adOrderItem.extra_report_param);
            }
            if (!Objects.equals(adOrderItem.ad_report_key, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(4, adOrderItem.ad_report_key);
            }
            if (!Objects.equals(adOrderItem.ad_report_param, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(5, adOrderItem.ad_report_param);
            }
            if (!Objects.equals(adOrderItem.unique_id, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(6, adOrderItem.unique_id);
            }
            if (!Objects.equals(adOrderItem.ad_refresh_context, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(7, adOrderItem.ad_refresh_context);
            }
            return encodedSizeWithTag + f().encodedSizeWithTag(8, adOrderItem.vr_report_dict) + adOrderItem.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdOrderItem redact(AdOrderItem adOrderItem) {
            a newBuilder = adOrderItem.newBuilder();
            Internal.redactElements(newBuilder.f383649b, AdReportList.ADAPTER);
            AdExtraReportItem adExtraReportItem = newBuilder.f383650c;
            if (adExtraReportItem != null) {
                newBuilder.f383650c = AdExtraReportItem.ADAPTER.redact(adExtraReportItem);
            }
            Internal.redactElements(newBuilder.f383655h, AdVRReportList.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdOrderItem(String str, Map<Integer, AdReportList> map, AdExtraReportItem adExtraReportItem, String str2, String str3, String str4, String str5, Map<Integer, AdVRReportList> map2) {
        this(str, map, adExtraReportItem, str2, str3, str4, str5, map2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdOrderItem)) {
            return false;
        }
        AdOrderItem adOrderItem = (AdOrderItem) obj;
        if (unknownFields().equals(adOrderItem.unknownFields()) && Internal.equals(this.order_id, adOrderItem.order_id) && this.report_dict.equals(adOrderItem.report_dict) && Internal.equals(this.extra_report_param, adOrderItem.extra_report_param) && Internal.equals(this.ad_report_key, adOrderItem.ad_report_key) && Internal.equals(this.ad_report_param, adOrderItem.ad_report_param) && Internal.equals(this.unique_id, adOrderItem.unique_id) && Internal.equals(this.ad_refresh_context, adOrderItem.ad_refresh_context) && this.vr_report_dict.equals(adOrderItem.vr_report_dict)) {
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
            String str = this.order_id;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = (((hashCode + i3) * 37) + this.report_dict.hashCode()) * 37;
            AdExtraReportItem adExtraReportItem = this.extra_report_param;
            if (adExtraReportItem != null) {
                i16 = adExtraReportItem.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (hashCode2 + i16) * 37;
            String str2 = this.ad_report_key;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            String str3 = this.ad_report_param;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str4 = this.unique_id;
            if (str4 != null) {
                i19 = str4.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (i36 + i19) * 37;
            String str5 = this.ad_refresh_context;
            if (str5 != null) {
                i27 = str5.hashCode();
            }
            int hashCode3 = ((i37 + i27) * 37) + this.vr_report_dict.hashCode();
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.order_id != null) {
            sb5.append(", order_id=");
            sb5.append(Internal.sanitize(this.order_id));
        }
        if (!this.report_dict.isEmpty()) {
            sb5.append(", report_dict=");
            sb5.append(this.report_dict);
        }
        if (this.extra_report_param != null) {
            sb5.append(", extra_report_param=");
            sb5.append(this.extra_report_param);
        }
        if (this.ad_report_key != null) {
            sb5.append(", ad_report_key=");
            sb5.append(Internal.sanitize(this.ad_report_key));
        }
        if (this.ad_report_param != null) {
            sb5.append(", ad_report_param=");
            sb5.append(Internal.sanitize(this.ad_report_param));
        }
        if (this.unique_id != null) {
            sb5.append(", unique_id=");
            sb5.append(Internal.sanitize(this.unique_id));
        }
        if (this.ad_refresh_context != null) {
            sb5.append(", ad_refresh_context=");
            sb5.append(Internal.sanitize(this.ad_refresh_context));
        }
        if (!this.vr_report_dict.isEmpty()) {
            sb5.append(", vr_report_dict=");
            sb5.append(this.vr_report_dict);
        }
        StringBuilder replace = sb5.replace(0, 2, "AdOrderItem{");
        replace.append('}');
        return replace.toString();
    }

    public AdOrderItem(String str, Map<Integer, AdReportList> map, AdExtraReportItem adExtraReportItem, String str2, String str3, String str4, String str5, Map<Integer, AdVRReportList> map2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.order_id = str;
            this.report_dict = Internal.immutableCopyOf("report_dict", map);
            this.extra_report_param = adExtraReportItem;
            if (str2 != null) {
                this.ad_report_key = str2;
                if (str3 != null) {
                    this.ad_report_param = str3;
                    if (str4 != null) {
                        this.unique_id = str4;
                        if (str5 != null) {
                            this.ad_refresh_context = str5;
                            this.vr_report_dict = Internal.immutableCopyOf("vr_report_dict", map2);
                            return;
                        }
                        throw new IllegalArgumentException("ad_refresh_context == null");
                    }
                    throw new IllegalArgumentException("unique_id == null");
                }
                throw new IllegalArgumentException("ad_report_param == null");
            }
            throw new IllegalArgumentException("ad_report_key == null");
        }
        throw new IllegalArgumentException("order_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383648a = this.order_id;
        aVar.f383649b = Internal.copyOf(this.report_dict);
        aVar.f383650c = this.extra_report_param;
        aVar.f383651d = this.ad_report_key;
        aVar.f383652e = this.ad_report_param;
        aVar.f383653f = this.unique_id;
        aVar.f383654g = this.ad_refresh_context;
        aVar.f383655h = Internal.copyOf(this.vr_report_dict);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
