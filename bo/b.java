package bo;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.qzone.reborn.repair.bean.QZonePhotoRepairMainInitBean;
import com.qzone.reborn.repair.bean.QZonePhotoRepairTaskInitBean;
import com.qzone.reborn.repair.fragment.QZonePhotoRepairLayerFragment;
import com.qzone.reborn.repair.fragment.QZonePhotoRepairMainFragment;
import com.qzone.reborn.repair.fragment.QZonePhotoRepairTaskListFragment;
import com.qzone.reborn.util.e;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import ho.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\bJ\u001a\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000f"}, d2 = {"Lbo/b;", "Lho/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/repair/bean/QZonePhotoRepairMainInitBean;", "initBean", "", "b", "Lcom/qzone/reborn/repair/bean/QZonePhotoRepairTaskInitBean;", "c", "Lwn/c;", "launchBean", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b implements ho.a {
    public final void b(Context context, QZonePhotoRepairMainInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (context == null) {
            return;
        }
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZonePhotoRepairMainFragment.class.getName()).withSerializable("qzone_route_bean", initBean).request();
    }

    public final void c(Context context, QZonePhotoRepairTaskInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (context == null) {
            return;
        }
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZonePhotoRepairTaskListFragment.class.getName()).withSerializable("qzone_route_bean", initBean).request();
    }

    public final void a(Context context, wn.c launchBean) {
        if (launchBean != null && context != null) {
            if (e.b("QZonePhotoRepairNativeLauncher_Repair", 500L)) {
                return;
            }
            ImageView clickView = launchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            Bundle bundle = new Bundle();
            bundle.putInt(PictureConst.PARAM_FROM, launchBean.getFrom());
            bundle.putInt("curindex", launchBean.getCurPos());
            bundle.putInt("mode", 3);
            bundle.putParcelable("photo_param", launchBean.getPhotoParam());
            bundle.putSerializable("picturelist", launchBean.l());
            bundle.putSerializable(PictureConst.KEY_INIT_BEAN, launchBean.getInitBean());
            ImageView clickView2 = launchBean.getClickView();
            List<RFWLayerItemMediaInfo> j3 = PictureViewerFactory.j(launchBean.l());
            Intrinsics.checkNotNullExpressionValue(j3, "convertPicInfo(launchBean.pics)");
            RFWLayerLaunchUtil.jumpToGallery$default(context, clickView2, j3, launchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QZonePhotoRepairLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.e("QZonePhotoRepairNativeLauncher", RFWLog.USR, "launchPhotoRepairLayer fail, layerLaunchBean: " + launchBean + ", context: " + context);
    }
}
