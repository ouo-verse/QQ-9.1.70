package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class BaseIpc {
    protected static final String BASE_IPC_CLASS_KEY = "_qwallet_ipc_class";

    public void toBundle(Bundle bundle) {
        bundle.putString(BASE_IPC_CLASS_KEY, getClass().getName());
    }

    public void fromBundle(Bundle bundle) {
    }
}
