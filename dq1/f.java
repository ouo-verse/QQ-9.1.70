package dq1;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import vh1.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Ldq1/f;", "Ldq1/c;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", "feedId", "", "b", "jump", "a", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam param;

    public f(@NotNull JumpGuildParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    private final void b(Context context, JumpGuildParam param, String feedId) {
        boolean z16 = param.getExtras().getBoolean("jumpGuildFromLoadingPage", false);
        Intent intent = new Intent();
        JumpGuildParam.JoinInfoParam joinInfoParam = param.getJoinInfoParam();
        Intrinsics.checkNotNull(joinInfoParam, "null cannot be cast to non-null type android.os.Parcelable");
        intent.putExtra("join_info_param", (Parcelable) joinInfoParam);
        intent.putExtra("jumpGuildFromLoadingPage", z16);
        intent.putExtra(JumpGuildParam.EXTRA_JUMP_REPORT_TASK, qw1.b.f(param.getExtras(), JumpGuildParam.EXTRA_JUMP_REPORT_TASK));
        intent.putExtra("funclist", param.extras.getString("funclist"));
        intent.putExtra("sgrp_channel_extension_info", param.extras.getString("sgrp_channel_extension_info"));
        intent.putExtra("param_key_search_extension_info", param.extras.getString("param_key_search_extension_info"));
        IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi = (IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class);
        String guildId = param.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "param.getGuildId()");
        String channelId = param.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "param.channelId");
        iGuildFeedNativeDetailApi.openFeedNativeDetailPage(context, guildId, channelId, feedId, param.extras.getInt("businessType", 6), intent, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    @Override // dq1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void jump(@NotNull Context context) {
        String str;
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        JumpGuildParam.ChannelDetailPageJumpInfo detailPageJumpInfo = this.param.getDetailPageJumpInfo();
        if (detailPageJumpInfo != null) {
            str = detailPageJumpInfo.getDetailId();
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("Context or feedId is null, cannot open feed detail native page.");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.jump.FeedDetailJumpStrategy", 1, (String) it.next(), null);
                    }
                    return;
                }
                Logger.f235387a.d().d("Guild.jump.FeedDetailJumpStrategy", 1, "jump feed " + this.param.guildId + " " + this.param.getChannelId() + " " + str);
                k.Companion companion = vh1.k.INSTANCE;
                String str2 = this.param.guildId;
                Intrinsics.checkNotNullExpressionValue(str2, "param.guildId");
                companion.b(str2, "GuildFeedChannelShareUrlProcessor");
                b(context, this.param, str);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
