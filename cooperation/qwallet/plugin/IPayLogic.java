package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppRuntime;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IPayLogic extends QRouteApi {
    public static final String DEFAULT_PF_PREF = "qq_m_qq-";
    public static final String MINIAPP_PF_PREF = "qqapp_qq-";
    public static final String RECEIVER_COM_KEY = "_qwallet_payresult_receiver";
    public static final String RECEIVER_LOGIC_LAYER_KEY = "receiver";
    public static final String TAG = "Q.qwallet.pay.PayLogic";

    void doOnRestoreInstanceState(Bundle bundle);

    void doOnSaveInstanceState(Bundle bundle);

    void end();

    void exec();

    IPayLogic getLogic(int i3);

    int getTag();

    boolean init(Intent intent, AppRuntime appRuntime, Activity activity);

    boolean isPaying();

    Bundle newPay(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, int i3, Bundle bundle);

    void onActivityResult(int i3, int i16, Intent intent);

    @Deprecated
    void onDestroy();

    void onEndFinished();

    boolean tryDoOnActivityResult(Activity activity);
}
