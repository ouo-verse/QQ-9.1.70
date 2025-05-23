package dq1;

import android.content.Context;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Ldq1/l;", "Ldq1/c;", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "a", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam param;

    public l(@NotNull JumpGuildParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // dq1.c
    public void jump(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        JumpGuildParam.ChannelDetailPageJumpInfo detailPageJumpInfo = this.param.getDetailPageJumpInfo();
        if (detailPageJumpInfo != null) {
            str = detailPageJumpInfo.getDetailId();
        } else {
            str = null;
        }
        if (MiscKt.f(str)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("jump error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.ScheduleDetailJumpStrategy", 1, (String) it.next(), null);
            }
            return;
        }
        GuildScheduleDetailFragment.bi(context, str, this.param);
    }
}
