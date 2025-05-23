package com.tencent.mobileqq.activity.qcircle.bubble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\f\u0010\u0011\u001a\u00020\u0002*\u00020\u0010H\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\bH\u0002J\f\u0010\u0014\u001a\u00020\u0012*\u00020\bH\u0002J\f\u0010\u0015\u001a\u00020\u0012*\u00020\bH\u0002R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/QCircleTianShuBubbleReporter;", "", "", "isBubbleShowing", "", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "p", "", "usageTime", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "l", "Landroid/content/Intent;", DomainData.DOMAIN_NAME, "", "o", "u", "t", "b", "J", "enterTime", "Landroid/content/BroadcastReceiver;", "c", "Landroid/content/BroadcastReceiver;", "stateChangeReceiver", "d", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "curAppInfo", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QCircleTianShuBubbleReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QCircleTianShuBubbleReporter f184515a = new QCircleTianShuBubbleReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long enterTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static BroadcastReceiver stateChangeReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static BusinessInfoCheckUpdate.AppInfo curAppInfo;

    QCircleTianShuBubbleReporter() {
    }

    @JvmStatic
    public static final void j(final boolean isBubbleShowing) {
        if (!QCircleTianShuBubbleChecker.f184511a.h()) {
            return;
        }
        com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTianShuBubbleReporter$enterQCircle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BusinessInfoCheckUpdate.AppInfo p16;
                BroadcastReceiver broadcastReceiver;
                BroadcastReceiver broadcastReceiver2;
                QLog.i("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "enterQCircle is bubble showing=" + isBubbleShowing);
                QCircleTianShuBubbleReporter.curAppInfo = null;
                if (isBubbleShowing) {
                    p16 = QCircleTianShuBubbleReporter.f184515a.p();
                    QCircleTianShuBubbleReporter.curAppInfo = p16;
                    QCircleTianShuBubbleReporter.enterTime = SystemClock.uptimeMillis();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(GuardManager.ACTION_PLUGIN_STATE_CHANGE);
                    broadcastReceiver = QCircleTianShuBubbleReporter.stateChangeReceiver;
                    if (broadcastReceiver == null) {
                        QCircleTianShuBubbleReporter.stateChangeReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTianShuBubbleReporter$enterQCircle$1.1
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                                boolean n3;
                                Intrinsics.checkNotNullParameter(context, "context");
                                Intrinsics.checkNotNullParameter(intent, "intent");
                                n3 = QCircleTianShuBubbleReporter.f184515a.n(intent);
                                if (n3) {
                                    QCircleTianShuBubbleReporter.k();
                                }
                            }
                        };
                        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                        broadcastReceiver2 = QCircleTianShuBubbleReporter.stateChangeReceiver;
                        application.registerReceiver(broadcastReceiver2, intentFilter);
                    }
                }
            }
        });
    }

    @JvmStatic
    public static final void k() {
        if (!QCircleTianShuBubbleChecker.f184511a.h()) {
            return;
        }
        com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTianShuBubbleReporter$exitQCircle$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BroadcastReceiver broadcastReceiver;
                long j3;
                long j16;
                BroadcastReceiver broadcastReceiver2;
                broadcastReceiver = QCircleTianShuBubbleReporter.stateChangeReceiver;
                if (broadcastReceiver != null) {
                    BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                    broadcastReceiver2 = QCircleTianShuBubbleReporter.stateChangeReceiver;
                    application.unregisterReceiver(broadcastReceiver2);
                    QCircleTianShuBubbleReporter.stateChangeReceiver = null;
                }
                j3 = QCircleTianShuBubbleReporter.enterTime;
                if (j3 > 0) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    j16 = QCircleTianShuBubbleReporter.enterTime;
                    long j17 = uptimeMillis - j16;
                    QLog.i("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "exitQCircle, cost=" + j17);
                    QCircleTianShuBubbleReporter.f184515a.r(j17);
                    QCircleTianShuBubbleReporter.enterTime = 0L;
                }
            }
        });
    }

    private final IRedTouchManager l() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "getAppInfo app is null");
            return null;
        }
        return (IRedTouchManager) runtime.getRuntimeService(IRedTouchManager.class, "");
    }

    private final BusinessInfoCheckUpdate.AppInfo m() {
        IRedTouchManager l3 = l();
        String str = null;
        if (l3 == null) {
            QLog.e("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "getTianShuAppInfo, redTouchManager is null");
            return null;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = l3.getAppInfo(16, "140110");
        if (appInfo != null) {
            str = f184515a.t(appInfo);
        }
        QLog.i("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "get tianShu appInfo = " + str);
        return appInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(Intent intent) {
        if (TextUtils.isEmpty(intent.getAction()) || !Intrinsics.areEqual(GuardManager.ACTION_PLUGIN_STATE_CHANGE, intent.getAction()) || intent.getIntExtra(GuardManager.KEY_PLUGIN_STATE, 0) != 0) {
            return false;
        }
        return true;
    }

    private final String o(BusinessInfoCheckUpdate.AppInfo appInfo) {
        try {
            String optString = new JSONObject(appInfo.buffer.get()).optString("ad_id");
            Intrinsics.checkNotNullExpressionValue(optString, "{\n        JSONObject(buf\u2026.optString(\"ad_id\")\n    }");
            return optString;
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BusinessInfoCheckUpdate.AppInfo p() {
        Boolean bool;
        Boolean bool2;
        BusinessInfoCheckUpdate.AppInfo m3 = m();
        if (m3 != null) {
            bool = Boolean.valueOf(m3.has());
        } else {
            bool = null;
        }
        QLog.i("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "reportBubbleClick has appInfo=" + bool);
        IRedTouchManager l3 = l();
        boolean z16 = false;
        if (m3 != null && m3.has()) {
            z16 = true;
        }
        if (z16 && l3 != null) {
            l3.onRedTouchItemClick(m3, "");
            return m3;
        }
        if (m3 != null) {
            bool2 = Boolean.valueOf(m3.has());
        } else {
            bool2 = null;
        }
        QLog.e("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "reportBubbleClick, appInfo=" + bool2 + ", redTouchManager=" + l3);
        return null;
    }

    @JvmStatic
    public static final void q() {
        Boolean bool;
        if (!QCircleTianShuBubbleChecker.f184511a.h()) {
            return;
        }
        QCircleTianShuBubbleReporter qCircleTianShuBubbleReporter = f184515a;
        BusinessInfoCheckUpdate.AppInfo m3 = qCircleTianShuBubbleReporter.m();
        Boolean bool2 = null;
        if (m3 != null) {
            bool = Boolean.valueOf(m3.has());
        } else {
            bool = null;
        }
        QLog.i("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "reportBubbleExposure has appInfo=" + bool);
        IRedTouchManager l3 = qCircleTianShuBubbleReporter.l();
        boolean z16 = false;
        if (m3 != null && m3.has()) {
            z16 = true;
        }
        if (z16 && l3 != null) {
            l3.onRedTouchItemExposure(m3, "");
            return;
        }
        if (m3 != null) {
            bool2 = Boolean.valueOf(m3.has());
        }
        QLog.e("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "reportBubbleExposure, appInfo=" + bool2 + ", redTouchManager=" + l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(long usageTime) {
        Boolean bool;
        boolean z16;
        BusinessInfoCheckUpdate.AppInfo appInfo = curAppInfo;
        if (appInfo != null) {
            bool = Boolean.valueOf(appInfo.has());
        } else {
            bool = null;
        }
        QLog.i("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "reportUsageTime, usageTime=" + usageTime + ", has appInfo=" + bool);
        if (appInfo != null && appInfo.has()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e("QCircleTabRedPoint-UsageTimeWithBubbleReporter", 1, "reportUsageTime, appInfo= null");
            return;
        }
        final TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mActionId = 133;
        tianShuReportData.mActionValue = (int) usageTime;
        QCircleTianShuBubbleReporter qCircleTianShuBubbleReporter = f184515a;
        tianShuReportData.mItemId = qCircleTianShuBubbleReporter.o(appInfo);
        tianShuReportData.mTraceId = qCircleTianShuBubbleReporter.u(appInfo);
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mOperTime = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = "vab_red";
        tianShuReportData.mPageId = "vab_red";
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.m
            @Override // java.lang.Runnable
            public final void run() {
                QCircleTianShuBubbleReporter.s(TianShuReportData.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(TianShuReportData tianShuReportData) {
        Intrinsics.checkNotNullParameter(tianShuReportData, "$tianShuReportData");
        TianShuManager.getInstance().report(tianShuReportData);
        curAppInfo = null;
    }

    private final String t(BusinessInfoCheckUpdate.AppInfo appInfo) {
        return "iNewFlag=" + appInfo.iNewFlag.get() + ", uiAppId=" + appInfo.uiAppId.get() + ", type=" + appInfo.type.get() + ",path=" + appInfo.path.get() + ", modify_ts=" + appInfo.modify_ts.get() + ", num=" + appInfo.num.get() + ",push_red_ts=" + appInfo.push_red_ts.get() + ", mission_level=" + appInfo.mission_level.get() + ",exposure_max=" + appInfo.exposure_max.get();
    }

    private final String u(BusinessInfoCheckUpdate.AppInfo appInfo) {
        try {
            String optString = new JSONObject(appInfo.buffer.get()).optString("trace_id");
            Intrinsics.checkNotNullExpressionValue(optString, "{\n        JSONObject(buf\u2026tString(\"trace_id\")\n    }");
            return optString;
        } catch (JSONException unused) {
            return "";
        }
    }
}
