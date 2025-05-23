package com.tencent.mobileqq.guild.feed.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.base.GuildTransBottomSheetDialogFragment;
import com.tencent.mobileqq.guild.feed.comment.fragment.GuildFeedListCommentFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildChannelFrag;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fH\u0002J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001ej\b\u0012\u0004\u0012\u00020\u0012`\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J6\u0010%\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010#J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u0012J\u0018\u0010(\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\f\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/GuildFeedCommentUtil;", "", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "detailInitBean", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "p", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "i", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "dialogTip", "jump2AIOAfterJoin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isMember", "f", "guildId", "channelId", "l", "", "g", "j", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "", "dtParams", DomainData.DOMAIN_NAME, "verifyUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedCommentUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedCommentUtil f223766a = new GuildFeedCommentUtil();

    GuildFeedCommentUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(Context context, GProStFeed stFeed, boolean isMember) {
        String valueOf = String.valueOf(stFeed.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(stFeed.channelInfo.sign.channelId);
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
            return !l(valueOf, valueOf2);
        }
        return false;
    }

    private final CharSequence g(String guildId, String channelId) {
        Pair<Long, Long> s16 = GuildInfoManager.q().s(guildId, channelId);
        Long expireTimeOfAll = s16.component1();
        Long expireTimeOfSelf = s16.component2();
        Intrinsics.checkNotNullExpressionValue(expireTimeOfAll, "expireTimeOfAll");
        if (expireTimeOfAll.longValue() > NetConnInfoCenter.getServerTime()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f144570p5);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_fee\u2026ive_mute_all_hint_format)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{com.tencent.mobileqq.guild.setting.mute.c.B(expireTimeOfAll)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        Intrinsics.checkNotNullExpressionValue(expireTimeOfSelf, "expireTimeOfSelf");
        if (expireTimeOfSelf.longValue() > NetConnInfoCenter.getServerTime()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String qqStr2 = HardCodeUtil.qqStr(R.string.f144600p8);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_feed_native_self_muted_tips)");
            String format2 = String.format(qqStr2, Arrays.copyOf(new Object[]{com.tencent.mobileqq.guild.setting.mute.c.G(expireTimeOfSelf)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return "";
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> h(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        ArrayList arrayList = new ArrayList();
        ArrayList<GProStComment> arrayList2 = stFeed.externalCommentList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "stFeed.externalCommentList");
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            String str = ((GProStComment) it.next()).idd;
            Intrinsics.checkNotNullExpressionValue(str, "item.idd");
            arrayList.add(str);
        }
        return com.tencent.mobileqq.troop.utils.bg.f302144a.n(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(IGProGuildInfo guildInfo) {
        if (guildInfo != null && ch.r(guildInfo.getGuildID())) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                ch.h1(qBaseActivity, guildInfo.getGuildID());
                return true;
            }
            QLog.e("Guild_Feed_GuildFeedCommentLikeUtil", 1, "activity is null or finishing");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(GProStFeed stFeed, Context context) {
        boolean z16;
        String str;
        boolean z17;
        if (stFeed.getAllowFeedComment() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean areEqual = Intrinsics.areEqual(stFeed.poster.idd, str);
        if (!z16 && !areEqual) {
            z17 = false;
        } else {
            z17 = true;
        }
        QLog.i("Guild_Feed_GuildFeedCommentLikeUtil", 1, "isInterceptComment isCanComment:" + z17 + "  stFeed.getAllowFeedComment()=" + stFeed.getAllowFeedComment() + "  feed.getPosterId():" + stFeed.poster.idd + "  currentAccountTinyId:" + str);
        if (z17) {
            return false;
        }
        QQToastUtil.showQQToast(0, context.getString(R.string.f144460ou));
        return true;
    }

    private final boolean l(String guildId, String channelId) {
        boolean L = GuildInfoManager.L(guildId, channelId);
        boolean K = GuildInfoManager.q().K(guildId, channelId);
        boolean P = GuildInfoManager.q().P(channelId);
        boolean M = com.tencent.mobileqq.guild.setting.mute.c.M(guildId);
        if (!L) {
            return false;
        }
        if (P && K) {
            return false;
        }
        if (!P && M) {
            return false;
        }
        yl1.n.A(0, g(guildId, channelId));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Context context, JumpGuildParam jumpGuildParam, String dialogTip, boolean jump2AIOAfterJoin) {
        Intent a16 = JoinGuildChannelFrag.INSTANCE.a(jumpGuildParam, dialogTip, jump2AIOAfterJoin, false);
        if (context instanceof Activity) {
            GuildTransBottomSheetDialogFragment.INSTANCE.a(context, a16, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
            return;
        }
        if (QBaseActivity.sTopActivity != null) {
            GuildTransBottomSheetDialogFragment.Companion companion = GuildTransBottomSheetDialogFragment.INSTANCE;
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
            companion.a(sTopActivity, a16, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
            return;
        }
        GuildTransBottomSheetDialogFragment.INSTANCE.a(context, a16, JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(GuildFeedCommentUtil guildFeedCommentUtil, View view, GProStFeed gProStFeed, GuildFeedBaseInitBean guildFeedBaseInitBean, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        guildFeedCommentUtil.n(view, gProStFeed, guildFeedBaseInitBean, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(GuildFeedDetailInitBean detailInitBean, GProStFeed stFeed, View rootView) {
        FragmentManager fragmentManager;
        try {
            fragmentManager = FragmentManager.findFragment(rootView).getChildFragmentManager();
        } catch (IllegalStateException unused) {
            QLog.e("Guild_Feed_GuildFeedCommentLikeUtil", 1, "[showCommentInputInner]: fm not found, bean.guildId=" + detailInitBean.getGuildId());
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            GuildFeedListCommentFragment.INSTANCE.a(fragmentManager, rootView.getId(), detailInitBean, stFeed);
        }
    }

    public final boolean k(@Nullable IGProGuildInfo guildInfo, boolean isMember) {
        if (guildInfo == null || isMember || ((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getIsVisitorOperate(guildInfo, 1)) {
            return false;
        }
        return true;
    }

    public final void n(@NotNull final View rootView, @NotNull final GProStFeed stFeed, @NotNull final GuildFeedBaseInitBean initBean, @Nullable final Map<String, Object> dtParams) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        GuildMainFrameUtils.l(String.valueOf(stFeed.channelInfo.sign.guildId), false, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedCommentUtil$showCommentFragment$1
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
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                boolean isMember;
                boolean f16;
                boolean i3;
                boolean j3;
                GuildFeedDetailInitBean detailInitBean = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(GProStFeed.this, initBean, "");
                if (iGProGuildInfo == null) {
                    QLog.e("Guild_Feed_GuildFeedCommentLikeUtil", 1, "fetchGuildInfoAnyway failed");
                    isMember = true;
                } else {
                    isMember = iGProGuildInfo.isMember();
                }
                GuildFeedCommentUtil guildFeedCommentUtil = GuildFeedCommentUtil.f223766a;
                Context context = rootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                f16 = guildFeedCommentUtil.f(context, GProStFeed.this, isMember);
                if (f16) {
                    if (!guildFeedCommentUtil.k(iGProGuildInfo, isMember)) {
                        i3 = guildFeedCommentUtil.i(iGProGuildInfo);
                        if (i3) {
                            QLog.d("Guild_Feed_GuildFeedCommentLikeUtil", 1, "interceptVisitorCertification, show toast and return");
                            return;
                        }
                        GProStFeed gProStFeed = GProStFeed.this;
                        Context context2 = rootView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
                        j3 = guildFeedCommentUtil.j(gProStFeed, context2);
                        if (j3) {
                            return;
                        }
                        detailInitBean.setStFeed(GProStFeed.this);
                        detailInitBean.setIsMember(isMember);
                        Map<String, Object> map = dtParams;
                        if (map != null) {
                            if (detailInitBean.getDiscoverSearchDtParams() == null) {
                                detailInitBean.setDiscoverSearchDtParams(new HashMap<>());
                            }
                            detailInitBean.getDiscoverSearchDtParams().put("sgrp_section_name", String.valueOf(map.get("sgrp_section_name")));
                            detailInitBean.getDiscoverSearchDtParams().put("sgrp_forum_trace_id", String.valueOf(map.get("sgrp_forum_trace_id")));
                            detailInitBean.getDiscoverSearchDtParams().put("sgrp_rank", String.valueOf(map.get("sgrp_rank")));
                        }
                        Intrinsics.checkNotNullExpressionValue(detailInitBean, "detailInitBean");
                        guildFeedCommentUtil.p(detailInitBean, GProStFeed.this, rootView);
                        return;
                    }
                    QLog.d("Guild_Feed_GuildFeedCommentLikeUtil", 1, "isInvisibleForVisitor, show dialog and return");
                    yl1.n.z(0, R.string.f144500oy);
                    JumpGuildParam jumpGuildParam = new JumpGuildParam(detailInitBean.getGuildId(), detailInitBean.getChannelId());
                    JumpGuildParam.JoinInfoParam joinInfoParam = detailInitBean.getJoinInfoParam();
                    if (joinInfoParam != null) {
                        jumpGuildParam.setJoinInfoParam(joinInfoParam);
                    }
                    Context context3 = rootView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "rootView.context");
                    String qqStr = HardCodeUtil.qqStr(R.string.f147280wg);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026_unlock_interactive_tips)");
                    guildFeedCommentUtil.m(context3, jumpGuildParam, qqStr, false);
                }
            }
        });
    }

    public final void q(@NotNull Context context, @Nullable String verifyUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.guild.feed.feedsquare.utils.j jVar = com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a;
        String string = context.getString(R.string.f144590p7);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ed_verify_real_name_tips)");
        String string2 = context.getString(R.string.f157191m9);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026_threshold_aio_auth_jump)");
        jVar.h(context, verifyUrl, string, string2);
    }
}
