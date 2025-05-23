package com.qzone.widget.copyabletextview.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.proxy.feedcomponent.text.TouchBehaviorListener;
import com.qzone.widget.AsyncRichTextView;
import com.qzone.widget.copyabletextview.CopyableTextView;
import ip.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SelectableTextView extends AsyncRichTextView implements TouchBehaviorListener {
    public static float E = 40.0f;
    private dp.a C;
    private Rect D;

    /* renamed from: d, reason: collision with root package name */
    private b f60750d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f60751e;

    /* renamed from: f, reason: collision with root package name */
    private int f60752f;

    /* renamed from: h, reason: collision with root package name */
    private int f60753h;

    /* renamed from: i, reason: collision with root package name */
    private a f60754i;

    /* renamed from: m, reason: collision with root package name */
    private int f60755m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a();
    }

    public SelectableTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60750d = new b();
        this.f60751e = false;
        this.f60755m = -2763307;
        f(context, attributeSet);
    }

    private void e() {
        a aVar = this.f60754i;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.f60750d.f(1, this);
        this.f60750d.f(0, this);
        this.f60750d.f(6, this);
        setHighLightColor(this.f60755m);
        setBackgroundDrawable(null);
    }

    public int c() {
        return this.f60753h;
    }

    public int d() {
        return this.f60752f;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean b16 = this.f60750d.b(motionEvent);
        return !b16 ? super.dispatchTouchEvent(motionEvent) : b16;
    }

    public boolean g() {
        return this.f60751e;
    }

    @Override // android.widget.TextView
    protected boolean getDefaultEditable() {
        return false;
    }

    public boolean h(int i3, int i16) {
        if (i3 >= getText().length()) {
            i3 = getText().length() - 1;
        }
        if (i16 >= getText().length()) {
            i16 = getText().length();
        }
        if (this.f60752f == i3 && this.f60753h == i16) {
            return false;
        }
        this.f60752f = i3;
        this.f60753h = i16;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float lineLeft;
        float lineRight;
        if (this.f60751e) {
            Layout layout = getLayout();
            int i3 = this.f60752f;
            int i16 = this.f60753h;
            int lineForOffset = layout.getLineForOffset(i3);
            int lineForOffset2 = layout.getLineForOffset(i16);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            if (this.C == null) {
                this.C = new dp.a(this.f60755m);
            }
            for (int i17 = lineForOffset; i17 <= lineForOffset2; i17++) {
                if (i17 == lineForOffset) {
                    lineLeft = layout.getPrimaryHorizontal(i3);
                } else {
                    lineLeft = layout.getLineLeft(i17);
                }
                int i18 = (int) lineLeft;
                if (i17 == lineForOffset2) {
                    lineRight = layout.getPrimaryHorizontal(i16);
                } else {
                    lineRight = layout.getLineRight(i17);
                }
                int i19 = (int) lineRight;
                if (this.D == null) {
                    this.D = new Rect();
                }
                this.D.set(i18 + paddingLeft, (layout.getLineBottom(i17) - layout.getLineDescent(i17)) + layout.getLineAscent(i17) + paddingTop, i19 + paddingLeft, layout.getLineBottom(i17) + paddingTop);
                this.C.a(this.D);
            }
            this.C.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // com.qzone.widget.AsyncRichTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setHighLightColor(int i3) {
        this.f60755m = i3;
        super.setHighlightColor(i3);
    }

    public void setMenuDelegate(a aVar) {
        this.f60754i = aVar;
    }

    public void setSelecting(boolean z16) {
        this.f60751e = z16;
        postInvalidate();
    }

    public SelectableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60750d = new b();
        this.f60751e = false;
        this.f60755m = -2763307;
        f(context, attributeSet);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TouchBehaviorListener
    public boolean onInvoke(int i3, float f16, float f17, int i16) {
        CopyableTextView copyableTextView;
        if (i3 != 0) {
            return false;
        }
        if (this.f60751e) {
            this.f60751e = false;
            h(0, 0);
            e();
        } else {
            try {
                Layout layout = getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) ((f17 - getTotalPaddingTop()) + getScrollY())), (f16 - getTotalPaddingLeft()) + getScrollX());
                if (((ClickableSpan[]) ((Spannable) getText()).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class)).length != 0 || (copyableTextView = (CopyableTextView) getParent()) == null) {
                    return false;
                }
                int id5 = copyableTextView.getId();
                Handler handler = (Handler) copyableTextView.getTag();
                if (id5 <= 0 || handler == null) {
                    return false;
                }
                int i17 = (id5 / 10000) - 1;
                int i18 = (id5 - ((i17 + 1) * 10000)) - 1;
                if (i17 < 0 || i18 < 0) {
                    return false;
                }
                Message obtain = Message.obtain();
                obtain.what = 152;
                obtain.arg1 = i17;
                Bundle bundle = new Bundle();
                bundle.putString("REPLY_POS", String.valueOf(i18));
                obtain.setData(bundle);
                handler.sendMessage(obtain);
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public SelectableTextView(Context context) {
        super(context);
        this.f60750d = new b();
        this.f60751e = false;
        this.f60755m = -2763307;
        f(context, null);
    }
}
