package com.tencent.gdtad.inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.impl.c;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class GdtWebViewProxy {
    public static final String TAG = "GdtWebViewProxy";

    @NonNull
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAdApi/Inject_AdInject.yml", version = 1)
    public static ArrayList<Class<? extends IGdtWebView>> gdtWebViewClasses;

    static {
        ArrayList<Class<? extends IGdtWebView>> arrayList = new ArrayList<>();
        gdtWebViewClasses = arrayList;
        arrayList.add(c.class);
    }

    @Nullable
    public IGdtWebView createGdtWebView() {
        if (!gdtWebViewClasses.isEmpty()) {
            try {
                return gdtWebViewClasses.get(0).newInstance();
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                QLog.i(TAG, 1, "createGdtWebView size = " + gdtWebViewClasses.size());
                return null;
            }
        }
        QLog.i(TAG, 1, "createGdtWebView is empty ");
        return null;
    }
}
