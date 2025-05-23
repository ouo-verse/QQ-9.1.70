package com.tencent.mobileqq.perf.memory.cache;

import android.app.Activity;
import androidx.fragment.app.Argus;
import androidx.fragment.app.Fragment;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.api.d;
import com.tencent.cache.core.manager.api.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bR&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/cache/AppStateMonitor;", "", "Lcom/tencent/mobileqq/perf/memory/cache/AppStateMonitor$AppAction;", "appAction", "", "stage", "", "e", "", "j", "Lcom/tencent/cache/api/Business;", "business", "addOrRemove", "i", "f", "businessTag", "b", "d", "c", h.F, "", "", "Ljava/util/Map;", "businessToPackageSignature", "businessToFixedPreviousBusiness", "Ljava/util/Stack;", "Ljava/util/Stack;", "businessStack", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "g", "()Lcom/tencent/mobileqq/perf/tracker/callback/a;", "sceneChangerListener", "<init>", "()V", "AppAction", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AppStateMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AppStateMonitor f257658a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Business, List<String>> businessToPackageSignature;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Business, Business> businessToFixedPreviousBusiness;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Stack<Business> businessStack;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.tracker.callback.a sceneChangerListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/cache/AppStateMonitor$AppAction;", "", "addOrRemove", "", "(Ljava/lang/String;IZ)V", "getAddOrRemove", "()Z", "TRACE_START", "TRACE_END", "ACTIVITY_RESUME", "ACTIVITY_PAUSE", "FRAGMENT_RESUME", "FRAGMENT_DESTROY", "SET_BY_BUSINESS", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class AppAction {
        private static final /* synthetic */ AppAction[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AppAction ACTIVITY_PAUSE;
        public static final AppAction ACTIVITY_RESUME;
        public static final AppAction FRAGMENT_DESTROY;
        public static final AppAction FRAGMENT_RESUME;
        public static final AppAction SET_BY_BUSINESS;
        public static final AppAction TRACE_END;
        public static final AppAction TRACE_START;
        private final boolean addOrRemove;

        private static final /* synthetic */ AppAction[] $values() {
            return new AppAction[]{TRACE_START, TRACE_END, ACTIVITY_RESUME, ACTIVITY_PAUSE, FRAGMENT_RESUME, FRAGMENT_DESTROY, SET_BY_BUSINESS};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28873);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            TRACE_START = new AppAction("TRACE_START", 0, true);
            boolean z16 = false;
            int i3 = 1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            TRACE_END = new AppAction("TRACE_END", 1, z16, i3, defaultConstructorMarker);
            ACTIVITY_RESUME = new AppAction("ACTIVITY_RESUME", 2, true);
            ACTIVITY_PAUSE = new AppAction("ACTIVITY_PAUSE", 3, z16, i3, defaultConstructorMarker);
            FRAGMENT_RESUME = new AppAction("FRAGMENT_RESUME", 4, true);
            FRAGMENT_DESTROY = new AppAction("FRAGMENT_DESTROY", 5, z16, i3, defaultConstructorMarker);
            SET_BY_BUSINESS = new AppAction("SET_BY_BUSINESS", 6, false, 1, null);
            $VALUES = $values();
        }

        AppAction(String str, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.addOrRemove = z16;
            } else {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        public static AppAction valueOf(String str) {
            return (AppAction) Enum.valueOf(AppAction.class, str);
        }

        public static AppAction[] values() {
            return (AppAction[]) $VALUES.clone();
        }

        public final boolean getAddOrRemove() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.addOrRemove;
        }

        /* synthetic */ AppAction(String str, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, (i16 & 1) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/perf/memory/cache/AppStateMonitor$a", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "stage", "", "delay", "", "traceStart", "traceEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onActivityResumed", "onActivityPaused", "Landroidx/fragment/app/Fragment;", "fragment", "onQFragmentResumed", "onQFragmentDestroy", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            AppStateMonitor appStateMonitor = AppStateMonitor.f257658a;
            AppAction appAction = AppAction.ACTIVITY_PAUSE;
            String name = activity.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
            appStateMonitor.e(appAction, name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            AppStateMonitor appStateMonitor = AppStateMonitor.f257658a;
            AppAction appAction = AppAction.ACTIVITY_RESUME;
            String name = activity.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
            appStateMonitor.e(appAction, name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentDestroy(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) fragment);
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            AppStateMonitor appStateMonitor = AppStateMonitor.f257658a;
            AppAction appAction = AppAction.FRAGMENT_DESTROY;
            String name = fragment.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "fragment.javaClass.name");
            appStateMonitor.e(appAction, name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentResumed(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) fragment);
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            AppStateMonitor appStateMonitor = AppStateMonitor.f257658a;
            AppAction appAction = AppAction.FRAGMENT_RESUME;
            String name = fragment.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "fragment.javaClass.name");
            appStateMonitor.e(appAction, name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceEnd(@NotNull String stage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) stage);
            } else {
                Intrinsics.checkNotNullParameter(stage, "stage");
                AppStateMonitor.f257658a.e(AppAction.TRACE_END, stage);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceStart(@NotNull String stage, boolean delay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, stage, Boolean.valueOf(delay));
            } else {
                Intrinsics.checkNotNullParameter(stage, "stage");
                AppStateMonitor.f257658a.e(AppAction.TRACE_START, stage);
            }
        }
    }

    static {
        List listOf;
        List listOf2;
        List listOf3;
        List listOf4;
        List listOf5;
        Map<Business, List<String>> mapOf;
        Map<Business, Business> mapOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f257658a = new AppStateMonitor();
        Business business = Business.Guild;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(".guild.");
        Business business2 = Business.QCircle;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(".qqcircle.");
        Business business3 = Business.Leba;
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(".leba.");
        Business business4 = Business.QZone;
        listOf4 = CollectionsKt__CollectionsJVMKt.listOf(".qzone.");
        Business business5 = Business.MiniApp;
        listOf5 = CollectionsKt__CollectionsJVMKt.listOf(".mini.");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(business, listOf), TuplesKt.to(business2, listOf2), TuplesKt.to(business3, listOf3), TuplesKt.to(business4, listOf4), TuplesKt.to(business5, listOf5));
        businessToPackageSignature = mapOf;
        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(business4, business3));
        businessToFixedPreviousBusiness = mapOf2;
        businessStack = new Stack<>();
        sceneChangerListener = new a();
    }

    AppStateMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Business b(Business businessTag) {
        Business f16 = f();
        if (businessTag == businessToFixedPreviousBusiness.get(f16)) {
            businessStack.pop();
            if (f() != businessTag) {
                businessStack.push(businessTag);
                return f16;
            }
            businessStack.push(f16);
            return null;
        }
        return businessTag;
    }

    private final Business c(AppAction appAction, String stage) {
        List listOf;
        Object obj;
        boolean contains$default;
        boolean z16;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AppAction[]{AppAction.ACTIVITY_RESUME, AppAction.ACTIVITY_PAUSE, AppAction.FRAGMENT_RESUME, AppAction.FRAGMENT_DESTROY});
        if (!listOf.contains(appAction)) {
            return null;
        }
        QRouteApi api = QRoute.api(IPerfApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPerfApi::class.java)");
        if (Intrinsics.areEqual(stage, ((IPerfApi) api).getSimpleClassName("GuildContactFragment"))) {
            return Business.Contact;
        }
        Iterator<T> it = businessToPackageSignature.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Iterable iterable = (Iterable) ((Map.Entry) obj).getValue();
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it5 = iterable.iterator();
                    while (it5.hasNext()) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) stage, (CharSequence) it5.next(), false, 2, (Object) null);
                        if (contains$default) {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return (Business) entry.getKey();
    }

    private final Business d(AppAction appAction, String stage) {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AppAction[]{AppAction.TRACE_START, AppAction.TRACE_END});
        if (!listOf.contains(appAction)) {
            return null;
        }
        switch (stage.hashCode()) {
            case -414462903:
                if (!stage.equals("com.tencent.mobileqq.activity.home.Conversation")) {
                    return null;
                }
                return Business.Conversation;
            case 407018872:
                if (!stage.equals("com.tencent.mobileqq.leba.Leba")) {
                    return null;
                }
                return Business.Leba;
            case 970997192:
                if (!stage.equals("QQSettingMe")) {
                    return null;
                }
                return Business.Setting;
            case 1360123902:
                if (!stage.equals("com.tencent.mobileqq.activity.contacts.base.Contacts")) {
                    return null;
                }
                return Business.Contact;
            case 1782751074:
                if (!stage.equals("com.tencent.mobileqq.activity.qcircle.QCircleFrame")) {
                    return null;
                }
                return Business.QCircle;
            case 1823474909:
                if (!stage.equals("com.tencent.mobileqq.activity.leba.QzoneFrame")) {
                    return null;
                }
                return Business.QZone;
            case 1931709360:
                if (!stage.equals("SplashAIOFragment")) {
                    return null;
                }
                return Business.AIO;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(AppAction appAction, String stage) {
        Business d16 = d(appAction, stage);
        if (d16 == null) {
            d16 = c(appAction, stage);
        }
        if (d16 != null) {
            f257658a.i(d16, appAction, appAction.getAddOrRemove());
        }
    }

    private final Business f() {
        if (!businessStack.isEmpty()) {
            return businessStack.peek();
        }
        return null;
    }

    private final synchronized void i(Business business, AppAction appAction, boolean addOrRemove) {
        if (addOrRemove) {
            Business business2 = Business.Conversation;
            if (business == business2) {
                if ((!businessStack.isEmpty()) && businessStack.peek() == business2) {
                    return;
                } else {
                    businessStack.clear();
                }
            }
            if (businessStack.isEmpty() || businessStack.peek() != business) {
                Business b16 = b(business);
                if (b16 != null) {
                    businessStack.push(b16);
                    if (!f257658a.j()) {
                        c.f98725d.a().b(null, new d(b16, PageHierarchy.MainPage, null));
                    }
                }
                QLog.i("MemoryControl_AppStateMonitor", 1, "updateCurrentBusinessTag, businessTag:" + business + ", appAction:" + appAction + ", addOrRemove: true, Stack: " + businessStack);
            }
        } else if ((!businessStack.isEmpty()) && businessStack.peek() == business) {
            businessStack.pop();
            Business f16 = f();
            if (f16 != null && !f257658a.j()) {
                c.f98725d.a().b(null, new d(f16, PageHierarchy.MainPage, null));
            }
            QLog.i("MemoryControl_AppStateMonitor", 1, "updateCurrentBusinessTag, business:" + business + ", appAction:" + appAction + ", addOrRemove: false, Stack: " + businessStack);
        }
    }

    private final boolean j() {
        if (c.f98725d.d().H() && Argus.INSTANCE.isMonitorEnable()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final com.tencent.mobileqq.perf.tracker.callback.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.perf.tracker.callback.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sceneChangerListener;
    }

    public final void h(@NotNull Business business, boolean addOrRemove) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, business, Boolean.valueOf(addOrRemove));
        } else {
            Intrinsics.checkNotNullParameter(business, "business");
            i(business, AppAction.SET_BY_BUSINESS, addOrRemove);
        }
    }
}
