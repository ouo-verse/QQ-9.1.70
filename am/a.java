package am;

import com.qzone.album.qun.ui.ReshipPhotoStateQun;
import com.qzone.album.qun.ui.ReshipPhotoStateQun4PhotoList;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.publish.ui.state.h;
import com.qzone.publish.ui.state.j;
import com.qzone.util.image.NetImageInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lam/a;", "Lam/c;", "", com.tencent.luggage.wxa.c8.c.G, "", "path", "", "F9", "Lcom/qzone/publish/ui/activity/QZoneUploadPhotoActivity;", "e", "Lcom/qzone/publish/ui/activity/QZoneUploadPhotoActivity;", "uploadActivity", "<init>", "(Lcom/qzone/publish/ui/activity/QZoneUploadPhotoActivity;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QZoneUploadPhotoActivity uploadActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(QZoneUploadPhotoActivity uploadActivity) {
        super(uploadActivity);
        Intrinsics.checkNotNullParameter(uploadActivity, "uploadActivity");
        this.uploadActivity = uploadActivity;
    }

    @Override // am.c
    public void F9(int pos, String path) {
        ArrayList<NetImageInfo> arrayList;
        Intrinsics.checkNotNullParameter(path, "path");
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.uploadActivity;
        if (qZoneUploadPhotoActivity.oj() == null || qZoneUploadPhotoActivity.oj().size() == 0) {
            return;
        }
        QZoneUploadPhotoActivity.ai aiVar = qZoneUploadPhotoActivity.N2;
        if (aiVar instanceof h) {
            h hVar = aiVar instanceof h ? (h) aiVar : null;
            if (hVar != null) {
                hVar.D(pos);
            }
        } else {
            if ((aiVar instanceof ReshipPhotoStateQun ? true : aiVar instanceof ReshipPhotoStateQun4PhotoList ? true : aiVar instanceof com.qzone.album.qun.ui.a ? true : aiVar instanceof com.qzone.album.qun.ui.b ? true : aiVar instanceof j) && (arrayList = qZoneUploadPhotoActivity.f45143z0) != null && arrayList.size() > pos) {
                qZoneUploadPhotoActivity.f45143z0.remove(pos);
            }
        }
        qZoneUploadPhotoActivity.ri(qZoneUploadPhotoActivity.N2.g());
        qZoneUploadPhotoActivity.ui();
        qZoneUploadPhotoActivity.sq();
        qZoneUploadPhotoActivity.fq();
    }
}
