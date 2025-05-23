package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/v;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", "t", "Landroid/view/View;", "view", "", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "g", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "getItemData", "()Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", tl.h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class v extends t {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final t.ItemData itemData;

    public v() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("MultiSelectActionItem", 4, "onItemClick");
        String str = data.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.channelId");
        GuildMultiMsgManager.INSTANCE.a().b(new GuildMultiMsgManager.d(str, com.tencent.guild.aio.util.ex.a.d(h())), data);
        h().e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("MultiSelectActionItem", true));
        j().o8();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.isWalletMsg()) {
            return false;
        }
        return super.a(data);
    }

    public /* synthetic */ v(t.ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.qui_tick_circle, R.string.f16494277) : itemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        this.itemData = itemData;
    }
}
