package com.dataline.qqnt.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class WaitTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private Handler f32329d;

    /* renamed from: e, reason: collision with root package name */
    private String f32330e;

    /* renamed from: f, reason: collision with root package name */
    private int f32331f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f32332h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
    }

    public WaitTextView(Context context) {
        super(context);
        this.f32331f = 0;
        this.f32332h = new Runnable() { // from class: com.dataline.qqnt.widget.WaitTextView.1
            @Override // java.lang.Runnable
            public void run() {
                WaitTextView.this.d();
                WaitTextView.a(WaitTextView.this);
                WaitTextView.this.f32329d.postDelayed(this, 500L);
            }
        };
    }

    static /* bridge */ /* synthetic */ a a(WaitTextView waitTextView) {
        waitTextView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i3 = this.f32331f;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    setText(this.f32330e + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    this.f32331f = 0;
                    return;
                }
                setText(this.f32330e + ".. ");
                this.f32331f = this.f32331f + 1;
                return;
            }
            setText(this.f32330e + ".  ");
            this.f32331f = this.f32331f + 1;
            return;
        }
        setText(this.f32330e + "   ");
        this.f32331f = this.f32331f + 1;
    }

    public void setWaitText(String str) {
        this.f32330e = str;
        this.f32331f = 0;
        setText(this.f32330e + "   ");
    }

    public WaitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32331f = 0;
        this.f32332h = new Runnable() { // from class: com.dataline.qqnt.widget.WaitTextView.1
            @Override // java.lang.Runnable
            public void run() {
                WaitTextView.this.d();
                WaitTextView.a(WaitTextView.this);
                WaitTextView.this.f32329d.postDelayed(this, 500L);
            }
        };
    }

    public WaitTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f32331f = 0;
        this.f32332h = new Runnable() { // from class: com.dataline.qqnt.widget.WaitTextView.1
            @Override // java.lang.Runnable
            public void run() {
                WaitTextView.this.d();
                WaitTextView.a(WaitTextView.this);
                WaitTextView.this.f32329d.postDelayed(this, 500L);
            }
        };
    }

    public void setRefreshListener(a aVar) {
    }
}
