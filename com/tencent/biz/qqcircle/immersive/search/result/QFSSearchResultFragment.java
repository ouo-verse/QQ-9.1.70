package com.tencent.biz.qqcircle.immersive.search.result;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.search.QFSSearchBaseFragment;
import com.tencent.biz.qqcircle.manager.k;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import s60.d;
import u60.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchResultFragment extends QFSSearchBaseFragment {
    private d E;

    @Nullable
    private QFSSearchInfo sh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (QFSSearchInfo) arguments.getParcelable("data");
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        d dVar = new d();
        this.E = dVar;
        arrayList.add(dVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.grw;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchResultFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        d dVar;
        super.onHiddenChanged(z16);
        if (z16 && (dVar = this.E) != null) {
            dVar.W9();
        }
    }

    public void rh(b bVar) {
        getPartManager().broadcastMessage("changePageState", bVar);
    }

    public void update() {
        QFSSearchInfo sh5 = sh();
        if (sh5 == null) {
            return;
        }
        getPartManager().broadcastMessage("updateData", sh5);
        k.d().a(sh5.f());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
