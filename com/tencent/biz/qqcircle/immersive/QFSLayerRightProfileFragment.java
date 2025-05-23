package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.part.av;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSPersonalConsumeTimeManager;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.r;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* loaded from: classes4.dex */
public class QFSLayerRightProfileFragment extends QFSPersonalDetailsFragment implements Observer<e40.j> {

    /* renamed from: h0, reason: collision with root package name */
    private int f84703h0;

    /* renamed from: i0, reason: collision with root package name */
    private av f84704i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f84705j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f84706k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private String f84707l0;

    private void qi() {
        if (this.K == null) {
            return;
        }
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        hashMap.put(QFS5507ReportHelper.JsonKey.ENTER_TYPE, Integer.valueOf(this.f84706k0 ? 1 : 0));
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(this.K));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(QFS5507ReportHelper.JsonKey.TRANS_FEEDID, this.K.f398449id.get());
        hashMap2.put(QFS5507ReportHelper.JsonKey.TRANS_REQID, Ih());
        dataBuilder.setActionType(600).setSubActionType(2).setToUin(this.K.poster.f398463id.get()).setPosition(this.f84703h0).setExt4(gson.toJson(hashMap)).setExt10(gson.toJson(hashMap2)).setPageId(getPageId()).setFirstFeedId(w20.a.j().h());
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private void ri() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.d
            @Override // java.lang.Runnable
            public final void run() {
                QFSLayerRightProfileFragment.this.ui();
            }
        });
    }

    private boolean ti() {
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (qCircleInitBean != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.f(qCircleInitBean)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ui() {
        if (this.K == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GESTURE_SLIDING);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.K.poster.f398463id.get());
        buildElementParams.put("xsj_feed_id", this.K.f398449id.get());
        buildElementParams.put("xsj_custom_pgid", si());
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
        try {
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.K.reportInfoForClient.get().toByteArray());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSLayerRightProfileFragment", 1, e16, new Object[0]);
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void xi() {
        if (ti() && this.K != null) {
            QFSPersonalConsumeTimeManager e16 = QFSPersonalConsumeTimeManager.e();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
            e16.d(feedCloudMeta$StFeed, feedCloudMeta$StFeed.poster.f398463id.get(), 2);
        }
    }

    public void Ai(boolean z16) {
        this.f84706k0 = z16;
    }

    protected boolean Bi() {
        return !isResumed();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    protected void Nh(int i3) {
        QCircleLayerBean qCircleLayerBean;
        if (getQCircleInitBean() instanceof QCircleLayerBean) {
            qCircleLayerBean = (QCircleLayerBean) getQCircleInitBean();
        } else {
            qCircleLayerBean = null;
        }
        if (ti()) {
            if (this.K != null && i3 != 2) {
                QFSPersonalConsumeTimeManager e16 = QFSPersonalConsumeTimeManager.e();
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
                e16.d(feedCloudMeta$StFeed, feedCloudMeta$StFeed.poster.f398463id.get(), i3);
                return;
            }
            return;
        }
        if (qCircleLayerBean != null && qCircleLayerBean.getExtraTypeInfo() != null && qCircleLayerBean.getExtraTypeInfo().sourceType == 20101 && "pg_xsj_explore_page".equals(qCircleLayerBean.getFromReportBean().getDtFromPageId()) && qCircleLayerBean.getFeed() == null && i3 == 2) {
            QFSPersonalConsumeTimeManager.e().d(qCircleLayerBean.getFeed(), qCircleLayerBean.getFeed().poster.f398463id.get(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    public void Xh() {
        if (this.K == null) {
            return;
        }
        this.N.g3(true);
        this.T.Z1(true);
        this.U.Z1(true);
        this.V.X1(true);
        super.Xh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        av avVar = new av();
        this.f84704i0 = avVar;
        assembleParts.add(avVar);
        return assembleParts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> childDaTongPageParams = super.getChildDaTongPageParams();
        if (childDaTongPageParams == null) {
            childDaTongPageParams = new HashMap<>();
        }
        childDaTongPageParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_ENTRYMODE, 1);
        mi(childDaTongPageParams);
        return childDaTongPageParams;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerRightProfileFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            super.load();
            getPartManager().broadcastMessage("personal_detail_show_publish", Boolean.FALSE);
            QLog.d("QFSLayerRightProfileFragment", 1, "lazyInit");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getContext() != null) {
            w20.a.j().n(getContext().hashCode(), this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getContext() != null) {
            w20.a.j().w(getContext().hashCode());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        RFWThreadManager.getUIHandler().postDelayed(new c(this), 500L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (!ti()) {
            Nh(1);
        }
        super.onResume();
        qi();
        ri();
        RFWThreadManager.getUIHandler().postDelayed(new c(this), 500L);
    }

    public String si() {
        return this.f84707l0;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: vi, reason: merged with bridge method [inline-methods] */
    public void onChanged(e40.j jVar) {
        av avVar;
        if (jVar != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = jVar.f395620a.get();
            this.K = feedCloudMeta$StFeed2;
            this.f84703h0 = jVar.f395622c;
            if (feedCloudMeta$StFeed2 != null && feedCloudMeta$StFeed2.poster.has() && (avVar = this.f84704i0) != null) {
                avVar.A9(this.K);
                if (this.N != null) {
                    if (!TextUtils.equals(bj.g(feedCloudMeta$StFeed), bj.g(this.K)) && Bi()) {
                        this.N.V2();
                    }
                    this.N.h3(this.K);
                }
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.d dVar = this.U;
                if (dVar != null) {
                    dVar.setUin(this.K.poster.f398463id.get());
                    this.U.Q1().setValue(null);
                }
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.d dVar2 = this.T;
                if (dVar2 != null) {
                    dVar2.setUin(this.K.poster.f398463id.get());
                    this.T.Q1().setValue(null);
                }
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.j jVar2 = this.V;
                if (jVar2 != null) {
                    jVar2.setUin(this.K.poster.f398463id.get());
                    this.V.Q1().setValue(null);
                }
            }
        }
    }

    public void wi(Fragment fragment) {
        if (fragment == this) {
            this.f84705j0 = true;
        } else if (this.f84705j0) {
            xi();
            this.f84705j0 = false;
        }
    }

    public void yi() {
        r rVar = this.N;
        if (rVar != null && rVar.J2()) {
            this.N.d3();
            this.N.T2(true);
        }
    }

    public void zi(String str) {
        this.f84707l0 = str;
    }
}
