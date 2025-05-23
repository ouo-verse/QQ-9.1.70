package com.tencent.qqnt.chats.biz.troophelper;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.troophelper.f;
import com.tencent.qqnt.chats.biz.troophelper.g;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.widget.ActionSheet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chats/biz/troophelper/c;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "Lcom/tencent/qqnt/chats/biz/troophelper/f;", "uiEvent", "", "B0", "C0", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$b;", "viewParams", "d0", "Lcom/tencent/qqnt/chats/core/uievent/b;", "b", "Lcom/tencent/qqnt/chats/core/uistate/b;", "uiState", "N", "", "a0", "Z", "mIsTop", "Landroid/view/ViewGroup;", "b0", "Landroid/view/ViewGroup;", "listViewContainer", "Landroid/view/View;", "c0", "Landroid/view/View;", "troopTitleTips", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mViewModel", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends ChatsListVB {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsTop;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup listViewContainer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View troopTitleTips;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, @NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mViewModel, mBuilder);
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mViewModel, (Object) mBuilder);
        }
    }

    private final void B0(f uiEvent) {
        if (uiEvent instanceof f.b) {
            C0();
            return;
        }
        if (uiEvent instanceof f.a) {
            boolean a16 = ((f.a) uiEvent).a();
            this.mIsTop = a16;
            QLog.d("TroopHelperChatVB", 1, "onTopStateChange: " + a16);
        }
    }

    private final void C0() {
        final ActionSheet create = ActionSheet.create(C());
        if (this.mIsTop) {
            create.addButton(C().getString(R.string.zj_));
        } else {
            create.addButton(C().getString(R.string.zld));
        }
        create.addButton(C().getString(R.string.zlp));
        create.addCancelButton(C().getString(R.string.cancel));
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chats.biz.troophelper.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                c.D0(c.this, create, view, i3);
            }
        });
        try {
            create.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(c this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.e(g.a.f354427a);
            }
        } else {
            this$0.e(g.b.f354428a);
        }
        actionSheet.dismiss();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r4.isEmpty() == true) goto L20;
     */
    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB, com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(@NotNull com.tencent.qqnt.chats.core.uistate.b uiState) {
        a.b bVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uiState);
            return;
        }
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        super.c(uiState);
        if (uiState instanceof a.b) {
            bVar = (a.b) uiState;
        } else {
            bVar = null;
        }
        if (bVar != null && (r4 = bVar.d()) != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            View view = this.troopTitleTips;
            if (view != null) {
                view.setVisibility(4);
                return;
            }
            return;
        }
        View view2 = this.troopTitleTips;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB, com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    public void b(@NotNull com.tencent.qqnt.chats.core.uievent.b uiEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uiEvent);
            return;
        }
        Intrinsics.checkNotNullParameter(uiEvent, "uiEvent");
        if (uiEvent instanceof f) {
            B0((f) uiEvent);
        } else if ((uiEvent instanceof a.f) && !ChatsListConfig.f354433a.j()) {
            QLog.d("TroopHelperChatVB", 1, "EnableListAnim is disable.");
        } else {
            super.b(uiEvent);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void d0(@NotNull ChatsListVB.b viewParams) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewParams);
            return;
        }
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        super.d0(viewParams);
        QUIBadgeDragLayout c16 = viewParams.c();
        this.listViewContainer = c16;
        if (c16 != null) {
            view = c16.findViewById(R.id.f1038361o);
        } else {
            view = null;
        }
        this.troopTitleTips = view;
    }
}
