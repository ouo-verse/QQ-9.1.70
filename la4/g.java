package la4;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.preload.d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lla4/g;", "Lla4/d;", "", "preloadMaxIndex", "Ljava/util/concurrent/ConcurrentSkipListMap;", "Lcom/tencent/sqshow/zootopia/player/preload/e;", "continueMap", "", "d", "e", "Landroid/os/Message;", "message", "", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends d {
    private final void d(int preloadMaxIndex, ConcurrentSkipListMap<Integer, com.tencent.sqshow.zootopia.player.preload.e> continueMap) {
        Iterator<Map.Entry<Integer, com.tencent.sqshow.zootopia.player.preload.e>> it = continueMap.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.sqshow.zootopia.player.preload.e value = it.next().getValue();
            if (value != null && value.f() < preloadMaxIndex) {
                it.remove();
            }
        }
    }

    private final void e() {
        Iterator<Map.Entry<Integer, com.tencent.sqshow.zootopia.player.preload.e>> it = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE.a().j().entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.sqshow.zootopia.player.preload.e value = it.next().getValue();
            if (!(value != null && value.getPreloadDuration() == 6)) {
                if (value != null) {
                    value.l(6);
                }
                if (value != null) {
                    value.j(true);
                }
                com.tencent.sqshow.zootopia.player.preload.d.INSTANCE.a().r(2, value);
                it.remove();
                QLog.d("VideoPreDownloadManager_QFSVideoPreloadContinueProcess", 1, "tryToContinueDownload:" + value);
            }
        }
    }

    @Override // la4.d
    public boolean c(Message message) {
        d.Companion companion = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE;
        int c16 = (com.tencent.sqshow.zootopia.player.preload.e.INSTANCE.b().get() - companion.c()) + 1;
        d(c16, companion.a().n());
        d(c16, companion.a().j());
        int size = companion.a().n().size();
        int size2 = companion.a().j().size();
        QLog.d("VideoPreDownloadManager_QFSVideoPreloadContinueProcess", 1, "QFSVideoPreloadContinueProcess:|currentPreloadCount:" + size + "|continueMapSize:" + size2);
        if (size == 0 && size2 != 0) {
            e();
        }
        return true;
    }
}
