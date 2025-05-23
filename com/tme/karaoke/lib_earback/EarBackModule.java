package com.tme.karaoke.lib_earback;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.multimedia.audiokit.interfaces.EnhancedDeviceInfo;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKit;
import com.tencent.component.utils.LogUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tme.karaoke.lib_earback.base.EarBackHeadSetPlugReceiver;
import com.tme.karaoke.lib_earback.base.HeadPhoneStatus;
import com.tme.karaoke.lib_earback.base.a;
import com.tme.karaoke.lib_earback.d;
import com.tme.karaoke.lib_earback.huawei.HWAudioKitEarBack;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cf\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00012\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0005\u001a\u00020\u0004H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010A\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR0\u0010\\\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0W0Vj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0W`Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u00100R\u0019\u0010d\u001a\u0004\u0018\u00010_8\u0006\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0016\u0010h\u001a\u0004\u0018\u00010e8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010k\u00a8\u0006o"}, d2 = {"Lcom/tme/karaoke/lib_earback/EarBackModule;", "Lcom/tme/karaoke/lib_earback/d;", "Lcom/tme/karaoke/lib_earback/base/e;", "Lkotlinx/coroutines/CoroutineScope;", "", "i", "Lcom/tme/karaoke/lib_earback/base/HeadPhoneStatus;", "headPhoneStatus", "b", "", "on", "Lcom/tme/karaoke/lib_earback/EarBackScene;", "scene", "a", "Landroid/content/SharedPreferences;", "d", "Landroid/content/SharedPreferences;", "l", "()Landroid/content/SharedPreferences;", "mSharePerference", "Lcom/tme/karaoke/lib_earback/b;", "e", "Lcom/tme/karaoke/lib_earback/b;", "j", "()Lcom/tme/karaoke/lib_earback/b;", "earBackWorkState", "Landroid/media/AudioManager;", "f", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager", "Lcom/tme/karaoke/lib_earback/base/EarBackHeadSetPlugReceiver;", h.F, "Lcom/tme/karaoke/lib_earback/base/EarBackHeadSetPlugReceiver;", "earBackHeadSetPlugReceiver", "Lry4/a;", "Lry4/a;", "oldVivoFeedback", "Lry4/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lry4/b;", "newVivoFeedback", "Lsy4/b;", BdhLogUtil.LogTag.Tag_Conn, "Lsy4/b;", "xiaoMiFeedback", "D", "Z", "isHuaweiDefaultUserWillSet", "com/tme/karaoke/lib_earback/EarBackModule$c", "E", "Lcom/tme/karaoke/lib_earback/EarBackModule$c;", "huaweiIAudioKitCallback", "Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack;", UserInfo.SEX_FEMALE, "Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack;", "k", "()Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack;", "huaweiAudioKitEarback", "Lcom/tme/karaoke/lib_earback/huawei/a;", "G", "Lcom/tme/karaoke/lib_earback/huawei/a;", "getHuaweiHWAPIAbove26EarBack", "()Lcom/tme/karaoke/lib_earback/huawei/a;", "huaweiHWAPIAbove26EarBack", "Lqy4/a;", "H", "Lqy4/a;", "samsungEarback", "Lpy4/a;", "I", "Lpy4/a;", "oppoEarback", "Lny4/a;", "J", "Lny4/a;", "onePlusFeedback", "Loy4/b;", "K", "Loy4/b;", "openslFeedback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "L", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasTelePhoneCallInState", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/telephony/PhoneStateListener;", "Lkotlin/collections/ArrayList;", "M", "Ljava/util/ArrayList;", "phoneStateListenerWefList", "N", "isForeground", "Landroid/media/AudioManager$AudioRecordingCallback;", "P", "Landroid/media/AudioManager$AudioRecordingCallback;", "getAudioRecordCallback_Above_N", "()Landroid/media/AudioManager$AudioRecordingCallback;", "audioRecordCallback_Above_N", "Landroid/media/AudioDeviceCallback;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/media/AudioDeviceCallback;", "audioDeviceCallback_Above_M", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class EarBackModule implements d, com.tme.karaoke.lib_earback.base.e, CoroutineScope {

    /* renamed from: C, reason: from kotlin metadata */
    private static final sy4.b xiaoMiFeedback;

    /* renamed from: D, reason: from kotlin metadata */
    private static boolean isHuaweiDefaultUserWillSet;

    /* renamed from: E, reason: from kotlin metadata */
    private static final c huaweiIAudioKitCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static final HWAudioKitEarBack huaweiAudioKitEarback;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static final com.tme.karaoke.lib_earback.huawei.a huaweiHWAPIAbove26EarBack;

    /* renamed from: H, reason: from kotlin metadata */
    private static final qy4.a samsungEarback;

    /* renamed from: I, reason: from kotlin metadata */
    private static final py4.a oppoEarback;

    /* renamed from: J, reason: from kotlin metadata */
    private static final ny4.a onePlusFeedback;

    /* renamed from: K, reason: from kotlin metadata */
    private static final oy4.b openslFeedback;

    /* renamed from: L, reason: from kotlin metadata */
    private static final AtomicBoolean hasTelePhoneCallInState;

    /* renamed from: M, reason: from kotlin metadata */
    private static final ArrayList<WeakReference<PhoneStateListener>> phoneStateListenerWefList;

    /* renamed from: N, reason: from kotlin metadata */
    private static boolean isForeground;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private static final AudioManager.AudioRecordingCallback audioRecordCallback_Above_N;

    /* renamed from: Q, reason: from kotlin metadata */
    @RequiresApi(23)
    private static final AudioDeviceCallback audioDeviceCallback_Above_M;
    public static final EarBackModule R;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final SharedPreferences mSharePerference;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final EarBackWorkState earBackWorkState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final AudioManager audioManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final EarBackHeadSetPlugReceiver earBackHeadSetPlugReceiver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final ry4.a oldVivoFeedback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final ry4.b newVivoFeedback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2 = {"com/tme/karaoke/lib_earback/EarBackModule$a", "Landroid/media/AudioDeviceCallback;", "", "Landroid/media/AudioDeviceInfo;", "addedDevices", "", "onAudioDevicesAdded", "([Landroid/media/AudioDeviceInfo;)V", "removedDevices", "onAudioDevicesRemoved", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes27.dex */
    public static final class a extends AudioDeviceCallback {
        a() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(@NotNull AudioDeviceInfo[] addedDevices) {
            boolean z16;
            AudioDeviceInfo audioDeviceInfo;
            boolean z17;
            Intrinsics.checkParameterIsNotNull(addedDevices, "addedDevices");
            try {
                if (addedDevices.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int length = addedDevices.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            audioDeviceInfo = addedDevices[i3];
                            if (audioDeviceInfo.getType() == 8) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            audioDeviceInfo = null;
                            break;
                        }
                    }
                    if (audioDeviceInfo != null) {
                        com.tme.karaoke.lib_earback.base.c.m("find a2dp device info");
                        com.tme.karaoke.lib_earback.base.c.k(audioDeviceInfo);
                        EarBackModule earBackModule = EarBackModule.R;
                        earBackModule.j().getAudioDeviceInfo().e(audioDeviceInfo);
                        if (com.tme.karaoke.lib_earback.base.c.j()) {
                            earBackModule.i();
                        }
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                com.tme.karaoke.lib_earback.base.c.m("addedDevices.size is zero");
                throw new IllegalStateException(Unit.INSTANCE.toString());
            } catch (Throwable th5) {
                if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                    com.tme.karaoke.lib_earback.base.c.m("need report");
                } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                    com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                }
                com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th5.getMessage());
                th5.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(@NotNull AudioDeviceInfo[] removedDevices) {
            boolean z16;
            AudioDeviceInfo audioDeviceInfo;
            Intrinsics.checkParameterIsNotNull(removedDevices, "removedDevices");
            try {
                int i3 = 0;
                if (removedDevices.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int length = removedDevices.length;
                    while (true) {
                        if (i3 < length) {
                            audioDeviceInfo = removedDevices[i3];
                            if (Intrinsics.areEqual(audioDeviceInfo, EarBackModule.R.j().getAudioDeviceInfo().getAudioDeviceInfo())) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            audioDeviceInfo = null;
                            break;
                        }
                    }
                    if (audioDeviceInfo != null) {
                        com.tme.karaoke.lib_earback.base.c.m("cur a2dp device is removed");
                        EarBackModule.R.j().getAudioDeviceInfo().d();
                    } else {
                        com.tme.karaoke.lib_earback.base.c.m("don't find cur a2dp device ,when onAudioDevicesRemoved event received");
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                com.tme.karaoke.lib_earback.base.c.m("removedDevice is empty");
                throw new IllegalStateException(Unit.INSTANCE.toString());
            } catch (Throwable th5) {
                if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                    com.tme.karaoke.lib_earback.base.c.m("need report");
                } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                    com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                }
                com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th5.getMessage());
                th5.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes27.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineContext.Key key) {
            super(key);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(exception, "exception");
            com.tme.karaoke.lib_earback.base.c.m("exception occur in EarBackModule,exception is " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tme/karaoke/lib_earback/EarBackModule$c", "Lcom/tme/karaoke/lib_earback/huawei/d;", "", TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, "", "a", "", QzoneIPCModule.RESULT_CODE, "c", "errorCode", "b", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes27.dex */
    public static final class c implements com.tme.karaoke.lib_earback.huawei.d {
        c() {
        }

        @Override // com.tme.karaoke.lib_earback.huawei.d
        public void a(boolean support) {
            if (support) {
                com.tme.karaoke.lib_earback.base.c.m("change supportHwAudiokit");
                try {
                    EarBackModule earBackModule = EarBackModule.R;
                    Object audioDeviceInfo = earBackModule.j().getAudioDeviceInfo().getAudioDeviceInfo();
                    if (!(audioDeviceInfo instanceof AudioDeviceInfo)) {
                        audioDeviceInfo = null;
                    }
                    AudioDeviceInfo audioDeviceInfo2 = (AudioDeviceInfo) audioDeviceInfo;
                    if (audioDeviceInfo2 != null) {
                        com.tme.karaoke.lib_earback.base.c.k(audioDeviceInfo2);
                        com.tme.karaoke.lib_earback.base.c.m("getBlueToothSupportFeatureForHuawei in huaweiaudioKitcallback event");
                        earBackModule.i();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th5) {
                    if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                        com.tme.karaoke.lib_earback.base.c.m("need report");
                    } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                        com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                    }
                    com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th5.getMessage());
                    th5.printStackTrace();
                    Unit unit2 = Unit.INSTANCE;
                }
                EarBackModule earBackModule2 = EarBackModule.R;
                EarBackType earBackType = earBackModule2.j().getEarBackType();
                EarBackType earBackType2 = EarBackType.HuaweiAudioKitEarBackType;
                if (earBackType == earBackType2) {
                    d.a.a(earBackModule2, com.tme.karaoke.lib_earback.base.c.h(), null, 2, null);
                    return;
                }
                earBackModule2.j().j(earBackType2);
                earBackModule2.j().g(earBackModule2.k());
                earBackModule2.j().h(true);
                earBackModule2.j().i(EarBackState.UnKnow);
                if (!EarBackModule.g(earBackModule2)) {
                    EarBackModule.isHuaweiDefaultUserWillSet = true;
                    com.tme.karaoke.lib_earback.base.c.o(earBackType2);
                    com.tme.karaoke.lib_earback.base.c.e(EarBackUserWill.On);
                }
                d.a.a(earBackModule2, com.tme.karaoke.lib_earback.base.c.h(), null, 2, null);
            }
        }

        @Override // com.tme.karaoke.lib_earback.huawei.d
        public void b(int errorCode) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isAudiokitInitialFail, errorCode=");
            sb5.append(errorCode);
            sb5.append(", earBackWorkState.earBackType=");
            EarBackModule earBackModule = EarBackModule.R;
            sb5.append(earBackModule.j().getEarBackType());
            com.tme.karaoke.lib_earback.base.c.m(sb5.toString());
            if (earBackModule.j().getEarBackType() == EarBackType.HuaweiAPIAbove26VersionSystemEarBackType) {
                HWAudioKitEarBack k3 = earBackModule.k();
                if (k3 != null) {
                    d.a.a(k3, false, null, 2, null);
                }
                earBackModule.k().b();
                return;
            }
            if (earBackModule.j().getEarBackType() == EarBackType.HuaweiAudioKitEarBackType) {
                HWAudioKitEarBack k16 = earBackModule.k();
                if (k16 != null) {
                    d.a.a(k16, false, null, 2, null);
                }
                HWAudioKitEarBack k17 = earBackModule.k();
                if (k17 != null) {
                    k17.b();
                }
                earBackModule.j().j(EarBackType.Opensl);
                earBackModule.j().g(EarBackModule.e(earBackModule));
                earBackModule.j().h(true);
                d.a.a(earBackModule, false, null, 2, null);
                d.a.a(earBackModule, com.tme.karaoke.lib_earback.base.c.h(), null, 2, null);
            }
        }

        @Override // com.tme.karaoke.lib_earback.huawei.d
        public void c(int resultCode) {
            EarBackModule.c(EarBackModule.R);
        }
    }

    static {
        SharedPreferences sharedPreferences;
        Object obj;
        EarBackModule earBackModule = new EarBackModule();
        R = earBackModule;
        Context a16 = com.tme.karaoke.lib_earback.base.b.a();
        AudioManager.AudioRecordingCallback audioRecordingCallback = null;
        if (a16 != null) {
            sharedPreferences = a16.getSharedPreferences("EarBackModule", 0);
        } else {
            sharedPreferences = null;
        }
        mSharePerference = sharedPreferences;
        earBackWorkState = new EarBackWorkState(null, null, null, null, false, null, null, 127, null);
        Context a17 = com.tme.karaoke.lib_earback.base.b.a();
        if (a17 != null) {
            obj = a17.getSystemService("audio");
        } else {
            obj = null;
        }
        if (!(obj instanceof AudioManager)) {
            obj = null;
        }
        audioManager = (AudioManager) obj;
        EarBackHeadSetPlugReceiver earBackHeadSetPlugReceiver2 = new EarBackHeadSetPlugReceiver();
        earBackHeadSetPlugReceiver2.a(earBackModule);
        earBackHeadSetPlugReceiver = earBackHeadSetPlugReceiver2;
        int i3 = Build.VERSION.SDK_INT;
        oldVivoFeedback = null;
        newVivoFeedback = new ry4.b();
        xiaoMiFeedback = new sy4.b();
        isHuaweiDefaultUserWillSet = com.tme.karaoke.lib_earback.base.c.f(EarBackType.HuaweiAudioKitEarBackType);
        huaweiIAudioKitCallback = new c();
        huaweiAudioKitEarback = new HWAudioKitEarBack();
        huaweiHWAPIAbove26EarBack = new com.tme.karaoke.lib_earback.huawei.a(earBackModule);
        samsungEarback = new qy4.a();
        oppoEarback = new py4.a();
        onePlusFeedback = new ny4.a();
        oy4.b a18 = oy4.b.a();
        Intrinsics.checkExpressionValueIsNotNull(a18, "NativeFeedback.getInstance()");
        openslFeedback = a18;
        hasTelePhoneCallInState = new AtomicBoolean(false);
        phoneStateListenerWefList = new ArrayList<>();
        isForeground = true;
        if (i3 >= 24) {
            audioRecordingCallback = new AudioManager.AudioRecordingCallback() { // from class: com.tme.karaoke.lib_earback.EarBackModule$audioRecordCallback_Above_N$1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v30, types: [T, java.lang.String] */
                @Override // android.media.AudioManager.AudioRecordingCallback
                public void onRecordingConfigChanged(@Nullable List<AudioRecordingConfiguration> configs) {
                    Integer num;
                    boolean contains$default;
                    int clientAudioSource;
                    int clientAudioSource2;
                    Class<AudioRecordingConfiguration> cls;
                    boolean z16;
                    int clientAudioSource3;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("recording configchanged,configs.size = ");
                    if (configs != null) {
                        num = Integer.valueOf(configs.size());
                    } else {
                        num = null;
                    }
                    sb5.append(num);
                    com.tme.karaoke.lib_earback.base.c.m(sb5.toString());
                    if (configs != null) {
                        try {
                            EarBackModule earBackModule2 = EarBackModule.R;
                            z16 = EarBackModule.isForeground;
                            if (z16 && configs.size() == 1) {
                                clientAudioSource3 = configs.get(0).getClientAudioSource();
                                if (clientAudioSource3 == 1) {
                                    com.tme.karaoke.lib_earback.base.c.m("try open earback when clientAudioSource is our app");
                                    if (com.tme.karaoke.lib_earback.base.d.a() == 3) {
                                        if (earBackModule2.j().getAudioDeviceInfo().getIsBlueToothSupport() && com.tme.karaoke.lib_earback.base.c.h()) {
                                            d.a.a(earBackModule2, true, null, 2, null);
                                        } else {
                                            LogUtil.i("EarBackModule", "bluetooth not support earback");
                                            d.a.a(earBackModule2, false, null, 2, null);
                                        }
                                    } else if (com.tme.karaoke.lib_earback.base.c.h()) {
                                        d.a.a(earBackModule2, true, null, 2, null);
                                    }
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th5) {
                            if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                                com.tme.karaoke.lib_earback.base.c.m("need report");
                            } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                                com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                            }
                            com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th5.getMessage());
                            th5.printStackTrace();
                            Unit unit2 = Unit.INSTANCE;
                        }
                        for (AudioRecordingConfiguration audioRecordingConfiguration : configs) {
                            com.tme.karaoke.lib_earback.base.c.l(audioRecordingConfiguration);
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            objectRef.element = "";
                            try {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    cls = AudioRecordingConfiguration.class;
                                } else {
                                    cls = null;
                                }
                                if (cls != null) {
                                    Field declaredField = cls.getDeclaredField("mClientPackageName");
                                    Intrinsics.checkExpressionValueIsNotNull(declaredField, "it.getDeclaredField(\"mClientPackageName\")");
                                    declaredField.setAccessible(true);
                                    Object obj2 = declaredField.get(audioRecordingConfiguration);
                                    if (obj2 != null) {
                                        objectRef.element = (String) obj2;
                                        Unit unit3 = Unit.INSTANCE;
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                                        break;
                                    }
                                }
                            } catch (Throwable th6) {
                                if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                                    com.tme.karaoke.lib_earback.base.c.m("need report");
                                } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                                    com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                                }
                                com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th6.getMessage());
                                th6.printStackTrace();
                                Unit unit4 = Unit.INSTANCE;
                            }
                            com.tme.karaoke.lib_earback.base.c.m("now,the audiorecordingconfiguration clientname = " + ((String) objectRef.element));
                            if (!TextUtils.isEmpty((String) objectRef.element)) {
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) objectRef.element, (CharSequence) "com.tencent.karaoke", false, 2, (Object) null);
                                if (!contains$default) {
                                    clientAudioSource = audioRecordingConfiguration.getClientAudioSource();
                                    if (clientAudioSource == 1) {
                                        try {
                                            BuildersKt__Builders_commonKt.launch$default(EarBackModule.R, null, null, new EarBackModule$audioRecordCallback_Above_N$1$$special$$inlined$Try$lambda$1(null, objectRef), 3, null);
                                        } catch (Throwable th7) {
                                            if (Reflection.getOrCreateKotlinClass(Job.class).isInstance(a.C10084a.f386971a)) {
                                                com.tme.karaoke.lib_earback.base.c.m("need report");
                                            } else if (Reflection.getOrCreateKotlinClass(Job.class).isInstance(a.b.f386972a)) {
                                                com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                                            }
                                            com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th7.getMessage());
                                            th7.printStackTrace();
                                            Unit unit5 = Unit.INSTANCE;
                                        }
                                    } else {
                                        clientAudioSource2 = audioRecordingConfiguration.getClientAudioSource();
                                        if (clientAudioSource2 == 4) {
                                            com.tme.karaoke.lib_earback.base.c.m("\u7535\u8bdd\u6b63\u5728\u5360\u7528\u5f55\u97f3\u901a\u9053");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            };
        }
        audioRecordCallback_Above_N = audioRecordingCallback;
        audioDeviceCallback_Above_M = new a();
    }

    EarBackModule() {
    }

    public static final /* synthetic */ com.tme.karaoke.lib_earback.huawei.c c(EarBackModule earBackModule) {
        return null;
    }

    public static final /* synthetic */ oy4.b e(EarBackModule earBackModule) {
        return openslFeedback;
    }

    public static final /* synthetic */ boolean g(EarBackModule earBackModule) {
        return isHuaweiDefaultUserWillSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(23)
    public final void i() {
        EnhancedDeviceInfo enhancedDeviceInfo;
        HwAudioKit mHwAudioKit = huaweiAudioKitEarback.getMHwAudioKit();
        if (mHwAudioKit != null && (enhancedDeviceInfo = mHwAudioKit.getEnhancedDeviceInfo(8)) != null) {
            com.tme.karaoke.lib_earback.base.c.m("getEnhancedDeviceInfo success for a2dp");
            EarBackWorkState earBackWorkState2 = earBackWorkState;
            earBackWorkState2.getAudioDeviceInfo().i(enhancedDeviceInfo.isFullbandRecordSupported());
            earBackWorkState2.getAudioDeviceInfo().g(enhancedDeviceInfo.isKaraokeSupported());
            if (earBackWorkState2.getAudioDeviceInfo().getIsBlueToothSupport()) {
                earBackWorkState2.getAudioDeviceInfo().f(180);
                earBackWorkState2.getAudioDeviceInfo().h(true);
            }
            com.tme.karaoke.lib_earback.base.c.m("show audioDeviceInfo=" + earBackWorkState2.getAudioDeviceInfo());
            return;
        }
        com.tme.karaoke.lib_earback.base.c.m("don't find enhancedDevice info");
    }

    @Override // com.tme.karaoke.lib_earback.d
    public boolean a(boolean on5, @NotNull EarBackScene scene) {
        boolean a16;
        EarBackState earBackState;
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("before turnEarbackSwitch(");
        sb5.append(on5);
        sb5.append("),first list cur earback info ");
        EarBackWorkState earBackWorkState2 = earBackWorkState;
        sb5.append(earBackWorkState2);
        sb5.append(",scene = ");
        sb5.append(scene);
        com.tme.karaoke.lib_earback.base.c.m(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("audioKitResultCode:");
        HWAudioKitEarBack hWAudioKitEarBack = huaweiAudioKitEarback;
        sb6.append(hWAudioKitEarBack.getLastAudioKitResultCode());
        com.tme.karaoke.lib_earback.base.c.m(sb6.toString());
        if (!com.tme.karaoke.lib_earback.base.c.g() && !com.tme.karaoke.lib_earback.base.c.i()) {
            com.tme.karaoke.lib_earback.base.c.m("turnEarbacSwitch>>> but can't control earback");
            earBackWorkState2.i(EarBackState.On);
            return false;
        }
        if (on5 && com.tme.karaoke.lib_earback.base.d.c()) {
            if (com.tme.karaoke.lib_earback.base.d.a() == 3 && earBackWorkState2.getEarBackType() == EarBackType.HuaweiAudioKitEarBackType) {
                if (hWAudioKitEarBack.getMMode() == HWAudioKitEarBack.ModeState.PreInit) {
                    com.tme.karaoke.lib_earback.base.c.m("try turn on earback\uff0chwaudiokit,mode:" + hWAudioKitEarBack.getMMode() + ",pass");
                } else if (!com.tme.karaoke.lib_earback.base.c.c()) {
                    com.tme.karaoke.lib_earback.base.c.m("try turn on earback\uff0cbut is bluetooth\uff0creturn");
                    if (earBackWorkState2.getEarBackStatus() != EarBackState.On) {
                        return false;
                    }
                    return true;
                }
            } else {
                com.tme.karaoke.lib_earback.base.c.m("try turn on earback\uff0cbut is speaker\uff0creturn");
                if (earBackWorkState2.getEarBackStatus() != EarBackState.On) {
                    return false;
                }
                return true;
            }
        }
        Object earBackImpl = earBackWorkState2.getEarBackImpl();
        if (earBackImpl != null) {
            if (earBackImpl instanceof e) {
                a16 = ((e) earBackImpl).turnFeedback(on5);
            } else if (earBackImpl instanceof d) {
                a16 = d.a.a((d) earBackImpl, on5, null, 2, null);
            } else {
                com.tme.karaoke.lib_earback.base.c.m("don't support feedbackInterface");
                throw new UnsupportedOperationException("unsupported feedbackimpl");
            }
            if (a16) {
                earBackState = EarBackState.On;
            } else {
                earBackState = EarBackState.Off;
            }
            earBackWorkState2.i(earBackState);
            com.tme.karaoke.lib_earback.base.c.m("excute turnEarbackSwitch(" + on5 + ") success,now earbackworking is " + earBackWorkState2.getEarBackStatus());
            return a16;
        }
        com.tme.karaoke.lib_earback.base.c.m("don't has earback impl,return false");
        return false;
    }

    @Override // com.tme.karaoke.lib_earback.base.e
    public void b(@NotNull HeadPhoneStatus headPhoneStatus) {
        Intrinsics.checkParameterIsNotNull(headPhoneStatus, "headPhoneStatus");
        com.tme.karaoke.lib_earback.base.c.m("headsetplugchanged received,headPhoneStatus=" + headPhoneStatus + ",userWill = " + earBackWorkState.getEarBackUserWill());
        int i3 = com.tme.karaoke.lib_earback.a.f386961a[headPhoneStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        d.a.a(this, false, null, 2, null);
                        return;
                    }
                    return;
                } else {
                    if (com.tme.karaoke.lib_earback.base.c.h()) {
                        d.a.a(this, true, null, 2, null);
                        return;
                    }
                    return;
                }
            }
            if (com.tme.karaoke.lib_earback.base.c.h()) {
                d.a.a(this, true, null, 2, null);
                return;
            }
            return;
        }
        d.a.a(this, false, null, 2, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Intrinsics.checkExpressionValueIsNotNull(newSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        return ExecutorsKt.from(newSingleThreadExecutor).plus(SupervisorKt.m1995SupervisorJob$default((Job) null, 1, (Object) null)).plus(new b(CoroutineExceptionHandler.INSTANCE));
    }

    @NotNull
    public final EarBackWorkState j() {
        return earBackWorkState;
    }

    @NotNull
    public final HWAudioKitEarBack k() {
        return huaweiAudioKitEarback;
    }

    @Nullable
    public final SharedPreferences l() {
        return mSharePerference;
    }
}
