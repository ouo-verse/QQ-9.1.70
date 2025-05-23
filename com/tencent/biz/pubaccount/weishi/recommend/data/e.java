package com.tencent.biz.pubaccount.weishi.recommend.data;

import UserGrowth.stExposureFeedInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f81418a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f81419b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f81420c;

    /* renamed from: d, reason: collision with root package name */
    private final long f81421d = System.currentTimeMillis();

    /* renamed from: e, reason: collision with root package name */
    private String f81422e;

    /* renamed from: f, reason: collision with root package name */
    private String f81423f;

    /* renamed from: g, reason: collision with root package name */
    private String f81424g;

    /* renamed from: h, reason: collision with root package name */
    private String f81425h;

    /* renamed from: i, reason: collision with root package name */
    private int f81426i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<stExposureFeedInfo> f81427j;

    public e(boolean z16, boolean z17, boolean z18) {
        this.f81418a = z16;
        this.f81419b = z17;
        this.f81420c = z18;
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(this.f81425h)) {
            arrayList.add(this.f81425h);
        }
        return arrayList;
    }

    public ArrayList<stExposureFeedInfo> b() {
        return this.f81427j;
    }

    public String c() {
        return this.f81423f;
    }

    public String d() {
        return this.f81424g;
    }

    public long e() {
        return this.f81421d;
    }

    public String f() {
        return this.f81422e;
    }

    public Map<String, Integer> g() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.f81425h)) {
            hashMap.put(this.f81425h, Integer.valueOf(this.f81426i));
        }
        return hashMap;
    }

    public boolean h() {
        return this.f81419b;
    }

    public boolean i() {
        return this.f81420c;
    }

    public boolean j() {
        return this.f81418a;
    }

    public e k(ArrayList<stExposureFeedInfo> arrayList) {
        this.f81427j = arrayList;
        return this;
    }

    public e l(String str) {
        this.f81425h = str;
        return this;
    }

    public void m(int i3) {
        this.f81426i = i3;
    }

    public e n(String str) {
        this.f81423f = str;
        return this;
    }

    public e o(String str) {
        this.f81424g = str;
        return this;
    }

    public e p(String str) {
        this.f81422e = str;
        return this;
    }

    public String toString() {
        return "WSGridRequestParams{mIsRefresh=" + this.f81418a + ", mIsFirstFromService=" + this.f81419b + ", mIsRedDotCacheValid=" + this.f81420c + ", mStartLoadTimestamp=" + this.f81421d + ", mSubTabId='" + this.f81422e + "', mPushInfo='" + this.f81423f + "', mRowKey='" + this.f81424g + "', mLastFeedId='" + this.f81425h + "'}";
    }
}
