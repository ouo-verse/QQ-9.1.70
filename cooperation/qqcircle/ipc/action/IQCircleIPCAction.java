package cooperation.qqcircle.ipc.action;

import android.os.Bundle;
import eipc.EIPCResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcooperation/qqcircle/ipc/action/IQCircleIPCAction;", "", "doAction", "Leipc/EIPCResult;", "params", "Landroid/os/Bundle;", "callbackId", "", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public interface IQCircleIPCAction {
    @Nullable
    EIPCResult doAction(@NotNull Bundle params, int callbackId);
}
