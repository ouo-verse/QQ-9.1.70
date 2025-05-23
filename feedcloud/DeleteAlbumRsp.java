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
public final class DeleteAlbumRsp extends Message<DeleteAlbumRsp, a> {
    public static final ProtoAdapter<DeleteAlbumRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<DeleteAlbumRsp, a> {
        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeleteAlbumRsp build() {
            return new DeleteAlbumRsp(super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<DeleteAlbumRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DeleteAlbumRsp.class, "type.googleapis.com/trpc.feedcloud.qqvideo_album.DeleteAlbumRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeleteAlbumRsp decode(ProtoReader protoReader) throws IOException {
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
        public void encode(ProtoWriter protoWriter, DeleteAlbumRsp deleteAlbumRsp) throws IOException {
            protoWriter.writeBytes(deleteAlbumRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(DeleteAlbumRsp deleteAlbumRsp) {
            return deleteAlbumRsp.unknownFields().size() + 0;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DeleteAlbumRsp redact(DeleteAlbumRsp deleteAlbumRsp) {
            a newBuilder = deleteAlbumRsp.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public DeleteAlbumRsp() {
        this(ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeleteAlbumRsp)) {
            return false;
        }
        return unknownFields().equals(((DeleteAlbumRsp) obj).unknownFields());
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder replace = new StringBuilder().replace(0, 2, "DeleteAlbumRsp{");
        replace.append('}');
        return replace.toString();
    }

    public DeleteAlbumRsp(ByteString byteString) {
        super(ADAPTER, byteString);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
