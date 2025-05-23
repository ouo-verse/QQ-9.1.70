package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetExperimentsReqV2 extends Message<GetExperimentsReqV2, a> {
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_GUID = "";
    public static final String DEFAULT_SDK_VERSION = "";
    public static final String DEFAULT_SNAPSHOT_VERSION = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String app_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> extra_params;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.FilterOptions#ADAPTER", tag = 10)
    public final FilterOptions filter_options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String guid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 11)
    public final Long modify_timestamp;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.ProfileValues#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, ProfileValues> profiles;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String sdk_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String snapshot_version;
    public static final ProtoAdapter<GetExperimentsReqV2> ADAPTER = new b();
    public static final Long DEFAULT_MODIFY_TIMESTAMP = 0L;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<GetExperimentsReqV2, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f374208a;

        /* renamed from: b, reason: collision with root package name */
        public String f374209b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, ProfileValues> f374210c = Internal.newMutableMap();

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String> f374211d = Internal.newMutableMap();

        /* renamed from: e, reason: collision with root package name */
        public FilterOptions f374212e;

        /* renamed from: f, reason: collision with root package name */
        public Long f374213f;

        /* renamed from: g, reason: collision with root package name */
        public String f374214g;

        /* renamed from: h, reason: collision with root package name */
        public String f374215h;

        public a a(String str) {
            this.f374208a = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GetExperimentsReqV2 build() {
            return new GetExperimentsReqV2(this.f374208a, this.f374209b, this.f374210c, this.f374211d, this.f374212e, this.f374213f, this.f374214g, this.f374215h, super.buildUnknownFields());
        }

        public a c(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f374211d = map;
            return this;
        }

        public a d(FilterOptions filterOptions) {
            this.f374212e = filterOptions;
            return this;
        }

        public a e(String str) {
            this.f374209b = str;
            return this;
        }

        public a f(Long l3) {
            this.f374213f = l3;
            return this;
        }

        public a g(Map<String, ProfileValues> map) {
            Internal.checkElementsNotNull(map);
            this.f374210c = map;
            return this;
        }

        public a h(String str) {
            this.f374215h = str;
            return this;
        }

        public a i(String str) {
            this.f374214g = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<GetExperimentsReqV2> {

        /* renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, ProfileValues>> f374216a;

        /* renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f374217b;

        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetExperimentsReqV2.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.f374216a = ProtoAdapter.newMapAdapter(protoAdapter, ProfileValues.ADAPTER);
            this.f374217b = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetExperimentsReqV2 decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    switch (nextTag) {
                                        case 10:
                                            aVar.d(FilterOptions.ADAPTER.decode(protoReader));
                                            break;
                                        case 11:
                                            aVar.f(ProtoAdapter.INT64.decode(protoReader));
                                            break;
                                        case 12:
                                            aVar.i(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 13:
                                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        default:
                                            FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                                            aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
                                            break;
                                    }
                                } else {
                                    aVar.f374211d.putAll(this.f374217b.decode(protoReader));
                                }
                            } else {
                                aVar.f374210c.putAll(this.f374216a.decode(protoReader));
                            }
                        } else {
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.a(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetExperimentsReqV2 getExperimentsReqV2) throws IOException {
            String str = getExperimentsReqV2.app_id;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            String str2 = getExperimentsReqV2.guid;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str2);
            }
            this.f374216a.encodeWithTag(protoWriter, 3, getExperimentsReqV2.profiles);
            this.f374217b.encodeWithTag(protoWriter, 4, getExperimentsReqV2.extra_params);
            FilterOptions filterOptions = getExperimentsReqV2.filter_options;
            if (filterOptions != null) {
                FilterOptions.ADAPTER.encodeWithTag(protoWriter, 10, filterOptions);
            }
            Long l3 = getExperimentsReqV2.modify_timestamp;
            if (l3 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 11, l3);
            }
            String str3 = getExperimentsReqV2.snapshot_version;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, str3);
            }
            String str4 = getExperimentsReqV2.sdk_version;
            if (str4 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, str4);
            }
            protoWriter.writeBytes(getExperimentsReqV2.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetExperimentsReqV2 getExperimentsReqV2) {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            String str = getExperimentsReqV2.app_id;
            int i26 = 0;
            if (str != null) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, str);
            } else {
                i3 = 0;
            }
            String str2 = getExperimentsReqV2.guid;
            if (str2 != null) {
                i16 = ProtoAdapter.STRING.encodedSizeWithTag(2, str2);
            } else {
                i16 = 0;
            }
            int encodedSizeWithTag = i3 + i16 + this.f374216a.encodedSizeWithTag(3, getExperimentsReqV2.profiles) + this.f374217b.encodedSizeWithTag(4, getExperimentsReqV2.extra_params);
            FilterOptions filterOptions = getExperimentsReqV2.filter_options;
            if (filterOptions != null) {
                i17 = FilterOptions.ADAPTER.encodedSizeWithTag(10, filterOptions);
            } else {
                i17 = 0;
            }
            int i27 = encodedSizeWithTag + i17;
            Long l3 = getExperimentsReqV2.modify_timestamp;
            if (l3 != null) {
                i18 = ProtoAdapter.INT64.encodedSizeWithTag(11, l3);
            } else {
                i18 = 0;
            }
            int i28 = i27 + i18;
            String str3 = getExperimentsReqV2.snapshot_version;
            if (str3 != null) {
                i19 = ProtoAdapter.STRING.encodedSizeWithTag(12, str3);
            } else {
                i19 = 0;
            }
            int i29 = i28 + i19;
            String str4 = getExperimentsReqV2.sdk_version;
            if (str4 != null) {
                i26 = ProtoAdapter.STRING.encodedSizeWithTag(13, str4);
            }
            return i29 + i26 + getExperimentsReqV2.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public GetExperimentsReqV2 redact(GetExperimentsReqV2 getExperimentsReqV2) {
            a newBuilder = getExperimentsReqV2.newBuilder();
            Internal.redactElements(newBuilder.f374210c, ProfileValues.ADAPTER);
            FilterOptions filterOptions = newBuilder.f374212e;
            if (filterOptions != null) {
                newBuilder.f374212e = FilterOptions.ADAPTER.redact(filterOptions);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetExperimentsReqV2(String str, String str2, Map<String, ProfileValues> map, Map<String, String> map2, FilterOptions filterOptions, Long l3, String str3, String str4) {
        this(str, str2, map, map2, filterOptions, l3, str3, str4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetExperimentsReqV2)) {
            return false;
        }
        GetExperimentsReqV2 getExperimentsReqV2 = (GetExperimentsReqV2) obj;
        if (unknownFields().equals(getExperimentsReqV2.unknownFields()) && Internal.equals(this.app_id, getExperimentsReqV2.app_id) && Internal.equals(this.guid, getExperimentsReqV2.guid) && this.profiles.equals(getExperimentsReqV2.profiles) && this.extra_params.equals(getExperimentsReqV2.extra_params) && Internal.equals(this.filter_options, getExperimentsReqV2.filter_options) && Internal.equals(this.modify_timestamp, getExperimentsReqV2.modify_timestamp) && Internal.equals(this.snapshot_version, getExperimentsReqV2.snapshot_version) && Internal.equals(this.sdk_version, getExperimentsReqV2.sdk_version)) {
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
            String str = this.app_id;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.guid;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int hashCode2 = (((((i28 + i16) * 37) + this.profiles.hashCode()) * 37) + this.extra_params.hashCode()) * 37;
            FilterOptions filterOptions = this.filter_options;
            if (filterOptions != null) {
                i17 = filterOptions.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (hashCode2 + i17) * 37;
            Long l3 = this.modify_timestamp;
            if (l3 != null) {
                i18 = l3.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str3 = this.snapshot_version;
            if (str3 != null) {
                i19 = str3.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (i36 + i19) * 37;
            String str4 = this.sdk_version;
            if (str4 != null) {
                i27 = str4.hashCode();
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
        if (this.app_id != null) {
            sb5.append(", app_id=");
            sb5.append(this.app_id);
        }
        if (this.guid != null) {
            sb5.append(", guid=");
            sb5.append(this.guid);
        }
        if (!this.profiles.isEmpty()) {
            sb5.append(", profiles=");
            sb5.append(this.profiles);
        }
        if (!this.extra_params.isEmpty()) {
            sb5.append(", extra_params=");
            sb5.append(this.extra_params);
        }
        if (this.filter_options != null) {
            sb5.append(", filter_options=");
            sb5.append(this.filter_options);
        }
        if (this.modify_timestamp != null) {
            sb5.append(", modify_timestamp=");
            sb5.append(this.modify_timestamp);
        }
        if (this.snapshot_version != null) {
            sb5.append(", snapshot_version=");
            sb5.append(this.snapshot_version);
        }
        if (this.sdk_version != null) {
            sb5.append(", sdk_version=");
            sb5.append(this.sdk_version);
        }
        StringBuilder replace = sb5.replace(0, 2, "GetExperimentsReqV2{");
        replace.append('}');
        return replace.toString();
    }

    public GetExperimentsReqV2(String str, String str2, Map<String, ProfileValues> map, Map<String, String> map2, FilterOptions filterOptions, Long l3, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.app_id = str;
        this.guid = str2;
        this.profiles = Internal.immutableCopyOf("profiles", map);
        this.extra_params = Internal.immutableCopyOf("extra_params", map2);
        this.filter_options = filterOptions;
        this.modify_timestamp = l3;
        this.snapshot_version = str3;
        this.sdk_version = str4;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374208a = this.app_id;
        aVar.f374209b = this.guid;
        aVar.f374210c = Internal.copyOf("profiles", this.profiles);
        aVar.f374211d = Internal.copyOf("extra_params", this.extra_params);
        aVar.f374212e = this.filter_options;
        aVar.f374213f = this.modify_timestamp;
        aVar.f374214g = this.snapshot_version;
        aVar.f374215h = this.sdk_version;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
