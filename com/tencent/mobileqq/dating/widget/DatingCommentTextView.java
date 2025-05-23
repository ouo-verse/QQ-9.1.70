package com.tencent.mobileqq.dating.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DatingCommentTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f203446d;

    /* renamed from: e, reason: collision with root package name */
    private int f203447e;

    /* renamed from: f, reason: collision with root package name */
    private ClickableSpan f203448f;

    public DatingCommentTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f203446d = -1;
        this.f203447e = -1;
        setFocusable(false);
    }

    @Override // android.view.View
    @ViewDebug.ExportedProperty(category = WSPublicAccReport.SOP_NAME_FOCUS)
    public boolean hasFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        try {
            int actionMasked = motionEvent.getActionMasked();
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int totalPaddingLeft = x16 - getTotalPaddingLeft();
            int totalPaddingTop = y16 - getTotalPaddingTop();
            int scrollX = totalPaddingLeft + getScrollX();
            int scrollY = totalPaddingTop + getScrollY();
            Layout layout = getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            CharSequence text = getText();
            if (!TextUtils.isEmpty(text) && (text instanceof Spannable)) {
                Spannable spannable = (Spannable) getText();
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr != null && clickableSpanArr.length != 0) {
                    if (actionMasked == 0) {
                        ClickableSpan clickableSpan = clickableSpanArr[0];
                        this.f203448f = clickableSpan;
                        this.f203446d = spannable.getSpanStart(clickableSpan);
                        int spanEnd = spannable.getSpanEnd(clickableSpanArr[0]);
                        this.f203447e = spanEnd;
                        int i3 = this.f203446d;
                        if (i3 >= 0 && spanEnd >= i3) {
                            ClickableSpan clickableSpan2 = clickableSpanArr[0];
                            if (clickableSpan2 instanceof a) {
                                ((a) clickableSpan2).a(true);
                            } else {
                                spannable.setSpan(new BackgroundColorSpan(Color.parseColor("#d5d5d5")), this.f203446d, this.f203447e, 33);
                            }
                        }
                    } else if (actionMasked == 1 || actionMasked == 3) {
                        this.f203448f = null;
                        int i16 = this.f203446d;
                        if (i16 >= 0 && this.f203447e >= i16) {
                            ClickableSpan clickableSpan3 = clickableSpanArr[0];
                            if (clickableSpan3 instanceof a) {
                                ((a) clickableSpan3).a(false);
                            } else {
                                spannable.setSpan(new BackgroundColorSpan(0), this.f203446d, this.f203447e, 33);
                            }
                            Selection.removeSelection(spannable);
                            this.f203446d = -1;
                            this.f203447e = -1;
                        }
                    }
                    return true;
                }
                int i17 = this.f203446d;
                if (i17 >= 0 && this.f203447e >= i17) {
                    ClickableSpan clickableSpan4 = this.f203448f;
                    if (clickableSpan4 != null && (clickableSpan4 instanceof a)) {
                        ((a) clickableSpan4).a(false);
                        this.f203448f = null;
                    } else {
                        spannable.setSpan(new BackgroundColorSpan(0), this.f203446d, this.f203447e, 33);
                    }
                    Selection.removeSelection(spannable);
                    this.f203446d = -1;
                    this.f203447e = -1;
                }
                return false;
            }
            return onTouchEvent;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
            }
            return onTouchEvent;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends ClickableSpan implements BlockableEditTextView.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f203449d;

        /* renamed from: e, reason: collision with root package name */
        private ColorStateList f203450e;

        /* renamed from: f, reason: collision with root package name */
        private ColorStateList f203451f;

        /* renamed from: h, reason: collision with root package name */
        private View.OnClickListener f203452h;

        public a(View.OnClickListener onClickListener, ColorStateList colorStateList, ColorStateList colorStateList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, onClickListener, colorStateList, colorStateList2);
                return;
            }
            this.f203452h = onClickListener;
            this.f203450e = colorStateList;
            this.f203451f = colorStateList2;
        }

        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.f203449d = z16;
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
                return;
            }
            View.OnClickListener onClickListener = this.f203452h;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int colorForState;
            int colorForState2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) textPaint);
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            ColorStateList colorStateList = this.f203450e;
            if (colorStateList != null) {
                if (this.f203449d) {
                    colorForState2 = colorStateList.getColorForState(new int[]{R.attr.state_pressed}, 0);
                } else {
                    colorForState2 = colorStateList.getColorForState(new int[0], 0);
                }
                textPaint.setColor(colorForState2);
            } else {
                textPaint.setColor(-16777216);
            }
            ColorStateList colorStateList2 = this.f203451f;
            if (colorStateList2 != null) {
                if (this.f203449d) {
                    colorForState = colorStateList2.getColorForState(new int[]{R.attr.state_pressed}, 0);
                } else {
                    colorForState = colorStateList2.getColorForState(new int[0], 0);
                }
                textPaint.bgColor = colorForState;
                return;
            }
            textPaint.bgColor = 0;
        }

        public a(View.OnClickListener onClickListener, ColorStateList colorStateList) {
            this(onClickListener, colorStateList, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onClickListener, (Object) colorStateList);
        }

        public a(View.OnClickListener onClickListener, int i3) {
            this(onClickListener, ColorStateList.valueOf(i3), null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onClickListener, i3);
        }
    }

    public DatingCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f203446d = -1;
        this.f203447e = -1;
        setFocusable(false);
    }
}
