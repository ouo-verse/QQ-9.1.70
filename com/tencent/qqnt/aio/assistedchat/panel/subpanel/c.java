package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelGuideView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/c;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/f;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "l", "o", "Lkotlin/Function1;", "", "E", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "p", "(Lkotlin/jvm/functions/Function1;)V", "onClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
final class c extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super CharSequence, Unit> onClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(new AssistedChatPolishPanelGuideView(context, null, 0, 6, null));
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.f
    public void l(@NotNull e item, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, position);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelGuideView");
        AssistedChatPolishPanelGuideView assistedChatPolishPanelGuideView = (AssistedChatPolishPanelGuideView) view;
        assistedChatPolishPanelGuideView.s();
        assistedChatPolishPanelGuideView.setOnItemClickListener(this.onClickListener);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelGuideView");
        ((AssistedChatPolishPanelGuideView) view).h();
    }

    public final void p(@Nullable Function1<? super CharSequence, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function1);
        } else {
            this.onClickListener = function1;
        }
    }
}
