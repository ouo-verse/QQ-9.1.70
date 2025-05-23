package com.tencent.mobileqq.guild.feed.report;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import guild.GuildClientReport$SingleTableData;
import guild.GuildCommon$BytesEntry;
import guild.GuildCommon$Entry;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e {
    public static GuildCommon$Entry a(String str, String str2) {
        GuildCommon$Entry guildCommon$Entry = new GuildCommon$Entry();
        if (str != null) {
            guildCommon$Entry.key.set(str);
        }
        if (str2 != null) {
            guildCommon$Entry.value.set(str2);
        }
        return guildCommon$Entry;
    }

    public static GuildClientReport$SingleTableData b(int i3, List<GuildCommon$Entry> list, List<GuildCommon$Entry> list2, List<GuildCommon$BytesEntry> list3) {
        GuildClientReport$SingleTableData guildClientReport$SingleTableData = new GuildClientReport$SingleTableData();
        guildClientReport$SingleTableData.tableID.set(i3);
        if (list != null && !list.isEmpty()) {
            guildClientReport$SingleTableData.reportData.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            guildClientReport$SingleTableData.extInfo.addAll(list2);
        }
        if (list3 != null && !list3.isEmpty()) {
            guildClientReport$SingleTableData.byteExtInfo.addAll(list3);
        }
        return guildClientReport$SingleTableData;
    }

    public static void c(GProStFeed gProStFeed, String str, String str2, String str3, String str4, String str5) {
        if (gProStFeed == null) {
            QLog.e("GuildFeedReportHelper", 1, "reportAttaData: feed is null, actionType[" + str + "]");
            return;
        }
        QLog.e("GuildFeedReportHelper", 1, "reportAttaData: feed[" + gProStFeed.idd + "] actionType[" + str + "]");
        GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(f.b(gProStFeed, str3).K(str).J("success").Y(str2).g0(str4).V(str3).f0(str5)));
    }

    public static void d(String str, String str2, String str3, String str4, long j3) {
        QLog.e("GuildFeedReportHelper", 1, "reportPageAttaData:  actionType[" + str + "] pageId[" + str2 + "] type[" + str3 + "]" + str4 + "]");
        GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(f.f().K(str).J("success").Y(str2).g0(str4)));
    }

    public static void e(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QLog.e("GuildFeedReportHelper", 1, "reportPageAttaData: guildId[" + str + "] channelId[" + str2 + " actionType[" + str3 + "] pageId[" + str4 + "] type[" + str5 + "] prePageId[" + str6 + "] preType[" + str7 + "]");
            GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(f.g(str, str2, "pg_sgrp_forum").K(str3).J("success").Y(str4).V(str5).g0(str6).f0(str7).Z(String.valueOf(j3))));
            return;
        }
        QLog.e("GuildFeedReportHelper", 1, "reportPageAttaData: guildId\u3001channelId == null");
    }
}
