package com.tencent.mobileqq.guild.quicksearch.searchbox;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/MemberAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/f;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/a;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/MemberAdapterDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class MemberAdapterDelegate extends AbsListItemAdapterDelegate<GuildMemberData, com.tencent.mobileqq.guild.quicksearch.searchbox.a, a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/MemberAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "isInDelete", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "memberName", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "avatarFrame", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private TextView memberName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private GuildUserAvatarView avatarView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private ImageView avatarFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.eos);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.member_name)");
            this.memberName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f115206ve);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.user_avatar)");
            this.avatarView = (GuildUserAvatarView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.t1e);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.avatar_frame)");
            this.avatarFrame = (ImageView) findViewById3;
        }

        private final void m(boolean isInDelete) {
            float f16;
            float f17;
            View view = this.itemView;
            GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            view.setBackground(guildUIUtils.o(context, R.color.qui_common_fill_light_primary, 14.0f));
            this.memberName.setTextColor(this.itemView.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
            ImageView imageView = this.avatarFrame;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            float f18 = 0.5f;
            gradientDrawable.setStroke(bi.a(0.5f), this.itemView.getContext().getResources().getColorStateList(R.color.qui_common_border_standard));
            imageView.setBackground(gradientDrawable);
            TextView textView = this.memberName;
            if (isInDelete) {
                f16 = 0.5f;
            } else {
                f16 = 1.0f;
            }
            textView.setAlpha(f16);
            ImageView imageView2 = this.avatarFrame;
            if (isInDelete) {
                f17 = 0.5f;
            } else {
                f17 = 1.0f;
            }
            imageView2.setAlpha(f17);
            GuildUserAvatarView guildUserAvatarView = this.avatarView;
            if (!isInDelete) {
                f18 = 1.0f;
            }
            guildUserAvatarView.setAlpha(f18);
        }

        public final void l(@NotNull GuildMemberData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.avatarView.setAvatarTinyId(item.getData().getGuildId(), item.getData().getTinyId());
            this.memberName.setText(item.getData().getName());
            m(item.getIsInDelete());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.quicksearch.searchbox.a item, @NotNull List<com.tencent.mobileqq.guild.quicksearch.searchbox.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildMemberData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildMemberData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.l(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.eze, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        return new a(inflate);
    }
}
