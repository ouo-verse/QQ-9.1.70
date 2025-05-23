package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import fi3.bm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B7\u0012\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001a\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000b0#\u00a2\u0006\u0004\b1\u00102J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0013H\u0016R \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000b0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020$0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b,\u0010-*\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeNeighborAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeNeighborAdapter$a;", "Lx45/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "", "p0", "Landroid/view/View;", "view", "", "k0", "n0", "o0", "Landroid/graphics/drawable/Drawable;", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "s0", "getItemCount", "holder", "position", "q0", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableStateFlow;", "source", "Lkotlinx/coroutines/CoroutineScope;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "", "D", "Lkotlin/jvm/functions/Function1;", "onVisitClick", "Ljava/util/concurrent/CopyOnWriteArrayList;", "E", "Ljava/util/concurrent/CopyOnWriteArrayList;", "inviteList", "l0", "()[Lx45/g;", "getData$delegate", "(Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeNeighborAdapter;)Ljava/lang/Object;", "data", "<init>", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeNeighborAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function1<Long, Unit> onVisitClick;

    /* renamed from: E, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<Long> inviteList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<x45.g[]> source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeNeighborAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfi3/bm;", "E", "Lfi3/bm;", "l", "()Lfi3/bm;", "binding", "<init>", "(Lfi3/bm;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final bm binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bm binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            View view = this.itemView;
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.sqshow.zootopia.utils.i.b(10);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.sqshow.zootopia.utils.i.b(10);
            view.setLayoutParams(layoutParams);
        }

        /* renamed from: l, reason: from getter */
        public final bm getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MiniHomeNeighborAdapter(MutableStateFlow<x45.g[]> source, CoroutineScope scope, Function1<? super Long, Unit> onVisitClick) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onVisitClick, "onVisitClick");
        this.source = source;
        this.scope = scope;
        this.onVisitClick = onVisitClick;
        this.inviteList = new CopyOnWriteArrayList<>();
    }

    private final void k0(View view, x45.g item) {
        VideoReport.setElementId(view, "em_zplan_interaction_btn");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementParams(view, p0(item));
        VideoReport.setElementReuseIdentifier(view, item + ".uin");
        VideoReport.traverseExposure();
    }

    private final x45.g[] l0() {
        return this.source.getValue();
    }

    private final Drawable m0(x45.g item) {
        int parseColor;
        int i3 = item.f447209d;
        if (i3 == 2) {
            parseColor = Color.parseColor("#1A0099FF");
        } else if (i3 == 3) {
            parseColor = Color.parseColor("#1AFF9473");
        } else if (i3 == 4) {
            parseColor = Color.parseColor("#1A8566FF");
        } else if (i3 != 5) {
            parseColor = Color.parseColor("#1AEDAF00");
        } else {
            parseColor = Color.parseColor("#1AFF66B3");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(com.tencent.sqshow.zootopia.utils.i.e(4));
        return gradientDrawable;
    }

    private final String n0(x45.g item) {
        String str;
        int i3 = item.f447209d;
        if (i3 == 2) {
            str = "\u57fa\u53cb\u503c";
        } else if (i3 == 3) {
            str = "\u95fa\u871c\u503c";
        } else if (i3 == 4) {
            str = "\u6b7b\u515a\u503c";
        } else if (i3 != 5) {
            str = "\u5bc6\u53cb\u503c";
        } else {
            str = "\u60c5\u4fa3\u503c";
        }
        return str + APLogFileUtil.SEPARATOR_LOG + item.f447210e;
    }

    private final String o0(x45.g item) {
        int i3 = item.f447209d;
        if (i3 == 2) {
            return "#0099FF";
        }
        if (i3 == 3) {
            return "#FF9473";
        }
        if (i3 == 4) {
            return "#8566FF";
        }
        if (i3 != 5) {
            return "#EDAF00";
        }
        return "#FF66B3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(x45.g item, MiniHomeNeighborAdapter this$0, bm this_apply, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002");
            return;
        }
        if (item.f447208c) {
            this$0.onVisitClick.invoke(Long.valueOf(item.f447206a));
        } else {
            CorountineFunKt.e(this$0.scope, "zplan_MiniHomeNeighborAdapter_\u540e\u53f0\u53d1\u9001\u9080\u8bf7ark", null, null, null, new MiniHomeNeighborAdapter$onBindViewHolder$1$1$1(item, this$0, this_apply, null), 14, null);
        }
        VideoReport.reportEvent("clck", this_apply.f399122c, this$0.p0(item));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return l0().length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Pair pair;
        QUIButton qUIButton;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final x45.g gVar = l0()[position];
        final bm binding = holder.getBinding();
        binding.f399123d.setText(gVar.f447207b);
        binding.f399124e.setText(n0(gVar));
        TextView relationshipValue = binding.f399124e;
        Intrinsics.checkNotNullExpressionValue(relationshipValue, "relationshipValue");
        String o06 = o0(gVar);
        if (o06 instanceof Integer) {
            relationshipValue.setTextColor(relationshipValue.getResources().getColorStateList(((Number) o06).intValue()));
        } else if (o06 instanceof String) {
            relationshipValue.setTextColor(Color.parseColor(o06));
        }
        binding.f399124e.setBackground(m0(gVar));
        binding.f399124e.setPadding(com.tencent.sqshow.zootopia.utils.i.b(6), com.tencent.sqshow.zootopia.utils.i.b(3), com.tencent.sqshow.zootopia.utils.i.b(6), com.tencent.sqshow.zootopia.utils.i.b(3));
        binding.f399121b.x(1, String.valueOf(gVar.f447206a), null);
        QUIButton qUIButton2 = binding.f399122c;
        if (!(qUIButton2 instanceof QUIButton)) {
            qUIButton2 = null;
        }
        if (qUIButton2 != null) {
            qUIButton2.setSizeType(2);
        }
        binding.f399122c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniHomeNeighborAdapter.r0(x45.g.this, this, binding, view);
            }
        });
        if (this.inviteList.contains(Long.valueOf(gVar.f447206a))) {
            binding.f399122c.setText("\u5df2\u53d1\u9001");
            QUIButton qUIButton3 = binding.f399122c;
            qUIButton = qUIButton3 instanceof QUIButton ? qUIButton3 : null;
            if (qUIButton != null) {
                qUIButton.setType(1);
            }
            binding.f399122c.setPadding(0, 0, 0, 0);
            binding.f399122c.setBackgroundDisabled();
            binding.f399122c.setClickable(false);
        } else {
            binding.f399122c.o();
            if (gVar.f447208c) {
                pair = new Pair("\u4e32\u95e8", 0);
            } else {
                pair = new Pair("\u9080\u8bf7", 1);
            }
            String str = (String) pair.component1();
            int intValue = ((Number) pair.component2()).intValue();
            binding.f399122c.setText(str);
            binding.f399122c.setClickable(true);
            QUIButton qUIButton4 = binding.f399122c;
            qUIButton = qUIButton4 instanceof QUIButton ? qUIButton4 : null;
            if (qUIButton != null) {
                qUIButton.setType(intValue);
            }
        }
        QUIButton button = binding.f399122c;
        Intrinsics.checkNotNullExpressionValue(button, "button");
        k0(button, gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bm g16 = bm.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
        return new a(g16);
    }

    private final Map<String, Object> p0(x45.g item) {
        String str;
        HashMap hashMapOf;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        pairArr[1] = TuplesKt.to("zplan_to_uin", Long.valueOf(item.f447206a));
        if (item.f447208c) {
            str = "\u4e32\u95e8";
        } else {
            str = "\u9080\u8bf7";
        }
        pairArr[2] = TuplesKt.to("zplan_btn_content", str);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf;
    }
}
