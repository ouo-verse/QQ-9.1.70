package com.tencent.qqlive.superplayer.vinfo.vod;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKCGIVideoInfoBuilder {

    /* renamed from: a, reason: collision with root package name */
    private int f345721a;

    /* renamed from: c, reason: collision with root package name */
    private int f345723c;

    /* renamed from: d, reason: collision with root package name */
    private int f345724d;

    /* renamed from: g, reason: collision with root package name */
    private int f345727g;

    /* renamed from: h, reason: collision with root package name */
    private String f345728h;

    /* renamed from: i, reason: collision with root package name */
    private String f345729i;

    /* renamed from: j, reason: collision with root package name */
    private String f345730j;

    /* renamed from: k, reason: collision with root package name */
    private String f345731k;

    /* renamed from: l, reason: collision with root package name */
    private String f345732l;

    /* renamed from: m, reason: collision with root package name */
    private String f345733m;

    /* renamed from: n, reason: collision with root package name */
    private String f345734n;

    /* renamed from: r, reason: collision with root package name */
    private zt3.h f345738r;

    /* renamed from: b, reason: collision with root package name */
    private int f345722b = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f345725e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f345726f = -1;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList<String> f345735o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    private TVKCGIVideoInfo f345736p = new TVKCGIVideoInfo();

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<TVKCGIVideoInfoVkeyInfo> f345737q = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    private Map<String, y> f345739s = new HashMap();

    /* renamed from: t, reason: collision with root package name */
    private Map<String, Class> f345740t = new HashMap();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoInfoVkeyInfo implements Serializable {
        private static final long serialVersionUID = -1;
        private int idx;
        private String url;
        private String vkey;

        public int getIdx() {
            return this.idx;
        }

        public String getUrl() {
            return this.url;
        }

        public String getVkey() {
            return this.vkey;
        }

        public void setIdx(int i3) {
            this.idx = i3;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVkey(String str) {
            this.vkey = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements y {
        a() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.X(node.getChildNodes());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class aa implements y {
        aa() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder tVKCGIVideoInfoBuilder = TVKCGIVideoInfoBuilder.this;
            tVKCGIVideoInfoBuilder.f345727g = com.tencent.qqlive.superplayer.tools.utils.g.i(tVKCGIVideoInfoBuilder.F(node), 0);
            TVKCGIVideoInfoBuilder.this.f345736p.i1(TVKCGIVideoInfoBuilder.this.f345727g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ab implements y {
        ab() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.j1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ac implements y {
        ac() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.k1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ad implements y {
        ad() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.l1(com.tencent.qqlive.superplayer.tools.utils.g.j(TVKCGIVideoInfoBuilder.this.F(node), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ae implements y {
        ae() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.m1(com.tencent.qqlive.superplayer.tools.utils.g.h(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class af implements y {
        af() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.n1(TVKCGIVideoInfoBuilder.this.F(node));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ag implements y {
        ag() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.o1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ah implements y {
        ah() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.r1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ai implements y {
        ai() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.e0(node.getChildNodes());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class aj implements y {
        aj() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.u1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ak implements y {
        ak() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f0(node.getChildNodes());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class al implements y {
        al() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder tVKCGIVideoInfoBuilder = TVKCGIVideoInfoBuilder.this;
            tVKCGIVideoInfoBuilder.f345728h = tVKCGIVideoInfoBuilder.F(node);
            TVKCGIVideoInfoBuilder.this.f345736p.v1(TVKCGIVideoInfoBuilder.this.f345728h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class am implements y {
        am() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.w1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class an implements y {
        an() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.y1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ao implements y {
        ao() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.z1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ap implements y {
        ap() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.A1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class aq implements y {
        aq() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.B1(com.tencent.qqlive.superplayer.tools.utils.g.h(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ar implements y {
        ar() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.g0(node.getChildNodes());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements y {
        b() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.A0(TVKCGIVideoInfoBuilder.this.F(node));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements y {
        c() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.B0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements y {
        d() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.C0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements y {
        e() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.D0(TVKCGIVideoInfoBuilder.this.F(node));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements y {
        f() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.Z(node.getChildNodes());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class g implements y {
        g() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.E0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class h implements y {
        h() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.G0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class i implements y {
        i() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.H0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class j implements y {
        j() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.I0(com.tencent.qqlive.superplayer.tools.utils.g.g(TVKCGIVideoInfoBuilder.this.F(node), 0.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class k implements y {
        k() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.K0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class l implements y {
        l() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.N0(TVKCGIVideoInfoBuilder.this.F(node));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class m implements y {
        m() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder tVKCGIVideoInfoBuilder = TVKCGIVideoInfoBuilder.this;
            tVKCGIVideoInfoBuilder.f345732l = tVKCGIVideoInfoBuilder.F(node);
            TVKCGIVideoInfoBuilder.this.f345736p.O0(TVKCGIVideoInfoBuilder.this.f345732l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class n implements y {
        n() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.Q0(TVKCGIVideoInfoBuilder.this.F(node));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class o implements y {
        o() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.R0(com.tencent.qqlive.superplayer.tools.utils.g.j(TVKCGIVideoInfoBuilder.this.F(node), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class p implements y {
        p() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.S0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class q implements y {
        q() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder tVKCGIVideoInfoBuilder = TVKCGIVideoInfoBuilder.this;
            tVKCGIVideoInfoBuilder.f345731k = tVKCGIVideoInfoBuilder.F(node);
            TVKCGIVideoInfoBuilder.this.f345736p.T0(TVKCGIVideoInfoBuilder.this.f345731k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class r implements y {
        r() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.U0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class s implements y {
        s() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.V0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class t implements y {
        t() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.W0(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class u implements y {
        u() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.Y0(TVKCGIVideoInfoBuilder.this.F(node));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class v implements y {
        v() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.V(node.getChildNodes());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class w implements y {
        w() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder tVKCGIVideoInfoBuilder = TVKCGIVideoInfoBuilder.this;
            tVKCGIVideoInfoBuilder.f345730j = tVKCGIVideoInfoBuilder.F(node);
            TVKCGIVideoInfoBuilder.this.f345736p.Z0(TVKCGIVideoInfoBuilder.this.f345730j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class x implements y {
        x() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.b1(com.tencent.qqlive.superplayer.tools.utils.g.i(TVKCGIVideoInfoBuilder.this.F(node), 0));
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface y {
        void a(Node node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class z implements y {
        z() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder.y
        public void a(Node node) {
            TVKCGIVideoInfoBuilder.this.f345736p.c1(TVKCGIVideoInfoBuilder.this.y(node));
            TVKCGIVideoInfoBuilder.this.b0(node.getChildNodes());
        }
    }

    public TVKCGIVideoInfoBuilder() {
        T();
        S();
    }

    private String A(String str, String str2, String str3) {
        String format = String.format("%s?vkey=%s&platform=%d&br=%d&fmt=%s&sdtfrom=%s&guid=%s", str, str2, Integer.valueOf(J()), Integer.valueOf(this.f345723c), this.f345729i, K(), tt3.a.e());
        if (!TextUtils.isEmpty(str3)) {
            return (format + "&keyid=") + str3;
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F(Node node) {
        if (node != null && node.getFirstChild() != null) {
            return node.getFirstChild().getNodeValue();
        }
        return "";
    }

    private int J() {
        zt3.h hVar = this.f345738r;
        if (hVar != null) {
            return hVar.l();
        }
        return tt3.a.f();
    }

    private String K() {
        zt3.h hVar = this.f345738r;
        if (hVar != null) {
            return tt3.a.h(hVar.l());
        }
        return tt3.a.g();
    }

    private void S() {
        Map<String, Class> map = this.f345740t;
        Class cls = Integer.TYPE;
        map.put("id", cls);
        this.f345740t.put("name", String.class);
        this.f345740t.put(TtmlNode.TAG_BR, cls);
        this.f345740t.put("fs", Long.TYPE);
        this.f345740t.put("sl", cls);
        this.f345740t.put("cname", String.class);
        this.f345740t.put("lmt", cls);
        this.f345740t.put("profile", cls);
        this.f345740t.put(TVKCommonParamEnum.REQ_PARAM_KEY_DRM, cls);
        this.f345740t.put("super", cls);
        this.f345740t.put("video", cls);
        this.f345740t.put("audio", cls);
        this.f345740t.put("sb", cls);
        this.f345740t.put("hdr10enh", cls);
        this.f345740t.put("sname", String.class);
        this.f345740t.put("resolution", String.class);
    }

    private void T() {
        this.f345739s.put("vi", new ak());
        this.f345739s.put("vid", new al());
        this.f345739s.put("fn", new m());
        this.f345739s.put("st", new aa());
        this.f345739s.put("lnk", new w());
        this.f345739s.put("fvkey", new q());
        this.f345739s.put(PM.BASE, new b());
        this.f345739s.put("duration", new j());
        this.f345739s.put("ch", new d());
        this.f345739s.put("ckc", new e());
        this.f345739s.put(LinkReportConstant$GlobalKey.CONNECT_TYPE, new g());
        this.f345739s.put("dm", new h());
        this.f345739s.put(TVKCommonParamEnum.REQ_PARAM_KEY_DRM, new i());
        this.f345739s.put(JsonWebSignature.ENCRYPTION_METHOD, new k());
        this.f345739s.put("fmd5", new l());
        this.f345739s.put("fps", new n());
        this.f345739s.put(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID, new u());
        this.f345739s.put("fs", new o());
        this.f345739s.put("fst", new p());
        this.f345739s.put("head", new r());
        this.f345739s.put("hevc", new s());
        this.f345739s.put("iflag", new t());
        this.f345739s.put("mst", new x());
        this.f345739s.put(TextNode.MODE_TAIL, new ac());
        this.f345739s.put("targetid", new ad());
        this.f345739s.put("td", new ae());
        this.f345739s.put("ti", new af());
        this.f345739s.put("tie", new ag());
        this.f345739s.put("type", new ah());
        this.f345739s.put("vh", new aj());
        this.f345739s.put("vw", new ap());
        this.f345739s.put("wh", new aq());
        this.f345739s.put("videotype", new am());
        this.f345739s.put("vr", new an());
        this.f345739s.put(EventKey.VST, new ao());
        this.f345739s.put("swhdcp", new ab());
        this.f345739s.put(TtmlNode.TAG_BR, new c());
        this.f345739s.put("cl", new f());
        this.f345739s.put("ul", new ai());
        this.f345739s.put("pl", new z());
        this.f345739s.put("wl", new ar());
        this.f345739s.put("ad", new a());
        this.f345739s.put("ll", new v());
    }

    private void U(Node node, TVKCGIVideoInfo.TVKCGIVideoFormatInfo tVKCGIVideoFormatInfo) {
        if (node.getNodeType() == 1) {
            String lowerCase = node.getNodeName().toLowerCase();
            if (lowerCase.equals("fi")) {
                a0(node.getChildNodes());
                return;
            }
            if (this.f345740t.containsKey(lowerCase)) {
                Class cls = this.f345740t.get(lowerCase);
                Class cls2 = Integer.TYPE;
                if (cls == cls2) {
                    com.tencent.qqlive.superplayer.tools.utils.g.f(tVKCGIVideoFormatInfo, lowerCase, cls2, Integer.valueOf(com.tencent.qqlive.superplayer.tools.utils.g.i(F(node), 0)));
                    return;
                }
                Class cls3 = this.f345740t.get(lowerCase);
                Class cls4 = Long.TYPE;
                if (cls3 == cls4) {
                    com.tencent.qqlive.superplayer.tools.utils.g.f(tVKCGIVideoFormatInfo, lowerCase, cls4, Long.valueOf(com.tencent.qqlive.superplayer.tools.utils.g.j(F(node), 0L)));
                } else if (this.f345740t.get(lowerCase) == String.class) {
                    com.tencent.qqlive.superplayer.tools.utils.g.f(tVKCGIVideoFormatInfo, lowerCase, String.class, F(node));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo tVKCGIVideoTVLogoInfo = new TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase("li")) {
                        V(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase(tl.h.F)) {
                        tVKCGIVideoTVLogoInfo.g(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("w")) {
                        tVKCGIVideoTVLogoInfo.k(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase(HippyTKDListViewAdapter.X)) {
                        tVKCGIVideoTVLogoInfo.l(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("y")) {
                        tVKCGIVideoTVLogoInfo.m(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("show")) {
                        tVKCGIVideoTVLogoInfo.j(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    }
                }
            }
            if (tVKCGIVideoTVLogoInfo.a() != 0 || ((tVKCGIVideoTVLogoInfo.b() != 0 && tVKCGIVideoTVLogoInfo.c() != 0) || tVKCGIVideoTVLogoInfo.e() != 0)) {
                this.f345736p.g(tVKCGIVideoTVLogoInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(NodeList nodeList) {
        if (nodeList != null) {
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1 && item.getNodeName().equalsIgnoreCase(TVKCommonParamEnum.REQ_PARAM_KEY_AD_SESSION_ID)) {
                    this.f345736p.z0(F(item));
                }
            }
        }
    }

    private void Y(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo tVKCGIVideoAudioTrackInfo = new TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase("ai")) {
                        Y(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase("sl")) {
                        tVKCGIVideoAudioTrackInfo.u(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("action")) {
                        tVKCGIVideoAudioTrackInfo.o(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("audio")) {
                        tVKCGIVideoAudioTrackInfo.p(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("lmt")) {
                        tVKCGIVideoAudioTrackInfo.r(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID)) {
                        tVKCGIVideoAudioTrackInfo.q(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("name")) {
                        tVKCGIVideoAudioTrackInfo.s(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("preview")) {
                        tVKCGIVideoAudioTrackInfo.t(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("track")) {
                        tVKCGIVideoAudioTrackInfo.v(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("ul")) {
                        for (int i16 = 0; i16 < item.getChildNodes().getLength(); i16++) {
                            tVKCGIVideoAudioTrackInfo.a(item.getChildNodes().item(i16).getFirstChild().getFirstChild().getNodeValue());
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(tVKCGIVideoAudioTrackInfo.g())) {
                this.f345736p.a(tVKCGIVideoAudioTrackInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo tVKCGIVideoMp4ClipInfo = new TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase("fc")) {
                        int i16 = com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0);
                        this.f345722b = i16;
                        this.f345736p.M0(i16);
                    } else if (item.getNodeName().equalsIgnoreCase("ci")) {
                        Z(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase("idx")) {
                        tVKCGIVideoMp4ClipInfo.n(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("cs")) {
                        tVKCGIVideoMp4ClipInfo.p(com.tencent.qqlive.superplayer.tools.utils.g.j(F(item), 0L));
                    } else if (item.getNodeName().equalsIgnoreCase("cd")) {
                        tVKCGIVideoMp4ClipInfo.m(com.tencent.qqlive.superplayer.tools.utils.g.h(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("cmd5")) {
                        tVKCGIVideoMp4ClipInfo.l(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID)) {
                        tVKCGIVideoMp4ClipInfo.o(F(item));
                    }
                }
            }
            if (tVKCGIVideoMp4ClipInfo.c() > 0) {
                this.f345736p.c(tVKCGIVideoMp4ClipInfo);
            }
        }
    }

    private void a0(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoFormatInfo tVKCGIVideoFormatInfo = new TVKCGIVideoInfo.TVKCGIVideoFormatInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                U(nodeList.item(i3), tVKCGIVideoFormatInfo);
            }
            if (!TextUtils.isEmpty(tVKCGIVideoFormatInfo.l())) {
                this.f345736p.b(tVKCGIVideoFormatInfo);
            }
            if (tVKCGIVideoFormatInfo.n() == 1) {
                this.f345736p.g1(tVKCGIVideoFormatInfo.l());
                this.f345736p.h1(tVKCGIVideoFormatInfo.j());
                this.f345736p.f1(tVKCGIVideoFormatInfo.f());
                this.f345724d = tVKCGIVideoFormatInfo.j();
                this.f345729i = tVKCGIVideoFormatInfo.l();
                this.f345723c = tVKCGIVideoFormatInfo.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoPictureInfo tVKCGIVideoPictureInfo = new TVKCGIVideoInfo.TVKCGIVideoPictureInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase("pd")) {
                        b0(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase("cd")) {
                        tVKCGIVideoPictureInfo.e(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase(tl.h.F)) {
                        tVKCGIVideoPictureInfo.j(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("w")) {
                        tVKCGIVideoPictureInfo.l(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("r")) {
                        tVKCGIVideoPictureInfo.k(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("c")) {
                        tVKCGIVideoPictureInfo.c(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase(TPReportKeys.Common.COMMON_MEDIA_FORMAT)) {
                        tVKCGIVideoPictureInfo.f(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("fn")) {
                        tVKCGIVideoPictureInfo.g(F(item));
                    }
                }
            }
            if (!TextUtils.isEmpty(tVKCGIVideoPictureInfo.a())) {
                this.f345736p.e(tVKCGIVideoPictureInfo);
            }
        }
    }

    private void c0(Document document) {
        if (document != null) {
            NodeList childNodes = document.getFirstChild().getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item = childNodes.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase("em")) {
                        int i16 = com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0);
                        this.f345725e = i16;
                        this.f345736p.J0(i16);
                    } else if (item.getNodeName().equalsIgnoreCase("exem")) {
                        int i17 = com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0);
                        this.f345726f = i17;
                        this.f345736p.L0(i17);
                    } else if (item.getNodeName().equalsIgnoreCase(TPReportKeys.Common.COMMON_DL_TYPE)) {
                        int i18 = com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0);
                        this.f345721a = i18;
                        this.f345736p.F0(i18);
                    } else if (item.getNodeName().equalsIgnoreCase("preview")) {
                        this.f345736p.d1(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase(ReportConstant.COSTREPORT_PREFIX)) {
                        this.f345736p.e1(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase(TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP)) {
                        this.f345736p.p1(com.tencent.qqlive.superplayer.tools.utils.g.j(F(item), 0L));
                    } else if (item.getNodeName().equalsIgnoreCase("fp2p")) {
                        this.f345736p.P0(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("tstid")) {
                        this.f345736p.q1(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("ip")) {
                        this.f345736p.X0(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("fl")) {
                        a0(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase("al")) {
                        Y(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase(LinkReportConstant$EventKey.VALUE)) {
                        f0(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase("sfl")) {
                        d0(item.getChildNodes());
                    }
                }
            }
        }
    }

    private void d0(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo tVKCGIVideoSubtitleInfo = new TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase("fi")) {
                        d0(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID)) {
                        tVKCGIVideoSubtitleInfo.f(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("name")) {
                        tVKCGIVideoSubtitleInfo.g(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("url")) {
                        tVKCGIVideoSubtitleInfo.j(F(item));
                    }
                }
            }
            if (!TextUtils.isEmpty(tVKCGIVideoSubtitleInfo.a())) {
                this.f345736p.f(tVKCGIVideoSubtitleInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoUrlInfo tVKCGIVideoUrlInfo = new TVKCGIVideoInfo.TVKCGIVideoUrlInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase(SensorJsPlugin.SENSOR_INTERVAL_UI)) {
                        e0(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase("url")) {
                        tVKCGIVideoUrlInfo.q(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase(TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8)) {
                        String F = F(item);
                        if (!TextUtils.isEmpty(F)) {
                            this.f345736p.a1(F);
                        }
                    } else if (item.getNodeName().equalsIgnoreCase(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE)) {
                        tVKCGIVideoUrlInfo.r(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("spip")) {
                        tVKCGIVideoUrlInfo.o(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("spport")) {
                        tVKCGIVideoUrlInfo.p(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("path")) {
                        tVKCGIVideoUrlInfo.m(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase(TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS)) {
                        NodeList childNodes = item.getChildNodes();
                        for (int i16 = 0; i16 < childNodes.getLength(); i16++) {
                            Node item2 = childNodes.item(i16);
                            if (item2.getNodeType() == 1) {
                                if (item2.getNodeName().equalsIgnoreCase("hk")) {
                                    tVKCGIVideoUrlInfo.l(F(item2));
                                } else if (item2.getNodeName().equalsIgnoreCase("pt")) {
                                    tVKCGIVideoUrlInfo.n(F(item2));
                                }
                            }
                        }
                    }
                }
            }
            if (!tVKCGIVideoUrlInfo.g().isEmpty()) {
                this.f345736p.j(tVKCGIVideoUrlInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(NodeList nodeList) {
        String str;
        if (nodeList != null) {
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName() != null) {
                        str = item.getNodeName().toLowerCase();
                    } else {
                        str = "";
                    }
                    y yVar = this.f345739s.get(str);
                    if (yVar != null) {
                        yVar.a(item);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(NodeList nodeList) {
        if (nodeList != null) {
            TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo tVKCGIVideoWatermarkInfo = new TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                Node item = nodeList.item(i3);
                if (item.getNodeType() == 1) {
                    if (item.getNodeName().equalsIgnoreCase("wi")) {
                        g0(item.getChildNodes());
                    } else if (item.getNodeName().equalsIgnoreCase("id")) {
                        tVKCGIVideoWatermarkInfo.f(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase(HippyTKDListViewAdapter.X)) {
                        tVKCGIVideoWatermarkInfo.m(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("y")) {
                        tVKCGIVideoWatermarkInfo.n(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase(tl.h.F)) {
                        tVKCGIVideoWatermarkInfo.e(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("w")) {
                        tVKCGIVideoWatermarkInfo.l(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("a")) {
                        tVKCGIVideoWatermarkInfo.c(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item), 0));
                    } else if (item.getNodeName().equalsIgnoreCase("md5")) {
                        tVKCGIVideoWatermarkInfo.g(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("url")) {
                        tVKCGIVideoWatermarkInfo.k(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("surl")) {
                        tVKCGIVideoWatermarkInfo.j(F(item));
                    } else if (item.getNodeName().equalsIgnoreCase("action")) {
                        this.f345736p.y0(F(item));
                    }
                }
            }
            if (!TextUtils.isEmpty(tVKCGIVideoWatermarkInfo.a())) {
                this.f345736p.k(tVKCGIVideoWatermarkInfo);
            }
        }
    }

    private void v(String str) {
        String g16;
        String g17;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuffer.append("<CLIPMP4><VERSION>2</VERSION><CLIPSINFO>");
        String g18 = this.f345736p.m0().get(0).g();
        Iterator<TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo> it = this.f345736p.Z().iterator();
        while (it.hasNext()) {
            TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo next = it.next();
            if (TextUtils.isEmpty(str)) {
                g17 = A(g18 + z(this.f345732l, next.c()), next.j(), next.e());
            } else {
                g17 = next.g();
            }
            stringBuffer.append("<CLIPINFO>");
            stringBuffer.append("<DURATION>");
            stringBuffer.append(next.b() * 1000.0d * 1000.0d);
            stringBuffer.append("</DURATION>");
            stringBuffer.append("<CLIPSIZE>");
            stringBuffer.append(next.f());
            stringBuffer.append("</CLIPSIZE>");
            stringBuffer.append("<URL>");
            stringBuffer.append(g17.replaceAll(ContainerUtils.FIELD_DELIMITER, "&amp;"));
            stringBuffer.append("</URL>");
            stringBuffer.append("<URLPARAM>");
            stringBuffer.append("clipid=" + next.c());
            stringBuffer.append("</URLPARAM>");
            stringBuffer.append("</CLIPINFO>");
        }
        stringBuffer.append("</CLIPSINFO></CLIPMP4>");
        this.f345733m = stringBuffer.toString();
        Iterator<TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo> it5 = this.f345736p.Z().iterator();
        while (it5.hasNext()) {
            TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo next2 = it5.next();
            for (int i3 = 0; i3 < this.f345736p.m0().size(); i3++) {
                String g19 = this.f345736p.m0().get(i3).g();
                if (TextUtils.isEmpty(str)) {
                    g16 = A(g19 + z(this.f345732l, next2.c()), next2.j(), next2.e());
                } else {
                    g16 = next2.g();
                }
                if (i3 == 0) {
                    next2.q(g16);
                }
                next2.a(g16);
            }
        }
    }

    private void w(String str) {
        TVKCGIVideoInfo.TVKCGIVideoUrlInfo tVKCGIVideoUrlInfo;
        String K = K();
        if (this.f345736p.m0().size() > 0 && (tVKCGIVideoUrlInfo = this.f345736p.m0().get(0)) != null) {
            if (TextUtils.isEmpty(str)) {
                int i3 = this.f345721a;
                if (i3 == 3) {
                    this.f345733m = tVKCGIVideoUrlInfo.g() + String.format("%s&hlskey=%s&sdtfrom=%s", tVKCGIVideoUrlInfo.c(), tVKCGIVideoUrlInfo.a(), K);
                } else if (i3 == 8) {
                    this.f345733m = tVKCGIVideoUrlInfo.g() + "&sdtfrom=" + K;
                }
            } else {
                this.f345733m = tVKCGIVideoUrlInfo.g();
            }
        }
        Iterator<TVKCGIVideoInfo.TVKCGIVideoUrlInfo> it = this.f345736p.m0().iterator();
        while (it.hasNext()) {
            TVKCGIVideoInfo.TVKCGIVideoUrlInfo next = it.next();
            if (next != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(next.g());
                if (TextUtils.isEmpty(str)) {
                    if (this.f345721a == 3) {
                        stringBuffer.append(next.c());
                        stringBuffer.append("&hlskey=");
                        stringBuffer.append(next.a());
                    }
                    stringBuffer.append("&sdtfrom=");
                    stringBuffer.append(K);
                }
                this.f345735o.add(stringBuffer.toString());
            }
        }
        this.f345736p.t1(this.f345735o);
    }

    private void x(String str) {
        TVKCGIVideoInfo.TVKCGIVideoUrlInfo tVKCGIVideoUrlInfo = this.f345736p.m0().get(0);
        if (tVKCGIVideoUrlInfo != null) {
            this.f345733m = tVKCGIVideoUrlInfo.g();
            if (TextUtils.isEmpty(str)) {
                this.f345733m = A(tVKCGIVideoUrlInfo.g() + this.f345732l, this.f345731k, "");
            }
        }
        Iterator<TVKCGIVideoInfo.TVKCGIVideoUrlInfo> it = this.f345736p.m0().iterator();
        while (it.hasNext()) {
            TVKCGIVideoInfo.TVKCGIVideoUrlInfo next = it.next();
            String g16 = next.g();
            if (TextUtils.isEmpty(str)) {
                g16 = A(next.g() + this.f345732l, this.f345731k, "");
            }
            this.f345735o.add(g16);
        }
        this.f345736p.t1(this.f345735o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y(Node node) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        try {
            if (node.hasChildNodes() && node.getFirstChild().hasChildNodes()) {
                sb5.append("<");
                sb5.append(node.getNodeName());
                sb5.append(">");
                z16 = true;
            } else {
                z16 = false;
            }
            while (node.hasChildNodes()) {
                Node firstChild = node.getFirstChild();
                if (firstChild.hasChildNodes()) {
                    sb5.append(y(firstChild));
                } else {
                    sb5.append("<");
                    sb5.append(firstChild.getParentNode().getNodeName());
                    sb5.append(">");
                    sb5.append(firstChild.getNodeValue());
                    sb5.append("</");
                    sb5.append(firstChild.getParentNode().getNodeName());
                    sb5.append(">");
                }
                node.removeChild(node.getFirstChild());
            }
            if (z16) {
                sb5.append("</");
                sb5.append(node.getNodeName());
                sb5.append(">");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }

    private String z(String str, int i3) {
        int lastIndexOf = str.lastIndexOf(".");
        return String.format("%s%d%s", str.substring(0, lastIndexOf + 1), Integer.valueOf(i3), str.substring(lastIndexOf));
    }

    public int B() {
        return this.f345722b;
    }

    public int C() {
        return this.f345721a;
    }

    public int D() {
        return this.f345725e;
    }

    public int E() {
        return this.f345726f;
    }

    public int G() {
        return this.f345724d;
    }

    public String H() {
        return this.f345730j;
    }

    public String I() {
        if (this.f345736p.m0().size() > 0) {
            return this.f345736p.m0().get(0).b();
        }
        return "";
    }

    public String L() {
        if (this.f345736p.m0().size() > 0) {
            return this.f345736p.m0().get(0).e();
        }
        return "";
    }

    public String M() {
        if (this.f345736p.m0().size() > 0) {
            return this.f345736p.m0().get(0).f();
        }
        return "";
    }

    public int N() {
        return this.f345727g;
    }

    public String O() {
        return this.f345733m;
    }

    public String P() {
        return this.f345734n;
    }

    public int Q() {
        return this.f345737q.size();
    }

    public int R() {
        return this.f345736p.m0().get(0).j();
    }

    public TVKCGIVideoInfo W(Document document) {
        try {
            c0(document);
            if (this.f345736p.Z().size() > 0) {
                this.f345736p.Z().get(0).q(this.f345736p.m0().get(0).g());
                this.f345736p.Z().get(0).r(this.f345731k);
                TVKCGIVideoInfoVkeyInfo tVKCGIVideoInfoVkeyInfo = new TVKCGIVideoInfoVkeyInfo();
                tVKCGIVideoInfoVkeyInfo.setIdx(1);
                tVKCGIVideoInfoVkeyInfo.setVkey(this.f345731k);
                this.f345737q.add(tVKCGIVideoInfoVkeyInfo);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this.f345736p;
    }

    public void h0(Document document) {
        Node firstChild;
        if (document != null) {
            NodeList elementsByTagName = document.getElementsByTagName("em");
            NodeList elementsByTagName2 = document.getElementsByTagName("exem");
            if (elementsByTagName.getLength() > 0) {
                this.f345725e = com.tencent.qqlive.superplayer.tools.utils.g.i(F(elementsByTagName.item(0)), 0);
                this.f345726f = com.tencent.qqlive.superplayer.tools.utils.g.i(F(elementsByTagName2.item(0)), 0);
                if (this.f345725e > 0) {
                    return;
                }
            }
            NodeList childNodes = document.getElementsByTagName("cl").item(0).getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item = childNodes.item(i3);
                if (item.getNodeType() == 1 && item.getNodeName().equalsIgnoreCase("ci")) {
                    NodeList childNodes2 = item.getChildNodes();
                    TVKCGIVideoInfoVkeyInfo tVKCGIVideoInfoVkeyInfo = new TVKCGIVideoInfoVkeyInfo();
                    for (int i16 = 0; i16 < childNodes2.getLength(); i16++) {
                        Node item2 = childNodes2.item(i16);
                        if (item2.getNodeType() == 1) {
                            if (item2.getNodeName().equalsIgnoreCase("idx")) {
                                tVKCGIVideoInfoVkeyInfo.setIdx(com.tencent.qqlive.superplayer.tools.utils.g.i(F(item2), 0));
                            } else if (item2.getNodeName().equalsIgnoreCase("key")) {
                                tVKCGIVideoInfoVkeyInfo.setVkey(F(item2));
                            } else if (item2.getNodeName().equalsIgnoreCase("ul") && item2.getFirstChild() != null && (firstChild = item2.getFirstChild().getFirstChild()) != null && firstChild.getNodeName().equalsIgnoreCase("url")) {
                                tVKCGIVideoInfoVkeyInfo.setUrl(F(firstChild));
                            }
                        }
                    }
                    this.f345737q.add(tVKCGIVideoInfoVkeyInfo);
                    int idx = tVKCGIVideoInfoVkeyInfo.getIdx() - 1;
                    if (idx > 0 && this.f345736p.Z().get(idx) != null && this.f345736p.Z().get(idx).c() == tVKCGIVideoInfoVkeyInfo.getIdx()) {
                        this.f345736p.Z().get(idx).q(tVKCGIVideoInfoVkeyInfo.getUrl());
                        this.f345736p.Z().get(idx).r(tVKCGIVideoInfoVkeyInfo.getVkey());
                    }
                }
            }
        }
    }

    public void i0(zt3.h hVar) {
        this.f345738r = hVar;
    }

    public void j0(String str) {
        this.f345734n = str;
    }

    public void u(String str) {
        if (str == null) {
            str = "";
        }
        if (this.f345721a == 1) {
            if (this.f345722b > 0) {
                v(str);
                return;
            } else {
                x(str);
                return;
            }
        }
        w(str);
    }
}
