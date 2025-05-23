package com.tencent.mobileqq.wink.qzone.templatelibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibDetailFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.part.WinkQZoneTemplateLibDetailListPart;
import com.tencent.mobileqq.wink.qzone.templatelibrary.part.o;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.wink.schema.d;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, scene = QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_PICKER)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J/\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibDetailFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "initViewModel", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "categoriesData", "qh", "initIntentData", "Landroid/view/View;", "contentView", "sh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "", "enableRootViewSetFitsSystemWindows", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "templateViewModel", "D", "Ljava/lang/String;", "targetTemplateId", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "E", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "currentMaterialCategory", UserInfo.SEX_FEMALE, "Z", "isSchemaJump", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneTemplateLibDetailListPart;", "G", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneTemplateLibDetailListPart;", "detailListPart", "<init>", "()V", "I", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibDetailFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel templateViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String targetTemplateId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MetaCategory currentMaterialCategory;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isSchemaJump;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibDetailListPart detailListPart;

    @NotNull
    public Map<Integer, View> H = new LinkedHashMap();

    private final void initIntentData() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        d dVar = d.f326305a;
        String k3 = dVar.k("target", intent);
        boolean areEqual = Intrinsics.areEqual(k3, "5");
        this.isSchemaJump = areEqual;
        if (areEqual) {
            this.targetTemplateId = dVar.k("libtemplate", intent);
        } else {
            boolean areEqual2 = Intrinsics.areEqual(k3, "20");
            this.isSchemaJump = areEqual2;
            if (areEqual2) {
                this.targetTemplateId = dVar.k("template", intent);
            } else {
                this.currentMaterialCategory = c.f326233a.a((MetaCategory) intent.getSerializableExtra("current_material_category"));
                this.targetTemplateId = intent.getStringExtra("target_template_id");
            }
        }
        b.f("WinkQZoneTemplateLibDetailFragment", "initIntentData targetTemplateId is " + this.targetTemplateId + ", isSchemaJump is " + this.isSchemaJump);
    }

    private final void initViewModel() {
        MutableLiveData<WinkQZoneTemplateLibViewModel.CategoriesData> N1;
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = (WinkQZoneTemplateLibViewModel) getViewModel(WinkQZoneTemplateLibViewModel.class);
        this.templateViewModel = winkQZoneTemplateLibViewModel;
        if (this.isSchemaJump) {
            if (winkQZoneTemplateLibViewModel != null) {
                winkQZoneTemplateLibViewModel.P1(true);
            }
            WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel2 = this.templateViewModel;
            if (winkQZoneTemplateLibViewModel2 != null && (N1 = winkQZoneTemplateLibViewModel2.N1()) != null) {
                N1.observe(getViewLifecycleOwner(), new Observer() { // from class: u93.a
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkQZoneTemplateLibDetailFragment.rh(WinkQZoneTemplateLibDetailFragment.this, (WinkQZoneTemplateLibViewModel.CategoriesData) obj);
                    }
                });
                return;
            }
            return;
        }
        if (winkQZoneTemplateLibViewModel != null) {
            winkQZoneTemplateLibViewModel.Q1(this.targetTemplateId, this.currentMaterialCategory);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r3 == true) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void qh(WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
        MetaCategory metaCategory;
        ArrayList<MetaCategory> arrayList;
        Object obj;
        ArrayList<MetaCategory> arrayList2;
        boolean z16;
        ArrayList<MetaMaterial> materials;
        boolean z17;
        MetaCategory templateCategory = categoriesData.getTemplateCategory();
        if (templateCategory != null && (arrayList2 = templateCategory.subCategories) != null) {
            for (MetaCategory metaCategory2 : arrayList2) {
                if (metaCategory2 != null && (materials = metaCategory2.materials) != null) {
                    Intrinsics.checkNotNullExpressionValue(materials, "materials");
                    z16 = true;
                    if (!materials.isEmpty()) {
                        Iterator<T> it = materials.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((MetaMaterial) it.next()).f30533id, this.targetTemplateId)) {
                                z17 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                }
                z16 = false;
                if (z16) {
                    this.currentMaterialCategory = c.f326233a.a(metaCategory2);
                }
            }
        }
        String str = null;
        if (this.currentMaterialCategory == null) {
            c cVar = c.f326233a;
            MetaCategory templateCategory2 = categoriesData.getTemplateCategory();
            if (templateCategory2 != null && (arrayList = templateCategory2.subCategories) != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "100017")) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                metaCategory = (MetaCategory) obj;
            } else {
                metaCategory = null;
            }
            this.currentMaterialCategory = cVar.a(metaCategory);
            QQToast.makeText(getContext(), R.string.f240887qd, 0).show();
        }
        MetaCategory metaCategory3 = this.currentMaterialCategory;
        if (metaCategory3 != null) {
            str = metaCategory3.name;
        }
        b.f("WinkQZoneTemplateLibDetailFragment", "handleCategoriesData currentMaterialCategory is " + str);
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = this.templateViewModel;
        if (winkQZoneTemplateLibViewModel != null) {
            winkQZoneTemplateLibViewModel.Q1(this.targetTemplateId, this.currentMaterialCategory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(WinkQZoneTemplateLibDetailFragment this$0, WinkQZoneTemplateLibViewModel.CategoriesData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.qh(it);
    }

    private final void sh(View contentView) {
        if (getActivity() == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, WinkDaTongReportConstant.PageId.PG_QZ_MODEL_DETAIL);
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE);
        Intrinsics.checkNotNullExpressionValue(obj, "get(WinkDaTongReportCons\u2026J_IS_FROM_WHICH_ENTRANCE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, obj);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    public void _$_clearFindViewByIdCache() {
        this.H.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        this.detailListPart = new WinkQZoneTemplateLibDetailListPart();
        WinkQZoneTemplateLibDetailListPart winkQZoneTemplateLibDetailListPart = this.detailListPart;
        Intrinsics.checkNotNull(winkQZoneTemplateLibDetailListPart);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new o(), winkQZoneTemplateLibDetailListPart);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i7s;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
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
        WinkQZoneTemplateLibDetailListPart winkQZoneTemplateLibDetailListPart = this.detailListPart;
        if (winkQZoneTemplateLibDetailListPart != null) {
            winkQZoneTemplateLibDetailListPart.I9(requestCode, permissions, grantResults);
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        l.f();
        if (uq3.c.f6()) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).preDownloadAllNonEssentialBundles();
        }
        initIntentData();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        sh(contentView);
    }
}
