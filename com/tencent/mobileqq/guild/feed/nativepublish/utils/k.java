package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/k;", "", "", "sceneType", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "c", "extra", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;", "commonExt", "", "a", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f222343a = new k();

    k() {
    }

    @JvmStatic
    public static final void a(@Nullable GuildFeedReportSourceInfo extra, @NotNull GProStCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        if (extra == null) {
            return;
        }
        String str = extra.getReportInfoMap().get("extra_feeds_page_id");
        if (!TextUtils.isEmpty(str)) {
            GProFeedEntry gProFeedEntry = new GProFeedEntry();
            gProFeedEntry.key = "page_id";
            gProFeedEntry.value = str;
            commonExt.mapInfoList.add(gProFeedEntry);
        }
        String str2 = extra.getReportInfoMap().get("extra_feeds_page_forum_type");
        if (!TextUtils.isEmpty(str2)) {
            GProFeedEntry gProFeedEntry2 = new GProFeedEntry();
            gProFeedEntry2.key = "sgrp_pg_forum_type";
            gProFeedEntry2.value = str2;
            commonExt.mapInfoList.add(gProFeedEntry2);
        }
        String str3 = extra.getReportInfoMap().get("extra_feeds_pre_page_id");
        if (!TextUtils.isEmpty(str3)) {
            GProFeedEntry gProFeedEntry3 = new GProFeedEntry();
            gProFeedEntry3.key = "re_page_id";
            gProFeedEntry3.value = str3;
            commonExt.mapInfoList.add(gProFeedEntry3);
        }
        String str4 = extra.getReportInfoMap().get("extra_feeds_pre_page_forum_type");
        if (!TextUtils.isEmpty(str4)) {
            GProFeedEntry gProFeedEntry4 = new GProFeedEntry();
            gProFeedEntry4.key = "re_sgrp_pg_forum_type";
            gProFeedEntry4.value = str4;
            commonExt.mapInfoList.add(gProFeedEntry4);
        }
        String str5 = extra.getReportInfoMap().get("extra_feeds_create_source");
        if (!TextUtils.isEmpty(str5)) {
            GProFeedEntry gProFeedEntry5 = new GProFeedEntry();
            gProFeedEntry5.key = "create_source";
            gProFeedEntry5.value = str5;
            commonExt.mapInfoList.add(gProFeedEntry5);
        }
        String str6 = extra.getReportInfoMap().get("extra_feeds_from_activity_id");
        if (!TextUtils.isEmpty(str6)) {
            GProFeedEntry gProFeedEntry6 = new GProFeedEntry();
            gProFeedEntry6.key = "sgrp_activity_id";
            gProFeedEntry6.value = str6;
            commonExt.mapInfoList.add(gProFeedEntry6);
        }
    }

    @JvmStatic
    public static final void b(@NotNull GProStCommonExt commonExt) {
        Intrinsics.checkNotNullParameter(commonExt, "commonExt");
        for (Map.Entry<String, String> entry : com.tencent.mobileqq.guild.report.b.d().entrySet()) {
            GProFeedEntry gProFeedEntry = new GProFeedEntry();
            gProFeedEntry.key = entry.getKey();
            gProFeedEntry.value = entry.getValue();
            commonExt.mapInfoList.add(gProFeedEntry);
        }
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedReportSourceInfo c(int sceneType, @Nullable GuildFeedBaseInitBean initBean) {
        String str;
        if (initBean == null) {
            return new GuildFeedReportSourceInfo();
        }
        if (sceneType == 2) {
            GuildFeedReportSourceInfo feedReportSourceInfo = initBean.getFeedReportSourceInfo();
            if (initBean.isMember()) {
                str = "pg_sgrp_forumshared_joined";
            } else {
                str = "pg_sgrp_forumshared_notjoined";
            }
            feedReportSourceInfo.addReportItem("extra_feeds_page_id", str);
            Intrinsics.checkNotNullExpressionValue(feedReportSourceInfo, "{\n            initBean.f\u2026)\n            }\n        }");
            return feedReportSourceInfo;
        }
        GuildFeedReportSourceInfo feedReportSourceInfo2 = initBean.getFeedReportSourceInfo();
        Intrinsics.checkNotNullExpressionValue(feedReportSourceInfo2, "{\n            initBean.f\u2026eportSourceInfo\n        }");
        return feedReportSourceInfo2;
    }
}
