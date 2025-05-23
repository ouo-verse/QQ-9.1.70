package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/ac;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/p;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "data", "", "l", "t", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "E", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "eventHandler", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getSortView", "()Landroid/view/View;", "sortView", "G", "getArrowView", "arrowView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "categoryName", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "categoryIcon", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ac extends p {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final g eventHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View sortView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final View arrowView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView categoryName;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView categoryIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(@NotNull View itemView, @NotNull g eventHandler) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
        View findViewById = itemView.findViewById(R.id.f86944t1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.sort_view)");
        this.sortView = findViewById;
        View findViewById2 = itemView.findViewById(R.id.w1l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.guild_channel_arrow)");
        this.arrowView = findViewById2;
        View findViewById3 = itemView.findViewById(R.id.arv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.category_name)");
        this.categoryName = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.art);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.category_icon)");
        this.categoryIcon = (ImageView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ac this$0, b data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Function2<View, b, Unit> a16 = this$0.eventHandler.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            a16.invoke(it, data);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(ac this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.eventHandler.b().invoke(this$0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ac this$0, b data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.eventHandler.d().invoke(data);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.p
    public void l(@NotNull final b data) {
        boolean z16;
        boolean z17;
        int i3;
        boolean z18;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof GuildCategoryChannelItemData)) {
            return;
        }
        this.itemView.setTag(data);
        t(data);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.q(ac.this, data, view);
            }
        });
        View view = this.itemView;
        GuildCategoryChannelItemData guildCategoryChannelItemData = (GuildCategoryChannelItemData) data;
        int i16 = 0;
        if (!guildCategoryChannelItemData.getIsEdit() && !guildCategoryChannelItemData.getIsCloseSwitch() && guildCategoryChannelItemData.getIsManager()) {
            z16 = true;
        } else {
            z16 = false;
        }
        view.setClickable(z16);
        View view2 = this.itemView;
        if (!guildCategoryChannelItemData.getIsEdit() && !guildCategoryChannelItemData.getIsCloseSwitch() && guildCategoryChannelItemData.getIsManager()) {
            z17 = true;
        } else {
            z17 = false;
        }
        view2.setFocusable(z17);
        this.categoryName.setText(guildCategoryChannelItemData.getCategoryChannel().getCategoryAlias());
        this.sortView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.aa
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                boolean r16;
                r16 = ac.r(ac.this, view3);
                return r16;
            }
        });
        if (guildCategoryChannelItemData.getIsCloseSwitch()) {
            this.categoryIcon.setImageResource(R.drawable.guild_qui_add_filled);
            this.categoryName.setAlpha(0.3f);
            this.sortView.setVisibility(8);
        } else {
            this.categoryIcon.setImageResource(R.drawable.guild_qui_reduce_filled);
            this.categoryName.setAlpha(1.0f);
            View view3 = this.sortView;
            if (guildCategoryChannelItemData.getIsEdit()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view3.setVisibility(i3);
        }
        if (guildCategoryChannelItemData.getIsEdit()) {
            this.categoryIcon.setVisibility(0);
            this.arrowView.setVisibility(8);
            this.categoryName.setAlpha(1.0f);
        } else {
            this.categoryIcon.setVisibility(8);
            View view4 = this.arrowView;
            if (!guildCategoryChannelItemData.getIsCloseSwitch() && 7 != guildCategoryChannelItemData.getCategoryChannel().getCategoryType()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                i16 = 8;
            }
            view4.setVisibility(i16);
        }
        this.categoryIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ac.s(ac.this, data, view5);
            }
        });
        if (guildCategoryChannelItemData.getCategoryChannel().getCategoryType() == 1) {
            this.categoryIcon.setAlpha(0.3f);
        } else {
            this.categoryIcon.setAlpha(1.0f);
        }
        if (!guildCategoryChannelItemData.getIsManager()) {
            this.arrowView.setVisibility(8);
            this.categoryName.setAlpha(0.3f);
        }
    }

    public final void t(@NotNull b data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof GuildCategoryChannelItemData)) {
            return;
        }
        this.itemView.setBackgroundResource(m(((GuildCategoryChannelItemData) data).getPositionType()));
    }
}
