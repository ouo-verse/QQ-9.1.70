package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QFSPersonalGuildInfoInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSQUIPersonalEditTitlePart;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.part.ILazyLoader;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalGuildInfoBindingFragment extends QCircleBaseFragment implements ILazyLoader {
    public static final String G = "com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalGuildInfoBindingFragment";
    private QFSPersonalGuildInfoInitBean C;
    private com.tencent.biz.qqcircle.immersive.personal.part.w D;
    private QFSQUIPersonalEditTitlePart E;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.n F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<Long> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            QFSPersonalGuildInfoBindingFragment.this.F.Z1();
            QFSPersonalGuildInfoBindingFragment.this.F.U1(QFSPersonalGuildInfoBindingFragment.this.getHostActivity());
        }
    }

    private void initIntentData() {
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            this.C = (QFSPersonalGuildInfoInitBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            QLog.i(G, 1, "InitBean is null");
        }
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.n nVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.n) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.n.class);
        this.F = nVar;
        nVar.R1(getContext(), this.C.getSelectGuildId(), this.C.isNeedShow());
        this.F.O1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalGuildInfoBindingFragment.this.uh((UIStateData) obj);
            }
        });
        this.F.N1().observe(this, new a());
    }

    private void sh() {
        this.E.A9(getContext().getResources().getString(R.string.f189043yb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(Long l3) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.n nVar = this.F;
        if (nVar != null) {
            nVar.N1().setValue(l3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(UIStateData uIStateData) {
        com.tencent.biz.qqcircle.immersive.personal.part.w wVar = this.D;
        if (wVar != null) {
            wVar.z9(uIStateData);
        }
    }

    private void vh() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.n nVar = this.F;
        if (nVar == null) {
            QLog.e(G, 1, "[requestData]: view model is null");
        } else {
            nVar.T1();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSQUIPersonalEditTitlePart qFSQUIPersonalEditTitlePart = new QFSQUIPersonalEditTitlePart();
        this.E = qFSQUIPersonalEditTitlePart;
        arrayList.add(qFSQUIPersonalEditTitlePart);
        com.tencent.biz.qqcircle.immersive.personal.part.w wVar = new com.tencent.biz.qqcircle.immersive.personal.part.w();
        this.D = wVar;
        wVar.B9(new Consumer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.p
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QFSPersonalGuildInfoBindingFragment.this.th((Long) obj);
            }
        });
        arrayList.add(this.D);
        arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.part.u());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean enableSetStatusBarColor() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gmb;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return G;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        initIntentData();
        initViewModel();
        vh();
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
        sh();
    }
}
