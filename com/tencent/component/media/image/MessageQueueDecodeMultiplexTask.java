package com.tencent.component.media.image;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MessageQueueDecodeMultiplexTask extends ImageTask {
    private static final int MSG_CHECK_SAME_IMAGE_TASK = 1000;
    private static final int MSG_RETRY = 2;
    private static final int MSG_SET_RESULT = 1;
    private static Handler mDispatcher;
    private static int mObjectPoolSize;
    private static MessageQueueDecodeMultiplexTask sPool;
    private static final Object sPoolSync;
    private MessageQueueDecodeMultiplexTask next;
    private static HashMap<Integer, LinkedList<MessageQueueDecodeMultiplexTask>> mDecodeImageTaskQueue = new HashMap<>();
    private static boolean needRetry = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class ImageDecodeMultiplexHandler extends Handler {
        public ImageDecodeMultiplexHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ImageLoader.Options options;
            int i3 = message.what;
            if (i3 != 8) {
                if (i3 != 9) {
                    if (i3 != 11) {
                        if (i3 != 13) {
                            if (i3 == 1000) {
                                MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask) message.obj;
                                if (!MessageQueueDecodeMultiplexTask.hasSameDecodeImageTask(messageQueueDecodeMultiplexTask)) {
                                    ImageManager.getInstance().imageKeyFilePathCheck(messageQueueDecodeMultiplexTask.getImageKey());
                                    if (messageQueueDecodeMultiplexTask.getNextTask() != null) {
                                        ImageTracer.start(messageQueueDecodeMultiplexTask.getImageKey().url);
                                        messageQueueDecodeMultiplexTask.getNextTask().excuteTask();
                                        return;
                                    }
                                    ImageKey imageKey = messageQueueDecodeMultiplexTask.getImageKey();
                                    if (imageKey != null && (options = imageKey.options) != null) {
                                        options.errCode = ImageManager.getErrorString(imageKey, 700);
                                    }
                                    messageQueueDecodeMultiplexTask.setResult(9, new Object[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask2 = (MessageQueueDecodeMultiplexTask) ((Object[]) message.obj)[0];
                        if (messageQueueDecodeMultiplexTask2 != null && messageQueueDecodeMultiplexTask2.getImageKey() != null) {
                            List<MessageQueueDecodeMultiplexTask> removeSameDecodeImageTask = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(messageQueueDecodeMultiplexTask2.getImageKey().hashCodeEx());
                            if (removeSameDecodeImageTask != null) {
                                for (MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask3 : removeSameDecodeImageTask) {
                                    if (messageQueueDecodeMultiplexTask3 != null && messageQueueDecodeMultiplexTask3.isCanceled()) {
                                        messageQueueDecodeMultiplexTask3.setResult(13, new Object[0]);
                                    } else if (messageQueueDecodeMultiplexTask3 != null && !messageQueueDecodeMultiplexTask3.isCanceled() && !MessageQueueDecodeMultiplexTask.hasSameDecodeImageTask(messageQueueDecodeMultiplexTask3)) {
                                        ImageManager.getInstance().imageKeyFilePathCheck(messageQueueDecodeMultiplexTask3.getImageKey());
                                        if (messageQueueDecodeMultiplexTask3.getNextTask() != null) {
                                            ImageTracer.start(messageQueueDecodeMultiplexTask3.getImageKey().url);
                                            messageQueueDecodeMultiplexTask3.getNextTask().excuteTask();
                                        } else {
                                            messageQueueDecodeMultiplexTask3.setResult(9, new Object[0]);
                                        }
                                    }
                                }
                            }
                            ImageManagerLog.d("MessageQueueDecodeMultiplexTask", "decode cancel, url = " + messageQueueDecodeMultiplexTask2.getImageKey().url);
                            return;
                        }
                        return;
                    }
                    Object[] objArr = (Object[]) message.obj;
                    MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask4 = (MessageQueueDecodeMultiplexTask) objArr[0];
                    List<MessageQueueDecodeMultiplexTask> removeSameDecodeImageTask2 = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(messageQueueDecodeMultiplexTask4.getImageKey().hashCodeEx());
                    if (removeSameDecodeImageTask2 != null) {
                        for (MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask5 : removeSameDecodeImageTask2) {
                            if (messageQueueDecodeMultiplexTask5 != null) {
                                messageQueueDecodeMultiplexTask5.setResult(11, objArr[1]);
                            }
                        }
                    }
                    messageQueueDecodeMultiplexTask4.setResult(11, objArr[1]);
                    return;
                }
                MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask6 = (MessageQueueDecodeMultiplexTask) ((Object[]) message.obj)[0];
                if (messageQueueDecodeMultiplexTask6 != null && messageQueueDecodeMultiplexTask6.getImageKey() != null) {
                    ProgressTracer.print(1002, messageQueueDecodeMultiplexTask6.getImageKey().url);
                    List<MessageQueueDecodeMultiplexTask> removeSameDecodeImageTask3 = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(messageQueueDecodeMultiplexTask6.getImageKey().hashCodeEx());
                    if (removeSameDecodeImageTask3 != null) {
                        for (MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask7 : removeSameDecodeImageTask3) {
                            if (messageQueueDecodeMultiplexTask7 != null) {
                                messageQueueDecodeMultiplexTask7.setResult(9, new Object[0]);
                            }
                        }
                    }
                }
                messageQueueDecodeMultiplexTask6.setResult(9, new Object[0]);
                return;
            }
            Object[] objArr2 = (Object[]) message.obj;
            MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask8 = (MessageQueueDecodeMultiplexTask) objArr2[0];
            if (messageQueueDecodeMultiplexTask8 != null && messageQueueDecodeMultiplexTask8.getImageKey() != null) {
                ProgressTracer.print(4, messageQueueDecodeMultiplexTask8.getImageKey().urlKey);
                List<MessageQueueDecodeMultiplexTask> removeSameDecodeImageTask4 = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(messageQueueDecodeMultiplexTask8.getImageKey().hashCodeEx());
                if (removeSameDecodeImageTask4 != null) {
                    for (MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask9 : removeSameDecodeImageTask4) {
                        if (messageQueueDecodeMultiplexTask9 != null) {
                            messageQueueDecodeMultiplexTask9.setResult(8, objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6]);
                        }
                    }
                }
                messageQueueDecodeMultiplexTask8.setResult(8, objArr2[1], objArr2[2], objArr2[3], objArr2[4], objArr2[5], objArr2[6]);
            }
        }
    }

    static {
        mDispatcher = null;
        if (ImageManagerEnv.g().getDispatcher() != null) {
            mDispatcher = new ImageDecodeMultiplexHandler(ImageManagerEnv.g().getDispatcher());
        } else {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ImageDecodeMultiplexThread");
            baseHandlerThread.start();
            mDispatcher = new ImageDecodeMultiplexHandler(baseHandlerThread.getLooper());
        }
        sPool = null;
        sPoolSync = new Object();
        mObjectPoolSize = 0;
        clearAndInitSize();
    }

    MessageQueueDecodeMultiplexTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask = new MessageQueueDecodeMultiplexTask(null);
                messageQueueDecodeMultiplexTask.next = sPool;
                sPool = messageQueueDecodeMultiplexTask;
                mObjectPoolSize++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r1 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        com.tencent.component.media.image.MessageQueueDecodeMultiplexTask.mDecodeImageTaskQueue.remove(java.lang.Integer.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000d, code lost:
    
        if (r0 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (r0.size() <= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r1 = r0.removeFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MessageQueueDecodeMultiplexTask getNextSameDecodeImageTask(int i3) {
        LinkedList<MessageQueueDecodeMultiplexTask> linkedList = mDecodeImageTaskQueue.get(Integer.valueOf(i3));
        MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasSameDecodeImageTask(MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask) {
        if (messageQueueDecodeMultiplexTask.getImageKey() == null) {
            return true;
        }
        int hashCodeEx = messageQueueDecodeMultiplexTask.getImageKey().hashCodeEx();
        LinkedList<MessageQueueDecodeMultiplexTask> linkedList = mDecodeImageTaskQueue.get(Integer.valueOf(hashCodeEx));
        if (linkedList == null) {
            mDecodeImageTaskQueue.put(Integer.valueOf(hashCodeEx), new LinkedList<>());
            return false;
        }
        linkedList.addLast(messageQueueDecodeMultiplexTask);
        return true;
    }

    public static MessageQueueDecodeMultiplexTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                MessageQueueDecodeMultiplexTask messageQueueDecodeMultiplexTask = sPool;
                if (messageQueueDecodeMultiplexTask != null) {
                    sPool = messageQueueDecodeMultiplexTask.next;
                    messageQueueDecodeMultiplexTask.next = null;
                    mObjectPoolSize--;
                    messageQueueDecodeMultiplexTask.setImageTask(imageTask);
                    return messageQueueDecodeMultiplexTask;
                }
            }
        }
        return new MessageQueueDecodeMultiplexTask(imageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<MessageQueueDecodeMultiplexTask> removeSameDecodeImageTask(int i3) {
        return mDecodeImageTaskQueue.remove(Integer.valueOf(i3));
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        Message obtainMessage = mDispatcher.obtainMessage();
        obtainMessage.what = 1000;
        obtainMessage.obj = this;
        obtainMessage.sendToTarget();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageKey getImageKey() {
        return super.getImageKey();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getNextTask() {
        return super.getNextTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getPreviousTask() {
        return super.getPreviousTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ boolean isCanceled() {
        return super.isCanceled();
    }

    @Override // com.tencent.component.media.image.ImageTask
    protected void onResult(int i3, Object... objArr) {
        ImageTracer.end(getImageKey().url);
        if (i3 != 8) {
            if (i3 != 9) {
                if (i3 != 11) {
                    if (i3 != 13) {
                        setResult(i3, objArr);
                        return;
                    }
                    Message obtainMessage = mDispatcher.obtainMessage();
                    obtainMessage.what = 13;
                    obtainMessage.obj = new Object[]{this};
                    obtainMessage.sendToTarget();
                    return;
                }
                Message obtainMessage2 = mDispatcher.obtainMessage();
                obtainMessage2.what = 11;
                obtainMessage2.obj = new Object[]{this, objArr[0]};
                obtainMessage2.sendToTarget();
                return;
            }
            if (!needRetry) {
                Message obtainMessage3 = mDispatcher.obtainMessage();
                obtainMessage3.what = 9;
                obtainMessage3.obj = new Object[]{this};
                obtainMessage3.sendToTarget();
                return;
            }
            return;
        }
        Message obtainMessage4 = mDispatcher.obtainMessage();
        obtainMessage4.what = 8;
        obtainMessage4.obj = new Object[]{this, objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]};
        obtainMessage4.sendToTarget();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void recycle() {
        if (!ImageTask.needRecycle) {
            return;
        }
        reset();
        synchronized (sPoolSync) {
            int i3 = mObjectPoolSize;
            if (i3 < 50) {
                this.next = sPool;
                sPool = this;
                mObjectPoolSize = i3 + 1;
            }
        }
    }
}
