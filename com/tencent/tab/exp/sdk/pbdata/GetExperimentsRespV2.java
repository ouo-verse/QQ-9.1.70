package com.tencent.tab.exp.sdk.pbdata;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetExperimentsRespV2 extends Message<GetExperimentsRespV2, a> {
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_SNAPSHOT_VERSION = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.ControlData#ADAPTER", tag = 10)
    public final ControlData control_data;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.DataUpdateType#ADAPTER", tag = 12)
    public final DataUpdateType data_update_type;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.Experiment#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, Experiment> exp_data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 4)
    public final List<String> exp_data_removed;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 11)
    public final Long modify_timestamp;

    /* renamed from: msg, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f374218msg;

    @WireField(adapter = "com.tencent.tab.exp.sdk.pbdata.RetCode#ADAPTER", tag = 1)
    public final RetCode ret_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String snapshot_version;
    public static final ProtoAdapter<GetExperimentsRespV2> ADAPTER = new b();
    public static final RetCode DEFAULT_RET_CODE = RetCode.RET_CODE_UNKNOWN;
    public static final Long DEFAULT_MODIFY_TIMESTAMP = 0L;
    public static final DataUpdateType DEFAULT_DATA_UPDATE_TYPE = DataUpdateType.DATA_UPDATE_TYPE_UNKNOWN;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<GetExperimentsRespV2, a> {

        /* renamed from: a, reason: collision with root package name */
        public RetCode f374219a;

        /* renamed from: b, reason: collision with root package name */
        public String f374220b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, Experiment> f374221c = Internal.newMutableMap();

        /* renamed from: d, reason: collision with root package name */
        public List<String> f374222d = Internal.newMutableList();

        /* renamed from: e, reason: collision with root package name */
        public ControlData f374223e;

        /* renamed from: f, reason: collision with root package name */
        public Long f374224f;

        /* renamed from: g, reason: collision with root package name */
        public DataUpdateType f374225g;

        /* renamed from: h, reason: collision with root package name */
        public String f374226h;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetExperimentsRespV2 build() {
            return new GetExperimentsRespV2(this.f374219a, this.f374220b, this.f374221c, this.f374222d, this.f374223e, this.f374224f, this.f374225g, this.f374226h, super.buildUnknownFields());
        }

        public a b(ControlData controlData) {
            this.f374223e = controlData;
            return this;
        }

        public a c(DataUpdateType dataUpdateType) {
            this.f374225g = dataUpdateType;
            return this;
        }

        public a d(Long l3) {
            this.f374224f = l3;
            return this;
        }

        public a e(String str) {
            this.f374220b = str;
            return this;
        }

        public a f(RetCode retCode) {
            this.f374219a = retCode;
            return this;
        }

        public a g(String str) {
            this.f374226h = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<GetExperimentsRespV2> {

        /* renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, Experiment>> f374227a;

        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetExperimentsRespV2.class);
            this.f374227a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Experiment.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetExperimentsRespV2 decode(ProtoReader protoReader) throws IOException {
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
                                            aVar.b(ControlData.ADAPTER.decode(protoReader));
                                            break;
                                        case 11:
                                            aVar.d(ProtoAdapter.INT64.decode(protoReader));
                                            break;
                                        case 12:
                                            try {
                                                aVar.c(DataUpdateType.ADAPTER.decode(protoReader));
                                                break;
                                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                                break;
                                            }
                                        case 13:
                                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        default:
                                            FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                                            aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
                                            break;
                                    }
                                } else {
                                    aVar.f374222d.add(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.f374221c.putAll(this.f374227a.decode(protoReader));
                            }
                        } else {
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        try {
                            aVar.f(RetCode.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                        }
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetExperimentsRespV2 getExperimentsRespV2) throws IOException {
            RetCode retCode = getExperimentsRespV2.ret_code;
            if (retCode != null) {
                RetCode.ADAPTER.encodeWithTag(protoWriter, 1, retCode);
            }
            String str = getExperimentsRespV2.f374218msg;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str);
            }
            this.f374227a.encodeWithTag(protoWriter, 3, getExperimentsRespV2.exp_data);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 4, getExperimentsRespV2.exp_data_removed);
            ControlData controlData = getExperimentsRespV2.control_data;
            if (controlData != null) {
                ControlData.ADAPTER.encodeWithTag(protoWriter, 10, controlData);
            }
            Long l3 = getExperimentsRespV2.modify_timestamp;
            if (l3 != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 11, l3);
            }
            DataUpdateType dataUpdateType = getExperimentsRespV2.data_update_type;
            if (dataUpdateType != null) {
                DataUpdateType.ADAPTER.encodeWithTag(protoWriter, 12, dataUpdateType);
            }
            String str2 = getExperimentsRespV2.snapshot_version;
            if (str2 != null) {
                protoAdapter.encodeWithTag(protoWriter, 13, str2);
            }
            protoWriter.writeBytes(getExperimentsRespV2.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetExperimentsRespV2 getExperimentsRespV2) {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            RetCode retCode = getExperimentsRespV2.ret_code;
            int i26 = 0;
            if (retCode != null) {
                i3 = RetCode.ADAPTER.encodedSizeWithTag(1, retCode);
            } else {
                i3 = 0;
            }
            String str = getExperimentsRespV2.f374218msg;
            if (str != null) {
                i16 = ProtoAdapter.STRING.encodedSizeWithTag(2, str);
            } else {
                i16 = 0;
            }
            int encodedSizeWithTag = i3 + i16 + this.f374227a.encodedSizeWithTag(3, getExperimentsRespV2.exp_data);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter.asRepeated().encodedSizeWithTag(4, getExperimentsRespV2.exp_data_removed);
            ControlData controlData = getExperimentsRespV2.control_data;
            if (controlData != null) {
                i17 = ControlData.ADAPTER.encodedSizeWithTag(10, controlData);
            } else {
                i17 = 0;
            }
            int i27 = encodedSizeWithTag2 + i17;
            Long l3 = getExperimentsRespV2.modify_timestamp;
            if (l3 != null) {
                i18 = ProtoAdapter.INT64.encodedSizeWithTag(11, l3);
            } else {
                i18 = 0;
            }
            int i28 = i27 + i18;
            DataUpdateType dataUpdateType = getExperimentsRespV2.data_update_type;
            if (dataUpdateType != null) {
                i19 = DataUpdateType.ADAPTER.encodedSizeWithTag(12, dataUpdateType);
            } else {
                i19 = 0;
            }
            int i29 = i28 + i19;
            String str2 = getExperimentsRespV2.snapshot_version;
            if (str2 != null) {
                i26 = protoAdapter.encodedSizeWithTag(13, str2);
            }
            return i29 + i26 + getExperimentsRespV2.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public GetExperimentsRespV2 redact(GetExperimentsRespV2 getExperimentsRespV2) {
            a newBuilder = getExperimentsRespV2.newBuilder();
            Internal.redactElements(newBuilder.f374221c, Experiment.ADAPTER);
            ControlData controlData = newBuilder.f374223e;
            if (controlData != null) {
                newBuilder.f374223e = ControlData.ADAPTER.redact(controlData);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetExperimentsRespV2(RetCode retCode, String str, Map<String, Experiment> map, List<String> list, ControlData controlData, Long l3, DataUpdateType dataUpdateType, String str2) {
        this(retCode, str, map, list, controlData, l3, dataUpdateType, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetExperimentsRespV2)) {
            return false;
        }
        GetExperimentsRespV2 getExperimentsRespV2 = (GetExperimentsRespV2) obj;
        if (unknownFields().equals(getExperimentsRespV2.unknownFields()) && Internal.equals(this.ret_code, getExperimentsRespV2.ret_code) && Internal.equals(this.f374218msg, getExperimentsRespV2.f374218msg) && this.exp_data.equals(getExperimentsRespV2.exp_data) && this.exp_data_removed.equals(getExperimentsRespV2.exp_data_removed) && Internal.equals(this.control_data, getExperimentsRespV2.control_data) && Internal.equals(this.modify_timestamp, getExperimentsRespV2.modify_timestamp) && Internal.equals(this.data_update_type, getExperimentsRespV2.data_update_type) && Internal.equals(this.snapshot_version, getExperimentsRespV2.snapshot_version)) {
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
            RetCode retCode = this.ret_code;
            int i27 = 0;
            if (retCode != null) {
                i3 = retCode.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str = this.f374218msg;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int hashCode2 = (((((i28 + i16) * 37) + this.exp_data.hashCode()) * 37) + this.exp_data_removed.hashCode()) * 37;
            ControlData controlData = this.control_data;
            if (controlData != null) {
                i17 = controlData.hashCode();
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
            DataUpdateType dataUpdateType = this.data_update_type;
            if (dataUpdateType != null) {
                i19 = dataUpdateType.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (i36 + i19) * 37;
            String str2 = this.snapshot_version;
            if (str2 != null) {
                i27 = str2.hashCode();
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
        if (this.ret_code != null) {
            sb5.append(", ret_code=");
            sb5.append(this.ret_code);
        }
        if (this.f374218msg != null) {
            sb5.append(", msg=");
            sb5.append(this.f374218msg);
        }
        if (!this.exp_data.isEmpty()) {
            sb5.append(", exp_data=");
            sb5.append(this.exp_data);
        }
        if (!this.exp_data_removed.isEmpty()) {
            sb5.append(", exp_data_removed=");
            sb5.append(this.exp_data_removed);
        }
        if (this.control_data != null) {
            sb5.append(", control_data=");
            sb5.append(this.control_data);
        }
        if (this.modify_timestamp != null) {
            sb5.append(", modify_timestamp=");
            sb5.append(this.modify_timestamp);
        }
        if (this.data_update_type != null) {
            sb5.append(", data_update_type=");
            sb5.append(this.data_update_type);
        }
        if (this.snapshot_version != null) {
            sb5.append(", snapshot_version=");
            sb5.append(this.snapshot_version);
        }
        StringBuilder replace = sb5.replace(0, 2, "GetExperimentsRespV2{");
        replace.append('}');
        return replace.toString();
    }

    public GetExperimentsRespV2(RetCode retCode, String str, Map<String, Experiment> map, List<String> list, ControlData controlData, Long l3, DataUpdateType dataUpdateType, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ret_code = retCode;
        this.f374218msg = str;
        this.exp_data = Internal.immutableCopyOf("exp_data", map);
        this.exp_data_removed = Internal.immutableCopyOf("exp_data_removed", list);
        this.control_data = controlData;
        this.modify_timestamp = l3;
        this.data_update_type = dataUpdateType;
        this.snapshot_version = str2;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374219a = this.ret_code;
        aVar.f374220b = this.f374218msg;
        aVar.f374221c = Internal.copyOf("exp_data", this.exp_data);
        aVar.f374222d = Internal.copyOf("exp_data_removed", this.exp_data_removed);
        aVar.f374223e = this.control_data;
        aVar.f374224f = this.modify_timestamp;
        aVar.f374225g = this.data_update_type;
        aVar.f374226h = this.snapshot_version;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
