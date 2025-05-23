package com.tencent.trpcprotocol.group_pro.common.client;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.ad;
import com.google.protobuf.ar;
import com.google.protobuf.ax;
import com.google.protobuf.bg;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.t;
import com.tencent.luggage.wxa.gg.e;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class client {

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.b f381440a;

    /* renamed from: b, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381441b;

    /* renamed from: c, reason: collision with root package name */
    private static final Descriptors.b f381442c;

    /* renamed from: d, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381443d;

    /* renamed from: e, reason: collision with root package name */
    private static Descriptors.FileDescriptor f381444e = Descriptors.FileDescriptor.u(new String[]{"\n\fclient.proto\u0012\u0015trpc.group_pro.common\"1\n\u000eClientIdentity\u0012\u0011\n\tclient_id\u0018\u0001 \u0001(\r\u0012\f\n\u0004desc\u0018\u0002 \u0001(\t\"\u00fe\u0001\n\u000eClientPresence\u0012\u0011\n\tclient_id\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bclient_name\u0018\u0002 \u0001(\t\u0012\u0010\n\bbig_icon\u0018\u0003 \u0001(\t\u0012\r\n\u0005state\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007details\u0018\u0005 \u0001(\t\u0012\u0012\n\nparty_size\u0018\u0006 \u0001(\u0003\u0012\u0011\n\tparty_max\u0018\u0007 \u0001(\u0003\u0012\f\n\u0004role\u0018\b \u0001(\t\u0012\u0017\n\u000fstart_timestamp\u0018\t \u0001(\u0003\u0012\u0015\n\rend_timestamp\u0018\n \u0001(\u0003\u0012\u0012\n\nsmall_icon\u0018\u000b \u0001(\t\u0012\u0019\n\u0010expire_timestamp\u0018\u0091N \u0001(\u0003Br\n0com.tencent.trpcprotocol.group_pro.common.clientB\u0006clientP\u0000Z4git.code.oa.com/trpcprotocol/group_pro/common_clientb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ClientIdentity extends GeneratedMessageV3 implements b {
        public static final int CLIENT_ID_FIELD_NUMBER = 1;
        public static final int DESC_FIELD_NUMBER = 2;

        /* renamed from: d, reason: collision with root package name */
        private static final ClientIdentity f381445d = new ClientIdentity();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ClientIdentity> f381446e = new a();
        private static final long serialVersionUID = 0;
        private int clientId_;
        private volatile Object desc_;
        private byte memoizedIsInitialized;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ClientIdentity> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ClientIdentity g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ClientIdentity(kVar, tVar);
            }
        }

        public static ClientIdentity getDefaultInstance() {
            return f381445d;
        }

        public static final Descriptors.b getDescriptor() {
            return client.f381440a;
        }

        public static b newBuilder() {
            return f381445d.toBuilder();
        }

        public static ClientIdentity parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ClientIdentity) GeneratedMessageV3.parseDelimitedWithIOException(f381446e, inputStream);
        }

        public static ClientIdentity parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381446e.d(byteBuffer);
        }

        public static bg<ClientIdentity> parser() {
            return f381446e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ClientIdentity)) {
                return super.equals(obj);
            }
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (getClientId() == clientIdentity.getClientId() && getDesc().equals(clientIdentity.getDesc()) && this.unknownFields.equals(clientIdentity.unknownFields)) {
                return true;
            }
            return false;
        }

        public int getClientId() {
            return this.clientId_;
        }

        public String getDesc() {
            Object obj = this.desc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.desc_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDescBytes() {
            Object obj = this.desc_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.desc_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ClientIdentity> getParserForType() {
            return f381446e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.clientId_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.Y(1, i16);
            }
            if (!getDescBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(2, this.desc_);
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = ((((((((((e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getClientId()) * 37) + 2) * 53) + getDesc().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return client.f381441b.e(ClientIdentity.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new ClientIdentity();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.clientId_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            if (!getDescBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.desc_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {

            /* renamed from: i, reason: collision with root package name */
            private int f381447i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381448m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return client.f381440a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return client.f381441b.e(ClientIdentity.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ClientIdentity build() {
                ClientIdentity buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ClientIdentity buildPartial() {
                ClientIdentity clientIdentity = new ClientIdentity(this);
                clientIdentity.clientId_ = this.f381447i;
                clientIdentity.desc_ = this.f381448m;
                onBuilt();
                return clientIdentity;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381447i = 0;
                this.f381448m = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public ClientIdentity getDefaultInstanceForType() {
                return ClientIdentity.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ClientIdentity clientIdentity = null;
                try {
                    try {
                        ClientIdentity clientIdentity2 = (ClientIdentity) ClientIdentity.f381446e.g(kVar, tVar);
                        if (clientIdentity2 != null) {
                            x(clientIdentity2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ClientIdentity clientIdentity3 = (ClientIdentity) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            clientIdentity = clientIdentity3;
                            if (clientIdentity != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (clientIdentity != null) {
                        x(clientIdentity);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ClientIdentity) {
                    return x((ClientIdentity) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ClientIdentity clientIdentity) {
                if (clientIdentity == ClientIdentity.getDefaultInstance()) {
                    return this;
                }
                if (clientIdentity.getClientId() != 0) {
                    z(clientIdentity.getClientId());
                }
                if (!clientIdentity.getDesc().isEmpty()) {
                    this.f381448m = clientIdentity.desc_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) clientIdentity).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(int i3) {
                this.f381447i = i3;
                onChanged();
                return this;
            }

            b() {
                this.f381448m = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381448m = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ClientIdentity clientIdentity) {
            return f381445d.toBuilder().x(clientIdentity);
        }

        public static ClientIdentity parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381446e.m(byteBuffer, tVar);
        }

        ClientIdentity(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ClientIdentity parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ClientIdentity) GeneratedMessageV3.parseDelimitedWithIOException(f381446e, inputStream, tVar);
        }

        public static ClientIdentity parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381446e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ClientIdentity getDefaultInstanceForType() {
            return f381445d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381445d ? new b() : new b().x(this);
        }

        public static ClientIdentity parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381446e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ClientIdentity() {
            this.memoizedIsInitialized = (byte) -1;
            this.desc_ = "";
        }

        public static ClientIdentity parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381446e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ClientIdentity parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381446e.i(bArr, tVar);
        }

        public static ClientIdentity parseFrom(InputStream inputStream) throws IOException {
            return (ClientIdentity) GeneratedMessageV3.parseWithIOException(f381446e, inputStream);
        }

        ClientIdentity(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 8) {
                                    this.clientId_ = kVar.K();
                                } else if (J != 18) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.desc_ = kVar.I();
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ClientIdentity parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ClientIdentity) GeneratedMessageV3.parseWithIOException(f381446e, inputStream, tVar);
        }

        public static ClientIdentity parseFrom(k kVar) throws IOException {
            return (ClientIdentity) GeneratedMessageV3.parseWithIOException(f381446e, kVar);
        }

        public static ClientIdentity parseFrom(k kVar, t tVar) throws IOException {
            return (ClientIdentity) GeneratedMessageV3.parseWithIOException(f381446e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ClientPresence extends GeneratedMessageV3 implements c {
        public static final int BIG_ICON_FIELD_NUMBER = 3;
        public static final int CLIENT_ID_FIELD_NUMBER = 1;
        public static final int CLIENT_NAME_FIELD_NUMBER = 2;
        public static final int DETAILS_FIELD_NUMBER = 5;
        public static final int END_TIMESTAMP_FIELD_NUMBER = 10;
        public static final int EXPIRE_TIMESTAMP_FIELD_NUMBER = 10001;
        public static final int PARTY_MAX_FIELD_NUMBER = 7;
        public static final int PARTY_SIZE_FIELD_NUMBER = 6;
        public static final int ROLE_FIELD_NUMBER = 8;
        public static final int SMALL_ICON_FIELD_NUMBER = 11;
        public static final int START_TIMESTAMP_FIELD_NUMBER = 9;
        public static final int STATE_FIELD_NUMBER = 4;

        /* renamed from: d, reason: collision with root package name */
        private static final ClientPresence f381449d = new ClientPresence();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ClientPresence> f381450e = new a();
        private static final long serialVersionUID = 0;
        private volatile Object bigIcon_;
        private int clientId_;
        private volatile Object clientName_;
        private volatile Object details_;
        private long endTimestamp_;
        private long expireTimestamp_;
        private byte memoizedIsInitialized;
        private long partyMax_;
        private long partySize_;
        private volatile Object role_;
        private volatile Object smallIcon_;
        private long startTimestamp_;
        private volatile Object state_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ClientPresence> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ClientPresence g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ClientPresence(kVar, tVar);
            }
        }

        public static ClientPresence getDefaultInstance() {
            return f381449d;
        }

        public static final Descriptors.b getDescriptor() {
            return client.f381442c;
        }

        public static b newBuilder() {
            return f381449d.toBuilder();
        }

        public static ClientPresence parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ClientPresence) GeneratedMessageV3.parseDelimitedWithIOException(f381450e, inputStream);
        }

        public static ClientPresence parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381450e.d(byteBuffer);
        }

        public static bg<ClientPresence> parser() {
            return f381450e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ClientPresence)) {
                return super.equals(obj);
            }
            ClientPresence clientPresence = (ClientPresence) obj;
            if (getClientId() == clientPresence.getClientId() && getClientName().equals(clientPresence.getClientName()) && getBigIcon().equals(clientPresence.getBigIcon()) && getState().equals(clientPresence.getState()) && getDetails().equals(clientPresence.getDetails()) && getPartySize() == clientPresence.getPartySize() && getPartyMax() == clientPresence.getPartyMax() && getRole().equals(clientPresence.getRole()) && getStartTimestamp() == clientPresence.getStartTimestamp() && getEndTimestamp() == clientPresence.getEndTimestamp() && getSmallIcon().equals(clientPresence.getSmallIcon()) && getExpireTimestamp() == clientPresence.getExpireTimestamp() && this.unknownFields.equals(clientPresence.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getBigIcon() {
            Object obj = this.bigIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bigIcon_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getBigIconBytes() {
            Object obj = this.bigIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bigIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getClientId() {
            return this.clientId_;
        }

        public String getClientName() {
            Object obj = this.clientName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.clientName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getClientNameBytes() {
            Object obj = this.clientName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.clientName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getDetails() {
            Object obj = this.details_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.details_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDetailsBytes() {
            Object obj = this.details_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.details_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        public long getExpireTimestamp() {
            return this.expireTimestamp_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ClientPresence> getParserForType() {
            return f381450e;
        }

        public long getPartyMax() {
            return this.partyMax_;
        }

        public long getPartySize() {
            return this.partySize_;
        }

        public String getRole() {
            Object obj = this.role_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.role_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getRoleBytes() {
            Object obj = this.role_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.role_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.clientId_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.Y(1, i16);
            }
            if (!getClientNameBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(2, this.clientName_);
            }
            if (!getBigIconBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(3, this.bigIcon_);
            }
            if (!getStateBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(4, this.state_);
            }
            if (!getDetailsBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(5, this.details_);
            }
            long j3 = this.partySize_;
            if (j3 != 0) {
                i17 += CodedOutputStream.z(6, j3);
            }
            long j16 = this.partyMax_;
            if (j16 != 0) {
                i17 += CodedOutputStream.z(7, j16);
            }
            if (!getRoleBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(8, this.role_);
            }
            long j17 = this.startTimestamp_;
            if (j17 != 0) {
                i17 += CodedOutputStream.z(9, j17);
            }
            long j18 = this.endTimestamp_;
            if (j18 != 0) {
                i17 += CodedOutputStream.z(10, j18);
            }
            if (!getSmallIconBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(11, this.smallIcon_);
            }
            long j19 = this.expireTimestamp_;
            if (j19 != 0) {
                i17 += CodedOutputStream.z(10001, j19);
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getSmallIcon() {
            Object obj = this.smallIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.smallIcon_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSmallIconBytes() {
            Object obj = this.smallIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.smallIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        public String getState() {
            Object obj = this.state_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.state_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getStateBytes() {
            Object obj = this.state_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.state_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getClientId()) * 37) + 2) * 53) + getClientName().hashCode()) * 37) + 3) * 53) + getBigIcon().hashCode()) * 37) + 4) * 53) + getState().hashCode()) * 37) + 5) * 53) + getDetails().hashCode()) * 37) + 6) * 53) + ad.h(getPartySize())) * 37) + 7) * 53) + ad.h(getPartyMax())) * 37) + 8) * 53) + getRole().hashCode()) * 37) + 9) * 53) + ad.h(getStartTimestamp())) * 37) + 10) * 53) + ad.h(getEndTimestamp())) * 37) + 11) * 53) + getSmallIcon().hashCode()) * 37) + 10001) * 53) + ad.h(getExpireTimestamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return client.f381443d.e(ClientPresence.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.av
        public final boolean isInitialized() {
            byte b16 = this.memoizedIsInitialized;
            if (b16 == 1) {
                return true;
            }
            if (b16 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.f fVar) {
            return new ClientPresence();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.clientId_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            if (!getClientNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.clientName_);
            }
            if (!getBigIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.bigIcon_);
            }
            if (!getStateBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.state_);
            }
            if (!getDetailsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.details_);
            }
            long j3 = this.partySize_;
            if (j3 != 0) {
                codedOutputStream.I0(6, j3);
            }
            long j16 = this.partyMax_;
            if (j16 != 0) {
                codedOutputStream.I0(7, j16);
            }
            if (!getRoleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.role_);
            }
            long j17 = this.startTimestamp_;
            if (j17 != 0) {
                codedOutputStream.I0(9, j17);
            }
            long j18 = this.endTimestamp_;
            if (j18 != 0) {
                codedOutputStream.I0(10, j18);
            }
            if (!getSmallIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.smallIcon_);
            }
            long j19 = this.expireTimestamp_;
            if (j19 != 0) {
                codedOutputStream.I0(10001, j19);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {
            private Object C;
            private Object D;
            private Object E;
            private long F;
            private long G;
            private Object H;
            private long I;
            private long J;
            private Object K;
            private long L;

            /* renamed from: i, reason: collision with root package name */
            private int f381451i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381452m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(long j3) {
                this.J = j3;
                onChanged();
                return this;
            }

            public b B(long j3) {
                this.L = j3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b D(long j3) {
                this.G = j3;
                onChanged();
                return this;
            }

            public b E(long j3) {
                this.F = j3;
                onChanged();
                return this;
            }

            public b F(long j3) {
                this.I = j3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return client.f381442c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return client.f381443d.e(ClientPresence.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ClientPresence build() {
                ClientPresence buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ClientPresence buildPartial() {
                ClientPresence clientPresence = new ClientPresence(this);
                clientPresence.clientId_ = this.f381451i;
                clientPresence.clientName_ = this.f381452m;
                clientPresence.bigIcon_ = this.C;
                clientPresence.state_ = this.D;
                clientPresence.details_ = this.E;
                clientPresence.partySize_ = this.F;
                clientPresence.partyMax_ = this.G;
                clientPresence.role_ = this.H;
                clientPresence.startTimestamp_ = this.I;
                clientPresence.endTimestamp_ = this.J;
                clientPresence.smallIcon_ = this.K;
                clientPresence.expireTimestamp_ = this.L;
                onBuilt();
                return clientPresence;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381451i = 0;
                this.f381452m = "";
                this.C = "";
                this.D = "";
                this.E = "";
                this.F = 0L;
                this.G = 0L;
                this.H = "";
                this.I = 0L;
                this.J = 0L;
                this.K = "";
                this.L = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public b clearOneof(Descriptors.g gVar) {
                return (b) super.clearOneof(gVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mo50clone() {
                return (b) super.mo50clone();
            }

            @Override // com.google.protobuf.av, com.google.protobuf.ax
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public ClientPresence getDefaultInstanceForType() {
                return ClientPresence.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ClientPresence clientPresence = null;
                try {
                    try {
                        ClientPresence clientPresence2 = (ClientPresence) ClientPresence.f381450e.g(kVar, tVar);
                        if (clientPresence2 != null) {
                            x(clientPresence2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ClientPresence clientPresence3 = (ClientPresence) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            clientPresence = clientPresence3;
                            if (clientPresence != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (clientPresence != null) {
                        x(clientPresence);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ClientPresence) {
                    return x((ClientPresence) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ClientPresence clientPresence) {
                if (clientPresence == ClientPresence.getDefaultInstance()) {
                    return this;
                }
                if (clientPresence.getClientId() != 0) {
                    z(clientPresence.getClientId());
                }
                if (!clientPresence.getClientName().isEmpty()) {
                    this.f381452m = clientPresence.clientName_;
                    onChanged();
                }
                if (!clientPresence.getBigIcon().isEmpty()) {
                    this.C = clientPresence.bigIcon_;
                    onChanged();
                }
                if (!clientPresence.getState().isEmpty()) {
                    this.D = clientPresence.state_;
                    onChanged();
                }
                if (!clientPresence.getDetails().isEmpty()) {
                    this.E = clientPresence.details_;
                    onChanged();
                }
                if (clientPresence.getPartySize() != 0) {
                    E(clientPresence.getPartySize());
                }
                if (clientPresence.getPartyMax() != 0) {
                    D(clientPresence.getPartyMax());
                }
                if (!clientPresence.getRole().isEmpty()) {
                    this.H = clientPresence.role_;
                    onChanged();
                }
                if (clientPresence.getStartTimestamp() != 0) {
                    F(clientPresence.getStartTimestamp());
                }
                if (clientPresence.getEndTimestamp() != 0) {
                    A(clientPresence.getEndTimestamp());
                }
                if (!clientPresence.getSmallIcon().isEmpty()) {
                    this.K = clientPresence.smallIcon_;
                    onChanged();
                }
                if (clientPresence.getExpireTimestamp() != 0) {
                    B(clientPresence.getExpireTimestamp());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) clientPresence).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(int i3) {
                this.f381451i = i3;
                onChanged();
                return this;
            }

            b() {
                this.f381452m = "";
                this.C = "";
                this.D = "";
                this.E = "";
                this.H = "";
                this.K = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381452m = "";
                this.C = "";
                this.D = "";
                this.E = "";
                this.H = "";
                this.K = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ClientPresence clientPresence) {
            return f381449d.toBuilder().x(clientPresence);
        }

        public static ClientPresence parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381450e.m(byteBuffer, tVar);
        }

        ClientPresence(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ClientPresence parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ClientPresence) GeneratedMessageV3.parseDelimitedWithIOException(f381450e, inputStream, tVar);
        }

        public static ClientPresence parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381450e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ClientPresence getDefaultInstanceForType() {
            return f381449d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381449d ? new b() : new b().x(this);
        }

        public static ClientPresence parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381450e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ClientPresence() {
            this.memoizedIsInitialized = (byte) -1;
            this.clientName_ = "";
            this.bigIcon_ = "";
            this.state_ = "";
            this.details_ = "";
            this.role_ = "";
            this.smallIcon_ = "";
        }

        public static ClientPresence parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381450e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ClientPresence parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381450e.i(bArr, tVar);
        }

        public static ClientPresence parseFrom(InputStream inputStream) throws IOException {
            return (ClientPresence) GeneratedMessageV3.parseWithIOException(f381450e, inputStream);
        }

        public static ClientPresence parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ClientPresence) GeneratedMessageV3.parseWithIOException(f381450e, inputStream, tVar);
        }

        public static ClientPresence parseFrom(k kVar) throws IOException {
            return (ClientPresence) GeneratedMessageV3.parseWithIOException(f381450e, kVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
        ClientPresence(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            switch (J) {
                                case 0:
                                    z16 = true;
                                case 8:
                                    this.clientId_ = kVar.K();
                                case 18:
                                    this.clientName_ = kVar.I();
                                case 26:
                                    this.bigIcon_ = kVar.I();
                                case 34:
                                    this.state_ = kVar.I();
                                case 42:
                                    this.details_ = kVar.I();
                                case 48:
                                    this.partySize_ = kVar.y();
                                case 56:
                                    this.partyMax_ = kVar.y();
                                case 66:
                                    this.role_ = kVar.I();
                                case 72:
                                    this.startTimestamp_ = kVar.y();
                                case 80:
                                    this.endTimestamp_ = kVar.y();
                                case 90:
                                    this.smallIcon_ = kVar.I();
                                case 80008:
                                    this.expireTimestamp_ = kVar.y();
                                default:
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                        z16 = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e16) {
                            throw e16.setUnfinishedMessage(this);
                        }
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ClientPresence parseFrom(k kVar, t tVar) throws IOException {
            return (ClientPresence) GeneratedMessageV3.parseWithIOException(f381450e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface b extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface c extends ax {
    }

    static {
        Descriptors.b bVar = e().p().get(0);
        f381440a = bVar;
        f381441b = new GeneratedMessageV3.e(bVar, new String[]{"ClientId", "Desc"});
        Descriptors.b bVar2 = e().p().get(1);
        f381442c = bVar2;
        f381443d = new GeneratedMessageV3.e(bVar2, new String[]{"ClientId", "ClientName", "BigIcon", "State", "Details", "PartySize", "PartyMax", "Role", "StartTimestamp", "EndTimestamp", "SmallIcon", "ExpireTimestamp"});
    }

    public static Descriptors.FileDescriptor e() {
        return f381444e;
    }
}
