package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static QQCustomMenuLayout a(BubblePopupWindow bubblePopupWindow, Context context, c cVar, View.OnClickListener onClickListener) {
        QQCustomMenuLayout qQCustomMenuLayout = new QQCustomMenuLayout(context);
        qQCustomMenuLayout.setGravity(17);
        qQCustomMenuLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuLayout.setPopupWindow(bubblePopupWindow);
        qQCustomMenuLayout.setMenuList(cVar);
        qQCustomMenuLayout.setMenuIconClickListener(onClickListener);
        qQCustomMenuLayout.h();
        return qQCustomMenuLayout;
    }

    public static QQCustomMenuLayout b(BubblePopupWindow bubblePopupWindow, Context context, c cVar, View.OnClickListener onClickListener, rb0.b bVar) {
        QQCustomMenuLayout qQCustomMenuLayout = new QQCustomMenuLayout(context);
        qQCustomMenuLayout.setGravity(17);
        qQCustomMenuLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuLayout.setPopupWindow(bubblePopupWindow);
        qQCustomMenuLayout.setMenuList(cVar);
        qQCustomMenuLayout.setMenuIconClickListener(onClickListener);
        qQCustomMenuLayout.setMenuContainerStyle(bVar);
        qQCustomMenuLayout.h();
        return qQCustomMenuLayout;
    }

    public static BubblePopupWindow c(View view, c cVar, View.OnClickListener onClickListener, BubblePopupWindow.c cVar2) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.E(a(bubblePopupWindow, view.getContext(), cVar, onClickListener));
        bubblePopupWindow.H(cVar2);
        bubblePopupWindow.D(new ColorDrawable(0));
        bubblePopupWindow.I(true);
        bubblePopupWindow.F(true);
        bubblePopupWindow.L(view);
        return bubblePopupWindow;
    }
}
