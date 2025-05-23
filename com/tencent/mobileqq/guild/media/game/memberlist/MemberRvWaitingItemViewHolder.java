package com.tencent.mobileqq.guild.media.game.memberlist;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.q;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvWaitingItemViewHolder;", "Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder;", "", "bindBackground", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "bindData", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MemberRvWaitingItemViewHolder extends MemberRvBaseItemViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRvWaitingItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    private final void bindBackground() {
        getRootApngBgImageView().setVisibility(0);
    }

    @Override // com.tencent.mobileqq.guild.media.game.memberlist.MemberRvBaseItemViewHolder
    public void bindData(@NotNull p userInfo, @NotNull f selfUserInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        super.bindData(userInfo, selfUserInfo);
        w.c("MemberRvWaitingItemViewHolder_bindData");
        q userInfoInGame = userInfo.C.getUserInfoInGame();
        if (!TextUtils.isEmpty(userInfoInGame.getNickName())) {
            getLocalFirstHeroImageView().setVisibility(8);
            getLocalFirstHeroTextView().setVisibility(0);
            getLocalFirstHeroTextView().setText(userInfoInGame.getNickName());
        } else {
            getLocalFirstHeroTextView().setVisibility(8);
        }
        getGamingStatusLl().setVisibility(0);
        getRootBgImageView().setVisibility(8);
        getGoodAtHeroLl().setVisibility(8);
        getGamingHeroIv().setVisibility(8);
        int gameStatus = userInfoInGame.getGameStatus();
        if (gameStatus != 1) {
            if (gameStatus != 2) {
                getGamingHeroRecordTv().setText("\u6e38\u620f\u51c6\u5907\u4e2d");
            } else {
                getGamingHeroRecordTv().setText("\u6e38\u620f\u5df2\u5c31\u4f4d");
            }
        } else {
            getGamingHeroRecordTv().setText("\u6e38\u620f\u542f\u52a8\u4e2d");
        }
        bindBackground();
        setDtElement(userInfo, "1");
        w.d();
    }
}
