package com.tencent.mobileqq.guild.media.game.memberlist;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.media.core.data.UserBusinessInfo;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.q;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvGamingItemViewHolder;", "Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder;", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "", "bindBackground", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "bindData", "", "backgroundPic", "Ljava/lang/String;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MemberRvGamingItemViewHolder extends MemberRvBaseItemViewHolder {

    @NotNull
    private String backgroundPic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRvGamingItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.backgroundPic = "";
    }

    private final void bindBackground(p userInfo) {
        getRootApngBgImageView().setVisibility(0);
        UserBusinessInfo userBusinessInfo = userInfo.C;
        if (!TextUtils.isEmpty(userBusinessInfo.getUserInfoInGame().getBackgroundPic())) {
            if (Intrinsics.areEqual(this.backgroundPic, userBusinessInfo.getUserInfoInGame().getBackgroundPic())) {
                getRootBgImageView().setVisibility(0);
                return;
            }
            this.backgroundPic = userBusinessInfo.getUserInfoInGame().getBackgroundPic();
            URLDrawable drawable = URLDrawable.getDrawable(this.backgroundPic, URLDrawable.URLDrawableOptions.obtain());
            getRootBgImageView().setAlpha(1.0f);
            getRootBgImageView().setVisibility(0);
            getRootBgImageView().setBackground(drawable);
            return;
        }
        getRootBgImageView().setVisibility(8);
        this.backgroundPic = "";
        if (QLog.isColorLevel()) {
            QLog.d(MemberRvBaseItemViewHolder.TAG, 2, "bindBackground url is empty");
        }
    }

    @Override // com.tencent.mobileqq.guild.media.game.memberlist.MemberRvBaseItemViewHolder
    public void bindData(@NotNull p userInfo, @NotNull f selfUserInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        super.bindData(userInfo, selfUserInfo);
        w.c("MemberRvGamingItemViewHolder_bindData");
        q userInfoInGame = userInfo.C.getUserInfoInGame();
        if (!TextUtils.isEmpty(userInfoInGame.getNickName())) {
            getLocalFirstHeroImageView().setVisibility(8);
            getLocalFirstHeroTextView().setVisibility(0);
            getLocalFirstHeroTextView().setText(userInfoInGame.getNickName());
        } else {
            getLocalFirstHeroTextView().setVisibility(8);
        }
        getGamingStatusLl().setVisibility(0);
        getGoodAtHeroLl().setVisibility(8);
        if (!TextUtils.isEmpty(userInfoInGame.getHeroPic())) {
            URLDrawable drawable = URLDrawable.getDrawable(userInfoInGame.getHeroPic(), URLDrawable.URLDrawableOptions.obtain());
            getGamingHeroIv().setVisibility(0);
            getGamingHeroIv().setImageDrawable(drawable);
        } else {
            getGamingHeroIv().setVisibility(8);
        }
        getGamingHeroRecordTv().setText(userInfoInGame.getRecord());
        bindBackground(userInfo);
        setDtElement(userInfo, "3");
        w.d();
    }
}
