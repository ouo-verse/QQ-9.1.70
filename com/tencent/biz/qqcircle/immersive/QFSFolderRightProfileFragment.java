package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.part.av;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSPersonalConsumeTimeManager;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.r;
import com.tencent.biz.qqcircle.immersive.utils.ax;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
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
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* loaded from: classes4.dex */
public class QFSFolderRightProfileFragment extends QFSFolderProfileFragment implements Observer<e40.j> {

    /* renamed from: h0, reason: collision with root package name */
    private int f84695h0;

    /* renamed from: i0, reason: collision with root package name */
    private av f84696i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f84697j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private String f84698k0;

    public QFSFolderRightProfileFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("qfs_key_bundle_personal_fragment_scene", "qfs_personal_fragment_scene_client");
        setArguments(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ai() {
        if (this.K == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GESTURE_SLIDING);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.K.poster.f398463id.get());
        buildElementParams.put("xsj_feed_id", this.K.f398449id.get());
        buildElementParams.put("xsj_custom_pgid", yi());
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
        try {
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.K.reportInfoForClient.get().toByteArray());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSFolderRightProfileFragment", 1, e16, new Object[0]);
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void wi() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.QFSFolderRightProfileFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (((QFSPersonalDetailsFragment) QFSFolderRightProfileFragment.this).K == null) {
                    return;
                }
                Gson gson = new Gson();
                HashMap hashMap = new HashMap();
                hashMap.put(QFS5507ReportHelper.JsonKey.ENTER_TYPE, Integer.valueOf(QFSFolderRightProfileFragment.this.f84697j0 ? 1 : 0));
                HashMap hashMap2 = new HashMap();
                hashMap2.put(QFS5507ReportHelper.JsonKey.TRANS_FEEDID, ((QFSPersonalDetailsFragment) QFSFolderRightProfileFragment.this).K.f398449id.get());
                hashMap2.put(QFS5507ReportHelper.JsonKey.TRANS_REQID, QFSFolderRightProfileFragment.this.Ih());
                QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(((QFSPersonalDetailsFragment) QFSFolderRightProfileFragment.this).K));
                dataBuilder.setActionType(600).setSubActionType(2).setToUin(((QFSPersonalDetailsFragment) QFSFolderRightProfileFragment.this).K.poster.f398463id.get()).setPosition(QFSFolderRightProfileFragment.this.f84695h0).setExt4(gson.toJson(hashMap)).setExt10(gson.toJson(hashMap2)).setPageId(QFSFolderRightProfileFragment.this.getPageId()).setfpageid(503).setFirstFeedId(w20.a.j().h());
                QCircleLpReportDc05507.report(dataBuilder);
            }
        });
    }

    private void xi() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSFolderRightProfileFragment.this.Ai();
            }
        });
    }

    private void zi() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 32) {
            QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
            try {
                qQCircleDitto$StCircleDittoDataNew.mergeFrom(this.K.dittoFeed.dittoDataNew.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (qQCircleDitto$StCircleDittoDataNew.itemContainter.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size() > 0 && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.size() > 0) {
                this.K = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.get(0);
            }
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: Bi, reason: merged with bridge method [inline-methods] */
    public void onChanged(e40.j jVar) {
        av avVar;
        if (jVar == null) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = jVar.f395620a.get();
        if (com.tencent.biz.qqcircle.immersive.repository.foldertab.j.g(feedCloudMeta$StFeed)) {
            QLog.d("QFSFolderRightProfileFragment", 1, "stFeed is simple feed, ignore");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.K;
        this.K = feedCloudMeta$StFeed;
        this.f84695h0 = jVar.f395622c;
        zi();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.K;
        if (feedCloudMeta$StFeed3 != null && feedCloudMeta$StFeed3.poster.has() && (avVar = this.f84696i0) != null) {
            avVar.A9(this.K);
            if (this.N != null) {
                if (!TextUtils.equals(bj.g(feedCloudMeta$StFeed2), bj.g(this.K)) && Fi()) {
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

    public void Ci() {
        r rVar = this.N;
        if (rVar != null && rVar.J2()) {
            this.N.d3();
            this.N.T2(true);
        }
    }

    public void Di(String str) {
        this.f84698k0 = str;
    }

    public void Ei(boolean z16) {
        this.f84697j0 = z16;
    }

    protected boolean Fi() {
        return !isResumed();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    protected void Nh(int i3) {
        if (this.K == null) {
            return;
        }
        QFSPersonalConsumeTimeManager e16 = QFSPersonalConsumeTimeManager.e();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        e16.d(feedCloudMeta$StFeed, feedCloudMeta$StFeed.poster.f398463id.get(), i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    public void Th() {
        super.Th();
        if (getContext() != null) {
            w20.a.j().n(getContext().hashCode(), this);
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
        this.f84696i0 = avVar;
        assembleParts.add(avVar);
        return assembleParts;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void doResume() {
        super.doResume();
        wi();
        xi();
        Activity hostActivity = getHostActivity();
        if (hostActivity != null && hostActivity.getParent() != null) {
            QUIImmersiveHelper.s(hostActivity.getParent(), true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> childDaTongPageParams = super.getChildDaTongPageParams();
        if (childDaTongPageParams == null) {
            childDaTongPageParams = new HashMap<>();
        }
        childDaTongPageParams.putAll(ua0.c.d(new e30.b(this.K)));
        childDaTongPageParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_ENTRYMODE, 1);
        mi(childDaTongPageParams);
        return childDaTongPageParams;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSFolderProfileFragment, com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFolderRightProfileFragment" + hashCode();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (!bz.p()) {
            return super.onBackEvent();
        }
        if (this.C && getActivity() != null) {
            QLog.d("QFSFolderRightProfileFragment", 4, "[onBackEvent] back in personal page in pad.");
            getActivity().onBackPressed();
            return true;
        }
        return super.onBackEvent();
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
        RFWThreadManager.getUIHandler().postDelayed(new a(this), 500L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ax.h(getContext(), false);
        RFWThreadManager.getUIHandler().postDelayed(new a(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        com.tencent.mobileqq.qui.b.f276860a.a(this.E, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
    }

    public String yi() {
        return this.f84698k0;
    }
}
