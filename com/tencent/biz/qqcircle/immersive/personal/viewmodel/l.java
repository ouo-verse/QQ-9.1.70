package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l extends BaseViewModel implements Call.OnRspCallBack, IDataDisplaySurface<e30.b> {
    private com.tencent.biz.qqcircle.immersive.personal.interceptor.d D;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.bean.b f89151i;

    /* renamed from: m, reason: collision with root package name */
    private RspInterceptor f89152m;
    private final MutableLiveData<QQCircleFeedBase$StFeedListBusiRspData> C = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<e30.b>>> E = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Call.OnRspCallBack {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
            QLog.d("QFSPersonalFeedViewModel", 1, "[onReceive] ->  , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str);
            if (z16 && j3 == 0) {
                if (l.this.E.getValue() != 0 && !((List) ((UIStateData) l.this.E.getValue()).getData()).isEmpty()) {
                    ((List) ((UIStateData) l.this.E.getValue()).getData()).clear();
                    ((UIStateData) l.this.E.getValue()).setState(0);
                    l.this.C.setValue(new QQCircleFeedBase$StFeedListBusiRspData());
                    l.this.E.setValue((UIStateData) l.this.E.getValue());
                    com.tencent.biz.qqcircle.immersive.personal.request.b.g(l.this.f89151i.b(), l.this.f89151i.a(), false);
                    return;
                }
                return;
            }
            QCircleToast.h(R.string.f194594cb, 0);
        }
    }

    public void O1() {
        com.tencent.biz.qqcircle.immersive.personal.bean.b bVar = this.f89151i;
        if (bVar != null && bVar.b() == 20107) {
            com.tencent.biz.qqcircle.immersive.personal.request.b.j(new a());
        }
    }

    public MutableLiveData<QQCircleFeedBase$StFeedListBusiRspData> P1() {
        return this.C;
    }

    public MutableLiveData<UIStateData<List<e30.b>>> Q1() {
        return this.E;
    }

    public String R1() {
        com.tencent.biz.qqcircle.immersive.personal.bean.b bVar = this.f89151i;
        if (bVar == null) {
            return "";
        }
        return bVar.a();
    }

    public String S1() {
        return hashCode() + "";
    }

    public void T1(int i3, int i16) {
        boolean z16;
        boolean z17;
        if (i16 != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 == 3) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.biz.qqcircle.immersive.personal.request.b.l(i3, R1(), this.D, this, this.f89152m, z16, z17);
    }

    public void U1(com.tencent.biz.qqcircle.immersive.personal.interceptor.d dVar) {
        this.D = dVar;
    }

    public void W1(com.tencent.biz.qqcircle.immersive.personal.bean.b bVar) {
        if (bVar == null) {
            QLog.i("QFSPersonalFeedViewModel", 1, "[setQFSFeedGridData] -> feedGridData is null");
        } else {
            this.f89151i = bVar;
        }
    }

    public void X1(RspInterceptor rspInterceptor) {
        this.f89152m = rspInterceptor;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        if (this.f89151i != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof QCircleInitBean) {
                QCircleInitBean qCircleInitBean = (QCircleInitBean) obj;
                if (qCircleInitBean.getExtraTypeInfo() == null || qCircleInitBean.getExtraTypeInfo().sourceType != this.f89151i.b()) {
                    return null;
                }
                return this.E;
            }
        }
        return null;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalFeedViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        com.tencent.biz.qqcircle.immersive.personal.bean.b bVar = this.f89151i;
        if (bVar == null) {
            return;
        }
        T1(bVar.b(), 3);
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
        if (obj instanceof QFSGetFeedListRequest) {
            QFSGetFeedListRequest qFSGetFeedListRequest = (QFSGetFeedListRequest) obj;
            QLog.d("QFSPersonalFeedViewModel", 1, "onReceive | cmdName=" + qFSGetFeedListRequest.get$cmd() + " | traceId=" + qFSGetFeedListRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j3);
            if (z16 && j3 == 0 && qFSGetFeedListRequest.getSourceType() == 20107) {
                QLog.d("QFSPersonalFeedViewModel", 1, "onReceive | clear up local watch history");
                QFSRecentlyWatchedRecorder.i().g(qFSGetFeedListRequest.getHistorySent());
            }
        }
        if (obj2 instanceof UIStateData) {
            try {
                this.E.setValue((UIStateData) obj2);
                return;
            } catch (ClassCastException e16) {
                QLog.e("QFSPersonalFeedViewModel", 1, e16.getMessage());
                return;
            }
        }
        if (obj2 instanceof QQCircleFeedBase$StFeedListBusiRspData) {
            try {
                this.C.setValue((QQCircleFeedBase$StFeedListBusiRspData) obj2);
            } catch (ClassCastException e17) {
                QLog.e("QFSPersonalFeedViewModel", 1, e17.getMessage());
            }
        }
    }
}
