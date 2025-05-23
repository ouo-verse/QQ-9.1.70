package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOConfig;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.msg.api.IMsgService;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0002J@\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0006\u0010\u0019\u001a\u00020\bR\u0014\u0010\u001b\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0014\u0010 \u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010%\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/utils/CustomWithRawUtil;", "", "", "msgTime", "", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/CustomWithdrawConfig;", DownloadInfo.spKey_Config, "", "c", "oldStrategy", "b", "", "from", PanoramaConfig.KEY_CURRENT_UIN, "withDrawBegin", "withDrawEnd", "msgBegin", "msgEnd", "", "configVersion", "f", "time", "d", "e", "g", "Ljava/lang/String;", "TAG", "MSG_REVOKE_WITHDRAW_BEGIN", "MSG_REVOKE_WITHDRAW_END", "MSG_REVOKE_MSG_BEGIN", "MSG_REVOKE_MSG_END", "MSG_REVOKE_CONFIG_VERSION", "getAIO_CUSTOM_REVOKE_MSG", "()Ljava/lang/String;", "setAIO_CUSTOM_REVOKE_MSG", "(Ljava/lang/String;)V", "AIO_CUSTOM_REVOKE_MSG", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class CustomWithRawUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CustomWithRawUtil f352256a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MSG_REVOKE_WITHDRAW_BEGIN;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MSG_REVOKE_WITHDRAW_END;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MSG_REVOKE_MSG_BEGIN;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MSG_REVOKE_MSG_END;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String MSG_REVOKE_CONFIG_VERSION;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String AIO_CUSTOM_REVOKE_MSG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47931);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f352256a = new CustomWithRawUtil();
        TAG = "CustomWithRawUtil";
        MSG_REVOKE_WITHDRAW_BEGIN = "_msg_revoke_withdraw_begin";
        MSG_REVOKE_WITHDRAW_END = "_msg_revoke_withdraw_end";
        MSG_REVOKE_MSG_BEGIN = "_msg_revoke_msg_begin";
        MSG_REVOKE_MSG_END = "_msg_revoke_msg_end";
        MSG_REVOKE_CONFIG_VERSION = "_msg_revoke_config_version";
        AIO_CUSTOM_REVOKE_MSG = "aio_custom_revoke_msg";
    }

    CustomWithRawUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(long msgTime, boolean oldStrategy) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        long decodeLong = from.decodeLong(currentUin + MSG_REVOKE_WITHDRAW_BEGIN, 0L);
        long decodeLong2 = from.decodeLong(currentUin + MSG_REVOKE_WITHDRAW_END, 0L);
        long decodeLong3 = from.decodeLong(currentUin + MSG_REVOKE_MSG_BEGIN, 0L);
        long decodeLong4 = from.decodeLong(currentUin + MSG_REVOKE_MSG_END, 0L);
        f("decodeMsg", currentUin, decodeLong, decodeLong2, decodeLong3, decodeLong4, from.decodeInt(currentUin + MSG_REVOKE_CONFIG_VERSION, 0));
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = ((long) 1000) * msgTime;
        QLog.d(TAG, 1, "decodeMsg, curTime=", d(currentTimeMillis), ", msg.time=", d(j3), ", oldStrategy=", String.valueOf(oldStrategy));
        if (decodeLong != 0 && decodeLong2 != 0 && decodeLong3 != 0 && decodeLong4 != 0 && decodeLong <= currentTimeMillis && decodeLong2 >= currentTimeMillis) {
            if (decodeLong3 <= j3 && decodeLong4 >= j3) {
                return true;
            }
            return oldStrategy;
        }
        return oldStrategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(CustomWithdrawConfig config) {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        long j3 = 1000;
        long j16 = config.withdrawBegin * j3;
        long j17 = config.withdrawEnd * j3;
        long j18 = config.msgBegin * j3;
        long j19 = config.msgEnd * j3;
        int i3 = config.configVersion;
        f("encodeConfig", currentUin, j16, j17, j18, j19, i3);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong(currentUin + MSG_REVOKE_WITHDRAW_BEGIN, j16);
        from.encodeLong(currentUin + MSG_REVOKE_WITHDRAW_END, j17);
        from.encodeLong(currentUin + MSG_REVOKE_MSG_BEGIN, j18);
        from.encodeLong(currentUin + MSG_REVOKE_MSG_END, j19);
        from.encodeInt(currentUin + MSG_REVOKE_CONFIG_VERSION, i3);
    }

    private final String d(long time) {
        Date date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 E HH:mm");
        try {
            date = calendar.getTime();
        } catch (IllegalArgumentException e16) {
            QLog.d(TAG, 2, "formatTime err: ", e16);
            date = new Date();
        }
        return simpleDateFormat.format(date);
    }

    private final boolean e() {
        boolean isFeatureSwitchOn = ((IAIOConfig) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOConfig.class)).isFeatureSwitchOn(AIO_CUSTOM_REVOKE_MSG, true);
        QLog.d(TAG, 1, "isFeatureEnable: " + isFeatureSwitchOn);
        return isFeatureSwitchOn;
    }

    private final void f(String from, String currentUin, long withDrawBegin, long withDrawEnd, long msgBegin, long msgEnd, int configVersion) {
        QLog.d(TAG, 1, from, ", configVersion=", Integer.valueOf(configVersion), ", currentUin=", StringUtil.getSimpleUinForPrint(currentUin), ", withDrawBegin=", d(withDrawBegin), ", withDrawEnd=", d(withDrawEnd), ", msgBegin=", d(msgBegin), ", msgEnd=", d(msgEnd));
    }

    @JvmStatic
    public static final boolean h(long msgTime) {
        boolean z16;
        if (NetConnInfoCenter.getServerTimeMillis() - (1000 * msgTime) < 120000) {
            z16 = true;
        } else {
            z16 = false;
        }
        CustomWithRawUtil customWithRawUtil = f352256a;
        if (!customWithRawUtil.e()) {
            return z16;
        }
        return customWithRawUtil.b(msgTime, z16);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.d(TAG, 1, "registerCustomWithRawListener");
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerCustomWithdrawConfigUpdateFlow(), new CustomWithRawUtil$registerCustomWithRawListener$1(null)), Dispatchers.getIO()), CoroutineScopeKt.MainScope());
        }
    }
}
