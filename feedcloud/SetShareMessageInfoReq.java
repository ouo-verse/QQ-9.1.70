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
public final class SetShareMessageInfoReq extends Message<SetShareMessageInfoReq, a> {
    public static final ProtoAdapter<SetShareMessageInfoReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.ShareMessageInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<ShareMessageInfo> shareMessageInfos;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<SetShareMessageInfoReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<ShareMessageInfo> f398525a = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetShareMessageInfoReq build() {
            return new SetShareMessageInfoReq(this.f398525a, super.buildUnknownFields());
        }

        public a b(List<ShareMessageInfo> list) {
            Internal.checkElementsNotNull(list);
            this.f398525a = list;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<SetShareMessageInfoReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SetShareMessageInfoReq.class, "type.googleapis.com/trpc.feedcloud.reply_share_message.SetShareMessageInfoReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetShareMessageInfoReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f398525a.add(ShareMessageInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SetShareMessageInfoReq setShareMessageInfoReq) throws IOException {
            ShareMessageInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, setShareMessageInfoReq.shareMessageInfos);
            protoWriter.writeBytes(setShareMessageInfoReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SetShareMessageInfoReq setShareMessageInfoReq) {
            return ShareMessageInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, setShareMessageInfoReq.shareMessageInfos) + 0 + setShareMessageInfoReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SetShareMessageInfoReq redact(SetShareMessageInfoReq setShareMessageInfoReq) {
            a newBuilder = setShareMessageInfoReq.newBuilder();
            Internal.redactElements(newBuilder.f398525a, ShareMessageInfo.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SetShareMessageInfoReq(List<ShareMessageInfo> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetShareMessageInfoReq)) {
            return false;
        }
        SetShareMessageInfoReq setShareMessageInfoReq = (SetShareMessageInfoReq) obj;
        if (unknownFields().equals(setShareMessageInfoReq.unknownFields()) && this.shareMessageInfos.equals(setShareMessageInfoReq.shareMessageInfos)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.shareMessageInfos.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.shareMessageInfos.isEmpty()) {
            sb5.append(", shareMessageInfos=");
            sb5.append(this.shareMessageInfos);
        }
        StringBuilder replace = sb5.replace(0, 2, "SetShareMessageInfoReq{");
        replace.append('}');
        return replace.toString();
    }

    public SetShareMessageInfoReq(List<ShareMessageInfo> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.shareMessageInfos = Internal.immutableCopyOf("shareMessageInfos", list);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398525a = Internal.copyOf(this.shareMessageInfos);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
