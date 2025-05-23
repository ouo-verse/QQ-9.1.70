package com.tencent.richmediabrowser.view.progress;

import android.view.View;

/* loaded from: classes25.dex */
public class ProgressViewHelper {
    private AbstractProgressView progressView;

    private AbstractProgressView getProgressView(int i3) {
        return this.progressView;
    }

    public void onLoadFinish(int i3, boolean z16) {
        AbstractProgressView progressView = getProgressView(i3);
        if (progressView != null) {
            progressView.stop();
        }
    }

    public void onLoadProgressUpdate(View view, int i3) {
    }

    public void onLoadStart(int i3, int i16) {
        AbstractProgressView progressView = getProgressView(i3);
        if (progressView != null) {
            progressView.start(i16);
        }
    }

    public void setProgressView(AbstractProgressView abstractProgressView) {
        this.progressView = abstractProgressView;
    }

    public void onLoadProgressUpdate(int i3, int i16) {
        AbstractProgressView progressView = getProgressView(i3);
        if (progressView == null || !progressView.isShow()) {
            return;
        }
        progressView.start(i16);
    }
}
