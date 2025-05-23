package com.tencent.mobileqq.guild.contentshare.fragment;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.media.z;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yg1.ItemData;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJQ\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J!\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/fragment/e;", "", "", "position", "Lyg1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/contentshare/d;", "contentShareInfo", "scene", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "e", "(ILyg1/a;Lcom/tencent/mobileqq/guild/contentshare/d;Ljava/lang/Integer;)Ljava/util/HashMap;", "data", "f", "(Ljava/lang/Object;)Ljava/lang/Integer;", "c", "", "a", "guildId", "channelId", "g", "d", "(Ljava/lang/String;Ljava/lang/Integer;)I", "", "b", "(Lyg1/a;ILcom/tencent/mobileqq/guild/contentshare/d;Ljava/lang/Integer;)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f216326a = new e();

    e() {
    }

    private final boolean a(ItemData item) {
        if (item.getPlatformType() != 3 && item.getPlatformType() != 2) {
            return true;
        }
        return ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).isWXAppInstalled();
    }

    private final String c(ItemData item) {
        if ((item.getPlatformType() != 3 && item.getPlatformType() != 2) || ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).isWXAppInstalled()) {
            return "";
        }
        return "Not Installed";
    }

    private final int d(String channelId, Integer scene) {
        IGProChannelInfo channelInfo;
        if (scene != null && scene.intValue() == 0) {
            return 1;
        }
        if (scene != null && scene.intValue() == 1) {
            return 7;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (channelInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(channelId)) == null) {
            return 0;
        }
        return channelInfo.getType();
    }

    private final HashMap<String, Object> e(int position, ItemData item, com.tencent.mobileqq.guild.contentshare.d contentShareInfo, Integer scene) {
        QLog.i("StatisticUtils", 4, "getDTParams position=" + position + " name=" + item.getPlatformName());
        HashMap<String, Object> hashMap = new HashMap<>();
        String guildId = contentShareInfo.getChannelInfo().getGuildId();
        String guildId2 = contentShareInfo.getChannelInfo().getGuildId();
        hashMap.put("sgrp_channel_id", guildId);
        hashMap.put("sgrp_sub_channel_id", guildId2);
        hashMap.put("sgrp_user_type", Integer.valueOf(g(guildId, guildId2)));
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(d(guildId2, scene)));
        hashMap.put("sgrp_content_id", contentShareInfo.getContentId());
        Integer f16 = f(contentShareInfo.getData());
        if (f16 != null) {
            hashMap.put("sgrp_msg_type", Integer.valueOf(f16.intValue()));
        }
        hashMap.put("sgrp_rank", Integer.valueOf(position));
        hashMap.put("sgrp_share_item", item.getPlatformName());
        hashMap.put("sgrp_is_success", Integer.valueOf(a(item) ? 1 : 0));
        hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, c(item));
        return hashMap;
    }

    private final Integer f(Object data) {
        if (data instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) data;
            if (qr0.d.o(guildMsgItem) && !qr0.d.g(guildMsgItem)) {
                return 1;
            }
            if (qr0.d.m(guildMsgItem) && !qr0.d.f(guildMsgItem)) {
                return 2;
            }
            if ((!qr0.d.k(guildMsgItem) || qr0.d.f(guildMsgItem)) && qr0.d.n(guildMsgItem)) {
                return 4;
            }
            return 3;
        }
        return null;
    }

    private final int g(String guildId, String channelId) {
        return z.h(guildId, channelId);
    }

    public final void b(@NotNull ItemData item, int position, @NotNull com.tencent.mobileqq.guild.contentshare.d contentShareInfo, @Nullable Integer scene) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(contentShareInfo, "contentShareInfo");
        VideoReport.reportEvent("ev_sgrp_share_img_share_result", e(position, item, contentShareInfo, scene));
    }
}
