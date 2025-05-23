package kz1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"Lkz1/m;", "Lkz1/g;", "Lmz1/g;", "Lvp1/j;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "u", "viewBinding", "<init>", "(Lvp1/j;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class m extends g<mz1.g, vp1.j> {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lkz1/m$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkz1/m;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kz1.m$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final m a(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            vp1.j g16 = vp1.j.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(parent), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
            return new m(g16);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull vp1.j viewBinding) {
        super(viewBinding);
        int i3;
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        TextView textView = viewBinding.f443024d;
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        textView.setBackground(guildUIUtils.o(context, R.color.qui_button_bg_secondary_default, 100.0f));
        ConstraintLayout root = viewBinding.getRoot();
        Context context2 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
        root.setBackground(guildUIUtils.m(context2, R.color.qui_common_icon_tertiary, 0.5f, 8.0f, 2.0f, 2.0f));
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            i3 = R.color.qui_button_text_secondary_default;
        } else {
            i3 = R.color.qui_button_text_primary_outline_default;
        }
        viewBinding.f443024d.setTextColor(this.itemView.getContext().getResources().getColor(i3));
        Context context3 = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "itemView.context");
        Drawable w3 = GuildUIUtils.w(context3, R.drawable.guild_app_manage_add_features, Integer.valueOf(i3));
        if (w3 != null) {
            w3.setBounds(0, 0, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
        }
        viewBinding.f443024d.setCompoundDrawables(w3, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o().a();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kz1.i
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull mz1.g item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        s().f443024d.setOnClickListener(new View.OnClickListener() { // from class: kz1.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.v(m.this, view);
            }
        });
        Integer d16 = o().d();
        if (d16 != null && d16.intValue() == 1) {
            TextView textView = s().f443024d;
            Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.tvManageApp");
            textView.setVisibility(8);
            TextView textView2 = s().f443022b;
            Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.tvEditTips");
            textView2.setVisibility(0);
        } else if (d16 != null && d16.intValue() == 0) {
            TextView textView3 = s().f443024d;
            Intrinsics.checkNotNullExpressionValue(textView3, "viewBinding.tvManageApp");
            textView3.setVisibility(0);
            TextView textView4 = s().f443022b;
            Intrinsics.checkNotNullExpressionValue(textView4, "viewBinding.tvEditTips");
            textView4.setVisibility(8);
        }
        TextView textView5 = s().f443024d;
        Intrinsics.checkNotNullExpressionValue(textView5, "viewBinding.tvManageApp");
        q(textView5, "em_sgrp_empty_create", true, null, item.getItemId());
    }
}
