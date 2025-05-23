package com.tencent.mobileqq.zplan.avatar.impl.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.scene.data.SceneComponentType;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.ZPlanUEController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.avatar.EngineLoadingScene;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarMallLoadingComponent;
import com.tencent.sqshow.zootopia.nativeui.ue.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.r;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import fi3.cb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import pd3.a;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\b \u0010!J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0014J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0014J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\u0010\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\u0004H\u0016J\b\u00109\u001a\u00020\u0004H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010G\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanUEWithHippyFragment;", "Lcom/tencent/mobileqq/zootopia/scene/fragment/base/BaseAvatarWithLoadingFragment;", "Lpd3/b;", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/a;", "", "xi", "wi", "Lfi3/cb;", "binding", "si", "Landroid/widget/FrameLayout;", "hippyContainer", "pi", "ri", ParseCommon.CONTAINER, "qi", "oi", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "Landroid/view/View;", "onCreateView", "", "rh", "", "di", "", "bi", "()Ljava/lang/Integer;", "fi", "()Ljava/lang/Boolean;", "getPageId", "getSubSource", "onBackPressedEvent", "w0", "Bb", "U", "Xh", "success", "engineInitFinish", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "engineDestroy", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "M2", "", "xh", "beforeFinish", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Eh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/b;", "w6", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/f;", "W", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/f;", "mSceneParser", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/ZPlanUEController;", "X", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/ZPlanUEController;", "mUEController", "Y", "Lfi3/cb;", "mBinding", "Z", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/b;", "mAvatarPanelHelper", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/c;", "a0", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/c;", "mHippyController", "Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarMallLoadingComponent;", "b0", "Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarMallLoadingComponent;", "mLoadingComp", "Ljf3/f;", "c0", "Ljf3/f;", "mAvatarComp", "d0", "mLoadingShowing", "<init>", "()V", "e0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEWithHippyFragment extends BaseAvatarWithLoadingFragment implements pd3.b, a {

    /* renamed from: W, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.f mSceneParser = new com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.f();

    /* renamed from: X, reason: from kotlin metadata */
    private final ZPlanUEController mUEController = new ZPlanUEController();

    /* renamed from: Y, reason: from kotlin metadata */
    private cb mBinding;

    /* renamed from: Z, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b mAvatarPanelHelper;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.c mHippyController;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private AvatarMallLoadingComponent mLoadingComp;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private jf3.f mAvatarComp;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean mLoadingShowing;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanUEWithHippyFragment$b", "Lpd3/a;", "", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "", "b", "(Ljava/lang/Integer;I)V", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements pd3.a {
        b() {
        }

        @Override // pd3.a
        public void a(FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SceneInfo M2 = ZPlanUEWithHippyFragment.this.M2();
            boolean m3 = M2.m(SceneInfo.INSTANCE.b(result.getParams()));
            QLog.i("ZPlanUEWithHippyFragment_", 1, "onSceneFirstFrame isSame:" + m3 + ", self:" + M2 + ", result:" + result);
            if (m3) {
                com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = ZPlanUEWithHippyFragment.this.mAvatarPanelHelper;
                if (bVar != null) {
                    bVar.onFirstFrame(result);
                }
                ZPlanUEWithHippyFragment.this.hideLoadingView();
            }
        }

        @Override // pd3.a
        public void b(Integer old, int r36) {
            if (((we3.a) k74.i.INSTANCE.a(we3.a.class)).needLoading(r36)) {
                QLog.i("ZPlanUEWithHippyFragment_", 1, "onSceneChange needLoading true , loading showing");
                ZPlanUEWithHippyFragment.this.showLoadingView();
            }
        }

        @Override // pd3.a
        public void c() {
            a.C11005a.a(this);
        }
    }

    private final void oi(FrameLayout container) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        jf3.f fVar = new jf3.f();
        this.mAvatarComp = fVar;
        Kh(SceneComponentType.TYPE_AVATAR, fVar);
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.mAvatarPanelHelper;
        if (bVar != null) {
            bVar.q(fVar);
        }
        fVar.gh(this);
        fVar.B6(this);
        fVar.W7(this);
        fVar.Qf(new b());
        fVar.j(activity, this, this, container);
        this.mUEController.m(Bh(), container);
    }

    private final void pi(FrameLayout hippyContainer) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.c cVar = new com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.c(childFragmentManager, hippyContainer);
        cVar.b(getArguments(), this);
        this.mHippyController = cVar;
    }

    private final void qi(FrameLayout container) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        AvatarMallLoadingComponent avatarMallLoadingComponent = new AvatarMallLoadingComponent(6, "SUB_AVATAR", null, 4, null);
        this.mLoadingComp = avatarMallLoadingComponent;
        Kh(SceneComponentType.TYPE_AVATAR_LOADING, avatarMallLoadingComponent);
        avatarMallLoadingComponent.a0(Ch());
        avatarMallLoadingComponent.j(activity, this, this, container);
        if (!((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady()) {
            avatarMallLoadingComponent.show();
        }
        avatarMallLoadingComponent.b0(this);
        Bundle arguments = getArguments();
        if (arguments != null ? arguments.getBoolean("NeedLoading", false) : false) {
            cb cbVar = this.mBinding;
            FrameLayout root = cbVar != null ? cbVar.getRoot() : null;
            if (root != null) {
                root.setBackground(new ColorDrawable(-1));
            }
            showLoadingView();
        }
    }

    private final void ri(cb binding) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        SceneInfo M2 = M2();
        FrameLayout frameLayout = binding.f399227b;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.avatarContainer");
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = new com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b(activity, null, frameLayout, Ch(), false, false, 48, null);
        this.mAvatarPanelHelper = bVar;
        bVar.l(M2, aa.f371327d, true, true);
    }

    private final void si(final cb binding) {
        binding.f399228c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanUEWithHippyFragment.ti(view);
            }
        });
        ri(binding);
        FrameLayout frameLayout = binding.f399230e;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        qi(frameLayout);
        FrameLayout frameLayout2 = binding.f399227b;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.avatarContainer");
        oi(frameLayout2);
        binding.getRoot().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.n
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUEWithHippyFragment.ui(cb.this);
            }
        });
        FragmentActivity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            com.tencent.sqshow.zootopia.utils.a.a(qBaseActivity);
            r.c(qBaseActivity.getWindow());
        }
        FrameLayout frameLayout3 = binding.f399229d;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.hippyContainer");
        pi(frameLayout3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(cb binding) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        com.tencent.sqshow.zootopia.avatar.f.f369932a.b().b(binding.getRoot().getWidth(), binding.getRoot().getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(ZPlanUEWithHippyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanUEController zPlanUEController = this$0.mUEController;
        int Bh = this$0.Bh();
        cb cbVar = this$0.mBinding;
        zPlanUEController.m(Bh, cbVar != null ? cbVar.f399227b : null);
    }

    private final void wi() {
        Bitmap v46;
        cb cbVar;
        ImageView imageView;
        jf3.f fVar = this.mAvatarComp;
        if (fVar == null || (v46 = fVar.v4()) == null || (cbVar = this.mBinding) == null || (imageView = cbVar.f399228c) == null) {
            return;
        }
        imageView.setImageBitmap(v46);
    }

    private final void xi() {
        wi();
        ((xe3.a) vb3.a.f441346a.b(xe3.a.class)).k0(M2());
        this.mUEController.l();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public void Eh() {
        super.Eh();
        this.mUEController.g();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, od3.a
    public SceneInfo M2() {
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.f fVar = this.mSceneParser;
        String b16 = ah.b(Ch());
        Bundle arguments = getArguments();
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.mAvatarPanelHelper;
        return fVar.a(b16, arguments, intent, bVar != null ? bVar.getCameraId() : null);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        try {
            xi();
        } catch (Exception e16) {
            QLog.e("ZPlanUEWithHippyFragment_", 1, "beforeFinish error", e16);
        }
        super.beforeFinish();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public Integer bi() {
        return Integer.valueOf(this.mSceneParser.getCurrentViewType());
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public String di() {
        return EngineLoadingScene.UE_HIPPY;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        this.mUEController.c();
        super.engineDestroy();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        this.mUEController.d(success);
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.mAvatarPanelHelper;
        if (bVar != null) {
            bVar.engineInitFinish(success);
        }
        super.engineInitFinish(success);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public Boolean fi() {
        return Boolean.FALSE;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public String getPageId() {
        return "ZPlanUEWithHippyFragment";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return "ZPlanUEWithHippyFragment_";
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.i("ZPlanUEWithHippyFragment_", 1, "onConfigurationChanged ");
        this.mUEController.h(newConfig);
        ZPlanUEController zPlanUEController = this.mUEController;
        int Bh = Bh();
        cb cbVar = this.mBinding;
        zPlanUEController.m(Bh, cbVar != null ? cbVar.f399227b : null);
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.f fVar = this.mSceneParser;
        Bundle arguments = getArguments();
        FragmentActivity activity = getActivity();
        fVar.c(arguments, activity != null ? activity.getIntent() : null);
        this.mUEController.f(Ch(), getActivity(), this.mSceneParser);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        cb g16 = cb.g(inflater);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
        this.mBinding = g16;
        si(g16);
        FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("ZPlanUEWithHippyFragment_", 1, "onDestroy :: getCurrentViewType() == " + bi());
        this.mUEController.i();
        qe3.a.f428883a.b();
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.mAvatarPanelHelper;
        if (bVar != null) {
            bVar.destroy();
        }
        jf3.f fVar = this.mAvatarComp;
        if (fVar != null) {
            fVar.destroy();
        }
        this.mAvatarComp = null;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mUEController.j();
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ZPlanUEController zPlanUEController = this.mUEController;
        int Bh = Bh();
        cb cbVar = this.mBinding;
        zPlanUEController.m(Bh, cbVar != null ? cbVar.f399227b : null);
        this.mUEController.k();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            qe3.a.d(qe3.a.f428883a, activity, null, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment
    protected boolean rh() {
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment, com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarFragment, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        this.mUEController.o(connect);
        com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b bVar = this.mAvatarPanelHelper;
        if (bVar != null) {
            bVar.serviceConnected(connect);
        }
        if (connect) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.impl.fragment.l
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUEWithHippyFragment.vi(ZPlanUEWithHippyFragment.this);
                }
            });
        }
        super.serviceConnected(connect);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.impl.fragment.a
    /* renamed from: w6, reason: from getter */
    public com.tencent.mobileqq.zplan.avatar.impl.fragment.helper.b getMAvatarPanelHelper() {
        return this.mAvatarPanelHelper;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public long xh() {
        return 250L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(View view) {
        QLog.i("ZPlanUEWithHippyFragment_", 1, "clicked backgroundIgv");
    }

    @Override // pd3.b
    public void U() {
        this.mLoadingShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zootopia.scene.fragment.base.BaseAvatarWithLoadingFragment
    public void Xh() {
        QLog.i("ZPlanUEWithHippyFragment_", 1, "checkIfNeedLoading ");
        if (((we3.a) k74.i.INSTANCE.a(we3.a.class)).needLoading(M2().getSceneType())) {
            super.Xh();
        }
    }

    @Override // pd3.b
    public void w0() {
        this.mLoadingShowing = true;
    }

    @Override // pd3.b
    public void Bb() {
    }
}
