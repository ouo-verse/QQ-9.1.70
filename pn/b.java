package pn;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.qzmoment.bean.QZMFolderInitBean;
import com.qzone.reborn.qzmoment.bean.QZMPublishBean;
import com.qzone.reborn.qzmoment.bean.QZMPublishCaptureBean;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import ho.i;
import on.f;
import rn.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends an.b {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<String> f426484i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<LbsDataV2.PoiInfo> f426485m = new MutableLiveData<>();
    private final MutableLiveData<QZMPublishCaptureBean> C = new MutableLiveData<>();

    private void O1(Context context, QZMPublishBean qZMPublishBean) {
        ((jn.b) i.t(jn.b.class)).c(context, new QZMFolderInitBean(), qZMPublishBean);
        ((IWinkAPI) QRoute.api(IWinkAPI.class)).exitWink(true, 0, null);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    private boolean P1(QZMPublishBean qZMPublishBean) {
        QZMPublishCaptureBean value = this.C.getValue();
        if (value == null) {
            QLog.e("QZMPublishViewModel", 1, "canPassPublishPreCheck captureBean is null");
            return false;
        }
        qZMPublishBean.mTraceId = f.a();
        qZMPublishBean.mFrontPath = value.getFrontUrl();
        qZMPublishBean.mBackPath = value.getBackUrl();
        qZMPublishBean.mPoiInfo = this.f426485m.getValue();
        qZMPublishBean.mContent = this.f426484i.getValue();
        if (!qZMPublishBean.isInValid()) {
            return true;
        }
        QLog.e("QZMPublishViewModel", 1, "canPassPublishPreCheck QZMPublishBean is invalid!");
        return false;
    }

    public void Q1(final Context context) {
        final QZMPublishBean qZMPublishBean = new QZMPublishBean();
        if (!P1(qZMPublishBean)) {
            ToastUtil.s("\u51fa\u9519\u4e86\uff0c\u8bf7\u91cd\u65b0\u62cd\u6444", 4);
        } else {
            d.b(qZMPublishBean, new d.a() { // from class: pn.a
                @Override // rn.d.a
                public final void a(boolean z16) {
                    b.this.R1(context, qZMPublishBean, z16);
                }
            });
        }
    }

    public void S1(String str) {
        this.f426484i.setValue(str);
    }

    public void T1(LbsDataV2.PoiInfo poiInfo) {
        this.f426485m.setValue(poiInfo);
    }

    public void U1(QZMPublishCaptureBean qZMPublishCaptureBean) {
        this.C.setValue(qZMPublishCaptureBean);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMPublishViewModel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(Context context, QZMPublishBean qZMPublishBean, boolean z16) {
        if (z16) {
            O1(context, qZMPublishBean);
        } else {
            ToastUtil.s("\u53d1\u5e03\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u62cd\u6444", 4);
        }
    }
}
