package com.tencent.mobileqq.mini.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqmini.container.core.MiniView;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes33.dex */
public class MiniContainerPageFragment extends QPublicBaseFragment {
    public static final String PAGE_PATH = "path";
    private MiniView miniView;

    private boolean isNightTheme() {
        return QQTheme.isNowThemeIsNight() || QQTheme.isNowThemeSimpleNight();
    }

    private void loadPage() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        if (activity.getWindow() != null) {
            ImmersiveUtils.setStatusTextColor(!isNightTheme(), activity.getWindow());
        }
        this.miniView.setLifeCycleOwner(this);
        this.miniView.r(activity.getIntent().getStringExtra("path"));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MiniView miniView = this.miniView;
        if (miniView == null || miniView.n()) {
            return;
        }
        this.miniView.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.miniView = (MiniView) view.findViewById(R.id.rjj);
        final View findViewById = view.findViewById(R.id.f163697ri4);
        final View findViewById2 = view.findViewById(R.id.ril);
        view.findViewById(R.id.rj8).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniContainerPageFragment.this.lambda$onViewCreated$0(findViewById2, findViewById, view2);
            }
        });
        this.miniView.setLoadCallback(new com.tencent.qqmini.container.core.l() { // from class: com.tencent.mobileqq.mini.activity.d
            @Override // com.tencent.qqmini.container.core.l
            public final void onLoaded(int i3, String str) {
                MiniContainerPageFragment.lambda$onViewCreated$1(findViewById2, findViewById, i3, str);
            }
        });
        loadPage();
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).registerMiniView(this.miniView);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view, View view2, View view3) {
        view.setVisibility(0);
        view2.setVisibility(8);
        this.miniView.x();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.djr, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onViewCreated$1(View view, View view2, int i3, String str) {
        boolean z16 = i3 == 0;
        view.setVisibility(8);
        view2.setVisibility(z16 ? 8 : 0);
    }
}
