package com.tencent.libra.base.bitmap;

import android.os.Build;
import androidx.annotation.WorkerThread;
import com.bytedance.shadowhook.ShadowHook;
import com.tencent.biz.richframework.delegate.ISoLoadDelegate;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWSoLoad;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0082 J\b\u0010\u0006\u001a\u00020\u0004H\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/libra/base/bitmap/NativeBitmapHelper;", "", "", "c", "", "nInit", "d", "a", "Z", "sHasInit", "<init>", "()V", "libra-native-bitmap_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class NativeBitmapHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean sHasInit;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final NativeBitmapHelper f118624b = new NativeBitmapHelper();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "onLoadResult"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    static final class a implements ISoLoadDelegate.OnLoadListener {

        /* renamed from: a, reason: collision with root package name */
        public static final a f118625a = new a();

        a() {
        }

        @Override // com.tencent.biz.richframework.delegate.ISoLoadDelegate.OnLoadListener
        public final void onLoadResult(boolean z16) {
            NativeBitmapHelper.f118624b.nInit();
            NativeBitmapHelper.sHasInit = true;
            RFWLog.i("NativeBitmapHelper", RFWLog.USR, "[tryInit] success");
        }
    }

    NativeBitmapHelper() {
    }

    private final boolean c() {
        if (Build.VERSION.SDK_INT < 26 && RFWConfig.getConfigValue("enable_jni_bitmap", true)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nInit();

    @WorkerThread
    public final void d() {
        try {
            if (!c()) {
                RFWLog.i("NativeBitmapHelper", RFWLog.USR, "[tryInit] failed! unSupport os version or config false");
                return;
            }
            RFWLog.i("NativeBitmapHelper", RFWLog.USR, "[tryInit] start");
            synchronized (NativeBitmapHelper.class) {
                if (!sHasInit) {
                    ShadowHook.c(new ShadowHook.b().c(ShadowHook.Mode.UNIQUE).a());
                    RFWSoLoad.load("nativebitmap", true, a.f118625a);
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Throwable th5) {
            RFWLog.e("NativeBitmapHelper", RFWLog.USR, "[tryInit] error=" + th5);
        }
    }
}
