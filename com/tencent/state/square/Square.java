package com.tencent.state.square;

import android.app.Application;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.mmkv.MMKVMigrate;
import com.tencent.state.square.avatar.filament.FilamentZipFileUtils;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.interaction.InteractionManager;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u0004J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/Square;", "", "()V", "TAG", "", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "callback", "Lcom/tencent/state/square/SquareCallback;", "getCallback", "()Lcom/tencent/state/square/SquareCallback;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/state/square/SquareCallback;)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/SquareConfig;", "getConfig", "()Lcom/tencent/state/square/SquareConfig;", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkDirExists", "", "getAvatarFile", "resource", "Lcom/tencent/state/square/data/Resource;", "type", "", "getAvatarRootDir", "Ljava/io/File;", "isDefault", "", "getCommonUtilsClassName", "initialize", "isSquareConfigInvalid", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class Square {
    private static final String TAG = "Square_Square";
    public static final Square INSTANCE = new Square();
    private static SquareCallback callback = new DefaultSquareCallback();
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    Square() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDirExists(SquareConfig config) {
        if (config.getRootCacheDir().exists()) {
            return;
        }
        config.getRootCacheDir().mkdirs();
    }

    public final Application getApplication() {
        return SquareBase.INSTANCE.getApp();
    }

    public final String getAvatarFile(Resource resource, int type) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        String absolutePath = getAvatarRootDir(resource.getIsDefault()).getAbsolutePath();
        if (type == 1) {
            return absolutePath + File.separator + resource.getKey() + ".png";
        }
        if (type != 2) {
            return absolutePath + File.separator + resource.getActionId() + util.base64_pad_url + resource.getKey();
        }
        return absolutePath + File.separator + resource.getActionId() + util.base64_pad_url + resource.getKey() + ".mp4";
    }

    public final SquareCallback getCallback() {
        return callback;
    }

    public final String getCommonUtilsClassName() {
        String name = getConfig().getCommonUtils().getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "config.commonUtils.javaClass.name");
        return name;
    }

    public final SquareConfig getConfig() {
        return SquareBase.INSTANCE.getConfig();
    }

    public final boolean initialize(final SquareConfig config, SquareCallback callback2) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        if (!isInitialized.compareAndSet(false, true)) {
            return false;
        }
        callback = callback2;
        SquareBase.INSTANCE.initialize(config);
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.Square$initialize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                new MMKVMigrate().migrateVasFileToDovFile();
                Square.INSTANCE.checkDirExists(SquareConfig.this);
                InteractionManager.INSTANCE.init();
                FilamentZipFileUtils.INSTANCE.init();
            }
        });
        return true;
    }

    public final boolean isSquareConfigInvalid() {
        return (getConfig().getLogger() instanceof DefaultSquareLogger) || (getConfig().getCommonUtils() instanceof DefaultUtils);
    }

    public final void setCallback(SquareCallback squareCallback) {
        Intrinsics.checkNotNullParameter(squareCallback, "<set-?>");
        callback = squareCallback;
    }

    private final File getAvatarRootDir(boolean isDefault) {
        if (isDefault) {
            return SquareBase.INSTANCE.getAvatarDefaultDir();
        }
        return SquareBase.INSTANCE.getAvatarCacheDir();
    }

    public static /* synthetic */ boolean initialize$default(Square square, SquareConfig squareConfig, SquareCallback squareCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            squareCallback = new DefaultSquareCallback();
        }
        return square.initialize(squareConfig, squareCallback);
    }

    static /* synthetic */ File getAvatarRootDir$default(Square square, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return square.getAvatarRootDir(z16);
    }
}
