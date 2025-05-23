package com.tencent.mobileqq.guild.quicksearch.resultview.history;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.quicksearch.resultview.history.GuildQuickSearchHistoryView;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.FlowLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lw1.i;
import lw1.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0002?@B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\n\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u000e\u001a\u00020\u0002*\u00020\rH\u0002J\f\u0010\u000f\u001a\u00020\u0002*\u00020\u0007H\u0002JG\u0010\u0015\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102*\u0010\u0014\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u00130\u0012\"\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u0013H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u001d\u001a\u00020\u00022\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0007R\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010!R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/history/GuildQuickSearchHistoryView;", "Landroid/widget/FrameLayout;", "", "k", "j", DomainData.DOMAIN_NAME, "g", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "viewType", "u", "Landroid/widget/TextView;", "v", ReportConstant.COSTREPORT_PREFIX, "", "elId", "", "Lkotlin/Pair;", "pair", h.F, "(Landroid/view/View;Ljava/lang/String;[Lkotlin/Pair;)V", "Llw1/j;", "cb", "guildId", "i", "", "dataList", "r", "childView", "setLogicParent", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "mClearHistoryView", "f", "mHistoryListHeader", "mFindSpecificTitle", "Lcom/tencent/mobileqq/guild/widget/FlowLayout;", "Lcom/tencent/mobileqq/guild/widget/FlowLayout;", "mHistoryFlowLayout", "Llw1/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Llw1/i;", "mHistorySearchAdapter", BdhLogUtil.LogTag.Tag_Conn, "Llw1/j;", "mHistoryCallback", "D", "Ljava/lang/String;", "mGuildId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "HistoryViewType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildQuickSearchHistoryView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private j mHistoryCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String mGuildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Button mClearHistoryView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mHistoryListHeader;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mFindSpecificTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FlowLayout mHistoryFlowLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private i mHistorySearchAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/history/GuildQuickSearchHistoryView$HistoryViewType;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes14.dex */
    public @interface HistoryViewType {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildQuickSearchHistoryView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g() {
        List<String> emptyList;
        u(0);
        i iVar = this.mHistorySearchAdapter;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistorySearchAdapter");
            iVar = null;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        iVar.setData(emptyList);
        j jVar = this.mHistoryCallback;
        if (jVar != null) {
            jVar.a();
        }
        Button button = this.mClearHistoryView;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClearHistoryView");
            button = null;
        }
        VideoReport.reportEvent("clck", button, null);
    }

    private final void h(View view, String str, Pair<String, Integer>... pairArr) {
        Map map;
        map = MapsKt__MapsKt.toMap(pairArr);
        bt.d(view, str, map, null, null, EndExposurePolicy.REPORT_NONE, 24, null);
    }

    private final void j() {
        Button button;
        VideoReport.setPageId(getRootView(), "pg_sgrp_search_all");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View rootView = getRootView();
        String str = this.mGuildId;
        if (str == null) {
            str = "";
        }
        iGuildDTReportApi.setGuildPageParams(rootView, str, null);
        Button button2 = this.mClearHistoryView;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClearHistoryView");
            button = null;
        } else {
            button = button2;
        }
        bt.d(button, "em_sgrp_delete_history", null, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE, 4, null);
    }

    private final void k() {
        View findViewById = this.mRootView.findViewById(R.id.wux);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026rch_clear_search_history)");
        Button button = (Button) findViewById;
        this.mClearHistoryView = button;
        i iVar = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClearHistoryView");
            button = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        button.setBackground(GuildUIUtils.w(context, R.drawable.qui_delete, Integer.valueOf(R.color.qui_common_icon_secondary)));
        View findViewById2 = this.mRootView.findViewById(R.id.f165595wv0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026earch_history_tag_layout)");
        this.mHistoryListHeader = findViewById2;
        View findViewById3 = this.mRootView.findViewById(R.id.f110976jz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026tv_search_specific_title)");
        this.mFindSpecificTitle = findViewById3;
        TextView textView = (TextView) this.mRootView.findViewById(R.id.f107896bn);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: lw1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildQuickSearchHistoryView.this.q(view);
                }
            });
            v(textView);
            s(textView);
            h(textView, "em_sgrp_search_way", TuplesKt.to("sgrp_search_way", 2));
        }
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.f167040k71);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: lw1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildQuickSearchHistoryView.this.q(view);
                }
            });
            v(textView2);
            s(textView2);
            h(textView2, "em_sgrp_search_way", TuplesKt.to("sgrp_search_way", 3));
        }
        TextView textView3 = (TextView) this.mRootView.findViewById(R.id.f109256fb);
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: lw1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildQuickSearchHistoryView.this.q(view);
                }
            });
            v(textView3);
            s(textView3);
            h(textView3, "em_sgrp_search_way", TuplesKt.to("sgrp_search_way", 1));
        }
        Button button2 = this.mClearHistoryView;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClearHistoryView");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: lw1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildQuickSearchHistoryView.l(GuildQuickSearchHistoryView.this, view);
            }
        });
        View findViewById4 = this.mRootView.findViewById(R.id.wuz);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026_history_tag_flow_layout)");
        FlowLayout flowLayout = (FlowLayout) findViewById4;
        this.mHistoryFlowLayout = flowLayout;
        if (flowLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistoryFlowLayout");
            flowLayout = null;
        }
        i iVar2 = this.mHistorySearchAdapter;
        if (iVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistorySearchAdapter");
        } else {
            iVar = iVar2;
        }
        flowLayout.setAdapter(iVar);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: lw1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildQuickSearchHistoryView.m(view);
            }
        });
        u(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildQuickSearchHistoryView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object systemService = view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n() {
        if (o.c("QQGuildInSearchTag.GuildQuickSearchHistoryView")) {
            QLog.i("QQGuildInSearchTag.GuildQuickSearchHistoryView", 1, "onClearButtonClicked is fast click, return");
        } else {
            DialogUtil.createCustomDialog(getContext(), 230).setMessage(getContext().getString(R.string.f152591_t)).setPositiveButton(R.string.f143520ma, new DialogInterface.OnClickListener() { // from class: lw1.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildQuickSearchHistoryView.o(GuildQuickSearchHistoryView.this, dialogInterface, i3);
                }
            }).setNegativeButton(R.string.f140850f3, new DialogInterface.OnClickListener() { // from class: lw1.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildQuickSearchHistoryView.p(dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildQuickSearchHistoryView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(View view) {
        j jVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f107896bn) {
            j jVar2 = this.mHistoryCallback;
            if (jVar2 != null) {
                jVar2.d(view);
            }
        } else if (id5 == R.id.f167040k71) {
            j jVar3 = this.mHistoryCallback;
            if (jVar3 != null) {
                jVar3.b(view);
            }
        } else if (id5 == R.id.f109256fb && (jVar = this.mHistoryCallback) != null) {
            jVar.e(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s(View view) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: lw1.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean t16;
                t16 = GuildQuickSearchHistoryView.t(view2, motionEvent);
                return t16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }

    private final void u(int viewType) {
        View view = null;
        if (viewType != 0) {
            if (viewType == 1) {
                View view2 = this.mHistoryListHeader;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHistoryListHeader");
                    view2 = null;
                }
                view2.setVisibility(0);
                FlowLayout flowLayout = this.mHistoryFlowLayout;
                if (flowLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHistoryFlowLayout");
                    flowLayout = null;
                }
                flowLayout.setVisibility(0);
                View view3 = this.mFindSpecificTitle;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFindSpecificTitle");
                } else {
                    view = view3;
                }
                view.setPaddingRelative(view.getPaddingStart(), (int) cw.c(48.0f), view.getPaddingEnd(), view.getPaddingBottom());
                return;
            }
            return;
        }
        View view4 = this.mHistoryListHeader;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistoryListHeader");
            view4 = null;
        }
        view4.setVisibility(8);
        FlowLayout flowLayout2 = this.mHistoryFlowLayout;
        if (flowLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistoryFlowLayout");
            flowLayout2 = null;
        }
        flowLayout2.setVisibility(8);
        View view5 = this.mFindSpecificTitle;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFindSpecificTitle");
        } else {
            view = view5;
        }
        view.setPaddingRelative(view.getPaddingStart(), (int) cw.c(18.0f), view.getPaddingEnd(), view.getPaddingBottom());
    }

    private final void v(TextView textView) {
        boolean z16;
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
        if (compoundDrawables.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            textView.getCompoundDrawables()[0].setColorFilter(new PorterDuffColorFilter(textView.getContext().getResources().getColor(R.color.qui_common_text_primary), PorterDuff.Mode.SRC_IN));
            textView.setCompoundDrawables(textView.getCompoundDrawables()[0], null, null, null);
        }
    }

    public final void i(@NotNull j cb5, @Nullable String guildId) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.mHistorySearchAdapter = new i(cb5);
        this.mHistoryCallback = cb5;
        this.mGuildId = guildId;
        k();
        j();
    }

    public final void r(@Nullable List<String> dataList) {
        boolean z16;
        List<String> list = dataList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            u(0);
            return;
        }
        u(1);
        i iVar = this.mHistorySearchAdapter;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHistorySearchAdapter");
            iVar = null;
        }
        iVar.setData(dataList);
    }

    public final void setLogicParent(@NotNull View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        VideoReport.setLogicParent(childView, getRootView());
        VideoReport.traversePage(childView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildQuickSearchHistoryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildQuickSearchHistoryView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildQuickSearchHistoryView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.f3b, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026istory_search_view, this)");
        this.mRootView = inflate;
    }
}
