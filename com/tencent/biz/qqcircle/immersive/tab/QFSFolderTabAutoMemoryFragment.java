package com.tencent.biz.qqcircle.immersive.tab;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFolderTabAutoMemoryFragment extends QFSFolderTabFragment {
    public String R;
    private QFSAutoMemoryFragment S;

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSFolderTabAutoMemoryFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        this.R = "QFSFolderTabAutoMemoryFragment_";
        this.R += qCircleTabInfo.getName() + "_" + qCircleTabInfo.getTabTaskId();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public int Dh() {
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo != null) {
            return qCircleTabInfo.getPriority();
        }
        return super.Dh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Th() {
        QFSAutoMemoryFragment qFSAutoMemoryFragment = this.S;
        if (qFSAutoMemoryFragment != null) {
            return qFSAutoMemoryFragment.sh();
        }
        QLog.e(getTAG(), 1, "[isSkinMode] mAttachContentFragment:null");
        return false;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void di() {
        if (this.S != null) {
            return;
        }
        if (!isAdded()) {
            QLog.d(getTAG(), 1, "[restorePageContent] isAdded false");
            return;
        }
        QFSAutoMemoryFragment rh5 = QFSAutoMemoryFragment.rh(this.E, this.F);
        if (rh5 != null) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.f3632149, rh5);
            beginTransaction.commitNowAllowingStateLoss();
            this.S = rh5;
            QLog.d(getTAG(), 1, "[restorePageContent] mCurrentTab:" + this.S);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void fi() {
        QLog.d(getTAG(), 1, "[scrollToTopAndRefresh] mAttachContentFragment:" + this.S);
        QFSAutoMemoryFragment qFSAutoMemoryFragment = this.S;
        if (qFSAutoMemoryFragment != null) {
            qFSAutoMemoryFragment.th();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gcd;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        QFSAutoMemoryFragment qFSAutoMemoryFragment = this.S;
        if (qFSAutoMemoryFragment != null) {
            return qFSAutoMemoryFragment.getDaTongPageId();
        }
        QLog.e(getTAG(), 1, "[getDaTongPageId] mAttachContentFragment: null");
        return "";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return this.R;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        QFSAutoMemoryFragment qFSAutoMemoryFragment = this.S;
        if (qFSAutoMemoryFragment != null) {
            return qFSAutoMemoryFragment.getPageId();
        }
        QLog.e(getTAG(), 1, "[getPageId] mAttachContentFragment: null");
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        if (Oh()) {
            QFSLazyLoadUtils.d(getContext());
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!Nh() && this.S == null) {
            QLog.d(getTAG(), 1, "[onActivityCreated] load content fragment");
            di();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        QFSAutoMemoryFragment qFSAutoMemoryFragment = this.S;
        if (qFSAutoMemoryFragment != null) {
            qFSAutoMemoryFragment.setUserVisibleHint(z16);
        } else {
            QLog.e(getTAG(), 1, "[setUserVisibleHint] mAttachContentFragment: null");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void sh() {
        if (this.S == null) {
            return;
        }
        QLog.d(getTAG(), 1, "[clearPageContent] mCurrentTab:" + this.S);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.remove(this.S);
        beginTransaction.commitNowAllowingStateLoss();
        this.S = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void scrollToTop() {
    }
}
