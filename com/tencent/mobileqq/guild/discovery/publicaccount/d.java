package com.tencent.mobileqq.guild.discovery.publicaccount;

import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/publicaccount/d;", "", "", "a", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "pubAccountParams", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "reportSourceInfo", "Ljava/util/HashMap;", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f216775a = new d();

    d() {
    }

    private final int a() {
        try {
            List<IGProGuildInfo> guildList = ((IGPSService) ch.R0(IGPSService.class)).getGuildList();
            if (guildList == null) {
                return 0;
            }
            return guildList.size();
        } catch (IllegalStateException unused) {
            return 0;
        }
    }

    @NotNull
    public final HashMap<String, Object> b(@NotNull GuildPublicAccountParams pubAccountParams, @NotNull GuildAppReportSourceInfo reportSourceInfo) {
        Intrinsics.checkNotNullParameter(pubAccountParams, "pubAccountParams");
        Intrinsics.checkNotNullParameter(reportSourceInfo, "reportSourceInfo");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_join_channel_num", Integer.valueOf(f216775a.a()));
        hashMap.put("sgrp_entry_public_accounts_type", Integer.valueOf(pubAccountParams.getJumpFrom()));
        hashMap.put("sgrp_is_tab_open", Integer.valueOf(ca.a() ? 1 : 0));
        hashMap.put("sgrp_public_new_message_type", Integer.valueOf(pubAccountParams.getLastMsgType()));
        hashMap.putAll(reportSourceInfo.getReportInfoMap());
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        return hashMap;
    }
}
