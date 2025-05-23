package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.text.TextUtils;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetCollectionListRequest;
import com.tencent.richframework.sender.call.Call;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends f {
    private boolean E = false;
    private com.tencent.biz.qqcircle.immersive.personal.interceptor.b F = new com.tencent.biz.qqcircle.immersive.personal.interceptor.b();

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public List<e30.b> P1() {
        return this.F.f();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public String R1() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (this.E) {
            str = "";
        } else {
            str = this.D + "_";
        }
        sb5.append(str);
        sb5.append(hashCode());
        sb5.append("_");
        sb5.append(ErrorCode.ERROR_CHECKLEGALAPP_INVALID_SDK_CLI_TYPE);
        return sb5.toString();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public void S1() {
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(this.F).i(true).addRequest(new QFSGetCollectionListRequest.b(this.D).g(2).a()).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public void U1(boolean z16) {
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(this.F).addRequest(new QFSGetCollectionListRequest.b(this.D).g(2).a()).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    public boolean W1(String str) {
        Iterator<e30.b> it = this.F.f().iterator();
        while (it.hasNext()) {
            e30.b next = it.next();
            if (next.g() != null && TextUtils.equals(next.g().f398449id.get(), str)) {
                it.remove();
                this.f435354m.setValue(com.tencent.biz.qqcircle.immersive.utils.r.Q0(this.f435354m.getValue(), this.F.f()));
                return true;
            }
        }
        return false;
    }

    public void X1(boolean z16) {
        this.E = z16;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectedViewModel";
    }
}
