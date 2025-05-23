package com.tencent.mobileqq.ark.base;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    public static QQCustomMenuNoIconLayout a(BubblePopupWindow bubblePopupWindow, Context context, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener) {
        QQCustomMenuItemPriorityHelper.d(aVar);
        QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(context);
        qQCustomMenuNoIconLayout.setGravity(17);
        qQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuNoIconLayout.setPopupWindow(bubblePopupWindow, new a());
        qQCustomMenuNoIconLayout.setMenu(aVar);
        qQCustomMenuNoIconLayout.setMenuIconClickListener(onClickListener);
        qQCustomMenuNoIconLayout.D();
        return qQCustomMenuNoIconLayout;
    }

    public static BubblePopupWindow b(View view, int i3, int i16, int i17, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(a(bubblePopupWindow, view.getContext(), aVar, onClickListener));
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(false);
        bubblePopupWindow.setFocusable(true);
        bubblePopupWindow.setSoftInputMode(1);
        bubblePopupWindow.setInputMethodMode(2);
        bubblePopupWindow.setTouchModal(false);
        bubblePopupWindow.setAnchorOffset(i17);
        bubblePopupWindow.setAnimationStyle(0);
        bubblePopupWindow.showAtLocation(view, i3, i16);
        return bubblePopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements BubblePopupWindow.QQMenuNoIconEmptyInterface {
        a() {
        }

        @Override // com.tencent.widget.BubblePopupWindow.QQMenuNoIconEmptyInterface
        public void onMenuNoIconEmptyClick() {
        }
    }
}
