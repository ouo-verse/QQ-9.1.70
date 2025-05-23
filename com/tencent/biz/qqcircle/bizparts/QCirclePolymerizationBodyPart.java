package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleEditProfileBean;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleBase$UserCircleInfo;
import qqcircle.QQCircleFeedBase$StEditProfileButton;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StPublisherButton;
import qqcircle.QQCircleProfile$GuildInfo;
import qqcircle.QQCircleProfile$StProfileBizData;

/* loaded from: classes4.dex */
public class QCirclePolymerizationBodyPart extends QCircleBaseBlockPart implements View.OnClickListener {
    private View C;
    private View D;
    private c E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private QCirclePolymerizationBean f82721d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.bizparts.c f82722e;

    /* renamed from: f, reason: collision with root package name */
    private QCirclePolymerizationViewModel f82723f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleBlockContainer f82724h;

    /* renamed from: i, reason: collision with root package name */
    private String f82725i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f82726m;

    /* loaded from: classes4.dex */
    class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState() && QCirclePolymerizationBodyPart.this.f82723f != null) {
                QCirclePolymerizationBodyPart.this.f82723f.g2(QCirclePolymerizationBodyPart.this.getContext(), QCirclePolymerizationBodyPart.this.f82721d, true, false);
            } else if (loadInfo.isRefreshState()) {
                QCirclePolymerizationBodyPart.this.L9(false);
            } else if (loadInfo.isInitState()) {
                QCirclePolymerizationBodyPart.this.L9(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            QCirclePolymerizationBodyPart.this.O9(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements OnTaskListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QCirclePolymerizationBodyPart> f82729a;

        public c(QCirclePolymerizationBodyPart qCirclePolymerizationBodyPart) {
            this.f82729a = new WeakReference<>(qCirclePolymerizationBodyPart);
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            WeakReference<QCirclePolymerizationBodyPart> weakReference = this.f82729a;
            if (weakReference != null && weakReference.get() != null && objArr != null && objArr.length == 4) {
                this.f82729a.get().H9(objArr);
            }
        }
    }

    public QCirclePolymerizationBodyPart(List<MultiViewBlock> list, int i3, int i16) {
        super(R.id.uaf, list, i3, i16);
        if (list != null && list.size() > 0) {
            this.f82722e = (com.tencent.biz.qqcircle.bizparts.c) list.get(0);
        }
    }

    private void F9(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
        if (this.f82721d != null && uIStateData != null) {
            QQCircleFeedBase$StFeedListBusiRspData data = uIStateData.getData();
            int polymerizationType = this.f82721d.getPolymerizationType();
            if (polymerizationType != 4) {
                if (polymerizationType == 7) {
                    broadcastMessage("tab_rsp", uIStateData.getData());
                    if (data != null && data.tagPageData.tagInfo.has()) {
                        com.tencent.biz.qqcircle.manager.e b16 = com.tencent.biz.qqcircle.manager.e.b();
                        String str = data.tagPageData.tagInfo.tagId.get();
                        boolean z16 = true;
                        if (data.tagPageData.tagInfo.followState.get() != 1) {
                            z16 = false;
                        }
                        b16.c(str, z16);
                        return;
                    }
                    return;
                }
                return;
            }
            I9(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state != 0) {
            if ((state != 2 && state != 3) || uIStateData.getData() == null) {
                return;
            }
            this.f82722e.setDatas(new ArrayList(Arrays.asList(uIStateData.getData())));
            this.f82722e.notifyLoadingComplete(true);
            F9(uIStateData);
            return;
        }
        QLog.e("QCirclePolymerizationBodyPart", 1, "handleHeaderRsp() return empty data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9(Object... objArr) {
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = this.f82723f;
        if (qCirclePolymerizationViewModel == null) {
            return;
        }
        qCirclePolymerizationViewModel.d2(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], (FeedCloudRead$StGetFeedListRsp) objArr[3], false, this.f82721d, this.f82723f.a2());
    }

    private void I9(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
        View view;
        QQCircleFeedBase$StEditProfileButton qQCircleFeedBase$StEditProfileButton;
        if (qQCircleFeedBase$StFeedListBusiRspData != null && qQCircleFeedBase$StFeedListBusiRspData.schoolPageData.has()) {
            int i3 = qQCircleFeedBase$StFeedListBusiRspData.schoolPageData.guildType.get();
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 && (qQCircleFeedBase$StEditProfileButton = qQCircleFeedBase$StFeedListBusiRspData.editProfileButton) != null && !TextUtils.isEmpty(qQCircleFeedBase$StEditProfileButton.title.get())) {
                        Q9(qQCircleFeedBase$StFeedListBusiRspData.editProfileButton.title.get(), true);
                        getPartManager().broadcastMessage("publish_show_or_hide", Boolean.FALSE);
                        P9(uq3.c.k3(), this.f82726m, "sp_key_school_aggr_edit_profile_guide_show");
                        return;
                    }
                    return;
                }
                QQCircleFeedBase$StPublisherButton qQCircleFeedBase$StPublisherButton = qQCircleFeedBase$StFeedListBusiRspData.publisherButton;
                if (qQCircleFeedBase$StPublisherButton != null && !TextUtils.isEmpty(qQCircleFeedBase$StPublisherButton.title.get())) {
                    getPartManager().broadcastMessage("publish_show_or_hide", Boolean.TRUE);
                    Q9("", false);
                    String l3 = uq3.c.l3();
                    View view2 = this.C;
                    if (view2 != null && view2.getVisibility() == 0) {
                        view = this.C;
                    } else {
                        view = this.D;
                    }
                    P9(l3, view, "sp_key_school_aggr_publish_guide_show");
                    return;
                }
                return;
            }
            Q9("", false);
            getPartManager().broadcastMessage("publish_show_or_hide", Boolean.FALSE);
        }
    }

    private void J9() {
        MutableLiveData<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> mutableLiveData;
        boolean z16;
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = this.f82723f;
        if (qCirclePolymerizationViewModel != null && (mutableLiveData = qCirclePolymerizationViewModel.P) != null && mutableLiveData.getValue() != null && this.f82723f.P.getValue().getData() != null && this.f82723f.P.getValue().getData().editProfileButton != null && this.f82723f.P.getValue().getData().editProfileButton.loginUser != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.f82723f.P.getValue().getData().editProfileButton.loginUser;
            QCircleEditProfileBean qCircleEditProfileBean = new QCircleEditProfileBean();
            qCircleEditProfileBean.setHostUin(HostDataTransUtils.getAccount());
            qCircleEditProfileBean.setAvatarUrl(feedCloudMeta$StUser.icon.iconUrl.get());
            qCircleEditProfileBean.setNick(feedCloudMeta$StUser.nick.get());
            qCircleEditProfileBean.setGender(feedCloudMeta$StUser.sex.get());
            qCircleEditProfileBean.setConstellation(feedCloudMeta$StUser.constellation.get());
            qCircleEditProfileBean.setLocation(com.tencent.biz.qqcircle.utils.af.c(feedCloudMeta$StUser.location.get()));
            qCircleEditProfileBean.setLocationCode(feedCloudMeta$StUser.locationCode.get());
            qCircleEditProfileBean.setDesc(feedCloudMeta$StUser.desc.get());
            QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData = this.f82723f.L;
            if (qQCircleProfile$StProfileBizData != null) {
                qCircleEditProfileBean.setGroup(com.tencent.biz.qqcircle.utils.af.b(qQCircleProfile$StProfileBizData.bindGroupStatus.get(), this.f82723f.L.bind_groups.get()));
                qCircleEditProfileBean.setBindChannelStatus(this.f82723f.L.bindGuildStatus.get());
                qCircleEditProfileBean.setUpdateSchoolNum(this.f82723f.L.updateSchoolNum.get());
                if (this.f82723f.L.hideSchool.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qCircleEditProfileBean.setShowSchool(z16);
                qCircleEditProfileBean.setStProfileBizData(this.f82723f.L.toByteArray());
            }
            PBRepeatMessageField<QQCircleBase$UserCircleInfo> pBRepeatMessageField = this.f82723f.N.schoolInfos;
            if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty() && this.f82723f.N.schoolInfos.get().size() > 0) {
                qCircleEditProfileBean.setSchool(this.f82723f.N.schoolInfos.get().get(0).name.get());
            }
            PBRepeatMessageField<QQCircleBase$UserCircleInfo> pBRepeatMessageField2 = this.f82723f.N.companyInfos;
            if (pBRepeatMessageField2 != null && !pBRepeatMessageField2.isEmpty() && this.f82723f.N.companyInfos.get().size() > 0) {
                qCircleEditProfileBean.setCompany(this.f82723f.N.companyInfos.get(0).name.get());
            }
            QQCircleProfile$GuildInfo qQCircleProfile$GuildInfo = this.f82723f.M;
            if (qQCircleProfile$GuildInfo != null) {
                qCircleEditProfileBean.setBindChannel(qQCircleProfile$GuildInfo.name.get());
                qCircleEditProfileBean.setBindChannelID(this.f82723f.M.guildId.get() + "");
            }
            com.tencent.biz.qqcircle.launcher.c.f0(getContext(), qCircleEditProfileBean);
        }
    }

    private void K9() {
        if (this.f82721d == null) {
            return;
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        int polymerizationType = this.f82721d.getPolymerizationType();
        if (polymerizationType != 4) {
            if (polymerizationType != 7) {
                if (polymerizationType != 16) {
                    if (polymerizationType == 20) {
                        qCircleExtraTypeInfo.pageType = 13;
                        getPartManager().broadcastMessage("publish_show_or_hide", Boolean.TRUE);
                    }
                } else {
                    qCircleExtraTypeInfo.pageType = 12;
                    getPartManager().broadcastMessage("publish_show_or_hide", Boolean.FALSE);
                }
            } else {
                qCircleExtraTypeInfo.pageType = 7;
                getPartManager().broadcastMessage("publish_show_or_hide", Boolean.TRUE);
            }
        } else {
            qCircleExtraTypeInfo.pageType = 4;
            getPartManager().broadcastMessage("publish_show_or_hide", Boolean.FALSE);
        }
        qCircleExtraTypeInfo.title = this.f82721d.getPolymerizationName();
        qCircleExtraTypeInfo.mGlobalViewModelKey = String.valueOf(this.f82721d.getPolymerizationType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9(boolean z16) {
        if (this.f82723f == null) {
            return;
        }
        boolean exists = PreLoader.exists("2008");
        QLog.i("QCirclePolymerizationBodyPart", 1, "refreshPolymerizationData isPreload : " + exists + " =====  enableCache : " + z16);
        if (exists) {
            QLog.i("QCirclePolymerizationBodyPart", 1, "runPreload");
            c cVar = new c(this);
            this.E = cVar;
            PreLoader.addListener("2008", cVar);
            return;
        }
        this.f82723f.g2(getContext(), this.f82721d, false, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9(int i3) {
        if (i3 == 0) {
            QCircleHostDropFrameMonitorHelper.stopMonitorScene(QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_POLYMERIZATION_PAGE(), false);
        } else {
            QCircleHostDropFrameMonitorHelper.startMonitorScene(QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_POLYMERIZATION_PAGE());
        }
    }

    private void P9(String str, View view, String str2) {
        if (view != null && view.getVisibility() == 0) {
            if (!TextUtils.isEmpty(str) && com.tencent.biz.qqcircle.f.G(str2, true)) {
                QLog.d("QCirclePolymerizationBodyPart", 1, "[showBubbleView] text: " + str);
                mc0.a.d(getContext(), str).setAnchor(view).setPosition(0).setAlignment(0).setBubbleBackground(QFSQUIUtilsKt.d(view.getContext(), R.color.qui_common_bg_top_dark)).setDismissInterval(5000L);
                com.tencent.biz.qqcircle.f.g0(str2, false);
                return;
            }
            return;
        }
        QLog.e("QCirclePolymerizationBodyPart", 1, "[showBubbleView] targetView is not showing.");
    }

    private void Q9(String str, boolean z16) {
        int i3;
        LinearLayout linearLayout = this.f82726m;
        if (linearLayout == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        TextView textView = (TextView) this.f82726m.getChildAt(1);
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void initViewModel() {
        this.f82725i = String.valueOf(this.f82721d.getPolymerizationType());
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = (QCirclePolymerizationViewModel) getViewModel(QCirclePolymerizationViewModel.class);
        this.f82723f = qCirclePolymerizationViewModel;
        qCirclePolymerizationViewModel.k2(this.f82721d);
        w20.a.j().registerDisplaySurface(this.f82725i, this.f82723f);
        this.f82723f.P.observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCirclePolymerizationBodyPart.this.G9((UIStateData) obj);
            }
        });
    }

    public void M9(QCirclePolymerizationBean qCirclePolymerizationBean) {
        this.f82721d = qCirclePolymerizationBean;
    }

    public void N9(boolean z16) {
        this.F = z16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.bsl) {
            J9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        int i3;
        this.f82724h = (QCircleBlockContainer) view.findViewById(R.id.uaf);
        this.f82726m = (LinearLayout) view.findViewById(R.id.bsl);
        this.C = view.findViewById(R.id.ypy);
        this.D = view.findViewById(R.id.f166105yq1);
        if (this.F) {
            i3 = t.I + ImmersiveUtils.getStatusBarHeight(view.getContext());
        } else {
            i3 = t.J;
        }
        this.f82724h.setPadding(0, i3, 0, 0);
        this.f82724h.setParentFragment(getHostFragment());
        this.f82724h.setEnableRefresh(false);
        this.f82724h.setEnableLoadMore(false);
        LinearLayout linearLayout = this.f82726m;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationBodyPart.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoReport.setElementId(QCirclePolymerizationBodyPart.this.f82726m, QCircleDaTongConstant.ElementId.EM_XSJ_WRITE_CAMPUS_BUTTON);
                    VideoReport.setElementParams(QCirclePolymerizationBodyPart.this.f82726m, new QCircleDTParamBuilder().buildElementParams());
                    VideoReport.setElementExposePolicy(QCirclePolymerizationBodyPart.this.f82726m, ExposurePolicy.REPORT_ALL);
                }
            });
        }
        initViewModel();
        this.f82722e.setOnLoadDataDelegate(new a());
        K9();
        super.onInitView(view);
        if (getBlockContainer() != null && getBlockContainer().getRecyclerView() != null) {
            getBlockContainer().setEnableRefresh(false);
            getBlockContainer().setEnableLoadMore(true);
            getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
            getBlockContainer().getRecyclerView().addOnScrollListener(new b());
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        PreLoader.remove("2008");
    }
}
