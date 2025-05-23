package com.tencent.mobileqq.search.fragment;

import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MessageSearchFragment extends BaseSearchFragment {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends mn2.b<y, sn2.c> {
        a(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            return new qn2.f(((BaseSearchFragment) MessageSearchFragment.this).faceDecoder);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new sn2.g(viewGroup, R.layout.bxs);
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        return getString(R.string.h_l);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return HardCodeUtil.qqStr(R.string.jzq);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected int getSearchModule() {
        return 40;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new a(this.listView, this.faceDecoder);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        return new MessageSearchEngine((QQAppInterface) this.appInterface);
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

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void startSearch(String str) {
        super.startSearch(str, 2);
    }
}
