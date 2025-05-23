package db0;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends a<QCircleDoRecommendRequest> {

    /* renamed from: f, reason: collision with root package name */
    private int f393492f;

    /* renamed from: g, reason: collision with root package name */
    private int f393493g;

    /* renamed from: h, reason: collision with root package name */
    private String f393494h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f393495i = false;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<View> f393496j;

    private void e(int i3) {
        Map<String, Object> map;
        WeakReference<View> weakReference;
        if (!TextUtils.isEmpty(this.f393487c) && (map = this.f393489e) != null) {
            map.put("xsj_action_type", this.f393494h);
            this.f393489e.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_TIMES, Integer.valueOf(i3));
            if (g() && (weakReference = this.f393496j) != null && weakReference.get() != null) {
                VideoReport.reportEvent(this.f393487c, this.f393496j.get(), this.f393489e);
                return;
            }
            WeakReference<View> weakReference2 = this.f393488d;
            if (weakReference2 != null && weakReference2.get() != null) {
                VideoReport.reportEvent(this.f393487c, this.f393488d.get(), this.f393489e);
            } else {
                VideoReport.reportEvent(this.f393487c, this.f393489e);
            }
        }
    }

    private boolean g() {
        if (!this.f393495i && !TextUtils.equals(this.f393494h, QCircleDaTongConstant.ElementParamValue.PUSH_V3)) {
            return false;
        }
        return true;
    }

    private void h(int i3) {
        QCircleLpReportDc05501.DataBuilder a16 = a();
        if (a16 != null) {
            a16.setExt2(String.valueOf(i3));
            int i16 = this.f393492f;
            if (i16 != 0 && i3 == 1) {
                a16.setActionType(i16);
            } else {
                int i17 = this.f393493g;
                if (i17 != 0 && i3 > 1) {
                    a16.setActionType(i17);
                }
            }
            QCircleLpReportDc05501.report(a16);
        }
    }

    private void i(int i3) {
        QCircleLpReportDc05507.DataBuilder b16 = b();
        if (b16 != null) {
            b16.setExt2(String.valueOf(i3));
            int i16 = this.f393492f;
            if (i16 != 0 && i3 == 1) {
                b16.setActionType(i16);
            } else {
                int i17 = this.f393493g;
                if (i17 != 0 && i3 > 1) {
                    b16.setActionType(i17);
                }
            }
            b16.setActTime(System.currentTimeMillis());
            QCircleLpReportDc05507.report(b16);
        }
    }

    private void j() {
        QCircleLpReportDc05507.DataBuilder b16 = b();
        if (b16 != null) {
            b16.setActionType(122);
            b16.setSubActionType(2);
            b16.setActTime(System.currentTimeMillis());
            QCircleLpReportDc05507.report(b16);
        }
    }

    @Override // com.tencent.richframework.sender.interceptor.ReqInterceptor
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void interceptAddReq(QCircleDoRecommendRequest qCircleDoRecommendRequest, BaseSenderChain baseSenderChain) {
        if (qCircleDoRecommendRequest != null && qCircleDoRecommendRequest.getReq() != null) {
            int i3 = qCircleDoRecommendRequest.getReq().comboCount.get();
            if (qCircleDoRecommendRequest.getReq().pushType.get() == 0) {
                o(34);
                l(34);
                i(i3);
                h(i3);
            } else {
                j();
            }
            e(i3);
            baseSenderChain.addRequest(qCircleDoRecommendRequest);
        }
    }

    public void k(String str) {
        this.f393494h = str;
    }

    public void l(int i3) {
        this.f393493g = i3;
    }

    public void m(View view) {
        this.f393496j = new WeakReference<>(view);
    }

    public void n(boolean z16) {
        this.f393495i = z16;
    }

    public void o(int i3) {
        this.f393492f = i3;
    }
}
