package lg0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.photobrowser.api.IECPhotoBrowser;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JF\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Llg0/a;", "", "", "", "photoUrl", "", "index", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "a", "Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "ecPhotoBrowserProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: b */
    public static final a f414523b = new a();

    /* renamed from: a, reason: from kotlin metadata */
    private static IECPhotoBrowser ecPhotoBrowserProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPhotoBrowser();

    a() {
    }

    public final void a(List<String> photoUrl, int index, HashMap<String, String> params) {
        IECPhotoBrowser iECPhotoBrowser = ecPhotoBrowserProxy;
        if (iECPhotoBrowser != null) {
            iECPhotoBrowser.show(photoUrl, index, params);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, List list, int i3, HashMap hashMap, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            hashMap = null;
        }
        aVar.a(list, i3, hashMap);
    }
}
