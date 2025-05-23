package com.tencent.mobileqq.search.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.business.viewmodel.SearchDataFetchViewModel;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.z;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import lo2.an;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FollowedSearchFragment extends QBaseFragment implements AbsListView.OnScrollListener, an {
    private String C;
    private long D;
    private lo2.b E;
    private View G;
    private XListView H;
    private View I;
    private View J;
    private TextView K;
    private View L;
    private TextView M;
    private TextView N;
    private jn2.h P;
    private IFaceDecoder Q;
    private int R;
    private boolean T;
    private boolean U;
    private String V;
    public boolean X;
    private SearchDataFetchViewModel Y;
    private final List<v> F = new ArrayList();
    private String S = "";
    private boolean W = true;
    private com.tencent.mobileqq.search.business.viewmodel.b Z = new com.tencent.mobileqq.search.business.viewmodel.b() { // from class: com.tencent.mobileqq.search.fragment.a
        @Override // com.tencent.mobileqq.search.business.viewmodel.b
        public final void a(String str, boolean z16, String str2, byte[] bArr, boolean z17, List list, List list2, int i3, boolean z18, wp2.b bVar) {
            FollowedSearchFragment.this.zh(str, z16, str2, bArr, z17, list, list2, i3, z18, bVar);
        }
    };

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.search.business.viewmodel.a f283175a0 = new com.tencent.mobileqq.search.business.viewmodel.a() { // from class: com.tencent.mobileqq.search.fragment.b
        @Override // com.tencent.mobileqq.search.business.viewmodel.a
        public final void a(String str, boolean z16, String str2, int i3, String str3) {
            FollowedSearchFragment.this.Ch(str, z16, str2, i3, str3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        startSearch(str);
        this.I.setVisibility(0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        startSearch(str);
        this.N.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Eh() {
        this.I.setVisibility(8);
        this.L.setVisibility(8);
        this.N.setVisibility(8);
        this.J.setVisibility(8);
        this.H.setVisibility(0);
    }

    private void th(List<v> list, boolean z16) {
        if (list != null && !list.isEmpty()) {
            if (list.get(0) instanceof com.tencent.mobileqq.search.model.i) {
                if (z16) {
                    ((com.tencent.mobileqq.search.model.i) list.get(0)).D(false);
                } else {
                    list.remove(0);
                }
            }
            for (v vVar : list) {
                if (vVar instanceof z) {
                    ((z) vVar).F(5);
                }
            }
        }
    }

    private void vh(boolean z16, String str) {
        if (getContext() instanceof ActiveEntitySearchActivity) {
            ((ActiveEntitySearchActivity) getContext()).M2(z16, str, null);
        }
    }

    private void wh() {
        jn2.h hVar = new jn2.h(this.H, this.Q, this, 0);
        this.P = hVar;
        this.H.setAdapter((ListAdapter) hVar);
        this.H.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.fragment.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean yh5;
                yh5 = FollowedSearchFragment.yh(view, motionEvent);
                return yh5;
            }
        });
    }

    private void xh(@NonNull LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.awk, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.cih);
        this.M = textView;
        textView.setText(HardCodeUtil.qqStr(R.string.j1w));
        this.M.setTextSize(16.0f);
        this.M.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary, 1000));
        this.M.setVisibility(8);
        this.H.addFooterView(inflate);
        View inflate2 = layoutInflater.inflate(R.layout.awk, (ViewGroup) null, false);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.cih);
        this.N = textView2;
        textView2.setText(HardCodeUtil.qqStr(R.string.f171546j23));
        this.N.setTextSize(16.0f);
        this.N.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary, 1000));
        this.N.setVisibility(8);
        this.H.addFooterView(inflate2);
        View inflate3 = layoutInflater.inflate(R.layout.acp, (ViewGroup) null, false);
        View findViewById = inflate3.findViewById(R.id.cih);
        this.L = findViewById;
        findViewById.setVisibility(8);
        this.H.addFooterView(inflate3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean yh(View view, MotionEvent motionEvent) {
        ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(String str, boolean z16, String str2, byte[] bArr, boolean z17, List list, List list2, int i3, boolean z18, wp2.b bVar) {
        Dh(str, z16, str2, bArr, z17, list2, i3, z18, bVar);
    }

    public void Ch(final String str, boolean z16, String str2, int i3, String str3) {
        String str4;
        if (isAdded() && TextUtils.equals(this.S, str2) && (str4 = this.C) != null && str4.equals(str)) {
            QLog.d("FollowedSearchFragment", 1, "[handleUniteSearchError] keyword: " + str + " isFirst: " + z16 + " reqTime: " + str2 + " resultCode: " + i3 + " errorMsg: " + str3);
            this.T = false;
            this.I.setVisibility(8);
            this.L.setVisibility(8);
            if (this.F.isEmpty()) {
                this.H.setVisibility(8);
                this.J.setVisibility(0);
                if (i3 != -1) {
                    this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.fragment.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FollowedSearchFragment.this.Ah(str, view);
                        }
                    });
                    this.K.setText(HardCodeUtil.qqStr(R.string.j1x));
                }
            } else {
                this.N.setVisibility(0);
                this.N.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.fragment.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FollowedSearchFragment.this.Bh(str, view);
                    }
                });
            }
            vh(false, str);
        }
    }

    public void Dh(String str, boolean z16, String str2, byte[] bArr, boolean z17, List<? extends x> list, int i3, boolean z18, wp2.b bVar) {
        String str3;
        if (isAdded() && TextUtils.equals(this.S, str2) && (str3 = this.C) != null && str3.equals(str)) {
            if (list != null && !list.isEmpty() && (list.get(0) instanceof lo2.b)) {
                lo2.b bVar2 = (lo2.b) list.get(0);
                this.E = bVar2;
                this.U = bVar2.R;
                this.V = bVar2.S;
                this.T = false;
                Eh();
                List<v> n3 = SearchUtil.n(list, z16, false, false);
                th(n3, z16);
                if (n3 != null) {
                    this.F.addAll(n3);
                }
                this.P.g(this.F);
                vh(true, str);
                return;
            }
            Ch(str, z16, str2, -1, "result = null");
        }
    }

    @Override // lo2.an
    public boolean isFirstClickResultItem() {
        return this.W;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        SearchDataFetchViewModel searchDataFetchViewModel = (SearchDataFetchViewModel) new ViewModelProvider(this).get(SearchDataFetchViewModel.class);
        this.Y = searchDataFetchViewModel;
        searchDataFetchViewModel.P1(this.Z);
        this.Y.O1(this.f283175a0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        this.Q = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        if (arguments != null) {
            this.D = arguments.getLong("group_mask_long");
            this.C = arguments.getString("keyword");
        }
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.h6v, viewGroup, false);
        this.G = inflate;
        this.H = (XListView) inflate.findViewById(R.id.eap);
        View findViewById = this.G.findViewById(R.id.efs);
        this.I = findViewById;
        findViewById.setVisibility(0);
        this.J = this.G.findViewById(R.id.c2a);
        this.K = (TextView) this.G.findViewById(R.id.c2c);
        this.J.setVisibility(8);
        xh(layoutInflater);
        wh();
        this.X = true;
        startSearch(this.C);
        View view = this.G;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.T = false;
        IFaceDecoder iFaceDecoder = this.Q;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        jn2.h hVar = this.P;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        jn2.h hVar = this.P;
        if (hVar != null && hVar.getCount() != 0 && this.R != 0 && (i17 - i3) - i16 < 10 && !this.T && !this.U) {
            startSearch(this.C);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        this.R = i3;
    }

    @Override // lo2.an
    public void setFirstClickResultItemFlag(boolean z16) {
        this.W = z16;
    }

    public synchronized void startSearch(String str) {
        if (this.Y != null) {
            this.C = str;
            this.S = System.currentTimeMillis() + "";
            if (!TextUtils.isEmpty(str)) {
                this.Y.e2(str, this.S, this.D, this.V);
                if (this.G == null) {
                    return;
                }
                this.J.setVisibility(8);
                if (this.V == null) {
                    this.I.setVisibility(0);
                } else {
                    this.L.setVisibility(0);
                }
            } else {
                if (this.G == null) {
                    return;
                }
                this.J.setVisibility(8);
                this.I.setVisibility(8);
                this.L.setVisibility(8);
            }
            this.N.setVisibility(8);
            this.M.setVisibility(8);
        }
    }

    public void uh() {
        if (this.P != null) {
            this.F.clear();
            this.V = null;
            setFirstClickResultItemFlag(false);
            this.P.g(this.F);
        }
        if (this.X) {
            this.I.setVisibility(8);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.J.setVisibility(8);
        }
    }
}
