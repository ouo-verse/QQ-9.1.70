package com.tencent.mobileqq.qqshop.publicaccount.menu;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/PopMenuController;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class MenuItemController$popupMenuController$2 extends Lambda implements Function0<PopMenuController> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MenuItemController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemController$popupMenuController$2(MenuItemController menuItemController) {
        super(0);
        this.this$0 = menuItemController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) menuItemController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final MenuItemController this$0) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view = this$0.itemView;
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.c
            @Override // java.lang.Runnable
            public final void run() {
                MenuItemController$popupMenuController$2.d(MenuItemController.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MenuItemController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final PopMenuController invoke() {
        View view;
        MenuItem menuItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PopMenuController) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        view = this.this$0.itemView;
        Context context = view.getContext();
        menuItem = this.this$0.tabItem;
        PopMenuController popMenuController = new PopMenuController(context, menuItem.getSheetList());
        final MenuItemController menuItemController = this.this$0;
        popMenuController.h(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.b
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                MenuItemController$popupMenuController$2.c(MenuItemController.this);
            }
        });
        return popMenuController;
    }
}
