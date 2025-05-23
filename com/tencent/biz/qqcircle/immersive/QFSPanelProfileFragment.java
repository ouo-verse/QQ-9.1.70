package com.tencent.biz.qqcircle.immersive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.helpers.s;
import com.tencent.biz.qqcircle.immersive.events.QFSReleaseMiniFragmentEvent;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.part.av;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSPersonalConsumeTimeManager;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.r;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;

/* loaded from: classes4.dex */
public class QFSPanelProfileFragment extends QFSPersonalDetailsFragment implements Observer<e40.j> {

    /* renamed from: h0, reason: collision with root package name */
    private av f84709h0;

    /* renamed from: i0, reason: collision with root package name */
    private final t40.e f84710i0;

    public QFSPanelProfileFragment(t40.e eVar) {
        this.f84710i0 = eVar;
    }

    private void ri() {
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

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    protected com.tencent.biz.qqcircle.immersive.personal.adapter.j Fh(Bundle bundle) {
        return new com.tencent.biz.qqcircle.immersive.personal.adapter.a(bundle);
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
    public void Sh(Intent intent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        super.Sh(intent);
        if (feedCloudMeta$StFeed != null) {
            this.K = feedCloudMeta$StFeed;
            this.L = feedCloudMeta$StFeed.poster.get();
        }
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

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    public boolean Zh() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        av avVar = new av();
        this.f84709h0 = avVar;
        assembleParts.add(avVar);
        return assembleParts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.glq;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    protected boolean li() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getContext() != null) {
            w20.a.j().x(getContext().hashCode(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_mini_profile_adapt_navigation_bar", true)) {
            com.tencent.mobileqq.qui.b.f276860a.a(this.E, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        }
    }

    public ImageView pi() {
        t40.e eVar = this.f84710i0;
        if (eVar != null) {
            return eVar.t5();
        }
        return null;
    }

    public ImageView qi() {
        t40.e eVar = this.f84710i0;
        if (eVar != null) {
            return eVar.A();
        }
        return null;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: si, reason: merged with bridge method [inline-methods] */
    public void onChanged(e40.j jVar) {
        if (jVar == null) {
            return;
        }
        Context context = getContext();
        if (context != null && !s.f84663a.a(context.hashCode())) {
            vi(jVar.f395620a.get(), false);
        } else {
            QLog.d("QFSPanelProfileFragment", 1, "[onChanged] personal panel is showing");
        }
    }

    public void ti() {
        r rVar = this.N;
        if (rVar != null && rVar.J2()) {
            this.N.d3();
            this.N.T2(true);
        }
    }

    protected boolean ui() {
        return !isResumed();
    }

    public void vi(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        av avVar;
        if (com.tencent.biz.qqcircle.immersive.repository.foldertab.j.g(feedCloudMeta$StFeed)) {
            QLog.d("QFSPanelProfileFragment", 1, "stFeed is simple feed, ignore");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.K;
        this.K = feedCloudMeta$StFeed;
        ri();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed4 = this.K;
        if (feedCloudMeta$StFeed4 != null && feedCloudMeta$StFeed4.poster.has() && feedCloudMeta$StFeed3 != (feedCloudMeta$StFeed2 = this.K) && (avVar = this.f84709h0) != null) {
            avVar.A9(feedCloudMeta$StFeed2);
            if (this.N != null) {
                String g16 = bj.g(feedCloudMeta$StFeed3);
                String g17 = bj.g(this.K);
                QLog.d("QFSPanelProfileFragment", 1, "preFeedId:" + g16 + " currentFeedId:" + g17);
                if (!TextUtils.equals(g16, g17) && ui()) {
                    this.N.V2();
                    SimpleEventBus.getInstance().dispatchEvent(new QFSReleaseMiniFragmentEvent());
                }
                this.N.h3(this.K);
                if (z16) {
                    this.N.i3(this.K.poster.get(), true);
                }
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
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.j jVar = this.V;
            if (jVar != null) {
                jVar.setUin(this.K.poster.f398463id.get());
                this.V.Q1().setValue(null);
            }
        }
    }
}
