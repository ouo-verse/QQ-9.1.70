package com.tencent.mobileqq.wink.inspirationlibrary.part.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationTemplateUtils;
import com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationTemplateCategoryView;
import com.tencent.mobileqq.wink.templatelibrary.WinkTemplatePreviewFragment;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0004EFGHB\u001d\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J4\u0010\u0013\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001aR\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/a;", "", "initView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "C0", "show", "D0", "B0", "Landroid/content/Intent;", "intent", "", "index", "showLabel", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "templateSize", "setData", "showDynamicCover", "K", "refresh", "release", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "labelView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$a;", "f", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$a;", "adapter", tl.h.F, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "getCategory", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "setCategory", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "i", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", BdhLogUtil.LogTag.Tag_Conn, "emptyView", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "emptyLayout", "", "E", "Ljava/lang/String;", "traceId", "Landroid/os/Bundle;", UserInfo.SEX_FEMALE, "Landroid/os/Bundle;", "bundle", "G", "Landroid/content/Intent;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "I", "a", "b", "InspirationTemplateViewHolder", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkInspirationTemplateCategoryView extends ConstraintLayout implements com.tencent.mobileqq.wink.inspirationlibrary.part.view.a {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int J = ViewUtils.dpToPx(8.0f);
    private static int K = ViewUtils.dpToPx(12.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView emptyView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout emptyLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String traceId;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Bundle bundle;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Intent intent;

    @NotNull
    public Map<Integer, View> H;

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
    private boolean showLabel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WinkInspirationTemplateUtils.Companion.SIZE templateSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010M\u001a\u00020\u0019\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010,\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\bN\u0010OJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0006\u0010#\u001a\u00020\"J\"\u0010&\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$H\u0007R\u0016\u0010(\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0017\u00107\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b4\u00102\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0014\u0010;\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010'R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$InspirationTemplateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "staticCoverUrl", "dynamicCoverUrl", "", "noStaticUrl", "name", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "Landroid/content/Context;", "context", "v", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "mateCategory", ReportConstant.COSTREPORT_PREFIX, "category", "", "position", "w", "Landroid/view/View;", "view", "templateID", HippyTKDListViewAdapter.X, "show", "B", "Landroid/content/Intent;", "intent", "r", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "t", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "templateSize", "p", "Ljava/lang/String;", "traceId", "Landroid/os/Bundle;", UserInfo.SEX_FEMALE, "Landroid/os/Bundle;", "bundle", "G", "Lcom/tencent/mobileqq/wink/view/RoundCornerImageView;", "coverView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "flagTextView", "I", "getNameTextView", "()Landroid/widget/TextView;", "nameTextView", "J", "descTextView", "K", "useCount", "L", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Landroid/graphics/drawable/Drawable;", "M", "Landroid/graphics/drawable/Drawable;", "getApngDrawable", "()Landroid/graphics/drawable/Drawable;", "y", "(Landroid/graphics/drawable/Drawable;)V", "apngDrawable", "N", "Z", "showDynamic", "P", "_dynamicCoverUrl", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/content/Intent;", "itemView", "<init>", "(Landroid/view/View;Ljava/lang/String;Landroid/os/Bundle;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class InspirationTemplateViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final String traceId;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private final Bundle bundle;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final RoundCornerImageView coverView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView flagTextView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView nameTextView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView descTextView;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final TextView useCount;

        /* renamed from: L, reason: from kotlin metadata */
        @Nullable
        private MetaMaterial material;

        /* renamed from: M, reason: from kotlin metadata */
        @Nullable
        private Drawable apngDrawable;

        /* renamed from: N, reason: from kotlin metadata */
        private boolean showDynamic;

        /* renamed from: P, reason: from kotlin metadata */
        @Nullable
        private String _dynamicCoverUrl;

        /* renamed from: Q, reason: from kotlin metadata */
        @Nullable
        private Intent intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InspirationTemplateViewHolder(@NotNull View itemView, @Nullable String str, @Nullable Bundle bundle) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.traceId = str;
            this.bundle = bundle;
            View findViewById = itemView.findViewById(R.id.f123017fi);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026late_category_item_cover)");
            this.coverView = (RoundCornerImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f122977fe);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026nk_inspiration_item_flag)");
            this.flagTextView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f123037fk);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026plate_category_item_name)");
            this.nameTextView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f123027fj);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026plate_category_item_desc)");
            this.descTextView = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f123047fl);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026plate_category_use_count)");
            this.useCount = (TextView) findViewById5;
            this.showDynamic = true;
        }

        private final void A(final String dynamicCoverUrl, final boolean noStaticUrl) {
            boolean z16;
            if (!this.showDynamic && !noStaticUrl) {
                return;
            }
            if (dynamicCoverUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            final Option preferDecoder = Option.obtain().setUrl(dynamicCoverUrl).setRegionScaleType(ImageView.ScaleType.CENTER_CROP).setRequestWidth(this.coverView.getLayoutParams().width).setRequestHeight(this.coverView.getLayoutParams().height).setPreferDecoder(com.tencent.qqnt.emotion.pic.libra.d.class);
            QQPicLoader.f201806a.d().loadImage(preferDecoder, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.d
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    WinkInspirationTemplateCategoryView.InspirationTemplateViewHolder.C(Option.this, this, noStaticUrl, dynamicCoverUrl, loadState, option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(Option option, final InspirationTemplateViewHolder this$0, boolean z16, String dynamicCoverUrl, LoadState loadState, Option option2) {
            Animatable animatable;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dynamicCoverUrl, "$dynamicCoverUrl");
            boolean z17 = false;
            if (loadState != null && loadState.isFinishSuccess()) {
                z17 = true;
            }
            if (z17) {
                Animatable animatable2 = null;
                if (option != null) {
                    animatable = option.getAnimatable();
                } else {
                    animatable = null;
                }
                if (!(animatable instanceof z01.a)) {
                    if (option != null) {
                        animatable2 = option.getAnimatable();
                    }
                    if (!(animatable2 instanceof com.tencent.qqnt.emotion.pic.libra.b)) {
                        return;
                    }
                }
                if (!this$0.showDynamic && !z16) {
                    return;
                }
                if (!Intrinsics.areEqual(option.getUrl(), dynamicCoverUrl)) {
                    QLog.e("WinkInspirationTemplateCategoryView", 1, "url is not equals.");
                    return;
                }
                Object animatable3 = option.getAnimatable();
                Intrinsics.checkNotNull(animatable3, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                this$0.apngDrawable = (Drawable) animatable3;
                this$0._dynamicCoverUrl = dynamicCoverUrl;
                this$0.coverView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkInspirationTemplateCategoryView.InspirationTemplateViewHolder.D(WinkInspirationTemplateCategoryView.InspirationTemplateViewHolder.this);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(InspirationTemplateViewHolder this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.coverView.setImageDrawable(this$0.apngDrawable);
        }

        private final void E(String staticCoverUrl, final String dynamicCoverUrl, final boolean noStaticUrl, final String name) {
            QQPicLoader.f201806a.d().loadImage(Option.obtain().setUrl(staticCoverUrl).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a).setRegionScaleType(ImageView.ScaleType.CENTER_CROP).setRequestWidth(this.coverView.getLayoutParams().width).setRequestHeight(this.coverView.getLayoutParams().height).setPreferDecoder(com.tencent.qqnt.emotion.pic.libra.d.class).setTargetView(this.coverView), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.e
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    WinkInspirationTemplateCategoryView.InspirationTemplateViewHolder.H(WinkInspirationTemplateCategoryView.InspirationTemplateViewHolder.this, dynamicCoverUrl, noStaticUrl, name, loadState, option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(InspirationTemplateViewHolder this$0, String dynamicCoverUrl, boolean z16, String name, LoadState loadState, Option option) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dynamicCoverUrl, "$dynamicCoverUrl");
            Intrinsics.checkNotNullParameter(name, "$name");
            if (loadState == LoadState.STATE_SUCCESS) {
                this$0.A(dynamicCoverUrl, z16);
                return;
            }
            if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                QLog.e("WinkInspirationTemplateCategoryView", 1, "name:" + name + ", staticCover err, state:" + loadState);
                this$0.coverView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                this$0.A(dynamicCoverUrl, z16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(InspirationTemplateViewHolder this$0, MetaCategory metaCategory, int i3, View view) {
            String str;
            boolean z16;
            String str2;
            MaterialType materialType;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MetaMaterial metaMaterial = this$0.material;
            Intent intent = null;
            if (metaMaterial != null) {
                str = com.tencent.mobileqq.wink.editor.c.m0(metaMaterial);
            } else {
                str = null;
            }
            if (this$0.u()) {
                MetaMaterial metaMaterial2 = this$0.material;
                if (metaMaterial2 != null) {
                    materialType = com.tencent.mobileqq.wink.editor.c.T(metaMaterial2);
                } else {
                    materialType = null;
                }
                if (materialType == MaterialType.CAMERA) {
                    Context context = this$0.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    this$0.v(context, this$0.material);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String builder = Uri.parse(str).buildUpon().appendQueryParameter("feedtagpagefromtype", "101").appendQueryParameter("xsj_operation_activity_id", String.valueOf(WinkDatongCurrentParams.params.get("xsj_operation_activity_id"))).toString();
                Intrinsics.checkNotNullExpressionValue(builder, "parse(schema).buildUpon(\u2026             ).toString()");
                com.tencent.mobileqq.wink.f.l(this$0.itemView.getContext(), builder);
            } else {
                this$0.w(metaCategory, i3, this$0.material);
                MetaMaterial metaMaterial3 = this$0.material;
                if (metaMaterial3 != null && (str2 = metaMaterial3.f30533id) != null) {
                    Context context2 = this$0.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                    Activity i16 = KRCSSViewExtensionKt.i(context2);
                    if (i16 != null) {
                        intent = i16.getIntent();
                    }
                    t53.a.a(intent, "libTemplate", str2, new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationTemplateCategoryView$InspirationTemplateViewHolder$bindData$1$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                            invoke2(aVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                            Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                            dc5507Report.b(1003);
                            dc5507Report.j(2);
                        }
                    });
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final MetaCategory s(MetaCategory mateCategory) {
            boolean z16;
            ArrayList<MetaMaterial> arrayList = mateCategory.materials;
            Intrinsics.checkNotNullExpressionValue(arrayList, "mateCategory.materials");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                MetaMaterial it = (MetaMaterial) obj;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                boolean z17 = false;
                if (com.tencent.mobileqq.wink.editor.c.T(it) != MaterialType.H5 && com.tencent.mobileqq.wink.editor.c.T(it) != MaterialType.CAMERA) {
                    if (com.tencent.mobileqq.wink.editor.c.m0(it).length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                if (z17) {
                    arrayList2.add(obj);
                }
            }
            return new MetaCategory(mateCategory.f30532id, mateCategory.name, mateCategory.thumbUrl, mateCategory.subCategories, new ArrayList(arrayList2), mateCategory.dynamicFields);
        }

        private final boolean u() {
            String str;
            Bundle bundle = this.bundle;
            if (bundle != null) {
                str = bundle.getString(QQWinkConstants.ENTRY_BUSINESS_NAME);
            } else {
                str = null;
            }
            return Intrinsics.areEqual(str, "QZONE");
        }

        private final void v(Context context, MetaMaterial material) {
            String str;
            if (material != null) {
                str = material.f30533id;
            } else {
                str = null;
            }
            w53.b.f("TemplateViewHolder", "jumpToCamera = " + str);
            if (material == null) {
                return;
            }
            Bundle bundle = this.bundle;
            if (bundle != null) {
                bundle.putInt("JUMP_FROM_KEY", 104);
            }
            f83.a.b(context, material, this.bundle);
        }

        private final void w(MetaCategory category, int position, MetaMaterial material) {
            MetaCategory metaCategory;
            ArrayList<MetaMaterial> arrayList;
            Intent intent = new Intent();
            Bundle bundle = this.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.setClass(this.itemView.getContext(), QQWinkActivity.class);
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, this.traceId);
            ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).addUseProfileThemeFlag(intent);
            intent.putExtra("public_fragment_class", WinkTemplatePreviewFragment.class.getName());
            MaterialType materialType = null;
            if (category != null) {
                metaCategory = s(category);
            } else {
                metaCategory = null;
            }
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                position = arrayList.indexOf(material);
            }
            boolean z16 = false;
            int max = Math.max(0, position - 100);
            if (metaCategory != null) {
                metaCategory.materials = new ArrayList<>(metaCategory.materials.subList(max, Math.min(position + 100, metaCategory.materials.size())));
            }
            if (metaCategory == null) {
                metaCategory = new MetaCategory();
            }
            intent.putExtra("category", metaCategory);
            intent.putExtra("position", position - max);
            if (material != null) {
                materialType = com.tencent.mobileqq.wink.editor.c.T(material);
            }
            if (materialType == MaterialType.AUTO_TEMPLATE) {
                z16 = true;
            }
            if (z16) {
                intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_PREVIEW_PAGE_TYPE, "auto_video");
                intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, "template");
            } else {
                intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_PREVIEW_PAGE_TYPE, "template");
            }
            if (WinkContext.INSTANCE.d().u("QZONE")) {
                intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, "normal_material");
            }
            this.itemView.getContext().startActivity(intent);
        }

        private final void x(View view, String name, String templateID) {
            boolean z16;
            if (name != null && name.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.w("InspirationTemplateViewHolder", 1, "[registerDatongElement] invalid name");
                return;
            }
            VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY_ITEM);
            VideoReport.setElementParam(view, WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, name);
            VideoReport.setElementParam(view, "xsj_template_id", templateID);
            VideoReport.setElementReuseIdentifier(view, name);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void z(MetaMaterial material) {
            String str;
            String str2;
            boolean z16;
            boolean z17;
            boolean z18;
            String a06;
            boolean z19;
            String str3 = "";
            boolean z26 = false;
            if (material != null && (str = com.tencent.mobileqq.wink.editor.c.s0(material)) != null) {
                if (str.length() == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    str = material.thumbUrl;
                    if (str != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "material.thumbUrl ?: \"\"");
                    }
                }
                if (material != null || (str2 = com.tencent.mobileqq.wink.editor.c.Z(material)) == null) {
                    str2 = "";
                }
                if (material != null && (a06 = com.tencent.mobileqq.wink.editor.c.a0(material)) != null) {
                    str3 = a06;
                }
                if (str.length() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (str.length() != 0) {
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
                        QLog.e("WinkInspirationTemplateCategoryView", 1, "name:" + str3 + ", cover url is empty.");
                        this.coverView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                        return;
                    }
                }
                if (str.length() == 0) {
                    z26 = true;
                }
                if (!z26) {
                    QLog.e("WinkInspirationTemplateCategoryView", 1, "name:" + str3 + ", only dynamic cover:" + str2);
                    this.coverView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                    A(str2, z16);
                    return;
                }
                if (Intrinsics.areEqual(this._dynamicCoverUrl, str2)) {
                    QLog.e("WinkInspirationTemplateCategoryView", 1, "name:" + str3 + ", show dynamic cover from tag:" + str2);
                    if (this.showDynamic) {
                        A(str2, z16);
                        return;
                    } else {
                        E(str, str2, z16, str3);
                        return;
                    }
                }
                E(str, str2, z16, str3);
                return;
            }
            str = "";
            if (material != null) {
            }
            str2 = "";
            if (material != null) {
                str3 = a06;
            }
            if (str.length() != 0) {
            }
            if (str.length() != 0) {
            }
            if (z17) {
            }
            if (str.length() == 0) {
            }
            if (!z26) {
            }
        }

        public final void B(boolean show) {
            this.showDynamic = show;
        }

        @SuppressLint({"SetTextI18n"})
        public final void p(@Nullable final MetaCategory category, final int position, @NotNull WinkInspirationTemplateUtils.Companion.SIZE templateSize) {
            MetaMaterial metaMaterial;
            String str;
            String substringAfter$default;
            String str2;
            boolean z16;
            String str3;
            String str4;
            ArrayList<MetaMaterial> arrayList;
            MetaMaterial metaMaterial2;
            ArrayList<MetaMaterial> arrayList2;
            MetaMaterial metaMaterial3;
            String q06;
            ArrayList<MetaMaterial> arrayList3;
            Intrinsics.checkNotNullParameter(templateSize, "templateSize");
            String str5 = null;
            if (category != null && (arrayList3 = category.materials) != null) {
                metaMaterial = arrayList3.get(position);
            } else {
                metaMaterial = null;
            }
            this.material = metaMaterial;
            TextView textView = this.nameTextView;
            String str6 = "";
            if (metaMaterial == null || (str = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial)) == null) {
                str = "";
            }
            textView.setText(str);
            TextView textView2 = this.descTextView;
            MetaMaterial metaMaterial4 = this.material;
            if (metaMaterial4 != null && (q06 = com.tencent.mobileqq.wink.editor.c.q0(metaMaterial4)) != null) {
                str6 = q06;
            }
            substringAfter$default = StringsKt__StringsKt.substringAfter$default(str6, "\u00b7", (String) null, 2, (Object) null);
            textView2.setText(substringAfter$default);
            if (templateSize == WinkInspirationTemplateUtils.Companion.SIZE.EXP_BIG || templateSize == WinkInspirationTemplateUtils.Companion.SIZE.EXP_NORMAL) {
                this.useCount.setText(qa3.a.f428766a.a(this.material));
            }
            MetaMaterial metaMaterial5 = this.material;
            if (metaMaterial5 != null) {
                str2 = com.tencent.mobileqq.wink.editor.c.d0(metaMaterial5);
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.flagTextView.setVisibility(8);
            } else {
                TextView textView3 = this.flagTextView;
                MetaMaterial metaMaterial6 = this.material;
                if (metaMaterial6 != null) {
                    str3 = com.tencent.mobileqq.wink.editor.c.d0(metaMaterial6);
                } else {
                    str3 = null;
                }
                textView3.setText(str3);
                this.flagTextView.setVisibility(0);
            }
            RoundCornerImageView roundCornerImageView = this.coverView;
            z(this.material);
            roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkInspirationTemplateCategoryView.InspirationTemplateViewHolder.q(WinkInspirationTemplateCategoryView.InspirationTemplateViewHolder.this, category, position, view);
                }
            });
            RoundCornerImageView roundCornerImageView2 = this.coverView;
            if (category != null && (arrayList2 = category.materials) != null && (metaMaterial3 = arrayList2.get(position)) != null) {
                str4 = com.tencent.mobileqq.wink.editor.c.a0(metaMaterial3);
            } else {
                str4 = null;
            }
            if (category != null && (arrayList = category.materials) != null && (metaMaterial2 = arrayList.get(position)) != null) {
                str5 = metaMaterial2.f30533id;
            }
            x(roundCornerImageView2, str4, str5);
        }

        public final void r(@Nullable Intent intent) {
            this.intent = intent;
        }

        @NotNull
        /* renamed from: t, reason: from getter */
        public final RoundCornerImageView getCoverView() {
            return this.coverView;
        }

        public final void y(@Nullable Drawable drawable) {
            this.apngDrawable = drawable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\b\u0010+\u001a\u0004\u0018\u00010&\u0012\b\u00101\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b?\u0010@J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010+\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u00101\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00108R\u0016\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00108R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00108\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$InspirationTemplateViewHolder;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "templateSize", "", "p0", "", "j0", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "position", "k0", "getItemCount", "", "show", "q0", "m0", "n0", "o0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "getCategory", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "setCategory", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "category", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTraceId", "()Ljava/lang/String;", "traceId", "Landroid/os/Bundle;", "D", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "Landroid/content/Intent;", "E", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", UserInfo.SEX_FEMALE, "Z", "showDynamicCover", "G", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "H", "I", "itemLayoutId", "itemWidthPx", "J", "itemHeightPx", "K", "coverCornerPx", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Ljava/lang/String;Landroid/os/Bundle;Landroid/content/Intent;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<InspirationTemplateViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private final String traceId;

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private final Bundle bundle;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final Intent intent;

        /* renamed from: F, reason: from kotlin metadata */
        private boolean showDynamicCover;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private WinkInspirationTemplateUtils.Companion.SIZE templateSize;

        /* renamed from: H, reason: from kotlin metadata */
        private int itemLayoutId;

        /* renamed from: I, reason: from kotlin metadata */
        private int itemWidthPx;

        /* renamed from: J, reason: from kotlin metadata */
        private int itemHeightPx;

        /* renamed from: K, reason: from kotlin metadata */
        private int coverCornerPx;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private MetaCategory category;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationTemplateCategoryView$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public /* synthetic */ class C9052a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f323047a;

            static {
                int[] iArr = new int[WinkInspirationTemplateUtils.Companion.SIZE.values().length];
                try {
                    iArr[WinkInspirationTemplateUtils.Companion.SIZE.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WinkInspirationTemplateUtils.Companion.SIZE.EXP_NORMAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[WinkInspirationTemplateUtils.Companion.SIZE.EXP_BIG.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f323047a = iArr;
            }
        }

        public a(@Nullable MetaCategory metaCategory, @Nullable String str, @Nullable Bundle bundle, @Nullable Intent intent) {
            this.category = metaCategory;
            this.traceId = str;
            this.bundle = bundle;
            this.intent = intent;
            WinkInspirationTemplateUtils.Companion.SIZE size = WinkInspirationTemplateUtils.Companion.SIZE.DEFAULT;
            this.templateSize = size;
            this.itemLayoutId = R.layout.i5l;
            WinkInspirationTemplateUtils.Companion companion = WinkInspirationTemplateUtils.INSTANCE;
            int e16 = companion.e(size);
            this.itemWidthPx = e16;
            this.itemHeightPx = companion.a(e16, this.templateSize);
            this.coverCornerPx = WinkInspirationTemplateCategoryView.INSTANCE.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            ArrayList<MetaMaterial> arrayList;
            MetaCategory metaCategory = this.category;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                return arrayList.size();
            }
            return 0;
        }

        public final int i0(@NotNull WinkInspirationTemplateUtils.Companion.SIZE templateSize) {
            Intrinsics.checkNotNullParameter(templateSize, "templateSize");
            if (templateSize == WinkInspirationTemplateUtils.Companion.SIZE.EXP_BIG) {
                return WinkInspirationTemplateCategoryView.INSTANCE.b();
            }
            return WinkInspirationTemplateCategoryView.INSTANCE.a();
        }

        public final int j0(@NotNull WinkInspirationTemplateUtils.Companion.SIZE templateSize) {
            Intrinsics.checkNotNullParameter(templateSize, "templateSize");
            int i3 = C9052a.f323047a[templateSize.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return R.layout.i5m;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return R.layout.i5n;
            }
            return R.layout.i5l;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull InspirationTemplateViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.B(this.showDynamicCover);
            holder.r(this.intent);
            holder.p(this.category, position, this.templateSize);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public InspirationTemplateViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(this.itemLayoutId, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            InspirationTemplateViewHolder inspirationTemplateViewHolder = new InspirationTemplateViewHolder(itemView, this.traceId, this.bundle);
            ViewGroup.LayoutParams layoutParams = inspirationTemplateViewHolder.getCoverView().getLayoutParams();
            layoutParams.width = this.itemWidthPx;
            layoutParams.height = this.itemHeightPx;
            inspirationTemplateViewHolder.getCoverView().setLayoutParams(layoutParams);
            inspirationTemplateViewHolder.getCoverView().setCorner(this.coverCornerPx);
            return inspirationTemplateViewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void onViewAttachedToWindow(@NotNull InspirationTemplateViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewAttachedToWindow(holder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void onViewDetachedFromWindow(@NotNull InspirationTemplateViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewDetachedFromWindow(holder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(@NotNull InspirationTemplateViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewRecycled(holder);
            holder.y(null);
        }

        public final void p0(@NotNull WinkInspirationTemplateUtils.Companion.SIZE templateSize) {
            Intrinsics.checkNotNullParameter(templateSize, "templateSize");
            this.templateSize = templateSize;
            this.itemLayoutId = j0(templateSize);
            WinkInspirationTemplateUtils.Companion companion = WinkInspirationTemplateUtils.INSTANCE;
            int e16 = companion.e(templateSize);
            this.itemWidthPx = e16;
            this.itemHeightPx = companion.a(e16, templateSize);
            this.coverCornerPx = i0(templateSize);
        }

        public final void q0(boolean show) {
            if (this.showDynamicCover == show) {
                return;
            }
            this.showDynamicCover = show;
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$b;", "", "", "CATEGORY_ITEM_CORNER_PX", "I", "a", "()I", "setCATEGORY_ITEM_CORNER_PX", "(I)V", "CATEGORY_ITEM_HOT_CORNER_PX", "b", "setCATEGORY_ITEM_HOT_CORNER_PX", "ITEM_VIEW_CACHE_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationTemplateCategoryView$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return WinkInspirationTemplateCategoryView.J;
        }

        public final int b() {
            return WinkInspirationTemplateCategoryView.K;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "firstLeftMarginPx", "e", "leftMarginPx", "f", "rightMarginPx", "<init>", "()V", tl.h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int firstLeftMarginPx = ImmersiveUtils.dpToPx(16.0f);

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int leftMarginPx = ImmersiveUtils.dpToPx(4.5f);

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int rightMarginPx = ImmersiveUtils.dpToPx(4.5f);

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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/view/WinkInspirationTemplateCategoryView$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkInspirationTemplateCategoryView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B0() {
        String str;
        MetaCategory metaCategory = this.category;
        String str2 = null;
        if (metaCategory != null) {
            str = metaCategory.f30532id;
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        if (metaCategory != null) {
            str2 = metaCategory.name;
        }
        if (str2 != null) {
            str3 = str2;
        }
        VideoReport.setElementId(this, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY_CATEGORY);
        VideoReport.setElementParam(this, WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIBRARY_CATEGORY_ID, str);
        VideoReport.setElementParam(this, WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIBRARY_CATEGORY_NAME, str3);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
    }

    private final boolean C0(MetaCategory category) {
        String str;
        if (category != null) {
            str = category.f30532id;
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "TEMPLATE_FAVORITE");
    }

    private final void D0(boolean show) {
        if (show) {
            FrameLayout frameLayout = this.emptyLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.emptyLayout;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
    
        if (r0 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        boolean z16;
        ArrayList<MetaMaterial> arrayList;
        boolean z17;
        TextView textView;
        View inflate = View.inflate(getContext(), R.layout.i5t, this);
        this.labelView = (TextView) inflate.findViewById(R.id.f123067fn);
        this.recyclerview = (RecyclerView) inflate.findViewById(R.id.f123007fh);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f123097fq);
        this.emptyView = textView2;
        if (textView2 != null) {
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            WinkInspirationTemplateUtils.Companion companion = WinkInspirationTemplateUtils.INSTANCE;
            int e16 = companion.e(this.templateSize);
            layoutParams.width = -1;
            layoutParams.height = companion.a(e16, this.templateSize);
            textView2.setGravity(17);
            textView2.setLayoutParams(layoutParams);
        }
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.f123057fm);
        this.emptyLayout = frameLayout;
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
            WinkInspirationTemplateUtils.Companion companion2 = WinkInspirationTemplateUtils.INSTANCE;
            int e17 = companion2.e(this.templateSize);
            layoutParams2.width = -1;
            layoutParams2.height = companion2.a(e17, this.templateSize);
            frameLayout.setLayoutParams(layoutParams2);
        }
        if (!this.showLabel && (textView = this.labelView) != null) {
            textView.setVisibility(8);
        }
        String str = null;
        if (C0(this.category)) {
            MetaCategory metaCategory = this.category;
            if (metaCategory != null) {
                arrayList = metaCategory.materials;
            } else {
                arrayList = null;
            }
            z16 = true;
            if (arrayList != null && !arrayList.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
        }
        z16 = false;
        D0(z16);
        TextView textView3 = this.labelView;
        if (textView3 != null) {
            MetaCategory metaCategory2 = this.category;
            if (metaCategory2 != null) {
                str = metaCategory2.name;
            }
            textView3.setText(str);
        }
        a aVar = new a(this.category, this.traceId, this.bundle, this.intent);
        aVar.p0(this.templateSize);
        this.adapter = aVar;
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(4);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setAdapter(this.adapter);
            recyclerView.addItemDecoration(new c());
            recyclerView.addOnScrollListener(new d());
        }
    }

    public static /* synthetic */ void setData$default(WinkInspirationTemplateCategoryView winkInspirationTemplateCategoryView, Intent intent, int i3, MetaCategory metaCategory, boolean z16, WinkInspirationTemplateUtils.Companion.SIZE size, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            size = WinkInspirationTemplateUtils.Companion.SIZE.DEFAULT;
        }
        winkInspirationTemplateCategoryView.setData(intent, i3, metaCategory, z17, size);
    }

    @Override // com.tencent.mobileqq.wink.inspirationlibrary.part.view.a
    public void K(boolean showDynamicCover) {
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.q0(showDynamicCover);
        }
    }

    @Override // com.tencent.mobileqq.wink.inspirationlibrary.part.view.a
    public void refresh() {
        ArrayList<MetaMaterial> arrayList;
        boolean z16;
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        boolean z17 = false;
        if (C0(this.category)) {
            MetaCategory metaCategory = this.category;
            if (metaCategory != null) {
                arrayList = metaCategory.materials;
            } else {
                arrayList = null;
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                z17 = true;
            }
        }
        D0(z17);
    }

    @Override // com.tencent.mobileqq.wink.inspirationlibrary.part.view.a
    public void release() {
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
        this.emptyView = null;
    }

    public final void setCategory(@Nullable MetaCategory metaCategory) {
        this.category = metaCategory;
    }

    public final void setData(@Nullable Intent intent, int index, @NotNull MetaCategory category, boolean showLabel, @NotNull WinkInspirationTemplateUtils.Companion.SIZE templateSize) {
        String str;
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(templateSize, "templateSize");
        this.intent = intent;
        this.category = category;
        this.showLabel = showLabel;
        this.templateSize = templateSize;
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
        B0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkInspirationTemplateCategoryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.H = new LinkedHashMap();
        this.showLabel = true;
        this.templateSize = WinkInspirationTemplateUtils.Companion.SIZE.DEFAULT;
    }

    public /* synthetic */ WinkInspirationTemplateCategoryView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
