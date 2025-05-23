package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQStoryLoadingView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    protected AnimationDrawable f94518d;

    /* renamed from: e, reason: collision with root package name */
    protected Handler f94519e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i3 = message.what;
            if (i3 == 0 || i3 == 4 || i3 == 8) {
                Object obj = message.obj;
                if (i3 == 8) {
                    str = ParseCommon.GONE;
                } else if (i3 == 0) {
                    str = ParseCommon.VISIBLE;
                } else {
                    str = "INVISIBLE";
                }
                c.c("QQStoryLoadingView", "%s => setVisibility => %s", obj, str);
                QQStoryLoadingView.this.setVisibility(message.what);
            }
        }
    }

    public QQStoryLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94519e = new a(Looper.getMainLooper());
        super.setGravity(17);
        if (super.getVisibility() == 0 && !post(new Runnable() { // from class: com.tencent.biz.qqstory.view.widget.QQStoryLoadingView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QQStoryLoadingView.super.getVisibility() == 0) {
                    QQStoryLoadingView.this.setVisibility(0);
                }
            }
        })) {
            setVisibility(0);
        }
    }

    public void c() {
        try {
            AnimationDrawable animationDrawable = this.f94518d;
            if (animationDrawable == null || animationDrawable.getNumberOfFrames() != 29) {
                this.f94518d = new AnimationDrawable();
                for (int i3 = 0; i3 < 29; i3++) {
                    this.f94518d.addFrame(super.getResources().getDrawable(R.drawable.f161982fd3 + i3), 50);
                }
                this.f94518d.setOneShot(false);
                super.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f94518d, (Drawable) null, (Drawable) null);
            }
            this.f94518d.start();
        } catch (Exception e16) {
            this.f94518d = null;
            c.g("Q.qqstory.QQStoryLoadingView", "start animation error:" + e16);
        }
    }

    public void d() {
        super.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, super.getResources().getDrawable(R.drawable.f161982fd3), (Drawable) null, (Drawable) null);
        AnimationDrawable animationDrawable = this.f94518d;
        if (animationDrawable != null) {
            animationDrawable.stop();
            for (int i3 = 0; i3 < this.f94518d.getNumberOfFrames(); i3++) {
                Drawable frame = this.f94518d.getFrame(i3);
                boolean z16 = frame instanceof BitmapDrawable;
                if (frame != null) {
                    frame.setCallback(null);
                }
            }
            this.f94518d.setCallback(null);
            this.f94518d = null;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        String str;
        if (this.f94519e.hasMessages(0)) {
            c.a("QQStoryLoadingView", "ignore VISIBLE");
        }
        this.f94519e.removeCallbacksAndMessages(null);
        if (super.getVisibility() != i3) {
            super.setVisibility(i3);
            String str2 = "QQStoryLoadingView" + System.identityHashCode(this);
            if (i3 == 8) {
                str = ParseCommon.GONE;
            } else if (i3 == 0) {
                str = ParseCommon.VISIBLE;
            } else {
                str = "INVISIBLE";
            }
            c.b(str2, "setVisibility => %s", str);
        }
        if (i3 == 0) {
            c();
        } else {
            d();
        }
    }

    public void setVisibilityDelay(int i3, long j3, String str) {
        this.f94519e.removeCallbacksAndMessages(null);
        Handler handler = this.f94519e;
        handler.sendMessageDelayed(Message.obtain(handler, i3, str), j3);
    }
}
