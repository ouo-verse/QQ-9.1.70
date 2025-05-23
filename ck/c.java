package ck;

import ak.f;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxAnimUtils;
import com.qzone.reborn.feedx.util.m;
import com.qzone.reborn.intimate.bean.init.QZIntimateHistoryCalendarCardInitBean;
import com.qzone.reborn.intimate.bean.init.QZIntimateSettingPageBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumSyncInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateEditTextInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateLoveTreeInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSelectAlbumInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateTaskDetailInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.qzone.reborn.intimate.fragment.QZIntimateHistoryCalendarCardFragment;
import com.qzone.reborn.intimate.fragment.QZIntimateSpaceSettingFragment;
import com.qzone.reborn.intimate.fragment.QZoneAlbumIntimateTabFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateAlbumBatchDownloadFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateAlbumSelectCoverFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateAlbumSyncFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateEditAlbumFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateEditTextFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateFeedDetailFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateFeedMoreMediaFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateManageFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateSelectAlbumFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateSpaceAlbumDetailFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateSpaceMainFragment;
import com.qzone.reborn.intimate.fragment.QZoneIntimateTaskDetailFragment;
import com.qzone.reborn.part.publish.intimate.QZoneIntimateSpaceUploadAlbumFragment;
import com.qzone.reborn.part.publish.intimate.QZonePublishIntimateMoodFragment;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.state.report.SquareReportConst;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.util.QQToastUtil;
import ho.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rJ\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001aJ\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0016J\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0016J\u001e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0016J\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001fJ\u0016\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!J\u0016\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020$J\u001e\u0010'\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020&J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020&J\u001e\u0010+\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)J\u001e\u0010-\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020,J\u001a\u00100\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010/\u001a\u0004\u0018\u00010.J\u001a\u00102\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u000101J\u001a\u00104\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u000103J\u001a\u00105\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u00108\u001a\u00020.8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lck/c;", "Lho/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "initBean", "", "r", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Landroid/view/View;", "clickView", "d", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateWriteMoodInitBean;", "u", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "t", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateUploadAlbumInitBean;", "y", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateManageInitBean;", ReportConstant.COSTREPORT_PREFIX, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateLoveTreeInitBean;", "g", "j", "i", "k", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateTaskDetailInitBean;", HippyTKDListViewAdapter.X, "", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumSyncInitBean;", "l", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateSelectAlbumInitBean;", "v", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "editAlbumInitBean", "p", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateEditTextInitBean;", "o", "", "spaceId", h.F, "Lcom/qzone/reborn/intimate/bean/init/QZIntimateHistoryCalendarCardInitBean;", "b", "Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;", "w", "f", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c implements ho.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static boolean f31008c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateSpaceNativeLauncher";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lck/c$a;", "", "", "existLoveTree", "Z", "getExistLoveTree", "()Z", "a", "(Z)V", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ck.c$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z16) {
            c.f31008c = z16;
        }

        Companion() {
        }
    }

    public final void c(Context context, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        e(this, context, feedData, null, 4, null);
    }

    public final void d(Context context, BusinessFeedData feedData, View clickView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        m.b("extra_key_parcelable_feed_for_detail", feedData);
        QZoneFeedxAnimUtils qZoneFeedxAnimUtils = QZoneFeedxAnimUtils.f55700a;
        QZoneBaseFeedItemView b16 = qZoneFeedxAnimUtils.b(clickView);
        AnimationParams c16 = b16 != null ? qZoneFeedxAnimUtils.c(b16) : null;
        i.d(context, qZoneFeedxAnimUtils.a(context, c16)).withString("feed_id", feedData.getFeedCommInfo().feedsid).withString("public_fragment_class", QZoneIntimateFeedDetailFragment.class.getName()).withParcelable("feed_detail_animation_params", c16 instanceof Parcelable ? c16 : null).request();
    }

    public final void g(Context context, QZoneIntimateLoveTreeInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        String str = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=" + ("love_wall_homepage&bottom_nav_bar_immersive=1&custom_back_pressed=1&peer_uin=" + initBean.getPeerUin() + "&enter_page=" + initBean.getEnterPage() + "&flower_id=" + initBean.getFlowerId() + "&from=" + initBean.getFrom()) + "&local_bundle_name=nearbypro";
        if (f31008c) {
            QQToastUtil.showQQToastInUiThread(4, "\u5df2\u5728\u7231\u60c5\u85e4\u8513\u4e2d\uff0c\u4e0d\u80fd\u91cd\u590d\u6253\u5f00");
        } else {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
        }
    }

    public final void i(Context context, QZoneIntimateAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        PreLoader.remove("album_detail_batch_data_preload_id");
        PreLoader.preLoad("album_detail_batch_data_preload_id", new ak.b(initBean));
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateAlbumBatchDownloadFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void j(Context context, QZoneIntimateAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        com.qzone.publish.business.publishqueue.intimate.i.f51168a.g(initBean.getSpaceId());
        kj.b.l().r(initBean.getSpaceId(), null);
        PreLoader.remove("album_detail_batch_data_preload_id");
        PreLoader.preLoad("album_detail_batch_data_preload_id", new ak.b(initBean));
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateSpaceAlbumDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void k(Activity activity, int requestCode, QZoneIntimateAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        PreLoader.remove("album_detail_batch_data_preload_id");
        PreLoader.preLoad("album_detail_batch_data_preload_id", new ak.b(initBean));
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateAlbumSelectCoverFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void l(Context context, QZoneIntimateAlbumSyncInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        PreLoader.remove("qzone_album_list_data_preload_id");
        PreLoader.preLoad("qzone_album_list_data_preload_id", new f(initBean));
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateAlbumSyncFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void m(Context context, long uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneAlbumIntimateTabFragment.class.getName()).withLong("key_album_owner_uin", uin).request();
    }

    public final void n(Context context, QZoneIntimateSelectAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateSelectAlbumFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void o(Activity activity, int requestCode, QZoneIntimateEditTextInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateEditTextFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void p(Activity activity, int requestCode, CommonAlbumEditInitBean editAlbumInitBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(editAlbumInitBean, "editAlbumInitBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateEditAlbumFragment.class.getName()), activity, requestCode, (Bundle) null, 4, (Object) null).withSerializable("key_bundle_common_init_bean", editAlbumInitBean).request();
    }

    public final void q(Context context, QZoneIntimateAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        PreLoader.remove("album_detail_batch_data_preload_id");
        PreLoader.preLoad("album_detail_batch_data_preload_id", new ak.b(initBean));
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateFeedMoreMediaFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void r(Context context, QZoneIntimateMainPageInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if ((initBean.getSpaceId().length() == 0) && !initBean.getIsDraft()) {
            RFWLog.e(this.TAG, RFWLog.USR, "[launchSpaceMainPage] spaceId is empty");
            return;
        }
        if (gd.a.f401926a.c("KEY_OPEN_UPLOAD_DEBUG_ENV", false)) {
            IUploadService uploadServiceBuilder = UploadServiceBuilder.getInstance();
            DebugServerRoute debugServerRoute = DebugServerRoute.CUSTOM;
            debugServerRoute.setServerIp("106.53.137.23");
            debugServerRoute.setServerPort(TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
            uploadServiceBuilder.setDebugServerRoute(debugServerRoute);
        }
        com.qzone.publish.business.publishqueue.intimate.i.f51168a.g(initBean.getSpaceId());
        kj.b.l().r(initBean.getSpaceId(), null);
        PreLoader.remove("album_list_data_preload_id");
        if (!initBean.getIsDraft()) {
            PreLoader.preLoad("album_list_data_preload_id", new ak.d(initBean));
        }
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateSpaceMainFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void s(Context context, QZoneIntimateManageInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        PreLoader.remove("manage_page_data_preload_id");
        PreLoader.preLoad("manage_page_data_preload_id", new ak.h(initBean));
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateManageFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void t(Activity activity, QZoneIntimateWriteMoodInitBean initBean, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        RFWLog.d(this.TAG, RFWLog.USR, "[launchSpacePublishMoodPage] spaceId" + initBean.getSpaceId());
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZonePublishIntimateMoodFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void u(Context context, QZoneIntimateWriteMoodInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        RFWLog.d(this.TAG, RFWLog.USR, "[launchSpacePublishMoodPage] spaceId" + initBean.getSpaceId());
        i.d(context, "/qzone/common_upload_page").withString("public_fragment_class", QZonePublishIntimateMoodFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void v(Activity activity, int requestCode, QZoneIntimateSelectAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateSelectAlbumFragment.class.getName()), activity, requestCode, (Bundle) null, 4, (Object) null).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void x(Context context, QZoneIntimateTaskDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneIntimateTaskDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void y(Context context, QZoneIntimateUploadAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/common_upload_page").withString("public_fragment_class", QZoneIntimateSpaceUploadAlbumFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void f(Context context, BusinessFeedData feedData) {
        Map mutableMapOf;
        User user;
        CellFeedCommInfo feedCommInfo;
        String str = null;
        String str2 = (feedData == null || (feedCommInfo = feedData.getFeedCommInfo()) == null) ? null : feedCommInfo.feedsid;
        if (context != null && feedData != null) {
            if (!(str2 == null || str2.length() == 0)) {
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("feed_id", str2));
                CellIntimateSpaceInfo cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo;
                if (cellIntimateSpaceInfo != null) {
                    String str3 = cellIntimateSpaceInfo.spaceId;
                    Intrinsics.checkNotNullExpressionValue(str3, "feedData.cellIntimateSpaceInfo.spaceId");
                    mutableMapOf.put("space_id", str3);
                    mutableMapOf.put("space_type", String.valueOf(feedData.cellIntimateSpaceInfo.spaceType));
                }
                CellUserInfo cellUserInfo = feedData.cellUserInfo;
                if (cellUserInfo != null && (user = cellUserInfo.user) != null) {
                    str = user.uid;
                }
                if (str == null) {
                    str = "";
                }
                mutableMapOf.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str);
                i.r(context, g.f53821a.h().x(), mutableMapOf);
                return;
            }
        }
        RFWLog.e(this.TAG, RFWLog.USR, "launchLikeListH5 error, context: " + context + ", feedId: + " + str2);
    }

    public static /* synthetic */ void e(c cVar, Context context, BusinessFeedData businessFeedData, View view, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            view = null;
        }
        cVar.d(context, businessFeedData, view);
    }

    public final void b(Context context, QZIntimateHistoryCalendarCardInitBean initBean) {
        if (context == null || initBean == null) {
            return;
        }
        i.d(context, "/qzone/holder_page_transparent").withString("public_fragment_class", QZIntimateHistoryCalendarCardFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void w(Context context, QZIntimateSettingPageBean initBean) {
        if (context == null || initBean == null) {
            return;
        }
        i.d(context, "/qzone/holder_page_transparent").withString("public_fragment_class", QZIntimateSpaceSettingFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void h(Context context, String spaceId) {
        Map mutableMapOf;
        if (context != null) {
            if (spaceId == null || spaceId.length() == 0) {
                return;
            }
            g gVar = g.f53821a;
            if (gVar.h().w()) {
                i.q(context, gVar.h().j(0.55f, gVar.h().B() + "&space_id=" + spaceId));
                return;
            }
            String B = gVar.h().B();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("space_id", spaceId));
            i.r(context, B, mutableMapOf);
        }
    }
}
