package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleTabPageFeedUpdateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFoldFullScreenChangeEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cs extends u implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f87940d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f87941e;

    /* renamed from: f, reason: collision with root package name */
    private String f87942f;

    /* renamed from: h, reason: collision with root package name */
    private View f87943h;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS && option != null) {
                cs.this.f87942f = option.getUrl();
            }
        }
    }

    private void A9() {
        QCircleHostGlobalInfo.setNeedRestoreFolderUi(true);
        t40.d dVar = (t40.d) getIocInterface(t40.d.class);
        if (dVar != null) {
            int lc5 = dVar.lc();
            RFWLog.d("QFSMainChipPart", RFWLog.USR, "[doSaveDataLogic] currentTabType:" + lc5);
            k30.e.i().u(lc5);
        }
    }

    private void B9(View view) {
        if (view == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f46691v_);
        if (viewStub == null) {
            RFWLog.d("QFSMainChipPart", RFWLog.USR, "[initFullScreenView] viewStub is null");
            return;
        }
        View inflate = viewStub.inflate();
        this.f87943h = inflate;
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.cr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                cs.this.C9(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        RFWLog.d("QFSMainChipPart", RFWLog.USR, "[initFullScreenView] user click jump fullScreen folder");
        A9();
        SimpleEventBus.getInstance().dispatchEvent(new QFSFoldFullScreenChangeEvent(getActivityHashCode(), true));
        QCircleFolderBean qCircleFolderBean = new QCircleFolderBean();
        qCircleFolderBean.setTabFullScreenMode(true);
        com.tencent.biz.qqcircle.launcher.c.I(getContext(), qCircleFolderBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void D9() {
        FeedCloudMeta$StUser m3;
        if (this.f87940d == null || (m3 = QCirclePluginGlobalInfo.m()) == null) {
            return;
        }
        String str = m3.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.f87942f)) {
            return;
        }
        this.f87940d.setAvatar(m3, com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.d3a));
    }

    private void E9() {
        int i3;
        if (this.f87941e == null) {
            QLog.d("QFSMainChipPart", 1, "[updateCloseButtonVisible] close button not is null.");
            return;
        }
        boolean M6 = uq3.c.M6();
        ImageView imageView = this.f87941e;
        if (M6) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleTabPageFeedUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainChipPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f46721vc) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(QCirclePluginGlobalInfo.m());
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            qCircleInitBean.setLaunchFrom("QFSMainChipPart");
            com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(21).setExt2(QFSMainMultiTabFragmentPart.Va()).setSubActionType(2));
        } else if (id5 == R.id.f46671v8) {
            if (QCircleHostGlobalInfo.isNowFlatState() && QCirclePluginUtil.isTabMode()) {
                QLog.d("QFSMainChipPart", 1, "[onBackClick] in split view mode");
                QCirclePluginUtil.setIsSplitModeInnerBackClk(true);
            }
            if (getActivity() != null) {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(21).setExt2(QFSMainMultiTabFragmentPart.Va()).setSubActionType(1));
                getActivity().onBackPressed();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u
    protected void onEnableSkinChange(boolean z16) {
        int i3;
        ImageView imageView = this.f87941e;
        if (imageView != null) {
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            if (z16) {
                i3 = R.drawable.qvideo_skin_icon_nav_arrow_left;
            } else {
                i3 = R.drawable.oli;
            }
            imageView.setImageDrawable(qCircleSkinHelper.getDrawable(i3));
        }
        View view = this.f87943h;
        if (view instanceof ImageView) {
            int i16 = -1;
            if (z16) {
                ImageView imageView2 = (ImageView) view;
                if (!QCircleSkinHelper.getInstance().isDarkMode()) {
                    i16 = -16777216;
                }
                imageView2.setColorFilter(i16);
                return;
            }
            ((ImageView) view).setColorFilter(-1);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QCircleAvatarView qCircleAvatarView = (QCircleAvatarView) view.findViewById(R.id.f46721vc);
        this.f87940d = qCircleAvatarView;
        if (qCircleAvatarView != null) {
            D9();
            this.f87940d.setOnClickListener(this);
            this.f87940d.d(new a());
            VideoReport.setElementId(this.f87940d, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_BUTTON);
            VideoReport.setElementParams(this.f87940d, new QCircleDTParamBuilder().buildElementParams());
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.f46671v8);
        this.f87941e = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
            VideoReport.setElementId(this.f87941e, "em_xsj_back_button");
            VideoReport.setElementParams(this.f87941e, new QCircleDTParamBuilder().buildElementParams());
        }
        if (QCircleHostGlobalInfo.getFolderUIType() == 3) {
            E9();
        }
        if (com.tencent.biz.qqcircle.utils.bz.f() && QCirclePluginUtil.isInLocalActivity(getActivity())) {
            ImageView imageView2 = this.f87941e;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            B9(view);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        D9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleTabPageFeedUpdateEvent) {
            D9();
        }
    }
}
