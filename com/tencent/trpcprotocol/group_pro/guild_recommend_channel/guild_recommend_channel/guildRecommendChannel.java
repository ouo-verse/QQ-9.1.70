package com.tencent.trpcprotocol.group_pro.guild_recommend_channel.guild_recommend_channel;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.ar;
import com.google.protobuf.ax;
import com.google.protobuf.bg;
import com.google.protobuf.bu;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.r;
import com.google.protobuf.t;
import com.tencent.luggage.wxa.gg.e;
import com.tencent.trpcprotocol.group_pro.av_userlist_read_proxy.av_userlist_read_proxy.avUserlistReadProxy;
import com.tencent.trpcprotocol.group_pro.cmd0xfb1.cmd0xfb1.cmd0xfb1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class guildRecommendChannel {

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.b f381456a;

    /* renamed from: b, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381457b;

    /* renamed from: c, reason: collision with root package name */
    private static final Descriptors.b f381458c;

    /* renamed from: d, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381459d;

    /* renamed from: e, reason: collision with root package name */
    private static final Descriptors.b f381460e;

    /* renamed from: f, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381461f;

    /* renamed from: g, reason: collision with root package name */
    private static Descriptors.FileDescriptor f381462g = Descriptors.FileDescriptor.u(new String[]{"\n\u001dguild_recommend_channel.proto\u0012&trpc.group_pro.guild_recommend_channel\u001a\u000ecmd0xfb1.proto\u001a\u001cav_userlist_read_proxy.proto\"D\n\u000bLiveChannel\u00125\n\bpresence\u0018\u0001 \u0001(\u000b2#.trpc.group_pro.cmd0xfb1.ResultItem\"\u000e\n\fVoiceChannel\"\u000e\n\fWorldChannelB\u00ad\u0001\nRcom.tencent.trpcprotocol.group_pro.guild_recommend_channel.guild_recommend_channelB\u0015guildRecommendChannelP\u0000Z>git.code.oa.com/trpcprotocol/group_pro/guild_recommend_channelb\u0006proto3"}, new Descriptors.FileDescriptor[]{cmd0xfb1.q(), avUserlistReadProxy.c()});

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class LiveChannel extends GeneratedMessageV3 implements b {
        public static final int PRESENCE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final LiveChannel f381463d = new LiveChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<LiveChannel> f381464e = new a();
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private cmd0xfb1.ResultItem presence_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<LiveChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public LiveChannel g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new LiveChannel(kVar, tVar);
            }
        }

        public static LiveChannel getDefaultInstance() {
            return f381463d;
        }

        public static final Descriptors.b getDescriptor() {
            return guildRecommendChannel.f381456a;
        }

        public static b newBuilder() {
            return f381463d.toBuilder();
        }

        public static LiveChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LiveChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381464e, inputStream);
        }

        public static LiveChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381464e.d(byteBuffer);
        }

        public static bg<LiveChannel> parser() {
            return f381464e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LiveChannel)) {
                return super.equals(obj);
            }
            LiveChannel liveChannel = (LiveChannel) obj;
            if (hasPresence() != liveChannel.hasPresence()) {
                return false;
            }
            if ((!hasPresence() || getPresence().equals(liveChannel.getPresence())) && this.unknownFields.equals(liveChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<LiveChannel> getParserForType() {
            return f381464e;
        }

        public cmd0xfb1.ResultItem getPresence() {
            cmd0xfb1.ResultItem resultItem = this.presence_;
            if (resultItem == null) {
                return cmd0xfb1.ResultItem.getDefaultInstance();
            }
            return resultItem;
        }

        public cmd0xfb1.f getPresenceOrBuilder() {
            return getPresence();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (this.presence_ != null) {
                i16 = 0 + CodedOutputStream.G(1, getPresence());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasPresence() {
            if (this.presence_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasPresence()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPresence().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return guildRecommendChannel.f381457b.e(LiveChannel.class, b.class);
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
            return new LiveChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.presence_ != null) {
                codedOutputStream.K0(1, getPresence());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {

            /* renamed from: i, reason: collision with root package name */
            private cmd0xfb1.ResultItem f381465i;

            /* renamed from: m, reason: collision with root package name */
            private bu<cmd0xfb1.ResultItem, cmd0xfb1.ResultItem.b, cmd0xfb1.f> f381466m;

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
                return guildRecommendChannel.f381456a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return guildRecommendChannel.f381457b.e(LiveChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public LiveChannel build() {
                LiveChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public LiveChannel buildPartial() {
                LiveChannel liveChannel = new LiveChannel(this);
                bu<cmd0xfb1.ResultItem, cmd0xfb1.ResultItem.b, cmd0xfb1.f> buVar = this.f381466m;
                if (buVar == null) {
                    liveChannel.presence_ = this.f381465i;
                } else {
                    liveChannel.presence_ = buVar.b();
                }
                onBuilt();
                return liveChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.f381466m == null) {
                    this.f381465i = null;
                } else {
                    this.f381465i = null;
                    this.f381466m = null;
                }
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
            public LiveChannel getDefaultInstanceForType() {
                return LiveChannel.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                LiveChannel liveChannel = null;
                try {
                    try {
                        LiveChannel liveChannel2 = (LiveChannel) LiveChannel.f381464e.g(kVar, tVar);
                        if (liveChannel2 != null) {
                            x(liveChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        LiveChannel liveChannel3 = (LiveChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            liveChannel = liveChannel3;
                            if (liveChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (liveChannel != null) {
                        x(liveChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof LiveChannel) {
                    return x((LiveChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(LiveChannel liveChannel) {
                if (liveChannel == LiveChannel.getDefaultInstance()) {
                    return this;
                }
                if (liveChannel.hasPresence()) {
                    y(liveChannel.getPresence());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) liveChannel).unknownFields);
                onChanged();
                return this;
            }

            public b y(cmd0xfb1.ResultItem resultItem) {
                bu<cmd0xfb1.ResultItem, cmd0xfb1.ResultItem.b, cmd0xfb1.f> buVar = this.f381466m;
                if (buVar == null) {
                    cmd0xfb1.ResultItem resultItem2 = this.f381465i;
                    if (resultItem2 != null) {
                        this.f381465i = cmd0xfb1.ResultItem.newBuilder(resultItem2).y(resultItem).buildPartial();
                    } else {
                        this.f381465i = resultItem;
                    }
                    onChanged();
                } else {
                    buVar.g(resultItem);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            b() {
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(LiveChannel liveChannel) {
            return f381463d.toBuilder().x(liveChannel);
        }

        public static LiveChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381464e.m(byteBuffer, tVar);
        }

        LiveChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (LiveChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381464e, inputStream, tVar);
        }

        public static LiveChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381464e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public LiveChannel getDefaultInstanceForType() {
            return f381463d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381463d ? new b() : new b().x(this);
        }

        public static LiveChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381464e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        LiveChannel() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381464e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static LiveChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381464e.i(bArr, tVar);
        }

        LiveChannel(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                if (J != 10) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    cmd0xfb1.ResultItem resultItem = this.presence_;
                                    cmd0xfb1.ResultItem.b builder = resultItem != null ? resultItem.toBuilder() : null;
                                    cmd0xfb1.ResultItem resultItem2 = (cmd0xfb1.ResultItem) kVar.z(cmd0xfb1.ResultItem.parser(), tVar);
                                    this.presence_ = resultItem2;
                                    if (builder != null) {
                                        builder.y(resultItem2);
                                        this.presence_ = builder.buildPartial();
                                    }
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

        public static LiveChannel parseFrom(InputStream inputStream) throws IOException {
            return (LiveChannel) GeneratedMessageV3.parseWithIOException(f381464e, inputStream);
        }

        public static LiveChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (LiveChannel) GeneratedMessageV3.parseWithIOException(f381464e, inputStream, tVar);
        }

        public static LiveChannel parseFrom(k kVar) throws IOException {
            return (LiveChannel) GeneratedMessageV3.parseWithIOException(f381464e, kVar);
        }

        public static LiveChannel parseFrom(k kVar, t tVar) throws IOException {
            return (LiveChannel) GeneratedMessageV3.parseWithIOException(f381464e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class VoiceChannel extends GeneratedMessageV3 implements c {
        public static final int PRESENCE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final VoiceChannel f381467d = new VoiceChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<VoiceChannel> f381468e = new a();
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private avUserlistReadProxy.ChannelUseList presence_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<VoiceChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public VoiceChannel g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new VoiceChannel(kVar, tVar);
            }
        }

        public static VoiceChannel getDefaultInstance() {
            return f381467d;
        }

        public static final Descriptors.b getDescriptor() {
            return guildRecommendChannel.f381458c;
        }

        public static b newBuilder() {
            return f381467d.toBuilder();
        }

        public static VoiceChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (VoiceChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381468e, inputStream);
        }

        public static VoiceChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381468e.d(byteBuffer);
        }

        public static bg<VoiceChannel> parser() {
            return f381468e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VoiceChannel)) {
                return super.equals(obj);
            }
            VoiceChannel voiceChannel = (VoiceChannel) obj;
            if (hasPresence() != voiceChannel.hasPresence()) {
                return false;
            }
            if ((!hasPresence() || getPresence().equals(voiceChannel.getPresence())) && this.unknownFields.equals(voiceChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<VoiceChannel> getParserForType() {
            return f381468e;
        }

        public avUserlistReadProxy.ChannelUseList getPresence() {
            avUserlistReadProxy.ChannelUseList channelUseList = this.presence_;
            if (channelUseList == null) {
                return avUserlistReadProxy.ChannelUseList.getDefaultInstance();
            }
            return channelUseList;
        }

        public avUserlistReadProxy.b getPresenceOrBuilder() {
            return getPresence();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (this.presence_ != null) {
                i16 = 0 + CodedOutputStream.G(1, getPresence());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasPresence() {
            if (this.presence_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasPresence()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPresence().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return guildRecommendChannel.f381459d.e(VoiceChannel.class, b.class);
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
            return new VoiceChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.presence_ != null) {
                codedOutputStream.K0(1, getPresence());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: i, reason: collision with root package name */
            private avUserlistReadProxy.ChannelUseList f381469i;

            /* renamed from: m, reason: collision with root package name */
            private bu<avUserlistReadProxy.ChannelUseList, avUserlistReadProxy.ChannelUseList.b, avUserlistReadProxy.b> f381470m;

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
                return guildRecommendChannel.f381458c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return guildRecommendChannel.f381459d.e(VoiceChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public VoiceChannel build() {
                VoiceChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public VoiceChannel buildPartial() {
                VoiceChannel voiceChannel = new VoiceChannel(this);
                bu<avUserlistReadProxy.ChannelUseList, avUserlistReadProxy.ChannelUseList.b, avUserlistReadProxy.b> buVar = this.f381470m;
                if (buVar == null) {
                    voiceChannel.presence_ = this.f381469i;
                } else {
                    voiceChannel.presence_ = buVar.b();
                }
                onBuilt();
                return voiceChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.f381470m == null) {
                    this.f381469i = null;
                } else {
                    this.f381469i = null;
                    this.f381470m = null;
                }
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
            public VoiceChannel getDefaultInstanceForType() {
                return VoiceChannel.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                VoiceChannel voiceChannel = null;
                try {
                    try {
                        VoiceChannel voiceChannel2 = (VoiceChannel) VoiceChannel.f381468e.g(kVar, tVar);
                        if (voiceChannel2 != null) {
                            x(voiceChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        VoiceChannel voiceChannel3 = (VoiceChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            voiceChannel = voiceChannel3;
                            if (voiceChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (voiceChannel != null) {
                        x(voiceChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof VoiceChannel) {
                    return x((VoiceChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(VoiceChannel voiceChannel) {
                if (voiceChannel == VoiceChannel.getDefaultInstance()) {
                    return this;
                }
                if (voiceChannel.hasPresence()) {
                    y(voiceChannel.getPresence());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) voiceChannel).unknownFields);
                onChanged();
                return this;
            }

            public b y(avUserlistReadProxy.ChannelUseList channelUseList) {
                bu<avUserlistReadProxy.ChannelUseList, avUserlistReadProxy.ChannelUseList.b, avUserlistReadProxy.b> buVar = this.f381470m;
                if (buVar == null) {
                    avUserlistReadProxy.ChannelUseList channelUseList2 = this.f381469i;
                    if (channelUseList2 != null) {
                        this.f381469i = avUserlistReadProxy.ChannelUseList.newBuilder(channelUseList2).z(channelUseList).buildPartial();
                    } else {
                        this.f381469i = channelUseList;
                    }
                    onChanged();
                } else {
                    buVar.g(channelUseList);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            b() {
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(VoiceChannel voiceChannel) {
            return f381467d.toBuilder().x(voiceChannel);
        }

        public static VoiceChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381468e.m(byteBuffer, tVar);
        }

        VoiceChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static VoiceChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (VoiceChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381468e, inputStream, tVar);
        }

        public static VoiceChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381468e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public VoiceChannel getDefaultInstanceForType() {
            return f381467d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381467d ? new b() : new b().x(this);
        }

        public static VoiceChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381468e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        VoiceChannel() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static VoiceChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381468e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static VoiceChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381468e.i(bArr, tVar);
        }

        VoiceChannel(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                if (J != 10) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    avUserlistReadProxy.ChannelUseList channelUseList = this.presence_;
                                    avUserlistReadProxy.ChannelUseList.b builder = channelUseList != null ? channelUseList.toBuilder() : null;
                                    avUserlistReadProxy.ChannelUseList channelUseList2 = (avUserlistReadProxy.ChannelUseList) kVar.z(avUserlistReadProxy.ChannelUseList.parser(), tVar);
                                    this.presence_ = channelUseList2;
                                    if (builder != null) {
                                        builder.z(channelUseList2);
                                        this.presence_ = builder.buildPartial();
                                    }
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

        public static VoiceChannel parseFrom(InputStream inputStream) throws IOException {
            return (VoiceChannel) GeneratedMessageV3.parseWithIOException(f381468e, inputStream);
        }

        public static VoiceChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (VoiceChannel) GeneratedMessageV3.parseWithIOException(f381468e, inputStream, tVar);
        }

        public static VoiceChannel parseFrom(k kVar) throws IOException {
            return (VoiceChannel) GeneratedMessageV3.parseWithIOException(f381468e, kVar);
        }

        public static VoiceChannel parseFrom(k kVar, t tVar) throws IOException {
            return (VoiceChannel) GeneratedMessageV3.parseWithIOException(f381468e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class WorldChannel extends GeneratedMessageV3 implements d {
        public static final int PRESENCE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final WorldChannel f381471d = new WorldChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<WorldChannel> f381472e = new a();
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private avUserlistReadProxy.ChannelUseList presence_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<WorldChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public WorldChannel g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new WorldChannel(kVar, tVar);
            }
        }

        public static WorldChannel getDefaultInstance() {
            return f381471d;
        }

        public static final Descriptors.b getDescriptor() {
            return guildRecommendChannel.f381460e;
        }

        public static b newBuilder() {
            return f381471d.toBuilder();
        }

        public static WorldChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WorldChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381472e, inputStream);
        }

        public static WorldChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381472e.d(byteBuffer);
        }

        public static bg<WorldChannel> parser() {
            return f381472e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WorldChannel)) {
                return super.equals(obj);
            }
            WorldChannel worldChannel = (WorldChannel) obj;
            if (hasPresence() != worldChannel.hasPresence()) {
                return false;
            }
            if ((!hasPresence() || getPresence().equals(worldChannel.getPresence())) && this.unknownFields.equals(worldChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<WorldChannel> getParserForType() {
            return f381472e;
        }

        public avUserlistReadProxy.ChannelUseList getPresence() {
            avUserlistReadProxy.ChannelUseList channelUseList = this.presence_;
            if (channelUseList == null) {
                return avUserlistReadProxy.ChannelUseList.getDefaultInstance();
            }
            return channelUseList;
        }

        public avUserlistReadProxy.b getPresenceOrBuilder() {
            return getPresence();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (this.presence_ != null) {
                i16 = 0 + CodedOutputStream.G(1, getPresence());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasPresence() {
            if (this.presence_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasPresence()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPresence().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return guildRecommendChannel.f381461f.e(WorldChannel.class, b.class);
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
            return new WorldChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.presence_ != null) {
                codedOutputStream.K0(1, getPresence());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements d {

            /* renamed from: i, reason: collision with root package name */
            private avUserlistReadProxy.ChannelUseList f381473i;

            /* renamed from: m, reason: collision with root package name */
            private bu<avUserlistReadProxy.ChannelUseList, avUserlistReadProxy.ChannelUseList.b, avUserlistReadProxy.b> f381474m;

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
                return guildRecommendChannel.f381460e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return guildRecommendChannel.f381461f.e(WorldChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public WorldChannel build() {
                WorldChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public WorldChannel buildPartial() {
                WorldChannel worldChannel = new WorldChannel(this);
                bu<avUserlistReadProxy.ChannelUseList, avUserlistReadProxy.ChannelUseList.b, avUserlistReadProxy.b> buVar = this.f381474m;
                if (buVar == null) {
                    worldChannel.presence_ = this.f381473i;
                } else {
                    worldChannel.presence_ = buVar.b();
                }
                onBuilt();
                return worldChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.f381474m == null) {
                    this.f381473i = null;
                } else {
                    this.f381473i = null;
                    this.f381474m = null;
                }
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
            public WorldChannel getDefaultInstanceForType() {
                return WorldChannel.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                WorldChannel worldChannel = null;
                try {
                    try {
                        WorldChannel worldChannel2 = (WorldChannel) WorldChannel.f381472e.g(kVar, tVar);
                        if (worldChannel2 != null) {
                            x(worldChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        WorldChannel worldChannel3 = (WorldChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            worldChannel = worldChannel3;
                            if (worldChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (worldChannel != null) {
                        x(worldChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof WorldChannel) {
                    return x((WorldChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(WorldChannel worldChannel) {
                if (worldChannel == WorldChannel.getDefaultInstance()) {
                    return this;
                }
                if (worldChannel.hasPresence()) {
                    y(worldChannel.getPresence());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) worldChannel).unknownFields);
                onChanged();
                return this;
            }

            public b y(avUserlistReadProxy.ChannelUseList channelUseList) {
                bu<avUserlistReadProxy.ChannelUseList, avUserlistReadProxy.ChannelUseList.b, avUserlistReadProxy.b> buVar = this.f381474m;
                if (buVar == null) {
                    avUserlistReadProxy.ChannelUseList channelUseList2 = this.f381473i;
                    if (channelUseList2 != null) {
                        this.f381473i = avUserlistReadProxy.ChannelUseList.newBuilder(channelUseList2).z(channelUseList).buildPartial();
                    } else {
                        this.f381473i = channelUseList;
                    }
                    onChanged();
                } else {
                    buVar.g(channelUseList);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            b() {
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(WorldChannel worldChannel) {
            return f381471d.toBuilder().x(worldChannel);
        }

        public static WorldChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381472e.m(byteBuffer, tVar);
        }

        WorldChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static WorldChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (WorldChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381472e, inputStream, tVar);
        }

        public static WorldChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381472e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public WorldChannel getDefaultInstanceForType() {
            return f381471d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381471d ? new b() : new b().x(this);
        }

        public static WorldChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381472e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        WorldChannel() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static WorldChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381472e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static WorldChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381472e.i(bArr, tVar);
        }

        WorldChannel(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                if (J != 10) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    avUserlistReadProxy.ChannelUseList channelUseList = this.presence_;
                                    avUserlistReadProxy.ChannelUseList.b builder = channelUseList != null ? channelUseList.toBuilder() : null;
                                    avUserlistReadProxy.ChannelUseList channelUseList2 = (avUserlistReadProxy.ChannelUseList) kVar.z(avUserlistReadProxy.ChannelUseList.parser(), tVar);
                                    this.presence_ = channelUseList2;
                                    if (builder != null) {
                                        builder.z(channelUseList2);
                                        this.presence_ = builder.buildPartial();
                                    }
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

        public static WorldChannel parseFrom(InputStream inputStream) throws IOException {
            return (WorldChannel) GeneratedMessageV3.parseWithIOException(f381472e, inputStream);
        }

        public static WorldChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (WorldChannel) GeneratedMessageV3.parseWithIOException(f381472e, inputStream, tVar);
        }

        public static WorldChannel parseFrom(k kVar) throws IOException {
            return (WorldChannel) GeneratedMessageV3.parseWithIOException(f381472e, kVar);
        }

        public static WorldChannel parseFrom(k kVar, t tVar) throws IOException {
            return (WorldChannel) GeneratedMessageV3.parseWithIOException(f381472e, kVar, tVar);
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

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface d extends ax {
    }

    static {
        Descriptors.b bVar = g().p().get(0);
        f381456a = bVar;
        f381457b = new GeneratedMessageV3.e(bVar, new String[]{"Presence"});
        Descriptors.b bVar2 = g().p().get(1);
        f381458c = bVar2;
        f381459d = new GeneratedMessageV3.e(bVar2, new String[]{"Presence"});
        Descriptors.b bVar3 = g().p().get(2);
        f381460e = bVar3;
        f381461f = new GeneratedMessageV3.e(bVar3, new String[]{"Presence"});
        Descriptors.FileDescriptor.w(f381462g, r.g());
        cmd0xfb1.q();
        avUserlistReadProxy.c();
    }

    public static Descriptors.FileDescriptor g() {
        return f381462g;
    }
}
