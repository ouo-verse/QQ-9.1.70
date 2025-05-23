package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WalletHomeResp extends BaseResp {
    public boolean isAppLoadFinished;
    public ArrayList<QWalletRedTouchInfo> resp;
    public int type;

    @Override // cooperation.qwallet.plugin.ipc.BaseIpc
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.resp = (ArrayList) bundle.getSerializable("_qwallet_ipc_WalletHome_resp");
        this.isAppLoadFinished = bundle.getBoolean("_qwallet_ipc_WalletHome_isAppLoadFinished");
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseIpc
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        ArrayList<QWalletRedTouchInfo> arrayList = this.resp;
        if (arrayList != null) {
            bundle.putSerializable("_qwallet_ipc_WalletHome_resp", arrayList);
        }
        bundle.putBoolean("_qwallet_ipc_WalletHome_isAppLoadFinished", this.isAppLoadFinished);
    }
}
