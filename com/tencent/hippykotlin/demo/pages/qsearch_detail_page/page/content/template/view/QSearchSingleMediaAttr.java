package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleMediaAttr extends k {
    public boolean isShowAsThumbnail;
    public QSearchMultiMediaInfo mediaInfo;
    public int moreCount;
    public boolean showMoreCount;
    public float borderRadius = 4.0f;
    public e reportParams = new e();

    public final QSearchMultiMediaInfo getMediaInfo() {
        QSearchMultiMediaInfo qSearchMultiMediaInfo = this.mediaInfo;
        if (qSearchMultiMediaInfo != null) {
            return qSearchMultiMediaInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        return null;
    }
}
