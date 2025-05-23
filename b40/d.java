package b40;

import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f27863a;

    /* renamed from: b, reason: collision with root package name */
    private String f27864b;

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudCommon$StCommonExt f27865c = new FeedCloudCommon$StCommonExt();

    /* renamed from: d, reason: collision with root package name */
    private boolean f27866d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f27867e;

    public d(String str, String str2, boolean z16, List<a> list) {
        this.f27864b = str;
        this.f27863a = str2;
        this.f27866d = z16;
        this.f27867e = list;
    }

    public List<a> a() {
        return this.f27867e;
    }

    public FeedCloudCommon$StCommonExt b() {
        return this.f27865c;
    }

    public String c() {
        return this.f27863a;
    }

    public String d() {
        return this.f27864b;
    }

    public boolean e() {
        return this.f27866d;
    }

    public void f(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        this.f27865c = feedCloudCommon$StCommonExt;
    }
}
