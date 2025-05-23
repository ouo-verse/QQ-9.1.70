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
public final class SetSwitchReq extends Message<SetSwitchReq, a> {
    public static final ProtoAdapter<SetSwitchReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String uid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final boolean value;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<SetSwitchReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f398526a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f398527b = "";

        /* renamed from: c, reason: collision with root package name */
        public boolean f398528c = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetSwitchReq build() {
            return new SetSwitchReq(this.f398526a, this.f398527b, this.f398528c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398527b = str;
            return this;
        }

        public a c(String str) {
            this.f398526a = str;
            return this;
        }

        public a d(boolean z16) {
            this.f398528c = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<SetSwitchReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SetSwitchReq.class, "type.googleapis.com/trpc.feedcloud.userswitch.SetSwitchReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SetSwitchReq decode(ProtoReader protoReader) throws IOException {
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
                                aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            }
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
        public void encode(ProtoWriter protoWriter, SetSwitchReq setSwitchReq) throws IOException {
            if (!Objects.equals(setSwitchReq.uid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, setSwitchReq.uid);
            }
            if (!Objects.equals(setSwitchReq.key, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, setSwitchReq.key);
            }
            if (!Objects.equals(Boolean.valueOf(setSwitchReq.value), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, Boolean.valueOf(setSwitchReq.value));
            }
            protoWriter.writeBytes(setSwitchReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SetSwitchReq setSwitchReq) {
            int i3 = 0;
            if (!Objects.equals(setSwitchReq.uid, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, setSwitchReq.uid);
            }
            if (!Objects.equals(setSwitchReq.key, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, setSwitchReq.key);
            }
            if (!Objects.equals(Boolean.valueOf(setSwitchReq.value), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(setSwitchReq.value));
            }
            return i3 + setSwitchReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SetSwitchReq redact(SetSwitchReq setSwitchReq) {
            a newBuilder = setSwitchReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SetSwitchReq(String str, String str2, boolean z16) {
        this(str, str2, z16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetSwitchReq)) {
            return false;
        }
        SetSwitchReq setSwitchReq = (SetSwitchReq) obj;
        if (unknownFields().equals(setSwitchReq.unknownFields()) && Internal.equals(this.uid, setSwitchReq.uid) && Internal.equals(this.key, setSwitchReq.key) && Internal.equals(Boolean.valueOf(this.value), Boolean.valueOf(setSwitchReq.value))) {
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
            String str2 = this.key;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int a16 = ((i18 + i17) * 37) + com.tencent.aio.widget.textView.param.a.a(this.value);
            this.hashCode = a16;
            return a16;
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
        if (this.key != null) {
            sb5.append(", key=");
            sb5.append(Internal.sanitize(this.key));
        }
        sb5.append(", value=");
        sb5.append(this.value);
        StringBuilder replace = sb5.replace(0, 2, "SetSwitchReq{");
        replace.append('}');
        return replace.toString();
    }

    public SetSwitchReq(String str, String str2, boolean z16, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.uid = str;
            if (str2 != null) {
                this.key = str2;
                this.value = z16;
                return;
            }
            throw new IllegalArgumentException("key == null");
        }
        throw new IllegalArgumentException("uid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398526a = this.uid;
        aVar.f398527b = this.key;
        aVar.f398528c = this.value;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
