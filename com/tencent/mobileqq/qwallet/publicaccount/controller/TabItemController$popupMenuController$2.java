package com.tencent.mobileqq.qwallet.publicaccount.controller;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.qwallet.publicaccount.conf.TabItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/qwallet/publicaccount/controller/PopMenuController;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class TabItemController$popupMenuController$2 extends Lambda implements Function0<PopMenuController> {
    final /* synthetic */ TabItemController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabItemController$popupMenuController$2(TabItemController tabItemController) {
        super(0);
        this.this$0 = tabItemController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final TabItemController this$0) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view = this$0.itemView;
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.publicaccount.controller.g
            @Override // java.lang.Runnable
            public final void run() {
                TabItemController$popupMenuController$2.d(TabItemController.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TabItemController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final PopMenuController invoke() {
        View view;
        TabItem tabItem;
        view = this.this$0.itemView;
        Context context = view.getContext();
        tabItem = this.this$0.tabItem;
        PopMenuController popMenuController = new PopMenuController(context, tabItem.getSheetList());
        final TabItemController tabItemController = this.this$0;
        popMenuController.h(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.qwallet.publicaccount.controller.f
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                TabItemController$popupMenuController$2.c(TabItemController.this);
            }
        });
        return popMenuController;
    }
}
