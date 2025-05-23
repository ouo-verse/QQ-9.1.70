package com.tencent.trpcprotocol.group_pro.cmd0xfb1.cmd0xfb1;

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
import com.google.protobuf.bk;
import com.google.protobuf.bp;
import com.google.protobuf.bu;
import com.google.protobuf.cc;
import com.google.protobuf.k;
import com.google.protobuf.t;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class cmd0xfb1 {
    private static final Descriptors.b A;
    private static final GeneratedMessageV3.e B;
    private static final Descriptors.b C;
    private static final GeneratedMessageV3.e D;
    private static final Descriptors.b E;
    private static final GeneratedMessageV3.e F;
    private static final Descriptors.b G;
    private static final GeneratedMessageV3.e H;
    private static final Descriptors.b I;
    private static final GeneratedMessageV3.e J;
    private static final Descriptors.b K;
    private static final GeneratedMessageV3.e L;
    private static final Descriptors.b M;
    private static final GeneratedMessageV3.e N;
    private static Descriptors.FileDescriptor O = Descriptors.FileDescriptor.u(new String[]{"\n\u000ecmd0xfb1.proto\u0012\u0017trpc.group_pro.cmd0xfb1\"\u00db\u0003\n\nResultItem\u0012\u0013\n\u000bresult_code\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012\u0010\n\bquery_id\u0018\u0003 \u0001(\u0004\u0012F\n\rquery_id_type\u0018\u0004 \u0001(\u000e2/.trpc.group_pro.cmd0xfb1.ResultItem.QueryIdType\u00128\n\u000banchor_info\u0018\u0005 \u0001(\u000b2#.trpc.group_pro.cmd0xfb1.AnchorInfo\u00124\n\troom_info\u0018\u0006 \u0001(\u000b2!.trpc.group_pro.cmd0xfb1.RoomInfo\u00128\n\u000bstream_info\u0018\u0007 \u0001(\u000b2#.trpc.group_pro.cmd0xfb1.StreamInfo\u0012\u0011\n\tlive_type\u0018\b \u0001(\r\u0012\u0010\n\bplatform\u0018\t \u0001(\r\u0012:\n\fprogram_info\u0018\n \u0001(\u000b2$.trpc.group_pro.cmd0xfb1.ProgramInfo\"B\n\u000bQueryIdType\u0012\u0016\n\u0012UNKNOWN_QUERY_TYPE\u0010\u0000\u0012\u000b\n\u0007ROOM_ID\u0010\u0001\u0012\u000e\n\nCHANNEL_ID\u0010\u0002\"\u007f\n\nAnchorInfo\u0012\u0013\n\u000banchor_name\u0018\u0001 \u0001(\f\u0012\u0013\n\u000banchor_icon\u0018\u0002 \u0001(\f\u0012\u0014\n\fid_verify_ts\u0018\u0003 \u0001(\r\u0012\u0016\n\u000euint64_tiny_id\u0018\u0004 \u0001(\u0004\u0012\u0019\n\u0011bytes_avatar_meta\u0018\u0005 \u0001(\f\"\u00d3\u0002\n\bRoomInfo\u0012\u000f\n\u0007room_id\u0018\u0001 \u0001(\u0004\u0012\u0012\n\nroom_title\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006viewer\u0018\u0003 \u0001(\u0004\u0012\u0012\n\nroom_state\u0018\u0004 \u0001(\r\u00126\n\nviewer_ext\u0018\u0005 \u0001(\u000b2\".trpc.group_pro.cmd0xfb1.ViewerExt\u0012\u0012\n\nprogram_id\u0018\u0006 \u0001(\t\u00129\n\nlive_icons\u0018\u0007 \u0003(\u000b2%.trpc.group_pro.cmd0xfb1.LiveIconInfo\u0012\u0012\n\nextra_info\u0018\n \u0001(\f\u0012\u000f\n\u0007room_pv\u0018\u000b \u0001(\t\u0012=\n\u000eaudience_infos\u0018\f \u0003(\u000b2%.trpc.group_pro.cmd0xfb1.AudienceInfo\u0012\u0013\n\u000bscreen_shot\u0018\r \u0001(\t\"D\n\fAudienceInfo\u0012\u000b\n\u0003uin\u0018\u0001 \u0001(\u0004\u0012\f\n\u0004icon\u0018\u0002 \u0001(\t\u0012\u0019\n\u0011bytes_avatar_meta\u0018\u0003 \u0001(\f\"=\n\nStreamInfo\u0012\u000b\n\u0003url\u0018\u0001 \u0001(\t\u0012\u0011\n\tanchor_id\u0018\u0002 \u0001(\u0004\u0012\u000f\n\u0007flv_url\u0018\u0003 \u0001(\t\"7\n\u0007Address\u0012\u000b\n\u0003url\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007bitrate\u0018\u0002 \u0001(\u0005\u0012\u000e\n\u0006format\u0018\u0003 \u0001(\t\"s\n\u0005Frame\u0012\r\n\u0005level\u0018\u0001 \u0001(\u0005\u00123\n\taddresses\u0018\u0002 \u0003(\u000b2 .trpc.group_pro.cmd0xfb1.Address\u0012\u0012\n\ndefinition\u0018\u0003 \u0001(\t\u0012\u0012\n\ncodec_type\u0018\u0004 \u0001(\u0005\"\u00a1\u0001\n\u0006Stream\u0012.\n\u0006frames\u0018\u0001 \u0003(\u000b2\u001e.trpc.group_pro.cmd0xfb1.Frame\u0012\f\n\u0004name\u0018\u0002 \u0001(\t\u0012\u0011\n\traw_level\u0018\u0003 \u0001(\u0005\u00123\n\u000bdelay_frame\u0018\u0004 \u0003(\u000b2\u001e.trpc.group_pro.cmd0xfb1.Frame\u0012\u0011\n\tstream_id\u0018\u0005 \u0001(\t\"\u0085\u0001\n\u000fCacheStreamInfo\u0012\u000b\n\u0003url\u0018\u0001 \u0001(\t\u0012\u0011\n\tanchor_id\u0018\u0002 \u0001(\u0004\u0012\u000f\n\u0007flv_url\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007room_id\u0018\u0004 \u0001(\u0004\u00120\n\u0007streams\u0018\u0005 \u0003(\u000b2\u001f.trpc.group_pro.cmd0xfb1.Stream\"+\n\fLiveIconInfo\u0012\r\n\u0005ratio\u0018\u0001 \u0001(\t\u0012\f\n\u0004icon\u0018\u0002 \u0001(\t\"h\n\u000bProgramInfo\u0012\u0012\n\nprogram_id\u0018\u0001 \u0001(\t\u0012\u0012\n\nlive_title\u0018\u0002 \u0001(\t\u0012\u0013\n\u000banchor_name\u0018\u0003 \u0001(\t\u0012\f\n\u0004logo\u0018\u0004 \u0001(\t\u0012\u000e\n\u0006tab_id\u0018\u0005 \u0001(\u0004\"B\n\tViewerExt\u0012\u0010\n\bfake_num\u0018\u0001 \u0001(\r\u0012\u0010\n\breal_num\u0018\u0002 \u0001(\r\u0012\u0011\n\trobot_num\u0018\u0003 \u0001(\r\"f\n\u001aUpdateLiveRoomViewerNumReq\u0012H\n\u0014rpt_live_room_viewer\u0018\u0001 \u0003(\u000b2*.trpc.group_pro.cmd0xfb1.LiveRoomViewerNum\"8\n\u0011LiveRoomViewerNum\u0012\u000f\n\u0007room_id\u0018\u0001 \u0001(\u0004\u0012\u0012\n\nviewer_num\u0018\u0002 \u0001(\r\"\u001c\n\u001aUpdateLiveRoomViewerNumRsp\"O\n\u0007RoomReq\u00123\n\u0006filter\u0018\u0001 \u0001(\u000b2#.trpc.group_pro.cmd0xfb1.RoomFilter\u0012\u000f\n\u0007room_id\u0018\u0002 \u0001(\u0004\"\u001d\n\u0007RoomRsp\u0012\u0012\n\nroom_title\u0018\u0001 \u0001(\t\"(\n\nRoomFilter\u0012\u001a\n\u0012is_need_room_title\u0018\u0001 \u0001(\r\"q\n\u0012LiveRoomInfoFilter\u0012\u0018\n\u0010need_stream_info\u0018\u0001 \u0001(\b\u0012A\n\u0010room_info_filter\u0018\u0002 \u0001(\u000b2'.trpc.group_pro.cmd0xfb1.RoomInfoFilter\"\u008f\u0001\n\u000eRoomInfoFilter\u0012\u0014\n\fneed_room_pv\u0018\u0002 \u0001(\b\u0012\u001b\n\u0013need_audience_infos\u0018\u0003 \u0001(\b\u0012\u0018\n\u0010need_screen_shot\u0018\u0004 \u0001(\b\u0012\u0017\n\u000fneed_room_title\u0018\u0005 \u0001(\b\u0012\u0017\n\u000fneed_live_icons\u0018\u0006 \u0001(\b*@\n\u0005Level\u0012\u0007\n\u0003RAW\u0010\u0000\u0012\u0006\n\u0002SD\u0010\u0001\u0012\u0006\n\u0002HD\u0010\u0002\u0012\u0007\n\u0003FHD\u0010\u0003\u0012\t\n\u0005BLU4M\u0010\u0004\u0012\n\n\u0006BLU10M\u0010\u0005Bs\n4com.tencent.trpcprotocol.group_pro.cmd0xfb1.cmd0xfb1B\bcmd0xfb1P\u0000Z/git.code.oa.com/trpcprotocol/group_pro/cmd0xfb1b\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.b f381382a;

    /* renamed from: b, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381383b;

    /* renamed from: c, reason: collision with root package name */
    private static final Descriptors.b f381384c;

    /* renamed from: d, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381385d;

    /* renamed from: e, reason: collision with root package name */
    private static final Descriptors.b f381386e;

    /* renamed from: f, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381387f;

    /* renamed from: g, reason: collision with root package name */
    private static final Descriptors.b f381388g;

    /* renamed from: h, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381389h;

    /* renamed from: i, reason: collision with root package name */
    private static final Descriptors.b f381390i;

    /* renamed from: j, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381391j;

    /* renamed from: k, reason: collision with root package name */
    private static final Descriptors.b f381392k;

    /* renamed from: l, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381393l;

    /* renamed from: m, reason: collision with root package name */
    private static final Descriptors.b f381394m;

    /* renamed from: n, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381395n;

    /* renamed from: o, reason: collision with root package name */
    private static final Descriptors.b f381396o;

    /* renamed from: p, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381397p;

    /* renamed from: q, reason: collision with root package name */
    private static final Descriptors.b f381398q;

    /* renamed from: r, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381399r;

    /* renamed from: s, reason: collision with root package name */
    private static final Descriptors.b f381400s;

    /* renamed from: t, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381401t;

    /* renamed from: u, reason: collision with root package name */
    private static final Descriptors.b f381402u;

    /* renamed from: v, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381403v;

    /* renamed from: w, reason: collision with root package name */
    private static final Descriptors.b f381404w;

    /* renamed from: x, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381405x;

    /* renamed from: y, reason: collision with root package name */
    private static final Descriptors.b f381406y;

    /* renamed from: z, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381407z;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class AnchorInfo extends GeneratedMessageV3 implements b {
        public static final int ANCHOR_ICON_FIELD_NUMBER = 2;
        public static final int ANCHOR_NAME_FIELD_NUMBER = 1;
        public static final int BYTES_AVATAR_META_FIELD_NUMBER = 5;
        public static final int ID_VERIFY_TS_FIELD_NUMBER = 3;
        public static final int UINT64_TINY_ID_FIELD_NUMBER = 4;

        /* renamed from: d, reason: collision with root package name */
        private static final AnchorInfo f381408d = new AnchorInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<AnchorInfo> f381409e = new a();
        private static final long serialVersionUID = 0;
        private ByteString anchorIcon_;
        private ByteString anchorName_;
        private ByteString bytesAvatarMeta_;
        private int idVerifyTs_;
        private byte memoizedIsInitialized;
        private long uint64TinyId_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<AnchorInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public AnchorInfo g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new AnchorInfo(kVar, tVar);
            }
        }

        public static AnchorInfo getDefaultInstance() {
            return f381408d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381384c;
        }

        public static b newBuilder() {
            return f381408d.toBuilder();
        }

        public static AnchorInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AnchorInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381409e, inputStream);
        }

        public static AnchorInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381409e.d(byteBuffer);
        }

        public static bg<AnchorInfo> parser() {
            return f381409e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AnchorInfo)) {
                return super.equals(obj);
            }
            AnchorInfo anchorInfo = (AnchorInfo) obj;
            if (getAnchorName().equals(anchorInfo.getAnchorName()) && getAnchorIcon().equals(anchorInfo.getAnchorIcon()) && getIdVerifyTs() == anchorInfo.getIdVerifyTs() && getUint64TinyId() == anchorInfo.getUint64TinyId() && getBytesAvatarMeta().equals(anchorInfo.getBytesAvatarMeta()) && this.unknownFields.equals(anchorInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public ByteString getAnchorIcon() {
            return this.anchorIcon_;
        }

        public ByteString getAnchorName() {
            return this.anchorName_;
        }

        public ByteString getBytesAvatarMeta() {
            return this.bytesAvatarMeta_;
        }

        public int getIdVerifyTs() {
            return this.idVerifyTs_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<AnchorInfo> getParserForType() {
            return f381409e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (!this.anchorName_.isEmpty()) {
                i16 = 0 + CodedOutputStream.h(1, this.anchorName_);
            }
            if (!this.anchorIcon_.isEmpty()) {
                i16 += CodedOutputStream.h(2, this.anchorIcon_);
            }
            int i17 = this.idVerifyTs_;
            if (i17 != 0) {
                i16 += CodedOutputStream.Y(3, i17);
            }
            long j3 = this.uint64TinyId_;
            if (j3 != 0) {
                i16 += CodedOutputStream.a0(4, j3);
            }
            if (!this.bytesAvatarMeta_.isEmpty()) {
                i16 += CodedOutputStream.h(5, this.bytesAvatarMeta_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public long getUint64TinyId() {
            return this.uint64TinyId_;
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
            int hashCode = ((((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getAnchorName().hashCode()) * 37) + 2) * 53) + getAnchorIcon().hashCode()) * 37) + 3) * 53) + getIdVerifyTs()) * 37) + 4) * 53) + ad.h(getUint64TinyId())) * 37) + 5) * 53) + getBytesAvatarMeta().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381385d.e(AnchorInfo.class, b.class);
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
            return new AnchorInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.anchorName_.isEmpty()) {
                codedOutputStream.q0(1, this.anchorName_);
            }
            if (!this.anchorIcon_.isEmpty()) {
                codedOutputStream.q0(2, this.anchorIcon_);
            }
            int i3 = this.idVerifyTs_;
            if (i3 != 0) {
                codedOutputStream.b1(3, i3);
            }
            long j3 = this.uint64TinyId_;
            if (j3 != 0) {
                codedOutputStream.d1(4, j3);
            }
            if (!this.bytesAvatarMeta_.isEmpty()) {
                codedOutputStream.q0(5, this.bytesAvatarMeta_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {
            private int C;
            private long D;
            private ByteString E;

            /* renamed from: i, reason: collision with root package name */
            private ByteString f381410i;

            /* renamed from: m, reason: collision with root package name */
            private ByteString f381411m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(ByteString byteString) {
                byteString.getClass();
                this.f381410i = byteString;
                onChanged();
                return this;
            }

            public b B(ByteString byteString) {
                byteString.getClass();
                this.E = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b D(int i3) {
                this.C = i3;
                onChanged();
                return this;
            }

            public b E(long j3) {
                this.D = j3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: F, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return cmd0xfb1.f381384c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381385d.e(AnchorInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public AnchorInfo build() {
                AnchorInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public AnchorInfo buildPartial() {
                AnchorInfo anchorInfo = new AnchorInfo(this);
                anchorInfo.anchorName_ = this.f381410i;
                anchorInfo.anchorIcon_ = this.f381411m;
                anchorInfo.idVerifyTs_ = this.C;
                anchorInfo.uint64TinyId_ = this.D;
                anchorInfo.bytesAvatarMeta_ = this.E;
                onBuilt();
                return anchorInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                ByteString byteString = ByteString.EMPTY;
                this.f381410i = byteString;
                this.f381411m = byteString;
                this.C = 0;
                this.D = 0L;
                this.E = byteString;
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
            public AnchorInfo getDefaultInstanceForType() {
                return AnchorInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                AnchorInfo anchorInfo = null;
                try {
                    try {
                        AnchorInfo anchorInfo2 = (AnchorInfo) AnchorInfo.f381409e.g(kVar, tVar);
                        if (anchorInfo2 != null) {
                            x(anchorInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        AnchorInfo anchorInfo3 = (AnchorInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            anchorInfo = anchorInfo3;
                            if (anchorInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (anchorInfo != null) {
                        x(anchorInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof AnchorInfo) {
                    return x((AnchorInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(AnchorInfo anchorInfo) {
                if (anchorInfo == AnchorInfo.getDefaultInstance()) {
                    return this;
                }
                ByteString anchorName = anchorInfo.getAnchorName();
                ByteString byteString = ByteString.EMPTY;
                if (anchorName != byteString) {
                    A(anchorInfo.getAnchorName());
                }
                if (anchorInfo.getAnchorIcon() != byteString) {
                    z(anchorInfo.getAnchorIcon());
                }
                if (anchorInfo.getIdVerifyTs() != 0) {
                    D(anchorInfo.getIdVerifyTs());
                }
                if (anchorInfo.getUint64TinyId() != 0) {
                    E(anchorInfo.getUint64TinyId());
                }
                if (anchorInfo.getBytesAvatarMeta() != byteString) {
                    B(anchorInfo.getBytesAvatarMeta());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) anchorInfo).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(ByteString byteString) {
                byteString.getClass();
                this.f381411m = byteString;
                onChanged();
                return this;
            }

            b() {
                ByteString byteString = ByteString.EMPTY;
                this.f381410i = byteString;
                this.f381411m = byteString;
                this.E = byteString;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                ByteString byteString = ByteString.EMPTY;
                this.f381410i = byteString;
                this.f381411m = byteString;
                this.E = byteString;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(AnchorInfo anchorInfo) {
            return f381408d.toBuilder().x(anchorInfo);
        }

        public static AnchorInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381409e.m(byteBuffer, tVar);
        }

        AnchorInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AnchorInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (AnchorInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381409e, inputStream, tVar);
        }

        public static AnchorInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381409e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public AnchorInfo getDefaultInstanceForType() {
            return f381408d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381408d ? new b() : new b().x(this);
        }

        public static AnchorInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381409e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        AnchorInfo() {
            this.memoizedIsInitialized = (byte) -1;
            ByteString byteString = ByteString.EMPTY;
            this.anchorName_ = byteString;
            this.anchorIcon_ = byteString;
            this.bytesAvatarMeta_ = byteString;
        }

        public static AnchorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381409e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static AnchorInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381409e.i(bArr, tVar);
        }

        public static AnchorInfo parseFrom(InputStream inputStream) throws IOException {
            return (AnchorInfo) GeneratedMessageV3.parseWithIOException(f381409e, inputStream);
        }

        public static AnchorInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (AnchorInfo) GeneratedMessageV3.parseWithIOException(f381409e, inputStream, tVar);
        }

        AnchorInfo(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                if (J == 10) {
                                    this.anchorName_ = kVar.q();
                                } else if (J == 18) {
                                    this.anchorIcon_ = kVar.q();
                                } else if (J == 24) {
                                    this.idVerifyTs_ = kVar.K();
                                } else if (J == 32) {
                                    this.uint64TinyId_ = kVar.L();
                                } else if (J != 42) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.bytesAvatarMeta_ = kVar.q();
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static AnchorInfo parseFrom(k kVar) throws IOException {
            return (AnchorInfo) GeneratedMessageV3.parseWithIOException(f381409e, kVar);
        }

        public static AnchorInfo parseFrom(k kVar, t tVar) throws IOException {
            return (AnchorInfo) GeneratedMessageV3.parseWithIOException(f381409e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class AudienceInfo extends GeneratedMessageV3 implements c {
        public static final int BYTES_AVATAR_META_FIELD_NUMBER = 3;
        public static final int ICON_FIELD_NUMBER = 2;
        public static final int UIN_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final AudienceInfo f381412d = new AudienceInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<AudienceInfo> f381413e = new a();
        private static final long serialVersionUID = 0;
        private ByteString bytesAvatarMeta_;
        private volatile Object icon_;
        private byte memoizedIsInitialized;
        private long uin_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<AudienceInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public AudienceInfo g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new AudienceInfo(kVar, tVar);
            }
        }

        public static AudienceInfo getDefaultInstance() {
            return f381412d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381388g;
        }

        public static b newBuilder() {
            return f381412d.toBuilder();
        }

        public static AudienceInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AudienceInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381413e, inputStream);
        }

        public static AudienceInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381413e.d(byteBuffer);
        }

        public static bg<AudienceInfo> parser() {
            return f381413e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AudienceInfo)) {
                return super.equals(obj);
            }
            AudienceInfo audienceInfo = (AudienceInfo) obj;
            if (getUin() == audienceInfo.getUin() && getIcon().equals(audienceInfo.getIcon()) && getBytesAvatarMeta().equals(audienceInfo.getBytesAvatarMeta()) && this.unknownFields.equals(audienceInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public ByteString getBytesAvatarMeta() {
            return this.bytesAvatarMeta_;
        }

        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<AudienceInfo> getParserForType() {
            return f381413e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            long j3 = this.uin_;
            int i16 = 0;
            if (j3 != 0) {
                i16 = 0 + CodedOutputStream.a0(1, j3);
            }
            if (!getIconBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(2, this.icon_);
            }
            if (!this.bytesAvatarMeta_.isEmpty()) {
                i16 += CodedOutputStream.h(3, this.bytesAvatarMeta_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public long getUin() {
            return this.uin_;
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
            int hashCode = ((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getUin())) * 37) + 2) * 53) + getIcon().hashCode()) * 37) + 3) * 53) + getBytesAvatarMeta().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381389h.e(AudienceInfo.class, b.class);
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
            return new AudienceInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j3 = this.uin_;
            if (j3 != 0) {
                codedOutputStream.d1(1, j3);
            }
            if (!getIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.icon_);
            }
            if (!this.bytesAvatarMeta_.isEmpty()) {
                codedOutputStream.q0(3, this.bytesAvatarMeta_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {
            private ByteString C;

            /* renamed from: i, reason: collision with root package name */
            private long f381414i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381415m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(long j3) {
                this.f381414i = j3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return cmd0xfb1.f381388g;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381389h.e(AudienceInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public AudienceInfo build() {
                AudienceInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public AudienceInfo buildPartial() {
                AudienceInfo audienceInfo = new AudienceInfo(this);
                audienceInfo.uin_ = this.f381414i;
                audienceInfo.icon_ = this.f381415m;
                audienceInfo.bytesAvatarMeta_ = this.C;
                onBuilt();
                return audienceInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381414i = 0L;
                this.f381415m = "";
                this.C = ByteString.EMPTY;
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
            public AudienceInfo getDefaultInstanceForType() {
                return AudienceInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                AudienceInfo audienceInfo = null;
                try {
                    try {
                        AudienceInfo audienceInfo2 = (AudienceInfo) AudienceInfo.f381413e.g(kVar, tVar);
                        if (audienceInfo2 != null) {
                            x(audienceInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        AudienceInfo audienceInfo3 = (AudienceInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            audienceInfo = audienceInfo3;
                            if (audienceInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (audienceInfo != null) {
                        x(audienceInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof AudienceInfo) {
                    return x((AudienceInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(AudienceInfo audienceInfo) {
                if (audienceInfo == AudienceInfo.getDefaultInstance()) {
                    return this;
                }
                if (audienceInfo.getUin() != 0) {
                    B(audienceInfo.getUin());
                }
                if (!audienceInfo.getIcon().isEmpty()) {
                    this.f381415m = audienceInfo.icon_;
                    onChanged();
                }
                if (audienceInfo.getBytesAvatarMeta() != ByteString.EMPTY) {
                    z(audienceInfo.getBytesAvatarMeta());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) audienceInfo).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(ByteString byteString) {
                byteString.getClass();
                this.C = byteString;
                onChanged();
                return this;
            }

            b() {
                this.f381415m = "";
                this.C = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381415m = "";
                this.C = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(AudienceInfo audienceInfo) {
            return f381412d.toBuilder().x(audienceInfo);
        }

        public static AudienceInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381413e.m(byteBuffer, tVar);
        }

        AudienceInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AudienceInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (AudienceInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381413e, inputStream, tVar);
        }

        public static AudienceInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381413e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public AudienceInfo getDefaultInstanceForType() {
            return f381412d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381412d ? new b() : new b().x(this);
        }

        public static AudienceInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381413e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        AudienceInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.icon_ = "";
            this.bytesAvatarMeta_ = ByteString.EMPTY;
        }

        public static AudienceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381413e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static AudienceInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381413e.i(bArr, tVar);
        }

        public static AudienceInfo parseFrom(InputStream inputStream) throws IOException {
            return (AudienceInfo) GeneratedMessageV3.parseWithIOException(f381413e, inputStream);
        }

        AudienceInfo(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 8) {
                                this.uin_ = kVar.L();
                            } else if (J == 18) {
                                this.icon_ = kVar.I();
                            } else if (J != 26) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.bytesAvatarMeta_ = kVar.q();
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static AudienceInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (AudienceInfo) GeneratedMessageV3.parseWithIOException(f381413e, inputStream, tVar);
        }

        public static AudienceInfo parseFrom(k kVar) throws IOException {
            return (AudienceInfo) GeneratedMessageV3.parseWithIOException(f381413e, kVar);
        }

        public static AudienceInfo parseFrom(k kVar, t tVar) throws IOException {
            return (AudienceInfo) GeneratedMessageV3.parseWithIOException(f381413e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class LiveIconInfo extends GeneratedMessageV3 implements d {
        public static final int ICON_FIELD_NUMBER = 2;
        public static final int RATIO_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final LiveIconInfo f381416d = new LiveIconInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<LiveIconInfo> f381417e = new a();
        private static final long serialVersionUID = 0;
        private volatile Object icon_;
        private byte memoizedIsInitialized;
        private volatile Object ratio_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<LiveIconInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public LiveIconInfo g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new LiveIconInfo(kVar, tVar);
            }
        }

        public static LiveIconInfo getDefaultInstance() {
            return f381416d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381400s;
        }

        public static b newBuilder() {
            return f381416d.toBuilder();
        }

        public static LiveIconInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LiveIconInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381417e, inputStream);
        }

        public static LiveIconInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381417e.d(byteBuffer);
        }

        public static bg<LiveIconInfo> parser() {
            return f381417e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LiveIconInfo)) {
                return super.equals(obj);
            }
            LiveIconInfo liveIconInfo = (LiveIconInfo) obj;
            if (getRatio().equals(liveIconInfo.getRatio()) && getIcon().equals(liveIconInfo.getIcon()) && this.unknownFields.equals(liveIconInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<LiveIconInfo> getParserForType() {
            return f381417e;
        }

        public String getRatio() {
            Object obj = this.ratio_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ratio_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getRatioBytes() {
            Object obj = this.ratio_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ratio_ = copyFromUtf8;
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
            int i16 = 0;
            if (!getRatioBytes().isEmpty()) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.ratio_);
            }
            if (!getIconBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(2, this.icon_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getRatio().hashCode()) * 37) + 2) * 53) + getIcon().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381401t.e(LiveIconInfo.class, b.class);
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
            return new LiveIconInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getRatioBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.ratio_);
            }
            if (!getIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.icon_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements d {

            /* renamed from: i, reason: collision with root package name */
            private Object f381418i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381419m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return cmd0xfb1.f381400s;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381401t.e(LiveIconInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public LiveIconInfo build() {
                LiveIconInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public LiveIconInfo buildPartial() {
                LiveIconInfo liveIconInfo = new LiveIconInfo(this);
                liveIconInfo.ratio_ = this.f381418i;
                liveIconInfo.icon_ = this.f381419m;
                onBuilt();
                return liveIconInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381418i = "";
                this.f381419m = "";
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
            public LiveIconInfo getDefaultInstanceForType() {
                return LiveIconInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                LiveIconInfo liveIconInfo = null;
                try {
                    try {
                        LiveIconInfo liveIconInfo2 = (LiveIconInfo) LiveIconInfo.f381417e.g(kVar, tVar);
                        if (liveIconInfo2 != null) {
                            x(liveIconInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        LiveIconInfo liveIconInfo3 = (LiveIconInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            liveIconInfo = liveIconInfo3;
                            if (liveIconInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (liveIconInfo != null) {
                        x(liveIconInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof LiveIconInfo) {
                    return x((LiveIconInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(LiveIconInfo liveIconInfo) {
                if (liveIconInfo == LiveIconInfo.getDefaultInstance()) {
                    return this;
                }
                if (!liveIconInfo.getRatio().isEmpty()) {
                    this.f381418i = liveIconInfo.ratio_;
                    onChanged();
                }
                if (!liveIconInfo.getIcon().isEmpty()) {
                    this.f381419m = liveIconInfo.icon_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) liveIconInfo).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            b() {
                this.f381418i = "";
                this.f381419m = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381418i = "";
                this.f381419m = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(LiveIconInfo liveIconInfo) {
            return f381416d.toBuilder().x(liveIconInfo);
        }

        public static LiveIconInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381417e.m(byteBuffer, tVar);
        }

        LiveIconInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LiveIconInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (LiveIconInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381417e, inputStream, tVar);
        }

        public static LiveIconInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381417e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public LiveIconInfo getDefaultInstanceForType() {
            return f381416d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381416d ? new b() : new b().x(this);
        }

        public static LiveIconInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381417e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        LiveIconInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.ratio_ = "";
            this.icon_ = "";
        }

        public static LiveIconInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381417e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static LiveIconInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381417e.i(bArr, tVar);
        }

        public static LiveIconInfo parseFrom(InputStream inputStream) throws IOException {
            return (LiveIconInfo) GeneratedMessageV3.parseWithIOException(f381417e, inputStream);
        }

        LiveIconInfo(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                if (J == 10) {
                                    this.ratio_ = kVar.I();
                                } else if (J != 18) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.icon_ = kVar.I();
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

        public static LiveIconInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (LiveIconInfo) GeneratedMessageV3.parseWithIOException(f381417e, inputStream, tVar);
        }

        public static LiveIconInfo parseFrom(k kVar) throws IOException {
            return (LiveIconInfo) GeneratedMessageV3.parseWithIOException(f381417e, kVar);
        }

        public static LiveIconInfo parseFrom(k kVar, t tVar) throws IOException {
            return (LiveIconInfo) GeneratedMessageV3.parseWithIOException(f381417e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ProgramInfo extends GeneratedMessageV3 implements e {
        public static final int ANCHOR_NAME_FIELD_NUMBER = 3;
        public static final int LIVE_TITLE_FIELD_NUMBER = 2;
        public static final int LOGO_FIELD_NUMBER = 4;
        public static final int PROGRAM_ID_FIELD_NUMBER = 1;
        public static final int TAB_ID_FIELD_NUMBER = 5;

        /* renamed from: d, reason: collision with root package name */
        private static final ProgramInfo f381420d = new ProgramInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ProgramInfo> f381421e = new a();
        private static final long serialVersionUID = 0;
        private volatile Object anchorName_;
        private volatile Object liveTitle_;
        private volatile Object logo_;
        private byte memoizedIsInitialized;
        private volatile Object programId_;
        private long tabId_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ProgramInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ProgramInfo g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ProgramInfo(kVar, tVar);
            }
        }

        public static ProgramInfo getDefaultInstance() {
            return f381420d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381402u;
        }

        public static b newBuilder() {
            return f381420d.toBuilder();
        }

        public static ProgramInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ProgramInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381421e, inputStream);
        }

        public static ProgramInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381421e.d(byteBuffer);
        }

        public static bg<ProgramInfo> parser() {
            return f381421e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ProgramInfo)) {
                return super.equals(obj);
            }
            ProgramInfo programInfo = (ProgramInfo) obj;
            if (getProgramId().equals(programInfo.getProgramId()) && getLiveTitle().equals(programInfo.getLiveTitle()) && getAnchorName().equals(programInfo.getAnchorName()) && getLogo().equals(programInfo.getLogo()) && getTabId() == programInfo.getTabId() && this.unknownFields.equals(programInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getAnchorName() {
            Object obj = this.anchorName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.anchorName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getAnchorNameBytes() {
            Object obj = this.anchorName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.anchorName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getLiveTitle() {
            Object obj = this.liveTitle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liveTitle_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getLiveTitleBytes() {
            Object obj = this.liveTitle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liveTitle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getLogo() {
            Object obj = this.logo_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.logo_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getLogoBytes() {
            Object obj = this.logo_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.logo_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ProgramInfo> getParserForType() {
            return f381421e;
        }

        public String getProgramId() {
            Object obj = this.programId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.programId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getProgramIdBytes() {
            Object obj = this.programId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.programId_ = copyFromUtf8;
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
            int i16 = 0;
            if (!getProgramIdBytes().isEmpty()) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.programId_);
            }
            if (!getLiveTitleBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(2, this.liveTitle_);
            }
            if (!getAnchorNameBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(3, this.anchorName_);
            }
            if (!getLogoBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(4, this.logo_);
            }
            long j3 = this.tabId_;
            if (j3 != 0) {
                i16 += CodedOutputStream.a0(5, j3);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public long getTabId() {
            return this.tabId_;
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
            int hashCode = ((((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getProgramId().hashCode()) * 37) + 2) * 53) + getLiveTitle().hashCode()) * 37) + 3) * 53) + getAnchorName().hashCode()) * 37) + 4) * 53) + getLogo().hashCode()) * 37) + 5) * 53) + ad.h(getTabId())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381403v.e(ProgramInfo.class, b.class);
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
            return new ProgramInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getProgramIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.programId_);
            }
            if (!getLiveTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.liveTitle_);
            }
            if (!getAnchorNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.anchorName_);
            }
            if (!getLogoBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.logo_);
            }
            long j3 = this.tabId_;
            if (j3 != 0) {
                codedOutputStream.d1(5, j3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {
            private Object C;
            private Object D;
            private long E;

            /* renamed from: i, reason: collision with root package name */
            private Object f381422i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381423m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(long j3) {
                this.E = j3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return cmd0xfb1.f381402u;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381403v.e(ProgramInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ProgramInfo build() {
                ProgramInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ProgramInfo buildPartial() {
                ProgramInfo programInfo = new ProgramInfo(this);
                programInfo.programId_ = this.f381422i;
                programInfo.liveTitle_ = this.f381423m;
                programInfo.anchorName_ = this.C;
                programInfo.logo_ = this.D;
                programInfo.tabId_ = this.E;
                onBuilt();
                return programInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381422i = "";
                this.f381423m = "";
                this.C = "";
                this.D = "";
                this.E = 0L;
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
            public ProgramInfo getDefaultInstanceForType() {
                return ProgramInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ProgramInfo programInfo = null;
                try {
                    try {
                        ProgramInfo programInfo2 = (ProgramInfo) ProgramInfo.f381421e.g(kVar, tVar);
                        if (programInfo2 != null) {
                            x(programInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ProgramInfo programInfo3 = (ProgramInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            programInfo = programInfo3;
                            if (programInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (programInfo != null) {
                        x(programInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ProgramInfo) {
                    return x((ProgramInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ProgramInfo programInfo) {
                if (programInfo == ProgramInfo.getDefaultInstance()) {
                    return this;
                }
                if (!programInfo.getProgramId().isEmpty()) {
                    this.f381422i = programInfo.programId_;
                    onChanged();
                }
                if (!programInfo.getLiveTitle().isEmpty()) {
                    this.f381423m = programInfo.liveTitle_;
                    onChanged();
                }
                if (!programInfo.getAnchorName().isEmpty()) {
                    this.C = programInfo.anchorName_;
                    onChanged();
                }
                if (!programInfo.getLogo().isEmpty()) {
                    this.D = programInfo.logo_;
                    onChanged();
                }
                if (programInfo.getTabId() != 0) {
                    A(programInfo.getTabId());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) programInfo).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            b() {
                this.f381422i = "";
                this.f381423m = "";
                this.C = "";
                this.D = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381422i = "";
                this.f381423m = "";
                this.C = "";
                this.D = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ProgramInfo programInfo) {
            return f381420d.toBuilder().x(programInfo);
        }

        public static ProgramInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381421e.m(byteBuffer, tVar);
        }

        ProgramInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ProgramInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ProgramInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381421e, inputStream, tVar);
        }

        public static ProgramInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381421e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ProgramInfo getDefaultInstanceForType() {
            return f381420d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381420d ? new b() : new b().x(this);
        }

        public static ProgramInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381421e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ProgramInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.programId_ = "";
            this.liveTitle_ = "";
            this.anchorName_ = "";
            this.logo_ = "";
        }

        public static ProgramInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381421e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ProgramInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381421e.i(bArr, tVar);
        }

        public static ProgramInfo parseFrom(InputStream inputStream) throws IOException {
            return (ProgramInfo) GeneratedMessageV3.parseWithIOException(f381421e, inputStream);
        }

        public static ProgramInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ProgramInfo) GeneratedMessageV3.parseWithIOException(f381421e, inputStream, tVar);
        }

        ProgramInfo(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                if (J == 10) {
                                    this.programId_ = kVar.I();
                                } else if (J == 18) {
                                    this.liveTitle_ = kVar.I();
                                } else if (J == 26) {
                                    this.anchorName_ = kVar.I();
                                } else if (J == 34) {
                                    this.logo_ = kVar.I();
                                } else if (J != 40) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.tabId_ = kVar.L();
                                }
                            }
                            z16 = true;
                        } catch (IOException e16) {
                            throw new InvalidProtocolBufferException(e16).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e17) {
                        throw e17.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ProgramInfo parseFrom(k kVar) throws IOException {
            return (ProgramInfo) GeneratedMessageV3.parseWithIOException(f381421e, kVar);
        }

        public static ProgramInfo parseFrom(k kVar, t tVar) throws IOException {
            return (ProgramInfo) GeneratedMessageV3.parseWithIOException(f381421e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ResultItem extends GeneratedMessageV3 implements f {
        public static final int ANCHOR_INFO_FIELD_NUMBER = 5;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int LIVE_TYPE_FIELD_NUMBER = 8;
        public static final int PLATFORM_FIELD_NUMBER = 9;
        public static final int PROGRAM_INFO_FIELD_NUMBER = 10;
        public static final int QUERY_ID_FIELD_NUMBER = 3;
        public static final int QUERY_ID_TYPE_FIELD_NUMBER = 4;
        public static final int RESULT_CODE_FIELD_NUMBER = 1;
        public static final int ROOM_INFO_FIELD_NUMBER = 6;
        public static final int STREAM_INFO_FIELD_NUMBER = 7;

        /* renamed from: d, reason: collision with root package name */
        private static final ResultItem f381424d = new ResultItem();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ResultItem> f381425e = new a();
        private static final long serialVersionUID = 0;
        private AnchorInfo anchorInfo_;
        private volatile Object errMsg_;
        private int liveType_;
        private byte memoizedIsInitialized;
        private int platform_;
        private ProgramInfo programInfo_;
        private int queryIdType_;
        private long queryId_;
        private int resultCode_;
        private RoomInfo roomInfo_;
        private StreamInfo streamInfo_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public enum QueryIdType implements bk {
            UNKNOWN_QUERY_TYPE(0),
            ROOM_ID(1),
            CHANNEL_ID(2),
            UNRECOGNIZED(-1);

            public static final int CHANNEL_ID_VALUE = 2;
            public static final int ROOM_ID_VALUE = 1;
            public static final int UNKNOWN_QUERY_TYPE_VALUE = 0;
            private final int value;
            private static final ad.d<QueryIdType> internalValueMap = new a();
            private static final QueryIdType[] VALUES = values();

            /* compiled from: P */
            /* loaded from: classes27.dex */
            class a implements ad.d<QueryIdType> {
                a() {
                }

                @Override // com.google.protobuf.ad.d
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public QueryIdType findValueByNumber(int i3) {
                    return QueryIdType.forNumber(i3);
                }
            }

            QueryIdType(int i3) {
                this.value = i3;
            }

            public static QueryIdType forNumber(int i3) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return null;
                        }
                        return CHANNEL_ID;
                    }
                    return ROOM_ID;
                }
                return UNKNOWN_QUERY_TYPE;
            }

            public static final Descriptors.c getDescriptor() {
                return ResultItem.getDescriptor().p().get(0);
            }

            public static ad.d<QueryIdType> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.c getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ad.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            public final Descriptors.d getValueDescriptor() {
                return getDescriptor().o().get(ordinal());
            }

            @Deprecated
            public static QueryIdType valueOf(int i3) {
                return forNumber(i3);
            }

            public static QueryIdType valueOf(Descriptors.d dVar) {
                if (dVar.m() == getDescriptor()) {
                    if (dVar.l() == -1) {
                        return UNRECOGNIZED;
                    }
                    return VALUES[dVar.l()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ResultItem> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ResultItem g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ResultItem(kVar, tVar);
            }
        }

        public static ResultItem getDefaultInstance() {
            return f381424d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381382a;
        }

        public static b newBuilder() {
            return f381424d.toBuilder();
        }

        public static ResultItem parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ResultItem) GeneratedMessageV3.parseDelimitedWithIOException(f381425e, inputStream);
        }

        public static ResultItem parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381425e.d(byteBuffer);
        }

        public static bg<ResultItem> parser() {
            return f381425e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResultItem)) {
                return super.equals(obj);
            }
            ResultItem resultItem = (ResultItem) obj;
            if (getResultCode() != resultItem.getResultCode() || !getErrMsg().equals(resultItem.getErrMsg()) || getQueryId() != resultItem.getQueryId() || this.queryIdType_ != resultItem.queryIdType_ || hasAnchorInfo() != resultItem.hasAnchorInfo()) {
                return false;
            }
            if ((hasAnchorInfo() && !getAnchorInfo().equals(resultItem.getAnchorInfo())) || hasRoomInfo() != resultItem.hasRoomInfo()) {
                return false;
            }
            if ((hasRoomInfo() && !getRoomInfo().equals(resultItem.getRoomInfo())) || hasStreamInfo() != resultItem.hasStreamInfo()) {
                return false;
            }
            if ((hasStreamInfo() && !getStreamInfo().equals(resultItem.getStreamInfo())) || getLiveType() != resultItem.getLiveType() || getPlatform() != resultItem.getPlatform() || hasProgramInfo() != resultItem.hasProgramInfo()) {
                return false;
            }
            if ((!hasProgramInfo() || getProgramInfo().equals(resultItem.getProgramInfo())) && this.unknownFields.equals(resultItem.unknownFields)) {
                return true;
            }
            return false;
        }

        public AnchorInfo getAnchorInfo() {
            AnchorInfo anchorInfo = this.anchorInfo_;
            if (anchorInfo == null) {
                return AnchorInfo.getDefaultInstance();
            }
            return anchorInfo;
        }

        public b getAnchorInfoOrBuilder() {
            return getAnchorInfo();
        }

        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getLiveType() {
            return this.liveType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ResultItem> getParserForType() {
            return f381425e;
        }

        public int getPlatform() {
            return this.platform_;
        }

        public ProgramInfo getProgramInfo() {
            ProgramInfo programInfo = this.programInfo_;
            if (programInfo == null) {
                return ProgramInfo.getDefaultInstance();
            }
            return programInfo;
        }

        public e getProgramInfoOrBuilder() {
            return getProgramInfo();
        }

        public long getQueryId() {
            return this.queryId_;
        }

        public QueryIdType getQueryIdType() {
            QueryIdType valueOf = QueryIdType.valueOf(this.queryIdType_);
            if (valueOf == null) {
                return QueryIdType.UNRECOGNIZED;
            }
            return valueOf;
        }

        public int getQueryIdTypeValue() {
            return this.queryIdType_;
        }

        public int getResultCode() {
            return this.resultCode_;
        }

        public RoomInfo getRoomInfo() {
            RoomInfo roomInfo = this.roomInfo_;
            if (roomInfo == null) {
                return RoomInfo.getDefaultInstance();
            }
            return roomInfo;
        }

        public g getRoomInfoOrBuilder() {
            return getRoomInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.resultCode_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.Y(1, i16);
            }
            if (!getErrMsgBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(2, this.errMsg_);
            }
            long j3 = this.queryId_;
            if (j3 != 0) {
                i17 += CodedOutputStream.a0(3, j3);
            }
            if (this.queryIdType_ != QueryIdType.UNKNOWN_QUERY_TYPE.getNumber()) {
                i17 += CodedOutputStream.l(4, this.queryIdType_);
            }
            if (this.anchorInfo_ != null) {
                i17 += CodedOutputStream.G(5, getAnchorInfo());
            }
            if (this.roomInfo_ != null) {
                i17 += CodedOutputStream.G(6, getRoomInfo());
            }
            if (this.streamInfo_ != null) {
                i17 += CodedOutputStream.G(7, getStreamInfo());
            }
            int i18 = this.liveType_;
            if (i18 != 0) {
                i17 += CodedOutputStream.Y(8, i18);
            }
            int i19 = this.platform_;
            if (i19 != 0) {
                i17 += CodedOutputStream.Y(9, i19);
            }
            if (this.programInfo_ != null) {
                i17 += CodedOutputStream.G(10, getProgramInfo());
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public StreamInfo getStreamInfo() {
            StreamInfo streamInfo = this.streamInfo_;
            if (streamInfo == null) {
                return StreamInfo.getDefaultInstance();
            }
            return streamInfo;
        }

        public h getStreamInfoOrBuilder() {
            return getStreamInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasAnchorInfo() {
            if (this.anchorInfo_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasProgramInfo() {
            if (this.programInfo_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasRoomInfo() {
            if (this.roomInfo_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasStreamInfo() {
            if (this.streamInfo_ != null) {
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
            int hashCode = ((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getResultCode()) * 37) + 2) * 53) + getErrMsg().hashCode()) * 37) + 3) * 53) + ad.h(getQueryId())) * 37) + 4) * 53) + this.queryIdType_;
            if (hasAnchorInfo()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getAnchorInfo().hashCode();
            }
            if (hasRoomInfo()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getRoomInfo().hashCode();
            }
            if (hasStreamInfo()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getStreamInfo().hashCode();
            }
            int liveType = (((((((hashCode * 37) + 8) * 53) + getLiveType()) * 37) + 9) * 53) + getPlatform();
            if (hasProgramInfo()) {
                liveType = (((liveType * 37) + 10) * 53) + getProgramInfo().hashCode();
            }
            int hashCode2 = (liveType * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381383b.e(ResultItem.class, b.class);
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
            return new ResultItem();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.resultCode_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            if (!getErrMsgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.errMsg_);
            }
            long j3 = this.queryId_;
            if (j3 != 0) {
                codedOutputStream.d1(3, j3);
            }
            if (this.queryIdType_ != QueryIdType.UNKNOWN_QUERY_TYPE.getNumber()) {
                codedOutputStream.u0(4, this.queryIdType_);
            }
            if (this.anchorInfo_ != null) {
                codedOutputStream.K0(5, getAnchorInfo());
            }
            if (this.roomInfo_ != null) {
                codedOutputStream.K0(6, getRoomInfo());
            }
            if (this.streamInfo_ != null) {
                codedOutputStream.K0(7, getStreamInfo());
            }
            int i16 = this.liveType_;
            if (i16 != 0) {
                codedOutputStream.b1(8, i16);
            }
            int i17 = this.platform_;
            if (i17 != 0) {
                codedOutputStream.b1(9, i17);
            }
            if (this.programInfo_ != null) {
                codedOutputStream.K0(10, getProgramInfo());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements f {
            private long C;
            private int D;
            private AnchorInfo E;
            private bu<AnchorInfo, AnchorInfo.b, b> F;
            private RoomInfo G;
            private bu<RoomInfo, RoomInfo.b, g> H;
            private StreamInfo I;
            private bu<StreamInfo, StreamInfo.b, h> J;
            private int K;
            private int L;
            private ProgramInfo M;
            private bu<ProgramInfo, ProgramInfo.b, e> N;

            /* renamed from: i, reason: collision with root package name */
            private int f381426i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381427m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(RoomInfo roomInfo) {
                bu<RoomInfo, RoomInfo.b, g> buVar = this.H;
                if (buVar == null) {
                    RoomInfo roomInfo2 = this.G;
                    if (roomInfo2 != null) {
                        this.G = RoomInfo.newBuilder(roomInfo2).B(roomInfo).buildPartial();
                    } else {
                        this.G = roomInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(roomInfo);
                }
                return this;
            }

            public b B(StreamInfo streamInfo) {
                bu<StreamInfo, StreamInfo.b, h> buVar = this.J;
                if (buVar == null) {
                    StreamInfo streamInfo2 = this.I;
                    if (streamInfo2 != null) {
                        this.I = StreamInfo.newBuilder(streamInfo2).x(streamInfo).buildPartial();
                    } else {
                        this.I = streamInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(streamInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b E(int i3) {
                this.K = i3;
                onChanged();
                return this;
            }

            public b F(int i3) {
                this.L = i3;
                onChanged();
                return this;
            }

            public b G(long j3) {
                this.C = j3;
                onChanged();
                return this;
            }

            public b H(int i3) {
                this.D = i3;
                onChanged();
                return this;
            }

            public b I(int i3) {
                this.f381426i = i3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: J, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return cmd0xfb1.f381382a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381383b.e(ResultItem.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ResultItem build() {
                ResultItem buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ResultItem buildPartial() {
                ResultItem resultItem = new ResultItem(this);
                resultItem.resultCode_ = this.f381426i;
                resultItem.errMsg_ = this.f381427m;
                resultItem.queryId_ = this.C;
                resultItem.queryIdType_ = this.D;
                bu<AnchorInfo, AnchorInfo.b, b> buVar = this.F;
                if (buVar == null) {
                    resultItem.anchorInfo_ = this.E;
                } else {
                    resultItem.anchorInfo_ = buVar.b();
                }
                bu<RoomInfo, RoomInfo.b, g> buVar2 = this.H;
                if (buVar2 == null) {
                    resultItem.roomInfo_ = this.G;
                } else {
                    resultItem.roomInfo_ = buVar2.b();
                }
                bu<StreamInfo, StreamInfo.b, h> buVar3 = this.J;
                if (buVar3 == null) {
                    resultItem.streamInfo_ = this.I;
                } else {
                    resultItem.streamInfo_ = buVar3.b();
                }
                resultItem.liveType_ = this.K;
                resultItem.platform_ = this.L;
                bu<ProgramInfo, ProgramInfo.b, e> buVar4 = this.N;
                if (buVar4 == null) {
                    resultItem.programInfo_ = this.M;
                } else {
                    resultItem.programInfo_ = buVar4.b();
                }
                onBuilt();
                return resultItem;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381426i = 0;
                this.f381427m = "";
                this.C = 0L;
                this.D = 0;
                if (this.F == null) {
                    this.E = null;
                } else {
                    this.E = null;
                    this.F = null;
                }
                if (this.H == null) {
                    this.G = null;
                } else {
                    this.G = null;
                    this.H = null;
                }
                if (this.J == null) {
                    this.I = null;
                } else {
                    this.I = null;
                    this.J = null;
                }
                this.K = 0;
                this.L = 0;
                if (this.N == null) {
                    this.M = null;
                } else {
                    this.M = null;
                    this.N = null;
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
            public ResultItem getDefaultInstanceForType() {
                return ResultItem.getDefaultInstance();
            }

            public b v(AnchorInfo anchorInfo) {
                bu<AnchorInfo, AnchorInfo.b, b> buVar = this.F;
                if (buVar == null) {
                    AnchorInfo anchorInfo2 = this.E;
                    if (anchorInfo2 != null) {
                        this.E = AnchorInfo.newBuilder(anchorInfo2).x(anchorInfo).buildPartial();
                    } else {
                        this.E = anchorInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(anchorInfo);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ResultItem resultItem = null;
                try {
                    try {
                        ResultItem resultItem2 = (ResultItem) ResultItem.f381425e.g(kVar, tVar);
                        if (resultItem2 != null) {
                            y(resultItem2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ResultItem resultItem3 = (ResultItem) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            resultItem = resultItem3;
                            if (resultItem != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (resultItem != null) {
                        y(resultItem);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ResultItem) {
                    return y((ResultItem) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b y(ResultItem resultItem) {
                if (resultItem == ResultItem.getDefaultInstance()) {
                    return this;
                }
                if (resultItem.getResultCode() != 0) {
                    I(resultItem.getResultCode());
                }
                if (!resultItem.getErrMsg().isEmpty()) {
                    this.f381427m = resultItem.errMsg_;
                    onChanged();
                }
                if (resultItem.getQueryId() != 0) {
                    G(resultItem.getQueryId());
                }
                if (resultItem.queryIdType_ != 0) {
                    H(resultItem.getQueryIdTypeValue());
                }
                if (resultItem.hasAnchorInfo()) {
                    v(resultItem.getAnchorInfo());
                }
                if (resultItem.hasRoomInfo()) {
                    A(resultItem.getRoomInfo());
                }
                if (resultItem.hasStreamInfo()) {
                    B(resultItem.getStreamInfo());
                }
                if (resultItem.getLiveType() != 0) {
                    E(resultItem.getLiveType());
                }
                if (resultItem.getPlatform() != 0) {
                    F(resultItem.getPlatform());
                }
                if (resultItem.hasProgramInfo()) {
                    z(resultItem.getProgramInfo());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) resultItem).unknownFields);
                onChanged();
                return this;
            }

            public b z(ProgramInfo programInfo) {
                bu<ProgramInfo, ProgramInfo.b, e> buVar = this.N;
                if (buVar == null) {
                    ProgramInfo programInfo2 = this.M;
                    if (programInfo2 != null) {
                        this.M = ProgramInfo.newBuilder(programInfo2).x(programInfo).buildPartial();
                    } else {
                        this.M = programInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(programInfo);
                }
                return this;
            }

            b() {
                this.f381427m = "";
                this.D = 0;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381427m = "";
                this.D = 0;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ResultItem resultItem) {
            return f381424d.toBuilder().y(resultItem);
        }

        public static ResultItem parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381425e.m(byteBuffer, tVar);
        }

        ResultItem(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ResultItem parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ResultItem) GeneratedMessageV3.parseDelimitedWithIOException(f381425e, inputStream, tVar);
        }

        public static ResultItem parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381425e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ResultItem getDefaultInstanceForType() {
            return f381424d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381424d ? new b() : new b().y(this);
        }

        public static ResultItem parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381425e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ResultItem() {
            this.memoizedIsInitialized = (byte) -1;
            this.errMsg_ = "";
            this.queryIdType_ = 0;
        }

        public static ResultItem parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381425e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ResultItem parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381425e.i(bArr, tVar);
        }

        public static ResultItem parseFrom(InputStream inputStream) throws IOException {
            return (ResultItem) GeneratedMessageV3.parseWithIOException(f381425e, inputStream);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0013. Please report as an issue. */
        ResultItem(k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                    this.resultCode_ = kVar.K();
                                case 18:
                                    this.errMsg_ = kVar.I();
                                case 24:
                                    this.queryId_ = kVar.L();
                                case 32:
                                    this.queryIdType_ = kVar.s();
                                case 42:
                                    AnchorInfo anchorInfo = this.anchorInfo_;
                                    AnchorInfo.b builder = anchorInfo != null ? anchorInfo.toBuilder() : null;
                                    AnchorInfo anchorInfo2 = (AnchorInfo) kVar.z(AnchorInfo.parser(), tVar);
                                    this.anchorInfo_ = anchorInfo2;
                                    if (builder != null) {
                                        builder.x(anchorInfo2);
                                        this.anchorInfo_ = builder.buildPartial();
                                    }
                                case 50:
                                    RoomInfo roomInfo = this.roomInfo_;
                                    RoomInfo.b builder2 = roomInfo != null ? roomInfo.toBuilder() : null;
                                    RoomInfo roomInfo2 = (RoomInfo) kVar.z(RoomInfo.parser(), tVar);
                                    this.roomInfo_ = roomInfo2;
                                    if (builder2 != null) {
                                        builder2.B(roomInfo2);
                                        this.roomInfo_ = builder2.buildPartial();
                                    }
                                case 58:
                                    StreamInfo streamInfo = this.streamInfo_;
                                    StreamInfo.b builder3 = streamInfo != null ? streamInfo.toBuilder() : null;
                                    StreamInfo streamInfo2 = (StreamInfo) kVar.z(StreamInfo.parser(), tVar);
                                    this.streamInfo_ = streamInfo2;
                                    if (builder3 != null) {
                                        builder3.x(streamInfo2);
                                        this.streamInfo_ = builder3.buildPartial();
                                    }
                                case 64:
                                    this.liveType_ = kVar.K();
                                case 72:
                                    this.platform_ = kVar.K();
                                case 82:
                                    ProgramInfo programInfo = this.programInfo_;
                                    ProgramInfo.b builder4 = programInfo != null ? programInfo.toBuilder() : null;
                                    ProgramInfo programInfo2 = (ProgramInfo) kVar.z(ProgramInfo.parser(), tVar);
                                    this.programInfo_ = programInfo2;
                                    if (builder4 != null) {
                                        builder4.x(programInfo2);
                                        this.programInfo_ = builder4.buildPartial();
                                    }
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

        public static ResultItem parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ResultItem) GeneratedMessageV3.parseWithIOException(f381425e, inputStream, tVar);
        }

        public static ResultItem parseFrom(k kVar) throws IOException {
            return (ResultItem) GeneratedMessageV3.parseWithIOException(f381425e, kVar);
        }

        public static ResultItem parseFrom(k kVar, t tVar) throws IOException {
            return (ResultItem) GeneratedMessageV3.parseWithIOException(f381425e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RoomInfo extends GeneratedMessageV3 implements g {
        public static final int AUDIENCE_INFOS_FIELD_NUMBER = 12;
        public static final int EXTRA_INFO_FIELD_NUMBER = 10;
        public static final int LIVE_ICONS_FIELD_NUMBER = 7;
        public static final int PROGRAM_ID_FIELD_NUMBER = 6;
        public static final int ROOM_ID_FIELD_NUMBER = 1;
        public static final int ROOM_PV_FIELD_NUMBER = 11;
        public static final int ROOM_STATE_FIELD_NUMBER = 4;
        public static final int ROOM_TITLE_FIELD_NUMBER = 2;
        public static final int SCREEN_SHOT_FIELD_NUMBER = 13;
        public static final int VIEWER_EXT_FIELD_NUMBER = 5;
        public static final int VIEWER_FIELD_NUMBER = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final RoomInfo f381428d = new RoomInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<RoomInfo> f381429e = new a();
        private static final long serialVersionUID = 0;
        private List<AudienceInfo> audienceInfos_;
        private ByteString extraInfo_;
        private List<LiveIconInfo> liveIcons_;
        private byte memoizedIsInitialized;
        private volatile Object programId_;
        private long roomId_;
        private volatile Object roomPv_;
        private int roomState_;
        private volatile Object roomTitle_;
        private volatile Object screenShot_;
        private ViewerExt viewerExt_;
        private long viewer_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<RoomInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public RoomInfo g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new RoomInfo(kVar, tVar);
            }
        }

        public static RoomInfo getDefaultInstance() {
            return f381428d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381386e;
        }

        public static b newBuilder() {
            return f381428d.toBuilder();
        }

        public static RoomInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RoomInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381429e, inputStream);
        }

        public static RoomInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381429e.d(byteBuffer);
        }

        public static bg<RoomInfo> parser() {
            return f381429e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RoomInfo)) {
                return super.equals(obj);
            }
            RoomInfo roomInfo = (RoomInfo) obj;
            if (getRoomId() != roomInfo.getRoomId() || !getRoomTitle().equals(roomInfo.getRoomTitle()) || getViewer() != roomInfo.getViewer() || getRoomState() != roomInfo.getRoomState() || hasViewerExt() != roomInfo.hasViewerExt()) {
                return false;
            }
            if ((!hasViewerExt() || getViewerExt().equals(roomInfo.getViewerExt())) && getProgramId().equals(roomInfo.getProgramId()) && getLiveIconsList().equals(roomInfo.getLiveIconsList()) && getExtraInfo().equals(roomInfo.getExtraInfo()) && getRoomPv().equals(roomInfo.getRoomPv()) && getAudienceInfosList().equals(roomInfo.getAudienceInfosList()) && getScreenShot().equals(roomInfo.getScreenShot()) && this.unknownFields.equals(roomInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public AudienceInfo getAudienceInfos(int i3) {
            return this.audienceInfos_.get(i3);
        }

        public int getAudienceInfosCount() {
            return this.audienceInfos_.size();
        }

        public List<AudienceInfo> getAudienceInfosList() {
            return this.audienceInfos_;
        }

        public c getAudienceInfosOrBuilder(int i3) {
            return this.audienceInfos_.get(i3);
        }

        public List<? extends c> getAudienceInfosOrBuilderList() {
            return this.audienceInfos_;
        }

        public ByteString getExtraInfo() {
            return this.extraInfo_;
        }

        public LiveIconInfo getLiveIcons(int i3) {
            return this.liveIcons_.get(i3);
        }

        public int getLiveIconsCount() {
            return this.liveIcons_.size();
        }

        public List<LiveIconInfo> getLiveIconsList() {
            return this.liveIcons_;
        }

        public d getLiveIconsOrBuilder(int i3) {
            return this.liveIcons_.get(i3);
        }

        public List<? extends d> getLiveIconsOrBuilderList() {
            return this.liveIcons_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<RoomInfo> getParserForType() {
            return f381429e;
        }

        public String getProgramId() {
            Object obj = this.programId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.programId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getProgramIdBytes() {
            Object obj = this.programId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.programId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public long getRoomId() {
            return this.roomId_;
        }

        public String getRoomPv() {
            Object obj = this.roomPv_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomPv_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getRoomPvBytes() {
            Object obj = this.roomPv_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomPv_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getRoomState() {
            return this.roomState_;
        }

        public String getRoomTitle() {
            Object obj = this.roomTitle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomTitle_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getRoomTitleBytes() {
            Object obj = this.roomTitle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomTitle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getScreenShot() {
            Object obj = this.screenShot_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.screenShot_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getScreenShotBytes() {
            Object obj = this.screenShot_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.screenShot_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            long j3 = this.roomId_;
            if (j3 != 0) {
                i3 = CodedOutputStream.a0(1, j3) + 0;
            } else {
                i3 = 0;
            }
            if (!getRoomTitleBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(2, this.roomTitle_);
            }
            long j16 = this.viewer_;
            if (j16 != 0) {
                i3 += CodedOutputStream.a0(3, j16);
            }
            int i17 = this.roomState_;
            if (i17 != 0) {
                i3 += CodedOutputStream.Y(4, i17);
            }
            if (this.viewerExt_ != null) {
                i3 += CodedOutputStream.G(5, getViewerExt());
            }
            if (!getProgramIdBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(6, this.programId_);
            }
            for (int i18 = 0; i18 < this.liveIcons_.size(); i18++) {
                i3 += CodedOutputStream.G(7, this.liveIcons_.get(i18));
            }
            if (!this.extraInfo_.isEmpty()) {
                i3 += CodedOutputStream.h(10, this.extraInfo_);
            }
            if (!getRoomPvBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(11, this.roomPv_);
            }
            for (int i19 = 0; i19 < this.audienceInfos_.size(); i19++) {
                i3 += CodedOutputStream.G(12, this.audienceInfos_.get(i19));
            }
            if (!getScreenShotBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(13, this.screenShot_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public long getViewer() {
            return this.viewer_;
        }

        public ViewerExt getViewerExt() {
            ViewerExt viewerExt = this.viewerExt_;
            if (viewerExt == null) {
                return ViewerExt.getDefaultInstance();
            }
            return viewerExt;
        }

        public i getViewerExtOrBuilder() {
            return getViewerExt();
        }

        public boolean hasViewerExt() {
            if (this.viewerExt_ != null) {
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
            int hashCode = ((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getRoomId())) * 37) + 2) * 53) + getRoomTitle().hashCode()) * 37) + 3) * 53) + ad.h(getViewer())) * 37) + 4) * 53) + getRoomState();
            if (hasViewerExt()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getViewerExt().hashCode();
            }
            int hashCode2 = (((hashCode * 37) + 6) * 53) + getProgramId().hashCode();
            if (getLiveIconsCount() > 0) {
                hashCode2 = (((hashCode2 * 37) + 7) * 53) + getLiveIconsList().hashCode();
            }
            int hashCode3 = (((((((hashCode2 * 37) + 10) * 53) + getExtraInfo().hashCode()) * 37) + 11) * 53) + getRoomPv().hashCode();
            if (getAudienceInfosCount() > 0) {
                hashCode3 = (((hashCode3 * 37) + 12) * 53) + getAudienceInfosList().hashCode();
            }
            int hashCode4 = (((((hashCode3 * 37) + 13) * 53) + getScreenShot().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode4;
            return hashCode4;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381387f.e(RoomInfo.class, b.class);
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
            return new RoomInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j3 = this.roomId_;
            if (j3 != 0) {
                codedOutputStream.d1(1, j3);
            }
            if (!getRoomTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.roomTitle_);
            }
            long j16 = this.viewer_;
            if (j16 != 0) {
                codedOutputStream.d1(3, j16);
            }
            int i3 = this.roomState_;
            if (i3 != 0) {
                codedOutputStream.b1(4, i3);
            }
            if (this.viewerExt_ != null) {
                codedOutputStream.K0(5, getViewerExt());
            }
            if (!getProgramIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.programId_);
            }
            for (int i16 = 0; i16 < this.liveIcons_.size(); i16++) {
                codedOutputStream.K0(7, this.liveIcons_.get(i16));
            }
            if (!this.extraInfo_.isEmpty()) {
                codedOutputStream.q0(10, this.extraInfo_);
            }
            if (!getRoomPvBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.roomPv_);
            }
            for (int i17 = 0; i17 < this.audienceInfos_.size(); i17++) {
                codedOutputStream.K0(12, this.audienceInfos_.get(i17));
            }
            if (!getScreenShotBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.screenShot_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g {
            private Object C;
            private long D;
            private int E;
            private ViewerExt F;
            private bu<ViewerExt, ViewerExt.b, i> G;
            private Object H;
            private List<LiveIconInfo> I;
            private bp<LiveIconInfo, LiveIconInfo.b, d> J;
            private ByteString K;
            private Object L;
            private List<AudienceInfo> M;
            private bp<AudienceInfo, AudienceInfo.b, c> N;
            private Object P;

            /* renamed from: i, reason: collision with root package name */
            private int f381430i;

            /* renamed from: m, reason: collision with root package name */
            private long f381431m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                    w();
                }
            }

            private void u() {
                if ((this.f381430i & 2) == 0) {
                    this.M = new ArrayList(this.M);
                    this.f381430i |= 2;
                }
            }

            private void v() {
                if ((this.f381430i & 1) == 0) {
                    this.I = new ArrayList(this.I);
                    this.f381430i |= 1;
                }
            }

            private bp<AudienceInfo, AudienceInfo.b, c> w() {
                boolean z16;
                if (this.N == null) {
                    List<AudienceInfo> list = this.M;
                    if ((this.f381430i & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.N = new bp<>(list, z16, h(), isClean());
                    this.M = null;
                }
                return this.N;
            }

            private bp<LiveIconInfo, LiveIconInfo.b, d> y() {
                if (this.J == null) {
                    List<LiveIconInfo> list = this.I;
                    boolean z16 = true;
                    if ((this.f381430i & 1) == 0) {
                        z16 = false;
                    }
                    this.J = new bp<>(list, z16, h(), isClean());
                    this.I = null;
                }
                return this.J;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof RoomInfo) {
                    return B((RoomInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b B(RoomInfo roomInfo) {
                bp<LiveIconInfo, LiveIconInfo.b, d> bpVar;
                if (roomInfo == RoomInfo.getDefaultInstance()) {
                    return this;
                }
                if (roomInfo.getRoomId() != 0) {
                    G(roomInfo.getRoomId());
                }
                if (!roomInfo.getRoomTitle().isEmpty()) {
                    this.C = roomInfo.roomTitle_;
                    onChanged();
                }
                if (roomInfo.getViewer() != 0) {
                    J(roomInfo.getViewer());
                }
                if (roomInfo.getRoomState() != 0) {
                    H(roomInfo.getRoomState());
                }
                if (roomInfo.hasViewerExt()) {
                    D(roomInfo.getViewerExt());
                }
                if (!roomInfo.getProgramId().isEmpty()) {
                    this.H = roomInfo.programId_;
                    onChanged();
                }
                bp<AudienceInfo, AudienceInfo.b, c> bpVar2 = null;
                if (this.J == null) {
                    if (!roomInfo.liveIcons_.isEmpty()) {
                        if (this.I.isEmpty()) {
                            this.I = roomInfo.liveIcons_;
                            this.f381430i &= -2;
                        } else {
                            v();
                            this.I.addAll(roomInfo.liveIcons_);
                        }
                        onChanged();
                    }
                } else if (!roomInfo.liveIcons_.isEmpty()) {
                    if (this.J.j()) {
                        this.J.f();
                        this.J = null;
                        this.I = roomInfo.liveIcons_;
                        this.f381430i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = y();
                        } else {
                            bpVar = null;
                        }
                        this.J = bpVar;
                    } else {
                        this.J.b(roomInfo.liveIcons_);
                    }
                }
                if (roomInfo.getExtraInfo() != ByteString.EMPTY) {
                    E(roomInfo.getExtraInfo());
                }
                if (!roomInfo.getRoomPv().isEmpty()) {
                    this.L = roomInfo.roomPv_;
                    onChanged();
                }
                if (this.N == null) {
                    if (!roomInfo.audienceInfos_.isEmpty()) {
                        if (this.M.isEmpty()) {
                            this.M = roomInfo.audienceInfos_;
                            this.f381430i &= -3;
                        } else {
                            u();
                            this.M.addAll(roomInfo.audienceInfos_);
                        }
                        onChanged();
                    }
                } else if (!roomInfo.audienceInfos_.isEmpty()) {
                    if (this.N.j()) {
                        this.N.f();
                        this.N = null;
                        this.M = roomInfo.audienceInfos_;
                        this.f381430i &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar2 = w();
                        }
                        this.N = bpVar2;
                    } else {
                        this.N.b(roomInfo.audienceInfos_);
                    }
                }
                if (!roomInfo.getScreenShot().isEmpty()) {
                    this.P = roomInfo.screenShot_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) roomInfo).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b D(ViewerExt viewerExt) {
                bu<ViewerExt, ViewerExt.b, i> buVar = this.G;
                if (buVar == null) {
                    ViewerExt viewerExt2 = this.F;
                    if (viewerExt2 != null) {
                        this.F = ViewerExt.newBuilder(viewerExt2).x(viewerExt).buildPartial();
                    } else {
                        this.F = viewerExt;
                    }
                    onChanged();
                } else {
                    buVar.g(viewerExt);
                }
                return this;
            }

            public b E(ByteString byteString) {
                byteString.getClass();
                this.K = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: F, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b G(long j3) {
                this.f381431m = j3;
                onChanged();
                return this;
            }

            public b H(int i3) {
                this.E = i3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: I, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            public b J(long j3) {
                this.D = j3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return cmd0xfb1.f381386e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381387f.e(RoomInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public RoomInfo build() {
                RoomInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public RoomInfo buildPartial() {
                RoomInfo roomInfo = new RoomInfo(this);
                roomInfo.roomId_ = this.f381431m;
                roomInfo.roomTitle_ = this.C;
                roomInfo.viewer_ = this.D;
                roomInfo.roomState_ = this.E;
                bu<ViewerExt, ViewerExt.b, i> buVar = this.G;
                if (buVar == null) {
                    roomInfo.viewerExt_ = this.F;
                } else {
                    roomInfo.viewerExt_ = buVar.b();
                }
                roomInfo.programId_ = this.H;
                bp<LiveIconInfo, LiveIconInfo.b, d> bpVar = this.J;
                if (bpVar != null) {
                    roomInfo.liveIcons_ = bpVar.d();
                } else {
                    if ((this.f381430i & 1) != 0) {
                        this.I = Collections.unmodifiableList(this.I);
                        this.f381430i &= -2;
                    }
                    roomInfo.liveIcons_ = this.I;
                }
                roomInfo.extraInfo_ = this.K;
                roomInfo.roomPv_ = this.L;
                bp<AudienceInfo, AudienceInfo.b, c> bpVar2 = this.N;
                if (bpVar2 != null) {
                    roomInfo.audienceInfos_ = bpVar2.d();
                } else {
                    if ((this.f381430i & 2) != 0) {
                        this.M = Collections.unmodifiableList(this.M);
                        this.f381430i &= -3;
                    }
                    roomInfo.audienceInfos_ = this.M;
                }
                roomInfo.screenShot_ = this.P;
                onBuilt();
                return roomInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381431m = 0L;
                this.C = "";
                this.D = 0L;
                this.E = 0;
                if (this.G == null) {
                    this.F = null;
                } else {
                    this.F = null;
                    this.G = null;
                }
                this.H = "";
                bp<LiveIconInfo, LiveIconInfo.b, d> bpVar = this.J;
                if (bpVar == null) {
                    this.I = Collections.emptyList();
                    this.f381430i &= -2;
                } else {
                    bpVar.e();
                }
                this.K = ByteString.EMPTY;
                this.L = "";
                bp<AudienceInfo, AudienceInfo.b, c> bpVar2 = this.N;
                if (bpVar2 == null) {
                    this.M = Collections.emptyList();
                    this.f381430i &= -3;
                } else {
                    bpVar2.e();
                }
                this.P = "";
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
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public RoomInfo getDefaultInstanceForType() {
                return RoomInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                RoomInfo roomInfo = null;
                try {
                    try {
                        RoomInfo roomInfo2 = (RoomInfo) RoomInfo.f381429e.g(kVar, tVar);
                        if (roomInfo2 != null) {
                            B(roomInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        RoomInfo roomInfo3 = (RoomInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            roomInfo = roomInfo3;
                            if (roomInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (roomInfo != null) {
                        B(roomInfo);
                    }
                    throw th;
                }
            }

            b() {
                this.C = "";
                this.H = "";
                this.I = Collections.emptyList();
                this.K = ByteString.EMPTY;
                this.L = "";
                this.M = Collections.emptyList();
                this.P = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = "";
                this.H = "";
                this.I = Collections.emptyList();
                this.K = ByteString.EMPTY;
                this.L = "";
                this.M = Collections.emptyList();
                this.P = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(RoomInfo roomInfo) {
            return f381428d.toBuilder().B(roomInfo);
        }

        public static RoomInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381429e.m(byteBuffer, tVar);
        }

        RoomInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RoomInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (RoomInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381429e, inputStream, tVar);
        }

        public static RoomInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381429e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public RoomInfo getDefaultInstanceForType() {
            return f381428d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381428d ? new b() : new b().B(this);
        }

        public static RoomInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381429e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        RoomInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.roomTitle_ = "";
            this.programId_ = "";
            this.liveIcons_ = Collections.emptyList();
            this.extraInfo_ = ByteString.EMPTY;
            this.roomPv_ = "";
            this.audienceInfos_ = Collections.emptyList();
            this.screenShot_ = "";
        }

        public static RoomInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381429e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static RoomInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381429e.i(bArr, tVar);
        }

        public static RoomInfo parseFrom(InputStream inputStream) throws IOException {
            return (RoomInfo) GeneratedMessageV3.parseWithIOException(f381429e, inputStream);
        }

        public static RoomInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (RoomInfo) GeneratedMessageV3.parseWithIOException(f381429e, inputStream, tVar);
        }

        public static RoomInfo parseFrom(k kVar) throws IOException {
            return (RoomInfo) GeneratedMessageV3.parseWithIOException(f381429e, kVar);
        }

        public static RoomInfo parseFrom(k kVar, t tVar) throws IOException {
            return (RoomInfo) GeneratedMessageV3.parseWithIOException(f381429e, kVar, tVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0013. Please report as an issue. */
        RoomInfo(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            int i3 = 0;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        switch (J) {
                            case 0:
                                z16 = true;
                            case 8:
                                this.roomId_ = kVar.L();
                            case 18:
                                this.roomTitle_ = kVar.I();
                            case 24:
                                this.viewer_ = kVar.L();
                            case 32:
                                this.roomState_ = kVar.K();
                            case 42:
                                ViewerExt viewerExt = this.viewerExt_;
                                ViewerExt.b builder = viewerExt != null ? viewerExt.toBuilder() : null;
                                ViewerExt viewerExt2 = (ViewerExt) kVar.z(ViewerExt.parser(), tVar);
                                this.viewerExt_ = viewerExt2;
                                if (builder != null) {
                                    builder.x(viewerExt2);
                                    this.viewerExt_ = builder.buildPartial();
                                }
                            case 50:
                                this.programId_ = kVar.I();
                            case 58:
                                if ((i3 & 1) == 0) {
                                    this.liveIcons_ = new ArrayList();
                                    i3 |= 1;
                                }
                                this.liveIcons_.add((LiveIconInfo) kVar.z(LiveIconInfo.parser(), tVar));
                            case 82:
                                this.extraInfo_ = kVar.q();
                            case 90:
                                this.roomPv_ = kVar.I();
                            case 98:
                                if ((i3 & 2) == 0) {
                                    this.audienceInfos_ = new ArrayList();
                                    i3 |= 2;
                                }
                                this.audienceInfos_.add((AudienceInfo) kVar.z(AudienceInfo.parser(), tVar));
                            case 106:
                                this.screenShot_ = kVar.I();
                            default:
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    z16 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i3 & 1) != 0) {
                        this.liveIcons_ = Collections.unmodifiableList(this.liveIcons_);
                    }
                    if ((i3 & 2) != 0) {
                        this.audienceInfos_ = Collections.unmodifiableList(this.audienceInfos_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class StreamInfo extends GeneratedMessageV3 implements h {
        public static final int ANCHOR_ID_FIELD_NUMBER = 2;
        public static final int FLV_URL_FIELD_NUMBER = 3;
        public static final int URL_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final StreamInfo f381432d = new StreamInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<StreamInfo> f381433e = new a();
        private static final long serialVersionUID = 0;
        private long anchorId_;
        private volatile Object flvUrl_;
        private byte memoizedIsInitialized;
        private volatile Object url_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<StreamInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public StreamInfo g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new StreamInfo(kVar, tVar);
            }
        }

        public static StreamInfo getDefaultInstance() {
            return f381432d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381390i;
        }

        public static b newBuilder() {
            return f381432d.toBuilder();
        }

        public static StreamInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StreamInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381433e, inputStream);
        }

        public static StreamInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381433e.d(byteBuffer);
        }

        public static bg<StreamInfo> parser() {
            return f381433e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof StreamInfo)) {
                return super.equals(obj);
            }
            StreamInfo streamInfo = (StreamInfo) obj;
            if (getUrl().equals(streamInfo.getUrl()) && getAnchorId() == streamInfo.getAnchorId() && getFlvUrl().equals(streamInfo.getFlvUrl()) && this.unknownFields.equals(streamInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public long getAnchorId() {
            return this.anchorId_;
        }

        public String getFlvUrl() {
            Object obj = this.flvUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.flvUrl_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFlvUrlBytes() {
            Object obj = this.flvUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.flvUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<StreamInfo> getParserForType() {
            return f381433e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (!getUrlBytes().isEmpty()) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.url_);
            }
            long j3 = this.anchorId_;
            if (j3 != 0) {
                i16 += CodedOutputStream.a0(2, j3);
            }
            if (!getFlvUrlBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(3, this.flvUrl_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i3 = this.memoizedHashCode;
            if (i3 != 0) {
                return i3;
            }
            int hashCode = ((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getUrl().hashCode()) * 37) + 2) * 53) + ad.h(getAnchorId())) * 37) + 3) * 53) + getFlvUrl().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381391j.e(StreamInfo.class, b.class);
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
            return new StreamInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.url_);
            }
            long j3 = this.anchorId_;
            if (j3 != 0) {
                codedOutputStream.d1(2, j3);
            }
            if (!getFlvUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.flvUrl_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements h {
            private Object C;

            /* renamed from: i, reason: collision with root package name */
            private Object f381434i;

            /* renamed from: m, reason: collision with root package name */
            private long f381435m;

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
                return cmd0xfb1.f381390i;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381391j.e(StreamInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public StreamInfo build() {
                StreamInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public StreamInfo buildPartial() {
                StreamInfo streamInfo = new StreamInfo(this);
                streamInfo.url_ = this.f381434i;
                streamInfo.anchorId_ = this.f381435m;
                streamInfo.flvUrl_ = this.C;
                onBuilt();
                return streamInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381434i = "";
                this.f381435m = 0L;
                this.C = "";
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
            public StreamInfo getDefaultInstanceForType() {
                return StreamInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                StreamInfo streamInfo = null;
                try {
                    try {
                        StreamInfo streamInfo2 = (StreamInfo) StreamInfo.f381433e.g(kVar, tVar);
                        if (streamInfo2 != null) {
                            x(streamInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        StreamInfo streamInfo3 = (StreamInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            streamInfo = streamInfo3;
                            if (streamInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (streamInfo != null) {
                        x(streamInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof StreamInfo) {
                    return x((StreamInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(StreamInfo streamInfo) {
                if (streamInfo == StreamInfo.getDefaultInstance()) {
                    return this;
                }
                if (!streamInfo.getUrl().isEmpty()) {
                    this.f381434i = streamInfo.url_;
                    onChanged();
                }
                if (streamInfo.getAnchorId() != 0) {
                    z(streamInfo.getAnchorId());
                }
                if (!streamInfo.getFlvUrl().isEmpty()) {
                    this.C = streamInfo.flvUrl_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) streamInfo).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(long j3) {
                this.f381435m = j3;
                onChanged();
                return this;
            }

            b() {
                this.f381434i = "";
                this.C = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381434i = "";
                this.C = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(StreamInfo streamInfo) {
            return f381432d.toBuilder().x(streamInfo);
        }

        public static StreamInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381433e.m(byteBuffer, tVar);
        }

        StreamInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static StreamInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (StreamInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381433e, inputStream, tVar);
        }

        public static StreamInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381433e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public StreamInfo getDefaultInstanceForType() {
            return f381432d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381432d ? new b() : new b().x(this);
        }

        public static StreamInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381433e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        StreamInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.url_ = "";
            this.flvUrl_ = "";
        }

        public static StreamInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381433e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static StreamInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381433e.i(bArr, tVar);
        }

        public static StreamInfo parseFrom(InputStream inputStream) throws IOException {
            return (StreamInfo) GeneratedMessageV3.parseWithIOException(f381433e, inputStream);
        }

        StreamInfo(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 10) {
                                this.url_ = kVar.I();
                            } else if (J == 16) {
                                this.anchorId_ = kVar.L();
                            } else if (J != 26) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.flvUrl_ = kVar.I();
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static StreamInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (StreamInfo) GeneratedMessageV3.parseWithIOException(f381433e, inputStream, tVar);
        }

        public static StreamInfo parseFrom(k kVar) throws IOException {
            return (StreamInfo) GeneratedMessageV3.parseWithIOException(f381433e, kVar);
        }

        public static StreamInfo parseFrom(k kVar, t tVar) throws IOException {
            return (StreamInfo) GeneratedMessageV3.parseWithIOException(f381433e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ViewerExt extends GeneratedMessageV3 implements i {
        public static final int FAKE_NUM_FIELD_NUMBER = 1;
        public static final int REAL_NUM_FIELD_NUMBER = 2;
        public static final int ROBOT_NUM_FIELD_NUMBER = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final ViewerExt f381436d = new ViewerExt();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ViewerExt> f381437e = new a();
        private static final long serialVersionUID = 0;
        private int fakeNum_;
        private byte memoizedIsInitialized;
        private int realNum_;
        private int robotNum_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ViewerExt> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ViewerExt g(k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ViewerExt(kVar, tVar);
            }
        }

        public static ViewerExt getDefaultInstance() {
            return f381436d;
        }

        public static final Descriptors.b getDescriptor() {
            return cmd0xfb1.f381404w;
        }

        public static b newBuilder() {
            return f381436d.toBuilder();
        }

        public static ViewerExt parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ViewerExt) GeneratedMessageV3.parseDelimitedWithIOException(f381437e, inputStream);
        }

        public static ViewerExt parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381437e.d(byteBuffer);
        }

        public static bg<ViewerExt> parser() {
            return f381437e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ViewerExt)) {
                return super.equals(obj);
            }
            ViewerExt viewerExt = (ViewerExt) obj;
            if (getFakeNum() == viewerExt.getFakeNum() && getRealNum() == viewerExt.getRealNum() && getRobotNum() == viewerExt.getRobotNum() && this.unknownFields.equals(viewerExt.unknownFields)) {
                return true;
            }
            return false;
        }

        public int getFakeNum() {
            return this.fakeNum_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ViewerExt> getParserForType() {
            return f381437e;
        }

        public int getRealNum() {
            return this.realNum_;
        }

        public int getRobotNum() {
            return this.robotNum_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.fakeNum_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.Y(1, i16);
            }
            int i18 = this.realNum_;
            if (i18 != 0) {
                i17 += CodedOutputStream.Y(2, i18);
            }
            int i19 = this.robotNum_;
            if (i19 != 0) {
                i17 += CodedOutputStream.Y(3, i19);
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
            int hashCode = ((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getFakeNum()) * 37) + 2) * 53) + getRealNum()) * 37) + 3) * 53) + getRobotNum()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return cmd0xfb1.f381405x.e(ViewerExt.class, b.class);
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
            return new ViewerExt();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.fakeNum_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            int i16 = this.realNum_;
            if (i16 != 0) {
                codedOutputStream.b1(2, i16);
            }
            int i17 = this.robotNum_;
            if (i17 != 0) {
                codedOutputStream.b1(3, i17);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements i {
            private int C;

            /* renamed from: i, reason: collision with root package name */
            private int f381438i;

            /* renamed from: m, reason: collision with root package name */
            private int f381439m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(int i3) {
                this.f381439m = i3;
                onChanged();
                return this;
            }

            public b C(int i3) {
                this.C = i3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return cmd0xfb1.f381404w;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return cmd0xfb1.f381405x.e(ViewerExt.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ViewerExt build() {
                ViewerExt buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ViewerExt buildPartial() {
                ViewerExt viewerExt = new ViewerExt(this);
                viewerExt.fakeNum_ = this.f381438i;
                viewerExt.realNum_ = this.f381439m;
                viewerExt.robotNum_ = this.C;
                onBuilt();
                return viewerExt;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381438i = 0;
                this.f381439m = 0;
                this.C = 0;
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
            public ViewerExt getDefaultInstanceForType() {
                return ViewerExt.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(k kVar, t tVar) throws IOException {
                ViewerExt viewerExt = null;
                try {
                    try {
                        ViewerExt viewerExt2 = (ViewerExt) ViewerExt.f381437e.g(kVar, tVar);
                        if (viewerExt2 != null) {
                            x(viewerExt2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ViewerExt viewerExt3 = (ViewerExt) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            viewerExt = viewerExt3;
                            if (viewerExt != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (viewerExt != null) {
                        x(viewerExt);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ViewerExt) {
                    return x((ViewerExt) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ViewerExt viewerExt) {
                if (viewerExt == ViewerExt.getDefaultInstance()) {
                    return this;
                }
                if (viewerExt.getFakeNum() != 0) {
                    z(viewerExt.getFakeNum());
                }
                if (viewerExt.getRealNum() != 0) {
                    B(viewerExt.getRealNum());
                }
                if (viewerExt.getRobotNum() != 0) {
                    C(viewerExt.getRobotNum());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) viewerExt).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(int i3) {
                this.f381438i = i3;
                onChanged();
                return this;
            }

            b() {
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ViewerExt viewerExt) {
            return f381436d.toBuilder().x(viewerExt);
        }

        public static ViewerExt parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381437e.m(byteBuffer, tVar);
        }

        ViewerExt(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ViewerExt parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ViewerExt) GeneratedMessageV3.parseDelimitedWithIOException(f381437e, inputStream, tVar);
        }

        public static ViewerExt parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381437e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ViewerExt getDefaultInstanceForType() {
            return f381436d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381436d ? new b() : new b().x(this);
        }

        public static ViewerExt parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381437e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ViewerExt() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ViewerExt parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381437e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ViewerExt parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381437e.i(bArr, tVar);
        }

        ViewerExt(k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        if (J != 0) {
                            if (J == 8) {
                                this.fakeNum_ = kVar.K();
                            } else if (J == 16) {
                                this.realNum_ = kVar.K();
                            } else if (J != 24) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.robotNum_ = kVar.K();
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ViewerExt parseFrom(InputStream inputStream) throws IOException {
            return (ViewerExt) GeneratedMessageV3.parseWithIOException(f381437e, inputStream);
        }

        public static ViewerExt parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ViewerExt) GeneratedMessageV3.parseWithIOException(f381437e, inputStream, tVar);
        }

        public static ViewerExt parseFrom(k kVar) throws IOException {
            return (ViewerExt) GeneratedMessageV3.parseWithIOException(f381437e, kVar);
        }

        public static ViewerExt parseFrom(k kVar, t tVar) throws IOException {
            return (ViewerExt) GeneratedMessageV3.parseWithIOException(f381437e, kVar, tVar);
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

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface e extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface f extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface g extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface h extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface i extends ax {
    }

    static {
        Descriptors.b bVar = q().p().get(0);
        f381382a = bVar;
        f381383b = new GeneratedMessageV3.e(bVar, new String[]{"ResultCode", "ErrMsg", "QueryId", "QueryIdType", "AnchorInfo", "RoomInfo", "StreamInfo", "LiveType", "Platform", "ProgramInfo"});
        Descriptors.b bVar2 = q().p().get(1);
        f381384c = bVar2;
        f381385d = new GeneratedMessageV3.e(bVar2, new String[]{"AnchorName", "AnchorIcon", "IdVerifyTs", "Uint64TinyId", "BytesAvatarMeta"});
        Descriptors.b bVar3 = q().p().get(2);
        f381386e = bVar3;
        f381387f = new GeneratedMessageV3.e(bVar3, new String[]{"RoomId", "RoomTitle", "Viewer", "RoomState", "ViewerExt", "ProgramId", "LiveIcons", "ExtraInfo", "RoomPv", "AudienceInfos", "ScreenShot"});
        Descriptors.b bVar4 = q().p().get(3);
        f381388g = bVar4;
        f381389h = new GeneratedMessageV3.e(bVar4, new String[]{"Uin", "Icon", "BytesAvatarMeta"});
        Descriptors.b bVar5 = q().p().get(4);
        f381390i = bVar5;
        f381391j = new GeneratedMessageV3.e(bVar5, new String[]{"Url", "AnchorId", "FlvUrl"});
        Descriptors.b bVar6 = q().p().get(5);
        f381392k = bVar6;
        f381393l = new GeneratedMessageV3.e(bVar6, new String[]{"Url", "Bitrate", "Format"});
        Descriptors.b bVar7 = q().p().get(6);
        f381394m = bVar7;
        f381395n = new GeneratedMessageV3.e(bVar7, new String[]{"Level", "Addresses", "Definition", "CodecType"});
        Descriptors.b bVar8 = q().p().get(7);
        f381396o = bVar8;
        f381397p = new GeneratedMessageV3.e(bVar8, new String[]{"Frames", "Name", "RawLevel", "DelayFrame", "StreamId"});
        Descriptors.b bVar9 = q().p().get(8);
        f381398q = bVar9;
        f381399r = new GeneratedMessageV3.e(bVar9, new String[]{"Url", "AnchorId", "FlvUrl", "RoomId", "Streams"});
        Descriptors.b bVar10 = q().p().get(9);
        f381400s = bVar10;
        f381401t = new GeneratedMessageV3.e(bVar10, new String[]{"Ratio", "Icon"});
        Descriptors.b bVar11 = q().p().get(10);
        f381402u = bVar11;
        f381403v = new GeneratedMessageV3.e(bVar11, new String[]{"ProgramId", "LiveTitle", "AnchorName", "Logo", "TabId"});
        Descriptors.b bVar12 = q().p().get(11);
        f381404w = bVar12;
        f381405x = new GeneratedMessageV3.e(bVar12, new String[]{"FakeNum", "RealNum", "RobotNum"});
        Descriptors.b bVar13 = q().p().get(12);
        f381406y = bVar13;
        f381407z = new GeneratedMessageV3.e(bVar13, new String[]{"RptLiveRoomViewer"});
        Descriptors.b bVar14 = q().p().get(13);
        A = bVar14;
        B = new GeneratedMessageV3.e(bVar14, new String[]{"RoomId", "ViewerNum"});
        Descriptors.b bVar15 = q().p().get(14);
        C = bVar15;
        D = new GeneratedMessageV3.e(bVar15, new String[0]);
        Descriptors.b bVar16 = q().p().get(15);
        E = bVar16;
        F = new GeneratedMessageV3.e(bVar16, new String[]{"Filter", "RoomId"});
        Descriptors.b bVar17 = q().p().get(16);
        G = bVar17;
        H = new GeneratedMessageV3.e(bVar17, new String[]{"RoomTitle"});
        Descriptors.b bVar18 = q().p().get(17);
        I = bVar18;
        J = new GeneratedMessageV3.e(bVar18, new String[]{"IsNeedRoomTitle"});
        Descriptors.b bVar19 = q().p().get(18);
        K = bVar19;
        L = new GeneratedMessageV3.e(bVar19, new String[]{"NeedStreamInfo", "RoomInfoFilter"});
        Descriptors.b bVar20 = q().p().get(19);
        M = bVar20;
        N = new GeneratedMessageV3.e(bVar20, new String[]{"NeedRoomPv", "NeedAudienceInfos", "NeedScreenShot", "NeedRoomTitle", "NeedLiveIcons"});
    }

    public static Descriptors.FileDescriptor q() {
        return O;
    }
}
