package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SingleVideoItemAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SingleVideoItemAttr.class, "muted", "getMuted()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SingleVideoItemAttr.class, "playIndex", "getPlayIndex()I", 0)};
    public int index;
    public StFeedEx stFeedEx;
    public final ReadWriteProperty muted$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty playIndex$delegate = c.a(-1);
    public String highlightWord = "";
    public e reportParams = new e();

    public final int getPlayIndex() {
        return ((Number) this.playIndex$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final StFeedEx getStFeedEx() {
        StFeedEx stFeedEx = this.stFeedEx;
        if (stFeedEx != null) {
            return stFeedEx;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stFeedEx");
        return null;
    }
}
