package com.tencent.mobileqq.search.ftsentity.qqnt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.qqnt.NTFTSEntitySearchDetailFragment;
import com.tencent.mobileqq.search.ftsentity.qqnt.a;
import com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import ep2.c;
import ep2.e;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import on2.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public class NTFTSEntitySearchDetailFragment extends BaseFragment implements d<c> {
    private TextView C;
    private ListView D;
    private String E;
    private String F;
    private com.tencent.mobileqq.search.ftsentity.qqnt.a G;
    private IFaceDecoder H;
    private int L;
    private FTSEntitySearchDetailActivity M;
    private NTFtsMessageSearchEngine N;
    private Integer P;
    private boolean R;
    private String I = "";
    private int J = -1;
    private String K = "";
    private final List<c> Q = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.search.ftsentity.qqnt.a {
        a(ListView listView, IFaceDecoder iFaceDecoder, String str, FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity, a.InterfaceC8535a interfaceC8535a) {
            super(listView, iFaceDecoder, str, fTSEntitySearchDetailActivity, interfaceC8535a);
        }

        @Override // mn2.a
        protected qn2.d e(int i3) {
            return new com.tencent.mobileqq.search.presenter.c(NTFTSEntitySearchDetailFragment.this.H);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new ao2.a(viewGroup, R.layout.bxr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C4DB", "0X800C4DB", NTMsgMigrationManager.X().h0(), 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void loadData() {
        String str;
        String str2 = this.F;
        if (str2 != null && str2.isEmpty()) {
            str = this.E;
        } else {
            str = this.F;
        }
        this.N.e(e.e(str, this.E, this.I, this.J, this.K), this);
    }

    private void onSearchFinished(final List<c> list) {
        this.D.post(new Runnable() { // from class: fp2.a
            @Override // java.lang.Runnable
            public final void run() {
                NTFTSEntitySearchDetailFragment.this.th(list);
            }
        });
    }

    private void sh(ListView listView) {
        if (!NTMsgMigrationManager.X().F0()) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(getQBaseActivity());
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dip2px(80.0f)));
        relativeLayout.setGravity(17);
        TextView textView = new TextView(getQBaseActivity());
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        textView.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        textView.setTextSize(2, 14.0f);
        textView.setText(NTMsgMigrationManager.X().e0(getQBaseActivity(), new b()));
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
        relativeLayout.addView(textView);
        listView.addFooterView(relativeLayout);
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C4DA", "0X800C4DA", NTMsgMigrationManager.X().h0(), 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(List list) {
        this.R = false;
        this.Q.addAll(list);
        this.G.g(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        String str;
        if (this.P != null && !this.R) {
            this.R = true;
            String str2 = this.F;
            if (str2 != null && str2.isEmpty()) {
                str = this.E;
            } else {
                str = this.F;
            }
            pn2.a e16 = e.e(str, this.E, this.I, this.J, this.K);
            e16.f426496b.putInt("queryId", this.P.intValue());
            this.N.e(e16, this);
        }
    }

    public static NTFTSEntitySearchDetailFragment vh(String str, String str2, int i3, String str3, int i16, String str4, int i17) {
        NTFTSEntitySearchDetailFragment nTFTSEntitySearchDetailFragment = new NTFTSEntitySearchDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        bundle.putString("segment_keyword", str2);
        bundle.putInt("query_id", i3);
        bundle.putString("uid", str3);
        bundle.putInt("chatType", i16);
        bundle.putString("title", str4);
        bundle.putInt("item_count", i17);
        nTFTSEntitySearchDetailFragment.setArguments(bundle);
        return nTFTSEntitySearchDetailFragment;
    }

    @Override // on2.d
    public /* synthetic */ void onCancelSearch() {
        on2.c.a(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.E = arguments.getString("keyword");
        this.F = arguments.getString("segment_keyword");
        this.I = arguments.getString("uid");
        this.J = arguments.getInt("chatType");
        this.K = arguments.getString("title");
        this.L = arguments.getInt("item_count");
        FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity = (FTSEntitySearchDetailActivity) getBaseActivity();
        this.M = fTSEntitySearchDetailActivity;
        this.N = (NTFtsMessageSearchEngine) e.f(fTSEntitySearchDetailActivity.app, 2);
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
        this.N.destroy();
    }

    @Override // on2.d
    public void onFinish(List<c> list, int i3) {
        onSearchFinished(list);
    }

    @Override // on2.d
    public void onUpdate(List<c> list) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity = this.M;
            this.C.setText(e.a(fTSEntitySearchDetailActivity, this.L, this.E, fTSEntitySearchDetailActivity.f283230b0));
            this.H = ((IQQAvatarService) this.M.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.M.app);
            this.G = new a(this.D, this.H, this.E, this.M, new a.InterfaceC8535a() { // from class: com.tencent.mobileqq.search.ftsentity.qqnt.b
                @Override // com.tencent.mobileqq.search.ftsentity.qqnt.a.InterfaceC8535a
                public final void a() {
                    NTFTSEntitySearchDetailFragment.this.uh();
                }
            });
            sh(this.D);
            this.D.setAdapter((ListAdapter) this.G);
            this.N.init();
            loadData();
        } catch (NullPointerException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FTSEntitySearchDetailFragment", 2, "onViewCreated: ", e16);
            }
        }
    }

    @Override // on2.d
    public void onFinish(List<c> list, pn2.b bVar) {
        Bundle bundle = bVar.f426499b;
        if (bundle != null && bundle.containsKey("queryId")) {
            this.P = Integer.valueOf(bVar.f426499b.getInt("queryId"));
        } else {
            this.P = null;
        }
        onSearchFinished(list);
    }

    @Override // on2.d
    public void onUpdate(List<c> list, boolean z16) {
    }
}
