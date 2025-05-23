package com.tencent.mqq.shared_file_accessor.test;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes21.dex */
public class AccessRecorder {
    private static final int BUF_LEN = 32768;
    private static final String WRITE_FILE_NAME_BASE = "sp_rw_";
    private Handler mHandler;
    private StringBuilder mStringBuilder = new StringBuilder(32768);
    private FileWriter mWriter;
    private String mWritingFileName;
    private HandlerThread mWritingThread;
    private static final String FILE_LOCATED_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sp";
    private static volatile AccessRecorder mInstance = null;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private class PrivateHandler extends Handler {
        public static final int MSG_FLUSH_AFTER_LONG_TIME = 1;
        public static final int MSG_WRITE = 0;

        public PrivateHandler(Looper looper) {
            super(looper);
        }

        private void write(String str) {
            if (AccessRecorder.this.mWriter == null) {
                return;
            }
            try {
                AccessRecorder.this.mWriter.write(str);
                AccessRecorder.this.mWriter.flush();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    synchronized (AccessRecorder.this) {
                        sendMessage(Message.obtain(this, 0, AccessRecorder.this.mStringBuilder.toString()));
                        AccessRecorder.this.mStringBuilder.setLength(0);
                    }
                    return;
                }
                return;
            }
            write((String) message.obj);
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    AccessRecorder() {
        this.mWritingThread = null;
        this.mHandler = null;
        this.mWritingFileName = null;
        this.mWriter = null;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AccessRecorder", 0);
        this.mWritingThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mHandler = new PrivateHandler(this.mWritingThread.getLooper());
        this.mWritingFileName = WRITE_FILE_NAME_BASE + new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date());
        try {
            String str = FILE_LOCATED_DIR;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mWriter = new FileWriter(str + "/" + this.mWritingFileName + ".csv");
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public static AccessRecorder getInstance() {
        AccessRecorder accessRecorder;
        if (mInstance != null) {
            return mInstance;
        }
        synchronized (AccessRecorder.class) {
            if (mInstance == null) {
                mInstance = new AccessRecorder();
            }
            accessRecorder = mInstance;
        }
        return accessRecorder;
    }

    public synchronized void log(String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length - 1; i3++) {
            StringBuilder sb5 = this.mStringBuilder;
            sb5.append(strArr[i3]);
            sb5.append('\t');
        }
        StringBuilder sb6 = this.mStringBuilder;
        sb6.append(strArr[strArr.length - 1]);
        sb6.append('\n');
        if (this.mStringBuilder.length() > 32768) {
            String sb7 = this.mStringBuilder.toString();
            if (this.mHandler.hasMessages(1)) {
                this.mHandler.removeMessages(1);
            }
            Handler handler = this.mHandler;
            handler.sendMessage(Message.obtain(handler, 0, sb7));
            this.mStringBuilder.setLength(0);
        } else if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
