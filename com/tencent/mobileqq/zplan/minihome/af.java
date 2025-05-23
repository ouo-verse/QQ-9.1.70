package com.tencent.mobileqq.zplan.minihome;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.minihome.af;
import com.tencent.mobileqq.zplan.minihome.data.ServerFurnitureDesc;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import fi3.bl;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00014B#\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100$\u00a2\u0006\u0004\b2\u00103JJ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0016J\"\u0010\u001a\u001a\u00020\u00102\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/af;", "Landroidx/recyclerview/widget/ListAdapter;", "Ln55/a;", "Lcom/tencent/mobileqq/zplan/minihome/af$a;", "Landroid/view/View;", "view", "", "eventKey", "", "id", "", "subState", "", "haveOwn", "personalized", "price", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k0", "", "list", "Ljava/lang/Runnable;", "commitCallback", "submitList", "holder", "position", "j0", "Landroidx/lifecycle/LifecycleCoroutineScope;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleCoroutineScope;", "getScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onChoose", "D", "Ljava/lang/Integer;", "getChoosing", "()Ljava/lang/Integer;", "n0", "(Ljava/lang/Integer;)V", "choosing", "E", "I", "currListVersion", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Lkotlin/jvm/functions/Function1;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class af extends ListAdapter<n55.a, a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Function1<n55.a, Unit> onChoose;

    /* renamed from: D, reason: from kotlin metadata */
    private Integer choosing;

    /* renamed from: E, reason: from kotlin metadata */
    private int currListVersion;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LifecycleCoroutineScope scope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/af$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ln55/a;", "furniture", "", "l", "Lfi3/bl;", "E", "Lfi3/bl;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lfi3/bl;", "binding", "", UserInfo.SEX_FEMALE, "I", "o", "()I", "p", "(I)V", "reportVersion", "<init>", "(Lfi3/bl;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final bl binding;

        /* renamed from: F, reason: from kotlin metadata */
        private int reportVersion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bl binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            this.reportVersion = -1;
            View view = this.itemView;
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.sqshow.zootopia.utils.i.b(16);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            view.setLayoutParams(layoutParams);
            this.itemView.setOutlineProvider(new ap(com.tencent.sqshow.zootopia.utils.i.e(8)));
            this.itemView.setClipToOutline(true);
            if (EditMiniHomeFragment.INSTANCE.e()) {
                View view2 = this.itemView;
                RelativeLayout relativeLayout = view2 instanceof RelativeLayout ? (RelativeLayout) view2 : null;
                if (relativeLayout != null) {
                    TextView textView = new TextView(this.itemView.getContext());
                    textView.setVisibility(0);
                    textView.setTag("item_debug_view");
                    textView.setClickable(false);
                    textView.setFocusable(false);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams2.topMargin = com.tencent.sqshow.zootopia.utils.i.b(5);
                    layoutParams2.leftMargin = com.tencent.sqshow.zootopia.utils.i.b(5);
                    Unit unit = Unit.INSTANCE;
                    relativeLayout.addView(textView, layoutParams2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
        
            if (r1 != null) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void l(n55.a furniture) {
            TextView textView;
            String str;
            Intrinsics.checkNotNullParameter(furniture, "furniture");
            String str2 = furniture.f418394c;
            if (str2 != null) {
                if (!(str2.length() == 0)) {
                    ImageView imageView = this.binding.f399118d;
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    Unit unit = Unit.INSTANCE;
                    imageView.setImageDrawable(URLDrawable.getDrawable(str2, obtain));
                }
            }
            View view = this.itemView;
            RelativeLayout relativeLayout = view instanceof RelativeLayout ? (RelativeLayout) view : null;
            if (relativeLayout != null && (textView = (TextView) relativeLayout.findViewWithTag("item_debug_view")) != null) {
                if (!EditMiniHomeFragment.INSTANCE.e()) {
                    textView.setVisibility(4);
                } else {
                    textView.setVisibility(0);
                    ServerFurnitureDesc a16 = ServerFurnitureDesc.INSTANCE.a(furniture.f418399h);
                    if (a16 != null) {
                        str = "id: " + a16.getId() + ", substate: " + a16.getSubState();
                    }
                    str = "\u65e0id\u4fe1\u606f";
                    textView.setText(str);
                    textView.setTextColor(Color.parseColor("#000080"));
                }
            }
            this.binding.f399116b.setIsOwned(furniture.f418398g);
            this.binding.f399116b.setPrice(furniture.f418396e, furniture.f418397f);
        }

        /* renamed from: m, reason: from getter */
        public final bl getBinding() {
            return this.binding;
        }

        /* renamed from: o, reason: from getter */
        public final int getReportVersion() {
            return this.reportVersion;
        }

        public final void p(int i3) {
            this.reportVersion = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public af(LifecycleCoroutineScope scope, Function1<? super n55.a, Unit> onChoose) {
        super(new u());
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onChoose, "onChoose");
        this.scope = scope;
        this.onChoose = onChoose;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(a this_apply, af this$0, View view) {
        ServerFurnitureDesc a16;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int adapterPosition = this_apply.getAdapterPosition();
        if (adapterPosition != -1) {
            Integer num = this$0.choosing;
            this$0.choosing = Integer.valueOf(adapterPosition);
            n55.a item = this$0.getItem(adapterPosition);
            if (item != null) {
                this$0.onChoose.invoke(item);
                String str = item.f418399h;
                if (str != null && (a16 = ServerFurnitureDesc.INSTANCE.a(str)) != null) {
                    ImageView imageView = this_apply.getBinding().f399118d;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.itemThumbnail");
                    this$0.m0(imageView, "clck", a16.getId(), a16.getSubState(), item.f418398g, item.f418400i == 2, item.f418396e);
                }
            }
            this$0.notifyItemChanged(adapterPosition);
            if (num != null) {
                this$0.notifyItemChanged(num.intValue());
            }
        }
    }

    private final void m0(View view, String eventKey, long id5, int subState, boolean haveOwn, boolean personalized, int price) {
        HashMap hashMapOf;
        VideoReport.setElementId(view, "em_zplan_furniture");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_furniture_id", Long.valueOf(id5)), TuplesKt.to("zplan_substate", Integer.valueOf(subState)), TuplesKt.to("zplan_have_own", Integer.valueOf(haveOwn ? 1 : 0)), TuplesKt.to("zplan_xiaowo_personalized", Integer.valueOf(personalized ? 1 : 0)), TuplesKt.to("zplan_item_price", Integer.valueOf(price)));
        VideoReport.reportEvent(eventKey, view, hashMapOf);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bl g16 = bl.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
        final a aVar = new a(g16);
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setPageId(aVar.getBinding().getRoot(), "pg_zplan_mini_xiaowo_edit");
        VideoReport.setPageParams(aVar.getBinding().getRoot(), new PageParams(hashMap));
        VideoReport.setPageReportPolicy(aVar.getBinding().getRoot(), PageReportPolicy.REPORT_ALL);
        aVar.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                af.l0(af.a.this, this, view);
            }
        });
        return aVar;
    }

    public final void n0(Integer num) {
        this.choosing = num;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<n55.a> list, Runnable commitCallback) {
        int i3 = this.currListVersion;
        this.currListVersion = i3 == 10 ? 0 : i3 + 1;
        super.submitList(list, commitCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        n55.a item = getItem(position);
        if (item == null) {
            return;
        }
        if (holder.getReportVersion() != this.currListVersion) {
            ServerFurnitureDesc a16 = ServerFurnitureDesc.INSTANCE.a(item.f418399h);
            if (a16 != null) {
                ImageView imageView = holder.getBinding().f399118d;
                Intrinsics.checkNotNullExpressionValue(imageView, "holder.binding.itemThumbnail");
                m0(imageView, "imp", a16.getId(), a16.getSubState(), item.f418398g, item.f418400i == 2, item.f418396e);
            }
            holder.p(this.currListVersion);
        }
        holder.l(item);
        View view = holder.getBinding().f399117c;
        Integer num = this.choosing;
        view.setSelected(num != null && num.intValue() == position);
    }
}
