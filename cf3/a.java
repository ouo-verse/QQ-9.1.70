package cf3;

import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdSilentHelper;
import com.tencent.mobileqq.zplan.api.UECacheData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ue3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcf3/a;", "Lue3/d;", "Lcom/tencent/mobileqq/zootopia/openid/a;", "", "refreshCache", "", "cacheKey", "c", "doWhenQQLogout", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "a", "", "errCode", "errMsg", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements d, com.tencent.mobileqq.zootopia.openid.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f30778a = new a();

    a() {
    }

    @Override // com.tencent.mobileqq.zootopia.openid.a
    public void a(ZootopiaOpenIdResult result) {
        QLog.e("OpenIdCacheProvider_", 1, "onOpenIdResult result:" + result);
        if (result == null) {
            return;
        }
        UECacheData uECacheData = new UECacheData("OpenId", result.getOpenId(), result.getExpiredTime(), true);
        vb3.a aVar = vb3.a.f441346a;
        ((ue3.b) aVar.b(ue3.b.class)).V(uECacheData.getKey(), uECacheData);
        ((ue3.b) aVar.b(ue3.b.class)).sync();
    }

    @Override // com.tencent.mobileqq.zootopia.openid.a
    public void b(int errCode, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.e("OpenIdCacheProvider_", 1, "onOpenIdError errCode:" + errCode + ", errMsg:" + errMsg);
    }

    @Override // ue3.d
    public void c(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
    }

    @Override // ue3.d
    public void doWhenQQLogout() {
        QLog.i("OpenIdCacheProvider_", 1, "doWhenQQLogout");
    }

    @Override // ue3.d
    public void refreshCache() {
        QLog.i("OpenIdCacheProvider_", 1, "refreshCache");
        ZootopiaOpenIdSilentHelper.i(ZootopiaOpenIdSilentHelper.INSTANCE.a(), this, false, 2, null);
    }
}
