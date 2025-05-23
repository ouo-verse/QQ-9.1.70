package pm3;

import androidx.lifecycle.ViewModel;
import com.tencent.component.callback.ITimedCallback;
import com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel;
import com.tencent.now.linkpkanchorplay.linkscreen.model.AnchorInPKCtrlModel;
import g55.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lpm3/b;", "Landroidx/lifecycle/ViewModel;", "", "roomId", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/d;", "callback", "", "L1", "Lcom/tencent/now/linkpkanchorplay/linkscreen/model/AnchorInPKCtrlModel;", "i", "Lcom/tencent/now/linkpkanchorplay/linkscreen/model/AnchorInPKCtrlModel;", "anchorInPKModel", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorInPKCtrlModel anchorInPKModel = new AnchorInPKCtrlModel(new InviteDataModel());

    public final void L1(long roomId, @NotNull ITimedCallback<d> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.anchorInPKModel.a(roomId, callback);
    }
}
