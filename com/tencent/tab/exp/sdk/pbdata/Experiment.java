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
public final class Experiment extends Message<Experiment, a> {
    public static final String DEFAULT_EXP_GROUP_KEY = "";
    public static final String DEFAULT_EXP_KEY = "";
    public static final String DEFAULT_MODULE_CODE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer bucket;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String exp_group_key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer exp_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String exp_key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer module_bucket_num;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String module_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> params;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
    public final Float percentage;
    public static final ProtoAdapter<Experiment> ADAPTER = new b();
    public static final Integer DEFAULT_EXP_ID = 0;
    public static final Integer DEFAULT_BUCKET = 0;
    public static final Integer DEFAULT_MODULE_BUCKET_NUM = 0;
    public static final Float DEFAULT_PERCENTAGE = Float.valueOf(0.0f);

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a extends Message.Builder<Experiment, a> {

        /* renamed from: a, reason: collision with root package name */
        public Integer f374196a;

        /* renamed from: b, reason: collision with root package name */
        public String f374197b;

        /* renamed from: c, reason: collision with root package name */
        public String f374198c;

        /* renamed from: d, reason: collision with root package name */
        public String f374199d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, String> f374200e = Internal.newMutableMap();

        /* renamed from: f, reason: collision with root package name */
        public Integer f374201f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f374202g;

        /* renamed from: h, reason: collision with root package name */
        public Float f374203h;

        public a a(Integer num) {
            this.f374201f = num;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Experiment build() {
            return new Experiment(this.f374196a, this.f374197b, this.f374198c, this.f374199d, this.f374200e, this.f374201f, this.f374202g, this.f374203h, super.buildUnknownFields());
        }

        public a c(String str) {
            this.f374198c = str;
            return this;
        }

        public a d(Integer num) {
            this.f374196a = num;
            return this;
        }

        public a e(String str) {
            this.f374197b = str;
            return this;
        }

        public a f(Integer num) {
            this.f374202g = num;
            return this;
        }

        public a g(String str) {
            this.f374199d = str;
            return this;
        }

        public a h(Float f16) {
            this.f374203h = f16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static final class b extends ProtoAdapter<Experiment> {

        /* renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f374204a;

        b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Experiment.class);
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.f374204a = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Experiment decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 2:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.f374200e.putAll(this.f374204a.decode(protoReader));
                            break;
                        case 6:
                            aVar.a(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 7:
                            aVar.f(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 8:
                            aVar.h(ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        default:
                            FieldEncoding nextFieldEncoding = protoReader.getNextFieldEncoding();
                            aVar.addUnknownField(nextTag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, Experiment experiment) throws IOException {
            Integer num = experiment.exp_id;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, num);
            }
            String str = experiment.exp_key;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, str);
            }
            String str2 = experiment.exp_group_key;
            if (str2 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, str2);
            }
            String str3 = experiment.module_code;
            if (str3 != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, str3);
            }
            this.f374204a.encodeWithTag(protoWriter, 5, experiment.params);
            Integer num2 = experiment.bucket;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, num2);
            }
            Integer num3 = experiment.module_bucket_num;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, num3);
            }
            Float f16 = experiment.percentage;
            if (f16 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 8, f16);
            }
            protoWriter.writeBytes(experiment.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Experiment experiment) {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26;
            Integer num = experiment.exp_id;
            int i27 = 0;
            if (num != null) {
                i3 = ProtoAdapter.INT32.encodedSizeWithTag(1, num);
            } else {
                i3 = 0;
            }
            String str = experiment.exp_key;
            if (str != null) {
                i16 = ProtoAdapter.STRING.encodedSizeWithTag(2, str);
            } else {
                i16 = 0;
            }
            int i28 = i3 + i16;
            String str2 = experiment.exp_group_key;
            if (str2 != null) {
                i17 = ProtoAdapter.STRING.encodedSizeWithTag(3, str2);
            } else {
                i17 = 0;
            }
            int i29 = i28 + i17;
            String str3 = experiment.module_code;
            if (str3 != null) {
                i18 = ProtoAdapter.STRING.encodedSizeWithTag(4, str3);
            } else {
                i18 = 0;
            }
            int encodedSizeWithTag = i29 + i18 + this.f374204a.encodedSizeWithTag(5, experiment.params);
            Integer num2 = experiment.bucket;
            if (num2 != null) {
                i19 = ProtoAdapter.INT32.encodedSizeWithTag(6, num2);
            } else {
                i19 = 0;
            }
            int i36 = encodedSizeWithTag + i19;
            Integer num3 = experiment.module_bucket_num;
            if (num3 != null) {
                i26 = ProtoAdapter.INT32.encodedSizeWithTag(7, num3);
            } else {
                i26 = 0;
            }
            int i37 = i36 + i26;
            Float f16 = experiment.percentage;
            if (f16 != null) {
                i27 = ProtoAdapter.FLOAT.encodedSizeWithTag(8, f16);
            }
            return i37 + i27 + experiment.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Experiment redact(Experiment experiment) {
            a newBuilder = experiment.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Experiment(Integer num, String str, String str2, String str3, Map<String, String> map, Integer num2, Integer num3, Float f16) {
        this(num, str, str2, str3, map, num2, num3, f16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Experiment)) {
            return false;
        }
        Experiment experiment = (Experiment) obj;
        if (unknownFields().equals(experiment.unknownFields()) && Internal.equals(this.exp_id, experiment.exp_id) && Internal.equals(this.exp_key, experiment.exp_key) && Internal.equals(this.exp_group_key, experiment.exp_group_key) && Internal.equals(this.module_code, experiment.module_code) && this.params.equals(experiment.params) && Internal.equals(this.bucket, experiment.bucket) && Internal.equals(this.module_bucket_num, experiment.module_bucket_num) && Internal.equals(this.percentage, experiment.percentage)) {
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
            Integer num = this.exp_id;
            int i28 = 0;
            if (num != null) {
                i3 = num.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            String str = this.exp_key;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            String str2 = this.exp_group_key;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 37;
            String str3 = this.module_code;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode2 = (((i37 + i18) * 37) + this.params.hashCode()) * 37;
            Integer num2 = this.bucket;
            if (num2 != null) {
                i19 = num2.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (hashCode2 + i19) * 37;
            Integer num3 = this.module_bucket_num;
            if (num3 != null) {
                i26 = num3.hashCode();
            } else {
                i26 = 0;
            }
            int i39 = (i38 + i26) * 37;
            Float f16 = this.percentage;
            if (f16 != null) {
                i28 = f16.hashCode();
            }
            int i46 = i39 + i28;
            this.hashCode = i46;
            return i46;
        }
        return i27;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.exp_id != null) {
            sb5.append(", exp_id=");
            sb5.append(this.exp_id);
        }
        if (this.exp_key != null) {
            sb5.append(", exp_key=");
            sb5.append(this.exp_key);
        }
        if (this.exp_group_key != null) {
            sb5.append(", exp_group_key=");
            sb5.append(this.exp_group_key);
        }
        if (this.module_code != null) {
            sb5.append(", module_code=");
            sb5.append(this.module_code);
        }
        if (!this.params.isEmpty()) {
            sb5.append(", params=");
            sb5.append(this.params);
        }
        if (this.bucket != null) {
            sb5.append(", bucket=");
            sb5.append(this.bucket);
        }
        if (this.module_bucket_num != null) {
            sb5.append(", module_bucket_num=");
            sb5.append(this.module_bucket_num);
        }
        if (this.percentage != null) {
            sb5.append(", percentage=");
            sb5.append(this.percentage);
        }
        StringBuilder replace = sb5.replace(0, 2, "Experiment{");
        replace.append('}');
        return replace.toString();
    }

    public Experiment(Integer num, String str, String str2, String str3, Map<String, String> map, Integer num2, Integer num3, Float f16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.exp_id = num;
        this.exp_key = str;
        this.exp_group_key = str2;
        this.module_code = str3;
        this.params = Internal.immutableCopyOf("params", map);
        this.bucket = num2;
        this.module_bucket_num = num3;
        this.percentage = f16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f374196a = this.exp_id;
        aVar.f374197b = this.exp_key;
        aVar.f374198c = this.exp_group_key;
        aVar.f374199d = this.module_code;
        aVar.f374200e = Internal.copyOf("params", this.params);
        aVar.f374201f = this.bucket;
        aVar.f374202g = this.module_bucket_num;
        aVar.f374203h = this.percentage;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
