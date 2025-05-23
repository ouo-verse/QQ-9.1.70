package f20;

import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c implements IWXShareHelperListener {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QCircleWXShareListener> f397708a;

    public c(QCircleWXShareListener qCircleWXShareListener) {
        this.f397708a = new WeakReference<>(qCircleWXShareListener);
    }

    @Override // com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener
    public void onWXShareResp(WXShareRsp wXShareRsp) {
        QCircleWXShareListener qCircleWXShareListener = this.f397708a.get();
        if (qCircleWXShareListener != null) {
            qCircleWXShareListener.onWXShareResp(wXShareRsp.errCode, wXShareRsp.errStr, wXShareRsp.transaction);
        }
    }
}
