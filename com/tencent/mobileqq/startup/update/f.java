package com.tencent.mobileqq.startup.update;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qzonehub.api.IQzonePatchApi;
import cooperation.plugin.PluginInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/update/f;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String[] f289873e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/startup/update/f$a;", "", "", "", "DEPENDENCY_PLUGIN", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "KEY_NAME", "Ljava/lang/String;", "SP_NAME", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.update.f$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

        @NotNull
        public final String[] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return f.f289873e;
            }
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61746);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f289873e = new String[]{"qqfav.apk", "expand.apk", "qwallet_plugin.apk", "qqdataline.apk", "qlink_plugin.apk", PluginProxyActivity.READER_ID, "readinjoy_plugin.apk", IQQComicPluginUtil.COMIC_PLUGIN_ID, "QQWifiPlugin.apk", "group_video_plugin.apk", "qqpim_plugin.apk", "qqindividuality_plugin.apk", "qzone_live_video_plugin.apk", IQzonePatchApi.VERTICAL_VIDEO_LAYER_PLUGIN_ID, "huaweistep.apk"};
        }
    }

    public f() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        PluginBaseInfo createFromFile;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = BaseApplicationImpl.sApplication.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("update_plugin_version", 0);
        String string = sharedPreferences.getString("cur_version", "");
        String l3 = AppSetting.l();
        int i3 = 1;
        QLog.d("UpdatePluginVersion", 1, string + ", " + l3);
        if (!Intrinsics.areEqual(l3, string)) {
            File pluginInstallDir = PluginUtils.getPluginInstallDir(applicationContext);
            File dir = applicationContext.getDir("plugin_info", 0);
            int length = f289873e.length;
            for (int i16 = 0; i16 < length; i16++) {
                String str = f289873e[i16];
                File file = new File(pluginInstallDir, str + PluginUtils.CONFIG_FILE_EXTEND_NAME);
                File file2 = new File(pluginInstallDir, str);
                QLog.d("UpdatePluginVersion", i3, "clear start " + str);
                if (!file2.exists() && (createFromFile = PluginBaseInfoHelper.createFromFile(file, PluginInfo.class)) != null && createFromFile.mSubType == i3) {
                    QLog.d("UpdatePluginVersion", 1, "clear shadow plugin " + str + QShadow.getInstance().uninstallPlugin(PluginIdUtil.convertQPluginId2QShadowId(createFromFile.mID)));
                }
                if (file.exists()) {
                    QLog.d("UpdatePluginVersion", 1, "clear cfg" + str + file.delete());
                }
                for (int i17 = 0; file2.exists() && i17 < 3; i17++) {
                    QLog.d("UpdatePluginVersion", 1, "clear plugin" + str + file2.delete());
                }
                File file3 = new File(dir, str + PluginUtils.CONFIG_FILE_EXTEND_NAME);
                if (file3.exists()) {
                    i3 = 1;
                    QLog.d("UpdatePluginVersion", 1, "clear update cfg" + str + file3.delete());
                } else {
                    i3 = 1;
                }
            }
            sharedPreferences.edit().putString("cur_version", l3).commit();
        }
    }
}
