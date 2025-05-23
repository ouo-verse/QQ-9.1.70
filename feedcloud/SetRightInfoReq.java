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

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SetRightInfoReq extends Message<SetRightInfoReq, a> {
    public static final ProtoAdapter<SetRightInfoReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "feedId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String feed_id;

    @WireField(adapter = "feedcloud.RightFlag#ADAPTER", jsonName = "rightFlag", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final RightFlag right_flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> uids;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<SetRightInfoReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f398522a = "";

        /* renamed from: b, reason: collision with root package name */
        public RightFlag f398523b = RightFlag.RIGHTFLAG_NONE;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f398524c = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetRightInfoReq build() {
            return new SetRightInfoReq(this.f398522a, this.f398523b, this.f398524c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398522a = str;
            return this;
        }

        public a c(RightFlag rightFlag) {
            this.f398523b = rightFlag;
            return this;
        }

        public a d(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f398524c = list;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<SetRightInfoReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SetRightInfoReq.class, "type.googleapis.com/trpc.feedcloud.comment_right.SetRightInfoReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetRightInfoReq decode(ProtoReader protoReader) throws IOException {
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
                                aVar.f398524c.add(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            try {
                                aVar.c(RightFlag.ADAPTER.decode(protoReader));
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                            }
                        }
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
        public void encode(ProtoWriter protoWriter, SetRightInfoReq setRightInfoReq) throws IOException {
            if (!Objects.equals(setRightInfoReq.feed_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, setRightInfoReq.feed_id);
            }
            if (!Objects.equals(setRightInfoReq.right_flag, RightFlag.RIGHTFLAG_NONE)) {
                RightFlag.ADAPTER.encodeWithTag(protoWriter, 2, setRightInfoReq.right_flag);
            }
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 3, setRightInfoReq.uids);
            protoWriter.writeBytes(setRightInfoReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SetRightInfoReq setRightInfoReq) {
            int i3 = 0;
            if (!Objects.equals(setRightInfoReq.feed_id, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, setRightInfoReq.feed_id);
            }
            if (!Objects.equals(setRightInfoReq.right_flag, RightFlag.RIGHTFLAG_NONE)) {
                i3 += RightFlag.ADAPTER.encodedSizeWithTag(2, setRightInfoReq.right_flag);
            }
            return i3 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, setRightInfoReq.uids) + setRightInfoReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SetRightInfoReq redact(SetRightInfoReq setRightInfoReq) {
            a newBuilder = setRightInfoReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SetRightInfoReq(String str, RightFlag rightFlag, List<String> list) {
        this(str, rightFlag, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetRightInfoReq)) {
            return false;
        }
        SetRightInfoReq setRightInfoReq = (SetRightInfoReq) obj;
        if (unknownFields().equals(setRightInfoReq.unknownFields()) && Internal.equals(this.feed_id, setRightInfoReq.feed_id) && Internal.equals(this.right_flag, setRightInfoReq.right_flag) && this.uids.equals(setRightInfoReq.uids)) {
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
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            RightFlag rightFlag = this.right_flag;
            if (rightFlag != null) {
                i17 = rightFlag.hashCode();
            }
            int hashCode2 = ((i18 + i17) * 37) + this.uids.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
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
        if (this.right_flag != null) {
            sb5.append(", right_flag=");
            sb5.append(this.right_flag);
        }
        if (!this.uids.isEmpty()) {
            sb5.append(", uids=");
            sb5.append(Internal.sanitize(this.uids));
        }
        StringBuilder replace = sb5.replace(0, 2, "SetRightInfoReq{");
        replace.append('}');
        return replace.toString();
    }

    public SetRightInfoReq(String str, RightFlag rightFlag, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.feed_id = str;
            if (rightFlag != null) {
                this.right_flag = rightFlag;
                this.uids = Internal.immutableCopyOf("uids", list);
                return;
            }
            throw new IllegalArgumentException("right_flag == null");
        }
        throw new IllegalArgumentException("feed_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398522a = this.feed_id;
        aVar.f398523b = this.right_flag;
        aVar.f398524c = Internal.copyOf(this.uids);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
