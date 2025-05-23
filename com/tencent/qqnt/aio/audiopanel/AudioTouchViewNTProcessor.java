package com.tencent.qqnt.aio.audiopanel;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bq;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOPttControlApi;
import com.tencent.qqnt.aio.audiopanel.c;
import com.tencent.qqnt.aio.audiopanel.e;
import com.tencent.qqnt.aio.tts.TtsMsgIntent;
import com.tencent.qqnt.audio.INTFullScreenAudioApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.ttpic.videoshelf.data.Constants;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.light.LightConstants;

@Metadata(d1 = {"\u0000\u00d3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001x\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u00023?B\u0017\u0012\u0006\u0010E\u001a\u00020\u001a\u0012\u0006\u0010H\u001a\u00020\u0018\u00a2\u0006\u0004\b{\u0010|J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"H\u0016J\u0006\u0010%\u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\b\u0010&\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0011H\u0016J\n\u00100\u001a\u0004\u0018\u00010\u0004H\u0016J \u00103\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016J:\u0010;\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u0002052\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`92\u0006\u0010,\u001a\u00020+H\u0016J0\u0010<\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u0002052\f\u0010:\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010,\u001a\u00020+H\u0016J\u0012\u0010>\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010?\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010A\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u000bH\u0016J\u0012\u0010B\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010C\u001a\u00020\u000bR\u0014\u0010E\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010DR\u0014\u0010H\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010R\u001a\b\u0018\u00010OR\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010QR\u001b\u0010X\u001a\u00020S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR$\u0010^\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010fR\u0016\u0010i\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010kR\u0018\u0010m\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010YR\u0016\u0010o\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010\u0015R\u0018\u0010r\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010qR\u001e\u0010v\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u001e\u0010w\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010uR\u0014\u0010z\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010y\u00a8\u0006}"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor;", "Landroid/os/Handler$Callback;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/qqnt/audio/n;", "", "peerUin", "Lcom/tencent/qqnt/audio/m;", "u", "", "N", "t", "", "state", "M", "w", UserInfo.SEX_FEMALE, "D", "", "H", "G", "isCalling", "I", "Lcom/tencent/mobileqq/app/QQAppInterface;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/api/runtime/a;", HippyTKDListViewAdapter.X, "Landroid/view/View;", "B", "Lmqq/app/AppActivity;", "y", "Landroid/os/Message;", "msg", "handleMessage", "v", "Landroid/view/MotionEvent;", "event", "onTouch", "E", "isRecording", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/ptt/d$a;", "listener", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "recorderParam", "i", "sync", ExifInterface.LATITUDE_SOUTH, "j", Constants.AUDIO_FILE_PATH, "cancelSource", "a", "path", "", "pttDuration", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "O", "P", "text", "c", "b", "volumeState", "d", "f", "K", "Landroid/view/View;", "touchView", "e", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/audio/m;", "audioPopupWindow", "Landroid/os/Handler;", tl.h.F, "Landroid/os/Handler;", "handler", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "Landroid/os/PowerManager$WakeLock;", "screenWakeLock", "Lcom/tencent/util/MqqWeakReferenceHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/util/MqqWeakReferenceHandler;", "uiHandler", "Ljava/lang/String;", "getLocalAudioPath", "()Ljava/lang/String;", "setLocalAudioPath", "(Ljava/lang/String;)V", "localAudioPath", "Lcom/tencent/mobileqq/ptt/d;", "Lcom/tencent/mobileqq/ptt/d;", "audioRecord", "Lcom/tencent/qqnt/aio/audiopanel/aa;", "Lcom/tencent/qqnt/aio/audiopanel/aa;", "recordCallback", "Lcom/tencent/mobileqq/widget/bq;", "Lcom/tencent/mobileqq/widget/bq;", "recordToastDialog", "Z", "touchValid", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "startRecordRunnable", "pcmForVadPath", "J", "pttMaxTime", "Lcom/tencent/qqnt/aio/audiopanel/c;", "Lcom/tencent/qqnt/aio/audiopanel/c;", "mPhoneStatusHelper", "Ljava/lang/ref/WeakReference;", "L", "Ljava/lang/ref/WeakReference;", "mAioContextRef", "mTouchViewRef", "com/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor$c", "Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor$c;", "mRecordChangeListener", "<init>", "(Landroid/view/View;Lcom/tencent/aio/api/runtime/a;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AudioTouchViewNTProcessor implements Handler.Callback, View.OnTouchListener, com.tencent.qqnt.audio.n {
    private static final b P = new b(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String localAudioPath;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.ptt.d audioRecord;

    /* renamed from: E, reason: from kotlin metadata */
    private aa recordCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private bq recordToastDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean touchValid;

    /* renamed from: H, reason: from kotlin metadata */
    private final Runnable startRecordRunnable;

    /* renamed from: I, reason: from kotlin metadata */
    private String pcmForVadPath;

    /* renamed from: J, reason: from kotlin metadata */
    private int pttMaxTime;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.qqnt.aio.audiopanel.c mPhoneStatusHelper;

    /* renamed from: L, reason: from kotlin metadata */
    private WeakReference<com.tencent.aio.api.runtime.a> mAioContextRef;

    /* renamed from: M, reason: from kotlin metadata */
    private WeakReference<View> mTouchViewRef;

    /* renamed from: N, reason: from kotlin metadata */
    private final c mRecordChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View touchView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.audio.m audioPopupWindow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PowerManager.WakeLock screenWakeLock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiHandler;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor$a;", "Lcom/tencent/qqnt/aio/audiopanel/c$b;", "", "isCalling", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor;", "Ljava/lang/ref/WeakReference;", "getWeakReference", "()Ljava/lang/ref/WeakReference;", "setWeakReference", "(Ljava/lang/ref/WeakReference;)V", "weakReference", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "<init>", "(Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements c.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private WeakReference<AudioTouchViewNTProcessor> weakReference;

        public a(AudioTouchViewNTProcessor panel) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            this.weakReference = new WeakReference<>(panel);
        }

        @Override // com.tencent.qqnt.aio.audiopanel.c.b
        public void a(boolean isCalling) {
            AudioTouchViewNTProcessor audioTouchViewNTProcessor = this.weakReference.get();
            if (audioTouchViewNTProcessor != null) {
                audioTouchViewNTProcessor.I(isCalling);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor$b;", "", "", "CONFIG_KEY", "Ljava/lang/String;", "", "FULL_PANEL_PTT_RECORD_DELAY_TIME", "I", "", "PRESS_BETWEEN_SPEAK_TIME", "J", "TAG", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor$c", "Lcom/tencent/qqnt/aio/audiopanel/ac;", "", "b", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ac {
        c() {
        }

        @Override // com.tencent.qqnt.aio.audiopanel.ac
        public void a() {
            AudioTouchViewNTProcessor.this.D();
        }

        @Override // com.tencent.qqnt.aio.audiopanel.ac
        public void b() {
            AudioTouchViewNTProcessor.this.F();
        }
    }

    public AudioTouchViewNTProcessor(View touchView, com.tencent.aio.api.runtime.a aioContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(touchView, "touchView");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.touchView = touchView;
        this.aioContext = aioContext;
        this.handler = new Handler();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MqqWeakReferenceHandler>() { // from class: com.tencent.qqnt.aio.audiopanel.AudioTouchViewNTProcessor$uiHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MqqWeakReferenceHandler invoke() {
                return new MqqWeakReferenceHandler(Looper.getMainLooper(), AudioTouchViewNTProcessor.this);
            }
        });
        this.uiHandler = lazy;
        this.startRecordRunnable = new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.f
            @Override // java.lang.Runnable
            public final void run() {
                AudioTouchViewNTProcessor.Q(AudioTouchViewNTProcessor.this);
            }
        };
        c cVar = new c();
        this.mRecordChangeListener = cVar;
        this.recordCallback = new aa(cVar);
        this.mTouchViewRef = new WeakReference<>(touchView);
        this.mAioContextRef = new WeakReference<>(aioContext);
        View B = B();
        if (B != null) {
            B.setOnTouchListener(this);
        }
        G();
    }

    private final View B() {
        WeakReference<View> weakReference = this.mTouchViewRef;
        if (weakReference == null) {
            return null;
        }
        View view = weakReference != null ? weakReference.get() : null;
        if (view instanceof View) {
            return view;
        }
        return null;
    }

    private final MqqWeakReferenceHandler C() {
        return (MqqWeakReferenceHandler) this.uiHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        String str;
        com.tencent.mvi.base.route.j e16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        if (H()) {
            QLog.d("AudioTouchViewNTProcessor", 1, "handleClearVoiceInputStatus");
            com.tencent.aio.api.runtime.a x16 = x();
            if (x16 == null || (g16 = x16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
                str = "";
            }
            com.tencent.aio.api.runtime.a x17 = x();
            if (x17 == null || (e16 = x17.e()) == null) {
                return;
            }
            e16.h(new InputEvent.ClearInputStatusEvent(2, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        String str;
        com.tencent.mvi.base.route.j e16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        if (H()) {
            QLog.d("AudioTouchViewNTProcessor", 1, "handleSendVoiceInputStatus");
            com.tencent.aio.api.runtime.a x16 = x();
            if (x16 == null || (g16 = x16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
                str = "";
            }
            com.tencent.aio.api.runtime.a x17 = x();
            if (x17 == null || (e16 = x17.e()) == null) {
                return;
            }
            e16.h(new InputEvent.SendVoiceInputStatusEvent(str));
        }
    }

    private final void G() {
        com.tencent.qqnt.aio.audiopanel.c cVar = new com.tencent.qqnt.aio.audiopanel.c();
        this.mPhoneStatusHelper = cVar;
        cVar.g(new a(this));
    }

    private final boolean H() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a x16 = x();
        return (x16 == null || (g16 = x16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || c16.e() != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(boolean isCalling) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "AudioTouchViewNTProcessor onCallStateChanged isCalling = " + isCalling);
        }
        if (isCalling && isRecording()) {
            S(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AudioTouchViewNTProcessor this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M(i3);
    }

    private final void M(int state) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioTouchViewNTProcessor", 2, "recorderVolumeChange " + state);
        }
        if (state != 0) {
            if (state == 1) {
                com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
                if ((dVar == null || dVar.isRecording()) ? false : true) {
                    QLog.i("AudioTouchViewNTProcessor", 1, "volueme state err" + Build.MANUFACTURER + DeviceInfoMonitor.getModel());
                    return;
                }
                bq bqVar = this.recordToastDialog;
                if (bqVar != null && bqVar.isShowing()) {
                    return;
                }
                bq bqVar2 = new bq(y());
                this.recordToastDialog = bqVar2;
                AppActivity y16 = y();
                bqVar2.N(y16 != null ? y16.getString(R.string.f8u) : null);
                bq bqVar3 = this.recordToastDialog;
                if (bqVar3 != null) {
                    bqVar3.show();
                    return;
                }
                return;
            }
            if (state != 2) {
                return;
            }
        }
        bq bqVar4 = this.recordToastDialog;
        if (bqVar4 != null) {
            Intrinsics.checkNotNull(bqVar4);
            if (bqVar4.isShowing()) {
                bq bqVar5 = this.recordToastDialog;
                Intrinsics.checkNotNull(bqVar5);
                if (bqVar5.getWindow() != null) {
                    bq bqVar6 = this.recordToastDialog;
                    if (bqVar6 != null) {
                        bqVar6.dismiss();
                    }
                    this.recordToastDialog = null;
                }
            }
        }
    }

    private final void N() {
        PowerManager.WakeLock wakeLock;
        if (this.screenWakeLock == null) {
            AppActivity y16 = y();
            Object systemService = y16 != null ? y16.getSystemService("power") : null;
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            this.screenWakeLock = ((PowerManager) systemService).newWakeLock(536870918, "MobileQQ:AudioTouchViewNTProcessor");
        }
        PowerManager.WakeLock wakeLock2 = this.screenWakeLock;
        boolean z16 = false;
        if (wakeLock2 != null && !wakeLock2.isHeld()) {
            z16 = true;
        }
        if (z16 && (wakeLock = this.screenWakeLock) != null) {
            wakeLock.acquire(1000L);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioTouchViewNTProcessor", 2, "remainScreenOn");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final AudioTouchViewNTProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.touchValid = true;
        e.e(R.raw.f169416n, new e.a() { // from class: com.tencent.qqnt.aio.audiopanel.g
            @Override // com.tencent.qqnt.aio.audiopanel.e.a
            public final void onStart() {
                AudioTouchViewNTProcessor.R(AudioTouchViewNTProcessor.this);
            }
        });
        QQAppInterface z16 = this$0.z();
        if (z16 != null) {
            ReportController.y(z16, "0X800BFD6");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AudioTouchViewNTProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.audio.m mVar = this$0.audioPopupWindow;
        if (mVar != null) {
            mVar.show();
        }
    }

    private final void t() {
        PowerManager.WakeLock wakeLock = this.screenWakeLock;
        boolean z16 = false;
        if (wakeLock != null && wakeLock.isHeld()) {
            z16 = true;
        }
        if (z16) {
            PowerManager.WakeLock wakeLock2 = this.screenWakeLock;
            if (wakeLock2 != null) {
                wakeLock2.release();
            }
            this.screenWakeLock = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioTouchViewNTProcessor", 2, "cancelRemainScreenOn");
        }
    }

    private final com.tencent.qqnt.audio.m u(String peerUin) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.qqnt.audio.o oVar = new com.tencent.qqnt.audio.o();
        oVar.f352544a = peerUin;
        com.tencent.aio.api.runtime.a x16 = x();
        oVar.f352545b = com.tencent.nt.adapter.session.c.c((x16 == null || (g16 = x16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) ? 0 : c16.e());
        if (y() != null) {
            AppActivity y16 = y();
            Intrinsics.checkNotNull(y16);
            oVar.f352546c = y16;
        }
        QQAppInterface z16 = z();
        if (z16 == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            z16 = (QQAppInterface) peekAppRuntime;
        }
        oVar.f352547d = z16;
        if (B() != null) {
            oVar.f352548e = B();
        }
        oVar.f352549f = this;
        com.tencent.qqnt.audio.m createAudioNTPopupWindow = ((INTFullScreenAudioApi) QRoute.api(INTFullScreenAudioApi.class)).createAudioNTPopupWindow(oVar);
        Intrinsics.checkNotNullExpressionValue(createAudioNTPopupWindow, "api(INTFullScreenAudioAp\u2026dow(fullScreenAudioParam)");
        return createAudioNTPopupWindow;
    }

    private final void w() {
        bq bqVar = this.recordToastDialog;
        if (bqVar != null) {
            Intrinsics.checkNotNull(bqVar);
            if (bqVar.isShowing()) {
                bq bqVar2 = this.recordToastDialog;
                Intrinsics.checkNotNull(bqVar2);
                if (bqVar2.getWindow() != null) {
                    bq bqVar3 = this.recordToastDialog;
                    Intrinsics.checkNotNull(bqVar3);
                    bqVar3.dismiss();
                    this.recordToastDialog = null;
                }
            }
        }
    }

    private final com.tencent.aio.api.runtime.a x() {
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAioContextRef;
        if (weakReference == null) {
            return null;
        }
        com.tencent.aio.api.runtime.a aVar = weakReference != null ? weakReference.get() : null;
        if (aVar instanceof com.tencent.aio.api.runtime.a) {
            return aVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppActivity y() {
        return QBaseActivity.sTopActivity;
    }

    private final QQAppInterface z() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return (QQAppInterface) peekAppRuntime;
    }

    /* renamed from: A, reason: from getter */
    public String getLocalAudioPath() {
        return this.localAudioPath;
    }

    public final void E() {
        if (isRecording()) {
            S(true);
        }
    }

    public final int K() {
        int c16;
        QQAppInterface z16 = z();
        if (z16 == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            z16 = (QQAppInterface) peekAppRuntime;
        }
        int c17 = com.tencent.mobileqq.activity.aio.item.n.c(z16, "Normal_MaxPtt") * 1000;
        int privilegeFlags = VasUtil.getSignedService(z16).getVipStatus().getPrivilegeFlags(null);
        if ((privilegeFlags & 4) != 0) {
            c16 = com.tencent.mobileqq.activity.aio.item.n.c(z16, "SVIP_MaxPtt");
        } else {
            if ((privilegeFlags & 2) != 0) {
                c16 = com.tencent.mobileqq.activity.aio.item.n.c(z16, "VIP_MaxPtt");
            }
            this.pttMaxTime = c17;
            int i3 = c17 + 500;
            C().sendEmptyMessageDelayed(16711687, i3);
            return i3 + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
        }
        c17 = c16 * 1000;
        this.pttMaxTime = c17;
        int i36 = c17 + 500;
        C().sendEmptyMessageDelayed(16711687, i36);
        return i36 + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
    }

    @Override // com.tencent.qqnt.audio.n
    public void a(String audioFilePath, int cancelSource, RecordParams.RecorderParam recorderParam) {
        Intrinsics.checkNotNullParameter(audioFilePath, "audioFilePath");
        Intrinsics.checkNotNullParameter(recorderParam, "recorderParam");
        C().removeMessages(16711687);
        S(false);
    }

    @Override // com.tencent.qqnt.audio.n
    public void b(String path) {
        C().post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.i
            @Override // java.lang.Runnable
            public final void run() {
                AudioTouchViewNTProcessor.J();
            }
        });
        e.f(R.raw.f169416n, path);
        K();
    }

    @Override // com.tencent.qqnt.audio.n
    public void d(final int volumeState) {
        C().post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.h
            @Override // java.lang.Runnable
            public final void run() {
                AudioTouchViewNTProcessor.L(AudioTouchViewNTProcessor.this, volumeState);
            }
        });
    }

    @Override // com.tencent.qqnt.audio.n
    public /* bridge */ /* synthetic */ void e(String str, Float f16, ArrayList arrayList, RecordParams.RecorderParam recorderParam) {
        O(str, f16.floatValue(), arrayList, recorderParam);
    }

    @Override // com.tencent.qqnt.audio.n
    public void f(String path) {
        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.audiopanel.AudioTouchViewNTProcessor$recorderTimeTooShort$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppActivity y16;
                y16 = AudioTouchViewNTProcessor.this.y();
                QQToast.makeText(y16, R.string.f170312ly, 1).show();
            }
        });
        if (path != null) {
            new File(path).delete();
        }
    }

    @Override // com.tencent.qqnt.audio.n
    public /* bridge */ /* synthetic */ void g(Boolean bool) {
        S(bool.booleanValue());
    }

    @Override // com.tencent.qqnt.audio.n
    public /* bridge */ /* synthetic */ void h(String str, Float f16, ArrayList arrayList, RecordParams.RecorderParam recorderParam) {
        P(str, f16.floatValue(), arrayList, recorderParam);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what != 16711687) {
            return false;
        }
        S(false);
        com.tencent.qqnt.audio.m mVar = this.audioPopupWindow;
        if (mVar != null) {
            mVar.d(this.pttMaxTime);
        }
        return true;
    }

    @Override // com.tencent.qqnt.audio.n
    public void i(d.a listener, RecordParams.RecorderParam recorderParam) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(recorderParam, "recorderParam");
        QQAppInterface z16 = z();
        if (z16 == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            z16 = (QQAppInterface) peekAppRuntime;
        }
        this.localAudioPath = TransFileUtil.getTransferFilePath(z16.getCurrentAccountUin(), null, 2, null, false);
        String localFilePath = MessageForPtt.getLocalFilePath(recorderParam.f307257f, getLocalAudioPath());
        if (!Intrinsics.areEqual(getLocalAudioPath(), localFilePath)) {
            String localAudioPath = getLocalAudioPath();
            Intrinsics.checkNotNull(localAudioPath);
            new File(localAudioPath).deleteOnExit();
            this.localAudioPath = localFilePath;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioTouchViewNTProcessor", 2, "path: " + getLocalAudioPath());
        }
        C().removeMessages(16711687);
        N();
        e.h();
        if (QLog.isColorLevel()) {
            QLog.d("AudioTouchViewNTProcessor", 2, "startRecord() is called");
        }
        if (this.audioRecord == null) {
            this.audioRecord = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(y());
        }
        String vFSPath = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "ppt/", true);
        File file = new File(vFSPath);
        if (!file.exists()) {
            file.mkdir();
        }
        this.pcmForVadPath = vFSPath + "pcmforvad.pcm";
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        if (dVar != null) {
            dVar.e(recorderParam);
        }
        com.tencent.mobileqq.ptt.d dVar2 = this.audioRecord;
        if (dVar2 != null) {
            String str = this.pcmForVadPath;
            Intrinsics.checkNotNull(str);
            dVar2.d(str);
        }
        aa aaVar = this.recordCallback;
        Intrinsics.checkNotNull(aaVar);
        aaVar.a(listener);
        com.tencent.mobileqq.ptt.d dVar3 = this.audioRecord;
        if (dVar3 != null) {
            aa aaVar2 = this.recordCallback;
            Intrinsics.checkNotNull(aaVar2);
            dVar3.b(aaVar2);
        }
        com.tencent.mobileqq.ptt.d dVar4 = this.audioRecord;
        if (dVar4 != null) {
            String localAudioPath2 = getLocalAudioPath();
            Intrinsics.checkNotNull(localAudioPath2);
            dVar4.start(localAudioPath2);
        }
        QLog.d("AudioTouchViewNTProcessor", 2, "QQRecorder start time is:" + System.currentTimeMillis());
    }

    @Override // com.tencent.qqnt.audio.n
    public boolean isRecording() {
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        return dVar != null && dVar.isRecording();
    }

    @Override // com.tencent.qqnt.audio.n
    /* renamed from: j, reason: from getter */
    public String getPcmForVadPath() {
        return this.pcmForVadPath;
    }

    @Override // com.tencent.qqnt.audio.n
    public boolean n() {
        QQAppInterface z16 = z();
        if (z16 != null) {
            return z16.isVideoChatting();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r5 != 3) goto L66;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View v3, MotionEvent event) {
        Unit unit;
        String str;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        AIOParam g17;
        AIOSession r17;
        AIOContact c17;
        AIOParam g18;
        AIOSession r18;
        AIOContact c18;
        ViewParent parent;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    com.tencent.qqnt.audio.m mVar = this.audioPopupWindow;
                    if (mVar != null) {
                        mVar.e(event);
                    }
                }
            }
            if (!this.touchValid) {
                this.handler.removeCallbacks(this.startRecordRunnable);
                return true;
            }
            this.touchValid = false;
            com.tencent.qqnt.audio.m mVar2 = this.audioPopupWindow;
            if (mVar2 != null) {
                mVar2.a();
            }
        } else {
            com.tencent.qqnt.audio.record.util.b bVar = com.tencent.qqnt.audio.record.util.b.f352553a;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            bVar.c(context, true);
            ((IAIOPttControlApi) QRoute.api(IAIOPttControlApi.class)).pauseCurrentPttPlay();
            this.aioContext.e().h(new TtsMsgIntent.StopAllTtsMsgIntent("AudioTouchViewNTProcessor"));
            View B = B();
            if (B != null && (parent = B.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            com.tencent.qqnt.audio.m mVar3 = this.audioPopupWindow;
            String str2 = null;
            if (mVar3 != null) {
                mVar3.c();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                com.tencent.aio.api.runtime.a x16 = x();
                if (x16 != null && (g18 = x16.g()) != null && (r18 = g18.r()) != null && (c18 = r18.c()) != null && c18.e() == 2) {
                    z16 = true;
                }
                if (z16) {
                    com.tencent.aio.api.runtime.a x17 = x();
                    if (x17 != null && (g17 = x17.g()) != null && (r17 = g17.r()) != null && (c17 = r17.c()) != null) {
                        str2 = c17.j();
                    }
                } else {
                    com.tencent.aio.api.runtime.a x18 = x();
                    if (x18 == null || (g16 = x18.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
                        str = "";
                    }
                    str2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str);
                }
                QLog.e("AudioTouchViewNTProcessor", 1, "onTouch ACTION_DOWN uin=" + MobileQQ.getShortUinStr(str2));
                if (!TextUtils.isEmpty(str2)) {
                    Intrinsics.checkNotNull(str2);
                    this.audioPopupWindow = u(str2);
                }
            }
            this.handler.postDelayed(this.startRecordRunnable, 150L);
        }
        return true;
    }

    public final void v() {
        com.tencent.qqnt.audio.m mVar = this.audioPopupWindow;
        if (mVar != null) {
            mVar.destroy();
        }
        this.audioPopupWindow = null;
        com.tencent.qqnt.aio.audiopanel.c cVar = this.mPhoneStatusHelper;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J() {
        com.tencent.mobileqq.activity.aio.l.f179531g = true;
    }

    public void O(String path, float pttDuration, ArrayList<Byte> audioData, RecordParams.RecorderParam recorderParam) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        Intrinsics.checkNotNullParameter(recorderParam, "recorderParam");
        if (path == null || path.length() == 0) {
            return;
        }
        AudioUtil.n(R.raw.f169415m, false);
        com.tencent.aio.api.runtime.a x16 = x();
        if (x16 == null || (e16 = x16.e()) == null) {
            return;
        }
        e16.h(new AIOMsgSendEvent.PttSendEvent(path, pttDuration, recorderParam.f307257f, audioData, false, false, 0, null, 240, null));
    }

    public void P(String path, float pttDuration, ArrayList<Byte> audioData, RecordParams.RecorderParam recorderParam) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        Intrinsics.checkNotNullParameter(recorderParam, "recorderParam");
        if (path == null || path.length() == 0) {
            return;
        }
        AudioUtil.n(R.raw.f169415m, false);
        com.tencent.aio.api.runtime.a x16 = x();
        if (x16 == null || (e16 = x16.e()) == null) {
            return;
        }
        e16.h(new AIOMsgSendEvent.PttSendEvent(path, pttDuration, recorderParam.f307257f, audioData, false, false, 0, null, 240, null));
    }

    @Override // com.tencent.qqnt.audio.n
    public void c(String text) {
        com.tencent.aio.api.runtime.a x16;
        com.tencent.mvi.base.route.j e16;
        if ((text == null || text.length() == 0) || (x16 = x()) == null || (e16 = x16.e()) == null) {
            return;
        }
        e16.h(new AIOMsgSendEvent.TextSendEvent(text));
    }

    public void S(boolean sync) {
        boolean isSwitchOn = sync ? ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_touch_view_nt_processor_8985_116006063", false) : sync;
        w();
        t();
        QLog.d("AudioTouchViewNTProcessor", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
        if (QLog.isColorLevel()) {
            QLog.d("AudioTouchViewNTProcessor", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis() + "\uff0csync is:" + sync + "\uff0cneedSync is:" + isSwitchOn);
        }
        com.tencent.mobileqq.ptt.d dVar = this.audioRecord;
        if (dVar != null) {
            dVar.stop();
        }
        com.tencent.qqnt.audio.m mVar = this.audioPopupWindow;
        if (mVar != null && mVar.b()) {
            mVar.destroy();
        }
        com.tencent.qqnt.audio.record.util.b bVar = com.tencent.qqnt.audio.record.util.b.f352553a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        bVar.c(context, false);
    }
}
