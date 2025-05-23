package com.tencent.biz.pubaccount.weishi.verticalvideo;

import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes32.dex */
class WSVideoLayoutDispatchTouchListener$1 implements Runnable {
    final /* synthetic */ n this$0;

    @Override // java.lang.Runnable
    public void run() {
        WSPlayerControlBar wSPlayerControlBar;
        try {
            if (n.a(null) == null || (wSPlayerControlBar = (WSPlayerControlBar) n.a(null).get()) == null) {
                return;
            }
            wSPlayerControlBar.setThumb(BaseApplication.getContext().getResources().getDrawable(R.drawable.n5t));
        } catch (Exception e16) {
            x.f("WSVideoLayoutDispatchTouchListener", "seekBar un active runnable error:" + e16);
        }
    }
}
