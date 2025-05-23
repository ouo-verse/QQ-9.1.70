package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.view.View;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/w;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/p;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "data", "", "l", "Lvp1/s;", "E", "Lvp1/s;", "binding", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "eventHandler", "<init>", "(Lvp1/s;Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class w extends p {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final vp1.s binding;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final g eventHandler;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w(@NotNull vp1.s binding, @NotNull g eventHandler) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        ConstraintLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.binding = binding;
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(w this$0, b data, View it) {
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
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof GuildCategoryChoiceItemData)) {
            return;
        }
        GuildCategoryChoiceItemData guildCategoryChoiceItemData = (GuildCategoryChoiceItemData) data;
        this.itemView.setBackgroundResource(m(guildCategoryChoiceItemData.getPositionType()));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.o(w.this, data, view);
            }
        });
        this.binding.f443094b.setText(guildCategoryChoiceItemData.getCategoryChannel().getCategoryAlias());
        this.binding.f443095c.setChecked(guildCategoryChoiceItemData.getIsSelect());
        CheckBox checkBox = this.binding.f443095c;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.selectStatus");
        if (guildCategoryChoiceItemData.getIsSelect()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        checkBox.setVisibility(i3);
    }
}
