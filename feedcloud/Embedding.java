package feedcloud;

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
/* loaded from: classes28.dex */
public final class Embedding extends Message<Embedding, a> {
    public static final ProtoAdapter<Embedding> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "floatDbg", label = WireField.Label.REPEATED, tag = 999)
    public final List<String> float_dbg;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "modelInputHash", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String model_input_hash;

    @WireField(adapter = "feedcloud.PredefinedPipeline#ADAPTER", jsonName = "pipelineId", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final PredefinedPipeline pipeline_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    public final List<Double> value;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<Embedding, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<Double> f398420a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public PredefinedPipeline f398421b = PredefinedPipeline.PREDEFINED_PIPELINE_CUSTOM;

        /* renamed from: c, reason: collision with root package name */
        public String f398422c = "";

        /* renamed from: d, reason: collision with root package name */
        public List<String> f398423d = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Embedding build() {
            return new Embedding(this.f398420a, this.f398421b, this.f398422c, this.f398423d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398422c = str;
            return this;
        }

        public a c(PredefinedPipeline predefinedPipeline) {
            this.f398421b = predefinedPipeline;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<Embedding> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Embedding.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.Embedding", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Embedding decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 2) {
                        if (nextTag != 3) {
                            if (nextTag != 4) {
                                if (nextTag != 999) {
                                    protoReader.readUnknownField(nextTag);
                                } else {
                                    aVar.f398423d.add(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            try {
                                aVar.c(PredefinedPipeline.ADAPTER.decode(protoReader));
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                        }
                    } else {
                        aVar.f398420a.add(ProtoAdapter.DOUBLE.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, Embedding embedding) throws IOException {
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(protoWriter, 2, embedding.value);
            if (!Objects.equals(embedding.pipeline_id, PredefinedPipeline.PREDEFINED_PIPELINE_CUSTOM)) {
                PredefinedPipeline.ADAPTER.encodeWithTag(protoWriter, 3, embedding.pipeline_id);
            }
            if (!Objects.equals(embedding.model_input_hash, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, embedding.model_input_hash);
            }
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 999, embedding.float_dbg);
            protoWriter.writeBytes(embedding.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Embedding embedding) {
            int encodedSizeWithTag = ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(2, embedding.value) + 0;
            if (!Objects.equals(embedding.pipeline_id, PredefinedPipeline.PREDEFINED_PIPELINE_CUSTOM)) {
                encodedSizeWithTag += PredefinedPipeline.ADAPTER.encodedSizeWithTag(3, embedding.pipeline_id);
            }
            if (!Objects.equals(embedding.model_input_hash, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(4, embedding.model_input_hash);
            }
            return encodedSizeWithTag + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(999, embedding.float_dbg) + embedding.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Embedding redact(Embedding embedding) {
            a newBuilder = embedding.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Embedding(List<Double> list, PredefinedPipeline predefinedPipeline, String str, List<String> list2) {
        this(list, predefinedPipeline, str, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Embedding)) {
            return false;
        }
        Embedding embedding = (Embedding) obj;
        if (unknownFields().equals(embedding.unknownFields()) && this.value.equals(embedding.value) && Internal.equals(this.pipeline_id, embedding.pipeline_id) && Internal.equals(this.model_input_hash, embedding.model_input_hash) && this.float_dbg.equals(embedding.float_dbg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.value.hashCode()) * 37;
            PredefinedPipeline predefinedPipeline = this.pipeline_id;
            int i17 = 0;
            if (predefinedPipeline != null) {
                i3 = predefinedPipeline.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str = this.model_input_hash;
            if (str != null) {
                i17 = str.hashCode();
            }
            int hashCode2 = ((i18 + i17) * 37) + this.float_dbg.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.value.isEmpty()) {
            sb5.append(", value=");
            sb5.append(this.value);
        }
        if (this.pipeline_id != null) {
            sb5.append(", pipeline_id=");
            sb5.append(this.pipeline_id);
        }
        if (this.model_input_hash != null) {
            sb5.append(", model_input_hash=");
            sb5.append(Internal.sanitize(this.model_input_hash));
        }
        if (!this.float_dbg.isEmpty()) {
            sb5.append(", float_dbg=");
            sb5.append(Internal.sanitize(this.float_dbg));
        }
        StringBuilder replace = sb5.replace(0, 2, "Embedding{");
        replace.append('}');
        return replace.toString();
    }

    public Embedding(List<Double> list, PredefinedPipeline predefinedPipeline, String str, List<String> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.value = Internal.immutableCopyOf("value", list);
        if (predefinedPipeline != null) {
            this.pipeline_id = predefinedPipeline;
            if (str != null) {
                this.model_input_hash = str;
                this.float_dbg = Internal.immutableCopyOf("float_dbg", list2);
                return;
            }
            throw new IllegalArgumentException("model_input_hash == null");
        }
        throw new IllegalArgumentException("pipeline_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398420a = Internal.copyOf(this.value);
        aVar.f398421b = this.pipeline_id;
        aVar.f398422c = this.model_input_hash;
        aVar.f398423d = Internal.copyOf(this.float_dbg);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
