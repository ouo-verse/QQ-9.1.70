package com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.adapter.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kt2.TroopBindGuildLTitleData;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J.\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/guildlist/adapter/adapter/h;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lkt2/e;", "Lkt2/a;", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/guildlist/adapter/adapter/h$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "d", "holder", "", "payloads", "", "c", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Llt2/c;", "e", "Llt2/c;", "getViewModel", "()Llt2/c;", "viewModel", "<init>", "(Landroid/app/Activity;Llt2/c;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h extends AbsListItemAdapterDelegate<TroopBindGuildLTitleData, kt2.a, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final lt2.c viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/guildlist/adapter/adapter/h$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "tipsTv", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "l", "()Landroid/view/View;", "tipsTopGap", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView tipsTv;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final View tipsTopGap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f165550wm0);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.guild_list_title_tips)");
            this.tipsTv = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f97945lr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tips_top_gap)");
            this.tipsTopGap = findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final View getTipsTopGap() {
            return this.tipsTopGap;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getTipsTv() {
            return this.tipsTv;
        }
    }

    public h(@NotNull Activity activity, @NotNull lt2.c viewModel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.activity = activity;
        this.viewModel = viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull kt2.a item, @NotNull List<kt2.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item instanceof TroopBindGuildLTitleData) {
            TroopBindGuildLTitleData troopBindGuildLTitleData = (TroopBindGuildLTitleData) item;
            if (troopBindGuildLTitleData.getTitleType() == 0 || troopBindGuildLTitleData.getTitleType() == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull TroopBindGuildLTitleData item, @NotNull a holder, int position, @NotNull List<Object> payloads) {
        String string;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        int titleType = item.getTitleType();
        if (titleType != 0) {
            if (titleType != 1) {
                string = "";
            } else {
                string = this.activity.getString(R.string.f23379788);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026ld_select_guild_top_tips)");
                holder.getTipsTopGap().setVisibility(0);
            }
        } else {
            string = this.activity.getString(R.string.f2338278a);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026guild_show_list_top_tips)");
            holder.getTipsTopGap().setVisibility(8);
        }
        holder.getTipsTv().setText(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.fzy, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026uild_tips, parent, false)");
        return new a(inflate);
    }
}
