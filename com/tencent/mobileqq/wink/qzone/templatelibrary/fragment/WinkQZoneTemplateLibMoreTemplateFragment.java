package com.tencent.mobileqq.wink.qzone.templatelibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibMoreTemplateFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.part.WinkQZoneMoreTemplateCategoryPart;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, scene = QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_PICKER)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b1\u00102B\u001d\b\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010!\u0012\b\u0010(\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b1\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J/\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010\u001e\u001a\u00020\bH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibMoreTemplateFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Landroid/view/View;", "view", "", "initView", "contentView", "rh", "", "getContentLayoutId", "", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "quit", "getStatusBarColor", "", "enableRootViewSetFitsSystemWindows", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "categoriesData", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "D", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "targetPositionMaterial", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneMoreTemplateCategoryPart;", "E", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneMoreTemplateCategoryPart;", "categoryPart", "Landroidx/fragment/app/Fragment;", UserInfo.SEX_FEMALE, "Landroidx/fragment/app/Fragment;", "magicStudioLogicFragment", "<init>", "()V", "(Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibMoreTemplateFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel.CategoriesData categoriesData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial targetPositionMaterial;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneMoreTemplateCategoryPart categoryPart;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Fragment magicStudioLogicFragment;

    @NotNull
    public Map<Integer, View> G;

    public WinkQZoneTemplateLibMoreTemplateFragment() {
        this.G = new LinkedHashMap();
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.az7);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: u93.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkQZoneTemplateLibMoreTemplateFragment.qh(WinkQZoneTemplateLibMoreTemplateFragment.this, view2);
                }
            });
        }
        this.magicStudioLogicFragment = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAIGCLogicFragment(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(WinkQZoneTemplateLibMoreTemplateFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.quit();
        e eVar = e.f326265a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        e.m(eVar, it, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void rh(View contentView) {
        if (getActivity() == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_QZ_CLASSIFY_GROUP);
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE);
        Intrinsics.checkNotNullExpressionValue(obj, "get(WinkDaTongReportCons\u2026J_IS_FROM_WHICH_ENTRANCE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, obj);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    public void _$_clearFindViewByIdCache() {
        this.G.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> listOf;
        WinkQZoneMoreTemplateCategoryPart winkQZoneMoreTemplateCategoryPart = new WinkQZoneMoreTemplateCategoryPart(this.categoriesData, this.targetPositionMaterial);
        this.categoryPart = winkQZoneMoreTemplateCategoryPart;
        Intrinsics.checkNotNull(winkQZoneMoreTemplateCategoryPart);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(winkQZoneMoreTemplateCategoryPart);
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i7n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkQZoneTemplateLibMoreTemplateFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = this.magicStudioLogicFragment;
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        WinkQZoneMoreTemplateCategoryPart winkQZoneMoreTemplateCategoryPart = this.categoryPart;
        if (winkQZoneMoreTemplateCategoryPart != null) {
            winkQZoneMoreTemplateCategoryPart.G9(requestCode, permissions, grantResults);
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        rh(view);
        if (ImmersiveUtils.isSupportImmersive()) {
            view.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
    }

    public final void quit() {
        try {
            WinkQZoneMoreTemplateCategoryPart winkQZoneMoreTemplateCategoryPart = this.categoryPart;
            boolean z16 = false;
            if (winkQZoneMoreTemplateCategoryPart != null && winkQZoneMoreTemplateCategoryPart.H9()) {
                z16 = true;
            }
            if (z16) {
                getParentFragmentManager().popBackStack();
            }
        } catch (Throwable th5) {
            b.e("WinkQZoneTemplateLibMoreTemplateFragment", th5);
        }
    }

    public WinkQZoneTemplateLibMoreTemplateFragment(@Nullable WinkQZoneTemplateLibViewModel.CategoriesData categoriesData, @Nullable MetaMaterial metaMaterial) {
        this();
        this.categoriesData = categoriesData;
        this.targetPositionMaterial = metaMaterial;
    }
}
