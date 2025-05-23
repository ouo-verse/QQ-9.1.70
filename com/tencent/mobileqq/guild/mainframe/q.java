package com.tencent.mobileqq.guild.mainframe;

import android.content.SharedPreferences;
import android.os.Looper;
import androidx.annotation.UiThread;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabMMKVManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.mainframe.q;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0003J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010\f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n8B@BX\u0082\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/q;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "l", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/mainframe/v;", "listener", "i", HippyTKDListViewAdapter.X, "", "w", "account", FileReaderHelper.OPEN_FILE_FROM_FORCE, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "key", "j", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "r", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", ReportConstant.COSTREPORT_PREFIX, "v", "onAccountChanged", "e", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "onTabStatusChangeListener", "f", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", "studyModeChangeListener", "value", tl.h.F, "Ljava/lang/String;", "k", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "guildTabStates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final q f227488d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SharedPreferences.OnSharedPreferenceChangeListener onTabStatusChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static StudyModeChangeListener studyModeChangeListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String account;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, Boolean> guildTabStates;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<v> listeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/q$a", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/content/SharedPreferences;", "preferences", "", "key", "", "onSharedPreferenceChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            q.f227488d.v();
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(@NotNull SharedPreferences preferences, @NotNull String key) {
            Intrinsics.checkNotNullParameter(preferences, "preferences");
            Intrinsics.checkNotNullParameter(key, "key");
            q qVar = q.f227488d;
            String j3 = qVar.j(key);
            if (j3 != null) {
                boolean p16 = qVar.p(j3, true);
                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    qVar.v();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            q.a.b();
                        }
                    });
                }
                Logger.f235387a.d().i("Guild.tab.GuildTabStateRepository", 1, key + " - result: " + p16);
            }
        }
    }

    static {
        q qVar = new q();
        f227488d = qVar;
        onTabStatusChangeListener = qVar.r();
        studyModeChangeListener = qVar.s();
        account = "";
        guildTabStates = new ConcurrentHashMap<>();
        listeners = new CopyOnWriteArrayList<>();
        TabMMKVManager.d().g(qVar.getClass().getName(), onTabStatusChangeListener);
        AccountChangedNotifier.f214789d.a(qVar);
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(studyModeChangeListener);
    }

    q() {
    }

    @JvmStatic
    @UiThread
    public static final void i(@NotNull v listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<v> copyOnWriteArrayList = listeners;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(String key) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean endsWith$default;
        boolean endsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, TabDataHelper.KEY_TAB_SWITCH, false, 2, null);
        if (startsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(key, "GUILD", false, 2, null);
            if (endsWith$default2) {
                String substring = key.substring(12, (key.length() - 5) - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring;
            }
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(key, TabDataHelper.KEY_TAB_LOCAL_SWITCH, false, 2, null);
        if (startsWith$default2) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(key, "GUILD", false, 2, null);
            if (endsWith$default) {
                String substring2 = key.substring(17, (key.length() - 5) - 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring2;
            }
        }
        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(key, TabDataHelper.KEY_TAB_SEQUENCE, false, 2, null);
        if (!startsWith$default3) {
            return null;
        }
        String substring3 = key.substring(14);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
        return substring3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k() {
        String w3 = w();
        if (w3 == null) {
            return account;
        }
        return w3;
    }

    @JvmStatic
    public static final boolean l() {
        boolean z16;
        q qVar = f227488d;
        if (qVar.k().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger.f235387a.d().i("Guild.tab.GuildTabStateRepository", 1, "isGuildTabShow(): maybe account is empty? " + qVar.k());
        }
        if (MobileQQ.sProcessId != 1) {
            boolean p16 = qVar.p(qVar.k(), true);
            Logger.f235387a.d().i("Guild.tab.GuildTabStateRepository", 1, "Called from subprocess: isGuildTabShow() = " + p16);
            return p16;
        }
        Boolean bool = guildTabStates.get(qVar.k());
        if (bool == null) {
            return q(qVar, qVar.k(), false, 2, null);
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(String account2, boolean force) {
        boolean z16;
        boolean z17 = false;
        if (!force && !TabDataHelper.isOnceFetchFromServer(BaseApplication.getContext(), account2)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            z17 = TabDataHelper.isExtendTabShow(BaseApplication.getContext(), account2, "GUILD");
        }
        if (z16) {
            Logger.f235387a.d().i("Guild.tab.GuildTabStateRepository", 1, "loadIsTabShowFromTabData(" + account2 + ", force = " + force + ") = " + z17 + ", from TabHelper");
        } else {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.tab.GuildTabStateRepository", 2, "loadIsTabShowFromTabData(" + account2 + ") = " + z17);
            }
        }
        guildTabStates.put(account2, Boolean.valueOf(z17));
        return z17;
    }

    @JvmStatic
    public static final void n() {
        boolean z16;
        q qVar = f227488d;
        String k3 = qVar.k();
        boolean z17 = false;
        if (k3 != null && k3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger.f235387a.d().i("Guild.tab.GuildTabStateRepository", 1, "loadIsTabShowFromTabDataForce(): account is empty");
            return;
        }
        boolean l3 = l();
        boolean p16 = qVar.p(qVar.k(), true);
        if (l3 != p16) {
            z17 = true;
        }
        Logger.f235387a.d().i("Guild.tab.GuildTabStateRepository", 1, "loadIsTabShowFromTabDataForce(): isTabShowBeforeCheck " + l3 + " isTabShowAfterCheck " + p16 + " isChanged " + z17);
        if (z17) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                qVar.v();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.o();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        f227488d.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(String account2, boolean force) {
        String valueOf;
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Object[] objArr = {account2, Boolean.valueOf(force)};
        long a16 = GuildDebugUtils.a.f235335a.a();
        try {
            Logger logger = Logger.f235387a;
            logger.d().i("Guild.tab.GuildTabStateRepository", 1, "methodCall<" + a16 + "> loadIsTabShowFromTabData(" + GuildDebugUtils.f235333a.d(objArr) + ")");
            Boolean valueOf2 = Boolean.valueOf(f227488d.m(account2, force));
            Logger.a d16 = logger.d();
            if (Boolean.class == Void.TYPE) {
                valueOf = "VOID";
            } else {
                valueOf = String.valueOf(valueOf2);
            }
            d16.i("Guild.tab.GuildTabStateRepository", 1, "methodCall<" + a16 + "> loadIsTabShowFromTabData() return: " + valueOf);
            return valueOf2.booleanValue();
        } catch (Throwable th5) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "methodCall<" + a16 + "> loadIsTabShowFromTabData() throwException!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.tab.GuildTabStateRepository", 1, (String) it.next(), th5);
            }
            throw th5;
        }
    }

    static /* synthetic */ boolean q(q qVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return qVar.p(str, z16);
    }

    private final SharedPreferences.OnSharedPreferenceChangeListener r() {
        return new a();
    }

    private final StudyModeChangeListener s() {
        return new StudyModeChangeListener() { // from class: com.tencent.mobileqq.guild.mainframe.n
            @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
            public final void onChange(boolean z16) {
                q.t(z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(boolean z16) {
        q qVar = f227488d;
        boolean p16 = qVar.p(qVar.k(), true);
        Logger.f235387a.d().i("Guild.tab.GuildTabStateRepository", 1, "onStudyModeChange - result: " + p16);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            qVar.v();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.o
                @Override // java.lang.Runnable
                public final void run() {
                    q.u();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u() {
        f227488d.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void v() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((v) it.next()).a();
        }
    }

    private final String w() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return null;
    }

    @JvmStatic
    @UiThread
    public static final void x(@NotNull v listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    private final void y(String str) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.tab.GuildTabStateRepository", 2, "account changed: " + f227488d.k() + " -> " + str);
        }
        account = str;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account2) {
        Intrinsics.checkNotNullParameter(account2, "account");
        y(account2);
    }
}
