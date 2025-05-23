package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSelectorSearchFragment extends BaseSearchFragment<y> implements com.tencent.mobileqq.filemanager.data.search.e {
    private int C;
    private Bundle D;
    private FileSelectorSearchEngine E;
    private FileSelectorSearchAdapter F;
    private com.tencent.mobileqq.filemanager.widget.e G;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class FileSelectorSearchAdapter extends mn2.a<y, sn2.c> {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment$FileSelectorSearchAdapter$4, reason: invalid class name */
        /* loaded from: classes12.dex */
        class AnonymousClass4 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FileSelectorSearchAdapter f207926d;

            @Override // java.lang.Runnable
            public void run() {
                ((BaseSearchFragment) FileSelectorSearchFragment.this).fragmentView.findViewById(R.id.d3z).setVisibility(0);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment$FileSelectorSearchAdapter$5, reason: invalid class name */
        /* loaded from: classes12.dex */
        class AnonymousClass5 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FileSelectorSearchAdapter f207927d;

            @Override // java.lang.Runnable
            public void run() {
                ((BaseSearchFragment) FileSelectorSearchFragment.this).fragmentView.findViewById(R.id.d3z).setVisibility(8);
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements e {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.data.search.selector.e
            public void a() {
                FileSelectorSearchFragment.this.G.f();
            }
        }

        public FileSelectorSearchAdapter() {
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            b bVar = new b();
            bVar.e(new a());
            return bVar;
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new c(viewGroup);
        }

        @Override // mn2.a
        public void g(List<y> list) {
            super.g(list);
            if (list != null && list.size() > 0) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((BaseSearchFragment) FileSelectorSearchFragment.this).fragmentView.findViewById(R.id.d3z).setVisibility(0);
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment.FileSelectorSearchAdapter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((BaseSearchFragment) FileSelectorSearchFragment.this).fragmentView.findViewById(R.id.d3z).setVisibility(8);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        int i3 = this.C;
        if (i3 == 16) {
            return getQBaseActivity().getString(R.string.b6n);
        }
        if (i3 == 17) {
            return getQBaseActivity().getString(R.string.b67);
        }
        if (i3 == 18) {
            return getQBaseActivity().getString(R.string.b5k);
        }
        if (i3 == 19) {
            return getQBaseActivity().getString(R.string.w0f);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return HardCodeUtil.qqStr(R.string.jzn);
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.e
    public String getSearchKeyword() {
        return this.keyword;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        FileSelectorSearchAdapter fileSelectorSearchAdapter = new FileSelectorSearchAdapter();
        this.F = fileSelectorSearchAdapter;
        return fileSelectorSearchAdapter;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        FileSelectorSearchEngine fileSelectorSearchEngine = new FileSelectorSearchEngine((QQAppInterface) this.appInterface, getQBaseActivity(), this.C);
        this.E = fileSelectorSearchEngine;
        fileSelectorSearchEngine.h(this.D);
        return this.E;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View findViewById = this.fragmentView.findViewById(R.id.d3z);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.fragmentView.findViewById(R.id.result_layout);
        QFileSendBottomView qFileSendBottomView = new QFileSendBottomView(onCreateView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(qFileSendBottomView, layoutParams);
        qFileSendBottomView.a(this.listView);
        com.tencent.mobileqq.filemanager.widget.e a16 = com.tencent.mobileqq.filemanager.widget.e.a((QQAppInterface) getQBaseActivity().getAppRuntime(), getQBaseActivity(), qFileSendBottomView, this.D);
        this.G = a16;
        a16.d(this.D);
        this.G.e();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.filemanager.widget.e eVar = this.G;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.G.f();
    }

    public void uh(Bundle bundle) {
        this.D = bundle;
    }

    public void vh(int i3) {
        this.C = i3;
    }
}
