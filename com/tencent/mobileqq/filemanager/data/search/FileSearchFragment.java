package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSearchFragment extends BaseSearchFragment<y> {
    public List<y> C;
    public String D;
    protected boolean E = true;
    public int F = -1;
    public String G = "";
    public Bundle H = null;
    private LinearLayout I = null;
    private LinearLayout J = null;
    private TextView K = null;
    private TextView L = null;
    private TextView M = null;
    private View N = null;
    private ImageView P = null;
    private LinearLayout Q = null;
    private RelativeLayout R = null;
    private int S = -1;
    protected int T = 0;
    public List<View> U = new ArrayList();
    private boolean V = false;
    protected int W = -1;
    public boolean X = false;
    private boolean Y = false;
    private long Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    private long f207880a0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QBaseActivity qBaseActivity = FileSearchFragment.this.getQBaseActivity();
            if (qBaseActivity instanceof FileSearchActivity) {
                FileSearchFragment.this.Rh(true);
                FileSearchActivity fileSearchActivity = (FileSearchActivity) qBaseActivity;
                fileSearchActivity.showProgressDialog();
                fileSearchActivity.f207869v0 = 22;
                fileSearchActivity.f207870w0 = "";
                fileSearchActivity.f3("");
                fileSearchActivity.g3(FileSearchFragment.this.getString(R.string.zyn));
                FileSearchFragment fileSearchFragment = FileSearchFragment.this;
                fileSearchFragment.F = 22;
                fileSearchFragment.G = String.format(HardCodeUtil.qqStr(R.string.zyc), FileSearchFragment.this.getString(R.string.zyk));
                FileSearchFragment.this.M.setText(FileSearchFragment.this.G);
                FileSearchFragment.this.M.setVisibility(8);
                FileSearchFragment.this.N.setVisibility(8);
                ((TextView) qBaseActivity.findViewById(R.id.f110966jy)).setVisibility(0);
                if (FileSearchFragment.this.K != null) {
                    FileSearchFragment.this.K.setVisibility(4);
                    FileSearchFragment.this.L.setVisibility(4);
                }
                ((BaseSearchFragment) FileSearchFragment.this).adapter.g(null);
                Bundle bundle = new Bundle();
                bundle.putString("search_pc_file_id", "");
                FileSearchFragment fileSearchFragment2 = FileSearchFragment.this;
                fileSearchFragment2.startSearch(new pn2.a(fileSearchFragment2.keyword, bundle), 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements AbsListView.OnScrollListener {
        b() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (i3 == 0 && i16 > 0 && !FileSearchFragment.this.Y) {
                FileSearchFragment.this.Y = true;
                FileSearchFragment.this.Uh();
            }
            FileSearchFragment.this.Zh();
            if (i3 + i16 + ((BaseSearchFragment) FileSearchFragment.this).listView.getFooterViewsCount() >= i17 && i17 != 0 && FileSearchFragment.this.S == 0) {
                FileSearchFragment fileSearchFragment = FileSearchFragment.this;
                int i18 = fileSearchFragment.W;
                if (i18 == 0) {
                    fileSearchFragment.P.setVisibility(4);
                    FileSearchFragment.this.Q.setVisibility(4);
                    FileSearchFragment.this.R.setVisibility(4);
                    return;
                }
                if (i18 == 100000) {
                    fileSearchFragment.P.setImageDrawable(com.tencent.mobileqq.guild.util.qqui.d.d(FileSearchFragment.this.getContext(), 2));
                    FileSearchFragment.this.P.setVisibility(0);
                    FileSearchFragment.this.R.setVisibility(0);
                    FileSearchFragment.this.V = false;
                    return;
                }
                if (i18 == 100001) {
                    if (!fileSearchFragment.V) {
                        FileSearchFragment.this.V = true;
                        FileSearchFragment.this.Q.setVisibility(0);
                        FileSearchFragment.this.R.setVisibility(0);
                        ((BaseSearchFragment) FileSearchFragment.this).listView.setPadding(((BaseSearchFragment) FileSearchFragment.this).listView.getPaddingLeft(), ((BaseSearchFragment) FileSearchFragment.this).listView.getPaddingTop(), ((BaseSearchFragment) FileSearchFragment.this).listView.getPaddingRight(), (int) (FileSearchFragment.this.getResources().getDisplayMetrics().density * 75.0f));
                        FileSearchFragment.this.Sh();
                        return;
                    }
                    return;
                }
                if (i18 == 100002 || i18 == 199999) {
                    fileSearchFragment.Nh();
                }
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            FileSearchFragment.this.S = i3;
            if (FileSearchFragment.this.S == 0) {
                FileSearchFragment.this.Uh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class c extends mn2.b<y, sn2.c> {
        public c(ListView listView, IFaceDecoder iFaceDecoder, List<y> list, String str, QQAppInterface qQAppInterface) {
            super(listView, iFaceDecoder);
            if (FileSearchFragment.this.Ph()) {
                FileSearchResultView.s(FileSearchFragment.this.F, FileSearchFragment.this.H);
            }
            if (list == null) {
                return;
            }
            if (list.size() == 1) {
                com.tencent.mobileqq.filemanager.data.search.c cVar = (com.tencent.mobileqq.filemanager.data.search.c) list.get(0);
                if (cVar.G.size() > 1) {
                    ArrayList arrayList = new ArrayList();
                    for (FileManagerEntity fileManagerEntity : cVar.G) {
                        com.tencent.mobileqq.filemanager.data.search.c cVar2 = new com.tencent.mobileqq.filemanager.data.search.c();
                        cVar2.H = cVar.H;
                        cVar2.G.add(fileManagerEntity);
                        arrayList.add(cVar2);
                    }
                    g(arrayList);
                    return;
                }
            }
            g(list);
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            return new FileSearchResultPresenter(((BaseSearchFragment) FileSearchFragment.this).faceDecoder);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new FileSearchResultView(viewGroup);
        }
    }

    private void Oh(View view) {
        this.listView.setOnTouchListener(null);
        TextView textView = (TextView) view.findViewById(R.id.f110966jy);
        if (textView != null) {
            if (this.F == 22) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) view.findViewById(R.id.uib);
        this.M = textView2;
        textView2.setText(this.G);
        this.N = view.findViewById(R.id.jta);
        this.P = (ImageView) view.findViewById(R.id.f110946jw);
        this.I = (LinearLayout) view.findViewById(R.id.yev);
        this.Q = (LinearLayout) view.findViewById(R.id.yfj);
        ((TextView) view.findViewById(R.id.f110956jx)).setText(String.format(HardCodeUtil.qqStr(R.string.f224726jp), Integer.valueOf(((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getFileBridgeService().getHostMaxSearchCount())));
        this.R = (RelativeLayout) view.findViewById(R.id.acl);
        this.J = (LinearLayout) view.findViewById(R.id.f1041562j);
        this.K = (TextView) view.findViewById(R.id.zrx);
        TextView textView3 = (TextView) view.findViewById(R.id.f1041662k);
        this.L = textView3;
        textView3.setOnClickListener(new a());
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.addOnScrollListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(boolean z16) {
        int i3;
        String str;
        QLog.d("FileSearchFragment", 2, "reportGlobalSearchView. isClick: " + z16);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_results");
        hashMap.put("dt_eid", "em_bas_global_search_prompt_bar");
        HashMap hashMap2 = new HashMap();
        if (this.mResultList.size() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap2.put("have_result", Integer.valueOf(i3));
        hashMap.put("cur_pg", hashMap2);
        if (z16) {
            str = "clck";
        } else {
            str = "imp";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        int i3;
        QLog.d("FileSearchFragment", 2, "reportMaxResultLayout.");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_results");
        hashMap.put("dt_eid", "em_bas_result_many_bars");
        HashMap hashMap2 = new HashMap();
        if (this.mResultList.size() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap2.put("have_result", Integer.valueOf(i3));
        hashMap.put("cur_pg", hashMap2);
        VideoReport.reportEvent("imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        com.tencent.mobileqq.filemanager.data.search.c cVar;
        List<FileManagerEntity> list;
        int firstVisiblePosition = this.listView.getFirstVisiblePosition();
        int lastVisiblePosition = this.listView.getLastVisiblePosition();
        for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
            View childAt = this.listView.getChildAt(i3 - firstVisiblePosition);
            if (childAt.getTag(R.id.kxb) != null && (childAt.getTag(R.id.kxb) instanceof com.tencent.mobileqq.filemanager.data.search.c) && (cVar = (com.tencent.mobileqq.filemanager.data.search.c) childAt.getTag(R.id.kxb)) != null && (list = cVar.G) != null && list.size() > 0) {
                FileManagerEntity fileManagerEntity = cVar.G.get(0);
                Vh(false, 1, fileManagerEntity.fileSize, fileManagerEntity.nFileType);
            }
        }
    }

    private void Vh(boolean z16, int i3, long j3, int i16) {
        int i17;
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_results");
        hashMap.put("dt_eid", "em_bas_search_result_entry");
        hashMap.put("click_effect", Integer.valueOf(i3));
        hashMap.put("file_size", Long.valueOf(j3));
        hashMap.put("filetype", Integer.valueOf(i16));
        HashMap hashMap2 = new HashMap();
        if (this.mResultList.size() > 0) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        hashMap2.put("have_result", Integer.valueOf(i17));
        hashMap.put("cur_pg", hashMap2);
        if (z16) {
            str = "clck";
        } else {
            str = "imp";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    private void Wh(int i3, int i16) {
        int i17;
        QLog.d("FileSearchFragment", 2, "reportSearchDuration. durationMs: " + i3 + ", type: " + i16);
        HashMap hashMap = new HashMap();
        hashMap.put("search_duration", Integer.valueOf(i3));
        hashMap.put("search_reporting_time", Integer.valueOf(i16));
        HashMap hashMap2 = new HashMap();
        if (this.mResultList.size() > 0) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        hashMap2.put("have_result", Integer.valueOf(i17));
        hashMap.put("cur_pg", hashMap2);
        VideoReport.reportEvent("ev_bas_file_search_duration", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        this.U.clear();
        int firstVisiblePosition = this.listView.getFirstVisiblePosition();
        int lastVisiblePosition = this.listView.getLastVisiblePosition();
        for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
            this.U.add(this.listView.getChildAt(i3 - firstVisiblePosition));
        }
    }

    public void Nh() {
        on2.b bVar = this.searchEngine;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    protected boolean Ph() {
        int i3 = this.F;
        if (i3 != 22 && i3 != 23) {
            return false;
        }
        return true;
    }

    public void Qh(boolean z16) {
        int i3;
        String str;
        QLog.d("FileSearchFragment", 2, "reportCancelBtn. isClick: " + z16);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_results");
        hashMap.put("dt_eid", "em_bas_cancel");
        HashMap hashMap2 = new HashMap();
        if (this.mResultList.size() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap2.put("have_result", Integer.valueOf(i3));
        hashMap.put("cur_pg", hashMap2);
        if (z16) {
            str = "clck";
        } else {
            str = "imp";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    public void Th(boolean z16) {
        boolean z17;
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportPageExposure. isPageIn: ");
        sb5.append(z16);
        sb5.append(", mResultList: ");
        int i3 = 1;
        if (this.mResultList.size() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        QLog.d("FileSearchFragment", 2, sb5.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_bas_file_search_results");
        HashMap hashMap2 = new HashMap();
        if (this.mResultList.size() <= 0) {
            i3 = 0;
        }
        hashMap2.put("have_result", Integer.valueOf(i3));
        hashMap.put("cur_pg", hashMap2);
        if (z16) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    public void Xh() {
        int i3;
        if (this.Z > 0 && (i3 = this.W) != 0 && i3 != 100001) {
            Wh((int) (System.currentTimeMillis() - this.Z), 3);
        }
    }

    public void Yh(boolean z16) {
        this.E = z16;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        return do2.e.D;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected int getResourceId() {
        if (Ph()) {
            return R.layout.h2g;
        }
        return R.layout.b1r;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return HardCodeUtil.qqStr(R.string.jzn);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean isHideLoading() {
        return Ph();
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new c(this.listView, this.faceDecoder, this.C, this.D, (QQAppInterface) this.appInterface);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        return new FileManagerSearchEngine((QQAppInterface) this.appInterface, this.F);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (Ph()) {
            Oh(onCreateView);
        }
        TextView textView = (TextView) this.fragmentView.findViewById(R.id.d3z);
        if (!this.E) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected void onFinishProcess(List<y> list, int i3) {
        if (Ph()) {
            if (this.W == 100000) {
                List<M> list2 = this.mResultList;
                if (list2 != 0) {
                    list2.addAll(list);
                }
            } else {
                this.mResultList = list;
            }
            this.W = i3;
            return;
        }
        this.mResultList = list;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected void onSearchFinished() {
        if (Ph()) {
            if (!this.X) {
                this.X = true;
                Th(true);
                Qh(false);
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.Z);
            int i3 = this.W;
            if (i3 == 100000) {
                if (this.f207880a0 == 0) {
                    Wh(currentTimeMillis, 1);
                    this.f207880a0 = System.currentTimeMillis();
                }
            } else if (i3 == 0 || i3 == 100001) {
                if (this.f207880a0 == 0) {
                    Wh(currentTimeMillis, 1);
                    this.f207880a0 = System.currentTimeMillis();
                }
                Wh(currentTimeMillis, 2);
            }
            QBaseActivity qBaseActivity = super.getQBaseActivity();
            if (qBaseActivity instanceof FileSearchActivity) {
                if (this.F == 22) {
                    ((TextView) qBaseActivity.findViewById(R.id.f110966jy)).setVisibility(8);
                }
                ((FileSearchActivity) qBaseActivity).hideProgressDialog();
            }
            if (this.J != null && this.mResultList.size() > 0) {
                this.M.setVisibility(0);
                this.N.setVisibility(0);
                if (this.F == 22) {
                    this.J.setVisibility(8);
                    this.K.setVisibility(8);
                    this.L.setVisibility(8);
                } else {
                    this.J.setVisibility(0);
                    this.K.setVisibility(0);
                    this.L.setVisibility(0);
                    Rh(false);
                }
                this.listView.setVisibility(0);
                this.I.setVisibility(4);
            }
            this.P.setVisibility(4);
            this.R.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void showNoResultLayout(boolean z16) {
        if (z16 && Ph()) {
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.listView.setVisibility(8);
            this.I.setVisibility(0);
            this.I.removeAllViews();
            LinearLayout linearLayout = this.I;
            linearLayout.addView(new QUIEmptyState.Builder(linearLayout.getContext()).setImageType(2).setBackgroundColorType(0).setTitle(getString(R.string.f171022mm)).build());
            return;
        }
        super.showNoResultLayout(z16);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public boolean startSearch(pn2.a aVar, int i3) {
        this.W = -1;
        this.S = -1;
        this.T = 0;
        this.X = false;
        this.Y = false;
        this.Z = System.currentTimeMillis();
        this.f207880a0 = 0L;
        if (Ph()) {
            this.listView.setPadding(0, 0, 0, 0);
        }
        return super.startSearch(aVar, i3);
    }
}
