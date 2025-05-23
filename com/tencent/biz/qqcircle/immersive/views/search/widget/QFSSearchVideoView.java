package com.tencent.biz.qqcircle.immersive.views.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchVideoView extends QFSVideoView {
    private boolean H;
    private long I;
    private boolean J;

    public QFSSearchVideoView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void cleanOldISPlayer() {
        if (RFWThreadManager.isMainThread()) {
            super.cleanOldISPlayer();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.widget.a
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoView.this.cleanOldISPlayer();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public LinkedList<String> getProcessOrder(int i3) {
        if (!this.J) {
            return super.getProcessOrder(i3);
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK);
        return linkedList;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener
    public void onTimerCallback() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.I > 500) {
            this.I = currentTimeMillis;
            timeUpdateCallBack();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void playTimer() {
        if (this.H) {
            super.playTimer();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSVideoView, com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        try {
            super.release();
        } catch (Throwable th5) {
            if (QCircleHostConstants._AppSetting.isPublicVersion()) {
                QLog.w("QFSSearchVideoView", 1, th5.getMessage(), th5);
                return;
            }
            throw th5;
        }
    }

    public void setIsTVK(boolean z16) {
        this.J = z16;
    }

    public void setProgressEnabled(boolean z16) {
        this.H = z16;
    }

    public QFSSearchVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSVideoView
    public void setLoadingViewStatus(boolean z16) {
    }
}
