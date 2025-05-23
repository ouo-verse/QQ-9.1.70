package com.tencent.image;

import com.tencent.image.api.IThreadListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JobQueue implements IThreadListener {
    static IPatchRedirector $redirector_;
    protected final int maxRunning;
    protected LinkedList<Runnable> queue;
    protected int running;

    public JobQueue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.queue = new LinkedList<>();
            this.maxRunning = i3;
        }
    }

    public synchronized void excuteOnNetThread(Runnable runnable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, runnable, Boolean.valueOf(z16));
            return;
        }
        int i3 = this.running;
        if (i3 < this.maxRunning) {
            this.running = i3 + 1;
            URLDrawable.depImp.mThreadManager.executeOnNetThreadExcutor(runnable, this, false);
        } else {
            this.queue.add(runnable);
        }
    }

    @Override // com.tencent.image.api.IThreadListener
    public void onAdded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.image.api.IThreadListener
    public synchronized void onPostRun() {
        Runnable poll;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.running--;
        while (this.running < this.maxRunning && (poll = this.queue.poll()) != null) {
            this.running++;
            URLDrawable.depImp.mThreadManager.executeOnNetThreadExcutor(poll, this, false);
        }
    }

    @Override // com.tencent.image.api.IThreadListener
    public void onPreRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
