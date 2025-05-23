package la4;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.preload.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lla4/f;", "Lla4/d;", "Landroid/os/Message;", "msg", "", "e", "", "preloadCount", "", "d", "message", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends d {
    private final void d(int preloadCount) {
        int c16 = preloadCount - com.tencent.sqshow.zootopia.player.preload.d.INSTANCE.c();
        if (c16 < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            d.Companion companion = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE;
            Map.Entry<Integer, com.tencent.sqshow.zootopia.player.preload.e> firstEntry = companion.a().n().firstEntry();
            if (firstEntry != null) {
                companion.a().n().remove(firstEntry.getKey());
                companion.a().r(3, firstEntry.getValue());
                QLog.d("VideoPreDownloadManager_QFSVideoPreloadCheckNumMsgProcess", 1, " begin to cancel fromCheckNum | current preloadCount: " + preloadCount);
            }
            if (i3 == c16) {
                return;
            } else {
                i3++;
            }
        }
    }

    private final boolean e(Message msg2) {
        Intrinsics.checkNotNull(msg2);
        com.tencent.sqshow.zootopia.player.preload.e a16 = a(msg2);
        if (a16 == null) {
            return false;
        }
        d.Companion companion = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE;
        int size = companion.a().n().size();
        if (size >= companion.c()) {
            d(size);
        }
        companion.a().r(10, new Object[0]);
        companion.a().r(2, a16);
        return true;
    }

    @Override // la4.d
    public boolean c(Message message) {
        return e(message);
    }
}
