package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends f {
    private int E;
    private boolean F = false;
    private final com.tencent.biz.qqcircle.immersive.personal.interceptor.d G = new com.tencent.biz.qqcircle.immersive.personal.interceptor.d();

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public List<e30.b> P1() {
        return this.G.f();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public String R1() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (this.F) {
            str = "";
        } else {
            str = this.D + "_";
        }
        sb5.append(str);
        sb5.append(hashCode());
        sb5.append("_");
        sb5.append(this.E);
        return sb5.toString();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public void S1() {
        com.tencent.biz.qqcircle.immersive.personal.request.b.k(getUin(), this.E).c(false).a().j(this.G).i(true).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.viewmodel.f
    public void U1(boolean z16) {
        QLog.i("QFSPersonalFeedViewModel", 1, "[requestFeeds] -> enableCache = " + z16 + ", feedType = " + this.E);
        com.tencent.biz.qqcircle.immersive.personal.request.b.k(getUin(), this.E).c(z16).a().j(this.G).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    public boolean W1(String str) {
        Iterator<e30.b> it = this.G.f().iterator();
        while (it.hasNext()) {
            e30.b next = it.next();
            if (next.g() != null && TextUtils.equals(next.g().f398449id.get(), str)) {
                it.remove();
                this.f435354m.setValue(com.tencent.biz.qqcircle.immersive.utils.r.Q0(this.f435354m.getValue(), this.G.f()));
                return true;
            }
        }
        return false;
    }

    public void X1(String str, int i3) {
        this.D = str;
        this.E = i3;
    }

    public void Z1(boolean z16) {
        this.F = z16;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalFeedViewModel";
    }
}
