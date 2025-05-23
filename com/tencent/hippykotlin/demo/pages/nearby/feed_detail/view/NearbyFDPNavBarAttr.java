package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NearbyFDPNavBarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarAttr.class, "bgGradientPercentage", "getBgGradientPercentage()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarAttr.class, "navTitle", "getNavTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarAttr.class, "themeId", "getThemeId()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarAttr.class, "scrollParams", "getScrollParams()Lcom/tencent/kuikly/core/views/ScrollParams;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarAttr.class, "isFollowingPage", "isFollowingPage()Z", 0)};
    public INearbyFeedDetailDTReporter dtReporter;
    public final ReadWriteProperty bgGradientPercentage$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty navTitle$delegate = c.a("\u9644\u8fd1\u5e7f\u573a");
    public final ReadWriteProperty themeId$delegate = c.a("");
    public final ReadWriteProperty scrollParams$delegate = c.a(null);
    public final ReadWriteProperty isFollowingPage$delegate = c.a(Boolean.FALSE);

    public final String getThemeId() {
        return (String) this.themeId$delegate.getValue(this, $$delegatedProperties[2]);
    }
}
