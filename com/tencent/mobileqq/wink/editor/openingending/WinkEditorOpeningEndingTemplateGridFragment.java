package com.tencent.mobileqq.wink.editor.openingending;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateGridFragment;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.tav.core.AssetExtension;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.render.extension.MediaClipUseType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u000234B\u0007\u00a2\u0006\u0004\b/\u00100B'\b\u0016\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150(\u0012\u0006\u0010.\u001a\u00020,\u00a2\u0006\u0004\b/\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateGridFragment;", "Landroidx/fragment/app/Fragment;", "", "yh", OcrConfig.CHINESE, "Landroid/view/View;", "view", "registerDaTongReportPageId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", BdhLogUtil.LogTag.Tag_Conn, "I", "selectedIndex", "Lcom/tencent/videocut/model/MediaClip;", "D", "Lcom/tencent/videocut/model/MediaClip;", "appliedTemplateMediaClip", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "E", "Lkotlin/Lazy;", "xh", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "viewModel", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "wh", "()Landroidx/recyclerview/widget/RecyclerView;", "templateRecyclerView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "G", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "H", "Ljava/util/List;", "mediaClips", "", "Z", "isFromClipping", "<init>", "()V", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Ljava/util/List;Z)V", "K", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingTemplateGridFragment extends ReportAndroidXFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private int selectedIndex;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MediaClip appliedTemplateMediaClip;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy templateRecyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private MetaCategory category;

    /* renamed from: H, reason: from kotlin metadata */
    private List<? extends MediaClip> mediaClips;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFromClipping;

    @NotNull
    public Map<Integer, View> J;

    public WinkEditorOpeningEndingTemplateGridFragment() {
        Lazy lazy;
        Lazy lazy2;
        this.J = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorOpeningEndingViewModel>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateGridFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorOpeningEndingViewModel invoke() {
                FragmentActivity activity = WinkEditorOpeningEndingTemplateGridFragment.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                ViewModel viewModel = new ViewModelProvider(activity).get(WinkEditorOpeningEndingViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider((activ\u2026ingViewModel::class.java)");
                return (WinkEditorOpeningEndingViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateGridFragment$templateRecyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) WinkEditorOpeningEndingTemplateGridFragment.this.requireView().findViewById(R.id.f93915av);
            }
        });
        this.templateRecyclerView = lazy2;
    }

    private final void registerDaTongReportPageId(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, WinkDaTongReportConstant.PageId.PG_XSJ_OPENING_ENDING_PREVIEW_PAGE);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
        VideoReport.ignorePageInOutEvent(view, true);
    }

    private final RecyclerView wh() {
        Object value = this.templateRecyclerView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-templateRecyclerView>(...)");
        return (RecyclerView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorOpeningEndingViewModel xh() {
        return (WinkEditorOpeningEndingViewModel) this.viewModel.getValue();
    }

    private final void yh() {
        Object last;
        Object last2;
        String str;
        Object first;
        int i3;
        Object first2;
        String str2;
        MetaCategory metaCategory = this.category;
        MetaCategory metaCategory2 = null;
        if (metaCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
            metaCategory = null;
        }
        int i16 = -1;
        int i17 = 0;
        if (Intrinsics.areEqual(metaCategory.f30532id, "opening")) {
            List<? extends MediaClip> list = this.mediaClips;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                list = null;
            }
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            if (com.tencent.videocut.render.extension.e.r((MediaClip) first) == MediaClipUseType.OPENING) {
                List<? extends MediaClip> list2 = this.mediaClips;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                    list2 = null;
                }
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
                this.appliedTemplateMediaClip = (MediaClip) first2;
                MetaCategory metaCategory3 = this.category;
                if (metaCategory3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("category");
                    metaCategory3 = null;
                }
                ArrayList<MetaMaterial> arrayList = metaCategory3.materials;
                Intrinsics.checkNotNullExpressionValue(arrayList, "category.materials");
                Iterator<MetaMaterial> it = arrayList.iterator();
                int i18 = 0;
                while (true) {
                    if (it.hasNext()) {
                        String str3 = it.next().f30533id;
                        MediaClip mediaClip = this.appliedTemplateMediaClip;
                        if (mediaClip != null) {
                            str2 = com.tencent.videocut.render.extension.e.p(mediaClip);
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(str3, str2)) {
                            break;
                        } else {
                            i18++;
                        }
                    } else {
                        i18 = -1;
                        break;
                    }
                }
                this.selectedIndex = i18;
            } else {
                MetaCategory metaCategory4 = this.category;
                if (metaCategory4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("category");
                    metaCategory4 = null;
                }
                if (metaCategory4.materials.size() > 1) {
                    i3 = xh().getLastSelectedOpeningIndex();
                } else {
                    i3 = 0;
                }
                this.selectedIndex = i3;
            }
        }
        MetaCategory metaCategory5 = this.category;
        if (metaCategory5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
            metaCategory5 = null;
        }
        if (Intrinsics.areEqual(metaCategory5.f30532id, "ending")) {
            List<? extends MediaClip> list3 = this.mediaClips;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                list3 = null;
            }
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list3);
            if (com.tencent.videocut.render.extension.e.r((MediaClip) last) == MediaClipUseType.ENDING) {
                List<? extends MediaClip> list4 = this.mediaClips;
                if (list4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                    list4 = null;
                }
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) list4);
                this.appliedTemplateMediaClip = (MediaClip) last2;
                MetaCategory metaCategory6 = this.category;
                if (metaCategory6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("category");
                    metaCategory6 = null;
                }
                ArrayList<MetaMaterial> arrayList2 = metaCategory6.materials;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "category.materials");
                Iterator<MetaMaterial> it5 = arrayList2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    String str4 = it5.next().f30533id;
                    MediaClip mediaClip2 = this.appliedTemplateMediaClip;
                    if (mediaClip2 != null) {
                        str = com.tencent.videocut.render.extension.e.p(mediaClip2);
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str4, str)) {
                        i16 = i17;
                        break;
                    }
                    i17++;
                }
                this.selectedIndex = i16;
                return;
            }
            MetaCategory metaCategory7 = this.category;
            if (metaCategory7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("category");
            } else {
                metaCategory2 = metaCategory7;
            }
            if (metaCategory2.materials.size() > 1) {
                i17 = xh().getLastSelectedEndingIndex();
            }
            this.selectedIndex = i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
        MetaCategory metaCategory = this.category;
        if (metaCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
            metaCategory = null;
        }
        if (Intrinsics.areEqual(metaCategory.f30532id, "opening")) {
            xh().L2(this.selectedIndex);
        } else {
            xh().K2(this.selectedIndex);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.J.clear();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hea, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WinkEditorOpeningEndingViewModel xh5 = xh();
        MetaCategory metaCategory = this.category;
        if (metaCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
            metaCategory = null;
        }
        MetaMaterial metaMaterial = metaCategory.materials.get(this.selectedIndex);
        Intrinsics.checkNotNullExpressionValue(metaMaterial, "category.materials[selectedIndex]");
        xh5.J2(metaMaterial);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerDaTongReportPageId(view);
        yh();
        wh().setLayoutManager(new GridLayoutManager(getContext(), 4));
        RecyclerView wh5 = wh();
        MetaCategory metaCategory = this.category;
        if (metaCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
            metaCategory = null;
        }
        wh5.setAdapter(new b(this, metaCategory));
        com.tencent.mobileqq.wink.utils.e.j(wh(), 0, this.selectedIndex, false, false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingTemplateGridFragment(@NotNull MetaCategory category, @NotNull List<? extends MediaClip> mediaClips, boolean z16) {
        this();
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        this.category = category;
        this.mediaClips = mediaClips;
        this.isFromClipping = z16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\f2\u000e\u0010\n\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateGridFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateGridFragment$b$a;", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateGridFragment;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "getItemCount", "holder", "position", "", "j0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "i0", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "setCategory", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "category", "<init>", "(Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateGridFragment;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.Adapter<a> {
        final /* synthetic */ WinkEditorOpeningEndingTemplateGridFragment C;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MetaCategory category;

        public b(@NotNull WinkEditorOpeningEndingTemplateGridFragment winkEditorOpeningEndingTemplateGridFragment, MetaCategory category) {
            Intrinsics.checkNotNullParameter(category, "category");
            this.C = winkEditorOpeningEndingTemplateGridFragment;
            this.category = category;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.category.materials.size();
        }

        @NotNull
        /* renamed from: i0, reason: from getter */
        public final MetaCategory getCategory() {
            return this.category;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull a holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.p(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.heb, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new a(this, itemView);
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020\t\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0003J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fR\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\n \u0015*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001c\u0010 \u001a\n \u0015*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\n \u0015*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001c\u0010$\u001a\n \u0015*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001a\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateGridFragment$b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "imageView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "v", "w", "Landroid/view/View;", "buttonView", "u", "", "position", "metaMaterial", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/DialogInterface$OnClickListener;", "positiveClickListener", HippyTKDListViewAdapter.X, "p", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "templateName", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", AssetExtension.SCENE_THUMBNAIL, "G", "selectBorder", "H", "Landroid/view/View;", "editableOverlay", "I", "editableTip", "J", "clearBtn", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateGridFragment$b;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public final class a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            private final TextView templateName;

            /* renamed from: F, reason: from kotlin metadata */
            private final ImageView thumbnail;

            /* renamed from: G, reason: from kotlin metadata */
            private final ImageView selectBorder;

            /* renamed from: H, reason: from kotlin metadata */
            private final View editableOverlay;

            /* renamed from: I, reason: from kotlin metadata */
            private final View editableTip;

            /* renamed from: J, reason: from kotlin metadata */
            private final ImageView clearBtn;
            final /* synthetic */ b K;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull b bVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.K = bVar;
                this.templateName = (TextView) itemView.findViewById(R.id.f93895at);
                this.thumbnail = (ImageView) itemView.findViewById(R.id.y9u);
                this.selectBorder = (ImageView) itemView.findViewById(R.id.y8z);
                this.editableOverlay = itemView.findViewById(R.id.f166092yo0);
                this.editableTip = itemView.findViewById(R.id.f165054ur0);
                this.clearBtn = (ImageView) itemView.findViewById(R.id.txh);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void q(WinkEditorOpeningEndingTemplateGridFragment this$0, View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                MediaClip mediaClip = this$0.appliedTemplateMediaClip;
                if (mediaClip != null) {
                    this$0.xh().b2(mediaClip);
                }
                EventCollector.getInstance().onViewClicked(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void r(a this$0, int i3, MetaMaterial metaMaterial, View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                ImageView thumbnail = this$0.thumbnail;
                Intrinsics.checkNotNullExpressionValue(thumbnail, "thumbnail");
                Intrinsics.checkNotNullExpressionValue(metaMaterial, "metaMaterial");
                this$0.s(thumbnail, i3, metaMaterial);
                EventCollector.getInstance().onViewClicked(view);
            }

            @SuppressLint({"NotifyDataSetChanged"})
            private final void s(ImageView imageView, final int position, final MetaMaterial metaMaterial) {
                if (this.K.C.selectedIndex != position) {
                    w(imageView, metaMaterial);
                    if (this.K.C.appliedTemplateMediaClip == null) {
                        this.K.C.selectedIndex = position;
                        this.K.notifyDataSetChanged();
                        this.K.C.xh().J2(metaMaterial);
                        this.K.C.zh();
                        return;
                    }
                    final b bVar = this.K;
                    final WinkEditorOpeningEndingTemplateGridFragment winkEditorOpeningEndingTemplateGridFragment = bVar.C;
                    x(new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.az
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            WinkEditorOpeningEndingTemplateGridFragment.b.a.t(WinkEditorOpeningEndingTemplateGridFragment.this, position, bVar, metaMaterial, dialogInterface, i3);
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void t(WinkEditorOpeningEndingTemplateGridFragment this$0, int i3, b this$1, MetaMaterial metaMaterial, DialogInterface dialogInterface, int i16) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                Intrinsics.checkNotNullParameter(metaMaterial, "$metaMaterial");
                this$0.selectedIndex = i3;
                this$1.notifyDataSetChanged();
                this$0.xh().J2(metaMaterial);
                WinkEditorOpeningEndingViewModel.O2(this$0.xh(), null, Intrinsics.areEqual(this$1.getCategory().f30532id, "opening"), this$0.isFromClipping, null, null, null, 56, null);
                WinkEditorOpeningEndingViewModel xh5 = this$0.xh();
                MediaClip mediaClip = this$0.appliedTemplateMediaClip;
                Intrinsics.checkNotNull(mediaClip);
                xh5.e2(mediaClip);
                this$0.appliedTemplateMediaClip = null;
                this$0.zh();
            }

            private final void u(View buttonView, MetaMaterial material) {
                VideoReport.setElementId(buttonView, WinkDaTongReportConstant.ElementId.EM_XSJ_OPENING_ENDING_EDIT_BUTTON);
                VideoReport.setElementReuseIdentifier(buttonView, String.valueOf(material.hashCode()));
                Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
                Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
                reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, material.f30533id);
                VideoReport.setElementParams(buttonView, reportMap);
                VideoReport.setElementEndExposePolicy(buttonView, EndExposurePolicy.REPORT_NONE);
                VideoReport.setElementClickPolicy(buttonView, ClickPolicy.REPORT_ALL);
                VideoReport.setElementExposePolicy(buttonView, ExposurePolicy.REPORT_ALL);
            }

            private final void v(ImageView imageView, MetaMaterial material) {
                if (!Intrinsics.areEqual(material.f30533id, "CLEAR_OPENING_MATERIAL_ID") && !Intrinsics.areEqual(material.f30533id, "CLEAR_ENDING_MATERIAL_ID")) {
                    VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_OPENING_ENDING_MATERIAL_ITEM);
                    VideoReport.setElementReuseIdentifier(imageView, String.valueOf(material.hashCode()));
                    Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
                    Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
                    reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, material.f30533id);
                    VideoReport.setElementParams(imageView, reportMap);
                    VideoReport.setElementEndExposePolicy(imageView, EndExposurePolicy.REPORT_NONE);
                    VideoReport.setElementClickPolicy(imageView, ClickPolicy.REPORT_NONE);
                    VideoReport.setElementExposePolicy(imageView, ExposurePolicy.REPORT_ALL);
                }
            }

            private final void w(ImageView imageView, MetaMaterial material) {
                if (!Intrinsics.areEqual(material.f30533id, "CLEAR_OPENING_MATERIAL_ID") && !Intrinsics.areEqual(material.f30533id, "CLEAR_ENDING_MATERIAL_ID")) {
                    VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_OPENING_ENDING_MATERIAL_ITEM);
                    VideoReport.setElementReuseIdentifier(imageView, String.valueOf(material.hashCode()));
                    Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
                    Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
                    reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, material.f30533id);
                    VideoReport.reportEvent("dt_clck", imageView, reportMap);
                }
            }

            private final void x(DialogInterface.OnClickListener positiveClickListener) {
                try {
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.K.C.getContext(), 230);
                    createCustomDialog.setMessage(R.string.f215865wr);
                    createCustomDialog.setPositiveButton(R.string.f215835wo, positiveClickListener);
                    createCustomDialog.setNegativeButton(R.string.f239057lf, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ba
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            WinkEditorOpeningEndingTemplateGridFragment.b.a.y(dialogInterface, i3);
                        }
                    });
                    createCustomDialog.show();
                } catch (Exception e16) {
                    w53.b.c("WinkEditorOpeningEndingTemplateGridFragment", "showClearBtnConfirmDialog: " + e16);
                }
            }

            public final void p(final int position) {
                boolean z16;
                Resources resources;
                String str;
                Resources resources2;
                final MetaMaterial metaMaterial = this.K.getCategory().materials.get(position);
                ImageView thumbnail = this.thumbnail;
                Intrinsics.checkNotNullExpressionValue(thumbnail, "thumbnail");
                Intrinsics.checkNotNullExpressionValue(metaMaterial, "metaMaterial");
                v(thumbnail, metaMaterial);
                View editableOverlay = this.editableOverlay;
                Intrinsics.checkNotNullExpressionValue(editableOverlay, "editableOverlay");
                u(editableOverlay, metaMaterial);
                boolean z17 = true;
                if (com.tencent.mobileqq.wink.editor.c.T(metaMaterial) != MaterialType.TEMPLATE && com.tencent.mobileqq.wink.editor.c.T(metaMaterial) != MaterialType.OPEN_END_AIGC_TEMPLATE) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (this.K.C.selectedIndex != position) {
                    z17 = false;
                }
                this.templateName.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
                ViewUtilsKt.j(this.thumbnail, metaMaterial.thumbUrl);
                int i3 = -1;
                if (z17) {
                    this.selectBorder.setVisibility(0);
                    TextView textView = this.templateName;
                    Context context = this.K.C.getContext();
                    if (context != null && (resources2 = context.getResources()) != null) {
                        i3 = resources2.getColor(R.color.bfp);
                    }
                    textView.setTextColor(i3);
                } else {
                    this.selectBorder.setVisibility(4);
                    TextView textView2 = this.templateName;
                    Context context2 = this.K.C.getContext();
                    if (context2 != null && (resources = context2.getResources()) != null) {
                        i3 = resources.getColor(R.color.bfq);
                    }
                    textView2.setTextColor(i3);
                }
                if (z16) {
                    this.editableTip.setVisibility(0);
                } else {
                    this.editableTip.setVisibility(4);
                }
                if (!Intrinsics.areEqual(metaMaterial.f30533id, "CLEAR_ENDING_MATERIAL_ID") && !Intrinsics.areEqual(metaMaterial.f30533id, "CLEAR_OPENING_MATERIAL_ID")) {
                    this.clearBtn.setVisibility(8);
                } else {
                    this.clearBtn.setVisibility(0);
                    if (z17) {
                        this.clearBtn.setAlpha(1.0f);
                    } else {
                        this.clearBtn.setAlpha(0.55f);
                    }
                }
                if (z17) {
                    MediaClip mediaClip = this.K.C.appliedTemplateMediaClip;
                    if (mediaClip != null) {
                        str = com.tencent.videocut.render.extension.e.p(mediaClip);
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, metaMaterial.f30533id) && z16) {
                        this.editableOverlay.setVisibility(0);
                        View view = this.editableOverlay;
                        final WinkEditorOpeningEndingTemplateGridFragment winkEditorOpeningEndingTemplateGridFragment = this.K.C;
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ax
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                WinkEditorOpeningEndingTemplateGridFragment.b.a.q(WinkEditorOpeningEndingTemplateGridFragment.this, view2);
                            }
                        });
                        this.thumbnail.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ay
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                WinkEditorOpeningEndingTemplateGridFragment.b.a.r(WinkEditorOpeningEndingTemplateGridFragment.b.a.this, position, metaMaterial, view2);
                            }
                        });
                    }
                }
                this.editableOverlay.setVisibility(8);
                this.thumbnail.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ay
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        WinkEditorOpeningEndingTemplateGridFragment.b.a.r(WinkEditorOpeningEndingTemplateGridFragment.b.a.this, position, metaMaterial, view2);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void y(DialogInterface dialogInterface, int i3) {
            }
        }
    }
}
