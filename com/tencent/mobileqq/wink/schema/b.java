package com.tencent.mobileqq.wink.schema;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import r93.h;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, x93.a> f326298a;

    static {
        HashMap hashMap = new HashMap();
        f326298a = hashMap;
        hashMap.put(QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH, new x93.c());
    }

    private static void a(Context context, WinkSchemeBean winkSchemeBean, @Nullable Bundle bundle) {
        x93.a aVar;
        String schemeAction = winkSchemeBean.getSchemeAction();
        QLog.d("QCircleLauncher", 1, "launchWinkByScheme actionName" + schemeAction);
        if (TextUtils.isEmpty(schemeAction) || (aVar = f326298a.get(schemeAction)) == null) {
            return;
        }
        aVar.a(context, winkSchemeBean, bundle);
    }

    public static void b(Context context, WinkSchemeBean winkSchemeBean, @Nullable Bundle bundle) {
        if (c(winkSchemeBean, bundle)) {
            QQToast.makeText(context, context.getResources().getString(R.string.f185153nt), 0).show();
            QLog.e("QCircleLauncher", 1, "not start is study mode");
        } else {
            a(context, winkSchemeBean, bundle);
        }
    }

    private static boolean c(WinkSchemeBean winkSchemeBean, Bundle bundle) {
        if (bundle != null && h.f430993a.h(bundle)) {
            return false;
        }
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && (winkSchemeBean.getAttrs() == null || !"1".equals(winkSchemeBean.getAttrs().get("childmode")))) {
            return false;
        }
        return true;
    }
}
