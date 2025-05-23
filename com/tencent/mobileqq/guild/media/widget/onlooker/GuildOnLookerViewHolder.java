package com.tencent.mobileqq.guild.media.widget.onlooker;

import android.animation.Animator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.UserAVInfo;
import com.tencent.mobileqq.guild.media.core.data.UserBusinessInfo;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.bd;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t*\u0001)\u0018\u0000 /2\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010,\u001a\u00020\u0019\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0004R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/onlooker/GuildOnLookerViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "", "updateUserStatus", "initListeners", "updateUserName", "updateUserIdentify", "updateUserAVState", "setAudioQueueNumber", "updateRaiseHandIfNeeded", "", "isRaiseHand", "isChannelAllowRaiseHand", "needRefreshUI", "bindData", "resetStatus", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "mAvatar", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "Landroid/widget/TextView;", "mUserNameView", "Landroid/widget/TextView;", "mUserIdentifyView", "Landroid/view/View;", "mThirdAppGamingBg", "Landroid/view/View;", "Landroid/widget/LinearLayout;", "audioQueueNumberContainer", "Landroid/widget/LinearLayout;", "audioQueueNumber", "mRaiseHandContainer", "Lcom/airbnb/lottie/LottieAnimationView;", "kotlin.jvm.PlatformType", "mRaiseHandAnimView", "Lcom/airbnb/lottie/LottieAnimationView;", "mUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "mAllowRaiseHand", "Ljava/lang/Boolean;", "com/tencent/mobileqq/guild/media/widget/onlooker/GuildOnLookerViewHolder$c", "micSequenceListObserver", "Lcom/tencent/mobileqq/guild/media/widget/onlooker/GuildOnLookerViewHolder$c;", "itemView", "<init>", "(Landroid/view/View;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOnLookerViewHolder extends BaseMediaItemDelegate.BaseMediaViewHolder {

    @NotNull
    public static final String TAG = "QGMC.GuildOnLookerViewHolder";

    @NotNull
    private final TextView audioQueueNumber;

    @NotNull
    private final LinearLayout audioQueueNumberContainer;

    @Nullable
    private Boolean mAllowRaiseHand;

    @NotNull
    private final GuildWavAvatarImageView mAvatar;
    private final LottieAnimationView mRaiseHandAnimView;

    @NotNull
    private final View mRaiseHandContainer;

    @NotNull
    private final View mThirdAppGamingBg;

    @NotNull
    private final TextView mUserIdentifyView;

    @Nullable
    private p mUserInfo;

    @NotNull
    private final TextView mUserNameView;

    @NotNull
    private final c micSequenceListObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/onlooker/GuildOnLookerViewHolder$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bd;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<bd> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bd event) {
            Intrinsics.checkNotNullParameter(event, "event");
            p pVar = GuildOnLookerViewHolder.this.mUserInfo;
            if (pVar != null) {
                GuildOnLookerViewHolder.this.setAudioQueueNumber(pVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildOnLookerViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.wt6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.guild_onlooker_avatar)");
        this.mAvatar = (GuildWavAvatarImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.wt9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026guild_onlooker_user_name)");
        this.mUserNameView = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.wt8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026d_onlooker_user_identify)");
        this.mUserIdentifyView = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.wt7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026looker_third_game_status)");
        this.mThirdAppGamingBg = findViewById4;
        View findViewById5 = itemView.findViewById(R.id.vzi);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026umber_onlooker_container)");
        this.audioQueueNumberContainer = (LinearLayout) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.vzh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.\u2026io_queue_number_onlooker)");
        this.audioQueueNumber = (TextView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.wqe);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.\u2026dia_raise_hand_container)");
        this.mRaiseHandContainer = findViewById7;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) itemView.findViewById(R.id.wqf);
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.addAnimatorListener(new b());
        this.mRaiseHandAnimView = lottieAnimationView;
        this.micSequenceListObserver = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initListeners() {
        j.d().V(bd.class, this.micSequenceListObserver);
    }

    private final boolean isChannelAllowRaiseHand() {
        IGProChannelInfo channelInfo = j.a().getChannelInfo();
        if (channelInfo != null) {
            return channelInfo.isAllowOtherRaiseHand();
        }
        return false;
    }

    private final boolean isRaiseHand(p userInfo) {
        int userAVState = userInfo.C.getUserAVInfo().getUserAVState();
        if (userAVState != 3 && userAVState != 2) {
            return false;
        }
        return true;
    }

    private final boolean needRefreshUI(p userInfo) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        boolean z18;
        UserBusinessInfo userBusinessInfo;
        UserAVInfo userAVInfo;
        p pVar = this.mUserInfo;
        String str3 = null;
        if (pVar != null) {
            str = pVar.f228093a;
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, userInfo.f228093a)) {
            return true;
        }
        p pVar2 = this.mUserInfo;
        if (pVar2 != null) {
            str2 = pVar2.f228094b;
        } else {
            str2 = null;
        }
        if (!Intrinsics.areEqual(str2, userInfo.f228094b)) {
            return true;
        }
        p pVar3 = this.mUserInfo;
        if (pVar3 != null && (userBusinessInfo = pVar3.C) != null && (userAVInfo = userBusinessInfo.getUserAVInfo()) != null && userAVInfo.getUserAVState() == userInfo.C.getUserAVInfo().getUserAVState()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        p pVar4 = this.mUserInfo;
        if (pVar4 != null && pVar4.f228118z == userInfo.f228118z) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 || !Intrinsics.areEqual(this.mAllowRaiseHand, Boolean.valueOf(isChannelAllowRaiseHand()))) {
            return true;
        }
        p pVar5 = this.mUserInfo;
        if (pVar5 != null && pVar5.f228100h == userInfo.f228100h) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return true;
        }
        if (pVar5 != null) {
            str3 = pVar5.f228096d;
        }
        if (!Intrinsics.areEqual(str3, userInfo.f228096d)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAudioQueueNumber(p userInfo) {
        Object obj;
        if (!MediaChannelUtils.f228046a.u(j.a().E())) {
            this.audioQueueNumberContainer.setVisibility(8);
            return;
        }
        this.mRaiseHandContainer.setVisibility(8);
        List<IGProUserInfo> d16 = j.a().N().d1();
        Iterator<T> it = d16.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), userInfo.f228093a)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
        if (iGProUserInfo != null) {
            this.audioQueueNumberContainer.setVisibility(0);
            TextView textView = this.audioQueueNumber;
            textView.setTypeface(TypefaceProvider.c(textView.getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
            this.audioQueueNumber.setText(String.valueOf(d16.indexOf(iGProUserInfo) + 1));
            return;
        }
        this.audioQueueNumberContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRaiseHandIfNeeded(p userInfo) {
        int i3 = 8;
        this.audioQueueNumberContainer.setVisibility(8);
        boolean isRaiseHand = isRaiseHand(userInfo);
        boolean isChannelAllowRaiseHand = isChannelAllowRaiseHand();
        View view = this.mRaiseHandContainer;
        if (isChannelAllowRaiseHand && isRaiseHand) {
            i3 = 0;
        }
        view.setVisibility(i3);
        boolean isAnimating = this.mRaiseHandAnimView.isAnimating();
        if (isRaiseHand && !isAnimating) {
            if (TextUtils.isEmpty(this.mRaiseHandAnimView.getImageAssetsFolder())) {
                this.mRaiseHandAnimView.setAnimation("media/raisehand/guild_raisehand.json");
                this.mRaiseHandAnimView.setImageAssetsFolder("media/raisehand/images/");
            }
            this.mRaiseHandAnimView.setRepeatCount(1);
            this.mRaiseHandAnimView.playAnimation();
            return;
        }
        if (isAnimating && !isRaiseHand) {
            this.mRaiseHandAnimView.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserAVState(p userInfo) {
        if (MediaChannelUtils.f228046a.u(j.a().E())) {
            setAudioQueueNumber(userInfo);
            Unit unit = Unit.INSTANCE;
        } else {
            updateRaiseHandIfNeeded(userInfo);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserIdentify(p userInfo) {
        if (userInfo.f228118z) {
            this.mUserIdentifyView.setVisibility(0);
            this.mUserIdentifyView.getBackground().setColorFilter(Color.parseColor("#79798C"), PorterDuff.Mode.SRC);
            TextView textView = this.mUserIdentifyView;
            textView.setText(textView.getContext().getString(R.string.f140130d5));
            return;
        }
        this.mUserIdentifyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserName(p userInfo) {
        this.mUserNameView.setText(userInfo.f228094b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserStatus(p userInfo) {
        if (userInfo.f228100h) {
            this.mThirdAppGamingBg.setVisibility(0);
        } else {
            this.mThirdAppGamingBg.setVisibility(8);
        }
    }

    public final void bindData(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        if (!needRefreshUI(userInfo)) {
            return;
        }
        p pVar = this.mUserInfo;
        if (pVar == null) {
            p j3 = p.j();
            j3.e(userInfo);
            this.mUserInfo = j3;
        } else if (pVar != null) {
            pVar.e(userInfo);
        }
        this.mAllowRaiseHand = Boolean.valueOf(isChannelAllowRaiseHand());
        this.mAvatar.setAvatarTinyId(j.a().getGuildID(), userInfo.f228093a, userInfo.f228096d, userInfo.J);
        Unit unit = Unit.INSTANCE;
        updateUserName(userInfo);
        updateUserAVState(userInfo);
        updateUserIdentify(userInfo);
        updateUserStatus(userInfo);
        initListeners();
    }

    public final void resetStatus() {
        j.d().j(bd.class, this.micSequenceListObserver);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/widget/onlooker/GuildOnLookerViewHolder$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
