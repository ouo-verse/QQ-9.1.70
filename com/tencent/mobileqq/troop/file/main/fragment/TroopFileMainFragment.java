package com.tencent.mobileqq.troop.file.main.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.j;
import com.tencent.mobileqq.filemanager.app.k;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.troop.file.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.file.data.d;
import com.tencent.mobileqq.troop.file.data.r;
import com.tencent.mobileqq.troop.file.main.part.TroopFileMainActionBottomPart;
import com.tencent.mobileqq.troop.file.main.part.TroopFileMainContentPart;
import com.tencent.mobileqq.troop.file.main.part.TroopFileMainFileUploadPart;
import com.tencent.mobileqq.troop.file.main.part.TroopFileMainFolderOperatePart;
import com.tencent.mobileqq.troop.file.main.part.TroopFileMainGuidePart;
import com.tencent.mobileqq.troop.file.main.part.TroopFileMainTitlePart;
import com.tencent.mobileqq.troop.file.main.part.w;
import com.tencent.mobileqq.troop.file.main.part.x;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_FILE, scene = QQPermissionConstants.Business.SCENE.QQ_FILE_TROOP_FILE_LIST)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016R#\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\n \u001f*\u0004\u0018\u00010-0-8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/fragment/TroopFileMainFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "rh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onDestroyView", DKHippyEvent.EVENT_STOP, "", "isWrapContent", "Landroid/content/Intent;", "intent", "onNewIntent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "qh", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "Lcom/tencent/mobileqq/filemanager/app/j;", "D", "Lcom/tencent/mobileqq/filemanager/app/j;", "troopDocsQIPCModuleListener", "Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;", "E", "Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;", "errorHandlerObserver", "Lcom/tencent/mobileqq/app/QQAppInterface;", "ph", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private j troopDocsQIPCModuleListener;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopFileError.d errorHandlerObserver;

    public TroopFileMainFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileMainVM>() { // from class: com.tencent.mobileqq.troop.file.main.fragment.TroopFileMainFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileMainVM invoke() {
                TroopFileMainVM troopFileMainVM = (TroopFileMainVM) TroopFileMainFragment.this.getViewModel(TroopFileMainVM.class);
                Bundle requireArguments = TroopFileMainFragment.this.requireArguments();
                Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
                troopFileMainVM.init(requireArguments);
                return troopFileMainVM;
            }
        });
        this.viewModel = lazy;
    }

    private final QQAppInterface ph() {
        return TroopUtils.f();
    }

    private final TroopFileMainVM qh() {
        return (TroopFileMainVM) this.viewModel.getValue();
    }

    private final void rh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j3 = arguments.getLong("key_page_start_time", 0L);
            if (j3 <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleWeakNetReporter.KEY_COST, Long.valueOf(SystemClock.uptimeMillis() - j3));
            hashMap.put("from", Integer.valueOf(requireArguments().getInt(ISelectMemberActivityConstants.PARAM_FROM)));
            if (QLog.isDebugVersion()) {
                QLog.d("TroopFile.Main.TroopFileMainFragment", 4, "start page cost:" + (SystemClock.uptimeMillis() - j3));
            }
            ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("start_troop_file_page_end_event", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ai7;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity instanceof QBaseActivity) {
            ((QBaseActivity) activity).overridePendingTransition(R.anim.f154427o, R.anim.f154429q);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        if (savedInstanceState == null) {
            rh();
        }
        new r(TroopUtils.f(), getActivity(), qh().T1().troopUinStr).b(false, this);
        this.troopDocsQIPCModuleListener = new j(getActivity(), true);
        k c16 = k.c();
        j jVar = this.troopDocsQIPCModuleListener;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopDocsQIPCModuleListener");
            jVar = null;
        }
        c16.b(jVar);
        this.errorHandlerObserver = new TroopFileError.d(getActivity(), qh().T1().troopUinL, ph());
        d.i(getActivity(), qh().T1().troopUinStr);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        TroopFileSearchManager.g().j();
        k c16 = k.c();
        j jVar = this.troopDocsQIPCModuleListener;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopDocsQIPCModuleListener");
            jVar = null;
        }
        c16.d(jVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QQAppInterface ph5 = ph();
        TroopFileError.d dVar = this.errorHandlerObserver;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorHandlerObserver");
            dVar = null;
        }
        TroopFileError.f(ph5, dVar);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        qh().onResume();
        QQAppInterface ph5 = ph();
        TroopFileError.d dVar = this.errorHandlerObserver;
        TroopFileError.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorHandlerObserver");
            dVar = null;
        }
        if (ph5.containObserver(dVar, false)) {
            return;
        }
        QQAppInterface ph6 = ph();
        TroopFileError.d dVar3 = this.errorHandlerObserver;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorHandlerObserver");
        } else {
            dVar2 = dVar3;
        }
        TroopFileError.a(ph6, dVar2);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        RollangleImageView.a.f().c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (QLog.isColorLevel()) {
            QLog.i("TroopFile.Main.TroopFileMainFragment", 2, "onViewCreated.");
        }
        if (NetworkUtil.isNetworkAvailable(getActivity())) {
            return;
        }
        TroopFileUtils.F(ph(), qh().T1().troopUinL);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        TroopFileMainVM viewModel = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        TroopFileMainVM viewModel2 = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel2, "viewModel");
        TroopFileMainVM viewModel3 = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel3, "viewModel");
        TroopFileMainVM viewModel4 = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel4, "viewModel");
        TroopFileMainVM viewModel5 = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel5, "viewModel");
        TroopFileMainVM viewModel6 = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel6, "viewModel");
        TroopFileMainVM viewModel7 = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel7, "viewModel");
        TroopFileMainVM viewModel8 = qh();
        Intrinsics.checkNotNullExpressionValue(viewModel8, "viewModel");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopFileMainTitlePart(viewModel), new TroopFileMainContentPart(viewModel2), new TroopFileMainActionBottomPart(viewModel3), new TroopFileMainGuidePart(viewModel4), new x(viewModel5), new w(viewModel6), new TroopFileMainFileUploadPart(viewModel7), new TroopFileMainFolderOperatePart(viewModel8));
        return mutableListOf;
    }
}
