package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/af;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/p;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "data", "", "l", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "E", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "singleListItemView", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class af extends p {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final QUISingleLineListItem singleListItemView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final g eventHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(@NotNull QUISingleLineListItem singleListItemView, @NotNull g eventHandler) {
        super(singleListItemView);
        Intrinsics.checkNotNullParameter(singleListItemView, "singleListItemView");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.singleListItemView = singleListItemView;
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(af this$0, b data, View it) {
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

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.p
    public void l(@NotNull final b data) {
        GuildCategoryChoiceSubItemData guildCategoryChoiceSubItemData;
        Intrinsics.checkNotNullParameter(data, "data");
        super.l(data);
        if (data instanceof GuildCategoryChoiceSubItemData) {
            guildCategoryChoiceSubItemData = (GuildCategoryChoiceSubItemData) data;
        } else {
            guildCategoryChoiceSubItemData = null;
        }
        if (guildCategoryChoiceSubItemData != null) {
            this.singleListItemView.setConfig(new com.tencent.mobileqq.widget.listitem.x<>(new x.b.C8996b(guildCategoryChoiceSubItemData.getTitle(), R.drawable.guild_sub_category_setting_list_symbol), new x.c.g(guildCategoryChoiceSubItemData.getSelectSubCategoryName(), false, false, 6, null)));
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                af.o(af.this, data, view);
            }
        });
    }
}
