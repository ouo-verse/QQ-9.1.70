package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.NoteItem;
import com.tencent.karaoke.audiobasesdk.audiofx.SoundProbe;
import com.tencent.karaoke.audiobasesdk.audiofx.Visualizer;
import com.tencent.karaoke.audiobasesdk.commom.PublicPitchUtil;
import com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule;
import com.tencent.karaoke.audiobasesdk.scorer.IScore;
import com.tencent.karaoke.audiobasesdk.scorer.IScoreResult;
import com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult;
import com.tencent.karaoke.audiobasesdk.scorer.MultiScoreStcInfo;
import com.tencent.karaoke.audiobasesdk.scorer.ScoreConfig;
import com.tencent.karaoke.audiobasesdk.scorer.ScoreResultCallback;
import com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import yz0.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AbstractKaraRecorder implements com.tencent.karaoke.recordsdk.media.f, o {
    static final int MSG_RECORD_START = 3;
    private static final int MSG_RESUME = 1;
    private static final int MSG_START = 2;
    private static final int MST_VIVO_FEEDBACK_ON = 4;
    private static final int MST_VIVO_FEEDBACK_ON_DELAY_TIME = 500;
    private static final String TAG = "AbstractKaraRecorder";
    public static boolean sEnableEvaluateUnfinishSentence = false;
    public static boolean sEnableMultiScore = true;
    public static boolean sEnableNewAcfScore = false;
    public static boolean sEnableNewScoreAfterRefactor = true;
    public static int sEvaluateUnfinishSentenceWaitTimeMs = 300;
    public static boolean sIsRap = false;
    public k mAudioSilenceEventImpl;
    protected r mCallback;
    protected final d mCurrentState;
    private volatile boolean mEnableReplaceTest;
    protected com.tencent.karaoke.recordsdk.media.i mErrListener;
    protected Handler mHandler;
    protected HandlerThread mHandlerThread;
    protected volatile int mHasRecordLength;
    protected boolean mIsAcapella;
    private volatile boolean mIsBeforeSeek;
    private boolean mIsEvaluateAdded;
    volatile boolean mIsNeedIgnore;
    private boolean mIsOriginal;
    private boolean mIsSpeaker;
    protected volatile boolean mIsWaitingForPlayStart;
    volatile long mLastRecordIgnoreTime;
    private long mLastRecordTime;
    protected com.tencent.karaoke.recordsdk.media.e mOnDelayListener;
    protected int mPlayDelay;
    protected long mPlayStartTime;
    protected List<com.tencent.karaoke.recordsdk.media.g> mRecListeners;
    protected int mRecordDelay;
    protected int mRecordIgnoreCount;
    protected s mRecordParam;
    private p mRecordStartListener;
    private yz0.b mRecordStatistic;
    protected int mRecordTotalDelayBias;
    protected int mRecordTotalDelayCount;
    private RandomAccessFile mReplaceTestFile;

    @Nullable
    protected vz0.a mReportImpl;
    protected IScore mScore;
    private com.tencent.karaoke.recordsdk.media.c mScoreInfo;
    private final Object mScoreLock;
    protected LinkedList<c> mSeekRequests;
    private com.tencent.karaoke.recordsdk.media.j mSingListener;
    protected com.tencent.karaoke.recordsdk.media.d mSingModel;
    protected int mStartPosition;
    private long mStartRecordTime;
    private boolean mSyncEnable;
    protected int mSyncPosition;
    protected long mSyncTimeMillis;
    private q mVivoListener;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class EvaluateThread extends BaseHandlerThread implements com.tencent.karaoke.recordsdk.media.g {
        protected SoundProbe C;
        private int D;
        private Handler E;
        private ByteBuffer F;
        private com.tencent.karaoke.recordsdk.media.j G;
        private volatile int H;
        private LinkedList<byte[]> I;
        private Function3<Integer, Integer, Float, Unit> J;

        /* renamed from: m, reason: collision with root package name */
        protected Visualizer f116980m;

        public EvaluateThread(com.tencent.karaoke.recordsdk.media.j jVar, int i3) {
            super("KaraRecorder.EvaluateThread-" + System.currentTimeMillis());
            this.I = new LinkedList<>();
            this.J = new Function3() { // from class: com.tencent.karaoke.recordsdk.media.audio.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit m3;
                    m3 = AbstractKaraRecorder.EvaluateThread.this.m((Integer) obj, (Integer) obj2, (Float) obj3);
                    return m3;
                }
            };
            LogUtil.i(AbstractKaraRecorder.TAG, "perBufSize : " + i3);
            this.G = jVar;
            this.D = i3;
            this.F = ByteBuffer.allocate(i3 * 4);
            Visualizer visualizer = new Visualizer();
            this.f116980m = visualizer;
            int visualizerInit = visualizer.visualizerInit();
            if (visualizerInit != 0) {
                LogUtil.w(AbstractKaraRecorder.TAG, "can't initilize Visualizer: " + visualizerInit);
                this.f116980m = null;
            }
            for (int i16 = 0; i16 < 2; i16++) {
                this.I.add(new byte[this.D]);
            }
            SoundProbe soundProbe = new SoundProbe();
            this.C = soundProbe;
            int init = soundProbe.init(44100, 2);
            if (init != 0) {
                LogUtil.w(AbstractKaraRecorder.TAG, "can't initilize Visualizer: " + init);
                this.C = null;
            }
            start();
            this.E = new Handler(getLooper());
            IScore iScore = AbstractKaraRecorder.this.mScore;
            if (iScore != null) {
                iScore.setScoreResultCallback(new ScoreResultCallback() { // from class: com.tencent.karaoke.recordsdk.media.audio.g
                    @Override // com.tencent.karaoke.audiobasesdk.scorer.ScoreResultCallback
                    public final void scoreResultCallback(IScoreResult iScoreResult, float f16) {
                        AbstractKaraRecorder.EvaluateThread.this.n(iScoreResult, f16);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit m(Integer num, Integer num2, Float f16) {
            com.tencent.karaoke.recordsdk.media.j jVar = this.G;
            if (jVar != null) {
                int intValue = num.intValue();
                boolean z16 = true;
                if (num2.intValue() != 1) {
                    z16 = false;
                }
                jVar.d(intValue, z16, f16.longValue());
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(IScoreResult iScoreResult, float f16) {
            final int lastScoreTmp;
            if (iScoreResult != null && (lastScoreTmp = iScoreResult.getLastScoreTmp()) >= 0) {
                final Pair<Integer, int[]> sentenceScores = iScoreResult.getSentenceScores();
                final byte[] newScores = iScoreResult.getNewScores();
                final boolean isSeek = iScoreResult.isSeek();
                final int[] pYinSentenceScores = iScoreResult.pYinSentenceScores();
                final int[] acfSentenceScores = iScoreResult.acfSentenceScores();
                final int lastSkillTrillCount = iScoreResult.getLastSkillTrillCount();
                final int lastSkillGlintCount = iScoreResult.getLastSkillGlintCount();
                final int lastSkillTransliterationCount = iScoreResult.getLastSkillTransliterationCount();
                final int lastStableScore = iScoreResult.lastStableScore();
                final int lastRhythmScore = iScoreResult.lastRhythmScore();
                final int lastLongtoneScore = iScoreResult.lastLongtoneScore();
                final int lastSentenceMultiScoreIndex = iScoreResult.lastSentenceMultiScoreIndex();
                LogUtil.i(AbstractKaraRecorder.TAG, "stableScore = " + lastStableScore + "rhythmSetScore = " + lastRhythmScore + "longtoneScore = " + lastLongtoneScore + "scoreIndex = " + lastSentenceMultiScoreIndex);
                this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractKaraRecorder.EvaluateThread.this.o(sentenceScores, newScores, pYinSentenceScores, acfSentenceScores, isSeek, lastScoreTmp, lastSentenceMultiScoreIndex, lastSkillTrillCount, lastSkillGlintCount, lastSkillTransliterationCount, lastStableScore, lastRhythmScore, lastLongtoneScore);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Pair pair, byte[] bArr, int[] iArr, int[] iArr2, boolean z16, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            com.tencent.karaoke.recordsdk.media.j jVar;
            if (this.C != null) {
                LogUtil.i(AbstractKaraRecorder.TAG, "score -> current loudness:" + this.C.getLoudness());
            }
            com.tencent.karaoke.recordsdk.media.d dVar = AbstractKaraRecorder.this.mSingModel;
            if (dVar != null) {
                dVar.l(((Integer) pair.getFirst()).intValue());
                AbstractKaraRecorder.this.mSingModel.f((int[]) pair.getSecond());
                AbstractKaraRecorder.this.mSingModel.i(bArr);
                AbstractKaraRecorder.this.mSingModel.n(iArr);
                AbstractKaraRecorder.this.mSingModel.c(iArr2);
            }
            if (z16 || (jVar = this.G) == null) {
                return;
            }
            jVar.e(0, i3, ((Integer) pair.getFirst()).intValue(), (int[]) pair.getSecond(), bArr);
            this.G.a(0, i3, ((Integer) pair.getFirst()).intValue(), (int[]) pair.getSecond(), bArr, i16);
            this.G.g(i17, i18, i19);
            this.G.c(i26, i27, i28, i16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(float[][] fArr, float f16, byte[] bArr) {
            AbstractKaraRecorder abstractKaraRecorder = AbstractKaraRecorder.this;
            if (abstractKaraRecorder.mScore != null && fArr != null) {
                if (abstractKaraRecorder.mSingListener != null) {
                    AbstractKaraRecorder.this.mSingListener.b(fArr, f16);
                }
                IScore iScore = AbstractKaraRecorder.this.mScore;
                if (iScore != null) {
                    iScore.processWithBuffer(bArr, f16, this.D, fArr);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit q(final float f16, final byte[] bArr, final float[][] fArr) {
            if (AbstractKaraRecorder.this.mScore == null) {
                return null;
            }
            this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.j
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractKaraRecorder.EvaluateThread.this.p(fArr, f16, bArr);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(final byte[] bArr, int i3) {
            int process;
            Visualizer visualizer = this.f116980m;
            if (visualizer != null) {
                int visualizerProcess = visualizer.visualizerProcess(bArr, this.D);
                if (visualizerProcess >= 0) {
                    this.G.f(visualizerProcess);
                } else {
                    LogUtil.w(AbstractKaraRecorder.TAG, "visualize error: " + visualizerProcess);
                }
            }
            SoundProbe soundProbe = this.C;
            if (soundProbe != null && (process = soundProbe.process(bArr, this.D)) != 0) {
                LogUtil.w(AbstractKaraRecorder.TAG, "sound probe error: " + process);
            }
            AbstractKaraRecorder abstractKaraRecorder = AbstractKaraRecorder.this;
            if (!abstractKaraRecorder.mIsAcapella && abstractKaraRecorder.mScore != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                float a16 = (float) wz0.a.a(i3 - this.D);
                final float f16 = a16 + r2.mStartPosition;
                synchronized (AbstractKaraRecorder.this.mScoreLock) {
                    if (AbstractKaraRecorder.this.mIsBeforeSeek) {
                        LogUtil.i(AbstractKaraRecorder.TAG, "onRecord -> ignore for seek");
                        return;
                    }
                    RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
                    if (recordPublicProcessorModule.isEnablePublicPitch()) {
                        recordPublicProcessorModule.processData(bArr, this.D, f16, new Function1() { // from class: com.tencent.karaoke.recordsdk.media.audio.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit q16;
                                q16 = AbstractKaraRecorder.EvaluateThread.this.q(f16, bArr, (float[][]) obj);
                                return q16;
                            }
                        });
                    } else {
                        IScore iScore = AbstractKaraRecorder.this.mScore;
                        if (iScore != null) {
                            iScore.processWithBuffer(bArr, f16, this.D, null);
                        }
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    if (elapsedRealtime2 > 50) {
                        LogUtil.i(AbstractKaraRecorder.TAG, "onRecord -> score cost :" + elapsedRealtime2);
                    }
                    synchronized (this.I) {
                        if (this.I.size() < 4) {
                            this.I.add(bArr);
                        }
                    }
                    IScore iScore2 = AbstractKaraRecorder.this.mScore;
                    if (iScore2 != null) {
                        iScore2.getGroveAndHit(f16, 0.0f, this.J);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit s(ArrayList arrayList) {
            AbstractKaraRecorder.this.updateMultiScoreResult(arrayList);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit t(MultiScoreResult multiScoreResult, MultiScoreResult multiScoreResult2) {
            AbstractKaraRecorder.this.updateFinalMultiScoreResult(multiScoreResult, multiScoreResult2);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u() {
            LogUtil.i(AbstractKaraRecorder.TAG, "maybeFillSentences >>>");
            AbstractKaraRecorder.access$1100(AbstractKaraRecorder.this);
            LogUtil.i(AbstractKaraRecorder.TAG, "maybeFillSentences >>> skip, no score info");
        }

        @Override // com.tencent.karaoke.recordsdk.media.g
        public void a(int i3, int i16, int i17) {
            com.tencent.karaoke.recordsdk.media.d dVar;
            if (i3 == 0 && (dVar = AbstractKaraRecorder.this.mSingModel) != null) {
                dVar.o(false);
            }
            AbstractKaraRecorder abstractKaraRecorder = AbstractKaraRecorder.this;
            if (abstractKaraRecorder.mScore != null) {
                this.H = abstractKaraRecorder.mHasRecordLength + (this.D / 2);
                float a16 = (float) wz0.a.a(this.H);
                float f16 = a16 + r4.mStartPosition;
                synchronized (AbstractKaraRecorder.this.mScoreLock) {
                    LogUtil.i(AbstractKaraRecorder.TAG, "onSeek -> tmpTime:" + f16);
                    AbstractKaraRecorder.this.mIsBeforeSeek = true;
                    AbstractKaraRecorder.this.mScore.seek(f16);
                    this.F.clear();
                }
            }
        }

        @Override // com.tencent.karaoke.recordsdk.media.g
        public void b(int i3) {
            LogUtil.i(AbstractKaraRecorder.TAG, "onStop, " + getName());
            AbstractKaraRecorder.this.mIsBeforeSeek = true;
            com.tencent.karaoke.recordsdk.media.d dVar = AbstractKaraRecorder.this.mSingModel;
            if (dVar != null) {
                RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
                dVar.d(recordPublicProcessorModule.getMPublicPitchData().getMAiScore());
                AbstractKaraRecorder abstractKaraRecorder = AbstractKaraRecorder.this;
                abstractKaraRecorder.mSingModel.e(new b(recordPublicProcessorModule.getMPublicPitchData().getPitchs5ms(), recordPublicProcessorModule.getMPublicPitchData().getPitchs10ms()));
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final boolean z16 = AbstractKaraRecorder.sEnableEvaluateUnfinishSentence;
            this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder.EvaluateThread.1
                @Override // java.lang.Runnable
                public void run() {
                    IScore iScore;
                    if (z16 && !AbstractKaraRecorder.this.openNewScoreRefactor()) {
                        EvaluateThread.this.u();
                        countDownLatch.countDown();
                    } else {
                        LogUtil.i(AbstractKaraRecorder.TAG, "maybeFillSentences >>> skip, not enable");
                    }
                    RecordPublicProcessorModule recordPublicProcessorModule2 = RecordPublicProcessorModule.INSTANCE;
                    recordPublicProcessorModule2.markAsFinished();
                    recordPublicProcessorModule2.uninit();
                    Visualizer visualizer = EvaluateThread.this.f116980m;
                    if (visualizer != null) {
                        visualizer.visualizerRelease();
                        LogUtil.i(AbstractKaraRecorder.TAG, "mVisual release");
                    }
                    if (!AbstractKaraRecorder.this.openNewScoreRefactor() && (iScore = AbstractKaraRecorder.this.mScore) != null) {
                        iScore.stop();
                        AbstractKaraRecorder.this.mScore = null;
                    }
                    AbstractKaraRecorder.this.mSingListener = null;
                    SoundProbe soundProbe = EvaluateThread.this.C;
                    if (soundProbe != null) {
                        LogUtil.i(AbstractKaraRecorder.TAG, "onStop -> loudness:" + soundProbe.getLoudness());
                        EvaluateThread.this.C.release();
                        EvaluateThread.this.C = null;
                    }
                    if (!AbstractKaraRecorder.this.openNewScoreRefactor()) {
                        EvaluateThread.this.quit();
                    }
                }
            });
            if (!AbstractKaraRecorder.this.openNewScoreRefactor()) {
                AbstractKaraRecorder.this.updateMultiScoreResult(null);
                AbstractKaraRecorder.this.updateFinalMultiScoreResult(null, null);
            } else {
                IScore iScore = AbstractKaraRecorder.this.mScore;
                if (iScore != null) {
                    iScore.tryGetMultiScoreTmp(new Function1() { // from class: com.tencent.karaoke.recordsdk.media.audio.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit s16;
                            s16 = AbstractKaraRecorder.EvaluateThread.this.s((ArrayList) obj);
                            return s16;
                        }
                    });
                    AbstractKaraRecorder.access$1100(AbstractKaraRecorder.this);
                    AbstractKaraRecorder.access$1100(AbstractKaraRecorder.this);
                    AbstractKaraRecorder.this.mScore.setFinalMultiScoreResultCallback(new Function2() { // from class: com.tencent.karaoke.recordsdk.media.audio.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit t16;
                            t16 = AbstractKaraRecorder.EvaluateThread.this.t((MultiScoreResult) obj, (MultiScoreResult) obj2);
                            return t16;
                        }
                    }, null, 0);
                    if (AbstractKaraRecorder.sEnableEvaluateUnfinishSentence) {
                        AbstractKaraRecorder.this.mScore.finish();
                    } else {
                        AbstractKaraRecorder.this.mScore.stop();
                    }
                    AbstractKaraRecorder.this.mScore = null;
                    this.E.getLooper().quitSafely();
                    LogUtil.i(AbstractKaraRecorder.TAG, "mScore release");
                }
            }
            if (z16 && !AbstractKaraRecorder.this.openNewScoreRefactor()) {
                try {
                    int max = Math.max(2000, Math.max(AbstractKaraRecorder.sEvaluateUnfinishSentenceWaitTimeMs, 0) + 1000);
                    LogUtil.i(AbstractKaraRecorder.TAG, "wait " + max + "ms, result=" + countDownLatch.await(max, TimeUnit.MILLISECONDS));
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // com.tencent.karaoke.recordsdk.media.g
        public void c(byte[] bArr, int i3, int i16) {
            final byte[] bArr2;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.tencent.karaoke.recordsdk.media.d dVar = AbstractKaraRecorder.this.mSingModel;
            if (dVar != null) {
                dVar.o(true);
            }
            AbstractKaraRecorder.this.mRecordStatistic.f(elapsedRealtime, i3);
            if (AbstractKaraRecorder.this.mStartRecordTime == 0) {
                AbstractKaraRecorder.this.mStartRecordTime = elapsedRealtime;
            }
            if (AbstractKaraRecorder.this.mLastRecordTime != 0 && elapsedRealtime - AbstractKaraRecorder.this.mLastRecordTime > 100) {
                LogUtil.i(AbstractKaraRecorder.TAG, "onRecord -> recordCost:" + (elapsedRealtime - AbstractKaraRecorder.this.mStartRecordTime) + ", mHasRecordLength:" + AbstractKaraRecorder.this.mHasRecordLength + ", recordTime:" + wz0.a.a(AbstractKaraRecorder.this.mHasRecordLength) + ", curTime:" + elapsedRealtime);
            }
            AbstractKaraRecorder.this.mLastRecordTime = elapsedRealtime;
            if (this.F.remaining() >= i3) {
                this.F.put(bArr, 0, i3);
                this.F.flip();
                if (this.F.remaining() < this.D) {
                    this.F.compact();
                    return;
                }
                synchronized (this.I) {
                    if (this.I.size() > 0) {
                        bArr2 = this.I.peek();
                        this.I.remove();
                    } else {
                        bArr2 = new byte[this.D];
                    }
                }
                this.F.get(bArr2);
                this.F.compact();
                final int length = this.H + bArr2.length;
                this.H = length;
                int i17 = AbstractKaraRecorder.this.mHasRecordLength;
                if (AbstractKaraRecorder.this.mIsBeforeSeek) {
                    AbstractKaraRecorder.this.mIsBeforeSeek = false;
                    return;
                } else {
                    this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractKaraRecorder.EvaluateThread.this.r(bArr2, length);
                        }
                    });
                    return;
                }
            }
            this.F.clear();
        }

        public void v() {
            AbstractKaraRecorder abstractKaraRecorder = AbstractKaraRecorder.this;
            if (abstractKaraRecorder.mScore != null) {
                this.H = abstractKaraRecorder.mHasRecordLength + (this.D / 2);
                float a16 = (float) wz0.a.a(this.H);
                float f16 = a16 + r1.mStartPosition;
                synchronized (AbstractKaraRecorder.this.mScoreLock) {
                    LogUtil.i(AbstractKaraRecorder.TAG, "onSeek -> tmpTime:" + f16);
                    AbstractKaraRecorder.this.mScore.seek(f16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    protected abstract class RecordThread extends BaseThread {
        public RecordThread(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void c(c cVar) {
            LogUtil.i(AbstractKaraRecorder.TAG, "execute Seeking: " + cVar);
            if (AbstractKaraRecorder.this.mIsNeedIgnore) {
                if (!AbstractKaraRecorder.this.mIsWaitingForPlayStart) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - AbstractKaraRecorder.this.mPlayStartTime;
                    LogUtil.i(AbstractKaraRecorder.TAG, "execute Seeking -> start playtime: " + AbstractKaraRecorder.this.mPlayStartTime + ", interval:" + elapsedRealtime);
                    if (cVar.f116989b != 0 || elapsedRealtime > 200) {
                        LogUtil.i(AbstractKaraRecorder.TAG, "execute Seeking -> waiting For PlayStart");
                        AbstractKaraRecorder abstractKaraRecorder = AbstractKaraRecorder.this;
                        abstractKaraRecorder.mRecordIgnoreCount = 0;
                        abstractKaraRecorder.mIsWaitingForPlayStart = true;
                    }
                } else {
                    AbstractKaraRecorder abstractKaraRecorder2 = AbstractKaraRecorder.this;
                    abstractKaraRecorder2.mRecordIgnoreCount = 0;
                    abstractKaraRecorder2.mIsWaitingForPlayStart = true;
                }
            }
            AbstractKaraRecorder abstractKaraRecorder3 = AbstractKaraRecorder.this;
            abstractKaraRecorder3.mPlayStartTime = 0L;
            int i3 = cVar.f116988a;
            if (!abstractKaraRecorder3.mSingModel.b()) {
                int i16 = AbstractKaraRecorder.this.mStartPosition;
                if (i3 < i16) {
                    i3 = 0;
                } else {
                    i3 -= i16;
                }
            }
            int c16 = wz0.a.c(i3);
            AbstractKaraRecorder.this.mHasRecordLength = c16;
            AbstractKaraRecorder abstractKaraRecorder4 = AbstractKaraRecorder.this;
            com.tencent.karaoke.recordsdk.media.d dVar = abstractKaraRecorder4.mSingModel;
            if (dVar != null) {
                dVar.k(((int) wz0.a.a(abstractKaraRecorder4.mHasRecordLength - AbstractKaraRecorder.this.mSyncPosition)) + AbstractKaraRecorder.this.mStartPosition);
            }
            AbstractKaraRecorder.this.mStartRecordTime = SystemClock.elapsedRealtime() - i3;
            AbstractKaraRecorder.this.mRecordStatistic.e();
            LogUtil.i(AbstractKaraRecorder.TAG, String.format("executeSeeking -> seekMillsPos:%d, seekBytePos:%d, HasRecordLength:%d", Integer.valueOf(i3), Integer.valueOf(c16), Integer.valueOf(AbstractKaraRecorder.this.mHasRecordLength)));
            e(c16, cVar.f116990c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void d(byte[] bArr, int i3, int i16) {
            if (AbstractKaraRecorder.this.mEnableReplaceTest && AbstractKaraRecorder.this.mReplaceTestFile != null) {
                try {
                    AbstractKaraRecorder.this.mReplaceTestFile.read(bArr, 0, i3);
                } catch (IOException unused) {
                }
            }
            Iterator<com.tencent.karaoke.recordsdk.media.g> it = AbstractKaraRecorder.this.mRecListeners.iterator();
            while (it.hasNext()) {
                it.next().c(bArr, i3, i16);
            }
        }

        protected void e(int i3, int i16) {
            if (AbstractKaraRecorder.this.mEnableReplaceTest && AbstractKaraRecorder.this.mReplaceTestFile != null) {
                try {
                    AbstractKaraRecorder.this.mReplaceTestFile.seek(i3);
                } catch (IOException unused) {
                    AbstractKaraRecorder.this.mReplaceTestFile = null;
                }
            }
            Iterator<com.tencent.karaoke.recordsdk.media.g> it = AbstractKaraRecorder.this.mRecListeners.iterator();
            while (it.hasNext()) {
                it.next().a((int) wz0.a.a(i3), i3, i16);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void f(int i3) {
            if (AbstractKaraRecorder.this.mEnableReplaceTest && AbstractKaraRecorder.this.mReplaceTestFile != null) {
                try {
                    AbstractKaraRecorder.this.mReplaceTestFile.close();
                } catch (IOException unused) {
                    AbstractKaraRecorder.this.mReplaceTestFile = null;
                }
            }
            Iterator<com.tencent.karaoke.recordsdk.media.g> it = AbstractKaraRecorder.this.mRecListeners.iterator();
            while (it.hasNext()) {
                it.next().b(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            int i3 = message.what;
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            LogUtil.i(AbstractKaraRecorder.TAG, "notify start record after delay");
                            AbstractKaraRecorder.access$500(AbstractKaraRecorder.this);
                            return;
                        }
                        return;
                    }
                    AbstractKaraRecorder.access$100(AbstractKaraRecorder.this);
                    if (AbstractKaraRecorder.this.mSingListener != null) {
                        com.tencent.karaoke.recordsdk.media.j jVar = AbstractKaraRecorder.this.mSingListener;
                        boolean z17 = !AbstractKaraRecorder.this.mIsSpeaker;
                        boolean z18 = AbstractKaraRecorder.this.mIsOriginal;
                        if (AbstractKaraRecorder.this.mScore == null) {
                            z16 = false;
                        }
                        jVar.h(z17, z18, z16);
                    }
                    AbstractKaraRecorder.access$500(AbstractKaraRecorder.this);
                    return;
                }
                LogUtil.i(AbstractKaraRecorder.TAG, "execute start after delay");
                synchronized (AbstractKaraRecorder.this.mCurrentState) {
                    if (AbstractKaraRecorder.this.mCurrentState.a(2)) {
                        AbstractKaraRecorder.this.start((com.tencent.karaoke.recordsdk.media.j) message.obj);
                    } else {
                        LogUtil.i(AbstractKaraRecorder.TAG, "ignore start after delay because of state");
                    }
                }
                return;
            }
            LogUtil.i(AbstractKaraRecorder.TAG, "execute resume after delay");
            synchronized (AbstractKaraRecorder.this.mCurrentState) {
                if (AbstractKaraRecorder.this.mCurrentState.a(8)) {
                    LogUtil.i("RecordStatistic", "resume and reset params");
                    AbstractKaraRecorder.this.mRecordStatistic.d();
                    AbstractKaraRecorder.this.resume();
                } else {
                    LogUtil.i(AbstractKaraRecorder.TAG, "ignore resume after delay because of state");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f116985a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f116986b;

        public b(float[] fArr, float[] fArr2) {
            this.f116985a = fArr;
            this.f116986b = fArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f116988a;

        /* renamed from: b, reason: collision with root package name */
        public final int f116989b;

        /* renamed from: c, reason: collision with root package name */
        public final int f116990c;

        /* renamed from: d, reason: collision with root package name */
        public int f116991d;

        public c(int i3, int i16, int i17, com.tencent.karaoke.recordsdk.media.h hVar) {
            this.f116988a = i3;
            this.f116989b = i16;
            this.f116990c = i17;
            this.f116991d = wz0.a.c(i16);
        }

        public String toString() {
            return "SeekRequest[" + this.f116988a + ", " + this.f116989b + ", " + this.f116990c + ", " + ((Object) null) + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private int f116993a = 1;

        public d() {
        }

        public synchronized boolean a(int i3) {
            boolean z16;
            if ((i3 & this.f116993a) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return z16;
        }

        public synchronized boolean b(int... iArr) {
            boolean z16;
            z16 = false;
            int i3 = 0;
            for (int i16 : iArr) {
                i3 |= i16;
            }
            if ((this.f116993a & i3) != 0) {
                z16 = true;
            }
            return z16;
        }

        public String c(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            if (i3 != 8) {
                                if (i3 != 16) {
                                    return "unknow_state";
                                }
                                return "state_stopped";
                            }
                            return "state_paused";
                        }
                        return "state_started";
                    }
                    return "state_initialized";
                }
                return "state_idle";
            }
            return "state_error";
        }

        public synchronized void d(int i3) {
            LogUtil.i(AbstractKaraRecorder.TAG, "switch state: " + this.f116993a + " -> " + i3);
            this.f116993a = i3;
            AbstractKaraRecorder.this.mCurrentState.notifyAll();
        }

        @NotNull
        public String toString() {
            return "State[" + c(this.f116993a) + "]";
        }
    }

    public AbstractKaraRecorder() {
        this(null, 0, true);
    }

    static /* synthetic */ p access$100(AbstractKaraRecorder abstractKaraRecorder) {
        abstractKaraRecorder.getClass();
        return null;
    }

    static /* synthetic */ com.tencent.karaoke.recordsdk.media.c access$1100(AbstractKaraRecorder abstractKaraRecorder) {
        abstractKaraRecorder.getClass();
        return null;
    }

    static /* synthetic */ q access$500(AbstractKaraRecorder abstractKaraRecorder) {
        abstractKaraRecorder.getClass();
        return null;
    }

    private ScoreConfig getScoreConfig(int i3, final String str, final String str2) {
        return ScoreConfig.INSTANCE.with(new Function1() { // from class: com.tencent.karaoke.recordsdk.media.audio.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ScoreConfig lambda$getScoreConfig$1;
                lambda$getScoreConfig$1 = AbstractKaraRecorder.this.lambda$getScoreConfig$1(str2, str, (ScoreConfig.Builder) obj);
                return lambda$getScoreConfig$1;
            }
        });
    }

    private void initScore(@NonNull com.tencent.karaoke.recordsdk.media.c cVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScoreConfig lambda$getScoreConfig$1(String str, String str2, ScoreConfig.Builder builder) {
        builder.setSample(44100);
        builder.setChannel(2);
        builder.setBitDepth(2);
        builder.setSkillParam(str);
        if (!sEnableNewAcfScore) {
            builder.enableOldAcfScore();
        }
        if (sEnableMultiScore && !TextUtils.isEmpty(str2)) {
            builder.enableMultiScore();
            if (sIsRap) {
                builder.multiScoreIsRap();
            }
        }
        if (!openNewScoreRefactor()) {
            LogUtil.i(TAG, "enable old score");
            builder.setEnableBottomUpPlan(true);
        }
        return builder.build();
    }

    private /* synthetic */ Unit lambda$init$0() {
        Long l3 = 0L;
        RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
        if (recordPublicProcessorModule.getMPublicPitchProcessor() != null) {
            l3 = Long.valueOf(recordPublicProcessorModule.getMPublicPitchProcessor().getExternalNativeHandleId());
        }
        IScore iScore = this.mScore;
        if (iScore != null) {
            iScore.bindPublicPitch(l3.longValue());
            return null;
        }
        return null;
    }

    private /* synthetic */ Unit lambda$initScore$2(NoteItem[] noteItemArr) {
        this.mSingModel.j(noteItemArr);
        this.mSingModel.m(this.mScore.getValidSentenceNum());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openNewScoreRefactor() {
        if (sEnableNewScoreAfterRefactor && RecordPublicProcessorModule.INSTANCE.isEnablePublicPitch()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFinalMultiScoreResult(MultiScoreResult multiScoreResult, MultiScoreResult multiScoreResult2) {
        com.tencent.karaoke.recordsdk.media.d dVar = this.mSingModel;
        if (dVar != null) {
            dVar.g(multiScoreResult, multiScoreResult2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMultiScoreResult(ArrayList<MultiScoreStcInfo> arrayList) {
        com.tencent.karaoke.recordsdk.media.d dVar = this.mSingModel;
        if (dVar != null) {
            dVar.h(arrayList);
        }
    }

    public void addOnRecordListener(com.tencent.karaoke.recordsdk.media.g gVar) {
        LogUtil.i(TAG, "addOnRecordListener: ");
        if (gVar != null) {
            this.mRecListeners.add(gVar);
        } else {
            LogUtil.w(TAG, "addOnRecordListener -> listener is null");
        }
    }

    public d currentState() {
        return this.mCurrentState;
    }

    public void enableReplaceTest(String str) {
        this.mEnableReplaceTest = true;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mReplaceTestFile = new RandomAccessFile(str, "r");
            } catch (FileNotFoundException e16) {
                LogUtil.e(TAG, e16.getMessage());
                this.mReplaceTestFile = null;
            }
        }
    }

    public abstract int getDelay();

    public int getFixTargetPosition(int i3) {
        if (!this.mSingModel.b()) {
            int i16 = this.mStartPosition;
            if (i3 < i16) {
                return 0;
            }
            return i3 - i16;
        }
        return i3;
    }

    public int getMStartPosition() {
        return this.mStartPosition;
    }

    public int[] getNativeAllScore() {
        IScore iScore = this.mScore;
        if (iScore != null) {
            return iScore.getValidScoreArray();
        }
        return null;
    }

    public ConcurrentLinkedQueue<b.a> getRecordStaticsInfo() {
        return this.mRecordStatistic.b();
    }

    public s getmRecordParam() {
        return this.mRecordParam;
    }

    public int init(com.tencent.karaoke.recordsdk.media.i iVar) {
        LogUtil.i(TAG, "init");
        this.mErrListener = iVar;
        PublicPitchUtil.INSTANCE.enablePublichPitch(false);
        this.mHandlerThread.start();
        this.mHandler = new a(this.mHandlerThread.getLooper());
        uz0.f.a();
        reportRecorderCreate();
        return 0;
    }

    public void onChannelSwitch(boolean z16) {
        boolean z17;
        LogUtil.i(TAG, "onChannelSwitch: " + z16);
        boolean z18 = false;
        if (this.mScore != null) {
            this.mIsOriginal = !z16;
            LogUtil.i(TAG, "mIsOriginal: " + this.mIsOriginal + ", mIsSpeaker: " + this.mIsSpeaker);
            IScore iScore = this.mScore;
            if (this.mIsSpeaker && this.mIsOriginal) {
                z17 = true;
            } else {
                z17 = false;
            }
            iScore.setSpeakerOriginal(z17);
        }
        com.tencent.karaoke.recordsdk.media.j jVar = this.mSingListener;
        if (jVar != null) {
            boolean z19 = !this.mIsSpeaker;
            boolean z26 = this.mIsOriginal;
            if (this.mScore != null) {
                z18 = true;
            }
            jVar.h(z19, z26, z18);
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.f
    public void onHeadsetPlug(boolean z16) {
        boolean z17;
        LogUtil.i(TAG, "onHeadsetPlug: " + z16);
        this.mIsSpeaker = z16 ^ true;
        boolean z18 = false;
        if (this.mScore != null) {
            LogUtil.i(TAG, "mIsOriginal: " + this.mIsOriginal + ", mIsSpeaker: " + this.mIsSpeaker);
            IScore iScore = this.mScore;
            if (this.mIsSpeaker && this.mIsOriginal) {
                z17 = true;
            } else {
                z17 = false;
            }
            iScore.setSpeakerOriginal(z17);
        }
        com.tencent.karaoke.recordsdk.media.j jVar = this.mSingListener;
        if (jVar != null) {
            boolean z19 = this.mIsOriginal;
            if (this.mScore != null) {
                z18 = true;
            }
            jVar.h(z16, z19, z18);
        }
        uz0.f.a();
    }

    public void onPlayBlock(long j3) {
        LogUtil.i(TAG, "onPlayBlock -> blockTime:" + j3);
        if (!this.mIsWaitingForPlayStart) {
            if (j3 > 184) {
                this.mRecordIgnoreCount -= 3;
            }
            reportBlock(j3);
        }
    }

    public void onPlayStart(boolean z16, int i3) {
        String str;
        this.mPlayStartTime = SystemClock.elapsedRealtime();
        this.mIsWaitingForPlayStart = false;
        this.mIsNeedIgnore = z16;
        this.mPlayDelay = i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPlayStart,needIgnore:");
        if (z16) {
            str = "true";
        } else {
            str = "false";
        }
        sb5.append(str);
        sb5.append(",playDelay:");
        sb5.append(i3);
        LogUtil.i(TAG, sb5.toString());
    }

    public void onPositionReached(int i3) {
        if (!this.mSyncEnable) {
            LogUtil.i(TAG, "Sync give up");
            return;
        }
        if (this.mHasRecordLength > 0) {
            this.mSyncPosition = this.mHasRecordLength - ((i3 / 10) * 10);
            this.mSyncTimeMillis = 0L;
        } else {
            this.mSyncPosition = 0;
            this.mSyncTimeMillis = System.currentTimeMillis();
        }
        LogUtil.i(TAG, "onPositionReached, PlayPosition: " + i3 + ", RecordPosition: " + this.mHasRecordLength + ", SyncPosition: " + this.mSyncPosition + ", SyncTime: " + this.mSyncTimeMillis);
    }

    public void pause() {
        LogUtil.i(TAG, "pause");
        this.mRecordStatistic.e();
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(4);
    }

    public void removeOnRecordListener(com.tencent.karaoke.recordsdk.media.g gVar) {
        this.mRecListeners.remove(gVar);
    }

    public void resume() {
        LogUtil.i(TAG, "resume");
        this.mHandler.removeMessages(1);
    }

    public void seekTo(int i3, int i16, com.tencent.karaoke.recordsdk.media.h hVar) {
        LogUtil.i(TAG, "seekTo: " + i3 + ", whence: " + i16);
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.a(2)) {
                LogUtil.i(TAG, "mStartPosition has been re-assigned by position and delayMillis");
                this.mStartPosition = i3;
                IScore iScore = this.mScore;
                if (iScore != null) {
                    iScore.seek(i3);
                }
            }
            this.mSeekRequests.addLast(new c(i3, 0, i16, hVar));
            this.mCurrentState.notifyAll();
        }
    }

    public void setSingModel(com.tencent.karaoke.recordsdk.media.d dVar) {
        this.mSingModel = dVar;
    }

    public void shiftPitch(int i3) {
        IScore iScore = this.mScore;
        if (iScore != null) {
            iScore.setPitch(i3);
        }
    }

    public void start(com.tencent.karaoke.recordsdk.media.j jVar) {
        LogUtil.i(TAG, "start");
        this.mHandler.removeMessages(2);
        if (this.mIsEvaluateAdded || jVar == null) {
            return;
        }
        LogUtil.i(TAG, "start -> create EvaluateThread");
        this.mIsEvaluateAdded = true;
        EvaluateThread evaluateThread = new EvaluateThread(jVar, 8192);
        if (this.mStartPosition > 0) {
            evaluateThread.v();
        }
        this.mRecListeners.add(evaluateThread);
        this.mSingListener = jVar;
        boolean g16 = uz0.e.g();
        this.mIsSpeaker = g16;
        jVar.h(true ^ g16, false, false);
    }

    public void stop() {
        LogUtil.i(TAG, "stop");
        synchronized (this.mCurrentState) {
            this.mSeekRequests.clear();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(2);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(3);
            this.mHandler.removeMessages(4);
        }
        if (this.mHandlerThread != null) {
            LogUtil.i(TAG, "stop -> quit ScheduleThread");
            this.mHandlerThread.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tryResetRecordStaticsParams() {
        if (this.mRecordIgnoreCount >= this.mRecordTotalDelayCount) {
            LogUtil.i(TAG, "tryResetRecordStaticsParams");
            this.mRecordStatistic.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateHasRecordLength(int i3) {
        this.mHasRecordLength += i3;
        com.tencent.karaoke.recordsdk.media.d dVar = this.mSingModel;
        if (dVar != null) {
            dVar.k(((int) wz0.a.a(this.mHasRecordLength - this.mSyncPosition)) + this.mStartPosition);
        }
    }

    public AbstractKaraRecorder(com.tencent.karaoke.recordsdk.media.c cVar, int i3) {
        this(cVar, i3, false);
    }

    AbstractKaraRecorder(com.tencent.karaoke.recordsdk.media.c cVar, int i3, boolean z16) {
        this.mIsSpeaker = false;
        this.mIsOriginal = false;
        this.mSyncPosition = 0;
        this.mSyncTimeMillis = 0L;
        this.mSyncEnable = true;
        this.mHasRecordLength = 0;
        this.mRecListeners = new CopyOnWriteArrayList();
        this.mIsBeforeSeek = false;
        this.mScoreLock = new Object();
        this.mRecordStatistic = new yz0.b();
        this.mCurrentState = new d();
        this.mSeekRequests = new LinkedList<>();
        this.mIsWaitingForPlayStart = true;
        this.mPlayStartTime = 0L;
        this.mRecordTotalDelayBias = 0;
        this.mRecordParam = new s();
        this.mIsEvaluateAdded = false;
        LogUtil.i(TAG, String.format("Position: %d, Acapella: %b", Integer.valueOf(i3), Boolean.valueOf(z16)));
        this.mStartPosition = (i3 / 10) * 10;
        this.mIsAcapella = z16;
        this.mRecordStatistic.c();
        this.mHandlerThread = new BaseHandlerThread("KaraRecorder.ScheduleThread-" + System.currentTimeMillis());
    }

    public final void resume(int i3) {
        LogUtil.i(TAG, "resume, wait: " + i3);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, (long) i3);
    }

    public final void seekTo(int i3, int i16, int i17, com.tencent.karaoke.recordsdk.media.h hVar) {
        seekTo(i3, i3, i16, i17, hVar);
    }

    public void seekTo(int i3, int i16, int i17, int i18, com.tencent.karaoke.recordsdk.media.h hVar) {
        LogUtil.i(TAG, "seekTo, startPosition: " + i3 + ", timePosition: " + i16 + ", delayMillis: " + i17 + ", whence: " + i18);
        this.mHandler.removeMessages(1);
        if (this.mCurrentState.a(2) && i17 > 0) {
            this.mSyncEnable = false;
        }
        if (this.mCurrentState.a(4) && i17 > 0) {
            LogUtil.i(TAG, "pause because of delay while seek");
            pause();
        }
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.a(2)) {
                LogUtil.i(TAG, "mStartPosition has been re-assigned by position and delayMillis");
                this.mStartPosition = i3;
                LogUtil.i(TAG, "mStartPosition = " + this.mStartPosition);
            }
            this.mSeekRequests.addLast(new c(i16, i17, i18, hVar));
            this.mCurrentState.notifyAll();
        }
        if (!this.mCurrentState.a(8) || i17 <= 0) {
            return;
        }
        LogUtil.i(TAG, "resume because of delay while seek,mIsNeedIgnore=" + this.mIsNeedIgnore);
        if (this.mIsNeedIgnore) {
            resume(0);
        } else {
            resume(i17);
        }
    }

    public void start(com.tencent.karaoke.recordsdk.media.j jVar, int i3) {
        LogUtil.i(TAG, "start, wait: " + i3);
        this.mHandler.removeMessages(2);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2, jVar), (long) i3);
        if (this.mIsEvaluateAdded || jVar == null) {
            return;
        }
        LogUtil.i(TAG, "start -> create EvaluateThread");
        this.mIsEvaluateAdded = true;
        EvaluateThread evaluateThread = new EvaluateThread(jVar, 8192);
        if (this.mStartPosition > 0) {
            evaluateThread.v();
        }
        this.mRecListeners.add(evaluateThread);
        this.mSingListener = jVar;
        boolean g16 = uz0.e.g();
        this.mIsSpeaker = g16;
        jVar.h(true ^ g16, false, false);
    }

    protected void reportRecorderCreate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportBlock(long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportJoin(long j3) {
    }

    protected void reportMute(int i3) {
    }

    protected void reportRecordDelay(long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportResampleVersion(@NotNull String str) {
    }

    public void setOnDelayListener(com.tencent.karaoke.recordsdk.media.e eVar) {
    }

    public void setOnRecordStartListener(p pVar) {
    }

    public void setOnVivoFeedbackOnListener(q qVar) {
    }

    public void setOriAudioCallback(r rVar) {
    }

    public void setRecordReportProxyImpl(vz0.a aVar) {
    }
}
