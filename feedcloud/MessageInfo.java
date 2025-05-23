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
public final class MessageInfo extends Message<MessageInfo, a> {
    public static final ProtoAdapter<MessageInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final int chatType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final long clientSeq;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final long msgRandom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long msgSeq;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final long msgTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String peerUID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String senderUID;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<MessageInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public long f398506a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f398507b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f398508c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f398509d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f398510e = 0;

        /* renamed from: f, reason: collision with root package name */
        public String f398511f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f398512g = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageInfo build() {
            return new MessageInfo(this.f398506a, this.f398507b, this.f398508c, this.f398509d, this.f398510e, this.f398511f, this.f398512g, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f398510e = i3;
            return this;
        }

        public a c(long j3) {
            this.f398509d = j3;
            return this;
        }

        public a d(long j3) {
            this.f398507b = j3;
            return this;
        }

        public a e(long j3) {
            this.f398508c = j3;
            return this;
        }

        public a f(long j3) {
            this.f398506a = j3;
            return this;
        }

        public a g(String str) {
            this.f398511f = str;
            return this;
        }

        public a h(String str) {
            this.f398512g = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<MessageInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MessageInfo.class, "type.googleapis.com/trpc.feedcloud.reply_share_message.MessageInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.f(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 2:
                            aVar.d(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 3:
                            aVar.e(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 4:
                            aVar.c(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 5:
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 6:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, MessageInfo messageInfo) throws IOException {
            if (!Objects.equals(Long.valueOf(messageInfo.msgTime), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(messageInfo.msgTime));
            }
            if (!Objects.equals(Long.valueOf(messageInfo.msgRandom), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, Long.valueOf(messageInfo.msgRandom));
            }
            if (!Objects.equals(Long.valueOf(messageInfo.msgSeq), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, Long.valueOf(messageInfo.msgSeq));
            }
            if (!Objects.equals(Long.valueOf(messageInfo.clientSeq), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, Long.valueOf(messageInfo.clientSeq));
            }
            if (!Objects.equals(Integer.valueOf(messageInfo.chatType), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, Integer.valueOf(messageInfo.chatType));
            }
            if (!Objects.equals(messageInfo.peerUID, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, messageInfo.peerUID);
            }
            if (!Objects.equals(messageInfo.senderUID, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, messageInfo.senderUID);
            }
            protoWriter.writeBytes(messageInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(MessageInfo messageInfo) {
            int i3;
            if (!Objects.equals(Long.valueOf(messageInfo.msgTime), 0L)) {
                i3 = ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(messageInfo.msgTime)) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Long.valueOf(messageInfo.msgRandom), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(2, Long.valueOf(messageInfo.msgRandom));
            }
            if (!Objects.equals(Long.valueOf(messageInfo.msgSeq), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(messageInfo.msgSeq));
            }
            if (!Objects.equals(Long.valueOf(messageInfo.clientSeq), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(messageInfo.clientSeq));
            }
            if (!Objects.equals(Integer.valueOf(messageInfo.chatType), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(messageInfo.chatType));
            }
            if (!Objects.equals(messageInfo.peerUID, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, messageInfo.peerUID);
            }
            if (!Objects.equals(messageInfo.senderUID, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, messageInfo.senderUID);
            }
            return i3 + messageInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MessageInfo redact(MessageInfo messageInfo) {
            a newBuilder = messageInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MessageInfo(long j3, long j16, long j17, long j18, int i3, String str, String str2) {
        this(j3, j16, j17, j18, i3, str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessageInfo)) {
            return false;
        }
        MessageInfo messageInfo = (MessageInfo) obj;
        if (unknownFields().equals(messageInfo.unknownFields()) && Internal.equals(Long.valueOf(this.msgTime), Long.valueOf(messageInfo.msgTime)) && Internal.equals(Long.valueOf(this.msgRandom), Long.valueOf(messageInfo.msgRandom)) && Internal.equals(Long.valueOf(this.msgSeq), Long.valueOf(messageInfo.msgSeq)) && Internal.equals(Long.valueOf(this.clientSeq), Long.valueOf(messageInfo.clientSeq)) && Internal.equals(Integer.valueOf(this.chatType), Integer.valueOf(messageInfo.chatType)) && Internal.equals(this.peerUID, messageInfo.peerUID) && Internal.equals(this.senderUID, messageInfo.senderUID)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((((((unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.msgTime)) * 37) + androidx.fragment.app.a.a(this.msgRandom)) * 37) + androidx.fragment.app.a.a(this.msgSeq)) * 37) + androidx.fragment.app.a.a(this.clientSeq)) * 37) + this.chatType) * 37;
            String str = this.peerUID;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.senderUID;
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
        sb5.append(", msgTime=");
        sb5.append(this.msgTime);
        sb5.append(", msgRandom=");
        sb5.append(this.msgRandom);
        sb5.append(", msgSeq=");
        sb5.append(this.msgSeq);
        sb5.append(", clientSeq=");
        sb5.append(this.clientSeq);
        sb5.append(", chatType=");
        sb5.append(this.chatType);
        if (this.peerUID != null) {
            sb5.append(", peerUID=");
            sb5.append(Internal.sanitize(this.peerUID));
        }
        if (this.senderUID != null) {
            sb5.append(", senderUID=");
            sb5.append(Internal.sanitize(this.senderUID));
        }
        StringBuilder replace = sb5.replace(0, 2, "MessageInfo{");
        replace.append('}');
        return replace.toString();
    }

    public MessageInfo(long j3, long j16, long j17, long j18, int i3, String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.msgTime = j3;
        this.msgRandom = j16;
        this.msgSeq = j17;
        this.clientSeq = j18;
        this.chatType = i3;
        if (str != null) {
            this.peerUID = str;
            if (str2 != null) {
                this.senderUID = str2;
                return;
            }
            throw new IllegalArgumentException("senderUID == null");
        }
        throw new IllegalArgumentException("peerUID == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398506a = this.msgTime;
        aVar.f398507b = this.msgRandom;
        aVar.f398508c = this.msgSeq;
        aVar.f398509d = this.clientSeq;
        aVar.f398510e = this.chatType;
        aVar.f398511f = this.peerUID;
        aVar.f398512g = this.senderUID;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
