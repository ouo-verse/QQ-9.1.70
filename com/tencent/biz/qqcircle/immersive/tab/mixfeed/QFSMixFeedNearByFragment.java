package com.tencent.biz.qqcircle.immersive.tab.mixfeed;

import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.part.mixfeed.a;
import com.tencent.biz.richframework.part.Part;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedNearByFragment extends QFSMixFeedSubFragment {
    public QFSMixFeedNearByFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.mixfeed.QFSMixFeedSubFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new a(this.F));
        return assembleParts;
    }
}
