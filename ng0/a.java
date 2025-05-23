package ng0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.preload.api.IECImagePreloadManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lng0/a;", "", "", "url", "", "a", "", "urlList", "b", "Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "imagePreloadManager", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f420126b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECImagePreloadManager imagePreloadManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImagePreloadManager();

    a() {
    }

    public final void a(String url) {
        cg0.a.b("ECImagePreloadManager", "[preloadImage] url = " + url);
        imagePreloadManager.preloadImage(url);
    }

    public final void b(List<String> urlList) {
        Iterator<String> it = urlList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
