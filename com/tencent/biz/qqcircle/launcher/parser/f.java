package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends a {
    private void q(Context context, QCircleSchemeBean qCircleSchemeBean) {
        if (context != null && qCircleSchemeBean != null && qCircleSchemeBean.getAttrs() != null) {
            p(context, s(qCircleSchemeBean));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r(HashMap<String, String> hashMap, QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean) {
        int parseInt;
        String str;
        String str2 = hashMap.get("transdata");
        String str3 = hashMap.get("sourcetype");
        int i3 = 0;
        if (str3 != null) {
            try {
                parseInt = Integer.parseInt(str3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            str = hashMap.get("pageid");
            if (str != null) {
                try {
                    i3 = Integer.parseInt(str);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            qCirclePolymerizeDetailBean.setTransData(str2);
            qCirclePolymerizeDetailBean.setSourceType(parseInt);
            qCirclePolymerizeDetailBean.setPageId(i3);
        }
        parseInt = 0;
        str = hashMap.get("pageid");
        if (str != null) {
        }
        qCirclePolymerizeDetailBean.setTransData(str2);
        qCirclePolymerizeDetailBean.setSourceType(parseInt);
        qCirclePolymerizeDetailBean.setPageId(i3);
    }

    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(Context context, QCircleSchemeBean qCircleSchemeBean) {
        q(context, qCircleSchemeBean);
    }

    public Intent o(Context context, QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean) {
        Intent intent = new Intent();
        intent.putExtra("key_bundle_common_init_bean", qCirclePolymerizeDetailBean);
        intent.addFlags(268435456);
        intent.setClass(context, QCircleFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleLauncherUtil.d());
        return intent;
    }

    public void p(Context context, QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean) {
        if (fb0.a.b("QCircleBaseSchemeParser_launchContentDetailPage", 500L)) {
            return;
        }
        QLog.d("QCircleBaseSchemeParser", 1, "[launchContentLayerPageByScheme]");
        QCircleLauncherUtil.o(context, o(context, qCirclePolymerizeDetailBean));
    }

    @NotNull
    public QCirclePolymerizeDetailBean s(QCircleSchemeBean qCircleSchemeBean) {
        QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean = new QCirclePolymerizeDetailBean();
        b(qCircleSchemeBean, qCirclePolymerizeDetailBean);
        i(qCirclePolymerizeDetailBean, qCircleSchemeBean.getAttrs());
        r(qCircleSchemeBean.getAttrs(), qCirclePolymerizeDetailBean);
        return qCirclePolymerizeDetailBean;
    }
}
