package com.tencent.mobileqq.ptt.api.impl;

import android.os.Message;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.ptt.api.IVoiceToTextSttApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttSilkSliceUploadProcessor;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import td2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\"\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016R\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010!R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010%R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010#R\u001e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u001407j\b\u0012\u0004\u0012\u00020\u0014`88\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010?\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/ptt/api/impl/VoiceToTextSttApiImpl;", "Lcom/tencent/mobileqq/ptt/api/IVoiceToTextSttApi;", "", "path", "", "sliceData", "pcmForVadPath", "", "isFirst", "isLast", "", "sendSttRequest", "isLastTask", "doSttTask", "Ljava/io/File;", "pcmFile", "readFileFromStart", "cancelSttTask", "", "isFirstOrLast", "", "getSttIntervalConfig", "uniSeq", "cancelVoiceTextTask", "sessionId", "setRecorderSessionId", Constants.AUDIO_FILE_PATH, "Ltd2/a;", "listener", "onRecorderStart", "onRecorderEnd", "cancelAllRequest", "sMaxBufferSize", "I", "isFirstPage", "Z", "currentSession", "Ljava/lang/String;", "currentConvertIndex", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "transFileController", "Lcom/tencent/mobileqq/transfile/api/ITransFileController;", "newDataSize", "sliceUuid", "mPcmForFilePath", "mAudioFilePath", "Ljava/util/Timer;", "sttTimer", "Ljava/util/Timer;", "startPcmFileOffset", "J", "hasSttRequest", "Lmqq/util/WeakReference;", "listenerRef", "Lmqq/util/WeakReference;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sendIds", "Ljava/util/ArrayList;", "sttIntervalMillis$delegate", "Lkotlin/Lazy;", "getSttIntervalMillis", "()J", "sttIntervalMillis", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "pttTransProcessorHandler", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "<init>", "()V", "Companion", "a", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class VoiceToTextSttApiImpl implements IVoiceToTextSttApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "VoiceToTextSttApiImpl";
    private int currentConvertIndex;

    @NotNull
    private String currentSession;
    private boolean hasSttRequest;
    private boolean isFirstPage;

    @NotNull
    private WeakReference<a> listenerRef;

    @NotNull
    private String mAudioFilePath;

    @NotNull
    private String mPcmForFilePath;
    private int newDataSize;

    @NotNull
    private final TransProcessorHandler pttTransProcessorHandler;
    private final int sMaxBufferSize;

    @NotNull
    private final ArrayList<Long> sendIds;

    @NotNull
    private String sliceUuid;
    private long startPcmFileOffset;

    /* renamed from: sttIntervalMillis$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sttIntervalMillis;

    @Nullable
    private Timer sttTimer;

    @Nullable
    private ITransFileController transFileController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ptt/api/impl/VoiceToTextSttApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ptt.api.impl.VoiceToTextSttApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/ptt/api/impl/VoiceToTextSttApiImpl$b", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends TransProcessorHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VoiceToTextSttApiImpl.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
            FileMsg fileMsg = (FileMsg) obj;
            int i3 = fileMsg.fileType;
            if (i3 == 327699 && fileMsg.commandId == 68) {
                a aVar = (a) VoiceToTextSttApiImpl.this.listenerRef.get();
                if (aVar == null) {
                    QLog.i(VoiceToTextSttApiImpl.TAG, 1, "[handleMessage] msg:" + msg2.what + " listener is null");
                }
                int i16 = msg2.what;
                if (i16 != 1004) {
                    if (i16 != 2005) {
                        if (i16 != 2002) {
                            if (i16 != 2003) {
                                QLog.d(VoiceToTextSttApiImpl.TAG, 4, "[handleMessage] unknow msg:" + i16);
                                return;
                            }
                            QLog.i(VoiceToTextSttApiImpl.TAG, 1, "[handleMessage] STATUS_RECV_FINISHED: " + fileMsg.pttSliceText);
                            if (!TextUtils.isEmpty(fileMsg.pttSliceText) && aVar != null) {
                                aVar.b(fileMsg.pttSliceText);
                            }
                            if (aVar != null) {
                                aVar.c();
                            }
                            VoiceToTextSttApiImpl.this.sendIds.clear();
                            return;
                        }
                        if (!StringUtil.isEmpty(fileMsg.pttSliceText)) {
                            QLog.i(VoiceToTextSttApiImpl.TAG, 1, "STATUS_RECV_PROCESS " + fileMsg.pttSliceText);
                            if (aVar != null) {
                                aVar.b(fileMsg.pttSliceText);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    QLog.i(VoiceToTextSttApiImpl.TAG, 1, "pttTransProcessorHandler recieve error:" + fileMsg.errorCode);
                    if (aVar != null) {
                        aVar.a(fileMsg.errorCode);
                    }
                    VoiceToTextSttApiImpl.this.cancelSttTask();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(VoiceToTextSttApiImpl.TAG, 1, "pttTransProcessorHandler STATUS_SEND_CANCEL");
                    if (aVar != null) {
                        aVar.c();
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.d(VoiceToTextSttApiImpl.TAG, 4, "[handleMessage] fileType:" + i3 + " is not 327699 , msg:" + msg2.what);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VoiceToTextSttApiImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sMaxBufferSize = QQLiveError.ANCHOR_ISOLATE_CLOSE_SDK_NOT_READY;
        this.isFirstPage = true;
        this.currentSession = "";
        this.sliceUuid = "";
        this.mPcmForFilePath = "";
        this.mAudioFilePath = "";
        this.listenerRef = new WeakReference<>(null);
        this.sendIds = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.ptt.api.impl.VoiceToTextSttApiImpl$sttIntervalMillis$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VoiceToTextSttApiImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                long sttIntervalConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                sttIntervalConfig = VoiceToTextSttApiImpl.this.getSttIntervalConfig();
                return Long.valueOf(sttIntervalConfig);
            }
        });
        this.sttIntervalMillis = lazy;
        this.pttTransProcessorHandler = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelSttTask() {
        Timer timer = this.sttTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.sttTimer = null;
    }

    private final void cancelVoiceTextTask(long uniSeq) {
        boolean z16;
        BaseTransProcessor baseTransProcessor;
        TransferRequest transferRequest;
        if (uniSeq == 0) {
            return;
        }
        Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
        while (it.hasNext()) {
            IHttpCommunicatorListener value = it.next().getValue();
            boolean z17 = true;
            if ((value instanceof PttSliceUploadProcessor) && ((PttSliceUploadProcessor) value).getFileStatus() != Constant.FROM_ID_START_ACTIVITY) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (value instanceof BaseTransProcessor) {
                baseTransProcessor = (BaseTransProcessor) value;
            } else {
                baseTransProcessor = null;
            }
            if (!z16) {
                if (baseTransProcessor == null || (transferRequest = baseTransProcessor.mUiRequest) == null || uniSeq != transferRequest.mUniseq) {
                    z17 = false;
                }
                if (!z17) {
                }
            }
            if (baseTransProcessor != null) {
                baseTransProcessor.cancel();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cancelVoiceTextTask:" + uniSeq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSttTask(boolean isLastTask) {
        boolean z16;
        byte[] copyOfRange;
        boolean z17;
        boolean z18;
        File file = new File(this.mPcmForFilePath);
        if (!file.exists()) {
            QLog.i(TAG, 1, "[run] sttTimerTask. pcm file not exits: " + this.mPcmForFilePath);
            return;
        }
        QLog.i(TAG, 1, "[run] sttTimerTask. isFirstPage:" + this.isFirstPage + " isLastTask\uff1a" + isLastTask + " mAudioFilePath: " + this.mAudioFilePath);
        try {
            byte[] readFileFromStart = readFileFromStart(file);
            int length = readFileFromStart.length;
            int i3 = this.sMaxBufferSize;
            if (length > i3) {
                int length2 = ((readFileFromStart.length + i3) - 1) / i3;
                for (int i16 = 0; i16 < length2; i16++) {
                    int i17 = this.sMaxBufferSize;
                    int i18 = i16 * i17;
                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(readFileFromStart, i18, Math.min(i17 + i18, readFileFromStart.length));
                    if (isLastTask && i16 == length2 - 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (copyOfRange.length == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18 && !z17) {
                        QLog.i(TAG, 1, "[doSttTask] chunk is empty");
                    } else {
                        sendSttRequest(this.mAudioFilePath, copyOfRange, this.mPcmForFilePath, this.isFirstPage, z17);
                        this.isFirstPage = false;
                    }
                }
                return;
            }
            if (readFileFromStart.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !isLastTask) {
                QLog.i(TAG, 1, "[doSttTask] bytes isEmpty");
            } else {
                sendSttRequest(this.mAudioFilePath, readFileFromStart, this.mPcmForFilePath, this.isFirstPage, isLastTask);
                this.isFirstPage = false;
            }
        } catch (IOException e16) {
            QLog.e(TAG, 1, "[run] IOException:" + e16, e16);
            sendSttRequest(this.mAudioFilePath, new byte[0], this.mPcmForFilePath, this.isFirstPage, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getSttIntervalConfig() {
        boolean z16;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105867", "");
        if (loadAsString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 200L;
        }
        try {
            return new JSONObject(loadAsString).optLong(WidgetCacheConstellationData.INTERVAL);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "[getSttIntervalConfig] exception:" + e16, e16);
            return 200L;
        }
    }

    private final long getSttIntervalMillis() {
        return ((Number) this.sttIntervalMillis.getValue()).longValue();
    }

    private final int isFirstOrLast(boolean isFirst, boolean isLast) {
        if (isFirst && isLast) {
            return 3;
        }
        if (isFirst) {
            return 2;
        }
        if (isLast) {
            return 1;
        }
        return 0;
    }

    private final byte[] readFileFromStart(File pcmFile) {
        if (!pcmFile.exists()) {
            QLog.w(TAG, 1, "[readFileFromStart] file not exits:" + pcmFile.getPath());
            return new byte[0];
        }
        long length = pcmFile.length();
        long j3 = this.startPcmFileOffset;
        if (j3 >= length) {
            QLog.w(TAG, 1, "[readFileFromStart] start pos incorrect");
            return new byte[0];
        }
        byte[] bArr = new byte[(int) (length - j3)];
        FileInputStream fileInputStream = new FileInputStream(pcmFile);
        try {
            fileInputStream.skip(this.startPcmFileOffset);
            fileInputStream.read(bArr);
            CloseableKt.closeFinally(fileInputStream, null);
            this.startPcmFileOffset = length;
            return bArr;
        } finally {
        }
    }

    private final void sendSttRequest(String path, byte[] sliceData, String pcmForVadPath, boolean isFirst, boolean isLast) {
        boolean z16;
        byte[] bArr;
        ITransFileController iTransFileController = (ITransFileController) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITransFileController.class, "");
        this.transFileController = iTransFileController;
        if (iTransFileController != null) {
            iTransFileController.addHandle(this.pttTransProcessorHandler);
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mCommandId = 68;
        if (sliceData.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            bArr = new byte[]{0};
        } else {
            bArr = sliceData;
        }
        transferRequest.toSendData = bArr;
        transferRequest.resIdStr = this.sliceUuid;
        transferRequest.mUniseq = (long) (Math.random() * 1000000);
        transferRequest.mMd5 = "";
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_PTT_SILK_SLICE_TO_TEXT;
        transferRequest.mRichTag = StatisticCollector.PTT_SLICE_TO_TEXT;
        transferRequest.mLocalPath = path;
        transferRequest.pcmForVadPath = pcmForVadPath;
        transferRequest.pcmForVadNum = 1;
        transferRequest.pcmForVadPos = isFirstOrLast(isFirst, isLast);
        transferRequest.chatType = 3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "vadHelper startrecord sendrequest buffer=", Integer.valueOf(sliceData.length), " sliceUuid=", this.sliceUuid, "  transReq.pcmForVadPos=", Integer.valueOf(transferRequest.pcmForVadPos), " " + transferRequest.hashCode());
        }
        ITransFileController iTransFileController2 = this.transFileController;
        if (iTransFileController2 != null) {
            iTransFileController2.transferAsync(transferRequest);
        }
        this.hasSttRequest = true;
        this.sendIds.add(Long.valueOf(transferRequest.mUniseq));
    }

    @Override // com.tencent.mobileqq.ptt.api.IVoiceToTextSttApi
    public void cancelAllRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[cancelAllRequest] sendIds lens=" + this.sendIds.size());
        }
        Iterator<T> it = this.sendIds.iterator();
        while (it.hasNext()) {
            cancelVoiceTextTask(((Number) it.next()).longValue());
        }
    }

    @Override // com.tencent.mobileqq.ptt.api.IVoiceToTextSttApi
    public void onRecorderEnd() {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "[onRecorderEnd] ");
        cancelSttTask();
        doSttTask(true);
        this.newDataSize = 0;
        if (!this.hasSttRequest && (aVar = this.listenerRef.get()) != null) {
            aVar.d();
        }
        this.sendIds.clear();
    }

    @Override // com.tencent.mobileqq.ptt.api.IVoiceToTextSttApi
    public void onRecorderStart(@NotNull String pcmForVadPath, @NotNull String audioFilePath, @Nullable a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, pcmForVadPath, audioFilePath, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(pcmForVadPath, "pcmForVadPath");
        Intrinsics.checkNotNullParameter(audioFilePath, "audioFilePath");
        QLog.i(TAG, 1, "[onRecorderStart] ");
        this.mPcmForFilePath = pcmForVadPath;
        this.mAudioFilePath = audioFilePath;
        this.sliceUuid = this.currentSession;
        this.startPcmFileOffset = 0L;
        this.isFirstPage = true;
        this.hasSttRequest = false;
        this.sendIds.clear();
        this.listenerRef = new WeakReference<>(listener);
        BaseTimer baseTimer = new BaseTimer();
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.ptt.api.impl.VoiceToTextSttApiImpl$onRecorderStart$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VoiceToTextSttApiImpl.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VoiceToTextSttApiImpl.this.doSttTask(false);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 0L, getSttIntervalMillis());
        this.sttTimer = baseTimer;
    }

    @Override // com.tencent.mobileqq.ptt.api.IVoiceToTextSttApi
    public void setRecorderSessionId(@NotNull String sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sessionId);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.currentSession = sessionId;
        this.currentConvertIndex = 0;
        this.isFirstPage = true;
        this.newDataSize = 0;
        this.pttTransProcessorHandler.addFilterDistinct(PttSilkSliceUploadProcessor.class);
        QLog.i(TAG, 1, "vadHelper setRecorderSessionId currentSession=" + this.currentSession);
    }
}
