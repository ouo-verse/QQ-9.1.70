package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedSchemeBean;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends a {
    private void f(Context context, String str, String str2) {
        String u16 = ch.u(str, str2, 9);
        new Bundle().putInt("titleBarStyle", 10);
        cx.a(context, u16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h(final HashMap hashMap, String str, String str2, String str3, final Context context, IGProChannelInfo iGProChannelInfo, final Boolean bool) {
        if (TextUtils.equals(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218133s), "1")) {
            GuildJumpUtil.n(context, new JumpGuildParam(str, str2, str3, "share", "others"));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.launcher.parser.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.g(context, hashMap, bool);
                }
            });
            return null;
        }
        g(context, hashMap, bool);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(final Context context, final String str, final String str2, final String str3, final HashMap hashMap, IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            QLog.w("GuildFeedDetailParser", 1, "[onGetGuildInfoAndShareParam] fetchGuildInfoAnyway failed");
            f(context, str, str2);
            return null;
        }
        if (!iGProGuildInfo.isVisibleForVisitor() && ch.j0(str)) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(str, str2, new JumpGuildParam.JoinInfoParam(str2, str3, "share", "others"));
            String a16 = a(hashMap, "sgrp_channel_extension_info");
            if (!TextUtils.isEmpty(a16)) {
                jumpGuildParam.extras.putString("sgrp_channel_extension_info", a16);
            }
            String a17 = a(hashMap, "param_key_search_extension_info");
            if (!TextUtils.isEmpty(a17)) {
                jumpGuildParam.extras.putString("param_key_search_extension_info", a17);
            }
            GuildJumpUtil.n(context, jumpGuildParam);
        } else {
            GuildMainFrameUtils.e(str, str2, new Function2() { // from class: com.tencent.mobileqq.guild.feed.launcher.parser.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h16;
                    h16 = e.this.h(hashMap, str, str2, str3, context, (IGProChannelInfo) obj, (Boolean) obj2);
                    return h16;
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void g(Context context, HashMap<String, Serializable> hashMap, Boolean bool) {
        String a16 = a(hashMap, com.tencent.mobileqq.guild.feed.b.f218117c);
        String a17 = a(hashMap, com.tencent.mobileqq.guild.feed.b.f218132r);
        GuildFeedDetailInitBean guildFeedDetailInitBean = new GuildFeedDetailInitBean();
        guildFeedDetailInitBean.setGuildId(a16);
        guildFeedDetailInitBean.setIsMember(!bool.booleanValue());
        guildFeedDetailInitBean.setChannelId(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218119e));
        guildFeedDetailInitBean.setPosterTinyId(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218124j));
        guildFeedDetailInitBean.setFeedId(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218120f));
        guildFeedDetailInitBean.setUserType(com.tencent.mobileqq.guild.feed.report.f.j(guildFeedDetailInitBean.getGuildId()));
        guildFeedDetailInitBean.setFromPage(4);
        String a18 = a(hashMap, com.tencent.mobileqq.guild.feed.b.f218121g);
        boolean z16 = false;
        if (!TextUtils.isEmpty(a18)) {
            guildFeedDetailInitBean.setPosition(az.c(a18, 0));
        }
        String a19 = a(hashMap, com.tencent.mobileqq.guild.feed.b.f218122h);
        if (!TextUtils.isEmpty(a19)) {
            guildFeedDetailInitBean.setCreateTime(az.d(a19, 0L));
        }
        String a26 = a(hashMap, com.tencent.mobileqq.guild.feed.b.f218123i);
        if (!TextUtils.isEmpty(a26)) {
            guildFeedDetailInitBean.setLastModifiedTime(az.d(a26, 0L));
        }
        guildFeedDetailInitBean.setVisitorTinyId(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).accountUin());
        String a27 = a(hashMap, com.tencent.mobileqq.guild.feed.b.f218131q);
        if (!TextUtils.isEmpty(a27)) {
            guildFeedDetailInitBean.setShareSource(az.c(a27, 0));
        }
        if (!TextUtils.isEmpty(a17)) {
            String a28 = a(hashMap, com.tencent.mobileqq.guild.feed.b.A);
            String a29 = a(hashMap, com.tencent.mobileqq.guild.feed.b.B);
            if (TextUtils.isEmpty(a28)) {
                a28 = "share";
            }
            if (TextUtils.isEmpty(a29)) {
                a29 = "others";
            }
            guildFeedDetailInitBean.setJoinInfoParam(new JumpGuildParam.JoinInfoParam("", a17, a28, a29));
        }
        guildFeedDetailInitBean.setCommentTransfer(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218125k));
        guildFeedDetailInitBean.setPageid(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218126l));
        guildFeedDetailInitBean.setTabid(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218127m));
        guildFeedDetailInitBean.setCommentId(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218128n));
        guildFeedDetailInitBean.setReplyId(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218129o));
        guildFeedDetailInitBean.setInviteCode(a(hashMap, com.tencent.mobileqq.guild.feed.b.f218130p));
        guildFeedDetailInitBean.setAttrs(hashMap);
        String a36 = a(hashMap, com.tencent.mobileqq.guild.feed.b.f218140z);
        if (!TextUtils.isEmpty(a36)) {
            GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
            guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", a36);
            guildFeedDetailInitBean.setFeedReportSourceInfo(guildFeedReportSourceInfo);
        }
        String a37 = a(hashMap, "businessType");
        if (!TextUtils.isEmpty(a37)) {
            guildFeedDetailInitBean.setBusinessType(az.c(a37, 0));
        }
        String a38 = a(hashMap, "troopUin");
        if (!TextUtils.isEmpty(a38)) {
            guildFeedDetailInitBean.setTroopUin(a38);
        }
        String a39 = a(hashMap, "troopRole");
        if (!TextUtils.isEmpty(a39)) {
            guildFeedDetailInitBean.setTroopRole(az.c(a39, 0));
        }
        if ("false".equals(a(hashMap, com.tencent.mobileqq.guild.feed.b.F)) || "0".equals(a(hashMap, com.tencent.mobileqq.guild.feed.b.F))) {
            z16 = true;
        }
        GuildFeedLauncher.x(context, guildFeedDetailInitBean, Boolean.valueOf(!((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).checkNeedWebView(guildFeedDetailInitBean.getFeedId(), !z16, a(hashMap, com.tencent.mobileqq.guild.feed.b.G))));
    }

    @Override // com.tencent.mobileqq.guild.feed.launcher.parser.a
    public void b(final Context context, GuildFeedSchemeBean guildFeedSchemeBean) {
        final HashMap<String, Serializable> attrs = guildFeedSchemeBean.getAttrs();
        if (attrs == null) {
            return;
        }
        final String a16 = a(attrs, com.tencent.mobileqq.guild.feed.b.f218117c);
        final String a17 = a(attrs, com.tencent.mobileqq.guild.feed.b.f218132r);
        final String a18 = a(attrs, com.tencent.mobileqq.guild.feed.b.f218119e);
        String a19 = a(attrs, com.tencent.mobileqq.guild.feed.b.f218134t);
        if (!TextUtils.isEmpty(a19)) {
            com.tencent.mobileqq.guild.report.b.g(a19, "GuildFeedDetailParser");
        }
        GuildMainFrameUtils.k(a16, new Function1() { // from class: com.tencent.mobileqq.guild.feed.launcher.parser.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i3;
                i3 = e.this.i(context, a16, a18, a17, attrs, (IGProGuildInfo) obj);
                return i3;
            }
        });
    }
}
