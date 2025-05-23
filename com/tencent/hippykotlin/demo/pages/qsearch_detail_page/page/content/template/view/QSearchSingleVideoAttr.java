package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleVideoAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchSingleVideoAttr.class, "playIndex", "getPlayIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchSingleVideoAttr.class, "muted", "getMuted()Z", 0)};
    public int index;
    public boolean isShowCollectionIcon;
    public boolean isUseNewBodyStyle;
    public QSearchMultiMediaInfo mediaInfo;
    public StFeedEx stFeedEx;
    public final ReadWriteProperty playIndex$delegate = c.a(0);
    public final ReadWriteProperty muted$delegate = c.a(Boolean.TRUE);
    public float borderRadius = 8.0f;
    public e reportParams = new e();

    public final QSearchMultiMediaInfo getMediaInfo() {
        QSearchMultiMediaInfo qSearchMultiMediaInfo = this.mediaInfo;
        if (qSearchMultiMediaInfo != null) {
            return qSearchMultiMediaInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        return null;
    }

    public final boolean getMuted() {
        return ((Boolean) this.muted$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final int getPlayIndex() {
        return ((Number) this.playIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
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
