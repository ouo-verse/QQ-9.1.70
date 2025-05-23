package bf2;

import android.text.TextUtils;
import com.tencent.ecommerce.base.preload.api.IECImagePreloadManager;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lbf2/a;", "Lcom/tencent/ecommerce/base/preload/api/IECImagePreloadManager;", "", "url", "", "preloadImage", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements IECImagePreloadManager {
    @Override // com.tencent.ecommerce.base.preload.api.IECImagePreloadManager
    public void preloadImage(String url) {
        URL url2;
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i("ECImagePreloadManager", 1, "[preloadImage] url = " + url);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            url2 = new URL(url);
        } catch (MalformedURLException e16) {
            QLog.e("ECImagePreloadManager", 1, "[preloadImage] e = " + e16);
            url2 = null;
        }
        if (url2 != null) {
            b bVar = new b();
            bVar.f239004a = url2;
            bVar.f239008e = true;
            ((IImageManager) QRoute.api(IImageManager.class)).loadImage(bVar, null);
            QLog.i("ECImagePreloadManager", 1, "[preloadImage] finished, url = " + url);
        }
    }
}
