package ie;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.qzone.misc.network.report.QzoneFeedProVisitorReportService;
import com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProAlbumFeedLayerFragment;
import com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProFeedLayerFragment;
import com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProLimitedLayerFragment;
import com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProLongPicLayerFragment;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerRouteBean;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tk.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\"\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lie/a;", "Lho/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean;", "layerLaunchBean", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "c", "b", "d", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements ho.a {
    public final void a(Context context, QzoneFeedProLayerRouteBean layerLaunchBean, CommonFeed commonFeed) {
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        if (layerLaunchBean != null && context != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_route_bean", layerLaunchBean);
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, h.C());
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(context, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QzoneFeedProAlbumFeedLayerFragment.class, bundle, 0, 128, null);
            QzoneFeedProVisitorReportService.INSTANCE.a().d(layerLaunchBean, commonFeed);
            return;
        }
        QLog.i("QzoneFeedProGalleryNativeLauncher", 1, "launchFeedGalleryLayer fail, layerLaunchBean: " + layerLaunchBean + ", context: " + context);
    }

    public final void b(Context context, QzoneFeedProLayerRouteBean layerLaunchBean, CommonFeed commonFeed) {
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        if (layerLaunchBean != null && context != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_route_bean", layerLaunchBean);
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, h.C());
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(context, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QzoneFeedProFeedLayerFragment.class, bundle, 0, 128, null);
            QzoneFeedProVisitorReportService.INSTANCE.a().d(layerLaunchBean, commonFeed);
            return;
        }
        QLog.i("QzoneFeedProGalleryNativeLauncher", 1, "launchFeedGalleryLayer fail, layerLaunchBean: " + layerLaunchBean + ", context: " + context);
    }

    public final void c(Context context, QzoneFeedProLayerRouteBean layerLaunchBean, CommonFeed commonFeed) {
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        if (layerLaunchBean != null && context != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_route_bean", layerLaunchBean);
            RFWLayerLaunchUtil.jumpToGallery$default(context, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QzoneFeedProLongPicLayerFragment.class, bundle, 0, 128, null);
            QzoneFeedProVisitorReportService.INSTANCE.a().d(layerLaunchBean, commonFeed);
            return;
        }
        QLog.i("QzoneFeedProGalleryNativeLauncher", 1, "launchFeedLongPicLayer fail, layerLaunchBean: " + layerLaunchBean + ", context: " + context);
    }

    public final void d(Context context, QzoneFeedProLayerRouteBean layerLaunchBean) {
        if (layerLaunchBean != null && context != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_route_bean", layerLaunchBean);
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, h.C());
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(context, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QzoneFeedProLimitedLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        QLog.i("QzoneFeedProGalleryNativeLauncher", 1, "launchLimitedInteractionLayer fail, layerLaunchBean: " + layerLaunchBean + ", context: " + context);
    }
}
