package l54;

import com.tencent.robot.widget.list.vb.CommonListUIState;
import com.tencent.robot.widget.list.vb.c;
import com.tencent.robot.widget.list.vb.d;
import com.tencent.robot.widget.list.vb.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J=\u0010\u000f\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0012\u0006\b\u0000\u0012\u00020\u00020\u000bj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\u000e0\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001JD\u0010\u0013\u001a6\u00122\u00120\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00100\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00120\n2\u0006\u0010\t\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Ll54/a;", "Lcom/tencent/robot/widget/list/vb/c;", "Lcom/tencent/robot/widget/list/vb/f;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "a", "Lcom/tencent/robot/widget/list/vb/d;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", "b", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements c<f, e<u54.c>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.robot.at.dialog.content.list.mvidelegate.a f413864a = new com.tencent.robot.at.dialog.content.list.mvidelegate.a();

    @Override // com.tencent.robot.widget.list.vb.c
    @NotNull
    public f a(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.f413864a.a(createViewParams);
    }

    @Override // com.tencent.robot.widget.list.vb.c
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<com.tencent.robot.widget.list.vb.a, CommonListUIState, d, ? super f>> b(@NotNull d host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return this.f413864a.b(host);
    }

    @Override // com.tencent.robot.widget.list.vb.c
    @NotNull
    public List<com.tencent.input.base.mvicompat.e<com.tencent.robot.widget.list.vb.a, CommonListUIState, e<u54.c>, com.tencent.robot.widget.list.vb.e>> c(@NotNull com.tencent.robot.widget.list.vb.e host) {
        List<com.tencent.input.base.mvicompat.e<com.tencent.robot.widget.list.vb.a, CommonListUIState, e<u54.c>, com.tencent.robot.widget.list.vb.e>> listOf;
        Intrinsics.checkNotNullParameter(host, "host");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.input.base.mvicompat.e[]{new f64.b(host), new b(host)});
        return listOf;
    }
}
