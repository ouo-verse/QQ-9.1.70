package la2;

import android.view.View;
import com.tencent.mobileqq.nearbypro.chats.part.ChatsListInteractiveEntryPart;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.uistate.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lla2/a;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$b;", "viewParams", "", "d0", "e0", "A0", "Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListInteractiveEntryPart;", "a0", "Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListInteractiveEntryPart;", "chatsListInteractiveEntryPart", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mViewModel", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends ChatsListVB {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatsListInteractiveEntryPart chatsListInteractiveEntryPart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.qqnt.chats.core.mvi.a<b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, @NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mViewModel, mBuilder);
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        this.chatsListInteractiveEntryPart = new ChatsListInteractiveEntryPart();
    }

    public final void A0() {
        this.chatsListInteractiveEntryPart.O9();
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void d0(@NotNull ChatsListVB.b viewParams) {
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        super.d0(viewParams);
        View S9 = this.chatsListInteractiveEntryPart.S9(C());
        if (S9 != null) {
            n(S9, 0);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void e0() {
        super.e0();
        this.chatsListInteractiveEntryPart.T9();
    }
}
