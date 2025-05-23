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
public final class GetSwitchReq extends Message<GetSwitchReq, a> {
    public static final ProtoAdapter<GetSwitchReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> keys;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> uids;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<GetSwitchReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f398499a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public List<String> f398500b = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSwitchReq build() {
            return new GetSwitchReq(this.f398499a, this.f398500b, super.buildUnknownFields());
        }

        public a b(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f398500b = list;
            return this;
        }

        public a c(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f398499a = list;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<GetSwitchReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetSwitchReq.class, "type.googleapis.com/trpc.feedcloud.userswitch.GetSwitchReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSwitchReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f398500b.add(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.f398499a.add(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetSwitchReq getSwitchReq) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 1, getSwitchReq.uids);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 2, getSwitchReq.keys);
            protoWriter.writeBytes(getSwitchReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetSwitchReq getSwitchReq) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.asRepeated().encodedSizeWithTag(1, getSwitchReq.uids) + 0 + protoAdapter.asRepeated().encodedSizeWithTag(2, getSwitchReq.keys) + getSwitchReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public GetSwitchReq redact(GetSwitchReq getSwitchReq) {
            a newBuilder = getSwitchReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetSwitchReq(List<String> list, List<String> list2) {
        this(list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSwitchReq)) {
            return false;
        }
        GetSwitchReq getSwitchReq = (GetSwitchReq) obj;
        if (unknownFields().equals(getSwitchReq.unknownFields()) && this.uids.equals(getSwitchReq.uids) && this.keys.equals(getSwitchReq.keys)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.uids.hashCode()) * 37) + this.keys.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.uids.isEmpty()) {
            sb5.append(", uids=");
            sb5.append(Internal.sanitize(this.uids));
        }
        if (!this.keys.isEmpty()) {
            sb5.append(", keys=");
            sb5.append(Internal.sanitize(this.keys));
        }
        StringBuilder replace = sb5.replace(0, 2, "GetSwitchReq{");
        replace.append('}');
        return replace.toString();
    }

    public GetSwitchReq(List<String> list, List<String> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.uids = Internal.immutableCopyOf("uids", list);
        this.keys = Internal.immutableCopyOf("keys", list2);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398499a = Internal.copyOf(this.uids);
        aVar.f398500b = Internal.copyOf(this.keys);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
