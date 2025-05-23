package com.tencent.mobileqq.guild.feed.report;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f {
    public static void a(View view) {
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    public static GuildFeedReportTable12003.a b(GProStFeed gProStFeed, String str) {
        GuildFeedReportTable12003.a aVar = new GuildFeedReportTable12003.a();
        if (gProStFeed == null) {
            QLog.e("GuildFeedReportUtil", 1, "feed == null");
            return aVar;
        }
        String valueOf = String.valueOf(gProStFeed.meta.content.ContentID);
        String str2 = gProStFeed.idd;
        String str3 = gProStFeed.poster.idd;
        String u16 = ax.u();
        String str4 = gProStFeed.poster.idd;
        String valueOf2 = String.valueOf(gProStFeed.channelInfo.sign.guildId);
        String valueOf3 = String.valueOf(gProStFeed.channelInfo.sign.channelId);
        e(aVar);
        aVar.e0(l(u16, valueOf2, valueOf3, str));
        aVar.U(str2);
        aVar.n0(str4);
        aVar.O(valueOf);
        aVar.P(h(gProStFeed));
        aVar.j0(valueOf2);
        aVar.k0(valueOf3);
        aVar.l0(String.valueOf(7));
        aVar.L(str3);
        aVar.h0(gProStFeed.recomInfo.recomTrace);
        return aVar;
    }

    public static Map<String, Object> c(String str, String str2, String str3, int i3, String str4, boolean z16) {
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        if (str == null) {
            str5 = "";
        } else {
            str5 = str;
        }
        hashMap.put("sgrp_channel_id", str5);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("sgrp_sub_channel_id", str2);
        hashMap.put("sgrp_subchannel_type", String.valueOf(7));
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("sgrp_author_uin", str3);
        hashMap.put("sgrp_forum_viewer_enter_source", Integer.valueOf(a.b(i3)));
        hashMap.put("sgrp_user_type", j(str));
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        hashMap.put("group_id", str4);
        if (z16) {
            hashMap.put("sgrp_content_type", "2");
        } else {
            hashMap.put("sgrp_content_type", "1");
        }
        return hashMap;
    }

    public static Map<String, Object> d(GProStFeed gProStFeed, String str) {
        HashMap hashMap = new HashMap();
        if (gProStFeed == null) {
            return hashMap;
        }
        String valueOf = String.valueOf(gProStFeed.meta.content.ContentID);
        String str2 = gProStFeed.poster.idd;
        String u16 = ax.u();
        String valueOf2 = String.valueOf(gProStFeed.channelInfo.sign.guildId);
        String valueOf3 = String.valueOf(gProStFeed.channelInfo.sign.channelId);
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("forum_tab", Integer.valueOf(r(l(u16, valueOf2, valueOf3, str))));
        hashMap.put("forum_content_id", valueOf);
        hashMap.put("forum_content_type", h(gProStFeed));
        hashMap.put("sgrp_author_uin", str2);
        hashMap.put("sgrp_feed_id", gProStFeed.idd);
        hashMap.put("sgrp_content_id", valueOf);
        hashMap.put("sgrp_sub_channel_id", valueOf3);
        hashMap.put("sgrp_channel_id", valueOf2);
        hashMap.put("sgrp_user_type", j(String.valueOf(valueOf2)));
        return hashMap;
    }

    private static void e(GuildFeedReportTable12003.a aVar) {
        aVar.W(String.valueOf(System.currentTimeMillis()));
        aVar.Q(k());
        aVar.m0(n());
        aVar.o0(ax.v());
        aVar.b0("Android");
    }

    public static GuildFeedReportTable12003.a f() {
        GuildFeedReportTable12003.a aVar = new GuildFeedReportTable12003.a();
        e(aVar);
        return aVar;
    }

    public static GuildFeedReportTable12003.a g(String str, String str2, String str3) {
        GuildFeedReportTable12003.a aVar = new GuildFeedReportTable12003.a();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String u16 = ax.u();
            e(aVar);
            aVar.e0(l(u16, str, str2, str3));
            aVar.j0(str);
            aVar.k0(str2);
            aVar.l0(String.valueOf(7));
            return aVar;
        }
        QLog.e("GuildFeedReportUtil", 1, "guildId\u3001channelId == null");
        return aVar;
    }

    private static String h(GProStFeed gProStFeed) {
        boolean z16;
        boolean z17;
        if (gProStFeed == null) {
            return "";
        }
        ArrayList<GProStRichTextContent> arrayList = gProStFeed.contents.contents;
        boolean z18 = true;
        if (arrayList != null && arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<GProStImage> arrayList2 = gProStFeed.images;
        if (arrayList2 != null && arrayList2.size() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        ArrayList<GProStVideo> arrayList3 = gProStFeed.videos;
        if (arrayList3 == null || arrayList3.size() <= 0) {
            z18 = false;
        }
        return p(z16, z17, z18);
    }

    public static short i(int i3) {
        if (i3 == 1) {
            return (short) 3;
        }
        if (i3 == 2) {
            return (short) 1;
        }
        if (i3 == 3) {
            return (short) 2;
        }
        return (short) 0;
    }

    public static String j(String str) {
        IGPSService iGPSService;
        IGProGuildInfo guildInfo;
        if (str == null) {
            return "4";
        }
        try {
            iGPSService = GuildInfoManager.q().i();
        } catch (Exception e16) {
            QLog.e("GuildFeedReportUtil", 1, "getCurrentUserType getGPSService error :" + e16);
            iGPSService = null;
        }
        if (iGPSService == null || (guildInfo = iGPSService.getGuildInfo(str)) == null) {
            return "4";
        }
        return a.a(guildInfo.isMember(), guildInfo.getUserType());
    }

    public static String k() {
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(1)) + String.valueOf(calendar.get(2) + 1) + String.valueOf(calendar.get(5));
    }

    public static String l(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null) {
            if (TextUtils.equals(str4, "2")) {
                return m(str, str2);
            }
            int y16 = GuildInfoManager.q().y(str, str2, str3);
            if (y16 != 1 && y16 != 3) {
                return "hot";
            }
            return QCircleDaTongConstant.ElementParamValue.NEW;
        }
        return "";
    }

    public static String m(String str, String str2) {
        if (str != null && str2 != null) {
            int D = GuildInfoManager.q().D(str, str2);
            if (D != 1 && D != 3) {
                return "hot";
            }
            return QCircleDaTongConstant.ElementParamValue.NEW;
        }
        return "";
    }

    public static String n() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str) || !ch.n0(str)) {
            return "2";
        }
        return "1";
    }

    public static String p(boolean z16, boolean z17, boolean z18) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (!z16) {
            str = "";
        } else {
            str = "text";
        }
        if (!z17) {
            str2 = "";
        } else {
            str2 = "picture";
        }
        if (!z18) {
            str3 = "";
        } else {
            str3 = "video";
        }
        if (!z16 || !z17) {
            str4 = "";
        } else {
            str4 = "_";
        }
        if (z16 && z18) {
            str5 = "_";
        }
        return str + str4 + str2 + str5 + str3;
    }

    public static void q(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static int r(String str) {
        if (str.equals("hot")) {
            return 1;
        }
        return 2;
    }
}
