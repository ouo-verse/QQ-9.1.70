package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.base.room.AnchorLivePageAdapter;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiAnchorFragment extends QPublicBaseFragment {
    private ViewGroup C;
    private AnchorLivePageAdapter D;
    private IAegisLogApi E = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    private void ph() {
        if (this.D != null) {
            return;
        }
        this.D = new AnchorLivePageAdapter(new Page(requireContext(), new b()), new a());
    }

    private void qh(Context context) {
        if (this.D == null) {
            ph();
        }
        this.D.p(context, this.C, this);
        this.D.u();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return this.D.q();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        boolean z16;
        super.onConfigurationChanged(configuration);
        AnchorLivePageAdapter anchorLivePageAdapter = this.D;
        if (anchorLivePageAdapter != null) {
            anchorLivePageAdapter.r(configuration);
            AnchorLivePageAdapter anchorLivePageAdapter2 = this.D;
            if (configuration.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            anchorLivePageAdapter2.t(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ph();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context qBaseActivity;
        this.C = new FrameLayout(viewGroup.getContext());
        if (getQBaseActivity() == null) {
            qBaseActivity = viewGroup.getContext();
        } else {
            qBaseActivity = getQBaseActivity();
        }
        qh(qBaseActivity);
        ViewGroup viewGroup2 = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AnchorLivePageAdapter anchorLivePageAdapter = this.D;
        if (anchorLivePageAdapter != null) {
            anchorLivePageAdapter.v();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        AnchorLivePageAdapter anchorLivePageAdapter;
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras != null && (anchorLivePageAdapter = this.D) != null) {
            anchorLivePageAdapter.s(extras);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AnchorLivePageAdapter anchorLivePageAdapter = this.D;
        if (anchorLivePageAdapter != null) {
            anchorLivePageAdapter.w();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AnchorLivePageAdapter anchorLivePageAdapter = this.D;
        if (anchorLivePageAdapter != null) {
            anchorLivePageAdapter.x();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AnchorLivePageAdapter anchorLivePageAdapter = this.D;
        if (anchorLivePageAdapter != null) {
            anchorLivePageAdapter.y();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AnchorLivePageAdapter anchorLivePageAdapter = this.D;
        if (anchorLivePageAdapter != null) {
            anchorLivePageAdapter.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.E.i("TGLiveAnchorFloatingView", "TimiAnchorFragment onViewCreated");
        this.D.A(getArguments());
    }
}
