package com.tencent.mobileqq.zootopia.qav;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.lua.ai;
import com.tencent.mobileqq.zootopia.qav.MultiVoiceChatController;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.manager.PushManager;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0002fl\u0018\u0000 \"2\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\bp\u0010qJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0002J\u001e\u0010!\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001cJ\u0010\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002J\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010'j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`(J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\u0006J\u0010\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u00108\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\u0017\u0010;\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R\"\u0010B\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010F\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\"\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010H\u001a\u0004\bO\u0010J\"\u0004\bP\u0010LR\"\u0010X\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010^\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010\u0015\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R0\u0010e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0b0'j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0b`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010dR\u0014\u0010h\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010gR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010n\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/MultiVoiceChatController;", "", "", "delay", "", "reason", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "current", ExifInterface.LATITUDE_SOUTH, "", "D", "route", QCircleLpReportDc010001.KEY_SUBTYPE, "G", "B", "L", "Landroid/content/Intent;", "intent", "J", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "M", "", "openId", "roomId", "w", "sign", "k", "o", "enable", "O", "P", "v", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "u", BdhLogUtil.LogTag.Tag_Req, UserInfo.SEX_FEMALE, "H", "Ljava/lang/Runnable;", "runnable", "N", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getMHasInit", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "mHasInit", "b", "r", "mHasEnterRoom", "c", "E", "isEntering", "d", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "setMEnableLocalAudio", "(Z)V", "mEnableLocalAudio", "e", "getMFirstTimeNotNotify", "setMFirstTimeNotNotify", "mFirstTimeNotNotify", "f", "I", "getMAudioRoute", "()I", "setMAudioRoute", "(I)V", "mAudioRoute", "g", "getMAudioSubRoute", "setMAudioSubRoute", "mAudioSubRoute", tl.h.F, "Ljava/lang/String;", "t", "()Ljava/lang/String;", "setMSelfOpenId", "(Ljava/lang/String;)V", "mSelfOpenId", "i", ReportConstant.COSTREPORT_PREFIX, "()J", "setMRoomId", "(J)V", "mRoomId", "j", "Ljava/lang/Runnable;", "mGetSignTimeoutRunnable", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zootopia/qav/f;", "Ljava/util/ArrayList;", "mEventCallbacks", "com/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$d", "Lcom/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$d;", "mQavMultiObserver", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mReceiver", "com/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$b", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$b;", "accountChangedCallback", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MultiVoiceChatController {

    /* renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: p */
    private static final Lazy<MultiVoiceChatController> f328960p;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean mEnableLocalAudio;

    /* renamed from: f, reason: from kotlin metadata */
    private int mAudioRoute;

    /* renamed from: g, reason: from kotlin metadata */
    private int mAudioSubRoute;

    /* renamed from: j, reason: from kotlin metadata */
    private Runnable mGetSignTimeoutRunnable;

    /* renamed from: a, reason: from kotlin metadata */
    private final AtomicBoolean mHasInit = new AtomicBoolean(false);

    /* renamed from: b, reason: from kotlin metadata */
    private final AtomicBoolean mHasEnterRoom = new AtomicBoolean(false);

    /* renamed from: c, reason: from kotlin metadata */
    private final AtomicBoolean isEntering = new AtomicBoolean(false);

    /* renamed from: e, reason: from kotlin metadata */
    private boolean mFirstTimeNotNotify = true;

    /* renamed from: h */
    private String mSelfOpenId = "";

    /* renamed from: i, reason: from kotlin metadata */
    private long mRoomId = -1;

    /* renamed from: k, reason: from kotlin metadata */
    private final ArrayList<WeakReference<f>> mEventCallbacks = new ArrayList<>();

    /* renamed from: l, reason: from kotlin metadata */
    private final d mQavMultiObserver = new d();

    /* renamed from: m */
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.zootopia.qav.MultiVoiceChatController$mReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (Intrinsics.areEqual("android.intent.action.HEADSET_PLUG", action) || Intrinsics.areEqual("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED", action) || Intrinsics.areEqual("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED", action) || Intrinsics.areEqual("android.bluetooth.adapter.action.STATE_CHANGED", action)) {
                MultiVoiceChatController.this.J(intent);
            }
        }
    };

    /* renamed from: n */
    private final b accountChangedCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$a;", "", "Lcom/tencent/mobileqq/zootopia/qav/MultiVoiceChatController;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/qav/MultiVoiceChatController;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "ERROR_HAS_ENTER_ROOM", "I", "ERROR_NOT_INIT", "ERROR_OPERATOR_NULL", "ERROR_REQUEST_FOCUS_FAILED", "ERROR_TYPE_ERROR", "ERROR_WWISE_NOT_INIT", "GET_SIGN_SUCCESS", "", "TAG", "Ljava/lang/String;", "", "TIME_OUT_MS", "J", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.qav.MultiVoiceChatController$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiVoiceChatController a() {
            return (MultiVoiceChatController) MultiVoiceChatController.f328960p.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$b", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IAccountCallback {
        b() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
            if (QLog.isColorLevel()) {
                QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onAccountChangeFailed");
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            if (QLog.isColorLevel()) {
                QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onAccountChanged");
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
            if (QLog.isColorLevel()) {
                QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onLogout");
            }
            MultiVoiceChatController.this.o(2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$c", "Lcom/tencent/qav/channel/g;", "", "type", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.qav.channel.g {
        c() {
        }

        @Override // com.tencent.qav.channel.g
        public boolean a(int type) {
            return true;
        }

        @Override // com.tencent.qav.channel.g
        public boolean b(int type) {
            return false;
        }
    }

    static {
        Lazy<MultiVoiceChatController> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<MultiVoiceChatController>() { // from class: com.tencent.mobileqq.zootopia.qav.MultiVoiceChatController$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MultiVoiceChatController invoke() {
                return new MultiVoiceChatController();
            }
        });
        f328960p = lazy;
    }

    private final void A(Intent intent) {
        int intExtra = intent.getIntExtra("state", -1);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onReceive ACTION_HEADSET_PLUG state=%s", Arrays.copyOf(new Object[]{Integer.valueOf(intExtra)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, format);
        if (intExtra == 0) {
            S(0);
        } else {
            if (intExtra != 1) {
                return;
            }
            R(0, 3);
        }
    }

    public final boolean B() {
        boolean z16 = MobileQQ.sMobileQQ.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0;
        if (QLog.isColorLevel()) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "hasRecordPermission: " + z16);
        }
        return z16;
    }

    private final boolean D() {
        int i3;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            i3 = defaultAdapter.getProfileConnectionState(2);
            int profileConnectionState = defaultAdapter.getProfileConnectionState(1);
            int profileConnectionState2 = defaultAdapter.getProfileConnectionState(3);
            if (i3 != 2) {
                if (profileConnectionState == 2) {
                    i3 = profileConnectionState;
                } else if (profileConnectionState2 == 2) {
                    i3 = profileConnectionState2;
                }
            }
            Object systemService = BaseApplication.getContext().getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            return i3 != -1 || ((AudioManager) systemService).isBluetoothA2dpOn();
        }
        i3 = -1;
        Object systemService2 = BaseApplication.getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        if (i3 != -1) {
            return true;
        }
    }

    private final void G(int route, int r56) {
        Iterator<WeakReference<f>> it = this.mEventCallbacks.iterator();
        while (it.hasNext()) {
            WeakReference<f> next = it.next();
            if (next.get() != null) {
                f fVar = next.get();
                Intrinsics.checkNotNull(fVar);
                fVar.a(route, r56);
            }
        }
    }

    public static final void I(MultiVoiceChatController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ai.INSTANCE.h(false, -2, "\u7b7e\u540d\u83b7\u53d6\u8d85\u65f6");
        this$0.o(3);
    }

    public final void J(final Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.a
            @Override // java.lang.Runnable
            public final void run() {
                MultiVoiceChatController.K(intent, this, action);
            }
        }, 16, null, true);
    }

    public static final void K(Intent intent, MultiVoiceChatController this$0, String action) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        if (Intrinsics.areEqual("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED", intent.getAction())) {
            this$0.x(intent);
            return;
        }
        if (Intrinsics.areEqual("android.intent.action.HEADSET_PLUG", action)) {
            this$0.A(intent);
        } else if (Intrinsics.areEqual("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED", action)) {
            this$0.z(intent);
        } else if (Intrinsics.areEqual("android.bluetooth.adapter.action.STATE_CHANGED", action)) {
            this$0.y(intent);
        }
    }

    public final void L() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        BaseApplication.getContext().registerReceiver(this.mReceiver, intentFilter);
    }

    public final void Q() {
        int i3;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        int i16 = 0;
        String format = String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(F()), Boolean.valueOf(D())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, format);
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            if (F()) {
                c16.setAudioRoute(0);
                c16.setAudioRoute(0);
                i3 = 3;
            } else {
                if (D()) {
                    c16.setAudioRoute(2);
                    c16.setAudioRoute(2);
                    i16 = 2;
                } else {
                    c16.setAudioRoute(1);
                    c16.setAudioRoute(1);
                    i16 = 1;
                }
                i3 = -1;
            }
            QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "switchAudioRoute audioRoute: " + i16 + " sunType: " + i3);
            this.mAudioRoute = i16;
            this.mAudioSubRoute = i3;
            G(c16.getAudioRoute(), i3);
        }
    }

    private final void S(int i3) {
        boolean F = F();
        boolean D = D();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        int i16 = 3;
        int i17 = 0;
        String format = String.format("switchOtherAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", Arrays.copyOf(new Object[]{Boolean.valueOf(F), Boolean.valueOf(D), Integer.valueOf(i3)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, format);
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            if (i3 != 0 && F) {
                c16.setAudioRoute(0);
            } else if (i3 != 2 && D) {
                c16.setAudioRoute(2);
                i16 = 0;
                i17 = 2;
            } else {
                c16.setAudioRoute(0);
                i16 = 0;
            }
            QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "switchOtherAudioRoute audioRoute " + i17);
            this.mAudioRoute = i17;
            this.mAudioSubRoute = i16;
            G(i17, i16);
        }
    }

    private final void l(int reason) {
        if (this.mHasInit.get()) {
            QavDef$MultiUserInfo qavDef$MultiUserInfo = new QavDef$MultiUserInfo();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            qavDef$MultiUserInfo.mUin = runtime != null ? runtime.getLongAccountUin() : 0L;
            synchronized (this.mEventCallbacks) {
                Iterator<WeakReference<f>> it = this.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference<f> next = it.next();
                    if (next.get() != null) {
                        f fVar = next.get();
                        Intrinsics.checkNotNull(fVar);
                        fVar.h(qavDef$MultiUserInfo);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            AVBizModuleFactory.getModuleByName(Constants.Business.QQ_ZPLAN).abandonAVFocus();
            AVBizModuleFactory.removeModuleByName(Constants.Business.QQ_ZPLAN);
            com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
            if (c16 != null) {
                c16.exitRoom();
            }
            this.mSelfOpenId = "";
            this.mRoomId = -1L;
            if (reason == 2 || reason == 4) {
                ai.INSTANCE.j(reason);
            }
            M();
        }
    }

    private final void m(long j3, final int i3) {
        QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "exitRoom delay=" + j3 + " reason=" + i3);
        this.isEntering.set(false);
        if (j3 == 0) {
            l(i3);
        } else {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.b
                @Override // java.lang.Runnable
                public final void run() {
                    MultiVoiceChatController.n(MultiVoiceChatController.this, i3);
                }
            }, 16, null, true, j3);
        }
    }

    public static final void n(MultiVoiceChatController this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(i3);
    }

    private final void x(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onReceive ACTION_AUDIO_STATE_CHANGED state=%s", Arrays.copyOf(new Object[]{Integer.valueOf(intExtra)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, format);
        if (intExtra == 10) {
            S(2);
        } else {
            if (intExtra != 12) {
                return;
            }
            int i3 = this.mFirstTimeNotNotify ? -1 : 0;
            this.mFirstTimeNotNotify = false;
            R(2, i3);
        }
    }

    private final void y(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onReceive ACTION_STATE_CHANGED state=%s", Arrays.copyOf(new Object[]{Integer.valueOf(intExtra)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, format);
        if (intExtra == 10 || intExtra == 13) {
            S(2);
        }
    }

    private final void z(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", Arrays.copyOf(new Object[]{Integer.valueOf(intExtra)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, format);
        if (intExtra == 0) {
            S(2);
        } else {
            if (intExtra != 2) {
                return;
            }
            R(2, 0);
        }
    }

    public final void C() {
        QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "init");
        if (this.mHasInit.get()) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "has already init");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        PushManager pushManager = (PushManager) runtime.getManager(4);
        if (pushManager != null) {
            pushManager.registProxyMessagePush(AppSetting.f(), BaseApplicationImpl.getApplication().getQQProcessName(), "", "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation");
        }
        com.tencent.qav.log.a.f(new com.tencent.qav.log.c());
        com.tencent.qav.channel.c z16 = com.tencent.qav.channel.c.z();
        z16.A(runtime);
        z16.y(new c());
        com.tencent.qav.controller.a aVar = new com.tencent.qav.controller.a(BaseApplication.getContext(), new g(BaseApplication.getContext(), runtime.getLongAccountUin(), z16));
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.f(aVar);
        b16.d(BaseApplicationImpl.getApplication().getApplicationContext(), runtime.getLongAccountUin(), z16);
        b16.a(this.mQavMultiObserver);
        MobileQQ.sMobileQQ.registerAccountCallback(this.accountChangedCallback);
        this.mHasInit.set(true);
    }

    /* renamed from: E, reason: from getter */
    public final AtomicBoolean getIsEntering() {
        return this.isEntering;
    }

    public final boolean F() {
        Object systemService = BaseApplication.getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return ((AudioManager) systemService).isWiredHeadsetOn();
    }

    public final void H() {
        if (QLog.isColorLevel()) {
            QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "postGetSignTimeoutTask");
        }
        Runnable runnable = this.mGetSignTimeoutRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        this.mGetSignTimeoutRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.c
            @Override // java.lang.Runnable
            public final void run() {
                MultiVoiceChatController.I(MultiVoiceChatController.this);
            }
        }, 16, null, true, 10000L);
    }

    public final void M() {
        QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "release");
        PushManager pushManager = (PushManager) BaseApplicationImpl.getApplication().getRuntime().getManager(4);
        if (pushManager != null) {
            pushManager.unregistProxyMessagePush(AppSetting.f(), BaseApplicationImpl.getApplication().getQQProcessName());
        }
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.e(this.mQavMultiObserver);
        b16.g();
        MobileQQ.sMobileQQ.unregisterAccountCallback(this.accountChangedCallback);
        N(this.mGetSignTimeoutRunnable);
        synchronized (this.mEventCallbacks) {
            this.mEventCallbacks.clear();
            Unit unit = Unit.INSTANCE;
        }
        this.mHasInit.set(false);
        this.mHasEnterRoom.set(false);
    }

    public final void O(boolean enable) {
        g gVar = (g) com.tencent.qav.b.b().c();
        if (gVar != null) {
            gVar.enableLocalAudio(enable);
        }
        this.mEnableLocalAudio = enable;
        if (!enable || gVar == null) {
            return;
        }
        gVar.P();
    }

    public final void P(boolean enable) {
        QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "setEnableSpeaker enable: " + enable);
        if (!this.mHasEnterRoom.get()) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "setEnableSpeaker failed because did not enter room");
            return;
        }
        g gVar = (g) com.tencent.qav.b.b().c();
        if (enable) {
            if (gVar != null) {
                gVar.R();
            }
        } else if (gVar != null) {
            gVar.S();
        }
    }

    public final void R(int i3, int i16) {
        boolean F = F();
        boolean D = D();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Boolean.valueOf(F), Boolean.valueOf(D), Integer.valueOf(i16)}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, format);
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            QLog.d("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "switchAudioRoute audioRoute " + i3);
            c16.setAudioRoute(i3);
            this.mAudioRoute = i3;
            this.mAudioSubRoute = i16;
            G(i3, i16);
        }
    }

    public final int k(String openId, long roomId, String sign) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(sign, "sign");
        if (QLog.isColorLevel()) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "enterRoom openId:" + openId + " roomId:" + roomId + " sign:" + sign);
        }
        if (!ZplanAVControllerForQAV.INSTANCE.f()) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "enterRoom failed because not bind and init wwise");
            return -9;
        }
        if (!this.mHasInit.get()) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "enterRoom failed: has not initialized");
            return -6;
        }
        if (this.mHasEnterRoom.get()) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "has already enterRoom");
            return -10;
        }
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 == null) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "enterRoom failed. multiOperator == null");
            return -5;
        }
        QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "enterRoom openId: " + openId);
        if (!Intrinsics.areEqual("true", AVBizModuleFactory.getModuleByName(Constants.Business.QQ_ZPLAN).requestAVFocus())) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "request focus failed");
            return -7;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        com.tencent.qav.a aVar = new com.tencent.qav.a();
        aVar.f342343a = 11;
        aVar.f342344b = 14;
        aVar.f342345c = 1;
        aVar.f342349g = 6;
        aVar.f342347e = runtime.getLongAccountUin();
        aVar.f342346d = roomId;
        byte[] bytes = sign.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        aVar.f342350h = bytes;
        aVar.f342348f = openId;
        this.mSelfOpenId = openId;
        int e16 = c16.e(aVar);
        if (e16 != 0) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "enterRoom failed. result=" + e16);
        }
        return e16;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getMEnableLocalAudio() {
        return this.mEnableLocalAudio;
    }

    /* renamed from: r, reason: from getter */
    public final AtomicBoolean getMHasEnterRoom() {
        return this.mHasEnterRoom;
    }

    /* renamed from: s, reason: from getter */
    public final long getMRoomId() {
        return this.mRoomId;
    }

    /* renamed from: t, reason: from getter */
    public final String getMSelfOpenId() {
        return this.mSelfOpenId;
    }

    public final ArrayList<String> u() {
        List<QavDef$MultiUserInfo> v3;
        String joinToString$default;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!this.mHasEnterRoom.get()) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "setEnableSpeaker failed because did not enter room");
            return null;
        }
        g gVar = (g) com.tencent.qav.b.b().c();
        if (gVar == null || (v3 = gVar.v()) == null) {
            return null;
        }
        for (QavDef$MultiUserInfo qavDef$MultiUserInfo : v3) {
            if (!TextUtils.isEmpty(qavDef$MultiUserInfo.mOpenId)) {
                arrayList.add(qavDef$MultiUserInfo.mOpenId);
            }
        }
        if (QLog.isColorLevel()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "getOpenIdList result: " + joinToString$default);
        }
        return arrayList;
    }

    public final int v(long roomId) {
        QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "getOpenIdListErrCode roomId: " + roomId);
        if (this.mHasEnterRoom.get()) {
            return this.mRoomId != roomId ? -2 : 0;
        }
        return -1;
    }

    public final int w(String openId, long roomId) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        if (!this.mHasInit.get()) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "getSign failed: has not initialized");
            return -6;
        }
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 == null) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "getSign failed. multiOperator == null");
            return -5;
        }
        this.mSelfOpenId = openId;
        this.mRoomId = roomId;
        if (!(c16 instanceof g)) {
            return -8;
        }
        ((g) c16).O(roomId);
        H();
        return 0;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u0011\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0016J$\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016\u00a8\u0006 "}, d2 = {"com/tencent/mobileqq/zootopia/qav/MultiVoiceChatController$d", "Lcom/tencent/qav/controller/multi/c;", "", "e", "f", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "g", "Lcom/tencent/qav/QavDef$MultiUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "r", ReportConstant.COSTREPORT_PREFIX, "", "available", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "speaking", "audioEnergy", "v", "", "userInfoList", "w", "volumeValue", DomainData.DOMAIN_NAME, "isCalling", "p", "y", "", "ret", "", "msg", "sign", tl.h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends com.tencent.qav.controller.multi.c {
        d() {
        }

        public static final void B(MultiVoiceChatController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q();
        }

        public static final void C(MultiVoiceChatController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q();
        }

        @Override // com.tencent.qav.controller.multi.c
        public void e() {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "onCreateSuc");
            g gVar = (g) com.tencent.qav.b.b().c();
            if (gVar != null) {
                final MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
                if (!multiVoiceChatController.B()) {
                    gVar.Q();
                } else {
                    gVar.P();
                }
                gVar.enableRemoteAudio(true);
                multiVoiceChatController.O(false);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MultiVoiceChatController.d.B(MultiVoiceChatController.this);
                    }
                }, 16, null, true);
            }
            MultiVoiceChatController.this.L();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void f() {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "onEnterRoom");
            MultiVoiceChatController.this.getMHasEnterRoom().set(true);
            MultiVoiceChatController.this.getIsEntering().set(false);
            g gVar = (g) com.tencent.qav.b.b().c();
            if (gVar != null) {
                final MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
                if (!multiVoiceChatController.B()) {
                    gVar.Q();
                } else {
                    gVar.P();
                }
                gVar.enableRemoteAudio(true);
                multiVoiceChatController.O(false);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        MultiVoiceChatController.d.C(MultiVoiceChatController.this);
                    }
                }, 16, null, true);
            }
            MultiVoiceChatController.this.L();
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController2 = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController2.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).b();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            ai.Companion.i(ai.INSTANCE, true, 0, null, 6, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void g(int r95) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "onError errorType: " + r95);
            MultiVoiceChatController.this.getIsEntering().set(false);
            if (4 == r95) {
                MultiVoiceChatController.this.o(4);
            } else if (3 == r95) {
                if (MultiVoiceChatController.this.getMHasEnterRoom().get()) {
                    ai.INSTANCE.j(3);
                    MultiVoiceChatController.this.o(3);
                } else {
                    MultiVoiceChatController.this.o(3);
                    ai.Companion.i(ai.INSTANCE, false, 39, null, 4, null);
                }
            } else if (1 == r95) {
                MultiVoiceChatController.this.o(3);
                ai.INSTANCE.h(false, -2, "\u8fdb\u5165\u8bed\u97f3\u623f\u95f4\u8d85\u65f6");
            } else if (2 == r95) {
                MultiVoiceChatController.this.o(3);
                ai.Companion.i(ai.INSTANCE, false, 34, null, 4, null);
            }
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).c(r95);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void h(long j3, String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onGetSignResponse ret:" + j3 + " msg:" + str + " sign:" + str2);
            }
            if (j3 != 0) {
                MultiVoiceChatController.this.o(3);
                ai.INSTANCE.h(false, -3, "\u7f51\u7edc\u5f02\u5e38");
            } else {
                if (str2 != null) {
                    MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
                    multiVoiceChatController.N(multiVoiceChatController.mGetSignTimeoutRunnable);
                    MultiVoiceChatController multiVoiceChatController2 = MultiVoiceChatController.this;
                    multiVoiceChatController2.k(multiVoiceChatController2.getMSelfOpenId(), MultiVoiceChatController.this.getMRoomId(), str2);
                    return;
                }
                MultiVoiceChatController.this.o(3);
                ai.INSTANCE.h(false, -3, "\u7f51\u7edc\u5f02\u5e38");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void n(int i3) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "onSelfVolumeUpdate volume=" + i3);
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).d(i3);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void p(boolean isCalling) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "onSystemCallStateChanged isCalling=" + isCalling);
            com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
            if (c16 instanceof g) {
                if (isCalling) {
                    if (MultiVoiceChatController.this.getMEnableLocalAudio()) {
                        c16.enableLocalAudio(false);
                    }
                    ((g) c16).S();
                    CallingStateMonitor.k().h();
                } else {
                    if (MultiVoiceChatController.this.getMEnableLocalAudio()) {
                        c16.enableLocalAudio(true);
                    }
                    ((g) c16).R();
                }
            }
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).e(isCalling);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void q(QavDef$MultiUserInfo userInfo, boolean z16) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "onUserAudioAvailable userInfo = " + userInfo + " available = " + z16);
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).f(userInfo, z16);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void r(QavDef$MultiUserInfo r56) {
            String str;
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onUserEnter userInfo: " + r56);
            if (!Intrinsics.areEqual(MultiVoiceChatController.this.getMSelfOpenId(), r56 != null ? r56.mOpenId : null)) {
                ai.Companion companion = ai.INSTANCE;
                if ((r56 != null ? r56.mOpenId : null) == null) {
                    str = "";
                } else {
                    str = r56.mOpenId;
                }
                Intrinsics.checkNotNullExpressionValue(str, "if (userInfo?.mOpenId ==\u2026 \"\" else userInfo.mOpenId");
                companion.e(1, str);
            } else {
                QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onUserEnter self ignore");
            }
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).g(r56);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void s(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            String str;
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onUserExit userInfo: " + qavDef$MultiUserInfo);
            ai.Companion companion = ai.INSTANCE;
            if ((qavDef$MultiUserInfo != null ? qavDef$MultiUserInfo.mOpenId : null) == null) {
                str = "";
            } else {
                str = qavDef$MultiUserInfo.mOpenId;
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (userInfo?.mOpenId ==\u2026 \"\" else userInfo.mOpenId");
            companion.e(2, str);
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).h(qavDef$MultiUserInfo);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void y(boolean isCalling) {
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onVideoChatCallStateChanged isCalling=" + isCalling);
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).k(isCalling);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void v(QavDef$MultiUserInfo r56, boolean speaking, int audioEnergy) {
            if (r56 == null) {
                return;
            }
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it = multiVoiceChatController.mEventCallbacks.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).i(r56, speaking, audioEnergy);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void w(List<? extends QavDef$MultiUserInfo> userInfoList) {
            if (userInfoList == null) {
                QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onUserUpdate user list is null");
                return;
            }
            QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 1, "onUserUpdate userInfoList.size=" + userInfoList.size());
            if (QLog.isColorLevel()) {
                Iterator<? extends QavDef$MultiUserInfo> it = userInfoList.iterator();
                while (it.hasNext()) {
                    QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "onUserUpdate userInfo=" + it.next());
                }
            }
            ArrayList arrayList = MultiVoiceChatController.this.mEventCallbacks;
            MultiVoiceChatController multiVoiceChatController = MultiVoiceChatController.this;
            synchronized (arrayList) {
                Iterator it5 = multiVoiceChatController.mEventCallbacks.iterator();
                while (it5.hasNext()) {
                    WeakReference weakReference = (WeakReference) it5.next();
                    if (weakReference.get() != 0) {
                        T t16 = weakReference.get();
                        Intrinsics.checkNotNull(t16);
                        ((f) t16).j(userInfoList);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void N(Runnable runnable) {
        if (runnable != null) {
            if (QLog.isColorLevel()) {
                QLog.i("[RTAudio][ChatRoom][QQAudio]MultiVoiceChatController", 2, "remove timeout task, runnable " + Reflection.getOrCreateKotlinClass(runnable.getClass()).getSimpleName());
            }
            ThreadManagerV2.removeJob(runnable, 16);
        }
    }

    public final void o(int reason) {
        m(0L, reason);
    }

    public static /* synthetic */ void p(MultiVoiceChatController multiVoiceChatController, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        multiVoiceChatController.o(i3);
    }
}
