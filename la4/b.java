package la4;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.preload.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lla4/b;", "Lla4/d;", "Landroid/os/Message;", "message", "", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends d {
    @Override // la4.d
    public boolean c(Message message) {
        Intrinsics.checkNotNull(message);
        int b16 = b(message);
        if (b16 > 0) {
            d.Companion companion = com.tencent.sqshow.zootopia.player.preload.d.INSTANCE;
            companion.e(b16);
            QLog.d("VideoPreDownloadManager_QFSUpdatePreloadMaxCount", 1, "update current preloadCount:" + companion.c());
        }
        return true;
    }
}
