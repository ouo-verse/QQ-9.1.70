package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.events.QFSDeleteBtnShowEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public class QFSPersonalRecentlyWatchedFragment extends QCircleBaseFragment {
    private com.tencent.biz.qqcircle.immersive.personal.adapter.h C;
    private QFSBaseBlockPart D;
    private BlockContainer E;
    private RefreshHeaderView F;
    private QUISecNavBar G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Function2<View, BaseAction, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                QFSPersonalRecentlyWatchedFragment.this.onBackEvent();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.biz.qui.quisecnavbar.a {
        b() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            QFSPersonalRecentlyWatchedFragment.this.qh(view);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            return false;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            return R.drawable.qui_delete;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return R.drawable.qui_delete;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    private void initTitleBar(View view) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.f55572i_);
        this.G = qUISecNavBar;
        qUISecNavBar.setAutoAdaptTransparent(true);
        this.G.setLeftImageRes(R.drawable.qui_chevron_left);
        this.G.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        this.G.setTitleAlpha(0.0f);
        this.G.setOnBaseTitleBarClickListener(new a());
        b bVar = new b();
        this.G.d(bVar);
        View h16 = this.G.h(bVar);
        if (h16 != null) {
            VideoReport.setElementId(h16, "em_xsj_back_button");
            VideoReport.setElementParams(h16, new QCircleDTParamBuilder().buildElementParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(final View view) {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f194554c8), com.tencent.biz.qqcircle.utils.h.a(R.string.cancel), com.tencent.biz.qqcircle.utils.h.a(R.string.f194544c7), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalRecentlyWatchedFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.l lVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.l) QFSPersonalRecentlyWatchedFragment.this.getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.l.class);
                if (lVar == null) {
                    return;
                }
                lVar.O1();
                QFSRecentlyWatchedRecorder.i().f();
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalRecentlyWatchedFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_BUTTON);
                        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_BUTTON);
                        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
                    }
                });
            }
        }, new c()).show();
    }

    private void rh() {
        this.E = this.D.getBlockContainer();
        this.F = new RefreshHeaderView(getContext());
        this.D.getBlockContainer().setRefreshHeader(this.F);
        this.E.setParentFragment(this);
        this.E.setEnableRefresh(true);
        this.E.setEnableLoadMore(false);
    }

    private List<MultiViewBlock> sh() {
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        if (getQCircleInitBean() != null && getQCircleInitBean().getUin() != null) {
            bundle.putString("key_bundle_owner_uin", getQCircleInitBean().getUin());
        }
        bundle.putInt("key_bundle_source_type", ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP);
        this.C = new com.tencent.biz.qqcircle.immersive.personal.adapter.h(bundle);
        arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.adapter.s(null));
        arrayList.add(this.C);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSBaseBlockPart qFSBaseBlockPart = new QFSBaseBlockPart(R.id.f486220h, sh(), 2, 1);
        this.D = qFSBaseBlockPart;
        arrayList.add(qFSBaseBlockPart);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168730gn0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_RECENT_WATCHED_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSDeleteBtnShowEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalRecentlyWatchedFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getActivity() != null) {
            getActivity().finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QUISecNavBar qUISecNavBar;
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QFSDeleteBtnShowEvent) && (qUISecNavBar = this.G) != null) {
            qUISecNavBar.setRightIconLayoutVisible(((QFSDeleteBtnShowEvent) simpleBaseEvent).mIsShow);
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSQUIUtilsKt.h(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        rh();
        initTitleBar(view);
    }
}
