package lo1;

import com.tencent.mobileqq.guild.gift.module.f;
import com.tencent.mobileqq.guild.gift.module.h;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2 = {"Llo1/c;", "", "Lmqq/app/AppRuntime;", "appRuntime", "Llo1/b;", DownloadInfo.spKey_Config, "", "a", "destroy", "Lcom/tencent/mobileqq/guild/gift/module/b;", "c", "Lcom/tencent/mobileqq/guild/gift/module/f;", "d", "Lcom/tencent/mobileqq/guild/gift/module/h;", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c {
    void a(@NotNull AppRuntime appRuntime, @NotNull GuildGiftConfig config);

    @NotNull
    com.tencent.mobileqq.guild.gift.module.b c();

    @NotNull
    f d();

    void destroy();

    @NotNull
    h e();
}
