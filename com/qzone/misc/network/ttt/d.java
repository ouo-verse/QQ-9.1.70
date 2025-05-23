package com.qzone.misc.network.ttt;

import ELABORATE_FEED_REPORT.action_flow;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    public Map<Integer, String> f48547e;

    /* renamed from: f, reason: collision with root package name */
    public long f48548f;

    /* renamed from: g, reason: collision with root package name */
    public Map<Integer, String> f48549g;

    /* renamed from: h, reason: collision with root package name */
    public long f48550h;

    /* renamed from: i, reason: collision with root package name */
    public int f48551i;

    /* renamed from: j, reason: collision with root package name */
    public String f48552j;

    /* renamed from: a, reason: collision with root package name */
    private final String f48543a = "TTTRawActionFlow";

    /* renamed from: b, reason: collision with root package name */
    public long f48544b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f48545c = 0;

    /* renamed from: k, reason: collision with root package name */
    public action_flow f48553k = null;

    /* renamed from: d, reason: collision with root package name */
    public String f48546d = null;

    public void a(int i3, int i16, int i17, long j3, Map<Integer, String> map, long j16, int i18, int i19, String str, int i26, Map<Integer, String> map2, long j17, Map<Integer, String> map3, long j18, int i27, String str2) {
        Map<Integer, String> map4 = map2;
        this.f48544b = j16;
        this.f48545c = i19;
        this.f48547e = map4;
        this.f48546d = str;
        this.f48548f = j17;
        this.f48549g = map3;
        this.f48550h = j18;
        this.f48551i = i27;
        this.f48552j = str2;
        this.f48553k = new action_flow((i26 << 8) | (i16 << 24) | 0 | (i17 << 16) | (i18 << 12), j3, i3, map, j17);
        if (com.tencent.mobileqq.simpleui.b.c()) {
            if (map4 == null) {
                map4 = new HashMap<>();
            }
            map4.put(40, "1");
        }
    }
}
