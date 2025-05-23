package ka2;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"Lka2/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar == null || gVar.n() != 119) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        View c16 = params.c();
        if (b16 instanceof g) {
            QRouteApi api = QRoute.api(INearbyProPageRouter.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INearbyProPageRouter::class.java)");
            Context context = c16.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            g gVar = (g) b16;
            String str = gVar.s().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
            String e16 = gVar.w().e();
            String str2 = gVar.s().avatarUrl;
            Intrinsics.checkNotNullExpressionValue(str2, "item.originData.avatarUrl");
            INearbyProPageRouter.a.a((INearbyProPageRouter) api, context, str, e16, str2, 19, 0, 32, null);
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
