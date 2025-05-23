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
public final class InferFeedInfoRsp extends Message<InferFeedInfoRsp, a> {
    public static final ProtoAdapter<InferFeedInfoRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.Embedding#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Embedding> embeddings;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<InferFeedInfoRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<Embedding> f398504a = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InferFeedInfoRsp build() {
            return new InferFeedInfoRsp(this.f398504a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<InferFeedInfoRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) InferFeedInfoRsp.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.InferFeedInfoRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InferFeedInfoRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f398504a.add(Embedding.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, InferFeedInfoRsp inferFeedInfoRsp) throws IOException {
            Embedding.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, inferFeedInfoRsp.embeddings);
            protoWriter.writeBytes(inferFeedInfoRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(InferFeedInfoRsp inferFeedInfoRsp) {
            return Embedding.ADAPTER.asRepeated().encodedSizeWithTag(1, inferFeedInfoRsp.embeddings) + 0 + inferFeedInfoRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public InferFeedInfoRsp redact(InferFeedInfoRsp inferFeedInfoRsp) {
            a newBuilder = inferFeedInfoRsp.newBuilder();
            Internal.redactElements(newBuilder.f398504a, Embedding.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public InferFeedInfoRsp(List<Embedding> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InferFeedInfoRsp)) {
            return false;
        }
        InferFeedInfoRsp inferFeedInfoRsp = (InferFeedInfoRsp) obj;
        if (unknownFields().equals(inferFeedInfoRsp.unknownFields()) && this.embeddings.equals(inferFeedInfoRsp.embeddings)) {
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
        StringBuilder replace = sb5.replace(0, 2, "InferFeedInfoRsp{");
        replace.append('}');
        return replace.toString();
    }

    public InferFeedInfoRsp(List<Embedding> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.embeddings = Internal.immutableCopyOf("embeddings", list);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398504a = Internal.copyOf(this.embeddings);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
