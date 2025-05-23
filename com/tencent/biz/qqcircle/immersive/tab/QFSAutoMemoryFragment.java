package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.richframework.part.ILazyLoader;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSAutoMemoryFragment extends QFSBaseFragment implements ILazyLoader {
    protected final QCircleTabInfo E;
    protected final int F;

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSAutoMemoryFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        this.E = qCircleTabInfo;
        this.F = i3;
    }

    public static QFSAutoMemoryFragment rh(QCircleTabInfo qCircleTabInfo, int i3) {
        if (qCircleTabInfo == null) {
            return null;
        }
        if (QFSGameTabFragment.INSTANCE.a(qCircleTabInfo)) {
            return new QFSGameTabFragment(qCircleTabInfo, i3);
        }
        if (qCircleTabInfo.getType() != 14) {
            return null;
        }
        return new QFSProbeTabFragment(qCircleTabInfo, i3);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public abstract String getDaTongPageId();

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        return true;
    }

    public boolean sh() {
        return true;
    }

    public abstract void th();
}
