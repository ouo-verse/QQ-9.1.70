package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetBusiInfoRsp;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class t {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetBusiInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f92782a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f92783b;

        a(String str, Runnable runnable) {
            this.f92782a = str;
            this.f92783b = runnable;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetBusiInfoRsp feedCloudRead$StGetBusiInfoRsp) {
            QLog.d("QCircleEntranceUtils", 1, "QCircleEntranceUtils->onReceive: dispatch Success:" + z16 + " | CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | lastPageSchema:" + this.f92782a + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16 && j3 == 0) {
                Runnable runnable = this.f92783b;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = h.a(R.string.ci8);
            }
            QCircleToast.o(str, 0);
        }
    }

    public static boolean a(QCircleInitBean qCircleInitBean) {
        HashMap<String, String> schemeAttrs;
        if (qCircleInitBean == null || (schemeAttrs = qCircleInitBean.getSchemeAttrs()) == null || schemeAttrs.size() == 0 || !schemeAttrs.containsKey("is_from_third_party")) {
            return false;
        }
        return TextUtils.equals(schemeAttrs.get("is_from_third_party"), "1");
    }

    public static void b(String str, Runnable runnable) {
        QCircleHostGlobalInfo.setByShareOpenQCircle(true);
        QCircleFolderBean qCircleFolderBean = new QCircleFolderBean();
        if (!TextUtils.isEmpty(str)) {
            qCircleFolderBean.setLastPageScheme(str);
        }
        VSNetworkHelper.getInstance().sendRequest(new QCircleGetTabListRequest(null, qCircleFolderBean), new a(str, runnable));
    }
}
