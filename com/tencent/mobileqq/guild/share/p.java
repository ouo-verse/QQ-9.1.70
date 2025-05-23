package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class p {
    private static String a(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        int i3 = actionSheetItem.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 39) {
                                if (i3 != 171) {
                                    if (i3 != 179) {
                                        if (i3 != 196) {
                                            if (i3 != 72) {
                                                if (i3 != 73) {
                                                    return "null";
                                                }
                                                return "em_sgrp_share_panel_more_contacts";
                                            }
                                            return "em_sgrp_share_panel_recent_contacts";
                                        }
                                        return "em_sgrp_share_panel_qr";
                                    }
                                    return "em_sgrp_forum_video_mini_window";
                                }
                                return "em_sgrp_share_panel_channel";
                            }
                            return "em_sgrp_share_panel_save";
                        }
                        return "em_sgrp_share_panel_wechat_moments";
                    }
                    return "em_sgrp_share_panel_wechat_contacts";
                }
                return "em_sgrp_share_panel_qzone";
            }
            return "em_sgrp_share_panel_contacts";
        }
        return "em_sgrp_share_panel_copy_sharelink";
    }

    public static void b(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        c(view, actionSheetItem, a(actionSheetItem));
    }

    public static void c(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, String str) {
        String str2;
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        if (actionSheetItem.action == 72) {
            int i3 = actionSheetItem.uinType;
            if (i3 != 1) {
                if (i3 != 10014) {
                    str2 = "c2c";
                } else {
                    str2 = WadlProxyConsts.CHANNEL;
                }
            } else {
                str2 = "grp";
            }
            hashMap.put("sgrp_touin", actionSheetItem.uin);
            hashMap.put("sgrp_totype", str2);
        }
        VideoReport.reportEvent("clck", view, hashMap);
    }

    private static void d(Activity activity, ShareActionSheet shareActionSheet, String str, boolean z16, GuildSharePageSource guildSharePageSource) {
        int ordinal;
        String str2;
        if (shareActionSheet != null && shareActionSheet.getWindow() != null && activity != null) {
            View decorView = shareActionSheet.getWindow().getDecorView();
            if (decorView == null) {
                QLog.i("Guild.share.GuildShareDtReport", 1, "rootView null");
                return;
            }
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(decorView, "pg_sgrp_share_panel");
            HashMap hashMap = new HashMap();
            hashMap.put("pgid", "pg_sgrp_share_panel");
            if (guildSharePageSource != null) {
                ordinal = guildSharePageSource.ordinal();
            } else {
                ordinal = GuildSharePageSource.UNKNOWN.ordinal();
            }
            hashMap.put(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(ordinal));
            hashMap.put("sgrp_share_pannel_type", 0);
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(decorView, str, hashMap);
            VideoReport.setPageReportPolicy(decorView, PageReportPolicy.REPORT_NONE);
            if (z16) {
                str2 = "pgin";
            } else {
                str2 = "pgout";
            }
            VideoReport.reportEvent(str2, decorView, hashMap);
        }
    }

    public static void e(Activity activity, ShareActionSheet shareActionSheet, String str, GuildSharePageSource guildSharePageSource) {
        d(activity, shareActionSheet, str, true, guildSharePageSource);
    }

    public static void f(Activity activity, ShareActionSheet shareActionSheet, String str, GuildSharePageSource guildSharePageSource) {
        d(activity, shareActionSheet, str, false, guildSharePageSource);
    }
}
