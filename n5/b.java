package n5;

import android.os.Handler;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.preview.service.PictureManager;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements a {
    @Override // n5.a
    public void a(String str, QZoneWriteOperationService.p pVar, Handler handler) {
        PictureManager.getInstance().getSender().reship(handler, str, pVar);
    }

    @Override // n5.a
    public void b(String str, String str2, Handler handler) {
        PictureManager.getInstance().getSender().queryAlbum(handler, str);
    }
}
