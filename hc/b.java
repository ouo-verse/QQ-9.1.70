package hc;

import android.os.Handler;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.preview.service.PictureManager;
import com.qzone.reborn.albumx.qzonex.utils.i;
import com.qzone.reborn.util.o;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceCloneBatchMediaCallback;
import com.tencent.qqnt.kernel.nativeinterface.PACloneBatchMediaReq;
import com.tencent.qqnt.kernel.nativeinterface.PACloneBatchMediaRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import mc.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"Lhc/b;", "Ln5/a;", "", "albumId", AEEditorConstants.ALBUMNAME, "Landroid/os/Handler;", "handler", "", "b", "Lcom/qzone/common/business/service/QZoneWriteOperationService$p;", "params", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements n5.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j3, PACloneBatchMediaRsp pACloneBatchMediaRsp) {
        c.f416541a.e("cloneBatchMedia", System.currentTimeMillis() - j3, pACloneBatchMediaRsp.result);
        if (pACloneBatchMediaRsp.result != 0) {
            QLog.d("QZAlbumxReshipService", 1, "forwardFeed fail, traceId: " + pACloneBatchMediaRsp.traceId + ", msg:" + pACloneBatchMediaRsp.errMs);
            o.f59556a.d("\u590d\u5236\u5931\u8d25 " + pACloneBatchMediaRsp.errMs, 0);
            return;
        }
        o.f59556a.d("\u590d\u5236\u6210\u529f", 0);
    }

    @Override // n5.a
    public void b(String albumId, String albumName, Handler handler) {
        PictureManager.getInstance().getSender().queryAlbum(handler, albumId);
    }

    @Override // n5.a
    public void a(String albumId, QZoneWriteOperationService.p params, Handler handler) {
        if (params == null) {
            return;
        }
        PACloneBatchMediaReq pACloneBatchMediaReq = new PACloneBatchMediaReq();
        pACloneBatchMediaReq.srcAlbumid = params.f45774f;
        pACloneBatchMediaReq.dstAlbumid = albumId;
        pACloneBatchMediaReq.albumOwner.uin = String.valueOf(params.f45773e);
        ArrayList<String> arrayList = params.f45775g;
        if (!(arrayList == null || arrayList.isEmpty())) {
            pACloneBatchMediaReq.srcMediaIds.addAll(params.f45775g);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        z b16 = i.b();
        if (b16 != null) {
            b16.cloneBatchMedia(pACloneBatchMediaReq, new IPersonalAlbumServiceCloneBatchMediaCallback() { // from class: hc.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceCloneBatchMediaCallback
                public final void onCloneBatchMedia(PACloneBatchMediaRsp pACloneBatchMediaRsp) {
                    b.d(currentTimeMillis, pACloneBatchMediaRsp);
                }
            });
        }
    }
}
