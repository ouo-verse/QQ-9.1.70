package md1;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.aio.event.AIOMsgListExtEvent;
import com.tencent.mobileqq.gamecenter.nt.aio.top.GameMsgTopBarEvent;
import com.tencent.mobileqq.gamecenter.nt.aio.top.GameMsgTopBarUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lmd1/b;", "Lcom/tencent/aio/base/mvvm/b;", "", "Lcom/tencent/mobileqq/gamecenter/nt/aio/top/GameMsgTopBarUIState;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends com.tencent.aio.base.mvvm.b<Object, GameMsgTopBarUIState> implements com.tencent.mvi.base.route.a {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof GameMsgTopBarEvent.AddTopView) {
            GameMsgTopBarEvent.AddTopView addTopView = (GameMsgTopBarEvent.AddTopView) i3;
            updateUI(new GameMsgTopBarUIState.AddTopView(addTopView.getPriority(), addTopView.getView(), addTopView.getParams()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListExtEvent.SetTopPadding(addTopView.getParams().height));
        } else if (i3 instanceof GameMsgTopBarEvent.RemoveTopView) {
            updateUI(new GameMsgTopBarUIState.RemoveTopView(((GameMsgTopBarEvent.RemoveTopView) i3).getView()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListExtEvent.SetTopPadding(0));
        }
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        j e16 = context.e();
        String qualifiedName = Reflection.getOrCreateKotlinClass(GameMsgTopBarEvent.AddTopView.class).getQualifiedName();
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(qualifiedName, this, d16);
        j e17 = context.e();
        String qualifiedName2 = Reflection.getOrCreateKotlinClass(GameMsgTopBarEvent.RemoveTopView.class).getQualifiedName();
        LifecycleOwner d17 = context.d();
        Intrinsics.checkNotNullExpressionValue(d17, "context.lifecycleOwner");
        e17.c(qualifiedName2, this, d17);
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        return a.C9235a.a(this);
    }
}
