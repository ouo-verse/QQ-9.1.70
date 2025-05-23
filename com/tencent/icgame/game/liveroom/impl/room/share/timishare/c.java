package com.tencent.icgame.game.liveroom.impl.room.share.timishare;

import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f115618a;

    /* renamed from: b, reason: collision with root package name */
    public String f115619b;

    /* renamed from: c, reason: collision with root package name */
    public String f115620c;

    /* renamed from: d, reason: collision with root package name */
    public long f115621d;

    /* renamed from: e, reason: collision with root package name */
    public String f115622e;

    /* renamed from: f, reason: collision with root package name */
    public String f115623f;

    /* renamed from: g, reason: collision with root package name */
    public String f115624g;

    /* renamed from: m, reason: collision with root package name */
    public String f115630m;

    /* renamed from: h, reason: collision with root package name */
    public String f115625h = "1";

    /* renamed from: i, reason: collision with root package name */
    public String f115626i = "0";

    /* renamed from: j, reason: collision with root package name */
    public String f115627j = "1";

    /* renamed from: k, reason: collision with root package name */
    public String f115628k = "1";

    /* renamed from: l, reason: collision with root package name */
    public String f115629l = "";

    /* renamed from: n, reason: collision with root package name */
    public int f115631n = 0;

    /* renamed from: o, reason: collision with root package name */
    public String f115632o = "";

    public String a() {
        return this.f115629l;
    }

    public String b(int i3) {
        return ((ITimiShareHelper) QRoute.api(ITimiShareHelper.class)).getShareDetailUrl(this, i3);
    }

    public String c() {
        ITimiShareHelper iTimiShareHelper = (ITimiShareHelper) QRoute.api(ITimiShareHelper.class);
        String str = this.f115620c;
        if (str == null) {
            str = "";
        }
        return iTimiShareHelper.getShareSingleTitle(str);
    }

    public String d() {
        ITimiShareHelper iTimiShareHelper = (ITimiShareHelper) QRoute.api(ITimiShareHelper.class);
        String str = this.f115623f;
        if (str == null) {
            str = "";
        }
        return iTimiShareHelper.getShareSummary(str);
    }
}
