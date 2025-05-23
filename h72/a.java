package h72;

import com.tencent.aio.main.businesshelper.b;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lh72/a;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "a", "", "getId", "", "getTag", "state", "onMoveToState", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "<init>", "()V", "e", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    private final void a() {
        j e16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.UpdateRight1IvEvent(false, false, null, 5, null));
    }

    private final void b() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null) {
            if (aVar.g().l().getString("uin", "").equals("144115227025205148")) {
                QLog.i("QQStrangerLittleAssistantHelper", 1, "QQStrangerLittleAssistantHelper user_type is UT_HELPER");
                a();
            } else if (Intrinsics.areEqual(aVar.g().r().c().j(), "144115227025205148")) {
                QLog.i("QQStrangerLittleAssistantHelper", 1, "QQStrangerLittleAssistantHelper peerUid is Little Assistant");
                a();
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350681v1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "QQStrangerLittleAssistantHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAIOContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{1};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 1) {
            b();
        }
    }
}
