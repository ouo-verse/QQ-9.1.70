package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.text.TextUtils;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QFSPersonalCollectedFeedFragment extends QFSPersonalBaseFeedFragment {
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.j Q;

    public QFSPersonalCollectedFeedFragment() {
        super(ErrorCode.ERROR_CHECKLEGALAPP_INVALID_SDK_CLI_TYPE);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    public com.tencent.biz.qqcircle.immersive.personal.viewmodel.f Ah(IPartHost iPartHost) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.j jVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.j) getViewModel(iPartHost, "", com.tencent.biz.qqcircle.immersive.personal.viewmodel.j.class);
        this.Q = jVar;
        return jVar;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    protected void Ch() {
        String x16;
        QLog.i("QFSPersonalCollectedFeedFragment", 1, "[handleEmptyState]");
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.I;
        if (tVar != null && tVar.N1() != null) {
            if (this.I.N1().z()) {
                x16 = uq3.c.y1();
            } else {
                x16 = uq3.c.x1();
            }
            String[] f16 = cu.f(x16, "\n");
            if (f16.length >= 2) {
                this.F.M9(f16[0], f16[1]);
            } else {
                this.F.M9(f16[0], "");
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    protected void Dh(String str, long j3) {
        QLog.i(getTAG(), 1, "[handleError] -> errorMsg = " + str);
        this.F.N9(str);
    }

    protected void Sh(QFSCollectedFeedEvent qFSCollectedFeedEvent) {
        if (this.Q == null) {
            return;
        }
        String feedId = qFSCollectedFeedEvent.getFeedId();
        boolean isCollected = qFSCollectedFeedEvent.isCollected();
        RFWLog.i(getTAG(), RFWLog.USR, "handleCollectFeedEvent feedId = " + feedId + ",isCollected = " + isCollected);
        boolean z16 = true;
        if (isCollected) {
            this.Q.P1().add(0, new e30.b(qFSCollectedFeedEvent.getFeed()).p());
            this.P = true;
            return;
        }
        for (e30.b bVar : this.Q.P1()) {
            if (TextUtils.equals(bVar.g().f398449id.get(), feedId)) {
                if (!this.Q.P1().remove(bVar) && !this.P) {
                    z16 = false;
                }
                this.P = z16;
                return;
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSCollectedFeedEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectedFeedFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (Oh() && (simpleBaseEvent instanceof QFSCollectedFeedEvent)) {
            Sh((QFSCollectedFeedEvent) simpleBaseEvent);
        }
    }
}
