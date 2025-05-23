package com.tencent.mobileqq.guild.feed.report;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedReportTable12003 {
    private static int a() {
        return 12003;
    }

    public static void b(a aVar) {
        if (aVar == null) {
            return;
        }
        c(aVar, a());
    }

    public static void c(final a aVar, final int i3) {
        GuildFeedReporter.o().n().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList(Arrays.asList(e.a(TPReportKeys.LiveExKeys.LIVE_EX_REPORT_TIME, a.this.f223235a), e.a(QZoneHelper.INTENT_EXTINFO, a.this.f223236b), e.a("action_type", a.this.f223237c), e.a("date_key", a.this.f223238d), e.a("time_stamp", a.this.f223239e), e.a("uin", a.this.f223240f), e.a("action_result", a.this.f223241g), e.a(VRReportDefine$ReportParam.FAIL_REASON, a.this.f223242h), e.a("platform", a.this.f223243i), e.a("rank_tab", a.this.f223244j), e.a("content_id", a.this.f223246l), e.a("content_type", a.this.f223247m), e.a("sgrp_channel_id", a.this.f223250p), e.a("sgrp_sub_channel_id", a.this.f223251q), e.a("sgrp_subchannel_type", a.this.f223252r), e.a("author_uin", a.this.f223253s), e.a("page_id", a.this.f223255u), e.a("sgrp_pg_forum_type", a.this.f223257w), e.a("re_page_id", a.this.f223256v), e.a("re_sgrp_pg_forum_type", a.this.f223258x), e.a("page_stay_time", a.this.f223259y), e.a("feed_id", a.this.f223245k), e.a("seal_transfer_new", a.this.C), e.a("to_tinyid", a.this.D), e.a("sgrp_forum_viewer_enter_source", a.this.E), e.a("sgrp_stream_pgin_source_name", a.this.F), e.a("sgrp_visit_from", a.this.G), e.a(ServiceConst.PARA_SESSION_ID, a.this.H)));
                if (a.this.f223247m.contains("video")) {
                    arrayList.add(e.a("vedio_length", a.this.f223260z));
                    arrayList.add(e.a("play_duration", a.this.A));
                    arrayList.add(e.a("play_start_type", a.this.B));
                }
                if (a.this.f223237c.contains("comment")) {
                    arrayList.add(e.a("comment_id", a.this.f223248n));
                    arrayList.add(e.a("comment_type", a.this.f223249o));
                }
                if (a.this.f223237c.equals("emotion")) {
                    arrayList.add(e.a("emoji_id", a.this.f223254t));
                }
                GuildFeedReporter.o().j(e.b(i3, arrayList, null, null), true);
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f223235a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f223236b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f223237c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f223238d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f223239e = "";

        /* renamed from: f, reason: collision with root package name */
        private String f223240f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f223241g = "";

        /* renamed from: h, reason: collision with root package name */
        private String f223242h = "";

        /* renamed from: i, reason: collision with root package name */
        private String f223243i = "";

        /* renamed from: j, reason: collision with root package name */
        private String f223244j = "";

        /* renamed from: k, reason: collision with root package name */
        private String f223245k = "";

        /* renamed from: l, reason: collision with root package name */
        private String f223246l = "";

        /* renamed from: m, reason: collision with root package name */
        private String f223247m = "";

        /* renamed from: n, reason: collision with root package name */
        private String f223248n = "";

        /* renamed from: o, reason: collision with root package name */
        private String f223249o = "";

        /* renamed from: p, reason: collision with root package name */
        private String f223250p = "";

        /* renamed from: q, reason: collision with root package name */
        private String f223251q = "";

        /* renamed from: r, reason: collision with root package name */
        private String f223252r = "";

        /* renamed from: s, reason: collision with root package name */
        private String f223253s = "";

        /* renamed from: t, reason: collision with root package name */
        private String f223254t = "";

        /* renamed from: u, reason: collision with root package name */
        private String f223255u = "";

        /* renamed from: v, reason: collision with root package name */
        private String f223256v = "";

        /* renamed from: w, reason: collision with root package name */
        private String f223257w = "";

        /* renamed from: x, reason: collision with root package name */
        private String f223258x = "";

        /* renamed from: y, reason: collision with root package name */
        private String f223259y = "";

        /* renamed from: z, reason: collision with root package name */
        private String f223260z = "";
        private String A = "";
        private String B = "";
        private String C = "";
        private String D = "";
        private String E = "";
        private String F = "";
        private String G = "";
        private String H = "";

        public a() {
        }

        public String I() {
            return this.f223245k;
        }

        public a J(String str) {
            this.f223241g = str;
            return this;
        }

        public a K(String str) {
            this.f223237c = str;
            return this;
        }

        public a L(String str) {
            this.f223253s = str;
            return this;
        }

        public a M(String str) {
            this.f223248n = str;
            return this;
        }

        public a N(String str) {
            this.f223249o = str;
            return this;
        }

        public a O(String str) {
            this.f223246l = str;
            return this;
        }

        public a P(String str) {
            this.f223247m = str;
            return this;
        }

        public a Q(String str) {
            this.f223238d = str;
            return this;
        }

        public a R(String str) {
            this.f223254t = str;
            return this;
        }

        public a S(String str) {
            this.f223236b = str;
            return this;
        }

        public a T(String str) {
            this.f223242h = str;
            return this;
        }

        public a U(String str) {
            this.f223245k = str;
            return this;
        }

        public a V(String str) {
            this.f223257w = str;
            return this;
        }

        public a W(String str) {
            this.f223235a = str;
            return this;
        }

        public a X(String str) {
            this.E = str;
            return this;
        }

        public a Y(String str) {
            this.f223255u = str;
            return this;
        }

        public a Z(String str) {
            this.f223259y = str;
            return this;
        }

        public a a0(String str) {
            this.F = str;
            return this;
        }

        public a b0(String str) {
            this.f223243i = str;
            return this;
        }

        public a c0(String str) {
            this.A = str;
            return this;
        }

        public a d0(String str) {
            this.B = str;
            return this;
        }

        public a e0(String str) {
            this.f223244j = str;
            return this;
        }

        public a f0(String str) {
            this.f223258x = str;
            return this;
        }

        public a g0(String str) {
            this.f223256v = str;
            return this;
        }

        public a h0(String str) {
            this.C = str;
            return this;
        }

        public a i0(String str) {
            this.H = str;
            return this;
        }

        public a j0(String str) {
            this.f223250p = str;
            return this;
        }

        public a k0(String str) {
            this.f223251q = str;
            return this;
        }

        public a l0(String str) {
            this.f223252r = str;
            return this;
        }

        public a m0(String str) {
            this.f223239e = str;
            return this;
        }

        public a n0(String str) {
            this.D = str;
            return this;
        }

        public a o0(String str) {
            this.f223240f = str;
            return this;
        }

        public a p0(String str) {
            this.f223260z = str;
            return this;
        }

        public a q0(String str) {
            this.G = str;
            return this;
        }

        public a(a aVar) {
            if (aVar == null) {
                return;
            }
            W(aVar.f223235a);
            S(aVar.f223236b);
            K(aVar.f223237c);
            Q(aVar.f223238d);
            m0(aVar.f223239e);
            o0(aVar.f223240f);
            J(aVar.f223241g);
            T(aVar.f223242h);
            b0(aVar.f223243i);
            e0(aVar.f223244j);
            U(aVar.f223245k);
            O(aVar.f223246l);
            P(aVar.f223247m);
            M(aVar.f223248n);
            N(aVar.f223249o);
            j0(aVar.f223250p);
            k0(aVar.f223251q);
            l0(aVar.f223252r);
            L(aVar.f223253s);
            R(aVar.f223254t);
            Y(aVar.f223255u);
            V(aVar.f223257w);
            g0(aVar.f223256v);
            f0(aVar.f223258x);
            Z(aVar.f223259y);
            p0(aVar.f223260z);
            c0(aVar.A);
            d0(aVar.B);
            h0(aVar.C);
            n0(aVar.D);
            X(aVar.E);
        }
    }
}
