package com.tencent.mobileqq.guild.feed.util;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedReportBean;
import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.mobileqq.guild.feed.event.GuildFeedReportEvent;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.performance.report.FromType;
import com.tencent.mobileqq.guild.feed.performance.report.GuildFeedDetailInitData;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedReportHelper {

    /* renamed from: c, reason: collision with root package name */
    private static GuildFeedReportHelper f223778c;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f223779a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private boolean f223780b = true;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper$9, reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass9 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f223792d;
        final /* synthetic */ GuildFeedReportHelper this$0;

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("feed_detail_send_comment_time_from_tool", String.valueOf(System.currentTimeMillis()));
            String str = this.f223792d;
            if (str.length() > 10) {
                str = str.substring(0, 10);
            }
            hashMap.put("feed_detail_send_comment_content", str);
            this.this$0.l("gpro_quality#event#feed_channel_business_detail", "feed_detail_start_send_comment_event_from_tool", hashMap, false);
        }
    }

    GuildFeedReportHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
        GuildFeedDetailInitBean initBean;
        if (!(guildFeedBaseWebViewFragment instanceof GuildFeedDetailWebViewFragment) || (initBean = ((GuildFeedDetailWebViewFragment) guildFeedBaseWebViewFragment).getInitBean()) == null) {
            return "";
        }
        return initBean.getPosterTinyId();
    }

    public static GuildFeedReportHelper i() {
        if (f223778c == null) {
            synchronized (GuildFeedReportHelper.class) {
                if (f223778c == null) {
                    f223778c = new GuildFeedReportHelper();
                }
            }
        }
        return f223778c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
        return guildFeedBaseWebViewFragment instanceof GuildFeedDetailWebViewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void l(String str, String str2, Map<String, String> map, boolean z16) {
        GuildFeedReportBean guildFeedReportBean = new GuildFeedReportBean();
        ArrayList arrayList = new ArrayList();
        GuildFeedReportBean.ReportBean reportBean = new GuildFeedReportBean.ReportBean();
        reportBean.setTaskName(str);
        reportBean.setEvent(str2);
        if (str.equals("gpro_quality#event#feed_channel_publish")) {
            String h16 = GuildUploadHelper.i().h();
            if (!TextUtils.isEmpty(h16)) {
                map.put("feed_publish_task_id", h16);
            }
        }
        reportBean.setParams(map);
        QLog.d("GuildFeedReportHelper", 1, "send feed report: " + reportBean);
        arrayList.add(reportBean);
        guildFeedReportBean.setReportList(arrayList);
        bl.c().b(new GuildFeedReportEvent(guildFeedReportBean, z16), true);
    }

    public boolean g() {
        return w.c("qqguild", "guild_feed_detail_report_switch", "1").equals("1");
    }

    public boolean j() {
        return this.f223780b;
    }

    public void m(final GuildFeedDetailInitBean guildFeedDetailInitBean, final long j3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                String type;
                GuildFeedDetailInitBean guildFeedDetailInitBean2 = guildFeedDetailInitBean;
                if (guildFeedDetailInitBean2 == null) {
                    return;
                }
                String feedId = guildFeedDetailInitBean2.getFeedId();
                String guildId = guildFeedDetailInitBean.getGuildId();
                String channelId = guildFeedDetailInitBean.getChannelId();
                String posterTinyId = guildFeedDetailInitBean.getPosterTinyId();
                int fromPage = guildFeedDetailInitBean.getFromPage();
                if (fromPage != 1 && fromPage != 2 && fromPage != 3) {
                    if (fromPage != 4) {
                        type = FromType.UNKNOWN.getType();
                    } else {
                        type = FromType.SCHEMA.getType();
                    }
                } else {
                    type = FromType.FEED.getType();
                }
                GuildFeedDetailInitData a16 = new GuildFeedDetailInitData.a().i(feedId).k(guildId).h(channelId).l(posterTinyId).j(type).m(j3).a();
                com.tencent.mobileqq.guild.feed.performance.report.f.i(a16);
                com.tencent.mobileqq.guild.feed.performance.report.e.e(a16);
                com.tencent.mobileqq.guild.feed.performance.report.c.e(a16);
                com.tencent.mobileqq.guild.feed.performance.report.l.o();
            }
        });
    }

    public void n(final boolean z16) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.8
            @Override // java.lang.Runnable
            public void run() {
                String str;
                HashMap hashMap = new HashMap();
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("is_hit_detail_cache_data", str);
                GuildFeedReportHelper.this.l("gpro_quality#time_cost#channel_topic_detail", "get_detail_json_data", hashMap, false);
            }
        });
    }

    public void o(final GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                String str;
                boolean k3 = GuildFeedReportHelper.this.k(guildFeedBaseWebViewFragment);
                GuildFeedReportHelper.this.f223779a.clear();
                long currentTimeMillis = System.currentTimeMillis();
                String urlFromIntent = guildFeedBaseWebViewFragment.getUrlFromIntent();
                String str2 = "1";
                if (urlFromIntent.contains(GuildFeedHtmlOfflineUtil.d())) {
                    obj = "1";
                } else {
                    obj = "0";
                }
                if (!GuildFeedReportHelper.this.f223780b) {
                    str2 = "0";
                }
                GuildFeedReportHelper.this.f223780b = false;
                HashMap hashMap = new HashMap();
                hashMap.put("is_first_load", str2);
                hashMap.put("is_use_offline", obj);
                long d16 = com.tencent.mobileqq.guild.util.az.d(URLUtil.getArgumentsFromURL(urlFromIntent).get("clickTime"), -1L);
                if (d16 > -1) {
                    hashMap.put("cost_time", String.valueOf(currentTimeMillis - d16));
                    GuildFeedReportHelper.this.f223779a.put("clickTime", Long.valueOf(d16));
                    GuildFeedReportHelper.this.f223779a.put("detail_fragment_on_create", Long.valueOf(currentTimeMillis));
                }
                if (k3) {
                    str = "gpro_quality#time_cost#channel_topic_detail";
                } else {
                    str = "gpro_quality#event#feed_channel_publish";
                }
                GuildFeedReportHelper.this.l(str, "detail_fragment_on_create", hashMap, false);
            }
        });
    }

    public void p(final GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.5
            @Override // java.lang.Runnable
            public void run() {
                String str;
                boolean k3 = GuildFeedReportHelper.this.k(guildFeedBaseWebViewFragment);
                HashMap hashMap = new HashMap();
                long currentTimeMillis = System.currentTimeMillis();
                hashMap.put("start_time", String.valueOf(currentTimeMillis));
                Long l3 = (Long) GuildFeedReportHelper.this.f223779a.get("webview_load_request_start");
                if (l3 != null) {
                    hashMap.put("cost_time", String.valueOf(currentTimeMillis - l3.longValue()));
                }
                if (k3) {
                    str = "gpro_quality#time_cost#channel_topic_detail";
                } else {
                    str = "gpro_quality#event#feed_channel_publish";
                }
                GuildFeedReportHelper.this.l(str, "webview_load_request_finish", hashMap, false);
            }
        });
    }

    public void q(final GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                boolean k3 = GuildFeedReportHelper.this.k(guildFeedBaseWebViewFragment);
                long currentTimeMillis = System.currentTimeMillis();
                GuildFeedReportHelper.this.f223779a.put("webview_load_request_start", Long.valueOf(currentTimeMillis));
                HashMap hashMap = new HashMap();
                hashMap.put("start_time", String.valueOf(currentTimeMillis));
                Long l3 = (Long) GuildFeedReportHelper.this.f223779a.get("webview_on_init");
                if (l3 != null) {
                    hashMap.put("cost_time", String.valueOf(currentTimeMillis - l3.longValue()));
                }
                if (k3) {
                    str = "gpro_quality#time_cost#channel_topic_detail";
                } else {
                    str = "gpro_quality#event#feed_channel_publish";
                }
                GuildFeedReportHelper.this.l(str, "webview_load_request_start", hashMap, false);
            }
        });
    }

    public void r(final GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment, final int i3, final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.6
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                boolean k3 = GuildFeedReportHelper.this.k(guildFeedBaseWebViewFragment);
                HashMap hashMap = new HashMap();
                hashMap.put("ret", String.valueOf(i3));
                hashMap.put("msg", str);
                if (k3) {
                    str2 = "gpro_quality#success#channel_topic_detail";
                } else {
                    str2 = "gpro_quality#event#feed_channel_publish";
                }
                GuildFeedReportHelper.this.l(str2, "load_failed", hashMap, true);
            }
        });
    }

    public void s(final GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.7
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedReportHelper.this.r(guildFeedBaseWebViewFragment, -5, "ssl error");
            }
        });
    }

    public void t(final GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                int i3;
                String str;
                boolean k3 = GuildFeedReportHelper.this.k(guildFeedBaseWebViewFragment);
                long currentTimeMillis = System.currentTimeMillis();
                GuildFeedReportHelper.this.f223779a.put("webview_on_init", Long.valueOf(currentTimeMillis));
                HashMap hashMap = new HashMap();
                hashMap.put("start_time", String.valueOf(currentTimeMillis));
                GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment2 = guildFeedBaseWebViewFragment;
                if (guildFeedBaseWebViewFragment2 != null && (guildFeedBaseWebViewFragment2.getWebView() instanceof com.tencent.mobileqq.guild.feed.webbundle.t)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                GuildFeedBaseWebViewFragment guildFeedBaseWebViewFragment3 = guildFeedBaseWebViewFragment;
                if (guildFeedBaseWebViewFragment3 != null && guildFeedBaseWebViewFragment3.getStatistics() != null) {
                    if (guildFeedBaseWebViewFragment.getStatistics().G0) {
                        i3 = 2;
                    } else if (SwiftBrowserStatistics.f314343h1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (z16) {
                        if (i3 == 1) {
                            i3 = 3;
                        } else {
                            i3 = 4;
                        }
                    }
                } else {
                    i3 = 0;
                }
                hashMap.put("web_process_status", String.valueOf(i3));
                hashMap.put("poster_tiny_id", GuildFeedReportHelper.this.h(guildFeedBaseWebViewFragment));
                Long l3 = (Long) GuildFeedReportHelper.this.f223779a.get("detail_fragment_on_create");
                if (l3 != null) {
                    hashMap.put("cost_time", String.valueOf(currentTimeMillis - l3.longValue()));
                }
                if (k3) {
                    str = "gpro_quality#time_cost#channel_topic_detail";
                } else {
                    str = "gpro_quality#event#feed_channel_publish";
                }
                GuildFeedReportHelper.this.l(str, "webview_on_init", hashMap, false);
            }
        });
    }

    public void u() {
        l("gpro_quality#event#feed_channel_publish", "feed_publish_exit_not_save_draft", new HashMap(), false);
    }

    public void v() {
        l("gpro_quality#event#feed_channel_publish", "feed_publish_save_draft_in_tool", new HashMap(), false);
    }

    public void w(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("feed_detail_receive_comment_time_from_tool", String.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashMap.put("feed_detail_receive_comment_content_in_tool", str);
        l("gpro_quality#event#feed_channel_business_detail", "feed_detail_receive_comment_status_from_tool", hashMap, false);
    }

    public void x(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_state", i3 + "");
        StringBuilder sb5 = new StringBuilder();
        int i16 = 1;
        if (i3 == 1) {
            i16 = 0;
        }
        sb5.append(i16);
        sb5.append("");
        hashMap.put("sgrp_action_result", sb5.toString());
        l("gpro_quality#event#feed_channel_business_detail", "click", hashMap, false);
    }
}
