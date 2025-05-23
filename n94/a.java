package n94;

import b94.a;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import com.tencent.zplan.luabridge.a;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.i;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Ln94/a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lb94/d;", "dressController", "", "i", "Lm94/a;", "newDressInfo", "Lorg/json/JSONObject;", "clickedItemParam", "Lcom/tencent/zplan/luabridge/a$b;", "cb", "k", "", "toString", "Lqu4/c;", "g", "Lqu4/c;", "getColorInfo", "()Lqu4/c;", "colorInfo", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "Lm94/i;", "callback", "", "addToHistory", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Lqu4/c;Lm94/i;Z)V", h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.tencent.sqshow.zootopia.nativeui.data.dress.task.b {

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicInteger f419532i = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final qu4.c colorInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DressTaskChannel dressTaskChannel, qu4.c colorInfo, i callback, boolean z16) {
        super(dressTaskChannel, "ColorInfoChangeTask-" + f419532i.getAndIncrement(), callback, z16, false, 16, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.colorInfo = colorInfo;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        m94.a b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b();
        qu4.a h16 = bj3.a.h(b16.getAvatarCharacter());
        qu4.c cVar = h16.f429575d;
        Intrinsics.checkNotNullExpressionValue(cVar, "newAvatar.colorInfo");
        bj3.a.e(cVar, this.colorInfo);
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.b.d(this, dressController, new m94.a(b16.getGender(), b16.b(), h16), false, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void k(m94.a newDressInfo, JSONObject clickedItemParam, a.b cb5) {
        Intrinsics.checkNotNullParameter(newDressInfo, "newDressInfo");
        b94.a engineApi = getDressTaskChannel().getEngineApi();
        if ((engineApi != null ? engineApi.getType() : null) == AvatarEngineType.UE) {
            super.k(newDressInfo, clickedItemParam, cb5);
            return;
        }
        b94.a engineApi2 = getDressTaskChannel().getEngineApi();
        if (engineApi2 != null) {
            a.C0113a.l(engineApi2, newDressInfo.getAvatarCharacter(), null, 2, null);
        }
    }

    public String toString() {
        return "ColorInfoChangeTask, " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() + ", colorInfo:" + r94.c.j(this.colorInfo);
    }
}
