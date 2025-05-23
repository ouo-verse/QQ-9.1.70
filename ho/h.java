package ho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.debug.QZoneDebugShellFragment;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.video.QzoneVideoBeaconReport;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h {
    public static void b(Activity activity, long j3) {
        i.z().m(activity, j3);
    }

    public static void c(Context context) {
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneDebugShellFragment.class.getName()).withString("KEY_DEBUG_DATA_FACTORY", "KEY_QZONE_DEBUG").withString("KEY_TITLE", "\u7a7a\u95f4Debug\u9875\u9762").request();
    }

    public static void e(Activity activity, int i3, String str) {
        f(activity, i3, str, 11);
    }

    public static void d(Context context, String str) {
        if (context == null) {
            return;
        }
        if (yo.d.i(str, "returnactive=1")) {
            i.q(context, yo.f.j(str, "returnactive=1", "returnactive=0"));
        } else if (yo.d.i(str, "returnactiveforce=1")) {
            i.q(context, yo.f.j(str, "returnactiveforce=1", "returnactive=0"));
        }
    }

    public static boolean a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("blog_url");
        boolean z16 = bundle.getBoolean("qzone.isFavorBlog", false);
        int i3 = bundle.getInt("appid");
        String string2 = bundle.getString("cell_operation.qq_url");
        if (!TextUtils.isEmpty(string2) && i3 == 0) {
            QLog.i("QZoneRouteHelper", 1, "route to detail by url: " + string2);
            try {
                String queryParameter = Uri.parse(string2).getQueryParameter("a");
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = Uri.parse(string2).getQueryParameter("appid");
                }
                i3 = Integer.parseInt(queryParameter);
            } catch (Throwable th5) {
                RFWLog.fatal("QZoneRouteHelper", 1, th5);
            }
        }
        return i3 == 2 || !TextUtils.isEmpty(string) || z16;
    }

    public static void f(Activity activity, int i3, String str, int i16) {
        if (i3 == 2) {
            QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
            qZonePublishMoodInitBean.t0(0);
            qZonePublishMoodInitBean.C0(str);
            i.w().c(activity, qZonePublishMoodInitBean);
            return;
        }
        if (i3 == 1) {
            Intent D = ak.D(activity, 0, null, null, i16);
            D.putExtra("IsBack", true);
            if (i16 == 11) {
                D.putExtra(QzoneVideoBeaconReport.BEACON_SOURCE, QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM);
            }
            D.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, i3);
            D.putExtra("refer", str);
            if (lc.b.d()) {
                i.x().l(activity, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0), D);
            } else {
                QZonePublishMoodInitBean qZonePublishMoodInitBean2 = new QZonePublishMoodInitBean(System.currentTimeMillis());
                qZonePublishMoodInitBean2.O0(Integer.valueOf(i16));
                i.w().h(activity, qZonePublishMoodInitBean2, D);
                activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
            }
        }
    }
}
