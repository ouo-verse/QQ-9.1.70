package com.tencent.mobileqq.guild.feed.report;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ:\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H\u0007J@\u0010\f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H\u0007JT\u0010\u0013\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H\u0007J`\u0010\u0016\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007J\u0018\u0010\u0019\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u0018\u001a\u00020\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/report/d;", "", "Landroid/view/View;", "view", "", "id", IECDtReport.ACTION_IDENTIFIER, "", "params", "", "b", "eventId", "a", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "d", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "e", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "g", "", "c", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f223284a = new d();

    d() {
    }

    @JvmStatic
    public static final void a(@Nullable String eventId, @Nullable View view, @Nullable String id5, @Nullable Map<String, ? extends Object> params) {
        try {
            VideoReport.setElementId(view, id5);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
            VideoReport.reportEvent(eventId, view, params);
        } catch (Exception e16) {
            QLog.e("GuildFeedPresenterReportUtil", 1, e16.getMessage());
        }
    }

    @JvmStatic
    public static final void b(@NotNull View view, @NotNull String id5, @NotNull String identifier, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        try {
            VideoReport.setEventType(view, EventAgingType.REALTIME);
            VideoReport.setElementId(view, id5);
            VideoReport.setElementReuseIdentifier(view, identifier + "#" + view.hashCode());
            if (params != null) {
                VideoReport.setElementParams(view, params);
            }
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        } catch (Exception e16) {
            QLog.e("GuildFeedPresenterReportUtil", 1, e16.getMessage());
        }
    }

    @JvmStatic
    public static final void d(@Nullable View view, @Nullable String id5, @NotNull ClickPolicy clickPolicy, @NotNull ExposurePolicy exposurePolicy, @NotNull EndExposurePolicy endExposurePolicy, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        e(view, id5, clickPolicy, exposurePolicy, endExposurePolicy, params, null);
    }

    @JvmStatic
    public static final void e(@Nullable View view, @Nullable String id5, @NotNull ClickPolicy clickPolicy, @NotNull ExposurePolicy exposurePolicy, @NotNull EndExposurePolicy endExposurePolicy, @Nullable Map<String, ? extends Object> params, @Nullable IDynamicParams dynamicParams) {
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(endExposurePolicy, "endExposurePolicy");
        try {
            VideoReport.setElementId(view, id5);
            VideoReport.setElementParams(view, params);
            VideoReport.setElementClickPolicy(view, clickPolicy);
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
            VideoReport.setEventType(view, EventAgingType.REALTIME);
            if (dynamicParams != null) {
                VideoReport.setEventDynamicParams(view, dynamicParams);
            }
        } catch (Exception e16) {
            QLog.e("GuildFeedPresenterReportUtil", 1, e16.getMessage());
        }
    }

    public static /* synthetic */ void f(View view, String str, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            clickPolicy = ClickPolicy.REPORT_NONE;
        }
        ClickPolicy clickPolicy2 = clickPolicy;
        if ((i3 & 8) != 0) {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        }
        ExposurePolicy exposurePolicy2 = exposurePolicy;
        if ((i3 & 16) != 0) {
            endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        }
        d(view, str, clickPolicy2, exposurePolicy2, endExposurePolicy, map);
    }

    @NotNull
    public final Map<String, Object> c(@NotNull GuildFeedBaseInitBean initBean) {
        int i3;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        HashMap hashMap = new HashMap();
        String guildId = initBean.getGuildId();
        String str = "";
        if (guildId == null) {
            guildId = "";
        }
        hashMap.put("sgrp_channel_id", guildId);
        String channelId = initBean.getChannelId();
        if (channelId == null) {
            channelId = "";
        }
        hashMap.put("sgrp_sub_channel_id", channelId);
        String channelName = initBean.getChannelName();
        if (channelName == null) {
            channelName = "";
        }
        hashMap.put("sgrp_section_name", channelName);
        String guildId2 = initBean.getGuildId();
        if (guildId2 != null) {
            str = guildId2;
        }
        String j3 = f.j(str);
        Intrinsics.checkNotNullExpressionValue(j3, "getCurrentUserType(initBean.guildId ?: \"\")");
        hashMap.put("sgrp_user_type", j3);
        hashMap.put("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c());
        hashMap.put("sgrp_visit_from", com.tencent.mobileqq.guild.report.b.f());
        if (initBean.getBusinessType() == 15) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("sgrp_section_type", Integer.valueOf(i3));
        hashMap.put("sgrp_session_id", com.tencent.mobileqq.guild.report.b.e());
        return hashMap;
    }

    public final void g(@Nullable View view, @NotNull GuildFeedBaseInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) c(initBean)));
    }
}
