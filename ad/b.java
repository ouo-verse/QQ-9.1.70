package ad;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cd.c;
import com.qzone.reborn.comment.activity.QZoneCommentPanelActivity;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProForwardPanelFragment;
import com.qzone.reborn.feedx.util.m;
import com.qzone.reborn.util.e;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u0010"}, d2 = {"Lad/b;", "Lho/a;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "params", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "a", "c", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b implements ho.a {
    private final void a(QZoneCommentPanelParams params, Activity activity, Fragment fragment, CommonFeed feedData) {
        if (e.a("QzoneForwardPanelNativeLauncher_launchFeedProForwardPanel")) {
            return;
        }
        if (feedData != null) {
            m.b("extra_key_parcelable_feeds_pro", feedData);
        }
        if (g.f53821a.a().l()) {
            c.f30656a.n(params.getQuiThemeMode());
        }
        RFWLog.d("QzoneForwardPanelNativeLauncher", RFWLog.USR, "launchForwardPanel fragment:" + fragment + " activity:" + activity + " all params\n: " + params);
        if (fragment != null) {
            c(fragment, params);
        } else if (activity != null) {
            QZoneCommentPanelActivity.INSTANCE.a(!(activity instanceof SplashActivity));
            Navigator.withRequestCode$default(i.d(activity, "/qzone/forward_panel").withString("public_fragment_class", QzoneFeedProForwardPanelFragment.class.getName()).withSerializable("qzone_route_bean", params), activity, params.getRequestCode(), (Bundle) null, 4, (Object) null).request();
        }
    }

    private final void c(Fragment fragment, QZoneCommentPanelParams params) {
        if (!fragment.isAdded()) {
            RFWLog.e("QzoneForwardPanelNativeLauncher", RFWLog.USR, "launchForwardPanel fragment is not added");
            return;
        }
        QZoneCommentPanelActivity.INSTANCE.a(!(fragment.getActivity() instanceof SplashActivity));
        try {
            Navigator.withRequestCode$default(i.d(fragment.getContext(), "/qzone/forward_panel").withString("public_fragment_class", QzoneFeedProForwardPanelFragment.class.getName()).withSerializable("qzone_route_bean", params), fragment, params.getRequestCode(), (Bundle) null, 4, (Object) null).requestWithReturn();
        } catch (QRouteException e16) {
            RFWLog.e("QzoneForwardPanelNativeLauncher", RFWLog.USR, "launchForwardPanel fail " + e16);
        }
    }

    public final void d(QZoneCommentPanelParams params, Activity activity, CommonFeed feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && feedData != null) {
            b(this, params, activity, null, feedData, 4, null);
            return;
        }
        RFWLog.e("QzoneForwardPanelNativeLauncher", RFWLog.USR, "launchPanelForForwardFeedPro error, " + activity + ", " + feedData);
    }

    static /* synthetic */ void b(b bVar, QZoneCommentPanelParams qZoneCommentPanelParams, Activity activity, Fragment fragment, CommonFeed commonFeed, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            activity = null;
        }
        if ((i3 & 4) != 0) {
            fragment = null;
        }
        if ((i3 & 8) != 0) {
            commonFeed = null;
        }
        bVar.a(qZoneCommentPanelParams, activity, fragment, commonFeed);
    }
}
