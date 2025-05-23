package com.qzone.reborn.util;

import android.app.Activity;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy;
import kotlin.Metadata;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/util/k;", "", "", "g", "a", "c", "f", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "d", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f59549a = new k();

    k() {
    }

    public final boolean a() {
        return SimpleUIUtil.isNowElderMode();
    }

    public final boolean b() {
        try {
            return com.tencent.biz.qui.quicommon.a.b(ContextCompat.getColor(BaseApplication.context, R.color.qui_common_bg_bottom_standard));
        } catch (Exception e16) {
            QLog.e("QZoneModeUtils", 1, e16, new Object[0]);
            return false;
        }
    }

    public final boolean c() {
        boolean needShowQzoneFrame = QZoneApiProxy.needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
        RFWLog.d("QZoneModeUtils", RFWLog.USR, "isFriendFeedTabMode: " + needShowQzoneFrame);
        return needShowQzoneFrame;
    }

    public final boolean d(Activity activity) {
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT >= 24 && activity != null) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(Activity activity) {
        boolean isInPictureInPictureMode;
        if (Build.VERSION.SDK_INT >= 26 && activity != null) {
            isInPictureInPictureMode = activity.isInPictureInPictureMode();
            if (isInPictureInPictureMode) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        if (QQTheme.isVasTheme()) {
            return QQTheme.isNowThemeIsNight();
        }
        return QQTheme.isNowThemeIsNight() || b();
    }

    public final boolean g() {
        return StudyModeManager.t();
    }
}
