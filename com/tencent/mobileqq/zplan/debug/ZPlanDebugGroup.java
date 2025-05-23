package com.tencent.mobileqq.zplan.debug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.debug.recordpreview.ZPlanRecordPreviewFragment;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/ZPlanDebugGroup;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "()V", "getContentLayoutId", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanDebugGroup extends QIphoneTitleBarFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getId() != R.id.r7k) {
            return;
        }
        QPublicFragmentActivity.start(this$0.getContext(), ZPlanResourceFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iZootopiaApi.startDemoActivity(requireContext, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "http://anlog.woa.com/");
        this$0.requireActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iSchemeApi.launchScheme(requireContext, "mqqapi://hippy/open?bundleName%3Dsuperqqshow%26bundleUrl%3Dhttp%3A%2F%2Fzplan-image-1300343094.cos.ap-nanjing.myqcloud.com%2Fhippy%2Fdev_adr.zip%26url%3Dhttps%253A%252F%252Ftest-mweb.superqqshow.qq.com%252Findex.bundle%253Froute%253D%25252FoutfitFeeds%26isStatusBarDarkFont%3Dtrue");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iZPlanApi.launchSchemeWithContext(requireContext, "mqqapi://zplan/openHomeConnected?src_type=app&version=1.0&referer=interact_logo_banner&sceneType=100&uin=1375099534&mode=1&direct_exit=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getId() == R.id.f163624r43) {
            QPublicFragmentActivity.start(this$0.getContext(), ZPlanDebugFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getId() != R.id.r7j) {
            return;
        }
        QPublicFragmentActivity.start(this$0.getContext(), ZPlanRecordPreviewFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(ZPlanDebugGroup this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getId() != R.id.r77) {
            return;
        }
        QPublicFragmentActivity.start(this$0.getContext(), ZPlanPortalTestFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dbb;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u8d85\u7ea7QQ\u79c0(ZPlan)");
        View findViewById = view.findViewById(R.id.f163624r43);
        findViewById.setVisibility(0);
        findViewById.setBackgroundColor(Color.parseColor("#55005500"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.xh(ZPlanDebugGroup.this, view2);
            }
        });
        View findViewById2 = view.findViewById(R.id.r7j);
        findViewById2.setVisibility(0);
        findViewById2.setBackgroundColor(Color.parseColor("#55005500"));
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.yh(ZPlanDebugGroup.this, view2);
            }
        });
        View findViewById3 = view.findViewById(R.id.r77);
        findViewById3.setVisibility(0);
        findViewById3.setBackgroundColor(Color.parseColor("#55005500"));
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.zh(ZPlanDebugGroup.this, view2);
            }
        });
        View findViewById4 = view.findViewById(R.id.r7k);
        findViewById4.setVisibility(0);
        findViewById4.setBackgroundColor(Color.parseColor("#55005500"));
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.Ah(ZPlanDebugGroup.this, view2);
            }
        });
        view.findViewById(R.id.f163469qa2).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.Bh(ZPlanDebugGroup.this, view2);
            }
        });
        view.findViewById(R.id.pab).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.Ch(ZPlanDebugGroup.this, view2);
            }
        });
        view.findViewById(R.id.p_t).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.Dh(ZPlanDebugGroup.this, view2);
            }
        });
        view.findViewById(R.id.f163470qa3).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanDebugGroup.Eh(ZPlanDebugGroup.this, view2);
            }
        });
    }
}
