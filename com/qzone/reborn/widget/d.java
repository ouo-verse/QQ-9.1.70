package com.qzone.reborn.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u001a\u0012\u0006\u0010)\u001a\u00020\"\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R(\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/widget/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qzone/reborn/widget/d$a;", "", "position", "Lcom/qzone/reborn/widget/b;", "j0", "", "list", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "holder", "k0", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Landroid/app/Dialog;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "setDialog", "(Landroid/app/Dialog;)V", "dialog", "Lcom/qzone/reborn/widget/a;", "D", "Lcom/qzone/reborn/widget/a;", "getBuildParam", "()Lcom/qzone/reborn/widget/a;", "setBuildParam", "(Lcom/qzone/reborn/widget/a;)V", "buildParam", "Landroid/view/LayoutInflater;", "E", "Landroid/view/LayoutInflater;", "mInflater", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "getMenuDataList", "()Ljava/util/List;", "setMenuDataList", "(Ljava/util/List;)V", "menuDataList", "<init>", "(Landroid/content/Context;Landroid/app/Dialog;Lcom/qzone/reborn/widget/a;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private Dialog dialog;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.widget.a buildParam;

    /* renamed from: E, reason: from kotlin metadata */
    private LayoutInflater mInflater;

    /* renamed from: F, reason: from kotlin metadata */
    private List<b> menuDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001b\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/widget/d$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setIvMenu", "(Landroid/widget/ImageView;)V", "ivMenu", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setTvMenu", "(Landroid/widget/TextView;)V", "tvMenu", "Landroid/view/View;", "G", "Landroid/view/View;", "o", "()Landroid/view/View;", "setViewLine", "(Landroid/view/View;)V", "viewLine", "itemView", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private ImageView ivMenu;

        /* renamed from: F, reason: from kotlin metadata */
        private TextView tvMenu;

        /* renamed from: G, reason: from kotlin metadata */
        private View viewLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f162810mr2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.qzone_bottom_menu_icon)");
            this.ivMenu = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f162811mr3);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.qzone_bottom_menu_text)");
            this.tvMenu = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f20518l);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026.dropdown_list_item_line)");
            this.viewLine = findViewById3;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getIvMenu() {
            return this.ivMenu;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getTvMenu() {
            return this.tvMenu;
        }

        /* renamed from: o, reason: from getter */
        public final View getViewLine() {
            return this.viewLine;
        }
    }

    public d(Context context, Dialog dialog, com.qzone.reborn.widget.a buildParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(buildParam, "buildParam");
        this.context = context;
        this.dialog = dialog;
        this.buildParam = buildParam;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.mInflater = from;
        this.menuDataList = new ArrayList();
    }

    private final b j0(int position) {
        return this.menuDataList.get(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(d this$0, b menuData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuData, "$menuData");
        this$0.dialog.dismiss();
        View.OnClickListener onClickListener = menuData.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.menuDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final b j06 = j0(position);
        holder.getIvMenu().setImageDrawable(ie0.a.f().o(this.context, j06.getIcon(), R.color.qui_common_icon_primary, this.buildParam.getSkinMode()));
        holder.getTvMenu().setText(j06.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.l0(d.this, j06, view);
            }
        });
        if (position == getNUM_BACKGOURND_ICON() - 1) {
            holder.getViewLine().setVisibility(8);
        } else {
            holder.getViewLine().setVisibility(0);
        }
        String emId = j06.getEmId();
        if (emId == null || emId.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (j06.e() != null && (!j06.e().isEmpty())) {
            linkedHashMap.putAll(j06.e());
        }
        fo.c.p(j06.getEmId(), j06.getPageId(), holder.itemView, linkedHashMap);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = this.mInflater.inflate(R.layout.f1294463, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        a aVar = new a(itemView);
        aVar.getTvMenu().setTextColor(ie0.a.f().g(this.context, R.color.qui_common_text_primary, this.buildParam.getSkinMode()));
        aVar.getViewLine().setBackground(ie0.a.f().k(this.context, R.color.qui_common_border_standard, 0.0f, this.buildParam.getSkinMode()));
        if (this.buildParam.getPressable()) {
            itemView.setBackground(this.context.getResources().getDrawable(R.drawable.f15143l));
        } else {
            itemView.setBackground(ie0.a.f().k(this.context, R.color.qui_common_bg_middle_light, 0.0f, this.buildParam.getSkinMode()));
        }
        return aVar;
    }

    public final void setData(List<b> list) {
        this.menuDataList.clear();
        if (list != null) {
            this.menuDataList.addAll(list);
        }
    }
}
