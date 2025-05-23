package com.tencent.biz.qqcircle.immersive.part.search.tab;

import androidx.annotation.CallSuper;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.search.QFSSearchBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSBaseSearchTabFragment extends QFSSearchBaseFragment {
    protected QFSSearchInfo E;
    private boolean F;
    private boolean G;

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @CallSuper
    public List<Part> assembleParts() {
        this.G = true;
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        QFSSearchInfo qFSSearchInfo = this.E;
        if (qFSSearchInfo != null) {
            hashMap.put("xsj_query_text", qFSSearchInfo.f());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gsk;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    public void loadData() {
        if (!this.F && this.G) {
            this.F = true;
            getPartManager().broadcastMessage("qfs_search_action_with_keyword", this.E);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.search.QFSSearchBaseFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.E != null) {
            QLog.d(getLogTag(), 1, "onResume has searchInfo");
            loadData();
        }
    }

    public abstract void reset();

    public void rh(QFSSearchInfo qFSSearchInfo) {
        this.F = false;
        this.E = qFSSearchInfo;
        if (sh()) {
            reset();
        } else {
            loadData();
        }
    }

    public abstract boolean sh();

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
