package ka;

import android.content.Context;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxExpicPicInitBean;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import ef.d;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lka/b;", "Lho/b;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/route/QZoneSchemeBean;", "schemeBean", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends ho.b {
    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean schemeBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        if (schemeBean.getAttrs() == null) {
            QLog.e("QZoneAlbumxSchemeLauncher", 1, "parseScheme  schemeBean == null");
            return false;
        }
        if (!Intrinsics.areEqual(schemeBean.getPageAction(), "degrade_photolist")) {
            return false;
        }
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = new QZoneAlbumxExpicPicInitBean();
        qZoneAlbumxExpicPicInitBean.setPhotoStatus(d.i(schemeBean.getAttrs().get("photostatus")));
        i.y().b(context, qZoneAlbumxExpicPicInitBean);
        return true;
    }
}
