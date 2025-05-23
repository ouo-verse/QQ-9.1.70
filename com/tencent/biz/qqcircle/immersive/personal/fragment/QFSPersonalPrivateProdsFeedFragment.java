package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.events.QFSDoTopProfileEvent;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalPrivateProdsFeedFragment extends QFSPersonalFeedFragment {
    private void Nh(QFSDoTopProfileEvent qFSDoTopProfileEvent) {
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter = this.J;
        if (qFSPersonalFeedAdapter == null) {
            return;
        }
        List<com.tencent.biz.qqcircle.immersive.personal.bean.k> dataList = qFSPersonalFeedAdapter.getDataList();
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = dataList.get(i3);
            if (kVar != null && TextUtils.equals(kVar.d(), qFSDoTopProfileEvent.mTargetFeedId)) {
                boolean q16 = kVar.q();
                boolean z16 = qFSDoTopProfileEvent.isDoProfile;
                if (q16 != z16) {
                    kVar.s(z16);
                    this.J.notifyItemChanged(i3);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    protected void Eh(UIStateData<List<e30.b>> uIStateData) {
        NestScrollRecyclerView nestScrollRecyclerView;
        if (uIStateData == null) {
            QLog.e("QFSPersonalPrivateProdsFeedFragment", 1, "[handleSuccess] uiStateData = " + uIStateData);
            return;
        }
        if (this.J != null && uIStateData.getData() != null && this.L != null) {
            QLog.e("QFSPersonalPrivateProdsFeedFragment", 1, "handleSuccess, size:" + uIStateData.getData().size() + ", livedata.hash:" + this.L.m2().hashCode() + ", UIstate:" + uIStateData.getState());
            ArrayList arrayList = new ArrayList();
            String l26 = this.L.l2();
            for (int i3 = 0; i3 < uIStateData.getData().size(); i3++) {
                e30.b bVar = uIStateData.getData().get(i3);
                if (bVar != null && bVar.g() != null) {
                    if (bVar.g().feedType.get() == 6 && bVar.g().type.get() == 4) {
                        QLog.d("QFSPersonalPrivateProdsFeedFragment", 1, "[handleSuccess] ditto feed -> guild, mViewModel.getOwnerUin() = " + this.L.i2());
                        arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.i(this.L.i2(), bVar, this.N, AudienceReportConst.EVENT_ID_BUFFER_END));
                    } else {
                        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = new com.tencent.biz.qqcircle.immersive.personal.bean.k(this.L.i2(), bVar, this.N);
                        if (!bVar.g().promoteInfo.usePromoteTicket.get() && TextUtils.equals(bVar.g().f398449id.get(), l26)) {
                            this.L.L2();
                        }
                        arrayList.add(kVar);
                    }
                }
            }
            QLog.i("QFSPersonalPrivateProdsFeedFragment", 1, "[handleSuccess] -> data size = " + arrayList.size());
            this.J.setDatas(arrayList);
            this.J.notifyDataSetChanged();
            if (!uIStateData.getIsLoadMore() && (nestScrollRecyclerView = this.I) != null) {
                nestScrollRecyclerView.scrollToPosition(0);
            }
            this.F.E9();
            return;
        }
        QLog.e("QFSPersonalPrivateProdsFeedFragment", 1, "[handleSuccess] mPersonalFeedAdapter = " + this.J + " mViewModel = " + this.L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    void Ih() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar == null) {
            return;
        }
        rVar.m2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalPrivateProdsFeedFragment.this.Mh((UIStateData) obj);
            }
        });
        this.L.c3(false, -1);
        t30.f fVar = new t30.f(getTAG(), t30.f.U1(this.J), this.L.m2());
        this.S = fVar;
        fVar.a2(1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    boolean Kh() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar == null) {
            return false;
        }
        return "qfs_personal_tab_private_prods".equals(rVar.t2());
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.vg9, Jh(), 2, 3);
        this.E = blockPart;
        arrayList.add(blockPart);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.F = yVar;
        arrayList.add(yVar);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSDoTopProfileEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalPrivateProdsFeedFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    protected void initViewModel() {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.K;
        if (qFSPersonalDetailsFragment == null) {
            QLog.i("QFSPersonalPrivateProdsFeedFragment", 1, "fsPersonalHomeFragment is null");
        } else {
            this.L = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(qFSPersonalDetailsFragment, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i("QFSPersonalPrivateProdsFeedFragment", 1, "onCreate, sourceType:" + this.N);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QFSPersonalPrivateProdsFeedFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSDoTopProfileEvent) {
            Nh((QFSDoTopProfileEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    protected void zh() {
        if (this.J == null) {
            return;
        }
        this.J.setDatas(new ArrayList());
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar != null && !rVar.K2()) {
            String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1932649q);
            String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1932549p);
            com.tencent.biz.qqcircle.immersive.personal.part.y yVar = this.F;
            if (yVar != null) {
                yVar.M9(a16, a17);
            }
        }
    }
}
