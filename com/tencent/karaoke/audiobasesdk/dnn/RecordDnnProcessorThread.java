package com.tencent.karaoke.audiobasesdk.dnn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.utils.LogUtil;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.karaoke.audiobasesdk.dnn.RecordDnnProcessorThread;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 M2\u00020\u0001:\u0005MNOPQB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010:\u001a\u000208H\u0002J\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?J\u0016\u0010@\u001a\u0002082\u0006\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u0017J\u000e\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020\u0017J\u0010\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020\bH\u0002J)\u0010G\u001a\u00020<2!\u0010H\u001a\u001d\u0012\u0013\u0012\u001108\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020<0IR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00060&R\u00020\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u000202\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u0017X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0019\u00a8\u0006R"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread;", "Landroid/os/HandlerThread;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curState", "Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$DnnState;", "getCurState", "()Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$DnnState;", "setCurState", "(Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$DnnState;)V", "mDnnClickMicFileThread", "Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread;", "getMDnnClickMicFileThread", "()Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread;", "setMDnnClickMicFileThread", "(Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickFileThread;)V", "mDnnClickOriginFileThread", "getMDnnClickOriginFileThread", "setMDnnClickOriginFileThread", "mDnnProcessDataCount", "", "getMDnnProcessDataCount", "()I", "setMDnnProcessDataCount", "(I)V", "mDnnProcessOriginCount", "getMDnnProcessOriginCount", "setMDnnProcessOriginCount", "mDnnProcessorImpl", "Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickProcessor;", "getMDnnProcessorImpl", "()Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickProcessor;", "setMDnnProcessorImpl", "(Lcom/tencent/karaoke/audiobasesdk/dnn/DnnClickProcessor;)V", "mHandler", "Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$RecordDnnProcessorHandler;", "getMHandler", "()Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$RecordDnnProcessorHandler;", "setMHandler", "(Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$RecordDnnProcessorHandler;)V", "mRecordDnnDebug", "Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnDebug;", "getMRecordDnnDebug", "()Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnDebug;", "setMRecordDnnDebug", "(Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnDebug;)V", "outputInternalBuffer", "", "getOutputInternalBuffer", "()[B", "outputInternalLen", "getOutputInternalLen", "checkModelFile", "", "modeFilePath", "checkState", HippyQQPagView.FunctionName.FLUSH, "", "init", "enterParams", "Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$RecordDnnProcessEnterParams;", "process", "pcmInput", "inputLen", InnerAudioPlugin.AUDIO_OPERATE_SEEK, c.G, "transferState", "state", "uninit", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Companion", "DnnState", "RecordDnnProcessEnterParams", "RecordDnnProcessThreadJob", "RecordDnnProcessorHandler", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class RecordDnnProcessorThread extends BaseHandlerThread {

    @NotNull
    private final String TAG;

    @NotNull
    private DnnState curState;

    @Nullable
    private DnnClickFileThread mDnnClickMicFileThread;

    @Nullable
    private DnnClickFileThread mDnnClickOriginFileThread;
    private int mDnnProcessDataCount;
    private int mDnnProcessOriginCount;

    @Nullable
    private DnnClickProcessor mDnnProcessorImpl;

    @NotNull
    private RecordDnnProcessorHandler mHandler;

    @Nullable
    private RecordDnnDebug mRecordDnnDebug;

    @NotNull
    private final byte[] outputInternalBuffer;
    private final int outputInternalLen;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int msg_init = 1;
    private static final int msg_process = 2;
    private static final int msg_flush = 3;
    private static final int msg_seek = 4;
    private static final int msg_uninit = 5;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$Companion;", "", "()V", "msg_flush", "", "getMsg_flush", "()I", "msg_init", "getMsg_init", "msg_process", "getMsg_process", "msg_seek", "getMsg_seek", "msg_uninit", "getMsg_uninit", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final int getMsg_flush() {
            return RecordDnnProcessorThread.msg_flush;
        }

        public final int getMsg_init() {
            return RecordDnnProcessorThread.msg_init;
        }

        public final int getMsg_process() {
            return RecordDnnProcessorThread.msg_process;
        }

        public final int getMsg_seek() {
            return RecordDnnProcessorThread.msg_seek;
        }

        public final int getMsg_uninit() {
            return RecordDnnProcessorThread.msg_uninit;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$DnnState;", "", "(Ljava/lang/String;I)V", "None", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "Process", "Uninit", BaseQmcfProcessor.INIT_ERROR, "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public enum DnnState {
        None,
        Init,
        Process,
        Uninit,
        InitError
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003JK\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\tH\u00d6\u0001J\b\u0010)\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u0006*"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$RecordDnnProcessEnterParams;", "", "modeFilePath", "", "qrcContentByteArray", "", "dnnSaveFilePath", "dnnOriginSaveFilePath", "sample", "", "chanel", "(Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;II)V", "getChanel", "()I", "setChanel", "(I)V", "getDnnOriginSaveFilePath", "()Ljava/lang/String;", "setDnnOriginSaveFilePath", "(Ljava/lang/String;)V", "getDnnSaveFilePath", "setDnnSaveFilePath", "getModeFilePath", "setModeFilePath", "getQrcContentByteArray", "()[B", "setQrcContentByteArray", "([B)V", "getSample", "setSample", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final /* data */ class RecordDnnProcessEnterParams {
        private int chanel;

        @Nullable
        private String dnnOriginSaveFilePath;

        @NotNull
        private String dnnSaveFilePath;

        @Nullable
        private String modeFilePath;

        @Nullable
        private byte[] qrcContentByteArray;
        private int sample;

        public RecordDnnProcessEnterParams(@Nullable String str, @Nullable byte[] bArr, @NotNull String dnnSaveFilePath, @Nullable String str2, int i3, int i16) {
            Intrinsics.checkParameterIsNotNull(dnnSaveFilePath, "dnnSaveFilePath");
            this.modeFilePath = str;
            this.qrcContentByteArray = bArr;
            this.dnnSaveFilePath = dnnSaveFilePath;
            this.dnnOriginSaveFilePath = str2;
            this.sample = i3;
            this.chanel = i16;
        }

        @NotNull
        public static /* synthetic */ RecordDnnProcessEnterParams copy$default(RecordDnnProcessEnterParams recordDnnProcessEnterParams, String str, byte[] bArr, String str2, String str3, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                str = recordDnnProcessEnterParams.modeFilePath;
            }
            if ((i17 & 2) != 0) {
                bArr = recordDnnProcessEnterParams.qrcContentByteArray;
            }
            byte[] bArr2 = bArr;
            if ((i17 & 4) != 0) {
                str2 = recordDnnProcessEnterParams.dnnSaveFilePath;
            }
            String str4 = str2;
            if ((i17 & 8) != 0) {
                str3 = recordDnnProcessEnterParams.dnnOriginSaveFilePath;
            }
            String str5 = str3;
            if ((i17 & 16) != 0) {
                i3 = recordDnnProcessEnterParams.sample;
            }
            int i18 = i3;
            if ((i17 & 32) != 0) {
                i16 = recordDnnProcessEnterParams.chanel;
            }
            return recordDnnProcessEnterParams.copy(str, bArr2, str4, str5, i18, i16);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getModeFilePath() {
            return this.modeFilePath;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final byte[] getQrcContentByteArray() {
            return this.qrcContentByteArray;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getDnnSaveFilePath() {
            return this.dnnSaveFilePath;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getDnnOriginSaveFilePath() {
            return this.dnnOriginSaveFilePath;
        }

        /* renamed from: component5, reason: from getter */
        public final int getSample() {
            return this.sample;
        }

        /* renamed from: component6, reason: from getter */
        public final int getChanel() {
            return this.chanel;
        }

        @NotNull
        public final RecordDnnProcessEnterParams copy(@Nullable String modeFilePath, @Nullable byte[] qrcContentByteArray, @NotNull String dnnSaveFilePath, @Nullable String dnnOriginSaveFilePath, int sample, int chanel) {
            Intrinsics.checkParameterIsNotNull(dnnSaveFilePath, "dnnSaveFilePath");
            return new RecordDnnProcessEnterParams(modeFilePath, qrcContentByteArray, dnnSaveFilePath, dnnOriginSaveFilePath, sample, chanel);
        }

        public boolean equals(@Nullable Object other) {
            boolean z16;
            boolean z17;
            if (this != other) {
                if (other instanceof RecordDnnProcessEnterParams) {
                    RecordDnnProcessEnterParams recordDnnProcessEnterParams = (RecordDnnProcessEnterParams) other;
                    if (Intrinsics.areEqual(this.modeFilePath, recordDnnProcessEnterParams.modeFilePath) && Intrinsics.areEqual(this.qrcContentByteArray, recordDnnProcessEnterParams.qrcContentByteArray) && Intrinsics.areEqual(this.dnnSaveFilePath, recordDnnProcessEnterParams.dnnSaveFilePath) && Intrinsics.areEqual(this.dnnOriginSaveFilePath, recordDnnProcessEnterParams.dnnOriginSaveFilePath)) {
                        if (this.sample == recordDnnProcessEnterParams.sample) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            if (this.chanel == recordDnnProcessEnterParams.chanel) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final int getChanel() {
            return this.chanel;
        }

        @Nullable
        public final String getDnnOriginSaveFilePath() {
            return this.dnnOriginSaveFilePath;
        }

        @NotNull
        public final String getDnnSaveFilePath() {
            return this.dnnSaveFilePath;
        }

        @Nullable
        public final String getModeFilePath() {
            return this.modeFilePath;
        }

        @Nullable
        public final byte[] getQrcContentByteArray() {
            return this.qrcContentByteArray;
        }

        public final int getSample() {
            return this.sample;
        }

        public int hashCode() {
            int i3;
            int i16;
            int i17;
            String str = this.modeFilePath;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = i3 * 31;
            byte[] bArr = this.qrcContentByteArray;
            if (bArr != null) {
                i16 = Arrays.hashCode(bArr);
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 31;
            String str2 = this.dnnSaveFilePath;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i27 = (i26 + i17) * 31;
            String str3 = this.dnnOriginSaveFilePath;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            return ((((i27 + i18) * 31) + this.sample) * 31) + this.chanel;
        }

        public final void setChanel(int i3) {
            this.chanel = i3;
        }

        public final void setDnnOriginSaveFilePath(@Nullable String str) {
            this.dnnOriginSaveFilePath = str;
        }

        public final void setDnnSaveFilePath(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.dnnSaveFilePath = str;
        }

        public final void setModeFilePath(@Nullable String str) {
            this.modeFilePath = str;
        }

        public final void setQrcContentByteArray(@Nullable byte[] bArr) {
            this.qrcContentByteArray = bArr;
        }

        public final void setSample(int i3) {
            this.sample = i3;
        }

        @NotNull
        public String toString() {
            return "RecordDnnProcessEnterParams(modeFilePath=" + this.modeFilePath + ", dnnSaveFilePath='" + this.dnnSaveFilePath + "', dnnOriginSaveFilePath=" + this.dnnOriginSaveFilePath + ", sample=" + this.sample + ", chanel=" + this.chanel + ')';
        }

        public /* synthetic */ RecordDnnProcessEnterParams(String str, byte[] bArr, String str2, String str3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, bArr, str2, (i17 & 8) != 0 ? null : str3, (i17 & 16) != 0 ? 44100 : i3, (i17 & 32) != 0 ? 2 : i16);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$RecordDnnProcessThreadJob;", "", QQBrowserActivity.KEY_MSG_TYPE, "", "byteBuffer", "", "byteLen", "(I[BI)V", "getByteBuffer", "()[B", "setByteBuffer", "([B)V", "getByteLen", "()I", "setByteLen", "(I)V", "getMsgType", "setMsgType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final /* data */ class RecordDnnProcessThreadJob {

        @Nullable
        private byte[] byteBuffer;
        private int byteLen;
        private int msgType;

        public RecordDnnProcessThreadJob(int i3, @Nullable byte[] bArr, int i16) {
            this.msgType = i3;
            this.byteBuffer = bArr;
            this.byteLen = i16;
        }

        @NotNull
        public static /* synthetic */ RecordDnnProcessThreadJob copy$default(RecordDnnProcessThreadJob recordDnnProcessThreadJob, int i3, byte[] bArr, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = recordDnnProcessThreadJob.msgType;
            }
            if ((i17 & 2) != 0) {
                bArr = recordDnnProcessThreadJob.byteBuffer;
            }
            if ((i17 & 4) != 0) {
                i16 = recordDnnProcessThreadJob.byteLen;
            }
            return recordDnnProcessThreadJob.copy(i3, bArr, i16);
        }

        /* renamed from: component1, reason: from getter */
        public final int getMsgType() {
            return this.msgType;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final byte[] getByteBuffer() {
            return this.byteBuffer;
        }

        /* renamed from: component3, reason: from getter */
        public final int getByteLen() {
            return this.byteLen;
        }

        @NotNull
        public final RecordDnnProcessThreadJob copy(int msgType, @Nullable byte[] byteBuffer, int byteLen) {
            return new RecordDnnProcessThreadJob(msgType, byteBuffer, byteLen);
        }

        public boolean equals(@Nullable Object other) {
            boolean z16;
            boolean z17;
            if (this != other) {
                if (other instanceof RecordDnnProcessThreadJob) {
                    RecordDnnProcessThreadJob recordDnnProcessThreadJob = (RecordDnnProcessThreadJob) other;
                    if (this.msgType == recordDnnProcessThreadJob.msgType) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && Intrinsics.areEqual(this.byteBuffer, recordDnnProcessThreadJob.byteBuffer)) {
                        if (this.byteLen == recordDnnProcessThreadJob.byteLen) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @Nullable
        public final byte[] getByteBuffer() {
            return this.byteBuffer;
        }

        public final int getByteLen() {
            return this.byteLen;
        }

        public final int getMsgType() {
            return this.msgType;
        }

        public int hashCode() {
            int i3;
            int i16 = this.msgType * 31;
            byte[] bArr = this.byteBuffer;
            if (bArr != null) {
                i3 = Arrays.hashCode(bArr);
            } else {
                i3 = 0;
            }
            return ((i16 + i3) * 31) + this.byteLen;
        }

        public final void setByteBuffer(@Nullable byte[] bArr) {
            this.byteBuffer = bArr;
        }

        public final void setByteLen(int i3) {
            this.byteLen = i3;
        }

        public final void setMsgType(int i3) {
            this.msgType = i3;
        }

        @NotNull
        public String toString() {
            return "RecordDnnProcessThreadJob(msgType=" + this.msgType + ", byteBuffer=" + Arrays.toString(this.byteBuffer) + ", byteLen=" + this.byteLen + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread$RecordDnnProcessorHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnProcessorThread;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public final class RecordDnnProcessorHandler extends Handler {
        final /* synthetic */ RecordDnnProcessorThread this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecordDnnProcessorHandler(@NotNull RecordDnnProcessorThread recordDnnProcessorThread, Looper looper) {
            super(looper);
            Intrinsics.checkParameterIsNotNull(looper, "looper");
            this.this$0 = recordDnnProcessorThread;
        }

        @Override // android.os.Handler
        public void handleMessage(@Nullable Message msg2) {
            boolean z16;
            int i3;
            byte[] copyOfRange;
            byte[] copyOfRange2;
            if (msg2 != null) {
                int i16 = msg2.what;
                Companion companion = RecordDnnProcessorThread.INSTANCE;
                if (i16 == companion.getMsg_process()) {
                    try {
                        int outputInternalLen = this.this$0.getOutputInternalLen();
                        Object obj = msg2.obj;
                        if (!(obj instanceof RecordDnnProcessThreadJob)) {
                            obj = null;
                        }
                        RecordDnnProcessThreadJob recordDnnProcessThreadJob = (RecordDnnProcessThreadJob) obj;
                        if (recordDnnProcessThreadJob != null) {
                            byte[] byteBuffer = recordDnnProcessThreadJob.getByteBuffer();
                            int byteLen = recordDnnProcessThreadJob.getByteLen();
                            Object obj2 = "";
                            if (byteBuffer == null) {
                                RecordDnnDebug mRecordDnnDebug = this.this$0.getMRecordDnnDebug();
                                if (mRecordDnnDebug != null) {
                                    mRecordDnnDebug.writeLog("pcmInput is null,when processdata");
                                    obj2 = Unit.INSTANCE;
                                }
                                throw new IllegalStateException(obj2.toString());
                            }
                            if (byteLen > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                RecordDnnDebug mRecordDnnDebug2 = this.this$0.getMRecordDnnDebug();
                                if (mRecordDnnDebug2 != null) {
                                    mRecordDnnDebug2.writeLog("checkLogFile");
                                    obj2 = Unit.INSTANCE;
                                }
                                throw new IllegalStateException(obj2.toString());
                            }
                            DnnClickFileThread mDnnClickOriginFileThread = this.this$0.getMDnnClickOriginFileThread();
                            if (mDnnClickOriginFileThread != null) {
                                copyOfRange2 = ArraysKt___ArraysJvmKt.copyOfRange(byteBuffer, 0, byteLen);
                                DnnClickFileThread.insertAndStart$default(mDnnClickOriginFileThread, copyOfRange2, byteLen, null, 4, null);
                            }
                            RecordDnnProcessorThread recordDnnProcessorThread = this.this$0;
                            recordDnnProcessorThread.setMDnnProcessOriginCount(recordDnnProcessorThread.getMDnnProcessOriginCount() + byteLen);
                            DnnClickProcessor mDnnProcessorImpl = this.this$0.getMDnnProcessorImpl();
                            if (mDnnProcessorImpl != null) {
                                i3 = mDnnProcessorImpl.process(byteBuffer, byteLen, this.this$0.getOutputInternalBuffer(), outputInternalLen);
                            } else {
                                i3 = 0;
                            }
                            RecordDnnDebug mRecordDnnDebug3 = this.this$0.getMRecordDnnDebug();
                            if (mRecordDnnDebug3 != null) {
                                mRecordDnnDebug3.writeLog("process ret>>>> " + i3 + ",preOutButBufferSize=" + outputInternalLen);
                            }
                            if (i3 > 0) {
                                DnnClickFileThread mDnnClickMicFileThread = this.this$0.getMDnnClickMicFileThread();
                                if (mDnnClickMicFileThread != null) {
                                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(this.this$0.getOutputInternalBuffer(), 0, i3);
                                    DnnClickFileThread.insertAndStart$default(mDnnClickMicFileThread, copyOfRange, i3, null, 4, null);
                                }
                                RecordDnnProcessorThread recordDnnProcessorThread2 = this.this$0;
                                recordDnnProcessorThread2.setMDnnProcessDataCount(recordDnnProcessorThread2.getMDnnProcessDataCount() + i3);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (i16 == companion.getMsg_init() || i16 == companion.getMsg_seek() || i16 == companion.getMsg_flush() || i16 == companion.getMsg_uninit()) {
                    Object obj3 = msg2.obj;
                    if (obj3 != null) {
                        ((Runnable) obj3).run();
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Runnable");
                }
            }
        }
    }

    public RecordDnnProcessorThread() {
        super("RecordDnnProcessThread");
        this.TAG = "RecordDnnProcessorThread";
        this.outputInternalLen = 352800;
        this.outputInternalBuffer = new byte[352800];
        this.curState = DnnState.None;
        LogUtil.i("RecordDnnProcessorThread", "outputLen: 352800");
        start();
        Looper looper = getLooper();
        Intrinsics.checkExpressionValueIsNotNull(looper, "looper");
        this.mHandler = new RecordDnnProcessorHandler(this, looper);
    }

    private final boolean checkModelFile(String modeFilePath) {
        if (modeFilePath != null) {
            File file = new File(modeFilePath);
            if (!file.exists()) {
                LogUtil.i(this.TAG, "model file not exists");
                return false;
            }
            if (!file.isFile()) {
                LogUtil.i(this.TAG, "model file is not a file");
                return false;
            }
            return true;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkState() {
        DnnState dnnState = this.curState;
        if (dnnState != DnnState.None && dnnState != DnnState.Uninit && dnnState != DnnState.InitError) {
            return true;
        }
        LogUtil.i(this.TAG, "state not valid,curState = " + this.curState);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void transferState(DnnState state) {
        LogUtil.i(this.TAG, "curState=" + this.curState + ",target state=" + state);
        this.curState = state;
    }

    public final void flush() {
        if (!checkState()) {
            return;
        }
        RecordDnnProcessorHandler recordDnnProcessorHandler = this.mHandler;
        recordDnnProcessorHandler.sendMessage(recordDnnProcessorHandler.obtainMessage(msg_flush, new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.dnn.RecordDnnProcessorThread$flush$1
            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                byte[] copyOfRange;
                int outputInternalLen = RecordDnnProcessorThread.this.getOutputInternalLen();
                DnnClickProcessor mDnnProcessorImpl = RecordDnnProcessorThread.this.getMDnnProcessorImpl();
                if (mDnnProcessorImpl != null) {
                    i3 = mDnnProcessorImpl.flush(RecordDnnProcessorThread.this.getOutputInternalBuffer(), outputInternalLen);
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    RecordDnnDebug mRecordDnnDebug = RecordDnnProcessorThread.this.getMRecordDnnDebug();
                    if (mRecordDnnDebug != null) {
                        mRecordDnnDebug.writeLog("after flush\uff0cret=" + i3);
                    }
                    RecordDnnProcessorThread recordDnnProcessorThread = RecordDnnProcessorThread.this;
                    recordDnnProcessorThread.setMDnnProcessDataCount(recordDnnProcessorThread.getMDnnProcessDataCount() + i3);
                    DnnClickFileThread mDnnClickMicFileThread = RecordDnnProcessorThread.this.getMDnnClickMicFileThread();
                    if (mDnnClickMicFileThread != null) {
                        copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(RecordDnnProcessorThread.this.getOutputInternalBuffer(), 0, i3);
                        mDnnClickMicFileThread.insertAndStart(copyOfRange, i3, DnnUnitType.Flush);
                    }
                }
            }
        }));
    }

    @NotNull
    public final DnnState getCurState() {
        return this.curState;
    }

    @Nullable
    public final DnnClickFileThread getMDnnClickMicFileThread() {
        return this.mDnnClickMicFileThread;
    }

    @Nullable
    public final DnnClickFileThread getMDnnClickOriginFileThread() {
        return this.mDnnClickOriginFileThread;
    }

    public final int getMDnnProcessDataCount() {
        return this.mDnnProcessDataCount;
    }

    public final int getMDnnProcessOriginCount() {
        return this.mDnnProcessOriginCount;
    }

    @Nullable
    public final DnnClickProcessor getMDnnProcessorImpl() {
        return this.mDnnProcessorImpl;
    }

    @NotNull
    public final RecordDnnProcessorHandler getMHandler() {
        return this.mHandler;
    }

    @Nullable
    public final RecordDnnDebug getMRecordDnnDebug() {
        return this.mRecordDnnDebug;
    }

    @NotNull
    public final byte[] getOutputInternalBuffer() {
        return this.outputInternalBuffer;
    }

    public final int getOutputInternalLen() {
        return this.outputInternalLen;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final void init(@NotNull final RecordDnnProcessEnterParams enterParams) throws NullPointerException {
        Intrinsics.checkParameterIsNotNull(enterParams, "enterParams");
        RecordDnnDebug recordDnnDebug = this.mRecordDnnDebug;
        if (recordDnnDebug != null) {
            recordDnnDebug.writeLog("enterParams:" + enterParams);
        }
        if (this.curState == DnnState.Init) {
            LogUtil.i(this.TAG, "has init before");
            return;
        }
        transferState(DnnState.None);
        this.mHandler.removeCallbacksAndMessages(null);
        if (!checkModelFile(enterParams.getModeFilePath())) {
            return;
        }
        if (enterParams.getQrcContentByteArray() != null) {
            if (enterParams.getDnnSaveFilePath() != null) {
                Runnable runnable = new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.dnn.RecordDnnProcessorThread$init$initRunable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecordDnnProcessorThread.this.setMDnnClickMicFileThread(new DnnClickFileThread(enterParams.getDnnSaveFilePath(), RecordDnnProcessorThread.this.getMRecordDnnDebug()));
                        RecordDnnDebug mRecordDnnDebug = RecordDnnProcessorThread.this.getMRecordDnnDebug();
                        if (mRecordDnnDebug != null && mRecordDnnDebug.getEnableDebug() && !TextUtils.isEmpty(enterParams.getDnnOriginSaveFilePath())) {
                            LogUtil.i(mRecordDnnDebug.getTAG(), "debug mode");
                            RecordDnnProcessorThread recordDnnProcessorThread = RecordDnnProcessorThread.this;
                            String dnnOriginSaveFilePath = enterParams.getDnnOriginSaveFilePath();
                            if (dnnOriginSaveFilePath == null) {
                                Intrinsics.throwNpe();
                            }
                            recordDnnProcessorThread.setMDnnClickOriginFileThread(new DnnClickFileThread(dnnOriginSaveFilePath, null, 2, null));
                        }
                        RecordDnnProcessorThread.this.setMDnnProcessorImpl(new DnnClickProcessor());
                        LogUtil.i(RecordDnnProcessorThread.this.getTAG(), "dnnInitIsSuccess: false");
                        RecordDnnProcessorThread.this.transferState(RecordDnnProcessorThread.DnnState.InitError);
                        RecordDnnProcessorThread.this.setMDnnProcessDataCount(0);
                    }
                };
                RecordDnnProcessorHandler recordDnnProcessorHandler = this.mHandler;
                recordDnnProcessorHandler.sendMessage(recordDnnProcessorHandler.obtainMessage(msg_init, runnable));
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final boolean process(@NotNull byte[] pcmInput, int inputLen) {
        byte[] copyOfRange;
        Intrinsics.checkParameterIsNotNull(pcmInput, "pcmInput");
        if (!checkState()) {
            return false;
        }
        int i3 = msg_process;
        copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(pcmInput, 0, inputLen);
        RecordDnnProcessThreadJob recordDnnProcessThreadJob = new RecordDnnProcessThreadJob(i3, copyOfRange, inputLen);
        RecordDnnProcessorHandler recordDnnProcessorHandler = this.mHandler;
        recordDnnProcessorHandler.sendMessage(recordDnnProcessorHandler.obtainMessage(i3, recordDnnProcessThreadJob));
        return true;
    }

    public final void seek(final int pos) {
        if (!checkState()) {
            return;
        }
        RecordDnnProcessorHandler recordDnnProcessorHandler = this.mHandler;
        recordDnnProcessorHandler.sendMessage(recordDnnProcessorHandler.obtainMessage(msg_seek, new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.dnn.RecordDnnProcessorThread$seek$1
            @Override // java.lang.Runnable
            public final void run() {
                RecordDnnDebug mRecordDnnDebug = RecordDnnProcessorThread.this.getMRecordDnnDebug();
                if (mRecordDnnDebug != null) {
                    mRecordDnnDebug.writeLog("excute seek pos=" + pos);
                }
                DnnClickProcessor mDnnProcessorImpl = RecordDnnProcessorThread.this.getMDnnProcessorImpl();
                if (mDnnProcessorImpl != null) {
                    mDnnProcessorImpl.seek(pos);
                }
                DnnClickFileThread mDnnClickOriginFileThread = RecordDnnProcessorThread.this.getMDnnClickOriginFileThread();
                if (mDnnClickOriginFileThread != null) {
                    mDnnClickOriginFileThread.insertAndStart(null, pos, DnnUnitType.Seek);
                }
                DnnClickFileThread mDnnClickMicFileThread = RecordDnnProcessorThread.this.getMDnnClickMicFileThread();
                if (mDnnClickMicFileThread != null) {
                    mDnnClickMicFileThread.insertAndStart(null, pos, DnnUnitType.Seek);
                }
            }
        }));
    }

    public final void setCurState(@NotNull DnnState dnnState) {
        Intrinsics.checkParameterIsNotNull(dnnState, "<set-?>");
        this.curState = dnnState;
    }

    public final void setMDnnClickMicFileThread(@Nullable DnnClickFileThread dnnClickFileThread) {
        this.mDnnClickMicFileThread = dnnClickFileThread;
    }

    public final void setMDnnClickOriginFileThread(@Nullable DnnClickFileThread dnnClickFileThread) {
        this.mDnnClickOriginFileThread = dnnClickFileThread;
    }

    public final void setMDnnProcessDataCount(int i3) {
        this.mDnnProcessDataCount = i3;
    }

    public final void setMDnnProcessOriginCount(int i3) {
        this.mDnnProcessOriginCount = i3;
    }

    public final void setMDnnProcessorImpl(@Nullable DnnClickProcessor dnnClickProcessor) {
        this.mDnnProcessorImpl = dnnClickProcessor;
    }

    public final void setMHandler(@NotNull RecordDnnProcessorHandler recordDnnProcessorHandler) {
        Intrinsics.checkParameterIsNotNull(recordDnnProcessorHandler, "<set-?>");
        this.mHandler = recordDnnProcessorHandler;
    }

    public final void setMRecordDnnDebug(@Nullable RecordDnnDebug recordDnnDebug) {
        this.mRecordDnnDebug = recordDnnDebug;
    }

    public final void uninit(@NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (this.curState == DnnState.Uninit) {
            LogUtil.i(this.TAG, "hasUnit,don't do againi");
        } else {
            RecordDnnProcessorHandler recordDnnProcessorHandler = this.mHandler;
            recordDnnProcessorHandler.sendMessage(recordDnnProcessorHandler.obtainMessage(msg_uninit, new Runnable() { // from class: com.tencent.karaoke.audiobasesdk.dnn.RecordDnnProcessorThread$uninit$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean checkState;
                    DnnClickProcessor mDnnProcessorImpl = RecordDnnProcessorThread.this.getMDnnProcessorImpl();
                    if (mDnnProcessorImpl != null) {
                        mDnnProcessorImpl.uninit();
                    }
                    RecordDnnProcessorThread.this.setMDnnProcessorImpl(null);
                    DnnUnitType dnnUnitType = DnnUnitType.Finish;
                    DnnUnitJob dnnUnitJob = new DnnUnitJob(null, 0, dnnUnitType, callback);
                    checkState = RecordDnnProcessorThread.this.checkState();
                    if (!checkState) {
                        LogUtil.i(RecordDnnProcessorThread.this.getTAG(), "state is not valid,state=" + RecordDnnProcessorThread.this.getCurState());
                        dnnUnitJob.setCallback(null);
                        callback.invoke(Boolean.FALSE);
                    }
                    DnnClickFileThread mDnnClickMicFileThread = RecordDnnProcessorThread.this.getMDnnClickMicFileThread();
                    if (mDnnClickMicFileThread != null) {
                        mDnnClickMicFileThread.insertJob(dnnUnitJob);
                    }
                    DnnClickFileThread mDnnClickOriginFileThread = RecordDnnProcessorThread.this.getMDnnClickOriginFileThread();
                    if (mDnnClickOriginFileThread != null) {
                        mDnnClickOriginFileThread.insertAndStart(null, 0, dnnUnitType);
                    }
                    DnnClickFileThread mDnnClickOriginFileThread2 = RecordDnnProcessorThread.this.getMDnnClickOriginFileThread();
                    if (mDnnClickOriginFileThread2 != null) {
                        mDnnClickOriginFileThread2.join();
                    }
                    DnnClickFileThread mDnnClickOriginFileThread3 = RecordDnnProcessorThread.this.getMDnnClickOriginFileThread();
                    if (mDnnClickOriginFileThread3 != null) {
                        mDnnClickOriginFileThread3.join();
                    }
                    LogUtil.i(RecordDnnProcessorThread.this.getTAG(), "originPcmInput=" + RecordDnnProcessorThread.this.getMDnnProcessOriginCount() + ",dnnPcmOutPut=" + RecordDnnProcessorThread.this.getMDnnProcessDataCount());
                    RecordDnnDebug mRecordDnnDebug = RecordDnnProcessorThread.this.getMRecordDnnDebug();
                    if (mRecordDnnDebug != null) {
                        mRecordDnnDebug.writeLog("originPcmInput=" + RecordDnnProcessorThread.this.getMDnnProcessOriginCount() + ",dnnPcmOutPut=" + RecordDnnProcessorThread.this.getMDnnProcessDataCount());
                    }
                    RecordDnnProcessorThread.this.transferState(RecordDnnProcessorThread.DnnState.Uninit);
                    RecordDnnDebug mRecordDnnDebug2 = RecordDnnProcessorThread.this.getMRecordDnnDebug();
                    if (mRecordDnnDebug2 != null) {
                        mRecordDnnDebug2.release();
                    }
                    RecordDnnProcessorThread.this.quit();
                }
            }));
        }
    }
}
