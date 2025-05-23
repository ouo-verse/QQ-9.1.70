package com.tencent.guild.aio.msglist.graytips.common;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.guild.aio.msglist.graytips.common.GuildCommonGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.common.b;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/d;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lol3/b;", "intent", "", "handleIntent", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Landroid/graphics/drawable/Drawable$Callback;", "drawableCallback", "Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "", "isRebuild", "l", "d", "Lcom/tencent/aio/data/msglist/a;", "mMsgItem", "e", "Landroid/os/Bundle;", "defaultExtraParams", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.data.msglist.a mMsgItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle defaultExtraParams = new Bundle();

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            b.a aVar = (b.a) intent;
            l(aVar.getMsgItem(), aVar.getDrawableCallback(), aVar.getBundle(), false);
        } else if (intent instanceof b.C1196b) {
            com.tencent.aio.data.msglist.a aVar2 = this.mMsgItem;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgItem");
                aVar2 = null;
            }
            l(aVar2, ((b.C1196b) intent).getDrawableCallback(), this.defaultExtraParams, true);
        }
    }

    public final void l(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull Drawable.Callback drawableCallback, @NotNull Bundle extraParams, boolean isRebuild) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(drawableCallback, "drawableCallback");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        this.mMsgItem = msgItem;
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(8);
        if (firstTypeElement != null && firstTypeElement.grayTipElement != null) {
            charSequence = a.f111330a.b(guildMsgItem, drawableCallback, extraParams, isRebuild);
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        updateUI(new GuildCommonGrayTipsUIState.SetGrayTipsText(charSequence, isRebuild));
    }
}
