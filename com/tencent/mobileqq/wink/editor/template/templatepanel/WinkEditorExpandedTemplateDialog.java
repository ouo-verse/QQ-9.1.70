package com.tencent.mobileqq.wink.editor.template.templatepanel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.template.g;
import com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorExpandedTemplateDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 92\u00020\u0001:\u0003:;<B\u0007\u00a2\u0006\u0004\b6\u00107B\u0019\b\u0016\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\b6\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006Jb\u0010&\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001c2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010%\u001a\u00020\tJ\b\u0010'\u001a\u00020\u0004H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "", "needDismissCallback", "vh", "", "uh", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onStart", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "checked", "Ah", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "materialCategories", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "favouriteMaterials", "recommendMaterials", "categoryMaterials", "selectedMaterial", "allTypeCategories", "categoryDividerIndex", "Bh", "onDestroyView", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$c;", "initConfig", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$a;", "D", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$a;", "clickListener", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplatePanel;", "E", "Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplatePanel;", "templatePanel", UserInfo.SEX_FEMALE, "Z", "<init>", "()V", "(Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$c;Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$a;)V", "H", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorExpandedTemplateDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private c initConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private a clickListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WinkEditorExpandedTemplatePanel templatePanel;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean needDismissCallback;

    @NotNull
    public Map<Integer, View> G;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "firstShowMaterial", "", "d", "editableMaterial", "b", "selectedMaterial", "e", "Landroid/view/View;", "view", "a", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NotNull View view);

        void b(@Nullable MetaMaterial editableMaterial);

        void c(@Nullable MetaMaterial firstShowMaterial, @Nullable MetaMaterial selectedMaterial);

        void d(@Nullable MetaMaterial firstShowMaterial);

        void e(@Nullable MetaMaterial selectedMaterial);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\t\u0012\u0006\u0010!\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020\"\u00a2\u0006\u0004\b'\u0010(R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u0012\u0010\u001dR\u0019\u0010 \u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010!\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010%\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b\u000f\u0010$R\u0017\u0010&\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b\u0004\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$c;", "", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "a", "Ljava/util/List;", "f", "()Ljava/util/List;", "materialCategories", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "c", "favouriteMaterials", h.F, "recommendMaterials", "d", "categoryMaterials", "", "e", "Z", "j", "()Z", "isClearButtonEnabled", "k", "isFilterButtonChecked", "g", "l", "isFilterButtonRedDotShow", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "firstShowMaterial", "i", "selectedMaterial", "needShowEditableOverlay", "", "I", "()I", "filterButtonVisibility", "categoryDividerIndex", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZLcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;ZII)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<MetaCategory> materialCategories;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<MetaMaterial> favouriteMaterials;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<MetaMaterial> recommendMaterials;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<MetaMaterial> categoryMaterials;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isClearButtonEnabled;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isFilterButtonChecked;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final boolean isFilterButtonRedDotShow;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MetaMaterial firstShowMaterial;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MetaMaterial selectedMaterial;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private final boolean needShowEditableOverlay;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final int filterButtonVisibility;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private final int categoryDividerIndex;

        public c(@Nullable List<MetaCategory> list, @Nullable List<MetaMaterial> list2, @Nullable List<MetaMaterial> list3, @NotNull List<MetaMaterial> categoryMaterials, boolean z16, boolean z17, boolean z18, @Nullable MetaMaterial metaMaterial, @Nullable MetaMaterial metaMaterial2, boolean z19, int i3, int i16) {
            Intrinsics.checkNotNullParameter(categoryMaterials, "categoryMaterials");
            this.materialCategories = list;
            this.favouriteMaterials = list2;
            this.recommendMaterials = list3;
            this.categoryMaterials = categoryMaterials;
            this.isClearButtonEnabled = z16;
            this.isFilterButtonChecked = z17;
            this.isFilterButtonRedDotShow = z18;
            this.firstShowMaterial = metaMaterial;
            this.selectedMaterial = metaMaterial2;
            this.needShowEditableOverlay = z19;
            this.filterButtonVisibility = i3;
            this.categoryDividerIndex = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getCategoryDividerIndex() {
            return this.categoryDividerIndex;
        }

        @NotNull
        public final List<MetaMaterial> b() {
            return this.categoryMaterials;
        }

        @Nullable
        public final List<MetaMaterial> c() {
            return this.favouriteMaterials;
        }

        /* renamed from: d, reason: from getter */
        public final int getFilterButtonVisibility() {
            return this.filterButtonVisibility;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final MetaMaterial getFirstShowMaterial() {
            return this.firstShowMaterial;
        }

        @Nullable
        public final List<MetaCategory> f() {
            return this.materialCategories;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getNeedShowEditableOverlay() {
            return this.needShowEditableOverlay;
        }

        @Nullable
        public final List<MetaMaterial> h() {
            return this.recommendMaterials;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final MetaMaterial getSelectedMaterial() {
            return this.selectedMaterial;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsClearButtonEnabled() {
            return this.isClearButtonEnabled;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getIsFilterButtonChecked() {
            return this.isFilterButtonChecked;
        }

        /* renamed from: l, reason: from getter */
        public final boolean getIsFilterButtonRedDotShow() {
            return this.isFilterButtonRedDotShow;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/template/templatepanel/WinkEditorExpandedTemplateDialog$d", "Lcom/tencent/mobileqq/wink/editor/template/g$a;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements g.a {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.e
        public void a(int position, @Nullable MetaMaterial material) {
            a aVar = WinkEditorExpandedTemplateDialog.this.clickListener;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clickListener");
                aVar = null;
            }
            aVar.e(material);
            WinkEditorExpandedTemplateDialog.this.vh(false);
        }

        @Override // com.tencent.mobileqq.wink.editor.template.g.a
        public void b(int position, @Nullable MetaMaterial material) {
            a aVar = WinkEditorExpandedTemplateDialog.this.clickListener;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clickListener");
                aVar = null;
            }
            aVar.b(material);
            WinkEditorExpandedTemplateDialog.this.vh(false);
        }
    }

    public WinkEditorExpandedTemplateDialog() {
        this.G = new LinkedHashMap();
        this.needDismissCallback = true;
    }

    private final void initView(View rootView) {
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel;
        if (this.initConfig == null) {
            vh(false);
            return;
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel2 = (WinkEditorExpandedTemplatePanel) rootView.findViewById(R.id.f93905au);
        this.templatePanel = winkEditorExpandedTemplatePanel2;
        if (winkEditorExpandedTemplatePanel2 != null) {
            winkEditorExpandedTemplatePanel2.setOnExpandBtnClickListener(new View.OnClickListener() { // from class: q73.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorExpandedTemplateDialog.xh(WinkEditorExpandedTemplateDialog.this, view);
                }
            });
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel3 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel3 != null) {
            winkEditorExpandedTemplatePanel3.setOnClearButtonClickListener(new View.OnClickListener() { // from class: q73.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorExpandedTemplateDialog.yh(WinkEditorExpandedTemplateDialog.this, view);
                }
            });
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel4 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel4 != null) {
            winkEditorExpandedTemplatePanel4.setContentItemSelectListener(new d());
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel5 = this.templatePanel;
        c cVar = null;
        if (winkEditorExpandedTemplatePanel5 != null) {
            c cVar2 = this.initConfig;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar2 = null;
            }
            List<MetaCategory> f16 = cVar2.f();
            c cVar3 = this.initConfig;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar3 = null;
            }
            List<MetaMaterial> c16 = cVar3.c();
            c cVar4 = this.initConfig;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar4 = null;
            }
            List<MetaMaterial> h16 = cVar4.h();
            c cVar5 = this.initConfig;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar5 = null;
            }
            List<MetaMaterial> b16 = cVar5.b();
            c cVar6 = this.initConfig;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar6 = null;
            }
            winkEditorExpandedTemplatePanel5.setData(f16, c16, h16, b16, cVar6.getCategoryDividerIndex());
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel6 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel6 != null) {
            c cVar7 = this.initConfig;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar7 = null;
            }
            winkEditorExpandedTemplatePanel6.setClearButtonEnable(cVar7.getIsClearButtonEnabled());
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel7 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel7 != null) {
            c cVar8 = this.initConfig;
            if (cVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar8 = null;
            }
            winkEditorExpandedTemplatePanel7.setFilterButtonChecked(cVar8.getIsFilterButtonChecked());
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel8 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel8 != null) {
            c cVar9 = this.initConfig;
            if (cVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar9 = null;
            }
            winkEditorExpandedTemplatePanel8.w(cVar9.getIsFilterButtonRedDotShow());
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel9 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel9 != null) {
            c cVar10 = this.initConfig;
            if (cVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar10 = null;
            }
            winkEditorExpandedTemplatePanel9.H(cVar10.getFirstShowMaterial());
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel10 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel10 != null) {
            c cVar11 = this.initConfig;
            if (cVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar11 = null;
            }
            winkEditorExpandedTemplatePanel10.setFilterBtnVisibility(cVar11.getFilterButtonVisibility());
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel11 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel11 != null) {
            c cVar12 = this.initConfig;
            if (cVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar12 = null;
            }
            winkEditorExpandedTemplatePanel11.setSelectedMaterial(cVar12.getSelectedMaterial());
        }
        c cVar13 = this.initConfig;
        if (cVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initConfig");
            cVar13 = null;
        }
        if (cVar13.getNeedShowEditableOverlay()) {
            c cVar14 = this.initConfig;
            if (cVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                cVar14 = null;
            }
            if (cVar14.getSelectedMaterial() != null && (winkEditorExpandedTemplatePanel = this.templatePanel) != null) {
                c cVar15 = this.initConfig;
                if (cVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("initConfig");
                } else {
                    cVar = cVar15;
                }
                winkEditorExpandedTemplatePanel.setEditableOverlay(cVar.getSelectedMaterial());
            }
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel12 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel12 != null) {
            winkEditorExpandedTemplatePanel12.setOnFilterBtnClickListener(new View.OnClickListener() { // from class: q73.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorExpandedTemplateDialog.zh(WinkEditorExpandedTemplateDialog.this, view);
                }
            });
        }
    }

    private final int uh() {
        int roundToInt;
        int dpToPx = ImmersiveUtils.dpToPx(169.0f);
        int screenHeight = ImmersiveUtils.getScreenHeight();
        roundToInt = MathKt__MathJVMKt.roundToInt(ImmersiveUtils.getScreenHeight() * 0.76d);
        if (screenHeight - roundToInt < dpToPx) {
            roundToInt = MathKt__MathJVMKt.roundToInt(ImmersiveUtils.getScreenHeight() * 0.7d);
        }
        int i3 = screenHeight - roundToInt;
        if (i3 < dpToPx) {
            return i3;
        }
        return roundToInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh(boolean needDismissCallback) {
        this.needDismissCallback = needDismissCallback;
        dismiss();
    }

    private final void wh(View rootView) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(rootView, WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setPageParams(rootView, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
        VideoReport.ignorePageInOutEvent(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(WinkEditorExpandedTemplateDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vh(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(WinkEditorExpandedTemplateDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.clickListener;
        MetaMaterial metaMaterial = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickListener");
            aVar = null;
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = this$0.templatePanel;
        if (winkEditorExpandedTemplatePanel != null) {
            metaMaterial = winkEditorExpandedTemplatePanel.C();
        }
        aVar.d(metaMaterial);
        this$0.vh(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(WinkEditorExpandedTemplateDialog this$0, View view) {
        ImageView e16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = this$0.templatePanel;
        if (winkEditorExpandedTemplatePanel != null) {
            winkEditorExpandedTemplatePanel.w(false);
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel2 = this$0.templatePanel;
        if (winkEditorExpandedTemplatePanel2 != null && (e16 = winkEditorExpandedTemplatePanel2.e()) != null) {
            a aVar = this$0.clickListener;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clickListener");
                aVar = null;
            }
            aVar.a(e16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void Ah(boolean checked) {
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = this.templatePanel;
        if (winkEditorExpandedTemplatePanel != null) {
            winkEditorExpandedTemplatePanel.setFilterButtonChecked(checked);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Bh(@NotNull List<MetaCategory> materialCategories, @Nullable List<MetaMaterial> favouriteMaterials, @Nullable List<MetaMaterial> recommendMaterials, @NotNull List<MetaMaterial> categoryMaterials, @Nullable MetaMaterial selectedMaterial, @NotNull List<MetaCategory> allTypeCategories, int categoryDividerIndex) {
        String str;
        Object obj;
        List<MetaMaterial> E;
        Object lastOrNull;
        Object obj2;
        List<MetaMaterial> E2;
        List<MetaMaterial> E3;
        Intrinsics.checkNotNullParameter(materialCategories, "materialCategories");
        Intrinsics.checkNotNullParameter(categoryMaterials, "categoryMaterials");
        Intrinsics.checkNotNullParameter(allTypeCategories, "allTypeCategories");
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = this.templatePanel;
        MetaMaterial metaMaterial = null;
        if (winkEditorExpandedTemplatePanel != null) {
            str = winkEditorExpandedTemplatePanel.F();
        } else {
            str = null;
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel2 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel2 != null) {
            winkEditorExpandedTemplatePanel2.setData(materialCategories, favouriteMaterials, recommendMaterials, categoryMaterials, categoryDividerIndex);
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel3 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel3 != null) {
            winkEditorExpandedTemplatePanel3.setSelectedMaterial(selectedMaterial);
        }
        List<MetaCategory> list = materialCategories;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((MetaCategory) obj) != null) {
            WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel4 = this.templatePanel;
            if (winkEditorExpandedTemplatePanel4 != null && (E3 = winkEditorExpandedTemplatePanel4.E()) != null) {
                Iterator<T> it5 = E3.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o((MetaMaterial) next), str)) {
                        metaMaterial = next;
                        break;
                    }
                }
                metaMaterial = metaMaterial;
            }
            WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel5 = this.templatePanel;
            if (winkEditorExpandedTemplatePanel5 != null) {
                winkEditorExpandedTemplatePanel5.H(metaMaterial);
                return;
            }
            return;
        }
        boolean z16 = false;
        for (MetaCategory metaCategory : allTypeCategories) {
            if (z16) {
                Iterator<T> it6 = list.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        obj2 = it6.next();
                        if (Intrinsics.areEqual(((MetaCategory) obj2).f30532id, metaCategory.f30532id)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                if (((MetaCategory) obj2) != null) {
                    WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel6 = this.templatePanel;
                    if (winkEditorExpandedTemplatePanel6 != null && (E2 = winkEditorExpandedTemplatePanel6.E()) != null) {
                        Iterator<T> it7 = E2.iterator();
                        while (true) {
                            if (!it7.hasNext()) {
                                break;
                            }
                            Object next2 = it7.next();
                            if (Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o((MetaMaterial) next2), metaCategory.f30532id)) {
                                metaMaterial = next2;
                                break;
                            }
                        }
                        metaMaterial = metaMaterial;
                    }
                    WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel7 = this.templatePanel;
                    if (winkEditorExpandedTemplatePanel7 != null) {
                        winkEditorExpandedTemplatePanel7.H(metaMaterial);
                        return;
                    }
                    return;
                }
            }
            if (Intrinsics.areEqual(str, metaCategory.f30532id)) {
                z16 = true;
            }
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel8 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel8 != null) {
            if (winkEditorExpandedTemplatePanel8 != null && (E = winkEditorExpandedTemplatePanel8.E()) != null) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) E);
                metaMaterial = (MetaMaterial) lastOrNull;
            }
            winkEditorExpandedTemplatePanel8.H(metaMaterial);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.G.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.ati);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = inflater.inflate(R.layout.hda, container, false);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        wh(rootView);
        initView(rootView);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = this.templatePanel;
        if (winkEditorExpandedTemplatePanel != null) {
            recyclerView = winkEditorExpandedTemplatePanel.getMContentRecyclerView();
        } else {
            recyclerView = null;
        }
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel2 = this.templatePanel;
        if (winkEditorExpandedTemplatePanel2 != null) {
            recyclerView2 = winkEditorExpandedTemplatePanel2.f322424e;
        } else {
            recyclerView2 = null;
        }
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(null);
        }
        this.templatePanel = null;
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        MetaMaterial metaMaterial;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.needDismissCallback) {
            a aVar = this.clickListener;
            MetaMaterial metaMaterial2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clickListener");
                aVar = null;
            }
            WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = this.templatePanel;
            if (winkEditorExpandedTemplatePanel != null) {
                metaMaterial = winkEditorExpandedTemplatePanel.C();
            } else {
                metaMaterial = null;
            }
            WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel2 = this.templatePanel;
            if (winkEditorExpandedTemplatePanel2 != null) {
                metaMaterial2 = winkEditorExpandedTemplatePanel2.G();
            }
            aVar.c(metaMaterial, metaMaterial2);
        }
        this.needDismissCallback = true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ViewGroup.LayoutParams layoutParams;
        super.onStart();
        View view = getView();
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.height = uh();
        }
        WinkEditorExpandedTemplatePanel winkEditorExpandedTemplatePanel = this.templatePanel;
        if (winkEditorExpandedTemplatePanel != null) {
            winkEditorExpandedTemplatePanel.t();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorExpandedTemplateDialog(@NotNull c initConfig, @NotNull a clickListener) {
        this();
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.initConfig = initConfig;
        this.clickListener = clickListener;
    }
}
