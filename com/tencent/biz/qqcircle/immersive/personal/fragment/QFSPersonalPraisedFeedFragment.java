package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalPraisedFeedFragment extends QFSPersonalBaseFeedFragment {

    /* loaded from: classes4.dex */
    class a extends v.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_op_mask");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            if (QFSPersonalPraisedFeedFragment.this.F != null && !wVar.x() && !wVar.v() && !wVar.w()) {
                if (!wVar.z() && wVar.u(6)) {
                    QFSPersonalPraisedFeedFragment.this.F.S9();
                    return;
                }
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.f fVar = QFSPersonalPraisedFeedFragment.this.J;
                if (fVar != null && fVar.Q1().getValue() == null) {
                    RFWLog.i("QFSPersonalPraisedFeedFragment", RFWLog.USR, "[requestFeeds]");
                    QFSPersonalPraisedFeedFragment.this.J.U1(true);
                }
            }
        }
    }

    public QFSPersonalPraisedFeedFragment() {
        super(ErrorCode.ERROR_APPID_NOT_FOUND);
    }

    private void Sh() {
        VideoReport.setElementId(((QCircleBaseFragment) this).mContentView, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_PRAISE_TAB);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    public com.tencent.biz.qqcircle.immersive.personal.viewmodel.f Ah(IPartHost iPartHost) {
        return (com.tencent.biz.qqcircle.immersive.personal.viewmodel.f) getViewModel(iPartHost, "key_prefix_praised", com.tencent.biz.qqcircle.immersive.personal.viewmodel.d.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    protected void Ch() {
        String B1;
        String z16;
        QLog.i("QFSPersonalPraisedFeedFragment", 1, "[handleEmptyState]");
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.I;
        if (tVar != null && tVar.N1() != null) {
            boolean z17 = this.I.N1().z();
            if (z17) {
                B1 = uq3.c.C1();
            } else {
                B1 = uq3.c.B1();
            }
            if (z17) {
                z16 = uq3.c.A1();
            } else {
                z16 = uq3.c.z1();
            }
            this.F.M9(B1, z16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    protected void Hh(QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent) {
        if (!Oh() || this.J == null) {
            return;
        }
        String str = qCirclePolyPraiseUpdateEvent.mTargetFeedId;
        boolean isPraised = qCirclePolyPraiseUpdateEvent.isPraised();
        RFWLog.i(getTAG(), RFWLog.USR, "handlePraisedUpdateEvent feedId = " + str + ",isPraised = " + isPraised);
        boolean z16 = true;
        if (isPraised) {
            this.J.P1().add(0, new e30.b(qCirclePolyPraiseUpdateEvent.getStFeed()).p());
            this.P = true;
            return;
        }
        for (e30.b bVar : this.J.P1()) {
            if (TextUtils.equals(bVar.g().f398449id.get(), str)) {
                if (!this.J.P1().remove(bVar) && !this.P) {
                    z16 = false;
                }
                this.P = z16;
                return;
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalPraisedFeedFragment";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    public void initViewModel() {
        super.initViewModel();
        this.I.O1().c(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        Sh();
    }
}
