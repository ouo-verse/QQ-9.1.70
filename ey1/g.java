package ey1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Ley1/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ley1/e;", "memberData", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "nickNameText", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarImage", "G", "Ley1/e;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView nickNameText;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildUserAvatarView avatarImage;

    /* renamed from: G, reason: from kotlin metadata */
    private MemberData memberData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.f165879xy2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_tv_nickname)");
        this.nickNameText = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.xvn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.item_iv_avatar)");
        GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) findViewById2;
        this.avatarImage = guildUserAvatarView;
        guildUserAvatarView.setLogTag("Guild.rg.MemberViewHolder");
    }

    public final void l(@NotNull MemberData memberData) {
        Intrinsics.checkNotNullParameter(memberData, "memberData");
        this.memberData = memberData;
        if (memberData.getAvatarType() == 0) {
            this.nickNameText.setText("");
            this.avatarImage.setImageResource(R.drawable.guild_member_more);
            ViewGroup.LayoutParams layoutParams = this.avatarImage.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = ViewUtils.dip2px(16.0f);
            layoutParams2.height = ViewUtils.dip2px(16.0f);
            return;
        }
        m();
        this.avatarImage.setAvatarTinyId(memberData.getGuildId(), memberData.getTinyId());
    }

    public final void m() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        MemberData memberData = this.memberData;
        MemberData memberData2 = null;
        if (memberData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberData");
            memberData = null;
        }
        String guildId = memberData.getGuildId();
        MemberData memberData3 = this.memberData;
        if (memberData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberData");
        } else {
            memberData2 = memberData3;
        }
        String guildUserDisplayName = iGPSService.getGuildUserDisplayName(guildId, memberData2.getTinyId());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "IGPSService::class.get()\u2026ildId, memberData.tinyId)");
        this.nickNameText.setText(guildUserDisplayName);
    }
}
