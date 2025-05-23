package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import vp1.ce;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lvp1/ce;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", com.tencent.luggage.wxa.c8.c.G, "", "invoke", "(Lvp1/ce;Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;I)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildNavigatorConfigSelectIconFragment$initUI$2 extends Lambda implements Function3<ce, ConfigIconItem, Integer, Unit> {
    final /* synthetic */ QQGuildNavigatorConfigSelectIconFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildNavigatorConfigSelectIconFragment$initUI$2(QQGuildNavigatorConfigSelectIconFragment qQGuildNavigatorConfigSelectIconFragment) {
        super(3);
        this.this$0 = qQGuildNavigatorConfigSelectIconFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQGuildNavigatorConfigSelectIconFragment this$0, ConfigIconItem item, int i3, View view) {
        ConfigIconItem configIconItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Pair<Integer, ConfigIconItem> l06 = this$0.Ih().l0();
        if (l06 != null) {
            configIconItem = l06.getSecond();
        } else {
            configIconItem = null;
        }
        boolean z16 = false;
        if (Intrinsics.areEqual(configIconItem, item)) {
            item.setCheck(false);
            this$0.Ih().m0(null);
        } else {
            Pair<Integer, ConfigIconItem> l07 = this$0.Ih().l0();
            if (l07 != null) {
                l07.getSecond().setCheck(false);
                this$0.Ih().notifyItemChanged(l07.getFirst().intValue());
            }
            this$0.Lh(item, i3);
        }
        this$0.Ih().notifyItemChanged(i3);
        if (this$0.Ih().l0() != null) {
            z16 = true;
        }
        this$0.Mh(z16);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ce ceVar, ConfigIconItem configIconItem, Integer num) {
        invoke(ceVar, configIconItem, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ce ceVar, @NotNull final ConfigIconItem item, final int i3) {
        String Jh;
        Intrinsics.checkNotNullParameter(ceVar, "$this$null");
        Intrinsics.checkNotNullParameter(item, "item");
        GradientDrawable customRadiusDrawable = ViewUtils.customRadiusDrawable(AppCompatResources.getColorStateList(this.this$0.requireContext(), R.color.qui_common_fill_light_secondary), ViewUtils.dip2px(2.0f), ViewUtils.dip2px(2.0f), ViewUtils.dip2px(2.0f), ViewUtils.dip2px(2.0f));
        if (item.isCheck()) {
            customRadiusDrawable.setStroke(ViewUtils.dip2px(1.0f), AppCompatResources.getColorStateList(this.this$0.requireContext(), R.color.qui_common_brand_standard));
        }
        ceVar.f442687d.setBackground(customRadiusDrawable);
        Jh = this.this$0.Jh(Long.valueOf(item.getId()));
        if (Jh == null) {
            Jh = item.getIcon();
        }
        ImageView ivIcon = ceVar.f442686c;
        Intrinsics.checkNotNullExpressionValue(ivIcon, "ivIcon");
        com.tencent.mobileqq.guild.util.v.i(Jh, ivIcon);
        ceVar.f442686c.setColorFilter(new PorterDuffColorFilter(this.this$0.getResources().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN));
        ceVar.f442688e.setText(item.getName());
        ImageView ivCheckIcon = ceVar.f442685b;
        Intrinsics.checkNotNullExpressionValue(ivCheckIcon, "ivCheckIcon");
        ivCheckIcon.setVisibility(item.isCheck() ? 0 : 8);
        ConstraintLayout constraintLayout = ceVar.f442687d;
        final QQGuildNavigatorConfigSelectIconFragment qQGuildNavigatorConfigSelectIconFragment = this.this$0;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigSelectIconFragment$initUI$2.b(QQGuildNavigatorConfigSelectIconFragment.this, item, i3, view);
            }
        });
    }
}
