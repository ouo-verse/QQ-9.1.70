package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.ArrayUtils;

/* loaded from: classes28.dex */
public abstract class QWalletPayBridge {

    @Deprecated
    private static final Integer[] MIDAS_INVOKE_LIST = {7, 1, 2, 3, 10, 4, 6, 8, 16, 11, 14, 17};
    public static final String TAG = "Q.qwallet.pay.QWalletPayBridge";

    /* loaded from: classes28.dex */
    public static abstract class Key {
        public static final String LAUNCH_TYPE = "launch_type";
        public static final String PAY_INVOKER_ID = "PayInvokerId";
    }

    /* loaded from: classes28.dex */
    public static abstract class LaunchType {
        public static final int BACKGROUND_REQ_DATA = 1;
        public static final int FOREGROUND_PAY = 0;
    }

    /* loaded from: classes28.dex */
    public static abstract class PayInvokerId {
        public static final int PAY_INVOKER_ACTIVITY_JUMP = 13;
        public static final int PAY_INVOKER_BUY_GOODS = 7;
        public static final int PAY_INVOKER_DATA_TENWACTH = 15;
        public static final int PAY_INVOKER_EMOJIMALL_PAY = 1;
        public static final int PAY_INVOKER_GET_QB_RECORD = 16;
        public static final int PAY_INVOKER_GOLD_CHARGE = 2;
        public static final int PAY_INVOKER_LAUNCH_WECHAT = 17;
        public static final int PAY_INVOKER_OPEN_PAY = 24;
        public static final int PAY_INVOKER_OPEN_QQREADER_VIP = 3;
        public static final int PAY_INVOKER_OPEN_QZONE_VIP = 10;
        public static final int PAY_INVOKER_OPEN_SERVICE = 4;
        public static final int PAY_INVOKER_OPEN_SVIP = 11;
        public static final int PAY_INVOKER_OPEN_TENPAY_VIEW = 5;
        public static final int PAY_INVOKER_PAY = 9;
        public static final int PAY_INVOKER_PAY_DATA = 22;
        public static final int PAY_INVOKER_PREGET_QRCODE = 23;
        public static final int PAY_INVOKER_PRE_CONNECT = 21;
        public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
        public static final int PAY_INVOKER_RECHARGE_QB = 8;
        public static final int PAY_INVOKER_SUBSCRIBE_MONTH_CARD = 14;
        public static final int PAY_INVOKER_WEBANK_CHECK = 12;
        public static final int PAY_INVOKER_WX_NATIVE_PAY = 25;
    }

    /* loaded from: classes28.dex */
    public static abstract class PayResult {
        public static final int PAY_REQUEST_CODE = 3001;
        public static final int PAY_RESULT_ERROR_PARAMS = 2;
        public static final String PAY_RESULT_EXTRA_KEY = "QWalletPayBridge.PayResult.ExtraKey";
        public static final int PAY_RESULT_OK = 1;
    }

    /* loaded from: classes28.dex */
    public static abstract class PayRetCode {
        public static final int ERR_CODE_GET_SKEY_FAIL = -97;
        public static final int ERR_CODE_NULL_ACTIVITY = -94;
        public static final int ERR_CODE_PARSE_PARAM_BUNDLE_NULL = -95;
        public static final int ERR_CODE_PARSE_PARAM_INTENT_NULL = -96;
        public static final int ERR_CODE_SUCC = 0;
    }

    public static boolean isMidasInvokerId(int i3) {
        return ArrayUtils.contains(MIDAS_INVOKE_LIST, Integer.valueOf(i3));
    }

    public static boolean isPayInvokeId(int i3) {
        if (i3 != 9 && i3 != 24) {
            return false;
        }
        return true;
    }

    public static boolean launchBackground(Context context, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("launch_type", 1);
        }
        return ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).launchPlugin(context, bundle);
    }

    public static boolean launchForeground(Activity activity, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("launch_type", 0);
        }
        return ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).launchPlugin(activity, bundle);
    }
}
