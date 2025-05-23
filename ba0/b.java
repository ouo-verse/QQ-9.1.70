package ba0;

import circlesearch.CircleSearchExhibition$JumpInfo;
import circlesearch.CircleSearchExhibition$TextIconStyleData;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements aa0.a {

    /* renamed from: a, reason: collision with root package name */
    public final CircleSearchExhibition$TextIconStyleData f28141a;

    /* renamed from: b, reason: collision with root package name */
    private String f28142b;

    public b(CircleSearchExhibition$TextIconStyleData circleSearchExhibition$TextIconStyleData) {
        this.f28141a = circleSearchExhibition$TextIconStyleData;
    }

    @Override // aa0.a
    public CircleSearchExhibition$JumpInfo a() {
        return this.f28141a.jumpInfo.get();
    }

    public Integer b() {
        return p.F(this.f28141a.icon.background_color.get());
    }

    public Integer c() {
        return p.F(this.f28141a.icon.text_color.get());
    }

    public String d() {
        return this.f28142b;
    }

    public FeedCloudCommon$StCommonExt e() {
        return this.f28141a.reportInfo.get();
    }

    public void f(String str) {
        this.f28142b = str;
    }
}
