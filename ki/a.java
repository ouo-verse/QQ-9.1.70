package ki;

import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAllAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAllAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\r\u00a8\u0006\u0011"}, d2 = {"Lki/a;", "", "", "groupId", "albumId", "llocId", "", "batchId", "attachInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetMediaListCallback;", "callback", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetAllAlbumListCallback;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f412421a = new a();

    a() {
    }

    public final void a(String attachInfo, IAlbumServiceGetAllAlbumListCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        NTGetAllAlbumListReq nTGetAllAlbumListReq = new NTGetAllAlbumListReq();
        nTGetAllAlbumListReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        nTGetAllAlbumListReq.attachInfo = attachInfo;
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.p0(nTGetAllAlbumListReq, callback);
        }
    }

    public final void b(String groupId, String albumId, String llocId, long batchId, String attachInfo, IAlbumServiceGetMediaListCallback callback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NTGetMediaListReq nTGetMediaListReq = new NTGetMediaListReq();
        nTGetMediaListReq.qunId = groupId;
        nTGetMediaListReq.albumId = albumId;
        nTGetMediaListReq.lloc = llocId;
        nTGetMediaListReq.batchId = batchId;
        nTGetMediaListReq.attachInfo = attachInfo;
        nTGetMediaListReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.getMediaList(nTGetMediaListReq, callback);
        }
    }
}
