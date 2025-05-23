package com.tencent.component.media.image;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MessageQueueDownloadMultiplexTask extends ImageTask {
    private static final int MSG_CHECK_SAME_IMAGE_TASK = 1000;
    private static Handler mDispatcher;
    private static int mObjectPoolSize;
    private static MessageQueueDownloadMultiplexTask sPool;
    private static final Object sPoolSync;
    private MessageQueueDownloadMultiplexTask next;
    private static HashMap<String, LinkedList<MessageQueueDownloadMultiplexTask>> mDownloadImageTaskQueue = new HashMap<>();
    private static boolean needRetry = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class ImageDownloadMultiplexHandler extends Handler {
        public ImageDownloadMultiplexHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 11) {
                            if (i3 != 12) {
                                if (i3 == 1000) {
                                    MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask = (MessageQueueDownloadMultiplexTask) message.obj;
                                    if (!MessageQueueDownloadMultiplexTask.hasSameDownloadImageTask(messageQueueDownloadMultiplexTask) && messageQueueDownloadMultiplexTask.getImageKey() != null) {
                                        if (messageQueueDownloadMultiplexTask.getNextTask() != null) {
                                            if (!messageQueueDownloadMultiplexTask.getImageKey().needDecode()) {
                                                ImageTracer.start(messageQueueDownloadMultiplexTask.getImageKey().url);
                                            }
                                            messageQueueDownloadMultiplexTask.getNextTask().excuteTask();
                                            return;
                                        }
                                        messageQueueDownloadMultiplexTask.setResult(1, messageQueueDownloadMultiplexTask.getImageKey().url);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask2 = (MessageQueueDownloadMultiplexTask) ((Object[]) message.obj)[0];
                            if (messageQueueDownloadMultiplexTask2 != null && messageQueueDownloadMultiplexTask2.getImageKey() != null) {
                                List<ImageTask> removeSameDownloadImageTask = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(messageQueueDownloadMultiplexTask2.getImageKey().urlKey);
                                if (removeSameDownloadImageTask != null) {
                                    for (ImageTask imageTask : removeSameDownloadImageTask) {
                                        if (imageTask != null) {
                                            imageTask.setResult(12, new Object[0]);
                                        }
                                    }
                                }
                                messageQueueDownloadMultiplexTask2.setResult(12, new Object[0]);
                                return;
                            }
                            return;
                        }
                        Object[] objArr = (Object[]) message.obj;
                        MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask3 = (MessageQueueDownloadMultiplexTask) objArr[0];
                        if (messageQueueDownloadMultiplexTask3 != null && messageQueueDownloadMultiplexTask3.getImageKey() != null) {
                            List<ImageTask> removeSameDownloadImageTask2 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(messageQueueDownloadMultiplexTask3.getImageKey().urlKey);
                            if (removeSameDownloadImageTask2 != null) {
                                for (ImageTask imageTask2 : removeSameDownloadImageTask2) {
                                    if (imageTask2 != null) {
                                        imageTask2.setResult(11, objArr[1]);
                                    }
                                }
                            }
                            messageQueueDownloadMultiplexTask3.setResult(11, objArr[1]);
                            return;
                        }
                        return;
                    }
                    Object[] objArr2 = (Object[]) message.obj;
                    MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask4 = (MessageQueueDownloadMultiplexTask) objArr2[0];
                    if (messageQueueDownloadMultiplexTask4 != null && messageQueueDownloadMultiplexTask4.getImageKey() != null) {
                        List<ImageTask> removeSameDownloadImageTask3 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(messageQueueDownloadMultiplexTask4.getImageKey().urlKey);
                        if (removeSameDownloadImageTask3 != null) {
                            for (ImageTask imageTask3 : removeSameDownloadImageTask3) {
                                if (imageTask3 != null) {
                                    imageTask3.setResult(2, objArr2[1], objArr2[2], objArr2[3]);
                                }
                            }
                        }
                        messageQueueDownloadMultiplexTask4.setResult(2, objArr2[1], objArr2[2], objArr2[3]);
                        return;
                    }
                    return;
                }
                Object[] objArr3 = (Object[]) message.obj;
                MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask5 = (MessageQueueDownloadMultiplexTask) objArr3[0];
                if (messageQueueDownloadMultiplexTask5 != null && messageQueueDownloadMultiplexTask5.getImageKey() != null) {
                    List<ImageTask> removeSameDownloadImageTask4 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(messageQueueDownloadMultiplexTask5.getImageKey().urlKey);
                    if (removeSameDownloadImageTask4 != null) {
                        for (ImageTask imageTask4 : removeSameDownloadImageTask4) {
                            if (imageTask4 != null) {
                                imageTask4.setResult(1, objArr3[1]);
                            }
                        }
                    }
                    messageQueueDownloadMultiplexTask5.setResult(1, objArr3[1]);
                    return;
                }
                return;
            }
            Object[] objArr4 = (Object[]) message.obj;
            MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask6 = (MessageQueueDownloadMultiplexTask) objArr4[0];
            if (messageQueueDownloadMultiplexTask6 != null && messageQueueDownloadMultiplexTask6.getImageKey() != null) {
                List<ImageTask> removeSameDownloadImageTask5 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(messageQueueDownloadMultiplexTask6.getImageKey().urlKey);
                if (removeSameDownloadImageTask5 != null) {
                    for (ImageTask imageTask5 : removeSameDownloadImageTask5) {
                        if (imageTask5 != null) {
                            imageTask5.setResult(0, objArr4[1]);
                        }
                    }
                }
                messageQueueDownloadMultiplexTask6.setResult(0, objArr4[1]);
            }
        }
    }

    static {
        mDispatcher = null;
        if (ImageManagerEnv.g().getDispatcher() == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ImageDownloadMultiplexThread");
            baseHandlerThread.start();
            mDispatcher = new ImageDownloadMultiplexHandler(baseHandlerThread.getLooper());
        } else {
            mDispatcher = new ImageDownloadMultiplexHandler(ImageManagerEnv.g().getDispatcher());
        }
        sPool = null;
        sPoolSync = new Object();
        mObjectPoolSize = 0;
        clearAndInitSize();
    }

    MessageQueueDownloadMultiplexTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask = new MessageQueueDownloadMultiplexTask(null);
                messageQueueDownloadMultiplexTask.next = sPool;
                sPool = messageQueueDownloadMultiplexTask;
                mObjectPoolSize++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r1 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        com.tencent.component.media.image.MessageQueueDownloadMultiplexTask.mDownloadImageTaskQueue.remove(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0009, code lost:
    
        if (r0 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r0.size() <= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        r1 = r0.removeFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MessageQueueDownloadMultiplexTask getNextSameDownloadImageTask(String str) {
        LinkedList<MessageQueueDownloadMultiplexTask> linkedList = mDownloadImageTaskQueue.get(str);
        MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasSameDownloadImageTask(MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask) {
        if (messageQueueDownloadMultiplexTask == null || messageQueueDownloadMultiplexTask.getImageKey() == null) {
            return false;
        }
        String str = messageQueueDownloadMultiplexTask.getImageKey().urlKey;
        LinkedList<MessageQueueDownloadMultiplexTask> linkedList = mDownloadImageTaskQueue.get(str);
        if (linkedList == null) {
            mDownloadImageTaskQueue.put(str, new LinkedList<>());
            return false;
        }
        linkedList.addLast(messageQueueDownloadMultiplexTask);
        return true;
    }

    public static MessageQueueDownloadMultiplexTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                MessageQueueDownloadMultiplexTask messageQueueDownloadMultiplexTask = sPool;
                if (messageQueueDownloadMultiplexTask != null) {
                    sPool = messageQueueDownloadMultiplexTask.next;
                    messageQueueDownloadMultiplexTask.next = null;
                    mObjectPoolSize--;
                    messageQueueDownloadMultiplexTask.setImageTask(imageTask);
                    return messageQueueDownloadMultiplexTask;
                }
            }
        }
        return new MessageQueueDownloadMultiplexTask(imageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<MessageQueueDownloadMultiplexTask> removeSameDownloadImageTask(String str) {
        return mDownloadImageTaskQueue.remove(str);
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
        if (!getImageKey().needDecode()) {
            ImageTracer.end(getImageKey().url);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 11) {
                        if (i3 != 12) {
                            setResult(i3, objArr);
                            return;
                        }
                        Message obtainMessage = mDispatcher.obtainMessage();
                        obtainMessage.what = 12;
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
                Message obtainMessage3 = mDispatcher.obtainMessage();
                obtainMessage3.what = 2;
                obtainMessage3.obj = new Object[]{this, objArr[0], objArr[1], objArr[2]};
                obtainMessage3.sendToTarget();
                return;
            }
            if (!needRetry) {
                Message obtainMessage4 = mDispatcher.obtainMessage();
                obtainMessage4.what = 1;
                obtainMessage4.obj = new Object[]{this, objArr[0]};
                obtainMessage4.sendToTarget();
                return;
            }
            return;
        }
        if (!needRetry) {
            Message obtainMessage5 = mDispatcher.obtainMessage();
            obtainMessage5.what = 0;
            obtainMessage5.obj = new Object[]{this, objArr[0]};
            obtainMessage5.sendToTarget();
        }
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
