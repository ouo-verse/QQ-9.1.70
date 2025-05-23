package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IPropertyUtils extends QRouteApi {
    String getNetworkType(Context context);

    int getScreenWidth(Activity activity);

    int getTitleBarHeight(Activity activity);

    int getToastOffset(Context context);
}
