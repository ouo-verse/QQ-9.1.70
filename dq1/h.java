package dq1;

import android.content.Context;
import com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.GuildMyProfileFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ldq1/h;", "Ldq1/c;", "Landroid/content/Context;", "context", "", "jump", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h implements c {
    @Override // dq1.c
    public void jump(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GuildMyProfileFragment.INSTANCE.a(context, new GuildMyProfileFragment.OpenParam(0, null, null, 7, null));
    }
}
