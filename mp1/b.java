package mp1;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.home.viewmodels.e;
import com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&R\u0014\u0010\u0007\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lmp1/b;", "", "", "finishRefresh", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "()Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "guildHomePermissionViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "K1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "guildSubTabPageViewModel", "Landroidx/lifecycle/LiveData;", "Lef1/a;", "", "T", "()Landroidx/lifecycle/LiveData;", "liveStartRefresh", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {
    @NotNull
    /* renamed from: K1 */
    e getGuildSubTabPageViewModel();

    @NotNull
    LiveData<ef1.a<Boolean>> T();

    @NotNull
    /* renamed from: a1 */
    GuildHomePermissionViewModel getGuildHomePermissionViewModel();

    void finishRefresh();
}
