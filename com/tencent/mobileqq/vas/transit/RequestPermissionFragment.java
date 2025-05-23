package com.tencent.mobileqq.vas.transit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import bd3.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/RequestPermissionFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "qh", "initView", "finishActivity", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onActivityCreated", "onResume", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "D", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "navBarView", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "contentView", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "G", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "transitPageInfo", "", "H", "Z", "fullScreenMode", "<init>", "()V", "I", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RequestPermissionFragment extends QPublicBaseFragment {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private NavBarCommon navBarView;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout contentView;

    /* renamed from: F, reason: from kotlin metadata */
    private ZootopiaSource sourceFrom;

    /* renamed from: G, reason: from kotlin metadata */
    private TransitPageInfo transitPageInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean fullScreenMode;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/RequestPermissionFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "pageInfo", "Landroid/os/Bundle;", "extBundle", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "a", "", "KEY_PAGE_INFO", "Ljava/lang/String;", "KEY_SOURCE_FROM", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.transit.RequestPermissionFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, TransitPageInfo pageInfo, Bundle extBundle, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
            Intrinsics.checkNotNullParameter(source, "source");
            if (!TransitPageInfo.INSTANCE.a(pageInfo)) {
                QLog.e("TransitPageFragment", 1, "invalid pageInfo");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("transit_page_info", pageInfo);
            intent.putExtra("transit_source_from", source);
            intent.putExtra("public_fragment_window_feature", 1);
            if (extBundle != null) {
                intent.putExtras(extBundle);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, RequestPermissionFragment.class);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/transit/RequestPermissionFragment$c", "Lbd3/a;", "", "onDismiss", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends a {
        c() {
        }

        @Override // bd3.a, bd3.c
        public void onDismiss() {
            super.onDismiss();
            RequestPermissionFragment.this.finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    private final void initView() {
        NavBarCommon navBarCommon;
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = this.contentView;
        if (frameLayout2 != null) {
            frameLayout2.setBackgroundColor(this.fullScreenMode ? -1 : 0);
        }
        View view = this.rootView;
        FrameLayout frameLayout3 = null;
        if (view == null || (navBarCommon = (NavBarCommon) view.findViewById(R.id.qy5)) == null) {
            navBarCommon = null;
        } else if (this.fullScreenMode) {
            navBarCommon.setVisibility(0);
            navBarCommon.setTitle(getString(R.string.xds));
            navBarCommon.setLeftBackVisible(0);
            navBarCommon.setOnItemSelectListener(new b());
        } else {
            navBarCommon.setVisibility(8);
        }
        this.navBarView = navBarCommon;
        View view2 = this.rootView;
        if (view2 != null && (frameLayout = (FrameLayout) view2.findViewById(R.id.f163591qy4)) != null) {
            frameLayout.setVisibility(0);
            frameLayout3 = frameLayout;
        }
        this.contentView = frameLayout3;
    }

    private final void qh() {
        TransitPageInfo transitPageInfo;
        if (this.contentView == null) {
            QLog.e("TransitPageFragment", 1, "onActivityCreated, contentView is null");
            finishActivity();
            return;
        }
        if (this.sourceFrom == null || (transitPageInfo = this.transitPageInfo) == null) {
            return;
        }
        IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
        int i3 = this.fullScreenMode ? 3 : 0;
        FrameLayout frameLayout = this.contentView;
        Intrinsics.checkNotNull(frameLayout);
        bd3.b createProfileCommonTips = iZootopiaApi.createProfileCommonTips(i3, frameLayout, transitPageInfo, new c());
        if (createProfileCommonTips != null) {
            createProfileCommonTips.show();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        TransitPageConfig config;
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("transit_source_from") : null;
        this.sourceFrom = serializable instanceof ZootopiaSource ? (ZootopiaSource) serializable : null;
        Bundle arguments2 = getArguments();
        Serializable serializable2 = arguments2 != null ? arguments2.getSerializable("transit_page_info") : null;
        TransitPageInfo transitPageInfo = serializable2 instanceof TransitPageInfo ? (TransitPageInfo) serializable2 : null;
        this.transitPageInfo = transitPageInfo;
        if (this.sourceFrom != null && transitPageInfo != null) {
            this.fullScreenMode = (transitPageInfo == null || (config = transitPageInfo.getConfig()) == null || config.getUiStyle() != 1) ? false : true;
            initView();
            qh();
        } else {
            QLog.e("TransitPageFragment", 1, "onActivityCreated, params err");
            finishActivity();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.d6z, container, false);
        this.rootView = inflate;
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(activity instanceof QBaseActivity ? (QBaseActivity) activity : null);
        if (systemBarComp != null) {
            systemBarComp.setStatusBarColor(0);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/transit/RequestPermissionFragment$b", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.widget.navbar.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View v3, int item) {
            if (item == 1) {
                RequestPermissionFragment.this.finishActivity();
            }
        }
    }
}
