package com.dataline.util.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes2.dex */
public class WaitTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private Handler f32476d;

    /* renamed from: e, reason: collision with root package name */
    private String f32477e;

    /* renamed from: f, reason: collision with root package name */
    private int f32478f;

    /* renamed from: h, reason: collision with root package name */
    private a f32479h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f32480i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void E0();
    }

    public WaitTextView(Context context) {
        super(context);
        this.f32478f = 0;
        this.f32480i = new Runnable() { // from class: com.dataline.util.widget.WaitTextView.1
            @Override // java.lang.Runnable
            public void run() {
                WaitTextView.this.d();
                if (WaitTextView.this.f32479h != null) {
                    WaitTextView.this.f32479h.E0();
                }
                WaitTextView.this.f32476d.postDelayed(this, 500L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i3 = this.f32478f;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    setText(this.f32477e + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    this.f32478f = 0;
                    return;
                }
                setText(this.f32477e + ".. ");
                this.f32478f = this.f32478f + 1;
                return;
            }
            setText(this.f32477e + ".  ");
            this.f32478f = this.f32478f + 1;
            return;
        }
        setText(this.f32477e + "   ");
        this.f32478f = this.f32478f + 1;
    }

    public void e() {
        if (this.f32476d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.f32476d = handler;
            handler.postDelayed(this.f32480i, 500L);
        }
    }

    public void f() {
        Handler handler = this.f32476d;
        if (handler != null) {
            handler.removeCallbacks(this.f32480i);
            this.f32476d = null;
        }
    }

    public void setRefreshListener(a aVar) {
        this.f32479h = aVar;
    }

    public void setWaitText(String str) {
        this.f32477e = str;
        this.f32478f = 0;
        setText(this.f32477e + "   ");
    }

    public WaitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32478f = 0;
        this.f32480i = new Runnable() { // from class: com.dataline.util.widget.WaitTextView.1
            @Override // java.lang.Runnable
            public void run() {
                WaitTextView.this.d();
                if (WaitTextView.this.f32479h != null) {
                    WaitTextView.this.f32479h.E0();
                }
                WaitTextView.this.f32476d.postDelayed(this, 500L);
            }
        };
    }

    public WaitTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f32478f = 0;
        this.f32480i = new Runnable() { // from class: com.dataline.util.widget.WaitTextView.1
            @Override // java.lang.Runnable
            public void run() {
                WaitTextView.this.d();
                if (WaitTextView.this.f32479h != null) {
                    WaitTextView.this.f32479h.E0();
                }
                WaitTextView.this.f32476d.postDelayed(this, 500L);
            }
        };
    }
}
