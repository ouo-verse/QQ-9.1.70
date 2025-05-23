package com.tencent.mobileqq.vas.theme.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.em;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureProcessor;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.theme.SkinEngine;
import com.tencent.util.StringBuilderUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeSwitcherImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitcher;", "", "themeId", "from", "Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitchCallback;", "callback", "", "startSwitch", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ThemeSwitcherImpl implements IThemeSwitcher {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0003J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u001a\u0010\u0014\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\nH\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeSwitcherImpl$a;", "", "", "urlId", "", "args", "e", "url", "extraZipPath", "unzipPath", "Ljava/io/File;", "unzipDir", "", "needSwitch", "d", "scid", "", "errorCode", "", "f", "c", "name", "file", h.F, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/theme/api/impl/ThemeSwitcherImpl$a$a", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDone", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8928a extends f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f310903a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f310904b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ File f310905c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f310906d;

            C8928a(String str, String str2, File file, boolean z16) {
                this.f310903a = str;
                this.f310904b = str2;
                this.f310905c = file;
                this.f310906d = z16;
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onDone(@NotNull g task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.i() != 3) {
                    QLog.d(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon Failed zip not Exist!");
                }
                try {
                    FileUtils.uncompressZip(this.f310903a, this.f310904b, false);
                } catch (Exception e16) {
                    QLog.e(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon:uncompressZip error:", e16);
                }
                AppRuntime createAppRuntime = ThemeUtil.getCreateAppRuntime();
                if (this.f310905c.exists() && createAppRuntime != null && this.f310906d) {
                    createAppRuntime.getApplicationContext().sendBroadcast(new Intent(SkinEngine.ACTION_THEME_UPDATE), "com.tencent.msg.permission.pushnotify");
                    QLog.d(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon:success!");
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean d(String url, String extraZipPath, String unzipPath, File unzipDir, boolean needSwitch) {
            com.tencent.mobileqq.vip.h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(4);
            if (downloader == null) {
                QLog.e(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon downloader == null");
                return true;
            }
            downloader.startDownload(new g(url, new File(extraZipPath)), new C8928a(extraZipPath, unzipPath, unzipDir, needSwitch), null);
            return false;
        }

        private final String e(String urlId, Map<String, String> args) {
            String url = IndividuationUrlHelper.getUrl(urlId);
            if (url != null && args != null) {
                String str = url;
                for (String str2 : args.keySet()) {
                    Intrinsics.checkNotNull(str);
                    Intrinsics.checkNotNull(str2);
                    String str3 = args.get(str2);
                    Intrinsics.checkNotNull(str3);
                    str = StringsKt__StringsJVMKt.replace$default(str, str2, str3, false, 4, (Object) null);
                }
                return str;
            }
            return url;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(String str, String scid, int i3, String str2, String str3) {
            Intrinsics.checkNotNullParameter(scid, "$scid");
            QLog.e(ThemeSwitcher.TAG, 1, "onQueryItemVer: " + i3 + "," + str2 + "," + str3);
            if (i3 == 0) {
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                ThemeLocator themeId = new ThemeLocator().setThemeId(str);
                themeId.init(context, str2, str3);
                ThemeSwitcher.unVideoZipTheme(scid, themeId.getUnzipPath() + "raw");
                ThemeUtil.mAnimateThemeId = null;
            }
        }

        @JvmStatic
        public final boolean c(@Nullable String scid, boolean needSwitch) {
            if (!QVipFeatureProcessor.get().enableDownloadExtraTabIcon) {
                QLog.e(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon: config off");
                return false;
            }
            BaseApplication context = BaseApplication.getContext();
            String themeId = ThemeUtil.getIDFromSCID(scid);
            ThemeLocator init = new ThemeLocator().setThemeId(themeId).init(context, scid, "");
            String encryptFile = FileUtils.encryptFile(init.getZipPath(), KeyPropertiesCompact.DIGEST_MD5);
            if (TextUtils.isEmpty(encryptFile)) {
                QLog.e(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon: fail to get md5");
                return false;
            }
            init.init(context, scid, encryptFile);
            String unzipPath = init.getUnzipPath();
            QLog.d(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon to " + unzipPath);
            try {
                File file = new File(unzipPath);
                if (!file.exists()) {
                    QLog.e(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon:path not exists");
                    return false;
                }
                if (h("skin_tab_icon_1.png", file)) {
                    QLog.d(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon: extra icon already exist");
                    return false;
                }
                HashMap hashMap = new HashMap();
                Intrinsics.checkNotNullExpressionValue(themeId, "themeId");
                hashMap.put("[id]", themeId);
                String e16 = e(IndividuationUrlHelper.UrlId.THEME_PATCH, hashMap);
                if (e16 == null) {
                    QLog.d(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon: url is null");
                    return false;
                }
                ReportInfo.reportEveryDay$default(VasCommonReporter.getHistoryFeature("theme_extra_icon").setValue2(themeId), null, 1, null);
                StringBuilder obtain = StringBuilderUtils.obtain();
                obtain.append(init.getBasePath(context));
                obtain.append(themeId);
                obtain.append(".zip");
                String sb5 = obtain.toString();
                Intrinsics.checkNotNullExpressionValue(sb5, "obtain()\n               \u2026              .toString()");
                return d(e16, sb5, unzipPath, file, needSwitch);
            } catch (Exception e17) {
                QLog.e(ThemeSwitcher.TAG, 1, "downloadExtraTabIcon failed", e17);
                return false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ef  */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void f(@NotNull final String scid, int errorCode) {
            String str;
            boolean startsWith$default;
            ThemeSwitcher.DownloadListenser downloadListenser;
            boolean startsWith$default2;
            boolean startsWith$default3;
            boolean z16;
            boolean contains$default;
            Intrinsics.checkNotNullParameter(scid, "scid");
            QLog.e(ThemeSwitcher.TAG, 1, "onComplete: " + scid + "," + errorCode);
            if (errorCode == 0) {
                String SCID_THEME_ZIP_PREFIX = ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX;
                Intrinsics.checkNotNullExpressionValue(SCID_THEME_ZIP_PREFIX, "SCID_THEME_ZIP_PREFIX");
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(scid, SCID_THEME_ZIP_PREFIX, false, 2, null);
                if (startsWith$default2) {
                    String SCID_THEME_ZIP_PREFIX_VIDEO = ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX_VIDEO;
                    Intrinsics.checkNotNullExpressionValue(SCID_THEME_ZIP_PREFIX_VIDEO, "SCID_THEME_ZIP_PREFIX_VIDEO");
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(scid, SCID_THEME_ZIP_PREFIX_VIDEO, false, 2, null);
                    if (startsWith$default3) {
                        final String iDFromSCID = ThemeUtil.getIDFromSCID(scid);
                        String string = em.b().a().getString("theme_root", "");
                        String cfgScid = ThemeUtil.getThemeConfigID(iDFromSCID);
                        if (!TextUtils.isEmpty(string)) {
                            if (string != null) {
                                Intrinsics.checkNotNullExpressionValue(cfgScid, "cfgScid");
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) cfgScid, false, 2, (Object) null);
                                if (contains$default) {
                                    z16 = true;
                                    if (z16) {
                                        ThemeSwitcher.unVideoZipTheme(scid, string + "raw");
                                        ThemeUtil.mAnimateThemeId = null;
                                    }
                                }
                            }
                            z16 = false;
                            if (z16) {
                            }
                        }
                        QuickUpdateIPCModule.queryItemVersion(3, cfgScid, true, new QueryItemCallback() { // from class: h33.b
                            @Override // com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback
                            public final void onQueryItemVer(int i3, String str2, String str3) {
                                ThemeSwitcherImpl.Companion.g(iDFromSCID, scid, i3, str2, str3);
                            }
                        });
                    } else {
                        str = ThemeSwitcher.unzipTheme(scid, false);
                        if (TextUtils.isEmpty(str)) {
                            VasMonitorDT.reportErrCode("individual_v2_theme_setup_err", ThemeSwitcher.UNZIP_FAIL);
                        } else if (QQTheme.isCustomTheme(ThemeUtil.getIDFromSCID(scid)) || Intrinsics.areEqual("999", ThemeUtil.getIDFromSCID(scid))) {
                            c(scid, ThemeSwitcher.isSwitching());
                            if (ThemeSwitcher.isSwitching()) {
                                ThemeSwitcher themeSwitcher = ThemeSwitcher.sSwitcher;
                                if (themeSwitcher != null && (downloadListenser = themeSwitcher.downloadListenser) != null) {
                                    downloadListenser.onComplete(scid, str, errorCode);
                                    return;
                                }
                                return;
                            }
                            if (errorCode == 0) {
                                String SCID_THEME_ZIP_PREFIX2 = ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX;
                                Intrinsics.checkNotNullExpressionValue(SCID_THEME_ZIP_PREFIX2, "SCID_THEME_ZIP_PREFIX");
                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, SCID_THEME_ZIP_PREFIX2, false, 2, null);
                                if (startsWith$default) {
                                    String iDFromSCID2 = ThemeUtil.getIDFromSCID(scid);
                                    String currentThemeId = ThemeUtil.getCurrentThemeId();
                                    QLog.e(ThemeSwitcher.TAG, 1, "theme update: " + iDFromSCID2 + " engineId: " + currentThemeId);
                                    if (!TextUtils.isEmpty(iDFromSCID2) && Intrinsics.areEqual(iDFromSCID2, currentThemeId)) {
                                        ThemeSwitcher.startSwitch(iDFromSCID2, ThemeReporter.FROM_UPDATE, null);
                                    }
                                    ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, ThemeReporter.FROM_UPDATE, 153, 1, 35, iDFromSCID2, "20000000", ThemeReporter.PATH_DOWNLOAD, "");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (ThemeSwitcher.isSwitching()) {
                        }
                    }
                }
            }
            str = null;
            if (ThemeSwitcher.isSwitching()) {
            }
        }

        @JvmStatic
        public final boolean h(@NotNull String name, @NotNull File file) {
            boolean z16;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(file, "file");
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File f16 : listFiles) {
                    if (f16.isDirectory()) {
                        Intrinsics.checkNotNullExpressionValue(f16, "f");
                        z16 = h(name, f16);
                    } else if (f16.isFile() && Intrinsics.areEqual(f16.getName(), name)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return true;
                    }
                }
            }
            return false;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final boolean downloadExtraTabIcon(@Nullable String str, boolean z16) {
        return INSTANCE.c(str, z16);
    }

    @JvmStatic
    private static final boolean downloadIcon(String str, String str2, String str3, File file, boolean z16) {
        return INSTANCE.d(str, str2, str3, file, z16);
    }

    @JvmStatic
    public static final void onComplete(@NotNull String str, int i3) {
        INSTANCE.f(str, i3);
    }

    @JvmStatic
    public static final boolean searchNameByFile(@NotNull String str, @NotNull File file) {
        return INSTANCE.h(str, file);
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitcher
    public void startSwitch(@NotNull String themeId, @NotNull String from, @NotNull IThemeSwitchCallback callback) {
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThemeSwitcher.startSwitch(themeId, from, callback);
    }
}
