package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;

/* loaded from: classes32.dex */
public final class QSearchPictureDetail implements ISSOReqModel, ISSORspModel<QSearchPictureDetail> {
    public final QSearchPicture large;
    public final QSearchPicture small;

    public QSearchPictureDetail(QSearchPicture qSearchPicture, QSearchPicture qSearchPicture2) {
        this.large = qSearchPicture;
        this.small = qSearchPicture2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QSearchPicture qSearchPicture = this.large;
        if (qSearchPicture != null) {
            eVar.v(NtFaceConstant.LARGE, qSearchPicture.encode());
        }
        QSearchPicture qSearchPicture2 = this.small;
        if (qSearchPicture2 != null) {
            eVar.v(NtFaceConstant.SMALL, qSearchPicture2.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchPictureDetail decode(e eVar) {
        e m3 = eVar.m(NtFaceConstant.LARGE);
        QSearchPicture decode = m3 != null ? new QSearchPicture(null, null, 0, 0, null, 31, null).decode(m3) : null;
        e m16 = eVar.m(NtFaceConstant.SMALL);
        return new QSearchPictureDetail(decode, m16 != null ? new QSearchPicture(null, null, 0, 0, null, 31, null).decode(m16) : null);
    }
}
