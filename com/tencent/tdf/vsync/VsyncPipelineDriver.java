package com.tencent.tdf.vsync;

import android.view.Choreographer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFJNI;
import com.tencent.tdf.utils.PlatformThread;

/* loaded from: classes26.dex */
public class VsyncPipelineDriver implements IPipelineDriver {
    static IPatchRedirector $redirector_;
    private boolean mIsDriverStarted;
    private long mPipelineDriver;
    private Choreographer.FrameCallback mPipelineDriverTask;
    private boolean stopRequestVSync;

    /* loaded from: classes26.dex */
    class PipelineDriverTask implements Choreographer.FrameCallback {
        static IPatchRedirector $redirector_;
        private long mContext;

        public PipelineDriverTask(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VsyncPipelineDriver.this, Long.valueOf(j3));
            } else {
                this.mContext = j3;
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                if (VsyncPipelineDriver.this.stopRequestVSync) {
                    return;
                }
                TDFJNI.nativeOnDrive(this.mContext);
                VsyncPipelineDriver.this.postFrameCallback(this.mContext);
                VsyncPipelineDriver.this.mPipelineDriver = this.mContext;
            }
        }
    }

    public VsyncPipelineDriver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsDriverStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postFrameCallback(long j3) {
        if (this.mPipelineDriverTask == null) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this.mPipelineDriverTask);
    }

    @Override // com.tencent.tdf.vsync.IPipelineDriver
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mIsDriverStarted && this.stopRequestVSync) {
            this.stopRequestVSync = false;
            postFrameCallback(this.mPipelineDriver);
        }
    }

    @Override // com.tencent.tdf.vsync.IPipelineDriver
    public void start(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        this.mIsDriverStarted = true;
        this.mPipelineDriverTask = new PipelineDriverTask(j3);
        PlatformThread.post(new Runnable(j3) { // from class: com.tencent.tdf.vsync.VsyncPipelineDriver.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$pipelineDriver;

            {
                this.val$pipelineDriver = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VsyncPipelineDriver.this, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VsyncPipelineDriver.this.postFrameCallback(this.val$pipelineDriver);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.tdf.vsync.IPipelineDriver
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.stopRequestVSync = true;
        }
    }
}
