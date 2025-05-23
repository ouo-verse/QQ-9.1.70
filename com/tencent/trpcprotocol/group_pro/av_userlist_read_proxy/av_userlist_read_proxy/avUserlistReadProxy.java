package com.tencent.trpcprotocol.group_pro.av_userlist_read_proxy.av_userlist_read_proxy;

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
import com.google.protobuf.bp;
import com.google.protobuf.c;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.r;
import com.google.protobuf.t;
import com.tencent.luggage.wxa.gg.e;
import com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.MemberInfo;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes27.dex */
public final class avUserlistReadProxy {

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.b f381375a;

    /* renamed from: b, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381376b;

    /* renamed from: c, reason: collision with root package name */
    private static Descriptors.FileDescriptor f381377c = Descriptors.FileDescriptor.u(new String[]{"\n\u001cav_userlist_read_proxy.proto\u0012%trpc.group_pro.av_userlist_read_proxy\"\u008e\u0001\n\u000eChannelUseList\u0012\u0019\n\u0011uint64_channel_id\u0018\u0001 \u0001(\u0004\u0012\u001e\n\u0016uint32_channel_max_num\u0018\u0003 \u0001(\r\u0012\"\n\u001auint32_channel_current_num\u0018\u0004 \u0001(\r\u0012\u001d\n\u0015uint32_channel_status\u0018\u0005 \u0001(\rB\u00a8\u0001\nPcom.tencent.trpcprotocol.group_pro.av_userlist_read_proxy.av_userlist_read_proxyB\u0013avUserlistReadProxyP\u0000Z=git.code.oa.com/trpcprotocol/group_pro/av_userlist_read_proxyb\u0006proto3"}, new Descriptors.FileDescriptor[]{com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.a()});

    /* loaded from: classes27.dex */
    public static final class ChannelUseList extends GeneratedMessageV3 implements b {
        public static final int RPT_MEMBER_LIST_FIELD_NUMBER = 2;
        public static final int UINT32_CHANNEL_CURRENT_NUM_FIELD_NUMBER = 4;
        public static final int UINT32_CHANNEL_MAX_NUM_FIELD_NUMBER = 3;
        public static final int UINT32_CHANNEL_STATUS_FIELD_NUMBER = 5;
        public static final int UINT64_CHANNEL_ID_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final ChannelUseList f381378d = new ChannelUseList();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ChannelUseList> f381379e = new a();
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<MemberInfo> rptMemberList_;
        private int uint32ChannelCurrentNum_;
        private int uint32ChannelMaxNum_;
        private int uint32ChannelStatus_;
        private long uint64ChannelId_;

