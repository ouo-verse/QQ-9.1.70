package com.tencent.qqnt.chats.biz.notifyservice;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BQ\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012,\b\u0002\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R8\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chats/biz/notifyservice/d;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$b;", "viewParams", "", "d0", "Lcom/tencent/qqnt/chats/core/uievent/b;", "uiEvent", "b", "Lkotlin/Function2;", "Landroid/content/Context;", "Ljava/util/ArrayList;", "Lcom/tencent/widget/PopupMenuDialog$MenuItem;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/widget/PopupMenuDialog;", "a0", "Lkotlin/jvm/functions/Function2;", "uiCreator", "Landroid/view/ViewGroup;", "b0", "Landroid/view/ViewGroup;", "listViewContainer", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mViewModel", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;Lkotlin/jvm/functions/Function2;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends ChatsListVB {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function2<Context, ArrayList<PopupMenuDialog.MenuItem>, PopupMenuDialog> uiCreator;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup listViewContainer;

    public /* synthetic */ d(com.tencent.qqnt.chats.core.mvi.a aVar, com.tencent.qqnt.chats.core.data.a aVar2, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, aVar2, (i3 & 4) != 0 ? null : function2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, aVar2, function2, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB, com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    public void b(@NotNull com.tencent.qqnt.chats.core.uievent.b uiEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uiEvent);
        } else {
            Intrinsics.checkNotNullParameter(uiEvent, "uiEvent");
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void d0(@NotNull ChatsListVB.b viewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewParams);
            return;
        }
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        super.d0(viewParams);
        this.listViewContainer = viewParams.c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, @NotNull com.tencent.qqnt.chats.core.data.a mBuilder, @Nullable Function2<? super Context, ? super ArrayList<PopupMenuDialog.MenuItem>, ? extends PopupMenuDialog> function2) {
        super(mViewModel, mBuilder);
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.uiCreator = function2;
        } else {
            iPatchRedirector.redirect((short) 1, this, mViewModel, mBuilder, function2);
        }
    }
}
