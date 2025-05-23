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
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MultiInferTextRsp extends Message<MultiInferTextRsp, a> {
    public static final ProtoAdapter<MultiInferTextRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.Embedding#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Embedding> embeddings;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<MultiInferTextRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<Embedding> f398517a = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MultiInferTextRsp build() {
            return new MultiInferTextRsp(this.f398517a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<MultiInferTextRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MultiInferTextRsp.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.MultiInferTextRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MultiInferTextRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f398517a.add(Embedding.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, MultiInferTextRsp multiInferTextRsp) throws IOException {
            Embedding.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, multiInferTextRsp.embeddings);
            protoWriter.writeBytes(multiInferTextRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(MultiInferTextRsp multiInferTextRsp) {
            return Embedding.ADAPTER.asRepeated().encodedSizeWithTag(1, multiInferTextRsp.embeddings) + 0 + multiInferTextRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MultiInferTextRsp redact(MultiInferTextRsp multiInferTextRsp) {
            a newBuilder = multiInferTextRsp.newBuilder();
            Internal.redactElements(newBuilder.f398517a, Embedding.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MultiInferTextRsp(List<Embedding> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiInferTextRsp)) {
            return false;
        }
        MultiInferTextRsp multiInferTextRsp = (MultiInferTextRsp) obj;
        if (unknownFields().equals(multiInferTextRsp.unknownFields()) && this.embeddings.equals(multiInferTextRsp.embeddings)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.embeddings.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.embeddings.isEmpty()) {
            sb5.append(", embeddings=");
            sb5.append(this.embeddings);
        }
        StringBuilder replace = sb5.replace(0, 2, "MultiInferTextRsp{");
        replace.append('}');
        return replace.toString();
    }

    public MultiInferTextRsp(List<Embedding> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.embeddings = Internal.immutableCopyOf("embeddings", list);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398517a = Internal.copyOf(this.embeddings);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
