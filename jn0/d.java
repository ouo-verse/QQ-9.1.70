package jn0;

import androidx.annotation.CallSuper;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0007*\u0001\u0011\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0017R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ljn0/d;", "Lcom/tencent/aio/api/list/b;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/aio/data/msglist/a;", "data", "", "position", "", "", "payloads", "", "j", "jn0/d$a", "d", "Ljn0/d$a;", "mActionR", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mActionR = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jn0/d$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.mvi.base.route.b {
        a() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return d.this.I(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent i3) {
        return pn0.b.f426490a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.list.b
    @CallSuper
    public void j(@NotNull com.tencent.aio.data.msglist.a data, int position, @NotNull List<Object> payloads) {
        List mutableList;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListCombineEvent(position, data, payloads));
        GuildMultiMsgManager.MultiSelectMode multiSelectMode = new GuildMultiMsgManager.MultiSelectMode(UIUtil.f112434a.y((com.tencent.aio.api.runtime.a) getMContext()));
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) new ArrayList(payloads));
        mutableList.add(multiSelectMode);
        updateUI(new MsgListItemState(data, position, mutableList));
    }
}
