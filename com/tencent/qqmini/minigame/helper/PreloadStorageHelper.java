package com.tencent.qqmini.minigame.helper;

import android.content.Context;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/minigame/helper/PreloadStorageHelper;", "", "Landroid/content/Context;", "context", "", "appId", "", "a", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class PreloadStorageHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final PreloadStorageHelper f346468a = new PreloadStorageHelper();

    PreloadStorageHelper() {
    }

    @JvmStatic
    public static final void a(@NotNull Context context, @Nullable final String appId) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        final WeakReference weakReference = new WeakReference(context);
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.helper.PreloadStorageHelper$preload$1
            @Override // java.lang.Runnable
            public final void run() {
                String uin;
                boolean z17;
                Context context2 = (Context) weakReference.get();
                if (context2 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(context2, "ctxRef.get() ?: return@executeOnDiskIOThreadPool");
                    LoginManager loginManager = LoginManager.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(loginManager, "LoginManager.getInstance()");
                    if (loginManager.getAccount() != null) {
                        LoginManager loginManager2 = LoginManager.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(loginManager2, "LoginManager.getInstance()");
                        uin = loginManager2.getAccount();
                    } else {
                        uin = "";
                    }
                    Intrinsics.checkExpressionValueIsNotNull(uin, "uin");
                    if (uin.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        Storage.open(context2, uin, appId);
                    }
                }
            }
        });
    }
}
