package com.tencent.mobileqq.guild.report;

import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/report/e;", "", "", "reason", "", "c", "a", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f232013a = new e();

    e() {
    }

    @Deprecated(message = "9080 \u89c1 GuildTabReport9080Utils.getTabStateReportValue")
    @JvmStatic
    @NotNull
    public static final String a() {
        UnreadInfo.a aVar;
        IGuildDelayInitializeService iGuildDelayInitializeService = (IGuildDelayInitializeService) ch.R0(IGuildDelayInitializeService.class);
        if (iGuildDelayInitializeService != null) {
            aVar = iGuildDelayInitializeService.getGuildTabUnreadCountSafely();
        } else {
            aVar = null;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.tab.GuildTabReportUtils", 2, "getTabStateReportValue totalUnreadCntInfo=" + aVar);
        }
        if (aVar != null && aVar.getCount() > 0) {
            if (aVar.getIsStrongUnread()) {
                return "tab_noricon_number";
            }
            return "tab_noricon_red_point";
        }
        return "tab_noricon_null";
    }

    @JvmStatic
    public static final void c(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        HashMap hashMap = new HashMap();
        hashMap.put("disappear_cause", reason);
        hashMap.put("sgrp_channel_changetab_state", a());
        VideoReport.reportEvent("ev_sgrp_channel_tab_state_disappear", hashMap);
    }

    @NotNull
    public final String b() {
        return String.valueOf(((IGuildDelayInitializeService) ch.R0(IGuildDelayInitializeService.class)).getGuildTabUnreadCountSafely().getCount());
    }
}
