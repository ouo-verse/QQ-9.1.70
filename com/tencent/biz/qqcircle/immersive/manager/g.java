package com.tencent.biz.qqcircle.immersive.manager;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWFastCostExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceAv1Exp;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerBusinessStrategyExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerPreRenderExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static volatile g f87226a;

    private String a(String str) {
        if (!TextUtils.isEmpty(str) && o.e()) {
            if (l(str)) {
                return str;
            }
            return b(b(b(b(b(str, "exp1", RFWVideoFluencyExp9095.getCDNValue()), "exp2", RFWFastCostExp9095.getCDNValue()), "exp3", RFWPlayerPreRenderExp9095.getCDNValue()), "exp4", RFWPlayerBusinessStrategyExp9095.getCDNValue()), "exp5", RFWLowDeviceAv1Exp.getCDNValue());
        }
        return str;
    }

    public static String b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            String str4 = ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
            if (str.contains(str4)) {
                return str;
            }
            return str + str4;
        }
        return str;
    }

    public static g e() {
        if (f87226a == null) {
            synchronized (g.class) {
                if (f87226a == null) {
                    f87226a = new g();
                }
            }
        }
        return f87226a;
    }

    private String f(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            return "";
        }
        String preloadSourceType = rFWPlayerOptions.getPreloadSourceType();
        if (!m(preloadSourceType)) {
            return preloadSourceType;
        }
        String j3 = j(rFWPlayerOptions);
        if (m(j3)) {
            return "";
        }
        return j3;
    }

    private String g(QCircleReportBean qCircleReportBean) {
        String dtCustomPagId;
        String dtFromPageId;
        String str = "";
        if (qCircleReportBean == null) {
            dtCustomPagId = "";
        } else {
            dtCustomPagId = qCircleReportBean.getDtCustomPagId();
        }
        if (qCircleReportBean == null) {
            dtFromPageId = "";
        } else {
            dtFromPageId = qCircleReportBean.getDtFromPageId();
        }
        if (qCircleReportBean != null) {
            str = qCircleReportBean.getDtPageId();
        }
        if (m(dtCustomPagId)) {
            dtCustomPagId = dtFromPageId;
        }
        if (!m(dtCustomPagId)) {
            return dtCustomPagId;
        }
        return str;
    }

    private String j(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        RFWPlayerIOC ioc;
        QCircleReportBean qCircleReportBean;
        RFWPlayerUpperData upperData;
        Context context;
        QCircleReportBean qCircleReportBean2 = null;
        if (rFWPlayerOptions == null) {
            ioc = null;
        } else {
            ioc = rFWPlayerOptions.getIOC();
        }
        if (ioc == null) {
            qCircleReportBean = null;
        } else {
            qCircleReportBean = (QCircleReportBean) ioc.getReportBean();
        }
        String g16 = g(qCircleReportBean);
        if (!m(g16)) {
            return g16;
        }
        if (ioc == null) {
            upperData = null;
        } else {
            upperData = ioc.getUpperData();
        }
        if (upperData == null) {
            context = null;
        } else {
            context = upperData.getContext();
        }
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (qCircleInitBean != null) {
            qCircleReportBean2 = qCircleInitBean.getFromReportBean();
        }
        if (qCircleReportBean2 == null) {
            return "";
        }
        return qCircleReportBean2.getDtPageId();
    }

    private boolean k() {
        return uq3.c.R5();
    }

    public static boolean l(String str) {
        if (str.contains(".flv")) {
            return true;
        }
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && !str.contains(ContainerUtils.FIELD_DELIMITER)) {
            QLog.e("QFSScenePlayerPageManager", 1, "[appendPlayerSceneParam] not exists param append, url: " + str);
            return true;
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            QLog.e("QFSScenePlayerPageManager", 1, "[appendPlayerSceneParam] update fail, url: " + str);
            return true;
        }
        return false;
    }

    private boolean m(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, String.valueOf(0))) {
            return false;
        }
        return true;
    }

    public String c(RFWPlayerOptions rFWPlayerOptions, String str) {
        if (!k()) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String a16 = a(str);
            String f16 = f(rFWPlayerOptions);
            if (m(f16)) {
                QLog.e("QFSScenePlayerPageManager", 1, "[appendPlayerSceneParam] current scene id should not be null.");
                return a16;
            }
            if (a16.contains("&play_scene=")) {
                return a16;
            }
            if (l(a16)) {
                return a16;
            }
            return a16 + "&play_scene=" + f16;
        } catch (Throwable th5) {
            QLog.e("QFSScenePlayerPageManager", 1, "[appendPlayerSceneParam] error: ", th5);
            return str;
        }
    }

    public List<String> d(RFWPlayerOptions rFWPlayerOptions, List<String> list) {
        if (list != null && !list.isEmpty()) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(c(rFWPlayerOptions, it.next()));
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public String h(QCircleLayerBean qCircleLayerBean) {
        QCircleReportBean fromReportBean;
        if (!k()) {
            return "";
        }
        if (qCircleLayerBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleLayerBean.getFromReportBean();
        }
        return g(fromReportBean);
    }

    public String i(QCircleReportBean qCircleReportBean) {
        if (!k()) {
            return "";
        }
        return g(qCircleReportBean);
    }
}
