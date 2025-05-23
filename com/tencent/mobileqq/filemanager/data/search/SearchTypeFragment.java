package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SearchTypeFragment extends BaseFragment implements View.OnClickListener {
    private SearchFileFlowLayout C;
    public List<Integer> D;
    public int E;
    private SparseIntArray F = new SparseIntArray();
    private SparseIntArray G = new SparseIntArray();
    private View H;
    public String I;
    private ub1.a J;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer num = (Integer) view.getTag();
        ub1.a aVar = this.J;
        if (aVar != null) {
            aVar.a(num.intValue());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.F.put(13, R.drawable.qui_group);
        this.F.put(3, R.drawable.qui_files);
        this.F.put(2, R.drawable.qui_video_on);
        this.F.put(0, R.drawable.qui_image);
        this.F.put(1, R.drawable.qui_music);
        this.F.put(11, R.drawable.qui_more_apps);
        this.G.put(13, R.string.eli);
        this.G.put(3, R.string.elg);
        this.G.put(2, R.string.ell);
        this.G.put(0, R.string.elh);
        this.G.put(1, R.string.elj);
        this.G.put(11, R.string.elk);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.am7, viewGroup, false);
        this.H = inflate;
        SearchFileFlowLayout searchFileFlowLayout = (SearchFileFlowLayout) inflate.findViewById(R.id.ccg);
        this.C = searchFileFlowLayout;
        searchFileFlowLayout.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.SearchTypeFragment.1
            @Override // java.lang.Runnable
            public void run() {
                SearchTypeFragment searchTypeFragment = SearchTypeFragment.this;
                searchTypeFragment.qh(searchTypeFragment.D, searchTypeFragment.E);
            }
        });
        View view = this.H;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    public View ph(int i3, int i16, int i17) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.am9, (ViewGroup) this.H, false);
        LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.ee8);
        TextView textView = (TextView) frameLayout.findViewById(R.id.kah);
        ((ImageView) frameLayout.findViewById(R.id.dxx)).setImageDrawable(getResources().getDrawable(this.F.get(i3)));
        textView.setText(this.G.get(i3));
        linearLayout.setTag(Integer.valueOf(i3));
        linearLayout.setOnClickListener(this);
        ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).width = i16 / i17;
        return frameLayout;
    }

    public void qh(List<Integer> list, int i3) {
        SearchFileFlowLayout searchFileFlowLayout = this.C;
        if (searchFileFlowLayout != null && list != null) {
            searchFileFlowLayout.setMaxNumInLineAndAlignMode(0, i3);
            int measuredWidth = this.C.getMeasuredWidth();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                this.C.addView((FrameLayout) ph(it.next().intValue(), measuredWidth, i3));
            }
        }
    }

    public void rh(ub1.a aVar) {
        this.J = aVar;
    }
}
