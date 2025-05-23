package com.tencent.mobileqq.zootopia.qav;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.avcore.jni.NtrtcAudioWwise;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.lua.ai;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV;", "", "a", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanAVControllerForQAV {

    /* renamed from: b, reason: collision with root package name */
    private static QQPermission f328979b;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f328981d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f328982e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f328983f;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f328986i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f328987j;

    /* renamed from: k, reason: collision with root package name */
    private static Companion.ScreenActionReceiver f328988k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f328989l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f328990m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f328991n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final BusinessConfig f328980c = new BusinessConfig(QQPermissionConstants.Business.ID.ZPLAN_GAME, QQPermissionConstants.Business.SCENE.ZPLAN_AUDIO_CALL);

    /* renamed from: g, reason: collision with root package name */
    private static String f328984g = "";

    /* renamed from: h, reason: collision with root package name */
    private static String f328985h = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001SB\t\b\u0002\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0016\u0010!\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\tR$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00105\u001a\u0004\b>\u00107\"\u0004\b?\u00109R\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00105\u001a\u0004\bA\u00107\"\u0004\bB\u00109R\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00105\u001a\u0004\bD\u00107\"\u0004\bE\u00109R\u0014\u0010F\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010/R\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00105R\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00105R\u0016\u0010L\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00105R\u0016\u0010M\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010/R\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion;", "", "", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "I", ReportConstant.COSTREPORT_PREFIX, "g", "r", "", "w", "J", "", "status", "isSmallHome", "v", "", IProfileProtocolConst.PARAM_TARGET_UIN, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "H", "b", "a", "y", HippyTKDListViewAdapter.X, "visitUin", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "f", "d", "K", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "listener", "e", "enable", tl.h.F, VirtualAppProxy.KEY_GAME_ID, "t", "p", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "gQQPermission", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "o", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "G", "(Lcom/tencent/mobileqq/qqpermission/QQPermission;)V", "currentCallerUin", "Ljava/lang/String;", "i", "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "gIsBackToAVActivity", "Z", "l", "()Z", "D", "(Z)V", "gNeedToRestoreGameMode", DomainData.DOMAIN_NAME, UserInfo.SEX_FEMALE, "gNeedToHideFloatView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "gDelayToNotifyMapExit", "j", "B", "gDelayToNotifyMapExitIsFromSmallHome", "k", BdhLogUtil.LogTag.Tag_Conn, "TAG", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "gConfig", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "gIsWwisePorxyBinded", "gIsWwiseProxyInited", "gIsWwiseProxyLoadSuc", "gLastVideoAction", "Lcom/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$ScreenActionReceiver;", "gScreenActionReceiver", "Lcom/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$ScreenActionReceiver;", "<init>", "()V", "ScreenActionReceiver", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$ScreenActionReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class ScreenActionReceiver extends BroadcastReceiver {
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                boolean equals;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -2128145023:
                            if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                                int intExtra = intent.getIntExtra("why", 0);
                                ZplanAVControllerForQAV.INSTANCE.E(true);
                                QLog.d("ZplanAVControllerForQAV", 1, "ACTION_SCREEN_OFF, why[" + intExtra + "]");
                                return;
                            }
                            return;
                        case -1454123155:
                            if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                                QLog.d("ZplanAVControllerForQAV", 1, "ACTION_SCREEN_ON");
                                return;
                            }
                            return;
                        case -403228793:
                            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                                String stringExtra = intent.getStringExtra("reason");
                                QLog.d("ZplanAVControllerForQAV", 1, "ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + stringExtra + "]");
                                equals = StringsKt__StringsJVMKt.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY, stringExtra, true);
                                if (equals) {
                                    ZplanAVControllerForQAV.INSTANCE.E(true);
                                    QLog.d("ZplanAVControllerForQAV", 1, "SYSTEM_HOME_KEY, switch to normal mode");
                                    return;
                                }
                                return;
                            }
                            return;
                        case 823795052:
                            if (action.equals("android.intent.action.USER_PRESENT")) {
                                QLog.d("ZplanAVControllerForQAV", 1, "ACTION_USER_PRESENT");
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$e", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class e extends QQPermission.BasePermissionsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f328993a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f328994b;

            e(Activity activity, String str) {
                this.f328993a = activity;
                this.f328994b = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(String targetUin, Activity activity) {
                Intrinsics.checkNotNullParameter(targetUin, "$targetUin");
                Intrinsics.checkNotNullParameter(activity, "$activity");
                ZplanAVControllerForQAV.INSTANCE.H(targetUin, activity);
                ai.INSTANCE.m(0);
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                QLog.i("ZplanAVControllerForQAV", 1, "request Audio permission result is Granted");
                super.onAllGranted();
                final Activity activity = this.f328993a;
                final String str = this.f328994b;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZplanAVControllerForQAV.Companion.e.b(str, activity);
                    }
                });
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(List<String> permissions, List<Integer> results) {
                QLog.i("ZplanAVControllerForQAV", 1, "request audio permission result is Denied");
                super.onDenied(permissions, results);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean I() {
            if (ZplanAVControllerForQAV.f328982e) {
                ZplanAVControllerForQAV.f328982e = false;
                QLog.e("ZplanAVControllerForQAV", 1, "uninit NtrtcAudioWwise suc.");
                NtrtcAudioWwise.getInstance().uninit();
                NtrtcAudioWwise.destroyInstance();
                return true;
            }
            QLog.e("ZplanAVControllerForQAV", 1, "uninit NtrtcAudioWwise failed.");
            return false;
        }

        private final boolean g() {
            if (ZplanAVControllerForQAV.f328981d) {
                return true;
            }
            return u();
        }

        private final boolean q() {
            if (!g()) {
                return false;
            }
            try {
                ZplanAVControllerForQAV.f328982e = NtrtcAudioWwise.getInstance().init();
            } catch (UnsatisfiedLinkError e16) {
                ZplanAVControllerForQAV.f328982e = false;
                QLog.e("ZplanAVControllerForQAV", 1, "initWwiseProxy failed excetion:" + e16);
            }
            if (!ZplanAVControllerForQAV.f328982e) {
                QLog.e("ZplanAVControllerForQAV", 1, "initWwiseProxy failed");
            } else {
                QLog.e("ZplanAVControllerForQAV", 1, "initWwiseProxy suc.");
            }
            return ZplanAVControllerForQAV.f328982e;
        }

        private final boolean r() {
            if (o() != null) {
                QQPermission o16 = o();
                Intrinsics.checkNotNull(o16);
                if (o16.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
                    return true;
                }
            }
            return false;
        }

        private final boolean s() {
            if (g()) {
                return NtrtcAudioWwise.getInstance().isWwiseAudioPluginBound();
            }
            return false;
        }

        private final boolean u() {
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            AVSoUtils.g(-1057L);
            boolean z16 = false;
            if (SoLoadUtil.m(context, "c++_shared", 0, false) && SoLoadUtil.m(context, "xplatform", 0, false) && SoLoadUtil.m(context, "wwise_rtc_proxy", 0, false)) {
                z16 = true;
            }
            ZplanAVControllerForQAV.f328981d = z16;
            if (!ZplanAVControllerForQAV.f328981d) {
                QLog.e("ZplanAVControllerForQAV", 1, "loadWwiseRtcProxyLib failed");
            } else {
                QLog.e("ZplanAVControllerForQAV", 1, "loadWwiseRtcProxyLib suc");
            }
            return ZplanAVControllerForQAV.f328981d;
        }

        public final void A(String str) {
            ZplanAVControllerForQAV.f328985h = str;
        }

        public final void B(boolean z16) {
            ZplanAVControllerForQAV.f328990m = z16;
        }

        public final void C(boolean z16) {
            ZplanAVControllerForQAV.f328991n = z16;
        }

        public final void D(boolean z16) {
            ZplanAVControllerForQAV.f328986i = z16;
        }

        public final void E(boolean z16) {
            ZplanAVControllerForQAV.f328989l = z16;
        }

        public final void F(boolean z16) {
            ZplanAVControllerForQAV.f328987j = z16;
        }

        public final void G(QQPermission qQPermission) {
            ZplanAVControllerForQAV.f328979b = qQPermission;
        }

        public final boolean H(String targetUin, Activity activity) {
            Intrinsics.checkNotNullParameter(targetUin, "targetUin");
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!e(activity, new e(activity, targetUin))) {
                return false;
            }
            if (!f()) {
                QLog.e("ZplanAVControllerForQAV", 1, "startQAudio failed");
                return false;
            }
            QLog.e("ZplanAVControllerForQAV", 1, "startQAudio suc.");
            Bundle bundle = new Bundle();
            bundle.putString("target_uin", targetUin);
            w();
            com.tencent.av.zplan.c.m("tencent.video.z2v.start_qq_audio_call", bundle, null);
            ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.start_qq_audio_call";
            return true;
        }

        public final void J() {
            if (com.tencent.av.zplan.c.l()) {
                com.tencent.av.zplan.c.p(BaseApplication.context);
            }
        }

        public final boolean K() {
            if (ZplanAVControllerForQAV.f328983f || s()) {
                ZplanAVControllerForQAV.f328983f = false;
                QLog.e("ZplanAVControllerForQAV", 1, "WwisePorxy unBind suc.", new Throwable("\u6253\u5370\u5806\u6808"));
                NtrtcAudioWwise.getInstance().unbindWwiseAudioPlugin();
                return true;
            }
            QLog.e("ZplanAVControllerForQAV", 1, "WwisePorxy unBind failed.");
            return false;
        }

        public final boolean a() {
            if (!f()) {
                QLog.e("ZplanAVControllerForQAV", 1, "acceptGAudio failed");
                return false;
            }
            MultiVoiceChatController.INSTANCE.a().o(4);
            if (QLog.isColorLevel()) {
                QLog.i("ZplanAVControllerForQAV", 2, "acceptGAudio called");
            }
            w();
            ai.INSTANCE.m(0);
            com.tencent.av.zplan.c.m("tencent.video.z2v.accept_gaudio_call", null, null);
            ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.accept_gaudio_call";
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if ((peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null) != null) {
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new a());
            }
            return true;
        }

        public final boolean b() {
            if (!f()) {
                QLog.e("ZplanAVControllerForQAV", 1, "startQAudio failed");
                return false;
            }
            MultiVoiceChatController.INSTANCE.a().o(4);
            if (QLog.isColorLevel()) {
                QLog.i("ZplanAVControllerForQAV", 2, "acceptQAudio called");
            }
            w();
            ai.INSTANCE.m(0);
            com.tencent.av.zplan.c.m("tencent.video.z2v.accept_audio_call", null, null);
            ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.accept_audio_call";
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if ((peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null) != null) {
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new b());
            }
            return true;
        }

        public final void c(String visitUin) {
            Intrinsics.checkNotNullParameter(visitUin, "visitUin");
            if (QLog.isColorLevel()) {
                QLog.i("ZplanAVControllerForQAV", 2, "backToActivity called and visitUin: " + visitUin);
            }
            w();
            Bundle bundle = new Bundle();
            bundle.putString("visitUin", visitUin);
            com.tencent.av.zplan.c.m("tencent.video.z2v.back_to_audio", bundle, null);
            ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.back_to_audio";
            D(true);
        }

        public final boolean d() {
            if (!g() && s()) {
                return false;
            }
            ZplanAVControllerForQAV.f328983f = NtrtcAudioWwise.getInstance().bindWwiseAudioPlugin();
            if (!ZplanAVControllerForQAV.f328983f) {
                QLog.e("ZplanAVControllerForQAV", 1, "WwisePorxyBind failed");
            } else {
                QLog.e("ZplanAVControllerForQAV", 1, "WwisePorxyBind suc.");
            }
            return ZplanAVControllerForQAV.f328983f;
        }

        public final boolean e(Activity activity, QQPermission.BasePermissionsListener listener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (o() == null) {
                G(QQPermissionFactory.getQQPermission(activity, ZplanAVControllerForQAV.f328980c));
            }
            if (r()) {
                return true;
            }
            String[] strArr = {QQPermissionConstants.Permission.RECORD_AUDIO};
            QQPermission o16 = o();
            if (o16 == null) {
                return false;
            }
            o16.requestPermissions(strArr, 2, listener);
            return false;
        }

        public final boolean f() {
            if (!ZplanAVControllerForQAV.f328982e) {
                ZplanAVControllerForQAV.f328982e = q();
            }
            if (!ZplanAVControllerForQAV.f328983f) {
                ZplanAVControllerForQAV.f328983f = d();
            }
            return ZplanAVControllerForQAV.f328982e && ZplanAVControllerForQAV.f328983f;
        }

        public final String i() {
            return ZplanAVControllerForQAV.f328985h;
        }

        public final boolean j() {
            return ZplanAVControllerForQAV.f328990m;
        }

        public final boolean k() {
            return ZplanAVControllerForQAV.f328991n;
        }

        public final boolean l() {
            return ZplanAVControllerForQAV.f328986i;
        }

        public final boolean m() {
            return ZplanAVControllerForQAV.f328989l;
        }

        public final boolean n() {
            return ZplanAVControllerForQAV.f328987j;
        }

        public final QQPermission o() {
            return ZplanAVControllerForQAV.f328979b;
        }

        public final void p() {
            if (j()) {
                B(false);
                v(0, k());
            }
        }

        public final boolean t(int gameId) {
            int[] QQ_AUDIO_CALL_SUPPORT_MAP_ID = com.tencent.mobileqq.zootopia.f.f328304a;
            Intrinsics.checkNotNullExpressionValue(QQ_AUDIO_CALL_SUPPORT_MAP_ID, "QQ_AUDIO_CALL_SUPPORT_MAP_ID");
            for (int i3 : QQ_AUDIO_CALL_SUPPORT_MAP_ID) {
                if (i3 == gameId) {
                    return true;
                }
            }
            return false;
        }

        public final void v(int status, boolean isSmallHome) {
            if (QLog.isColorLevel()) {
                QLog.i("ZplanAVControllerForQAV", 2, "notifyZPlanGameStatus status: " + status);
            }
            w();
            if (status == 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isFromZPlanSmallHomeMod", isSmallHome);
                com.tencent.av.zplan.c.m("tencent.video.z2v.exit_zplan_home", bundle, null);
                ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.exit_zplan_home";
                z();
                D(false);
                return;
            }
            if (status != 1) {
                return;
            }
            if (!Intrinsics.areEqual("tencent.video.z2v.enter_zplan_home", ZplanAVControllerForQAV.f328984g)) {
                f();
                com.tencent.av.zplan.c.m("tencent.video.z2v.enter_zplan_home", null, null);
                ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.enter_zplan_home";
            }
            D(false);
        }

        public final void w() {
            if (com.tencent.av.zplan.c.l()) {
                return;
            }
            com.tencent.av.zplan.c.n(BaseApplication.context);
        }

        public final boolean x() {
            if (!f()) {
                QLog.e("ZplanAVControllerForQAV", 1, "refuseGAudio failed");
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ZplanAVControllerForQAV", 2, "refuseGAudio called");
            }
            w();
            com.tencent.av.zplan.c.m("tencent.video.z2v.refuse_gaudio_call", null, null);
            ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.refuse_gaudio_call";
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if ((peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null) != null) {
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new c());
            }
            return true;
        }

        public final boolean y() {
            if (!f()) {
                QLog.e("ZplanAVControllerForQAV", 1, "startQAudio failed");
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ZplanAVControllerForQAV", 2, "refuseQAudio called");
            }
            w();
            com.tencent.av.zplan.c.m("tencent.video.z2v.refuse_audio_call", null, null);
            ZplanAVControllerForQAV.f328984g = "tencent.video.z2v.refuse_audio_call";
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if ((peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null) != null) {
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new d());
            }
            return true;
        }

        public final void z() {
            I();
            K();
            J();
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {
            a() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(ZootopiaOpenIdResult result) {
                a(result);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("ZplanAVControllerForQAV", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
                a(null);
            }

            private final void a(ZootopiaOpenIdResult result) {
                if (result != null) {
                    QLog.i("ZplanAVControllerForQAV", 1, "handleOpenIdResult openId " + result.getOpenId());
                    ai.INSTANCE.g(1, "", result.getOpenId());
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class b implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {
            b() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(ZootopiaOpenIdResult result) {
                a(result);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("ZplanAVControllerForQAV", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
                a(null);
            }

            private final void a(ZootopiaOpenIdResult result) {
                if (result != null) {
                    QLog.i("ZplanAVControllerForQAV", 1, "handleOpenIdResult openId " + result.getOpenId());
                    ai.INSTANCE.f(2, ZplanAVControllerForQAV.INSTANCE.i(), result.getOpenId());
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class c implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {
            c() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(ZootopiaOpenIdResult result) {
                a(result);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("ZplanAVControllerForQAV", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
                a(null);
            }

            private final void a(ZootopiaOpenIdResult result) {
                if (result != null) {
                    QLog.i("ZplanAVControllerForQAV", 1, "handleOpenIdResult openId " + result.getOpenId());
                    ai.INSTANCE.g(3, "", result.getOpenId());
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/qav/ZplanAVControllerForQAV$Companion$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class d implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {
            d() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(ZootopiaOpenIdResult result) {
                a(result);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("ZplanAVControllerForQAV", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
                a(null);
            }

            private final void a(ZootopiaOpenIdResult result) {
                if (result != null) {
                    QLog.i("ZplanAVControllerForQAV", 1, "handleOpenIdResult openId " + result.getOpenId());
                    ai.INSTANCE.f(3, ZplanAVControllerForQAV.INSTANCE.i(), result.getOpenId());
                }
            }
        }

        Companion() {
        }

        public final void h(boolean enable) {
            if (enable) {
                if (ZplanAVControllerForQAV.f328988k == null) {
                    ZplanAVControllerForQAV.f328988k = new ScreenActionReceiver();
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
                    if (appInterface != null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                        appInterface.getApp().registerReceiver(ZplanAVControllerForQAV.f328988k, intentFilter);
                        QLog.d("ZplanAVControllerForQAV", 1, "register screen action receiver suc.");
                        return;
                    }
                    return;
                }
                return;
            }
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface2 = peekAppRuntime2 instanceof AppInterface ? (AppInterface) peekAppRuntime2 : null;
            if (appInterface2 == null || ZplanAVControllerForQAV.f328988k == null) {
                return;
            }
            appInterface2.getApp().unregisterReceiver(ZplanAVControllerForQAV.f328988k);
            ZplanAVControllerForQAV.f328988k = null;
            QLog.d("ZplanAVControllerForQAV", 1, "unregister screen action receiver");
        }
    }
}
