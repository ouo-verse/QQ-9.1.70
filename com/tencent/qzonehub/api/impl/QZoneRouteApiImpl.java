package com.tencent.qzonehub.api.impl;

import NS_MOBILE_FEEDS.single_feed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.aio.QZoneAIOUserFeedxFragment;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.base.QZoneShellActivity;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.util.m;
import com.qzone.reborn.message.fragment.QZonePassiveMessageTabFragment;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.qzone.reborn.util.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u001c\u0010 \u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0016J*\u0010%\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016J&\u0010'\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010(\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\u0012\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J0\u0010/\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016J\f\u00101\u001a\u0006\u0012\u0002\b\u000300H\u0016\u00a8\u00066"}, d2 = {"Lcom/tencent/qzonehub/api/impl/QZoneRouteApiImpl;", "Lcom/tencent/qzonehub/api/IQZoneRouteApi;", "", "isOpenGroupAlbumSafeSwitch", "isOpenNativeDebugSwitch", "isAIOForwardSafeSwitch", "Landroid/content/Context;", "context", "", "cmp", "Landroid/content/Intent;", "intent", "uin", "", "launchQZonePage", "getPassiveIntent", "", "Landroidx/fragment/app/Fragment;", "getQZoneAIOUserHomeFragment", ZPlanPublishSource.FROM_SCHEME, "launchQZoneScheme", "appName", "isGroupAlbumEntry", "isNewAIOGroupAlbumEnable", "isNativeGroupAlbumExpOpen", "isAIOLongPressExptOn", "isChatRecordExpOn", "isAIOPanelShareSwitch", "actionUrl", "getQZoneDetailIntent", "Landroid/os/Bundle;", "bundle", "launchDetailPage", "getQZoneUserHomeIntent", "isFamousUser", "", "loginFrom", "launchUserHome", "bizData", "launchFeedDetailWithData", "launchPublishMoodPage", "isMediaPickFirstExpOn", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "launchMediaPickToPublishMood", "isOpenQZAlbumx", "from", "launchQZAlbumxMainPage", "Ljava/lang/Class;", "getQZonePublishMoodActivityClass", "<init>", "()V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QZoneRouteApiImpl implements IQZoneRouteApi {
    private static final String GROUP_ALBUM_CANG_LAN_SAFE_SWITCH = "group_album_cang_lan_safe_switch";
    private static final String GROUP_ALBUM_NAME = "\u76f8\u518c";
    private static final String TAG = "QZoneRouteApiImpl";

    private final boolean isAIOForwardSafeSwitch() {
        return g.f53821a.d().l();
    }

    private final boolean isOpenGroupAlbumSafeSwitch() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(GROUP_ALBUM_CANG_LAN_SAFE_SWITCH, true);
    }

    private final boolean isOpenNativeDebugSwitch() {
        return gd.a.f401926a.c("KEY_OPEN_NEW_AIO_GROUP_ALBUM_ENTRANCE", false);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public Intent getPassiveIntent() {
        Intent intent = new Intent();
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZoneShellActivity.class.getName());
        intent.putExtra("public_fragment_class", QZonePassiveMessageTabFragment.class.getName());
        return intent;
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public Fragment getQZoneAIOUserHomeFragment(long uin) {
        QZoneAIOUserFeedxFragment qZoneAIOUserFeedxFragment = new QZoneAIOUserFeedxFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("uin", uin);
        qZoneAIOUserFeedxFragment.setArguments(bundle);
        return qZoneAIOUserFeedxFragment;
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public Intent getQZoneDetailIntent(Context context, String actionUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionUrl, "actionUrl");
        return i.e().a(context, actionUrl);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public Class<?> getQZonePublishMoodActivityClass() {
        return lc.b.b();
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public Intent getQZoneUserHomeIntent(Context context, String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intent c16 = i.z().c(context, uin);
        Intrinsics.checkNotNullExpressionValue(c16, "userHome().getQZoneUserH\u2026otification(context, uin)");
        return c16;
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isAIOLongPressExptOn() {
        boolean e16 = com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qzone_groupalbum_reprint_longpress_new", null, 2, null);
        boolean isOpenGroupAlbumSafeSwitch = isOpenGroupAlbumSafeSwitch();
        boolean isAIOForwardSafeSwitch = isAIOForwardSafeSwitch();
        boolean isOpenNativeDebugSwitch = isOpenNativeDebugSwitch();
        com.tencent.xaction.log.b.a(TAG, 1, "isAIOLongPressExptOn, tabAIOLongPressSwitch:" + e16 + ", safeSwitch:" + isOpenGroupAlbumSafeSwitch + ", debugSwitch:" + isOpenNativeDebugSwitch);
        return (e16 && isOpenGroupAlbumSafeSwitch && isAIOForwardSafeSwitch) || isOpenNativeDebugSwitch;
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isAIOPanelShareSwitch() {
        return isAIOForwardSafeSwitch() || isOpenNativeDebugSwitch();
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isChatRecordExpOn() {
        boolean e16 = com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qzone_groupalbum_reprint_chatrecords_new", null, 2, null);
        boolean isOpenGroupAlbumSafeSwitch = isOpenGroupAlbumSafeSwitch();
        boolean isAIOForwardSafeSwitch = isAIOForwardSafeSwitch();
        boolean isOpenNativeDebugSwitch = isOpenNativeDebugSwitch();
        com.tencent.xaction.log.b.a(TAG, 1, "isChatRecordExpOn, tabAIOChatRecordSwitch:" + e16 + ", safeSwitch:" + isOpenGroupAlbumSafeSwitch + ", debugSwitch:" + isOpenNativeDebugSwitch);
        return (e16 && isOpenGroupAlbumSafeSwitch && isAIOForwardSafeSwitch) || isOpenNativeDebugSwitch;
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isGroupAlbumEntry(String appName) {
        return Intrinsics.areEqual("\u76f8\u518c", appName);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isMediaPickFirstExpOn() {
        return com.qzone.reborn.a.f52169a.d("exp_qzone_publishlink_shuoshuojumptopicker", "_B");
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isNativeGroupAlbumExpOpen() {
        boolean isOpenGroupAlbumSafeSwitch = isOpenGroupAlbumSafeSwitch();
        boolean isOpenNativeDebugSwitch = isOpenNativeDebugSwitch();
        com.tencent.xaction.log.b.a(TAG, 1, "isNativeGroupAlbumExpOpen, safeSwitch:" + isOpenGroupAlbumSafeSwitch + ", debugSwitch:" + isOpenNativeDebugSwitch);
        return isOpenGroupAlbumSafeSwitch || isOpenNativeDebugSwitch;
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isNewAIOGroupAlbumEnable() {
        return isNativeGroupAlbumExpOpen();
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean isOpenQZAlbumx() {
        return com.qzone.reborn.albumx.qzonex.utils.d.a();
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public void launchDetailPage(Context context, Bundle bundle) {
        i.e().g(context, bundle);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public void launchFeedDetailWithData(Context context, String scheme, String bizData) {
        com.tencent.xaction.log.b.a(TAG, 1, "launchFeedDetailWithData: " + scheme);
        if (context != null) {
            if (scheme == null || scheme.length() == 0) {
                return;
            }
            if (!(bizData == null || bizData.length() == 0) && g.f53821a.b().B()) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    m.b("extra_key_parcelable_feed_for_detail", BusinessFeedData.createFrom((single_feed) t5.b.b(single_feed.class, com.qzone.proxy.feedcomponent.manager.a.a(bizData)), 4097));
                    com.tencent.xaction.log.b.a(TAG, 1, "launchFeedDetailWithData finish: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                } catch (Throwable th5) {
                    xe.b.f447841a.d(th5);
                }
                i.q(context, scheme);
                return;
            }
            com.tencent.xaction.log.b.a(TAG, 1, "just launch scheme");
            i.q(context, scheme);
        }
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public boolean launchMediaPickToPublishMood(Activity activity) {
        return l.f59550a.T(activity, null);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public void launchQZAlbumxMainPage(Context context, String uin, Bundle bundle, String from) {
        com.tencent.xaction.log.b.a(TAG, 1, "launchQZAlbumxMainPage uin=" + uin + ", context=" + context);
        if (TextUtils.isEmpty(uin)) {
            return;
        }
        Intrinsics.checkNotNull(uin);
        QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = new QZAlbumxMainPageInitBean(uin);
        qZAlbumxMainPageInitBean.setFrom(from);
        i.x().i(context, qZAlbumxMainPageInitBean, bundle);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public void launchQZonePage(Context context, String cmp, Intent intent, String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cmp, "cmp");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (Intrinsics.areEqual(cmp, QZoneHelper.FRIEND_FEED) && pl.a.f426446a.A()) {
            i.j().a(context, intent);
            return;
        }
        QzonePluginProxyActivity.setActivityNameToIntent(intent, cmp);
        intent.addFlags(536870912);
        QzonePluginProxyActivity.launchPluingActivityForResult(context, uin, intent, -1);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public void launchQZoneScheme(Context context, String scheme) {
        i.q(context, scheme);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public void launchUserHome(Context context, long uin, boolean isFamousUser, int loginFrom) {
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean(0L, null, null, null, false, null, null, 0, null, false, false, 0, 4095, null);
        qZoneUserHomeBean.setUin(uin);
        qZoneUserHomeBean.setFamousSpace(isFamousUser);
        qZoneUserHomeBean.setLoginFrom(loginFrom);
        i.z().t(context, qZoneUserHomeBean);
    }

    @Override // com.tencent.qzonehub.api.IQZoneRouteApi
    public void launchPublishMoodPage(Context context) {
        if (context == null) {
            return;
        }
        i.q(context, "mqzone://arouse/writemood");
    }
}
