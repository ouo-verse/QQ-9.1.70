package com.tencent.qqnt.chats.core.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.core.adapter.menu.creator.c;
import com.tencent.widget.BubblePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010 \u001a\u00020\r\u0012\u001e\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00120!\u00a2\u0006\u0004\bA\u0010BJ0\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J2\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002R\u0017\u0010 \u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR/\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00120!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010:\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/e;", "", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/utils/dialogutils/a;", "menu", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/widget/BubblePopupWindow$OnDismissListener;", "onDismissListener", "Lcom/tencent/widget/BubblePopupWindow;", DomainData.DOMAIN_NAME, "popup", "Landroid/content/Context;", "ctx", "listener", "Lcom/tencent/mobileqq/utils/dialogutils/QQCustomMenuNoIconLayout;", "e", "", "g", "", "j", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", com.tencent.luggage.wxa.c8.c.G, "itemView", "k", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lkotlin/Function3;", "b", "Lkotlin/jvm/functions/Function3;", "getMenuClick", "()Lkotlin/jvm/functions/Function3;", "menuClick", "c", "Lcom/tencent/widget/BubblePopupWindow;", "getCurBubble", "()Lcom/tencent/widget/BubblePopupWindow;", "setCurBubble", "(Lcom/tencent/widget/BubblePopupWindow;)V", "curBubble", "d", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "i", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "setBindDataItem", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;)V", "bindDataItem", "I", tl.h.F, "()I", "setBindDataIndex", "(I)V", "bindDataIndex", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "f", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollListener", "Landroid/view/View;", "anchorView", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function3;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<Integer, com.tencent.qqnt.chats.core.adapter.itemdata.b, Integer, Unit> menuClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BubblePopupWindow curBubble;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.adapter.itemdata.b bindDataItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int bindDataIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewTreeObserver.OnScrollChangedListener scrollListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View anchorView;

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull Context context, @NotNull Function3<? super Integer, ? super com.tencent.qqnt.chats.core.adapter.itemdata.b, ? super Integer, Unit> menuClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menuClick, "menuClick");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) menuClick);
            return;
        }
        this.context = context;
        this.menuClick = menuClick;
        this.bindDataIndex = -1;
    }

    private final QQCustomMenuNoIconLayout e(BubblePopupWindow popup, Context ctx, com.tencent.mobileqq.utils.dialogutils.a menu, View.OnClickListener listener) {
        QQCustomMenuItemPriorityHelper.d(menu);
        QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(ctx);
        qQCustomMenuNoIconLayout.setGravity(17);
        qQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuNoIconLayout.setPopupWindow(popup, new BubblePopupWindow.QQMenuNoIconEmptyInterface() { // from class: com.tencent.qqnt.chats.core.ui.d
            @Override // com.tencent.widget.BubblePopupWindow.QQMenuNoIconEmptyInterface
            public final void onMenuNoIconEmptyClick() {
                e.f();
            }
        });
        qQCustomMenuNoIconLayout.setMenu(menu);
        qQCustomMenuNoIconLayout.setMenuIconClickListener(listener);
        qQCustomMenuNoIconLayout.D();
        return qQCustomMenuNoIconLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(List items, e this$0, int i3, com.tencent.qqnt.chats.core.adapter.itemdata.b item, View view) {
        int c16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        int id5 = view.getId();
        c.Companion companion = com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE;
        int i16 = companion.i(((com.tencent.qqnt.chats.core.adapter.menu.a) items.get(id5)).f());
        com.tencent.qqnt.chats.core.adapter.menu.a aVar = (com.tencent.qqnt.chats.core.adapter.menu.a) items.get(id5);
        if (i16 != -1) {
            c16 = companion.i(aVar.f());
        } else {
            c16 = aVar.c();
        }
        this$0.menuClick.invoke(Integer.valueOf(i3), item, Integer.valueOf(c16));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        itemView.setSelected(false);
    }

    private final BubblePopupWindow n(View view, com.tencent.mobileqq.utils.dialogutils.a menu, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(e(bubblePopupWindow, view.getContext(), menu, onClickListener));
        bubblePopupWindow.setOnDismissListener(onDismissListener);
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(true);
        bubblePopupWindow.showAsDropDown(view);
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.tencent.qqnt.chats.core.ui.c
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                e.o(e.this);
            }
        };
        this.scrollListener = onScrollChangedListener;
        this.anchorView = view;
        view.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        return bubblePopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isDebugVersion()) {
            QLog.d("BubbleMenu", 1, "[OnScrollChangedListener] change is call");
        }
        this$0.g();
    }

    public final void g() {
        View view;
        ViewTreeObserver viewTreeObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.curBubble;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
        }
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.scrollListener;
        if (onScrollChangedListener != null && (view = this.anchorView) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
        }
        this.anchorView = null;
        this.scrollListener = null;
        this.curBubble = null;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.bindDataIndex;
    }

    @Nullable
    public final com.tencent.qqnt.chats.core.adapter.itemdata.b i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.chats.core.adapter.itemdata.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.bindDataItem;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        BubblePopupWindow bubblePopupWindow = this.curBubble;
        if (bubblePopupWindow != null) {
            return bubblePopupWindow.isShowing();
        }
        return false;
    }

    public final void k(@NotNull final com.tencent.qqnt.chats.core.adapter.itemdata.b item, final int pos, @NotNull final View itemView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, item, Integer.valueOf(pos), itemView);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        final List<com.tencent.qqnt.chats.core.adapter.menu.a> a16 = item.a();
        List<com.tencent.qqnt.chats.core.adapter.menu.a> list = a16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.bindDataItem = item;
        this.bindDataIndex = pos;
        com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
        for (Object obj : a16) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.chats.core.adapter.menu.a aVar2 = (com.tencent.qqnt.chats.core.adapter.menu.a) obj;
            if (aVar2.e() != null) {
                Context context = this.context;
                Integer e16 = aVar2.e();
                Intrinsics.checkNotNull(e16);
                aVar.a(i3, context.getString(e16.intValue()));
            } else {
                c.Companion companion = com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE;
                if (companion.r(aVar2.f()) != -1) {
                    aVar.a(i3, this.context.getString(companion.r(aVar2.f())));
                } else {
                    aVar.a(i3, aVar2.d());
                }
            }
            i3 = i16;
        }
        this.curBubble = n(itemView, aVar, new View.OnClickListener() { // from class: com.tencent.qqnt.chats.core.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.l(a16, this, pos, item, view);
            }
        }, new BubblePopupWindow.OnDismissListener() { // from class: com.tencent.qqnt.chats.core.ui.b
            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public final void onDismiss() {
                e.m(itemView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
    }
}
