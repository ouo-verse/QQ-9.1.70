package com.tencent.mobileqq.filemanager.data.search;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.presenter.n;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends n {
    public d(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    @Override // com.tencent.mobileqq.search.presenter.n
    protected qn2.c<y, sn2.c> g(IFaceDecoder iFaceDecoder) {
        return new FileSearchResultPresenter(iFaceDecoder);
    }
}
