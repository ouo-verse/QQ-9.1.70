package com.tencent.timi.game.liveroom.impl.room.match;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TGLiveTouchWebView extends TouchWebView {
    private boolean C;
    private TGAudienceTabViewPager D;

    public TGLiveTouchWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = false;
        this.D = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    TGAudienceTabViewPager tGAudienceTabViewPager = this.D;
                    if (tGAudienceTabViewPager != null) {
                        tGAudienceTabViewPager.requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    TGAudienceTabViewPager tGAudienceTabViewPager2 = this.D;
                    if (tGAudienceTabViewPager2 != null) {
                        tGAudienceTabViewPager2.requestDisallowInterceptTouchEvent(true ^ this.C);
                    }
                }
            } else {
                this.C = false;
                TGAudienceTabViewPager tGAudienceTabViewPager3 = this.D;
                if (tGAudienceTabViewPager3 != null) {
                    tGAudienceTabViewPager3.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view) {
        super.onOverScrolled(i3, i16, z16, z17, view);
        this.C = z16;
    }

    public void setViewPager(TGAudienceTabViewPager tGAudienceTabViewPager) {
        this.D = tGAudienceTabViewPager;
    }

    public TGLiveTouchWebView(Context context) {
        super(context);
        this.C = false;
        this.D = null;
    }
}
