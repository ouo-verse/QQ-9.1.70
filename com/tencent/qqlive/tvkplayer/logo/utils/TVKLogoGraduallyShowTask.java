package com.tencent.qqlive.tvkplayer.logo.utils;

import android.widget.ImageView;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoGraduallyShowTask extends TimerTask {
    private static final int MAX_ALPHA = 255;
    private static final int MAX_EXECUTION_COUNT = 1;
    private static final long PERIOD_MS = 0;
    private final int mLogoAlpha;
    private final ImageView mLogoView;
    private int mExecutionCount = 1;
    private final ScheduledFuture<?> mScheduledFuture = TVKThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(this, 0, 0, TimeUnit.MILLISECONDS);

    TVKLogoGraduallyShowTask(ImageView imageView, int i3) {
        this.mLogoView = imageView;
        this.mLogoAlpha = (i3 * 255) / 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$run$0(int i3) {
        this.mLogoView.setImageAlpha((this.mLogoAlpha * i3) / 1);
    }

    public static void newTask(ImageView imageView, int i3) {
        if (imageView != null && i3 >= 0 && i3 <= 100) {
            new TVKLogoGraduallyShowTask(imageView, i3);
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        final int i3 = this.mExecutionCount;
        if (i3 > 1) {
            this.mScheduledFuture.cancel(false);
        } else {
            this.mExecutionCount = i3 + 1;
            TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    TVKLogoGraduallyShowTask.this.lambda$run$0(i3);
                }
            });
        }
    }
}
