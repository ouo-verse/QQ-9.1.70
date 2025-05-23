package mqq.observer;

import android.os.Bundle;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class TicketObserver implements BusinessObserver, Constants.Action {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        onChangeTicket(bundle.getString("uin"));
    }

    public void onChangeTicket(String str) {
    }
}
