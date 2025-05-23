package com.tencent.mobileqq.tvideo.pr;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import tvideo.TVideoFloatPr$FlowPoolReportMap;
import tvideo.TVideoFloatPr$GetQqPromotionLocationData;
import tvideo.TVideoFloatPr$GetQqPromotionLocationResp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    private static int f304605f = -1;

    /* renamed from: a, reason: collision with root package name */
    public volatile int f304606a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet f304607b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArraySet f304608c = new CopyOnWriteArraySet();

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f304610e = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private final TVideoFloatPrLocationRequest f304609d = new TVideoFloatPrLocationRequest();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f304611a = new e();
    }

    e() {
    }

    private void b() {
        this.f304607b.clear();
        this.f304608c.clear();
    }

    private void d(List<TVideoFloatPr$FlowPoolReportMap> list, Set<String> set) {
        if (list != null && set != null) {
            for (TVideoFloatPr$FlowPoolReportMap tVideoFloatPr$FlowPoolReportMap : list) {
                if (tVideoFloatPr$FlowPoolReportMap != null) {
                    set.add(tVideoFloatPr$FlowPoolReportMap.key.get());
                }
            }
        }
    }

    public static e e() {
        return a.f304611a;
    }

    private void f(TVideoFloatPr$GetQqPromotionLocationResp tVideoFloatPr$GetQqPromotionLocationResp) {
        TVideoFloatPr$GetQqPromotionLocationData tVideoFloatPr$GetQqPromotionLocationData = tVideoFloatPr$GetQqPromotionLocationResp.data;
        this.f304606a = tVideoFloatPr$GetQqPromotionLocationData.flag.get();
        if (this.f304606a != 1) {
            return;
        }
        List<TVideoFloatPr$FlowPoolReportMap> list = tVideoFloatPr$GetQqPromotionLocationData.cids.get();
        List<TVideoFloatPr$FlowPoolReportMap> list2 = tVideoFloatPr$GetQqPromotionLocationData.vids.get();
        d(list, this.f304607b);
        d(list2, this.f304608c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoFloatPr$GetQqPromotionLocationResp tVideoFloatPr$GetQqPromotionLocationResp) {
        QLog.i("TVideoPrLocationManager", 1, "fetchLocationData isSuccess = " + z16 + " errMsg = " + str + " rsp = " + tVideoFloatPr$GetQqPromotionLocationResp);
        if (tVideoFloatPr$GetQqPromotionLocationResp != null && z16 && j3 == 0 && tVideoFloatPr$GetQqPromotionLocationResp.data != null) {
            this.f304610e.set(true);
            f(tVideoFloatPr$GetQqPromotionLocationResp);
        }
    }

    public synchronized void c() {
        if (this.f304610e.get()) {
            return;
        }
        b();
        VSNetworkHelper.getInstance().sendRequest(f304605f, this.f304609d, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.pr.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.this.g(baseRequest, z16, j3, str, (TVideoFloatPr$GetQqPromotionLocationResp) obj);
            }
        });
    }

    public String h(String str, String str2) {
        if (this.f304606a == 0) {
            return "";
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return "";
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (this.f304606a == 2) {
            if (isEmpty) {
                return str2;
            }
            return str;
        }
        if (this.f304607b.isEmpty() && this.f304608c.isEmpty()) {
            return "";
        }
        if (this.f304607b.contains(str)) {
            return str;
        }
        if (!this.f304608c.contains(str2)) {
            return "";
        }
        return str2;
    }

    public void i() {
        this.f304610e.set(false);
    }
}
