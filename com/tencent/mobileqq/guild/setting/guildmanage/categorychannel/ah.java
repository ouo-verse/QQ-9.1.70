package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.text.TextUtils;
import android.view.View;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/ah;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/p;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "data", "", "l", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "E", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "eventHandler", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "categoryTitle", "G", "rightBtnText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ah extends p {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final g eventHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView categoryTitle;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView rightBtnText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(@NotNull View itemView, @NotNull g eventHandler) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
        View findViewById = itemView.findViewById(R.id.tp6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.category_title)");
        this.categoryTitle = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.tp7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026category_title_right_btn)");
        this.rightBtnText = (TextView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ah this$0, b data, View it) {
        Function2<View, b, Unit> c16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && (c16 = this$0.eventHandler.c()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            c16.invoke(it, data);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.p
    public void l(@NotNull final b data) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof GuildCategoryChannelTitleHolderData) {
            this.categoryTitle.setText("\u5728\u9891\u9053\u4e3b\u9875\u663e\u793a\u7684\u529f\u80fd\u5206\u533a");
            GuildCategoryChannelTitleHolderData guildCategoryChannelTitleHolderData = (GuildCategoryChannelTitleHolderData) data;
            if (!TextUtils.isEmpty(guildCategoryChannelTitleHolderData.getRightBtnText())) {
                this.rightBtnText.setText(guildCategoryChannelTitleHolderData.getRightBtnText());
                this.rightBtnText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.ag
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ah.o(ah.this, data, view);
                    }
                });
            }
            TextView textView = this.rightBtnText;
            if (guildCategoryChannelTitleHolderData.getIsShowRightBtn()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
        if (data instanceof GuildCategoryChannelSecondHolderData) {
            this.categoryTitle.setText("\u4e0d\u663e\u793a\u7684\u529f\u80fd\u5206\u533a");
        }
        if (data instanceof GuildCategoryChannelTitleHideInEditHolderData) {
            this.categoryTitle.setText(R.string.f143000kw);
        }
    }
}
