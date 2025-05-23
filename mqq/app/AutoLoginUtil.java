package mqq.app;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lmqq/app/AutoLoginUtil;", "", "()V", "KEY_AUTO_LOGIN", "", "LOGIN_AUTO", "", "LOGIN_MANUAL", "LOGIN_UNINIT", "TAG", "canAutoLogin", "", "uin", "setAutoLogin", "", "auto", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class AutoLoginUtil {

    @NotNull
    public static final AutoLoginUtil INSTANCE = new AutoLoginUtil();

    @NotNull
    private static final String KEY_AUTO_LOGIN = "mqq_account_auto_login_";
    private static final int LOGIN_AUTO = 2;
    private static final int LOGIN_MANUAL = 1;
    private static final int LOGIN_UNINIT = 0;

    @NotNull
    private static final String TAG = "AutoLoginUtil";

    AutoLoginUtil() {
    }

    @JvmStatic
    public static final boolean canAutoLogin(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, MobileQQ.FILE_COMMON)");
        int i3 = fromV2.getInt(KEY_AUTO_LOGIN + uin, 0);
        if (i3 == 0) {
            boolean canAutoLoginFromCache = AppRuntime.canAutoLoginFromCache(BaseApplication.context, uin);
            QLog.i(TAG, 1, "canAutoLoginFromSP " + canAutoLoginFromCache);
            setAutoLogin(uin, canAutoLoginFromCache);
            return canAutoLoginFromCache;
        }
        if (i3 != 2) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void setAutoLogin(@NotNull String uin, boolean auto) {
        int i3;
        Intrinsics.checkNotNullParameter(uin, "uin");
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, MobileQQ.FILE_COMMON)");
        String str = KEY_AUTO_LOGIN + uin;
        if (auto) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        fromV2.putInt(str, i3);
        QLog.i(TAG, 1, "setAutoLogin uin:" + MsfSdkUtils.getShortUin(uin) + " auto:" + auto);
    }
}
