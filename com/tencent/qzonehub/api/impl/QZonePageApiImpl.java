package com.tencent.qzonehub.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.homepage.diy.util.QzoneDIYService;
import com.qzone.reborn.base.QZoneShellActivity;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProBlogDetailFragment;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProDetailFragment;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProMoodListFragment;
import com.qzone.reborn.feedpro.fragment.QzoneFeedProUserHomeFragment;
import com.qzone.reborn.feedpro.fragment.QzoneFriendFeedProFragment;
import com.qzone.reborn.feedx.fragment.QZoneBlogDetailFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedXDetailFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedXMoodListFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedxDIYUserHomeFragment;
import com.qzone.reborn.feedx.fragment.QZoneFeedxUserHomeFragment;
import com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment;
import com.qzone.reborn.qzmoment.bean.QZMPublishCaptureBean;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZonePageApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import ho.i;
import jo.h;

/* loaded from: classes34.dex */
public class QZonePageApiImpl implements IQZonePageApi {
    private static final String COOPERATION_QZONE_PAGE_PREFIX = "cooperation.qzone";
    private static final String QZONE_PAGE_PREFIX = "com.qzone";
    private static final String TAG = "QZonePageApiImpl";

    private void checkIntentRedirectForFragment(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("KEY_FRAGMENT_NAME");
        if (stringExtra != null) {
            if (!stringExtra.equals(QZoneHelper.USER_HOME)) {
                if (stringExtra.equals(QZoneHelper.PAGE_MOOD_LIST)) {
                    intent.setClassName(context, QZoneShellActivity.class.getName());
                    if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                        intent.putExtra("public_fragment_class", QzoneFeedProMoodListFragment.class.getName());
                    } else {
                        intent.putExtra("public_fragment_class", QZoneFeedXMoodListFragment.class.getName());
                    }
                    h.f410717a.h("page_launch_mood_list").t("LAUNCH_CLICK");
                    return;
                }
                return;
            }
            intent.setClassName(context, QZoneShellActivity.class.getName());
            if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                intent.putExtra("public_fragment_class", QzoneFeedProUserHomeFragment.class.getName());
            } else {
                intent.putExtra("public_fragment_class", QZoneFeedxUserHomeFragment.class.getName());
            }
            h.f410717a.h("page_launch_user_home").t("LAUNCH_CLICK");
        }
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public void checkExceptionWhetherCauseByFeedx(String str) {
        xe.b.f447841a.b(str);
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public Boolean getCangLanConfig(String str, boolean z16) {
        return Boolean.valueOf(g.f53821a.b().f(str, z16));
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public String getLebaEntranceText() {
        try {
            if (!com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                return QzoneConfig.DefaultValue.DEFAULT_FRIENDFEED_TITLE;
            }
            return g.f53821a.c().v();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return QzoneConfig.DefaultValue.DEFAULT_FRIENDFEED_TITLE;
        }
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public boolean isQZonePage(Context context) {
        return context instanceof BaseActivity;
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public boolean isQzoneFeedProPage() {
        return com.qzone.reborn.feedpro.utils.d.f54318a.b();
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public void jumpQZMomentPublishPage(Bundle bundle) {
        ((jn.b) i.t(jn.b.class)).g(new QZMPublishCaptureBean(bundle.getString(AECameraConstants.AE_MULTI_CAMERA_SMALL_PATH, ""), bundle.getString(AECameraConstants.AE_MULTI_CAMERA_BIG_PATH, "")));
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public void openDebugPage(Context context) {
        ho.h.c(context);
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public void preloadQzoneResource(Intent intent) {
        jm.b.f410600a.k(intent);
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public String getCangLanConfig(String str, String str2) {
        return g.f53821a.b().e(str, str2);
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public boolean isQZonePage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("com.qzone") || str.startsWith(COOPERATION_QZONE_PAGE_PREFIX);
    }

    @Override // com.tencent.qzonehub.api.IQZonePageApi
    public Intent checkIntentRedirect(Context context, String str, Intent intent) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -755325895:
                    if (str.equals(QZoneHelper.DETAIL)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -727229201:
                    if (str.equals(QZoneHelper.USER_HOME)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -63037391:
                    if (str.equals(QZoneHelper.FRIEND_FEED)) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    intent.setClassName(context, QZoneShellActivity.class.getName());
                    if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                        if (ho.h.a(intent.getExtras())) {
                            intent.putExtra("public_fragment_class", QzoneFeedProBlogDetailFragment.class.getName());
                        } else {
                            intent.putExtra("public_fragment_class", QzoneFeedProDetailFragment.class.getName());
                        }
                    } else if (ho.h.a(intent.getExtras())) {
                        intent.putExtra("public_fragment_class", QZoneBlogDetailFragment.class.getName());
                    } else {
                        intent.putExtra("public_fragment_class", QZoneFeedXDetailFragment.class.getName());
                    }
                    h.f410717a.h("page_launch_feed_detail").t("LAUNCH_CLICK");
                    break;
                case 1:
                    long longExtra = intent.getLongExtra("qqid", 0L);
                    intent.setClassName(context, QZoneShellActivity.class.getName());
                    if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                        intent.putExtra("public_fragment_class", QzoneFeedProUserHomeFragment.class.getName());
                    } else if (QzoneDIYService.L().G(longExtra)) {
                        intent.putExtra("public_fragment_class", QZoneFeedxDIYUserHomeFragment.class.getName());
                    } else {
                        intent.putExtra("public_fragment_class", QZoneFeedxUserHomeFragment.class.getName());
                    }
                    h.f410717a.h("page_launch_user_home").t("LAUNCH_CLICK");
                    break;
                case 2:
                    if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                        intent.setClassName(context, QZoneHelper.FRIEND_FEED_PRO);
                        intent.putExtra("public_fragment_class", QzoneFriendFeedProFragment.class.getName());
                    } else {
                        intent.setClassName(context, QZoneHelper.FRIEND_FEEDX);
                        intent.putExtra("public_fragment_class", QZoneFriendFeedXFragment.class.getName());
                    }
                    h.f410717a.h("page_launch_friend_feed").t("LAUNCH_CLICK");
                    break;
                default:
                    checkIntentRedirectForFragment(context, intent);
                    break;
            }
        }
        return intent;
    }
}
