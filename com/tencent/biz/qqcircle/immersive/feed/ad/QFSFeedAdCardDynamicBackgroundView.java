package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class QFSFeedAdCardDynamicBackgroundView extends QFSPagAnimView {
    private String M;

    public QFSFeedAdCardDynamicBackgroundView(@NonNull Context context) {
        super(context);
    }

    public void Y() {
        String str = this.M;
        if (str == null) {
            QLog.d("QFSFeedAdCardDynamicBackgroundView", 1, "[start], mPagUrl is null");
        } else {
            N(str, Integer.MAX_VALUE, TTL.MAX_VALUE);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            i17 = viewGroup.getMeasuredWidth();
            i18 = viewGroup.getMeasuredHeight();
        } else {
            i17 = 0;
            i18 = 0;
        }
        QLog.d("QFSFeedAdCardDynamicBackgroundView", 1, "[onMeasure] w:" + i17 + ", h:" + i18);
        setMeasuredDimension(i17, i18);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
    }

    public void setPagUrl(String str) {
        this.M = str;
    }

    public QFSFeedAdCardDynamicBackgroundView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSFeedAdCardDynamicBackgroundView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
