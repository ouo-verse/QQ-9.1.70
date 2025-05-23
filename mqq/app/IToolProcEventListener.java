package mqq.app;

import android.content.Intent;

/* loaded from: classes28.dex */
public interface IToolProcEventListener {
    void onBeforeExitProc();

    boolean onReceiveAccountAction(String str, Intent intent);

    boolean onReceiveLegalExitProcAction(Intent intent);
}
