package os0;

import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.guildlive.aio.reserve2.LiveVideoScreenChangeUIState;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveVideoScreenChange;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Los0/b;", "Lpn0/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "j", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends pn0.a<qq0.b, GuildReserve2UIState> {
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildLiveOuterMsgIntent$LiveVideoScreenChange) {
            updateUI(new LiveVideoScreenChangeUIState(((GuildLiveOuterMsgIntent$LiveVideoScreenChange) intent).getVideoScreenState()));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$LiveVideoScreenChange.class).getQualifiedName());
        return listOf;
    }
}
