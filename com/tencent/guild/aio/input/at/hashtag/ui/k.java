package com.tencent.guild.aio.input.at.hashtag.ui;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.aio.widget.textView.view.AioTextView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class k extends com.tencent.aio.widget.textView.view.b {

    /* renamed from: a, reason: collision with root package name */
    protected b f110967a;

    /* renamed from: b, reason: collision with root package name */
    private long f110968b;

    @Override // com.tencent.aio.widget.textView.view.b
    public boolean d(View view, Layout layout, Spanned spanned, MotionEvent motionEvent) {
        if (!(view instanceof AioTextView)) {
            return false;
        }
        AioTextView aioTextView = (AioTextView) view;
        Object n3 = aioTextView.n((int) motionEvent.getX(), (int) motionEvent.getY(), b.class);
        if (n3 instanceof b) {
            this.f110967a = (b) n3;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                e(spanned);
            }
        } else {
            e(spanned);
            b bVar = this.f110967a;
            if (bVar != null) {
                bVar.a(true);
            }
        }
        Object a16 = l.f110969a.a((int) motionEvent.getX(), (int) motionEvent.getY(), aioTextView.i(), aioTextView.o());
        if (a16 == null) {
            a16 = aioTextView.n((int) motionEvent.getX(), (int) motionEvent.getY(), ClickableSpan.class);
            if (a16 instanceof b) {
                a16 = null;
            }
        }
        boolean z16 = a16 instanceof ClickableSpan;
        if (motionEvent.getAction() == 1) {
            if (!z16) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    return ((ViewGroup) parent).performClick();
                }
            } else {
                if (System.currentTimeMillis() - this.f110968b >= 300 && (a16 instanceof com.tencent.mobileqq.guild.feed.a)) {
                    ((com.tencent.mobileqq.guild.feed.a) a16).a(view);
                } else {
                    ((ClickableSpan) a16).onClick(view);
                }
                return true;
            }
        } else if (z16) {
            if (motionEvent.getAction() == 0) {
                this.f110968b = System.currentTimeMillis();
            }
            return true;
        }
        return false;
    }

    protected void e(Spanned spanned) {
        b bVar = this.f110967a;
        if (bVar != null) {
            bVar.a(false);
            this.f110967a = null;
            if (spanned instanceof Spannable) {
                Selection.removeSelection((Spannable) spanned);
            }
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        ClickableSpan b16 = l.f110969a.b(textView, spannable, motionEvent);
        if (b16 instanceof b) {
            this.f110967a = (b) b16;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                e(spannable);
            }
        } else {
            e(spannable);
            b bVar = this.f110967a;
            if (bVar != null) {
                bVar.a(true);
            }
        }
        if (motionEvent.getAction() == 1) {
            if (b16 == null) {
                ViewParent parent = textView.getParent();
                if (parent instanceof ViewGroup) {
                    return ((ViewGroup) parent).performClick();
                }
            } else {
                if (System.currentTimeMillis() - this.f110968b >= 300 && (b16 instanceof com.tencent.mobileqq.guild.feed.a)) {
                    ((com.tencent.mobileqq.guild.feed.a) b16).a(textView);
                } else {
                    b16.onClick(textView);
                    textView.cancelPendingInputEvents();
                }
                return true;
            }
        } else if (motionEvent.getAction() == 0) {
            this.f110968b = System.currentTimeMillis();
        }
        if (b16 != null) {
            return true;
        }
        return false;
    }
}
