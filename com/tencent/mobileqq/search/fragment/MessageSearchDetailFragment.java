package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.model.aa;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MessageSearchDetailFragment extends BaseFragment {
    private static FullMessageSearchResult.SearchResultItem I;
    private TextView C;
    private ListView D;
    private String E;
    private FullMessageSearchResult.SearchResultItem F;
    private jn2.a G;
    private IFaceDecoder H;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends jn2.a<aa, sn2.g> {
        a(ListView listView, IFaceDecoder iFaceDecoder, FullMessageSearchResult.SearchResultItem searchResultItem, String str, QQAppInterface qQAppInterface) {
            super(listView, iFaceDecoder, searchResultItem, str, qQAppInterface);
        }

        @Override // mn2.a
        protected qn2.d e(int i3) {
            return new qn2.f(MessageSearchDetailFragment.this.H);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new sn2.g(viewGroup, R.layout.bxv);
        }
    }

    public static MessageSearchDetailFragment qh(String str, FullMessageSearchResult.SearchResultItem searchResultItem) {
        I = searchResultItem;
        MessageSearchDetailFragment messageSearchDetailFragment = new MessageSearchDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        messageSearchDetailFragment.setArguments(bundle);
        return messageSearchDetailFragment;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.F = I;
        I = null;
        this.E = getArguments().getString("keyword");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168267qt, viewGroup, false);
        this.C = (TextView) inflate.findViewById(R.id.d3z);
        this.D = (ListView) inflate.findViewById(R.id.eap);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IFaceDecoder iFaceDecoder = this.H;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i3;
        List<Long> list;
        super.onViewCreated(view, bundle);
        FullMessageSearchResult.SearchResultItem searchResultItem = this.F;
        if (searchResultItem != null && (list = searchResultItem.secondPageMessageUniseq) != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        this.C.setText(getString(R.string.h_k, Integer.valueOf(i3), this.E));
        this.H = ((IQQAvatarService) getBaseActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getBaseActivity().app);
        a aVar = new a(this.D, this.H, this.F, this.E, getBaseActivity().app);
        this.G = aVar;
        this.D.setAdapter((ListAdapter) aVar);
        this.G.i();
    }
}
