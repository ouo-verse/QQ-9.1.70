package a34;

import a34.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.j;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.aio.share.RobotSessionShareParams;
import com.tencent.robot.aio.share.event.RobotMultiShareMsgFromBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"La34/d;", "Lcom/tencent/aio/base/mvvm/b;", "La34/a;", "", "La34/a$a;", "intent", "", "l", "La34/a$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends com.tencent.aio.base.mvvm.b<a, Object> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void l(a.C0009a intent) {
        j e16;
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(RobotMultiShareMsgFromBar.OnShareCancel.f367343d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(a.OnShareItemClick intent) {
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null) {
            String friendUinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUinFromUid(aVar.g().r().c().j());
            int i3 = intent.getItem().action;
            String str = intent.getItem().uin;
            if (str == null) {
                str = "";
            }
            RobotSessionShareParams robotSessionShareParams = new RobotSessionShareParams(i3, str, intent.getItem().uinType, friendUinFromUid, 0, 16, null);
            j e16 = aVar.e();
            if (e16 != null) {
                e16.h(new RobotMultiShareMsgFromBar.OnShareClick(robotSessionShareParams));
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.OnShareItemClick) {
            m((a.OnShareItemClick) intent);
        } else if (intent instanceof a.C0009a) {
            l((a.C0009a) intent);
        }
    }
}
