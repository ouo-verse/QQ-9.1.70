package com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.util.api.IAEEditorJumpUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibMoreTemplateFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.WinkQZoneTemplateLibJumpHelper;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 B2\u00020\u0001:\u0004CDE\u001aB\u001d\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\nH&J \u0010\u0017\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0002R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "Landroid/view/View;", "view", "H0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "targetPositionMaterial", "J0", "", "C0", "F0", "G0", "E0", "B0", "D0", "Landroid/content/Intent;", "intent", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "categoriesData", "setData", "release", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "labelView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView$a;", "f", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView$a;", "adapter", h.F, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "getCategory", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "setCategory", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "i", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "traceId", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "bundle", "D", "Landroid/view/View;", "moreView", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "E", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkQZoneTemplateCategoryBaseView extends ConstraintLayout {

    @NotNull
    private static final Set<String> H;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Bundle bundle;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View moreView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibJumpHelper jumpHelper;

    @NotNull
    public Map<Integer, View> F;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView labelView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerview;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaCategory category;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel.CategoriesData categoriesData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String traceId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\b\u0010-\u001a\u0004\u0018\u00010(\u0012\u0006\u0010/\u001a\u00020\u0005\u00a2\u0006\u0004\b0\u00101J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010$\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0017\u0010'\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u0019\u0010-\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010/\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001b\u001a\u0004\b.\u0010\u001d\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "k0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "getCategory", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "D", "I", "getLayoutId", "()I", "layoutId", "E", "getWidth", "width", UserInfo.SEX_FEMALE, "getHeight", "height", "G", "getCornerRadius", "cornerRadius", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "H", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "getJumpHelper", "()Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "getNameTextBottomMargin", "nameTextBottomMargin", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Landroid/os/Bundle;IIIILcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<d> {

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private final Bundle bundle;

        /* renamed from: D, reason: from kotlin metadata */
        private final int layoutId;

        /* renamed from: E, reason: from kotlin metadata */
        private final int width;

        /* renamed from: F, reason: from kotlin metadata */
        private final int height;

        /* renamed from: G, reason: from kotlin metadata */
        private final int cornerRadius;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private final WinkQZoneTemplateLibJumpHelper jumpHelper;

        /* renamed from: I, reason: from kotlin metadata */
        private final int nameTextBottomMargin;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final MetaCategory category;

        public a(@Nullable MetaCategory metaCategory, @Nullable Bundle bundle, int i3, int i16, int i17, int i18, @Nullable WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper, int i19) {
            this.category = metaCategory;
            this.bundle = bundle;
            this.layoutId = i3;
            this.width = i16;
            this.height = i17;
            this.cornerRadius = i18;
            this.jumpHelper = winkQZoneTemplateLibJumpHelper;
            this.nameTextBottomMargin = i19;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            int i3;
            ArrayList<MetaMaterial> arrayList;
            MetaCategory metaCategory = this.category;
            int i16 = 0;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            MetaCategory metaCategory2 = this.category;
            if (metaCategory2 != null) {
                i16 = com.tencent.mobileqq.wink.editor.b.c(metaCategory2);
            }
            return Math.min(i3, i16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.p(this.category, position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(this.layoutId, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new d(itemView, this.bundle, this.cornerRadius, this.width, this.height, this.jumpHelper, this.nameTextBottomMargin);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(@NotNull d holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewRecycled(holder);
            holder.v(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "firstLeftMarginPx", "e", "leftMarginPx", "f", "rightMarginPx", "<init>", "()V", h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int firstLeftMarginPx = ImmersiveUtils.dpToPx(16.0f);

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int leftMarginPx = ImmersiveUtils.dpToPx(3.5f);

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int rightMarginPx = ImmersiveUtils.dpToPx(3.5f);

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildLayoutPosition(view) == 0) {
                i3 = this.firstLeftMarginPx;
            } else {
                i3 = this.leftMarginPx;
            }
            outRect.left = i3;
            outRect.right = this.rightMarginPx;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010E\u001a\u00020\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0012\u0012\b\u0010\"\u001a\u0004\u0018\u00010 \u0012\u0006\u0010$\u001a\u00020\u0012\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010!R\u0014\u0010$\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001aR\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0017\u00100\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Landroid/view/View;", "view", "u", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "w", "", "dynamicCoverUrl", "", "noStaticUrl", "r", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "position", "p", "Landroid/os/Bundle;", "E", "Landroid/os/Bundle;", "bundle", UserInfo.SEX_FEMALE, "I", "cornerRadius", "G", "width", "H", "height", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "J", "nameTextBottomMargin", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "K", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "coverView", "Landroid/widget/TextView;", "L", "Landroid/widget/TextView;", "flagTextView", "M", "getNameTextView", "()Landroid/widget/TextView;", "nameTextView", "N", "descTextView", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "hotIcon", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/drawable/Drawable;", "getApngDrawable", "()Landroid/graphics/drawable/Drawable;", "v", "(Landroid/graphics/drawable/Drawable;)V", "apngDrawable", "Landroid/graphics/drawable/ColorDrawable;", ExifInterface.LATITUDE_SOUTH, "Landroid/graphics/drawable/ColorDrawable;", "defaultDrawable", "itemView", "<init>", "(Landroid/view/View;Landroid/os/Bundle;IIILcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final Bundle bundle;

        /* renamed from: F, reason: from kotlin metadata */
        private final int cornerRadius;

        /* renamed from: G, reason: from kotlin metadata */
        private final int width;

        /* renamed from: H, reason: from kotlin metadata */
        private final int height;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private WinkQZoneTemplateLibJumpHelper jumpHelper;

        /* renamed from: J, reason: from kotlin metadata */
        private final int nameTextBottomMargin;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final RoundCornerImageView coverView;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final TextView flagTextView;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private final TextView nameTextView;

        /* renamed from: N, reason: from kotlin metadata */
        @NotNull
        private final TextView descTextView;

        /* renamed from: P, reason: from kotlin metadata */
        @NotNull
        private final ImageView hotIcon;

        /* renamed from: Q, reason: from kotlin metadata */
        @Nullable
        private MetaMaterial material;

        /* renamed from: R, reason: from kotlin metadata */
        @Nullable
        private Drawable apngDrawable;

        /* renamed from: S, reason: from kotlin metadata */
        @NotNull
        private final ColorDrawable defaultDrawable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull View itemView, @Nullable Bundle bundle, int i3, int i16, int i17, @Nullable WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper, int i18) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.bundle = bundle;
            this.cornerRadius = i3;
            this.width = i16;
            this.height = i17;
            this.jumpHelper = winkQZoneTemplateLibJumpHelper;
            this.nameTextBottomMargin = i18;
            View findViewById = itemView.findViewById(R.id.f124007i7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026late_category_item_cover)");
            this.coverView = (RoundCornerImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f124107ig);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026e_template_lib_item_flag)");
            this.flagTextView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f124027i9);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026plate_category_item_name)");
            this.nameTextView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f124017i8);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026plate_category_item_desc)");
            this.descTextView = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f124417ja);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026nk_template_popular_icon)");
            this.hotIcon = (ImageView) findViewById5;
            this.defaultDrawable = new ColorDrawable(itemView.getContext().getColor(R.color.qui_common_bg_nav_bottom));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(d this$0, MetaCategory metaCategory, View it) {
            String str;
            String str2;
            Map<String, ?> mutableMapOf;
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this$0.jumpHelper;
            if (winkQZoneTemplateLibJumpHelper != null) {
                Context context = this$0.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                winkQZoneTemplateLibJumpHelper.k(context, this$0.bundle, this$0.material, metaCategory, "1");
            }
            Pair[] pairArr = new Pair[2];
            Integer num = null;
            if (metaCategory != null) {
                str = metaCategory.name;
            } else {
                str = null;
            }
            pairArr[0] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, str);
            MetaMaterial metaMaterial = this$0.material;
            if (metaMaterial != null) {
                str2 = metaMaterial.f30533id;
            } else {
                str2 = null;
            }
            pairArr[1] = TuplesKt.to("material_id", str2);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            MetaMaterial metaMaterial2 = this$0.material;
            if (metaMaterial2 != null) {
                num = Integer.valueOf(metaMaterial2.hashCode());
            }
            eVar.l(it, WinkDaTongReportConstant.ElementId.EM_QZ_INSPIRATION_DETAIL_EN, mutableMapOf, String.valueOf(num));
            EventCollector.getInstance().onViewClicked(it);
        }

        private final void r(final String dynamicCoverUrl, boolean noStaticUrl) {
            boolean z16;
            if (dynamicCoverUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            Option loadingDrawable = Option.obtain().setUrl(dynamicCoverUrl).setRequestWidth(this.width).setRequestHeight(this.height).setLoadingDrawable(this.defaultDrawable);
            Set set = WinkQZoneTemplateCategoryBaseView.H;
            String MODEL = DeviceInfoMonitor.getModel();
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            String upperCase = MODEL.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
            if (set.contains(upperCase)) {
                loadingDrawable.setPreferDecoder(com.tencent.qqnt.emotion.pic.libra.d.class);
            }
            QQPicLoader.f201806a.d().loadImage(loadingDrawable, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    WinkQZoneTemplateCategoryBaseView.d.s(dynamicCoverUrl, this, loadState, option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(String dynamicCoverUrl, final d this$0, LoadState loadState, Option option) {
            Intrinsics.checkNotNullParameter(dynamicCoverUrl, "$dynamicCoverUrl");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z16 = false;
            if (loadState != null && loadState.isFinishSuccess()) {
                z16 = true;
            }
            if (z16) {
                if (!Intrinsics.areEqual(option.getUrl(), dynamicCoverUrl)) {
                    QLog.e("WinkQZoneTemplateCategoryBaseView", 1, "url is not equals.");
                    return;
                }
                if (option.getAnimatable() instanceof com.tencent.qqnt.emotion.pic.libra.b) {
                    Animatable animatable = option.getAnimatable();
                    Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.qqnt.emotion.pic.libra.ApngDrawable");
                    this$0.apngDrawable = (com.tencent.qqnt.emotion.pic.libra.b) animatable;
                } else if (option.getAnimatable() instanceof z01.a) {
                    Animatable animatable2 = option.getAnimatable();
                    Intrinsics.checkNotNull(animatable2, "null cannot be cast to non-null type com.tencent.libra.extension.apng.APNGDrawable");
                    this$0.apngDrawable = (z01.a) animatable2;
                } else if (option.getAnimatable() instanceof c11.a) {
                    Animatable animatable3 = option.getAnimatable();
                    Intrinsics.checkNotNull(animatable3, "null cannot be cast to non-null type com.tencent.libra.extension.apng.lib.ApngLibDrawable");
                    this$0.apngDrawable = (c11.a) animatable3;
                }
                this$0.coverView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkQZoneTemplateCategoryBaseView.d.t(WinkQZoneTemplateCategoryBaseView.d.this);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(d this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.coverView.setImageDrawable(this$0.apngDrawable);
        }

        private final void u(View view) {
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
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QZ_INSPIRATION_LIBRARY_HOME);
            params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_QZ_INSPIRATION_DETAIL_EN);
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            MetaMaterial metaMaterial3 = this.material;
            if (metaMaterial3 != null) {
                str3 = metaMaterial3.f30533id;
            }
            eVar.e(view, WinkDaTongReportConstant.ElementId.EM_QZ_INSPIRATION_DETAIL_EN, params, str3);
        }

        private final void w(MetaMaterial material) {
            String str;
            final String str2;
            final boolean z16;
            boolean z17;
            boolean z18;
            String a06;
            final String str3 = "";
            if (material == null || (str = com.tencent.mobileqq.wink.editor.c.s0(material)) == null) {
                str = "";
            }
            if (material == null || (str2 = com.tencent.mobileqq.wink.editor.c.Z(material)) == null) {
                str2 = "";
            }
            if (material != null && (a06 = com.tencent.mobileqq.wink.editor.c.a0(material)) != null) {
                str3 = a06;
            }
            boolean z19 = false;
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (str.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (str2.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    QLog.e("WinkQZoneTemplateCategoryBaseView", 1, "name:" + str3 + ", cover url is empty.");
                    this.coverView.setImageDrawable(this.defaultDrawable);
                    return;
                }
            }
            if (str.length() == 0) {
                z19 = true;
            }
            if (z19) {
                QLog.e("WinkQZoneTemplateCategoryBaseView", 1, "name:" + str3 + ", only dynamic cover:" + str2);
                this.coverView.setImageDrawable(this.defaultDrawable);
                r(str2, z16);
                return;
            }
            QQPicLoader.f201806a.d().loadImage(Option.obtain().setUrl(str).setLoadingDrawable(this.defaultDrawable).setRequestWidth(this.width).setRequestHeight(this.height).setTargetView(this.coverView), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.b
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    WinkQZoneTemplateCategoryBaseView.d.x(WinkQZoneTemplateCategoryBaseView.d.this, str2, z16, str3, loadState, option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(d this$0, String dynamicCoverUrl, boolean z16, String name, LoadState loadState, Option option) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dynamicCoverUrl, "$dynamicCoverUrl");
            Intrinsics.checkNotNullParameter(name, "$name");
            if (loadState == LoadState.STATE_SUCCESS) {
                this$0.r(dynamicCoverUrl, z16);
                return;
            }
            if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                QLog.e("WinkQZoneTemplateCategoryBaseView", 1, "name:" + name + ", staticCover err, state:" + loadState);
                this$0.coverView.setImageDrawable(this$0.defaultDrawable);
                this$0.r(dynamicCoverUrl, z16);
            }
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
            int i3;
            ViewGroup.LayoutParams layoutParams = this.nameTextView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                MetaMaterial metaMaterial = this.material;
                boolean z16 = false;
                if (metaMaterial != null && com.tencent.mobileqq.wink.editor.c.F(metaMaterial)) {
                    z16 = true;
                }
                if (z16) {
                    i3 = ImmersiveUtils.dpToPx(10.0f);
                } else {
                    i3 = this.nameTextBottomMargin;
                }
                marginLayoutParams.bottomMargin = i3;
                this.nameTextView.setLayoutParams(layoutParams);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void p(@Nullable final MetaCategory category, int position) {
            MetaMaterial metaMaterial;
            String str;
            boolean z16;
            String str2;
            boolean z17;
            String str3;
            ArrayList<MetaMaterial> arrayList;
            this.itemView.getLayoutParams().width = this.width;
            this.itemView.getLayoutParams().height = this.height;
            String str4 = null;
            if (category != null && (arrayList = category.materials) != null) {
                metaMaterial = arrayList.get(position);
            } else {
                metaMaterial = null;
            }
            this.material = metaMaterial;
            TextView textView = this.nameTextView;
            if (metaMaterial == null || (str = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial)) == null) {
                str = "";
            }
            textView.setText(str);
            this.descTextView.setText(com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.e(this.material));
            MetaMaterial metaMaterial2 = this.material;
            boolean z18 = true;
            if (metaMaterial2 != null && com.tencent.mobileqq.wink.editor.c.F(metaMaterial2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.descTextView.setVisibility(8);
            } else {
                this.descTextView.setVisibility(0);
            }
            MetaMaterial metaMaterial3 = this.material;
            if (metaMaterial3 != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.d0(metaMaterial3);
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                this.flagTextView.setVisibility(8);
            } else {
                MetaMaterial metaMaterial4 = this.material;
                if (metaMaterial4 != null) {
                    str3 = com.tencent.mobileqq.wink.editor.c.d0(metaMaterial4);
                } else {
                    str3 = null;
                }
                if (Intrinsics.areEqual(str3, "\u70ed\u95e8")) {
                    MetaMaterial metaMaterial5 = this.material;
                    if (metaMaterial5 == null || com.tencent.mobileqq.wink.editor.c.F(metaMaterial5)) {
                        z18 = false;
                    }
                    if (z18) {
                        this.flagTextView.setVisibility(8);
                        y();
                    }
                }
                this.hotIcon.setVisibility(8);
                TextView textView2 = this.flagTextView;
                MetaMaterial metaMaterial6 = this.material;
                if (metaMaterial6 != null) {
                    str4 = com.tencent.mobileqq.wink.editor.c.d0(metaMaterial6);
                }
                textView2.setText(str4);
                this.flagTextView.setVisibility(0);
            }
            z();
            RoundCornerImageView roundCornerImageView = this.coverView;
            w(this.material);
            roundCornerImageView.setCorner(this.cornerRadius);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkQZoneTemplateCategoryBaseView.d.q(WinkQZoneTemplateCategoryBaseView.d.this, category, view);
                }
            });
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            u(itemView);
        }

        public final void v(@Nullable Drawable drawable) {
            this.apngDrawable = drawable;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
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

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"FRD-L19", "FRD-L14", "FRD-L04", "FRD-AL00", "FRD-TL00", "FRD-AL10", "FRD-L09", "FRD-L02", "FRD-L19", "FRD-L14", "FRD-DL00", "BKL-AL20", "BKL-L04", "BKL-L09", "BKL-AL00"});
        H = of5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkQZoneTemplateCategoryBaseView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void H0(View view) {
        RecyclerView.LayoutManager layoutManager;
        Map mutableMapOf;
        MetaMaterial metaMaterial;
        String str;
        String str2;
        ArrayList<MetaMaterial> arrayList;
        Object orNull;
        if (FastClickUtils.isFastDoubleClick("WinkQZoneTemplateCategoryBaseView")) {
            return;
        }
        RecyclerView recyclerView = this.recyclerview;
        String str3 = null;
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            MetaCategory metaCategory = this.category;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, findLastVisibleItemPosition);
                metaMaterial = (MetaMaterial) orNull;
            } else {
                metaMaterial = null;
            }
            String str4 = "";
            if (metaMaterial != null) {
                MetaCategory metaCategory2 = this.category;
                if (metaCategory2 != null) {
                    str2 = metaCategory2.f30532id;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                }
                com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, str2);
            }
            if (metaMaterial != null) {
                MetaCategory metaCategory3 = this.category;
                if (metaCategory3 != null) {
                    str = metaCategory3.name;
                } else {
                    str = null;
                }
                if (str != null) {
                    str4 = str;
                }
                com.tencent.mobileqq.wink.editor.c.p1(metaMaterial, str4);
            }
            J0(metaMaterial);
        }
        Pair[] pairArr = new Pair[1];
        MetaCategory metaCategory4 = this.category;
        if (metaCategory4 != null) {
            str3 = metaCategory4.name;
        }
        pairArr[0] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, str3);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        com.tencent.mobileqq.wink.report.e.m(com.tencent.mobileqq.wink.report.e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_QZ_MORE_BTN, mutableMapOf, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(WinkQZoneTemplateCategoryBaseView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.H0(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void J0(MetaMaterial targetPositionMaterial) {
        WinkQZoneTemplateLibMoreTemplateFragment winkQZoneTemplateLibMoreTemplateFragment = new WinkQZoneTemplateLibMoreTemplateFragment(this.categoriesData, targetPositionMaterial);
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.f155080vw, R.anim.f155082vy, R.anim.f155080vw, R.anim.f155082vy).add(((IAEEditorJumpUtil) QRoute.api(IAEEditorJumpUtil.class)).getFragmentContainerId((Activity) context), winkQZoneTemplateLibMoreTemplateFragment, "WinkQZoneTemplateLibMoreTemplateFragment").addToBackStack(null).commitAllowingStateLoss();
        }
    }

    private final void initView() {
        String str;
        View inflate = View.inflate(getContext(), C0(), this);
        this.labelView = (TextView) inflate.findViewById(R.id.f124117ih);
        this.recyclerview = (RecyclerView) inflate.findViewById(R.id.f124147ik);
        View findViewById = inflate.findViewById(R.id.f124137ij);
        this.moreView = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: t93.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkQZoneTemplateCategoryBaseView.I0(WinkQZoneTemplateCategoryBaseView.this, view);
                }
            });
        }
        TextView textView = this.labelView;
        if (textView != null) {
            MetaCategory metaCategory = this.category;
            if (metaCategory != null) {
                str = metaCategory.name;
            } else {
                str = null;
            }
            textView.setText(str);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.jumpHelper = new WinkQZoneTemplateLibJumpHelper(context, null);
        this.adapter = new a(this.category, this.bundle, F0(), G0(), E0(), B0(), this.jumpHelper, D0());
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(4);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setAdapter(this.adapter);
            recyclerView.addItemDecoration(new c());
            recyclerView.addOnScrollListener(new e());
        }
    }

    public abstract int B0();

    public abstract int C0();

    public abstract int D0();

    public abstract int E0();

    public abstract int F0();

    public abstract int G0();

    public final void release() {
        this.category = null;
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        RecyclerView recyclerView2 = this.recyclerview;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(null);
        }
        this.recyclerview = null;
    }

    public final void setCategory(@Nullable MetaCategory metaCategory) {
        this.category = metaCategory;
    }

    public final void setData(@Nullable Intent intent, @NotNull MetaCategory category, @NotNull WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
        String str;
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(categoriesData, "categoriesData");
        this.category = category;
        this.categoriesData = categoriesData;
        Bundle bundle = null;
        if (intent != null) {
            str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        } else {
            str = null;
        }
        this.traceId = str;
        if (intent != null) {
            bundle = intent.getExtras();
        }
        this.bundle = bundle;
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkQZoneTemplateCategoryBaseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.F = new LinkedHashMap();
    }

    public /* synthetic */ WinkQZoneTemplateCategoryBaseView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
