package ir1;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000b\u00a8\u0006%"}, d2 = {"Lir1/b;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$b;", "", NodeProps.VISIBLE, "", "d", "", "event", "c", "", "progress", "J", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "getGuildContainer", "()Landroid/view/ViewGroup;", "guildContainer", "f", "Ljava/lang/String;", "currentGuildId", h.F, "lastPageReportEvent", "i", "pageInSourceName", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "pageInTime", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements IGuildLayoutApi.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup guildContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentGuildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lastPageReportEvent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String pageInSourceName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long pageInTime;

    public b(@NotNull Activity activity, @NotNull ViewGroup guildContainer) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildContainer, "guildContainer");
        this.activity = activity;
        this.guildContainer = guildContainer;
        this.lastPageReportEvent = "pgout";
    }

    private final void c(String event) {
        boolean z16;
        String str;
        if (TextUtils.equals(this.lastPageReportEvent, event)) {
            return;
        }
        String str2 = this.currentGuildId;
        boolean z17 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildReportController", 2, "reportDtPageEvent(" + event + ") :guildId is null");
                return;
            }
            return;
        }
        this.lastPageReportEvent = event;
        VideoReport.addToDetectionWhitelist(this.activity);
        VideoReport.setPageId(this.guildContainer, "pg_sgrp_subscribe_channel");
        HashMap hashMap = new HashMap();
        if (TextUtils.equals(event, "pgin")) {
            this.pageInTime = System.currentTimeMillis();
            GuildAppReportSourceInfo fromActivity = GuildAppReportSourceInfo.fromActivity(this.activity);
            if (fromActivity != null) {
                str = fromActivity.getPageInSourceName();
            } else {
                str = null;
            }
            this.pageInSourceName = str;
            if (str == null || str.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                hashMap.put("sgrp_stream_pgin_source_name", this.pageInSourceName);
            }
            hashMap.put("sgrp_join_channel_num", Integer.valueOf(ch.N()));
        } else {
            hashMap.put(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(System.currentTimeMillis() - this.pageInTime));
            String str3 = this.pageInSourceName;
            if (str3 == null || str3.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                hashMap.put("sgrp_stream_pgin_source_name", this.pageInSourceName);
            }
            hashMap.put("sgrp_join_channel_num", Integer.valueOf(ch.N()));
        }
        hashMap.put("pgid", "pg_sgrp_subscribe_channel");
        w.b(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.guildContainer, this.currentGuildId, hashMap);
        VideoReport.setPageReportPolicy(this.guildContainer, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(this.guildContainer, new PageParams(hashMap));
        VideoReport.reportEvent(event, this.guildContainer, hashMap);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildReportController", 2, "reportDtPageEvent(" + event + ") : " + this.pageInSourceName + ", " + this.currentGuildId);
        }
    }

    private final void d(boolean visible) {
        boolean z16;
        boolean z17 = true;
        int i3 = 0;
        if (this.guildContainer.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != visible) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildReportController", "updateVisible: " + visible);
            }
            if (visible) {
                String str = this.currentGuildId;
                if (str != null && str.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    c("pgin");
                }
            } else {
                c("pgout");
            }
            ViewGroup viewGroup = this.guildContainer;
            if (!visible) {
                i3 = 8;
            }
            viewGroup.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.d
    public void J(float progress) {
        boolean z16;
        if (progress > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        d(z16);
    }
}
