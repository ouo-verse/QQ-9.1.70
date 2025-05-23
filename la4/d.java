package la4;

import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lla4/d;", "", "Landroid/os/Message;", "message", "", "c", "msg", "Lcom/tencent/sqshow/zootopia/player/preload/e;", "a", "", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class d {
    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.sqshow.zootopia.player.preload.e a(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Object obj = msg2.obj;
        if (!(obj instanceof Object[])) {
            return null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 0) {
            return null;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof com.tencent.sqshow.zootopia.player.preload.e)) {
            return null;
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.player.preload.VideoPreDownloadRecord");
        return (com.tencent.sqshow.zootopia.player.preload.e) obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Object obj = msg2.obj;
        if (!(obj instanceof Object[])) {
            return -1;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 0) {
            return -1;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof Integer)) {
            return -1;
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) obj2).intValue();
    }

    public abstract boolean c(Message message);
}
