package cooperation.qwallet.pluginshare;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface ITenCookie extends QRouteApi {
    public static final String QB_TENPAY_HB_SP_NAME = "qb_tenpay_h5_common_hb_";

    boolean clearTempArgs(String str);

    String getEncryptValue(String str, String str2, SharedPreferences sharedPreferences);

    String getMsgNo(String str);

    String getTempArgs(String str);

    String putEncryptValue(String str, String str2, SharedPreferences sharedPreferences, String str3);

    String readTagCookie(Context context, String str, String str2);

    String setTempArgs(String str, String str2);

    boolean setUin(String str);

    void writeTagCookie(Context context, String str, List<String> list);
}
