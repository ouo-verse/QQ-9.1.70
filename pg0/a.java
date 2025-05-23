package pg0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.publicaccount.api.IECPublicAccountManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lpg0/a;", "", "", "a", "Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "Lcom/tencent/ecommerce/base/publicaccount/api/IECPublicAccountManager;", "publicAccountManager", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f426137b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECPublicAccountManager publicAccountManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPublicAccountManager();

    a() {
    }

    public final void a() {
        cg0.a.b("ECPublicAccountManager", "[openAccountProfilePage]");
        publicAccountManager.openAccountProfilePage();
    }
}
