package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class BaseResp extends BaseIpc {
    public static BaseResp getResp(Bundle bundle) {
        Class<?> loadClass;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("_qwallet_ipc_class");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            ClassLoader classLoader = BaseIpc.class.getClassLoader();
            if (classLoader == null || (loadClass = classLoader.loadClass(string)) == null) {
                return null;
            }
            BaseResp baseResp = (BaseResp) loadClass.newInstance();
            baseResp.fromBundle(bundle);
            return baseResp;
        } catch (Exception unused) {
            return null;
        }
    }
}
