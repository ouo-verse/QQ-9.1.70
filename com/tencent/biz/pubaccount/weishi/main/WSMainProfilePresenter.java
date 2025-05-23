package com.tencent.biz.pubaccount.weishi.main;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;

/* loaded from: classes32.dex */
public class WSMainProfilePresenter extends WSMainVerticalPresenter {
    public WSMainProfilePresenter(c cVar) {
        super(cVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter
    protected void setCanScrollHorizontally(c cVar, j jVar) {
        cVar.h9(!TextUtils.equals(this.mPersonId, jVar.e().poster.f25130id));
    }
}
