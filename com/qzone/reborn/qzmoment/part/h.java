package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.qzmoment.bean.QZMFeedDetailInitBean;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.widget.QZMPageStateView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h extends an.a {
    private QZMPageStateView C;
    private com.qzone.reborn.qzmoment.viewmodel.i D;

    /* renamed from: d, reason: collision with root package name */
    private QZMFeedDetailInitBean f58956d;

    /* renamed from: e, reason: collision with root package name */
    private bn.b f58957e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f58958f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f58959h;

    /* renamed from: i, reason: collision with root package name */
    private SmartRefreshLayout f58960i;

    /* renamed from: m, reason: collision with root package name */
    private cn.d f58961m;

    private QZMFeedCommentInfo D9() {
        QZMFeedCommentInfo qZMFeedCommentInfo = new QZMFeedCommentInfo(this.f58957e.a());
        qZMFeedCommentInfo.mIsGuest = H9();
        qZMFeedCommentInfo.mIsFromHostPraise = false;
        qZMFeedCommentInfo.mTotalCommentCount = this.f58957e.a().commentCount.get();
        return qZMFeedCommentInfo;
    }

    private void F9(List<bn.b> list) {
        this.f58959h.setVisibility(0);
        this.C.setVisibility(8);
        this.f58961m.setItems(new ArrayList(list));
        if (list.size() == 0) {
            QLog.w("QZMFeedDetailPart", 1, "handleSuccessState is empty");
            return;
        }
        QZMFeedDetailInitBean qZMFeedDetailInitBean = this.f58956d;
        if (qZMFeedDetailInitBean == null) {
            QLog.w("QZMFeedDetailPart", 1, "init bean is null");
        } else if ("comment".equals(qZMFeedDetailInitBean.getPopup())) {
            this.f58957e = list.get(0);
            showCommentPanel();
        }
    }

    private void G9() {
        this.C.setData(new bn.h().c(new QUIEmptyState.Builder(getContext()).setImageType(8).setTitle(HardCodeUtil.qqStr(R.string.f133586i)).setThemeType(2).setBackgroundColorType(0)).d(new QUIEmptyState.Builder(getContext()).setImageType(5).setTitle(HardCodeUtil.qqStr(R.string.f133596j)).setThemeType(2).setBackgroundColorType(0)));
    }

    private boolean H9() {
        bn.b bVar = this.f58957e;
        if (bVar == null || bVar.a() == null || this.f58957e.a().poster == null) {
            return true;
        }
        return !TextUtils.equals(LoginData.getInstance().getUinString(), this.f58957e.a().poster.f430367id.get());
    }

    private void I9() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            Intent intent = getActivity().getIntent();
            if (intent.getExtras() == null) {
                QLog.e("QZMFeedDetailPart", 1, "extra is null");
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras.get("key_bundle_common_init_bean") instanceof QZMFeedDetailInitBean) {
                this.f58956d = (QZMFeedDetailInitBean) extras.get("key_bundle_common_init_bean");
                return;
            }
            return;
        }
        QLog.e("QZMFeedDetailPart", 1, "qzm activity is null");
    }

    private void J9() {
        this.f58959h.setVisibility(4);
        this.C.p0();
    }

    private void K9(UIStateData<List<bn.b>> uIStateData) {
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        this.f58959h.setVisibility(4);
        this.C.showErrorView();
    }

    private void initData() {
        com.qzone.reborn.qzmoment.viewmodel.i iVar = (com.qzone.reborn.qzmoment.viewmodel.i) getViewModel(com.qzone.reborn.qzmoment.viewmodel.i.class);
        this.D = iVar;
        iVar.O1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.qzmoment.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.this.E9((UIStateData) obj);
            }
        });
        this.D.S1(this.f58956d);
    }

    private void showCommentPanel() {
        gn.d dVar = (gn.d) getIocInterface(gn.d.class);
        if (dVar == null || this.f58958f) {
            return;
        }
        dVar.J6(D9());
        this.f58958f = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.C = (QZMPageStateView) view.findViewById(R.id.mhv);
        this.f58959h = (RecyclerView) view.findViewById(R.id.nf7);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.f162941ng1);
        this.f58960i = smartRefreshLayout;
        smartRefreshLayout.setEnableRefresh(false);
        this.f58960i.setEnableLoadMore(false);
        this.f58960i.setEnableOverScrollDrag(true);
        this.f58959h.setItemAnimator(null);
        this.f58959h.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        cn.d dVar = new cn.d();
        this.f58961m = dVar;
        dVar.setHasStableIds(true);
        this.f58959h.setAdapter(this.f58961m);
        I9();
        initData();
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        cn.d dVar = this.f58961m;
        if (dVar != null) {
            dVar.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        cn.d dVar = this.f58961m;
        if (dVar != null) {
            dVar.l0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        cn.d dVar = this.f58961m;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        cn.d dVar = this.f58961m;
        if (dVar != null) {
            dVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(UIStateData<List<bn.b>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        QLog.i(getTAG(), 1, "handleFeedListRsp()  state = " + uIStateData.getState());
        int state = uIStateData.getState();
        if (state == 0) {
            J9();
            return;
        }
        if (state == 2 || state == 3) {
            F9(uIStateData.getData());
        } else {
            if (state != 4) {
                return;
            }
            K9(uIStateData);
        }
    }
}
