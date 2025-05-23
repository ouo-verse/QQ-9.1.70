package com.tencent.mobileqq.guild.media.game.memberlist;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.q;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvNormalItemViewHolder;", "Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder;", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "", "bindData", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MemberRvNormalItemViewHolder extends MemberRvBaseItemViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRvNormalItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.tencent.mobileqq.guild.media.game.memberlist.MemberRvBaseItemViewHolder
    public void bindData(@NotNull p userInfo, @NotNull f selfUserInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        super.bindData(userInfo, selfUserInfo);
        w.c("MemberRvNormalItemViewHolder_bindData");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        q userInfoInGame = userInfo.C.getUserInfoInGame();
        if (!TextUtils.isEmpty(userInfoInGame.getHonorDesc()) && !TextUtils.isEmpty(userInfoInGame.getHonorIcon())) {
            getLocalFirstHeroTextView().setVisibility(0);
            getLocalFirstHeroImageView().setVisibility(0);
            getLocalFirstHeroTextView().setText(userInfoInGame.getHonorDesc());
            if (!Intrinsics.areEqual(getLocalFirstHeroImageView().getTag(), userInfoInGame.getHonorIcon())) {
                getLocalFirstHeroImageView().setImageDrawable(URLDrawable.getDrawable(userInfoInGame.getHonorIcon(), obtain));
                getLocalFirstHeroImageView().setTag(userInfoInGame.getHonorIcon());
            }
        } else {
            getLocalFirstHeroTextView().setVisibility(8);
            getLocalFirstHeroImageView().setVisibility(8);
        }
        getRootBgImageView().setVisibility(8);
        getGamingStatusLl().setVisibility(8);
        getGoodAtHeroLl().setVisibility(0);
        getGoodAtHeroLl().removeAllViews();
        Iterator<String> it = userInfoInGame.h().iterator();
        while (it.hasNext()) {
            URLDrawable drawable = URLDrawable.getDrawable(it.next(), obtain);
            ImageView imageView = new ImageView(this.itemView.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
            layoutParams.setMargins(ViewUtils.dip2px(1.3f), 0, ViewUtils.dip2px(1.3f), 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageDrawable(drawable);
            getGoodAtHeroLl().addView(imageView);
        }
        setDtElement(userInfo, "2");
        w.d();
    }
}
