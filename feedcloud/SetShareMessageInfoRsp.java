package feedcloud;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import java.io.IOException;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SetShareMessageInfoRsp extends Message<SetShareMessageInfoRsp, a> {
    public static final ProtoAdapter<SetShareMessageInfoRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<SetShareMessageInfoRsp, a> {
        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetShareMessageInfoRsp build() {
            return new SetShareMessageInfoRsp(super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<SetShareMessageInfoRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SetShareMessageInfoRsp.class, "type.googleapis.com/trpc.feedcloud.reply_share_message.SetShareMessageInfoRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetShareMessageInfoRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    protoReader.readUnknownField(nextTag);
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SetShareMessageInfoRsp setShareMessageInfoRsp) throws IOException {
            protoWriter.writeBytes(setShareMessageInfoRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SetShareMessageInfoRsp setShareMessageInfoRsp) {
            return setShareMessageInfoRsp.unknownFields().size() + 0;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SetShareMessageInfoRsp redact(SetShareMessageInfoRsp setShareMessageInfoRsp) {
            a newBuilder = setShareMessageInfoRsp.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SetShareMessageInfoRsp() {
        this(ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetShareMessageInfoRsp)) {
            return false;
        }
        return unknownFields().equals(((SetShareMessageInfoRsp) obj).unknownFields());
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder replace = new StringBuilder().replace(0, 2, "SetShareMessageInfoRsp{");
        replace.append('}');
        return replace.toString();
    }

    public SetShareMessageInfoRsp(ByteString byteString) {
        super(ADAPTER, byteString);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
