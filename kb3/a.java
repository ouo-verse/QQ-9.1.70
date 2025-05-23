package kb3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.qphone.base.util.QLog;
import eb3.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import lb3.g;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001aj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#\u00a8\u0006("}, d2 = {"Lkb3/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "g", "Ljava/lang/Class;", "clazz", "", "name", "Landroid/content/Context;", "originContext", "", "f", "action", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "wxaInfo", "e", h.F, "k", "j", "i", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "createActivity", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "activityMap", "d", "Z", "isResume", "Lkb3/a$a;", "Lkb3/a$a;", "receiver", "<init>", "()V", "a", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Activity> createActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isResume;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static C10645a receiver;

    /* renamed from: a, reason: collision with root package name */
    public static final a f411988a = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Activity, WxaInfo> activityMap = new HashMap<>();

    a() {
    }

    private final void e(String action, WxaInfo wxaInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(WxaInfo.class.getClassLoader());
        bundle.putParcelable("wxaInfo", wxaInfo);
        QIPCClientHelper.getInstance().callServer("wxa_qipc_module", action, bundle);
    }

    private final void f(Class<?> clazz, String name, Context originContext) {
        try {
            b bVar = b.f396065a;
            Object obj = bVar.a(clazz, name).get(originContext);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Context");
            Context context = (Context) obj;
            if (context instanceof eb3.a) {
                return;
            }
            bVar.a(clazz, name).set(originContext, new eb3.a(context));
            QLog.e("[wxa-q]WxaContainerLifecycle", 1, "on wxa activity created hook success.");
        } catch (Throwable th5) {
            QLog.e("[wxa-q]WxaContainerLifecycle", 1, "on wxa activity created hook failed.", th5);
        }
    }

    private final boolean g(Activity activity) {
        boolean startsWith$default;
        String simpleName = activity.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(simpleName, "WxaContainerMultiTaskActivity", false, 2, null);
        return startsWith$default;
    }

    public final void h(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (g(activity)) {
            QLog.i("[wxa-q]WxaContainerLifecycle", 1, "activity onCreate: " + activity);
            GlobalDisplayMetricsManager.adjustDisplayMetrics(activity);
            FontSettingManager.resetFontIfNeeded(activity, true, false);
            f(ContextWrapper.class, "mBase", activity);
            C10645a c10645a = new C10645a();
            receiver = c10645a;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.ACTION_LAUNCH_WXA");
            Unit unit = Unit.INSTANCE;
            activity.registerReceiver(c10645a, intentFilter);
            createActivity = new WeakReference<>(activity);
            mb3.a.f416521d.registerModule();
        }
    }

    public final void i(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (g(activity)) {
            g gVar = g.f414306a;
            gVar.m();
            WxaInfo remove = activityMap.remove(activity);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("activity:");
            sb5.append(activity);
            sb5.append(" onDestroy appid:");
            sb5.append(remove != null ? remove.getWxAppId() : null);
            QLog.i("[wxa-q]WxaContainerLifecycle", 1, sb5.toString());
            if (remove != null) {
                gVar.s(activity, remove);
                f411988a.e("client_action_on_destroy", remove);
            }
            C10645a c10645a = receiver;
            if (c10645a != null) {
                try {
                    activity.unregisterReceiver(c10645a);
                } catch (Exception e16) {
                    QLog.e("[wxa-q]WxaContainerLifecycle", 1, e16, new Object[0]);
                }
            }
        }
    }

    public final void j(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (g(activity)) {
            WxaInfo wxaInfo = activityMap.get(activity);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("activity pause: ");
            sb5.append(activity);
            sb5.append(" appid:");
            sb5.append(wxaInfo != null ? wxaInfo.getWxAppId() : null);
            QLog.i("[wxa-q]WxaContainerLifecycle", 1, sb5.toString());
            if (wxaInfo != null) {
                g.f414306a.s(activity, wxaInfo);
                f411988a.e("client_action_on_hide", wxaInfo);
            }
        }
    }

    public final void k(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (g(activity)) {
            WxaInfo wxaInfo = activityMap.get(activity);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("activity resume: ");
            sb5.append(activity);
            sb5.append(" appid:");
            sb5.append(wxaInfo != null ? wxaInfo.getWxAppId() : null);
            QLog.i("[wxa-q]WxaContainerLifecycle", 1, sb5.toString());
            if (wxaInfo != null) {
                g.f414306a.B(activity, wxaInfo);
                f411988a.e("client_action_on_show", wxaInfo);
            }
            isResume = true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lkb3/a$a;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kb3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    private static final class C10645a extends BroadcastReceiver {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action != null && action.hashCode() == 1915111367 && action.equals("com.tencent.mobileqq.ACTION_LAUNCH_WXA")) {
                WxaInfo wxaInfo = (WxaInfo) intent.getParcelableExtra("wxaInfo");
                if (wxaInfo == null) {
                    QLog.e("[wxa-q]WxaContainerLifecycle", 1, "receive LAUNCH_WXA_ACTION error data");
                    return;
                }
                QLog.i("[wxa-q]WxaContainerLifecycle", 1, "receive LAUNCH_WXA_ACTION wxaInfo :" + wxaInfo + " resumeActivity:" + a.createActivity);
                WeakReference weakReference = a.createActivity;
                if ((weakReference != null ? (Activity) weakReference.get() : null) != null) {
                    WeakReference weakReference2 = a.createActivity;
                    Intrinsics.checkNotNull(weakReference2);
                    T t16 = weakReference2.get();
                    Intrinsics.checkNotNull(t16);
                    Activity activity = (Activity) t16;
                    a.activityMap.put(activity, wxaInfo);
                    if (a.isResume) {
                        a.f411988a.k(activity);
                    }
                    a.createActivity = null;
                    return;
                }
                for (Map.Entry entry : a.activityMap.entrySet()) {
                    if (Intrinsics.areEqual(((WxaInfo) entry.getValue()).getWxAppId(), wxaInfo.getWxAppId())) {
                        WxaInfo wxaInfo2 = (WxaInfo) a.activityMap.get(entry.getKey());
                        if (wxaInfo2 != null) {
                            wxaInfo2.t(wxaInfo.getScene());
                        }
                        QLog.i("[wxa-q]WxaContainerLifecycle", 1, "receive find same wxAppId, update wxaInfo.scene:" + wxaInfo);
                    }
                }
            }
        }
    }
}
