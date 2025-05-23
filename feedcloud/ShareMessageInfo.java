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
public final class ShareMessageInfo extends Message<ShareMessageInfo, a> {
    public static final ProtoAdapter<ShareMessageInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String dstUin;

    @WireField(adapter = "feedcloud.DstUinType#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final DstUinType dstUinType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String feedID;

    @WireField(adapter = "feedcloud.MessageInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final MessageInfo messageInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String shareUin;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends Message.Builder<ShareMessageInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f398529a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f398530b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f398531c = "";

        /* renamed from: d, reason: collision with root package name */
        public DstUinType f398532d = DstUinType.UIN_TYPE_UNKNOWN;

        /* renamed from: e, reason: collision with root package name */
        public MessageInfo f398533e;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareMessageInfo build() {
            return new ShareMessageInfo(this.f398529a, this.f398530b, this.f398531c, this.f398532d, this.f398533e, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f398531c = str;
            return this;
        }

        public a c(DstUinType dstUinType) {
            this.f398532d = dstUinType;
            return this;
        }

        public a d(String str) {
            this.f398529a = str;
            return this;
        }

        public a e(MessageInfo messageInfo) {
            this.f398533e = messageInfo;
            return this;
        }

        public a f(String str) {
            this.f398530b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static final class b extends ProtoAdapter<ShareMessageInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ShareMessageInfo.class, "type.googleapis.com/trpc.feedcloud.reply_share_message.ShareMessageInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareMessageInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 5) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.e(MessageInfo.ADAPTER.decode(protoReader));
                                    }
                                } else {
                                    try {
                                        aVar.c(DstUinType.ADAPTER.decode(protoReader));
                                    } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                        aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    }
                                }
                            } else {
                                aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.d(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, ShareMessageInfo shareMessageInfo) throws IOException {
            if (!Objects.equals(shareMessageInfo.feedID, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, shareMessageInfo.feedID);
            }
            if (!Objects.equals(shareMessageInfo.shareUin, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, shareMessageInfo.shareUin);
            }
            if (!Objects.equals(shareMessageInfo.dstUin, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, shareMessageInfo.dstUin);
            }
            if (!Objects.equals(shareMessageInfo.dstUinType, DstUinType.UIN_TYPE_UNKNOWN)) {
                DstUinType.ADAPTER.encodeWithTag(protoWriter, 4, shareMessageInfo.dstUinType);
            }
            if (!Objects.equals(shareMessageInfo.messageInfo, null)) {
                MessageInfo.ADAPTER.encodeWithTag(protoWriter, 5, shareMessageInfo.messageInfo);
            }
            protoWriter.writeBytes(shareMessageInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ShareMessageInfo shareMessageInfo) {
            int i3 = 0;
            if (!Objects.equals(shareMessageInfo.feedID, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, shareMessageInfo.feedID);
            }
            if (!Objects.equals(shareMessageInfo.shareUin, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, shareMessageInfo.shareUin);
            }
            if (!Objects.equals(shareMessageInfo.dstUin, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, shareMessageInfo.dstUin);
            }
            if (!Objects.equals(shareMessageInfo.dstUinType, DstUinType.UIN_TYPE_UNKNOWN)) {
                i3 += DstUinType.ADAPTER.encodedSizeWithTag(4, shareMessageInfo.dstUinType);
            }
            if (!Objects.equals(shareMessageInfo.messageInfo, null)) {
                i3 += MessageInfo.ADAPTER.encodedSizeWithTag(5, shareMessageInfo.messageInfo);
            }
            return i3 + shareMessageInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ShareMessageInfo redact(ShareMessageInfo shareMessageInfo) {
            a newBuilder = shareMessageInfo.newBuilder();
            MessageInfo messageInfo = newBuilder.f398533e;
            if (messageInfo != null) {
                newBuilder.f398533e = MessageInfo.ADAPTER.redact(messageInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ShareMessageInfo(String str, String str2, String str3, DstUinType dstUinType, MessageInfo messageInfo) {
        this(str, str2, str3, dstUinType, messageInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareMessageInfo)) {
            return false;
        }
        ShareMessageInfo shareMessageInfo = (ShareMessageInfo) obj;
        if (unknownFields().equals(shareMessageInfo.unknownFields()) && Internal.equals(this.feedID, shareMessageInfo.feedID) && Internal.equals(this.shareUin, shareMessageInfo.shareUin) && Internal.equals(this.dstUin, shareMessageInfo.dstUin) && Internal.equals(this.dstUinType, shareMessageInfo.dstUinType) && Internal.equals(this.messageInfo, shareMessageInfo.messageInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.feedID;
            int i26 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            String str2 = this.shareUin;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            String str3 = this.dstUin;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            DstUinType dstUinType = this.dstUinType;
            if (dstUinType != null) {
                i18 = dstUinType.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            MessageInfo messageInfo = this.messageInfo;
            if (messageInfo != null) {
                i26 = messageInfo.hashCode();
            }
            int i37 = i36 + i26;
            this.hashCode = i37;
            return i37;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.feedID != null) {
            sb5.append(", feedID=");
            sb5.append(Internal.sanitize(this.feedID));
        }
        if (this.shareUin != null) {
            sb5.append(", shareUin=");
            sb5.append(Internal.sanitize(this.shareUin));
        }
        if (this.dstUin != null) {
            sb5.append(", dstUin=");
            sb5.append(Internal.sanitize(this.dstUin));
        }
        if (this.dstUinType != null) {
            sb5.append(", dstUinType=");
            sb5.append(this.dstUinType);
        }
        if (this.messageInfo != null) {
            sb5.append(", messageInfo=");
            sb5.append(this.messageInfo);
        }
        StringBuilder replace = sb5.replace(0, 2, "ShareMessageInfo{");
        replace.append('}');
        return replace.toString();
    }

    public ShareMessageInfo(String str, String str2, String str3, DstUinType dstUinType, MessageInfo messageInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.feedID = str;
            if (str2 != null) {
                this.shareUin = str2;
                if (str3 != null) {
                    this.dstUin = str3;
                    if (dstUinType != null) {
                        this.dstUinType = dstUinType;
                        this.messageInfo = messageInfo;
                        return;
                    }
                    throw new IllegalArgumentException("dstUinType == null");
                }
                throw new IllegalArgumentException("dstUin == null");
            }
            throw new IllegalArgumentException("shareUin == null");
        }
        throw new IllegalArgumentException("feedID == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f398529a = this.feedID;
        aVar.f398530b = this.shareUin;
        aVar.f398531c = this.dstUin;
        aVar.f398532d = this.dstUinType;
        aVar.f398533e = this.messageInfo;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
