package com.tencent.karaoke.audiobasesdk.commom;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003BCDB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\b\u0010*\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020\u000fH\u0002J.\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020(02J\u001e\u0010,\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020(02J\u0006\u00103\u001a\u00020\u000fJ\u0006\u00104\u001a\u00020(J:\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:2\u001a\u0010;\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020>\u0018\u00010=\u0012\u0004\u0012\u00020(0<J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0006\u0010A\u001a\u00020(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016`\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006E"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule;", "", "()V", "INVALID_AISCORE", "", "TAG", "mCurPublicProcessState", "Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicProcessInitState;", "mGetPitchDataCostTm", "", "getMGetPitchDataCostTm", "()J", "setMGetPitchDataCostTm", "(J)V", "mHasUninit", "", "getMHasUninit", "()Z", "setMHasUninit", "(Z)V", "mPitchResultCallbackList", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PitchDataCallback;", "Lkotlin/collections/ArrayList;", "mPublicPitchData", "Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicPitchData;", "getMPublicPitchData", "()Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicPitchData;", "setMPublicPitchData", "(Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicPitchData;)V", "mPublicPitchHander", "Landroid/os/Handler;", "mPublicPitchProcessor", "Lcom/tencent/karaoke/audiobasesdk/commom/PublicPitchProcessor;", "getMPublicPitchProcessor", "()Lcom/tencent/karaoke/audiobasesdk/commom/PublicPitchProcessor;", "setMPublicPitchProcessor", "(Lcom/tencent/karaoke/audiobasesdk/commom/PublicPitchProcessor;)V", "getPitchDataSafely", "", "pitchResult", "hasMarkAsFinished", "hasPitchDataResulted", "init", "sampleRate", "", "channels", "aiModeFilePath", "successCallback", "Lkotlin/Function0;", "isEnablePublicPitch", "markAsFinished", "processData", "dataBuffer", "", "bufferSize", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "callback", "Lkotlin/Function1;", "", "", "transferState", "state", "uninit", "PitchDataCallback", "PublicPitchData", "PublicProcessInitState", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class RecordPublicProcessorModule {
    public static final RecordPublicProcessorModule INSTANCE = new RecordPublicProcessorModule();

    @NotNull
    public static final String INVALID_AISCORE = "-111111";

    @NotNull
    public static final String TAG = "RecordPublicProcessorModule";
    private static PublicProcessInitState mCurPublicProcessState;
    private static volatile long mGetPitchDataCostTm;
    private static volatile boolean mHasUninit;
    private static ArrayList<WeakReference<PitchDataCallback>> mPitchResultCallbackList;

    @NotNull
    private static PublicPitchData mPublicPitchData;
    private static Handler mPublicPitchHander;

    @Nullable
    private static PublicPitchProcessor mPublicPitchProcessor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PitchDataCallback;", "", "pitchDataResult", "", "pitchData", "Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicPitchData;", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public interface PitchDataCallback {
        void pitchDataResult(@Nullable PublicPitchData pitchData);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJB\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\b\u0010$\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicPitchData;", "", "pitchs5ms", "", "pitchs10ms", "mAiScore", "", "nonTimePitchs", "", "([F[FLjava/lang/String;[[F)V", "getMAiScore", "()Ljava/lang/String;", "setMAiScore", "(Ljava/lang/String;)V", "getNonTimePitchs", "()[[F", "setNonTimePitchs", "([[F)V", "[[F", "getPitchs10ms", "()[F", "setPitchs10ms", "([F)V", "getPitchs5ms", "setPitchs5ms", "component1", "component2", "component3", "component4", "copy", "([F[FLjava/lang/String;[[F)Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicPitchData;", "equals", "", "other", "hashCode", "", "toString", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final /* data */ class PublicPitchData {

        @NotNull
        private String mAiScore;

        @Nullable
        private float[][] nonTimePitchs;

        @Nullable
        private float[] pitchs10ms;

        @Nullable
        private float[] pitchs5ms;

        public PublicPitchData() {
            this(null, null, null, null, 15, null);
        }

        @NotNull
        public static /* synthetic */ PublicPitchData copy$default(PublicPitchData publicPitchData, float[] fArr, float[] fArr2, String str, float[][] fArr3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                fArr = publicPitchData.pitchs5ms;
            }
            if ((i3 & 2) != 0) {
                fArr2 = publicPitchData.pitchs10ms;
            }
            if ((i3 & 4) != 0) {
                str = publicPitchData.mAiScore;
            }
            if ((i3 & 8) != 0) {
                fArr3 = publicPitchData.nonTimePitchs;
            }
            return publicPitchData.copy(fArr, fArr2, str, fArr3);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final float[] getPitchs5ms() {
            return this.pitchs5ms;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final float[] getPitchs10ms() {
            return this.pitchs10ms;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getMAiScore() {
            return this.mAiScore;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final float[][] getNonTimePitchs() {
            return this.nonTimePitchs;
        }

        @NotNull
        public final PublicPitchData copy(@Nullable float[] pitchs5ms, @Nullable float[] pitchs10ms, @NotNull String mAiScore, @Nullable float[][] nonTimePitchs) {
            Intrinsics.checkParameterIsNotNull(mAiScore, "mAiScore");
            return new PublicPitchData(pitchs5ms, pitchs10ms, mAiScore, nonTimePitchs);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof PublicPitchData) {
                    PublicPitchData publicPitchData = (PublicPitchData) other;
                    if (!Intrinsics.areEqual(this.pitchs5ms, publicPitchData.pitchs5ms) || !Intrinsics.areEqual(this.pitchs10ms, publicPitchData.pitchs10ms) || !Intrinsics.areEqual(this.mAiScore, publicPitchData.mAiScore) || !Intrinsics.areEqual(this.nonTimePitchs, publicPitchData.nonTimePitchs)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final String getMAiScore() {
            return this.mAiScore;
        }

        @Nullable
        public final float[][] getNonTimePitchs() {
            return this.nonTimePitchs;
        }

        @Nullable
        public final float[] getPitchs10ms() {
            return this.pitchs10ms;
        }

        @Nullable
        public final float[] getPitchs5ms() {
            return this.pitchs5ms;
        }

        public int hashCode() {
            int i3;
            int i16;
            int i17;
            float[] fArr = this.pitchs5ms;
            int i18 = 0;
            if (fArr != null) {
                i3 = Arrays.hashCode(fArr);
            } else {
                i3 = 0;
            }
            int i19 = i3 * 31;
            float[] fArr2 = this.pitchs10ms;
            if (fArr2 != null) {
                i16 = Arrays.hashCode(fArr2);
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 31;
            String str = this.mAiScore;
            if (str != null) {
                i17 = str.hashCode();
            } else {
                i17 = 0;
            }
            int i27 = (i26 + i17) * 31;
            float[][] fArr3 = this.nonTimePitchs;
            if (fArr3 != null) {
                i18 = Arrays.hashCode(fArr3);
            }
            return i27 + i18;
        }

        public final void setMAiScore(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.mAiScore = str;
        }

        public final void setNonTimePitchs(@Nullable float[][] fArr) {
            this.nonTimePitchs = fArr;
        }

        public final void setPitchs10ms(@Nullable float[] fArr) {
            this.pitchs10ms = fArr;
        }

        public final void setPitchs5ms(@Nullable float[] fArr) {
            this.pitchs5ms = fArr;
        }

        @NotNull
        public String toString() {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ResultPitchData(pitchs5msSize=");
            float[] fArr = this.pitchs5ms;
            int i16 = -1;
            if (fArr != null) {
                i3 = fArr.length;
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            sb5.append(", pitchs10msSize=");
            float[] fArr2 = this.pitchs10ms;
            if (fArr2 != null) {
                i16 = fArr2.length;
            }
            sb5.append(i16);
            sb5.append(",mAiScore=");
            sb5.append(this.mAiScore);
            sb5.append(')');
            return sb5.toString();
        }

        public PublicPitchData(@Nullable float[] fArr, @Nullable float[] fArr2, @NotNull String mAiScore, @Nullable float[][] fArr3) {
            Intrinsics.checkParameterIsNotNull(mAiScore, "mAiScore");
            this.pitchs5ms = fArr;
            this.pitchs10ms = fArr2;
            this.mAiScore = mAiScore;
            this.nonTimePitchs = fArr3;
        }

        public /* synthetic */ PublicPitchData(float[] fArr, float[] fArr2, String str, float[][] fArr3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : fArr, (i3 & 2) != 0 ? null : fArr2, (i3 & 4) != 0 ? RecordPublicProcessorModule.INVALID_AISCORE : str, (i3 & 8) != 0 ? null : fArr3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/commom/RecordPublicProcessorModule$PublicProcessInitState;", "", "(Ljava/lang/String;I)V", "None", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "Process", "MarkAsFinished", "DataResulted", "Uninit", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public enum PublicProcessInitState {
        None,
        Init,
        Process,
        MarkAsFinished,
        DataResulted,
        Uninit
    }

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PublicPitchProcessor_Module");
        baseHandlerThread.start();
        final Looper looper = baseHandlerThread.getLooper();
        mPublicPitchHander = new Handler(looper) { // from class: com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule$mPublicPitchHander$1
            @Override // android.os.Handler
            public void handleMessage(@Nullable Message msg2) {
                if (msg2 != null) {
                    int i3 = msg2.what;
                    if (i3 == RecordPublicProcessorModule.PublicProcessInitState.Init.ordinal() || i3 == RecordPublicProcessorModule.PublicProcessInitState.Process.ordinal() || i3 == RecordPublicProcessorModule.PublicProcessInitState.MarkAsFinished.ordinal() || i3 == RecordPublicProcessorModule.PublicProcessInitState.DataResulted.ordinal() || i3 == RecordPublicProcessorModule.PublicProcessInitState.Uninit.ordinal()) {
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
        mCurPublicProcessState = PublicProcessInitState.None;
        mPitchResultCallbackList = new ArrayList<>();
        mPublicPitchData = new PublicPitchData(null, null, null, null, 15, null);
    }

    RecordPublicProcessorModule() {
    }

    private final boolean hasMarkAsFinished() {
        if (mCurPublicProcessState.compareTo(PublicProcessInitState.MarkAsFinished) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasPitchDataResulted() {
        if (mCurPublicProcessState.compareTo(PublicProcessInitState.DataResulted) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void transferState(PublicProcessInitState state) {
        LogUtil.i(TAG, "from state=" + mCurPublicProcessState + ",to state=" + state + TokenParser.SP);
        mCurPublicProcessState = state;
    }

    public final long getMGetPitchDataCostTm() {
        return mGetPitchDataCostTm;
    }

    public final boolean getMHasUninit() {
        return mHasUninit;
    }

    @NotNull
    public final PublicPitchData getMPublicPitchData() {
        return mPublicPitchData;
    }

    @Nullable
    public final PublicPitchProcessor getMPublicPitchProcessor() {
        return mPublicPitchProcessor;
    }

    public final void getPitchDataSafely(@NotNull final WeakReference<PitchDataCallback> pitchResult) {
        Intrinsics.checkParameterIsNotNull(pitchResult, "pitchResult");
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule$getPitchDataSafely$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean hasPitchDataResulted;
                ArrayList arrayList;
                RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
                if (recordPublicProcessorModule.isEnablePublicPitch()) {
                    hasPitchDataResulted = recordPublicProcessorModule.hasPitchDataResulted();
                    if (hasPitchDataResulted) {
                        RecordPublicProcessorModule.PitchDataCallback pitchDataCallback = (RecordPublicProcessorModule.PitchDataCallback) pitchResult.get();
                        if (pitchDataCallback != null) {
                            pitchDataCallback.pitchDataResult(recordPublicProcessorModule.getMPublicPitchData());
                            return;
                        } else {
                            LogUtil.e(RecordPublicProcessorModule.TAG, "callback is null");
                            return;
                        }
                    }
                    LogUtil.w(RecordPublicProcessorModule.TAG, "pitch data is running");
                    arrayList = RecordPublicProcessorModule.mPitchResultCallbackList;
                    arrayList.add(pitchResult);
                    return;
                }
                LogUtil.d(RecordPublicProcessorModule.TAG, "is not enable public pitch, just return null.");
                RecordPublicProcessorModule.PitchDataCallback pitchDataCallback2 = (RecordPublicProcessorModule.PitchDataCallback) pitchResult.get();
                if (pitchDataCallback2 != null) {
                    pitchDataCallback2.pitchDataResult(null);
                } else {
                    LogUtil.e(RecordPublicProcessorModule.TAG, "callback is null");
                }
            }
        };
        Handler handler = mPublicPitchHander;
        handler.sendMessage(handler.obtainMessage(PublicProcessInitState.DataResulted.ordinal(), runnable));
    }

    public final void init(final int sampleRate, final int channels, @Nullable final String aiModeFilePath, @NotNull final Function0<Unit> successCallback) {
        Intrinsics.checkParameterIsNotNull(successCallback, "successCallback");
        mPublicPitchHander.removeCallbacksAndMessages(null);
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule$init$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
                PublicPitchProcessor mPublicPitchProcessor2 = recordPublicProcessorModule.getMPublicPitchProcessor();
                if (mPublicPitchProcessor2 != null) {
                    mPublicPitchProcessor2.unInit();
                }
                recordPublicProcessorModule.setMPublicPitchProcessor(null);
                recordPublicProcessorModule.getMPublicPitchData().setPitchs10ms(null);
                recordPublicProcessorModule.getMPublicPitchData().setPitchs5ms(null);
                recordPublicProcessorModule.setMHasUninit(false);
                recordPublicProcessorModule.transferState(RecordPublicProcessorModule.PublicProcessInitState.None);
                recordPublicProcessorModule.setMPublicPitchProcessor(new PublicPitchProcessor());
                PublicPitchProcessor mPublicPitchProcessor3 = recordPublicProcessorModule.getMPublicPitchProcessor();
                if (mPublicPitchProcessor3 == null) {
                    Intrinsics.throwNpe();
                }
                int init = mPublicPitchProcessor3.init(sampleRate, channels);
                LogUtil.i(RecordPublicProcessorModule.TAG, "initRet=" + init);
                if (init == 0) {
                    recordPublicProcessorModule.transferState(RecordPublicProcessorModule.PublicProcessInitState.Init);
                    if (!TextUtils.isEmpty(aiModeFilePath)) {
                        PublicPitchProcessor mPublicPitchProcessor4 = recordPublicProcessorModule.getMPublicPitchProcessor();
                        if (mPublicPitchProcessor4 == null) {
                            Intrinsics.throwNpe();
                        }
                        LogUtil.i(RecordPublicProcessorModule.TAG, "initAiScore result:" + mPublicPitchProcessor4.initAiScore(aiModeFilePath));
                    }
                    PublicPitchUtil.INSTANCE.enablePublichPitch(true);
                    PublicPitchProcessor mPublicPitchProcessor5 = recordPublicProcessorModule.getMPublicPitchProcessor();
                    if (mPublicPitchProcessor5 == null) {
                        Intrinsics.throwNpe();
                    }
                    Boolean bool = Boolean.TRUE;
                    LogUtil.i(RecordPublicProcessorModule.TAG, "setDetectflagResult=" + mPublicPitchProcessor5.SetPitchDetectionSwitch(bool, bool));
                    successCallback.invoke();
                    return;
                }
                recordPublicProcessorModule.setMPublicPitchProcessor(null);
                PublicPitchUtil.INSTANCE.enablePublichPitch(false);
            }
        };
        Handler handler = mPublicPitchHander;
        handler.sendMessage(handler.obtainMessage(PublicProcessInitState.Init.ordinal(), runnable));
    }

    public final boolean isEnablePublicPitch() {
        return PublicPitchUtil.INSTANCE.isOpenPublicPitch();
    }

    public final void markAsFinished() {
        LogUtil.i(TAG, "mCurState=" + mCurPublicProcessState);
        if (hasMarkAsFinished()) {
            return;
        }
        RecordPublicProcessorModule$markAsFinished$runnable$1 recordPublicProcessorModule$markAsFinished$runnable$1 = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule$markAsFinished$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                float[] fArr;
                float[] fArr2;
                ArrayList arrayList;
                ArrayList arrayList2;
                RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
                if (recordPublicProcessorModule.isEnablePublicPitch()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    PublicPitchProcessor mPublicPitchProcessor2 = recordPublicProcessorModule.getMPublicPitchProcessor();
                    if (mPublicPitchProcessor2 != null) {
                        mPublicPitchProcessor2.MarkAsFinished();
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    recordPublicProcessorModule.transferState(RecordPublicProcessorModule.PublicProcessInitState.MarkAsFinished);
                    LogUtil.i(RecordPublicProcessorModule.TAG, "markAsFinished cost=" + currentTimeMillis2 + MsgSummary.STR_COLON);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    RecordPublicProcessorModule.PublicPitchData mPublicPitchData2 = recordPublicProcessorModule.getMPublicPitchData();
                    PublicPitchProcessor mPublicPitchProcessor3 = recordPublicProcessorModule.getMPublicPitchProcessor();
                    Integer num = null;
                    if (mPublicPitchProcessor3 != null) {
                        fArr = mPublicPitchProcessor3.getPitchsAlign5ms();
                    } else {
                        fArr = null;
                    }
                    mPublicPitchData2.setPitchs5ms(fArr);
                    RecordPublicProcessorModule.PublicPitchData mPublicPitchData3 = recordPublicProcessorModule.getMPublicPitchData();
                    PublicPitchProcessor mPublicPitchProcessor4 = recordPublicProcessorModule.getMPublicPitchProcessor();
                    if (mPublicPitchProcessor4 != null) {
                        fArr2 = mPublicPitchProcessor4.getPitchsAlign10ms();
                    } else {
                        fArr2 = null;
                    }
                    mPublicPitchData3.setPitchs10ms(fArr2);
                    RecordPublicProcessorModule.PublicPitchData mPublicPitchData4 = recordPublicProcessorModule.getMPublicPitchData();
                    PublicPitchProcessor mPublicPitchProcessor5 = recordPublicProcessorModule.getMPublicPitchProcessor();
                    if (mPublicPitchProcessor5 != null) {
                        num = Integer.valueOf(mPublicPitchProcessor5.getAiScore());
                    }
                    mPublicPitchData4.setMAiScore(String.valueOf(num));
                    recordPublicProcessorModule.transferState(RecordPublicProcessorModule.PublicProcessInitState.DataResulted);
                    arrayList = RecordPublicProcessorModule.mPitchResultCallbackList;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        RecordPublicProcessorModule.PitchDataCallback pitchDataCallback = (RecordPublicProcessorModule.PitchDataCallback) ((WeakReference) it.next()).get();
                        if (pitchDataCallback != null) {
                            pitchDataCallback.pitchDataResult(RecordPublicProcessorModule.INSTANCE.getMPublicPitchData());
                        } else {
                            LogUtil.e(RecordPublicProcessorModule.TAG, "callback is null");
                        }
                    }
                    RecordPublicProcessorModule recordPublicProcessorModule2 = RecordPublicProcessorModule.INSTANCE;
                    arrayList2 = RecordPublicProcessorModule.mPitchResultCallbackList;
                    arrayList2.clear();
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    recordPublicProcessorModule2.setMGetPitchDataCostTm(currentTimeMillis4);
                    LogUtil.i(RecordPublicProcessorModule.TAG, "getPitchsCost=" + currentTimeMillis4);
                }
            }
        };
        Handler handler = mPublicPitchHander;
        handler.sendMessage(handler.obtainMessage(PublicProcessInitState.MarkAsFinished.ordinal(), recordPublicProcessorModule$markAsFinished$runnable$1));
    }

    public final void processData(@NotNull final byte[] dataBuffer, final int bufferSize, final float timeStamp, @NotNull final Function1<? super float[][], Unit> callback) {
        Intrinsics.checkParameterIsNotNull(dataBuffer, "dataBuffer");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule$processData$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
                if (recordPublicProcessorModule.getMHasUninit()) {
                    LogUtil.i(RecordPublicProcessorModule.TAG, "hasUnit,just return");
                    return;
                }
                if (recordPublicProcessorModule.getMPublicPitchProcessor() != null) {
                    float[][] fArr = null;
                    if (recordPublicProcessorModule.isEnablePublicPitch()) {
                        PublicPitchProcessor mPublicPitchProcessor2 = recordPublicProcessorModule.getMPublicPitchProcessor();
                        if (mPublicPitchProcessor2 != null) {
                            i3 = mPublicPitchProcessor2.Process(dataBuffer, bufferSize, timeStamp);
                        } else {
                            i3 = -1;
                        }
                        if (i3 == 0) {
                            Function1 function1 = callback;
                            PublicPitchProcessor mPublicPitchProcessor3 = recordPublicProcessorModule.getMPublicPitchProcessor();
                            if (mPublicPitchProcessor3 != null) {
                                fArr = mPublicPitchProcessor3.GetCurPitchs();
                            }
                            function1.invoke(fArr);
                            return;
                        }
                        callback.invoke(null);
                        return;
                    }
                    callback.invoke(null);
                }
            }
        };
        Handler handler = mPublicPitchHander;
        handler.sendMessage(handler.obtainMessage(PublicProcessInitState.Process.ordinal(), runnable));
    }

    public final void setMGetPitchDataCostTm(long j3) {
        mGetPitchDataCostTm = j3;
    }

    public final void setMHasUninit(boolean z16) {
        mHasUninit = z16;
    }

    public final void setMPublicPitchData(@NotNull PublicPitchData publicPitchData) {
        Intrinsics.checkParameterIsNotNull(publicPitchData, "<set-?>");
        mPublicPitchData = publicPitchData;
    }

    public final void setMPublicPitchProcessor(@Nullable PublicPitchProcessor publicPitchProcessor) {
        mPublicPitchProcessor = publicPitchProcessor;
    }

    public final void uninit() {
        mPublicPitchHander.removeMessages(PublicProcessInitState.Process.ordinal());
        mHasUninit = true;
        RecordPublicProcessorModule$uninit$runnable$1 recordPublicProcessorModule$uninit$runnable$1 = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.commom.RecordPublicProcessorModule$uninit$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList;
                RecordPublicProcessorModule recordPublicProcessorModule = RecordPublicProcessorModule.INSTANCE;
                if (recordPublicProcessorModule.isEnablePublicPitch()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    PublicPitchProcessor mPublicPitchProcessor2 = recordPublicProcessorModule.getMPublicPitchProcessor();
                    if (mPublicPitchProcessor2 != null) {
                        mPublicPitchProcessor2.unInit();
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    recordPublicProcessorModule.transferState(RecordPublicProcessorModule.PublicProcessInitState.Uninit);
                    LogUtil.i(RecordPublicProcessorModule.TAG, "uninitCost=" + currentTimeMillis2);
                    recordPublicProcessorModule.setMPublicPitchProcessor(null);
                    arrayList = RecordPublicProcessorModule.mPitchResultCallbackList;
                    arrayList.clear();
                }
            }
        };
        Handler handler = mPublicPitchHander;
        handler.sendMessage(handler.obtainMessage(PublicProcessInitState.Uninit.ordinal(), recordPublicProcessorModule$uninit$runnable$1));
    }

    public final void init(@Nullable String aiModeFilePath, @NotNull Function0<Unit> successCallback) {
        Intrinsics.checkParameterIsNotNull(successCallback, "successCallback");
        init(44100, 2, aiModeFilePath, successCallback);
    }
}