        /* loaded from: classes27.dex */
        class a extends c<ChannelUseList> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ChannelUseList g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ChannelUseList(kVar, tVar);
            }
        }

        public static ChannelUseList getDefaultInstance() {
            return f381378d;
        }

        public static final Descriptors.b getDescriptor() {
            return avUserlistReadProxy.f381375a;
        }

        public static b newBuilder() {
            return f381378d.toBuilder();
        }

        public static ChannelUseList parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChannelUseList) GeneratedMessageV3.parseDelimitedWithIOException(f381379e, inputStream);
        }

        public static ChannelUseList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381379e.d(byteBuffer);
        }

        public static bg<ChannelUseList> parser() {
            return f381379e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChannelUseList)) {
                return super.equals(obj);
            }
            ChannelUseList channelUseList = (ChannelUseList) obj;
            if (getUint64ChannelId() == channelUseList.getUint64ChannelId() && getRptMemberListList().equals(channelUseList.getRptMemberListList()) && getUint32ChannelMaxNum() == channelUseList.getUint32ChannelMaxNum() && getUint32ChannelCurrentNum() == channelUseList.getUint32ChannelCurrentNum() && getUint32ChannelStatus() == channelUseList.getUint32ChannelStatus() && this.unknownFields.equals(channelUseList.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ChannelUseList> getParserForType() {
            return f381379e;
        }

        public MemberInfo getRptMemberList(int i3) {
            return this.rptMemberList_.get(i3);
        }

        public int getRptMemberListCount() {
            return this.rptMemberList_.size();
        }

        public List<MemberInfo> getRptMemberListList() {
            return this.rptMemberList_;
        }

        public com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.c getRptMemberListOrBuilder(int i3) {
            return this.rptMemberList_.get(i3);
        }

        public List<? extends com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.c> getRptMemberListOrBuilderList() {
            return this.rptMemberList_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            long j3 = this.uint64ChannelId_;
            if (j3 != 0) {
                i3 = CodedOutputStream.a0(1, j3) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.rptMemberList_.size(); i17++) {
                i3 += CodedOutputStream.G(2, this.rptMemberList_.get(i17));
            }
            int i18 = this.uint32ChannelMaxNum_;
            if (i18 != 0) {
                i3 += CodedOutputStream.Y(3, i18);
            }
            int i19 = this.uint32ChannelCurrentNum_;
            if (i19 != 0) {
                i3 += CodedOutputStream.Y(4, i19);
            }
            int i26 = this.uint32ChannelStatus_;
            if (i26 != 0) {
                i3 += CodedOutputStream.Y(5, i26);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public int getUint32ChannelCurrentNum() {
            return this.uint32ChannelCurrentNum_;
        }

        public int getUint32ChannelMaxNum() {
            return this.uint32ChannelMaxNum_;
        }

        public int getUint32ChannelStatus() {
            return this.uint32ChannelStatus_;
        }

        public long getUint64ChannelId() {
            return this.uint64ChannelId_;
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
            int hashCode = ((((e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getUint64ChannelId());
            if (getRptMemberListCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getRptMemberListList().hashCode();
            }
            int uint32ChannelMaxNum = (((((((((((((hashCode * 37) + 3) * 53) + getUint32ChannelMaxNum()) * 37) + 4) * 53) + getUint32ChannelCurrentNum()) * 37) + 5) * 53) + getUint32ChannelStatus()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = uint32ChannelMaxNum;
            return uint32ChannelMaxNum;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return avUserlistReadProxy.f381376b.e(ChannelUseList.class, b.class);
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
            return new ChannelUseList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j3 = this.uint64ChannelId_;
            if (j3 != 0) {
                codedOutputStream.d1(1, j3);
            }
            for (int i3 = 0; i3 < this.rptMemberList_.size(); i3++) {
                codedOutputStream.K0(2, this.rptMemberList_.get(i3));
            }
            int i16 = this.uint32ChannelMaxNum_;
            if (i16 != 0) {
                codedOutputStream.b1(3, i16);
            }
            int i17 = this.uint32ChannelCurrentNum_;
            if (i17 != 0) {
                codedOutputStream.b1(4, i17);
            }
            int i18 = this.uint32ChannelStatus_;
            if (i18 != 0) {
                codedOutputStream.b1(5, i18);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {
            private List<MemberInfo> C;
            private bp<MemberInfo, MemberInfo.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.c> D;
            private int E;
            private int F;
            private int G;

            /* renamed from: i, reason: collision with root package name */
            private int f381380i;

            /* renamed from: m, reason: collision with root package name */
            private long f381381m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private void u() {
                if ((this.f381380i & 1) == 0) {
                    this.C = new ArrayList(this.C);
                    this.f381380i |= 1;
                }
            }

            private bp<MemberInfo, MemberInfo.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.c> w() {
                if (this.D == null) {
                    List<MemberInfo> list = this.C;
                    boolean z16 = true;
                    if ((this.f381380i & 1) == 0) {
                        z16 = false;
                    }
                    this.D = new bp<>(list, z16, h(), isClean());
                    this.C = null;
                }
                return this.D;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b C(int i3) {
                this.F = i3;
                onChanged();
                return this;
            }

            public b D(int i3) {
                this.E = i3;
                onChanged();
                return this;
            }

            public b E(int i3) {
                this.G = i3;
                onChanged();
                return this;
            }

            public b F(long j3) {
                this.f381381m = j3;
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
                return avUserlistReadProxy.f381375a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return avUserlistReadProxy.f381376b.e(ChannelUseList.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ChannelUseList build() {
                ChannelUseList buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ChannelUseList buildPartial() {
                ChannelUseList channelUseList = new ChannelUseList(this);
                channelUseList.uint64ChannelId_ = this.f381381m;
                bp<MemberInfo, MemberInfo.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.c> bpVar = this.D;
                if (bpVar != null) {
                    channelUseList.rptMemberList_ = bpVar.d();
                } else {
                    if ((this.f381380i & 1) != 0) {
                        this.C = Collections.unmodifiableList(this.C);
                        this.f381380i &= -2;
                    }
                    channelUseList.rptMemberList_ = this.C;
                }
                channelUseList.uint32ChannelMaxNum_ = this.E;
                channelUseList.uint32ChannelCurrentNum_ = this.F;
                channelUseList.uint32ChannelStatus_ = this.G;
                onBuilt();
                return channelUseList;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381381m = 0L;
                bp<MemberInfo, MemberInfo.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.c> bpVar = this.D;
                if (bpVar == null) {
                    this.C = Collections.emptyList();
                    this.f381380i &= -2;
                } else {
                    bpVar.e();
                }
                this.E = 0;
                this.F = 0;
                this.G = 0;
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
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public ChannelUseList getDefaultInstanceForType() {
                return ChannelUseList.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ChannelUseList channelUseList = null;
                try {
                    try {
                        ChannelUseList channelUseList2 = (ChannelUseList) ChannelUseList.f381379e.g(kVar, tVar);
                        if (channelUseList2 != null) {
                            z(channelUseList2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ChannelUseList channelUseList3 = (ChannelUseList) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            channelUseList = channelUseList3;
                            if (channelUseList != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (channelUseList != null) {
                        z(channelUseList);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ChannelUseList) {
                    return z((ChannelUseList) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b z(ChannelUseList channelUseList) {
                if (channelUseList == ChannelUseList.getDefaultInstance()) {
                    return this;
                }
                if (channelUseList.getUint64ChannelId() != 0) {
                    F(channelUseList.getUint64ChannelId());
                }
                if (this.D == null) {
                    if (!channelUseList.rptMemberList_.isEmpty()) {
                        if (this.C.isEmpty()) {
                            this.C = channelUseList.rptMemberList_;
                            this.f381380i &= -2;
                        } else {
                            u();
                            this.C.addAll(channelUseList.rptMemberList_);
                        }
                        onChanged();
                    }
                } else if (!channelUseList.rptMemberList_.isEmpty()) {
                    if (this.D.j()) {
                        this.D.f();
                        bp<MemberInfo, MemberInfo.b, com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.c> bpVar = null;
                        this.D = null;
                        this.C = channelUseList.rptMemberList_;
                        this.f381380i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.D = bpVar;
                    } else {
                        this.D.b(channelUseList.rptMemberList_);
                    }
                }
                if (channelUseList.getUint32ChannelMaxNum() != 0) {
                    D(channelUseList.getUint32ChannelMaxNum());
                }
                if (channelUseList.getUint32ChannelCurrentNum() != 0) {
                    C(channelUseList.getUint32ChannelCurrentNum());
                }
                if (channelUseList.getUint32ChannelStatus() != 0) {
                    E(channelUseList.getUint32ChannelStatus());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) channelUseList).unknownFields);
                onChanged();
                return this;
            }

            b() {
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ChannelUseList channelUseList) {
            return f381378d.toBuilder().z(channelUseList);
        }

        public static ChannelUseList parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381379e.m(byteBuffer, tVar);
        }

        ChannelUseList(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ChannelUseList parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ChannelUseList) GeneratedMessageV3.parseDelimitedWithIOException(f381379e, inputStream, tVar);
        }

        public static ChannelUseList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381379e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ChannelUseList getDefaultInstanceForType() {
            return f381378d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381378d ? new b() : new b().z(this);
        }

        public static ChannelUseList parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381379e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ChannelUseList() {
            this.memoizedIsInitialized = (byte) -1;
            this.rptMemberList_ = Collections.emptyList();
        }

        public static ChannelUseList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381379e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ChannelUseList parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381379e.i(bArr, tVar);
        }

        public static ChannelUseList parseFrom(InputStream inputStream) throws IOException {
            return (ChannelUseList) GeneratedMessageV3.parseWithIOException(f381379e, inputStream);
        }

        ChannelUseList(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 8) {
                                this.uint64ChannelId_ = kVar.L();
                            } else if (J == 18) {
                                if (!(z17 & true)) {
                                    this.rptMemberList_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.rptMemberList_.add((MemberInfo) kVar.z(MemberInfo.parser(), tVar));
                            } else if (J == 24) {
                                this.uint32ChannelMaxNum_ = kVar.K();
                            } else if (J == 32) {
                                this.uint32ChannelCurrentNum_ = kVar.K();
                            } else if (J != 40) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.uint32ChannelStatus_ = kVar.K();
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z17 & true) {
                        this.rptMemberList_ = Collections.unmodifiableList(this.rptMemberList_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ChannelUseList parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ChannelUseList) GeneratedMessageV3.parseWithIOException(f381379e, inputStream, tVar);
        }

        public static ChannelUseList parseFrom(k kVar) throws IOException {
            return (ChannelUseList) GeneratedMessageV3.parseWithIOException(f381379e, kVar);
        }

        public static ChannelUseList parseFrom(k kVar, t tVar) throws IOException {
            return (ChannelUseList) GeneratedMessageV3.parseWithIOException(f381379e, kVar, tVar);
        }
    }

    /* loaded from: classes27.dex */
    public interface b extends ax {
    }

    static {
        Descriptors.b bVar = c().p().get(0);
        f381375a = bVar;
        f381376b = new GeneratedMessageV3.e(bVar, new String[]{"Uint64ChannelId", "RptMemberList", "Uint32ChannelMaxNum", "Uint32ChannelCurrentNum", "Uint32ChannelStatus"});
        Descriptors.FileDescriptor.w(f381377c, r.g());
        com.tencent.trpcprotocol.groupPro.cmd0xf5b.cmd0xf5b.a.a();
    }

    public static Descriptors.FileDescriptor c() {
        return f381377c;
    }
}
