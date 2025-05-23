package com.tencent.mobileqq.filemanager.data.search;

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
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSearchDetailFragment extends BaseFragment {
    private static c I;
    c C;
    String D;
    TextView E;
    ListView F;
    IFaceDecoder G;
    mn2.a H;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class a extends mn2.b<y, sn2.c> {
        public a(ListView listView, IFaceDecoder iFaceDecoder, y yVar, String str, QQAppInterface qQAppInterface) {
            super(listView, iFaceDecoder);
            c cVar = (c) yVar;
            if (cVar.G.size() > 1) {
                ArrayList arrayList = new ArrayList();
                for (FileManagerEntity fileManagerEntity : cVar.G) {
                    c cVar2 = new c();
                    cVar2.H = cVar.H;
                    cVar2.G.add(fileManagerEntity);
                    arrayList.add(cVar2);
                }
                g(arrayList);
            }
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            return new FileSearchResultPresenter(FileSearchDetailFragment.this.G);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new FileSearchResultView(viewGroup);
        }
    }

    public static FileSearchDetailFragment ph(String str, c cVar) {
        I = cVar;
        FileSearchDetailFragment fileSearchDetailFragment = new FileSearchDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        fileSearchDetailFragment.setArguments(bundle);
        return fileSearchDetailFragment;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = I;
        I = null;
        this.D = getArguments().getString("keyword");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168267qt, viewGroup, false);
        this.E = (TextView) inflate.findViewById(R.id.d3z);
        this.F = (ListView) inflate.findViewById(R.id.eap);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IFaceDecoder iFaceDecoder = this.G;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        List<FileManagerEntity> list;
        super.onViewCreated(view, bundle);
        String string = getString(R.string.ipj);
        c cVar = this.C;
        if (cVar != null && (list = cVar.G) != null) {
            this.E.setText(String.format(string, Integer.valueOf(list.size()), this.D));
            this.G = ((IQQAvatarService) getBaseActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getBaseActivity().app);
            a aVar = new a(this.F, this.G, this.C, this.D, getBaseActivity().app);
            this.H = aVar;
            this.F.setAdapter((ListAdapter) aVar);
            return;
        }
        this.E.setText(String.format(string, 0, this.D));
    }
}
