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
public final class InferFeedInfoReq extends Message<InferFeedInfoReq, a> {
    public static final ProtoAdapter<InferFeedInfoReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "feedId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String feed_id;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<InferFeedInfoReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f398503a = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InferFeedInfoReq build() {
            return new InferFeedInfoReq(this.f398503a, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398503a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<InferFeedInfoReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) InferFeedInfoReq.class, "type.googleapis.com/trpc.feedcloud.clip_infer_svr.InferFeedInfoReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InferFeedInfoReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, InferFeedInfoReq inferFeedInfoReq) throws IOException {
            if (!Objects.equals(inferFeedInfoReq.feed_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, inferFeedInfoReq.feed_id);
            }
            protoWriter.writeBytes(inferFeedInfoReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(InferFeedInfoReq inferFeedInfoReq) {
            int i3 = 0;
            if (!Objects.equals(inferFeedInfoReq.feed_id, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, inferFeedInfoReq.feed_id);
            }
            return i3 + inferFeedInfoReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public InferFeedInfoReq redact(InferFeedInfoReq inferFeedInfoReq) {
            a newBuilder = inferFeedInfoReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public InferFeedInfoReq(String str) {
        this(str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InferFeedInfoReq)) {
            return false;
        }
        InferFeedInfoReq inferFeedInfoReq = (InferFeedInfoReq) obj;
        if (unknownFields().equals(inferFeedInfoReq.unknownFields()) && Internal.equals(this.feed_id, inferFeedInfoReq.feed_id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.feed_id;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.feed_id != null) {
            sb5.append(", feed_id=");
            sb5.append(Internal.sanitize(this.feed_id));
        }
        StringBuilder replace = sb5.replace(0, 2, "InferFeedInfoReq{");
        replace.append('}');
        return replace.toString();
    }

    public InferFeedInfoReq(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.feed_id = str;
            return;
        }
        throw new IllegalArgumentException("feed_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398503a = this.feed_id;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
