package p94;

import b94.d;
import com.tencent.sqshow.zootopia.nativeui.data.c;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.b;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.i;
import qu4.j;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B)\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lp94/a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lb94/d;", "dressController", "", "i", "", "toString", "Lqu4/j;", "g", "Lqu4/j;", "getFaceInfo", "()Lqu4/j;", "faceInfo", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "Lm94/i;", "callback", "", "addToHistory", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Lqu4/j;Lm94/i;Z)V", h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends b {

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicInteger f425808i = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final j faceInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DressTaskChannel dressTaskChannel, j faceInfo, i callback, boolean z16) {
        super(dressTaskChannel, "FaceInfoChangeTask-" + f425808i.getAndIncrement(), callback, z16, false, 16, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(faceInfo, "faceInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.faceInfo = faceInfo;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        m94.a b16 = c.f370920a.m().b();
        qu4.a h16 = bj3.a.h(b16.getAvatarCharacter());
        j jVar = h16.f429573b;
        Intrinsics.checkNotNullExpressionValue(jVar, "newAvatar.faceInfo");
        bj3.a.f(jVar, this.faceInfo);
        b.d(this, dressController, new m94.a(b16.getGender(), b16.b(), h16), false, null, 12, null);
    }

    public String toString() {
        return "FaceInfoChangeTask, " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
    }
}
