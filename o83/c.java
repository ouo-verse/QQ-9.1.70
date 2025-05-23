package o83;

import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lo83/c;", "", "", "a", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f422215a = new c();

    c() {
    }

    public final boolean a() {
        List listOf;
        QRouteApi api = QRoute.api(IQCircle571ABTestApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQCircle571ABTestApi::class.java)");
        IQCircle571ABTestApi iQCircle571ABTestApi = (IQCircle571ABTestApi) api;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"exp_qq_shoot_same_video_new_link_new_B", "exp_qq_shoot_same_video_new_link_new_C", "exp_qq_shoot_same_video_new_link_new_D"});
        List list = listOf;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (iQCircle571ABTestApi.isExpHit("exp_qq_shoot_same_video_new_link_new", (String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
