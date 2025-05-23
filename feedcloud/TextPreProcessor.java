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
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes28.dex */
public final class TextPreProcessor extends Message<TextPreProcessor, a> {
    public static final ProtoAdapter<TextPreProcessor> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.TextPreProcessAct#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final TextPreProcessAct act;

    @WireField(adapter = "feedcloud.JiebaOpt#ADAPTER", jsonName = "jiebaOpt", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final JiebaOpt jieba_opt;

    @WireField(adapter = "feedcloud.PromptOpt#ADAPTER", jsonName = "promptOpt", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final PromptOpt prompt_opt;

    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<TextPreProcessor, a> {

        /* renamed from: a, reason: collision with root package name */
        public TextPreProcessAct f398538a = TextPreProcessAct.TEXT_PREPROCESS_ACT_UNKNOWN;

        /* renamed from: b, reason: collision with root package name */
        public JiebaOpt f398539b;

        /* renamed from: c, reason: collision with root package name */
        public PromptOpt f398540c;

        public a a(TextPreProcessAct textPreProcessAct) {
            this.f398538a = textPreProcessAct;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TextPreProcessor build() {
            return new TextPreProcessor(this.f398538a, this.f398539b, this.f398540c, super.buildUnknownFields());
        }

        public a c(JiebaOpt jiebaOpt) {
            this.f398539b = jiebaOpt;
            return this;
        }

        public a d(PromptOpt promptOpt) {
            this.f398540c = promptOpt;
            return this;
        }
    }

    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<TextPreProcessor> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) TextPreProcessor.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.TextPreProcessor", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextPreProcessor decode(ProtoReader protoReader) throws IOException {
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
                                aVar.d(PromptOpt.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.c(JiebaOpt.ADAPTER.decode(protoReader));
                        }
                    } else {
                        try {
                            aVar.a(TextPreProcessAct.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, TextPreProcessor textPreProcessor) throws IOException {
            if (!Objects.equals(textPreProcessor.act, TextPreProcessAct.TEXT_PREPROCESS_ACT_UNKNOWN)) {
                TextPreProcessAct.ADAPTER.encodeWithTag(protoWriter, 1, textPreProcessor.act);
            }
            if (!Objects.equals(textPreProcessor.jieba_opt, null)) {
                JiebaOpt.ADAPTER.encodeWithTag(protoWriter, 2, textPreProcessor.jieba_opt);
            }
            if (!Objects.equals(textPreProcessor.prompt_opt, null)) {
                PromptOpt.ADAPTER.encodeWithTag(protoWriter, 3, textPreProcessor.prompt_opt);
            }
            protoWriter.writeBytes(textPreProcessor.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(TextPreProcessor textPreProcessor) {
            int i3 = 0;
            if (!Objects.equals(textPreProcessor.act, TextPreProcessAct.TEXT_PREPROCESS_ACT_UNKNOWN)) {
                i3 = 0 + TextPreProcessAct.ADAPTER.encodedSizeWithTag(1, textPreProcessor.act);
            }
            if (!Objects.equals(textPreProcessor.jieba_opt, null)) {
                i3 += JiebaOpt.ADAPTER.encodedSizeWithTag(2, textPreProcessor.jieba_opt);
            }
            if (!Objects.equals(textPreProcessor.prompt_opt, null)) {
                i3 += PromptOpt.ADAPTER.encodedSizeWithTag(3, textPreProcessor.prompt_opt);
            }
            return i3 + textPreProcessor.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public TextPreProcessor redact(TextPreProcessor textPreProcessor) {
            a newBuilder = textPreProcessor.newBuilder();
            JiebaOpt jiebaOpt = newBuilder.f398539b;
            if (jiebaOpt != null) {
                newBuilder.f398539b = JiebaOpt.ADAPTER.redact(jiebaOpt);
            }
            PromptOpt promptOpt = newBuilder.f398540c;
            if (promptOpt != null) {
                newBuilder.f398540c = PromptOpt.ADAPTER.redact(promptOpt);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public TextPreProcessor(TextPreProcessAct textPreProcessAct, JiebaOpt jiebaOpt, PromptOpt promptOpt) {
        this(textPreProcessAct, jiebaOpt, promptOpt, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextPreProcessor)) {
            return false;
        }
        TextPreProcessor textPreProcessor = (TextPreProcessor) obj;
        if (unknownFields().equals(textPreProcessor.unknownFields()) && Internal.equals(this.act, textPreProcessor.act) && Internal.equals(this.jieba_opt, textPreProcessor.jieba_opt) && Internal.equals(this.prompt_opt, textPreProcessor.prompt_opt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            TextPreProcessAct textPreProcessAct = this.act;
            int i18 = 0;
            if (textPreProcessAct != null) {
                i3 = textPreProcessAct.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            JiebaOpt jiebaOpt = this.jieba_opt;
            if (jiebaOpt != null) {
                i16 = jiebaOpt.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            PromptOpt promptOpt = this.prompt_opt;
            if (promptOpt != null) {
                i18 = promptOpt.hashCode();
            }
            int i27 = i26 + i18;
            this.hashCode = i27;
            return i27;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.act != null) {
            sb5.append(", act=");
            sb5.append(this.act);
        }
        if (this.jieba_opt != null) {
            sb5.append(", jieba_opt=");
            sb5.append(this.jieba_opt);
        }
        if (this.prompt_opt != null) {
            sb5.append(", prompt_opt=");
            sb5.append(this.prompt_opt);
        }
        StringBuilder replace = sb5.replace(0, 2, "TextPreProcessor{");
        replace.append('}');
        return replace.toString();
    }

    public TextPreProcessor(TextPreProcessAct textPreProcessAct, JiebaOpt jiebaOpt, PromptOpt promptOpt, ByteString byteString) {
        super(ADAPTER, byteString);
        if (textPreProcessAct != null) {
            this.act = textPreProcessAct;
            this.jieba_opt = jiebaOpt;
            this.prompt_opt = promptOpt;
            return;
        }
        throw new IllegalArgumentException("act == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398538a = this.act;
        aVar.f398539b = this.jieba_opt;
        aVar.f398540c = this.prompt_opt;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
