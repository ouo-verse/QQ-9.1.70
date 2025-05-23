package com.tencent.trpcprotocol.group_pro.recommend.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.ad;
import com.google.protobuf.ag;
import com.google.protobuf.ah;
import com.google.protobuf.ar;
import com.google.protobuf.ax;
import com.google.protobuf.bg;
import com.google.protobuf.bk;
import com.google.protobuf.bl;
import com.google.protobuf.bp;
import com.google.protobuf.bu;
import com.google.protobuf.cc;
import com.google.protobuf.t;
import com.tencent.trpcprotocol.group_pro.guild_recommend_channel.guild_recommend_channel.guildRecommendChannel;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class common {
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
    private static Descriptors.FileDescriptor O = Descriptors.FileDescriptor.u(new String[]{"\n\fcommon.proto\u0012\u0018trpc.group_pro.recommend\"\u0097\u0005\n\rRecommendItem\u0012\u000f\n\u0007item_id\u0018\u0001 \u0001(\t\u00125\n\titem_type\u0018\u0002 \u0001(\u000e2\".trpc.group_pro.recommend.ItemType\u0012;\n\fchannel_info\u0018\u0003 \u0001(\u000b2%.trpc.group_pro.recommend.ChannelInfo\u0012B\n\flive_channel\u0018\u0004 \u0001(\u000b2,.trpc.group_pro.recommend.RCGuildLiveChannel\u0012D\n\rvoice_channel\u0018\u0005 \u0001(\u000b2-.trpc.group_pro.recommend.RCGuildVoiceChannel\u0012,\n\u0004feed\u0018\u0006 \u0001(\u000b2\u001e.trpc.group_pro.recommend.Feed\u0012\u0016\n\u000eitem_id_uint64\u0018\b \u0001(\u0004\u00126\n\ncategories\u0018\t \u0003(\u000b2\".trpc.group_pro.recommend.Category\u0012?\n\u000eh5game_channel\u0018\n \u0001(\u000b2'.trpc.group_pro.recommend.H5GameChannel\u00121\n\u0007ad_info\u0018\u000b \u0001(\u000b2 .trpc.group_pro.recommend.AdInfo\u0012=\n\rforum_channel\u0018\f \u0001(\u000b2&.trpc.group_pro.recommend.ForumChannel\u0012F\n\u000evoice_template\u0018\r \u0001(\u000b2..trpc.group_pro.recommend.VoiceTemplateChannel\"_\n\bCategory\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bcategory_id\u0018\u0002 \u0001(\u0005\u0012\u0010\n\bgroup_id\u0018\u0003 \u0001(\t\u0012\u0010\n\bhas_more\u0018\u0004 \u0001(\b\u0012\f\n\u0004type\u0018\u0005 \u0001(\t\"\u00d5\u0001\n\u000bChannelInfo\u0012\u0010\n\bguild_id\u0018\u0001 \u0001(\u0004\u0012\u0012\n\nguild_name\u0018\u0002 \u0001(\t\u0012\u0012\n\nguild_icon\u0018\u0003 \u0001(\t\u0012\u0015\n\rguild_profile\u0018\u0004 \u0001(\t\u00128\n\nstate_list\u0018\u0005 \u0003(\u000b2$.trpc.group_pro.recommend.GuildState\u0012\u0012\n\nshare_link\u0018\u0006 \u0001(\t\u0012\u0014\n\fjoined_guild\u0018\u0007 \u0001(\r\u0012\u0011\n\tcover_url\u0018\b \u0001(\t\"<\n\nGuildState\u0012\r\n\u0005state\u0018\u0001 \u0001(\r\u0012\f\n\u0004desc\u0018\u0002 \u0001(\t\u0012\u0011\n\ticon_urls\u0018\u0003 \u0003(\t\"y\n\u0012RCGuildLiveChannel\u0012/\n\bmsg_list\u0018\u0002 \u0003(\u000b2\u001d.trpc.group_pro.recommend.Msg\u00122\n\u0005cover\u0018\u0003 \u0001(\u000b2#.trpc.group_pro.recommend.CoverInfo\"@\n\tCoverInfo\u0012\f\n\u0004type\u0018\u0001 \u0001(\r\u0012\u0011\n\timage_url\u0018\u0002 \u0001(\t\u0012\u0012\n\nstream_url\u0018\u0003 \u0001(\t\"\\\n\u0003Msg\u0012\u000e\n\u0006tinyid\u0018\u0001 \u0001(\u0004\u0012\u0011\n\tnick_name\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006avatar\u0018\u0003 \u0001(\f\u0012\u000f\n\u0007msg_seq\u0018\u0004 \u0001(\u0004\u0012\u0011\n\trich_text\u0018\u0005 \u0001(\f\"I\n\u0013RCGuildVoiceChannel\u00122\n\u0005cover\u0018\u0002 \u0001(\u000b2#.trpc.group_pro.recommend.CoverInfo\"I\n\u0013RGGuildWorldChannel\u00122\n\u0005cover\u0018\u0002 \u0001(\u000b2#.trpc.group_pro.recommend.CoverInfo\"M\n\u0004Feed\u0012\f\n\u0004data\u0018\u0001 \u0001(\f\u00127\n\nshare_info\u0018\u0002 \u0001(\u000b2#.trpc.group_pro.recommend.ShareInfo\"3\n\tShareInfo\u0012\u0012\n\nshare_type\u0018\u0001 \u0001(\r\u0012\u0012\n\nshare_link\u0018\u0002 \u0001(\t\"s\n\rH5GameChannel\u0012.\n\u0004data\u0018\u0001 \u0001(\u000b2 .trpc.group_pro.recommend.H5Game\u00122\n\u0005cover\u0018\u0002 \u0001(\u000b2#.trpc.group_pro.recommend.CoverInfo\"\u00d1\u0001\n\u0006H5Game\u0012\u000f\n\u0007team_id\u0018\u0001 \u0001(\u0004\u00129\n\u000bteam_status\u0018\u0002 \u0001(\u000e2$.trpc.group_pro.recommend.TeamStatus\u00120\n\u0004game\u0018\u0003 \u0001(\u000b2\".trpc.group_pro.recommend.GameInfo\u0012.\n\u0007members\u0018\u0004 \u0003(\u000b2\u001d.trpc.group_pro.recommend.Msg\u0012\u0019\n\u0011ready_expire_time\u0018\u0005 \u0001(\u0003\"i\n\bGameInfo\u0012\n\n\u0002id\u0018\u0001 \u0001(\u0005\u0012\f\n\u0004name\u0018\u0002 \u0001(\t\u0012\f\n\u0004icon\u0018\u0003 \u0001(\t\u00125\n\tmode_info\u0018\u0004 \u0001(\u000b2\".trpc.group_pro.recommend.ModeInfo\"Q\n\bModeInfo\u0012\u000f\n\u0007mode_id\u0018\u0001 \u0001(\u0005\u0012\u0011\n\tmode_name\u0018\u0002 \u0001(\t\u0012\r\n\u0005is_pk\u0018\u0003 \u0001(\b\u0012\u0012\n\nplayer_num\u0018\u0004 \u0001(\u0005\"i\n\u0006AdInfo\u0012\r\n\u0005title\u0018\u0001 \u0001(\t\u0012\u0011\n\tsub_title\u0018\u0002 \u0001(\t\u0012\u000b\n\u0003tag\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007pic_url\u0018\u0004 \u0001(\t\u0012\u0010\n\bjump_url\u0018\u0005 \u0001(\t\u0012\r\n\u0005ad_id\u0018\u0006 \u0001(\u0005\"2\n\u0010ForumChannelInfo\u0012\u0010\n\bfeed_num\u0018\u0001 \u0001(\r\u0012\f\n\u0004imgs\u0018\u0002 \u0003(\t\"\u0097\u0002\n\u0014VoiceTemplateChannel\u00122\n\u0005cover\u0018\u0001 \u0001(\u000b2#.trpc.group_pro.recommend.CoverInfo\u0012\u0013\n\u000bstatus_desc\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bstatus_icon\u0018\u0003 \u0001(\t\u0012<\n\u0007members\u0018\u0004 \u0003(\u000b2+.trpc.group_pro.recommend.RCGuildMemberInfo\u0012\f\n\u0004name\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006status\u0018\u0006 \u0001(\u0005\u0012\f\n\u0004icon\u0018\u0007 \u0001(\t\u0012\u0011\n\tplay_desc\u0018\b \u0001(\t\u0012\u0013\n\u000bcurrent_num\u0018\t \u0001(\r\u0012\u000f\n\u0007max_num\u0018\n \u0001(\r\"I\n\u0011RCGuildMemberInfo\u0012\u000f\n\u0007tiny_id\u0018\u0001 \u0001(\u0004\u0012\u000e\n\u0006gender\u0018\u0002 \u0001(\r\u0012\u0013\n\u000bavatar_meta\u0018\u0003 \u0001(\f\"\u00a8\u0001\n\fForumChannel\u0012\u0013\n\u000bhotfeed_num\u0018\u0001 \u0001(\r\u0012\r\n\u0005index\u0018\u0002 \u0001(\u0005\u0012\u0017\n\u000fhot_value_title\u0018\u0003 \u0001(\t\u0012\f\n\u0004type\u0018\u0004 \u0001(\r\u0012\u0013\n\u000bstart_color\u0018\u0005 \u0001(\r\u0012\u0011\n\tend_color\u0018\u0006 \u0001(\r\u0012\u0010\n\bhot_icon\u0018\u0007 \u0001(\t\u0012\u0013\n\u000binvite_code\u0018\b \u0001(\t*\u00f2\u0002\n\bItemType\u0012\u000f\n\u000bTYPE_UNKOWN\u0010\u0000\u0012\r\n\tTYPE_FEED\u0010\u0001\u0012\r\n\tTYPE_LIVE\u0010\u0002\u0012\u000e\n\nTYPE_VOICE\u0010\u0003\u0012\u001b\n\u0017TYPE_VOICE_SCREEN_SHARE\u0010\u0004\u0012\u0014\n\u0010TYPE_VOICE_SMOBA\u0010\u0005\u0012\u000e\n\nTYPE_WORLD\u0010\u0006\u0012\u0010\n\fTYPE_CHANNEL\u0010\u0007\u0012\u000e\n\nTYPE_GUILD\u0010\b\u0012\u000f\n\u000bTYPE_H5GAME\u0010\t\u0012\f\n\bTYPE_KTV\u0010\n\u0012\u0013\n\u000fTYPE_VOICE_PLAY\u0010\u000b\u0012\u0014\n\u0010TYPE_VOICE_LOBBY\u0010\f\u0012\u0010\n\fTYPE_SUBJECT\u0010\r\u0012\u000e\n\nTYPE_FORUM\u0010\u000e\u0012\u0015\n\u0011TYPE_SUBJECT_CARD\u0010\u000f\u0012\u0013\n\u000fTYPE_QUICK_JOIN\u0010\u0010\u0012\u0016\n\u0012TYPE_GUILD_CHANNEL\u0010\u0011\u0012\u0012\n\u000eTYPE_VOICE_ALL\u0010d*\u0086\u0001\n\nTeamStatus\u0012\u0014\n\u0010TEAM_STATUS_INIT\u0010\u0000\u0012\u0014\n\u0010TEAM_STATUS_IDLE\u0010\u0001\u0012\u0018\n\u0014TEAM_STATUS_STARTING\u0010\u0002\u0012\u0017\n\u0013TEAM_STATUS_IN_GAME\u0010\u0003\u0012\u0019\n\u0015TEAM_STATUS_GAME_OVER\u0010\nBx\n3com.tencent.trpcprotocol.group_pro.recommend.commonB\u0006commonP\u0000Z7git.code.oa.com/trpcprotocol/group_pro/recommend_commonb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.b f381475a;

    /* renamed from: b, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381476b;

    /* renamed from: c, reason: collision with root package name */
    private static final Descriptors.b f381477c;

    /* renamed from: d, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381478d;

    /* renamed from: e, reason: collision with root package name */
    private static final Descriptors.b f381479e;

    /* renamed from: f, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381480f;

    /* renamed from: g, reason: collision with root package name */
    private static final Descriptors.b f381481g;

    /* renamed from: h, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381482h;

    /* renamed from: i, reason: collision with root package name */
    private static final Descriptors.b f381483i;

    /* renamed from: j, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381484j;

    /* renamed from: k, reason: collision with root package name */
    private static final Descriptors.b f381485k;

    /* renamed from: l, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381486l;

    /* renamed from: m, reason: collision with root package name */
    private static final Descriptors.b f381487m;

    /* renamed from: n, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381488n;

    /* renamed from: o, reason: collision with root package name */
    private static final Descriptors.b f381489o;

    /* renamed from: p, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381490p;

    /* renamed from: q, reason: collision with root package name */
    private static final Descriptors.b f381491q;

    /* renamed from: r, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381492r;

    /* renamed from: s, reason: collision with root package name */
    private static final Descriptors.b f381493s;

    /* renamed from: t, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381494t;

    /* renamed from: u, reason: collision with root package name */
    private static final Descriptors.b f381495u;

    /* renamed from: v, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381496v;

    /* renamed from: w, reason: collision with root package name */
    private static final Descriptors.b f381497w;

    /* renamed from: x, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381498x;

    /* renamed from: y, reason: collision with root package name */
    private static final Descriptors.b f381499y;

    /* renamed from: z, reason: collision with root package name */
    private static final GeneratedMessageV3.e f381500z;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class AdInfo extends GeneratedMessageV3 implements b {
        public static final int AD_ID_FIELD_NUMBER = 6;
        public static final int JUMP_URL_FIELD_NUMBER = 5;
        public static final int PIC_URL_FIELD_NUMBER = 4;
        public static final int SUB_TITLE_FIELD_NUMBER = 2;
        public static final int TAG_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final AdInfo f381501d = new AdInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<AdInfo> f381502e = new a();
        private static final long serialVersionUID = 0;
        private int adId_;
        private volatile Object jumpUrl_;
        private byte memoizedIsInitialized;
        private volatile Object picUrl_;
        private volatile Object subTitle_;
        private volatile Object tag_;
        private volatile Object title_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<AdInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public AdInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new AdInfo(kVar, tVar);
            }
        }

        public static AdInfo getDefaultInstance() {
            return f381501d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.E;
        }

        public static b newBuilder() {
            return f381501d.toBuilder();
        }

        public static AdInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381502e, inputStream);
        }

        public static AdInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381502e.d(byteBuffer);
        }

        public static bg<AdInfo> parser() {
            return f381502e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdInfo)) {
                return super.equals(obj);
            }
            AdInfo adInfo = (AdInfo) obj;
            if (getTitle().equals(adInfo.getTitle()) && getSubTitle().equals(adInfo.getSubTitle()) && getTag().equals(adInfo.getTag()) && getPicUrl().equals(adInfo.getPicUrl()) && getJumpUrl().equals(adInfo.getJumpUrl()) && getAdId() == adInfo.getAdId() && this.unknownFields.equals(adInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public int getAdId() {
            return this.adId_;
        }

        public String getJumpUrl() {
            Object obj = this.jumpUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.jumpUrl_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getJumpUrlBytes() {
            Object obj = this.jumpUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.jumpUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<AdInfo> getParserForType() {
            return f381502e;
        }

        public String getPicUrl() {
            Object obj = this.picUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.picUrl_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getPicUrlBytes() {
            Object obj = this.picUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.picUrl_ = copyFromUtf8;
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
            if (!getTitleBytes().isEmpty()) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.title_);
            }
            if (!getSubTitleBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(2, this.subTitle_);
            }
            if (!getTagBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(3, this.tag_);
            }
            if (!getPicUrlBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(4, this.picUrl_);
            }
            if (!getJumpUrlBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(5, this.jumpUrl_);
            }
            int i17 = this.adId_;
            if (i17 != 0) {
                i16 += CodedOutputStream.x(6, i17);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getSubTitle() {
            Object obj = this.subTitle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subTitle_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSubTitleBytes() {
            Object obj = this.subTitle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.subTitle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getTag() {
            Object obj = this.tag_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.tag_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getTagBytes() {
            Object obj = this.tag_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.tag_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getTitle().hashCode()) * 37) + 2) * 53) + getSubTitle().hashCode()) * 37) + 3) * 53) + getTag().hashCode()) * 37) + 4) * 53) + getPicUrl().hashCode()) * 37) + 5) * 53) + getJumpUrl().hashCode()) * 37) + 6) * 53) + getAdId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.F.e(AdInfo.class, b.class);
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
            return new AdInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.title_);
            }
            if (!getSubTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.subTitle_);
            }
            if (!getTagBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.tag_);
            }
            if (!getPicUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.picUrl_);
            }
            if (!getJumpUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.jumpUrl_);
            }
            int i3 = this.adId_;
            if (i3 != 0) {
                codedOutputStream.G0(6, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {
            private Object C;
            private Object D;
            private Object E;
            private int F;

            /* renamed from: i, reason: collision with root package name */
            private Object f381503i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381504m;

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
                return common.E;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.F.e(AdInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public AdInfo build() {
                AdInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public AdInfo buildPartial() {
                AdInfo adInfo = new AdInfo(this);
                adInfo.title_ = this.f381503i;
                adInfo.subTitle_ = this.f381504m;
                adInfo.tag_ = this.C;
                adInfo.picUrl_ = this.D;
                adInfo.jumpUrl_ = this.E;
                adInfo.adId_ = this.F;
                onBuilt();
                return adInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381503i = "";
                this.f381504m = "";
                this.C = "";
                this.D = "";
                this.E = "";
                this.F = 0;
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
            public AdInfo getDefaultInstanceForType() {
                return AdInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                AdInfo adInfo = null;
                try {
                    try {
                        AdInfo adInfo2 = (AdInfo) AdInfo.f381502e.g(kVar, tVar);
                        if (adInfo2 != null) {
                            x(adInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        AdInfo adInfo3 = (AdInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            adInfo = adInfo3;
                            if (adInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (adInfo != null) {
                        x(adInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof AdInfo) {
                    return x((AdInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(AdInfo adInfo) {
                if (adInfo == AdInfo.getDefaultInstance()) {
                    return this;
                }
                if (!adInfo.getTitle().isEmpty()) {
                    this.f381503i = adInfo.title_;
                    onChanged();
                }
                if (!adInfo.getSubTitle().isEmpty()) {
                    this.f381504m = adInfo.subTitle_;
                    onChanged();
                }
                if (!adInfo.getTag().isEmpty()) {
                    this.C = adInfo.tag_;
                    onChanged();
                }
                if (!adInfo.getPicUrl().isEmpty()) {
                    this.D = adInfo.picUrl_;
                    onChanged();
                }
                if (!adInfo.getJumpUrl().isEmpty()) {
                    this.E = adInfo.jumpUrl_;
                    onChanged();
                }
                if (adInfo.getAdId() != 0) {
                    z(adInfo.getAdId());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) adInfo).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(int i3) {
                this.F = i3;
                onChanged();
                return this;
            }

            b() {
                this.f381503i = "";
                this.f381504m = "";
                this.C = "";
                this.D = "";
                this.E = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381503i = "";
                this.f381504m = "";
                this.C = "";
                this.D = "";
                this.E = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(AdInfo adInfo) {
            return f381501d.toBuilder().x(adInfo);
        }

        public static AdInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381502e.m(byteBuffer, tVar);
        }

        AdInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AdInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (AdInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381502e, inputStream, tVar);
        }

        public static AdInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381502e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public AdInfo getDefaultInstanceForType() {
            return f381501d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381501d ? new b() : new b().x(this);
        }

        public static AdInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381502e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        AdInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.title_ = "";
            this.subTitle_ = "";
            this.tag_ = "";
            this.picUrl_ = "";
            this.jumpUrl_ = "";
        }

        public static AdInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381502e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static AdInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381502e.i(bArr, tVar);
        }

        public static AdInfo parseFrom(InputStream inputStream) throws IOException {
            return (AdInfo) GeneratedMessageV3.parseWithIOException(f381502e, inputStream);
        }

        public static AdInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (AdInfo) GeneratedMessageV3.parseWithIOException(f381502e, inputStream, tVar);
        }

        public static AdInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (AdInfo) GeneratedMessageV3.parseWithIOException(f381502e, kVar);
        }

        AdInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.title_ = kVar.I();
                            } else if (J == 18) {
                                this.subTitle_ = kVar.I();
                            } else if (J == 26) {
                                this.tag_ = kVar.I();
                            } else if (J == 34) {
                                this.picUrl_ = kVar.I();
                            } else if (J == 42) {
                                this.jumpUrl_ = kVar.I();
                            } else if (J != 48) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.adId_ = kVar.x();
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

        public static AdInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (AdInfo) GeneratedMessageV3.parseWithIOException(f381502e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Category extends GeneratedMessageV3 implements c {
        public static final int CATEGORY_ID_FIELD_NUMBER = 2;
        public static final int GROUP_ID_FIELD_NUMBER = 3;
        public static final int HAS_MORE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 5;

        /* renamed from: d, reason: collision with root package name */
        private static final Category f381505d = new Category();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<Category> f381506e = new a();
        private static final long serialVersionUID = 0;
        private int categoryId_;
        private volatile Object groupId_;
        private boolean hasMore_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object type_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<Category> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public Category g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new Category(kVar, tVar);
            }
        }

        public static Category getDefaultInstance() {
            return f381505d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381477c;
        }

        public static b newBuilder() {
            return f381505d.toBuilder();
        }

        public static Category parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Category) GeneratedMessageV3.parseDelimitedWithIOException(f381506e, inputStream);
        }

        public static Category parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381506e.d(byteBuffer);
        }

        public static bg<Category> parser() {
            return f381506e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Category)) {
                return super.equals(obj);
            }
            Category category = (Category) obj;
            if (getName().equals(category.getName()) && getCategoryId() == category.getCategoryId() && getGroupId().equals(category.getGroupId()) && getHasMore() == category.getHasMore() && getType().equals(category.getType()) && this.unknownFields.equals(category.unknownFields)) {
                return true;
            }
            return false;
        }

        public int getCategoryId() {
            return this.categoryId_;
        }

        public String getGroupId() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.groupId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getGroupIdBytes() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.groupId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean getHasMore() {
            return this.hasMore_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<Category> getParserForType() {
            return f381506e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (!getNameBytes().isEmpty()) {
                i16 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            int i17 = this.categoryId_;
            if (i17 != 0) {
                i16 += CodedOutputStream.x(2, i17);
            }
            if (!getGroupIdBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(3, this.groupId_);
            }
            boolean z16 = this.hasMore_;
            if (z16) {
                i16 += CodedOutputStream.e(4, z16);
            }
            if (!getTypeBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(5, this.type_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getCategoryId()) * 37) + 3) * 53) + getGroupId().hashCode()) * 37) + 4) * 53) + ad.c(getHasMore())) * 37) + 5) * 53) + getType().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381478d.e(Category.class, b.class);
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
            return new Category();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            int i3 = this.categoryId_;
            if (i3 != 0) {
                codedOutputStream.G0(2, i3);
            }
            if (!getGroupIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.groupId_);
            }
            boolean z16 = this.hasMore_;
            if (z16) {
                codedOutputStream.m0(4, z16);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.type_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {
            private Object C;
            private boolean D;
            private Object E;

            /* renamed from: i, reason: collision with root package name */
            private Object f381507i;

            /* renamed from: m, reason: collision with root package name */
            private int f381508m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(boolean z16) {
                this.D = z16;
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
                return common.f381477c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381478d.e(Category.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public Category build() {
                Category buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public Category buildPartial() {
                Category category = new Category(this);
                category.name_ = this.f381507i;
                category.categoryId_ = this.f381508m;
                category.groupId_ = this.C;
                category.hasMore_ = this.D;
                category.type_ = this.E;
                onBuilt();
                return category;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381507i = "";
                this.f381508m = 0;
                this.C = "";
                this.D = false;
                this.E = "";
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
            public Category getDefaultInstanceForType() {
                return Category.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                Category category = null;
                try {
                    try {
                        Category category2 = (Category) Category.f381506e.g(kVar, tVar);
                        if (category2 != null) {
                            x(category2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        Category category3 = (Category) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            category = category3;
                            if (category != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (category != null) {
                        x(category);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof Category) {
                    return x((Category) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(Category category) {
                if (category == Category.getDefaultInstance()) {
                    return this;
                }
                if (!category.getName().isEmpty()) {
                    this.f381507i = category.name_;
                    onChanged();
                }
                if (category.getCategoryId() != 0) {
                    z(category.getCategoryId());
                }
                if (!category.getGroupId().isEmpty()) {
                    this.C = category.groupId_;
                    onChanged();
                }
                if (category.getHasMore()) {
                    B(category.getHasMore());
                }
                if (!category.getType().isEmpty()) {
                    this.E = category.type_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) category).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(int i3) {
                this.f381508m = i3;
                onChanged();
                return this;
            }

            b() {
                this.f381507i = "";
                this.C = "";
                this.E = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381507i = "";
                this.C = "";
                this.E = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(Category category) {
            return f381505d.toBuilder().x(category);
        }

        public static Category parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381506e.m(byteBuffer, tVar);
        }

        Category(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Category parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (Category) GeneratedMessageV3.parseDelimitedWithIOException(f381506e, inputStream, tVar);
        }

        public static Category parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381506e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public Category getDefaultInstanceForType() {
            return f381505d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381505d ? new b() : new b().x(this);
        }

        public static Category parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381506e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        Category() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.groupId_ = "";
            this.type_ = "";
        }

        public static Category parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381506e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static Category parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381506e.i(bArr, tVar);
        }

        public static Category parseFrom(InputStream inputStream) throws IOException {
            return (Category) GeneratedMessageV3.parseWithIOException(f381506e, inputStream);
        }

        public static Category parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (Category) GeneratedMessageV3.parseWithIOException(f381506e, inputStream, tVar);
        }

        Category(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                    this.name_ = kVar.I();
                                } else if (J == 16) {
                                    this.categoryId_ = kVar.x();
                                } else if (J == 26) {
                                    this.groupId_ = kVar.I();
                                } else if (J == 32) {
                                    this.hasMore_ = kVar.p();
                                } else if (J != 42) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.type_ = kVar.I();
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

        public static Category parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (Category) GeneratedMessageV3.parseWithIOException(f381506e, kVar);
        }

        public static Category parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (Category) GeneratedMessageV3.parseWithIOException(f381506e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ChannelInfo extends GeneratedMessageV3 implements d {
        public static final int COVER_URL_FIELD_NUMBER = 8;
        public static final int GUILD_ICON_FIELD_NUMBER = 3;
        public static final int GUILD_ID_FIELD_NUMBER = 1;
        public static final int GUILD_NAME_FIELD_NUMBER = 2;
        public static final int GUILD_PROFILE_FIELD_NUMBER = 4;
        public static final int JOINED_GUILD_FIELD_NUMBER = 7;
        public static final int SHARE_LINK_FIELD_NUMBER = 6;
        public static final int STATE_LIST_FIELD_NUMBER = 5;

        /* renamed from: d, reason: collision with root package name */
        private static final ChannelInfo f381509d = new ChannelInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ChannelInfo> f381510e = new a();
        private static final long serialVersionUID = 0;
        private volatile Object coverUrl_;
        private volatile Object guildIcon_;
        private long guildId_;
        private volatile Object guildName_;
        private volatile Object guildProfile_;
        private int joinedGuild_;
        private byte memoizedIsInitialized;
        private volatile Object shareLink_;
        private List<GuildState> stateList_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ChannelInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ChannelInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ChannelInfo(kVar, tVar);
            }
        }

        public static ChannelInfo getDefaultInstance() {
            return f381509d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381479e;
        }

        public static b newBuilder() {
            return f381509d.toBuilder();
        }

        public static ChannelInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChannelInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381510e, inputStream);
        }

        public static ChannelInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381510e.d(byteBuffer);
        }

        public static bg<ChannelInfo> parser() {
            return f381510e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChannelInfo)) {
                return super.equals(obj);
            }
            ChannelInfo channelInfo = (ChannelInfo) obj;
            if (getGuildId() == channelInfo.getGuildId() && getGuildName().equals(channelInfo.getGuildName()) && getGuildIcon().equals(channelInfo.getGuildIcon()) && getGuildProfile().equals(channelInfo.getGuildProfile()) && getStateListList().equals(channelInfo.getStateListList()) && getShareLink().equals(channelInfo.getShareLink()) && getJoinedGuild() == channelInfo.getJoinedGuild() && getCoverUrl().equals(channelInfo.getCoverUrl()) && this.unknownFields.equals(channelInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getCoverUrl() {
            Object obj = this.coverUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.coverUrl_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCoverUrlBytes() {
            Object obj = this.coverUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.coverUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getGuildIcon() {
            Object obj = this.guildIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.guildIcon_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getGuildIconBytes() {
            Object obj = this.guildIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.guildIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public long getGuildId() {
            return this.guildId_;
        }

        public String getGuildName() {
            Object obj = this.guildName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.guildName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getGuildNameBytes() {
            Object obj = this.guildName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.guildName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getGuildProfile() {
            Object obj = this.guildProfile_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.guildProfile_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getGuildProfileBytes() {
            Object obj = this.guildProfile_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.guildProfile_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getJoinedGuild() {
            return this.joinedGuild_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ChannelInfo> getParserForType() {
            return f381510e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            long j3 = this.guildId_;
            if (j3 != 0) {
                i3 = CodedOutputStream.a0(1, j3) + 0;
            } else {
                i3 = 0;
            }
            if (!getGuildNameBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(2, this.guildName_);
            }
            if (!getGuildIconBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(3, this.guildIcon_);
            }
            if (!getGuildProfileBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(4, this.guildProfile_);
            }
            for (int i17 = 0; i17 < this.stateList_.size(); i17++) {
                i3 += CodedOutputStream.G(5, this.stateList_.get(i17));
            }
            if (!getShareLinkBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(6, this.shareLink_);
            }
            int i18 = this.joinedGuild_;
            if (i18 != 0) {
                i3 += CodedOutputStream.Y(7, i18);
            }
            if (!getCoverUrlBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(8, this.coverUrl_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getShareLink() {
            Object obj = this.shareLink_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.shareLink_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getShareLinkBytes() {
            Object obj = this.shareLink_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.shareLink_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GuildState getStateList(int i3) {
            return this.stateList_.get(i3);
        }

        public int getStateListCount() {
            return this.stateList_.size();
        }

        public List<GuildState> getStateListList() {
            return this.stateList_;
        }

        public i getStateListOrBuilder(int i3) {
            return this.stateList_.get(i3);
        }

        public List<? extends i> getStateListOrBuilderList() {
            return this.stateList_;
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
            int hashCode = ((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getGuildId())) * 37) + 2) * 53) + getGuildName().hashCode()) * 37) + 3) * 53) + getGuildIcon().hashCode()) * 37) + 4) * 53) + getGuildProfile().hashCode();
            if (getStateListCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getStateListList().hashCode();
            }
            int hashCode2 = (((((((((((((hashCode * 37) + 6) * 53) + getShareLink().hashCode()) * 37) + 7) * 53) + getJoinedGuild()) * 37) + 8) * 53) + getCoverUrl().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381480f.e(ChannelInfo.class, b.class);
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
            return new ChannelInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j3 = this.guildId_;
            if (j3 != 0) {
                codedOutputStream.d1(1, j3);
            }
            if (!getGuildNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.guildName_);
            }
            if (!getGuildIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.guildIcon_);
            }
            if (!getGuildProfileBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.guildProfile_);
            }
            for (int i3 = 0; i3 < this.stateList_.size(); i3++) {
                codedOutputStream.K0(5, this.stateList_.get(i3));
            }
            if (!getShareLinkBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.shareLink_);
            }
            int i16 = this.joinedGuild_;
            if (i16 != 0) {
                codedOutputStream.b1(7, i16);
            }
            if (!getCoverUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.coverUrl_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements d {
            private Object C;
            private Object D;
            private Object E;
            private List<GuildState> F;
            private bp<GuildState, GuildState.b, i> G;
            private Object H;
            private int I;
            private Object J;

            /* renamed from: i, reason: collision with root package name */
            private int f381511i;

            /* renamed from: m, reason: collision with root package name */
            private long f381512m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private void u() {
                if ((this.f381511i & 1) == 0) {
                    this.F = new ArrayList(this.F);
                    this.f381511i |= 1;
                }
            }

            private bp<GuildState, GuildState.b, i> w() {
                if (this.G == null) {
                    List<GuildState> list = this.F;
                    boolean z16 = true;
                    if ((this.f381511i & 1) == 0) {
                        z16 = false;
                    }
                    this.G = new bp<>(list, z16, h(), isClean());
                    this.F = null;
                }
                return this.G;
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

            public b C(long j3) {
                this.f381512m = j3;
                onChanged();
                return this;
            }

            public b D(int i3) {
                this.I = i3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381479e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381480f.e(ChannelInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ChannelInfo build() {
                ChannelInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ChannelInfo buildPartial() {
                ChannelInfo channelInfo = new ChannelInfo(this);
                channelInfo.guildId_ = this.f381512m;
                channelInfo.guildName_ = this.C;
                channelInfo.guildIcon_ = this.D;
                channelInfo.guildProfile_ = this.E;
                bp<GuildState, GuildState.b, i> bpVar = this.G;
                if (bpVar != null) {
                    channelInfo.stateList_ = bpVar.d();
                } else {
                    if ((this.f381511i & 1) != 0) {
                        this.F = Collections.unmodifiableList(this.F);
                        this.f381511i &= -2;
                    }
                    channelInfo.stateList_ = this.F;
                }
                channelInfo.shareLink_ = this.H;
                channelInfo.joinedGuild_ = this.I;
                channelInfo.coverUrl_ = this.J;
                onBuilt();
                return channelInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381512m = 0L;
                this.C = "";
                this.D = "";
                this.E = "";
                bp<GuildState, GuildState.b, i> bpVar = this.G;
                if (bpVar == null) {
                    this.F = Collections.emptyList();
                    this.f381511i &= -2;
                } else {
                    bpVar.e();
                }
                this.H = "";
                this.I = 0;
                this.J = "";
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
            public ChannelInfo getDefaultInstanceForType() {
                return ChannelInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                ChannelInfo channelInfo = null;
                try {
                    try {
                        ChannelInfo channelInfo2 = (ChannelInfo) ChannelInfo.f381510e.g(kVar, tVar);
                        if (channelInfo2 != null) {
                            z(channelInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ChannelInfo channelInfo3 = (ChannelInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            channelInfo = channelInfo3;
                            if (channelInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (channelInfo != null) {
                        z(channelInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ChannelInfo) {
                    return z((ChannelInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b z(ChannelInfo channelInfo) {
                if (channelInfo == ChannelInfo.getDefaultInstance()) {
                    return this;
                }
                if (channelInfo.getGuildId() != 0) {
                    C(channelInfo.getGuildId());
                }
                if (!channelInfo.getGuildName().isEmpty()) {
                    this.C = channelInfo.guildName_;
                    onChanged();
                }
                if (!channelInfo.getGuildIcon().isEmpty()) {
                    this.D = channelInfo.guildIcon_;
                    onChanged();
                }
                if (!channelInfo.getGuildProfile().isEmpty()) {
                    this.E = channelInfo.guildProfile_;
                    onChanged();
                }
                if (this.G == null) {
                    if (!channelInfo.stateList_.isEmpty()) {
                        if (this.F.isEmpty()) {
                            this.F = channelInfo.stateList_;
                            this.f381511i &= -2;
                        } else {
                            u();
                            this.F.addAll(channelInfo.stateList_);
                        }
                        onChanged();
                    }
                } else if (!channelInfo.stateList_.isEmpty()) {
                    if (this.G.j()) {
                        this.G.f();
                        bp<GuildState, GuildState.b, i> bpVar = null;
                        this.G = null;
                        this.F = channelInfo.stateList_;
                        this.f381511i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.G = bpVar;
                    } else {
                        this.G.b(channelInfo.stateList_);
                    }
                }
                if (!channelInfo.getShareLink().isEmpty()) {
                    this.H = channelInfo.shareLink_;
                    onChanged();
                }
                if (channelInfo.getJoinedGuild() != 0) {
                    D(channelInfo.getJoinedGuild());
                }
                if (!channelInfo.getCoverUrl().isEmpty()) {
                    this.J = channelInfo.coverUrl_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) channelInfo).unknownFields);
                onChanged();
                return this;
            }

            b() {
                this.C = "";
                this.D = "";
                this.E = "";
                this.F = Collections.emptyList();
                this.H = "";
                this.J = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = "";
                this.D = "";
                this.E = "";
                this.F = Collections.emptyList();
                this.H = "";
                this.J = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ChannelInfo channelInfo) {
            return f381509d.toBuilder().z(channelInfo);
        }

        public static ChannelInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381510e.m(byteBuffer, tVar);
        }

        ChannelInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ChannelInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ChannelInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381510e, inputStream, tVar);
        }

        public static ChannelInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381510e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ChannelInfo getDefaultInstanceForType() {
            return f381509d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381509d ? new b() : new b().z(this);
        }

        public static ChannelInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381510e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ChannelInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.guildName_ = "";
            this.guildIcon_ = "";
            this.guildProfile_ = "";
            this.stateList_ = Collections.emptyList();
            this.shareLink_ = "";
            this.coverUrl_ = "";
        }

        public static ChannelInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381510e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ChannelInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381510e.i(bArr, tVar);
        }

        public static ChannelInfo parseFrom(InputStream inputStream) throws IOException {
            return (ChannelInfo) GeneratedMessageV3.parseWithIOException(f381510e, inputStream);
        }

        public static ChannelInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ChannelInfo) GeneratedMessageV3.parseWithIOException(f381510e, inputStream, tVar);
        }

        public static ChannelInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (ChannelInfo) GeneratedMessageV3.parseWithIOException(f381510e, kVar);
        }

        ChannelInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        try {
                            int J = kVar.J();
                            if (J != 0) {
                                if (J == 8) {
                                    this.guildId_ = kVar.L();
                                } else if (J == 18) {
                                    this.guildName_ = kVar.I();
                                } else if (J == 26) {
                                    this.guildIcon_ = kVar.I();
                                } else if (J == 34) {
                                    this.guildProfile_ = kVar.I();
                                } else if (J == 42) {
                                    if (!(z17 & true)) {
                                        this.stateList_ = new ArrayList();
                                        z17 |= true;
                                    }
                                    this.stateList_.add((GuildState) kVar.z(GuildState.parser(), tVar));
                                } else if (J == 50) {
                                    this.shareLink_ = kVar.I();
                                } else if (J == 56) {
                                    this.joinedGuild_ = kVar.K();
                                } else if (J != 66) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.coverUrl_ = kVar.I();
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
                    if (z17 & true) {
                        this.stateList_ = Collections.unmodifiableList(this.stateList_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ChannelInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (ChannelInfo) GeneratedMessageV3.parseWithIOException(f381510e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class CoverInfo extends GeneratedMessageV3 implements e {
        public static final int IMAGE_URL_FIELD_NUMBER = 2;
        public static final int STREAM_URL_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final CoverInfo f381513d = new CoverInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<CoverInfo> f381514e = new a();
        private static final long serialVersionUID = 0;
        private volatile Object imageUrl_;
        private byte memoizedIsInitialized;
        private volatile Object streamUrl_;
        private int type_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<CoverInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public CoverInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new CoverInfo(kVar, tVar);
            }
        }

        public static CoverInfo getDefaultInstance() {
            return f381513d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381485k;
        }

        public static b newBuilder() {
            return f381513d.toBuilder();
        }

        public static CoverInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CoverInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381514e, inputStream);
        }

        public static CoverInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381514e.d(byteBuffer);
        }

        public static bg<CoverInfo> parser() {
            return f381514e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CoverInfo)) {
                return super.equals(obj);
            }
            CoverInfo coverInfo = (CoverInfo) obj;
            if (getType() == coverInfo.getType() && getImageUrl().equals(coverInfo.getImageUrl()) && getStreamUrl().equals(coverInfo.getStreamUrl()) && this.unknownFields.equals(coverInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public String getImageUrl() {
            Object obj = this.imageUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imageUrl_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getImageUrlBytes() {
            Object obj = this.imageUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imageUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<CoverInfo> getParserForType() {
            return f381514e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.type_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.Y(1, i16);
            }
            if (!getImageUrlBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(2, this.imageUrl_);
            }
            if (!getStreamUrlBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(3, this.streamUrl_);
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getStreamUrl() {
            Object obj = this.streamUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.streamUrl_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getStreamUrlBytes() {
            Object obj = this.streamUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.streamUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getType() {
            return this.type_;
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
            int hashCode = ((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + getImageUrl().hashCode()) * 37) + 3) * 53) + getStreamUrl().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381486l.e(CoverInfo.class, b.class);
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
            return new CoverInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.type_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            if (!getImageUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.imageUrl_);
            }
            if (!getStreamUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.streamUrl_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {
            private Object C;

            /* renamed from: i, reason: collision with root package name */
            private int f381515i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381516m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(int i3) {
                this.f381515i = i3;
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
                return common.f381485k;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381486l.e(CoverInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public CoverInfo build() {
                CoverInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public CoverInfo buildPartial() {
                CoverInfo coverInfo = new CoverInfo(this);
                coverInfo.type_ = this.f381515i;
                coverInfo.imageUrl_ = this.f381516m;
                coverInfo.streamUrl_ = this.C;
                onBuilt();
                return coverInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381515i = 0;
                this.f381516m = "";
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
            public CoverInfo getDefaultInstanceForType() {
                return CoverInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                CoverInfo coverInfo = null;
                try {
                    try {
                        CoverInfo coverInfo2 = (CoverInfo) CoverInfo.f381514e.g(kVar, tVar);
                        if (coverInfo2 != null) {
                            x(coverInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        CoverInfo coverInfo3 = (CoverInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            coverInfo = coverInfo3;
                            if (coverInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (coverInfo != null) {
                        x(coverInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof CoverInfo) {
                    return x((CoverInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(CoverInfo coverInfo) {
                if (coverInfo == CoverInfo.getDefaultInstance()) {
                    return this;
                }
                if (coverInfo.getType() != 0) {
                    A(coverInfo.getType());
                }
                if (!coverInfo.getImageUrl().isEmpty()) {
                    this.f381516m = coverInfo.imageUrl_;
                    onChanged();
                }
                if (!coverInfo.getStreamUrl().isEmpty()) {
                    this.C = coverInfo.streamUrl_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) coverInfo).unknownFields);
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
                this.f381516m = "";
                this.C = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381516m = "";
                this.C = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(CoverInfo coverInfo) {
            return f381513d.toBuilder().x(coverInfo);
        }

        public static CoverInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381514e.m(byteBuffer, tVar);
        }

        CoverInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CoverInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (CoverInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381514e, inputStream, tVar);
        }

        public static CoverInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381514e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public CoverInfo getDefaultInstanceForType() {
            return f381513d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381513d ? new b() : new b().x(this);
        }

        public static CoverInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381514e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        CoverInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.imageUrl_ = "";
            this.streamUrl_ = "";
        }

        public static CoverInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381514e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static CoverInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381514e.i(bArr, tVar);
        }

        public static CoverInfo parseFrom(InputStream inputStream) throws IOException {
            return (CoverInfo) GeneratedMessageV3.parseWithIOException(f381514e, inputStream);
        }

        CoverInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.type_ = kVar.K();
                            } else if (J == 18) {
                                this.imageUrl_ = kVar.I();
                            } else if (J != 26) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.streamUrl_ = kVar.I();
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

        public static CoverInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (CoverInfo) GeneratedMessageV3.parseWithIOException(f381514e, inputStream, tVar);
        }

        public static CoverInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (CoverInfo) GeneratedMessageV3.parseWithIOException(f381514e, kVar);
        }

        public static CoverInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (CoverInfo) GeneratedMessageV3.parseWithIOException(f381514e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Feed extends GeneratedMessageV3 implements f {
        public static final int DATA_FIELD_NUMBER = 1;
        public static final int SHARE_INFO_FIELD_NUMBER = 2;

        /* renamed from: d, reason: collision with root package name */
        private static final Feed f381517d = new Feed();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<Feed> f381518e = new a();
        private static final long serialVersionUID = 0;
        private ByteString data_;
        private byte memoizedIsInitialized;
        private ShareInfo shareInfo_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<Feed> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public Feed g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new Feed(kVar, tVar);
            }
        }

        public static Feed getDefaultInstance() {
            return f381517d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381493s;
        }

        public static b newBuilder() {
            return f381517d.toBuilder();
        }

        public static Feed parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Feed) GeneratedMessageV3.parseDelimitedWithIOException(f381518e, inputStream);
        }

        public static Feed parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381518e.d(byteBuffer);
        }

        public static bg<Feed> parser() {
            return f381518e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Feed)) {
                return super.equals(obj);
            }
            Feed feed = (Feed) obj;
            if (!getData().equals(feed.getData()) || hasShareInfo() != feed.hasShareInfo()) {
                return false;
            }
            if ((!hasShareInfo() || getShareInfo().equals(feed.getShareInfo())) && this.unknownFields.equals(feed.unknownFields)) {
                return true;
            }
            return false;
        }

        public ByteString getData() {
            return this.data_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<Feed> getParserForType() {
            return f381518e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (!this.data_.isEmpty()) {
                i16 = 0 + CodedOutputStream.h(1, this.data_);
            }
            if (this.shareInfo_ != null) {
                i16 += CodedOutputStream.G(2, getShareInfo());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public ShareInfo getShareInfo() {
            ShareInfo shareInfo = this.shareInfo_;
            if (shareInfo == null) {
                return ShareInfo.getDefaultInstance();
            }
            return shareInfo;
        }

        public r getShareInfoOrBuilder() {
            return getShareInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasShareInfo() {
            if (this.shareInfo_ != null) {
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
            int hashCode = ((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getData().hashCode();
            if (hasShareInfo()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getShareInfo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381494t.e(Feed.class, b.class);
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
            return new Feed();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.data_.isEmpty()) {
                codedOutputStream.q0(1, this.data_);
            }
            if (this.shareInfo_ != null) {
                codedOutputStream.K0(2, getShareInfo());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements f {
            private bu<ShareInfo, ShareInfo.b, r> C;

            /* renamed from: i, reason: collision with root package name */
            private ByteString f381519i;

            /* renamed from: m, reason: collision with root package name */
            private ShareInfo f381520m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(ByteString byteString) {
                byteString.getClass();
                this.f381519i = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381493s;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381494t.e(Feed.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public Feed build() {
                Feed buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public Feed buildPartial() {
                Feed feed = new Feed(this);
                feed.data_ = this.f381519i;
                bu<ShareInfo, ShareInfo.b, r> buVar = this.C;
                if (buVar == null) {
                    feed.shareInfo_ = this.f381520m;
                } else {
                    feed.shareInfo_ = buVar.b();
                }
                onBuilt();
                return feed;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381519i = ByteString.EMPTY;
                if (this.C == null) {
                    this.f381520m = null;
                } else {
                    this.f381520m = null;
                    this.C = null;
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
            public Feed getDefaultInstanceForType() {
                return Feed.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                Feed feed = null;
                try {
                    try {
                        Feed feed2 = (Feed) Feed.f381518e.g(kVar, tVar);
                        if (feed2 != null) {
                            x(feed2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        Feed feed3 = (Feed) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            feed = feed3;
                            if (feed != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (feed != null) {
                        x(feed);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof Feed) {
                    return x((Feed) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(Feed feed) {
                if (feed == Feed.getDefaultInstance()) {
                    return this;
                }
                if (feed.getData() != ByteString.EMPTY) {
                    A(feed.getData());
                }
                if (feed.hasShareInfo()) {
                    y(feed.getShareInfo());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) feed).unknownFields);
                onChanged();
                return this;
            }

            public b y(ShareInfo shareInfo) {
                bu<ShareInfo, ShareInfo.b, r> buVar = this.C;
                if (buVar == null) {
                    ShareInfo shareInfo2 = this.f381520m;
                    if (shareInfo2 != null) {
                        this.f381520m = ShareInfo.newBuilder(shareInfo2).x(shareInfo).buildPartial();
                    } else {
                        this.f381520m = shareInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(shareInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            b() {
                this.f381519i = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381519i = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(Feed feed) {
            return f381517d.toBuilder().x(feed);
        }

        public static Feed parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381518e.m(byteBuffer, tVar);
        }

        Feed(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Feed parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (Feed) GeneratedMessageV3.parseDelimitedWithIOException(f381518e, inputStream, tVar);
        }

        public static Feed parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381518e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public Feed getDefaultInstanceForType() {
            return f381517d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381517d ? new b() : new b().x(this);
        }

        public static Feed parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381518e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        Feed() {
            this.memoizedIsInitialized = (byte) -1;
            this.data_ = ByteString.EMPTY;
        }

        public static Feed parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381518e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static Feed parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381518e.i(bArr, tVar);
        }

        public static Feed parseFrom(InputStream inputStream) throws IOException {
            return (Feed) GeneratedMessageV3.parseWithIOException(f381518e, inputStream);
        }

        Feed(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.data_ = kVar.q();
                            } else if (J != 18) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                ShareInfo shareInfo = this.shareInfo_;
                                ShareInfo.b builder = shareInfo != null ? shareInfo.toBuilder() : null;
                                ShareInfo shareInfo2 = (ShareInfo) kVar.z(ShareInfo.parser(), tVar);
                                this.shareInfo_ = shareInfo2;
                                if (builder != null) {
                                    builder.x(shareInfo2);
                                    this.shareInfo_ = builder.buildPartial();
                                }
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

        public static Feed parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (Feed) GeneratedMessageV3.parseWithIOException(f381518e, inputStream, tVar);
        }

        public static Feed parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (Feed) GeneratedMessageV3.parseWithIOException(f381518e, kVar);
        }

        public static Feed parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (Feed) GeneratedMessageV3.parseWithIOException(f381518e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ForumChannel extends GeneratedMessageV3 implements g {
        public static final int END_COLOR_FIELD_NUMBER = 6;
        public static final int HOTFEED_NUM_FIELD_NUMBER = 1;
        public static final int HOT_ICON_FIELD_NUMBER = 7;
        public static final int HOT_VALUE_TITLE_FIELD_NUMBER = 3;
        public static final int INDEX_FIELD_NUMBER = 2;
        public static final int INVITE_CODE_FIELD_NUMBER = 8;
        public static final int START_COLOR_FIELD_NUMBER = 5;
        public static final int TYPE_FIELD_NUMBER = 4;

        /* renamed from: d, reason: collision with root package name */
        private static final ForumChannel f381521d = new ForumChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ForumChannel> f381522e = new a();
        private static final long serialVersionUID = 0;
        private int endColor_;
        private volatile Object hotIcon_;
        private volatile Object hotValueTitle_;
        private int hotfeedNum_;
        private int index_;
        private volatile Object inviteCode_;
        private byte memoizedIsInitialized;
        private int startColor_;
        private int type_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ForumChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ForumChannel g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ForumChannel(kVar, tVar);
            }
        }

        public static ForumChannel getDefaultInstance() {
            return f381521d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.M;
        }

        public static b newBuilder() {
            return f381521d.toBuilder();
        }

        public static ForumChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ForumChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381522e, inputStream);
        }

        public static ForumChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381522e.d(byteBuffer);
        }

        public static bg<ForumChannel> parser() {
            return f381522e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ForumChannel)) {
                return super.equals(obj);
            }
            ForumChannel forumChannel = (ForumChannel) obj;
            if (getHotfeedNum() == forumChannel.getHotfeedNum() && getIndex() == forumChannel.getIndex() && getHotValueTitle().equals(forumChannel.getHotValueTitle()) && getType() == forumChannel.getType() && getStartColor() == forumChannel.getStartColor() && getEndColor() == forumChannel.getEndColor() && getHotIcon().equals(forumChannel.getHotIcon()) && getInviteCode().equals(forumChannel.getInviteCode()) && this.unknownFields.equals(forumChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        public int getEndColor() {
            return this.endColor_;
        }

        public String getHotIcon() {
            Object obj = this.hotIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.hotIcon_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getHotIconBytes() {
            Object obj = this.hotIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.hotIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getHotValueTitle() {
            Object obj = this.hotValueTitle_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.hotValueTitle_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getHotValueTitleBytes() {
            Object obj = this.hotValueTitle_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.hotValueTitle_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getHotfeedNum() {
            return this.hotfeedNum_;
        }

        public int getIndex() {
            return this.index_;
        }

        public String getInviteCode() {
            Object obj = this.inviteCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.inviteCode_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getInviteCodeBytes() {
            Object obj = this.inviteCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.inviteCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ForumChannel> getParserForType() {
            return f381522e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.hotfeedNum_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.Y(1, i16);
            }
            int i18 = this.index_;
            if (i18 != 0) {
                i17 += CodedOutputStream.x(2, i18);
            }
            if (!getHotValueTitleBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(3, this.hotValueTitle_);
            }
            int i19 = this.type_;
            if (i19 != 0) {
                i17 += CodedOutputStream.Y(4, i19);
            }
            int i26 = this.startColor_;
            if (i26 != 0) {
                i17 += CodedOutputStream.Y(5, i26);
            }
            int i27 = this.endColor_;
            if (i27 != 0) {
                i17 += CodedOutputStream.Y(6, i27);
            }
            if (!getHotIconBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(7, this.hotIcon_);
            }
            if (!getInviteCodeBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(8, this.inviteCode_);
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public int getStartColor() {
            return this.startColor_;
        }

        public int getType() {
            return this.type_;
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
            int hashCode = ((((((((((((((((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getHotfeedNum()) * 37) + 2) * 53) + getIndex()) * 37) + 3) * 53) + getHotValueTitle().hashCode()) * 37) + 4) * 53) + getType()) * 37) + 5) * 53) + getStartColor()) * 37) + 6) * 53) + getEndColor()) * 37) + 7) * 53) + getHotIcon().hashCode()) * 37) + 8) * 53) + getInviteCode().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.N.e(ForumChannel.class, b.class);
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
            return new ForumChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.hotfeedNum_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            int i16 = this.index_;
            if (i16 != 0) {
                codedOutputStream.G0(2, i16);
            }
            if (!getHotValueTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.hotValueTitle_);
            }
            int i17 = this.type_;
            if (i17 != 0) {
                codedOutputStream.b1(4, i17);
            }
            int i18 = this.startColor_;
            if (i18 != 0) {
                codedOutputStream.b1(5, i18);
            }
            int i19 = this.endColor_;
            if (i19 != 0) {
                codedOutputStream.b1(6, i19);
            }
            if (!getHotIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.hotIcon_);
            }
            if (!getInviteCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.inviteCode_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g {
            private Object C;
            private int D;
            private int E;
            private int F;
            private Object G;
            private Object H;

            /* renamed from: i, reason: collision with root package name */
            private int f381523i;

            /* renamed from: m, reason: collision with root package name */
            private int f381524m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(int i3) {
                this.f381523i = i3;
                onChanged();
                return this;
            }

            public b C(int i3) {
                this.f381524m = i3;
                onChanged();
                return this;
            }

            public b D(int i3) {
                this.E = i3;
                onChanged();
                return this;
            }

            public b E(int i3) {
                this.D = i3;
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
                return common.M;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.N.e(ForumChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ForumChannel build() {
                ForumChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ForumChannel buildPartial() {
                ForumChannel forumChannel = new ForumChannel(this);
                forumChannel.hotfeedNum_ = this.f381523i;
                forumChannel.index_ = this.f381524m;
                forumChannel.hotValueTitle_ = this.C;
                forumChannel.type_ = this.D;
                forumChannel.startColor_ = this.E;
                forumChannel.endColor_ = this.F;
                forumChannel.hotIcon_ = this.G;
                forumChannel.inviteCode_ = this.H;
                onBuilt();
                return forumChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381523i = 0;
                this.f381524m = 0;
                this.C = "";
                this.D = 0;
                this.E = 0;
                this.F = 0;
                this.G = "";
                this.H = "";
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
            public ForumChannel getDefaultInstanceForType() {
                return ForumChannel.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                ForumChannel forumChannel = null;
                try {
                    try {
                        ForumChannel forumChannel2 = (ForumChannel) ForumChannel.f381522e.g(kVar, tVar);
                        if (forumChannel2 != null) {
                            x(forumChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ForumChannel forumChannel3 = (ForumChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            forumChannel = forumChannel3;
                            if (forumChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (forumChannel != null) {
                        x(forumChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ForumChannel) {
                    return x((ForumChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ForumChannel forumChannel) {
                if (forumChannel == ForumChannel.getDefaultInstance()) {
                    return this;
                }
                if (forumChannel.getHotfeedNum() != 0) {
                    B(forumChannel.getHotfeedNum());
                }
                if (forumChannel.getIndex() != 0) {
                    C(forumChannel.getIndex());
                }
                if (!forumChannel.getHotValueTitle().isEmpty()) {
                    this.C = forumChannel.hotValueTitle_;
                    onChanged();
                }
                if (forumChannel.getType() != 0) {
                    E(forumChannel.getType());
                }
                if (forumChannel.getStartColor() != 0) {
                    D(forumChannel.getStartColor());
                }
                if (forumChannel.getEndColor() != 0) {
                    z(forumChannel.getEndColor());
                }
                if (!forumChannel.getHotIcon().isEmpty()) {
                    this.G = forumChannel.hotIcon_;
                    onChanged();
                }
                if (!forumChannel.getInviteCode().isEmpty()) {
                    this.H = forumChannel.inviteCode_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) forumChannel).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b z(int i3) {
                this.F = i3;
                onChanged();
                return this;
            }

            b() {
                this.C = "";
                this.G = "";
                this.H = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = "";
                this.G = "";
                this.H = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ForumChannel forumChannel) {
            return f381521d.toBuilder().x(forumChannel);
        }

        public static ForumChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381522e.m(byteBuffer, tVar);
        }

        ForumChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ForumChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ForumChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381522e, inputStream, tVar);
        }

        public static ForumChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381522e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ForumChannel getDefaultInstanceForType() {
            return f381521d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381521d ? new b() : new b().x(this);
        }

        public static ForumChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381522e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ForumChannel() {
            this.memoizedIsInitialized = (byte) -1;
            this.hotValueTitle_ = "";
            this.hotIcon_ = "";
            this.inviteCode_ = "";
        }

        public static ForumChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381522e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ForumChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381522e.i(bArr, tVar);
        }

        public static ForumChannel parseFrom(InputStream inputStream) throws IOException {
            return (ForumChannel) GeneratedMessageV3.parseWithIOException(f381522e, inputStream);
        }

        public static ForumChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ForumChannel) GeneratedMessageV3.parseWithIOException(f381522e, inputStream, tVar);
        }

        ForumChannel(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.hotfeedNum_ = kVar.K();
                            } else if (J == 16) {
                                this.index_ = kVar.x();
                            } else if (J == 26) {
                                this.hotValueTitle_ = kVar.I();
                            } else if (J == 32) {
                                this.type_ = kVar.K();
                            } else if (J == 40) {
                                this.startColor_ = kVar.K();
                            } else if (J == 48) {
                                this.endColor_ = kVar.K();
                            } else if (J == 58) {
                                this.hotIcon_ = kVar.I();
                            } else if (J != 66) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.inviteCode_ = kVar.I();
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

        public static ForumChannel parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (ForumChannel) GeneratedMessageV3.parseWithIOException(f381522e, kVar);
        }

        public static ForumChannel parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (ForumChannel) GeneratedMessageV3.parseWithIOException(f381522e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class GameInfo extends GeneratedMessageV3 implements h {
        public static final int ICON_FIELD_NUMBER = 3;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int MODE_INFO_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 2;

        /* renamed from: d, reason: collision with root package name */
        private static final GameInfo f381525d = new GameInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<GameInfo> f381526e = new a();
        private static final long serialVersionUID = 0;
        private volatile Object icon_;
        private int id_;
        private byte memoizedIsInitialized;
        private ModeInfo modeInfo_;
        private volatile Object name_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<GameInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public GameInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new GameInfo(kVar, tVar);
            }
        }

        public static GameInfo getDefaultInstance() {
            return f381525d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.A;
        }

        public static b newBuilder() {
            return f381525d.toBuilder();
        }

        public static GameInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GameInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381526e, inputStream);
        }

        public static GameInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381526e.d(byteBuffer);
        }

        public static bg<GameInfo> parser() {
            return f381526e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GameInfo)) {
                return super.equals(obj);
            }
            GameInfo gameInfo = (GameInfo) obj;
            if (getId() != gameInfo.getId() || !getName().equals(gameInfo.getName()) || !getIcon().equals(gameInfo.getIcon()) || hasModeInfo() != gameInfo.hasModeInfo()) {
                return false;
            }
            if ((!hasModeInfo() || getModeInfo().equals(gameInfo.getModeInfo())) && this.unknownFields.equals(gameInfo.unknownFields)) {
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

        public int getId() {
            return this.id_;
        }

        public ModeInfo getModeInfo() {
            ModeInfo modeInfo = this.modeInfo_;
            if (modeInfo == null) {
                return ModeInfo.getDefaultInstance();
            }
            return modeInfo;
        }

        public l getModeInfoOrBuilder() {
            return getModeInfo();
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<GameInfo> getParserForType() {
            return f381526e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.id_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.x(1, i16);
            }
            if (!getNameBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            if (!getIconBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(3, this.icon_);
            }
            if (this.modeInfo_ != null) {
                i17 += CodedOutputStream.G(4, getModeInfo());
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasModeInfo() {
            if (this.modeInfo_ != null) {
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
            int hashCode = ((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getIcon().hashCode();
            if (hasModeInfo()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getModeInfo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.B.e(GameInfo.class, b.class);
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
            return new GameInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.id_;
            if (i3 != 0) {
                codedOutputStream.G0(1, i3);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
            }
            if (!getIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.icon_);
            }
            if (this.modeInfo_ != null) {
                codedOutputStream.K0(4, getModeInfo());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements h {
            private Object C;
            private ModeInfo D;
            private bu<ModeInfo, ModeInfo.b, l> E;

            /* renamed from: i, reason: collision with root package name */
            private int f381527i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381528m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(int i3) {
                this.f381527i = i3;
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
                return common.A;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.B.e(GameInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public GameInfo build() {
                GameInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public GameInfo buildPartial() {
                GameInfo gameInfo = new GameInfo(this);
                gameInfo.id_ = this.f381527i;
                gameInfo.name_ = this.f381528m;
                gameInfo.icon_ = this.C;
                bu<ModeInfo, ModeInfo.b, l> buVar = this.E;
                if (buVar == null) {
                    gameInfo.modeInfo_ = this.D;
                } else {
                    gameInfo.modeInfo_ = buVar.b();
                }
                onBuilt();
                return gameInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381527i = 0;
                this.f381528m = "";
                this.C = "";
                if (this.E == null) {
                    this.D = null;
                } else {
                    this.D = null;
                    this.E = null;
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
            public GameInfo getDefaultInstanceForType() {
                return GameInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                GameInfo gameInfo = null;
                try {
                    try {
                        GameInfo gameInfo2 = (GameInfo) GameInfo.f381526e.g(kVar, tVar);
                        if (gameInfo2 != null) {
                            x(gameInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        GameInfo gameInfo3 = (GameInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            gameInfo = gameInfo3;
                            if (gameInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (gameInfo != null) {
                        x(gameInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof GameInfo) {
                    return x((GameInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(GameInfo gameInfo) {
                if (gameInfo == GameInfo.getDefaultInstance()) {
                    return this;
                }
                if (gameInfo.getId() != 0) {
                    B(gameInfo.getId());
                }
                if (!gameInfo.getName().isEmpty()) {
                    this.f381528m = gameInfo.name_;
                    onChanged();
                }
                if (!gameInfo.getIcon().isEmpty()) {
                    this.C = gameInfo.icon_;
                    onChanged();
                }
                if (gameInfo.hasModeInfo()) {
                    y(gameInfo.getModeInfo());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) gameInfo).unknownFields);
                onChanged();
                return this;
            }

            public b y(ModeInfo modeInfo) {
                bu<ModeInfo, ModeInfo.b, l> buVar = this.E;
                if (buVar == null) {
                    ModeInfo modeInfo2 = this.D;
                    if (modeInfo2 != null) {
                        this.D = ModeInfo.newBuilder(modeInfo2).x(modeInfo).buildPartial();
                    } else {
                        this.D = modeInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(modeInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            b() {
                this.f381528m = "";
                this.C = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381528m = "";
                this.C = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(GameInfo gameInfo) {
            return f381525d.toBuilder().x(gameInfo);
        }

        public static GameInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381526e.m(byteBuffer, tVar);
        }

        GameInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static GameInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (GameInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381526e, inputStream, tVar);
        }

        public static GameInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381526e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public GameInfo getDefaultInstanceForType() {
            return f381525d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381525d ? new b() : new b().x(this);
        }

        public static GameInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381526e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        GameInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.icon_ = "";
        }

        public static GameInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381526e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static GameInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381526e.i(bArr, tVar);
        }

        public static GameInfo parseFrom(InputStream inputStream) throws IOException {
            return (GameInfo) GeneratedMessageV3.parseWithIOException(f381526e, inputStream);
        }

        GameInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                    this.id_ = kVar.x();
                                } else if (J == 18) {
                                    this.name_ = kVar.I();
                                } else if (J == 26) {
                                    this.icon_ = kVar.I();
                                } else if (J != 34) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    ModeInfo modeInfo = this.modeInfo_;
                                    ModeInfo.b builder = modeInfo != null ? modeInfo.toBuilder() : null;
                                    ModeInfo modeInfo2 = (ModeInfo) kVar.z(ModeInfo.parser(), tVar);
                                    this.modeInfo_ = modeInfo2;
                                    if (builder != null) {
                                        builder.x(modeInfo2);
                                        this.modeInfo_ = builder.buildPartial();
                                    }
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

        public static GameInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (GameInfo) GeneratedMessageV3.parseWithIOException(f381526e, inputStream, tVar);
        }

        public static GameInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (GameInfo) GeneratedMessageV3.parseWithIOException(f381526e, kVar);
        }

        public static GameInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (GameInfo) GeneratedMessageV3.parseWithIOException(f381526e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class GuildState extends GeneratedMessageV3 implements i {
        public static final int DESC_FIELD_NUMBER = 2;
        public static final int ICON_URLS_FIELD_NUMBER = 3;
        public static final int STATE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final GuildState f381529d = new GuildState();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<GuildState> f381530e = new a();
        private static final long serialVersionUID = 0;
        private volatile Object desc_;
        private ah iconUrls_;
        private byte memoizedIsInitialized;
        private int state_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<GuildState> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public GuildState g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new GuildState(kVar, tVar);
            }
        }

        public static GuildState getDefaultInstance() {
            return f381529d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381481g;
        }

        public static b newBuilder() {
            return f381529d.toBuilder();
        }

        public static GuildState parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GuildState) GeneratedMessageV3.parseDelimitedWithIOException(f381530e, inputStream);
        }

        public static GuildState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381530e.d(byteBuffer);
        }

        public static bg<GuildState> parser() {
            return f381530e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GuildState)) {
                return super.equals(obj);
            }
            GuildState guildState = (GuildState) obj;
            if (getState() == guildState.getState() && getDesc().equals(guildState.getDesc()) && m285getIconUrlsList().equals(guildState.m285getIconUrlsList()) && this.unknownFields.equals(guildState.unknownFields)) {
                return true;
            }
            return false;
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

        public String getIconUrls(int i3) {
            return this.iconUrls_.get(i3);
        }

        public ByteString getIconUrlsBytes(int i3) {
            return this.iconUrls_.getByteString(i3);
        }

        public int getIconUrlsCount() {
            return this.iconUrls_.size();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<GuildState> getParserForType() {
            return f381530e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            int i17 = this.state_;
            if (i17 != 0) {
                i3 = CodedOutputStream.Y(1, i17) + 0;
            } else {
                i3 = 0;
            }
            if (!getDescBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(2, this.desc_);
            }
            int i18 = 0;
            for (int i19 = 0; i19 < this.iconUrls_.size(); i19++) {
                i18 += GeneratedMessageV3.computeStringSizeNoTag(this.iconUrls_.c(i19));
            }
            int size = i3 + i18 + (m285getIconUrlsList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        public int getState() {
            return this.state_;
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
            int hashCode = ((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getState()) * 37) + 2) * 53) + getDesc().hashCode();
            if (getIconUrlsCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + m285getIconUrlsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381482h.e(GuildState.class, b.class);
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
            return new GuildState();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.state_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            if (!getDescBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.desc_);
            }
            for (int i16 = 0; i16 < this.iconUrls_.size(); i16++) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.iconUrls_.c(i16));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements i {
            private Object C;
            private ah D;

            /* renamed from: i, reason: collision with root package name */
            private int f381531i;

            /* renamed from: m, reason: collision with root package name */
            private int f381532m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            private void u() {
                if ((this.f381531i & 1) == 0) {
                    this.D = new ag(this.D);
                    this.f381531i |= 1;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(int i3) {
                this.f381532m = i3;
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
                return common.f381481g;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381482h.e(GuildState.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public GuildState build() {
                GuildState buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public GuildState buildPartial() {
                GuildState guildState = new GuildState(this);
                guildState.state_ = this.f381532m;
                guildState.desc_ = this.C;
                if ((this.f381531i & 1) != 0) {
                    this.D = this.D.getUnmodifiableView();
                    this.f381531i &= -2;
                }
                guildState.iconUrls_ = this.D;
                onBuilt();
                return guildState;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381532m = 0;
                this.C = "";
                this.D = ag.f35656h;
                this.f381531i &= -2;
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
            public GuildState getDefaultInstanceForType() {
                return GuildState.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                GuildState guildState = null;
                try {
                    try {
                        GuildState guildState2 = (GuildState) GuildState.f381530e.g(kVar, tVar);
                        if (guildState2 != null) {
                            y(guildState2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        GuildState guildState3 = (GuildState) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            guildState = guildState3;
                            if (guildState != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (guildState != null) {
                        y(guildState);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof GuildState) {
                    return y((GuildState) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b y(GuildState guildState) {
                if (guildState == GuildState.getDefaultInstance()) {
                    return this;
                }
                if (guildState.getState() != 0) {
                    B(guildState.getState());
                }
                if (!guildState.getDesc().isEmpty()) {
                    this.C = guildState.desc_;
                    onChanged();
                }
                if (!guildState.iconUrls_.isEmpty()) {
                    if (this.D.isEmpty()) {
                        this.D = guildState.iconUrls_;
                        this.f381531i &= -2;
                    } else {
                        u();
                        this.D.addAll(guildState.iconUrls_);
                    }
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) guildState).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            b() {
                this.C = "";
                this.D = ag.f35656h;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = "";
                this.D = ag.f35656h;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(GuildState guildState) {
            return f381529d.toBuilder().y(guildState);
        }

        public static GuildState parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381530e.m(byteBuffer, tVar);
        }

        /* renamed from: getIconUrlsList, reason: merged with bridge method [inline-methods] */
        public bl m285getIconUrlsList() {
            return this.iconUrls_;
        }

        GuildState(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static GuildState parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (GuildState) GeneratedMessageV3.parseDelimitedWithIOException(f381530e, inputStream, tVar);
        }

        public static GuildState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381530e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public GuildState getDefaultInstanceForType() {
            return f381529d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381529d ? new b() : new b().y(this);
        }

        public static GuildState parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381530e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        GuildState() {
            this.memoizedIsInitialized = (byte) -1;
            this.desc_ = "";
            this.iconUrls_ = ag.f35656h;
        }

        public static GuildState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381530e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static GuildState parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381530e.i(bArr, tVar);
        }

        public static GuildState parseFrom(InputStream inputStream) throws IOException {
            return (GuildState) GeneratedMessageV3.parseWithIOException(f381530e, inputStream);
        }

        GuildState(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.state_ = kVar.K();
                            } else if (J == 18) {
                                this.desc_ = kVar.I();
                            } else if (J != 26) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                String I = kVar.I();
                                if (!(z17 & true)) {
                                    this.iconUrls_ = new ag();
                                    z17 |= true;
                                }
                                this.iconUrls_.add(I);
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
                        this.iconUrls_ = this.iconUrls_.getUnmodifiableView();
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static GuildState parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (GuildState) GeneratedMessageV3.parseWithIOException(f381530e, inputStream, tVar);
        }

        public static GuildState parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (GuildState) GeneratedMessageV3.parseWithIOException(f381530e, kVar);
        }

        public static GuildState parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (GuildState) GeneratedMessageV3.parseWithIOException(f381530e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class H5Game extends GeneratedMessageV3 implements k {
        public static final int GAME_FIELD_NUMBER = 3;
        public static final int MEMBERS_FIELD_NUMBER = 4;
        public static final int READY_EXPIRE_TIME_FIELD_NUMBER = 5;
        public static final int TEAM_ID_FIELD_NUMBER = 1;
        public static final int TEAM_STATUS_FIELD_NUMBER = 2;

        /* renamed from: d, reason: collision with root package name */
        private static final H5Game f381533d = new H5Game();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<H5Game> f381534e = new a();
        private static final long serialVersionUID = 0;
        private GameInfo game_;
        private List<Msg> members_;
        private byte memoizedIsInitialized;
        private long readyExpireTime_;
        private long teamId_;
        private int teamStatus_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<H5Game> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public H5Game g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new H5Game(kVar, tVar);
            }
        }

        public static H5Game getDefaultInstance() {
            return f381533d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381499y;
        }

        public static b newBuilder() {
            return f381533d.toBuilder();
        }

        public static H5Game parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (H5Game) GeneratedMessageV3.parseDelimitedWithIOException(f381534e, inputStream);
        }

        public static H5Game parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381534e.d(byteBuffer);
        }

        public static bg<H5Game> parser() {
            return f381534e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof H5Game)) {
                return super.equals(obj);
            }
            H5Game h5Game = (H5Game) obj;
            if (getTeamId() != h5Game.getTeamId() || this.teamStatus_ != h5Game.teamStatus_ || hasGame() != h5Game.hasGame()) {
                return false;
            }
            if ((!hasGame() || getGame().equals(h5Game.getGame())) && getMembersList().equals(h5Game.getMembersList()) && getReadyExpireTime() == h5Game.getReadyExpireTime() && this.unknownFields.equals(h5Game.unknownFields)) {
                return true;
            }
            return false;
        }

        public GameInfo getGame() {
            GameInfo gameInfo = this.game_;
            if (gameInfo == null) {
                return GameInfo.getDefaultInstance();
            }
            return gameInfo;
        }

        public h getGameOrBuilder() {
            return getGame();
        }

        public Msg getMembers(int i3) {
            return this.members_.get(i3);
        }

        public int getMembersCount() {
            return this.members_.size();
        }

        public List<Msg> getMembersList() {
            return this.members_;
        }

        public m getMembersOrBuilder(int i3) {
            return this.members_.get(i3);
        }

        public List<? extends m> getMembersOrBuilderList() {
            return this.members_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<H5Game> getParserForType() {
            return f381534e;
        }

        public long getReadyExpireTime() {
            return this.readyExpireTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            long j3 = this.teamId_;
            if (j3 != 0) {
                i3 = CodedOutputStream.a0(1, j3) + 0;
            } else {
                i3 = 0;
            }
            if (this.teamStatus_ != TeamStatus.TEAM_STATUS_INIT.getNumber()) {
                i3 += CodedOutputStream.l(2, this.teamStatus_);
            }
            if (this.game_ != null) {
                i3 += CodedOutputStream.G(3, getGame());
            }
            for (int i17 = 0; i17 < this.members_.size(); i17++) {
                i3 += CodedOutputStream.G(4, this.members_.get(i17));
            }
            long j16 = this.readyExpireTime_;
            if (j16 != 0) {
                i3 += CodedOutputStream.z(5, j16);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public long getTeamId() {
            return this.teamId_;
        }

        public TeamStatus getTeamStatus() {
            TeamStatus valueOf = TeamStatus.valueOf(this.teamStatus_);
            if (valueOf == null) {
                return TeamStatus.UNRECOGNIZED;
            }
            return valueOf;
        }

        public int getTeamStatusValue() {
            return this.teamStatus_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasGame() {
            if (this.game_ != null) {
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
            int hashCode = ((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getTeamId())) * 37) + 2) * 53) + this.teamStatus_;
            if (hasGame()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getGame().hashCode();
            }
            if (getMembersCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getMembersList().hashCode();
            }
            int h16 = (((((hashCode * 37) + 5) * 53) + ad.h(getReadyExpireTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = h16;
            return h16;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381500z.e(H5Game.class, b.class);
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
            return new H5Game();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j3 = this.teamId_;
            if (j3 != 0) {
                codedOutputStream.d1(1, j3);
            }
            if (this.teamStatus_ != TeamStatus.TEAM_STATUS_INIT.getNumber()) {
                codedOutputStream.u0(2, this.teamStatus_);
            }
            if (this.game_ != null) {
                codedOutputStream.K0(3, getGame());
            }
            for (int i3 = 0; i3 < this.members_.size(); i3++) {
                codedOutputStream.K0(4, this.members_.get(i3));
            }
            long j16 = this.readyExpireTime_;
            if (j16 != 0) {
                codedOutputStream.I0(5, j16);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements k {
            private int C;
            private GameInfo D;
            private bu<GameInfo, GameInfo.b, h> E;
            private List<Msg> F;
            private bp<Msg, Msg.b, m> G;
            private long H;

            /* renamed from: i, reason: collision with root package name */
            private int f381535i;

            /* renamed from: m, reason: collision with root package name */
            private long f381536m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private void u() {
                if ((this.f381535i & 1) == 0) {
                    this.F = new ArrayList(this.F);
                    this.f381535i |= 1;
                }
            }

            private bp<Msg, Msg.b, m> w() {
                if (this.G == null) {
                    List<Msg> list = this.F;
                    boolean z16 = true;
                    if ((this.f381535i & 1) == 0) {
                        z16 = false;
                    }
                    this.G = new bp<>(list, z16, h(), isClean());
                    this.F = null;
                }
                return this.G;
            }

            public b A(GameInfo gameInfo) {
                bu<GameInfo, GameInfo.b, h> buVar = this.E;
                if (buVar == null) {
                    GameInfo gameInfo2 = this.D;
                    if (gameInfo2 != null) {
                        this.D = GameInfo.newBuilder(gameInfo2).x(gameInfo).buildPartial();
                    } else {
                        this.D = gameInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(gameInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b D(long j3) {
                this.H = j3;
                onChanged();
                return this;
            }

            public b E(long j3) {
                this.f381536m = j3;
                onChanged();
                return this;
            }

            public b F(int i3) {
                this.C = i3;
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
                return common.f381499y;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381500z.e(H5Game.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public H5Game build() {
                H5Game buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public H5Game buildPartial() {
                H5Game h5Game = new H5Game(this);
                h5Game.teamId_ = this.f381536m;
                h5Game.teamStatus_ = this.C;
                bu<GameInfo, GameInfo.b, h> buVar = this.E;
                if (buVar == null) {
                    h5Game.game_ = this.D;
                } else {
                    h5Game.game_ = buVar.b();
                }
                bp<Msg, Msg.b, m> bpVar = this.G;
                if (bpVar != null) {
                    h5Game.members_ = bpVar.d();
                } else {
                    if ((this.f381535i & 1) != 0) {
                        this.F = Collections.unmodifiableList(this.F);
                        this.f381535i &= -2;
                    }
                    h5Game.members_ = this.F;
                }
                h5Game.readyExpireTime_ = this.H;
                onBuilt();
                return h5Game;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381536m = 0L;
                this.C = 0;
                if (this.E == null) {
                    this.D = null;
                } else {
                    this.D = null;
                    this.E = null;
                }
                bp<Msg, Msg.b, m> bpVar = this.G;
                if (bpVar == null) {
                    this.F = Collections.emptyList();
                    this.f381535i &= -2;
                } else {
                    bpVar.e();
                }
                this.H = 0L;
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
            public H5Game getDefaultInstanceForType() {
                return H5Game.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                H5Game h5Game = null;
                try {
                    try {
                        H5Game h5Game2 = (H5Game) H5Game.f381534e.g(kVar, tVar);
                        if (h5Game2 != null) {
                            z(h5Game2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        H5Game h5Game3 = (H5Game) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            h5Game = h5Game3;
                            if (h5Game != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (h5Game != null) {
                        z(h5Game);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof H5Game) {
                    return z((H5Game) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b z(H5Game h5Game) {
                if (h5Game == H5Game.getDefaultInstance()) {
                    return this;
                }
                if (h5Game.getTeamId() != 0) {
                    E(h5Game.getTeamId());
                }
                if (h5Game.teamStatus_ != 0) {
                    F(h5Game.getTeamStatusValue());
                }
                if (h5Game.hasGame()) {
                    A(h5Game.getGame());
                }
                if (this.G == null) {
                    if (!h5Game.members_.isEmpty()) {
                        if (this.F.isEmpty()) {
                            this.F = h5Game.members_;
                            this.f381535i &= -2;
                        } else {
                            u();
                            this.F.addAll(h5Game.members_);
                        }
                        onChanged();
                    }
                } else if (!h5Game.members_.isEmpty()) {
                    if (this.G.j()) {
                        this.G.f();
                        bp<Msg, Msg.b, m> bpVar = null;
                        this.G = null;
                        this.F = h5Game.members_;
                        this.f381535i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.G = bpVar;
                    } else {
                        this.G.b(h5Game.members_);
                    }
                }
                if (h5Game.getReadyExpireTime() != 0) {
                    D(h5Game.getReadyExpireTime());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) h5Game).unknownFields);
                onChanged();
                return this;
            }

            b() {
                this.C = 0;
                this.F = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = 0;
                this.F = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(H5Game h5Game) {
            return f381533d.toBuilder().z(h5Game);
        }

        public static H5Game parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381534e.m(byteBuffer, tVar);
        }

        H5Game(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static H5Game parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (H5Game) GeneratedMessageV3.parseDelimitedWithIOException(f381534e, inputStream, tVar);
        }

        public static H5Game parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381534e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public H5Game getDefaultInstanceForType() {
            return f381533d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381533d ? new b() : new b().z(this);
        }

        public static H5Game parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381534e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        H5Game() {
            this.memoizedIsInitialized = (byte) -1;
            this.teamStatus_ = 0;
            this.members_ = Collections.emptyList();
        }

        public static H5Game parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381534e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static H5Game parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381534e.i(bArr, tVar);
        }

        public static H5Game parseFrom(InputStream inputStream) throws IOException {
            return (H5Game) GeneratedMessageV3.parseWithIOException(f381534e, inputStream);
        }

        H5Game(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.teamId_ = kVar.L();
                            } else if (J == 16) {
                                this.teamStatus_ = kVar.s();
                            } else if (J == 26) {
                                GameInfo gameInfo = this.game_;
                                GameInfo.b builder = gameInfo != null ? gameInfo.toBuilder() : null;
                                GameInfo gameInfo2 = (GameInfo) kVar.z(GameInfo.parser(), tVar);
                                this.game_ = gameInfo2;
                                if (builder != null) {
                                    builder.x(gameInfo2);
                                    this.game_ = builder.buildPartial();
                                }
                            } else if (J == 34) {
                                if (!(z17 & true)) {
                                    this.members_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.members_.add((Msg) kVar.z(Msg.parser(), tVar));
                            } else if (J != 40) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.readyExpireTime_ = kVar.y();
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
                        this.members_ = Collections.unmodifiableList(this.members_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static H5Game parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (H5Game) GeneratedMessageV3.parseWithIOException(f381534e, inputStream, tVar);
        }

        public static H5Game parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (H5Game) GeneratedMessageV3.parseWithIOException(f381534e, kVar);
        }

        public static H5Game parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (H5Game) GeneratedMessageV3.parseWithIOException(f381534e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class H5GameChannel extends GeneratedMessageV3 implements j {
        public static final int COVER_FIELD_NUMBER = 2;
        public static final int DATA_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final H5GameChannel f381537d = new H5GameChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<H5GameChannel> f381538e = new a();
        private static final long serialVersionUID = 0;
        private CoverInfo cover_;
        private H5Game data_;
        private byte memoizedIsInitialized;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<H5GameChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public H5GameChannel g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new H5GameChannel(kVar, tVar);
            }
        }

        public static H5GameChannel getDefaultInstance() {
            return f381537d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381497w;
        }

        public static b newBuilder() {
            return f381537d.toBuilder();
        }

        public static H5GameChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (H5GameChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381538e, inputStream);
        }

        public static H5GameChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381538e.d(byteBuffer);
        }

        public static bg<H5GameChannel> parser() {
            return f381538e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof H5GameChannel)) {
                return super.equals(obj);
            }
            H5GameChannel h5GameChannel = (H5GameChannel) obj;
            if (hasData() != h5GameChannel.hasData()) {
                return false;
            }
            if ((hasData() && !getData().equals(h5GameChannel.getData())) || hasCover() != h5GameChannel.hasCover()) {
                return false;
            }
            if ((!hasCover() || getCover().equals(h5GameChannel.getCover())) && this.unknownFields.equals(h5GameChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        public CoverInfo getCover() {
            CoverInfo coverInfo = this.cover_;
            if (coverInfo == null) {
                return CoverInfo.getDefaultInstance();
            }
            return coverInfo;
        }

        public e getCoverOrBuilder() {
            return getCover();
        }

        public H5Game getData() {
            H5Game h5Game = this.data_;
            if (h5Game == null) {
                return H5Game.getDefaultInstance();
            }
            return h5Game;
        }

        public k getDataOrBuilder() {
            return getData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<H5GameChannel> getParserForType() {
            return f381538e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (this.data_ != null) {
                i16 = 0 + CodedOutputStream.G(1, getData());
            }
            if (this.cover_ != null) {
                i16 += CodedOutputStream.G(2, getCover());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasCover() {
            if (this.cover_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasData() {
            if (this.data_ != null) {
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
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasData()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getData().hashCode();
            }
            if (hasCover()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getCover().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381498x.e(H5GameChannel.class, b.class);
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
            return new H5GameChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.data_ != null) {
                codedOutputStream.K0(1, getData());
            }
            if (this.cover_ != null) {
                codedOutputStream.K0(2, getCover());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements j {
            private CoverInfo C;
            private bu<CoverInfo, CoverInfo.b, e> D;

            /* renamed from: i, reason: collision with root package name */
            private H5Game f381539i;

            /* renamed from: m, reason: collision with root package name */
            private bu<H5Game, H5Game.b, k> f381540m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
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

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381497w;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381498x.e(H5GameChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public H5GameChannel build() {
                H5GameChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public H5GameChannel buildPartial() {
                H5GameChannel h5GameChannel = new H5GameChannel(this);
                bu<H5Game, H5Game.b, k> buVar = this.f381540m;
                if (buVar == null) {
                    h5GameChannel.data_ = this.f381539i;
                } else {
                    h5GameChannel.data_ = buVar.b();
                }
                bu<CoverInfo, CoverInfo.b, e> buVar2 = this.D;
                if (buVar2 == null) {
                    h5GameChannel.cover_ = this.C;
                } else {
                    h5GameChannel.cover_ = buVar2.b();
                }
                onBuilt();
                return h5GameChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.f381540m == null) {
                    this.f381539i = null;
                } else {
                    this.f381539i = null;
                    this.f381540m = null;
                }
                if (this.D == null) {
                    this.C = null;
                } else {
                    this.C = null;
                    this.D = null;
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
            public H5GameChannel getDefaultInstanceForType() {
                return H5GameChannel.getDefaultInstance();
            }

            public b v(CoverInfo coverInfo) {
                bu<CoverInfo, CoverInfo.b, e> buVar = this.D;
                if (buVar == null) {
                    CoverInfo coverInfo2 = this.C;
                    if (coverInfo2 != null) {
                        this.C = CoverInfo.newBuilder(coverInfo2).x(coverInfo).buildPartial();
                    } else {
                        this.C = coverInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(coverInfo);
                }
                return this;
            }

            public b w(H5Game h5Game) {
                bu<H5Game, H5Game.b, k> buVar = this.f381540m;
                if (buVar == null) {
                    H5Game h5Game2 = this.f381539i;
                    if (h5Game2 != null) {
                        this.f381539i = H5Game.newBuilder(h5Game2).z(h5Game).buildPartial();
                    } else {
                        this.f381539i = h5Game;
                    }
                    onChanged();
                } else {
                    buVar.g(h5Game);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                H5GameChannel h5GameChannel = null;
                try {
                    try {
                        H5GameChannel h5GameChannel2 = (H5GameChannel) H5GameChannel.f381538e.g(kVar, tVar);
                        if (h5GameChannel2 != null) {
                            z(h5GameChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        H5GameChannel h5GameChannel3 = (H5GameChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            h5GameChannel = h5GameChannel3;
                            if (h5GameChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (h5GameChannel != null) {
                        z(h5GameChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof H5GameChannel) {
                    return z((H5GameChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b z(H5GameChannel h5GameChannel) {
                if (h5GameChannel == H5GameChannel.getDefaultInstance()) {
                    return this;
                }
                if (h5GameChannel.hasData()) {
                    w(h5GameChannel.getData());
                }
                if (h5GameChannel.hasCover()) {
                    v(h5GameChannel.getCover());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) h5GameChannel).unknownFields);
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

        public static b newBuilder(H5GameChannel h5GameChannel) {
            return f381537d.toBuilder().z(h5GameChannel);
        }

        public static H5GameChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381538e.m(byteBuffer, tVar);
        }

        H5GameChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static H5GameChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (H5GameChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381538e, inputStream, tVar);
        }

        public static H5GameChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381538e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public H5GameChannel getDefaultInstanceForType() {
            return f381537d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381537d ? new b() : new b().z(this);
        }

        public static H5GameChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381538e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        H5GameChannel() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static H5GameChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381538e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static H5GameChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381538e.i(bArr, tVar);
        }

        H5GameChannel(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                H5Game h5Game = this.data_;
                                H5Game.b builder = h5Game != null ? h5Game.toBuilder() : null;
                                H5Game h5Game2 = (H5Game) kVar.z(H5Game.parser(), tVar);
                                this.data_ = h5Game2;
                                if (builder != null) {
                                    builder.z(h5Game2);
                                    this.data_ = builder.buildPartial();
                                }
                            } else if (J != 18) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                CoverInfo coverInfo = this.cover_;
                                CoverInfo.b builder2 = coverInfo != null ? coverInfo.toBuilder() : null;
                                CoverInfo coverInfo2 = (CoverInfo) kVar.z(CoverInfo.parser(), tVar);
                                this.cover_ = coverInfo2;
                                if (builder2 != null) {
                                    builder2.x(coverInfo2);
                                    this.cover_ = builder2.buildPartial();
                                }
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

        public static H5GameChannel parseFrom(InputStream inputStream) throws IOException {
            return (H5GameChannel) GeneratedMessageV3.parseWithIOException(f381538e, inputStream);
        }

        public static H5GameChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (H5GameChannel) GeneratedMessageV3.parseWithIOException(f381538e, inputStream, tVar);
        }

        public static H5GameChannel parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (H5GameChannel) GeneratedMessageV3.parseWithIOException(f381538e, kVar);
        }

        public static H5GameChannel parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (H5GameChannel) GeneratedMessageV3.parseWithIOException(f381538e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum ItemType implements bk {
        TYPE_UNKOWN(0),
        TYPE_FEED(1),
        TYPE_LIVE(2),
        TYPE_VOICE(3),
        TYPE_VOICE_SCREEN_SHARE(4),
        TYPE_VOICE_SMOBA(5),
        TYPE_WORLD(6),
        TYPE_CHANNEL(7),
        TYPE_GUILD(8),
        TYPE_H5GAME(9),
        TYPE_KTV(10),
        TYPE_VOICE_PLAY(11),
        TYPE_VOICE_LOBBY(12),
        TYPE_SUBJECT(13),
        TYPE_FORUM(14),
        TYPE_SUBJECT_CARD(15),
        TYPE_QUICK_JOIN(16),
        TYPE_GUILD_CHANNEL(17),
        TYPE_VOICE_ALL(100),
        UNRECOGNIZED(-1);

        public static final int TYPE_CHANNEL_VALUE = 7;
        public static final int TYPE_FEED_VALUE = 1;
        public static final int TYPE_FORUM_VALUE = 14;
        public static final int TYPE_GUILD_CHANNEL_VALUE = 17;
        public static final int TYPE_GUILD_VALUE = 8;
        public static final int TYPE_H5GAME_VALUE = 9;
        public static final int TYPE_KTV_VALUE = 10;
        public static final int TYPE_LIVE_VALUE = 2;
        public static final int TYPE_QUICK_JOIN_VALUE = 16;
        public static final int TYPE_SUBJECT_CARD_VALUE = 15;
        public static final int TYPE_SUBJECT_VALUE = 13;
        public static final int TYPE_UNKOWN_VALUE = 0;
        public static final int TYPE_VOICE_ALL_VALUE = 100;
        public static final int TYPE_VOICE_LOBBY_VALUE = 12;
        public static final int TYPE_VOICE_PLAY_VALUE = 11;
        public static final int TYPE_VOICE_SCREEN_SHARE_VALUE = 4;
        public static final int TYPE_VOICE_SMOBA_VALUE = 5;
        public static final int TYPE_VOICE_VALUE = 3;
        public static final int TYPE_WORLD_VALUE = 6;
        private final int value;
        private static final ad.d<ItemType> internalValueMap = new a();
        private static final ItemType[] VALUES = values();

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements ad.d<ItemType> {
            a() {
            }

            @Override // com.google.protobuf.ad.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ItemType findValueByNumber(int i3) {
                return ItemType.forNumber(i3);
            }
        }

        ItemType(int i3) {
            this.value = i3;
        }

        public static ItemType forNumber(int i3) {
            if (i3 != 100) {
                switch (i3) {
                    case 0:
                        return TYPE_UNKOWN;
                    case 1:
                        return TYPE_FEED;
                    case 2:
                        return TYPE_LIVE;
                    case 3:
                        return TYPE_VOICE;
                    case 4:
                        return TYPE_VOICE_SCREEN_SHARE;
                    case 5:
                        return TYPE_VOICE_SMOBA;
                    case 6:
                        return TYPE_WORLD;
                    case 7:
                        return TYPE_CHANNEL;
                    case 8:
                        return TYPE_GUILD;
                    case 9:
                        return TYPE_H5GAME;
                    case 10:
                        return TYPE_KTV;
                    case 11:
                        return TYPE_VOICE_PLAY;
                    case 12:
                        return TYPE_VOICE_LOBBY;
                    case 13:
                        return TYPE_SUBJECT;
                    case 14:
                        return TYPE_FORUM;
                    case 15:
                        return TYPE_SUBJECT_CARD;
                    case 16:
                        return TYPE_QUICK_JOIN;
                    case 17:
                        return TYPE_GUILD_CHANNEL;
                    default:
                        return null;
                }
            }
            return TYPE_VOICE_ALL;
        }

        public static final Descriptors.c getDescriptor() {
            return common.M().o().get(0);
        }

        public static ad.d<ItemType> internalGetValueMap() {
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
        public static ItemType valueOf(int i3) {
            return forNumber(i3);
        }

        public static ItemType valueOf(Descriptors.d dVar) {
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
    public static final class ModeInfo extends GeneratedMessageV3 implements l {
        public static final int IS_PK_FIELD_NUMBER = 3;
        public static final int MODE_ID_FIELD_NUMBER = 1;
        public static final int MODE_NAME_FIELD_NUMBER = 2;
        public static final int PLAYER_NUM_FIELD_NUMBER = 4;

        /* renamed from: d, reason: collision with root package name */
        private static final ModeInfo f381541d = new ModeInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ModeInfo> f381542e = new a();
        private static final long serialVersionUID = 0;
        private boolean isPk_;
        private byte memoizedIsInitialized;
        private int modeId_;
        private volatile Object modeName_;
        private int playerNum_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ModeInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ModeInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ModeInfo(kVar, tVar);
            }
        }

        public static ModeInfo getDefaultInstance() {
            return f381541d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.C;
        }

        public static b newBuilder() {
            return f381541d.toBuilder();
        }

        public static ModeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ModeInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381542e, inputStream);
        }

        public static ModeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381542e.d(byteBuffer);
        }

        public static bg<ModeInfo> parser() {
            return f381542e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ModeInfo)) {
                return super.equals(obj);
            }
            ModeInfo modeInfo = (ModeInfo) obj;
            if (getModeId() == modeInfo.getModeId() && getModeName().equals(modeInfo.getModeName()) && getIsPk() == modeInfo.getIsPk() && getPlayerNum() == modeInfo.getPlayerNum() && this.unknownFields.equals(modeInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public boolean getIsPk() {
            return this.isPk_;
        }

        public int getModeId() {
            return this.modeId_;
        }

        public String getModeName() {
            Object obj = this.modeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.modeName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getModeNameBytes() {
            Object obj = this.modeName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.modeName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ModeInfo> getParserForType() {
            return f381542e;
        }

        public int getPlayerNum() {
            return this.playerNum_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.modeId_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.x(1, i16);
            }
            if (!getModeNameBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(2, this.modeName_);
            }
            boolean z16 = this.isPk_;
            if (z16) {
                i17 += CodedOutputStream.e(3, z16);
            }
            int i18 = this.playerNum_;
            if (i18 != 0) {
                i17 += CodedOutputStream.x(4, i18);
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
            int hashCode = ((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getModeId()) * 37) + 2) * 53) + getModeName().hashCode()) * 37) + 3) * 53) + ad.c(getIsPk())) * 37) + 4) * 53) + getPlayerNum()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.D.e(ModeInfo.class, b.class);
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
            return new ModeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.modeId_;
            if (i3 != 0) {
                codedOutputStream.G0(1, i3);
            }
            if (!getModeNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.modeName_);
            }
            boolean z16 = this.isPk_;
            if (z16) {
                codedOutputStream.m0(3, z16);
            }
            int i16 = this.playerNum_;
            if (i16 != 0) {
                codedOutputStream.G0(4, i16);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements l {
            private boolean C;
            private int D;

            /* renamed from: i, reason: collision with root package name */
            private int f381543i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381544m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(boolean z16) {
                this.C = z16;
                onChanged();
                return this;
            }

            public b B(int i3) {
                this.f381543i = i3;
                onChanged();
                return this;
            }

            public b C(int i3) {
                this.D = i3;
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
                return common.C;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.D.e(ModeInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ModeInfo build() {
                ModeInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ModeInfo buildPartial() {
                ModeInfo modeInfo = new ModeInfo(this);
                modeInfo.modeId_ = this.f381543i;
                modeInfo.modeName_ = this.f381544m;
                modeInfo.isPk_ = this.C;
                modeInfo.playerNum_ = this.D;
                onBuilt();
                return modeInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381543i = 0;
                this.f381544m = "";
                this.C = false;
                this.D = 0;
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
            public ModeInfo getDefaultInstanceForType() {
                return ModeInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                ModeInfo modeInfo = null;
                try {
                    try {
                        ModeInfo modeInfo2 = (ModeInfo) ModeInfo.f381542e.g(kVar, tVar);
                        if (modeInfo2 != null) {
                            x(modeInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ModeInfo modeInfo3 = (ModeInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            modeInfo = modeInfo3;
                            if (modeInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (modeInfo != null) {
                        x(modeInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ModeInfo) {
                    return x((ModeInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ModeInfo modeInfo) {
                if (modeInfo == ModeInfo.getDefaultInstance()) {
                    return this;
                }
                if (modeInfo.getModeId() != 0) {
                    B(modeInfo.getModeId());
                }
                if (!modeInfo.getModeName().isEmpty()) {
                    this.f381544m = modeInfo.modeName_;
                    onChanged();
                }
                if (modeInfo.getIsPk()) {
                    A(modeInfo.getIsPk());
                }
                if (modeInfo.getPlayerNum() != 0) {
                    C(modeInfo.getPlayerNum());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) modeInfo).unknownFields);
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
                this.f381544m = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381544m = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ModeInfo modeInfo) {
            return f381541d.toBuilder().x(modeInfo);
        }

        public static ModeInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381542e.m(byteBuffer, tVar);
        }

        ModeInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ModeInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ModeInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381542e, inputStream, tVar);
        }

        public static ModeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381542e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ModeInfo getDefaultInstanceForType() {
            return f381541d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381541d ? new b() : new b().x(this);
        }

        public static ModeInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381542e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ModeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.modeName_ = "";
        }

        public static ModeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381542e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ModeInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381542e.i(bArr, tVar);
        }

        public static ModeInfo parseFrom(InputStream inputStream) throws IOException {
            return (ModeInfo) GeneratedMessageV3.parseWithIOException(f381542e, inputStream);
        }

        ModeInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.modeId_ = kVar.x();
                            } else if (J == 18) {
                                this.modeName_ = kVar.I();
                            } else if (J == 24) {
                                this.isPk_ = kVar.p();
                            } else if (J != 32) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.playerNum_ = kVar.x();
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

        public static ModeInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ModeInfo) GeneratedMessageV3.parseWithIOException(f381542e, inputStream, tVar);
        }

        public static ModeInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (ModeInfo) GeneratedMessageV3.parseWithIOException(f381542e, kVar);
        }

        public static ModeInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (ModeInfo) GeneratedMessageV3.parseWithIOException(f381542e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Msg extends GeneratedMessageV3 implements m {
        public static final int AVATAR_FIELD_NUMBER = 3;
        public static final int MSG_SEQ_FIELD_NUMBER = 4;
        public static final int NICK_NAME_FIELD_NUMBER = 2;
        public static final int RICH_TEXT_FIELD_NUMBER = 5;
        public static final int TINYID_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final Msg f381545d = new Msg();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<Msg> f381546e = new a();
        private static final long serialVersionUID = 0;
        private ByteString avatar_;
        private byte memoizedIsInitialized;
        private long msgSeq_;
        private volatile Object nickName_;
        private ByteString richText_;
        private long tinyid_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<Msg> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public Msg g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new Msg(kVar, tVar);
            }
        }

        public static Msg getDefaultInstance() {
            return f381545d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381487m;
        }

        public static b newBuilder() {
            return f381545d.toBuilder();
        }

        public static Msg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Msg) GeneratedMessageV3.parseDelimitedWithIOException(f381546e, inputStream);
        }

        public static Msg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381546e.d(byteBuffer);
        }

        public static bg<Msg> parser() {
            return f381546e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Msg)) {
                return super.equals(obj);
            }
            Msg msg2 = (Msg) obj;
            if (getTinyid() == msg2.getTinyid() && getNickName().equals(msg2.getNickName()) && getAvatar().equals(msg2.getAvatar()) && getMsgSeq() == msg2.getMsgSeq() && getRichText().equals(msg2.getRichText()) && this.unknownFields.equals(msg2.unknownFields)) {
                return true;
            }
            return false;
        }

        public ByteString getAvatar() {
            return this.avatar_;
        }

        public long getMsgSeq() {
            return this.msgSeq_;
        }

        public String getNickName() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nickName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getNickNameBytes() {
            Object obj = this.nickName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nickName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<Msg> getParserForType() {
            return f381546e;
        }

        public ByteString getRichText() {
            return this.richText_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            long j3 = this.tinyid_;
            int i16 = 0;
            if (j3 != 0) {
                i16 = 0 + CodedOutputStream.a0(1, j3);
            }
            if (!getNickNameBytes().isEmpty()) {
                i16 += GeneratedMessageV3.computeStringSize(2, this.nickName_);
            }
            if (!this.avatar_.isEmpty()) {
                i16 += CodedOutputStream.h(3, this.avatar_);
            }
            long j16 = this.msgSeq_;
            if (j16 != 0) {
                i16 += CodedOutputStream.a0(4, j16);
            }
            if (!this.richText_.isEmpty()) {
                i16 += CodedOutputStream.h(5, this.richText_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public long getTinyid() {
            return this.tinyid_;
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
            int hashCode = ((((((((((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getTinyid())) * 37) + 2) * 53) + getNickName().hashCode()) * 37) + 3) * 53) + getAvatar().hashCode()) * 37) + 4) * 53) + ad.h(getMsgSeq())) * 37) + 5) * 53) + getRichText().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381488n.e(Msg.class, b.class);
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
            return new Msg();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j3 = this.tinyid_;
            if (j3 != 0) {
                codedOutputStream.d1(1, j3);
            }
            if (!getNickNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.nickName_);
            }
            if (!this.avatar_.isEmpty()) {
                codedOutputStream.q0(3, this.avatar_);
            }
            long j16 = this.msgSeq_;
            if (j16 != 0) {
                codedOutputStream.d1(4, j16);
            }
            if (!this.richText_.isEmpty()) {
                codedOutputStream.q0(5, this.richText_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements m {
            private ByteString C;
            private long D;
            private ByteString E;

            /* renamed from: i, reason: collision with root package name */
            private long f381547i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381548m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(long j3) {
                this.D = j3;
                onChanged();
                return this;
            }

            public b C(ByteString byteString) {
                byteString.getClass();
                this.E = byteString;
                onChanged();
                return this;
            }

            public b D(long j3) {
                this.f381547i = j3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381487m;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381488n.e(Msg.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public Msg build() {
                Msg buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public Msg buildPartial() {
                Msg msg2 = new Msg(this);
                msg2.tinyid_ = this.f381547i;
                msg2.nickName_ = this.f381548m;
                msg2.avatar_ = this.C;
                msg2.msgSeq_ = this.D;
                msg2.richText_ = this.E;
                onBuilt();
                return msg2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381547i = 0L;
                this.f381548m = "";
                ByteString byteString = ByteString.EMPTY;
                this.C = byteString;
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
            public Msg getDefaultInstanceForType() {
                return Msg.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                Msg msg2 = null;
                try {
                    try {
                        Msg msg3 = (Msg) Msg.f381546e.g(kVar, tVar);
                        if (msg3 != null) {
                            x(msg3);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        Msg msg4 = (Msg) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            msg2 = msg4;
                            if (msg2 != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (msg2 != null) {
                        x(msg2);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof Msg) {
                    return x((Msg) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(Msg msg2) {
                if (msg2 == Msg.getDefaultInstance()) {
                    return this;
                }
                if (msg2.getTinyid() != 0) {
                    D(msg2.getTinyid());
                }
                if (!msg2.getNickName().isEmpty()) {
                    this.f381548m = msg2.nickName_;
                    onChanged();
                }
                ByteString avatar = msg2.getAvatar();
                ByteString byteString = ByteString.EMPTY;
                if (avatar != byteString) {
                    z(msg2.getAvatar());
                }
                if (msg2.getMsgSeq() != 0) {
                    B(msg2.getMsgSeq());
                }
                if (msg2.getRichText() != byteString) {
                    C(msg2.getRichText());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) msg2).unknownFields);
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
                this.f381548m = "";
                ByteString byteString = ByteString.EMPTY;
                this.C = byteString;
                this.E = byteString;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381548m = "";
                ByteString byteString = ByteString.EMPTY;
                this.C = byteString;
                this.E = byteString;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(Msg msg2) {
            return f381545d.toBuilder().x(msg2);
        }

        public static Msg parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381546e.m(byteBuffer, tVar);
        }

        Msg(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Msg parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (Msg) GeneratedMessageV3.parseDelimitedWithIOException(f381546e, inputStream, tVar);
        }

        public static Msg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381546e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public Msg getDefaultInstanceForType() {
            return f381545d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381545d ? new b() : new b().x(this);
        }

        public static Msg parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381546e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        Msg() {
            this.memoizedIsInitialized = (byte) -1;
            this.nickName_ = "";
            ByteString byteString = ByteString.EMPTY;
            this.avatar_ = byteString;
            this.richText_ = byteString;
        }

        public static Msg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381546e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static Msg parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381546e.i(bArr, tVar);
        }

        public static Msg parseFrom(InputStream inputStream) throws IOException {
            return (Msg) GeneratedMessageV3.parseWithIOException(f381546e, inputStream);
        }

        public static Msg parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (Msg) GeneratedMessageV3.parseWithIOException(f381546e, inputStream, tVar);
        }

        Msg(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                    this.tinyid_ = kVar.L();
                                } else if (J == 18) {
                                    this.nickName_ = kVar.I();
                                } else if (J == 26) {
                                    this.avatar_ = kVar.q();
                                } else if (J == 32) {
                                    this.msgSeq_ = kVar.L();
                                } else if (J != 42) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.richText_ = kVar.q();
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

        public static Msg parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (Msg) GeneratedMessageV3.parseWithIOException(f381546e, kVar);
        }

        public static Msg parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (Msg) GeneratedMessageV3.parseWithIOException(f381546e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RCGuildLiveChannel extends GeneratedMessageV3 implements n {
        public static final int COVER_FIELD_NUMBER = 3;
        public static final int DATA_FIELD_NUMBER = 1;
        public static final int MSG_LIST_FIELD_NUMBER = 2;

        /* renamed from: d, reason: collision with root package name */
        private static final RCGuildLiveChannel f381549d = new RCGuildLiveChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<RCGuildLiveChannel> f381550e = new a();
        private static final long serialVersionUID = 0;
        private CoverInfo cover_;
        private guildRecommendChannel.LiveChannel data_;
        private byte memoizedIsInitialized;
        private List<Msg> msgList_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<RCGuildLiveChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public RCGuildLiveChannel g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new RCGuildLiveChannel(kVar, tVar);
            }
        }

        public static RCGuildLiveChannel getDefaultInstance() {
            return f381549d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381483i;
        }

        public static b newBuilder() {
            return f381549d.toBuilder();
        }

        public static RCGuildLiveChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RCGuildLiveChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381550e, inputStream);
        }

        public static RCGuildLiveChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381550e.d(byteBuffer);
        }

        public static bg<RCGuildLiveChannel> parser() {
            return f381550e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RCGuildLiveChannel)) {
                return super.equals(obj);
            }
            RCGuildLiveChannel rCGuildLiveChannel = (RCGuildLiveChannel) obj;
            if (hasData() != rCGuildLiveChannel.hasData()) {
                return false;
            }
            if ((hasData() && !getData().equals(rCGuildLiveChannel.getData())) || !getMsgListList().equals(rCGuildLiveChannel.getMsgListList()) || hasCover() != rCGuildLiveChannel.hasCover()) {
                return false;
            }
            if ((!hasCover() || getCover().equals(rCGuildLiveChannel.getCover())) && this.unknownFields.equals(rCGuildLiveChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        public CoverInfo getCover() {
            CoverInfo coverInfo = this.cover_;
            if (coverInfo == null) {
                return CoverInfo.getDefaultInstance();
            }
            return coverInfo;
        }

        public e getCoverOrBuilder() {
            return getCover();
        }

        public guildRecommendChannel.LiveChannel getData() {
            guildRecommendChannel.LiveChannel liveChannel = this.data_;
            if (liveChannel == null) {
                return guildRecommendChannel.LiveChannel.getDefaultInstance();
            }
            return liveChannel;
        }

        public guildRecommendChannel.b getDataOrBuilder() {
            return getData();
        }

        public Msg getMsgList(int i3) {
            return this.msgList_.get(i3);
        }

        public int getMsgListCount() {
            return this.msgList_.size();
        }

        public List<Msg> getMsgListList() {
            return this.msgList_;
        }

        public m getMsgListOrBuilder(int i3) {
            return this.msgList_.get(i3);
        }

        public List<? extends m> getMsgListOrBuilderList() {
            return this.msgList_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<RCGuildLiveChannel> getParserForType() {
            return f381550e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if (this.data_ != null) {
                i3 = CodedOutputStream.G(1, getData()) + 0;
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < this.msgList_.size(); i17++) {
                i3 += CodedOutputStream.G(2, this.msgList_.get(i17));
            }
            if (this.cover_ != null) {
                i3 += CodedOutputStream.G(3, getCover());
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasCover() {
            if (this.cover_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasData() {
            if (this.data_ != null) {
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
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasData()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getData().hashCode();
            }
            if (getMsgListCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMsgListList().hashCode();
            }
            if (hasCover()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getCover().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381484j.e(RCGuildLiveChannel.class, b.class);
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
            return new RCGuildLiveChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.data_ != null) {
                codedOutputStream.K0(1, getData());
            }
            for (int i3 = 0; i3 < this.msgList_.size(); i3++) {
                codedOutputStream.K0(2, this.msgList_.get(i3));
            }
            if (this.cover_ != null) {
                codedOutputStream.K0(3, getCover());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements n {
            private bu<guildRecommendChannel.LiveChannel, guildRecommendChannel.LiveChannel.b, guildRecommendChannel.b> C;
            private List<Msg> D;
            private bp<Msg, Msg.b, m> E;
            private CoverInfo F;
            private bu<CoverInfo, CoverInfo.b, e> G;

            /* renamed from: i, reason: collision with root package name */
            private int f381551i;

            /* renamed from: m, reason: collision with root package name */
            private guildRecommendChannel.LiveChannel f381552m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private void u() {
                if ((this.f381551i & 1) == 0) {
                    this.D = new ArrayList(this.D);
                    this.f381551i |= 1;
                }
            }

            private bp<Msg, Msg.b, m> w() {
                if (this.E == null) {
                    List<Msg> list = this.D;
                    boolean z16 = true;
                    if ((this.f381551i & 1) == 0) {
                        z16 = false;
                    }
                    this.E = new bp<>(list, z16, h(), isClean());
                    this.D = null;
                }
                return this.E;
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof RCGuildLiveChannel) {
                    return B((RCGuildLiveChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b B(RCGuildLiveChannel rCGuildLiveChannel) {
                if (rCGuildLiveChannel == RCGuildLiveChannel.getDefaultInstance()) {
                    return this;
                }
                if (rCGuildLiveChannel.hasData()) {
                    y(rCGuildLiveChannel.getData());
                }
                if (this.E == null) {
                    if (!rCGuildLiveChannel.msgList_.isEmpty()) {
                        if (this.D.isEmpty()) {
                            this.D = rCGuildLiveChannel.msgList_;
                            this.f381551i &= -2;
                        } else {
                            u();
                            this.D.addAll(rCGuildLiveChannel.msgList_);
                        }
                        onChanged();
                    }
                } else if (!rCGuildLiveChannel.msgList_.isEmpty()) {
                    if (this.E.j()) {
                        this.E.f();
                        bp<Msg, Msg.b, m> bpVar = null;
                        this.E = null;
                        this.D = rCGuildLiveChannel.msgList_;
                        this.f381551i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.E = bpVar;
                    } else {
                        this.E.b(rCGuildLiveChannel.msgList_);
                    }
                }
                if (rCGuildLiveChannel.hasCover()) {
                    x(rCGuildLiveChannel.getCover());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) rCGuildLiveChannel).unknownFields);
                onChanged();
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

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381483i;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381484j.e(RCGuildLiveChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public RCGuildLiveChannel build() {
                RCGuildLiveChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public RCGuildLiveChannel buildPartial() {
                RCGuildLiveChannel rCGuildLiveChannel = new RCGuildLiveChannel(this);
                bu<guildRecommendChannel.LiveChannel, guildRecommendChannel.LiveChannel.b, guildRecommendChannel.b> buVar = this.C;
                if (buVar == null) {
                    rCGuildLiveChannel.data_ = this.f381552m;
                } else {
                    rCGuildLiveChannel.data_ = buVar.b();
                }
                bp<Msg, Msg.b, m> bpVar = this.E;
                if (bpVar != null) {
                    rCGuildLiveChannel.msgList_ = bpVar.d();
                } else {
                    if ((this.f381551i & 1) != 0) {
                        this.D = Collections.unmodifiableList(this.D);
                        this.f381551i &= -2;
                    }
                    rCGuildLiveChannel.msgList_ = this.D;
                }
                bu<CoverInfo, CoverInfo.b, e> buVar2 = this.G;
                if (buVar2 == null) {
                    rCGuildLiveChannel.cover_ = this.F;
                } else {
                    rCGuildLiveChannel.cover_ = buVar2.b();
                }
                onBuilt();
                return rCGuildLiveChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.C == null) {
                    this.f381552m = null;
                } else {
                    this.f381552m = null;
                    this.C = null;
                }
                bp<Msg, Msg.b, m> bpVar = this.E;
                if (bpVar == null) {
                    this.D = Collections.emptyList();
                    this.f381551i &= -2;
                } else {
                    bpVar.e();
                }
                if (this.G == null) {
                    this.F = null;
                } else {
                    this.F = null;
                    this.G = null;
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
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public RCGuildLiveChannel getDefaultInstanceForType() {
                return RCGuildLiveChannel.getDefaultInstance();
            }

            public b x(CoverInfo coverInfo) {
                bu<CoverInfo, CoverInfo.b, e> buVar = this.G;
                if (buVar == null) {
                    CoverInfo coverInfo2 = this.F;
                    if (coverInfo2 != null) {
                        this.F = CoverInfo.newBuilder(coverInfo2).x(coverInfo).buildPartial();
                    } else {
                        this.F = coverInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(coverInfo);
                }
                return this;
            }

            public b y(guildRecommendChannel.LiveChannel liveChannel) {
                bu<guildRecommendChannel.LiveChannel, guildRecommendChannel.LiveChannel.b, guildRecommendChannel.b> buVar = this.C;
                if (buVar == null) {
                    guildRecommendChannel.LiveChannel liveChannel2 = this.f381552m;
                    if (liveChannel2 != null) {
                        this.f381552m = guildRecommendChannel.LiveChannel.newBuilder(liveChannel2).x(liveChannel).buildPartial();
                    } else {
                        this.f381552m = liveChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(liveChannel);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                RCGuildLiveChannel rCGuildLiveChannel = null;
                try {
                    try {
                        RCGuildLiveChannel rCGuildLiveChannel2 = (RCGuildLiveChannel) RCGuildLiveChannel.f381550e.g(kVar, tVar);
                        if (rCGuildLiveChannel2 != null) {
                            B(rCGuildLiveChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        RCGuildLiveChannel rCGuildLiveChannel3 = (RCGuildLiveChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            rCGuildLiveChannel = rCGuildLiveChannel3;
                            if (rCGuildLiveChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (rCGuildLiveChannel != null) {
                        B(rCGuildLiveChannel);
                    }
                    throw th;
                }
            }

            b() {
                this.D = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.D = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(RCGuildLiveChannel rCGuildLiveChannel) {
            return f381549d.toBuilder().B(rCGuildLiveChannel);
        }

        public static RCGuildLiveChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381550e.m(byteBuffer, tVar);
        }

        RCGuildLiveChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RCGuildLiveChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (RCGuildLiveChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381550e, inputStream, tVar);
        }

        public static RCGuildLiveChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381550e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public RCGuildLiveChannel getDefaultInstanceForType() {
            return f381549d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381549d ? new b() : new b().B(this);
        }

        public static RCGuildLiveChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381550e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        RCGuildLiveChannel() {
            this.memoizedIsInitialized = (byte) -1;
            this.msgList_ = Collections.emptyList();
        }

        public static RCGuildLiveChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381550e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static RCGuildLiveChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381550e.i(bArr, tVar);
        }

        public static RCGuildLiveChannel parseFrom(InputStream inputStream) throws IOException {
            return (RCGuildLiveChannel) GeneratedMessageV3.parseWithIOException(f381550e, inputStream);
        }

        RCGuildLiveChannel(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                            if (J == 10) {
                                guildRecommendChannel.LiveChannel liveChannel = this.data_;
                                guildRecommendChannel.LiveChannel.b builder = liveChannel != null ? liveChannel.toBuilder() : null;
                                guildRecommendChannel.LiveChannel liveChannel2 = (guildRecommendChannel.LiveChannel) kVar.z(guildRecommendChannel.LiveChannel.parser(), tVar);
                                this.data_ = liveChannel2;
                                if (builder != null) {
                                    builder.x(liveChannel2);
                                    this.data_ = builder.buildPartial();
                                }
                            } else if (J == 18) {
                                boolean z18 = (z17 ? 1 : 0) & true;
                                z17 = z17;
                                if (!z18) {
                                    this.msgList_ = new ArrayList();
                                    z17 = (z17 ? 1 : 0) | true;
                                }
                                this.msgList_.add((Msg) kVar.z(Msg.parser(), tVar));
                            } else if (J != 26) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                CoverInfo coverInfo = this.cover_;
                                CoverInfo.b builder2 = coverInfo != null ? coverInfo.toBuilder() : null;
                                CoverInfo coverInfo2 = (CoverInfo) kVar.z(CoverInfo.parser(), tVar);
                                this.cover_ = coverInfo2;
                                if (builder2 != null) {
                                    builder2.x(coverInfo2);
                                    this.cover_ = builder2.buildPartial();
                                }
                            }
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferException e16) {
                        throw e16.setUnfinishedMessage(this);
                    } catch (IOException e17) {
                        throw new InvalidProtocolBufferException(e17).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((z17 ? 1 : 0) & true) {
                        this.msgList_ = Collections.unmodifiableList(this.msgList_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static RCGuildLiveChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (RCGuildLiveChannel) GeneratedMessageV3.parseWithIOException(f381550e, inputStream, tVar);
        }

        public static RCGuildLiveChannel parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (RCGuildLiveChannel) GeneratedMessageV3.parseWithIOException(f381550e, kVar);
        }

        public static RCGuildLiveChannel parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (RCGuildLiveChannel) GeneratedMessageV3.parseWithIOException(f381550e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RCGuildMemberInfo extends GeneratedMessageV3 implements o {
        public static final int AVATAR_META_FIELD_NUMBER = 3;
        public static final int GENDER_FIELD_NUMBER = 2;
        public static final int TINY_ID_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final RCGuildMemberInfo f381553d = new RCGuildMemberInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<RCGuildMemberInfo> f381554e = new a();
        private static final long serialVersionUID = 0;
        private ByteString avatarMeta_;
        private int gender_;
        private byte memoizedIsInitialized;
        private long tinyId_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<RCGuildMemberInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public RCGuildMemberInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new RCGuildMemberInfo(kVar, tVar);
            }
        }

        public static RCGuildMemberInfo getDefaultInstance() {
            return f381553d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.K;
        }

        public static b newBuilder() {
            return f381553d.toBuilder();
        }

        public static RCGuildMemberInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RCGuildMemberInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381554e, inputStream);
        }

        public static RCGuildMemberInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381554e.d(byteBuffer);
        }

        public static bg<RCGuildMemberInfo> parser() {
            return f381554e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RCGuildMemberInfo)) {
                return super.equals(obj);
            }
            RCGuildMemberInfo rCGuildMemberInfo = (RCGuildMemberInfo) obj;
            if (getTinyId() == rCGuildMemberInfo.getTinyId() && getGender() == rCGuildMemberInfo.getGender() && getAvatarMeta().equals(rCGuildMemberInfo.getAvatarMeta()) && this.unknownFields.equals(rCGuildMemberInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        public ByteString getAvatarMeta() {
            return this.avatarMeta_;
        }

        public int getGender() {
            return this.gender_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<RCGuildMemberInfo> getParserForType() {
            return f381554e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            long j3 = this.tinyId_;
            int i16 = 0;
            if (j3 != 0) {
                i16 = 0 + CodedOutputStream.a0(1, j3);
            }
            int i17 = this.gender_;
            if (i17 != 0) {
                i16 += CodedOutputStream.Y(2, i17);
            }
            if (!this.avatarMeta_.isEmpty()) {
                i16 += CodedOutputStream.h(3, this.avatarMeta_);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public long getTinyId() {
            return this.tinyId_;
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
            int hashCode = ((((((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + ad.h(getTinyId())) * 37) + 2) * 53) + getGender()) * 37) + 3) * 53) + getAvatarMeta().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.L.e(RCGuildMemberInfo.class, b.class);
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
            return new RCGuildMemberInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j3 = this.tinyId_;
            if (j3 != 0) {
                codedOutputStream.d1(1, j3);
            }
            int i3 = this.gender_;
            if (i3 != 0) {
                codedOutputStream.b1(2, i3);
            }
            if (!this.avatarMeta_.isEmpty()) {
                codedOutputStream.q0(3, this.avatarMeta_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements o {
            private ByteString C;

            /* renamed from: i, reason: collision with root package name */
            private long f381555i;

            /* renamed from: m, reason: collision with root package name */
            private int f381556m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b B(int i3) {
                this.f381556m = i3;
                onChanged();
                return this;
            }

            public b C(long j3) {
                this.f381555i = j3;
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
                return common.K;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.L.e(RCGuildMemberInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public RCGuildMemberInfo build() {
                RCGuildMemberInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public RCGuildMemberInfo buildPartial() {
                RCGuildMemberInfo rCGuildMemberInfo = new RCGuildMemberInfo(this);
                rCGuildMemberInfo.tinyId_ = this.f381555i;
                rCGuildMemberInfo.gender_ = this.f381556m;
                rCGuildMemberInfo.avatarMeta_ = this.C;
                onBuilt();
                return rCGuildMemberInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381555i = 0L;
                this.f381556m = 0;
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
            public RCGuildMemberInfo getDefaultInstanceForType() {
                return RCGuildMemberInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                RCGuildMemberInfo rCGuildMemberInfo = null;
                try {
                    try {
                        RCGuildMemberInfo rCGuildMemberInfo2 = (RCGuildMemberInfo) RCGuildMemberInfo.f381554e.g(kVar, tVar);
                        if (rCGuildMemberInfo2 != null) {
                            x(rCGuildMemberInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        RCGuildMemberInfo rCGuildMemberInfo3 = (RCGuildMemberInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            rCGuildMemberInfo = rCGuildMemberInfo3;
                            if (rCGuildMemberInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (rCGuildMemberInfo != null) {
                        x(rCGuildMemberInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof RCGuildMemberInfo) {
                    return x((RCGuildMemberInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(RCGuildMemberInfo rCGuildMemberInfo) {
                if (rCGuildMemberInfo == RCGuildMemberInfo.getDefaultInstance()) {
                    return this;
                }
                if (rCGuildMemberInfo.getTinyId() != 0) {
                    C(rCGuildMemberInfo.getTinyId());
                }
                if (rCGuildMemberInfo.getGender() != 0) {
                    B(rCGuildMemberInfo.getGender());
                }
                if (rCGuildMemberInfo.getAvatarMeta() != ByteString.EMPTY) {
                    z(rCGuildMemberInfo.getAvatarMeta());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) rCGuildMemberInfo).unknownFields);
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
                this.C = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.C = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(RCGuildMemberInfo rCGuildMemberInfo) {
            return f381553d.toBuilder().x(rCGuildMemberInfo);
        }

        public static RCGuildMemberInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381554e.m(byteBuffer, tVar);
        }

        RCGuildMemberInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RCGuildMemberInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (RCGuildMemberInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381554e, inputStream, tVar);
        }

        public static RCGuildMemberInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381554e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public RCGuildMemberInfo getDefaultInstanceForType() {
            return f381553d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381553d ? new b() : new b().x(this);
        }

        public static RCGuildMemberInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381554e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        RCGuildMemberInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.avatarMeta_ = ByteString.EMPTY;
        }

        public static RCGuildMemberInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381554e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static RCGuildMemberInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381554e.i(bArr, tVar);
        }

        public static RCGuildMemberInfo parseFrom(InputStream inputStream) throws IOException {
            return (RCGuildMemberInfo) GeneratedMessageV3.parseWithIOException(f381554e, inputStream);
        }

        RCGuildMemberInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                this.tinyId_ = kVar.L();
                            } else if (J == 16) {
                                this.gender_ = kVar.K();
                            } else if (J != 26) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                this.avatarMeta_ = kVar.q();
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

        public static RCGuildMemberInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (RCGuildMemberInfo) GeneratedMessageV3.parseWithIOException(f381554e, inputStream, tVar);
        }

        public static RCGuildMemberInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (RCGuildMemberInfo) GeneratedMessageV3.parseWithIOException(f381554e, kVar);
        }

        public static RCGuildMemberInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (RCGuildMemberInfo) GeneratedMessageV3.parseWithIOException(f381554e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RCGuildVoiceChannel extends GeneratedMessageV3 implements p {
        public static final int COVER_FIELD_NUMBER = 2;
        public static final int DATA_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final RCGuildVoiceChannel f381557d = new RCGuildVoiceChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<RCGuildVoiceChannel> f381558e = new a();
        private static final long serialVersionUID = 0;
        private CoverInfo cover_;
        private guildRecommendChannel.VoiceChannel data_;
        private byte memoizedIsInitialized;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<RCGuildVoiceChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public RCGuildVoiceChannel g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new RCGuildVoiceChannel(kVar, tVar);
            }
        }

        public static RCGuildVoiceChannel getDefaultInstance() {
            return f381557d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381489o;
        }

        public static b newBuilder() {
            return f381557d.toBuilder();
        }

        public static RCGuildVoiceChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RCGuildVoiceChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381558e, inputStream);
        }

        public static RCGuildVoiceChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381558e.d(byteBuffer);
        }

        public static bg<RCGuildVoiceChannel> parser() {
            return f381558e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RCGuildVoiceChannel)) {
                return super.equals(obj);
            }
            RCGuildVoiceChannel rCGuildVoiceChannel = (RCGuildVoiceChannel) obj;
            if (hasData() != rCGuildVoiceChannel.hasData()) {
                return false;
            }
            if ((hasData() && !getData().equals(rCGuildVoiceChannel.getData())) || hasCover() != rCGuildVoiceChannel.hasCover()) {
                return false;
            }
            if ((!hasCover() || getCover().equals(rCGuildVoiceChannel.getCover())) && this.unknownFields.equals(rCGuildVoiceChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        public CoverInfo getCover() {
            CoverInfo coverInfo = this.cover_;
            if (coverInfo == null) {
                return CoverInfo.getDefaultInstance();
            }
            return coverInfo;
        }

        public e getCoverOrBuilder() {
            return getCover();
        }

        public guildRecommendChannel.VoiceChannel getData() {
            guildRecommendChannel.VoiceChannel voiceChannel = this.data_;
            if (voiceChannel == null) {
                return guildRecommendChannel.VoiceChannel.getDefaultInstance();
            }
            return voiceChannel;
        }

        public guildRecommendChannel.c getDataOrBuilder() {
            return getData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<RCGuildVoiceChannel> getParserForType() {
            return f381558e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (this.data_ != null) {
                i16 = 0 + CodedOutputStream.G(1, getData());
            }
            if (this.cover_ != null) {
                i16 += CodedOutputStream.G(2, getCover());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasCover() {
            if (this.cover_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasData() {
            if (this.data_ != null) {
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
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasData()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getData().hashCode();
            }
            if (hasCover()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getCover().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381490p.e(RCGuildVoiceChannel.class, b.class);
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
            return new RCGuildVoiceChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.data_ != null) {
                codedOutputStream.K0(1, getData());
            }
            if (this.cover_ != null) {
                codedOutputStream.K0(2, getCover());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements p {
            private CoverInfo C;
            private bu<CoverInfo, CoverInfo.b, e> D;

            /* renamed from: i, reason: collision with root package name */
            private guildRecommendChannel.VoiceChannel f381559i;

            /* renamed from: m, reason: collision with root package name */
            private bu<guildRecommendChannel.VoiceChannel, guildRecommendChannel.VoiceChannel.b, guildRecommendChannel.c> f381560m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
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

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381489o;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381490p.e(RCGuildVoiceChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public RCGuildVoiceChannel build() {
                RCGuildVoiceChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public RCGuildVoiceChannel buildPartial() {
                RCGuildVoiceChannel rCGuildVoiceChannel = new RCGuildVoiceChannel(this);
                bu<guildRecommendChannel.VoiceChannel, guildRecommendChannel.VoiceChannel.b, guildRecommendChannel.c> buVar = this.f381560m;
                if (buVar == null) {
                    rCGuildVoiceChannel.data_ = this.f381559i;
                } else {
                    rCGuildVoiceChannel.data_ = buVar.b();
                }
                bu<CoverInfo, CoverInfo.b, e> buVar2 = this.D;
                if (buVar2 == null) {
                    rCGuildVoiceChannel.cover_ = this.C;
                } else {
                    rCGuildVoiceChannel.cover_ = buVar2.b();
                }
                onBuilt();
                return rCGuildVoiceChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.f381560m == null) {
                    this.f381559i = null;
                } else {
                    this.f381559i = null;
                    this.f381560m = null;
                }
                if (this.D == null) {
                    this.C = null;
                } else {
                    this.C = null;
                    this.D = null;
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
            public RCGuildVoiceChannel getDefaultInstanceForType() {
                return RCGuildVoiceChannel.getDefaultInstance();
            }

            public b v(CoverInfo coverInfo) {
                bu<CoverInfo, CoverInfo.b, e> buVar = this.D;
                if (buVar == null) {
                    CoverInfo coverInfo2 = this.C;
                    if (coverInfo2 != null) {
                        this.C = CoverInfo.newBuilder(coverInfo2).x(coverInfo).buildPartial();
                    } else {
                        this.C = coverInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(coverInfo);
                }
                return this;
            }

            public b w(guildRecommendChannel.VoiceChannel voiceChannel) {
                bu<guildRecommendChannel.VoiceChannel, guildRecommendChannel.VoiceChannel.b, guildRecommendChannel.c> buVar = this.f381560m;
                if (buVar == null) {
                    guildRecommendChannel.VoiceChannel voiceChannel2 = this.f381559i;
                    if (voiceChannel2 != null) {
                        this.f381559i = guildRecommendChannel.VoiceChannel.newBuilder(voiceChannel2).x(voiceChannel).buildPartial();
                    } else {
                        this.f381559i = voiceChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(voiceChannel);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                RCGuildVoiceChannel rCGuildVoiceChannel = null;
                try {
                    try {
                        RCGuildVoiceChannel rCGuildVoiceChannel2 = (RCGuildVoiceChannel) RCGuildVoiceChannel.f381558e.g(kVar, tVar);
                        if (rCGuildVoiceChannel2 != null) {
                            z(rCGuildVoiceChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        RCGuildVoiceChannel rCGuildVoiceChannel3 = (RCGuildVoiceChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            rCGuildVoiceChannel = rCGuildVoiceChannel3;
                            if (rCGuildVoiceChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (rCGuildVoiceChannel != null) {
                        z(rCGuildVoiceChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof RCGuildVoiceChannel) {
                    return z((RCGuildVoiceChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b z(RCGuildVoiceChannel rCGuildVoiceChannel) {
                if (rCGuildVoiceChannel == RCGuildVoiceChannel.getDefaultInstance()) {
                    return this;
                }
                if (rCGuildVoiceChannel.hasData()) {
                    w(rCGuildVoiceChannel.getData());
                }
                if (rCGuildVoiceChannel.hasCover()) {
                    v(rCGuildVoiceChannel.getCover());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) rCGuildVoiceChannel).unknownFields);
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

        public static b newBuilder(RCGuildVoiceChannel rCGuildVoiceChannel) {
            return f381557d.toBuilder().z(rCGuildVoiceChannel);
        }

        public static RCGuildVoiceChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381558e.m(byteBuffer, tVar);
        }

        RCGuildVoiceChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RCGuildVoiceChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (RCGuildVoiceChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381558e, inputStream, tVar);
        }

        public static RCGuildVoiceChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381558e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public RCGuildVoiceChannel getDefaultInstanceForType() {
            return f381557d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381557d ? new b() : new b().z(this);
        }

        public static RCGuildVoiceChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381558e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        RCGuildVoiceChannel() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RCGuildVoiceChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381558e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static RCGuildVoiceChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381558e.i(bArr, tVar);
        }

        RCGuildVoiceChannel(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                guildRecommendChannel.VoiceChannel voiceChannel = this.data_;
                                guildRecommendChannel.VoiceChannel.b builder = voiceChannel != null ? voiceChannel.toBuilder() : null;
                                guildRecommendChannel.VoiceChannel voiceChannel2 = (guildRecommendChannel.VoiceChannel) kVar.z(guildRecommendChannel.VoiceChannel.parser(), tVar);
                                this.data_ = voiceChannel2;
                                if (builder != null) {
                                    builder.x(voiceChannel2);
                                    this.data_ = builder.buildPartial();
                                }
                            } else if (J != 18) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                CoverInfo coverInfo = this.cover_;
                                CoverInfo.b builder2 = coverInfo != null ? coverInfo.toBuilder() : null;
                                CoverInfo coverInfo2 = (CoverInfo) kVar.z(CoverInfo.parser(), tVar);
                                this.cover_ = coverInfo2;
                                if (builder2 != null) {
                                    builder2.x(coverInfo2);
                                    this.cover_ = builder2.buildPartial();
                                }
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

        public static RCGuildVoiceChannel parseFrom(InputStream inputStream) throws IOException {
            return (RCGuildVoiceChannel) GeneratedMessageV3.parseWithIOException(f381558e, inputStream);
        }

        public static RCGuildVoiceChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (RCGuildVoiceChannel) GeneratedMessageV3.parseWithIOException(f381558e, inputStream, tVar);
        }

        public static RCGuildVoiceChannel parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (RCGuildVoiceChannel) GeneratedMessageV3.parseWithIOException(f381558e, kVar);
        }

        public static RCGuildVoiceChannel parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (RCGuildVoiceChannel) GeneratedMessageV3.parseWithIOException(f381558e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RGGuildWorldChannel extends GeneratedMessageV3 implements q {
        public static final int COVER_FIELD_NUMBER = 2;
        public static final int DATA_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final RGGuildWorldChannel f381561d = new RGGuildWorldChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<RGGuildWorldChannel> f381562e = new a();
        private static final long serialVersionUID = 0;
        private CoverInfo cover_;
        private guildRecommendChannel.WorldChannel data_;
        private byte memoizedIsInitialized;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<RGGuildWorldChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public RGGuildWorldChannel g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new RGGuildWorldChannel(kVar, tVar);
            }
        }

        public static RGGuildWorldChannel getDefaultInstance() {
            return f381561d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381491q;
        }

        public static b newBuilder() {
            return f381561d.toBuilder();
        }

        public static RGGuildWorldChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RGGuildWorldChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381562e, inputStream);
        }

        public static RGGuildWorldChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381562e.d(byteBuffer);
        }

        public static bg<RGGuildWorldChannel> parser() {
            return f381562e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RGGuildWorldChannel)) {
                return super.equals(obj);
            }
            RGGuildWorldChannel rGGuildWorldChannel = (RGGuildWorldChannel) obj;
            if (hasData() != rGGuildWorldChannel.hasData()) {
                return false;
            }
            if ((hasData() && !getData().equals(rGGuildWorldChannel.getData())) || hasCover() != rGGuildWorldChannel.hasCover()) {
                return false;
            }
            if ((!hasCover() || getCover().equals(rGGuildWorldChannel.getCover())) && this.unknownFields.equals(rGGuildWorldChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        public CoverInfo getCover() {
            CoverInfo coverInfo = this.cover_;
            if (coverInfo == null) {
                return CoverInfo.getDefaultInstance();
            }
            return coverInfo;
        }

        public e getCoverOrBuilder() {
            return getCover();
        }

        public guildRecommendChannel.WorldChannel getData() {
            guildRecommendChannel.WorldChannel worldChannel = this.data_;
            if (worldChannel == null) {
                return guildRecommendChannel.WorldChannel.getDefaultInstance();
            }
            return worldChannel;
        }

        public guildRecommendChannel.d getDataOrBuilder() {
            return getData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<RGGuildWorldChannel> getParserForType() {
            return f381562e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = 0;
            if (this.data_ != null) {
                i16 = 0 + CodedOutputStream.G(1, getData());
            }
            if (this.cover_ != null) {
                i16 += CodedOutputStream.G(2, getCover());
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasCover() {
            if (this.cover_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasData() {
            if (this.data_ != null) {
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
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasData()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getData().hashCode();
            }
            if (hasCover()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getCover().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381492r.e(RGGuildWorldChannel.class, b.class);
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
            return new RGGuildWorldChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.data_ != null) {
                codedOutputStream.K0(1, getData());
            }
            if (this.cover_ != null) {
                codedOutputStream.K0(2, getCover());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements q {
            private CoverInfo C;
            private bu<CoverInfo, CoverInfo.b, e> D;

            /* renamed from: i, reason: collision with root package name */
            private guildRecommendChannel.WorldChannel f381563i;

            /* renamed from: m, reason: collision with root package name */
            private bu<guildRecommendChannel.WorldChannel, guildRecommendChannel.WorldChannel.b, guildRecommendChannel.d> f381564m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
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

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381491q;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381492r.e(RGGuildWorldChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public RGGuildWorldChannel build() {
                RGGuildWorldChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public RGGuildWorldChannel buildPartial() {
                RGGuildWorldChannel rGGuildWorldChannel = new RGGuildWorldChannel(this);
                bu<guildRecommendChannel.WorldChannel, guildRecommendChannel.WorldChannel.b, guildRecommendChannel.d> buVar = this.f381564m;
                if (buVar == null) {
                    rGGuildWorldChannel.data_ = this.f381563i;
                } else {
                    rGGuildWorldChannel.data_ = buVar.b();
                }
                bu<CoverInfo, CoverInfo.b, e> buVar2 = this.D;
                if (buVar2 == null) {
                    rGGuildWorldChannel.cover_ = this.C;
                } else {
                    rGGuildWorldChannel.cover_ = buVar2.b();
                }
                onBuilt();
                return rGGuildWorldChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.f381564m == null) {
                    this.f381563i = null;
                } else {
                    this.f381563i = null;
                    this.f381564m = null;
                }
                if (this.D == null) {
                    this.C = null;
                } else {
                    this.C = null;
                    this.D = null;
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
            public RGGuildWorldChannel getDefaultInstanceForType() {
                return RGGuildWorldChannel.getDefaultInstance();
            }

            public b v(CoverInfo coverInfo) {
                bu<CoverInfo, CoverInfo.b, e> buVar = this.D;
                if (buVar == null) {
                    CoverInfo coverInfo2 = this.C;
                    if (coverInfo2 != null) {
                        this.C = CoverInfo.newBuilder(coverInfo2).x(coverInfo).buildPartial();
                    } else {
                        this.C = coverInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(coverInfo);
                }
                return this;
            }

            public b w(guildRecommendChannel.WorldChannel worldChannel) {
                bu<guildRecommendChannel.WorldChannel, guildRecommendChannel.WorldChannel.b, guildRecommendChannel.d> buVar = this.f381564m;
                if (buVar == null) {
                    guildRecommendChannel.WorldChannel worldChannel2 = this.f381563i;
                    if (worldChannel2 != null) {
                        this.f381563i = guildRecommendChannel.WorldChannel.newBuilder(worldChannel2).x(worldChannel).buildPartial();
                    } else {
                        this.f381563i = worldChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(worldChannel);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                RGGuildWorldChannel rGGuildWorldChannel = null;
                try {
                    try {
                        RGGuildWorldChannel rGGuildWorldChannel2 = (RGGuildWorldChannel) RGGuildWorldChannel.f381562e.g(kVar, tVar);
                        if (rGGuildWorldChannel2 != null) {
                            z(rGGuildWorldChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        RGGuildWorldChannel rGGuildWorldChannel3 = (RGGuildWorldChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            rGGuildWorldChannel = rGGuildWorldChannel3;
                            if (rGGuildWorldChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (rGGuildWorldChannel != null) {
                        z(rGGuildWorldChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof RGGuildWorldChannel) {
                    return z((RGGuildWorldChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b z(RGGuildWorldChannel rGGuildWorldChannel) {
                if (rGGuildWorldChannel == RGGuildWorldChannel.getDefaultInstance()) {
                    return this;
                }
                if (rGGuildWorldChannel.hasData()) {
                    w(rGGuildWorldChannel.getData());
                }
                if (rGGuildWorldChannel.hasCover()) {
                    v(rGGuildWorldChannel.getCover());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) rGGuildWorldChannel).unknownFields);
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

        public static b newBuilder(RGGuildWorldChannel rGGuildWorldChannel) {
            return f381561d.toBuilder().z(rGGuildWorldChannel);
        }

        public static RGGuildWorldChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381562e.m(byteBuffer, tVar);
        }

        RGGuildWorldChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RGGuildWorldChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (RGGuildWorldChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381562e, inputStream, tVar);
        }

        public static RGGuildWorldChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381562e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public RGGuildWorldChannel getDefaultInstanceForType() {
            return f381561d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381561d ? new b() : new b().z(this);
        }

        public static RGGuildWorldChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381562e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        RGGuildWorldChannel() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RGGuildWorldChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381562e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static RGGuildWorldChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381562e.i(bArr, tVar);
        }

        RGGuildWorldChannel(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                guildRecommendChannel.WorldChannel worldChannel = this.data_;
                                guildRecommendChannel.WorldChannel.b builder = worldChannel != null ? worldChannel.toBuilder() : null;
                                guildRecommendChannel.WorldChannel worldChannel2 = (guildRecommendChannel.WorldChannel) kVar.z(guildRecommendChannel.WorldChannel.parser(), tVar);
                                this.data_ = worldChannel2;
                                if (builder != null) {
                                    builder.x(worldChannel2);
                                    this.data_ = builder.buildPartial();
                                }
                            } else if (J != 18) {
                                if (!parseUnknownField(kVar, g16, tVar, J)) {
                                }
                            } else {
                                CoverInfo coverInfo = this.cover_;
                                CoverInfo.b builder2 = coverInfo != null ? coverInfo.toBuilder() : null;
                                CoverInfo coverInfo2 = (CoverInfo) kVar.z(CoverInfo.parser(), tVar);
                                this.cover_ = coverInfo2;
                                if (builder2 != null) {
                                    builder2.x(coverInfo2);
                                    this.cover_ = builder2.buildPartial();
                                }
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

        public static RGGuildWorldChannel parseFrom(InputStream inputStream) throws IOException {
            return (RGGuildWorldChannel) GeneratedMessageV3.parseWithIOException(f381562e, inputStream);
        }

        public static RGGuildWorldChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (RGGuildWorldChannel) GeneratedMessageV3.parseWithIOException(f381562e, inputStream, tVar);
        }

        public static RGGuildWorldChannel parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (RGGuildWorldChannel) GeneratedMessageV3.parseWithIOException(f381562e, kVar);
        }

        public static RGGuildWorldChannel parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (RGGuildWorldChannel) GeneratedMessageV3.parseWithIOException(f381562e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RecommendItem extends GeneratedMessageV3 implements ax {
        public static final int AD_INFO_FIELD_NUMBER = 11;
        public static final int CATEGORIES_FIELD_NUMBER = 9;
        public static final int CHANNEL_INFO_FIELD_NUMBER = 3;
        public static final int FEED_FIELD_NUMBER = 6;
        public static final int FORUM_CHANNEL_FIELD_NUMBER = 12;
        public static final int H5GAME_CHANNEL_FIELD_NUMBER = 10;
        public static final int ITEM_ID_FIELD_NUMBER = 1;
        public static final int ITEM_ID_UINT64_FIELD_NUMBER = 8;
        public static final int ITEM_TYPE_FIELD_NUMBER = 2;
        public static final int LIVE_CHANNEL_FIELD_NUMBER = 4;
        public static final int VOICE_CHANNEL_FIELD_NUMBER = 5;
        public static final int VOICE_TEMPLATE_FIELD_NUMBER = 13;
        public static final int WORLD_CHANNEL_FIELD_NUMBER = 7;

        /* renamed from: d, reason: collision with root package name */
        private static final RecommendItem f381565d = new RecommendItem();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<RecommendItem> f381566e = new a();
        private static final long serialVersionUID = 0;
        private AdInfo adInfo_;
        private List<Category> categories_;
        private ChannelInfo channelInfo_;
        private Feed feed_;
        private ForumChannel forumChannel_;
        private H5GameChannel h5GameChannel_;
        private long itemIdUint64_;
        private volatile Object itemId_;
        private int itemType_;
        private RCGuildLiveChannel liveChannel_;
        private byte memoizedIsInitialized;
        private RCGuildVoiceChannel voiceChannel_;
        private VoiceTemplateChannel voiceTemplate_;
        private RGGuildWorldChannel worldChannel_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<RecommendItem> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public RecommendItem g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new RecommendItem(kVar, tVar);
            }
        }

        public static RecommendItem getDefaultInstance() {
            return f381565d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381475a;
        }

        public static b newBuilder() {
            return f381565d.toBuilder();
        }

        public static RecommendItem parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RecommendItem) GeneratedMessageV3.parseDelimitedWithIOException(f381566e, inputStream);
        }

        public static RecommendItem parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381566e.d(byteBuffer);
        }

        public static bg<RecommendItem> parser() {
            return f381566e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RecommendItem)) {
                return super.equals(obj);
            }
            RecommendItem recommendItem = (RecommendItem) obj;
            if (!getItemId().equals(recommendItem.getItemId()) || this.itemType_ != recommendItem.itemType_ || hasChannelInfo() != recommendItem.hasChannelInfo()) {
                return false;
            }
            if ((hasChannelInfo() && !getChannelInfo().equals(recommendItem.getChannelInfo())) || hasLiveChannel() != recommendItem.hasLiveChannel()) {
                return false;
            }
            if ((hasLiveChannel() && !getLiveChannel().equals(recommendItem.getLiveChannel())) || hasVoiceChannel() != recommendItem.hasVoiceChannel()) {
                return false;
            }
            if ((hasVoiceChannel() && !getVoiceChannel().equals(recommendItem.getVoiceChannel())) || hasFeed() != recommendItem.hasFeed()) {
                return false;
            }
            if ((hasFeed() && !getFeed().equals(recommendItem.getFeed())) || hasWorldChannel() != recommendItem.hasWorldChannel()) {
                return false;
            }
            if ((hasWorldChannel() && !getWorldChannel().equals(recommendItem.getWorldChannel())) || getItemIdUint64() != recommendItem.getItemIdUint64() || !getCategoriesList().equals(recommendItem.getCategoriesList()) || hasH5GameChannel() != recommendItem.hasH5GameChannel()) {
                return false;
            }
            if ((hasH5GameChannel() && !getH5GameChannel().equals(recommendItem.getH5GameChannel())) || hasAdInfo() != recommendItem.hasAdInfo()) {
                return false;
            }
            if ((hasAdInfo() && !getAdInfo().equals(recommendItem.getAdInfo())) || hasForumChannel() != recommendItem.hasForumChannel()) {
                return false;
            }
            if ((hasForumChannel() && !getForumChannel().equals(recommendItem.getForumChannel())) || hasVoiceTemplate() != recommendItem.hasVoiceTemplate()) {
                return false;
            }
            if ((!hasVoiceTemplate() || getVoiceTemplate().equals(recommendItem.getVoiceTemplate())) && this.unknownFields.equals(recommendItem.unknownFields)) {
                return true;
            }
            return false;
        }

        public AdInfo getAdInfo() {
            AdInfo adInfo = this.adInfo_;
            if (adInfo == null) {
                return AdInfo.getDefaultInstance();
            }
            return adInfo;
        }

        public b getAdInfoOrBuilder() {
            return getAdInfo();
        }

        public Category getCategories(int i3) {
            return this.categories_.get(i3);
        }

        public int getCategoriesCount() {
            return this.categories_.size();
        }

        public List<Category> getCategoriesList() {
            return this.categories_;
        }

        public c getCategoriesOrBuilder(int i3) {
            return this.categories_.get(i3);
        }

        public List<? extends c> getCategoriesOrBuilderList() {
            return this.categories_;
        }

        public ChannelInfo getChannelInfo() {
            ChannelInfo channelInfo = this.channelInfo_;
            if (channelInfo == null) {
                return ChannelInfo.getDefaultInstance();
            }
            return channelInfo;
        }

        public d getChannelInfoOrBuilder() {
            return getChannelInfo();
        }

        public Feed getFeed() {
            Feed feed = this.feed_;
            if (feed == null) {
                return Feed.getDefaultInstance();
            }
            return feed;
        }

        public f getFeedOrBuilder() {
            return getFeed();
        }

        public ForumChannel getForumChannel() {
            ForumChannel forumChannel = this.forumChannel_;
            if (forumChannel == null) {
                return ForumChannel.getDefaultInstance();
            }
            return forumChannel;
        }

        public g getForumChannelOrBuilder() {
            return getForumChannel();
        }

        public H5GameChannel getH5GameChannel() {
            H5GameChannel h5GameChannel = this.h5GameChannel_;
            if (h5GameChannel == null) {
                return H5GameChannel.getDefaultInstance();
            }
            return h5GameChannel;
        }

        public j getH5GameChannelOrBuilder() {
            return getH5GameChannel();
        }

        public String getItemId() {
            Object obj = this.itemId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.itemId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getItemIdBytes() {
            Object obj = this.itemId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.itemId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public long getItemIdUint64() {
            return this.itemIdUint64_;
        }

        public ItemType getItemType() {
            ItemType valueOf = ItemType.valueOf(this.itemType_);
            if (valueOf == null) {
                return ItemType.UNRECOGNIZED;
            }
            return valueOf;
        }

        public int getItemTypeValue() {
            return this.itemType_;
        }

        public RCGuildLiveChannel getLiveChannel() {
            RCGuildLiveChannel rCGuildLiveChannel = this.liveChannel_;
            if (rCGuildLiveChannel == null) {
                return RCGuildLiveChannel.getDefaultInstance();
            }
            return rCGuildLiveChannel;
        }

        public n getLiveChannelOrBuilder() {
            return getLiveChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<RecommendItem> getParserForType() {
            return f381566e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3;
            int i16 = this.memoizedSize;
            if (i16 != -1) {
                return i16;
            }
            if (!getItemIdBytes().isEmpty()) {
                i3 = GeneratedMessageV3.computeStringSize(1, this.itemId_) + 0;
            } else {
                i3 = 0;
            }
            if (this.itemType_ != ItemType.TYPE_UNKOWN.getNumber()) {
                i3 += CodedOutputStream.l(2, this.itemType_);
            }
            if (this.channelInfo_ != null) {
                i3 += CodedOutputStream.G(3, getChannelInfo());
            }
            if (this.liveChannel_ != null) {
                i3 += CodedOutputStream.G(4, getLiveChannel());
            }
            if (this.voiceChannel_ != null) {
                i3 += CodedOutputStream.G(5, getVoiceChannel());
            }
            if (this.feed_ != null) {
                i3 += CodedOutputStream.G(6, getFeed());
            }
            if (this.worldChannel_ != null) {
                i3 += CodedOutputStream.G(7, getWorldChannel());
            }
            long j3 = this.itemIdUint64_;
            if (j3 != 0) {
                i3 += CodedOutputStream.a0(8, j3);
            }
            for (int i17 = 0; i17 < this.categories_.size(); i17++) {
                i3 += CodedOutputStream.G(9, this.categories_.get(i17));
            }
            if (this.h5GameChannel_ != null) {
                i3 += CodedOutputStream.G(10, getH5GameChannel());
            }
            if (this.adInfo_ != null) {
                i3 += CodedOutputStream.G(11, getAdInfo());
            }
            if (this.forumChannel_ != null) {
                i3 += CodedOutputStream.G(12, getForumChannel());
            }
            if (this.voiceTemplate_ != null) {
                i3 += CodedOutputStream.G(13, getVoiceTemplate());
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public RCGuildVoiceChannel getVoiceChannel() {
            RCGuildVoiceChannel rCGuildVoiceChannel = this.voiceChannel_;
            if (rCGuildVoiceChannel == null) {
                return RCGuildVoiceChannel.getDefaultInstance();
            }
            return rCGuildVoiceChannel;
        }

        public p getVoiceChannelOrBuilder() {
            return getVoiceChannel();
        }

        public VoiceTemplateChannel getVoiceTemplate() {
            VoiceTemplateChannel voiceTemplateChannel = this.voiceTemplate_;
            if (voiceTemplateChannel == null) {
                return VoiceTemplateChannel.getDefaultInstance();
            }
            return voiceTemplateChannel;
        }

        public s getVoiceTemplateOrBuilder() {
            return getVoiceTemplate();
        }

        public RGGuildWorldChannel getWorldChannel() {
            RGGuildWorldChannel rGGuildWorldChannel = this.worldChannel_;
            if (rGGuildWorldChannel == null) {
                return RGGuildWorldChannel.getDefaultInstance();
            }
            return rGGuildWorldChannel;
        }

        public q getWorldChannelOrBuilder() {
            return getWorldChannel();
        }

        public boolean hasAdInfo() {
            if (this.adInfo_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasChannelInfo() {
            if (this.channelInfo_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasFeed() {
            if (this.feed_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasForumChannel() {
            if (this.forumChannel_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasH5GameChannel() {
            if (this.h5GameChannel_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasLiveChannel() {
            if (this.liveChannel_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasVoiceChannel() {
            if (this.voiceChannel_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasVoiceTemplate() {
            if (this.voiceTemplate_ != null) {
                return true;
            }
            return false;
        }

        public boolean hasWorldChannel() {
            if (this.worldChannel_ != null) {
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
            int hashCode = ((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getItemId().hashCode()) * 37) + 2) * 53) + this.itemType_;
            if (hasChannelInfo()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getChannelInfo().hashCode();
            }
            if (hasLiveChannel()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getLiveChannel().hashCode();
            }
            if (hasVoiceChannel()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getVoiceChannel().hashCode();
            }
            if (hasFeed()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getFeed().hashCode();
            }
            if (hasWorldChannel()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getWorldChannel().hashCode();
            }
            int h16 = (((hashCode * 37) + 8) * 53) + ad.h(getItemIdUint64());
            if (getCategoriesCount() > 0) {
                h16 = (((h16 * 37) + 9) * 53) + getCategoriesList().hashCode();
            }
            if (hasH5GameChannel()) {
                h16 = (((h16 * 37) + 10) * 53) + getH5GameChannel().hashCode();
            }
            if (hasAdInfo()) {
                h16 = (((h16 * 37) + 11) * 53) + getAdInfo().hashCode();
            }
            if (hasForumChannel()) {
                h16 = (((h16 * 37) + 12) * 53) + getForumChannel().hashCode();
            }
            if (hasVoiceTemplate()) {
                h16 = (((h16 * 37) + 13) * 53) + getVoiceTemplate().hashCode();
            }
            int hashCode2 = (h16 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381476b.e(RecommendItem.class, b.class);
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
            return new RecommendItem();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getItemIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.itemId_);
            }
            if (this.itemType_ != ItemType.TYPE_UNKOWN.getNumber()) {
                codedOutputStream.u0(2, this.itemType_);
            }
            if (this.channelInfo_ != null) {
                codedOutputStream.K0(3, getChannelInfo());
            }
            if (this.liveChannel_ != null) {
                codedOutputStream.K0(4, getLiveChannel());
            }
            if (this.voiceChannel_ != null) {
                codedOutputStream.K0(5, getVoiceChannel());
            }
            if (this.feed_ != null) {
                codedOutputStream.K0(6, getFeed());
            }
            if (this.worldChannel_ != null) {
                codedOutputStream.K0(7, getWorldChannel());
            }
            long j3 = this.itemIdUint64_;
            if (j3 != 0) {
                codedOutputStream.d1(8, j3);
            }
            for (int i3 = 0; i3 < this.categories_.size(); i3++) {
                codedOutputStream.K0(9, this.categories_.get(i3));
            }
            if (this.h5GameChannel_ != null) {
                codedOutputStream.K0(10, getH5GameChannel());
            }
            if (this.adInfo_ != null) {
                codedOutputStream.K0(11, getAdInfo());
            }
            if (this.forumChannel_ != null) {
                codedOutputStream.K0(12, getForumChannel());
            }
            if (this.voiceTemplate_ != null) {
                codedOutputStream.K0(13, getVoiceTemplate());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements ax {
            private int C;
            private ChannelInfo D;
            private bu<ChannelInfo, ChannelInfo.b, d> E;
            private RCGuildLiveChannel F;
            private bu<RCGuildLiveChannel, RCGuildLiveChannel.b, n> G;
            private RCGuildVoiceChannel H;
            private bu<RCGuildVoiceChannel, RCGuildVoiceChannel.b, p> I;
            private Feed J;
            private bu<Feed, Feed.b, f> K;
            private RGGuildWorldChannel L;
            private bu<RGGuildWorldChannel, RGGuildWorldChannel.b, q> M;
            private long N;
            private List<Category> P;
            private bp<Category, Category.b, c> Q;
            private H5GameChannel R;
            private bu<H5GameChannel, H5GameChannel.b, j> S;
            private AdInfo T;
            private bu<AdInfo, AdInfo.b, b> U;
            private ForumChannel V;
            private bu<ForumChannel, ForumChannel.b, g> W;
            private VoiceTemplateChannel X;
            private bu<VoiceTemplateChannel, VoiceTemplateChannel.b, s> Y;

            /* renamed from: i, reason: collision with root package name */
            private int f381567i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381568m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    v();
                }
            }

            private void u() {
                if ((this.f381567i & 1) == 0) {
                    this.P = new ArrayList(this.P);
                    this.f381567i |= 1;
                }
            }

            private bp<Category, Category.b, c> v() {
                if (this.Q == null) {
                    List<Category> list = this.P;
                    boolean z16 = true;
                    if ((this.f381567i & 1) == 0) {
                        z16 = false;
                    }
                    this.Q = new bp<>(list, z16, h(), isClean());
                    this.P = null;
                }
                return this.Q;
            }

            public b A(ForumChannel forumChannel) {
                bu<ForumChannel, ForumChannel.b, g> buVar = this.W;
                if (buVar == null) {
                    ForumChannel forumChannel2 = this.V;
                    if (forumChannel2 != null) {
                        this.V = ForumChannel.newBuilder(forumChannel2).x(forumChannel).buildPartial();
                    } else {
                        this.V = forumChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(forumChannel);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                RecommendItem recommendItem = null;
                try {
                    try {
                        RecommendItem recommendItem2 = (RecommendItem) RecommendItem.f381566e.g(kVar, tVar);
                        if (recommendItem2 != null) {
                            D(recommendItem2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        RecommendItem recommendItem3 = (RecommendItem) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            recommendItem = recommendItem3;
                            if (recommendItem != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (recommendItem != null) {
                        D(recommendItem);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof RecommendItem) {
                    return D((RecommendItem) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b D(RecommendItem recommendItem) {
                if (recommendItem == RecommendItem.getDefaultInstance()) {
                    return this;
                }
                if (!recommendItem.getItemId().isEmpty()) {
                    this.f381568m = recommendItem.itemId_;
                    onChanged();
                }
                if (recommendItem.itemType_ != 0) {
                    M(recommendItem.getItemTypeValue());
                }
                if (recommendItem.hasChannelInfo()) {
                    y(recommendItem.getChannelInfo());
                }
                if (recommendItem.hasLiveChannel()) {
                    F(recommendItem.getLiveChannel());
                }
                if (recommendItem.hasVoiceChannel()) {
                    H(recommendItem.getVoiceChannel());
                }
                if (recommendItem.hasFeed()) {
                    z(recommendItem.getFeed());
                }
                if (recommendItem.hasWorldChannel()) {
                    J(recommendItem.getWorldChannel());
                }
                if (recommendItem.getItemIdUint64() != 0) {
                    L(recommendItem.getItemIdUint64());
                }
                if (this.Q == null) {
                    if (!recommendItem.categories_.isEmpty()) {
                        if (this.P.isEmpty()) {
                            this.P = recommendItem.categories_;
                            this.f381567i &= -2;
                        } else {
                            u();
                            this.P.addAll(recommendItem.categories_);
                        }
                        onChanged();
                    }
                } else if (!recommendItem.categories_.isEmpty()) {
                    if (this.Q.j()) {
                        this.Q.f();
                        bp<Category, Category.b, c> bpVar = null;
                        this.Q = null;
                        this.P = recommendItem.categories_;
                        this.f381567i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = v();
                        }
                        this.Q = bpVar;
                    } else {
                        this.Q.b(recommendItem.categories_);
                    }
                }
                if (recommendItem.hasH5GameChannel()) {
                    E(recommendItem.getH5GameChannel());
                }
                if (recommendItem.hasAdInfo()) {
                    x(recommendItem.getAdInfo());
                }
                if (recommendItem.hasForumChannel()) {
                    A(recommendItem.getForumChannel());
                }
                if (recommendItem.hasVoiceTemplate()) {
                    I(recommendItem.getVoiceTemplate());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) recommendItem).unknownFields);
                onChanged();
                return this;
            }

            public b E(H5GameChannel h5GameChannel) {
                bu<H5GameChannel, H5GameChannel.b, j> buVar = this.S;
                if (buVar == null) {
                    H5GameChannel h5GameChannel2 = this.R;
                    if (h5GameChannel2 != null) {
                        this.R = H5GameChannel.newBuilder(h5GameChannel2).z(h5GameChannel).buildPartial();
                    } else {
                        this.R = h5GameChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(h5GameChannel);
                }
                return this;
            }

            public b F(RCGuildLiveChannel rCGuildLiveChannel) {
                bu<RCGuildLiveChannel, RCGuildLiveChannel.b, n> buVar = this.G;
                if (buVar == null) {
                    RCGuildLiveChannel rCGuildLiveChannel2 = this.F;
                    if (rCGuildLiveChannel2 != null) {
                        this.F = RCGuildLiveChannel.newBuilder(rCGuildLiveChannel2).B(rCGuildLiveChannel).buildPartial();
                    } else {
                        this.F = rCGuildLiveChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(rCGuildLiveChannel);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b H(RCGuildVoiceChannel rCGuildVoiceChannel) {
                bu<RCGuildVoiceChannel, RCGuildVoiceChannel.b, p> buVar = this.I;
                if (buVar == null) {
                    RCGuildVoiceChannel rCGuildVoiceChannel2 = this.H;
                    if (rCGuildVoiceChannel2 != null) {
                        this.H = RCGuildVoiceChannel.newBuilder(rCGuildVoiceChannel2).z(rCGuildVoiceChannel).buildPartial();
                    } else {
                        this.H = rCGuildVoiceChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(rCGuildVoiceChannel);
                }
                return this;
            }

            public b I(VoiceTemplateChannel voiceTemplateChannel) {
                bu<VoiceTemplateChannel, VoiceTemplateChannel.b, s> buVar = this.Y;
                if (buVar == null) {
                    VoiceTemplateChannel voiceTemplateChannel2 = this.X;
                    if (voiceTemplateChannel2 != null) {
                        this.X = VoiceTemplateChannel.newBuilder(voiceTemplateChannel2).A(voiceTemplateChannel).buildPartial();
                    } else {
                        this.X = voiceTemplateChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(voiceTemplateChannel);
                }
                return this;
            }

            public b J(RGGuildWorldChannel rGGuildWorldChannel) {
                bu<RGGuildWorldChannel, RGGuildWorldChannel.b, q> buVar = this.M;
                if (buVar == null) {
                    RGGuildWorldChannel rGGuildWorldChannel2 = this.L;
                    if (rGGuildWorldChannel2 != null) {
                        this.L = RGGuildWorldChannel.newBuilder(rGGuildWorldChannel2).z(rGGuildWorldChannel).buildPartial();
                    } else {
                        this.L = rGGuildWorldChannel;
                    }
                    onChanged();
                } else {
                    buVar.g(rGGuildWorldChannel);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: K, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b L(long j3) {
                this.N = j3;
                onChanged();
                return this;
            }

            public b M(int i3) {
                this.C = i3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: N, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(cc ccVar) {
                return (b) super.setUnknownFields(ccVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a, com.google.protobuf.ax
            public Descriptors.b getDescriptorForType() {
                return common.f381475a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381476b.e(RecommendItem.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public RecommendItem build() {
                RecommendItem buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public RecommendItem buildPartial() {
                RecommendItem recommendItem = new RecommendItem(this);
                recommendItem.itemId_ = this.f381568m;
                recommendItem.itemType_ = this.C;
                bu<ChannelInfo, ChannelInfo.b, d> buVar = this.E;
                if (buVar == null) {
                    recommendItem.channelInfo_ = this.D;
                } else {
                    recommendItem.channelInfo_ = buVar.b();
                }
                bu<RCGuildLiveChannel, RCGuildLiveChannel.b, n> buVar2 = this.G;
                if (buVar2 == null) {
                    recommendItem.liveChannel_ = this.F;
                } else {
                    recommendItem.liveChannel_ = buVar2.b();
                }
                bu<RCGuildVoiceChannel, RCGuildVoiceChannel.b, p> buVar3 = this.I;
                if (buVar3 == null) {
                    recommendItem.voiceChannel_ = this.H;
                } else {
                    recommendItem.voiceChannel_ = buVar3.b();
                }
                bu<Feed, Feed.b, f> buVar4 = this.K;
                if (buVar4 == null) {
                    recommendItem.feed_ = this.J;
                } else {
                    recommendItem.feed_ = buVar4.b();
                }
                bu<RGGuildWorldChannel, RGGuildWorldChannel.b, q> buVar5 = this.M;
                if (buVar5 == null) {
                    recommendItem.worldChannel_ = this.L;
                } else {
                    recommendItem.worldChannel_ = buVar5.b();
                }
                recommendItem.itemIdUint64_ = this.N;
                bp<Category, Category.b, c> bpVar = this.Q;
                if (bpVar != null) {
                    recommendItem.categories_ = bpVar.d();
                } else {
                    if ((this.f381567i & 1) != 0) {
                        this.P = Collections.unmodifiableList(this.P);
                        this.f381567i &= -2;
                    }
                    recommendItem.categories_ = this.P;
                }
                bu<H5GameChannel, H5GameChannel.b, j> buVar6 = this.S;
                if (buVar6 == null) {
                    recommendItem.h5GameChannel_ = this.R;
                } else {
                    recommendItem.h5GameChannel_ = buVar6.b();
                }
                bu<AdInfo, AdInfo.b, b> buVar7 = this.U;
                if (buVar7 == null) {
                    recommendItem.adInfo_ = this.T;
                } else {
                    recommendItem.adInfo_ = buVar7.b();
                }
                bu<ForumChannel, ForumChannel.b, g> buVar8 = this.W;
                if (buVar8 == null) {
                    recommendItem.forumChannel_ = this.V;
                } else {
                    recommendItem.forumChannel_ = buVar8.b();
                }
                bu<VoiceTemplateChannel, VoiceTemplateChannel.b, s> buVar9 = this.Y;
                if (buVar9 == null) {
                    recommendItem.voiceTemplate_ = this.X;
                } else {
                    recommendItem.voiceTemplate_ = buVar9.b();
                }
                onBuilt();
                return recommendItem;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381568m = "";
                this.C = 0;
                if (this.E == null) {
                    this.D = null;
                } else {
                    this.D = null;
                    this.E = null;
                }
                if (this.G == null) {
                    this.F = null;
                } else {
                    this.F = null;
                    this.G = null;
                }
                if (this.I == null) {
                    this.H = null;
                } else {
                    this.H = null;
                    this.I = null;
                }
                if (this.K == null) {
                    this.J = null;
                } else {
                    this.J = null;
                    this.K = null;
                }
                if (this.M == null) {
                    this.L = null;
                } else {
                    this.L = null;
                    this.M = null;
                }
                this.N = 0L;
                bp<Category, Category.b, c> bpVar = this.Q;
                if (bpVar == null) {
                    this.P = Collections.emptyList();
                    this.f381567i &= -2;
                } else {
                    bpVar.e();
                }
                if (this.S == null) {
                    this.R = null;
                } else {
                    this.R = null;
                    this.S = null;
                }
                if (this.U == null) {
                    this.T = null;
                } else {
                    this.T = null;
                    this.U = null;
                }
                if (this.W == null) {
                    this.V = null;
                } else {
                    this.V = null;
                    this.W = null;
                }
                if (this.Y == null) {
                    this.X = null;
                } else {
                    this.X = null;
                    this.Y = null;
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public RecommendItem getDefaultInstanceForType() {
                return RecommendItem.getDefaultInstance();
            }

            public b x(AdInfo adInfo) {
                bu<AdInfo, AdInfo.b, b> buVar = this.U;
                if (buVar == null) {
                    AdInfo adInfo2 = this.T;
                    if (adInfo2 != null) {
                        this.T = AdInfo.newBuilder(adInfo2).x(adInfo).buildPartial();
                    } else {
                        this.T = adInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(adInfo);
                }
                return this;
            }

            public b y(ChannelInfo channelInfo) {
                bu<ChannelInfo, ChannelInfo.b, d> buVar = this.E;
                if (buVar == null) {
                    ChannelInfo channelInfo2 = this.D;
                    if (channelInfo2 != null) {
                        this.D = ChannelInfo.newBuilder(channelInfo2).z(channelInfo).buildPartial();
                    } else {
                        this.D = channelInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(channelInfo);
                }
                return this;
            }

            public b z(Feed feed) {
                bu<Feed, Feed.b, f> buVar = this.K;
                if (buVar == null) {
                    Feed feed2 = this.J;
                    if (feed2 != null) {
                        this.J = Feed.newBuilder(feed2).x(feed).buildPartial();
                    } else {
                        this.J = feed;
                    }
                    onChanged();
                } else {
                    buVar.g(feed);
                }
                return this;
            }

            b() {
                this.f381568m = "";
                this.C = 0;
                this.P = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381568m = "";
                this.C = 0;
                this.P = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(RecommendItem recommendItem) {
            return f381565d.toBuilder().D(recommendItem);
        }

        public static RecommendItem parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381566e.m(byteBuffer, tVar);
        }

        RecommendItem(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RecommendItem parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (RecommendItem) GeneratedMessageV3.parseDelimitedWithIOException(f381566e, inputStream, tVar);
        }

        public static RecommendItem parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381566e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public RecommendItem getDefaultInstanceForType() {
            return f381565d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381565d ? new b() : new b().D(this);
        }

        public static RecommendItem parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381566e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        RecommendItem() {
            this.memoizedIsInitialized = (byte) -1;
            this.itemId_ = "";
            this.itemType_ = 0;
            this.categories_ = Collections.emptyList();
        }

        public static RecommendItem parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381566e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static RecommendItem parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381566e.i(bArr, tVar);
        }

        public static RecommendItem parseFrom(InputStream inputStream) throws IOException {
            return (RecommendItem) GeneratedMessageV3.parseWithIOException(f381566e, inputStream);
        }

        public static RecommendItem parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (RecommendItem) GeneratedMessageV3.parseWithIOException(f381566e, inputStream, tVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0014. Please report as an issue. */
        RecommendItem(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        switch (J) {
                            case 0:
                                z16 = true;
                            case 10:
                                this.itemId_ = kVar.I();
                            case 16:
                                this.itemType_ = kVar.s();
                            case 26:
                                ChannelInfo channelInfo = this.channelInfo_;
                                ChannelInfo.b builder = channelInfo != null ? channelInfo.toBuilder() : null;
                                ChannelInfo channelInfo2 = (ChannelInfo) kVar.z(ChannelInfo.parser(), tVar);
                                this.channelInfo_ = channelInfo2;
                                if (builder != null) {
                                    builder.z(channelInfo2);
                                    this.channelInfo_ = builder.buildPartial();
                                }
                            case 34:
                                RCGuildLiveChannel rCGuildLiveChannel = this.liveChannel_;
                                RCGuildLiveChannel.b builder2 = rCGuildLiveChannel != null ? rCGuildLiveChannel.toBuilder() : null;
                                RCGuildLiveChannel rCGuildLiveChannel2 = (RCGuildLiveChannel) kVar.z(RCGuildLiveChannel.parser(), tVar);
                                this.liveChannel_ = rCGuildLiveChannel2;
                                if (builder2 != null) {
                                    builder2.B(rCGuildLiveChannel2);
                                    this.liveChannel_ = builder2.buildPartial();
                                }
                            case 42:
                                RCGuildVoiceChannel rCGuildVoiceChannel = this.voiceChannel_;
                                RCGuildVoiceChannel.b builder3 = rCGuildVoiceChannel != null ? rCGuildVoiceChannel.toBuilder() : null;
                                RCGuildVoiceChannel rCGuildVoiceChannel2 = (RCGuildVoiceChannel) kVar.z(RCGuildVoiceChannel.parser(), tVar);
                                this.voiceChannel_ = rCGuildVoiceChannel2;
                                if (builder3 != null) {
                                    builder3.z(rCGuildVoiceChannel2);
                                    this.voiceChannel_ = builder3.buildPartial();
                                }
                            case 50:
                                Feed feed = this.feed_;
                                Feed.b builder4 = feed != null ? feed.toBuilder() : null;
                                Feed feed2 = (Feed) kVar.z(Feed.parser(), tVar);
                                this.feed_ = feed2;
                                if (builder4 != null) {
                                    builder4.x(feed2);
                                    this.feed_ = builder4.buildPartial();
                                }
                            case 58:
                                RGGuildWorldChannel rGGuildWorldChannel = this.worldChannel_;
                                RGGuildWorldChannel.b builder5 = rGGuildWorldChannel != null ? rGGuildWorldChannel.toBuilder() : null;
                                RGGuildWorldChannel rGGuildWorldChannel2 = (RGGuildWorldChannel) kVar.z(RGGuildWorldChannel.parser(), tVar);
                                this.worldChannel_ = rGGuildWorldChannel2;
                                if (builder5 != null) {
                                    builder5.z(rGGuildWorldChannel2);
                                    this.worldChannel_ = builder5.buildPartial();
                                }
                            case 64:
                                this.itemIdUint64_ = kVar.L();
                            case 74:
                                boolean z18 = (z17 ? 1 : 0) & true;
                                z17 = z17;
                                if (!z18) {
                                    this.categories_ = new ArrayList();
                                    z17 = (z17 ? 1 : 0) | true;
                                }
                                this.categories_.add((Category) kVar.z(Category.parser(), tVar));
                            case 82:
                                H5GameChannel h5GameChannel = this.h5GameChannel_;
                                H5GameChannel.b builder6 = h5GameChannel != null ? h5GameChannel.toBuilder() : null;
                                H5GameChannel h5GameChannel2 = (H5GameChannel) kVar.z(H5GameChannel.parser(), tVar);
                                this.h5GameChannel_ = h5GameChannel2;
                                if (builder6 != null) {
                                    builder6.z(h5GameChannel2);
                                    this.h5GameChannel_ = builder6.buildPartial();
                                }
                            case 90:
                                AdInfo adInfo = this.adInfo_;
                                AdInfo.b builder7 = adInfo != null ? adInfo.toBuilder() : null;
                                AdInfo adInfo2 = (AdInfo) kVar.z(AdInfo.parser(), tVar);
                                this.adInfo_ = adInfo2;
                                if (builder7 != null) {
                                    builder7.x(adInfo2);
                                    this.adInfo_ = builder7.buildPartial();
                                }
                            case 98:
                                ForumChannel forumChannel = this.forumChannel_;
                                ForumChannel.b builder8 = forumChannel != null ? forumChannel.toBuilder() : null;
                                ForumChannel forumChannel2 = (ForumChannel) kVar.z(ForumChannel.parser(), tVar);
                                this.forumChannel_ = forumChannel2;
                                if (builder8 != null) {
                                    builder8.x(forumChannel2);
                                    this.forumChannel_ = builder8.buildPartial();
                                }
                            case 106:
                                VoiceTemplateChannel voiceTemplateChannel = this.voiceTemplate_;
                                VoiceTemplateChannel.b builder9 = voiceTemplateChannel != null ? voiceTemplateChannel.toBuilder() : null;
                                VoiceTemplateChannel voiceTemplateChannel2 = (VoiceTemplateChannel) kVar.z(VoiceTemplateChannel.parser(), tVar);
                                this.voiceTemplate_ = voiceTemplateChannel2;
                                if (builder9 != null) {
                                    builder9.A(voiceTemplateChannel2);
                                    this.voiceTemplate_ = builder9.buildPartial();
                                }
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
                    if ((z17 ? 1 : 0) & true) {
                        this.categories_ = Collections.unmodifiableList(this.categories_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static RecommendItem parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (RecommendItem) GeneratedMessageV3.parseWithIOException(f381566e, kVar);
        }

        public static RecommendItem parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (RecommendItem) GeneratedMessageV3.parseWithIOException(f381566e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ShareInfo extends GeneratedMessageV3 implements r {
        public static final int SHARE_LINK_FIELD_NUMBER = 2;
        public static final int SHARE_TYPE_FIELD_NUMBER = 1;

        /* renamed from: d, reason: collision with root package name */
        private static final ShareInfo f381569d = new ShareInfo();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<ShareInfo> f381570e = new a();
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object shareLink_;
        private int shareType_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<ShareInfo> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public ShareInfo g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new ShareInfo(kVar, tVar);
            }
        }

        public static ShareInfo getDefaultInstance() {
            return f381569d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.f381495u;
        }

        public static b newBuilder() {
            return f381569d.toBuilder();
        }

        public static ShareInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ShareInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381570e, inputStream);
        }

        public static ShareInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381570e.d(byteBuffer);
        }

        public static bg<ShareInfo> parser() {
            return f381570e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShareInfo)) {
                return super.equals(obj);
            }
            ShareInfo shareInfo = (ShareInfo) obj;
            if (getShareType() == shareInfo.getShareType() && getShareLink().equals(shareInfo.getShareLink()) && this.unknownFields.equals(shareInfo.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<ShareInfo> getParserForType() {
            return f381570e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public int getSerializedSize() {
            int i3 = this.memoizedSize;
            if (i3 != -1) {
                return i3;
            }
            int i16 = this.shareType_;
            int i17 = 0;
            if (i16 != 0) {
                i17 = 0 + CodedOutputStream.Y(1, i16);
            }
            if (!getShareLinkBytes().isEmpty()) {
                i17 += GeneratedMessageV3.computeStringSize(2, this.shareLink_);
            }
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public String getShareLink() {
            Object obj = this.shareLink_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.shareLink_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getShareLinkBytes() {
            Object obj = this.shareLink_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.shareLink_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int getShareType() {
            return this.shareType_;
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
            int hashCode = ((((((((((com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode()) * 37) + 1) * 53) + getShareType()) * 37) + 2) * 53) + getShareLink().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.f381496v.e(ShareInfo.class, b.class);
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
            return new ShareInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i3 = this.shareType_;
            if (i3 != 0) {
                codedOutputStream.b1(1, i3);
            }
            if (!getShareLinkBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.shareLink_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements r {

            /* renamed from: i, reason: collision with root package name */
            private int f381571i;

            /* renamed from: m, reason: collision with root package name */
            private Object f381572m;

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public b A(int i3) {
                this.f381571i = i3;
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
                return common.f381495u;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.f381496v.e(ShareInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public ShareInfo build() {
                ShareInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public ShareInfo buildPartial() {
                ShareInfo shareInfo = new ShareInfo(this);
                shareInfo.shareType_ = this.f381571i;
                shareInfo.shareLink_ = this.f381572m;
                onBuilt();
                return shareInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                this.f381571i = 0;
                this.f381572m = "";
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
            public ShareInfo getDefaultInstanceForType() {
                return ShareInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                ShareInfo shareInfo = null;
                try {
                    try {
                        ShareInfo shareInfo2 = (ShareInfo) ShareInfo.f381570e.g(kVar, tVar);
                        if (shareInfo2 != null) {
                            x(shareInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        ShareInfo shareInfo3 = (ShareInfo) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            shareInfo = shareInfo3;
                            if (shareInfo != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (shareInfo != null) {
                        x(shareInfo);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof ShareInfo) {
                    return x((ShareInfo) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            public b x(ShareInfo shareInfo) {
                if (shareInfo == ShareInfo.getDefaultInstance()) {
                    return this;
                }
                if (shareInfo.getShareType() != 0) {
                    A(shareInfo.getShareType());
                }
                if (!shareInfo.getShareLink().isEmpty()) {
                    this.f381572m = shareInfo.shareLink_;
                    onChanged();
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) shareInfo).unknownFields);
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
                this.f381572m = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f381572m = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(ShareInfo shareInfo) {
            return f381569d.toBuilder().x(shareInfo);
        }

        public static ShareInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381570e.m(byteBuffer, tVar);
        }

        ShareInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ShareInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ShareInfo) GeneratedMessageV3.parseDelimitedWithIOException(f381570e, inputStream, tVar);
        }

        public static ShareInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381570e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public ShareInfo getDefaultInstanceForType() {
            return f381569d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381569d ? new b() : new b().x(this);
        }

        public static ShareInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381570e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        ShareInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.shareLink_ = "";
        }

        public static ShareInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381570e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static ShareInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381570e.i(bArr, tVar);
        }

        public static ShareInfo parseFrom(InputStream inputStream) throws IOException {
            return (ShareInfo) GeneratedMessageV3.parseWithIOException(f381570e, inputStream);
        }

        ShareInfo(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
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
                                    this.shareType_ = kVar.K();
                                } else if (J != 18) {
                                    if (!parseUnknownField(kVar, g16, tVar, J)) {
                                    }
                                } else {
                                    this.shareLink_ = kVar.I();
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

        public static ShareInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ShareInfo) GeneratedMessageV3.parseWithIOException(f381570e, inputStream, tVar);
        }

        public static ShareInfo parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (ShareInfo) GeneratedMessageV3.parseWithIOException(f381570e, kVar);
        }

        public static ShareInfo parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (ShareInfo) GeneratedMessageV3.parseWithIOException(f381570e, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum TeamStatus implements bk {
        TEAM_STATUS_INIT(0),
        TEAM_STATUS_IDLE(1),
        TEAM_STATUS_STARTING(2),
        TEAM_STATUS_IN_GAME(3),
        TEAM_STATUS_GAME_OVER(10),
        UNRECOGNIZED(-1);

        public static final int TEAM_STATUS_GAME_OVER_VALUE = 10;
        public static final int TEAM_STATUS_IDLE_VALUE = 1;
        public static final int TEAM_STATUS_INIT_VALUE = 0;
        public static final int TEAM_STATUS_IN_GAME_VALUE = 3;
        public static final int TEAM_STATUS_STARTING_VALUE = 2;
        private final int value;
        private static final ad.d<TeamStatus> internalValueMap = new a();
        private static final TeamStatus[] VALUES = values();

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements ad.d<TeamStatus> {
            a() {
            }

            @Override // com.google.protobuf.ad.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TeamStatus findValueByNumber(int i3) {
                return TeamStatus.forNumber(i3);
            }
        }

        TeamStatus(int i3) {
            this.value = i3;
        }

        public static TeamStatus forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 10) {
                                return null;
                            }
                            return TEAM_STATUS_GAME_OVER;
                        }
                        return TEAM_STATUS_IN_GAME;
                    }
                    return TEAM_STATUS_STARTING;
                }
                return TEAM_STATUS_IDLE;
            }
            return TEAM_STATUS_INIT;
        }

        public static final Descriptors.c getDescriptor() {
            return common.M().o().get(1);
        }

        public static ad.d<TeamStatus> internalGetValueMap() {
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
        public static TeamStatus valueOf(int i3) {
            return forNumber(i3);
        }

        public static TeamStatus valueOf(Descriptors.d dVar) {
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
    public static final class VoiceTemplateChannel extends GeneratedMessageV3 implements s {
        public static final int COVER_FIELD_NUMBER = 1;
        public static final int CURRENT_NUM_FIELD_NUMBER = 9;
        public static final int ICON_FIELD_NUMBER = 7;
        public static final int MAX_NUM_FIELD_NUMBER = 10;
        public static final int MEMBERS_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 5;
        public static final int PLAY_DESC_FIELD_NUMBER = 8;
        public static final int STATUS_DESC_FIELD_NUMBER = 2;
        public static final int STATUS_FIELD_NUMBER = 6;
        public static final int STATUS_ICON_FIELD_NUMBER = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final VoiceTemplateChannel f381573d = new VoiceTemplateChannel();

        /* renamed from: e, reason: collision with root package name */
        private static final bg<VoiceTemplateChannel> f381574e = new a();
        private static final long serialVersionUID = 0;
        private CoverInfo cover_;
        private int currentNum_;
        private volatile Object icon_;
        private int maxNum_;
        private List<RCGuildMemberInfo> members_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object playDesc_;
        private volatile Object statusDesc_;
        private volatile Object statusIcon_;
        private int status_;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a extends com.google.protobuf.c<VoiceTemplateChannel> {
            a() {
            }

            @Override // com.google.protobuf.bg
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public VoiceTemplateChannel g(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
                return new VoiceTemplateChannel(kVar, tVar);
            }
        }

        public static VoiceTemplateChannel getDefaultInstance() {
            return f381573d;
        }

        public static final Descriptors.b getDescriptor() {
            return common.I;
        }

        public static b newBuilder() {
            return f381573d.toBuilder();
        }

        public static VoiceTemplateChannel parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (VoiceTemplateChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381574e, inputStream);
        }

        public static VoiceTemplateChannel parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return f381574e.d(byteBuffer);
        }

        public static bg<VoiceTemplateChannel> parser() {
            return f381574e;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VoiceTemplateChannel)) {
                return super.equals(obj);
            }
            VoiceTemplateChannel voiceTemplateChannel = (VoiceTemplateChannel) obj;
            if (hasCover() != voiceTemplateChannel.hasCover()) {
                return false;
            }
            if ((!hasCover() || getCover().equals(voiceTemplateChannel.getCover())) && getStatusDesc().equals(voiceTemplateChannel.getStatusDesc()) && getStatusIcon().equals(voiceTemplateChannel.getStatusIcon()) && getMembersList().equals(voiceTemplateChannel.getMembersList()) && getName().equals(voiceTemplateChannel.getName()) && getStatus() == voiceTemplateChannel.getStatus() && getIcon().equals(voiceTemplateChannel.getIcon()) && getPlayDesc().equals(voiceTemplateChannel.getPlayDesc()) && getCurrentNum() == voiceTemplateChannel.getCurrentNum() && getMaxNum() == voiceTemplateChannel.getMaxNum() && this.unknownFields.equals(voiceTemplateChannel.unknownFields)) {
                return true;
            }
            return false;
        }

        public CoverInfo getCover() {
            CoverInfo coverInfo = this.cover_;
            if (coverInfo == null) {
                return CoverInfo.getDefaultInstance();
            }
            return coverInfo;
        }

        public e getCoverOrBuilder() {
            return getCover();
        }

        public int getCurrentNum() {
            return this.currentNum_;
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

        public int getMaxNum() {
            return this.maxNum_;
        }

        public RCGuildMemberInfo getMembers(int i3) {
            return this.members_.get(i3);
        }

        public int getMembersCount() {
            return this.members_.size();
        }

        public List<RCGuildMemberInfo> getMembersList() {
            return this.members_;
        }

        public o getMembersOrBuilder(int i3) {
            return this.members_.get(i3);
        }

        public List<? extends o> getMembersOrBuilderList() {
            return this.members_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au
        public bg<VoiceTemplateChannel> getParserForType() {
            return f381574e;
        }

        public String getPlayDesc() {
            Object obj = this.playDesc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.playDesc_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getPlayDescBytes() {
            Object obj = this.playDesc_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.playDesc_ = copyFromUtf8;
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
            if (this.cover_ != null) {
                i3 = CodedOutputStream.G(1, getCover()) + 0;
            } else {
                i3 = 0;
            }
            if (!getStatusDescBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(2, this.statusDesc_);
            }
            if (!getStatusIconBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(3, this.statusIcon_);
            }
            for (int i17 = 0; i17 < this.members_.size(); i17++) {
                i3 += CodedOutputStream.G(4, this.members_.get(i17));
            }
            if (!getNameBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(5, this.name_);
            }
            int i18 = this.status_;
            if (i18 != 0) {
                i3 += CodedOutputStream.x(6, i18);
            }
            if (!getIconBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(7, this.icon_);
            }
            if (!getPlayDescBytes().isEmpty()) {
                i3 += GeneratedMessageV3.computeStringSize(8, this.playDesc_);
            }
            int i19 = this.currentNum_;
            if (i19 != 0) {
                i3 += CodedOutputStream.Y(9, i19);
            }
            int i26 = this.maxNum_;
            if (i26 != 0) {
                i3 += CodedOutputStream.Y(10, i26);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public int getStatus() {
            return this.status_;
        }

        public String getStatusDesc() {
            Object obj = this.statusDesc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.statusDesc_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getStatusDescBytes() {
            Object obj = this.statusDesc_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.statusDesc_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public String getStatusIcon() {
            Object obj = this.statusIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.statusIcon_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getStatusIconBytes() {
            Object obj = this.statusIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.statusIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.ax
        public final cc getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasCover() {
            if (this.cover_ != null) {
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
            int hashCode = com.tencent.luggage.wxa.gg.e.CTRL_INDEX + getDescriptor().hashCode();
            if (hasCover()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getCover().hashCode();
            }
            int hashCode2 = (((((((hashCode * 37) + 2) * 53) + getStatusDesc().hashCode()) * 37) + 3) * 53) + getStatusIcon().hashCode();
            if (getMembersCount() > 0) {
                hashCode2 = (((hashCode2 * 37) + 4) * 53) + getMembersList().hashCode();
            }
            int hashCode3 = (((((((((((((((((((((((((hashCode2 * 37) + 5) * 53) + getName().hashCode()) * 37) + 6) * 53) + getStatus()) * 37) + 7) * 53) + getIcon().hashCode()) * 37) + 8) * 53) + getPlayDesc().hashCode()) * 37) + 9) * 53) + getCurrentNum()) * 37) + 10) * 53) + getMaxNum()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return common.J.e(VoiceTemplateChannel.class, b.class);
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
            return new VoiceTemplateChannel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.au
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.cover_ != null) {
                codedOutputStream.K0(1, getCover());
            }
            if (!getStatusDescBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.statusDesc_);
            }
            if (!getStatusIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.statusIcon_);
            }
            for (int i3 = 0; i3 < this.members_.size(); i3++) {
                codedOutputStream.K0(4, this.members_.get(i3));
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.name_);
            }
            int i16 = this.status_;
            if (i16 != 0) {
                codedOutputStream.G0(6, i16);
            }
            if (!getIconBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.icon_);
            }
            if (!getPlayDescBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.playDesc_);
            }
            int i17 = this.currentNum_;
            if (i17 != 0) {
                codedOutputStream.b1(9, i17);
            }
            int i18 = this.maxNum_;
            if (i18 != 0) {
                codedOutputStream.b1(10, i18);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* compiled from: P */
        /* loaded from: classes27.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements s {
            private bu<CoverInfo, CoverInfo.b, e> C;
            private Object D;
            private Object E;
            private List<RCGuildMemberInfo> F;
            private bp<RCGuildMemberInfo, RCGuildMemberInfo.b, o> G;
            private Object H;
            private int I;
            private Object J;
            private Object K;
            private int L;
            private int M;

            /* renamed from: i, reason: collision with root package name */
            private int f381575i;

            /* renamed from: m, reason: collision with root package name */
            private CoverInfo f381576m;

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    w();
                }
            }

            private void u() {
                if ((this.f381575i & 1) == 0) {
                    this.F = new ArrayList(this.F);
                    this.f381575i |= 1;
                }
            }

            private bp<RCGuildMemberInfo, RCGuildMemberInfo.b, o> w() {
                if (this.G == null) {
                    List<RCGuildMemberInfo> list = this.F;
                    boolean z16 = true;
                    if ((this.f381575i & 1) == 0) {
                        z16 = false;
                    }
                    this.G = new bp<>(list, z16, h(), isClean());
                    this.F = null;
                }
                return this.G;
            }

            public b A(VoiceTemplateChannel voiceTemplateChannel) {
                if (voiceTemplateChannel == VoiceTemplateChannel.getDefaultInstance()) {
                    return this;
                }
                if (voiceTemplateChannel.hasCover()) {
                    x(voiceTemplateChannel.getCover());
                }
                if (!voiceTemplateChannel.getStatusDesc().isEmpty()) {
                    this.D = voiceTemplateChannel.statusDesc_;
                    onChanged();
                }
                if (!voiceTemplateChannel.getStatusIcon().isEmpty()) {
                    this.E = voiceTemplateChannel.statusIcon_;
                    onChanged();
                }
                if (this.G == null) {
                    if (!voiceTemplateChannel.members_.isEmpty()) {
                        if (this.F.isEmpty()) {
                            this.F = voiceTemplateChannel.members_;
                            this.f381575i &= -2;
                        } else {
                            u();
                            this.F.addAll(voiceTemplateChannel.members_);
                        }
                        onChanged();
                    }
                } else if (!voiceTemplateChannel.members_.isEmpty()) {
                    if (this.G.j()) {
                        this.G.f();
                        bp<RCGuildMemberInfo, RCGuildMemberInfo.b, o> bpVar = null;
                        this.G = null;
                        this.F = voiceTemplateChannel.members_;
                        this.f381575i &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            bpVar = w();
                        }
                        this.G = bpVar;
                    } else {
                        this.G.b(voiceTemplateChannel.members_);
                    }
                }
                if (!voiceTemplateChannel.getName().isEmpty()) {
                    this.H = voiceTemplateChannel.name_;
                    onChanged();
                }
                if (voiceTemplateChannel.getStatus() != 0) {
                    F(voiceTemplateChannel.getStatus());
                }
                if (!voiceTemplateChannel.getIcon().isEmpty()) {
                    this.J = voiceTemplateChannel.icon_;
                    onChanged();
                }
                if (!voiceTemplateChannel.getPlayDesc().isEmpty()) {
                    this.K = voiceTemplateChannel.playDesc_;
                    onChanged();
                }
                if (voiceTemplateChannel.getCurrentNum() != 0) {
                    C(voiceTemplateChannel.getCurrentNum());
                }
                if (voiceTemplateChannel.getMaxNum() != 0) {
                    E(voiceTemplateChannel.getMaxNum());
                }
                mo52mergeUnknownFields(((GeneratedMessageV3) voiceTemplateChannel).unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public final b mo52mergeUnknownFields(cc ccVar) {
                return (b) super.mo52mergeUnknownFields(ccVar);
            }

            public b C(int i3) {
                this.L = i3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.ar.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b E(int i3) {
                this.M = i3;
                onChanged();
                return this;
            }

            public b F(int i3) {
                this.I = i3;
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
                return common.I;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e i() {
                return common.J.e(VoiceTemplateChannel.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public VoiceTemplateChannel build() {
                VoiceTemplateChannel buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0252a.newUninitializedMessageException((ar) buildPartial);
            }

            @Override // com.google.protobuf.au.a, com.google.protobuf.ar.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public VoiceTemplateChannel buildPartial() {
                VoiceTemplateChannel voiceTemplateChannel = new VoiceTemplateChannel(this);
                bu<CoverInfo, CoverInfo.b, e> buVar = this.C;
                if (buVar == null) {
                    voiceTemplateChannel.cover_ = this.f381576m;
                } else {
                    voiceTemplateChannel.cover_ = buVar.b();
                }
                voiceTemplateChannel.statusDesc_ = this.D;
                voiceTemplateChannel.statusIcon_ = this.E;
                bp<RCGuildMemberInfo, RCGuildMemberInfo.b, o> bpVar = this.G;
                if (bpVar != null) {
                    voiceTemplateChannel.members_ = bpVar.d();
                } else {
                    if ((this.f381575i & 1) != 0) {
                        this.F = Collections.unmodifiableList(this.F);
                        this.f381575i &= -2;
                    }
                    voiceTemplateChannel.members_ = this.F;
                }
                voiceTemplateChannel.name_ = this.H;
                voiceTemplateChannel.status_ = this.I;
                voiceTemplateChannel.icon_ = this.J;
                voiceTemplateChannel.playDesc_ = this.K;
                voiceTemplateChannel.currentNum_ = this.L;
                voiceTemplateChannel.maxNum_ = this.M;
                onBuilt();
                return voiceTemplateChannel;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0252a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clear() {
                super.clear();
                if (this.C == null) {
                    this.f381576m = null;
                } else {
                    this.f381576m = null;
                    this.C = null;
                }
                this.D = "";
                this.E = "";
                bp<RCGuildMemberInfo, RCGuildMemberInfo.b, o> bpVar = this.G;
                if (bpVar == null) {
                    this.F = Collections.emptyList();
                    this.f381575i &= -2;
                } else {
                    bpVar.e();
                }
                this.H = "";
                this.I = 0;
                this.J = "";
                this.K = "";
                this.L = 0;
                this.M = 0;
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
            public VoiceTemplateChannel getDefaultInstanceForType() {
                return VoiceTemplateChannel.getDefaultInstance();
            }

            public b x(CoverInfo coverInfo) {
                bu<CoverInfo, CoverInfo.b, e> buVar = this.C;
                if (buVar == null) {
                    CoverInfo coverInfo2 = this.f381576m;
                    if (coverInfo2 != null) {
                        this.f381576m = CoverInfo.newBuilder(coverInfo2).x(coverInfo).buildPartial();
                    } else {
                        this.f381576m = coverInfo;
                    }
                    onChanged();
                } else {
                    buVar.g(coverInfo);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.b.a, com.google.protobuf.au.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
                VoiceTemplateChannel voiceTemplateChannel = null;
                try {
                    try {
                        VoiceTemplateChannel voiceTemplateChannel2 = (VoiceTemplateChannel) VoiceTemplateChannel.f381574e.g(kVar, tVar);
                        if (voiceTemplateChannel2 != null) {
                            A(voiceTemplateChannel2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e16) {
                        VoiceTemplateChannel voiceTemplateChannel3 = (VoiceTemplateChannel) e16.getUnfinishedMessage();
                        try {
                            throw e16.unwrapIOException();
                        } catch (Throwable th5) {
                            th = th5;
                            voiceTemplateChannel = voiceTemplateChannel3;
                            if (voiceTemplateChannel != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (voiceTemplateChannel != null) {
                        A(voiceTemplateChannel);
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.a.AbstractC0252a, com.google.protobuf.ar.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(ar arVar) {
                if (arVar instanceof VoiceTemplateChannel) {
                    return A((VoiceTemplateChannel) arVar);
                }
                super.mergeFrom(arVar);
                return this;
            }

            b() {
                this.D = "";
                this.E = "";
                this.F = Collections.emptyList();
                this.H = "";
                this.J = "";
                this.K = "";
                maybeForceBuilderInitialization();
            }

            b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.D = "";
                this.E = "";
                this.F = Collections.emptyList();
                this.H = "";
                this.J = "";
                this.K = "";
                maybeForceBuilderInitialization();
            }
        }

        public static b newBuilder(VoiceTemplateChannel voiceTemplateChannel) {
            return f381573d.toBuilder().A(voiceTemplateChannel);
        }

        public static VoiceTemplateChannel parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return f381574e.m(byteBuffer, tVar);
        }

        VoiceTemplateChannel(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static VoiceTemplateChannel parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (VoiceTemplateChannel) GeneratedMessageV3.parseDelimitedWithIOException(f381574e, inputStream, tVar);
        }

        public static VoiceTemplateChannel parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return f381574e.b(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.av, com.google.protobuf.ax
        public VoiceTemplateChannel getDefaultInstanceForType() {
            return f381573d;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b toBuilder() {
            return this == f381573d ? new b() : new b().A(this);
        }

        public static VoiceTemplateChannel parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return f381574e.a(byteString, tVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.au, com.google.protobuf.ar
        public b newBuilderForType() {
            return newBuilder();
        }

        VoiceTemplateChannel() {
            this.memoizedIsInitialized = (byte) -1;
            this.statusDesc_ = "";
            this.statusIcon_ = "";
            this.members_ = Collections.emptyList();
            this.name_ = "";
            this.icon_ = "";
            this.playDesc_ = "";
        }

        public static VoiceTemplateChannel parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return f381574e.j(bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar);
        }

        public static VoiceTemplateChannel parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return f381574e.i(bArr, tVar);
        }

        public static VoiceTemplateChannel parseFrom(InputStream inputStream) throws IOException {
            return (VoiceTemplateChannel) GeneratedMessageV3.parseWithIOException(f381574e, inputStream);
        }

        public static VoiceTemplateChannel parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (VoiceTemplateChannel) GeneratedMessageV3.parseWithIOException(f381574e, inputStream, tVar);
        }

        public static VoiceTemplateChannel parseFrom(com.google.protobuf.k kVar) throws IOException {
            return (VoiceTemplateChannel) GeneratedMessageV3.parseWithIOException(f381574e, kVar);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0013. Please report as an issue. */
        VoiceTemplateChannel(com.google.protobuf.k kVar, t tVar) throws InvalidProtocolBufferException {
            this();
            tVar.getClass();
            cc.b g16 = cc.g();
            boolean z16 = false;
            boolean z17 = false;
            while (!z16) {
                try {
                    try {
                        int J = kVar.J();
                        switch (J) {
                            case 0:
                                z16 = true;
                            case 10:
                                CoverInfo coverInfo = this.cover_;
                                CoverInfo.b builder = coverInfo != null ? coverInfo.toBuilder() : null;
                                CoverInfo coverInfo2 = (CoverInfo) kVar.z(CoverInfo.parser(), tVar);
                                this.cover_ = coverInfo2;
                                if (builder != null) {
                                    builder.x(coverInfo2);
                                    this.cover_ = builder.buildPartial();
                                }
                            case 18:
                                this.statusDesc_ = kVar.I();
                            case 26:
                                this.statusIcon_ = kVar.I();
                            case 34:
                                if (!(z17 & true)) {
                                    this.members_ = new ArrayList();
                                    z17 |= true;
                                }
                                this.members_.add((RCGuildMemberInfo) kVar.z(RCGuildMemberInfo.parser(), tVar));
                            case 42:
                                this.name_ = kVar.I();
                            case 48:
                                this.status_ = kVar.x();
                            case 58:
                                this.icon_ = kVar.I();
                            case 66:
                                this.playDesc_ = kVar.I();
                            case 72:
                                this.currentNum_ = kVar.K();
                            case 80:
                                this.maxNum_ = kVar.K();
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
                    if (z17 & true) {
                        this.members_ = Collections.unmodifiableList(this.members_);
                    }
                    this.unknownFields = g16.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static VoiceTemplateChannel parseFrom(com.google.protobuf.k kVar, t tVar) throws IOException {
            return (VoiceTemplateChannel) GeneratedMessageV3.parseWithIOException(f381574e, kVar, tVar);
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

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface j extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface k extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface l extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface m extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface n extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface o extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface p extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface q extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface r extends ax {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface s extends ax {
    }

    static {
        Descriptors.b bVar = M().p().get(0);
        f381475a = bVar;
        f381476b = new GeneratedMessageV3.e(bVar, new String[]{"ItemId", "ItemType", "ChannelInfo", "LiveChannel", "VoiceChannel", "Feed", "ItemIdUint64", "Categories", "H5GameChannel", "AdInfo", "ForumChannel", "VoiceTemplate"});
        Descriptors.b bVar2 = M().p().get(1);
        f381477c = bVar2;
        f381478d = new GeneratedMessageV3.e(bVar2, new String[]{"Name", "CategoryId", "GroupId", "HasMore", "Type"});
        Descriptors.b bVar3 = M().p().get(2);
        f381479e = bVar3;
        f381480f = new GeneratedMessageV3.e(bVar3, new String[]{"GuildId", "GuildName", "GuildIcon", "GuildProfile", "StateList", "ShareLink", "JoinedGuild", "CoverUrl"});
        Descriptors.b bVar4 = M().p().get(3);
        f381481g = bVar4;
        f381482h = new GeneratedMessageV3.e(bVar4, new String[]{"State", "Desc", "IconUrls"});
        Descriptors.b bVar5 = M().p().get(4);
        f381483i = bVar5;
        f381484j = new GeneratedMessageV3.e(bVar5, new String[]{"MsgList", "Cover"});
        Descriptors.b bVar6 = M().p().get(5);
        f381485k = bVar6;
        f381486l = new GeneratedMessageV3.e(bVar6, new String[]{"Type", "ImageUrl", "StreamUrl"});
        Descriptors.b bVar7 = M().p().get(6);
        f381487m = bVar7;
        f381488n = new GeneratedMessageV3.e(bVar7, new String[]{"Tinyid", "NickName", "Avatar", "MsgSeq", "RichText"});
        Descriptors.b bVar8 = M().p().get(7);
        f381489o = bVar8;
        f381490p = new GeneratedMessageV3.e(bVar8, new String[]{"Cover"});
        Descriptors.b bVar9 = M().p().get(8);
        f381491q = bVar9;
        f381492r = new GeneratedMessageV3.e(bVar9, new String[]{"Cover"});
        Descriptors.b bVar10 = M().p().get(9);
        f381493s = bVar10;
        f381494t = new GeneratedMessageV3.e(bVar10, new String[]{"Data", "ShareInfo"});
        Descriptors.b bVar11 = M().p().get(10);
        f381495u = bVar11;
        f381496v = new GeneratedMessageV3.e(bVar11, new String[]{"ShareType", "ShareLink"});
        Descriptors.b bVar12 = M().p().get(11);
        f381497w = bVar12;
        f381498x = new GeneratedMessageV3.e(bVar12, new String[]{"Data", "Cover"});
        Descriptors.b bVar13 = M().p().get(12);
        f381499y = bVar13;
        f381500z = new GeneratedMessageV3.e(bVar13, new String[]{"TeamId", "TeamStatus", "Game", "Members", "ReadyExpireTime"});
        Descriptors.b bVar14 = M().p().get(13);
        A = bVar14;
        B = new GeneratedMessageV3.e(bVar14, new String[]{"Id", "Name", "Icon", "ModeInfo"});
        Descriptors.b bVar15 = M().p().get(14);
        C = bVar15;
        D = new GeneratedMessageV3.e(bVar15, new String[]{"ModeId", "ModeName", "IsPk", "PlayerNum"});
        Descriptors.b bVar16 = M().p().get(15);
        E = bVar16;
        F = new GeneratedMessageV3.e(bVar16, new String[]{"Title", "SubTitle", "Tag", "PicUrl", "JumpUrl", "AdId"});
        Descriptors.b bVar17 = M().p().get(16);
        G = bVar17;
        H = new GeneratedMessageV3.e(bVar17, new String[]{"FeedNum", "Imgs"});
        Descriptors.b bVar18 = M().p().get(17);
        I = bVar18;
        J = new GeneratedMessageV3.e(bVar18, new String[]{"Cover", "StatusDesc", "StatusIcon", "Members", "Name", "Status", "Icon", "PlayDesc", "CurrentNum", "MaxNum"});
        Descriptors.b bVar19 = M().p().get(18);
        K = bVar19;
        L = new GeneratedMessageV3.e(bVar19, new String[]{"TinyId", "Gender", "AvatarMeta"});
        Descriptors.b bVar20 = M().p().get(19);
        M = bVar20;
        N = new GeneratedMessageV3.e(bVar20, new String[]{"HotfeedNum", "Index", "HotValueTitle", "Type", "StartColor", "EndColor", "HotIcon", "InviteCode"});
        Descriptors.FileDescriptor.w(O, com.google.protobuf.r.g());
        guildRecommendChannel.g();
    }

    public static Descriptors.FileDescriptor M() {
        return O;
    }
}
