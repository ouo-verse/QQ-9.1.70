package com.qzone.reborn.feedx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.base.b;
import com.qzone.reborn.feedx.block.z;
import com.qzone.reborn.feedx.part.aj;
import com.qzone.reborn.feedx.part.bf;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.feedx.part.detail.QZoneFeedxDetailAnimPart;
import com.qzone.reborn.feedx.part.detail.aa;
import com.qzone.reborn.feedx.part.detail.ac;
import com.qzone.reborn.feedx.part.detail.i;
import com.qzone.reborn.feedx.part.detail.j;
import com.qzone.reborn.feedx.part.detail.l;
import com.qzone.reborn.feedx.part.detail.n;
import com.qzone.reborn.feedx.part.detail.p;
import com.qzone.reborn.feedx.part.detail.u;
import com.qzone.reborn.feedx.part.x;
import com.qzone.reborn.feedx.util.QZoneFeedxAnimUtils;
import com.qzone.reborn.feedx.viewmodel.h;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.richframework.data.base.UIStateData;
import gf.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedXDetailFragment extends QZoneBaseFragment implements k {
    private i C;
    private com.qzone.reborn.feedx.viewmodel.h D;
    private fh.b E;

    private void initIoc() {
        registerIoc(this, k.class);
    }

    private void initViewModel() {
        com.qzone.reborn.feedx.viewmodel.h hVar = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        this.D = hVar;
        hVar.P1(new a());
    }

    private void parseIntent(Intent intent) {
        this.D.G2(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void qh() {
        jo.h.f410717a.h("page_launch_feed_detail").t("FEED_SHOW");
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        i iVar = new i(R.id.n2d, buildBlockList());
        this.C = iVar;
        arrayList.add(iVar);
        arrayList.add(new aj());
        arrayList.add(new ac());
        if (QZoneFeedxAnimUtils.f55700a.d()) {
            arrayList.add(new QZoneFeedxDetailAnimPart());
        }
        arrayList.add(new aa());
        arrayList.add(new com.qzone.reborn.feedx.part.detail.k());
        arrayList.add(new n(false));
        arrayList.add(new x());
        arrayList.add(new u());
        arrayList.add(new j());
        arrayList.add(new p());
        arrayList.add(new com.qzone.reborn.feedx.part.i(false));
        arrayList.add(new bf());
        arrayList.add(new cc("page_launch_feed_detail"));
        arrayList.add(new l());
        return arrayList;
    }

    List<MultiViewBlock> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new z(null));
        arrayList.add(new com.qzone.reborn.feedx.block.h(null));
        arrayList.add(new com.qzone.reborn.feedx.block.j(null));
        com.qzone.reborn.feedx.block.k kVar = new com.qzone.reborn.feedx.block.k(null);
        arrayList.add(kVar);
        kVar.setBlockVisible(false);
        if (!com.qzone.reborn.configx.g.f53821a.b().U1()) {
            arrayList.add(new com.qzone.reborn.feedx.block.g(null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongDynamicParams() {
        MutableLiveData<UIStateData<BusinessFeedData>> mutableLiveData;
        BusinessFeedData data;
        HashMap hashMap = new HashMap();
        com.qzone.reborn.feedx.viewmodel.h hVar = this.D;
        return (hVar == null || (mutableLiveData = hVar.f55901m) == null || mutableLiveData.getValue() == null || (data = this.D.f55901m.getValue().getData()) == null) ? hashMap : fh.b.b(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167288ci2;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_dynamic_detail_page";
    }

    @Override // gf.k
    public int getPageType() {
        com.qzone.reborn.feedx.viewmodel.h hVar = this.D;
        return (hVar == null || !hVar.u2()) ? 2 : 8;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        com.qzone.reborn.feedx.viewmodel.h hVar = this.D;
        if (hVar == null || hVar.p2() == -1) {
            return 3;
        }
        return this.D.p2();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getActivity().getWindow());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        BusinessFeedData X1;
        if (this.D.m2() == 2 && (X1 = this.D.X1()) != null && !TextUtils.isEmpty(X1.getFeedCommInfo().ugckey)) {
            Intent intent = new Intent();
            intent.putExtra("lloc", this.D.j2());
            intent.putExtra(PictureConst.PHOTO_MYLIKE, X1.getLikeInfo().isLiked);
            intent.putExtra(PictureConst.PHOTO_LIKE_NUM, X1.getLikeInfo().likeNum);
            intent.putExtra(PictureConst.PHOTO_COMMENT_NUM, X1.getCommentInfo().commentNum);
            intent.putExtra(PictureConst.CELL_ID, X1.getIdInfo().cellId);
            getActivity().setResult(-1, intent);
            getActivity().finish();
            return true;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.E = new fh.b(getMFromDtPageId());
        RFWIocAbilityProvider.g().registerIoc(view, this.E, gf.e.class);
        i iVar = this.C;
        if (iVar == null || iVar.getBlockContainer() == null || this.C.getBlockContainer().getBlockMerger() == null) {
            return;
        }
        this.C.getBlockContainer().getBlockMerger().k0(new b.a() { // from class: com.qzone.reborn.feedx.fragment.a
            @Override // com.qzone.reborn.base.b.a
            public final void S() {
                QZoneFeedXDetailFragment.qh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        initIoc();
        initViewModel();
        if (getActivity() != null) {
            parseIntent(getActivity().getIntent());
        }
        if (getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        getActivity().getWindow().setSoftInputMode(34);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements h.b {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.h.b
        public void K6(QZoneResult qZoneResult) {
            if (QZoneFeedXDetailFragment.this.getActivity() == null || QZoneFeedXDetailFragment.this.getActivity().isFinishing()) {
                return;
            }
            new tn.a().e(QZoneFeedXDetailFragment.this.getActivity(), qZoneResult);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.h.b
        public void onHandleMessage(Message message) {
        }
    }
}
