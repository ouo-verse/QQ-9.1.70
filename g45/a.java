package g45;

import NS_MOBILE_PHOTO.GetPrivilegeInfoRsp;
import android.os.Bundle;
import android.os.Handler;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.util.al;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import qzone.album.protocol.QZoneGetPrivilegeInfoRequest;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends Observable implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private static final al<a, Void> f401254d = new C10351a();

    /* compiled from: P */
    /* renamed from: g45.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10351a extends al<a, Void> {
        C10351a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    public static a D() {
        return f401254d.get(null);
    }

    public boolean E(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneGetPrivilegeInfoRequest(j3, 1), handler, this, 0));
            return true;
        }
        QZLog.w("QZoneAlbumUploadRightServices", "reqForPrivilegeInfo , NetworkState.isNetSupport() is false");
        return false;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 0) {
            return;
        }
        C(qZoneTask);
    }

    private void C(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000405);
        GetPrivilegeInfoRsp getPrivilegeInfoRsp = (GetPrivilegeInfoRsp) qZoneTask.mRequest.rsp;
        if (getPrivilegeInfoRsp == null) {
            result.setSucceed(false);
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("BOUGHT_COUNT", getPrivilegeInfoRsp.bought_balance);
            bundle.putLong("USED_COUNT", getPrivilegeInfoRsp.used_count);
            bundle.putLong("FREE_COUNT", getPrivilegeInfoRsp.free_balance);
            result.setData(bundle);
        }
        qZoneTask.sendResultMsg(result);
    }
}
