package kc2;

import android.os.Bundle;
import kotlin.Metadata;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lkc2/e;", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "success", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class e implements BusinessObserver {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, boolean isSuccess, @Nullable Bundle bundle) {
        if (type == 1) {
            a(isSuccess, bundle);
        }
    }

    public void a(boolean success, @Nullable Bundle bundle) {
    }
}
