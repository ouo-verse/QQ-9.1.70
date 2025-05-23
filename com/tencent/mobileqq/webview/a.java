package com.tencent.mobileqq.webview;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/webview/a;", "", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<String> f313802b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/webview/a$a;", "", "", "d", "e", "", "a", "Ljava/io/File;", "fileOrDirectory", "c", "b", "", "APP_WEB_VIEW_DIR_KEY", "Ljava/lang/String;", "APP_WEB_VIEW_DIR_NAME", "CHROMIUM_PREFS_NAME", "", "ISSUE_MODELS_TOP5", "Ljava/util/List;", "PRE_APPID_KEY", "TAG", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final void a() {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            int appId = ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getAppId();
            from.encodeInt("pre_appid_key", appId);
            from.commitAsync();
            QLog.i("WebView.AbiCompact", 1, "clearNewlyInstall to=" + appId + " model=" + DeviceInfoMonitor.getModel() + " SDK_INT=" + Build.VERSION.SDK_INT);
        }

        private final void c(@NonNull File fileOrDirectory) {
            if (!fileOrDirectory.exists()) {
                return;
            }
            if (fileOrDirectory.isDirectory()) {
                File[] listFiles = fileOrDirectory.listFiles();
                Intrinsics.checkNotNullExpressionValue(listFiles, "fileOrDirectory.listFiles()");
                for (File file : listFiles) {
                    a.INSTANCE.c(file);
                }
            }
            boolean delete = fileOrDirectory.delete();
            if (QLog.isColorLevel()) {
                QLog.i("WebView.AbiCompact", 2, "deleteRecursive suc=" + delete + " path=" + fileOrDirectory);
            }
        }

        private final boolean d() {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 != 26 && i3 != 27) {
                List list = a.f313802b;
                String MODEL = DeviceInfoMonitor.getModel();
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                String lowerCase = MODEL.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                return list.contains(lowerCase);
            }
            return true;
        }

        private final boolean e() {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            int decodeInt = from.decodeInt("pre_appid_key", 0);
            int appId = ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getAppId();
            if (decodeInt == appId) {
                return false;
            }
            QLog.i("WebView.AbiCompact", 1, "isNewlyInstall pre=" + decodeInt + " cur=" + appId);
            return true;
        }

        public final void b() {
            File dataDir;
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!d()) {
                a();
                return;
            }
            if (!e()) {
                return;
            }
            try {
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                context.getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
                dataDir = context.getDataDir();
                File[] listFiles = dataDir.listFiles();
                Intrinsics.checkNotNullExpressionValue(listFiles, "appContext.dataDir.listFiles()");
                for (File it : listFiles) {
                    String name = it.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    String lowerCase = name.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "webview", false, 2, (Object) null);
                    if (contains$default) {
                        Companion companion = a.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        companion.c(it);
                    }
                }
                a();
            } catch (Throwable th5) {
                QLog.e("WebView.AbiCompact", 1, "deleteAppWebViewCache exception", th5);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39953);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"m1852", "16 x", "oe106", "1801-a01", "de106"});
        f313802b = listOf;
    }
}
