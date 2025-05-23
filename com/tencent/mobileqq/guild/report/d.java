package com.tencent.mobileqq.guild.report;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0003J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/report/d;", "", "", "from", "", "d", "", "b", "c", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f232012a = new d();

    d() {
    }

    private final Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_changetab_state", c());
        return hashMap;
    }

    @JvmStatic
    private static final String c() {
        UnreadInfo.a aVar;
        IGuildDelayInitializeService iGuildDelayInitializeService = (IGuildDelayInitializeService) ch.R0(IGuildDelayInitializeService.class);
        if (iGuildDelayInitializeService != null) {
            aVar = iGuildDelayInitializeService.getGuildTabUnreadCountSafely();
        } else {
            aVar = null;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildTabReport9080Utils", 2, "getTabStateReportValue totalUnreadCntInfo=" + aVar);
        }
        if (aVar != null && aVar.getCount() > 0) {
            if (aVar.getIsStrongUnread()) {
                return "tab_noricon_number";
            }
            return "tab_noricon_red";
        }
        return "tab_noricon_null";
    }

    @JvmStatic
    public static final void d(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildTabReport9080Utils", 1, "reportTabClk from:" + from);
        }
        VideoReport.reportEvent("ev_sgrp_channel_tab_state_clk", f232012a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String from) {
        Intrinsics.checkNotNullParameter(from, "$from");
        long nanoTime = System.nanoTime();
        VideoReport.reportEvent("ev_sgrp_channel_tab_state_imp", f232012a.b());
        long nanoTime2 = System.nanoTime();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildTabReport9080Utils", 1, "reportTabImp from:" + from + " cost:" + (nanoTime2 - nanoTime) + "ns");
        }
    }

    public final void e(@NotNull final String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.report.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(from);
            }
        });
    }
}
