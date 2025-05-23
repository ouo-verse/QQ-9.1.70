package com.tencent.karaoke.audiobasesdk.scorer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.NoteItem;
import com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl;
import com.tencent.karaoke.audiobasesdk.scorer.IScore;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.text.Charsets;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0001[B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u000bH\u0016J7\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u001e\u00109\u001a\u001a\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010:J<\u0010;\u001a\u0004\u0018\u0001042\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u00172 \u00109\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015H\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\n\u0010@\u001a\u0004\u0018\u000104H\u0016J\b\u0010A\u001a\u00020\u0016H\u0016JB\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u0001042\u0006\u0010F\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u0001042\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010-H\u0016J7\u0010K\u001a\u00020\u00162\b\u0010L\u001a\u0004\u0018\u00010D2\u0006\u0010<\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00162\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u0017H\u0016J:\u0010R\u001a\u00020\u000b2\u001e\u00109\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010!2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u0016H\u0016J\u0010\u0010U\u001a\u00020\u000b2\u0006\u00109\u001a\u00020/H\u0016J\u0010\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u001aH\u0016J\b\u0010X\u001a\u00020\u000bH\u0016J6\u0010Y\u001a\u00020\u000b2,\u00109\u001a(\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u0001`\u001f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0016J\b\u0010Z\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R4\u0010\u001c\u001a(\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u0001`\u001f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010 \u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020-X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\\"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/DefaultScoreImpl;", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScore;", DownloadInfo.spKey_Config, "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "(Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;)V", "INIT_TIME_OUT", "", "allGroveCallback", "Lkotlin/Function1;", "", "Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "", "getConfig", "()Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread", "()Landroid/os/HandlerThread;", "setHandlerThread", "(Landroid/os/HandlerThread;)V", "hitGroveCallback", "Lkotlin/Function3;", "", "", "initStatus", "isOriginalSpeaker", "", "lyricSize", "multiCallback", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "Lkotlin/collections/ArrayList;", "multiResultCallback", "Lkotlin/Function2;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "multiScore", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreImpl;", "policy", "Lcom/tencent/karaoke/audiobasesdk/scorer/Policy;", "quit", "result", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResult;", "scoreHandler", "Landroid/os/Handler;", "scoreMap", "", "scoreResultCallback", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResultCallback;", "scoreThreadName", "scorerNativeBridge", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScorerNativeBridge;", "validScoreArray", "", "bindPublicPitch", "nativeHandle", "finish", "getAllGrove", "callback", "(Lkotlin/jvm/functions/Function1;)[Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "getGroveAndHit", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "pitch", "getScoreResult", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScoreResult;", "getValidScoreArray", "getValidSentenceNum", "initWithNoteArray", "noteBuf", "", Element.ELEMENT_NAME_TIMES, "sentenceCount", "lines", ProcessConstant.MULTI, "Lcom/tencent/karaoke/audiobasesdk/scorer/IMultiScore;", "resourceJson", "processWithBuffer", "pcmData", "dataLen", "pitchs", "", "([BFI[[F)I", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "setFinalMultiScoreResultCallback", "setPitch", "offset", "setScoreResultCallback", "setSpeakerOriginal", "original", "stop", "tryGetMultiScoreTmp", "unInit", "DefaultScoreMsg", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class DefaultScoreImpl implements IScore {
    private final long INIT_TIME_OUT;
    private Function1<? super NoteItem[], Unit> allGroveCallback;

    @NotNull
    private final ScoreConfig config;

    @Nullable
    private HandlerThread handlerThread;
    private Function3<? super Integer, ? super Integer, ? super Float, Unit> hitGroveCallback;
    private volatile int initStatus;
    private boolean isOriginalSpeaker;
    private int lyricSize;
    private Function1<? super ArrayList<MultiScoreStcInfo>, Unit> multiCallback;
    private Function2<? super MultiScoreResult, ? super MultiScoreResult, Unit> multiResultCallback;
    private MultiScoreImpl multiScore;
    private Policy policy;
    private volatile boolean quit;
    private ScoreResult result;
    private Handler scoreHandler;
    private String scoreMap;
    private ScoreResultCallback scoreResultCallback;
    private final String scoreThreadName;
    private ScorerNativeBridge scorerNativeBridge;
    private int[] validScoreArray;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/DefaultScoreImpl$DefaultScoreMsg;", "", "(Ljava/lang/String;I)V", "None", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "Process", "Seek", "Stop", "Finish", "BindPitchId", "SetCallback", "GroveAndHit", "GetAllGrove", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public enum DefaultScoreMsg {
        None,
        Init,
        Process,
        Seek,
        Stop,
        Finish,
        BindPitchId,
        SetCallback,
        GroveAndHit,
        GetAllGrove
    }

    public DefaultScoreImpl(@NotNull ScoreConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        this.config = config;
        this.INIT_TIME_OUT = 1000L;
        this.scorerNativeBridge = new ScorerNativeBridge();
        this.policy = new Policy(0.0f, 0.0f, 0, 0, false, 0, 63, null);
        this.scoreThreadName = "scorer_Module";
    }

    public static final /* synthetic */ ScoreResult access$getResult$p(DefaultScoreImpl defaultScoreImpl) {
        ScoreResult scoreResult = defaultScoreImpl.result;
        if (scoreResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        return scoreResult;
    }

    public static final /* synthetic */ Handler access$getScoreHandler$p(DefaultScoreImpl defaultScoreImpl) {
        Handler handler = defaultScoreImpl.scoreHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int unInit() {
        this.scoreResultCallback = null;
        this.allGroveCallback = null;
        this.hitGroveCallback = null;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return 1000;
        }
        ScoreResult scoreResult = this.result;
        if (scoreResult != null) {
            if (scoreResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("result");
            }
            scoreResult.destroy();
        }
        this.scorerNativeBridge.unInit();
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        LogUtil.i(ConstantsKt.SCORE_TAG, "ScoreImpl::unInit complate");
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int bindPublicPitch(long nativeHandle) {
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void finish() {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        this.quit = true;
        Handler handler = this.scoreHandler;
        if (handler == null) {
            return;
        }
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler.removeCallbacksAndMessages(null);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$finish$runnable$1

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
            /* renamed from: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$finish$runnable$1$1, reason: invalid class name */
            /* loaded from: classes7.dex */
            final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0 {
                AnonymousClass1(DefaultScoreImpl defaultScoreImpl) {
                    super(defaultScoreImpl);
                }

                @Override // kotlin.reflect.KProperty0
                @Nullable
                public Object get() {
                    return DefaultScoreImpl.access$getResult$p((DefaultScoreImpl) this.receiver);
                }

                @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                public String getName() {
                    return "result";
                }

                @Override // kotlin.jvm.internal.CallableReference
                public KDeclarationContainer getOwner() {
                    return Reflection.getOrCreateKotlinClass(DefaultScoreImpl.class);
                }

                @Override // kotlin.jvm.internal.CallableReference
                public String getSignature() {
                    return "getResult()Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResult;";
                }

                @Override // kotlin.reflect.KMutableProperty0
                public void set(@Nullable Object obj) {
                    ((DefaultScoreImpl) this.receiver).result = (ScoreResult) obj;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
            
                r4 = r6.this$0.multiScore;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
            
                r2 = r6.this$0.multiScore;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                ScorerNativeBridge scorerNativeBridge;
                MultiScoreImpl multiScoreImpl;
                ArrayList<MultiScoreStcInfo> arrayList;
                ScoreResult scoreResult;
                MultiScoreImpl multiScoreImpl2;
                MultiScoreResult multiScoreResult;
                String str;
                MultiScoreResult multiScoreResult2;
                Function1 function1;
                Function2 function2;
                MultiScoreImpl multiScoreImpl3;
                MultiScoreImpl multiScoreImpl4;
                MultiScoreImpl multiScoreImpl5;
                int i3;
                scorerNativeBridge = DefaultScoreImpl.this.scorerNativeBridge;
                scorerNativeBridge.finish();
                multiScoreImpl = DefaultScoreImpl.this.multiScore;
                if (multiScoreImpl != null) {
                    arrayList = multiScoreImpl.tryGetMultiScoreTmp();
                } else {
                    arrayList = null;
                }
                scoreResult = DefaultScoreImpl.this.result;
                if (scoreResult != null && multiScoreImpl5 != null) {
                    int[] pYinSentenceScores = DefaultScoreImpl.access$getResult$p(DefaultScoreImpl.this).pYinSentenceScores();
                    i3 = DefaultScoreImpl.this.lyricSize;
                    multiScoreImpl5.setNewTmpDataToMultiScore(arrayList, pYinSentenceScores, i3);
                }
                multiScoreImpl2 = DefaultScoreImpl.this.multiScore;
                if (multiScoreImpl2 != null) {
                    multiScoreResult = multiScoreImpl2.getMultiScoreFinal();
                } else {
                    multiScoreResult = null;
                }
                str = DefaultScoreImpl.this.scoreMap;
                if (str != null && multiScoreImpl4 != null) {
                    byte[] bytes = str.getBytes(Charsets.UTF_8);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    multiScoreResult2 = multiScoreImpl4.getMapMultiScoreFinal(bytes);
                } else {
                    multiScoreResult2 = null;
                }
                function1 = DefaultScoreImpl.this.multiCallback;
                if (function1 != null) {
                }
                DefaultScoreImpl.this.multiCallback = null;
                function2 = DefaultScoreImpl.this.multiResultCallback;
                if (function2 != null) {
                }
                DefaultScoreImpl.this.multiResultCallback = null;
                DefaultScoreImpl.this.unInit();
                multiScoreImpl3 = DefaultScoreImpl.this.multiScore;
                if (multiScoreImpl3 != null) {
                    multiScoreImpl3.uninit();
                }
                countDownLatch.countDown();
            }
        };
        Handler handler2 = this.scoreHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        Message obtainMessage = handler2.obtainMessage(DefaultScoreMsg.Finish.ordinal(), runnable);
        Handler handler3 = this.scoreHandler;
        if (handler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler3.sendMessage(obtainMessage);
        countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public NoteItem[] getAllGrove(@Nullable Function1<? super NoteItem[], Unit> callback) {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return null;
        }
        if (this.allGroveCallback == null) {
            this.allGroveCallback = callback;
        }
        if (this.scoreHandler == null) {
            return null;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$getAllGrove$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ScorerNativeBridge scorerNativeBridge;
                Function1 function1;
                scorerNativeBridge = DefaultScoreImpl.this.scorerNativeBridge;
                NoteItem[] allGrove = scorerNativeBridge.getAllGrove();
                function1 = DefaultScoreImpl.this.allGroveCallback;
                if (function1 != null) {
                }
            }
        };
        Handler handler = this.scoreHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        Message obtainMessage = handler.obtainMessage(DefaultScoreMsg.GetAllGrove.ordinal(), runnable);
        Handler handler2 = this.scoreHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler2.sendMessage(obtainMessage);
        return null;
    }

    @NotNull
    public final ScoreConfig getConfig() {
        return this.config;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public int[] getGroveAndHit(float timeStamp, float pitch, @Nullable Function3<? super Integer, ? super Integer, ? super Float, Unit> callback) {
        if (ScorerNativeBridge.INSTANCE.isLoaded() && !this.quit && this.hitGroveCallback == null) {
            this.hitGroveCallback = callback;
        }
        return null;
    }

    @Nullable
    public final HandlerThread getHandlerThread() {
        return this.handlerThread;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getSCORE_TYPE_ACF() {
        return IScore.DefaultImpls.getSCORE_TYPE_ACF(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getSCORE_TYPE_MIX() {
        return IScore.DefaultImpls.getSCORE_TYPE_MIX(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getSCORE_TYPE_PYIN() {
        return IScore.DefaultImpls.getSCORE_TYPE_PYIN(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public IScoreResult getScoreResult() {
        ScoreResult scoreResult = this.result;
        if (scoreResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        return scoreResult;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public int[] getValidScoreArray() {
        int i3;
        int[] iArr = null;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return null;
        }
        int[] iArr2 = this.validScoreArray;
        if (iArr2 != null) {
            return iArr2;
        }
        boolean[] validScoreArray = this.scorerNativeBridge.getValidScoreArray();
        if (validScoreArray != null) {
            iArr = new int[validScoreArray.length];
            int length = validScoreArray.length;
            for (int i16 = 0; i16 < length; i16++) {
                if (validScoreArray[i16]) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                iArr[i16] = i3;
            }
            this.validScoreArray = iArr;
        }
        return iArr;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getValidSentenceNum() {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return 0;
        }
        return this.scorerNativeBridge.validSentenceNum();
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int initWithNoteArray(@Nullable final byte[] noteBuf, @Nullable final int[] times, final int sentenceCount, @Nullable final int[] lines, @Nullable final IMultiScore multi, @Nullable final String resourceJson) {
        Integer num;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return 1000;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("resourceJson.length = ");
        if (resourceJson != null) {
            num = Integer.valueOf(resourceJson.length());
        } else {
            num = null;
        }
        sb5.append(num);
        LogUtil.i(ConstantsKt.SCORE_TAG, sb5.toString());
        LogUtil.i(ConstantsKt.SCORE_TAG, "config.enableMultiScore = " + this.config.getEnableMultiScore());
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.scoreThreadName);
        this.handlerThread = baseHandlerThread;
        baseHandlerThread.start();
        final Looper looper = baseHandlerThread.getLooper();
        this.scoreHandler = new Handler(looper) { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$initWithNoteArray$1
            @Override // android.os.Handler
            public void handleMessage(@Nullable Message msg2) {
                if (msg2 != null) {
                    int i3 = msg2.what;
                    if (i3 == DefaultScoreImpl.DefaultScoreMsg.None.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.Init.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.Process.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.Seek.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.Stop.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.Finish.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.BindPitchId.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.SetCallback.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.GroveAndHit.ordinal() || i3 == DefaultScoreImpl.DefaultScoreMsg.GetAllGrove.ordinal()) {
                        Object obj = msg2.obj;
                        if (obj != null) {
                            ((Runnable) obj).run();
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Runnable");
                    }
                }
            }
        };
        this.initStatus = 0;
        Handler handler = this.scoreHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler.removeCallbacksAndMessages(null);
        this.quit = false;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$initWithNoteArray$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                MultiScoreImpl multiScoreImpl;
                MultiScoreImpl multiScoreImpl2;
                long j3;
                ScorerNativeBridge scorerNativeBridge;
                int i3;
                ScorerNativeBridge scorerNativeBridge2;
                MultiScoreImpl multiScoreImpl3;
                MultiScoreImpl multiScoreImpl4;
                int i16;
                ScorerNativeBridge scorerNativeBridge3;
                MultiScoreImpl multiScoreImpl5;
                byte[] bArr;
                Boolean bool = null;
                if (DefaultScoreImpl.this.getConfig().getEnableMultiScore() && !TextUtils.isEmpty(resourceJson)) {
                    DefaultScoreImpl.this.multiScore = (MultiScoreImpl) multi;
                    multiScoreImpl5 = DefaultScoreImpl.this.multiScore;
                    if (multiScoreImpl5 != null) {
                        int sample = DefaultScoreImpl.this.getConfig().getSample();
                        int channel = DefaultScoreImpl.this.getConfig().getChannel();
                        String str = resourceJson;
                        if (str != null) {
                            Charset defaultCharset = Charset.defaultCharset();
                            Intrinsics.checkExpressionValueIsNotNull(defaultCharset, "Charset.defaultCharset()");
                            bArr = str.getBytes(defaultCharset);
                            Intrinsics.checkExpressionValueIsNotNull(bArr, "(this as java.lang.String).getBytes(charset)");
                        } else {
                            bArr = null;
                        }
                        multiScoreImpl5.initAndLoadResource(sample, channel, bArr);
                    }
                }
                multiScoreImpl = DefaultScoreImpl.this.multiScore;
                if (multiScoreImpl != null) {
                    scorerNativeBridge3 = DefaultScoreImpl.this.scorerNativeBridge;
                    multiScoreImpl.bindScorerNativeBridge$lib_audiobasesdk_release(scorerNativeBridge3);
                }
                multiScoreImpl2 = DefaultScoreImpl.this.multiScore;
                if (multiScoreImpl2 != null) {
                    j3 = multiScoreImpl2.getNativeId();
                } else {
                    j3 = 0;
                }
                DefaultScoreImpl defaultScoreImpl = DefaultScoreImpl.this;
                scorerNativeBridge = defaultScoreImpl.scorerNativeBridge;
                defaultScoreImpl.initStatus = scorerNativeBridge.initWithNoteArray(noteBuf, times, lines, sentenceCount, DefaultScoreImpl.this.getConfig().getSample(), DefaultScoreImpl.this.getConfig().getChannel(), DefaultScoreImpl.this.getConfig().getBitDepth(), DefaultScoreImpl.this.getConfig().getScoreType());
                i3 = DefaultScoreImpl.this.initStatus;
                if (i3 < 0) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("ScoreImpl::init failed ");
                    i16 = DefaultScoreImpl.this.initStatus;
                    sb6.append(i16);
                    LogUtil.i(ConstantsKt.SCORE_TAG, sb6.toString());
                }
                countDownLatch.countDown();
                scorerNativeBridge2 = DefaultScoreImpl.this.scorerNativeBridge;
                scorerNativeBridge2.bindMultiScore(j3);
                multiScoreImpl3 = DefaultScoreImpl.this.multiScore;
                if (multiScoreImpl3 != null) {
                    multiScoreImpl3.setIsRap(DefaultScoreImpl.this.getConfig().getIsRap());
                }
                String skillParam = DefaultScoreImpl.this.getConfig().getSkillParam();
                if (skillParam != null) {
                    Charset defaultCharset2 = Charset.defaultCharset();
                    Intrinsics.checkExpressionValueIsNotNull(defaultCharset2, "Charset.defaultCharset()");
                    byte[] bytes = skillParam.getBytes(defaultCharset2);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    if (bytes != null) {
                        multiScoreImpl4 = DefaultScoreImpl.this.multiScore;
                        if (multiScoreImpl4 != null) {
                            bool = Boolean.valueOf(multiScoreImpl4.setSkillParam(bytes));
                        }
                        LogUtil.i(ConstantsKt.SCORE_TAG, "setSkillResult = " + bool);
                    }
                }
            }
        };
        Handler handler2 = this.scoreHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        Message obtainMessage = handler2.obtainMessage(DefaultScoreMsg.Init.ordinal(), runnable);
        Handler handler3 = this.scoreHandler;
        if (handler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler3.sendMessage(obtainMessage);
        countDownLatch.await(this.INIT_TIME_OUT, TimeUnit.MILLISECONDS);
        if (this.initStatus < 0) {
            unInit();
        }
        return this.initStatus;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int processWithBuffer(@Nullable final byte[] pcmData, final float timeStamp, final int dataLen, @Nullable final float[][] pitchs) {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return 1000;
        }
        if (this.quit) {
            LogUtil.i(ConstantsKt.SCORE_TAG, "scorer has quit,return");
            return 0;
        }
        if (this.scoreHandler == null) {
            return 0;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$processWithBuffer$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ScorerNativeBridge scorerNativeBridge;
                ScorerNativeBridge scorerNativeBridge2;
                Function3 function3;
                scorerNativeBridge = DefaultScoreImpl.this.scorerNativeBridge;
                byte[] bArr = pcmData;
                if (bArr == null) {
                    Intrinsics.throwNpe();
                }
                scorerNativeBridge.processWithBuffer(bArr, timeStamp, dataLen, pitchs);
                scorerNativeBridge2 = DefaultScoreImpl.this.scorerNativeBridge;
                int[] groveAndHit = scorerNativeBridge2.getGroveAndHit(timeStamp, 0.0f);
                if (groveAndHit != null) {
                    int i3 = groveAndHit[0];
                    int i16 = groveAndHit[1];
                    function3 = DefaultScoreImpl.this.hitGroveCallback;
                    if (function3 != null) {
                    }
                }
            }
        };
        Message obtain = Message.obtain();
        obtain.what = DefaultScoreMsg.Process.ordinal();
        obtain.obj = runnable;
        Handler handler = this.scoreHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler.sendMessage(obtain);
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void seek(final float timeStamp) {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        if (this.quit) {
            LogUtil.i(ConstantsKt.SCORE_TAG, "want to seek but has quit");
            return;
        }
        Handler handler = this.scoreHandler;
        if (handler == null) {
            return;
        }
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler.removeMessages(DefaultScoreMsg.Process.ordinal());
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$seek$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ScorerNativeBridge scorerNativeBridge;
                scorerNativeBridge = DefaultScoreImpl.this.scorerNativeBridge;
                scorerNativeBridge.seek(timeStamp);
            }
        };
        Handler handler2 = this.scoreHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        Message obtainMessage = handler2.obtainMessage(DefaultScoreMsg.Seek.ordinal(), runnable);
        Handler handler3 = this.scoreHandler;
        if (handler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler3.sendMessage(obtainMessage);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setFinalMultiScoreResultCallback(@Nullable Function2<? super MultiScoreResult, ? super MultiScoreResult, Unit> callback, @Nullable String scoreMap, int lyricSize) {
        this.multiResultCallback = callback;
        this.scoreMap = scoreMap;
        this.lyricSize = lyricSize;
    }

    public final void setHandlerThread(@Nullable HandlerThread handlerThread) {
        this.handlerThread = handlerThread;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setPitch(int offset) {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        this.scorerNativeBridge.setShiftKey(offset);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setScoreResultCallback(@NotNull ScoreResultCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.scoreResultCallback = callback;
        if (!ScorerNativeBridge.INSTANCE.isLoaded() || this.scoreHandler == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$setScoreResultCallback$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ScorerNativeBridge scorerNativeBridge;
                scorerNativeBridge = DefaultScoreImpl.this.scorerNativeBridge;
                scorerNativeBridge.setScoreUpdateReceiver(new ScoreUpdateReceiver() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$setScoreResultCallback$runnable$1.1
                    @Override // com.tencent.karaoke.audiobasesdk.scorer.ScoreUpdateReceiver
                    public void updateScoreResult(long nativeHandle, boolean seek, float timeStamp, int stcIndex) {
                        ScoreResult scoreResult;
                        Policy policy;
                        Policy policy2;
                        ScoreResultCallback scoreResultCallback;
                        ScoreResultCallback scoreResultCallback2;
                        ScorerNativeBridge scorerNativeBridge2;
                        Policy policy3;
                        LogUtil.i(ConstantsKt.SCORE_TAG, "updateScoreResult seek:" + seek + ",timeStamp:" + timeStamp);
                        scoreResult = DefaultScoreImpl.this.result;
                        if (scoreResult == null) {
                            DefaultScoreImpl defaultScoreImpl = DefaultScoreImpl.this;
                            scorerNativeBridge2 = DefaultScoreImpl.this.scorerNativeBridge;
                            policy3 = DefaultScoreImpl.this.policy;
                            defaultScoreImpl.result = new ScoreResult(scorerNativeBridge2, policy3);
                        }
                        policy = DefaultScoreImpl.this.policy;
                        policy.setStcIndex(stcIndex);
                        ScoreResult access$getResult$p = DefaultScoreImpl.access$getResult$p(DefaultScoreImpl.this);
                        policy2 = DefaultScoreImpl.this.policy;
                        access$getResult$p.setPolicy(policy2);
                        DefaultScoreImpl.access$getResult$p(DefaultScoreImpl.this).updateScoreResult(nativeHandle, seek);
                        scoreResultCallback = DefaultScoreImpl.this.scoreResultCallback;
                        if (scoreResultCallback != null) {
                            scoreResultCallback2 = DefaultScoreImpl.this.scoreResultCallback;
                            if (scoreResultCallback2 == null) {
                                Intrinsics.throwNpe();
                            }
                            scoreResultCallback2.scoreResultCallback(DefaultScoreImpl.access$getResult$p(DefaultScoreImpl.this), timeStamp);
                            return;
                        }
                        LogUtil.i(ConstantsKt.SCORE_TAG, "scoreResultCallback is null");
                    }
                });
            }
        };
        Handler handler = this.scoreHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        Message obtainMessage = handler.obtainMessage(DefaultScoreMsg.SetCallback.ordinal(), runnable);
        Handler handler2 = this.scoreHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler2.sendMessage(obtainMessage);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setSpeakerOriginal(boolean original) {
        this.isOriginalSpeaker = original;
        this.policy.setOriginalSpeaker(original);
        LogUtil.i(ConstantsKt.SCORE_TAG, "setSpeakerOriginal " + original);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void stop() {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        this.quit = true;
        Handler handler = this.scoreHandler;
        if (handler == null) {
            return;
        }
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler.removeCallbacksAndMessages(null);
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.scorer.DefaultScoreImpl$stop$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ScorerNativeBridge scorerNativeBridge;
                scorerNativeBridge = DefaultScoreImpl.this.scorerNativeBridge;
                scorerNativeBridge.stop();
                DefaultScoreImpl.this.unInit();
            }
        };
        Handler handler2 = this.scoreHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        Message obtainMessage = handler2.obtainMessage(DefaultScoreMsg.Stop.ordinal(), runnable);
        Handler handler3 = this.scoreHandler;
        if (handler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreHandler");
        }
        handler3.sendMessage(obtainMessage);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void tryGetMultiScoreTmp(@Nullable Function1<? super ArrayList<MultiScoreStcInfo>, Unit> callback) {
        this.multiCallback = callback;
    }
}
