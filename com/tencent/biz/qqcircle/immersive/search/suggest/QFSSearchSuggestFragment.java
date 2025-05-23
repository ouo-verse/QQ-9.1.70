package com.tencent.biz.qqcircle.immersive.search.suggest;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.search.QFSSearchBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import t60.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchSuggestFragment extends QFSSearchBaseFragment {
    @Nullable
    private QFSSearchInfo rh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (QFSSearchInfo) arguments.getParcelable("data");
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.grf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_CONNECTIVE_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchSuggestFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    public void update() {
        QFSSearchInfo rh5 = rh();
        if (rh5 == null) {
            return;
        }
        getPartManager().broadcastMessage("updateData", rh5);
    }
}
