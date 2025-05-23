package com.tencent.sqshow.zootopia.portal.home.banner;

import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/c;", "", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "", "isFakeEdgeItem", "c", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface c {
    void c(int position, boolean isFakeEdgeItem);

    void onPageScrollStateChanged(int state);

    void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
}
