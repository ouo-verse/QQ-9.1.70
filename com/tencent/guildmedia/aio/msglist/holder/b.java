package com.tencent.guildmedia.aio.msglist.holder;

import android.view.View;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.component.combinestyle.t;
import com.tencent.guild.aio.msglist.holder.config.c;
import com.tencent.guild.aio.msglist.holder.config.d;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildmedia.widget.GuildMediaMsgItemRelativeLayout;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/holder/b;", "Lcom/tencent/guild/aio/component/combinestyle/t;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "e1", "", "l1", "Landroid/view/View;", "itemView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends t {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView, @NotNull d componentProvider, @NotNull c factoryProvider, int i3) {
        super(itemView, componentProvider, factoryProvider, i3);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
    }

    @Override // com.tencent.guild.aio.component.combinestyle.t
    public void e1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.e1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            z16 = UIUtil.f112434a.z(payloads);
        } else {
            z16 = false;
        }
        if (getItemView() instanceof GuildMediaMsgItemRelativeLayout) {
            View itemView = getItemView();
            Intrinsics.checkNotNull(itemView, "null cannot be cast to non-null type com.tencent.guildmedia.widget.GuildMediaMsgItemRelativeLayout");
            ((GuildMediaMsgItemRelativeLayout) itemView).setMultiSelectState(z16);
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.t
    public boolean l1() {
        String str;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null) {
            str = g16.n();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, com.tencent.guildmedia.aio.factory.b.class.getName());
    }
}
