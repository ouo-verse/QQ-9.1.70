package n94;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import m94.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Ln94/b;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lm94/a;", "l", "Lb94/d;", "dressController", "", "i", "", "g", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "targetSlot", "", h.F, "Ljava/lang/String;", "taskName", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;ILjava/lang/String;Lm94/i;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class b extends com.tencent.sqshow.zootopia.nativeui.data.dress.task.b {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f419535j = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int targetSlot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String taskName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(DressTaskChannel dressTaskChannel, int i3, String taskName, i callback) {
        super(dressTaskChannel, taskName + "-" + f419535j.getAndIncrement(), callback, false, false, 24, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.targetSlot = i3;
        this.taskName = taskName;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        qu4.d dVar;
        qu4.d dVar2;
        int indexOf;
        List mutableList;
        List mutableList2;
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        m94.a b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b();
        m94.a l3 = l();
        qu4.c i3 = bj3.a.i(b16.getAvatarCharacter().f429575d);
        qu4.d[] dVarArr = l3.getAvatarCharacter().f429575d.f429581b;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "targetColorInfo.slotArr");
        int length = dVarArr.length;
        int i16 = 0;
        while (true) {
            dVar = null;
            if (i16 >= length) {
                dVar2 = null;
                break;
            }
            dVar2 = dVarArr[i16];
            if (dVar2.f429583a == this.targetSlot) {
                break;
            } else {
                i16++;
            }
        }
        qu4.d[] dVarArr2 = i3.f429581b;
        Intrinsics.checkNotNullExpressionValue(dVarArr2, "newColorInfo.slotArr");
        int length2 = dVarArr2.length;
        int i17 = 0;
        while (true) {
            if (i17 >= length2) {
                break;
            }
            qu4.d dVar3 = dVarArr2[i17];
            if (dVar3.f429583a == this.targetSlot) {
                dVar = dVar3;
                break;
            }
            i17++;
        }
        if (dVar2 == null) {
            QLog.e("ResetColorInfoBaseTask", 1, "targetColorSlotInfo is null, targetSlot:" + this.targetSlot);
        }
        qu4.d[] dVarArr3 = i3.f429581b;
        Intrinsics.checkNotNullExpressionValue(dVarArr3, "newColorInfo.slotArr");
        indexOf = ArraysKt___ArraysKt.indexOf(dVarArr3, dVar);
        QLog.e("ResetColorInfoBaseTask", 1, "currentColorSlotInfoIndex " + indexOf + ", targetSlot:" + this.targetSlot);
        if (indexOf < 0) {
            if (dVar2 == null) {
                com.tencent.sqshow.zootopia.nativeui.data.dress.task.b.d(this, dressController, b16, false, null, 8, null);
                return;
            }
            qu4.d[] dVarArr4 = i3.f429581b;
            Intrinsics.checkNotNullExpressionValue(dVarArr4, "newColorInfo.slotArr");
            mutableList2 = ArraysKt___ArraysKt.toMutableList(dVarArr4);
            mutableList2.add(dVar2);
            Object[] array = mutableList2.toArray(new qu4.d[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            i3.f429581b = (qu4.d[]) array;
        } else if (dVar2 == null) {
            qu4.d[] dVarArr5 = i3.f429581b;
            Intrinsics.checkNotNullExpressionValue(dVarArr5, "newColorInfo.slotArr");
            mutableList = ArraysKt___ArraysKt.toMutableList(dVarArr5);
            mutableList.remove(dVar);
            Object[] array2 = mutableList.toArray(new qu4.d[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            i3.f429581b = (qu4.d[]) array2;
        } else {
            i3.f429581b[indexOf] = dVar2;
        }
        qu4.a h16 = bj3.a.h(b16.getAvatarCharacter());
        h16.f429575d = i3;
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.b.d(this, dressController, new m94.a(b16.getGender(), b16.b(), h16), false, null, 12, null);
    }

    public abstract m94.a l();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m, reason: from getter */
    public final int getTargetSlot() {
        return this.targetSlot;
    }
}
