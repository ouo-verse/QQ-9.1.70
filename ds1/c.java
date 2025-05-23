package ds1;

import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProExitAVChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildUserState;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.y;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lds1/c;", "", "", "guildId", "channelId", "", "b", "Z", "isChecked", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f394748a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isChecked;

    c() {
    }

    @JvmStatic
    public static final boolean b(@NotNull String guildId, @NotNull final String channelId) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (isChecked) {
            return true;
        }
        isChecked = true;
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildUserState alreadyEnteredChannel = ((IGPSService) S0).getAlreadyEnteredChannel();
        if (alreadyEnteredChannel != null && alreadyEnteredChannel.getChannelId() == MiscKt.l(channelId)) {
            return true;
        }
        IRuntimeService S02 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(T::class.java, process)");
        long l3 = MiscKt.l(guildId);
        long l16 = MiscKt.l(channelId);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(channelId);
        ((IGPSService) S02).exitAudioLiveChannel(l3, l16, 5, arrayListOf, new y() { // from class: ds1.b
            @Override // wh2.y
            public final void a(int i3, String str, IGProExitAVChannelRsp iGProExitAVChannelRsp) {
                c.c(channelId, i3, str, iGProExitAVChannelRsp);
            }
        });
        Logger.f235387a.d().w("Guild.MF.Lt.GuildLiveRoomStateManager", 1, "checkLiveRoomState " + guildId + " - " + channelId + " state is error");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String channelId, int i3, String str, IGProExitAVChannelRsp iGProExitAVChannelRsp) {
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Logger.f235387a.d().d("Guild.MF.Lt.GuildLiveRoomStateManager", 1, "checkLiveRoomState " + channelId + " exitAudioLiveChannel " + i3 + " " + str + " " + iGProExitAVChannelRsp);
    }
}
