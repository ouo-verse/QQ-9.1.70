package kotlin;

import android.os.SystemClock;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f400321d;

    /* renamed from: e, reason: collision with root package name */
    private long f400322e;

    public e(View.OnClickListener onClickListener) {
        this.f400321d = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (SystemClock.uptimeMillis() - this.f400322e >= 1000) {
            View.OnClickListener onClickListener = this.f400321d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            this.f400322e = SystemClock.uptimeMillis();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
