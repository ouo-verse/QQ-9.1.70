package com.tencent.biz.qqcircle.immersive.views.search.hotrank;

import com.tencent.richframework.data.idata.IDataDisplaySurface;
import p70.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b {
    private i F;

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b
    public String U1() {
        i iVar = this.F;
        if (iVar != null) {
            return iVar.c2();
        }
        return super.U1();
    }

    public IDataDisplaySurface<e30.b> b2() {
        i iVar = this.F;
        if (iVar != null) {
            return iVar;
        }
        com.tencent.xaction.log.b.a("QFSSearchHotRankViewModel", 1, "[getDataDisplaySurface] no searchResultViewModel");
        return this;
    }

    public void c2(i iVar) {
        this.F = iVar;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchHotRankViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.F = null;
    }
}
