package com.tencent.biz.qqcircle.immersive.tab.mixfeed;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.events.QFSRefreshSubTabEvent;
import com.tencent.biz.qqcircle.immersive.part.mixfeed.QFSMixFeedMainTopTabPart;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils;
import com.tencent.biz.qqcircle.lazyload.QFSNotifyLazyLoadEvent;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.ArrayList;
import java.util.List;
import t40.b;
import v60.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedMainTabFragment extends QFSFolderTabFragment implements a {
    private QFSMixFeedMainTopTabPart R;
    private b S;
    private View T;

    public QFSMixFeedMainTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        QFSHodorCollectManager.f84689a.a("qfs_mix_tab_create_cost");
        QCircleFolderTabInfoManager.m().C(true);
    }

    private void pi() {
        if (this.T == null) {
            QLog.e(getTAG(), 1, "[updateFragmentBackground] mFragmentContainerView == null");
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_bg_bottom_light), QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_bg_bottom_standard)});
        this.T.setBackground(gradientDrawable);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public int Ch() {
        return 3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public int Dh() {
        return 300;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void Gh() {
        fi();
        QCircleToast.h(R.string.f19048428, 2000);
        xh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void Hh(QFSNotifyLazyLoadEvent qFSNotifyLazyLoadEvent) {
        if (qFSNotifyLazyLoadEvent.getNotifyId() == Ch()) {
            makeSureInit(true);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Kh() {
        return f.v().f0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Th() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Wh() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSMixFeedMainTopTabPart qFSMixFeedMainTopTabPart = new QFSMixFeedMainTopTabPart(this.E);
        this.R = qFSMixFeedMainTopTabPart;
        arrayList.add(qFSMixFeedMainTopTabPart);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void di() {
        QFSMixFeedMainTopTabPart qFSMixFeedMainTopTabPart = this.R;
        if (qFSMixFeedMainTopTabPart != null) {
            qFSMixFeedMainTopTabPart.switchToContentState();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void fi() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSRefreshSubTabEvent(this.R.E9()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gjb;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMixFeedMainTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void hi() {
        super.hi();
        f.v().d0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void li(boolean z16) {
        String str;
        super.li(z16);
        if (z16) {
            str = "_begin_business";
        } else {
            str = "_end_business";
        }
        QFSHodorCollectManager.f84689a.b("qfs_tab_mix_feed" + str);
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        QFSMixFeedMainTopTabPart qFSMixFeedMainTopTabPart = this.R;
        if (qFSMixFeedMainTopTabPart != null) {
            qFSMixFeedMainTopTabPart.init();
        }
        if (Oh()) {
            QFSLazyLoadUtils.d(getContext());
        }
    }

    @Override // t40.b
    public void onHandlerMessage(String str, Object... objArr) {
        b bVar = this.S;
        if (bVar != null) {
            bVar.onHandlerMessage(str, objArr);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSHodorCollectManager.f84689a.b("qfs_tab_mix_feed_begin_business");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        QLog.d(getTAG(), 1, "[onViewCreatedAfterPartInit] hashCode = " + hashCode());
        this.T = view.findViewById(R.id.f47271wu);
        pi();
        com.tencent.mobileqq.qui.b.f276860a.a(this.T, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        QFSHodorCollectManager.f84689a.c("qfs_mix_tab_create_cost");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        this.S = (b) getIocInterface(b.class);
        registerIoc(view, this, a.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void sh() {
        QFSMixFeedMainTopTabPart qFSMixFeedMainTopTabPart = this.R;
        if (qFSMixFeedMainTopTabPart != null) {
            qFSMixFeedMainTopTabPart.switchToEmptyState();
        }
    }

    @Override // v60.a
    public boolean vd() {
        return isResumed();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void scrollToTop() {
    }
}
