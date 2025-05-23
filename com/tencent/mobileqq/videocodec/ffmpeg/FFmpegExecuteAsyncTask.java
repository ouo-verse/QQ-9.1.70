package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import hd0.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes20.dex */
class FFmpegExecuteAsyncTask extends AsyncTask<Void, String, CommandResult> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask";
    public final String[] cmd;
    public final FFmpegExecuteResponseCallback ffmpegExecuteResponseHandler;
    public boolean isFFmpegExecutable;
    public boolean isWorkThread;
    public Context mContext;
    public Boolean mIsDebug;
    public Process mProcess;
    public StringBuilder output;
    public final ShellCommand shellCommand;
    public long startTime;
    public final long timeout;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FFmpegExecuteAsyncTask(Context context, String[] strArr, long j3, boolean z16, FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, strArr, Long.valueOf(j3), Boolean.valueOf(z16), fFmpegExecuteResponseCallback);
            return;
        }
        this.mIsDebug = Boolean.FALSE;
        this.isFFmpegExecutable = false;
        this.mContext = context;
        this.cmd = strArr;
        this.timeout = j3;
        this.isWorkThread = z16;
        this.ffmpegExecuteResponseHandler = fFmpegExecuteResponseCallback;
        this.shellCommand = new ShellCommand();
        this.output = new StringBuilder();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0000, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkAndUpdateProcess() throws TimeoutException {
        FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback;
        while (!Util.isProcessCompleted(this.mProcess)) {
            if (this.timeout != Long.MAX_VALUE && SystemClock.uptimeMillis() > this.startTime + this.timeout) {
                QLog.i(FFmpeg.TAG, 1, "timeout");
                throw new TimeoutException("FFmpeg timed out");
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mProcess.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (isCancelled()) {
                            return;
                        }
                        StringBuilder sb5 = this.output;
                        sb5.append(readLine);
                        sb5.append("\n");
                        if (this.isWorkThread) {
                            if (!TextUtils.isEmpty(readLine) && (fFmpegExecuteResponseCallback = this.ffmpegExecuteResponseHandler) != null) {
                                fFmpegExecuteResponseCallback.onProgress(readLine);
                            }
                        } else {
                            publishProgress(readLine);
                        }
                    }
                }
            } catch (IOException e16) {
                QLog.i(FFmpeg.TAG, 1, "IOException");
                e16.printStackTrace();
            }
        }
    }

    private CommandResult getFailCommandResult() {
        CommandResult dummyFailureResponse = CommandResult.getDummyFailureResponse();
        if (this.isWorkThread) {
            handleResult(dummyFailureResponse);
            dummyFailureResponse.isDone = true;
        }
        return dummyFailureResponse;
    }

    private CommandResult getOutputCommandResult(Process process) {
        CommandResult outputFromProcess = CommandResult.getOutputFromProcess(process);
        if (this.isWorkThread) {
            handleResult(outputFromProcess);
            outputFromProcess.isDone = true;
        }
        return outputFromProcess;
    }

    private void handleResult(CommandResult commandResult) {
        if (this.ffmpegExecuteResponseHandler != null) {
            this.output.append(commandResult.output);
            if (commandResult.success) {
                this.ffmpegExecuteResponseHandler.onSuccess(this.output.toString());
            } else {
                this.ffmpegExecuteResponseHandler.onFailure(this.output.toString());
            }
            this.ffmpegExecuteResponseHandler.onFinish(commandResult.success);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ThreadName:" + Thread.currentThread().getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isProcessCompleted() {
        return Util.isProcessCompleted(this.mProcess);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.startTime = SystemClock.uptimeMillis();
        if (this.ffmpegExecuteResponseHandler != null) {
            if (this.isWorkThread) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteAsyncTask.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FFmpegExecuteAsyncTask.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(FFmpegExecuteAsyncTask.TAG, 2, "ThreadName:" + Thread.currentThread().getName());
                        }
                        FFmpegExecuteAsyncTask.this.ffmpegExecuteResponseHandler.onStart();
                    }
                }, 5, null, true);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ThreadName:" + Thread.currentThread().getName());
            }
            this.ffmpegExecuteResponseHandler.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public CommandResult doInBackground(Void... voidArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CommandResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) voidArr);
        }
        try {
            try {
                if (!this.isFFmpegExecutable) {
                    this.isFFmpegExecutable = Util.setFileExecutable(new File(FFmpegFileUtils.getFFmpeg(this.mContext)));
                }
                c.t(TAG, "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.cmd));
                Process run = this.shellCommand.run(this.cmd);
                this.mProcess = run;
                if (run == null) {
                    CommandResult failCommandResult = getFailCommandResult();
                    Util.destroyProcess(this.mProcess);
                    c.t(TAG, "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.cmd));
                    return failCommandResult;
                }
                if (this.mIsDebug.booleanValue()) {
                    StringBuilder sb5 = new StringBuilder();
                    for (String str : this.cmd) {
                        sb5.append(str);
                        sb5.append(TokenParser.SP);
                    }
                    publishProgress(sb5.toString());
                }
                checkAndUpdateProcess();
                CommandResult outputCommandResult = getOutputCommandResult(run);
                Util.destroyProcess(this.mProcess);
                c.t(TAG, "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.cmd));
                return outputCommandResult;
            } catch (TimeoutException e16) {
                c.h(TAG, "FFmpeg timed out", e16);
                CommandResult commandResult = new CommandResult(false, e16.getMessage());
                Util.destroyProcess(this.mProcess);
                c.t(TAG, "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.cmd));
                return commandResult;
            } catch (Exception e17) {
                c.h(TAG, "Error running FFmpeg", e17);
                Util.destroyProcess(this.mProcess);
                c.t(TAG, "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.cmd));
                return getFailCommandResult();
            }
        } catch (Throwable th5) {
            Util.destroyProcess(this.mProcess);
            c.t(TAG, "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.cmd));
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(CommandResult commandResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) commandResult);
        } else {
            if (commandResult.isDone) {
                return;
            }
            handleResult(commandResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(String... strArr) {
        String str;
        FFmpegExecuteResponseCallback fFmpegExecuteResponseCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr);
        } else {
            if (strArr == null || (str = strArr[0]) == null || (fFmpegExecuteResponseCallback = this.ffmpegExecuteResponseHandler) == null) {
                return;
            }
            fFmpegExecuteResponseCallback.onProgress(str);
        }
    }
}
