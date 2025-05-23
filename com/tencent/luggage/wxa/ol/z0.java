package com.tencent.luggage.wxa.ol;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class z0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements NoCopySpan {

        /* renamed from: a, reason: collision with root package name */
        public float f137000a;

        /* renamed from: b, reason: collision with root package name */
        public float f137001b;

        /* renamed from: c, reason: collision with root package name */
        public int f137002c;

        /* renamed from: d, reason: collision with root package name */
        public int f137003d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f137004e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f137005f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f137006g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f137007h;

        public a(float f16, float f17, int i3, int i16) {
            this.f137000a = f16;
            this.f137001b = f17;
            this.f137002c = i3;
            this.f137003d = i16;
        }
    }

    public static void a(TextView textView, Layout layout, int i3, int i16) {
        int i17;
        int width = textView.getWidth() - (textView.getTotalPaddingLeft() + textView.getTotalPaddingRight());
        int lineForVertical = layout.getLineForVertical(i16);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(lineForVertical);
        int paragraphDirection = layout.getParagraphDirection(lineForVertical);
        int i18 = 0;
        boolean z16 = paragraphDirection > 0;
        int i19 = width + 0;
        if (i19 < width) {
            if (paragraphAlignment == Layout.Alignment.ALIGN_CENTER) {
                i17 = (width - i19) / 2;
            } else if ((z16 && paragraphAlignment == Layout.Alignment.ALIGN_OPPOSITE) || (!z16 && paragraphAlignment == Layout.Alignment.ALIGN_NORMAL)) {
                i17 = width - i19;
            }
            i18 = 0 - i17;
        } else {
            i18 = Math.max(Math.min(i3, width - width), 0);
        }
        textView.scrollTo(i18, i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r0 != 3) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        float x16;
        float f16;
        float y16;
        if (!textView.canScrollVertically(-1) && !textView.canScrollVertically(1)) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    a[] aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
                    if (aVarArr.length > 0) {
                        if (!aVarArr[0].f137004e) {
                            float scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                            if (Math.abs(motionEvent.getX() - aVarArr[0].f137000a) >= scaledTouchSlop || Math.abs(motionEvent.getY() - aVarArr[0].f137001b) >= scaledTouchSlop) {
                                aVarArr[0].f137004e = true;
                            }
                        }
                        a aVar = aVarArr[0];
                        if (aVar.f137004e) {
                            aVar.f137005f = true;
                            if (((motionEvent.getMetaState() & 1) == 0 && MetaKeyKeyListener.getMetaState(spannable, 1) != 1 && MetaKeyKeyListener.getMetaState(spannable, 2048) == 0) ? false : true) {
                                x16 = motionEvent.getX() - aVarArr[0].f137000a;
                                f16 = motionEvent.getY();
                                y16 = aVarArr[0].f137001b;
                            } else {
                                x16 = aVarArr[0].f137000a - motionEvent.getX();
                                f16 = aVarArr[0].f137001b;
                                y16 = motionEvent.getY();
                            }
                            float f17 = f16 - y16;
                            aVarArr[0].f137000a = motionEvent.getX();
                            aVarArr[0].f137001b = motionEvent.getY();
                            a aVar2 = aVarArr[0];
                            if (aVar2.f137007h) {
                                aVar2.f137007h = false;
                                aVar2.f137004e = false;
                                return false;
                            }
                            int scrollX = textView.getScrollX() + ((int) x16);
                            int scrollY = textView.getScrollY() + ((int) f17);
                            int totalPaddingTop = textView.getTotalPaddingTop() + textView.getTotalPaddingBottom();
                            Layout layout = textView.getLayout();
                            int max = Math.max(Math.min(scrollY, layout.getHeight() - (textView.getHeight() - totalPaddingTop)), 0);
                            int scrollX2 = textView.getScrollX();
                            int scrollY2 = textView.getScrollY();
                            a(textView, layout, scrollX, max);
                            if (scrollX2 == textView.getScrollX() && scrollY2 == textView.getScrollY()) {
                                if (aVarArr[0].f137006g) {
                                    return true;
                                }
                                a(textView);
                            } else {
                                textView.cancelLongPress();
                                aVarArr[0].f137006g = true;
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            a[] a16 = a(textView);
            return a16 != null && a16.length > 0 && a16[0].f137005f;
        }
        for (a aVar3 : (a[]) spannable.getSpans(0, spannable.length(), a.class)) {
            spannable.removeSpan(aVar3);
        }
        spannable.setSpan(new a(motionEvent.getX(), motionEvent.getY(), textView.getScrollX(), textView.getScrollY()), 0, 0, 17);
        return true;
    }

    public static a[] a(TextView textView) {
        if (textView == null || !(textView.getText() instanceof Spannable)) {
            return null;
        }
        Spannable spannable = (Spannable) textView.getText();
        a[] aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
        for (a aVar : aVarArr) {
            spannable.removeSpan(aVar);
        }
        return aVarArr;
    }
}
