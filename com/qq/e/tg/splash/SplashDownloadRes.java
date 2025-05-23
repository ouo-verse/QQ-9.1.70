package com.qq.e.tg.splash;

import com.qq.e.comm.pi.SplashCustomSettingListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SplashDownloadRes {
    public static final int RES_IMG = 1;
    public static final int RES_VIDEO = 2;

    /* renamed from: a, reason: collision with root package name */
    private String f40726a;

    /* renamed from: b, reason: collision with root package name */
    private String f40727b;

    /* renamed from: c, reason: collision with root package name */
    private int f40728c;

    /* renamed from: d, reason: collision with root package name */
    private String f40729d;

    /* renamed from: e, reason: collision with root package name */
    private String f40730e;

    /* renamed from: f, reason: collision with root package name */
    private String f40731f;

    /* renamed from: g, reason: collision with root package name */
    private SplashCustomSettingListener.DownloadCallback f40732g;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ResType {
    }

    public SplashDownloadRes(String str, String str2, String str3, int i3, String str4, SplashCustomSettingListener.DownloadCallback downloadCallback) {
        this.f40726a = str;
        this.f40727b = str2;
        this.f40728c = i3;
        this.f40729d = str4;
        this.f40732g = downloadCallback;
        this.f40730e = str3;
    }

    public SplashCustomSettingListener.DownloadCallback getCallback() {
        return this.f40732g;
    }

    public String getCl() {
        return this.f40731f;
    }

    public String getName() {
        return this.f40730e;
    }

    public String getPath() {
        return this.f40727b;
    }

    public String getPosid() {
        return this.f40729d;
    }

    public int getType() {
        return this.f40728c;
    }

    public String getUrl() {
        return this.f40726a;
    }

    public SplashDownloadRes(String str, String str2, String str3, int i3, String str4, String str5, SplashCustomSettingListener.DownloadCallback downloadCallback) {
        this.f40726a = str;
        this.f40727b = str2;
        this.f40728c = i3;
        this.f40729d = str4;
        this.f40732g = downloadCallback;
        this.f40730e = str3;
        this.f40731f = str5;
    }
}
