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
public final class RightInfo extends Message<RightInfo, a> {
    public static final ProtoAdapter<RightInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "feedcloud.RightFlag#ADAPTER", jsonName = "rightFlag", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RightFlag right_flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> uids;

    @WireField(adapter = "feedcloud.User#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<User> users;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<RightInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public RightFlag f398519a = RightFlag.RIGHTFLAG_NONE;

        /* renamed from: b, reason: collision with root package name */
        public List<String> f398520b = Internal.newMutableList();

        /* renamed from: c, reason: collision with root package name */
        public List<User> f398521c = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RightInfo build() {
            return new RightInfo(this.f398519a, this.f398520b, this.f398521c, super.buildUnknownFields());
        }

        public a b(RightFlag rightFlag) {
            this.f398519a = rightFlag;
            return this;
        }

        public a c(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.f398520b = list;
            return this;
        }

        public a d(List<User> list) {
            Internal.checkElementsNotNull(list);
            this.f398521c = list;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<RightInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RightInfo.class, "type.googleapis.com/trpc.feedcloud.comment_right.RightInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RightInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.f398521c.add(User.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.f398520b.add(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        try {
                            aVar.b(RightFlag.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, RightInfo rightInfo) throws IOException {
            if (!Objects.equals(rightInfo.right_flag, RightFlag.RIGHTFLAG_NONE)) {
                RightFlag.ADAPTER.encodeWithTag(protoWriter, 1, rightInfo.right_flag);
            }
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, rightInfo.uids);
            User.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, rightInfo.users);
            protoWriter.writeBytes(rightInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RightInfo rightInfo) {
            int i3 = 0;
            if (!Objects.equals(rightInfo.right_flag, RightFlag.RIGHTFLAG_NONE)) {
                i3 = 0 + RightFlag.ADAPTER.encodedSizeWithTag(1, rightInfo.right_flag);
            }
            return i3 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, rightInfo.uids) + User.ADAPTER.asRepeated().encodedSizeWithTag(3, rightInfo.users) + rightInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RightInfo redact(RightInfo rightInfo) {
            a newBuilder = rightInfo.newBuilder();
            Internal.redactElements(newBuilder.f398521c, User.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RightInfo(RightFlag rightFlag, List<String> list, List<User> list2) {
        this(rightFlag, list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RightInfo)) {
            return false;
        }
        RightInfo rightInfo = (RightInfo) obj;
        if (unknownFields().equals(rightInfo.unknownFields()) && Internal.equals(this.right_flag, rightInfo.right_flag) && this.uids.equals(rightInfo.uids) && this.users.equals(rightInfo.users)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RightFlag rightFlag = this.right_flag;
            if (rightFlag != null) {
                i3 = rightFlag.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((((hashCode + i3) * 37) + this.uids.hashCode()) * 37) + this.users.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.right_flag != null) {
            sb5.append(", right_flag=");
            sb5.append(this.right_flag);
        }
        if (!this.uids.isEmpty()) {
            sb5.append(", uids=");
            sb5.append(Internal.sanitize(this.uids));
        }
        if (!this.users.isEmpty()) {
            sb5.append(", users=");
            sb5.append(this.users);
        }
        StringBuilder replace = sb5.replace(0, 2, "RightInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RightInfo(RightFlag rightFlag, List<String> list, List<User> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (rightFlag != null) {
            this.right_flag = rightFlag;
            this.uids = Internal.immutableCopyOf("uids", list);
            this.users = Internal.immutableCopyOf("users", list2);
            return;
        }
        throw new IllegalArgumentException("right_flag == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398519a = this.right_flag;
        aVar.f398520b = Internal.copyOf(this.uids);
        aVar.f398521c = Internal.copyOf(this.users);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
