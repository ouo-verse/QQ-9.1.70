package com.tencent.mobileqq.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;

/* compiled from: P */
/* loaded from: classes20.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f307814a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements BubblePopupWindow.QQMenuNoIconEmptyInterface {
        a() {
        }

        @Override // com.tencent.widget.BubblePopupWindow.QQMenuNoIconEmptyInterface
        public void onMenuNoIconEmptyClick() {
            if (com.tencent.qqnt.selectable.a.C().isSelected()) {
                com.tencent.qqnt.selectable.a.C().z();
            }
        }
    }

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

    public static BubblePopupWindow c(View view, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(a(bubblePopupWindow, view.getContext(), aVar, onClickListener));
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(true);
        bubblePopupWindow.showAsDropDown(view);
        return bubblePopupWindow;
    }

    public static BubblePopupWindow d(View view, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(a(bubblePopupWindow, view.getContext(), aVar, onClickListener));
        bubblePopupWindow.setOnDismissListener(onDismissListener);
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(true);
        bubblePopupWindow.showAsDropDown(view);
        return bubblePopupWindow;
    }

    public static BubblePopupWindow e(View view, int i3, int i16, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener, Integer num) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        QQCustomMenuNoIconLayout a16 = a(bubblePopupWindow, view.getContext(), aVar, onClickListener);
        a16.setIgnoreTouchLocation(true);
        a16.setContainerBottom(num);
        bubblePopupWindow.setContentView(a16);
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(true);
        bubblePopupWindow.setSoftInputMode(1);
        bubblePopupWindow.setInputMethodMode(2);
        int[] k3 = CommonMenuWrapper.k(view);
        bubblePopupWindow.showAtLocation(view, i3, i16, true, k3[0], k3[1]);
        return bubblePopupWindow;
    }
}
