package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.adapter.ae;
import com.tencent.biz.qqcircle.adapter.aj;
import com.tencent.biz.qqcircle.adapter.f;
import com.tencent.biz.qqcircle.adapter.g;
import com.tencent.biz.qqcircle.adapter.i;
import com.tencent.biz.qqcircle.adapter.j;
import com.tencent.biz.qqcircle.adapter.l;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationBodyPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.bizparts.s;
import com.tencent.biz.qqcircle.bizparts.t;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart;
import com.tencent.biz.qqcircle.immersive.part.br;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleBase$UserCircleInfo;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StSchoolPageData;
import qqcircle.QQCircleProfile$StProfileBizData;

/* loaded from: classes4.dex */
public class QCirclePolymerizationFragment extends QCircleBaseFragment {
    protected QCirclePolymerizationBean C;
    private int D;
    private String F;
    private int E = 71;
    private Map<String, Object> G = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            if (uIStateData != null && uIStateData.getData() != null && uIStateData.getData().schoolPageData != null) {
                QQCircleFeedBase$StSchoolPageData qQCircleFeedBase$StSchoolPageData = uIStateData.getData().schoolPageData;
                int size = qQCircleFeedBase$StSchoolPageData.subsidiaryFieldDesc.get().size();
                if (qQCircleFeedBase$StSchoolPageData.subsidiaryFieldDesc.get() != null && size > 1) {
                    QCirclePolymerizationFragment.this.G.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_INT, qQCircleFeedBase$StSchoolPageData.subsidiaryFieldDesc.get().get(size - 1).value.get());
                }
                QCirclePolymerizationFragment.this.G.put(QCircleDaTongConstant.ElementParamKey.XSJ_CAMPUS_BUTTON_OUTLOOK, Integer.valueOf(qQCircleFeedBase$StSchoolPageData.guildType.get()));
                VideoReport.setPageParams(((QCircleBaseFragment) QCirclePolymerizationFragment.this).mContentView, new QCircleDTParamBuilder().buildPageParams(QCirclePolymerizationFragment.this.getTAG(), QCirclePolymerizationFragment.this.getChildDaTongPageParams()));
            }
        }
    }

    private ArrayList<Long> Ah(QCirclePersonEditUpdateEvent qCirclePersonEditUpdateEvent) {
        if (qCirclePersonEditUpdateEvent != null && qCirclePersonEditUpdateEvent.getGroupInfoList() != null && qCirclePersonEditUpdateEvent.getGroupInfoList().showText != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(qCirclePersonEditUpdateEvent.getGroupInfoList().showText)) {
                return arrayList;
            }
            for (String str : qCirclePersonEditUpdateEvent.getGroupInfoList().showText.split(",")) {
                try {
                    arrayList.add(Long.valueOf(Long.parseLong(str)));
                } catch (Exception e16) {
                    QLog.e("QCirclePolymerizationFragment", 1, "addGroupList error" + e16.getMessage());
                }
            }
            return arrayList;
        }
        return null;
    }

    private void initViewModel() {
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = (QCirclePolymerizationViewModel) getViewModel(QCirclePolymerizationViewModel.class);
        qCirclePolymerizationViewModel.Q.observe(getViewLifecycleOwner(), new a());
        qCirclePolymerizationViewModel.P.observe(getViewLifecycleOwner(), new b());
    }

    private com.tencent.biz.qqcircle.bizparts.c qh() {
        com.tencent.biz.qqcircle.bizparts.c jVar;
        QCirclePolymerizationBean qCirclePolymerizationBean = this.C;
        if (qCirclePolymerizationBean == null) {
            QLog.e("QCirclePolymerizationFragment", 1, "[generateHeaderBlock] mInitBean is null");
            return null;
        }
        int polymerizationType = qCirclePolymerizationBean.getPolymerizationType();
        if (polymerizationType != 4) {
            if (polymerizationType != 7) {
                if (polymerizationType != 16) {
                    if (polymerizationType != 20) {
                        if (polymerizationType != 63) {
                            jVar = null;
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("key_block_bundle_bean", this.C);
                            jVar = new f(bundle);
                        }
                    } else {
                        jVar = new i(null);
                    }
                } else {
                    jVar = new g(null);
                }
            } else {
                if (this.C.getSelectedTabType() == -1) {
                    this.C.setTagTabType(0);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("key_block_bundle_bean", this.C);
                jVar = new l(bundle2);
            }
        } else {
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("key_block_bundle_bean", this.C);
            jVar = new j(bundle3);
        }
        if (jVar == null) {
            jVar = new l(null);
        }
        jVar.setReportBean(getReportBean());
        QLog.i("QCirclePolymerizationFragment", 1, "generateHeaderBlock  polymerizationType : " + this.C.getPolymerizationType());
        return jVar;
    }

    private int rh() {
        QCircleReportBean reportBean = getReportBean();
        if (reportBean == null) {
            return 0;
        }
        return reportBean.getFromPageId();
    }

    private void th() {
        QLog.d("QCirclePolymerizationFragment", 1, "[handleDeleteFeed]");
        ((QCirclePolymerizationViewModel) getViewModel(QCirclePolymerizationViewModel.class)).g2(getContext(), this.C, false, false);
    }

    private void uh(QCirclePersonEditUpdateEvent qCirclePersonEditUpdateEvent) {
        QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData;
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = (QCirclePolymerizationViewModel) getViewModel(QCirclePolymerizationViewModel.class);
        if (qCirclePolymerizationViewModel != null && qCirclePolymerizationViewModel.P != null && sh() == 4 && qCirclePolymerizationViewModel.P.getValue() != null && qCirclePolymerizationViewModel.P.getValue().getData() != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = qCirclePolymerizationViewModel.P.getValue().getData().editProfileButton.loginUser;
            if (qCirclePersonEditUpdateEvent.getAvatar() != null) {
                feedCloudMeta$StUser.icon.iconUrl.set(qCirclePersonEditUpdateEvent.getAvatar().showText);
                QFSPersonalEditViewModel.h2(10025, qCirclePolymerizationViewModel.L, qCirclePersonEditUpdateEvent.getAvatar());
            }
            if (qCirclePersonEditUpdateEvent.getNick() != null) {
                feedCloudMeta$StUser.nick.set(qCirclePersonEditUpdateEvent.getNick().showText);
                QFSPersonalEditViewModel.h2(10001, qCirclePolymerizationViewModel.L, qCirclePersonEditUpdateEvent.getNick());
            }
            if (qCirclePersonEditUpdateEvent.getGender() != 0) {
                feedCloudMeta$StUser.sex.set(qCirclePersonEditUpdateEvent.getGender());
            }
            if (qCirclePersonEditUpdateEvent.getConstellation() != 0) {
                feedCloudMeta$StUser.constellation.set(qCirclePersonEditUpdateEvent.getConstellation());
            }
            if (qCirclePersonEditUpdateEvent.getLocation() != null) {
                feedCloudMeta$StUser.location.set(qCirclePersonEditUpdateEvent.getLocation().f89126a);
                if (qCirclePersonEditUpdateEvent.getLocation().f89127b != null) {
                    feedCloudMeta$StUser.locationCode.set(qCirclePersonEditUpdateEvent.getLocation().f89127b);
                }
            }
            if (qCirclePersonEditUpdateEvent.getDesc() != null) {
                feedCloudMeta$StUser.desc.set(qCirclePersonEditUpdateEvent.getDesc().showText);
                QFSPersonalEditViewModel.h2(10008, qCirclePolymerizationViewModel.L, qCirclePersonEditUpdateEvent.getDesc());
            }
            QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = qCirclePolymerizationViewModel.N;
            if (qCirclePersonEditUpdateEvent.getSchool() != null && qQCircleBase$StUserBusiData != null) {
                if (qQCircleBase$StUserBusiData.schoolInfos.size() > 0) {
                    qQCircleBase$StUserBusiData.schoolInfos.get(0).name.set(qCirclePersonEditUpdateEvent.getSchool());
                } else {
                    QQCircleBase$UserCircleInfo qQCircleBase$UserCircleInfo = new QQCircleBase$UserCircleInfo();
                    qQCircleBase$UserCircleInfo.name.set(qCirclePersonEditUpdateEvent.getSchool());
                    qQCircleBase$StUserBusiData.schoolInfos.add(qQCircleBase$UserCircleInfo);
                }
            }
            if (qCirclePersonEditUpdateEvent.getCompany() != null && qQCircleBase$StUserBusiData != null) {
                if (qQCircleBase$StUserBusiData.companyInfos.size() > 0) {
                    qQCircleBase$StUserBusiData.companyInfos.get(0).name.set(qCirclePersonEditUpdateEvent.getCompany());
                } else {
                    QQCircleBase$UserCircleInfo qQCircleBase$UserCircleInfo2 = new QQCircleBase$UserCircleInfo();
                    qQCircleBase$UserCircleInfo2.name.set(qCirclePersonEditUpdateEvent.getCompany());
                    qQCircleBase$StUserBusiData.companyInfos.add(qQCircleBase$UserCircleInfo2);
                }
            }
            if (qQCircleBase$StUserBusiData != null) {
                feedCloudMeta$StUser.busiData.set(ByteStringMicro.copyFrom(qQCircleBase$StUserBusiData.toByteArray()));
            }
            if (Ah(qCirclePersonEditUpdateEvent) != null && (qQCircleProfile$StProfileBizData = qCirclePolymerizationViewModel.L) != null) {
                qQCircleProfile$StProfileBizData.groupIDList.set(Ah(qCirclePersonEditUpdateEvent));
                if (qCirclePersonEditUpdateEvent.isUpdateShowSchool()) {
                    qCirclePolymerizationViewModel.L.hideSchool.set(!qCirclePersonEditUpdateEvent.getShowSchool() ? 1 : 0);
                }
                qCirclePolymerizationViewModel.P.getValue().getData().editProfileButton.profileBusiData.set(ByteStringMicro.copyFrom(qCirclePolymerizationViewModel.L.toByteArray()));
            }
            qCirclePolymerizationViewModel.P.getValue().getData().editProfileButton.loginUser.set(feedCloudMeta$StUser);
            qCirclePolymerizationViewModel.g2(getContext(), this.C, false, false);
        }
    }

    private void vh(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState == 3) {
            th();
        }
    }

    private void wh() {
        if (!xh()) {
            this.G.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_HALFPAGE, 1);
        }
        int polymerizationType = this.C.getPolymerizationType();
        if (polymerizationType != 4) {
            if (polymerizationType != 7) {
                if (polymerizationType != 16) {
                    if (polymerizationType != 20) {
                        if (polymerizationType == 63) {
                            this.E = 303;
                            this.F = QCircleDaTongConstant.PageId.PG_XSJ_HOT_AGGREGATION_PAGE;
                            return;
                        }
                        return;
                    }
                    this.D = 9;
                    this.E = 72;
                    this.F = QCircleDaTongConstant.PageId.PG_XSJ_PORTFOLIO_FILTER;
                    return;
                }
                if (this.C.getPoiInfo() != null) {
                    this.G.put(QCircleDaTongConstant.ElementParamKey.XSJ_LBS_NAME, this.C.getPoiInfo().name.get());
                }
                this.E = 73;
                this.F = QCircleDaTongConstant.PageId.PG_XSJ_PORTFOLIO_POI;
                return;
            }
            if (this.C.getTagInfo() != null) {
                this.G.put("xsj_topic_name", this.C.getTagInfo().tagName.get());
                this.G.put("xsj_topic_id", this.C.getTagInfo().tagId.get());
                this.G.put("xsj_topic_page_source", this.C.getFeedTagPageFromType());
            }
            this.G.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_WHITELIST, 0);
            this.D = 8;
            this.E = 71;
            this.F = QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE;
            return;
        }
        this.F = QCircleDaTongConstant.PageId.PG_XSJ_CAMPUS_AGG_PAGE;
        if (this.C.getTagInfo() != null) {
            this.G.put(QCircleDaTongConstant.ElementParamKey.XSJ_CAMPUS_NAME, this.C.getTagInfo().tagName.get());
        }
        this.G.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
    }

    private void yh() {
        int i3;
        QCirclePolymerizationBean qCirclePolymerizationBean = this.C;
        if (qCirclePolymerizationBean == null) {
            QLog.e("QCirclePolymerizationFragment", 1, "[pageTypeParse] initBean is null");
            return;
        }
        int polymerizationType = qCirclePolymerizationBean.getPolymerizationType();
        if (polymerizationType != 4) {
            if (polymerizationType != 7) {
                if (polymerizationType != 16) {
                    if (polymerizationType != 20) {
                        if (polymerizationType == 63 && this.C.getHotEventInfo() != null) {
                            QCirclePolymerizationBean qCirclePolymerizationBean2 = this.C;
                            qCirclePolymerizationBean2.setPolymerizationName(qCirclePolymerizationBean2.getHotEventInfo().getTitle());
                        }
                    } else {
                        if (this.C.getSimulateData() != null) {
                            QCirclePolymerizationBean qCirclePolymerizationBean3 = this.C;
                            qCirclePolymerizationBean3.setPolymerizationName(qCirclePolymerizationBean3.getSimulateData().simulate_name.get());
                        }
                        i3 = 47;
                    }
                } else {
                    if (this.C.getPoiInfo() != null) {
                        this.C.setPolymerizationName(this.C.getPoiInfo().name.get());
                    }
                    i3 = 48;
                }
            } else {
                if (this.C.getTagInfo() != null) {
                    this.C.setPolymerizationName(this.C.getTagInfo().tagName.get());
                }
                i3 = 46;
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, this.F);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(i3).setSubActionType(1).setThrActionType(1).setExt1(String.valueOf(this.C.getExt1From())).setExt6(String.valueOf(this.C.getPolymerizationName())).setPageId(getPageId()).setfPageId(rh()));
        }
        if (this.C.getTagInfo() != null) {
            QCirclePolymerizationBean qCirclePolymerizationBean4 = this.C;
            qCirclePolymerizationBean4.setPolymerizationName(qCirclePolymerizationBean4.getTagInfo().tagName.get());
        }
        i3 = 0;
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, this.F);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(i3).setSubActionType(1).setThrActionType(1).setExt1(String.valueOf(this.C.getExt1From())).setExt6(String.valueOf(this.C.getPolymerizationName())).setPageId(getPageId()).setfPageId(rh()));
    }

    private List<MultiViewBlock> zh() {
        if (this.C == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.biz.qqcircle.bizparts.c qh5 = qh();
        qh5.setReportBean(getReportBean());
        arrayList.add(qh5);
        if (this.C.getPolymerizationType() != 7) {
            ae aeVar = new ae(new Bundle());
            aeVar.setReportBean(getReportBean());
            arrayList.add(aeVar);
        } else {
            arrayList.add(new aj(new Bundle()));
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (xh()) {
            arrayList.add(new t(this.C));
        }
        QCirclePolymerizationBodyPart qCirclePolymerizationBodyPart = new QCirclePolymerizationBodyPart(zh(), 1, 1);
        qCirclePolymerizationBodyPart.M9(this.C);
        qCirclePolymerizationBodyPart.N9(xh());
        qCirclePolymerizationBodyPart.setReportBean(getReportBean());
        arrayList.add(qCirclePolymerizationBodyPart);
        QFSSharePart qFSSharePart = new QFSSharePart();
        qFSSharePart.setReportBean(getReportBean());
        arrayList.add(qFSSharePart);
        arrayList.add(new QFSMainTabTipExpPart(true));
        QCirclePolymerizationBean qCirclePolymerizationBean = this.C;
        if (qCirclePolymerizationBean != null && qCirclePolymerizationBean.getPolymerizationType() != 16 && this.C.getPolymerizationType() != 63) {
            arrayList.add(new s());
        }
        arrayList.add(new br());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> map = this.G;
        if (map != null && map.size() == 0) {
            wh();
        }
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168633g52;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        if (TextUtils.isEmpty(this.F)) {
            wh();
        }
        return this.F;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCirclePersonEditUpdateEvent.class);
        eventClass.add(QCircleFeedEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePolymerizationFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        if (this.E == 0) {
            wh();
        }
        return this.E;
    }

    protected void initIntentData() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra("key_bundle_common_init_bean")) {
            this.C = (QCirclePolymerizationBean) intent.getSerializableExtra("key_bundle_common_init_bean");
            yh();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getWindow().setSoftInputMode(32);
        initViewModel();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        initIntentData();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QCircleReportHelper.getInstance().recordPageEndShow(getPageId(), isHaveInteractive());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCirclePersonEditUpdateEvent) {
            uh((QCirclePersonEditUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFeedEvent) {
            vh((QCircleFeedEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QCircleReportHelper.getInstance().recordPageStartShow(getPageId());
        if (xh()) {
            QFSQUIUtilsKt.i(getActivity(), R.color.qui_common_bg_bottom_light);
        }
    }

    public int sh() {
        QCirclePolymerizationBean qCirclePolymerizationBean = this.C;
        if (qCirclePolymerizationBean == null) {
            return 0;
        }
        return qCirclePolymerizationBean.getPolymerizationType();
    }

    protected boolean xh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<String> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable String str) {
        }
    }
}
