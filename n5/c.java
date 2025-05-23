package n5;

import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.business.service.QZoneWriteOperationService;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c implements a {
    @Override // n5.a
    public void b(String str, String str2, Handler handler) {
        QZoneWriteOperationService.v0().T1(str, handler);
    }

    @Override // n5.a
    public void a(String str, QZoneWriteOperationService.p pVar, Handler handler) {
        QZoneWriteOperationService.v0().s0(null, null, pVar.f45771c, 0, pVar.f45773e, pVar.f45774f, pVar.f45775g, "", null, null, null, 0, 0, 0, null, 7, str, !TextUtils.isEmpty(str) ? -1 : 1, null, handler, null, false, false, pVar.f45790v, null);
    }
}
