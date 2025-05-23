package m20;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.qqcircle.beans.QFSAIOFeedShareInitBean;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.logic.b;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lm20/a;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final C10759a f416028a = new C10759a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lm20/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: m20.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C10759a {
        public /* synthetic */ C10759a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        C10759a() {
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(@NotNull com.tencent.qqnt.pluspanel.data.a data, @NotNull com.tencent.aio.api.runtime.a context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        AIOSession r16 = context.g().r();
        int e16 = r16.c().e();
        String j3 = r16.c().j();
        if (r16.c().e() != 2) {
            j3 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(j3);
            Intrinsics.checkNotNullExpressionValue(j3, "api(IRelationNTUinAndUid\u2026a).getUinFromUid(peerUid)");
        }
        if (j3 != null && j3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QFSShareOnClickProcessor", 1, " uin in null");
            return;
        }
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        c.m(requireActivity, new QFSAIOFeedShareInitBean(j3, e16, "c2c"));
    }
}
