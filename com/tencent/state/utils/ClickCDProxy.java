package com.tencent.state.utils;

import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/utils/ClickCDProxy;", "Landroid/view/View$OnClickListener;", "originListener", "coolDownTimeMs", "", "(Landroid/view/View$OnClickListener;J)V", "(Landroid/view/View$OnClickListener;)V", "lastClickTimeStamp", NodeProps.ON_CLICK, "", "v", "Landroid/view/View;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ClickCDProxy implements View.OnClickListener {
    private static final String TAG = "ClickCDProxy";
    private long coolDownTimeMs;
    private long lastClickTimeStamp;
    private View.OnClickListener originListener;

    public ClickCDProxy(View.OnClickListener originListener, long j3) {
        Intrinsics.checkNotNullParameter(originListener, "originListener");
        this.originListener = originListener;
        this.coolDownTimeMs = j3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (System.currentTimeMillis() - this.lastClickTimeStamp >= this.coolDownTimeMs) {
            this.originListener.onClick(v3);
            this.lastClickTimeStamp = System.currentTimeMillis();
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "ignore click in cd time " + v3);
    }

    public ClickCDProxy(View.OnClickListener originListener) {
        Intrinsics.checkNotNullParameter(originListener, "originListener");
        this.coolDownTimeMs = 1000L;
        this.originListener = originListener;
    }
}
