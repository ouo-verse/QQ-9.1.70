package ad;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import cd.c;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.reborn.albumx.common.bean.d;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.comment.activity.QZoneCommentPanelActivity;
import com.qzone.reborn.comment.bean.GroupCommentParam;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.fragment.QZoneCommentPanelFragment;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.util.m;
import com.qzone.reborn.util.e;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\"\u0010#J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J4\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\"\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\"\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\f\u00a8\u0006$"}, d2 = {"Lad/a;", "Lho/a;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "params", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "d", "c", "k", "Lcom/qzone/reborn/albumx/common/bean/d;", "layerFeedInfo", "j", "p", "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "t", "r", ReportConstant.COSTREPORT_PREFIX, "g", DomainData.DOMAIN_NAME, "o", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements ho.a {
    private final void a(QZoneCommentPanelParams params, Activity activity, Fragment fragment, BusinessFeedData feedData) {
        if (e.a("QZoneCommentPanelNativeLauncher_launchCommentPanel")) {
            return;
        }
        if (feedData != null) {
            m.b("extra_key_parcelable_feed_for_detail", feedData);
        }
        if (g.f53821a.a().l()) {
            c.f30656a.n(params.getQuiThemeMode());
        }
        RFWLog.d("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchCommentPanel fragment:" + fragment + " activity:" + activity + " all params\n: " + params);
        if (fragment != null) {
            c(fragment, params);
        } else if (activity != null) {
            QZoneCommentPanelActivity.INSTANCE.a(!(activity instanceof SplashActivity));
            Navigator.withRequestCode$default(i.d(activity, "/qzone/comment_panel").withString("public_fragment_class", QZoneCommentPanelFragment.class.getName()).withSerializable("qzone_route_bean", params), activity, params.getRequestCode(), (Bundle) null, 4, (Object) null).request();
        }
    }

    private final void c(Fragment fragment, QZoneCommentPanelParams params) {
        if (!fragment.isAdded()) {
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchCommentPanel fragment is not added");
            return;
        }
        QZoneCommentPanelActivity.INSTANCE.a(!(fragment.getActivity() instanceof SplashActivity));
        try {
            Navigator.withRequestCode$default(i.d(fragment.getContext(), "/qzone/comment_panel").withString("public_fragment_class", QZoneCommentPanelFragment.class.getName()).withSerializable("qzone_route_bean", params), fragment, params.getRequestCode(), (Bundle) null, 4, (Object) null).requestWithReturn();
        } catch (QRouteException e16) {
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchCommentPanel fail " + e16);
        }
    }

    private final void d(QZoneCommentPanelParams params, Activity activity, Fragment fragment, CommonFeed feedData) {
        if (e.a("QZoneCommentPanelNativeLauncher_launchFeedProCommentPanel")) {
            return;
        }
        if (feedData != null) {
            m.b("extra_key_parcelable_feeds_pro", feedData);
        }
        if (g.f53821a.a().l()) {
            c.f30656a.n(params.getQuiThemeMode());
        }
        RFWLog.d("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchCommentPanel fragment:" + fragment + " activity:" + activity + " all params\n: " + params);
        if (fragment != null) {
            c(fragment, params);
        } else if (activity != null) {
            QZoneCommentPanelActivity.INSTANCE.a(!(activity instanceof SplashActivity));
            Navigator.withRequestCode$default(i.d(activity, "/qzone/comment_panel").withString("public_fragment_class", QZoneCommentPanelFragment.class.getName()).withSerializable("qzone_route_bean", params), activity, params.getRequestCode(), (Bundle) null, 4, (Object) null).request();
        }
    }

    public final void f(QZoneCommentPanelParams params, Fragment fragment, CommonFeed feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (fragment != null && feedData != null) {
            params.setRefer(11);
            params.setEnableEmoRapidComment(true);
            e(this, params, null, fragment, feedData, 2, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchPanelForCommentFeedPro error, " + fragment + ", " + feedData);
    }

    public final void g(QZoneCommentPanelParams params, Fragment fragment, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (fragment != null && feedData != null) {
            params.setRefer(1);
            params.setEnableEmoRapidComment(true);
            b(this, params, null, fragment, feedData, 2, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchFeedXPanel error, " + fragment + ", " + feedData);
    }

    public final void h(QZoneCommentPanelParams params, Activity activity, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && feedData != null) {
            params.setRefer(7);
            b(this, params, activity, null, feedData, 4, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchFeedXLayer error, " + activity + ", " + feedData);
    }

    public final void i(QZoneCommentPanelParams params, Activity activity, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && feedData != null) {
            CellFeedCommInfo feedCommInfo = feedData.getFeedCommInfo();
            String str = feedCommInfo != null ? feedCommInfo.feedsid : null;
            CellGroupAlbumInfo cellGroupAlbumInfo = feedData.cellGroupAlbumInfo;
            String str2 = cellGroupAlbumInfo != null ? cellGroupAlbumInfo.groupId : null;
            if (!(str == null || str.length() == 0)) {
                if (!(str2 == null || str2.length() == 0)) {
                    params.setRefer(4);
                    params.setGroupCommentParam(new GroupCommentParam(str2, null, 2, null));
                    b(this, params, activity, null, null, 12, null);
                    return;
                }
            }
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchGroupAlbumPanel error, " + str + ", " + str2);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchGroupAlbumPanel error, " + activity + ", " + feedData);
    }

    public final void j(QZoneCommentPanelParams params, Activity activity, d layerFeedInfo) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && layerFeedInfo != null && !TextUtils.isEmpty(layerFeedInfo.getGroupId())) {
            params.setRefer(5);
            params.setCacheUniKey(c.f(layerFeedInfo, params.getRequestCode()));
            params.setGroupCommentParam(new GroupCommentParam(layerFeedInfo.getGroupId(), null, 2, null));
            b(this, params, activity, null, null, 12, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchGroupLayerPanel error, " + activity + ", " + layerFeedInfo);
    }

    public final void k(QZoneCommentPanelParams params, Activity activity, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity == null) {
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchIntimatePanel error, " + activity);
            return;
        }
        params.setRefer(3);
        String string = activity.getString(R.string.glb);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026g.qzone_publis_mood_hint)");
        params.setHintText(string);
        params.setEnableAt(false);
        b(this, params, activity, null, feedData, 4, null);
    }

    public final void l(QZoneCommentPanelParams params, Activity activity) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity == null) {
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchFeedXLayer error, " + activity);
            return;
        }
        params.setRefer(7);
        b(this, params, activity, null, null, 12, null);
    }

    public final void m(QZoneCommentPanelParams params, Activity activity) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity == null) {
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchFeedXLayerShare error, " + activity);
            return;
        }
        params.setRefer(7);
        params.setShare(true);
        b(this, params, activity, null, null, 12, null);
    }

    public final void n(QZoneCommentPanelParams params, Activity activity, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && feedData != null) {
            params.setRefer(8);
            params.setEnableEmoRapidComment(true);
            b(this, params, activity, null, feedData, 4, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchNoticePanel error, " + activity + ", " + feedData);
    }

    public final void o(QZoneCommentPanelParams params, Fragment fragment, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (fragment != null && feedData != null) {
            params.setRefer(8);
            params.setEnableEmoRapidComment(true);
            b(this, params, null, fragment, feedData, 2, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchNoticePanel error, " + fragment + ", " + feedData);
    }

    public final void p(QZoneCommentPanelParams params, Activity activity, d layerFeedInfo) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && layerFeedInfo != null) {
            params.setRefer(5);
            params.setCacheUniKey(c.f(layerFeedInfo, params.getRequestCode()));
            b(this, params, activity, null, null, 12, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchPanelForQZAlbumLayer error, " + activity + ", " + layerFeedInfo);
    }

    public final void q(QZoneCommentPanelParams params, Activity activity, CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && albumInfo != null) {
            params.setRefer(10);
            params.setCacheUniKey(c.f30656a.g(albumInfo, params.getRequestCode()));
            b(this, params, activity, null, null, 12, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchPanelForQZAlbumxDetailShare error, " + activity + ", " + albumInfo);
    }

    public final void r(QZoneCommentPanelParams params, Activity activity) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity == null) {
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchShareEventTagPanel error, " + activity);
            return;
        }
        params.setRefer(6);
        params.setShare(false);
        params.setAllowEmpty(true);
        b(this, params, activity, null, null, 12, null);
    }

    public final void s(QZoneCommentPanelParams params, Fragment fragment, BusinessFeedData feedData) {
        String n3;
        Intrinsics.checkNotNullParameter(params, "params");
        if (fragment != null && feedData != null) {
            if (!QZoneFeedUtil.m(feedData)) {
                RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchSharePanel checkShareEnable disable");
                return;
            }
            if (feedData.isRegisterAnniversaryFeed()) {
                n3 = g.f53821a.a().m();
            } else {
                n3 = g.f53821a.a().n();
            }
            params.setRefer(1);
            params.setShare(true);
            params.setAllowEmpty(true);
            params.setEnableEmoRapidComment(true);
            params.setHintText(n3);
            b(this, params, null, fragment, feedData, 2, null);
            return;
        }
        RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchSharePanel error, " + fragment + ", " + feedData);
    }

    public final void t(QZoneCommentPanelParams params, Activity activity) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity == null) {
            RFWLog.e("QZoneCommentPanelNativeLauncher", RFWLog.USR, "launchPanelForWebComment error, " + activity);
            return;
        }
        params.setRefer(9);
        b(this, params, activity, null, null, 12, null);
    }

    static /* synthetic */ void b(a aVar, QZoneCommentPanelParams qZoneCommentPanelParams, Activity activity, Fragment fragment, BusinessFeedData businessFeedData, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            activity = null;
        }
        if ((i3 & 4) != 0) {
            fragment = null;
        }
        if ((i3 & 8) != 0) {
            businessFeedData = null;
        }
        aVar.a(qZoneCommentPanelParams, activity, fragment, businessFeedData);
    }

    static /* synthetic */ void e(a aVar, QZoneCommentPanelParams qZoneCommentPanelParams, Activity activity, Fragment fragment, CommonFeed commonFeed, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            activity = null;
        }
        if ((i3 & 4) != 0) {
            fragment = null;
        }
        if ((i3 & 8) != 0) {
            commonFeed = null;
        }
        aVar.d(qZoneCommentPanelParams, activity, fragment, commonFeed);
    }
}
