package jg3;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.mod.data.ZPlanModRPCData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ux4.c;
import zx4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016R4\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ljg3/a;", "Lzx4/l;", "Lcom/tencent/zplan/mod/data/a;", "msg", "Lux4/c;", "callback", "", "a", "data", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "callbackMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Long, c> callbackMap = new HashMap<>();

    @Override // zx4.l
    public void a(ZPlanModRPCData msg2, c callback) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (callback != null) {
            QLog.d("ZPlanRPCToModProxy", 1, "sendMsg2Mod, cmd: " + msg2.getCmd() + " , timeStamp == " + msg2.getTimeStamp());
            this.callbackMap.put(Long.valueOf(msg2.getTimeStamp()), callback);
        }
        b.f409904a.a(msg2.i());
        kg3.a.f412316a.n(msg2);
    }

    @Override // zx4.l
    public void b(ZPlanModRPCData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("ZPlanRPCToModProxy", 1, "notifyCallBack, data: " + data);
        c cVar = this.callbackMap.get(Long.valueOf(data.getTimeStamp()));
        if (cVar == null) {
            return;
        }
        QLog.d("ZPlanRPCToModProxy", 1, "hand callback, rpcCallback: " + cVar);
        cVar.a(0, "", data.i());
        this.callbackMap.remove(Long.valueOf(data.getTimeStamp()));
    }
}
