package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public class CommandResult {
    static IPatchRedirector $redirector_;
    boolean isDone;
    final String output;
    final boolean success;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommandResult(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str);
        } else {
            this.success = z16;
            this.output = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CommandResult getDummyFailureResponse() {
        return new CommandResult(false, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CommandResult getOutputFromProcess(Process process) {
        String convertInputStreamToString;
        if (success(Integer.valueOf(process.exitValue()))) {
            convertInputStreamToString = Util.convertInputStreamToString(process.getInputStream());
        } else {
            convertInputStreamToString = Util.convertInputStreamToString(process.getErrorStream());
        }
        return new CommandResult(success(Integer.valueOf(process.exitValue())), convertInputStreamToString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean success(Integer num) {
        if (num != null && num.intValue() == 0) {
            return true;
        }
        return false;
    }
}
