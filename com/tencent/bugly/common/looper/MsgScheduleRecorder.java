package com.tencent.bugly.common.looper;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MsgScheduleRecorder implements ILooperDispatchListener {
    private static final long DETAIL_INTERVAL = 30;
    private static final int EXECUTED_QUEUE_LEN = 100;
    private static final int EXECUTING_QUEUE_LEN = 50;
    private static final long IDLE_MSG_THRESHOLD = 1000;
    private static final long LONG_MSG_THRESHOLD = 200;
    private static final int MAX_TEMP_EXECUTED_COUNT = 500;
    private static final int TYPE_IDLE_MSG = 2;
    private static final int TYPE_LONG_MSG = 0;
    private static final int TYPE_MERGE_MSG = 1;
    private Looper mLooper;
    private long mMsgStartWallTime = 0;
    private long mMsgStartCpuTime = 0;
    private String mMsgStartDetail = "";
    private long mMsgEndWallTime = 0;
    private long mMsgEndCpuTime = 0;
    private long mTempMergeWallTime = 0;
    private long mTempMergeCpuTime = 0;
    private int mTempMergeCount = 0;
    private AtomicBoolean mCopying = new AtomicBoolean();
    private ArrayList<ExecutedMessage> mTempExecutedMsgList = new ArrayList<>();
    private ExecutedMessage[] mExecutedMessages = new ExecutedMessage[100];
    private ExecutedMessage mCurrentMessage = new ExecutedMessage();
    private int mIndex = 0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ExecutedMessage implements Cloneable {
        public int type;
        public long wallTime = 0;
        public long cpuTime = 0;
        public int count = 0;
        public String msgDetail = "";
        public long msgEndTimeInMs = 0;

        public ExecutedMessage() {
        }

        public boolean isLongMsg() {
            if (this.type == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "wallTime = " + this.wallTime + ", cpuTime = " + this.cpuTime + ", msgDetail = " + this.msgDetail + ", type = " + this.type + ", count = " + this.count + ", msgEndTimeInMs = " + this.msgEndTimeInMs;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public ExecutedMessage m103clone() {
            try {
                ExecutedMessage executedMessage = (ExecutedMessage) super.clone();
                executedMessage.cpuTime = this.cpuTime;
                executedMessage.wallTime = this.wallTime;
                executedMessage.msgDetail = this.msgDetail;
                executedMessage.type = this.type;
                executedMessage.count = this.count;
                executedMessage.msgEndTimeInMs = this.msgEndTimeInMs;
                return executedMessage;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ExecutingMessage {
        public int arg1;
        public int arg2;
        public String callback;
        public String target;
        public int what;
        public long when;

        public ExecutingMessage() {
        }
    }

    public MsgScheduleRecorder(Looper looper) {
        this.mLooper = looper;
    }

    private void addNode(long j3, long j16, String str, int i3, int i16) {
        if (this.mCopying.get()) {
            if (this.mTempExecutedMsgList.size() <= 500) {
                ExecutedMessage executedMessage = new ExecutedMessage();
                buildExecutedMsg(executedMessage, j3, j16, str, i3, i16);
                this.mTempExecutedMsgList.add(executedMessage);
                return;
            }
            return;
        }
        Iterator<ExecutedMessage> it = this.mTempExecutedMsgList.iterator();
        while (it.hasNext()) {
            this.mExecutedMessages[this.mIndex] = it.next();
            this.mIndex = getNextIndex();
        }
        this.mTempExecutedMsgList.clear();
        ExecutedMessage[] executedMessageArr = this.mExecutedMessages;
        int i17 = this.mIndex;
        if (executedMessageArr[i17] == null) {
            executedMessageArr[i17] = new ExecutedMessage();
        }
        ExecutedMessage executedMessage2 = this.mExecutedMessages[this.mIndex];
        if (executedMessage2 != null) {
            buildExecutedMsg(executedMessage2, j3, j16, str, i3, i16);
        }
        this.mIndex = getNextIndex();
    }

    private void buildExecutedMsg(ExecutedMessage executedMessage, long j3, long j16, String str, int i3, int i16) {
        if (executedMessage != null) {
            executedMessage.wallTime = j3;
            executedMessage.cpuTime = j16;
            if (j3 <= 30) {
                str = "";
            }
            executedMessage.msgDetail = str;
            executedMessage.type = i3;
            executedMessage.count = i16;
            executedMessage.msgEndTimeInMs = System.currentTimeMillis();
        }
    }

    private ExecutingMessage buildExecutingMsg(Message message, long j3) {
        String obj;
        ExecutingMessage executingMessage = new ExecutingMessage();
        executingMessage.arg1 = message.arg1;
        executingMessage.arg2 = message.arg2;
        executingMessage.what = message.what;
        executingMessage.when = message.getWhen() - j3;
        String str = "";
        if (message.getCallback() == null) {
            obj = "";
        } else {
            obj = message.getCallback().toString();
        }
        executingMessage.callback = obj;
        if (message.getTarget() != null) {
            str = message.getTarget().toString();
        }
        executingMessage.target = str;
        return executingMessage;
    }

    private int getNextIndex() {
        return ((this.mIndex + 1) + 100) % 100;
    }

    public ExecutedMessage getCurrentMessage() {
        if (this.mMsgStartWallTime != 0 && this.mMsgStartCpuTime != 0) {
            this.mCurrentMessage.wallTime = SystemClock.uptimeMillis() - this.mMsgStartWallTime;
            this.mCurrentMessage.cpuTime = SystemClock.currentThreadTimeMillis() - this.mMsgStartCpuTime;
        } else {
            ExecutedMessage executedMessage = this.mCurrentMessage;
            executedMessage.wallTime = 0L;
            executedMessage.cpuTime = 0L;
        }
        ExecutedMessage executedMessage2 = this.mCurrentMessage;
        executedMessage2.msgDetail = this.mMsgStartDetail;
        return executedMessage2;
    }

    public List<ExecutedMessage> getExecutedMessages() {
        this.mCopying.compareAndSet(false, true);
        ArrayList arrayList = new ArrayList();
        for (int i3 = this.mIndex; i3 < 100; i3++) {
            ExecutedMessage executedMessage = this.mExecutedMessages[i3];
            if (executedMessage != null) {
                arrayList.add(executedMessage.m103clone());
            }
        }
        for (int i16 = 0; i16 < this.mIndex; i16++) {
            ExecutedMessage executedMessage2 = this.mExecutedMessages[i16];
            if (executedMessage2 != null) {
                arrayList.add(executedMessage2.m103clone());
            }
        }
        this.mCopying.compareAndSet(true, false);
        return arrayList;
    }

    public ArrayList<ExecutingMessage> getExecutingMessages() {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            ArrayList<ExecutingMessage> arrayList = new ArrayList<>();
            Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            int i3 = 0;
            Method method = Class.forName("android.os.Looper").getMethod("getQueue", new Class[0]);
            method.setAccessible(true);
            Message message = (Message) declaredField.get((MessageQueue) method.invoke(this.mLooper, new Object[0]));
            if (message != null) {
                arrayList.add(buildExecutingMsg(message, uptimeMillis));
                i3 = 1;
            }
            Field declaredField2 = Class.forName("android.os.Message").getDeclaredField("next");
            declaredField2.setAccessible(true);
            for (Message message2 = (Message) declaredField2.get(message); message2 != null && i3 < 50; message2 = (Message) declaredField2.get(message2)) {
                arrayList.add(buildExecutingMsg(message2, uptimeMillis));
                i3++;
            }
            return arrayList;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.bugly.common.looper.ILooperDispatchListener
    public boolean isOpen() {
        return true;
    }

    @Override // com.tencent.bugly.common.looper.ILooperDispatchListener
    public void onDispatchEnd(@NonNull String str, long j3, long j16) {
        if (this.mMsgStartWallTime <= 0) {
            return;
        }
        this.mMsgEndWallTime = j3;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.mMsgEndCpuTime = currentThreadTimeMillis;
        long j17 = this.mMsgEndWallTime - this.mMsgStartWallTime;
        long j18 = currentThreadTimeMillis - this.mMsgStartCpuTime;
        if (j17 > LONG_MSG_THRESHOLD) {
            int i3 = this.mTempMergeCount;
            if (i3 >= 1) {
                addNode(this.mTempMergeWallTime, this.mTempMergeCpuTime, "", 1, i3);
            }
            addNode(j17, j18, str, 0, 1);
            this.mTempMergeCount = 0;
            this.mTempMergeWallTime = 0L;
            this.mTempMergeCpuTime = 0L;
            return;
        }
        long j19 = this.mTempMergeWallTime + j17;
        this.mTempMergeWallTime = j19;
        long j26 = this.mTempMergeCpuTime + j18;
        this.mTempMergeCpuTime = j26;
        int i16 = this.mTempMergeCount + 1;
        this.mTempMergeCount = i16;
        if (j19 > LONG_MSG_THRESHOLD) {
            addNode(j19, j26, "", 1, i16);
            this.mTempMergeCount = 0;
            this.mTempMergeWallTime = 0L;
            this.mTempMergeCpuTime = 0L;
        }
    }

    @Override // com.tencent.bugly.common.looper.ILooperDispatchListener
    public void onDispatchStart(@NonNull String str, long j3) {
        this.mMsgStartWallTime = j3;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.mMsgStartCpuTime = currentThreadTimeMillis;
        this.mMsgStartDetail = str;
        long j16 = this.mMsgEndWallTime;
        if (j16 > 0) {
            long j17 = this.mMsgStartWallTime - j16;
            if (j17 > 1000) {
                addNode(j17, currentThreadTimeMillis - this.mMsgEndCpuTime, "", 2, 1);
            }
        }
    }
}
