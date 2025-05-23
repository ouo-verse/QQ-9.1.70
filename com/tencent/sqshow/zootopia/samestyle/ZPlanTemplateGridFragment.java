package com.tencent.sqshow.zootopia.samestyle;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanDebugHelper;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.activity.ZplanHostActivity;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPageFrom;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateGridFragment;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.state.report.SquareReportConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 j2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003klmB\u0007\u00a2\u0006\u0004\bi\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002JD\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r22\u0010\u0013\u001a.\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J(\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016J&\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001a\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020/2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\u0006\u00105\u001a\u00020\u0004J\u0006\u00106\u001a\u00020\u0004J\u0018\u0010:\u001a\u00020\u00042\u0006\u00108\u001a\u0002072\b\b\u0001\u00109\u001a\u00020 J\b\u0010;\u001a\u00020\u0001H\u0016R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00120>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001c\u00109\u001a\u00020 8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\bB\u0010C\u0012\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010g\u00a8\u0006n"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment;", "Landroidx/fragment/app/Fragment;", "Lvc4/h;", "", "", "Wh", "Xh", "ci", "Rh", "di", "Sh", "fi", "Vh", "", "page", "Lkotlin/Function5;", "", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "callback", "ai", DKConfiguration.Directory.TEMPLATES, "Qh", "postion", "template", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment$c;", "holder", "Lcom/tencent/sqshow/zootopia/samestyle/q;", "sizeHelper", "Lh", "Oh", "bi", "", "url", "Kh", "Th", "Nh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onDestroyView", "onShow", "Yh", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "cat", "from", "Zh", "getFragment", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "", "D", "Ljava/util/List;", "templateList", "E", "Ljava/lang/String;", "getFrom$annotations", "()V", UserInfo.SEX_FEMALE, "J", "templateTabId", "G", "I", "currentPage", "H", "totalPage", "Z", "isLoading", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "K", "Landroid/view/View;", "emptyPageView", "Lcom/tencent/sqshow/zootopia/view/ZootopiaLoadFailView;", "L", "Lcom/tencent/sqshow/zootopia/view/ZootopiaLoadFailView;", "mErrorView", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", "M", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", "mShimmerView", "N", "Lcom/tencent/sqshow/zootopia/samestyle/q;", "mSizeHelper", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "P", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "mSource", "Landroid/app/Dialog;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/app/Dialog;", "mWaitingDialog", "<init>", BdhLogUtil.LogTag.Tag_Req, "a", "b", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTemplateGridFragment extends Fragment implements vc4.h<Long> {

    /* renamed from: R */
    public static final Companion INSTANCE = new Companion(null);
    private static final id3.d S = new id3.d(null, 1, null);

    /* renamed from: F */
    private long templateTabId;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentPage;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: J, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: K, reason: from kotlin metadata */
    private View emptyPageView;

    /* renamed from: L, reason: from kotlin metadata */
    private ZootopiaLoadFailView mErrorView;

    /* renamed from: M, reason: from kotlin metadata */
    private ShimmerLinearLayout mShimmerView;

    /* renamed from: Q */
    private Dialog mWaitingDialog;

    /* renamed from: C */
    private ZPlanTemplateCat cat = ZPlanTemplateCat.INSTANCE.a();

    /* renamed from: D, reason: from kotlin metadata */
    private List<ZPlanTemplate> templateList = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    private String from = SameStyleContentPageFrom.FROM_SAME_STYLE;

    /* renamed from: H, reason: from kotlin metadata */
    private int totalPage = -1;

    /* renamed from: N, reason: from kotlin metadata */
    private final q mSizeHelper = new q();

    /* renamed from: P, reason: from kotlin metadata */
    private ZootopiaSource mSource = ZootopiaSource.INSTANCE.g();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment$a;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "cat", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "zootopiaSource", "", "from", "Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment;", "a", "KEY_TEMPLATE_CAT", "Ljava/lang/String;", "TAG", "", "TYPE_TEMPLATE", "I", "Lid3/d;", "reporter", "Lid3/d;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateGridFragment$a */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanTemplateGridFragment a(ZPlanTemplateCat cat, ZootopiaSource zootopiaSource, @SameStyleContentPageFrom String from, Bundle r65) {
            Intrinsics.checkNotNullParameter(cat, "cat");
            Intrinsics.checkNotNullParameter(zootopiaSource, "zootopiaSource");
            Intrinsics.checkNotNullParameter(from, "from");
            ZPlanTemplateGridFragment zPlanTemplateGridFragment = new ZPlanTemplateGridFragment();
            if (r65 == null) {
                r65 = new Bundle();
            }
            r65.putSerializable("template_cat", cat);
            r65.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, zootopiaSource);
            r65.putString("KEY_FROM", from);
            zPlanTemplateGridFragment.setArguments(r65);
            return zPlanTemplateGridFragment;
        }

        Companion() {
        }

        public static /* synthetic */ ZPlanTemplateGridFragment b(Companion companion, ZPlanTemplateCat zPlanTemplateCat, ZootopiaSource zootopiaSource, String str, Bundle bundle, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = SameStyleContentPageFrom.FROM_SAME_STYLE;
            }
            if ((i3 & 8) != 0) {
                bundle = null;
            }
            return companion.a(zPlanTemplateCat, zootopiaSource, str, bundle);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "getItemViewType", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "", "onBindViewHolder", "Lcom/tencent/sqshow/zootopia/samestyle/q;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/samestyle/q;", "getSizeHelper", "()Lcom/tencent/sqshow/zootopia/samestyle/q;", "sizeHelper", "<init>", "(Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment;Lcom/tencent/sqshow/zootopia/samestyle/q;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        final /* synthetic */ ZPlanTemplateGridFragment C;

        /* renamed from: m */
        private final q sizeHelper;

        public b(ZPlanTemplateGridFragment zPlanTemplateGridFragment, q sizeHelper) {
            Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
            this.C = zPlanTemplateGridFragment;
            this.sizeHelper = sizeHelper;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.C.templateList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof c) {
                c cVar = (c) holder;
                cVar.s();
                ZPlanTemplate zPlanTemplate = (ZPlanTemplate) this.C.templateList.get(position);
                this.C.Lh(position, zPlanTemplate, cVar, this.sizeHelper);
                id3.d dVar = ZPlanTemplateGridFragment.S;
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ZPlanTemplateGridFragment zPlanTemplateGridFragment = this.C;
                linkedHashMap.put("zplan_tab_id", zPlanTemplateGridFragment.cat.getId());
                linkedHashMap.put("zplan_tab_name", zPlanTemplateGridFragment.cat.getName());
                linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate.getId()));
                linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(zPlanTemplate.getContentType()));
                Unit unit = Unit.INSTANCE;
                id3.d.h(dVar, view, "em_zplan_samestyle_template", linkedHashMap, false, true, String.valueOf(zPlanTemplate.getId()), 8, null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r46, int viewType) {
            Intrinsics.checkNotNullParameter(r46, "parent");
            if (viewType == 1) {
                View inflate = LayoutInflater.from(this.C.getContext()).inflate(R.layout.f167396d33, r46, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(\n \u2026                        )");
                return new c(inflate, this.C.mSizeHelper);
            }
            throw new IllegalStateException(("unsupported view type = " + viewType).toString());
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00101\u001a\u00020\u001f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b2\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00100\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", ReportConstant.COSTREPORT_PREFIX, "u", "t", "Lcom/tencent/sqshow/zootopia/samestyle/q;", "E", "Lcom/tencent/sqshow/zootopia/samestyle/q;", "sizeHelper", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "getContentContainer", "()Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "contentContainer", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "r", "()Landroid/widget/ImageView;", "videoIcon", "H", "o", "newIcon", "Lcom/tencent/image/URLImageView;", "I", "Lcom/tencent/image/URLImageView;", "l", "()Lcom/tencent/image/URLImageView;", "cover", "Landroid/view/View;", "J", "Landroid/view/View;", "getContent", "()Landroid/view/View;", "content", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mask", "Landroid/widget/TextView;", "L", "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "title", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "useTxv", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/sqshow/zootopia/samestyle/q;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final q sizeHelper;

        /* renamed from: F */
        private final RoundCorneredRelativeLayout contentContainer;

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView videoIcon;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView newIcon;

        /* renamed from: I, reason: from kotlin metadata */
        private final URLImageView cover;

        /* renamed from: J, reason: from kotlin metadata */
        private final View content;

        /* renamed from: K, reason: from kotlin metadata */
        private final URLImageView mask;

        /* renamed from: L, reason: from kotlin metadata */
        private final TextView title;

        /* renamed from: M, reason: from kotlin metadata */
        private final TextView useTxv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View itemView, q sizeHelper) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
            this.sizeHelper = sizeHelper;
            View findViewById = itemView.findViewById(R.id.f163508qi1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.rlContentContainer)");
            this.contentContainer = (RoundCorneredRelativeLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.q3z);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.ivVideoIcon)");
            this.videoIcon = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.q3y);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.ivNewIcon)");
            this.newIcon = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.q3v);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.ivCover)");
            this.cover = (URLImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f163507qi0);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.rlContent)");
            this.content = findViewById5;
            View findViewById6 = itemView.findViewById(R.id.q3x);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.ivMask)");
            this.mask = (URLImageView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.qt6);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.tvTitle)");
            this.title = (TextView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.qvp);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.useTxv)");
            this.useTxv = (TextView) findViewById8;
            s();
        }

        /* renamed from: l, reason: from getter */
        public final URLImageView getCover() {
            return this.cover;
        }

        /* renamed from: m, reason: from getter */
        public final URLImageView getMask() {
            return this.mask;
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getNewIcon() {
            return this.newIcon;
        }

        /* renamed from: p, reason: from getter */
        public final TextView getTitle() {
            return this.title;
        }

        /* renamed from: q, reason: from getter */
        public final TextView getUseTxv() {
            return this.useTxv;
        }

        /* renamed from: r, reason: from getter */
        public final ImageView getVideoIcon() {
            return this.videoIcon;
        }

        public final void s() {
            float mItemRadius = this.sizeHelper.getMItemRadius();
            this.contentContainer.setRadius(mItemRadius, mItemRadius, mItemRadius, mItemRadius);
            ViewGroup.LayoutParams layoutParams = this.contentContainer.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(0, -2);
            }
            layoutParams.width = this.sizeHelper.getMSingleWidth();
            layoutParams.height = this.sizeHelper.getMSinglePicHeight();
            this.contentContainer.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.itemView.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(0, -2);
            }
            layoutParams2.width = this.sizeHelper.getMSingleWidth();
            this.itemView.setLayoutParams(layoutParams2);
        }

        public final void t() {
            this.mask.setVisibility(8);
            this.content.setVisibility(0);
        }

        public final void u() {
            this.mask.setVisibility(0);
            this.content.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment$d", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "onLoadCanceled", "", "p1", "onLoadFialed", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements URLDrawable.URLDrawableListener {

        /* renamed from: d */
        final /* synthetic */ c f372831d;

        /* renamed from: e */
        final /* synthetic */ ZPlanTemplateGridFragment f372832e;

        d(c cVar, ZPlanTemplateGridFragment zPlanTemplateGridFragment) {
            this.f372831d = cVar;
            this.f372832e = zPlanTemplateGridFragment;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
            QLog.i("ZPlanSameStyle", 1, "onLoadCanceled");
            if (Intrinsics.areEqual(p06, this.f372831d.getCover().getDrawable())) {
                this.f372832e.Th(this.f372831d);
            }
            if (p06 != null) {
                p06.setURLDrawableListener(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            QLog.i("ZPlanSameStyle", 1, "onLoadFialed");
            if (Intrinsics.areEqual(p06, this.f372831d.getCover().getDrawable())) {
                this.f372832e.Th(this.f372831d);
            }
            if (p06 != null) {
                p06.setURLDrawableListener(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            QLog.i("ZPlanSameStyle", 1, "onLoadSuccessed");
            if (Intrinsics.areEqual(p06, this.f372831d.getCover().getDrawable())) {
                this.f372832e.Th(this.f372831d);
            }
            if (p06 != null) {
                p06.setURLDrawableListener(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment$e", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends RecyclerView.ItemDecoration {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView r46, RecyclerView.State state) {
            int mRightItemLeftMargin;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(r46, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = (r46.getChildAdapterPosition(view) % ZPlanTemplateGridFragment.this.mSizeHelper.getMSpanCount()) % 2;
            if (childAdapterPosition == 0) {
                mRightItemLeftMargin = ZPlanTemplateGridFragment.this.mSizeHelper.getMLeftAndRightMarin();
            } else {
                mRightItemLeftMargin = ZPlanTemplateGridFragment.this.mSizeHelper.getMRightItemLeftMargin();
            }
            outRect.left = mRightItemLeftMargin;
            outRect.top = ZPlanTemplateGridFragment.this.mSizeHelper.getMItemTopMargin();
            outRect.right = childAdapterPosition == 0 ? 0 : ZPlanTemplateGridFragment.this.mSizeHelper.getMLeftAndRightMarin();
            outRect.bottom = 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0 || ZPlanTemplateGridFragment.this.templateList.isEmpty()) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            int findLastVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findLastVisibleItemPosition() : -1;
            QLog.i("ZPlanSameStyle", 1, "try load more, last item position = " + findLastVisibleItemPosition + ", template size = " + ZPlanTemplateGridFragment.this.templateList.size());
            if (findLastVisibleItemPosition < 0 || findLastVisibleItemPosition < ZPlanTemplateGridFragment.this.templateList.size() - 1) {
                return;
            }
            ZPlanTemplateGridFragment.this.Xh();
        }
    }

    public final void Lh(int postion, final ZPlanTemplate template, final c holder, q sizeHelper) {
        boolean areEqual = Intrinsics.areEqual(this.from, SameStyleContentPageFrom.FROM_CONTENT_PUBLISH);
        bi(template, holder);
        holder.getNewIcon().setVisibility(template.isNew() ? 0 : 8);
        holder.getTitle().setText(template.getDisplayName());
        ((IZPlanDebugHelper) QRoute.api(IZPlanDebugHelper.class)).tryShowLongTextForTemplate(holder.getTitle());
        Kh(template.getCoverUrl(), holder, sizeHelper);
        if (template.isAR()) {
            holder.getUseTxv().setText("\u53bb\u62cd\u6444");
        } else {
            holder.getUseTxv().setText("\u4f7f\u7528");
        }
        holder.getUseTxv().setVisibility(areEqual ? 0 : 8);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        com.tencent.sqshow.zootopia.utils.aa.f(view, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanTemplateGridFragment.Mh(ZPlanTemplateGridFragment.this, holder, template, view2);
            }
        }, 500L, "ZPlanTemplateGridFragment#Item");
    }

    public static final void Mh(ZPlanTemplateGridFragment this$0, c holder, ZPlanTemplate template, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(template, "$template");
        this$0.Oh(holder, template);
    }

    private final void Nh() {
        Dialog dialog = this.mWaitingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mWaitingDialog = null;
    }

    private final void Oh(c holder, ZPlanTemplate template) {
        Intent intent;
        Bundle extras;
        Bundle bundle;
        Intent intent2;
        Intent intent3;
        id3.d dVar = S;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        dVar.c("dt_clck", view, new LinkedHashMap());
        boolean areEqual = Intrinsics.areEqual(this.from, SameStyleContentPageFrom.FROM_CONTENT_PUBLISH);
        if (areEqual && template.isAR()) {
            FragmentActivity activity = getActivity();
            ZootopiaSource zootopiaSource = this.mSource;
            if (activity == null || (intent3 = activity.getIntent()) == null || (bundle = intent3.getExtras()) == null) {
                bundle = new Bundle();
            }
            com.tencent.sqshow.zootopia.samestyle.b.f372897a.a(bundle, true);
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                intent2.putExtras(bundle);
            }
            com.tencent.sqshow.zootopia.samestyle.mix.helper.c.INSTANCE.a(activity, template, zootopiaSource, 4);
        } else {
            ZplanHostActivity.Companion companion = ZplanHostActivity.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Bundle bundle2 = new Bundle();
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null && (extras = intent.getExtras()) != null) {
                bundle2.putAll(extras);
            }
            bundle2.putSerializable("template", template);
            bundle2.putInt("biz", 1);
            Bundle arguments = getArguments();
            bundle2.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, arguments != null ? arguments.getSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE) : null);
            bundle2.putLong("templateTab", this.templateTabId);
            bundle2.putString("KEY_FROM", this.from);
            if (areEqual) {
                com.tencent.sqshow.zootopia.samestyle.b.f372897a.a(bundle2, true);
            }
            Unit unit = Unit.INSTANCE;
            ZplanHostActivity.Companion.c(companion, requireContext, a.class, bundle2, 0, 8, null);
        }
        Dialog dialog = this.mWaitingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mWaitingDialog = qc4.b.d(qc4.b.f428851a, getActivity(), false, 2, null);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.n
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateGridFragment.Ph(ZPlanTemplateGridFragment.this);
            }
        }, 1000L);
    }

    public static final void Ph(ZPlanTemplateGridFragment this$0) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || activity.isFinishing() || (dialog = this$0.mWaitingDialog) == null) {
            return;
        }
        dialog.show();
    }

    public final List<ZPlanTemplate> Qh(List<ZPlanTemplate> r75) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(210001L, peekAppRuntime.getLongAccountUin())) {
            return r75;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : r75) {
            if (!((ZPlanTemplate) obj).isAR()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void Rh() {
        View view = this.emptyPageView;
        if (view != null) {
            view.setVisibility(8);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    private final void Sh() {
        ZootopiaLoadFailView zootopiaLoadFailView = this.mErrorView;
        if (zootopiaLoadFailView == null) {
            return;
        }
        zootopiaLoadFailView.setVisibility(8);
    }

    public final void Th(final c holder) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            holder.t();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.o
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTemplateGridFragment.Uh(ZPlanTemplateGridFragment.c.this);
                }
            });
        }
    }

    public static final void Uh(c holder) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        holder.t();
    }

    public final void Vh() {
        ShimmerLinearLayout shimmerLinearLayout = this.mShimmerView;
        if (shimmerLinearLayout != null) {
            shimmerLinearLayout.setVisibility(8);
        }
        ShimmerLinearLayout shimmerLinearLayout2 = this.mShimmerView;
        if (shimmerLinearLayout2 != null) {
            shimmerLinearLayout2.d();
        }
    }

    private final void Wh() {
        RecyclerView.Adapter adapter;
        if (this.isLoading) {
            if (this.templateList.isEmpty()) {
                fi();
            }
        } else {
            if (!this.templateList.isEmpty()) {
                Vh();
                return;
            }
            if (this.totalPage >= 0) {
                ci();
                return;
            }
            this.isLoading = true;
            fi();
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            ai(1, new Function5<Boolean, Integer, Integer, Long, List<? extends ZPlanTemplate>, Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateGridFragment$loadFirstPage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(5);
                }

                @Override // kotlin.jvm.functions.Function5
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, Integer num2, Long l3, List<? extends ZPlanTemplate> list) {
                    invoke(bool.booleanValue(), num.intValue(), num2.intValue(), l3.longValue(), (List<ZPlanTemplate>) list);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3, int i16, long j3, List<ZPlanTemplate> list) {
                    RecyclerView recyclerView2;
                    RecyclerView.Adapter adapter2;
                    ZPlanTemplateGridFragment.this.isLoading = false;
                    ZPlanTemplateGridFragment.this.Vh();
                    if (!z16 || list == null) {
                        if (!z16) {
                            ZPlanTemplateGridFragment.this.di();
                            return;
                        } else {
                            ZPlanTemplateGridFragment.this.ci();
                            return;
                        }
                    }
                    ZPlanTemplateGridFragment.this.currentPage = i3;
                    ZPlanTemplateGridFragment.this.totalPage = i16;
                    ZPlanTemplateGridFragment.this.templateTabId = j3;
                    ZPlanTemplateGridFragment.this.templateList.addAll(list);
                    recyclerView2 = ZPlanTemplateGridFragment.this.recyclerView;
                    if (recyclerView2 != null && (adapter2 = recyclerView2.getAdapter()) != null) {
                        adapter2.notifyDataSetChanged();
                    }
                    if (ZPlanTemplateGridFragment.this.templateList.isEmpty()) {
                        ZPlanTemplateGridFragment.this.ci();
                    } else {
                        ZPlanTemplateGridFragment.this.Rh();
                    }
                }
            });
        }
    }

    public final void Xh() {
        if (this.isLoading) {
            QLog.e("ZPlanSameStyle", 1, "loadNextPage isLoading return. " + this.cat);
            return;
        }
        int i3 = this.currentPage;
        int i16 = this.totalPage;
        if (i3 >= i16) {
            QLog.e("ZPlanSameStyle", 1, "loadNextPage currentPage:" + i3 + ", totalPage:" + i16 + ". " + this.cat);
            return;
        }
        if (this.templateList.isEmpty()) {
            QLog.e("ZPlanSameStyle", 1, "loadNextPage templateList.isEmpty. " + this.cat);
            return;
        }
        this.isLoading = true;
        ai(this.currentPage + 1, new Function5<Boolean, Integer, Integer, Long, List<? extends ZPlanTemplate>, Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateGridFragment$loadNextPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, Integer num2, Long l3, List<? extends ZPlanTemplate> list) {
                invoke(bool.booleanValue(), num.intValue(), num2.intValue(), l3.longValue(), (List<ZPlanTemplate>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i17, int i18, long j3, List<ZPlanTemplate> list) {
                RecyclerView recyclerView;
                RecyclerView.Adapter adapter;
                ZPlanTemplateGridFragment.this.isLoading = false;
                if (!z16 || list == null) {
                    return;
                }
                ZPlanTemplateGridFragment.this.currentPage = i17;
                ZPlanTemplateGridFragment.this.totalPage = i18;
                ZPlanTemplateGridFragment.this.templateTabId = j3;
                int size = ZPlanTemplateGridFragment.this.templateList.size();
                int size2 = list.size();
                ZPlanTemplateGridFragment.this.templateList.addAll(list);
                recyclerView = ZPlanTemplateGridFragment.this.recyclerView;
                if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
                    return;
                }
                adapter.notifyItemRangeInserted(size, size2);
            }
        });
    }

    private final void ai(int page, Function5<? super Boolean, ? super Integer, ? super Integer, ? super Long, ? super List<ZPlanTemplate>, Unit> callback) {
        int i3 = h.b(getArguments()) ? 1 : 2;
        boolean areEqual = Intrinsics.areEqual(this.from, SameStyleContentPageFrom.FROM_CONTENT_PUBLISH);
        g gVar = g.f372915a;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        gVar.b((AppInterface) waitAppRuntime, new TemplateReq(this.cat.getId().longValue(), page, 0, areEqual ? 1 : 0, i3, areEqual ? 1 : 0, 4, null), new ZPlanTemplateGridFragment$requestTemplates$1(this, callback));
    }

    private final void bi(ZPlanTemplate template, c holder) {
        if (!template.isVideo() && !template.isMixWithVideo()) {
            if (template.isAR()) {
                holder.getVideoIcon().setVisibility(0);
                holder.getVideoIcon().setImageResource(R.drawable.f159898ig4);
                return;
            } else {
                holder.getVideoIcon().setVisibility(8);
                return;
            }
        }
        holder.getVideoIcon().setVisibility(0);
        holder.getVideoIcon().setImageResource(R.drawable.ig_);
    }

    public final void ci() {
        Sh();
        Vh();
        View view = this.emptyPageView;
        if (view != null) {
            view.setVisibility(0);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(8);
    }

    public final void di() {
        ZootopiaLoadFailView zootopiaLoadFailView = this.mErrorView;
        if (zootopiaLoadFailView == null) {
            return;
        }
        zootopiaLoadFailView.setVisibility(0);
        zootopiaLoadFailView.c();
        com.tencent.sqshow.zootopia.utils.aa.d(zootopiaLoadFailView.getBtnNetworkError(), new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTemplateGridFragment.ei(ZPlanTemplateGridFragment.this, view);
            }
        });
        Rh();
        Vh();
    }

    public static final void ei(ZPlanTemplateGridFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Sh();
        this$0.Wh();
    }

    private final void fi() {
        ShimmerLinearLayout shimmerLinearLayout = this.mShimmerView;
        if (shimmerLinearLayout != null) {
            shimmerLinearLayout.setVisibility(0);
        }
        ShimmerLinearLayout shimmerLinearLayout2 = this.mShimmerView;
        if (shimmerLinearLayout2 != null) {
            shimmerLinearLayout2.c();
        }
        Sh();
        Rh();
    }

    public final void Yh() {
        QLog.i("ZPlanSameStyle", 4, "template grid " + this.cat.getName() + " hide");
    }

    public final void Zh(ZPlanTemplateCat cat, @SameStyleContentPageFrom String from) {
        Intrinsics.checkNotNullParameter(cat, "cat");
        Intrinsics.checkNotNullParameter(from, "from");
        this.cat = cat;
        this.from = from;
        Wh();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.d("ZPlanSameStyle", 1, "onConfigurationChanged " + newConfig);
        try {
            Context context = getContext();
            if (context != null) {
                this.mSizeHelper.h(context);
            }
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
                return;
            }
            adapter.notifyDataSetChanged();
        } catch (Exception e16) {
            QLog.e("ZPlanSameStyle", 1, "configurationChanged " + e16);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r46) {
        super.onCreate(r46);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("template_cat") : null;
        ZPlanTemplateCat zPlanTemplateCat = serializable instanceof ZPlanTemplateCat ? (ZPlanTemplateCat) serializable : null;
        if (zPlanTemplateCat == null) {
            zPlanTemplateCat = ZPlanTemplateCat.INSTANCE.a();
        }
        this.cat = zPlanTemplateCat;
        Bundle arguments2 = getArguments();
        String str = SameStyleContentPageFrom.FROM_SAME_STYLE;
        String string = arguments2 != null ? arguments2.getString("KEY_FROM", SameStyleContentPageFrom.FROM_SAME_STYLE) : null;
        if (string != null) {
            str = string;
        }
        this.from = str;
        QLog.w("ZPlanSameStyle", 1, "onCreate  from:" + str);
        Bundle arguments3 = getArguments();
        Serializable serializable2 = arguments3 != null ? arguments3.getSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE) : null;
        ZootopiaSource zootopiaSource = serializable2 instanceof ZootopiaSource ? (ZootopiaSource) serializable2 : null;
        if (zootopiaSource != null) {
            this.mSource = zootopiaSource;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup r36, Bundle r46) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.f167395d32, r36, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.recyclerView = null;
        this.emptyPageView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Wh();
        Nh();
    }

    public final void onShow() {
        QLog.i("ZPlanSameStyle", 4, "template grid " + this.cat.getName() + " show");
        Wh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.qit);
        Context ctx = getContext();
        if (ctx == null) {
            ctx = view.getContext();
        }
        q qVar = this.mSizeHelper;
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        qVar.h(ctx);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), this.mSizeHelper.getMSpanCount()));
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new e());
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(new b(this, this.mSizeHelper));
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 != null) {
            recyclerView4.addOnScrollListener(new f());
        }
        this.emptyPageView = view.findViewById(R.id.qbd);
        this.mErrorView = (ZootopiaLoadFailView) view.findViewById(R.id.psq);
        this.mShimmerView = (ShimmerLinearLayout) view.findViewById(R.id.q6i);
        Wh();
    }

    private final void Kh(String url, c holder, q sizeHelper) {
        boolean endsWith$default;
        Drawable b16 = com.tencent.sqshow.zootopia.utils.q.b(R.drawable.gym);
        b16.setBounds(0, 0, sizeHelper.getMSingleWidth(), sizeHelper.getMSinglePicHeight());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = holder.itemView.getLayoutParams().width;
        obtain.mRequestHeight = holder.itemView.getLayoutParams().height;
        obtain.mPlayGifImage = true;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url, ".apng", false, 2, null);
        obtain.mUseApngImage = endsWith$default;
        obtain.mFailedDrawable = b16;
        obtain.mLoadingDrawable = b16;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        holder.getCover().setImageDrawable(drawable);
        QLog.i("ZPlanSameStyle", 1, "drawable status = " + drawable.getStatus() + ", url = " + url);
        if (drawable.getStatus() == 1) {
            holder.t();
            return;
        }
        holder.u();
        holder.getMask().setImageDrawable(b16);
        drawable.startDownload();
        drawable.setURLDrawableListener(new d(holder, this));
    }

    @Override // vc4.h
    public Fragment getFragment() {
        return this;
    }
}
