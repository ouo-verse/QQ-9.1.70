package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f303800a;

    /* renamed from: b, reason: collision with root package name */
    private String f303801b;

    /* renamed from: c, reason: collision with root package name */
    private QADApkDownloadTaskState f303802c;

    /* renamed from: d, reason: collision with root package name */
    private String f303803d;

    /* renamed from: e, reason: collision with root package name */
    private int f303804e;

    /* renamed from: f, reason: collision with root package name */
    private String f303805f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f303806g;

    /* renamed from: h, reason: collision with root package name */
    @QADDownloadRoute
    private int f303807h = 0;

    /* renamed from: i, reason: collision with root package name */
    @InstallQueryType
    private int f303808i = -1;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, String> f303809j = new HashMap();

    public e(String str, String str2, QADApkDownloadTaskState qADApkDownloadTaskState) {
        this.f303800a = str;
        this.f303801b = str2;
        this.f303802c = qADApkDownloadTaskState;
    }

    public QADApkDownloadTaskState a() {
        return this.f303802c;
    }

    public int b() {
        return this.f303804e;
    }

    public String c() {
        return this.f303805f;
    }

    public String d() {
        return this.f303801b;
    }

    @QADApkDownloadUiState
    public int e() {
        return com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.a.b(this.f303802c);
    }

    public boolean f() {
        return this.f303806g;
    }

    public void g(@QADDownloadRoute int i3) {
        this.f303807h = i3;
    }

    public void h(int i3) {
        this.f303804e = i3;
    }

    public void i(String str) {
        this.f303805f = str;
    }

    public void j(boolean z16) {
        this.f303806g = z16;
    }

    public void k(String str) {
        this.f303803d = str;
    }
}
