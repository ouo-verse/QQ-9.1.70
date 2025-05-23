package com.tencent.mobileqq.profilecard.base.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LongClickCopyAction implements View.OnLongClickListener, View.OnClickListener, BubblePopupWindow.OnDismissListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LongClickCopyAction";
    private ICopyListener mCopyListener;
    private LongClickCopyData mData;
    private int mEnd;
    private BackgroundColorSpan mSpan;
    private int mStart;
    private View mTarget;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface ICopyListener {
        void onCopyContent(String str);

        void onDismiss();

        void onShowCopyMenu();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class ToastCopyListener implements ICopyListener {
        static IPatchRedirector $redirector_;
        private Context context;
        private int tipsResId;

        public ToastCopyListener(Context context, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            } else {
                this.context = context;
                this.tipsResId = i3;
            }
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onCopyContent(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                QQToast.makeText(this.context, 2, this.tipsResId, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onShowCopyMenu() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    LongClickCopyAction(View view, LongClickCopyData longClickCopyData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) longClickCopyData);
            return;
        }
        this.mTarget = view;
        this.mData = longClickCopyData;
        this.mStart = -1;
        this.mEnd = -1;
    }

    public static LongClickCopyAction attachCopyAction(TextView textView) {
        String str;
        String str2;
        if (textView != null) {
            str = textView.getResources().getString(R.string.f203254zp);
            str2 = textView.getText().toString();
        } else {
            str = null;
            str2 = null;
        }
        LongClickCopyData longClickCopyData = new LongClickCopyData();
        longClickCopyData.addCopyItem(str, str2);
        return attachCopyAction(textView, longClickCopyData);
    }

    private void copyContent(String str) {
        if (str != null) {
            try {
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (mobileQQ != null) {
                    ClipboardMonitor.setText((ClipboardManager) mobileQQ.getSystemService("clipboard"), str);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 2, "copyContent fail.", e16);
            }
        }
    }

    private QQCustomMenuNoIconLayout createContent(BubblePopupWindow bubblePopupWindow, Context context, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener) {
        QQCustomMenuItemPriorityHelper.d(aVar);
        QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(context);
        qQCustomMenuNoIconLayout.setGravity(17);
        qQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuNoIconLayout.setPopupWindow(bubblePopupWindow, null);
        qQCustomMenuNoIconLayout.setMenu(aVar);
        qQCustomMenuNoIconLayout.setMenuIconClickListener(onClickListener);
        qQCustomMenuNoIconLayout.D();
        return qQCustomMenuNoIconLayout;
    }

    private BubblePopupWindow showAsDropDown(View view, com.tencent.mobileqq.utils.dialogutils.a aVar, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(createContent(bubblePopupWindow, view.getContext(), aVar, onClickListener));
        bubblePopupWindow.setOnDismissListener(onDismissListener);
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(true);
        bubblePopupWindow.showAsDropDown(view);
        return bubblePopupWindow;
    }

    public void cleanCopyContent(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) textView);
            return;
        }
        Spannable spannable = textView.getText() instanceof Spannable ? (Spannable) textView.getText() : null;
        if (spannable != null) {
            spannable.removeSpan(this.mSpan);
        }
    }

    public void markTextViewCopyContent(TextView textView) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) textView);
            return;
        }
        int length = textView.getText().toString().length();
        Spannable spannable = textView.getText() instanceof Spannable ? (Spannable) textView.getText() : null;
        if (spannable != null) {
            if (this.mSpan == null) {
                try {
                    i3 = Color.parseColor(GameCenterVideoViewController.GRAY_MASK);
                } catch (Exception unused) {
                    i3 = 1714664933;
                }
                this.mSpan = new BackgroundColorSpan(i3);
            }
            spannable.setSpan(this.mSpan, 0, length, 17);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            if (view instanceof TextView) {
                str = this.mData.getCopyContent(((TextView) view).getText().toString());
            } else {
                str = null;
            }
            QLog.d(TAG, 1, String.format("onClick view=%s copyResult=%s time:%s", view, str, Long.valueOf(System.currentTimeMillis())));
            if (!TextUtils.isEmpty(str)) {
                copyContent(str);
                ICopyListener iCopyListener = this.mCopyListener;
                if (iCopyListener != null) {
                    iCopyListener.onCopyContent(str);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        View view = this.mTarget;
        if (view instanceof TextView) {
            cleanCopyContent();
            ICopyListener iCopyListener = this.mCopyListener;
            if (iCopyListener != null) {
                iCopyListener.onDismiss();
                return;
            }
            return;
        }
        if (view != null) {
            view.setSelected(false);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view)).booleanValue();
        } else {
            if (this.mData != null) {
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                this.mData.attachToMenu(aVar);
                View view2 = this.mTarget;
                if (view2 instanceof TextView) {
                    markTextViewCopyContent();
                } else if (view2 != null) {
                    view2.setSelected(true);
                }
                showAsDropDown(view, aVar, this, this);
                ICopyListener iCopyListener = this.mCopyListener;
                if (iCopyListener != null) {
                    iCopyListener.onShowCopyMenu();
                }
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    public void setCopyListener(ICopyListener iCopyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iCopyListener);
        } else {
            this.mCopyListener = iCopyListener;
        }
    }

    public void setCopyViewPosition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mStart = i3;
            this.mEnd = i16;
        }
    }

    private void cleanCopyContent() {
        View view = this.mTarget;
        if (view == null || !(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        Spannable spannable = textView.getText() instanceof Spannable ? (Spannable) textView.getText() : null;
        if (spannable != null) {
            spannable.removeSpan(this.mSpan);
        }
    }

    public static LongClickCopyAction attachCopyAction(TextView textView, String str) {
        String charSequence = textView != null ? textView.getText().toString() : null;
        LongClickCopyData longClickCopyData = new LongClickCopyData();
        longClickCopyData.addCopyItem(str, charSequence);
        return attachCopyAction(textView, longClickCopyData);
    }

    private void markTextViewCopyContent() {
        int i3;
        View view = this.mTarget;
        if (view == null || !(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        String charSequence = textView.getText().toString();
        int max = Math.max(this.mStart, 0);
        int i16 = this.mEnd;
        if (i16 < 0) {
            i16 = charSequence.length();
        }
        int min = Math.min(i16, charSequence.length());
        Spannable spannable = textView.getText() instanceof Spannable ? (Spannable) textView.getText() : null;
        if (spannable != null) {
            if (this.mSpan == null) {
                try {
                    i3 = Color.parseColor(GameCenterVideoViewController.GRAY_MASK);
                } catch (Exception unused) {
                    i3 = 1714664933;
                }
                this.mSpan = new BackgroundColorSpan(i3);
            }
            spannable.setSpan(this.mSpan, max, min, 17);
        }
    }

    public static LongClickCopyAction attachCopyAction(View view, String str, String str2) {
        LongClickCopyData longClickCopyData = new LongClickCopyData();
        longClickCopyData.addCopyItem(str, str2);
        return attachCopyAction(view, longClickCopyData);
    }

    public static LongClickCopyAction attachCopyAction(View view, LongClickCopyData longClickCopyData) {
        if (view == null) {
            return null;
        }
        LongClickCopyAction longClickCopyAction = new LongClickCopyAction(view, longClickCopyData);
        view.setOnLongClickListener(longClickCopyAction);
        if (!(view instanceof TextView)) {
            return longClickCopyAction;
        }
        TextView textView = (TextView) view;
        textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
        return longClickCopyAction;
    }
}
