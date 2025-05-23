package com.tencent.mobileqq.guild.discovery.mine.util;

import android.content.Context;
import android.os.Bundle;
import ch1.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildChannelInfoApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import gq1.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010J6\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rJ\u0016\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/mine/util/OpenChannelUtil;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "e", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "d", "", "source", "pginSourceName", "Lcom/tencent/mobileqq/guild/discovery/mine/util/a;", "params", "g", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinGuildParam", "traceId", "f", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "", "pageFrom", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class OpenChannelUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final OpenChannelUtil f216755a = new OpenChannelUtil();

    OpenChannelUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Context context, IGProGuildInfo guildInfo, IGProChannelInfo channelInfo, JumpGuildParam jumpGuildParam) {
        if (channelInfo == null) {
            QLog.w("openChannelUtil", 1, "launchMediaChannelWrapper channelInfo is null");
            aa.a(R.string.f1503014m);
            return;
        }
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam(channelInfo.getChannelUin(), jumpGuildParam.getJoinSignature(), jumpGuildParam.getMainSource(), jumpGuildParam.getSubSource());
        Bundle bundle = new Bundle();
        bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
        bundle.putParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM, jumpGuildParam);
        bundle.putParcelable("GuildAppReportSourceInfo", jumpGuildParam.getReportSourceInfo());
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(context, guildInfo, channelInfo, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(IGProChannelInfo channelInfo, JumpGuildParam jumpGuildParam) {
        if (channelInfo == null) {
            QLog.w("openChannelUtil", 1, "openLiveChannel channelInfo is null");
            aa.a(R.string.f148480zp);
            return;
        }
        GLiveChannelStartParams f16 = GLiveChannelStartParams.Companion.f(GLiveChannelStartParams.INSTANCE, channelInfo, null, 2, null);
        f16.getBundle().putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, new JumpGuildParam.JoinInfoParam(channelInfo.getChannelUin(), jumpGuildParam.getJoinSignature(), jumpGuildParam.getMainSource(), jumpGuildParam.getSubSource()));
        f16.getBundle().putParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM, jumpGuildParam);
        f16.getBundle().putParcelable("GuildAppReportSourceInfo", jumpGuildParam.getReportSourceInfo());
        c.e(f16);
    }

    @NotNull
    public final String c(@NotNull DiscoverTabType tabType, int pageFrom) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        return b.f30840a.a(tabType, pageFrom);
    }

    public final void f(@NotNull String source, @NotNull String pginSourceName, @NotNull String guildId, @NotNull String channelId, @NotNull JumpGuildParam.JoinInfoParam joinGuildParam, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pginSourceName, "pginSourceName");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(joinGuildParam, "joinGuildParam");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        QLog.i("openChannelUtil", 1, "openLiveChannelFromDiscovery source: " + source + ", pginSourceName: " + pginSourceName + ", guildId: " + guildId + ", channelId: " + channelId);
        final JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, channelId, joinGuildParam.getJoinSignature(), joinGuildParam.getMainSource(), joinGuildParam.getSubSource());
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", pginSourceName);
        guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, traceId);
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        IGProChannelInfo C = ch.C(ch.l(), guildId, channelId);
        if (C == null) {
            QLog.w("openChannelUtil", 1, "openLiveChannelFromDiscovery try fetch channelInfo anyway");
            ((IGuildChannelInfoApi) QRoute.api(IGuildChannelInfoApi.class)).fetchChannelInfoAnyway(guildId, channelId, new Function1<IGProChannelInfo, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.mine.util.OpenChannelUtil$openLiveChannelFromDiscovery$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo) {
                    invoke2(iGProChannelInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable IGProChannelInfo iGProChannelInfo) {
                    OpenChannelUtil.f216755a.e(iGProChannelInfo, JumpGuildParam.this);
                }
            });
        } else {
            e(C, jumpGuildParam);
        }
    }

    public final void g(@NotNull final String source, @NotNull final Context context, @NotNull final String pginSourceName, @NotNull final MediaChannelParams params) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pginSourceName, "pginSourceName");
        Intrinsics.checkNotNullParameter(params, "params");
        final JumpGuildParam jumpGuildParam = new JumpGuildParam(params.getGuildId(), params.getChannelId(), params.getJoinGuildSig(), params.getJoinGuildMainSource(), params.getJoinGuildSubSource());
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", pginSourceName);
        guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, params.getTraceId());
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        GuildMainFrameUtils.k(params.getGuildId(), new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.mine.util.OpenChannelUtil$openMediaAliveChannel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable final IGProGuildInfo iGProGuildInfo) {
                IGuildChannelInfoApi iGuildChannelInfoApi = (IGuildChannelInfoApi) QRoute.api(IGuildChannelInfoApi.class);
                String guildId = MediaChannelParams.this.getGuildId();
                String channelId = MediaChannelParams.this.getChannelId();
                final MediaChannelParams mediaChannelParams = MediaChannelParams.this;
                final String str = source;
                final String str2 = pginSourceName;
                final Context context2 = context;
                final JumpGuildParam jumpGuildParam2 = jumpGuildParam;
                iGuildChannelInfoApi.fetchChannelInfoAnyway(guildId, channelId, new Function1<IGProChannelInfo, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.mine.util.OpenChannelUtil$openMediaAliveChannel$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo) {
                        invoke2(iGProChannelInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable IGProChannelInfo iGProChannelInfo) {
                        boolean z16 = false;
                        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 5) {
                            z16 = true;
                        }
                        if (!z16) {
                            OpenChannelUtil.f216755a.d(context2, iGProGuildInfo, iGProChannelInfo, jumpGuildParam2);
                        } else {
                            OpenChannelUtil.f216755a.f(str, str2, MediaChannelParams.this.getGuildId(), MediaChannelParams.this.getChannelId(), new JumpGuildParam.JoinInfoParam("", MediaChannelParams.this.getJoinGuildSig(), MediaChannelParams.this.getJoinGuildMainSource(), MediaChannelParams.this.getJoinGuildSubSource()), MediaChannelParams.this.getTraceId());
                        }
                    }
                });
            }
        });
    }
}
