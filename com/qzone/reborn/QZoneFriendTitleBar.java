package com.qzone.reborn;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.common.activities.titlebuilder.QzoneBaseTitle;
import com.qzone.feed.utils.g;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFriendTitleBar extends QzoneBaseTitle {

    /* renamed from: a0, reason: collision with root package name */
    protected ImageView f52157a0;

    public View G() {
        return this.f52157a0;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static class ZPlanSettingGuideBubbleRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneFriendTitleBar> f52158d;

        @Override // java.lang.Runnable
        public void run() {
            View G;
            WeakReference<QZoneFriendTitleBar> weakReference = this.f52158d;
            QZoneFriendTitleBar qZoneFriendTitleBar = weakReference == null ? null : weakReference.get();
            if (qZoneFriendTitleBar == null || (G = qZoneFriendTitleBar.G()) == null || G.getVisibility() != 0) {
                return;
            }
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "GuideBubbleZPlanSetting", "\u5c06\u8d85\u7ea7QQ\u79c0\u5f62\u8c61\u8bbe\u4e3a\u5c01\u9762");
            long config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ZPLAN_SETTING_GUIDE_STAY_TIME, 15000L);
            if (TextUtils.isEmpty(config)) {
                return;
            }
            if (!QQTheme.isNowThemeIsNightForQzone() && !"2920".equals(QQTheme.getCurrentThemeId())) {
                QzoneGuideBubbleHelper.g().o(qZoneFriendTitleBar.f(), G, config, 1, 14.0f, 5.0d, 10.0d, config2, -1728053248, false, true, 0, null, 0, true, 1.0f, null, false, -1, false);
            } else {
                QzoneGuideBubbleHelper.g().o(qZoneFriendTitleBar.f(), G, config, 1, 14.0f, 5.0d, 10.0d, config2, -1, false, true, 0, null, 0, true, 1.0f, null, false, -16777216, false);
            }
            g.b("friend_feed_zplan_setting_icon_bubble_guide");
        }
    }
}
