package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\t\b\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/u;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", "t", "Landroid/view/View;", "view", "", UserInfo.SEX_FEMALE, "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class u extends t {
    public u() {
        super(new t.ItemData(R.drawable.qui_position, R.string.f16493276));
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        j().o8();
        ArrayList<MsgElement> arrayList = data.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "data.msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                MsgElement msgElement = (MsgElement) obj;
                if (msgElement.elementType == 7 && msgElement.replyElement != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement2 = (MsgElement) obj;
        if (msgElement2 != null) {
            com.tencent.mvi.base.route.j e16 = h().e();
            Long l3 = msgElement2.replyElement.replayMsgSeq;
            Intrinsics.checkNotNullExpressionValue(l3, "it.replyElement.replayMsgSeq");
            e16.h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("SaveToEmojiMenuItem", l3.longValue()));
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<MsgElement> arrayList = data.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "data.msgRecord.elements");
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgElement) it.next()).elementType == 7) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (B() && z17) {
            return true;
        }
        return false;
    }
}
