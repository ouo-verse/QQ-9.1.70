package cooperation.vip.ad.processors;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import cooperation.vip.ad.TianshuSplashManager;
import cooperation.vip.ad.processors.a;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcooperation/vip/ad/processors/TianshuSplashProcessor;", "Lcooperation/vip/ad/processors/a;", "", "time", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "nowTime", "", "c", "", "f", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "mapEntries", "", "traceId", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "i", "e", "onAccountChange", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcooperation/vip/ad/TianshuSplashManager;", "Lkotlin/Lazy;", "k", "()Lcooperation/vip/ad/TianshuSplashManager;", "tianshuSplashManager", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class TianshuSplashProcessor implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tianshuSplashManager;

    public TianshuSplashProcessor() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TianshuSplashManager>() { // from class: cooperation.vip.ad.processors.TianshuSplashProcessor$tianshuSplashManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TianshuSplashManager invoke() {
                return new TianshuSplashManager(cooperation.vip.ad.i.b());
            }
        });
        this.tianshuSplashManager = lazy;
    }

    private final TianshuSplashManager k() {
        return (TianshuSplashManager) this.tianshuSplashManager.getValue();
    }

    @Override // cooperation.vip.ad.processors.a
    public int a() {
        return a.C10126a.h(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void b(int i3) {
        a.C10126a.a(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean c(int nowTime) {
        if (AppSetting.f99565y) {
            return false;
        }
        return a.C10126a.e(this, nowTime);
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public List<TianShuAdPosItemData> d(int time) {
        List<TianShuAdPosItemData> h16 = TianshuSplashManager.h();
        Intrinsics.checkNotNullExpressionValue(h16, "getRequestList()");
        return h16;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] e() {
        return new int[]{4, 1, 3, 2, 99};
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] f() {
        return new int[]{510, 716};
    }

    @Override // cooperation.vip.ad.processors.a
    public void g(long j3) {
        a.C10126a.i(this, j3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean h(int i3) {
        return a.C10126a.d(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public void i(@NotNull TianShuAccess.GetAdsRsp getAdsRsp, @NotNull Map<Integer, TianShuAccess.RspEntry> mapEntries, @NotNull String traceId, int currentTime) {
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        Intrinsics.checkNotNullParameter(mapEntries, "mapEntries");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        k().k(getAdsRsp, String.valueOf(currentTime));
        cooperation.vip.ad.license.g.g().o(5, String.valueOf(currentTime));
    }

    @Override // cooperation.vip.ad.processors.a
    public long j() {
        return a.C10126a.b(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void onAccountChange() {
        a.C10126a.f(this);
        k().l(cooperation.vip.ad.i.b());
    }

    @Override // cooperation.vip.ad.processors.a
    public void onDestroy() {
        a.C10126a.g(this);
        k().m();
    }
}
