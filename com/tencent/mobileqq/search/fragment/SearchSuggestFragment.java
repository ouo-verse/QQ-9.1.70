package com.tencent.mobileqq.search.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IGroupSearchHistoryManager;
import com.tencent.mobileqq.search.fragment.SearchSuggestFragment;
import com.tencent.mobileqq.search.model.am;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.util.al;
import com.tencent.mobileqq.search.view.SearchSuggestItemView;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.report.QCircleReporter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchSuggestFragment extends QBaseFragment {
    private b C;
    private String D;
    private a E;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(String str);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends BaseListViewAdapter<v> {

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ pn2.c f283192d;

            a(pn2.c cVar) {
                this.f283192d = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f283192d.v(view);
                ((IGroupSearchHistoryManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGroupSearchHistoryManager.class, "")).add(SearchSuggestFragment.this.D);
                pn2.c cVar = this.f283192d;
                al.a(cVar.C, cVar.x(), this.f283192d.getKeyword(), this.f283192d.G());
                if (SearchSuggestFragment.this.E != null) {
                    SearchSuggestFragment.this.E.b();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.search.fragment.SearchSuggestFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public class C8534b extends BaseListViewAdapter<v>.BaseVH {
            sn2.e E;

            public C8534b(View view) {
                super(view);
                this.E = null;
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j0(v vVar, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
            if (SearchSuggestFragment.this.E != null) {
                SearchSuggestFragment.this.E.a(((am) vVar).getWord());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (getItem(i3) instanceof pn2.c) {
                return 1;
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
            if (getDataList() != null && i3 >= 0 && i3 < getItemCount()) {
                final v item = getItem(i3);
                if (item instanceof pn2.c) {
                    pn2.c cVar = (pn2.c) item;
                    ((C8534b) viewHolder).E.o(cVar);
                    viewHolder.itemView.setOnClickListener(new a(cVar));
                } else {
                    ((SearchSuggestItemView) viewHolder.itemView).setData((am) item, i3);
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.fragment.p
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SearchSuggestFragment.b.this.j0(item, view);
                        }
                    });
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            if (i3 == 1) {
                sn2.e eVar = new sn2.e(viewGroup, R.layout.f168534a00);
                eVar.getView().setTag(R.id.kxc, 0);
                C8534b c8534b = new C8534b(eVar.getView());
                c8534b.E = eVar;
                return c8534b;
            }
            SearchSuggestItemView searchSuggestItemView = new SearchSuggestItemView(viewGroup.getContext());
            searchSuggestItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return new C8534b(searchSuggestItemView);
        }
    }

    private void sh(final View view) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.o
            @Override // java.lang.Runnable
            public final void run() {
                SearchSuggestFragment.this.vh(view);
            }
        });
    }

    private String th() {
        String str;
        QLog.d("SearchSuggestFragment", 1, "[jumpSearchDetailPage] keyword: " + this.D + " querySource: 4 userSource: 4");
        try {
            str = URLEncoder.encode(this.D, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            QLog.e("SearchSuggestFragment", 1, "[jumpSearchDetailPage] encode keyword failed, because UTF-8 is unknown");
            str = "";
        }
        return Uri.parse("mqqapi://kuikly/open?src_type=internal&version=1&source=1&target=52&channel=2&page_name=qsearch_detail").buildUpon().appendQueryParameter("sessionId", com.tencent.biz.qqcircle.immersive.views.search.util.p.r()).appendQueryParameter("keyword", str).appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, String.valueOf(4)).appendQueryParameter("user_source", String.valueOf(4)).appendQueryParameter("study_mode_status", String.valueOf(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())).appendQueryParameter("start_search_stamp", String.valueOf(System.currentTimeMillis())).toString();
    }

    @NonNull
    private pn2.c uh(String str) {
        pn2.c cVar = new pn2.c(str, -5, R.drawable.icon_recent_troop_assistant, true);
        cVar.S = GuildInjectImpl.N();
        cVar.H = th();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vh(View view) {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(view, "pg_bas_search_association_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "SearchSuggestFragment";
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.h5c, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f7917492);
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        b bVar = new b();
        this.C = bVar;
        recyclerView.setAdapter(bVar);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getView() != null) {
            sh(getView());
        }
    }

    public void wh(String str) {
        this.D = str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(uh(str));
        this.C.setDatas(arrayList);
    }

    public void xh(a aVar) {
        this.E = aVar;
    }
}
