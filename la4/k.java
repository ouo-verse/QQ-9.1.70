package la4;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.preload.d;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lla4/k;", "Lla4/d;", "Landroid/os/Message;", "msg", "", "d", "message", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends d {
    private final boolean d(Message msg2) {
        d.Companion companion = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE;
        ISPlayerPreDownloader m3 = companion.a().m();
        if (m3 != null) {
            m3.stopAllPreDownload();
        }
        companion.a().n().clear();
        companion.a().j().clear();
        QLog.d("VideoPreDownloadManager_QFSVideoPreloadStopAllProcess", 1, "handlerStopAll success");
        return true;
    }

    @Override // la4.d
    public boolean c(Message message) {
        return d(message);
    }
}
