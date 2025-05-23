package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.wink.editor.view.d;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b%\u0010&J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007J$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007J*\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0007R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/d;", "", "Lcom/tencent/mobileqq/wink/editor/view/d$a;", "adapter", "", "arrowResId", "backColor", "", "e", "", "text", tl.h.F, "Landroid/view/View;", "view", HippyTKDListViewAdapter.X, "y", "", "dismissMilli", "j", "", "c", "b", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "popWindow", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "popupWindowLayout", "d", "containerLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "arrowDown", "<init>", "(Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PopupWindow popWindow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout popupWindowLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout containerLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView arrowDown;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003)*+B7\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/d$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "position", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "onBindViewHolder", "Lcom/tencent/mobileqq/wink/editor/view/d$a$c;", "clickListener", "l0", "getItemViewType", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "rhythmTypeList", "D", "Ljava/lang/String;", "selectedType", "E", "I", "isBigPanel", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/view/d$a$c;", "G", "selectPos", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;I)V", "H", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final ArrayList<String> rhythmTypeList;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private String selectedType;

        /* renamed from: E, reason: from kotlin metadata */
        private final int isBigPanel;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private c clickListener;

        /* renamed from: G, reason: from kotlin metadata */
        private int selectPos;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/d$a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", IECSearchBar.METHOD_SET_TEXT, "(Landroid/widget/TextView;)V", "text", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "l", "()Landroid/widget/LinearLayout;", "setLlContainer", "(Landroid/widget/LinearLayout;)V", "llContainer", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class b extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private TextView text;

            /* renamed from: F, reason: from kotlin metadata */
            @NotNull
            private LinearLayout llContainer;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                View findViewById = itemView.findViewById(R.id.zly);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.nameText)");
                this.text = (TextView) findViewById;
                View findViewById2 = itemView.findViewById(R.id.f166090ed2);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.ll_container)");
                this.llContainer = (LinearLayout) findViewById2;
            }

            @NotNull
            /* renamed from: l, reason: from getter */
            public final LinearLayout getLlContainer() {
                return this.llContainer;
            }

            @NotNull
            /* renamed from: m, reason: from getter */
            public final TextView getText() {
                return this.text;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/d$a$c;", "", "", "key", "", NodeProps.ON_CLICK, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public interface c {
            void onClick(@Nullable String key);
        }

        public a(@NotNull Context context, @NotNull ArrayList<String> rhythmTypeList, @NotNull String selectedType, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rhythmTypeList, "rhythmTypeList");
            Intrinsics.checkNotNullParameter(selectedType, "selectedType");
            this.context = context;
            this.rhythmTypeList = rhythmTypeList;
            this.selectedType = selectedType;
            this.isBigPanel = i3;
            this.selectPos = -1;
        }

        private final void j0(final RecyclerView.ViewHolder holder, final int position) {
            Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.view.RecycleViewPopupWindow.RecycleViewPopupWindowAdapter.CustomVH");
            b bVar = (b) holder;
            TextView text = bVar.getText();
            String str = this.rhythmTypeList.get(position);
            Intrinsics.checkNotNullExpressionValue(str, "rhythmTypeList[position]");
            final String str2 = str;
            text.setText(str2);
            if (Intrinsics.areEqual(this.selectedType, str2)) {
                this.selectPos = position;
                text.setTextColor(this.context.getResources().getColor(R.color.b9n));
                text.setTypeface(null, 1);
            } else {
                text.setTextColor(-1);
            }
            VideoReport.setElementId(bVar.getLlContainer(), WinkDaTongReportConstant.ElementId.EM_XSJ_RHYFILTER_CONTENT_BUTTON);
            VideoReport.setElementClickPolicy(bVar.getLlContainer(), ClickPolicy.REPORT_NONE);
            bVar.getLlContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.a.k0(RecyclerView.ViewHolder.this, str2, this, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k0(RecyclerView.ViewHolder holder, String type, a this$0, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(type, "$type");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.wink.editor.template.c.f322362a.g(((b) holder).getLlContainer(), type, this$0.isBigPanel);
            int i16 = this$0.selectPos;
            if (i16 == -1) {
                this$0.selectPos = i3;
                this$0.notifyItemChanged(i3);
                this$0.selectedType = type;
                c cVar = this$0.clickListener;
                if (cVar != null) {
                    cVar.onClick(type);
                }
            } else if (i16 != i3) {
                this$0.notifyItemChanged(i16);
                this$0.selectPos = i3;
                this$0.notifyItemChanged(i3);
                this$0.selectedType = type;
                c cVar2 = this$0.clickListener;
                if (cVar2 != null) {
                    cVar2.onClick(type);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rhythmTypeList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == this.rhythmTypeList.size() - 1) {
                return 1;
            }
            return 2;
        }

        public final void l0(@Nullable c clickListener) {
            this.clickListener = clickListener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            j0(holder, position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.hew, parent, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) inflate;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setGravity(1);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.findViewById(R.id.xd6).setVisibility(8);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            TextView textView = (TextView) linearLayout.findViewById(R.id.zly);
            textView.setTextSize(14.0f);
            textView.setLayoutParams(layoutParams2);
            int c16 = x.c(this.context, 20.0f);
            int c17 = x.c(this.context, 8.0f);
            int c18 = x.c(this.context, 0.5f);
            if (viewType != 1) {
                TextView textView2 = new TextView(this.context);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, c18);
                textView2.setBackgroundColor(this.context.getResources().getColor(R.color.cjq));
                textView2.setLayoutParams(layoutParams3);
                linearLayout.addView(textView2);
                textView.setPadding(c16, c17, c16, c17);
            } else {
                textView.setPadding(c16, c17, c16, c18 + c17);
            }
            return new b(linearLayout);
        }
    }

    public d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.popupWindowLayout = new LinearLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.containerLayout = linearLayout;
        TextView textView = new TextView(context);
        this.arrowDown = textView;
        this.popupWindowLayout.setOrientation(1);
        this.popupWindowLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setGravity(8388613);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int c16 = x.c(context, 9.0f);
        int c17 = x.c(context, 17.0f);
        int c18 = x.c(context, 10.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c17, c16);
        layoutParams2.setMarginEnd(c18);
        linearLayout2.addView(textView, layoutParams2);
        this.popupWindowLayout.addView(linearLayout2, layoutParams);
        PopupWindow popupWindow = new PopupWindow((View) this.popupWindowLayout, -2, -2, true);
        this.popWindow = popupWindow;
        popupWindow.setTouchable(true);
    }

    public static /* synthetic */ void f(d dVar, a aVar, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = R.drawable.owl;
        }
        if ((i17 & 4) != 0) {
            i16 = -16777216;
        }
        dVar.e(aVar, i3, i16);
    }

    public static /* synthetic */ void i(d dVar, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = R.drawable.owm;
        }
        if ((i17 & 4) != 0) {
            i16 = R.color.f156884ee;
        }
        dVar.h(str, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.popWindow.dismiss();
    }

    public final void b() {
        this.popWindow.dismiss();
    }

    @NotNull
    public final int[] c() {
        this.popupWindowLayout.measure(0, 0);
        return new int[]{this.popupWindowLayout.getMeasuredWidth(), this.popupWindowLayout.getMeasuredHeight()};
    }

    @JvmOverloads
    public final void d(@NotNull a adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        f(this, adapter, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void e(@NotNull a adapter, int arrowResId, int backColor) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        RecyclerView recyclerView = new RecyclerView(this.context);
        recyclerView.setOverScrollMode(2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        recyclerView.setAdapter(adapter);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int c16 = x.c(this.context, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(backColor);
        gradientDrawable.setCornerRadius(c16);
        this.containerLayout.setBackground(gradientDrawable);
        this.containerLayout.addView(recyclerView, layoutParams);
        VideoReport.setPageId(this.popupWindowLayout, WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setElementExposePolicy(this.popupWindowLayout, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.popupWindowLayout, EndExposurePolicy.REPORT_NONE);
        this.arrowDown.setBackgroundResource(arrowResId);
    }

    @JvmOverloads
    public final void g(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        i(this, text, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void h(@NotNull String text, int arrowResId, int backColor) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = new TextView(this.context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setText(text);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        int c16 = x.c(this.context, 10.0f);
        int c17 = x.c(this.context, 8.0f);
        textView.setPadding(c16, c17, c16, c17);
        this.containerLayout.addView(textView, layoutParams);
        int c18 = x.c(this.context, 8.0f);
        int c19 = x.c(this.context, 11.0f);
        int c26 = x.c(this.context, 14.0f);
        int c27 = x.c(this.context, -2.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c19, c18);
        layoutParams2.setMargins(0, c27, c26, 0);
        this.arrowDown.setBackgroundResource(arrowResId);
        this.arrowDown.setLayoutParams(layoutParams2);
        int c28 = x.c(this.context, 4.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.context.getResources().getColor(backColor));
        gradientDrawable.setCornerRadius(c28);
        this.containerLayout.setBackground(gradientDrawable);
    }

    @JvmOverloads
    public final void j(@NotNull View view, int x16, int y16, long dismissMilli) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.popWindow.showAtLocation(view, 0, x16, y16);
        if (dismissMilli >= 0) {
            this.popWindow.getContentView().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.k(d.this);
                }
            }, dismissMilli);
        }
    }
}
