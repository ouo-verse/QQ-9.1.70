package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class f extends t30.a implements Call.OnRspCallBack<QCircleBaseRequest>, IDataDisplaySurface<e30.b> {
    protected String D;

    @Override // t30.b
    public int J() {
        return -1;
    }

    @Override // t30.a
    public int L1() {
        return 1;
    }

    public abstract List<e30.b> P1();

    public MutableLiveData<UIStateData<List<e30.b>>> Q1() {
        return this.f435354m;
    }

    public abstract String R1();

    public abstract void S1();

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.i(getTAG(), 1, "[onReceive] -> traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str);
        if (obj instanceof UIStateData) {
            this.f435354m.setValue((UIStateData) obj);
        }
    }

    public abstract void U1(boolean z16);

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f435354m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    public String getUin() {
        return this.D;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        S1();
    }

    public void setUin(String str) {
        this.D = str;
    }
}
