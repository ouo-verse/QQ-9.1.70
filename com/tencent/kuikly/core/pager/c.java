package com.tencent.kuikly.core.pager;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/pager/c;", "", "", "pagerEvent", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "eventData", "", "onPagerEvent", "", "width", "height", "onRootViewSizeChanged", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface c {
    void onPagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData);

    void onRootViewSizeChanged(double width, double height);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        public static void a(c cVar, double d16, double d17) {
        }
    }
}
