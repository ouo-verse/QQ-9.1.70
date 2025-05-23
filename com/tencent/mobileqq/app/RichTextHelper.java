package com.tencent.mobileqq.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RichTextHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RichTextHelper";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class MyClickableSpan extends ClickableSpan {
        static IPatchRedirector $redirector_ = null;
        private static final int MIN_CLICK_DURATION = 500;
        boolean isLink;
        boolean isPressed;
        long lastClickTime;
        private int linkNormalColor;
        private int linkPressedColor;
        View.OnClickListener listener;
        private int plainNormalColor;
        String url;
        boolean useExternalBrowser;

        public MyClickableSpan(Context context, RichTextData richTextData, boolean z16, SpanColors spanColors) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, richTextData, Boolean.valueOf(z16), spanColors);
                return;
            }
            this.isPressed = false;
            this.lastClickTime = 0L;
            this.url = richTextData.url;
            this.useExternalBrowser = z16;
            this.listener = richTextData.onClickListener;
            this.isLink = richTextData.isLink;
            if (spanColors != null) {
                this.plainNormalColor = spanColors.plainNormalColor;
                this.linkNormalColor = spanColors.linkNormalColor;
                this.linkPressedColor = spanColors.linkPressedColor;
                return;
            }
            initDefaultColor(context);
        }

        private void initDefaultColor(Context context) {
            this.plainNormalColor = context.getResources().getColor(R.color.qui_common_text_secondary);
            this.linkNormalColor = context.getResources().getColor(R.color.qui_common_text_link);
            this.linkPressedColor = context.getResources().getColor(R.color.qui_common_text_link_pressed);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.lastClickTime + 500 >= currentTimeMillis) {
                return;
            }
            this.lastClickTime = currentTimeMillis;
            View.OnClickListener onClickListener = this.listener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (!TextUtils.isEmpty(this.url)) {
                if (this.useExternalBrowser) {
                    try {
                        view.getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(this.url)));
                        return;
                    } catch (ActivityNotFoundException e16) {
                        QLog.d(RichTextHelper.TAG, 1, "no system browser exp=", e16);
                        return;
                    }
                }
                try {
                    Intent intent = new Intent();
                    intent.putExtra("url", this.url);
                    RouteUtils.startActivity(view.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
                } catch (Exception e17) {
                    QLog.d(RichTextHelper.TAG, 1, "startActivity error:", e17);
                }
            }
        }

        public void setPressed(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
            } else if (this.isPressed != z16) {
                this.isPressed = z16;
                view.invalidate();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            if (this.isLink) {
                if (this.isPressed) {
                    i3 = this.linkPressedColor;
                } else {
                    i3 = this.linkNormalColor;
                }
                textPaint.setColor(i3);
                return;
            }
            textPaint.setColor(this.plainNormalColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class MyLinkMovementMethod extends LinkMovementMethod {
        static IPatchRedirector $redirector_ = null;
        private static final int CLICKABLE_PADDING = 20;
        private static final MyLinkMovementMethod INSTANCE;
        private MyClickableSpan mLastPressedSpan;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46503);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                INSTANCE = new MyLinkMovementMethod();
            }
        }

        MyLinkMovementMethod() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private MyClickableSpan[] getMyClickableSpans(Spannable spannable, int i3, int i16, Layout layout) {
            QLog.d(RichTextHelper.TAG, 2, "x = " + i3 + ",y = " + i16 + ",layout = " + layout.getWidth() + ", " + layout.getHeight());
            if (i3 > -20 && i3 < layout.getWidth() + 20 && i16 > -20 && i16 < layout.getHeight() + 20) {
                int lineForVertical = layout.getLineForVertical(i16);
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i3);
                QLog.d(RichTextHelper.TAG, 2, "line = " + lineForVertical + ",off = " + offsetForHorizontal);
                return (MyClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, MyClickableSpan.class);
            }
            return new MyClickableSpan[0];
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            MyClickableSpan myClickableSpan;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, spannable, motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action == 1 || action == 0 || action == 3) {
                MyClickableSpan[] myClickableSpans = getMyClickableSpans(spannable, (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX(), (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY(), textView.getLayout());
                if (myClickableSpans.length != 0) {
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 3 && (myClickableSpan = this.mLastPressedSpan) != null) {
                                myClickableSpan.setPressed(textView, false);
                                this.mLastPressedSpan = null;
                            }
                        } else {
                            MyClickableSpan myClickableSpan2 = this.mLastPressedSpan;
                            if (myClickableSpan2 != null) {
                                myClickableSpan2.setPressed(textView, false);
                                MyClickableSpan myClickableSpan3 = this.mLastPressedSpan;
                                if (myClickableSpan3 == myClickableSpans[0]) {
                                    myClickableSpan3.onClick(textView);
                                }
                                this.mLastPressedSpan = null;
                            }
                        }
                    } else {
                        myClickableSpans[0].setPressed(textView, true);
                        this.mLastPressedSpan = myClickableSpans[0];
                    }
                    return true;
                }
                MyClickableSpan myClickableSpan4 = this.mLastPressedSpan;
                if (myClickableSpan4 != null) {
                    myClickableSpan4.setPressed(textView, false);
                    this.mLastPressedSpan = null;
                    return true;
                }
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SpanColors {
        static IPatchRedirector $redirector_;
        public int linkNormalColor;
        public int linkPressedColor;
        public int plainNormalColor;

        public SpanColors(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.plainNormalColor = i3;
            this.linkNormalColor = i16;
            this.linkPressedColor = i17;
        }
    }

    public RichTextHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SpannableString buildSpannable(String str, Context context, boolean z16, List<RichTextData> list) {
        return buildSpannable(str, context, z16, list, null);
    }

    public static MovementMethod getMovementMethodInstance() {
        return MyLinkMovementMethod.INSTANCE;
    }

    public static SpannableString buildSpannable(String str, Context context, boolean z16, List<RichTextData> list, SpanColors spanColors) {
        SpannableString spannableString = new SpannableString(str);
        for (RichTextData richTextData : list) {
            int indexOf = str.indexOf(richTextData.text);
            while (indexOf >= 0 && indexOf < str.length()) {
                spannableString.setSpan(new MyClickableSpan(context, richTextData, z16, spanColors), indexOf, richTextData.text.length() + indexOf, 17);
                indexOf = str.indexOf(richTextData.text, indexOf + 1);
            }
        }
        return spannableString;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class RichTextData {
        static IPatchRedirector $redirector_;
        boolean isLink;
        View.OnClickListener onClickListener;
        String text;
        String url;

        public RichTextData(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                return;
            }
            this.onClickListener = null;
            this.isLink = false;
            this.text = str;
            this.url = str2;
            this.isLink = !TextUtils.isEmpty(str2);
        }

        public RichTextData(String str, String str2, View.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, onClickListener);
                return;
            }
            this.isLink = false;
            this.text = str;
            this.url = str2;
            this.onClickListener = onClickListener;
            this.isLink = !TextUtils.isEmpty(str2);
        }

        public RichTextData(String str, View.OnClickListener onClickListener, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, onClickListener, Boolean.valueOf(z16));
                return;
            }
            this.url = null;
            this.text = str;
            this.onClickListener = onClickListener;
            this.isLink = z16;
        }
    }
}
