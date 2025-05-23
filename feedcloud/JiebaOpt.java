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

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JiebaOpt extends Message<JiebaOpt, a> {
    public static final ProtoAdapter<JiebaOpt> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "topK", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int top_k;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<JiebaOpt, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f398505a = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JiebaOpt build() {
            return new JiebaOpt(this.f398505a, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f398505a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<JiebaOpt> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) JiebaOpt.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.JiebaOpt", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JiebaOpt decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.b(ProtoAdapter.UINT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, JiebaOpt jiebaOpt) throws IOException {
            if (!Objects.equals(Integer.valueOf(jiebaOpt.top_k), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, Integer.valueOf(jiebaOpt.top_k));
            }
            protoWriter.writeBytes(jiebaOpt.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(JiebaOpt jiebaOpt) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(jiebaOpt.top_k), 0)) {
                i3 = 0 + ProtoAdapter.UINT32.encodedSizeWithTag(1, Integer.valueOf(jiebaOpt.top_k));
            }
            return i3 + jiebaOpt.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public JiebaOpt redact(JiebaOpt jiebaOpt) {
            a newBuilder = jiebaOpt.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public JiebaOpt(int i3) {
        this(i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JiebaOpt)) {
            return false;
        }
        JiebaOpt jiebaOpt = (JiebaOpt) obj;
        if (unknownFields().equals(jiebaOpt.unknownFields()) && Internal.equals(Integer.valueOf(this.top_k), Integer.valueOf(jiebaOpt.top_k))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.top_k;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", top_k=");
        sb5.append(this.top_k);
        StringBuilder replace = sb5.replace(0, 2, "JiebaOpt{");
        replace.append('}');
        return replace.toString();
    }

    public JiebaOpt(int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.top_k = i3;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398505a = this.top_k;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
