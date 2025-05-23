package com.tencent.mobileqq.wink.qzone.templatelibrary.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibViewPagerFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.WinkQZoneTemplateLibJumpHelper;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u93.k;
import w53.b;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 72\u00020\u0001:\u000489:;B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment;", "Landroidx/fragment/app/Fragment;", "", "th", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "targetPositionMaterial", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "", "vh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroyView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$a;", "D", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$a;", "adapter", "E", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "traceId", "G", "Landroid/os/Bundle;", "bundle", "H", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "I", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "J", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManager", "<init>", "()V", "L", "a", "b", "c", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibViewPagerFragment extends ReportAndroidXFragment {

    @NotNull
    private static final Pair<Float, String> M = TuplesKt.to(Float.valueOf(1.5f), "w,3:2");

    @NotNull
    private static final Pair<Float, String> N = TuplesKt.to(Float.valueOf(1.3333334f), "w,4:3");

    @NotNull
    private static final Pair<Float, String> P = TuplesKt.to(Float.valueOf(1.7777778f), "w,16:9");

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerview;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private a adapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MetaCategory category;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String traceId;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Bundle bundle;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial targetPositionMaterial;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibJumpHelper jumpHelper;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private StaggeredGridLayoutManager layoutManager;

    @NotNull
    public Map<Integer, View> K = new LinkedHashMap();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemViewType", "getItemCount", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "D", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Landroid/os/Bundle;Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<d> {

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private final Bundle bundle;

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private final WinkQZoneTemplateLibJumpHelper jumpHelper;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private MetaCategory category;

        public a(@Nullable MetaCategory metaCategory, @Nullable Bundle bundle, @Nullable WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper) {
            this.category = metaCategory;
            this.bundle = bundle;
            this.jumpHelper = winkQZoneTemplateLibJumpHelper;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            boolean z16;
            MetaCategory metaCategory = this.category;
            if (metaCategory == null) {
                return 0;
            }
            Intrinsics.checkNotNull(metaCategory);
            ArrayList<MetaMaterial> arrayList = metaCategory.materials;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return 0;
            }
            MetaCategory metaCategory2 = this.category;
            Intrinsics.checkNotNull(metaCategory2);
            return metaCategory2.materials.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            String str;
            ArrayList<MetaMaterial> arrayList;
            Object orNull;
            MetaCategory metaCategory = this.category;
            if (metaCategory != null) {
                str = metaCategory.f30532id;
            } else {
                str = null;
            }
            boolean z16 = false;
            if (Intrinsics.areEqual(str, "pic_gen_pic")) {
                return 0;
            }
            MetaCategory metaCategory2 = this.category;
            if (metaCategory2 != null && (arrayList = metaCategory2.materials) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, position);
                MetaMaterial metaMaterial = (MetaMaterial) orNull;
                if (metaMaterial != null && com.tencent.mobileqq.wink.editor.c.b1(metaMaterial)) {
                    z16 = true;
                }
            }
            if (z16) {
                return 1;
            }
            return 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.q(this.category, position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Pair pair;
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i7r, parent, false);
            if (viewType == 0) {
                pair = WinkQZoneTemplateLibViewPagerFragment.M;
            } else {
                pair = viewType != 1 ? WinkQZoneTemplateLibViewPagerFragment.P : WinkQZoneTemplateLibViewPagerFragment.N;
            }
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new d(itemView, this.bundle, this.jumpHelper, pair);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.left = ImmersiveUtils.dpToPx(5.5f);
            outRect.right = ImmersiveUtils.dpToPx(5.5f);
            outRect.bottom = ImmersiveUtils.dpToPx(20.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    private final int th() {
        if (com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.n()) {
            return 4;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(WinkQZoneTemplateLibViewPagerFragment this$0) {
        ArrayList<MetaMaterial> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MetaCategory metaCategory = this$0.category;
        if (metaCategory != null) {
            arrayList = metaCategory.materials;
        } else {
            arrayList = null;
        }
        int max = Math.max(com.tencent.mobileqq.wink.editor.c.g(arrayList, this$0.targetPositionMaterial), 0);
        StaggeredGridLayoutManager staggeredGridLayoutManager = this$0.layoutManager;
        if (staggeredGridLayoutManager != null) {
            staggeredGridLayoutManager.scrollToPositionWithOffset(max, 0);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.K.clear();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.layoutManager;
        if (staggeredGridLayoutManager != null) {
            staggeredGridLayoutManager.setSpanCount(th());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str = intent2.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        } else {
            str = null;
        }
        this.traceId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        this.bundle = bundle;
        View inflate = inflater.inflate(R.layout.i7q, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        RecyclerView recyclerView2 = this.recyclerview;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(null);
        }
        this.recyclerview = null;
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ApngImage.pauseAll();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ApngImage.resumeAll();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        DefaultItemAnimator defaultItemAnimator;
        SimpleItemAnimator simpleItemAnimator;
        Intrinsics.checkNotNullParameter(view, "view");
        this.recyclerview = (RecyclerView) view.findViewById(R.id.f124447jd);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(th(), 1);
        staggeredGridLayoutManager.setGapStrategy(0);
        this.layoutManager = staggeredGridLayoutManager;
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }
        RecyclerView recyclerView2 = this.recyclerview;
        String str2 = null;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(null);
        }
        RecyclerView recyclerView3 = this.recyclerview;
        if (recyclerView3 != null) {
            this.adapter = new a(this.category, this.bundle, this.jumpHelper);
            RecyclerView.ItemAnimator itemAnimator = recyclerView3.getItemAnimator();
            if (itemAnimator instanceof DefaultItemAnimator) {
                defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
            } else {
                defaultItemAnimator = null;
            }
            if (defaultItemAnimator != null) {
                defaultItemAnimator.setSupportsChangeAnimations(false);
            }
            RecyclerView.ItemAnimator itemAnimator2 = recyclerView3.getItemAnimator();
            if (itemAnimator2 instanceof SimpleItemAnimator) {
                simpleItemAnimator = (SimpleItemAnimator) itemAnimator2;
            } else {
                simpleItemAnimator = null;
            }
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            RecyclerView.ItemAnimator itemAnimator3 = recyclerView3.getItemAnimator();
            if (itemAnimator3 != null) {
                itemAnimator3.setChangeDuration(0L);
            }
            recyclerView3.setAdapter(this.adapter);
            recyclerView3.addItemDecoration(new c());
            recyclerView3.addOnScrollListener(new e());
        }
        MetaMaterial metaMaterial = this.targetPositionMaterial;
        if (metaMaterial != null) {
            str = com.tencent.mobileqq.wink.editor.c.o(metaMaterial);
        } else {
            str = null;
        }
        MetaCategory metaCategory = this.category;
        if (metaCategory != null) {
            str2 = metaCategory.f30532id;
        }
        if (Intrinsics.areEqual(str, str2)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: u93.h
                @Override // java.lang.Runnable
                public final void run() {
                    WinkQZoneTemplateLibViewPagerFragment.uh(WinkQZoneTemplateLibViewPagerFragment.this);
                }
            });
        }
    }

    public final void vh(@NotNull MetaCategory category, @Nullable MetaMaterial targetPositionMaterial, @Nullable WinkQZoneTemplateLibJumpHelper jumpHelper) {
        Intrinsics.checkNotNullParameter(category, "category");
        b.f("WinkQZoneTemplateLibViewPagerFragment", "[setData] ==> " + category.materials.size());
        this.category = category;
        this.targetPositionMaterial = targetPositionMaterial;
        this.jumpHelper = jumpHelper;
    }

    @Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u00017\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 \u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010\u0006\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Landroid/view/View;", "makeBtn", HippyTKDListViewAdapter.X, "view", "w", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Landroid/graphics/drawable/Drawable;", "t", "", "useApng", "defaultDrawable", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "u", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "position", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/os/Bundle;", "E", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "Lkotlin/Pair;", "", "", "G", "Lkotlin/Pair;", "coverRatio", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "H", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "coverView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "nameTextView", "J", "usageCountTextView", "K", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "hotIcon", "M", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "com/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$d$a", "N", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$d$a;", "drawableListener", "itemView", "<init>", "(Landroid/view/View;Landroid/os/Bundle;Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;Lkotlin/Pair;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final Bundle bundle;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private final WinkQZoneTemplateLibJumpHelper jumpHelper;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final Pair<Float, String> coverRatio;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final RoundCornerImageView coverView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView nameTextView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView usageCountTextView;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final TextView makeBtn;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final ImageView hotIcon;

        /* renamed from: M, reason: from kotlin metadata */
        @Nullable
        private MetaMaterial material;

        /* renamed from: N, reason: from kotlin metadata */
        @NotNull
        private final a drawableListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView, @Nullable Bundle bundle, @Nullable WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper, @NotNull Pair<Float, String> coverRatio) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(coverRatio, "coverRatio");
            this.bundle = bundle;
            this.jumpHelper = winkQZoneTemplateLibJumpHelper;
            this.coverRatio = coverRatio;
            View findViewById = itemView.findViewById(R.id.f124207iq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026late_category_item_cover)");
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById;
            this.coverView = roundCornerImageView;
            View findViewById2 = itemView.findViewById(R.id.f124217ir);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026plate_category_item_name)");
            this.nameTextView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f124227is);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026ategory_item_usage_count)");
            this.usageCountTextView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f124397j9);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.wink_template_make_btn)");
            this.makeBtn = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f124417ja);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026nk_template_popular_icon)");
            this.hotIcon = (ImageView) findViewById5;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) roundCornerImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.dimensionRatio = coverRatio.getSecond();
            }
            this.drawableListener = new a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(d this$0, MetaCategory metaCategory, Map reportParams, View it) {
            Integer num;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
            WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this$0.jumpHelper;
            if (winkQZoneTemplateLibJumpHelper != null) {
                winkQZoneTemplateLibJumpHelper.n(it.getContext(), this$0.material, metaCategory, "2");
            }
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            MetaMaterial metaMaterial = this$0.material;
            if (metaMaterial != null) {
                num = Integer.valueOf(metaMaterial.hashCode());
            } else {
                num = null;
            }
            eVar.l(it, WinkDaTongReportConstant.ElementId.EM_QZ_USE_BTN, reportParams, String.valueOf(num));
            EventCollector.getInstance().onViewClicked(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(d this$0, RoundCornerImageView this_apply, MetaCategory metaCategory, Map reportParams, View it) {
            Integer num;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
            WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this$0.jumpHelper;
            if (winkQZoneTemplateLibJumpHelper != null) {
                Context context = this_apply.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                winkQZoneTemplateLibJumpHelper.k(context, this$0.bundle, this$0.material, metaCategory, "2");
            }
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            MetaMaterial metaMaterial = this$0.material;
            if (metaMaterial != null) {
                num = Integer.valueOf(metaMaterial.hashCode());
            } else {
                num = null;
            }
            eVar.l(it, WinkDaTongReportConstant.ElementId.EM_QZ_INSPIRATION_DETAIL_EN, reportParams, String.valueOf(num));
            EventCollector.getInstance().onViewClicked(it);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Drawable t(MetaMaterial material) {
            String str;
            boolean z16;
            Drawable dynamicCoverDrawable;
            String str2;
            boolean z17;
            boolean isBlank;
            boolean isBlank2;
            boolean isBlank3;
            URLDrawable.URLDrawableOptions v3 = v(this, true, null, 2, null);
            if (material != null) {
                str = com.tencent.mobileqq.wink.editor.c.Z(material);
            } else {
                str = null;
            }
            if (str != null) {
                isBlank3 = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank3) {
                    z16 = false;
                    if (!z16) {
                        dynamicCoverDrawable = new ColorDrawable(this.itemView.getContext().getColor(R.color.qui_common_bg_nav_bottom));
                    } else {
                        dynamicCoverDrawable = URLDrawable.getDrawable(str, v3);
                    }
                    if (material == null) {
                        str2 = com.tencent.mobileqq.wink.editor.c.s0(material);
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                        if (!isBlank2) {
                            z17 = false;
                            if (z17) {
                                Intrinsics.checkNotNullExpressionValue(dynamicCoverDrawable, "dynamicCoverDrawable");
                                return dynamicCoverDrawable;
                            }
                            if (!(dynamicCoverDrawable instanceof URLDrawable) || !k.a((URLDrawable) dynamicCoverDrawable)) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(com.tencent.mobileqq.wink.editor.c.Z(material));
                                if (isBlank) {
                                    URLDrawable drawable = URLDrawable.getDrawable(str2, v(this, false, null, 3, null));
                                    Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(staticCoverUrl, getDrawableOptions())");
                                    return drawable;
                                }
                                URLDrawable.URLDrawableOptions v16 = v(this, false, null, 3, null);
                                v16.mExtraInfo = material;
                                URLDrawable staticCoverDrawable = URLDrawable.getDrawable(str2, v16);
                                Intrinsics.checkNotNullExpressionValue(staticCoverDrawable, "staticCoverDrawable");
                                if (k.a(staticCoverDrawable)) {
                                    URLDrawable drawable2 = URLDrawable.getDrawable(com.tencent.mobileqq.wink.editor.c.Z(material), u(true, staticCoverDrawable));
                                    Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(material.motionCoverUrl, options)");
                                    return drawable2;
                                }
                                return staticCoverDrawable;
                            }
                            return dynamicCoverDrawable;
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
            if (material == null) {
            }
            if (str2 != null) {
            }
            z17 = true;
            if (z17) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final URLDrawable.URLDrawableOptions u(boolean useApng, Drawable defaultDrawable) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = defaultDrawable;
            obtain.mFailedDrawable = defaultDrawable;
            int screenWidth = ImmersiveUtils.getScreenWidth() / 2;
            obtain.mRequestWidth = screenWidth;
            obtain.mRequestHeight = (int) (screenWidth * this.coverRatio.getFirst().floatValue());
            obtain.mUseApngImage = useApng;
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026e = useApng\n            }");
            return obtain;
        }

        static /* synthetic */ URLDrawable.URLDrawableOptions v(d dVar, boolean z16, Drawable drawable, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                drawable = new ColorDrawable(dVar.itemView.getContext().getColor(R.color.qui_common_bg_nav_bottom));
            }
            return dVar.u(z16, drawable);
        }

        private final void w(View view) {
            String str;
            String str2;
            Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            MetaMaterial metaMaterial = this.material;
            String str3 = null;
            if (metaMaterial != null) {
                str = metaMaterial.f30533id;
            } else {
                str = null;
            }
            params.put("material_id", str);
            MetaMaterial metaMaterial2 = this.material;
            if (metaMaterial2 != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.p(metaMaterial2);
            } else {
                str2 = null;
            }
            params.put(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, str2);
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QZ_CLASSIFY_GROUP);
            params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_INSPIRATION_DETAIL_EN);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            MetaMaterial metaMaterial3 = this.material;
            if (metaMaterial3 != null) {
                str3 = metaMaterial3.f30533id;
            }
            eVar.e(view, WinkDaTongReportConstant.ElementId.EM_QZ_INSPIRATION_DETAIL_EN, params, str3);
        }

        private final void x(View makeBtn) {
            String str;
            String str2;
            Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            MetaMaterial metaMaterial = this.material;
            String str3 = null;
            if (metaMaterial != null) {
                str = metaMaterial.f30533id;
            } else {
                str = null;
            }
            params.put("material_id", str);
            MetaMaterial metaMaterial2 = this.material;
            if (metaMaterial2 != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.p(metaMaterial2);
            } else {
                str2 = null;
            }
            params.put(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, str2);
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QZ_CLASSIFY_GROUP);
            params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_USE_BTN);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            MetaMaterial metaMaterial3 = this.material;
            if (metaMaterial3 != null) {
                str3 = metaMaterial3.f30533id;
            }
            eVar.e(makeBtn, WinkDaTongReportConstant.ElementId.EM_QZ_USE_BTN, params, str3);
        }

        private final void y() {
            this.hotIcon.setVisibility(0);
            Option obtain = Option.obtain();
            obtain.setLoadingDrawableColor(this.itemView.getContext().getColor(R.color.ajr));
            obtain.setTargetView(this.hotIcon);
            obtain.setUrl("https://qq-video.cdn-go.cn/ios/latest/defaultmode/9105/qzone_lingganku_icon_hot.png");
            QQPicLoader.f201806a.d().loadImage(obtain, null);
        }

        private final void z() {
            int dpToPx;
            ViewGroup.LayoutParams layoutParams = this.nameTextView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                MetaMaterial metaMaterial = this.material;
                boolean z16 = false;
                if (metaMaterial != null && com.tencent.mobileqq.wink.editor.c.F(metaMaterial)) {
                    z16 = true;
                }
                if (z16) {
                    dpToPx = ImmersiveUtils.dpToPx(12.0f);
                } else {
                    dpToPx = ImmersiveUtils.dpToPx(8.0f);
                }
                marginLayoutParams.topMargin = dpToPx;
                this.nameTextView.setLayoutParams(layoutParams);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00b6, code lost:
        
            if (r3 == true) goto L47;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void q(@Nullable final MetaCategory category, int position) {
            MetaMaterial metaMaterial;
            boolean z16;
            String str;
            String str2;
            String str3;
            final Map mutableMapOf;
            String string;
            String P0;
            boolean z17;
            ArrayList<MetaMaterial> arrayList;
            String str4 = null;
            if (category != null && (arrayList = category.materials) != null) {
                metaMaterial = arrayList.get(position);
            } else {
                metaMaterial = null;
            }
            this.material = metaMaterial;
            boolean z18 = true;
            if (metaMaterial != null && com.tencent.mobileqq.wink.editor.c.F(metaMaterial)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.usageCountTextView.setVisibility(8);
                this.hotIcon.setVisibility(8);
            } else {
                this.usageCountTextView.setVisibility(0);
                MetaMaterial metaMaterial2 = this.material;
                if (metaMaterial2 != null) {
                    str = com.tencent.mobileqq.wink.editor.c.d0(metaMaterial2);
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "\u70ed\u95e8")) {
                    y();
                } else {
                    this.hotIcon.setVisibility(8);
                }
            }
            TextView textView = this.nameTextView;
            MetaMaterial metaMaterial3 = this.material;
            if (metaMaterial3 != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial3);
            } else {
                str2 = null;
            }
            textView.setText(str2);
            this.usageCountTextView.setText(com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.e(this.material));
            z();
            Pair[] pairArr = new Pair[2];
            if (category != null) {
                str3 = category.name;
            } else {
                str3 = null;
            }
            pairArr[0] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, str3);
            MetaMaterial metaMaterial4 = this.material;
            if (metaMaterial4 != null) {
                str4 = metaMaterial4.f30533id;
            }
            pairArr[1] = TuplesKt.to("material_id", str4);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            this.makeBtn.setOnClickListener(new View.OnClickListener() { // from class: u93.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkQZoneTemplateLibViewPagerFragment.d.r(WinkQZoneTemplateLibViewPagerFragment.d.this, category, mutableMapOf, view);
                }
            });
            this.makeBtn.setVisibility(0);
            TextView textView2 = this.makeBtn;
            MetaMaterial metaMaterial5 = this.material;
            if (metaMaterial5 != null && (P0 = com.tencent.mobileqq.wink.editor.c.P0(metaMaterial5)) != null) {
                if (P0.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z18 = false;
            if (z18) {
                MetaMaterial metaMaterial6 = this.material;
                Intrinsics.checkNotNull(metaMaterial6);
                string = com.tencent.mobileqq.wink.editor.c.P0(metaMaterial6);
            } else {
                string = this.itemView.getContext().getString(R.string.f240867qb);
            }
            textView2.setText(string);
            x(this.makeBtn);
            final RoundCornerImageView roundCornerImageView = this.coverView;
            roundCornerImageView.setURLDrawableDownListener(this.drawableListener);
            roundCornerImageView.setImageDrawable(t(this.material));
            roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(12.0f));
            roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: u93.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkQZoneTemplateLibViewPagerFragment.d.s(WinkQZoneTemplateLibViewPagerFragment.d.this, roundCornerImageView, category, mutableMapOf, view);
                }
            });
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            w(itemView);
        }

        @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0016\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibViewPagerFragment$d$a", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "", "b", "Lcom/tencent/image/URLDrawable;", "drawable", "", "a", "Landroid/view/View;", "view", "onLoadSuccessed", "", "throwable", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "e", "onLoadInterrupted", "", "progress", "onLoadProgressed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class a implements URLDrawableDownListener {
            a() {
            }

            private final boolean a(URLDrawable drawable) {
                Object obj;
                MetaMaterial metaMaterial;
                String str;
                String str2 = null;
                if (drawable != null) {
                    obj = drawable.getExtraInfo();
                } else {
                    obj = null;
                }
                if (obj instanceof MetaMaterial) {
                    metaMaterial = (MetaMaterial) obj;
                } else {
                    metaMaterial = null;
                }
                if (metaMaterial != null) {
                    str = com.tencent.mobileqq.wink.editor.c.Z(metaMaterial);
                } else {
                    str = null;
                }
                MetaMaterial metaMaterial2 = d.this.material;
                if (metaMaterial2 != null) {
                    str2 = com.tencent.mobileqq.wink.editor.c.Z(metaMaterial2);
                }
                return Intrinsics.areEqual(str, str2);
            }

            private final void b(Drawable defaultDrawable) {
                String str;
                URLDrawable.URLDrawableOptions u16 = d.this.u(true, defaultDrawable);
                MetaMaterial metaMaterial = d.this.material;
                if (metaMaterial != null) {
                    str = com.tencent.mobileqq.wink.editor.c.Z(metaMaterial);
                } else {
                    str = null;
                }
                d.this.coverView.setImageDrawable(URLDrawable.getDrawable(str, u16));
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadCancelled(@Nullable View view, @Nullable URLDrawable drawable) {
                String str;
                MetaMaterial metaMaterial = d.this.material;
                if (metaMaterial != null) {
                    str = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial);
                } else {
                    str = null;
                }
                b.g("WinkQZoneTemplateLibViewPagerFragment", "[DownListener][onLoadCancelled] name=" + str);
                if (!a(drawable)) {
                    return;
                }
                Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
                Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
                b(TRANSPARENT);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadFailed(@Nullable View view, @Nullable URLDrawable drawable, @Nullable Throwable throwable) {
                String str;
                MetaMaterial metaMaterial = d.this.material;
                if (metaMaterial != null) {
                    str = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial);
                } else {
                    str = null;
                }
                b.g("WinkQZoneTemplateLibViewPagerFragment", "[DownListener][onLoadFailed] name=" + str);
                if (!a(drawable)) {
                    return;
                }
                Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
                Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
                b(TRANSPARENT);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadInterrupted(@Nullable View view, @Nullable URLDrawable drawable, @Nullable InterruptedException e16) {
                String str;
                MetaMaterial metaMaterial = d.this.material;
                if (metaMaterial != null) {
                    str = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial);
                } else {
                    str = null;
                }
                b.g("WinkQZoneTemplateLibViewPagerFragment", "[DownListener][onLoadInterrupted] name=" + str);
                if (!a(drawable)) {
                    return;
                }
                Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
                Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
                b(TRANSPARENT);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadSuccessed(@Nullable View view, @Nullable URLDrawable drawable) {
                boolean a16 = a(drawable);
                Drawable drawable2 = drawable;
                if (!a16) {
                    return;
                }
                if (drawable == null) {
                    drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
                }
                Intrinsics.checkNotNullExpressionValue(drawable2, "drawable ?: URLDrawableHelperConstants.TRANSPARENT");
                b(drawable2);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadProgressed(@Nullable View view, @Nullable URLDrawable drawable, int progress) {
            }
        }
    }
}
