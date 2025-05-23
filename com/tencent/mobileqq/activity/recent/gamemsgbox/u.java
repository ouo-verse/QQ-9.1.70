package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.ChatsListAdapter;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.uievent.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/u;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "Lcom/tencent/qqnt/chats/core/uievent/b;", "uiEvent", "", "b", "Lcom/tencent/qqnt/chats/core/data/a;", "builder", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "view", "A0", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mViewModel", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class u extends ChatsListVB {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, @NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mViewModel, mBuilder);
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mViewModel, (Object) mBuilder);
        }
    }

    public final void A0(@Nullable View view) {
        je1.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        ChatsListAdapter s16 = s();
        if (s16 instanceof je1.a) {
            aVar = (je1.a) s16;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.i1(view);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB, com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    public void b(@NotNull com.tencent.qqnt.chats.core.uievent.b uiEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uiEvent);
            return;
        }
        Intrinsics.checkNotNullParameter(uiEvent, "uiEvent");
        if (uiEvent instanceof a.f) {
            return;
        }
        super.b(uiEvent);
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    @NotNull
    public ChatsListAdapter q(@NotNull com.tencent.qqnt.chats.core.data.a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ChatsListAdapter) iPatchRedirector.redirect((short) 3, (Object) this, (Object) builder);
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((IGameMsgCardApi) QRoute.api(IGameMsgCardApi.class)).createGameBoxChatsListAdapter(builder);
    }
}
