package jn;

import android.content.Context;
import com.qzone.reborn.qzmoment.bean.QZMFeedDetailInitBean;
import com.qzone.reborn.qzmoment.bean.QZMFolderInitBean;
import com.qzone.reborn.qzmoment.bean.QZMMessageInitBean;
import com.qzone.reborn.qzmoment.bean.QZMMyMomentInitBean;
import com.qzone.reborn.qzmoment.bean.QZMPublishBean;
import com.qzone.reborn.qzmoment.bean.QZMPublishCaptureBean;
import com.qzone.reborn.qzmoment.fragment.QZMFeedDetailFragment;
import com.qzone.reborn.qzmoment.fragment.QZMFolderFragment;
import com.qzone.reborn.qzmoment.fragment.QZMMessageListFragment;
import com.qzone.reborn.qzmoment.fragment.QZMMyMomentFragment;
import com.qzone.reborn.qzmoment.preload.f;
import com.qzone.reborn.qzmoment.publish.QZMPublishFeedFragment;
import com.qzone.reborn.util.e;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.qphone.base.util.QLog;
import ho.i;
import jo.h;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements ho.a {
    public void a(Context context, QZMFeedDetailInitBean qZMFeedDetailInitBean) {
        if (e.b("QZMNativeLauncher_launchFeedDetailPage", 500L)) {
            return;
        }
        if (qZMFeedDetailInitBean == null) {
            QLog.e("QZMNativeLauncher", 1, "launchFeedDetailPage  bean == null");
        } else {
            h.f410717a.h("qzm_page_launch_feed_detail").t("LAUNCH_CLICK");
            i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZMFeedDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", qZMFeedDetailInitBean).request();
        }
    }

    public void b(Context context, QZMFolderInitBean qZMFolderInitBean) {
        if (e.b("QZMNativeLauncher_launchFolderPage", 500L)) {
            return;
        }
        if (qZMFolderInitBean == null) {
            QLog.e("QZMNativeLauncher", 1, "launchFolderPage  bean == null");
            return;
        }
        PreLoader.remove("qzm_folder_data_preload_id");
        PreLoader.preLoad("qzm_folder_data_preload_id", new com.qzone.reborn.qzmoment.preload.b());
        h.f410717a.h("qzm_page_launch_folder").t("LAUNCH_CLICK");
        i.d(context, "/qzone/qzm_folder_page").withString("public_fragment_class", QZMFolderFragment.class.getName()).withSerializable("key_bundle_common_init_bean", qZMFolderInitBean).withFlags(603979776).request();
    }

    public void c(Context context, QZMFolderInitBean qZMFolderInitBean, QZMPublishBean qZMPublishBean) {
        if (e.b("QZMNativeLauncher_launchFolderPage", 500L)) {
            return;
        }
        if (qZMFolderInitBean == null) {
            QLog.e("QZMNativeLauncher", 1, "launchFolderPage  bean == null");
        } else {
            h.f410717a.h("qzm_page_launch_folder").t("LAUNCH_CLICK");
            i.d(context, "/qzone/qzm_folder_page").withString("public_fragment_class", QZMFolderFragment.class.getName()).withSerializable("key_bundle_common_init_bean", qZMFolderInitBean).withParcelable("key_bundle_publish_bean", qZMPublishBean).withFlags(603979776).request();
        }
    }

    public void d(Context context, QZMMessageInitBean qZMMessageInitBean) {
        if (e.b("QZMNativeLauncher_launchMessageListPage", 500L)) {
            return;
        }
        if (qZMMessageInitBean == null) {
            QLog.e("QZMNativeLauncher", 1, "launchMessageListPage  bean == null");
        } else {
            h.f410717a.h("qzm_page_launch_message").t("LAUNCH_CLICK");
            i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZMMessageListFragment.class.getName()).withSerializable("key_bundle_common_init_bean", qZMMessageInitBean).request();
        }
    }

    public void e(Context context, QZMMyMomentInitBean qZMMyMomentInitBean) {
        if (e.b("QZMNativeLauncher_launchMyMomentPage", 500L)) {
            return;
        }
        if (qZMMyMomentInitBean == null) {
            QLog.e("QZMNativeLauncher", 1, "launchMyMomentPage  bean == null");
            return;
        }
        PreLoader.remove("qzm_history_data_preload_id");
        PreLoader.preLoad("qzm_history_data_preload_id", new f());
        h.f410717a.h("qzm_page_launch_my_moment").t("LAUNCH_CLICK");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZMMyMomentFragment.class.getName()).withSerializable("key_bundle_common_init_bean", qZMMyMomentInitBean).request();
    }

    public boolean f(Context context) {
        if (e.b("QZMNativeLauncher_launchPublishCapturePage", 500L)) {
            return false;
        }
        com.tencent.biz.qqcircle.launcher.c.g(context, "mqqapi://qcircle/openqqpublish?target=1002&ae_multi_camera_is_need_front_end_capture=1&ae_camera_ratio=1&wait_until_res_ready=1&ae_multi_camera_from=QZONE");
        return true;
    }

    public void g(QZMPublishCaptureBean qZMPublishCaptureBean) {
        if (e.b("QZMNativeLauncher_launchPublishFeedPage", 500L)) {
            return;
        }
        h.f410717a.h("qzm_page_launch_publish").t("LAUNCH_CLICK");
        i.d(null, "/qzone/holder_page").withString("public_fragment_class", QZMPublishFeedFragment.class.getName()).withSerializable("key_bundle_common_init_bean", qZMPublishCaptureBean).request();
    }
}
