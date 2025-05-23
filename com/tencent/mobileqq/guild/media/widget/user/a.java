package com.tencent.mobileqq.guild.media.widget.user;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.RefreshType;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zw1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/a;", "", "Landroid/view/View;", "view", "Landroid/app/Activity;", "b", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "dstInfo", "", "d", "v", "c", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f229990a = new a();

    a() {
    }

    private final Activity b(View view) {
        if (view.getContext() instanceof Activity) {
            Context context = view.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }
        return QBaseActivity.sTopActivity;
    }

    public final void c(@Nullable View v3, @Nullable p dstInfo) {
        FragmentActivity fragmentActivity;
        IGProChannelInfo channelInfo = j.a().getChannelInfo();
        Activity currentTopActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
        String str = null;
        if (currentTopActivity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) currentTopActivity;
        } else {
            fragmentActivity = null;
        }
        if (dstInfo != null && v3 != null && channelInfo != null && fragmentActivity != null && !fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
            RobotInfoFragment.xh(fragmentActivity, j.c().e(), j.c().r(), dstInfo.f228093a, dstInfo.f228115w, "4", false, new C7845a(), 0);
            return;
        }
        if (dstInfo != null) {
            str = dstInfo.f228093a;
        }
        QLog.w("QGMC.GuildMediaItemInfoLauncher", 1, "jump robot profile failed: " + str + ", " + fragmentActivity);
    }

    public final void d(@Nullable View view, @Nullable p dstInfo) {
        String str;
        IGProChannelInfo channelInfo = j.a().getChannelInfo();
        f selfUserInfo = j.c().getSelfUserInfo();
        if (dstInfo != null && view != null && channelInfo != null) {
            GuildProfileData guildProfileData = new GuildProfileData(channelInfo.getGuildId(), channelInfo.getChannelUin(), dstInfo.f228093a, 1, MediaChannelUtils.f228046a.l());
            guildProfileData.getExtras().putParcelable(GuildProfileData.KEY_CHANNEL_DATA, new GuildAudioChannelData(channelInfo.getChannelUin(), channelInfo.getType(), selfUserInfo.f228093a, selfUserInfo.f228097e, dstInfo.f228093a, dstInfo.f228097e, dstInfo.f228112t, dstInfo.f228113u, dstInfo.f228105m));
            guildProfileData.getGuildBaseProfileData().r(channelInfo.getChannelUin());
            Activity b16 = b(view);
            if (b16 != null && !b16.isDestroyed() && !b16.isFinishing()) {
                GuildProfileCard.Lh(b16, guildProfileData);
                return;
            } else {
                QLog.e("QGMC.GuildMediaItemInfoLauncher", 1, "[jumpToUserProfile] failed. invalid activity context");
                return;
            }
        }
        if (dstInfo != null) {
            str = dstInfo.f228093a;
        } else {
            str = null;
        }
        QLog.w("QGMC.GuildMediaItemInfoLauncher", 1, "get dstInfo failed: " + str);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/widget/user/a$a", "Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfoFragment$a;", "", "a", "", "isOperate", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.widget.user.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7845a implements RobotInfoFragment.a {
        C7845a() {
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void b(boolean isOperate) {
            j.a().G(j.c().e(), RefreshType.BY_AUDIO_ROBOT);
            e.r();
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void a() {
        }
    }

    public final void a(@Nullable View view) {
    }
}
