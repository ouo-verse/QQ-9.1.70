package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ContextMenuTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private Context f315588d;

    /* renamed from: e, reason: collision with root package name */
    BubblePopupWindow f315589e;

    /* renamed from: f, reason: collision with root package name */
    c f315590f;

    /* renamed from: h, reason: collision with root package name */
    View.OnClickListener f315591h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable[] f315592i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f315593m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.bbi) {
                Context context = ContextMenuTextView.this.f315588d;
                Context unused = ContextMenuTextView.this.f315588d;
                ((ClipboardManager) context.getSystemService("clipboard")).setText(ContextMenuTextView.this.getText().toString());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @TargetApi(16)
    /* loaded from: classes20.dex */
    class b implements BubblePopupWindow.OnDismissListener {
        b() {
        }

        @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
        public void onDismiss() {
            ContextMenuTextView.super.setBackground(null);
            ContextMenuTextView.this.f315589e = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class c implements View.OnLongClickListener, View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private PointF f315596d = new PointF();

        c() {
        }

        protected void a(View view) {
            MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0);
            view.dispatchTouchEvent(obtain);
            obtain.recycle();
            ContextMenuTextView.this.setBackgroundColor(-1);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            ContextMenuTextView.this.setBackgroundColor(-7829368);
            BubblePopupWindow bubblePopupWindow = ContextMenuTextView.this.f315589e;
            if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
                a(view);
                z16 = false;
            } else {
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                aVar.b(R.id.bbi, ContextMenuTextView.this.f315588d.getString(R.string.aet), R.drawable.cb5);
                ContextMenuTextView contextMenuTextView = ContextMenuTextView.this;
                PointF pointF = this.f315596d;
                contextMenuTextView.f315589e = com.tencent.mobileqq.utils.s.e(view, (int) pointF.x, (int) pointF.y, aVar, contextMenuTextView.f315591h, null);
                ContextMenuTextView contextMenuTextView2 = ContextMenuTextView.this;
                BubblePopupWindow bubblePopupWindow2 = contextMenuTextView2.f315589e;
                if (bubblePopupWindow2 != null) {
                    bubblePopupWindow2.setOnDismissListener(new b());
                }
                a(view);
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f315596d.x = motionEvent.getRawX();
                this.f315596d.y = motionEvent.getRawY();
                return false;
            }
            return false;
        }
    }

    public ContextMenuTextView(Context context) {
        super(context);
        this.f315588d = null;
        this.f315590f = new c();
        this.f315591h = new a();
        this.f315593m = false;
        this.f315588d = context;
        setOnLongClickListener(this.f315590f);
        setSelectAllOnFocus(true);
    }

    private void c(Object obj) {
        CharSequence text = getText();
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            int spanStart = spannable.getSpanStart(obj);
            int spanEnd = spannable.getSpanEnd(obj);
            SpanWatcher[] spanWatcherArr = (SpanWatcher[]) spannable.getSpans(spanStart, spanEnd, SpanWatcher.class);
            if (spanWatcherArr != null && spanWatcherArr.length > 0) {
                for (SpanWatcher spanWatcher : spanWatcherArr) {
                    spanWatcher.onSpanChanged(spannable, obj, spanStart, spanEnd, spanStart, spanEnd);
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        CharSequence text = getText();
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spannable.getSpans(0, spannable.length(), EmoticonSpan.class);
            if (emoticonSpanArr != null && emoticonSpanArr.length > 0) {
                this.f315593m = true;
                for (EmoticonSpan emoticonSpan : emoticonSpanArr) {
                    if (emoticonSpan.getDrawable() == drawable) {
                        c(emoticonSpan);
                    }
                }
                this.f315593m = false;
            }
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.f315593m) {
            super.requestLayout();
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!getText().equals(charSequence)) {
            super.setText(charSequence, bufferType);
            if (getText() instanceof QQText) {
                Spannable spannable = (Spannable) getText();
                EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spannable.getSpans(0, spannable.length(), EmoticonSpan.class);
                Drawable[] drawableArr = new Drawable[emoticonSpanArr.length];
                for (int i3 = 0; i3 < emoticonSpanArr.length; i3++) {
                    Drawable drawable = emoticonSpanArr[i3].getDrawable();
                    drawableArr[i3] = drawable;
                    drawable.setCallback(this);
                }
                this.f315592i = drawableArr;
            }
        }
    }

    public ContextMenuTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315588d = null;
        this.f315590f = new c();
        this.f315591h = new a();
        this.f315593m = false;
        this.f315588d = context;
        setOnLongClickListener(this.f315590f);
        setSelectAllOnFocus(true);
        setOnTouchListener(this.f315590f);
    }
}
