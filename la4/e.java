package la4;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.preload.d;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lla4/e;", "Lla4/d;", "Landroid/os/Message;", "msg", "", "d", "message", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends d {
    private final boolean d(Message msg2) {
        Intrinsics.checkNotNull(msg2);
        com.tencent.sqshow.zootopia.player.preload.e a16 = a(msg2);
        if (a16 == null) {
            QLog.e("VideoPreDownloadManager_QFSVideoPreloadCancelMsgProcess", 1, "handlerPreloadCancel no record");
            return false;
        }
        d.Companion companion = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE;
        ISPlayerPreDownloader m3 = companion.a().m();
        if (m3 != null) {
            m3.stopPreDownload(a16.getPreloadTaskId());
        }
        companion.a().n().remove(Integer.valueOf(a16.getPreloadTaskId()), a16);
        companion.a().j().remove(Integer.valueOf(a16.getPreloadTaskId()), a16);
        QLog.d("VideoPreDownloadManager_QFSVideoPreloadCancelMsgProcess", 1, "handler cancel success");
        return true;
    }

    @Override // la4.d
    public boolean c(Message message) {
        return d(message);
    }
}
