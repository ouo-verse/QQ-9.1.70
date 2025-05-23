package com.tencent.mobileqq.data.dt;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.dt.QQDtConfigHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AppSetting;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.vip.ad.i;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 F2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aH\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\u001a\u0010 \u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010&\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\"\u0010.\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010)R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010?R\u0011\u0010C\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/data/dt/QQDtConfigHelper;", "Lcom/tencent/richframework/lifecycle/IProcessStateChangeCallback;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "", "reportData", DomainData.DOMAIN_NAME, "Landroid/content/Intent;", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "t", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "onProcessBackground", "onProcessForeground", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "r", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "d", "Z", "getHasAppForeground", "()Z", "setHasAppForeground", "(Z)V", "hasAppForeground", "", "Lkotlin/Function1;", "e", "[Lkotlin/jvm/functions/Function1;", "startTypePushCheckFunc", "f", "[Ljava/lang/String;", "runPushKey", h.F, "needUpdate", "i", "Ljava/lang/String;", "lastLoginTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tianshuId", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "reportRunnable", "p", "()Ljava/lang/String;", "callFromType", "<init>", "()V", "D", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QQDtConfigHelper implements IProcessStateChangeCallback, SimpleEventReceiver<SimpleBaseEvent>, Application.ActivityLifecycleCallbacks {
    private static int E;

    @Nullable
    private static ry2.a G;

    @NotNull
    private static final Lazy<Handler> H;

    @NotNull
    private static final Lazy<MMKVOptionEntityV2> I;

    @NotNull
    private static final Lazy<Long> J;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Runnable reportRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasAppForeground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Intent, Boolean>[] startTypePushCheckFunc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] runPushKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lastLoginTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String tianshuId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String F = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001eR\u0014\u0010$\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001eR\u0014\u0010&\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0014\u0010'\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u0014\u0010)\u001a\u00020(8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020(8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010\u001eR\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/data/dt/QQDtConfigHelper$a;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", DomainData.DOMAIN_NAME, "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "handle$delegate", "Lkotlin/Lazy;", "g", "()Landroid/os/Handler;", "handle", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkvEntity$delegate", "j", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkvEntity", "", "reportIntervalTime$delegate", "k", "()J", "reportIntervalTime", "", "i", "()Ljava/lang/String;", "lastBadgeUnreadCount", "lastBadgeComposedString", "Ljava/lang/String;", h.F, "p", "(Ljava/lang/String;)V", "DT_CONFIG_INTENT_TAG", "KEY_ATTA_ID", "KEY_NEED_UPDATE", "KEY_START_TYPE", "KEY_TIANSHU_ID", "MMKV_KEY_LAST_LOGIN_TIME", "", "START_TYPE_ICON", "I", "START_TYPE_PUSH", "START_TYPE_SCHEAME", "TAG", "Lry2/a;", "lastBadgeData", "Lry2/a;", "startType", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.data.dt.QQDtConfigHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Handler g() {
            return (Handler) QQDtConfigHelper.H.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MMKVOptionEntityV2 j() {
            return (MMKVOptionEntityV2) QQDtConfigHelper.I.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long k() {
            return ((Number) QQDtConfigHelper.J.getValue()).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean m() {
            if (MobileQQ.sProcessId == 1) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o() {
            QQAppInterface b16;
            boolean z16;
            Companion companion = QQDtConfigHelper.INSTANCE;
            if (companion.k() <= 0 || (b16 = i.b()) == null) {
                return;
            }
            String account = b16.getAccount();
            if (account != null && account.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && com.tencent.mobileqq.notification.modularize.e.d(b16) && companion.q()) {
                HashMap hashMap = new HashMap();
                String account2 = b16.getAccount();
                Intrinsics.checkNotNullExpressionValue(account2, "app.account");
                hashMap.put("uin", account2);
                hashMap.put("platform", "Android");
                hashMap.put("version", AppSetting.getVersion());
                hashMap.put("red_pot", companion.i());
                hashMap.put("message_box", companion.h());
                hashMap.put("attaid", "01e00079448");
                hashMap.put("token", "01e00079448");
                i.o(hashMap);
                return;
            }
            QLog.d("QQDtConfigHelper", 4, "no need report");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean q() {
            ry2.a e16 = BadgeUtils.e();
            if (e16 == null || Intrinsics.areEqual(e16, QQDtConfigHelper.G)) {
                return false;
            }
            p(e16.toString());
            QQDtConfigHelper.G = e16;
            return true;
        }

        @NotNull
        public final String h() {
            return QQDtConfigHelper.F;
        }

        @NotNull
        public final String i() {
            Integer num;
            if (QQDtConfigHelper.G != null) {
                ry2.a aVar = QQDtConfigHelper.G;
                if (aVar != null) {
                    num = Integer.valueOf(aVar.getTotalCount());
                } else {
                    num = null;
                }
                return String.valueOf(num);
            }
            return "0";
        }

        public final boolean l() {
            if (QQDtConfigHelper.E == 0) {
                return true;
            }
            return false;
        }

        public final void n() {
            g().post(new Runnable() { // from class: com.tencent.mobileqq.data.dt.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQDtConfigHelper.Companion.o();
                }
            });
        }

        public final void p(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            QQDtConfigHelper.F = str;
        }

        Companion() {
        }
    }

    static {
        Lazy<Handler> lazy;
        Lazy<MMKVOptionEntityV2> lazy2;
        Lazy<Long> lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.data.dt.QQDtConfigHelper$Companion$handle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return RFWThreadManager.getInstance().getSerialThreadHandler();
            }
        });
        H = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntityV2>() { // from class: com.tencent.mobileqq.data.dt.QQDtConfigHelper$Companion$mmkvEntity$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKVOptionEntityV2 invoke() {
                return i.g();
            }
        });
        I = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.data.dt.QQDtConfigHelper$Companion$reportIntervalTime$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(RFWConfig.getConfigValue("tianshu_report_app_badge_count_interval_time", 600000L));
            }
        });
        J = lazy3;
    }

    public QQDtConfigHelper() {
        Function1<Intent, Boolean> function1;
        Function1<Intent, Boolean> function12;
        Function1<Intent, Boolean> function13;
        AppRuntime appRuntime;
        Companion companion = INSTANCE;
        this.hasAppForeground = companion.m();
        function1 = QQDtConfigHelperKt.f203138a;
        function12 = QQDtConfigHelperKt.f203139b;
        function13 = QQDtConfigHelperKt.f203140c;
        this.startTypePushCheckFunc = new Function1[]{function1, function12, function13};
        this.runPushKey = new String[]{"trigger_info", "push_trigger_info", "KEY_PUSH_TRIGGER_INFO"};
        this.lastLoginTime = "";
        this.reportRunnable = new Runnable() { // from class: com.tencent.mobileqq.data.dt.QQDtConfigHelper$reportRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                QQDtConfigHelper.Companion companion2 = QQDtConfigHelper.INSTANCE;
                companion2.n();
                QQAppInterface b16 = i.b();
                if (b16 != null && companion2.k() > 0 && com.tencent.mobileqq.notification.modularize.e.d(b16)) {
                    companion2.g().postDelayed(this, companion2.k());
                }
            }
        };
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            appRuntime = application.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null) {
            String decodeString = companion.j().decodeString("mmkv_key_dt_config_last_login_time_" + appRuntime.getLongAccountUin(), "");
            Intrinsics.checkNotNullExpressionValue(decodeString, "mmkvEntity.decodeString(\u2026ntime.longAccountUin, \"\")");
            this.lastLoginTime = decodeString;
        }
        RFWLifecycleHelper.getInstance().registerProcessChangeListener(this);
        RFWLifecycleHelper.getInstance().registerActivityLifecycleCallback(this);
        boolean z16 = companion.m() || companion.j().decodeBool("need_update", false);
        this.needUpdate = z16;
        if (!z16) {
            C();
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        new Runnable() { // from class: com.tencent.mobileqq.data.dt.d
            @Override // java.lang.Runnable
            public final void run() {
                QQDtConfigHelper.B();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B() {
        INSTANCE.j().encodeBool("need_update", true);
    }

    private final void C() {
        Companion companion = INSTANCE;
        E = companion.j().decodeInt("start_type", E);
        this.tianshuId = companion.j().decodeString("tianshu_id", this.tianshuId);
        this.needUpdate = companion.j().decodeBool("need_update", this.needUpdate);
        QLog.d("QQDtConfigHelper", 1, "updateFromMMKV startType:" + E + ", tianshuId:" + this.tianshuId);
    }

    private final String n(String reportData) {
        List<String> emptyList;
        boolean contains$default;
        boolean z16;
        String str = "";
        if (TextUtils.isEmpty(reportData)) {
            return "";
        }
        QLog.d("QQDtConfigHelper", 1, "getAdIdFromThirdPush");
        try {
            String optString = new JSONObject(reportData).optString("trigger_info");
            if (!TextUtils.isEmpty(optString)) {
                String oacTrigger = new JSONObject(optString).optString("oac_triggle");
                Intrinsics.checkNotNullExpressionValue(oacTrigger, "oacTrigger");
                List<String> split = new Regex(ContainerUtils.FIELD_DELIMITER).split(oacTrigger, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                for (String str2 : emptyList) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "ad_id=", false, 2, (Object) null);
                    if (contains$default) {
                        str = StringsKt__StringsJVMKt.replace$default(str2, "ad_id=", "", false, 4, (Object) null);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("QQDtConfigHelper", 1, "getAdIdFromThirdPush: exception.", e16);
        }
        return str;
    }

    public static /* synthetic */ int u(QQDtConfigHelper qQDtConfigHelper, Activity activity, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            activity = null;
        }
        return qQDtConfigHelper.t(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v() {
        new Runnable() { // from class: com.tencent.mobileqq.data.dt.e
            @Override // java.lang.Runnable
            public final void run() {
                QQDtConfigHelper.w();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w() {
        INSTANCE.j().encodeBool("need_update", false);
    }

    private final boolean y(Intent intent) {
        if (intent == null) {
            return false;
        }
        for (String str : this.runPushKey) {
            if (intent.hasExtra(str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean z(Intent intent) {
        for (Function1<Intent, Boolean> function1 : this.startTypePushCheckFunc) {
            if (function1.invoke(intent).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(UpdateDtConfigEvent.class);
        return arrayList;
    }

    public final int o() {
        AppRuntime appRuntime;
        Calendar calendar = Calendar.getInstance();
        String str = calendar.get(1) + "-" + calendar.get(2) + "-" + calendar.get(5);
        if (Intrinsics.areEqual(str, this.lastLoginTime)) {
            return 0;
        }
        this.lastLoginTime = str;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            appRuntime = application.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null) {
            INSTANCE.j().encodeString("mmkv_key_dt_config_last_login_time_" + appRuntime.getLongAccountUin(), this.lastLoginTime);
        }
        return 1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.needUpdate && INSTANCE.m()) {
            t(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessBackground() {
        this.needUpdate = true;
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.data.dt.b
            @Override // java.lang.Runnable
            public final void run() {
                QQDtConfigHelper.A();
            }
        });
        Companion companion = INSTANCE;
        this.hasAppForeground = companion.m();
        if (companion.k() > 0) {
            companion.g().postDelayed(this.reportRunnable, companion.k());
        }
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessForeground() {
        INSTANCE.g().removeCallbacks(this.reportRunnable);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if ((event instanceof UpdateDtConfigEvent) && ((UpdateDtConfigEvent) event).getProcessId() != MobileQQ.sProcessId) {
            C();
            this.hasAppForeground = INSTANCE.m();
        }
    }

    @NotNull
    public final String p() {
        if (TextUtils.isEmpty(this.tianshuId)) {
            return "0";
        }
        return "1";
    }

    @NotNull
    public final String q() {
        Intent intent = null;
        int u16 = u(this, null, 1, null);
        if (u16 != 0) {
            if (u16 != 1) {
                return "0";
            }
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                intent = topActivity.getIntent();
            }
            if (y(intent)) {
                return "0";
            }
            return "1";
        }
        return INSTANCE.i();
    }

    @NotNull
    public final String r() {
        String str;
        if (INSTANCE.m() && this.hasAppForeground) {
            str = "1";
        } else {
            str = "0";
        }
        this.hasAppForeground = false;
        return str;
    }

    @JvmOverloads
    public final int s() {
        return u(this, null, 1, null);
    }

    @JvmOverloads
    public final int t(@Nullable Activity activity) {
        Intent intent;
        Function1 function1;
        Function1 function12;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("QQDtConfigHelper", 2, "getStartType needUpdate = " + this.needUpdate + ", startType = " + E + ", tianshuId = " + this.tianshuId + ", redCompose:" + F);
        }
        if (!this.needUpdate) {
            return E;
        }
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        String str2 = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return E;
        }
        this.needUpdate = false;
        Companion companion = INSTANCE;
        companion.q();
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.data.dt.c
            @Override // java.lang.Runnable
            public final void run() {
                QQDtConfigHelper.v();
            }
        });
        E = 0;
        String str3 = "";
        this.tianshuId = "";
        if (intent.hasExtra("has_checked_by_dt_config")) {
            return E;
        }
        intent.putExtra("has_checked_by_dt_config", true);
        if (z(intent)) {
            E = 1;
            function1 = QQDtConfigHelperKt.f203140c;
            if (!((Boolean) function1.invoke(intent)).booleanValue()) {
                function12 = QQDtConfigHelperKt.f203139b;
                if (!((Boolean) function12.invoke(intent)).booleanValue() || !intent.hasExtra("report_data")) {
                    str = "";
                } else {
                    str = n(intent.getStringExtra("report_data"));
                }
            } else {
                str = String.valueOf(intent.getIntExtra("KEY_PUSH_ID", 0));
            }
            if (!TextUtils.isEmpty(str)) {
                str3 = "{\"item_id\":\"" + str + "\"}";
            }
            this.tianshuId = str3;
        } else if (!TextUtils.isEmpty(intent.getDataString())) {
            E = 2;
            String dataString = intent.getDataString();
            if (dataString != null) {
                str2 = StringsKt__StringsKt.substringBefore$default(dataString, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, (String) null, 2, (Object) null);
            }
            this.tianshuId = str2;
        }
        companion.j().encodeInt("start_type", E);
        companion.j().encodeString("tianshu_id", this.tianshuId);
        QLog.d("QQDtConfigHelper", 1, "getStartType:" + E + ", redCompose:" + F + ", tianshuId:" + this.tianshuId);
        SimpleEventBus.getInstance().dispatchEvent(new UpdateDtConfigEvent(MobileQQ.sProcessId), true);
        return E;
    }

    @NotNull
    public final String x() {
        String str = this.tianshuId;
        if (str == null) {
            return "";
        }
        return str;
    }
}
