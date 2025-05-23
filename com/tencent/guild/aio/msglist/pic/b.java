package com.tencent.guild.aio.msglist.pic;

import android.view.View;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/pic/b;", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Landroid/view/View;", "imageView", "", "j", "intent", "handleIntent", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void j(MsgRecord msgRecord, PicElement picElement, View imageView) {
        i.c cVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new GuildMsgListIntent.GetAIORichMediaMsgListEvent(msgRecord));
        List<MsgRecord> list = null;
        if (k3 instanceof i.c) {
            cVar = (i.c) k3;
        } else {
            cVar = null;
        }
        UIUtil uIUtil = UIUtil.f112434a;
        if (cVar != null) {
            list = cVar.a();
        }
        uIUtil.C(imageView, msgRecord, picElement, list);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.j) {
            a.j jVar = (a.j) intent;
            j(jVar.getMsgRecord(), jVar.getPicElement(), jVar.getClickedView());
        }
    }
}
