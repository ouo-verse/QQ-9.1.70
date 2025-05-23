package la4;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.preload.d;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lla4/l;", "Lla4/d;", "Landroid/os/Message;", "msg", "", "d", "e", "message", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends d {
    private final boolean d(Message msg2) {
        if (!e(msg2)) {
            return false;
        }
        Intrinsics.checkNotNull(msg2);
        Object obj = msg2.obj;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
        Object obj2 = ((Object[]) obj)[0];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj2;
        Iterator<Map.Entry<Integer, com.tencent.sqshow.zootopia.player.preload.e>> it = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE.a().l().entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.sqshow.zootopia.player.preload.e value = it.next().getValue();
            if (str.equals(value != null ? value.g() : null)) {
                if (value != null) {
                    int preloadTaskId = value.getPreloadTaskId();
                    ISPlayerPreDownloader m3 = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE.a().m();
                    if (m3 != null) {
                        m3.stopPreDownload(preloadTaskId);
                    }
                }
                d.Companion companion = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE;
                companion.a().n().remove(value != null ? Integer.valueOf(value.getPreloadTaskId()) : null, value);
                companion.a().j().remove(value != null ? Integer.valueOf(value.getPreloadTaskId()) : null, value);
                QLog.d("VideoPreDownloadManager_QFSVideoPreloadStopProcess", 1, "handlerFeedSelected success");
                return true;
            }
        }
        QLog.d("VideoPreDownloadManager_QFSVideoPreloadStopProcess", 1, "handlerFeedSelected failed no record vid: " + str);
        return false;
    }

    private final boolean e(Message msg2) {
        Intrinsics.checkNotNull(msg2);
        Object obj = msg2.obj;
        if (!(obj instanceof Object[])) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) obj;
        return ((objArr.length == 0) ^ true) && (objArr[0] instanceof String);
    }

    @Override // la4.d
    public boolean c(Message message) {
        return d(message);
    }
}
