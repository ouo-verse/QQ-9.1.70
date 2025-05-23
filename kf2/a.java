package kf2;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.biz.game.api.IECGameApi;
import com.tencent.mobileqq.qqecommerce.biz.game.ECGameUnionButtonContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lkf2/a;", "Lcom/tencent/ecommerce/biz/game/api/IECGameApi;", "Landroid/content/Context;", "context", "", "params", "Landroid/view/View;", "createGameButton", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class a implements IECGameApi {
    @Override // com.tencent.ecommerce.biz.game.api.IECGameApi
    public View createGameButton(Context context, String params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        b bVar = new b();
        bVar.i(params);
        ECGameUnionButtonContainer eCGameUnionButtonContainer = new ECGameUnionButtonContainer(context);
        eCGameUnionButtonContainer.c(bVar);
        return eCGameUnionButtonContainer;
    }
}
