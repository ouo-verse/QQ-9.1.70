package com.qzone.reborn.qzmoment.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.qzmoment.event.QZMNotifyDeleteFeedEvent;
import com.qzone.reborn.qzmoment.request.QZMDeleteFeedRequest;
import com.qzone.reborn.qzmoment.request.QZMGetFeedSharePanelRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentReader$StGetFeedSharePanelRsp;
import qzonemoment.QZMomentWriter$StDeleteFeedRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends an.b {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<UIStateData<bn.i>> f59104i = new MutableLiveData<>();

    private boolean Q1(bn.d dVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (!PreLoader.exists("qzm_feed_share_data_preload_id")) {
            return false;
        }
        QLog.d(getTAG(), 1, "requestGetFeedSharePanel from preload task");
        R1(dVar, actionSheetItem);
        return true;
    }

    private void R1(final bn.d dVar, final ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        PreLoader.addListener("qzm_feed_share_data_preload_id", new OnTaskListener() { // from class: com.qzone.reborn.qzmoment.viewmodel.d
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                g.this.W1(dVar, actionSheetItem, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(QZMomentMeta$StFeed qZMomentMeta$StFeed, BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentWriter$StDeleteFeedRsp qZMomentWriter$StDeleteFeedRsp) {
        M1("[requestDeleteFeed]", z16, baseRequest, j3, str, false);
        T1(z16, j3, str, qZMomentWriter$StDeleteFeedRsp, qZMomentMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(bn.d dVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentReader$StGetFeedSharePanelRsp qZMomentReader$StGetFeedSharePanelRsp) {
        M1("[requestGetFeedSharePanel]", z16, baseRequest, j3, str, false);
        U1(z16, j3, qZMomentReader$StGetFeedSharePanelRsp, dVar, actionSheetItem, str);
    }

    public MutableLiveData<UIStateData<bn.i>> S1() {
        return this.f59104i;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedActionSheetViewModel";
    }

    public void a2(final QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        if (qZMomentMeta$StFeed == null) {
            QLog.e(getTAG(), 1, "requestDeleteFeed  feed == null");
            return;
        }
        QZMDeleteFeedRequest qZMDeleteFeedRequest = new QZMDeleteFeedRequest(qZMomentMeta$StFeed);
        QLog.d(getTAG(), 1, "requestDeleteFeed  | feedId : " + qZMomentMeta$StFeed.f430362id.get());
        sendRequest(qZMDeleteFeedRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.viewmodel.e
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                g.this.X1(qZMomentMeta$StFeed, baseRequest, z16, j3, str, (QZMomentWriter$StDeleteFeedRsp) obj);
            }
        });
    }

    public void b2(final bn.d dVar, final ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (dVar != null && dVar.f28666a != null) {
            if (Q1(dVar, actionSheetItem)) {
                return;
            }
            QZMomentMeta$StFeed a16 = dVar.f28666a.a();
            QZMGetFeedSharePanelRequest qZMGetFeedSharePanelRequest = new QZMGetFeedSharePanelRequest(a16);
            QLog.d(getTAG(), 1, "requestGetFeedSharePanel  | feedId : " + a16.f430362id.get());
            sendRequest(qZMGetFeedSharePanelRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.qzmoment.viewmodel.f
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    g.this.Z1(dVar, actionSheetItem, baseRequest, z16, j3, str, (QZMomentReader$StGetFeedSharePanelRsp) obj);
                }
            });
            return;
        }
        QLog.e(getTAG(), 1, "requestGetFeedSharePanel  feed == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(bn.d dVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, Object[] objArr) {
        if (objArr == null || objArr.length != 4) {
            return;
        }
        QLog.d(getTAG(), 1, "fetchNewDataFromPreload requestGetFeedSharePanel onReceive: dispatch Success:" + objArr[0] + " | retCode:" + objArr[1] + " | retMessage:" + objArr[2]);
        U1(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (QZMomentReader$StGetFeedSharePanelRsp) objArr[3], dVar, actionSheetItem, (String) objArr[2]);
    }

    private void U1(boolean z16, long j3, QZMomentReader$StGetFeedSharePanelRsp qZMomentReader$StGetFeedSharePanelRsp, bn.d dVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, String str) {
        if (z16 && qZMomentReader$StGetFeedSharePanelRsp != null && j3 == 0) {
            bn.i iVar = new bn.i(qZMomentReader$StGetFeedSharePanelRsp.share_info.get(), dVar);
            iVar.c(actionSheetItem);
            this.f59104i.postValue(UIStateData.obtainSuccess(false).setData(false, iVar));
            return;
        }
        this.f59104i.postValue(UIStateData.obtainError(str).setRetCode(j3));
    }

    private void T1(boolean z16, long j3, String str, QZMomentWriter$StDeleteFeedRsp qZMomentWriter$StDeleteFeedRsp, QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        if (z16 && j3 == 0 && qZMomentWriter$StDeleteFeedRsp != null) {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f1334162, 0).show();
            QLog.d(getTAG(), 1, "handleDeleteFeedResponse  | feedId : " + qZMomentMeta$StFeed.f430362id.get());
            com.tencent.mobileqq.service.qzone.b.z(qZMomentWriter$StDeleteFeedRsp.nextPublishTime.get());
            SimpleEventBus.getInstance().dispatchEvent(new QZMNotifyDeleteFeedEvent(qZMomentMeta$StFeed));
            return;
        }
        QLog.e(getTAG(), 1, "handleDeleteFeedResponse rsp error  isSuccess = " + z16 + " retCode = " + j3 + " errMsg = " + str + " rsp = " + qZMomentWriter$StDeleteFeedRsp);
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1334061, 0).show();
    }
}
