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
public final class ADBaseExtraInfo extends Message<ADBaseExtraInfo, a> {
    public static final ProtoAdapter<ADBaseExtraInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tvideo.protocol.pb.AdExtraSystemInfo#ADAPTER", jsonName = "adExtraSystemInfo", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final AdExtraSystemInfo ad_extra_system_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "deviceInitTime", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String device_init_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "expIdList", label = WireField.Label.REPEATED, tag = 4)
    public final List<String> exp_id_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "interestAdTags", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String interest_ad_tags;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "mntId", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String mnt_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "shouldSkipCustomAdWithoutLogin", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean should_skip_custom_ad_without_login;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "supportHapApp", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final boolean support_hap_app;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends Message.Builder<ADBaseExtraInfo, a> {

        /* renamed from: c, reason: collision with root package name */
        public AdExtraSystemInfo f383493c;

        /* renamed from: a, reason: collision with root package name */
        public boolean f383491a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f383492b = false;

        /* renamed from: d, reason: collision with root package name */
        public List<String> f383494d = Internal.newMutableList();

        /* renamed from: e, reason: collision with root package name */
        public String f383495e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f383496f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f383497g = "";

        public a a(AdExtraSystemInfo adExtraSystemInfo) {
            this.f383493c = adExtraSystemInfo;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ADBaseExtraInfo build() {
            return new ADBaseExtraInfo(this.f383491a, this.f383492b, this.f383493c, this.f383494d, this.f383495e, this.f383496f, this.f383497g, super.buildUnknownFields());
        }

        public a c(String str) {
            this.f383497g = str;
            return this;
        }

        public a d(String str) {
            this.f383495e = str;
            return this;
        }

        public a e(String str) {
            this.f383496f = str;
            return this;
        }

        public a f(boolean z16) {
            this.f383491a = z16;
            return this;
        }

        public a g(boolean z16) {
            this.f383492b = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static final class b extends ProtoAdapter<ADBaseExtraInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ADBaseExtraInfo.class, "type.googleapis.com/com.tencent.tvideo.protocol.pb.ADBaseExtraInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ADBaseExtraInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.f(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            break;
                        case 2:
                            aVar.g(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            break;
                        case 3:
                            aVar.a(AdExtraSystemInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.f383494d.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
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
        public void encode(ProtoWriter protoWriter, ADBaseExtraInfo aDBaseExtraInfo) throws IOException {
            Boolean valueOf = Boolean.valueOf(aDBaseExtraInfo.should_skip_custom_ad_without_login);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(aDBaseExtraInfo.should_skip_custom_ad_without_login));
            }
            if (!Objects.equals(Boolean.valueOf(aDBaseExtraInfo.support_hap_app), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, Boolean.valueOf(aDBaseExtraInfo.support_hap_app));
            }
            if (!Objects.equals(aDBaseExtraInfo.ad_extra_system_info, null)) {
                AdExtraSystemInfo.ADAPTER.encodeWithTag(protoWriter, 3, aDBaseExtraInfo.ad_extra_system_info);
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 4, aDBaseExtraInfo.exp_id_list);
            if (!Objects.equals(aDBaseExtraInfo.interest_ad_tags, "")) {
                protoAdapter.encodeWithTag(protoWriter, 5, aDBaseExtraInfo.interest_ad_tags);
            }
            if (!Objects.equals(aDBaseExtraInfo.mnt_id, "")) {
                protoAdapter.encodeWithTag(protoWriter, 6, aDBaseExtraInfo.mnt_id);
            }
            if (!Objects.equals(aDBaseExtraInfo.device_init_time, "")) {
                protoAdapter.encodeWithTag(protoWriter, 7, aDBaseExtraInfo.device_init_time);
            }
            protoWriter.writeBytes(aDBaseExtraInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ADBaseExtraInfo aDBaseExtraInfo) {
            Boolean valueOf = Boolean.valueOf(aDBaseExtraInfo.should_skip_custom_ad_without_login);
            Boolean bool = Boolean.FALSE;
            int i3 = 0;
            if (!Objects.equals(valueOf, bool)) {
                i3 = 0 + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(aDBaseExtraInfo.should_skip_custom_ad_without_login));
            }
            if (!Objects.equals(Boolean.valueOf(aDBaseExtraInfo.support_hap_app), bool)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(2, Boolean.valueOf(aDBaseExtraInfo.support_hap_app));
            }
            if (!Objects.equals(aDBaseExtraInfo.ad_extra_system_info, null)) {
                i3 += AdExtraSystemInfo.ADAPTER.encodedSizeWithTag(3, aDBaseExtraInfo.ad_extra_system_info);
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = i3 + protoAdapter.asRepeated().encodedSizeWithTag(4, aDBaseExtraInfo.exp_id_list);
            if (!Objects.equals(aDBaseExtraInfo.interest_ad_tags, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(5, aDBaseExtraInfo.interest_ad_tags);
            }
            if (!Objects.equals(aDBaseExtraInfo.mnt_id, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(6, aDBaseExtraInfo.mnt_id);
            }
            if (!Objects.equals(aDBaseExtraInfo.device_init_time, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(7, aDBaseExtraInfo.device_init_time);
            }
            return encodedSizeWithTag + aDBaseExtraInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ADBaseExtraInfo redact(ADBaseExtraInfo aDBaseExtraInfo) {
            a newBuilder = aDBaseExtraInfo.newBuilder();
            AdExtraSystemInfo adExtraSystemInfo = newBuilder.f383493c;
            if (adExtraSystemInfo != null) {
                newBuilder.f383493c = AdExtraSystemInfo.ADAPTER.redact(adExtraSystemInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ADBaseExtraInfo(boolean z16, boolean z17, AdExtraSystemInfo adExtraSystemInfo, List<String> list, String str, String str2, String str3) {
        this(z16, z17, adExtraSystemInfo, list, str, str2, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ADBaseExtraInfo)) {
            return false;
        }
        ADBaseExtraInfo aDBaseExtraInfo = (ADBaseExtraInfo) obj;
        if (unknownFields().equals(aDBaseExtraInfo.unknownFields()) && Internal.equals(Boolean.valueOf(this.should_skip_custom_ad_without_login), Boolean.valueOf(aDBaseExtraInfo.should_skip_custom_ad_without_login)) && Internal.equals(Boolean.valueOf(this.support_hap_app), Boolean.valueOf(aDBaseExtraInfo.support_hap_app)) && Internal.equals(this.ad_extra_system_info, aDBaseExtraInfo.ad_extra_system_info) && this.exp_id_list.equals(aDBaseExtraInfo.exp_id_list) && Internal.equals(this.interest_ad_tags, aDBaseExtraInfo.interest_ad_tags) && Internal.equals(this.mnt_id, aDBaseExtraInfo.mnt_id) && Internal.equals(this.device_init_time, aDBaseExtraInfo.device_init_time)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.should_skip_custom_ad_without_login)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.support_hap_app)) * 37;
            AdExtraSystemInfo adExtraSystemInfo = this.ad_extra_system_info;
            int i19 = 0;
            if (adExtraSystemInfo != null) {
                i3 = adExtraSystemInfo.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = (((hashCode + i3) * 37) + this.exp_id_list.hashCode()) * 37;
            String str = this.interest_ad_tags;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (hashCode2 + i16) * 37;
            String str2 = this.mnt_id;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i27 = (i26 + i17) * 37;
            String str3 = this.device_init_time;
            if (str3 != null) {
                i19 = str3.hashCode();
            }
            int i28 = i27 + i19;
            this.hashCode = i28;
            return i28;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", should_skip_custom_ad_without_login=");
        sb5.append(this.should_skip_custom_ad_without_login);
        sb5.append(", support_hap_app=");
        sb5.append(this.support_hap_app);
        if (this.ad_extra_system_info != null) {
            sb5.append(", ad_extra_system_info=");
            sb5.append(this.ad_extra_system_info);
        }
        if (!this.exp_id_list.isEmpty()) {
            sb5.append(", exp_id_list=");
            sb5.append(Internal.sanitize(this.exp_id_list));
        }
        if (this.interest_ad_tags != null) {
            sb5.append(", interest_ad_tags=");
            sb5.append(Internal.sanitize(this.interest_ad_tags));
        }
        if (this.mnt_id != null) {
            sb5.append(", mnt_id=");
            sb5.append(Internal.sanitize(this.mnt_id));
        }
        if (this.device_init_time != null) {
            sb5.append(", device_init_time=");
            sb5.append(Internal.sanitize(this.device_init_time));
        }
        StringBuilder replace = sb5.replace(0, 2, "ADBaseExtraInfo{");
        replace.append('}');
        return replace.toString();
    }

    public ADBaseExtraInfo(boolean z16, boolean z17, AdExtraSystemInfo adExtraSystemInfo, List<String> list, String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.should_skip_custom_ad_without_login = z16;
        this.support_hap_app = z17;
        this.ad_extra_system_info = adExtraSystemInfo;
        this.exp_id_list = Internal.immutableCopyOf("exp_id_list", list);
        if (str != null) {
            this.interest_ad_tags = str;
            if (str2 != null) {
                this.mnt_id = str2;
                if (str3 != null) {
                    this.device_init_time = str3;
                    return;
                }
                throw new IllegalArgumentException("device_init_time == null");
            }
            throw new IllegalArgumentException("mnt_id == null");
        }
        throw new IllegalArgumentException("interest_ad_tags == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f383491a = this.should_skip_custom_ad_without_login;
        aVar.f383492b = this.support_hap_app;
        aVar.f383493c = this.ad_extra_system_info;
        aVar.f383494d = Internal.copyOf(this.exp_id_list);
        aVar.f383495e = this.interest_ad_tags;
        aVar.f383496f = this.mnt_id;
        aVar.f383497g = this.device_init_time;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
