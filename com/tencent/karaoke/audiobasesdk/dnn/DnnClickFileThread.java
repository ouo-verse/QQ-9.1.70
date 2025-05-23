package com.tencent.karaoke.audiobasesdk.dnn;

import android.os.Handler;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.dnn.DnnClickFileThread;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u001a2\u0006\u00102\u001a\u00020%2\b\b\u0002\u00103\u001a\u000204J\u000e\u00105\u001a\u0002002\u0006\u00106\u001a\u00020\u001fJ\b\u00107\u001a\u000200H\u0002R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR\u000e\u0010-\u001a\u00020.X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread;", "Landroid/os/HandlerThread;", "savePath", "", "dnnDebugLog", "Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnDebug;", "(Ljava/lang/String;Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnDebug;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getDnnDebugLog", "()Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnDebug;", "mCurState", "Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread$State;", "getMCurState", "()Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread$State;", "setMCurState", "(Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread$State;)V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mLinkListPool", "Ljava/util/LinkedList;", "", "getMLinkListPool", "()Ljava/util/LinkedList;", "mLinkedListBufferQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/karaoke/audiobasesdk/dnn/DnnUnitJob;", "getMLinkedListBufferQueue", "()Ljava/util/concurrent/LinkedBlockingQueue;", "setMLinkedListBufferQueue", "(Ljava/util/concurrent/LinkedBlockingQueue;)V", "mPerBufferSize", "", "getMPerBufferSize", "()I", "setMPerBufferSize", "(I)V", "mRecordReceiverByteBuffer", "Ljava/nio/ByteBuffer;", "getSavePath", "writeFile", "Ljava/io/RandomAccessFile;", "insertAndStart", "", "input", c.E, "type", "Lcom/tencent/karaoke/audiobasesdk/dnn/DnnUnitType;", "insertJob", "dnnJob", SmsPlugin.API_SEND_SMS, "State", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class DnnClickFileThread extends BaseHandlerThread {

    @NotNull
    private final String TAG;

    @Nullable
    private final RecordDnnDebug dnnDebugLog;

    @NotNull
    private State mCurState;

    @NotNull
    private Handler mHandler;

    @NotNull
    private final LinkedList<byte[]> mLinkListPool;

    @NotNull
    private LinkedBlockingQueue<DnnUnitJob> mLinkedListBufferQueue;
    private int mPerBufferSize;
    private ByteBuffer mRecordReceiverByteBuffer;

    @NotNull
    private final String savePath;
    private RandomAccessFile writeFile;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread$State;", "", "(Ljava/lang/String;I)V", "Start", "Stop", "Error", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public enum State {
        Start,
        Stop,
        Error
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DnnUnitType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DnnUnitType.Write.ordinal()] = 1;
            iArr[DnnUnitType.Flush.ordinal()] = 2;
            iArr[DnnUnitType.Seek.ordinal()] = 3;
            iArr[DnnUnitType.Finish.ordinal()] = 4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DnnClickFileThread(@NotNull String savePath, @Nullable RecordDnnDebug recordDnnDebug) {
        super("DnnClickFileThread" + savePath.hashCode());
        Intrinsics.checkParameterIsNotNull(savePath, "savePath");
        this.savePath = savePath;
        this.dnnDebugLog = recordDnnDebug;
        this.TAG = "DnnClickFileThread" + savePath.hashCode();
        LinkedList<byte[]> linkedList = new LinkedList<>();
        this.mLinkListPool = linkedList;
        this.mLinkedListBufferQueue = new LinkedBlockingQueue<>();
        this.mPerBufferSize = 352800;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(352800 * 4);
        Intrinsics.checkExpressionValueIsNotNull(allocateDirect, "ByteBuffer.allocateDirect(mPerBufferSize*4)");
        this.mRecordReceiverByteBuffer = allocateDirect;
        this.mCurState = State.Start;
        start();
        synchronized (linkedList) {
            for (int i3 = 0; i3 < 2; i3++) {
                this.mLinkListPool.add(new byte[this.mPerBufferSize]);
            }
            Unit unit = Unit.INSTANCE;
        }
        try {
            File file = new File(this.savePath);
            if (file.exists()) {
                boolean delete = file.delete();
                LogUtil.i(this.TAG, "deleteSuccess=" + delete + " for savePath=" + this.savePath);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.savePath, "rw");
            this.writeFile = randomAccessFile;
            randomAccessFile.seek(0L);
            RandomAccessFile randomAccessFile2 = this.writeFile;
            if (randomAccessFile2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("writeFile");
            }
            long length = randomAccessFile2.length();
            RandomAccessFile randomAccessFile3 = this.writeFile;
            if (randomAccessFile3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("writeFile");
            }
            long filePointer = randomAccessFile3.getFilePointer();
            LogUtil.i(this.TAG, "fileLength = " + length + ",filePointer = " + filePointer);
        } catch (FileNotFoundException unused) {
            LogUtil.i(this.TAG, "filenot find error");
            this.mCurState = State.Error;
        }
        this.mHandler = new Handler(getLooper());
    }

    public static final /* synthetic */ RandomAccessFile access$getWriteFile$p(DnnClickFileThread dnnClickFileThread) {
        RandomAccessFile randomAccessFile = dnnClickFileThread.writeFile;
        if (randomAccessFile == null) {
            Intrinsics.throwUninitializedPropertyAccessException("writeFile");
        }
        return randomAccessFile;
    }

    public static /* synthetic */ void insertAndStart$default(DnnClickFileThread dnnClickFileThread, byte[] bArr, int i3, DnnUnitType dnnUnitType, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            dnnUnitType = DnnUnitType.Write;
        }
        dnnClickFileThread.insertAndStart(bArr, i3, dnnUnitType);
    }

    private final void sendMsg() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.dnn.DnnClickFileThread$sendMsg$1
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00fc, code lost:
            
                if (r0 != null) goto L41;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x0122, code lost:
            
                r13.this$0.quit();
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x02a0, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x011a, code lost:
            
                r0 = r0.invoke(java.lang.Boolean.TRUE);
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x0118, code lost:
            
                if (r0 == null) goto L42;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                DnnUnitJob dnnUnitJob;
                ByteBuffer byteBuffer;
                ByteBuffer byteBuffer2;
                ByteBuffer byteBuffer3;
                byte[] bArr;
                ByteBuffer byteBuffer4;
                ByteBuffer byteBuffer5;
                ByteBuffer byteBuffer6;
                ByteBuffer byteBuffer7;
                ByteBuffer byteBuffer8;
                ByteBuffer byteBuffer9;
                ByteBuffer byteBuffer10;
                ByteBuffer byteBuffer11;
                Function1<Boolean, Unit> callback;
                ByteBuffer byteBuffer12;
                ByteBuffer byteBuffer13;
                ByteBuffer byteBuffer14;
                RecordDnnDebug dnnDebugLog = DnnClickFileThread.this.getDnnDebugLog();
                if (dnnDebugLog != null) {
                    dnnDebugLog.writeLog("run,curState=" + DnnClickFileThread.this.getMCurState());
                }
                if (DnnClickFileThread.this.getMLinkedListBufferQueue().isEmpty()) {
                    return;
                }
                DnnClickFileThread.State mCurState = DnnClickFileThread.this.getMCurState();
                DnnClickFileThread.State state = DnnClickFileThread.State.Stop;
                if (mCurState == state || DnnClickFileThread.this.getMCurState() == DnnClickFileThread.State.Error) {
                    return;
                }
                synchronized (DnnClickFileThread.this.getMLinkedListBufferQueue()) {
                    DnnUnitJob poll = DnnClickFileThread.this.getMLinkedListBufferQueue().poll();
                    Intrinsics.checkExpressionValueIsNotNull(poll, "mLinkedListBufferQueue.poll()");
                    dnnUnitJob = poll;
                    Unit unit = Unit.INSTANCE;
                }
                RecordDnnDebug dnnDebugLog2 = DnnClickFileThread.this.getDnnDebugLog();
                if (dnnDebugLog2 != null) {
                    dnnDebugLog2.writeLog("job=" + dnnUnitJob);
                }
                int i3 = DnnClickFileThread.WhenMappings.$EnumSwitchMapping$0[dnnUnitJob.getType().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    byte[] buffer = dnnUnitJob.getBuffer();
                    int reallen = dnnUnitJob.getReallen();
                    if (buffer != null) {
                        byteBuffer = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        if (byteBuffer.remaining() >= reallen) {
                            byteBuffer7 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                            byteBuffer7.put(buffer, 0, reallen);
                        }
                        byteBuffer2 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        byteBuffer2.flip();
                        byteBuffer3 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        if (byteBuffer3.remaining() < DnnClickFileThread.this.getMPerBufferSize()) {
                            RecordDnnDebug dnnDebugLog3 = DnnClickFileThread.this.getDnnDebugLog();
                            if (dnnDebugLog3 != null) {
                                dnnDebugLog3.writeLog("remain<bufferSize");
                            }
                            byteBuffer6 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                            byteBuffer6.compact();
                            return;
                        }
                        synchronized (DnnClickFileThread.this.getMLinkListPool()) {
                            if (DnnClickFileThread.this.getMLinkListPool().size() > 0) {
                                bArr = DnnClickFileThread.this.getMLinkListPool().poll();
                                if (bArr == null) {
                                    bArr = new byte[DnnClickFileThread.this.getMPerBufferSize()];
                                }
                            } else {
                                bArr = new byte[DnnClickFileThread.this.getMPerBufferSize()];
                            }
                        }
                        byteBuffer4 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        byteBuffer4.get(bArr);
                        byteBuffer5 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        byteBuffer5.compact();
                        try {
                            DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).write(bArr, 0, DnnClickFileThread.this.getMPerBufferSize());
                            synchronized (DnnClickFileThread.this.getMLinkListPool()) {
                                if (DnnClickFileThread.this.getMLinkListPool().size() < 3) {
                                    DnnClickFileThread.this.getMLinkListPool().add(bArr);
                                }
                            }
                            return;
                        } catch (Exception unused) {
                            DnnClickFileThread.this.setMCurState(DnnClickFileThread.State.Error);
                            return;
                        }
                    }
                    return;
                }
                if (i3 == 3) {
                    byteBuffer8 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                    byteBuffer8.flip();
                    byteBuffer9 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                    int remaining = byteBuffer9.remaining();
                    if (remaining > 0) {
                        byteBuffer10 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        byteBuffer10.get(new byte[remaining]);
                        byteBuffer11 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        byteBuffer11.compact();
                    }
                    int reallen2 = dnnUnitJob.getReallen();
                    try {
                        long length = DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).length();
                        long j3 = reallen2;
                        if (j3 > length) {
                            DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).seek(length);
                            byte[] bArr2 = new byte[8192];
                            long j16 = j3 - length;
                            long j17 = 8192;
                            long j18 = j16 / j17;
                            for (long j19 = 0; j19 < j18; j19++) {
                                DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).write(bArr2);
                            }
                            DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).write(bArr2, 0, (int) (j16 % j17));
                            return;
                        }
                        DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).seek(j3);
                        DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).setLength(j3);
                        return;
                    } catch (Exception unused2) {
                        DnnClickFileThread.this.setMCurState(DnnClickFileThread.State.Error);
                        return;
                    }
                }
                if (i3 != 4) {
                    return;
                }
                LogUtil.i(DnnClickFileThread.this.getTAG(), "finsih file thread");
                try {
                    try {
                        byteBuffer12 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        byteBuffer12.flip();
                        byteBuffer13 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                        int remaining2 = byteBuffer13.remaining();
                        if (remaining2 > 0) {
                            LogUtil.i(DnnClickFileThread.this.getTAG(), "finish,remain=" + remaining2);
                            byte[] bArr3 = new byte[remaining2];
                            byteBuffer14 = DnnClickFileThread.this.mRecordReceiverByteBuffer;
                            byteBuffer14.get(bArr3);
                            DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).write(bArr3);
                        }
                        DnnClickFileThread.access$getWriteFile$p(DnnClickFileThread.this).close();
                        DnnClickFileThread.this.setMCurState(state);
                        callback = dnnUnitJob.getCallback();
                    } catch (Exception unused3) {
                        LogUtil.i(DnnClickFileThread.this.getTAG(), "writeFile exception occur");
                        DnnClickFileThread.this.setMCurState(DnnClickFileThread.State.Stop);
                        callback = dnnUnitJob.getCallback();
                    }
                } catch (Throwable th5) {
                    DnnClickFileThread.this.setMCurState(DnnClickFileThread.State.Stop);
                    Function1<Boolean, Unit> callback2 = dnnUnitJob.getCallback();
                    if (callback2 != null) {
                        callback2.invoke(Boolean.TRUE);
                    }
                    DnnClickFileThread.this.quit();
                    throw th5;
                }
            }
        });
    }

    @Nullable
    public final RecordDnnDebug getDnnDebugLog() {
        return this.dnnDebugLog;
    }

    @NotNull
    public final State getMCurState() {
        return this.mCurState;
    }

    @NotNull
    public final Handler getMHandler() {
        return this.mHandler;
    }

    @NotNull
    public final LinkedList<byte[]> getMLinkListPool() {
        return this.mLinkListPool;
    }

    @NotNull
    public final LinkedBlockingQueue<DnnUnitJob> getMLinkedListBufferQueue() {
        return this.mLinkedListBufferQueue;
    }

    public final int getMPerBufferSize() {
        return this.mPerBufferSize;
    }

    @NotNull
    public final String getSavePath() {
        return this.savePath;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final void insertAndStart(@Nullable byte[] input, int len, @NotNull DnnUnitType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        insertJob(new DnnUnitJob(input, len, type, null, 8, null));
    }

    public final void insertJob(@NotNull DnnUnitJob dnnJob) {
        Intrinsics.checkParameterIsNotNull(dnnJob, "dnnJob");
        this.mLinkedListBufferQueue.offer(dnnJob);
        sendMsg();
    }

    public final void setMCurState(@NotNull State state) {
        Intrinsics.checkParameterIsNotNull(state, "<set-?>");
        this.mCurState = state;
    }

    public final void setMHandler(@NotNull Handler handler) {
        Intrinsics.checkParameterIsNotNull(handler, "<set-?>");
        this.mHandler = handler;
    }

    public final void setMLinkedListBufferQueue(@NotNull LinkedBlockingQueue<DnnUnitJob> linkedBlockingQueue) {
        Intrinsics.checkParameterIsNotNull(linkedBlockingQueue, "<set-?>");
        this.mLinkedListBufferQueue = linkedBlockingQueue;
    }

    public final void setMPerBufferSize(int i3) {
        this.mPerBufferSize = i3;
    }

    public /* synthetic */ DnnClickFileThread(String str, RecordDnnDebug recordDnnDebug, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : recordDnnDebug);
    }
}
