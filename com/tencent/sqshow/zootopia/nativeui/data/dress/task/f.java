package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/f;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lb94/d;", "dressController", "", "i", "", "toString", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "g", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "", "Luv4/az;", tl.h.F, "Ljava/util/List;", "dressList", "Lqu4/a;", "Lqu4/a;", "avatarCharacter", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Ljava/lang/String;Lm94/i;Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;Ljava/util/List;Lqu4/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f extends b {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final UEAvatarGender gender;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<az> dressList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final qu4.a avatarCharacter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(DressTaskChannel dressTaskChannel, String taskId, m94.i callback, UEAvatarGender gender, List<az> dressList, qu4.a avatarCharacter) {
        super(dressTaskChannel, taskId, callback, false, false, 24, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(dressList, "dressList");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        this.gender = gender;
        this.dressList = dressList;
        this.avatarCharacter = avatarCharacter;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        HashMap hashMap = new HashMap();
        for (az azVar : this.dressList) {
            be beVar = azVar.f440290q;
            if (beVar != null) {
                int[] iArr = beVar.f440325b;
                Intrinsics.checkNotNullExpressionValue(iArr, "item.slot.occupancySlots");
                for (int i3 : iArr) {
                    hashMap.put(Integer.valueOf(i3), azVar);
                }
            }
        }
        b.d(this, dressController, new m94.a(this.gender, hashMap, this.avatarCharacter), false, null, 12, null);
    }

    public String toString() {
        return "FullDressUpTask-" + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
    }
}
