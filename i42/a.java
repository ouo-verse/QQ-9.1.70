package i42;

import android.content.Context;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.az;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002\u001a\b\u0010\f\u001a\u00020\u0002H\u0002\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\"\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Landroid/content/Context;", "context", "", "isAnchor", "", "c", "d", "f", "hasNaviBar", "isShortScreen", "a", "b", "e", "", "", "Ljava/util/List;", "ADAPTION_DEVICE_LIST", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<String> f407183a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f407184b;

    static {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("NOP-AN00", "ABR-AL00");
        f407183a = mutableListOf;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f407184b = (IAegisLogApi) api;
    }

    private static final float a(boolean z16, boolean z17) {
        if (z16 && z17) {
            return 0.6f;
        }
        if (z16) {
            return 0.8f;
        }
        if (z17 || e()) {
            return 0.7f;
        }
        return 1.0f;
    }

    private static final float b(boolean z16, boolean z17) {
        if (z17) {
            return 0.8f;
        }
        return 1.0f;
    }

    public static final float c(@NotNull Context context, boolean z16) {
        float b16;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean d16 = d(context);
        boolean f16 = f(context);
        IAegisLogApi iAegisLogApi = f407184b;
        iAegisLogApi.i("ICGameLiveMessageLayoutAdaption", "isAnchor:" + z16 + ", hasNavigationBar: " + d16 + ", isShortScreen:" + f16);
        if (z16) {
            b16 = a(d16, f16);
        } else {
            b16 = b(d16, f16);
        }
        iAegisLogApi.i("ICGameLiveMessageLayoutAdaption", "proportion:" + b16);
        return b16;
    }

    private static final boolean d(Context context) {
        x.f(context);
        if (!az.e(context) || az.c(context) <= x.b(context, 30.0f)) {
            return false;
        }
        return true;
    }

    private static final boolean e() {
        String model = DeviceInfoMonitor.getModel();
        f407184b.i("ICGameLiveMessageLayoutAdaption", "deviceModel:" + model);
        Iterator<T> it = f407183a.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), model)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean f(Context context) {
        if (x.f(context).f185861b <= 1920) {
            return true;
        }
        return false;
    }
}
