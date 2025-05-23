package o51;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.loader.core.PluginPathConfig;
import com.tencent.minibox.loader.core.g;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J*\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0007J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lo51/a;", "", "Landroid/content/Context;", "context", "", "installedVersion", "targetMD5", "", "e", "Lo51/b;", DownloadInfo.spKey_Config, "Ljava/io/File;", "targetFile", "a", "version", "storeFile", "c", "", "f", "uin", "needInstall", "b", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sIsReqUpdate", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f422110b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean sIsReqUpdate = new AtomicBoolean(false);

    a() {
    }

    private final boolean a(RainbowPluginConfig config, File targetFile) {
        try {
            i51.a aVar = i51.a.f407248a;
            String dexDownloadUrl = config.getDexDownloadUrl();
            String absolutePath = targetFile.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "targetFile.absolutePath");
            return aVar.b(dexDownloadUrl, absolutePath);
        } catch (Exception e16) {
            LogUtils.e("NetPluginInstaller", "downloadPluginFile: exception.", e16);
            return false;
        }
    }

    private final boolean c(Context context, String version, File storeFile) {
        PluginPathConfig d16 = d.d(context, version);
        if (!g.e(com.tencent.minibox.loader.core.d.INSTANCE.a(storeFile), d16)) {
            LogUtils.e("NetPluginInstaller", "installPluginInner: install failed.");
            return false;
        }
        m51.d.f416182a.a(new File(d16.getLibPath()));
        f(context);
        m51.a.e(storeFile);
        LogUtils.i("NetPluginInstaller", "installPluginInner: install success! version=" + version);
        return true;
    }

    private final boolean e(Context context, String installedVersion, String targetMD5) {
        return Intrinsics.areEqual(m51.c.f416181a.a(new File(d.d(context, installedVersion).getApkFilePath())), targetMD5);
    }

    @SuppressLint({"ApplySharedPref"})
    private final void f(Context context) {
        p51.d.f425349a.a(context).edit().putLong("minibox_key_update_time", System.currentTimeMillis()).commit();
    }

    @Nullable
    public final String b(@NotNull Context context, @NotNull String uin, @Nullable String installedVersion, boolean needInstall) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        LogUtils.i("NetPluginInstaller", "installPluginFromNet: needInstall:" + needInstall + ", sIsReqUpdate:" + sIsReqUpdate.get());
        if (!needInstall && sIsReqUpdate.get()) {
            LogUtils.i("NetPluginInstaller", "installPluginFromNet: isReqUpdate abort");
            return null;
        }
        if (!needInstall) {
            sIsReqUpdate.compareAndSet(false, true);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (installedVersion != null && installedVersion.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z17 = !z16;
        RainbowPluginConfig a16 = c.f422119a.a(uin);
        LogUtils.i("NetPluginInstaller", "installPluginFromNet: pullConfig cost=" + (System.currentTimeMillis() - currentTimeMillis));
        if (a16 == null) {
            LogUtils.e("NetPluginInstaller", "installPluginFromNet: pullConfig failed. isInstall=" + z17);
            if (!needInstall) {
                sIsReqUpdate.compareAndSet(true, false);
            }
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (z17 && Intrinsics.areEqual(a16.getDexVersion(), installedVersion) && e(context, installedVersion, a16.getDexMD5())) {
            f(context);
            LogUtils.i("NetPluginInstaller", "installPluginFromNet: the same md5, no need download.");
            if (!needInstall) {
                sIsReqUpdate.compareAndSet(true, false);
            }
            return null;
        }
        File file = new File(d.e(context), "minibox.apk");
        boolean a17 = a(a16, file);
        LogUtils.i("NetPluginInstaller", "installPluginFromNet: downloadPluginFile, succeed=" + a17 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis2));
        if (!a17) {
            LogUtils.e("NetPluginInstaller", "installPluginFromNet: download failed.");
            if (!needInstall) {
                sIsReqUpdate.compareAndSet(true, false);
            }
            return null;
        }
        if (needInstall) {
            long currentTimeMillis3 = System.currentTimeMillis();
            boolean c16 = c(context, a16.getDexVersion(), file);
            LogUtils.i("NetPluginInstaller", "installPluginFromNet: install version=" + a16.getDexVersion() + ", succeed=" + c16 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis3));
            if (!c16) {
                return null;
            }
            return a16.getDexVersion();
        }
        sIsReqUpdate.compareAndSet(true, false);
        return a16.getDexVersion();
    }

    public final boolean d(@NotNull Context context, @Nullable String version) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (version != null && version.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean c16 = c(context, version, new File(d.e(context), "minibox.apk"));
        LogUtils.i("NetPluginInstaller", "installStoredPlugin: version=" + version + ", succeed=" + c16 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return c16;
    }
}
