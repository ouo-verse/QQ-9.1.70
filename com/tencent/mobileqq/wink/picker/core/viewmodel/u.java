package com.tencent.mobileqq.wink.picker.core.viewmodel;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.request.QQWinkQueryPubInfoReq;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudPubGuideSvr$QueryPubInfoRsp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/u;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "M1", "<init>", "()V", "i", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class u extends BaseViewModel {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudPubGuideSvr$QueryPubInfoRsp feedCloudPubGuideSvr$QueryPubInfoRsp) {
        boolean z17 = true;
        if (z16 && j3 == 0 && feedCloudPubGuideSvr$QueryPubInfoRsp != null) {
            uq3.k a16 = uq3.k.a();
            PBEnumField pBEnumField = feedCloudPubGuideSvr$QueryPubInfoRsp.has_pub;
            if (pBEnumField == null || pBEnumField.get() != 2) {
                z17 = false;
            }
            a16.j(QQWinkConstants.WINK_USER_HAVE_NO_PUBLISH, z17);
            return;
        }
        QLog.e("WinkPublishInfoViewModel", 1, "isSuccess:" + z16 + ", retCode:" + j3 + ", rsp:" + feedCloudPubGuideSvr$QueryPubInfoRsp);
    }

    public final void M1() {
        VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), new QQWinkQueryPubInfoReq(1), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.t
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                u.N1(baseRequest, z16, j3, str, (FeedCloudPubGuideSvr$QueryPubInfoRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkPublishInfoViewModel";
    }
}
