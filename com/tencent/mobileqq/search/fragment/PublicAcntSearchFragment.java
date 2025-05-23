package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.dj;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.searchlocal.searchengine.PublicAccountSearchEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.search.DynamicTabSearch$SubHotWord;

/* loaded from: classes18.dex */
public class PublicAcntSearchFragment extends BaseSearchFragment implements AbsListView.OnScrollListener {
    private static int J = -1;
    protected boolean D;
    protected int I;
    public boolean C = false;
    public byte[] E = null;
    protected String F = "";
    private long G = -1;
    protected dj H = new dj() { // from class: com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2
        @Override // com.tencent.mobileqq.app.dj
        public void handleTabSearchError(String str, boolean z16, String str2, int i3, String str3, long[] jArr) {
            if (QLog.isColorLevel()) {
                QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchError!!!");
            }
            PublicAcntSearchFragment publicAcntSearchFragment = PublicAcntSearchFragment.this;
            publicAcntSearchFragment.C = false;
            ((BaseSearchFragment) publicAcntSearchFragment).handler.sendEmptyMessage(3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x020c, code lost:
        
            if ((r0.get(0) instanceof com.tencent.mobileqq.search.model.i) == false) goto L61;
         */
        @Override // com.tencent.mobileqq.app.dj
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleTabSearchResult(String str, boolean z16, String str2, byte[] bArr, final boolean z17, List<x> list, long[] jArr, String str3, List<DynamicTabSearch$SubHotWord> list2, boolean z18, String str4, int i3) {
            int i16;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleTabSearchResult\uff0c keyword=");
                sb5.append(PublicAcntSearchFragment.this.keyword);
                sb5.append(", isFirstReq=");
                sb5.append(z16);
                sb5.append(" ,cookie = ");
                sb5.append(bArr);
                sb5.append(",result=");
                sb5.append(list != null ? list.size() : -1);
                QLog.i("PublicAcntSearchFragment", 2, sb5.toString());
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2.1
                @Override // java.lang.Runnable
                public void run() {
                    List<M> list3;
                    ((BaseSearchFragment) PublicAcntSearchFragment.this).footerLoadingJuhuaView.setVisibility(8);
                    if (z17 && (list3 = PublicAcntSearchFragment.this.mResultList) != 0 && list3.size() > 0) {
                        PublicAcntSearchFragment.this.showNoMoreResult(true);
                    }
                }
            });
            if (!TextUtils.equals(str2, PublicAcntSearchFragment.this.F)) {
                QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. reqKeyword=" + str + " keyword=" + PublicAcntSearchFragment.this.keyword + " reqTime=" + str2 + " lastReqTime=" + PublicAcntSearchFragment.this.F + " isEnd1=" + z17);
                return;
            }
            if (!TextUtils.equals(str, PublicAcntSearchFragment.this.keyword)) {
                QLog.d("PublicAcntSearchFragment", 2, "handleTabSearchResult. masks=" + jArr[0] + " reqKeyword=" + str + " keyword=" + PublicAcntSearchFragment.this.keyword + " isEnd1=" + z17);
                return;
            }
            if (list == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("PublicAcntSearchFragment", 2, "handleTabSearchResult result is null");
                }
                handleTabSearchError(str, z16, str2, -1, "result = null", jArr);
                return;
            }
            long j3 = -1;
            long j16 = -1;
            int i17 = 0;
            for (x xVar : list) {
                if (xVar.o() != null) {
                    if (xVar instanceof lo2.b) {
                        lo2.b bVar = (lo2.b) xVar;
                        if (j3 == -1) {
                            j3 = bVar.D;
                        }
                        j16 = bVar.D;
                    }
                    i17 += xVar.o().size();
                }
            }
            if (!z16) {
                SearchUtils.W0("sub_result", "load_result", PublicAcntSearchFragment.this.keyword, SearchUtils.e0(jArr), "", SearchUtils.g0("dynamic_tab_search.1", jArr));
            }
            if (i17 == 0) {
                SearchUtils.W0("sub_result", "no_result", PublicAcntSearchFragment.this.keyword, SearchUtils.e0(jArr), "", SearchUtils.g0("dynamic_tab_search.1", jArr));
            } else if (z16) {
                SearchUtils.W0("sub_result", "exp_result", PublicAcntSearchFragment.this.keyword, SearchUtils.e0(jArr), "", SearchUtils.g0("dynamic_tab_search.1", jArr));
            }
            PublicAcntSearchFragment publicAcntSearchFragment = PublicAcntSearchFragment.this;
            publicAcntSearchFragment.D = z17;
            publicAcntSearchFragment.C = false;
            publicAcntSearchFragment.E = bArr;
            List<M> list3 = publicAcntSearchFragment.mResultList;
            if (list3 != 0 && !list3.isEmpty()) {
                List<v> l3 = SearchUtil.l(list, z16);
                if (!z16 && j3 == PublicAcntSearchFragment.this.G && l3 != null && l3.size() > 0 && !z18) {
                    v vVar = (v) PublicAcntSearchFragment.this.mResultList.get(r1.size() - 1);
                    List<M> list4 = PublicAcntSearchFragment.this.mResultList;
                    int i18 = list4.get(list4.size() + (-1)) instanceof up2.b ? 0 : 0;
                    l3.remove(i18);
                    int i19 = 0;
                    int i26 = 0;
                    while (true) {
                        if (i19 >= l3.size()) {
                            i19 = i26;
                            break;
                        } else {
                            if (l3.get(i19) instanceof com.tencent.mobileqq.search.model.i) {
                                break;
                            }
                            i26 = i19;
                            i19++;
                        }
                    }
                    if (vVar instanceof y) {
                        y yVar = (y) vVar;
                        i16 = yVar.p();
                        rn2.k.e(yVar, i16 + i19, i16 - 1);
                    } else {
                        i16 = 0;
                    }
                    for (int i27 = 0; i27 < i19; i27++) {
                        v vVar2 = l3.get(i27);
                        if (vVar2 instanceof y) {
                            rn2.k.e((y) vVar2, i16 + i19, i16 + i27);
                        }
                    }
                }
                PublicAcntSearchFragment.this.mResultList.addAll(l3);
            } else {
                PublicAcntSearchFragment.this.mResultList = SearchUtil.l(list, z16);
            }
            for (int i28 = 0; i28 < PublicAcntSearchFragment.this.mResultList.size(); i28++) {
                if (PublicAcntSearchFragment.this.mResultList.get(i28) instanceof lo2.m) {
                    ((lo2.m) PublicAcntSearchFragment.this.mResultList.get(i28)).f283548i = 0;
                }
            }
            ((BaseSearchFragment) PublicAcntSearchFragment.this).adapter.g(PublicAcntSearchFragment.this.mResultList);
            PublicAcntSearchFragment.this.G = j16;
            if (PublicAcntSearchFragment.this.mResultList.size() == 0 && !TextUtils.isEmpty(PublicAcntSearchFragment.this.keyword) && z17) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PublicAcntSearchFragment.this.showNoResultLayout(true);
                        PublicAcntSearchFragment.this.showNoMoreResult(false);
                    }
                });
            }
        }
    };

    public static PublicAcntSearchFragment Ah(int i3) {
        J = i3;
        return new PublicAcntSearchFragment();
    }

    protected void Bh(List list) {
        this.C = true;
        if (QLog.isColorLevel()) {
            QLog.i("PublicAcntSearchFragment", 2, "sendNetPublicAcntRequest ,keyword=" + this.keyword);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ((BaseSearchFragment) PublicAcntSearchFragment.this).footerLoadingJuhuaView.setVisibility(0);
                ((BaseSearchFragment) PublicAcntSearchFragment.this).footerErrorView.setVisibility(8);
                PublicAcntSearchFragment.this.showNoMoreResult(false);
            }
        });
        List<Entity> publicAccountList = ((IPublicAccountDataManager) this.appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
        ArrayList arrayList = new ArrayList();
        if (publicAccountList != null && !publicAccountList.isEmpty()) {
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    v vVar = (v) list.get(i3);
                    if (vVar instanceof up2.b) {
                        up2.b bVar = (up2.b) vVar;
                        for (int i16 = 0; i16 < publicAccountList.size(); i16++) {
                            PublicAccountInfo publicAccountInfo = (PublicAccountInfo) publicAccountList.get(i16);
                            if (TextUtils.equals(String.valueOf(publicAccountInfo.uin), String.valueOf(bVar.X.getUinString()))) {
                                arrayList.add(Long.valueOf(publicAccountInfo.uin));
                            }
                        }
                    }
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("PublicAcntSearchFragment", 2, "all publicAccountInfoList is null or empty");
        }
        UniteSearchHandler uniteSearchHandler = (UniteSearchHandler) this.appInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
        Bundle bundle = new Bundle();
        bundle.putBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, true);
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, J);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Long.valueOf(Constant.FROM_ID_START_ACTIVITY));
        uniteSearchHandler.I2(this.keyword, this.F, 20, arrayList2, arrayList, this.E, 0.0d, 0.0d, bundle);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        if (J == 12) {
            return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.appInterface, BaseApplication.getContext());
        }
        return HardCodeUtil.qqStr(R.string.f172334pn0);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return HardCodeUtil.qqStr(R.string.jzs);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected int getSearchModule() {
        return 50;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean isNoResult() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean needShowHeader() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new jn2.h(this.listView, this.faceDecoder, this, 0);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        return new PublicAccountSearchEngine((QQAppInterface) this.appInterface, J);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appInterface.addObserver(this.H);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.F = System.currentTimeMillis() + "";
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        on2.b bVar = this.searchEngine;
        if (bVar instanceof PublicAccountSearchEngine) {
            ((PublicAccountSearchEngine) bVar).destroy();
        }
        this.E = null;
        this.appInterface.removeObserver(this.H);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, pn2.b bVar) {
        if (bVar.a(this.keyword)) {
            onFinish(list, bVar.f426500c);
        } else if (QLog.isColorLevel()) {
            QLog.d("PublicAcntSearchFragment", 2, "onFinish not match keyword1:", bVar.f426498a, " keyword2:", this.keyword);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.searchEngine.pause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.searchEngine.resume();
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        mn2.a aVar = this.adapter;
        if (aVar != null && aVar.getCount() != 0 && this.I != 0 && (i17 - i3) - i16 < 10 && !this.C && !this.D) {
            Bh(this.mResultList);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        this.I = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void onSearchTimeout(List list) {
        super.onSearchTimeout(list);
        this.footerErrorView.setVisibility(0);
        this.footerLoadingJuhuaView.setVisibility(8);
        showNoMoreResult(false);
        showNoResultLayout(false);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, int i3) {
        super.onFinish(list, i3);
        if (SearchUtils.F0(J) && !this.isReported) {
            this.isReported = true;
            String[] strArr = new String[2];
            strArr[0] = "" + this.keyword;
            strArr[1] = list == null ? "0" : "" + list.size();
            SearchUtils.W0("all_result", "exp_public_uin_page", strArr);
        }
        List<M> list2 = this.mResultList;
        if (list2 != 0 && !list2.isEmpty()) {
            for (int i16 = 0; i16 < this.mResultList.size(); i16++) {
                rn2.k.e((y) this.mResultList.get(i16), this.mResultList.size(), i16);
            }
            this.mResultList.add(0, new com.tencent.mobileqq.search.model.i(HardCodeUtil.qqStr(R.string.pln), "", ""));
        }
        this.E = null;
        if (!TextUtils.isEmpty(this.keyword)) {
            if (QLog.isColorLevel()) {
                QLog.i("PublicAcntSearchFragment", 2, "onFinish, search net result ,keyword = " + this.keyword);
            }
            Bh(this.mResultList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PublicAcntSearchFragment", 2, "keyword is empty ");
        }
    }
}
