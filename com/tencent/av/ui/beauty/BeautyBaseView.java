package com.tencent.av.ui.beauty;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.av.ui.d;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BeautyBaseView extends RelativeLayout implements View.OnClickListener, BeautySeekView.c, d {

    /* renamed from: d, reason: collision with root package name */
    VideoAppInterface f75424d;

    /* renamed from: e, reason: collision with root package name */
    long f75425e;

    public BeautyBaseView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (action != 2 || Math.abs(elapsedRealtime - this.f75425e) > 200) {
            this.f75425e = elapsedRealtime;
            BaseToolbar.keepInToolbar(this.f75424d, -1043L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setAppInterface(VideoAppInterface videoAppInterface) {
        if (this.f75424d != videoAppInterface) {
            this.f75424d = videoAppInterface;
        }
    }

    public BeautyBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BeautyBaseView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75425e = 0L;
    }

    public void e(long j3, boolean z16) {
    }

    public void f(long j3, boolean z16) {
    }
}
