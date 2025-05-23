package mc;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lmc/d;", "", "", "permissionType", "c", "(Ljava/lang/Integer;)I", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "b", "albumType", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f416543a = new d();

    d() {
    }

    public final int a(int albumType) {
        if (albumType == 2) {
            return 3;
        }
        if (albumType == 3) {
            return 5;
        }
        if (albumType == 4) {
            return 4;
        }
        if (albumType == 5) {
            return 2;
        }
        return 1;
    }

    public final int b(CommonAlbumInfo albumInfo) {
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        if (cVar.f(albumInfo)) {
            return 1;
        }
        return cVar.e(albumInfo) ? 2 : 3;
    }

    public final int c(Integer permissionType) {
        if (permissionType != null && permissionType.intValue() == 1) {
            return 1;
        }
        int i3 = 3;
        if (permissionType != null && permissionType.intValue() == 3) {
            return 4;
        }
        if (permissionType != null && permissionType.intValue() == 4) {
            return 2;
        }
        if (permissionType == null || permissionType.intValue() != 5) {
            i3 = 6;
            if (permissionType != null && permissionType.intValue() == 6) {
                return 5;
            }
            if (permissionType == null || permissionType.intValue() != 8) {
                return 0;
            }
        }
        return i3;
    }
}
