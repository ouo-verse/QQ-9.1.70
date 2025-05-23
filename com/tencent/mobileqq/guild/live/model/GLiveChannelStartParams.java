package com.tencent.mobileqq.guild.live.model;

import android.os.Bundle;
import com.tencent.mobileqq.guild.config.z;
import com.tencent.mobileqq.guild.data.GuildLiveJumpData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u0000 e2\u00020\u0001:\u0002\u0005\u0003B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\u0004\bc\u0010dJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0006R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u000e8F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u000e8F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u0004\u0018\u00010\u000e8F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u000e8F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u001fR$\u0010)\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u001fR*\u0010.\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R.\u00108\u001a\u0004\u0018\u0001072\b\u0010-\u001a\u0004\u0018\u0001078\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b>\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010?\u001a\u0004\bK\u0010@\"\u0004\bL\u0010BR\"\u0010N\u001a\u00020M8F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u0014\u001a\u0004\bU\u0010\u0016\"\u0004\bV\u0010\u001fR\u0013\u0010Y\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\bW\u0010XR\u0013\u0010\\\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R\u0011\u0010^\u001a\u00020,8F\u00a2\u0006\u0006\u001a\u0004\b]\u00101R\u0011\u0010`\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b_\u0010\u0016R\u0011\u0010b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\ba\u0010@\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "a", "", "isLiving", "isValidRoomId", "isValidLiveUrl", "Lcom/tencent/mobileqq/qqguildsdk/data/ILiveRoomInfo;", "roomInfo", "", "updateFromLiveRoomInfo", "", "toString", "startParams", "updateFromNewInfo", "isEmpty", "guildId", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "channelId", "getChannelId", "<set-?>", "key", "getKey", "guildName", "getGuildName", "setGuildName", "(Ljava/lang/String;)V", "channelName", "getChannelName", "setChannelName", "anchorTinyId", "getAnchorTinyId", "setAnchorTinyId", "liveRoomName", "getLiveRoomName", "setLiveRoomName", "liveUrl", "getLiveUrl", "setLiveUrl", "", "value", "liveType", "I", "getLiveType", "()I", "setLiveType", "(I)V", "videoScaleType", "getVideoScaleType", "setVideoScaleType", "Lcom/tencent/mobileqq/guild/live/model/LiveChannelRoomInfo;", "liveChannelRoomInfo", "Lcom/tencent/mobileqq/guild/live/model/LiveChannelRoomInfo;", "getLiveChannelRoomInfo", "()Lcom/tencent/mobileqq/guild/live/model/LiveChannelRoomInfo;", "setLiveChannelRoomInfo", "(Lcom/tencent/mobileqq/guild/live/model/LiveChannelRoomInfo;)V", "isNeedOpenSharePanel", "Z", "()Z", "setNeedOpenSharePanel", "(Z)V", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "allowStartLive", "getAllowStartLive", "setAllowStartLive", "", "roomId", "J", "getRoomId", "()J", "setRoomId", "(J)V", "enterSourceType", "getEnterSourceType", "setEnterSourceType", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "getViewerNumWhenInit", "viewerNumWhenInit", "getLiveRoomProgramId", "liveRoomProgramId", "getAnchorIsSelf", "anchorIsSelf", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GLiveChannelStartParams implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean allowStartLive;

    @Nullable
    private String anchorTinyId;

    @NotNull
    private Bundle bundle;

    @NotNull
    private final String channelId;

    @Nullable
    private String channelName;

    @NotNull
    private String enterSourceType;

    @NotNull
    private final String guildId;

    @Nullable
    private String guildName;
    private boolean isNeedOpenSharePanel;

    @NotNull
    private String key;

    @Nullable
    private LiveChannelRoomInfo liveChannelRoomInfo;

    @Nullable
    private String liveRoomName;
    private int liveType;

    @Nullable
    private String liveUrl;
    private long roomId;
    private int videoScaleType;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0007R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams$a;", "", "", "i", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/main/data/QQGuildChannelLive;", "liveChannel", "Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "e", "g", "Lcom/tencent/mobileqq/guild/data/f;", "data", "b", "Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams$b;", "c", h.F, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GLiveChannelStartParams f(Companion companion, IGProChannelInfo iGProChannelInfo, QQGuildChannelLive qQGuildChannelLive, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                qQGuildChannelLive = null;
            }
            return companion.e(iGProChannelInfo, qQGuildChannelLive);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean i() {
            return z.f216289a.e();
        }

        @JvmStatic
        @NotNull
        public final GLiveChannelStartParams b(@NotNull GuildLiveJumpData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String guildId = data.getGuildId();
            Intrinsics.checkNotNull(guildId);
            String channelId = data.getChannelId();
            Intrinsics.checkNotNull(channelId);
            GLiveChannelStartParams gLiveChannelStartParams = new GLiveChannelStartParams(guildId, channelId);
            gLiveChannelStartParams.setLiveUrl(data.getLiveStreamUrl());
            gLiveChannelStartParams.setGuildName(data.getGuildName());
            gLiveChannelStartParams.setChannelName(data.getLiveRoomName());
            gLiveChannelStartParams.setLiveRoomName(data.getLiveRoomName());
            gLiveChannelStartParams.setAnchorTinyId(data.getLiveAnchorId());
            gLiveChannelStartParams.setRoomId(data.getLiveRoomId());
            return gLiveChannelStartParams;
        }

        @JvmStatic
        @NotNull
        public final GLiveChannelStartParams c(@NotNull b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            GLiveChannelStartParams gLiveChannelStartParams = new GLiveChannelStartParams(data.getGuildId(), data.getChannelId());
            gLiveChannelStartParams.setLiveUrl(data.getLiveStreamUrl());
            gLiveChannelStartParams.setGuildName(data.getGuildName());
            gLiveChannelStartParams.setChannelName(data.getLiveRoomName());
            gLiveChannelStartParams.setLiveRoomName(data.getLiveRoomName());
            gLiveChannelStartParams.setAnchorTinyId(data.getLiveAnchorId());
            gLiveChannelStartParams.setRoomId(data.getLiveRoomId());
            gLiveChannelStartParams.setEnterSourceType("functional_qq_little_world_feed");
            return gLiveChannelStartParams;
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final GLiveChannelStartParams d(@NotNull IGProChannelInfo channelInfo) {
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            return f(this, channelInfo, null, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final GLiveChannelStartParams e(@NotNull IGProChannelInfo channelInfo, @Nullable QQGuildChannelLive liveChannel) {
            QQGuildChannelLive.a p16;
            String m3;
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            String guildId = channelInfo.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
            String channelUin = channelInfo.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
            GLiveChannelStartParams gLiveChannelStartParams = new GLiveChannelStartParams(guildId, channelUin);
            if (liveChannel != null && (p16 = liveChannel.p()) != null) {
                gLiveChannelStartParams.setLiveChannelRoomInfo(LiveChannelRoomInfo.parseFrom(p16));
                if (GLiveChannelStartParams.INSTANCE.i()) {
                    m3 = p16.l();
                } else {
                    m3 = p16.m();
                }
                gLiveChannelStartParams.setLiveUrl(m3);
                gLiveChannelStartParams.setLiveType(p16.e());
            }
            gLiveChannelStartParams.setGuildName(((IGPSService) ch.R0(IGPSService.class)).getGuildName(channelInfo.getGuildId()));
            gLiveChannelStartParams.setChannelName(channelInfo.getChannelName());
            gLiveChannelStartParams.setAnchorTinyId(String.valueOf(channelInfo.getLiveAnchorTinyId()));
            gLiveChannelStartParams.setRoomId(channelInfo.getLiveRoomId());
            gLiveChannelStartParams.setLiveRoomName(channelInfo.getLiveRoomName());
            return gLiveChannelStartParams;
        }

        @JvmStatic
        @NotNull
        public final GLiveChannelStartParams g() {
            return new GLiveChannelStartParams("", "");
        }

        @JvmStatic
        public final boolean h() {
            JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) GLiveChannelCore.f226698a.s().getBundle().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
            if (joinInfoParam == null) {
                return false;
            }
            String mainSource = joinInfoParam.getMainSource();
            String subSource = joinInfoParam.getSubSource();
            if (!Intrinsics.areEqual("small_world_distribution", mainSource) || !Intrinsics.areEqual("feeds", subSource)) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "guildId", h.F, "channelId", "c", "g", DomainData.DOMAIN_NAME, "liveStreamUrl", "d", "j", "guildName", "e", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "liveRoomName", "k", "liveAnchorId", "", "J", "()J", "l", "(J)V", "liveRoomId", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String guildId = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String channelId = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String liveStreamUrl = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String guildName = "";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String liveRoomName = "";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String liveAnchorId = "";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long liveRoomId = -1;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getLiveAnchorId() {
            return this.liveAnchorId;
        }

        /* renamed from: e, reason: from getter */
        public final long getLiveRoomId() {
            return this.liveRoomId;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getLiveRoomName() {
            return this.liveRoomName;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final String getLiveStreamUrl() {
            return this.liveStreamUrl;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.channelId = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guildId = str;
        }

        public final void j(@Nullable String str) {
            this.guildName = str;
        }

        public final void k(@Nullable String str) {
            this.liveAnchorId = str;
        }

        public final void l(long j3) {
            this.liveRoomId = j3;
        }

        public final void m(@Nullable String str) {
            this.liveRoomName = str;
        }

        public final void n(@Nullable String str) {
            this.liveStreamUrl = str;
        }
    }

    public GLiveChannelStartParams(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.key = uuid;
        this.bundle = new Bundle();
        this.enterSourceType = "";
    }

    private final IGProChannelInfo a() {
        return ((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(this.channelId);
    }

    private final IGProGuildInfo b() {
        return ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(this.guildId);
    }

    @JvmStatic
    @NotNull
    public static final GLiveChannelStartParams create(@NotNull GuildLiveJumpData guildLiveJumpData) {
        return INSTANCE.b(guildLiveJumpData);
    }

    @JvmStatic
    @NotNull
    public static final GLiveChannelStartParams empty() {
        return INSTANCE.g();
    }

    @JvmStatic
    public static final boolean fromLittleWorld() {
        return INSTANCE.h();
    }

    public final boolean getAllowStartLive() {
        return this.allowStartLive;
    }

    public final boolean getAnchorIsSelf() {
        if (getAnchorTinyId() != null && Intrinsics.areEqual(((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId(), getAnchorTinyId())) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getAnchorTinyId() {
        long j3;
        IGProChannelInfo channelInfo = getChannelInfo();
        if (channelInfo != null) {
            j3 = channelInfo.getLiveAnchorTinyId();
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            IGProChannelInfo channelInfo2 = getChannelInfo();
            if (channelInfo2 != null) {
                return Long.valueOf(channelInfo2.getLiveAnchorTinyId()).toString();
            }
            return null;
        }
        return this.anchorTinyId;
    }

    @NotNull
    public final Bundle getBundle() {
        return this.bundle;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final IGProChannelInfo getChannelInfo() {
        return a();
    }

    @Nullable
    public final String getChannelName() {
        String str;
        boolean z16;
        IGProChannelInfo channelInfo = getChannelInfo();
        if (channelInfo != null) {
            str = channelInfo.getChannelName();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return this.channelName;
        }
        IGProChannelInfo channelInfo2 = getChannelInfo();
        if (channelInfo2 == null) {
            return null;
        }
        return channelInfo2.getChannelName();
    }

    @NotNull
    public final String getEnterSourceType() {
        return this.enterSourceType;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    public final IGProGuildInfo getGuildInfo() {
        return b();
    }

    @Nullable
    public final String getGuildName() {
        String str;
        boolean z16;
        IGProGuildInfo guildInfo = getGuildInfo();
        if (guildInfo != null) {
            str = guildInfo.getGuildName();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return this.guildName;
        }
        IGProGuildInfo guildInfo2 = getGuildInfo();
        if (guildInfo2 == null) {
            return null;
        }
        return guildInfo2.getGuildName();
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final LiveChannelRoomInfo getLiveChannelRoomInfo() {
        return this.liveChannelRoomInfo;
    }

    @Nullable
    public final String getLiveRoomName() {
        String str;
        boolean z16;
        IGProChannelInfo channelInfo = getChannelInfo();
        if (channelInfo != null) {
            str = channelInfo.getLiveRoomName();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return this.liveRoomName;
        }
        IGProChannelInfo channelInfo2 = getChannelInfo();
        if (channelInfo2 == null) {
            return null;
        }
        return channelInfo2.getLiveRoomName();
    }

    @NotNull
    public final String getLiveRoomProgramId() {
        String str;
        LiveChannelRoomInfo liveChannelRoomInfo = this.liveChannelRoomInfo;
        if (liveChannelRoomInfo != null) {
            str = liveChannelRoomInfo.getProgramId();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final int getLiveType() {
        return this.liveType;
    }

    @Nullable
    public final String getLiveUrl() {
        return this.liveUrl;
    }

    public final long getRoomId() {
        long j3;
        IGProChannelInfo channelInfo = getChannelInfo();
        if (channelInfo != null) {
            j3 = channelInfo.getLiveRoomId();
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            IGProChannelInfo channelInfo2 = getChannelInfo();
            Intrinsics.checkNotNull(channelInfo2);
            return channelInfo2.getLiveRoomId();
        }
        return this.roomId;
    }

    public final int getVideoScaleType() {
        return this.videoScaleType;
    }

    public final int getViewerNumWhenInit() {
        LiveChannelRoomInfo liveChannelRoomInfo = this.liveChannelRoomInfo;
        if (liveChannelRoomInfo != null) {
            return (int) liveChannelRoomInfo.getViewer();
        }
        return 0;
    }

    public final boolean isEmpty() {
        boolean z16;
        boolean z17;
        if (this.guildId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (this.channelId.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    public final boolean isLiving() {
        if (!isValidRoomId() && !isValidLiveUrl()) {
            return false;
        }
        return true;
    }

    /* renamed from: isNeedOpenSharePanel, reason: from getter */
    public final boolean getIsNeedOpenSharePanel() {
        return this.isNeedOpenSharePanel;
    }

    public final boolean isValidLiveUrl() {
        boolean z16;
        String str = this.liveUrl;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    public final boolean isValidRoomId() {
        if (getRoomId() > 0) {
            return true;
        }
        return false;
    }

    public final void setAllowStartLive(boolean z16) {
        this.allowStartLive = z16;
    }

    public final void setAnchorTinyId(@Nullable String str) {
        this.anchorTinyId = str;
    }

    public final void setBundle(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.bundle = bundle;
    }

    public final void setChannelName(@Nullable String str) {
        this.channelName = str;
    }

    public final void setEnterSourceType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.enterSourceType = str;
    }

    public final void setGuildName(@Nullable String str) {
        this.guildName = str;
    }

    public final void setLiveChannelRoomInfo(@Nullable LiveChannelRoomInfo liveChannelRoomInfo) {
        String str;
        this.liveChannelRoomInfo = liveChannelRoomInfo;
        String str2 = null;
        if (liveChannelRoomInfo != null) {
            str = liveChannelRoomInfo.getRoomId();
        } else {
            str = null;
        }
        if (liveChannelRoomInfo != null) {
            str2 = liveChannelRoomInfo.getProgramId();
        }
        QLog.i("QGL.GLiveChannelStartParams", 1, "set liveChannelRoomInfo, roomId:" + str + ", programId:" + str2);
    }

    public final void setLiveRoomName(@Nullable String str) {
        this.liveRoomName = str;
    }

    public final void setLiveType(int i3) {
        this.liveType = i3;
        QLog.i("QGL.GLiveChannelStartParams", 1, "set live type:" + i3);
    }

    public final void setLiveUrl(@Nullable String str) {
        this.liveUrl = str;
    }

    public final void setNeedOpenSharePanel(boolean z16) {
        this.isNeedOpenSharePanel = z16;
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public final void setVideoScaleType(int i3) {
        this.videoScaleType = i3;
        QLog.i("QGL.GLiveChannelStartParams", 1, "set scale type: " + i3 + " ");
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = this.liveUrl;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            if (str2.length() > 50) {
                String str3 = this.liveUrl;
                Intrinsics.checkNotNull(str3);
                str = str3.substring(0, 50);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return "GLiveChannelStartParams{guildName=" + getGuildName() + ",channelName=" + getChannelName() + ",anchorTinyId=" + getAnchorTinyId() + ",liveRoomName=" + getLiveRoomName() + ",liveUrl=" + str + ",liveType=" + this.liveType + ",isNeedOpenSharePanel=" + this.isNeedOpenSharePanel + ",allowStartLive=" + this.allowStartLive + ",roomId=" + getRoomId() + ",viewerNumWhenInit=" + getViewerNumWhenInit() + ",liveRoomProgramId=" + getLiveRoomProgramId() + ",anchorIsSelf=" + getAnchorIsSelf() + "}";
            }
        }
        str = this.liveUrl;
        return "GLiveChannelStartParams{guildName=" + getGuildName() + ",channelName=" + getChannelName() + ",anchorTinyId=" + getAnchorTinyId() + ",liveRoomName=" + getLiveRoomName() + ",liveUrl=" + str + ",liveType=" + this.liveType + ",isNeedOpenSharePanel=" + this.isNeedOpenSharePanel + ",allowStartLive=" + this.allowStartLive + ",roomId=" + getRoomId() + ",viewerNumWhenInit=" + getViewerNumWhenInit() + ",liveRoomProgramId=" + getLiveRoomProgramId() + ",anchorIsSelf=" + getAnchorIsSelf() + "}";
    }

    public final void updateFromLiveRoomInfo(@Nullable ILiveRoomInfo roomInfo) {
        int i3;
        String str;
        String liveStreamUrl;
        long j3;
        ILiveRoomAnchorInfo anchorInfo;
        String roomId;
        setLiveChannelRoomInfo(LiveChannelRoomInfo.parseFrom(roomInfo));
        if (roomInfo != null) {
            i3 = roomInfo.getLiveTypeNum();
        } else {
            i3 = 0;
        }
        setLiveType(i3);
        String str2 = null;
        if (roomInfo != null) {
            str = roomInfo.getRoomTitle();
        } else {
            str = null;
        }
        this.liveRoomName = str;
        if (INSTANCE.i()) {
            if (roomInfo != null) {
                liveStreamUrl = roomInfo.getLiveStreamFlvUrl();
            }
            liveStreamUrl = null;
        } else {
            if (roomInfo != null) {
                liveStreamUrl = roomInfo.getLiveStreamUrl();
            }
            liveStreamUrl = null;
        }
        this.liveUrl = liveStreamUrl;
        if (roomInfo != null && (roomId = roomInfo.getRoomId()) != null) {
            j3 = Long.parseLong(roomId);
        } else {
            j3 = 0;
        }
        this.roomId = j3;
        if (roomInfo != null && (anchorInfo = roomInfo.getAnchorInfo()) != null) {
            str2 = anchorInfo.getAnchorTinyId();
        }
        this.anchorTinyId = str2;
    }

    public final void updateFromNewInfo(@NotNull GLiveChannelStartParams startParams) {
        String str;
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        this.isNeedOpenSharePanel = startParams.isNeedOpenSharePanel;
        this.bundle.putAll(startParams.bundle);
        if (Intrinsics.areEqual(this.key, startParams.key)) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "{\n            // \u8bf4\u660e\u662f\u6d6e\u7a97\u573a\u666f\u2026ID().toString()\n        }");
        } else {
            str = startParams.key;
        }
        this.key = str;
    }

    @JvmStatic
    @NotNull
    public static final GLiveChannelStartParams create(@NotNull b bVar) {
        return INSTANCE.c(bVar);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final GLiveChannelStartParams create(@NotNull IGProChannelInfo iGProChannelInfo) {
        return INSTANCE.d(iGProChannelInfo);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final GLiveChannelStartParams create(@NotNull IGProChannelInfo iGProChannelInfo, @Nullable QQGuildChannelLive qQGuildChannelLive) {
        return INSTANCE.e(iGProChannelInfo, qQGuildChannelLive);
    }
}
