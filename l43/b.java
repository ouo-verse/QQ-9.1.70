package l43;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.vashealth.x;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Ll43/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof g)) {
            return false;
        }
        g gVar = (g) b16;
        if (gVar.n() != 103 || !TextUtils.equals(IPublicAccountUtil.UIN_FOR_HEALTH, String.valueOf(gVar.l()))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z16 = false;
        if (!(params.b() instanceof g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        g gVar = (g) b16;
        if ((gVar.x().c() == 1 || gVar.x().c() == 3) && gVar.x().b() > 0) {
            z16 = true;
        }
        Context context = params.c().getContext();
        e.f413840a.i(z16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        return x.f(context, (BaseQQAppInterface) peekAppRuntime, 161, z16);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
