package com.tencent.mobileqq.search.ftsentity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import ep2.b;
import ep2.c;
import ep2.e;
import java.util.List;
import on2.d;
import sn2.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FTSEntitySearchDetailFragment extends BaseFragment implements Handler.Callback, d<c> {
    private static List<FTSEntity> N;
    private TextView C;
    private ListView D;
    private String E;
    private String F;
    private List<FTSEntity> G;
    private List<c> H;
    private ep2.a I;
    private IFaceDecoder J;
    FTSEntitySearchDetailActivity K;
    b L;
    private Handler M = new Handler(this);

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends ep2.a<c, g> {
        a(ListView listView, IFaceDecoder iFaceDecoder, List list, String str, FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity) {
            super(listView, iFaceDecoder, list, str, fTSEntitySearchDetailActivity);
        }

        @Override // mn2.a
        protected qn2.d e(int i3) {
            return new com.tencent.mobileqq.search.presenter.c(FTSEntitySearchDetailFragment.this.J);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new ao2.a(viewGroup, R.layout.bxr);
        }
    }

    private void onSearchFinished(List<c> list) {
        this.I.g(list);
    }

    public static FTSEntitySearchDetailFragment qh(String str, String str2, List<FTSEntity> list) {
        N = list;
        FTSEntitySearchDetailFragment fTSEntitySearchDetailFragment = new FTSEntitySearchDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("original_keyword", str);
        bundle.putString("segment_keyword", str2);
        fTSEntitySearchDetailFragment.setArguments(bundle);
        return fTSEntitySearchDetailFragment;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == -1) {
            onSearchFinished(this.H);
            return true;
        }
        return true;
    }

    @Override // on2.d
    public /* synthetic */ void onCancelSearch() {
        on2.c.a(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.G = N;
        N = null;
        Bundle arguments = getArguments();
        this.E = arguments.getString("original_keyword");
        this.F = arguments.getString("segment_keyword");
        FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity = (FTSEntitySearchDetailActivity) getBaseActivity();
        this.K = fTSEntitySearchDetailActivity;
        this.L = e.f(fTSEntitySearchDetailActivity.app, fTSEntitySearchDetailActivity.f283230b0);
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
        IFaceDecoder iFaceDecoder = this.J;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        N = null;
    }

    @Override // on2.d
    public void onFinish(List<c> list, pn2.b bVar) {
        if (bVar.a(this.E)) {
            onFinish(list, bVar.f426500c);
        } else if (QLog.isColorLevel()) {
            QLog.d("FTSEntitySearchFragment", 2, "onFinish not match keyword1:", bVar.f426498a, " keyword2:", this.E);
        }
    }

    @Override // on2.d
    public void onUpdate(List<c> list) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            this.C.setText(e.a(this.K, this.G.size(), this.E, this.K.f283230b0));
            this.J = ((IQQAvatarService) this.K.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.K.app);
            a aVar = new a(this.D, this.J, this.G, this.F, this.K);
            this.I = aVar;
            this.D.setAdapter((ListAdapter) aVar);
            this.L.f(this.F, this.G);
            this.I.h();
            String str = this.E;
            if (str != null && str.length() > 0 && !FTSMessageSearchEngine.j(this.E)) {
                this.L.init();
                this.L.e(e.g(this.K.f283230b0, this.F, this.G.get(0)), this);
            }
        } catch (NullPointerException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FTSEntitySearchDetailFragment", 2, "onViewCreated: ", e16);
            }
        }
    }

    @Override // on2.d
    public void onUpdate(List<c> list, boolean z16) {
    }

    @Override // on2.d
    public void onFinish(List<c> list, int i3) {
        this.H = list;
        this.M.removeMessages(-1);
        this.M.sendEmptyMessage(-1);
    }
}
