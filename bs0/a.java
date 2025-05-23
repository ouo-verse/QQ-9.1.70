package bs0;

import android.app.Activity;
import android.content.Intent;
import com.tencent.guild.api.activity.IAIOSingleActivityApi;
import com.tencent.guildlive.aio.excellentdetail.launch.GuildLiveExcellentMsgDetailFragment;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lbs0/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "channelId", "", IProfileCardConst.KEY_FROM_TYPE, "", "firstCanShowSeq", "", "a", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29030a = new a();

    a() {
    }

    public final void a(@NotNull Activity activity, @NotNull String guildId, @NotNull String channelId, int fromType, long firstCanShowSeq) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intent intent = new Intent();
        intent.putExtra("LAUNCHER_FROM_KEY", fromType);
        intent.putExtra("guild_chosen_guild_id", guildId);
        intent.putExtra("guild_chosen_channel_id", channelId);
        intent.putExtra("guild_chosen_first_can_show_seq", firstCanShowSeq);
        intent.setClass(activity, ((IAIOSingleActivityApi) QRoute.api(IAIOSingleActivityApi.class)).getAIOSingleActivityClass());
        intent.putExtra("public_fragment_class", GuildLiveExcellentMsgDetailFragment.class.getName());
        activity.startActivityForResult(intent, 0);
    }
}
