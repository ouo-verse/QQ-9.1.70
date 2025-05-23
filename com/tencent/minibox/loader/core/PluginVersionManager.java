package com.tencent.minibox.loader.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.common.thread.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.File;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u001d\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/minibox/loader/core/PluginVersionManager;", "", "Landroid/content/Context;", "context", "", "uin", "", "l", "k", "curVersion", "", "r", "o", "version", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "latestVersion", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "p", ReportConstant.COSTREPORT_PREFIX, "j", "e", "Lcom/tencent/minibox/loader/core/f;", "g", "f", "i", "a", "Ljava/lang/Object;", "mVersionLock", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class PluginVersionManager {

    /* renamed from: b, reason: collision with root package name */
    public static final PluginVersionManager f151646b = new PluginVersionManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Object mVersionLock = new Object();

    PluginVersionManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(Context context) {
        return p51.d.f425349a.a(context).getString("plugin_version_latest_update", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(Context context) {
        return p51.e.f425350a.a(context);
    }

    private final boolean k(final Context context, final String uin) {
        synchronized (mVersionLock) {
            PluginVersionManager pluginVersionManager = f151646b;
            String h16 = pluginVersionManager.h(context);
            LogUtils.i("PluginVersionManager", "installOnlinePlugin: latestUpdateVersion:" + h16);
            if (pluginVersionManager.n(context, h16)) {
                boolean d16 = o51.a.f422110b.d(context, h16);
                LogUtils.i("PluginVersionManager", "installOnlinePlugin: installResult:" + d16);
                if (d16) {
                    boolean m3 = pluginVersionManager.m(context, h16);
                    LogUtils.i("PluginVersionManager", "installOnlinePlugin: isNewVersionValid:" + m3);
                    if (m3) {
                        pluginVersionManager.q(context, h16);
                        pluginVersionManager.p(context, null);
                        if (h16 == null) {
                            Intrinsics.throwNpe();
                        }
                        pluginVersionManager.s(context, h16);
                        pluginVersionManager.o(context);
                        return true;
                    }
                }
            }
            final String i3 = pluginVersionManager.i(context);
            boolean m16 = pluginVersionManager.m(context, i3);
            LogUtils.i("PluginVersionManager", "installOnlinePlugin: oldVersion:" + i3 + ", isOldVersionValid:" + m16);
            if (m16) {
                ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.loader.core.PluginVersionManager$installOnlinePlugin$$inlined$synchronized$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z16 = false;
                        String b16 = o51.a.f422110b.b(context, uin, i3, false);
                        LogUtils.i("PluginVersionManager", "installOnlinePlugin: async newVersion:" + b16);
                        if (b16 == null || b16.length() == 0) {
                            z16 = true;
                        }
                        if (!z16) {
                            PluginVersionManager.f151646b.p(context, b16);
                        }
                    }
                });
                if (i3 == null) {
                    Intrinsics.throwNpe();
                }
                pluginVersionManager.s(context, i3);
                pluginVersionManager.o(context);
                return true;
            }
            String b16 = o51.a.f422110b.b(context, uin, null, true);
            boolean m17 = pluginVersionManager.m(context, b16);
            LogUtils.i("PluginVersionManager", "installOnlinePlugin: newVersion:" + b16 + ", isNewVersionValid:" + m17);
            if (m17) {
                pluginVersionManager.q(context, b16);
                if (b16 == null) {
                    Intrinsics.throwNpe();
                }
                pluginVersionManager.s(context, b16);
                pluginVersionManager.o(context);
                return true;
            }
            pluginVersionManager.o(context);
            return false;
        }
    }

    private final boolean l(Context context, String uin) {
        return k(context, uin);
    }

    private final boolean m(Context context, String version) {
        boolean startsWith$default;
        File[] listFiles;
        boolean z16;
        if (TextUtils.isEmpty(version)) {
            LogUtils.w("PluginVersionManager", "isPluginVersionUsable: version is empty");
            return false;
        }
        if (version == null) {
            Intrinsics.throwNpe();
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(version, "0.5.2", false, 2, null);
        if (!startsWith$default) {
            LogUtils.w("PluginVersionManager", "isPluginVersionUsable: version mismatch, version=" + version);
            return false;
        }
        PluginPathConfig d16 = o51.d.d(context, version);
        if (!new File(d16.getApkFilePath()).exists() || (listFiles = new File(d16.getLibPath()).listFiles()) == null) {
            return false;
        }
        if (listFiles.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            return false;
        }
        return true;
    }

    private final boolean n(Context context, String version) {
        boolean startsWith$default;
        if (TextUtils.isEmpty(version)) {
            LogUtils.w("PluginVersionManager", "isPluginVersionUsable: version is empty");
            return false;
        }
        if (version == null) {
            Intrinsics.throwNpe();
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(version, "0.5.2", false, 2, null);
        if (!startsWith$default) {
            LogUtils.w("PluginVersionManager", "isPluginVersionUsable: version mismatch, version=" + version);
            return false;
        }
        return new File(o51.d.e(context), "minibox.apk").exists();
    }

    private final void o(final Context context) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.loader.core.PluginVersionManager$removeExpiredPluginVersion$1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                String j3;
                String h16;
                PluginVersionManager pluginVersionManager = PluginVersionManager.f151646b;
                obj = PluginVersionManager.mVersionLock;
                synchronized (obj) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    String i3 = pluginVersionManager.i(context);
                    if (i3 != null) {
                        linkedHashSet.add(i3);
                    }
                    j3 = pluginVersionManager.j(context);
                    if (j3 != null) {
                        linkedHashSet.add(j3);
                    }
                    h16 = pluginVersionManager.h(context);
                    if (h16 != null) {
                        linkedHashSet.add(h16);
                    }
                    o51.d.f(context, linkedHashSet);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Context context, String latestVersion) {
        p51.d.f425349a.a(context).edit().putString("plugin_version_latest_update", latestVersion).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    private final void q(Context context, String latestVersion) {
        p51.d.f425349a.a(context).edit().putString("plugin_version_latest", latestVersion).commit();
    }

    private final void r(final Context context, final String curVersion, final String uin) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.loader.core.PluginVersionManager$updatePluginAsync$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16 = false;
                String b16 = o51.a.f422110b.b(context, uin, curVersion, false);
                LogUtils.i("PluginVersionManager", "updatePluginAsync: async newVersion:" + b16);
                if (b16 == null || b16.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    PluginVersionManager.f151646b.p(context, b16);
                }
            }
        });
    }

    @SuppressLint({"ApplySharedPref"})
    private final void s(Context context, String version) {
        if (p51.c.e(context)) {
            LogUtils.w("PluginVersionManager", "updateUsingVersion: minibox proc is running");
            return;
        }
        if (p51.c.f425348c.c(context)) {
            LogUtils.i("PluginVersionManager", "updateUsingVersion to " + version);
            p51.e.f425350a.c(context, version);
            return;
        }
        throw new IllegalStateException("Can only be called at MainProcess");
    }

    @WorkerThread
    public final boolean e(@NotNull Context context, @NotNull String uin) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        String j3 = j(context);
        boolean e16 = p51.c.e(context);
        LogUtils.i("PluginVersionManager", "checkPluginReady: MiniBox associated proc running: " + e16);
        if (e16 && m(context, j3)) {
            LogUtils.i("PluginVersionManager", "checkPluginReady: MiniBox plugin ready");
            r(context, j3, uin);
            return true;
        }
        if (e16) {
            p51.c.f(context);
        }
        return l(context, uin);
    }

    public final void f(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        q(context, null);
        o51.d.c(context);
    }

    @Nullable
    public final PluginPathConfig g(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String j3 = j(context);
        if (!m(context, j3)) {
            LogUtils.e("PluginVersionManager", "getCurrentPluginPathConfig: plugin is not ready");
            return null;
        }
        LogUtils.i("PluginVersionManager", "getCurrentPluginPathConfig: use version = " + j3);
        if (j3 == null) {
            Intrinsics.throwNpe();
        }
        return o51.d.d(context, j3);
    }

    @Nullable
    public final String i(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return p51.d.f425349a.a(context).getString("plugin_version_latest", null);
    }
}
