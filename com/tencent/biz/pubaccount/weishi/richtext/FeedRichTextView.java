package com.tencent.biz.pubaccount.weishi.richtext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.richtext.d;
import com.tencent.biz.subscribe.widget.textview.SafeTextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FeedRichTextView extends SafeTextView implements Handler.Callback {
    private b C;
    private Handler D;

    /* renamed from: d, reason: collision with root package name */
    private int f81538d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.richtext.a f81539e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<d.e> f81540f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<d.C0830d> f81541h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f81542i;

    /* renamed from: m, reason: collision with root package name */
    private a f81543m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(String str);

        void b(String str);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(ArrayList<d.e> arrayList);
    }

    public FeedRichTextView(Context context) {
        super(context, null);
        this.D = new Handler(Looper.getMainLooper(), this);
    }

    public ArrayList<d.C0830d> h() {
        return this.f81541h;
    }

    public ArrayList<d.e> i() {
        return this.f81540f;
    }

    protected void j(final CharSequence charSequence, final a aVar, final Drawable.Callback callback) {
        if (this.f81539e == null) {
            this.f81539e = c.a(0);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.1
            @Override // java.lang.Runnable
            public void run() {
                d.c a16 = FeedRichTextView.this.f81539e.a(charSequence, Math.round(FeedRichTextView.this.getTextSize()), aVar, callback);
                if (a16 == null) {
                    return;
                }
                if (aVar != null) {
                    FeedRichTextView feedRichTextView = FeedRichTextView.this;
                    feedRichTextView.setMovementMethod(feedRichTextView.getDefaultMovementMethod());
                }
                if (FeedRichTextView.this.D == null) {
                    FeedRichTextView.this.D = new Handler(Looper.getMainLooper(), FeedRichTextView.this);
                }
                Message obtainMessage = FeedRichTextView.this.D.obtainMessage();
                obtainMessage.what = 1001;
                obtainMessage.obj = a16;
                FeedRichTextView.this.D.sendMessage(obtainMessage);
            }
        }, 8, null, true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f81542i = false;
        CharSequence text = getText();
        if (text instanceof SpannableStringBuilder) {
            ((SpannableStringBuilder) text).clearSpans();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void setOnElementClickListener(a aVar) {
        this.f81543m = aVar;
    }

    public void setOnParseListener(b bVar) {
        this.C = bVar;
    }

    public void setRichTextDisplayType(int i3) {
        this.f81538d = i3;
        this.f81539e = c.a(i3);
    }

    @Override // com.tencent.biz.subscribe.widget.textview.SafeTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!TextUtils.isEmpty(charSequence) && (TextUtils.isEmpty(charSequence) || !(charSequence instanceof d.c))) {
            j(charSequence, this.f81543m, null);
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setFocusable(false);
        return super.onTouchEvent(motionEvent);
    }

    public FeedRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new Handler(Looper.getMainLooper(), this);
    }

    public FeedRichTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new Handler(Looper.getMainLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message != null && message.what == 1001) {
            Object obj = message.obj;
            if (obj instanceof d.c) {
                d.c cVar = (d.c) obj;
                this.f81540f = cVar.b();
                this.f81541h = cVar.a();
                b bVar = this.C;
                if (bVar != null && !this.f81542i) {
                    bVar.a(this.f81540f);
                }
                this.f81542i = true;
                super.setText(cVar, (TextView.BufferType) null);
            }
        }
        return false;
    }
}
