package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model;

import com.tencent.tvideo.protocol.pb.AdActionButton;
import com.tencent.tvideo.protocol.pb.AdPlayFinishMaskInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private String f304165a;

    /* renamed from: b, reason: collision with root package name */
    private String f304166b;

    /* renamed from: c, reason: collision with root package name */
    private String f304167c;

    /* renamed from: d, reason: collision with root package name */
    private String f304168d;

    /* renamed from: e, reason: collision with root package name */
    private int f304169e;

    /* renamed from: f, reason: collision with root package name */
    private String f304170f;

    /* renamed from: g, reason: collision with root package name */
    private String f304171g;

    /* renamed from: h, reason: collision with root package name */
    private String f304172h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f304173i;

    public c(String str, String str2, String str3, int i3, String str4, String str5) {
        this.f304165a = str;
        this.f304166b = str2;
        this.f304168d = str3;
        this.f304169e = i3;
        this.f304170f = str4;
        this.f304171g = str5;
    }

    public static c a(AdPlayFinishMaskInfo adPlayFinishMaskInfo, boolean z16) {
        String str;
        String str2;
        if (adPlayFinishMaskInfo == null) {
            return null;
        }
        AdActionButton adActionButton = adPlayFinishMaskInfo.action_button;
        if (adActionButton != null) {
            str = adActionButton.text_color;
            str2 = adActionButton.bg_color;
        } else {
            str = null;
            str2 = null;
        }
        c cVar = new c(adPlayFinishMaskInfo.title, adPlayFinishMaskInfo.sub_title, adPlayFinishMaskInfo.image_url, 0, str, str2);
        cVar.f(z16);
        cVar.e(adPlayFinishMaskInfo.short_title);
        return cVar;
    }

    public String b() {
        return this.f304168d;
    }

    public String c() {
        return this.f304166b;
    }

    public String d() {
        return this.f304165a;
    }

    public void e(String str) {
        this.f304167c = str;
    }

    public void f(boolean z16) {
        this.f304173i = z16;
    }

    public String toString() {
        return "QAdMaskEndItem{actionTitle='" + this.f304165a + "', actionIcon='" + this.f304168d + "', defaultIcon=" + this.f304169e + ", actionTextColor='" + this.f304170f + "', actionBgColor='" + this.f304171g + "', adDefaultExtInfo='" + this.f304172h + "'}";
    }
}
