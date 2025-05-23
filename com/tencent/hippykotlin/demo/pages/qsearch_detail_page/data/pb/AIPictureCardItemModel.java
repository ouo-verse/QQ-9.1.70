package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

/* loaded from: classes32.dex */
public final class AIPictureCardItemModel extends BaseSearchItemModel {
    public AIPictureCardInfo cardInfo;

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        AIPictureCardInfo aIPictureCardInfo = this.cardInfo;
        if (aIPictureCardInfo != null) {
            return aIPictureCardInfo.isShow;
        }
        return false;
    }
}
