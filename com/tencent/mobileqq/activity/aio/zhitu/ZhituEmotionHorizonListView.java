package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ZhituEmotionHorizonListView extends HorizontalListView {

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
    }

    public ZhituEmotionHorizonListView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        if (i3 > 0 && (getAdapter() instanceof ZhituPicAdapter)) {
            ((ZhituPicAdapter) getAdapter()).e();
        }
        super.onOverScrolled(i3, i16, z16, z17);
    }

    public ZhituEmotionHorizonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTouchListener(a aVar) {
    }
}
