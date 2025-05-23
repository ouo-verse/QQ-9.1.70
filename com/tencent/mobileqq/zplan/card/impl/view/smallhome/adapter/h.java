package com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.RoundRectURLImageView;
import fi3.l;
import gi3.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/adapter/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "elementId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lpv4/d;", "itemData", "y", HippyTKDListViewAdapter.X, "r", "Lfi3/l;", "E", "Lfi3/l;", "getViewBinding", "()Lfi3/l;", "setViewBinding", "(Lfi3/l;)V", "viewBinding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "<init>", "(Lfi3/l;Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;)V", "G", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private l viewBinding;

    /* renamed from: F, reason: from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(l viewBinding, ZplanViewReportHelper reportHelper) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        this.viewBinding = viewBinding;
        this.reportHelper = reportHelper;
    }

    private final void A(final String elementId) {
        this.viewBinding.f399299e.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.g
            @Override // java.lang.Runnable
            public final void run() {
                h.B(h.this, elementId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(h this$0, String elementId) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        TextView textView = this$0.viewBinding.f399299e;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvVisitBack");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.INSTANCE.g()));
        zplanViewReportHelper.g(textView, elementId, (r16 & 4) != 0 ? null : mutableMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(h this$0, pv4.d itemData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        this$0.y(itemData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(h this$0, pv4.d itemData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        this$0.y(itemData);
        this$0.z("em_zplan_xw_visitor_win_return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(h this$0, pv4.d itemData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        this$0.y(itemData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(h this$0, pv4.d itemData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        this$0.y(itemData);
        this$0.z("em_zplan_xw_msg_win_likeback");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(h this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x();
    }

    private final void x() {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default("mqqapi://zplan/enterAvatarScene?src_type=app&version=1.0&subReferer=${subReferer}&sceneType=7&pageData={\"needDownload\":true,\"mapId\":200001,\"openDetailNotReady\":true}&sceneData={\"SceneType\":\"1\"}", "${subReferer}", "smallhome_card", false, 4, (Object) null);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context = this.viewBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewBinding.root.context");
        iZPlanApi.launchScheme(context, replace$default);
    }

    private final void y(pv4.d itemData) {
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this.viewBinding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewBinding.root.context");
        String str = itemData.f427585g;
        Intrinsics.checkNotNullExpressionValue(str, "itemData.jumpSchema");
        iSchemeApi.launchScheme(context, str);
    }

    private final void z(String elementId) {
        Map<String, ? extends Object> mutableMapOf;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        TextView textView = this.viewBinding.f399299e;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvVisitBack");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ZootopiaSource.INSTANCE.g()));
        zplanViewReportHelper.e(textView, elementId, mutableMapOf);
    }

    public final void r(final pv4.d itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        this.viewBinding.f399297c.setRadius(com.tencent.sqshow.zootopia.utils.i.d(21.5f));
        RoundRectURLImageView roundRectURLImageView = this.viewBinding.f399297c;
        Intrinsics.checkNotNullExpressionValue(roundRectURLImageView, "viewBinding.headIcon");
        String str = itemData.f427588j;
        Intrinsics.checkNotNullExpressionValue(str, "itemData.avatar");
        CommonExKt.w(roundRectURLImageView, str, null, null, 6, null);
        this.viewBinding.f399301g.setText(itemData.f427587i);
        a.Companion companion = gi3.a.INSTANCE;
        TextView textView = this.viewBinding.f399300f;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvVisitorDesc");
        String str2 = itemData.f427580b;
        Intrinsics.checkNotNullExpressionValue(str2, "itemData.eventDesc");
        companion.b(textView, str2, 16);
        int i3 = itemData.f427579a;
        if (i3 == 15) {
            this.viewBinding.f399298d.setVisibility(0);
            this.viewBinding.f399299e.setText("\u56de\u8d5e");
            ConstraintLayout root = this.viewBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
            aa.d(root, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.u(h.this, itemData, view);
                }
            });
            A("em_zplan_xw_msg_win_likeback");
            LinearLayout linearLayout = this.viewBinding.f399298d;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.layoutVisitBack");
            aa.d(linearLayout, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.v(h.this, itemData, view);
                }
            });
            return;
        }
        if (i3 != 17) {
            if (i3 != 19) {
                QLog.i("SmallHomeVisitCommonViewHolder", 1, "updateLoadMoreTag else type:" + i3);
                return;
            }
            this.viewBinding.f399298d.setVisibility(8);
            this.viewBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.w(h.this, view);
                }
            });
            return;
        }
        this.viewBinding.f399298d.setVisibility(0);
        this.viewBinding.f399299e.setText("\u56de\u8bbf");
        ConstraintLayout root2 = this.viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "viewBinding.root");
        aa.d(root2, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.s(h.this, itemData, view);
            }
        });
        A("em_zplan_xw_visitor_win_return");
        LinearLayout linearLayout2 = this.viewBinding.f399298d;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "viewBinding.layoutVisitBack");
        aa.d(linearLayout2, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.smallhome.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.t(h.this, itemData, view);
            }
        });
    }
}
