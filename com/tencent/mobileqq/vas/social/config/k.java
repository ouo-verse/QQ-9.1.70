package com.tencent.mobileqq.vas.social.config;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.social.AccountChangedNotifier;
import com.tencent.mobileqq.vas.social.SocialActionRecordHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.api.ISquareLifecycleProxy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/k;", "Lcom/tencent/state/square/api/ISquareLifecycleProxy;", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k implements ISquareLifecycleProxy {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, LoadExtResult loadExtResult) {
        if (i3 == 0) {
            SocialActionRecordHelper.f310651d.J(true);
            QLog.i("VasSquareLifecycleObserver", 1, "load mp4 encoder success");
            return;
        }
        SocialActionRecordHelper.f310651d.J(false);
        QLog.e("VasSquareLifecycleObserver", 1, "load mp4 encoder error: " + i3);
    }

    @Override // com.tencent.state.square.api.ISquareLifecycleProxy
    public void onCreate() {
        AccountChangedNotifier.a();
        SocialActionRecordHelper.f310651d.y();
        QLog.i("VasSquareLifecycleObserver", 1, "64:true");
        if (((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d().h() == 0) {
            SoLoadManager.getInstance().download(new String[]{SoLoadConstants.SONAME_X264, SoLoadConstants.SONAME_MP4V2, SoLoadConstants.SONAME_MP4_SYNTHESIZER}, new OnLoadListener() { // from class: com.tencent.mobileqq.vas.social.config.j
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    k.b(i3, loadExtResult);
                }
            });
        }
    }

    @Override // com.tencent.state.square.api.ISquareLifecycleProxy
    public void onDestroy() {
        SocialActionRecordHelper.f310651d.H();
    }
}
