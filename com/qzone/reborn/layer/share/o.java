package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.qzone.common.business.result.QZoneResult;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o extends t {
    public o(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void D() {
        C();
    }

    @Override // com.qzone.reborn.layer.share.d
    protected boolean R() {
        return false;
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void f(int i3, String str, Handler handler) {
        e(i3, str, handler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.d, com.qzone.reborn.layer.share.c, com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        super.x(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000067) {
            D();
            T(this.f58107b);
        }
    }
}
