package com.tencent.sqshow.zootopia.role.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanUECacheHelper;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleController;
import com.tencent.sqshow.zootopia.samestyle.data.MaterialWrapper;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import n74.ar;
import pu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/sqshow/zootopia/role/fragment/CreateRoleFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "Hh", "Jh", "onCreate", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onDestroyView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "", "getSubSource", "onBackPressedEvent", "Ln74/ar;", "N", "Ln74/ar;", "Ih", "()Ln74/ar;", "Kh", "(Ln74/ar;)V", "mBinding", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "P", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CreateRoleFragment extends ZootopiaBaseFragment {

    /* renamed from: N, reason: from kotlin metadata */
    public ar mBinding;

    /* renamed from: P, reason: from kotlin metadata */
    private CreateRoleController mController;

    private final void Hh(Bundle savedInstanceState) {
        TextView textView = Ih().A;
        ViewGroup.LayoutParams layoutParams = Ih().A.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = null;
        } else if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = Bh() + i.b(20);
        }
        textView.setLayoutParams(layoutParams);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.mController = new CreateRoleController(activity, Ih(), Ch());
        }
        QLog.d("CreateRoleFragment", 1, "bindView ==> " + savedInstanceState);
        QLog.d("CreateRoleFragment", 1, "saveInstanceStatus => step = " + (savedInstanceState != null ? Integer.valueOf(savedInstanceState.getInt("create_role_step")) : null));
        CreateRoleController createRoleController = this.mController;
        if (createRoleController != null) {
            createRoleController.A();
        }
    }

    private final void Jh() {
        if (FilamentApiImpl.f369933a.d()) {
            return;
        }
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).zootopiaServiceManagerStartZPlanService();
        ((IZPlanUECacheHelper) QRoute.api(IZPlanUECacheHelper.class)).refreshCache();
    }

    public final ar Ih() {
        ar arVar = this.mBinding;
        if (arVar != null) {
            return arVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        return null;
    }

    public final void Kh(ar arVar) {
        Intrinsics.checkNotNullParameter(arVar, "<set-?>");
        this.mBinding = arVar;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    protected String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_CREATE_ROLE;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        CreateRoleController createRoleController = this.mController;
        if (createRoleController != null) {
            return createRoleController.O();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Window window;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        r.c(window);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ar g16 = ar.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        Kh(g16);
        Hh(savedInstanceState);
        ConstraintLayout constraintLayout = Ih().f418709t;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.root");
        return constraintLayout;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        CreateRoleController createRoleController = this.mController;
        if (createRoleController != null) {
            createRoleController.g();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        g i3;
        g k3;
        Intrinsics.checkNotNullParameter(outState, "outState");
        CreateRoleController createRoleController = this.mController;
        outState.putInt("create_role_step", createRoleController != null ? createRoleController.getMStep() : 0);
        CreateRoleController createRoleController2 = this.mController;
        if (createRoleController2 != null && (k3 = createRoleController2.k()) != null) {
            outState.putSerializable("create_role_head", MaterialWrapper.INSTANCE.b(k3));
        }
        CreateRoleController createRoleController3 = this.mController;
        if (createRoleController3 != null && (i3 = createRoleController3.i()) != null) {
            outState.putSerializable("create_role_avatar", MaterialWrapper.INSTANCE.b(i3));
        }
        QLog.d("CreateRoleFragment", 1, "save => bundle " + outState);
        super.onSaveInstanceState(outState);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ag.f373258a.f(Ch());
        QLog.d("CreateRoleFragment", 1, "onViewCreated text " + ah.b(Ch()));
        Jh();
    }
}
