package com.qzone.reborn.albumx.qzone.local;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.runtime.QZoneRuntime;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/QZoneForegroundForSubProcess;", "", "Landroid/content/Context;", "context", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "j", "Landroid/content/Intent;", "dataIntent", DomainData.DOMAIN_NAME, tl.h.F, "o", ReportConstant.COSTREPORT_PREFIX, "onQzonePage", "l", "b", "Z", "mIsQzoneProcessForeground", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "isOnQzoneScreen", "<init>", "()V", "MainProgressPageStatusReceiver", "SubProgressPageStatusReceiver", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneForegroundForSubProcess {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsQzoneProcessForeground;

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneForegroundForSubProcess f52639a = new QZoneForegroundForSubProcess();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<Boolean> isOnQzoneScreen = new MutableLiveData<>(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/QZoneForegroundForSubProcess$MainProgressPageStatusReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class MainProgressPageStatusReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "MainProgressPageStatusReceiver[onReceive]");
            QZoneForegroundForSubProcess.f52639a.l(QZoneRuntime.j().m());
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/QZoneForegroundForSubProcess$SubProgressPageStatusReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class SubProgressPageStatusReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QZoneForegroundForSubProcess qZoneForegroundForSubProcess = QZoneForegroundForSubProcess.f52639a;
            if (qZoneForegroundForSubProcess.j()) {
                qZoneForegroundForSubProcess.n(intent);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/qzone/reborn/albumx/qzone/local/QZoneForegroundForSubProcess$a", "Lmqq/app/QActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements QActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[doInitOnQzoneProgress] onProcessBackground");
            QZoneForegroundForSubProcess.mIsQzoneProcessForeground = false;
            QZoneForegroundForSubProcess qZoneForegroundForSubProcess = QZoneForegroundForSubProcess.f52639a;
            if (qZoneForegroundForSubProcess.j()) {
                qZoneForegroundForSubProcess.s();
            } else {
                qZoneForegroundForSubProcess.k().postValue(Boolean.FALSE);
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[doInitOnQzoneProgress] onProcessForeground");
            QZoneForegroundForSubProcess.mIsQzoneProcessForeground = true;
            QZoneForegroundForSubProcess.f52639a.k().postValue(Boolean.TRUE);
        }
    }

    QZoneForegroundForSubProcess() {
    }

    private final void i(Context context) {
        boolean isCurrentProcessForeground = Foreground.isCurrentProcessForeground();
        mIsQzoneProcessForeground = isCurrentProcessForeground;
        if (isCurrentProcessForeground) {
            isOnQzoneScreen.postValue(Boolean.TRUE);
        }
        RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[doInitOnQzoneProgress] mIsQzoneProcessForeground:" + mIsQzoneProcessForeground);
        Foreground.addActivityLifeCallback(new a());
        q(context);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_QZONE_FOREGROUND_ENABLE_CHECK_MAIN_PROCESS_PAGE, 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(boolean z16) {
        RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[notifyQZonePageStatus] " + z16);
        try {
            Intent intent = new Intent("REFRESH_PAGE_STATUS_ACTION");
            intent.putExtra("KEY_ON_SCREEN", z16);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
        } catch (Exception e16) {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[notifyQZonePageStatus] error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Intent dataIntent) {
        boolean booleanExtra;
        if (mIsQzoneProcessForeground) {
            booleanExtra = true;
        } else {
            booleanExtra = dataIntent != null ? dataIntent.getBooleanExtra("KEY_ON_SCREEN", false) : false;
        }
        isOnQzoneScreen.postValue(Boolean.valueOf(booleanExtra));
        RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[refreshQzonePageStatus] " + booleanExtra + ",dataIntent:" + dataIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        try {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[registerMainProgressDispatch]");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("REQUEST_REFRESH_PAGE_STATUS_ACTION");
            context.registerReceiver(new MainProgressPageStatusReceiver(), intentFilter);
        } catch (Exception e16) {
            RFWLog.e("MediaRecommend_QZoneForeground", RFWLog.USR, "[registerMainProgressDispatch] error:" + e16);
        }
    }

    private final void q(final Context context) {
        if (!j()) {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[registerMainProgressListener] enableCheckMainProgress return false");
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.c
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneForegroundForSubProcess.r(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[registerMainProgressListener]");
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("REFRESH_PAGE_STATUS_ACTION");
            context.registerReceiver(new SubProgressPageStatusReceiver(), intentFilter);
        } catch (Exception e16) {
            RFWLog.e("MediaRecommend_QZoneForeground", RFWLog.USR, "[registerMainProgressListener] error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[requestMainProcessStatusRefresh]");
        try {
            MobileQQ.sMobileQQ.sendBroadcast(new Intent("REQUEST_REFRESH_PAGE_STATUS_ACTION"));
        } catch (Exception e16) {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[requestMainProcessStatusRefresh] error:" + e16);
        }
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, BaseApplication.processName)) {
            return;
        }
        i(context);
    }

    public final MutableLiveData<Boolean> k() {
        return isOnQzoneScreen;
    }

    public final void l(final boolean onQzonePage) {
        if (Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, BaseApplication.processName)) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.a
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneForegroundForSubProcess.m(onQzonePage);
                }
            });
        }
    }

    public final void o(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!j()) {
            RFWLog.d("MediaRecommend_QZoneForeground", RFWLog.USR, "[registerMainProgressDispatch] enableCheckMainProgress return false");
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.b
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneForegroundForSubProcess.p(context);
                }
            });
        }
    }

    public final void s() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.d
            @Override // java.lang.Runnable
            public final void run() {
                QZoneForegroundForSubProcess.t();
            }
        });
    }
}
