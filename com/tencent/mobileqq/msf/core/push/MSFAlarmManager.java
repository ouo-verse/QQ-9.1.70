package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004*+,-B\u0013\b\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b(\u0010)J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u001b\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "id", "", "cancelAlarm", "handleAlarmBroadcast", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "intervalTime", "Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$AlarmCallback;", "callback", "registerAlarm", "registerMethod", "canScheduleExactAlarms", "reportAlarmRegister", "Landroid/app/PendingIntent;", "setAlarmMgr", "lockTime", "tryWakeLock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegister", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "mAlarmAction", "Ljava/lang/String;", "Ljava/util/TreeSet;", "", "", "mAlarmWaitingSet", "Ljava/util/TreeSet;", "Lcom/tencent/mobileqq/msf/core/wakeup/MSFWakeLock;", "wakeLock", "Lcom/tencent/mobileqq/msf/core/wakeup/MSFWakeLock;", "<init>", "(Ljava/lang/String;)V", "AlarmCallback", "Companion", "ComparatorAlarm", "TSetData", "MSFSDK_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.msf.core.push.c, reason: from Kotlin metadata */
/* loaded from: classes15.dex */
public final class MSFAlarmManager extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final c f249601e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final String f249602f = "MSFAlarmManager";

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final String f249603g = "Alarm_ID";

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final String f249604h = "Alarm_PID";

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final String f249605i = "Alarm_WaitTime";

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final String f249606j = "Alarm_RegisterTime";

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final String f249607k = "Alarm_ReceiveTime";

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final String f249608l = "alarm_wait_time";

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final String f249609m = "alarm_id";

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final String f249610n = "register_method";

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final String f249611o = "can_schedule_extra_alarm";

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public static final String f249612p = "is_battery_Optimizations";

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public static final String f249613q = "event_name_alarm_register_monitor";

    /* renamed from: r, reason: collision with root package name */
    public static final int f249614r = 1;

    /* renamed from: s, reason: collision with root package name */
    public static final int f249615s = 2;

    /* renamed from: t, reason: collision with root package name */
    public static final int f249616t = 3;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private static final Lazy<MSFAlarmManager> f249617u;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f249618a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private com.tencent.mobileqq.msf.core.h0.a f249619b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f249620c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final TreeSet<Object[]> f249621d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$AlarmCallback;", "", "onAlarm", "", "intent", "Landroid/content/Intent;", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.msf.core.push.c$a */
    /* loaded from: classes15.dex */
    public interface a {
        void a(@NotNull Intent intent);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager;", "invoke", "()Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.msf.core.push.c$b, reason: from Kotlin metadata and collision with other inner class name */
    /* loaded from: classes15.dex */
    static final class C8094b extends Lambda implements Function0<MSFAlarmManager> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final C8094b f249622a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22961);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f249622a = new C8094b();
            }
        }

        C8094b() {
            super(0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MSFAlarmManager invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MSFAlarmManager) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new MSFAlarmManager(null, 1, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$Companion;", "", "()V", "BEACON_EVENT_NAME_ALARM_REGISTER_MONITOR", "", "EXTRA_KEY_ID", "EXTRA_KEY_PID", "EXTRA_KEY_RECEIVE_TIME", "EXTRA_KEY_REGISTER_TIME", "EXTRA_KEY_WAIT_TIME", "PARAM_KEY_ALARM_ID", "PARAM_KEY_ALARM_WAIT_TIME", "PARAM_KEY_CAN_SCHEDULE_EXTRA_ALARM", "PARAM_KEY_IS_BATTERY_IGNORING_OPTIMIZATIONS", "PARAM_KEY_REGISTER_METHOD", "TAG", "USE_EXACT_AND_ALLOW_WHILE_IDLE", "", "USE_SET_AND_ALLOW_WHILE_IDLE", "USE_SET_METHOD", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager;", "getInstance", "()Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager;", "instance$delegate", "Lkotlin/Lazy;", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.msf.core.push.c$c */
    /* loaded from: classes15.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final MSFAlarmManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MSFAlarmManager) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (MSFAlarmManager) MSFAlarmManager.f249617u.getValue();
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$ComparatorAlarm;", "Ljava/util/Comparator;", "", "", "()V", "compare", "", "lhs", "rhs", "([Ljava/lang/Object;[Ljava/lang/Object;)I", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.msf.core.push.c$d */
    /* loaded from: classes15.dex */
    private static final class d implements Comparator<Object[]> {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@NotNull Object[] lhs, @NotNull Object[] rhs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) lhs, (Object) rhs)).intValue();
            }
            Intrinsics.checkNotNullParameter(lhs, "lhs");
            Intrinsics.checkNotNullParameter(rhs, "rhs");
            e eVar = e.f249623a;
            Object obj = lhs[eVar.ordinal()];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Object obj2 = rhs[eVar.ordinal()];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            return intValue - ((Integer) obj2).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/msf/core/push/MSFAlarmManager$TSetData;", "", "<init>", "(Ljava/lang/String;I)V", "MSFSDK_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.msf.core.push.c$e */
    /* loaded from: classes15.dex */
    public static final class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final e f249623a;

        /* renamed from: b, reason: collision with root package name */
        public static final e f249624b;

        /* renamed from: c, reason: collision with root package name */
        public static final e f249625c;

        /* renamed from: d, reason: collision with root package name */
        public static final e f249626d;

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ e[] f249627e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29168);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f249623a = new e("ID", 0);
            f249624b = new e("WAIT_TIME", 1);
            f249625c = new e("PENDING_INTENT", 2);
            f249626d = new e("CALLBACK", 3);
            f249627e = a();
        }

        e(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static e a(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) f249627e.clone();
        }

        private static final /* synthetic */ e[] a() {
            return new e[]{f249623a, f249624b, f249625c, f249626d};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.msf.core.push.MSFAlarmManager$handleAlarmBroadcast$2", f = "MSFAlarmManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.msf.core.push.c$f */
    /* loaded from: classes15.dex */
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f249628a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f249629b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MSFAlarmManager f249630c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Intent intent, MSFAlarmManager mSFAlarmManager, Continuation<? super f> continuation) {
            super(2, continuation);
            this.f249629b = intent;
            this.f249630c = mSFAlarmManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, intent, mSFAlarmManager, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new f(this.f249629b, this.f249630c, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[LOOP:0: B:22:0x007c->B:58:?, LOOP_END, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Unit unit;
            Object obj2;
            Object[] objArr;
            a aVar;
            Integer num;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f249628a == 0) {
                    ResultKt.throwOnFailure(obj);
                    int intExtra = this.f249629b.getIntExtra(MSFAlarmManager.f249603g, -1);
                    if (intExtra == -1) {
                        QLog.e(MSFAlarmManager.f249602f, 1, "onReceive: invalid alarmId");
                        return Unit.INSTANCE;
                    }
                    int intExtra2 = this.f249629b.getIntExtra(MSFAlarmManager.f249604h, -1);
                    int myPid = Process.myPid();
                    if (intExtra2 == myPid) {
                        TreeSet treeSet = this.f249630c.f249621d;
                        MSFAlarmManager mSFAlarmManager = this.f249630c;
                        synchronized (treeSet) {
                            Iterator it = mSFAlarmManager.f249621d.iterator();
                            while (true) {
                                unit = null;
                                aVar = null;
                                if (it.hasNext()) {
                                    obj2 = it.next();
                                    Object obj3 = ((Object[]) obj2)[e.f249623a.ordinal()];
                                    if (obj3 instanceof Integer) {
                                        num = (Integer) obj3;
                                    } else {
                                        num = null;
                                    }
                                    if (num != null && num.intValue() == intExtra) {
                                        z16 = true;
                                        if (!z16) {
                                            break;
                                        }
                                    }
                                    z16 = false;
                                    if (!z16) {
                                    }
                                } else {
                                    obj2 = null;
                                    break;
                                }
                            }
                            objArr = (Object[]) obj2;
                        }
                        if (objArr != null) {
                            MSFAlarmManager mSFAlarmManager2 = this.f249630c;
                            Intent intent = this.f249629b;
                            try {
                                Boolean I = com.tencent.mobileqq.msf.core.x.d.I();
                                Intrinsics.checkNotNullExpressionValue(I, "getMSFProbeEnableWakeLock()");
                                if (I.booleanValue()) {
                                    mSFAlarmManager2.b(com.tencent.mobileqq.msf.core.x.d.K());
                                }
                                Object obj4 = objArr[e.f249626d.ordinal()];
                                if (obj4 instanceof a) {
                                    aVar = (a) obj4;
                                }
                                if (aVar != null) {
                                    aVar.a(intent);
                                }
                                QLog.d(MSFAlarmManager.f249602f, 1, "Executed callback for alarm " + intExtra);
                            } catch (Exception e16) {
                                QLog.e(MSFAlarmManager.f249602f, 1, "Callback execution failed", e16);
                            }
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            QLog.d(MSFAlarmManager.f249602f, 1, "Alarm " + intExtra + " not found");
                        }
                        return Unit.INSTANCE;
                    }
                    QLog.d(MSFAlarmManager.f249602f, 1, "onReceive: ignore alarm from other process (register:" + intExtra2 + ", received:" + myPid + ')');
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.msf.core.push.MSFAlarmManager$onReceive$1", f = "MSFAlarmManager.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.msf.core.push.c$g */
    /* loaded from: classes15.dex */
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f249631a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f249633c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Intent intent, Continuation<? super g> continuation) {
            super(2, continuation);
            this.f249633c = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MSFAlarmManager.this, intent, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new g(this.f249633c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f249631a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    MSFAlarmManager mSFAlarmManager = MSFAlarmManager.this;
                    Intent intent = this.f249633c;
                    this.f249631a = 1;
                    if (mSFAlarmManager.a(intent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    static {
        Lazy<MSFAlarmManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f249601e = new c(null);
        lazy = LazyKt__LazyJVMKt.lazy(C8094b.f249622a);
        f249617u = lazy;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ MSFAlarmManager(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r0);
        String str2;
        if ((i3 & 1) != 0) {
            str2 = MsfSdkUtils.getProcessName(BaseApplication.getContext()) + util.base64_pad_url + c.class.hashCode();
        } else {
            str2 = str;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i3) {
        if (com.tencent.mobileqq.msf.core.x.d.I().booleanValue()) {
            if (this.f249619b == null) {
                this.f249619b = new com.tencent.mobileqq.msf.core.h0.a();
            }
            if (i3 > 0) {
                QLog.d(f249602f, 1, "tryWakeLock, lockTime:" + i3 + "ms");
                com.tencent.mobileqq.msf.core.h0.a aVar = this.f249619b;
                if (aVar != null) {
                    aVar.a(i3);
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        QLog.d(f249602f, 1, "MSF_Alive_Log alarm receive " + intent);
        String str = null;
        if (intent != null && Intrinsics.areEqual(intent.getAction(), this.f249618a)) {
            intent.putExtra(f249607k, SystemClock.elapsedRealtime());
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new g(intent, null), 3, null);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onReceive: ignore unrelated action ");
        if (intent != null) {
            str = intent.getAction();
        }
        sb5.append(str);
        QLog.d(f249602f, 1, sb5.toString());
    }

    MSFAlarmManager(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f249618a = str;
        this.f249620c = new AtomicBoolean(false);
        this.f249621d = new TreeSet<>(new d());
    }

    public final boolean a(int i3, long j3, @NotNull a callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), callback)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (j3 <= 0) {
            QLog.d(f249602f, 1, "tart Alarm error, intervalTime:" + j3);
            return false;
        }
        synchronized (this.f249621d) {
            if (this.f249620c.compareAndSet(false, true)) {
                BaseApplication.getContext().registerReceiver(this, new IntentFilter(this.f249618a));
                QLog.d(f249602f, 1, "Alarm register Broadcast success");
            }
            Boolean I = com.tencent.mobileqq.msf.core.x.d.I();
            Intrinsics.checkNotNullExpressionValue(I, "getMSFProbeEnableWakeLock()");
            if (I.booleanValue()) {
                b(com.tencent.mobileqq.msf.core.x.d.L());
            }
            TreeSet<Object[]> treeSet = this.f249621d;
            if (!(treeSet instanceof Collection) || !treeSet.isEmpty()) {
                Iterator<T> it = treeSet.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((Object[]) it.next())[e.f249623a.ordinal()], Integer.valueOf(i3))) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                QLog.e(f249602f, 1, "start Alarm error, id:" + i3 + " is already exist");
            } else {
                PendingIntent a16 = a(i3, j3);
                if (a16 == null) {
                    QLog.d(f249602f, 1, "start Alarm error, pendingIntent is null");
                } else {
                    this.f249621d.add(new Object[]{Integer.valueOf(i3), Long.valueOf(j3), a16, callback});
                    QLog.d(f249602f, 1, "start Alarm success, id:" + i3 + ", intervalTime:" + j3);
                    z17 = true;
                }
            }
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, long j3, int i16, boolean z16) {
        com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.core.getStatReporter();
        HashMap hashMap = new HashMap();
        hashMap.put(f249609m, String.valueOf(i3));
        hashMap.put(f249608l, String.valueOf(j3));
        hashMap.put(f249610n, String.valueOf(i16));
        hashMap.put(f249611o, String.valueOf(z16));
        Object systemService = BaseApplication.getContext().getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        hashMap.put(f249612p, String.valueOf(powerManager != null ? Boolean.valueOf(powerManager.isIgnoringBatteryOptimizations(BaseApplication.getContext().getPackageName())) : null));
        if (statReporter != null) {
            statReporter.a(f249613q, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[LOOP:0: B:25:0x0077->B:57:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(int i3) {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        Object systemService = BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
        boolean z17 = false;
        if (alarmManager == null) {
            QLog.d(f249602f, 1, "cancelAlarm error: alarmManager is null");
            return false;
        }
        synchronized (this.f249621d) {
            if (this.f249620c.compareAndSet(false, true)) {
                BaseApplication.getContext().registerReceiver(this, new IntentFilter(this.f249618a));
                QLog.d(f249602f, 1, "Alarm register Broadcast success");
            }
            Boolean I = com.tencent.mobileqq.msf.core.x.d.I();
            Intrinsics.checkNotNullExpressionValue(I, "getMSFProbeEnableWakeLock()");
            if (I.booleanValue()) {
                b(com.tencent.mobileqq.msf.core.x.d.J());
            }
            Iterator<T> it = this.f249621d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Object obj2 = ((Object[]) obj)[e.f249623a.ordinal()];
                Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
                if (num != null && num.intValue() == i3) {
                    z16 = true;
                    if (!z16) {
                        break;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            Object[] objArr = (Object[]) obj;
            if (objArr == null) {
                QLog.d(f249602f, 1, "cancelAlarm: alarmId " + i3 + " not found");
            } else {
                try {
                    Object obj3 = objArr[e.f249625c.ordinal()];
                    PendingIntent pendingIntent = obj3 instanceof PendingIntent ? (PendingIntent) obj3 : null;
                    if (pendingIntent != null) {
                        alarmManager.cancel(pendingIntent);
                        pendingIntent.cancel();
                    }
                    this.f249621d.remove(objArr);
                    QLog.d(f249602f, 1, "cancelAlarm success: id=" + i3);
                    z17 = true;
                } catch (Exception e16) {
                    QLog.e(f249602f, 1, "cancelAlarm error for id=" + i3, e16);
                }
            }
        }
        return z17;
    }

    private final PendingIntent a(int i3, long j3) {
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        int i16;
        Object systemService = BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
        if (alarmManager == null) {
            QLog.d(f249602f, 1, "setAlarmMgr error: alarmManager is null");
            return null;
        }
        int i17 = Build.VERSION.SDK_INT;
        if (i17 > 31) {
            z16 = alarmManager.canScheduleExactAlarms();
            str = f249602f;
        } else {
            str = f249602f;
            z16 = true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j16 = elapsedRealtime + j3;
        Intent intent = new Intent(this.f249618a);
        intent.putExtra(f249603g, i3);
        intent.putExtra(f249604h, Process.myPid());
        intent.putExtra(f249605i, j3);
        intent.putExtra(f249606j, elapsedRealtime);
        PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), i3, intent, i17 > 23 ? 335544320 : 268435456);
        try {
            Method declaredMethod = AlarmManager.class.getDeclaredMethod("setExactAndAllowWhileIdle", Integer.TYPE, Long.TYPE, PendingIntent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(alarmManager, 2, Long.valueOf(j16), broadcast);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("register alarm with setExactAndAllowWhileIdle success, action:");
            sb5.append(this.f249618a);
            sb5.append(", canScheduleExactAlarms:");
            sb5.append(z16);
            sb5.append(", alarmId:");
            sb5.append(i3);
            str3 = ", trigger at:";
            try {
                sb5.append(str3);
                sb5.append(MsfSdkUtils.timeMillisToDay(System.currentTimeMillis() + j3));
                str2 = str;
            } catch (Throwable th5) {
                th = th5;
                str2 = str;
            }
            try {
                QLog.d(str2, 1, sb5.toString());
                i16 = 1;
            } catch (Throwable th6) {
                th = th6;
                QLog.e(str2, 1, "doRegisterAlarm with setExactAndAllowWhileIdle method error!", th);
                try {
                    Class[] clsArr = new Class[3];
                    clsArr[0] = Integer.TYPE;
                    String str5 = str2;
                    try {
                        clsArr[1] = Long.TYPE;
                        clsArr[2] = PendingIntent.class;
                        Method declaredMethod2 = AlarmManager.class.getDeclaredMethod("setAndAllowWhileIdle", clsArr);
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(alarmManager, 2, Long.valueOf(j16), broadcast);
                        str4 = str5;
                    } catch (Throwable th7) {
                        th = th7;
                        str4 = str5;
                    }
                    try {
                        QLog.d(str4, 1, "register alarm with setAndAllowWhileIdle success, action:" + this.f249618a + ", canScheduleExactAlarms:" + z16 + ", alarmId:" + i3 + str3 + MsfSdkUtils.timeMillisToDay(System.currentTimeMillis() + j3));
                        i16 = 2;
                    } catch (Throwable th8) {
                        th = th8;
                        QLog.e(str4, 1, "doRegisterAlarm with setAndAllowWhileIdle method error!", th);
                        try {
                            Method declaredMethod3 = AlarmManager.class.getDeclaredMethod("set", Integer.TYPE, Long.TYPE, PendingIntent.class);
                            declaredMethod3.setAccessible(true);
                            declaredMethod3.invoke(alarmManager, 2, Long.valueOf(j16), broadcast);
                            QLog.d(str4, 1, "register alarm with setAlarm success, action:" + this.f249618a + "canScheduleExactAlarms:" + z16 + ", alarmId:" + i3 + str3 + MsfSdkUtils.timeMillisToDay(System.currentTimeMillis() + j3));
                            i16 = 3;
                            a(i3, j3, i16, z16);
                            return broadcast;
                        } catch (Throwable th9) {
                            QLog.e(str4, 1, "doRegisterAlarm with setAlarm method error!", th9);
                            return null;
                        }
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str4 = str2;
                }
                a(i3, j3, i16, z16);
                return broadcast;
            }
        } catch (Throwable th11) {
            th = th11;
            str2 = str;
            str3 = ", trigger at:";
        }
        a(i3, j3, i16, z16);
        return broadcast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Intent intent, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new f(intent, this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    private final void a(final int i3, final long j3, final int i16, final boolean z16) {
        q.q().post(new Runnable() { // from class: com.tencent.mobileqq.msf.core.push.i
            @Override // java.lang.Runnable
            public final void run() {
                MSFAlarmManager.b(i3, j3, i16, z16);
            }
        });
    }
}
