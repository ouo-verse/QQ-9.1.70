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

/* loaded from: classes28.dex */
public final class TextPipeline extends Message<TextPipeline, a> {
    public static final ProtoAdapter<TextPipeline> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.TextPreProcessor#ADAPTER", jsonName = "customProcessors", label = WireField.Label.REPEATED, tag = 2)
    public final List<TextPreProcessor> custom_processors;

    @WireField(adapter = "feedcloud.PredefinedPipeline#ADAPTER", jsonName = "predefinedId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final PredefinedPipeline predefined_id;

    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<TextPipeline, a> {

        /* renamed from: a, reason: collision with root package name */
        public PredefinedPipeline f398536a = PredefinedPipeline.PREDEFINED_PIPELINE_CUSTOM;

        /* renamed from: b, reason: collision with root package name */
        public List<TextPreProcessor> f398537b = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextPipeline build() {
            return new TextPipeline(this.f398536a, this.f398537b, super.buildUnknownFields());
        }

        public a b(PredefinedPipeline predefinedPipeline) {
            this.f398536a = predefinedPipeline;
            return this;
        }
    }

    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<TextPipeline> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) TextPipeline.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.TextPipeline", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextPipeline decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f398537b.add(TextPreProcessor.ADAPTER.decode(protoReader));
                        }
                    } else {
                        try {
                            aVar.b(PredefinedPipeline.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, TextPipeline textPipeline) throws IOException {
            if (!Objects.equals(textPipeline.predefined_id, PredefinedPipeline.PREDEFINED_PIPELINE_CUSTOM)) {
                PredefinedPipeline.ADAPTER.encodeWithTag(protoWriter, 1, textPipeline.predefined_id);
            }
            TextPreProcessor.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, textPipeline.custom_processors);
            protoWriter.writeBytes(textPipeline.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(TextPipeline textPipeline) {
            int i3 = 0;
            if (!Objects.equals(textPipeline.predefined_id, PredefinedPipeline.PREDEFINED_PIPELINE_CUSTOM)) {
                i3 = 0 + PredefinedPipeline.ADAPTER.encodedSizeWithTag(1, textPipeline.predefined_id);
            }
            return i3 + TextPreProcessor.ADAPTER.asRepeated().encodedSizeWithTag(2, textPipeline.custom_processors) + textPipeline.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public TextPipeline redact(TextPipeline textPipeline) {
            a newBuilder = textPipeline.newBuilder();
            Internal.redactElements(newBuilder.f398537b, TextPreProcessor.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public TextPipeline(PredefinedPipeline predefinedPipeline, List<TextPreProcessor> list) {
        this(predefinedPipeline, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextPipeline)) {
            return false;
        }
        TextPipeline textPipeline = (TextPipeline) obj;
        if (unknownFields().equals(textPipeline.unknownFields()) && Internal.equals(this.predefined_id, textPipeline.predefined_id) && this.custom_processors.equals(textPipeline.custom_processors)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            PredefinedPipeline predefinedPipeline = this.predefined_id;
            if (predefinedPipeline != null) {
                i3 = predefinedPipeline.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((hashCode + i3) * 37) + this.custom_processors.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.predefined_id != null) {
            sb5.append(", predefined_id=");
            sb5.append(this.predefined_id);
        }
        if (!this.custom_processors.isEmpty()) {
            sb5.append(", custom_processors=");
            sb5.append(this.custom_processors);
        }
        StringBuilder replace = sb5.replace(0, 2, "TextPipeline{");
        replace.append('}');
        return replace.toString();
    }

    public TextPipeline(PredefinedPipeline predefinedPipeline, List<TextPreProcessor> list, ByteString byteString) {
        super(ADAPTER, byteString);
        if (predefinedPipeline != null) {
            this.predefined_id = predefinedPipeline;
            this.custom_processors = Internal.immutableCopyOf("custom_processors", list);
            return;
        }
        throw new IllegalArgumentException("predefined_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398536a = this.predefined_id;
        aVar.f398537b = Internal.copyOf(this.custom_processors);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
