package hi1;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.GuildMyProfileFragment;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lhi1/b;", "Lhi1/g;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements g {
    @Override // hi1.g
    public void a(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Logger.f235387a.d().d("Guild.jump.GuildDiscoveryC2CNoticeAIOJumper", 1, "handleAction bundle:" + bundle);
        String inboxKey = bundle.getString("BUNDLE_KEY_TARGET_INBOX_KEY", "");
        Intrinsics.checkNotNullExpressionValue(inboxKey, "inboxKey");
        GuildMyProfileFragment.INSTANCE.a(context, new GuildMyProfileFragment.OpenParam(1, inboxKey, null, 4, null));
    }
}
