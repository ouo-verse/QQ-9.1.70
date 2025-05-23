package ko;

import android.content.Context;
import android.util.Log;
import com.tencent.biz.richframework.arthook.api.RFWHook;
import com.tencent.biz.richframework.arthook.api.RFWHookConfig;
import com.tencent.biz.richframework.arthook.api.callback.MethodHook;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.util.AppSetting;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lko/a;", "", "", "c", "b", "", "methodTag", "Ljava/lang/reflect/Method;", "method", "a", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f412730a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"ko/a$a", "Lcom/tencent/biz/richframework/arthook/api/callback/MethodHook;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ko.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10672a extends MethodHook {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f412731a;

        C10672a(String str) {
            this.f412731a = str;
        }
    }

    static {
        RFWHookConfig.debug = true;
        RFWHookConfig.debuggable = AppSetting.isDebugVersion();
    }

    a() {
    }

    private final void a(String methodTag, Method method) {
        RFWHook.hook(method, new C10672a(methodTag));
    }

    public final void d() {
        if (AppSetting.isPublicVersion()) {
            return;
        }
        c();
        b();
    }

    private final void b() {
        Method method = DownloaderImpl.class.getDeclaredMethod("download", DownloadRequest.class, Boolean.TYPE);
        Log.d("QZoneHookManager", "hookDownloadManager: " + method);
        Intrinsics.checkNotNullExpressionValue(method, "method");
        a("hookDownloadManager", method);
    }

    private final void c() {
        Method method = ImageLoader.class.getDeclaredMethod("getInstance", new Class[0]);
        Log.d("QZoneHookManager", "hookImageLoader: " + method);
        Intrinsics.checkNotNullExpressionValue(method, "method");
        a(com.nostra13.universalimageloader.core.ImageLoader.TAG, method);
        Method methodWithContext = ImageLoader.class.getDeclaredMethod("getInstance", Context.class);
        Log.d("QZoneHookManager", "hookImageLoaderWithContext: " + methodWithContext);
        Intrinsics.checkNotNullExpressionValue(methodWithContext, "methodWithContext");
        a("ImageLoaderWithContext", methodWithContext);
    }
}
