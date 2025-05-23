package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import hd0.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public class ShellCommand {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShellCommand() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Process run(String[] strArr) {
        try {
            return RuntimeMonitor.exec(Runtime.getRuntime(), strArr);
        } catch (IOException e16) {
            c.h(FFmpeg.TAG, "Exception while trying to run: " + strArr, e16);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    CommandResult runWaitFor(String[] strArr) {
        Integer num;
        String convertInputStreamToString;
        String str;
        Process run = run(strArr);
        String str2 = null;
        if (run != null) {
            try {
                try {
                    num = Integer.valueOf(run.waitFor());
                    try {
                        if (CommandResult.success(num)) {
                            convertInputStreamToString = Util.convertInputStreamToString(run.getInputStream());
                        } else {
                            convertInputStreamToString = Util.convertInputStreamToString(run.getErrorStream());
                        }
                        str = convertInputStreamToString;
                        str2 = num;
                    } catch (InterruptedException e16) {
                        e = e16;
                        c.h(FFmpeg.TAG, "Interrupt exception", e);
                        return new CommandResult(CommandResult.success(r1), str2);
                    }
                } finally {
                    Util.destroyProcess(run);
                }
            } catch (InterruptedException e17) {
                e = e17;
                num = 0;
            }
        } else {
            str = null;
        }
        Util.destroyProcess(run);
        String str3 = str;
        Integer num2 = str2;
        str2 = str3;
        return new CommandResult(CommandResult.success(num2), str2);
    }
}
