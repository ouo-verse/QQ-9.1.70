package com.tencent.biz.pubaccount.weishi.report.dc898;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSReportDC898Base {

    /* renamed from: a, reason: collision with root package name */
    private String f81509a;

    /* renamed from: b, reason: collision with root package name */
    private String f81510b;

    /* renamed from: c, reason: collision with root package name */
    private final a f81511c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WSReportDC898Base(a aVar) {
        this.f81511c = aVar;
    }

    private String b() {
        Map<String, String> c16 = c();
        if (c16 == null) {
            return "";
        }
        return new Gson().toJson(c16);
    }

    public Map<String, String> c() {
        if (TextUtils.isEmpty(this.f81509a) || TextUtils.isEmpty(this.f81510b)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, this.f81509a);
        hashMap.put("sop_name", this.f81510b);
        return hashMap;
    }

    public String d(int i3) {
        Map<String, String> c16 = c();
        if (c16 == null) {
            return String.valueOf(i3);
        }
        c16.put("op_id", String.valueOf(i3));
        return new Gson().toJson(c16);
    }

    public void e() {
        r("profpic_clkc", 0, 0, 0L, 0L, b());
    }

    public void h() {
        q("follow_entry_clk", 0, 0, 0L, 0L, b());
    }

    public void i() {
        r("videoplay_more_clk", 0, 0, 0L, 0L, b());
    }

    public void j() {
        String str;
        String b16 = b();
        q("videoplay_title_clk", 0, 0, 0L, 0L, b16);
        if (l.c(BaseApplicationImpl.sApplication)) {
            str = "videoplay_title_clk_ws";
        } else {
            str = "videoplay_title_dl_ws";
        }
        q(str, 0, 0, 0L, 0L, b16);
    }

    public void k(String str, int i3, int i16) {
        String str2;
        Map<String, String> c16 = c();
        if (c16 != null) {
            c16.put("url", str);
            str2 = new Gson().toJson(c16);
        } else {
            str2 = "";
        }
        r("blockpage_exp", i3, 0, 0L, i16, str2);
    }

    public void l() {
        r("fullscreen_exp", 0, 0, 0L, 0L, b());
    }

    public void m() {
        r("videoplay_close", 0, 0, 0L, 0L, b());
    }

    public void n(Map<String, String> map) {
        String json;
        Map<String, String> c16 = c();
        if (c16 != null) {
            c16.putAll(map);
            json = new Gson().toJson(c16);
        } else {
            json = new Gson().toJson(map);
        }
        r("video_play", 0, 0, 0L, 0L, json);
    }

    public void o(String str) {
        this.f81509a = str;
    }

    public void p(String str) {
        this.f81510b = str;
    }

    public void q(final String str, final int i3, final int i16, final long j3, final long j16, final String str2) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.report.dc898.WSReportDC898Base.1
            @Override // java.lang.Runnable
            public void run() {
                WSReportDc00898.n(WSReportDC898Base.this.f81511c.a(), str, i3, i16, j3, j16, str2, WSReportDC898Base.this.f81511c.b());
            }
        });
    }

    public void r(final String str, final int i3, final int i16, final long j3, final long j16, final String str2) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.report.dc898.WSReportDC898Base.2
            @Override // java.lang.Runnable
            public void run() {
                WSReportDc00898.n(WSReportDC898Base.this.f81511c.c(), str, i3, i16, j3, j16, str2, WSReportDC898Base.this.f81511c.b());
            }
        });
    }

    public void g(String str, int i3, int i16) {
        q(str, i3, 0, 0L, 0L, d(i16));
    }

    public void f(String str) {
        q(str, 0, 0, 0L, 0L, b());
    }
}
