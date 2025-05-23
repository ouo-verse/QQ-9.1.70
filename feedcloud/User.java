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
public final class User extends Message<User, a> {
    public static final ProtoAdapter<User> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String nick;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String uid;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<User, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f398541a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f398542b = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public User build() {
            return new User(this.f398541a, this.f398542b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398542b = str;
            return this;
        }

        public a c(String str) {
            this.f398541a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<User> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) User.class, "type.googleapis.com/trpc.feedcloud.comment_right.User", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public User decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, User user) throws IOException {
            if (!Objects.equals(user.uid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, user.uid);
            }
            if (!Objects.equals(user.nick, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, user.nick);
            }
            protoWriter.writeBytes(user.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(User user) {
            int i3 = 0;
            if (!Objects.equals(user.uid, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, user.uid);
            }
            if (!Objects.equals(user.nick, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, user.nick);
            }
            return i3 + user.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public User redact(User user) {
            a newBuilder = user.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public User(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        if (unknownFields().equals(user.unknownFields()) && Internal.equals(this.uid, user.uid) && Internal.equals(this.nick, user.nick)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.uid;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.nick;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.uid != null) {
            sb5.append(", uid=");
            sb5.append(Internal.sanitize(this.uid));
        }
        if (this.nick != null) {
            sb5.append(", nick=");
            sb5.append(Internal.sanitize(this.nick));
        }
        StringBuilder replace = sb5.replace(0, 2, "User{");
        replace.append('}');
        return replace.toString();
    }

    public User(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.uid = str;
            if (str2 != null) {
                this.nick = str2;
                return;
            }
            throw new IllegalArgumentException("nick == null");
        }
        throw new IllegalArgumentException("uid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398541a = this.uid;
        aVar.f398542b = this.nick;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
