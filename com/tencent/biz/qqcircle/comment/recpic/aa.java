package com.tencent.biz.qqcircle.comment.recpic;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QFSPrivateSettingBean;
import com.tencent.biz.qqcircle.fragments.QFSCommentRecPicPermissionFragment;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.IWinkWeClipApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u20.PermissionFeedGuideConfig;
import u20.PermissionPanelGuideConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b#\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001e\u001a\u00020\u0002J&\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!J\u0006\u0010'\u001a\u00020%J\u0010\u0010(\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\bJ\u0006\u0010)\u001a\u00020\u0002J\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\u0002J\u0006\u0010.\u001a\u00020%J\u0006\u0010/\u001a\u00020%J\u000e\u00100\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bJ\u0006\u00101\u001a\u00020%J\u0006\u00102\u001a\u00020\u0002J\u0006\u00103\u001a\u00020%J\u0010\u00104\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\bJ\u0006\u00105\u001a\u00020%J\u0010\u00106\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\bJ\u0010\u00107\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\bJ\u0006\u00108\u001a\u00020%J\u0006\u00109\u001a\u00020%R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010:R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010:R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00109R$\u0010C\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010:R\u0016\u0010E\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010:\u00a8\u0006H"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/aa;", "", "", "p", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentManager;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "D", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "l", "k", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "w", HippyTKDListViewAdapter.X, "y", "u", "G", UserInfo.SEX_FEMALE, "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", "Landroid/content/Context;", "context", "", "feedId", "from", "pageId", "", BdhLogUtil.LogTag.Tag_Req, "J", "E", "e", "O", "d", "v", "c", "b", "P", "f", "K", "g", "L", "j", "N", "i", tl.h.F, "M", "I", "Z", "isAllowPermission", "isShowPermissionAnim", "entranceTxtExposeCount", "Ljava/lang/String;", "B", "()Ljava/lang/String;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Ljava/lang/String;)V", "showFeedGuideFeedId", "hasCheckStoragePermission", "hasStoragePermission", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aa f83750a = new aa();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isAllowPermission = uq3.k.a().c("qqcircle_allow_scan_local_pic", false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowPermissionAnim = uq3.k.a().c("qqcircle_show_permission_anim", false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int entranceTxtExposeCount = uq3.k.a().e("qqcircle_show_permission_anim", 0);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String showFeedGuideFeedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean hasCheckStoragePermission;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean hasStoragePermission;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/comment/recpic/aa$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f83757a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f83758b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f83759c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f83760d;

        a(String str, String str2, String str3, Context context) {
            this.f83757a = str;
            this.f83758b = str2;
            this.f83759c = str3;
            this.f83760d = context;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QFSCommentRecPicPermissionFragment qFSCommentRecPicPermissionFragment = new QFSCommentRecPicPermissionFragment();
            qFSCommentRecPicPermissionFragment.uh(this.f83757a);
            qFSCommentRecPicPermissionFragment.vh(this.f83758b);
            qFSCommentRecPicPermissionFragment.wh(this.f83759c);
            FragmentManager C = aa.f83750a.C((FragmentActivity) this.f83760d);
            if (C.isDestroyed()) {
                QLog.d("QFSCommentRecPicControlHelper", 1, "[afterPermission] SFM is destroyed");
            } else {
                qFSCommentRecPicPermissionFragment.show(C, QFSCommentRecPicPermissionFragment.class.getSimpleName());
            }
        }
    }

    aa() {
    }

    private final int A() {
        return z.f83900a.o().getTotalCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentManager C(FragmentActivity activity) {
        if (bz.r() && activity.isDestroyed()) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity instanceof FragmentActivity) {
                QLog.d("QFSCommentRecPicControlHelper", 1, "[getSupportFragmentManager] use splashActivity");
                FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "hostActivity.supportFragmentManager");
                return supportFragmentManager;
            }
            FragmentManager supportFragmentManager2 = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.supportFragmentManager");
            return supportFragmentManager2;
        }
        FragmentManager supportFragmentManager3 = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "activity.supportFragmentManager");
        return supportFragmentManager3;
    }

    private final boolean D(Activity activity) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, QQPermissionConstants.Business.SCENE.QCIRCLE_MIX_FEED));
        if (qQPermission == null || qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0 || qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            return false;
        }
        return true;
    }

    private final boolean p() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_low_device", false);
    }

    private final boolean s() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(" qqcircle_disable_permission_feed_guide_new", false);
    }

    @Nullable
    public final String B() {
        return showFeedGuideFeedId;
    }

    public final boolean E(@Nullable Activity activity) {
        if (isAllowPermission) {
            if (hasCheckStoragePermission) {
                return hasStoragePermission;
            }
            hasCheckStoragePermission = true;
            boolean D = D(activity);
            hasStoragePermission = D;
            if (!D) {
                QLog.d("QFSCommentRecPicControlHelper", 1, "hasStoragePermission = false");
            }
            return hasStoragePermission;
        }
        return false;
    }

    public final boolean F() {
        boolean equals = TextUtils.equals(com.tencent.biz.qqcircle.utils.k.a("exp_input_recom_v5"), "exp_input_recom_v5_B");
        if (p()) {
            if (!QCircleDeviceInfoUtils.isLowDevice() && equals) {
                return true;
            }
            return false;
        }
        return equals;
    }

    public final boolean G() {
        if (uq3.k.b().e("QFSOpenRecPicDebugInfoController", 0) != 1) {
            return false;
        }
        return true;
    }

    public final boolean H() {
        if (isAllowPermission && !uq3.k.a().c(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC, false)) {
            return false;
        }
        return true;
    }

    public final void I() {
        QLog.d("QFSCommentRecPicControlHelper", 1, "resetCache");
        Iterator<QFSRecPicInfo> it = QFSCommentRecPicClusterHelper.f83716a.I().iterator();
        while (it.hasNext()) {
            ((IWinkWeClipApi) QRoute.api(IWinkWeClipApi.class)).removeImageFeature(it.next().getPhotoId());
        }
        uq3.k.a().j(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_REC_PIC, false);
        uq3.k.a().j("key_show_permission_feed_guide_red_point", true);
        uq3.k.a().j("qqcircle_allow_scan_local_pic", false);
        uq3.k.a().j("qqcircle_show_permission_anim", false);
        uq3.k.a().n("qqcircle_last_show_rec_feed_guide_timestamp", 0L);
        uq3.k.a().m("qqcircle_show_rec_feed_guide_count", 0);
        uq3.k.a().n("qqcircle_last_show_permission_feed_guide_timestamp", 0L);
        uq3.k.a().m("qqcircle_show_permission_feed_guide_count", 0);
        uq3.k.a().n("qqcircle_last_show_rec_panel_guide_timestamp", 0L);
        uq3.k.a().m("qqcircle_show_rec_panel_guide_count", 0);
        uq3.k.a().n("qqcircle_last_show_permission_panel_guide_timestamp", 0L);
        uq3.k.a().m("qqcircle_show_permission_panel_guide_count", 0);
        QFSCommentRecPicClusterHelper.f83716a.B();
    }

    public final void J() {
        hasCheckStoragePermission = false;
        hasStoragePermission = true;
        isAllowPermission = true;
        uq3.k.a().j("qqcircle_allow_scan_local_pic", true);
    }

    public final void K() {
        uq3.k.a().n("qqcircle_last_show_permission_feed_guide_timestamp", System.currentTimeMillis());
        uq3.k.a().m("qqcircle_show_permission_feed_guide_count", uq3.k.a().e("qqcircle_show_permission_feed_guide_count", 0) + 1);
    }

    public final void L() {
        uq3.k.a().j("key_show_permission_feed_guide_red_point", false);
    }

    public final void M() {
        uq3.k.a().n("qqcircle_last_show_permission_panel_guide_timestamp", System.currentTimeMillis());
        uq3.k.a().m("qqcircle_show_permission_panel_guide_count", uq3.k.a().e("qqcircle_show_permission_panel_guide_count", 0) + 1);
    }

    public final void N() {
        long f16 = uq3.k.a().f("qqcircle_last_show_rec_panel_guide_timestamp", 0L);
        if (System.currentTimeMillis() - f16 > com.tencent.qqnt.chats.core.b.a() && f16 != 0) {
            uq3.k.a().n("qqcircle_last_show_rec_panel_guide_timestamp", 0L);
            uq3.k.a().m("qqcircle_show_rec_panel_guide_count", 0);
        } else {
            uq3.k.a().n("qqcircle_last_show_rec_panel_guide_timestamp", System.currentTimeMillis());
            uq3.k.a().m("qqcircle_show_rec_panel_guide_count", uq3.k.a().e("qqcircle_show_rec_panel_guide_count", 0) + 1);
        }
    }

    public final void O() {
        isShowPermissionAnim = true;
        uq3.k.a().j("qqcircle_show_permission_anim", true);
    }

    public final void P() {
        entranceTxtExposeCount = A() + 1;
        uq3.k.a().m("qqcircle_show_permission_anim", entranceTxtExposeCount);
    }

    public final void Q(@Nullable String str) {
        showFeedGuideFeedId = str;
    }

    public final void R(@NotNull Context context, @NotNull String feedId, @NotNull String from, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (!(context instanceof FragmentActivity)) {
            return;
        }
        com.tencent.biz.qqcircle.utils.z.b((Activity) context, 2, new a(feedId, from, pageId, context), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_PUBLISH_FEED), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    public final void b() {
        entranceTxtExposeCount++;
        uq3.k.a().m("qqcircle_show_permission_anim", entranceTxtExposeCount);
    }

    public final boolean c() {
        if (entranceTxtExposeCount == A()) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (entranceTxtExposeCount < A()) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        return !isShowPermissionAnim;
    }

    public final boolean f(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (E(activity)) {
            return false;
        }
        long f16 = uq3.k.a().f("qqcircle_last_show_permission_feed_guide_timestamp", 0L);
        int e16 = uq3.k.a().e("qqcircle_show_permission_feed_guide_count", 0);
        PermissionFeedGuideConfig n3 = z.f83900a.n();
        if (e16 >= n3.getTotalCount() || System.currentTimeMillis() - f16 <= n3.getInterval() * 1000) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        if (s()) {
            return false;
        }
        return uq3.k.a().c("key_show_permission_feed_guide_red_point", true);
    }

    public final boolean h(@Nullable Activity activity) {
        if (E(activity)) {
            return false;
        }
        long f16 = uq3.k.a().f("qqcircle_last_show_permission_panel_guide_timestamp", 0L);
        int e16 = uq3.k.a().e("qqcircle_show_permission_panel_guide_count", 0);
        PermissionPanelGuideConfig p16 = z.f83900a.p();
        if (e16 >= p16.getTotalCount() || System.currentTimeMillis() - f16 <= p16.getInterval() * 1000) {
            return false;
        }
        return true;
    }

    public final boolean i(@Nullable Activity activity) {
        if (E(activity) || uq3.k.a().e("qqcircle_show_permission_panel_guide_count", 0) != 0) {
            return false;
        }
        return true;
    }

    public final boolean j(@Nullable Activity activity) {
        if (!E(activity)) {
            return false;
        }
        long f16 = uq3.k.a().f("qqcircle_last_show_rec_panel_guide_timestamp", 0L);
        if (uq3.k.a().e("qqcircle_show_rec_panel_guide_count", 0) >= z.f83900a.r().getTotalCount() || System.currentTimeMillis() - f16 <= r3.getInterval() * 1000) {
            return false;
        }
        return true;
    }

    public final boolean k() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_cmt_recom_pic", false);
    }

    public final boolean l() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_feed_recom_pic", false);
    }

    public final boolean m() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_feed_recom_guide", false);
    }

    public final boolean n() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_input_recom_pic", false);
    }

    public final boolean o() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_input_keyword_prompt", false);
    }

    public final boolean q() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_input_origin_prompt", false);
    }

    public final boolean r() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_panel_recom_guide", false);
    }

    public final boolean t() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_recom_pic_function", false);
    }

    public final boolean u() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_screenshot_recom_pic", false);
    }

    public final boolean v() {
        if (entranceTxtExposeCount > A()) {
            return true;
        }
        return false;
    }

    public final boolean w() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_input_emoticon_prompt", true);
    }

    public final boolean x() {
        return Intrinsics.areEqual(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_feed_desc_config", "1"), "1");
    }

    public final boolean y() {
        return Intrinsics.areEqual(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_feed_desc_config", "0"), "2");
    }

    public final boolean z(@Nullable FeedCloudMeta$StFeed feed) {
        if (!com.tencent.biz.qqcircle.comment.af.p(feed)) {
            return false;
        }
        return H();
    }
}
