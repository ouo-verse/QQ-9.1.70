package com.tencent.minibox.loader.core;

import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import com.tencent.minibox.common.log.LogUtils;
import java.io.File;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/minibox/loader/core/h;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "dest", "", "a", "b", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f151669a = new h();

    h() {
    }

    private final void a(Context context, File dest) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                ResourcesManager.getInstance().appendLibAssetForMainAssetPath(context.getApplicationInfo().publicSourceDir, dest.getAbsolutePath());
            }
        } catch (Exception e16) {
            LogUtils.e("ResourceHook", "initResource: ResourcesManager call failed --->", e16);
        }
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        PluginPathConfig g16 = PluginVersionManager.f151646b.g(context);
        if (g16 != null) {
            File file = new File(g16.getApkFilePath());
            a(context, file);
            try {
                Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
                Resources resources = n51.b.b().getResources();
                Intrinsics.checkExpressionValueIsNotNull(resources, "MiniBoxProcess.getAppContext().resources");
                declaredMethod.invoke(resources.getAssets(), file.getAbsolutePath());
                LogUtils.d("ResourceHook", "initResource: success.");
            } catch (Exception e16) {
                LogUtils.e("ResourceHook", "initResource: failed --->", e16);
            }
        }
    }
}
