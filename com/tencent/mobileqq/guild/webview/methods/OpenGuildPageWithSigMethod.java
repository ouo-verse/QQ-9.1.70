package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.ipc.methods.aj;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes14.dex */
public class OpenGuildPageWithSigMethod extends a {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface PageTypeWithSig {
        public static final int S_PAGE_TYPE_GUILD_STANDALONE_CHANNEL = 3;
        public static final int S_PAGE_TYPE_GUILD_TAB = 2;
        public static final int S_PAGE_TYPE_STANDALONE_DIALOG = 1;
        public static final int S_PAGE_TYPE_STANDALONE_FULL = 0;
    }

    private JumpGuildParam l() {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(f("guildId"), f("channelId"), f("joinSig"), g("sourceId", "share"), g("subSourceId", "others"));
        jumpGuildParam.setReportSourceInfo(m());
        Bundle bundle = jumpGuildParam.extras;
        bundle.putString("PGIN_SOURCE_REPORT_KEY", g("appChannel", ""));
        bundle.putInt("entranceId", e("entranceId", 4));
        bundle.putString("backUrl", g("backUrl", ""));
        if ("functional_qq_search".equals(f("appChannel"))) {
            bundle.putInt("sgrp_stream_pgin_source", 22);
        }
        return jumpGuildParam;
    }

    private GuildAppReportSourceInfo m() {
        if (TextUtils.isEmpty(g("appChannel", ""))) {
            QLog.w("Guild.jump.JS.OpenGuildPageWithSigMethod", 1, "getReportInfo appChannel should not be empty!");
        }
        g("pginSource", "");
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        if (j(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY)) {
            guildAppReportSourceInfo.addReportItem(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, f(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY));
        }
        if (j(JumpGuildParam.EXTRA_KEY_TRACE_ID)) {
            guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, f(JumpGuildParam.EXTRA_KEY_TRACE_ID));
        }
        if (j(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY)) {
            guildAppReportSourceInfo.addReportItem(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY, f(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY));
        }
        if (j("sgrp_search_res_node_position")) {
            guildAppReportSourceInfo.addReportItem("sgrp_search_res_index", f("sgrp_search_res_index"));
        }
        if (j("sgrp_search_res_index")) {
            guildAppReportSourceInfo.addReportItem("sgrp_search_res_index", f("sgrp_search_res_index"));
        }
        return guildAppReportSourceInfo;
    }

    @Override // com.tencent.mobileqq.guild.webview.methods.a
    protected boolean k(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        int e16;
        boolean c16 = c("openStandalone", false);
        if (c16) {
            e16 = 0;
        } else {
            e16 = e("pageType", 0);
        }
        QLog.d("Guild.jump.JS.OpenGuildPageWithSigMethod", 1, "openStandaloneAttr: " + c16);
        com.tencent.mobileqq.guild.util.y.g(aj.class, Integer.valueOf(e16), l());
        return true;
    }
}
