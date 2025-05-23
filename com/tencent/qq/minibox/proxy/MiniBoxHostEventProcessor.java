package com.tencent.qq.minibox.proxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.proxy.CallHostCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.minigame.api.IArkShareForMiniBoxApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVALaunchApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVALoginApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.minigame.va.GameLoginInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.IMiniBoxNoticeService;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import com.tencent.qq.minibox.event.MiniBoxAppBackgroundEvent;
import com.tencent.qq.minibox.exception.MiniBoxExceptionDetail;
import com.tencent.trpcprotocol.minibox.va_stop_bleeding.VaStopBleeding.VaStopBleedingPB$CrashReportRsp;
import com.tencent.util.QQToastUtil;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cs3.ApkInfo;
import cs3.MetaDreamAppExtraInfo;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J:\u0010\u0011\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J-\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\u0017\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J,\u0010\"\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u0012H\u0002J\u0014\u0010#\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010&\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$J\u0006\u0010'\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020(J\u000e\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020(R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010/R:\u0010:\u001a&\u0012\f\u0012\n 7*\u0004\u0018\u00010(0( 7*\u0012\u0012\f\u0012\n 7*\u0004\u0018\u00010(0(\u0018\u000108068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00109R$\u0010?\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00128\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b*\u0010<\u001a\u0004\b=\u0010>\u00a8\u0006C"}, d2 = {"Lcom/tencent/qq/minibox/proxy/MiniBoxHostEventProcessor;", "", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCModule;", "eipcModule", "", "o", "appId", PushClientConstants.TAG_PKG_NAME, "currentVersionName", "reportName", "reportData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "deleteVaApp", "B", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", QZoneDTLoginReporter.SCHEMA, "t", "k", "u", "v", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l", ReportConstant.COSTREPORT_PREFIX, "icon", "text", "callRefresh", "y", "g", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "e", "i", "Lcom/tencent/qq/minibox/proxy/MiniBoxHostEventProcessor$a;", "listener", "f", HippyTKDListViewAdapter.X, "Ljava/util/concurrent/ConcurrentHashMap;", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "stayTimeMap", "c", "Ljava/lang/String;", "currentWaitingGameAppId", "d", "actionToPromiseMap", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "processListeners", "<set-?>", "Z", "w", "()Z", "isChannelReady", "<init>", "()V", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxHostEventProcessor {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String currentWaitingGameAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isChannelReady;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MiniBoxHostEventProcessor f344586a = new MiniBoxHostEventProcessor();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Long> stayTimeMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Promise> actionToPromiseMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Set<a> processListeners = Collections.synchronizedSet(new HashSet());

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qq/minibox/proxy/MiniBoxHostEventProcessor$a;", "", "", "Dd", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void Dd();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qq/minibox/proxy/MiniBoxHostEventProcessor$b", "Lqs3/a;", "Lqs3/d;", "ssoResponse", "", "q7", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements qs3.a {
        b() {
        }

        @Override // qs3.a
        public void q7(@NotNull qs3.d ssoResponse) {
            Intrinsics.checkNotNullParameter(ssoResponse, "ssoResponse");
            QLog.i("MiniBoxHostEventProcess", 2, "report common report isSuccess:" + ssoResponse.c() + " retCode:" + ssoResponse.getRetCode());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qq/minibox/proxy/MiniBoxHostEventProcessor$c", "Lqs3/a;", "Lqs3/d;", "ssoResponse", "", "q7", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements qs3.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f344592d;

        c(String str) {
            this.f344592d = str;
        }

        @Override // qs3.a
        public void q7(@NotNull qs3.d ssoResponse) {
            Intrinsics.checkNotNullParameter(ssoResponse, "ssoResponse");
            QLog.i("MiniBoxHostEventProcess", 2, "report crash detail " + ssoResponse.c());
            if (ssoResponse.c() && ssoResponse.getData() != null) {
                try {
                    VaStopBleedingPB$CrashReportRsp vaStopBleedingPB$CrashReportRsp = new VaStopBleedingPB$CrashReportRsp();
                    vaStopBleedingPB$CrashReportRsp.mergeFrom(ssoResponse.getData());
                    boolean z16 = vaStopBleedingPB$CrashReportRsp.is_available.get();
                    us3.q qVar = us3.q.f440003a;
                    String str = vaStopBleedingPB$CrashReportRsp.rule.get();
                    Intrinsics.checkNotNullExpressionValue(str, "rsp.rule.get()");
                    qVar.o(str);
                    QLog.i("MiniBoxHostEventProcess", 1, this.f344592d + " isVaAvailable:" + z16);
                    if (!z16) {
                        ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).handleCrashInterceptUpdate();
                    }
                } catch (Throwable th5) {
                    QLog.e("MiniBoxHostEventProcess", 1, "report crash throw:", th5);
                }
            }
        }
    }

    MiniBoxHostEventProcessor() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A(Bundle params) {
        String str;
        boolean z16;
        boolean isBlank;
        if (params != null) {
            str = params.getString("mini_box_key_toast_text");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    QQToastUtil.showQQToast(-1, str);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void B(Boolean deleteVaApp, String pkgName, String currentVersionName) {
        if (Intrinsics.areEqual(deleteVaApp, Boolean.TRUE) && pkgName != null) {
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).uninstallVirtualApp(pkgName, null);
        }
        ((IMiniGameVALaunchApi) QRoute.api(IMiniGameVALaunchApi.class)).startYunGame(pkgName);
        ((IMiniGameVALaunchApi) QRoute.api(IMiniGameVALaunchApi.class)).reportDc87(1, pkgName, currentVersionName, "");
    }

    private final void g(String appId) {
        if (appId != null) {
            Bundle bundle = new Bundle();
            bundle.putString("appid", appId);
            Message message = new Message();
            message.what = 1134071;
            message.obj = bundle;
            BannerManager.l().O(com.tencent.mobileqq.banner.d.L, 0, message);
        }
    }

    static /* synthetic */ void h(MiniBoxHostEventProcessor miniBoxHostEventProcessor, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = currentWaitingGameAppId;
        }
        miniBoxHostEventProcessor.g(str);
    }

    private final void j(Bundle params) {
        String string;
        String string2;
        if (params == null || (string = params.getString("game_id")) == null || (string2 = params.getString("package_name")) == null) {
            return;
        }
        us3.g.f439986a.c(string, string2, params.getString("app_name"), params.getInt("version_code", 0), params.getString("icon_url"), params.getString("apk_url"));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void k(Bundle params) {
        boolean z16;
        Long l3;
        boolean z17;
        if (((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isMiniBoxSystemInstallSwitchEnable() && params != null) {
            long j3 = params.getLong("minibox_stay_time", 0L);
            String appId = params.getString("minibox_appid", "");
            boolean z18 = params.getBoolean("minibox_is_exit", false);
            if (appId != null) {
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                if (appId.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16 && j3 > 0) {
                        ConcurrentHashMap<String, Long> concurrentHashMap = stayTimeMap;
                        l3 = concurrentHashMap.get(appId);
                        if (l3 != null) {
                            Long valueOf = Long.valueOf(j3);
                            Intrinsics.checkNotNullExpressionValue(appId, "appId");
                            concurrentHashMap.put(appId, valueOf);
                        } else {
                            Intrinsics.checkNotNullExpressionValue(appId, "appId");
                            concurrentHashMap.put(appId, Long.valueOf(l3.longValue() + j3));
                        }
                        if (z18) {
                            Long l16 = concurrentHashMap.get(appId);
                            Intrinsics.checkNotNull(l16);
                            if (l16.longValue() > 180000) {
                                SimpleEventBus.getInstance().dispatchEvent(new MiniBoxAppBackgroundEvent(appId));
                            }
                        }
                    }
                    if (!z18) {
                        QLog.d("MiniBoxHostEventProcess", 2, "minibox_app_background exit");
                        h(f344586a, null, 1, null);
                        isChannelReady = false;
                        currentWaitingGameAppId = null;
                        ConcurrentHashMap<String, Promise> concurrentHashMap2 = actionToPromiseMap;
                        synchronized (concurrentHashMap2) {
                            concurrentHashMap2.clear();
                            Unit unit = Unit.INSTANCE;
                        }
                        Set<a> processListeners2 = processListeners;
                        Intrinsics.checkNotNullExpressionValue(processListeners2, "processListeners");
                        synchronized (processListeners2) {
                            Iterator<a> it = processListeners.iterator();
                            while (it.hasNext()) {
                                it.next().Dd();
                            }
                            processListeners.clear();
                            Unit unit2 = Unit.INSTANCE;
                        }
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            if (z16) {
                ConcurrentHashMap<String, Long> concurrentHashMap3 = stayTimeMap;
                l3 = concurrentHashMap3.get(appId);
                if (l3 != null) {
                }
                if (z18) {
                }
            }
            if (!z18) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0115 A[Catch: all -> 0x0139, TRY_LEAVE, TryCatch #1 {all -> 0x0139, blocks: (B:9:0x0067, B:11:0x0084, B:19:0x0099, B:21:0x00a1, B:25:0x00ac, B:26:0x00dc, B:34:0x00f5, B:39:0x00f8, B:40:0x00f9, B:41:0x00fa, B:45:0x0104, B:47:0x0108, B:53:0x0115, B:28:0x00dd, B:29:0x00e3, B:31:0x00e9, B:33:0x00f3), top: B:8:0x0067, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l(Bundle params) {
        String str;
        boolean z16;
        if (params != null) {
            str = params.getString("minibox_client_key_game_queue", null);
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        String appId = params.getString("minibox_appid", null);
        String string = params.getString("mini_box_icon", null);
        String string2 = params.getString("mini_box_game_name", "\u4e91\u6e38\u620f");
        QLog.d("MiniBoxHostEventProcess", 2, "handleGameQueue gameInfoString:" + str + " appId:" + appId + " iconUrl:" + string + " gameName:" + string2 + " currentWaitingGameAppId:" + currentWaitingGameAppId);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cmd", "");
            jSONObject.optString("data", "");
            MiniBoxSDK.getAppInfo();
            if (optString != null) {
                int hashCode = optString.hashCode();
                if (hashCode != -1910467556) {
                    if (hashCode != -66861099) {
                        if (hashCode == 1869685752) {
                            optString.equals("ALLOCATE_DEVICE_QUEUEING");
                            return;
                        }
                        return;
                    }
                    if (optString.equals("ALLOCATE_DEVICE_QUEUEING_BACKGROUND")) {
                        currentWaitingGameAppId = appId;
                        Intrinsics.checkNotNullExpressionValue(appId, "appId");
                        z(this, appId, string, "\u4f60\u7684" + string2 + "\u540e\u53f0\u52a0\u8f7d\u8fdb\u884c\u4e2d\uff0c\u70b9\u51fb\u8fdb\u5165\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f", false, 8, null);
                        Set<a> processListeners2 = processListeners;
                        Intrinsics.checkNotNullExpressionValue(processListeners2, "processListeners");
                        synchronized (processListeners2) {
                            Iterator<a> it = processListeners.iterator();
                            while (it.hasNext()) {
                                it.next().Dd();
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                        return;
                    }
                    return;
                }
                if (optString.equals("ALLOCATE_DEVICE_READY")) {
                    String str2 = currentWaitingGameAppId;
                    if (str2 != null && str2.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(appId, "appId");
                        y(appId, string, "\u4f60\u7684" + string2 + "\u540e\u53f0\u52a0\u8f7d\u5df2\u5b8c\u6210\uff0c\u70b9\u51fb\u8fdb\u5165\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f", true);
                        currentWaitingGameAppId = null;
                        return;
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("MiniBoxHostEventProcess", 1, "handleGameQueue tr:", th5);
        }
    }

    private final void m(final String appId, final String pkgName, final String currentVersionName, final String reportName, final String reportData) {
        ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).getExtraInfo(new cs3.c() { // from class: com.tencent.qq.minibox.proxy.l
            @Override // cs3.c
            public final void onExtraRsp(MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
                MiniBoxHostEventProcessor.n(appId, pkgName, currentVersionName, reportName, reportData, metaDreamAppExtraInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String str, String str2, String str3, String str4, String str5, MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
        ApkInfo apkInfo;
        String str6 = null;
        if (metaDreamAppExtraInfo != null) {
            apkInfo = metaDreamAppExtraInfo.getApkInfo();
        } else {
            apkInfo = null;
        }
        if (apkInfo != null) {
            us3.a aVar = new us3.a();
            if (str == null) {
                str = str2;
            }
            aVar.f439975a = str;
            ApkInfo apkInfo2 = metaDreamAppExtraInfo.getApkInfo();
            if (apkInfo2 != null) {
                str6 = apkInfo2.getVersionName();
            }
            if (str6 == null) {
                str6 = "";
            }
            aVar.f439977c = str6;
            aVar.f439976b = str3;
            aVar.f439978d = str4;
            aVar.f439979e = str5;
            qs3.c.f429464a.d(new rs3.i(aVar), new b());
        }
    }

    @JvmStatic
    public static final void o(@Nullable String action, @Nullable Bundle params, final int callbackId, @NotNull final EIPCModule eipcModule) {
        Boolean bool;
        final String str;
        final Boolean bool2;
        final String str2;
        final String str3;
        final String str4;
        final String str5;
        final String str6;
        Serializable serializable;
        String str7;
        String str8;
        final String str9;
        int i3;
        Intrinsics.checkNotNullParameter(eipcModule, "eipcModule");
        QLog.d("MiniBoxHostEventProcess", 4, "handleMiniBoxHostEvent action:" + action);
        if (action != null) {
            boolean z16 = true;
            boolean z17 = false;
            int i16 = 0;
            String str10 = null;
            String str11 = null;
            final String str12 = null;
            String str13 = null;
            String str14 = null;
            MiniBoxExceptionDetail miniBoxExceptionDetail = null;
            String str15 = null;
            final String str16 = null;
            switch (action.hashCode()) {
                case -2122006314:
                    if (action.equals("minibox_client_plugin_binder_died")) {
                        f344586a.s(params);
                        return;
                    }
                    return;
                case -1943105207:
                    if (action.equals("action_letsgo_redinfo")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("key_host_info_letsgo_redinfo", ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).getLetsGoRedInfo());
                        Unit unit = Unit.INSTANCE;
                        eipcModule.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                        return;
                    }
                    return;
                case -1871315600:
                    if (action.equals("minibox_show_toast")) {
                        f344586a.A(params);
                        return;
                    }
                    return;
                case -1555485716:
                    if (!action.equals("minibox_call_mc")) {
                        return;
                    }
                    break;
                case -1514769591:
                    if (action.equals("minibox_mc_channel_ready")) {
                        isChannelReady = true;
                        return;
                    }
                    return;
                case -1200531082:
                    if (action.equals("action_get_login_info")) {
                        if (params != null) {
                            bool = Boolean.valueOf(params.getBoolean("key_force_update"));
                        } else {
                            bool = null;
                        }
                        if (params != null) {
                            str10 = params.getString(GameCenterReceiver.KEY_PKG_NAME);
                        }
                        if (str10 != null) {
                            IMiniGameVALoginApi iMiniGameVALoginApi = (IMiniGameVALoginApi) QRoute.api(IMiniGameVALoginApi.class);
                            if (bool != null) {
                                z17 = bool.booleanValue();
                            }
                            iMiniGameVALoginApi.getLoginInfo(str10, z17, new Function1<GameLoginInfo, Unit>() { // from class: com.tencent.qq.minibox.proxy.MiniBoxHostEventProcessor$handleMiniBoxHostEvent$1$4$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(GameLoginInfo gameLoginInfo) {
                                    invoke2(gameLoginInfo);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@Nullable GameLoginInfo gameLoginInfo) {
                                    if (gameLoginInfo != null) {
                                        EIPCModule eIPCModule = EIPCModule.this;
                                        int i17 = callbackId;
                                        QLog.d("MiniBoxHostEventProcess", 2, "getLoginInfo gameLoginInfo:" + gameLoginInfo);
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putString("key_access_token", gameLoginInfo.accessToken);
                                        bundle2.putString("key_pay_token", gameLoginInfo.payToken);
                                        bundle2.putString("key_open_id", gameLoginInfo.openId);
                                        bundle2.putString("key_app_id", gameLoginInfo.appId);
                                        eIPCModule.callbackResult(i17, EIPCResult.createResult(0, bundle2));
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                case -537862249:
                    if (action.equals("minibox_app_background")) {
                        f344586a.k(params);
                        return;
                    }
                    return;
                case -370041947:
                    if (action.equals("action_start_yun_game")) {
                        if (params != null) {
                            str = params.getString(PushClientConstants.TAG_PKG_NAME);
                        } else {
                            str = null;
                        }
                        if (params != null) {
                            bool2 = Boolean.valueOf(params.getBoolean("deleteVaApp"));
                        } else {
                            bool2 = null;
                        }
                        if (params != null) {
                            str16 = params.getString("currentVersionName");
                        }
                        if (params != null) {
                            i16 = params.getInt("launchDelay", 0);
                        }
                        QLog.i("MiniBoxHostEventProcess", 1, "ACTION_START_YUN_GAME pkgName:" + str + " deleteVaApp:" + bool2 + " launchDelay:" + i16);
                        if (i16 > 0) {
                            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qq.minibox.proxy.j
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MiniBoxHostEventProcessor.r(bool2, str, str16);
                                }
                            }, 16, null, false, i16);
                            return;
                        } else {
                            f344586a.B(bool2, str, str16);
                            return;
                        }
                    }
                    return;
                case -95286592:
                    if (action.equals("minibox_get_resolution")) {
                        if (params != null) {
                            str15 = params.getString("minibox_client_key_resolution", null);
                        }
                        if (str15 == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(str15, "params?.getString(Common\u2026SOLUTION, null) ?: return");
                        HippyMap hippyMap = new HippyMap();
                        hippyMap.pushString("resolution", str15);
                        ConcurrentHashMap<String, Promise> concurrentHashMap = actionToPromiseMap;
                        synchronized (concurrentHashMap) {
                            Promise remove = concurrentHashMap.remove(action);
                            if (remove == null) {
                                return;
                            }
                            Intrinsics.checkNotNullExpressionValue(remove, "actionToPromiseMap.remove(action) ?: return");
                            remove.resolve(hippyMap);
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                    }
                    return;
                case 50351512:
                    if (action.equals("action_game_report")) {
                        if (params != null) {
                            str2 = params.getString(PushClientConstants.TAG_PKG_NAME);
                        } else {
                            str2 = null;
                        }
                        if (params != null) {
                            str3 = params.getString("appId");
                        } else {
                            str3 = null;
                        }
                        if (params != null) {
                            str4 = params.getString("reportName");
                        } else {
                            str4 = null;
                        }
                        if (TextUtils.isEmpty(str4)) {
                            QLog.i("MiniBoxHostEventProcess", 1, "ACTION_GAME_REPORT reportName is empty, params:" + params);
                            return;
                        }
                        if (params != null) {
                            str5 = params.getString("currentVersionName");
                        } else {
                            str5 = null;
                        }
                        if (params != null) {
                            str6 = params.getString("reportData");
                        } else {
                            str6 = null;
                        }
                        QLog.i("MiniBoxHostEventProcess", 1, "ACTION_GAME_REPORT pkgName:" + str2 + " appId:" + str3 + " reportName:" + str4);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.proxy.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                MiniBoxHostEventProcessor.p(str3, str2, str5, str4, str6);
                            }
                        }, 128, null, false);
                        return;
                    }
                    return;
                case 133149874:
                    if (action.equals("action_va_not_available")) {
                        if (params != null) {
                            serializable = params.getSerializable("key_crash_detail");
                        } else {
                            serializable = null;
                        }
                        if (serializable instanceof MiniBoxExceptionDetail) {
                            miniBoxExceptionDetail = (MiniBoxExceptionDetail) serializable;
                        }
                        if (miniBoxExceptionDetail == null) {
                            QLog.e("MiniBoxHostEventProcess", 1, "handle " + action + " but detail is null");
                            return;
                        }
                        ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).checkIsAvailableCrash(miniBoxExceptionDetail.getSliceCrashStack());
                        QLog.i("MiniBoxHostEventProcess", 1, "reportCrashDetail detail:" + miniBoxExceptionDetail);
                        qs3.c.f429464a.d(new rs3.j(miniBoxExceptionDetail), new c(action));
                        return;
                    }
                    return;
                case 140378908:
                    if (!action.equals("minibox_call_mc_with_observer")) {
                        return;
                    }
                    break;
                case 284612837:
                    if (action.equals("CLIENT_ACTION_SHARE_ARK")) {
                        if (params != null) {
                            str8 = params.getString("KEY_SHARE_ARK_ORIGIN_SCHEMA");
                        } else {
                            str8 = null;
                        }
                        if (params != null) {
                            str13 = params.getString("KEY_SHARE_ARK_ORIGIN_PKG");
                        }
                        f344586a.t(str13, str8, eipcModule, callbackId);
                        return;
                    }
                    return;
                case 669262663:
                    if (action.equals("minibox_download_and_install")) {
                        f344586a.j(params);
                        return;
                    }
                    return;
                case 878568296:
                    if (action.equals("action_restart_app")) {
                        if (params != null) {
                            str9 = params.getString(PushClientConstants.TAG_PKG_NAME);
                        } else {
                            str9 = null;
                        }
                        if (params != null) {
                            str12 = params.getString("currentVersionName");
                        }
                        if (params != null) {
                            i3 = params.getInt("launchDelay", 0);
                        } else {
                            i3 = 0;
                        }
                        QLog.i("MiniBoxHostEventProcess", 1, "ACTION_RESTART_APP pkgName:" + str9 + " launchDelay:" + i3);
                        if (i3 > 0) {
                            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qq.minibox.proxy.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MiniBoxHostEventProcessor.q(str9, str12);
                                }
                            }, 16, null, false, i3);
                            return;
                        } else {
                            ((IMiniGameVALaunchApi) QRoute.api(IMiniGameVALaunchApi.class)).restartApp(str9);
                            ((IMiniGameVALaunchApi) QRoute.api(IMiniGameVALaunchApi.class)).reportDc87(0, str9, str12, "");
                            return;
                        }
                    }
                    return;
                case 1875001505:
                    if (action.equals("mimibox_get_user_time_info")) {
                        if (params != null) {
                            str11 = params.getString("minibox_client_key_user_time_info", null);
                        }
                        if (str11 == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(str11, "params?.getString(Common\u2026IME_INFO, null) ?: return");
                        JSONObject jSONObject = new JSONObject(str11);
                        boolean optBoolean = jSONObject.optBoolean("isBindOpenid");
                        boolean optBoolean2 = jSONObject.optBoolean("isOpenVip");
                        int optInt = jSONObject.optInt("leftFreeTime");
                        int optInt2 = jSONObject.optInt("leftGiftTime");
                        int optInt3 = jSONObject.optInt("totalLeftTime");
                        HippyMap hippyMap2 = new HippyMap();
                        hippyMap2.pushBoolean("isBindOpenid", optBoolean);
                        hippyMap2.pushBoolean("isOpenVip", optBoolean2);
                        hippyMap2.pushInt("leftFreeTime", optInt);
                        hippyMap2.pushInt("leftGiftTime", optInt2);
                        hippyMap2.pushInt("totalLeftTime", optInt3);
                        ConcurrentHashMap<String, Promise> concurrentHashMap2 = actionToPromiseMap;
                        synchronized (concurrentHashMap2) {
                            Promise remove2 = concurrentHashMap2.remove(action);
                            if (remove2 == null) {
                                return;
                            }
                            Intrinsics.checkNotNullExpressionValue(remove2, "actionToPromiseMap.remove(action) ?: return");
                            remove2.resolve(hippyMap2);
                            Unit unit3 = Unit.INSTANCE;
                            return;
                        }
                    }
                    return;
                case 1989590060:
                    if (action.equals("com.tencent.mobileqq.ACTION_VA_IPC_HANDLE")) {
                        f344586a.u(params);
                        return;
                    }
                    return;
                case 1999974388:
                    if (action.equals("mimibox_game_queue_callback")) {
                        f344586a.l(params);
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (params != null) {
                str7 = params.getString("minibox_client_key_common_call_api", null);
            } else {
                str7 = null;
            }
            if (params != null) {
                str14 = params.getString("minibox_client_key_common_call_callback_result", null);
            }
            LogUtils.d("MiniBoxHostEventProcess", "call mc callback api:" + str7 + " result:" + str14);
            HippyMap hippyMap3 = new HippyMap();
            hippyMap3.pushInt("code", 0);
            if (str14 != null && str14.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                hippyMap3.pushString("result", str14);
            }
            ConcurrentHashMap<String, Promise> concurrentHashMap3 = actionToPromiseMap;
            synchronized (concurrentHashMap3) {
                Promise promise = (Promise) TypeIntrinsics.asMutableMap(concurrentHashMap3).remove(str7);
                if (promise == null) {
                    return;
                }
                promise.resolve(hippyMap3);
                Unit unit4 = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String str, String str2, String str3, String str4, String str5) {
        f344586a.m(str, str2, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String str, String str2) {
        ((IMiniGameVALaunchApi) QRoute.api(IMiniGameVALaunchApi.class)).restartApp(str);
        ((IMiniGameVALaunchApi) QRoute.api(IMiniGameVALaunchApi.class)).reportDc87(0, str, str2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Boolean bool, String str, String str2) {
        f344586a.B(bool, str, str2);
    }

    private final void s(Bundle params) {
        boolean z16;
        String str;
        Set<a> processListeners2 = processListeners;
        Intrinsics.checkNotNullExpressionValue(processListeners2, "processListeners");
        synchronized (processListeners2) {
            Iterator<a> it = processListeners.iterator();
            while (it.hasNext()) {
                it.next().Dd();
            }
            Unit unit = Unit.INSTANCE;
        }
        String str2 = currentWaitingGameAppId;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (params != null) {
            str = params.getString("minibox_appid", null);
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        String string = params.getString("mini_box_icon", null);
        String string2 = params.getString("mini_box_game_name", "\u4e91\u6e38\u620f");
        QLog.d("MiniBoxHostEventProcess", 2, "handlePluginBinderDied appId:" + str + " iconUrl:" + string + " gameName:" + string2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u4f60\u7684");
        sb5.append(string2);
        sb5.append("\u540e\u53f0\u6392\u961f\u7531\u4e8e\u5185\u5b58\u7ba1\u63a7\u88ab\u4e2d\u65ad\uff0c\u8bf7\u91cd\u65b0\u6392\u961f");
        y(str, string, sb5.toString(), true);
        currentWaitingGameAppId = null;
    }

    private final void t(String pkgName, String schema, EIPCModule eipcModule, int callbackId) {
        String str;
        IArkShareForMiniBoxApi iArkShareForMiniBoxApi = (IArkShareForMiniBoxApi) QRoute.api(IArkShareForMiniBoxApi.class);
        if (pkgName == null) {
            str = "";
        } else {
            str = pkgName;
        }
        iArkShareForMiniBoxApi.getShareMiniAppInfo(str, new MiniBoxHostEventProcessor$handleShareArk$1(pkgName, schema, eipcModule, callbackId));
    }

    private final void u(Bundle params) {
        final Activity topActivity = Foreground.getTopActivity();
        if (params == null) {
            v();
            return;
        }
        final String string = params.getString("keyVaIPCParams");
        if (string == null) {
            v();
        } else {
            Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
            new MiniBoxHostAction(topActivity, string, new CallHostCallback() { // from class: com.tencent.qq.minibox.proxy.MiniBoxHostEventProcessor$handleVAIPC$miniBoxHostAction$1
                @Override // com.tencent.minibox.proxy.CallHostCallback
                public void response(@NotNull String params2) {
                    Intrinsics.checkNotNullParameter(params2, "params");
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mobileqq.ACTION_VA_TRANSPARENT_HANDLE");
                    intent.putExtra("va_response", string);
                    topActivity.sendBroadcast(intent);
                }
            }).f();
        }
    }

    private final void v() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.ACTION_VA_IPC_HANDLE_ACT_NULL");
        BaseApplication.context.sendBroadcast(intent);
    }

    private final void y(String appId, String icon, String text, boolean callRefresh) {
        g(appId);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniBoxNoticeService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ssConstant.MAIN\n        )");
        MiniBoxNoticeInfo miniBoxNoticeInfo = new MiniBoxNoticeInfo();
        miniBoxNoticeInfo.appId = appId;
        miniBoxNoticeInfo.iconUrl = icon;
        miniBoxNoticeInfo.title = text;
        miniBoxNoticeInfo.startTime = System.currentTimeMillis();
        miniBoxNoticeInfo.notifyStatus = 2;
        ((IMiniBoxNoticeService) runtimeService).addGameWaitingNotice(miniBoxNoticeInfo);
        if (callRefresh) {
            Bundle bundle = new Bundle();
            bundle.putString("appid", appId);
            bundle.putString(MiniBoxNoticeInfo.KEY_ICON_URL, icon);
            bundle.putString("tips", text);
            Message message = new Message();
            message.what = 1134071;
            message.obj = bundle;
            BannerManager.l().O(com.tencent.mobileqq.banner.d.L, 2, message);
        }
    }

    static /* synthetic */ void z(MiniBoxHostEventProcessor miniBoxHostEventProcessor, String str, String str2, String str3, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        miniBoxHostEventProcessor.y(str, str2, str3, z16);
    }

    public final void e(@NotNull String action, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ConcurrentHashMap<String, Promise> concurrentHashMap = actionToPromiseMap;
        synchronized (concurrentHashMap) {
            concurrentHashMap.put(action, promise);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void f(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<a> processListeners2 = processListeners;
        Intrinsics.checkNotNullExpressionValue(processListeners2, "processListeners");
        synchronized (processListeners2) {
            processListeners.add(listener);
        }
    }

    public final void i() {
        ConcurrentHashMap<String, Promise> concurrentHashMap = actionToPromiseMap;
        synchronized (concurrentHashMap) {
            concurrentHashMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean w() {
        return isChannelReady;
    }

    public final void x(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<a> processListeners2 = processListeners;
        Intrinsics.checkNotNullExpressionValue(processListeners2, "processListeners");
        synchronized (processListeners2) {
            processListeners.remove(listener);
        }
    }
}
