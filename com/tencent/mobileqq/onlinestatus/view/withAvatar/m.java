package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.onlinestatus.view.OnlineStatusFriendListFragment;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J<\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/m;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/onlinestatus/model/d;", GuildMsgItem.NICK_FRIEND, "", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarDialog;", "a", "", "friends", "selectIndex", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/view/OnlineStatusFriendListFragment;", "wrFragment", "b", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f256724a = new m();

    m() {
    }

    @JvmStatic
    @NotNull
    public static final OnlineStatusLikeWithAvatarDialog a(@NotNull FragmentActivity activity, @NotNull com.tencent.mobileqq.onlinestatus.model.d friend, int fromType) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(friend, "friend");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(friend);
        OnlineStatusLikeWithAvatarDialog onlineStatusLikeWithAvatarDialog = new OnlineStatusLikeWithAvatarDialog(mutableListOf, 0, fromType);
        onlineStatusLikeWithAvatarDialog.show(activity.getSupportFragmentManager(), "showOnlineStatusLikeDialog");
        return onlineStatusLikeWithAvatarDialog;
    }

    @JvmStatic
    @NotNull
    public static final OnlineStatusLikeWithAvatarDialog b(@NotNull FragmentActivity activity, @NotNull List<com.tencent.mobileqq.onlinestatus.model.d> friends, int selectIndex, int fromType, @NotNull WeakReference<OnlineStatusFriendListFragment> wrFragment) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(friends, "friends");
        Intrinsics.checkNotNullParameter(wrFragment, "wrFragment");
        OnlineStatusLikeWithAvatarDialog onlineStatusLikeWithAvatarDialog = new OnlineStatusLikeWithAvatarDialog(friends, Math.max(0, selectIndex), fromType);
        onlineStatusLikeWithAvatarDialog.show(activity.getSupportFragmentManager(), "showOnlineStatusLikeDialog");
        onlineStatusLikeWithAvatarDialog.Nh(wrFragment);
        return onlineStatusLikeWithAvatarDialog;
    }
}
