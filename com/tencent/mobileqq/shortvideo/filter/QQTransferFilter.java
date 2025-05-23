package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferRender;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQTransferFilter extends QQBaseFilter {
    private static final String TAG = "QQTransferFilter";
    private boolean mEnabled;
    private TransferRender mRender;
    private final LinkedList<Runnable> mRunOnDraw;

    public QQTransferFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(160, qQFilterRenderManager);
        this.mRunOnDraw = new LinkedList<>();
        this.mEnabled = true;
        this.mRender = new TransferRender();
    }

    private void runOnDraw(Runnable runnable) {
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.addLast(runnable);
        }
    }

    private void runPendingOnDrawTasks() {
        synchronized (this.mRunOnDraw) {
            while (!this.mRunOnDraw.isEmpty()) {
                this.mRunOnDraw.removeFirst().run();
            }
        }
    }

    public void enable(boolean z16) {
        this.mEnabled = z16;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        if (this.mEnabled && this.mRender.isWorking()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        if (this.mEnabled) {
            runPendingOnDrawTasks();
            int process = this.mRender.process(this.mInputTextureID, null, null, getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp() / 1000000);
            if (process >= 0) {
                this.mOutputTextureID = process;
                return;
            } else {
                this.mOutputTextureID = this.mInputTextureID;
                return;
            }
        }
        this.mOutputTextureID = this.mInputTextureID;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        this.mRender.onSurfaceChange(i3, i16);
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        this.mRender.destroy();
    }

    public void setSpeedRate(final float f16) {
        if (!this.mEnabled) {
            return;
        }
        runOnDraw(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.filter.QQTransferFilter.2
            @Override // java.lang.Runnable
            public void run() {
                QQTransferFilter.this.mRender.setSpeedRate(f16);
            }
        });
    }

    public void setTransferData(final TransferData transferData) {
        if (!this.mEnabled) {
            return;
        }
        runOnDraw(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.filter.QQTransferFilter.1
            @Override // java.lang.Runnable
            public void run() {
                QQTransferFilter.this.mRender.setTransferData(transferData);
            }
        });
    }
}
