package ge;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commwriter.media_commwriter.EditPhoto;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R,\u0010\u0012\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lge/c;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "albumId", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditPhotoOperaType;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "operations", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commwriter/media_commwriter/EditPhoto;", "e", "editPhotoList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<Integer> operations = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<EditPhoto> editPhotoList = new ArrayList();

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    public final List<EditPhoto> b() {
        return this.editPhotoList;
    }

    public final List<Integer> c() {
        return this.operations;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void e(List<EditPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.editPhotoList = list;
    }

    public final void f(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.operations = list;
    }
}
