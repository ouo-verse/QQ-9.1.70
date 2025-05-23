package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ChatFileSearchFragment extends FileSearchFragment {

    /* renamed from: b0, reason: collision with root package name */
    public String f207843b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f207844c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f207845d0;

    /* renamed from: e0, reason: collision with root package name */
    public List<Integer> f207846e0;

    /* renamed from: f0, reason: collision with root package name */
    Runnable f207847f0 = new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (!((BaseSearchFragment) ChatFileSearchFragment.this).isEngineInited) {
                ChatFileSearchFragment.this.searchEngine.init();
                ((BaseSearchFragment) ChatFileSearchFragment.this).isEngineInited = true;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatFileSearchFragment.this.startSearch("nothing");
                    }
                });
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class a extends mn2.b<y, sn2.c> {
        a(ListView listView, IFaceDecoder iFaceDecoder, List<y> list, String str, QQAppInterface qQAppInterface) {
            super(listView, iFaceDecoder);
            if (list == null) {
                return;
            }
            if (list.size() == 1) {
                com.tencent.mobileqq.filemanager.data.search.a aVar = (com.tencent.mobileqq.filemanager.data.search.a) list.get(0);
                if (aVar.G.size() > 1) {
                    ArrayList arrayList = new ArrayList();
                    for (FileManagerEntity fileManagerEntity : aVar.G) {
                        com.tencent.mobileqq.filemanager.data.search.a aVar2 = new com.tencent.mobileqq.filemanager.data.search.a();
                        aVar2.H = aVar.H;
                        aVar2.G.add(fileManagerEntity);
                        arrayList.add(aVar2);
                    }
                    g(arrayList);
                    return;
                }
            }
            g(list);
        }

        @Override // mn2.a
        protected qn2.d<y, sn2.c> e(int i3) {
            boolean z16;
            FileSearchResultPresenter fileSearchResultPresenter = new FileSearchResultPresenter(((BaseSearchFragment) ChatFileSearchFragment.this).faceDecoder);
            if (ChatFileSearchFragment.this.F == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            fileSearchResultPresenter.f207885f = z16;
            return fileSearchResultPresenter;
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new b(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean needShowHeader() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.FileSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new a(this.listView, this.faceDecoder, this.C, this.D, (QQAppInterface) this.appInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.FileSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        ChatFileManagerSearchEngine chatFileManagerSearchEngine = new ChatFileManagerSearchEngine((QQAppInterface) this.appInterface, this.F);
        int i3 = this.f207844c0;
        if (i3 == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("qfile_search_param_uin", this.f207843b0);
            chatFileManagerSearchEngine.d(3, bundle);
        } else if (i3 == 2) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("qfile_search_param_uin", this.f207843b0);
            bundle2.putInt("qfile_search_param_type", this.f207845d0);
            bundle2.putIntegerArrayList("qfile_search_param_others", (ArrayList) this.f207846e0);
            chatFileManagerSearchEngine.d(4, bundle2);
        }
        return chatFileManagerSearchEngine;
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.FileSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f207844c0 == 2) {
            ThreadManagerV2.executeOnFileThread(this.f207847f0);
            this.noResultLayout.removeAllViewsInLayout();
            TextView textView = new TextView(getQBaseActivity());
            textView.setText(HardCodeUtil.qqStr(R.string.kcz));
            textView.setSingleLine(true);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setTextSize(1, 15.0f);
            textView.setTextColor(getResources().getColor(R.color.skin_gray3));
            this.noResultLayout.addView(textView);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.data.search.FileSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void showNoResultLayout(boolean z16) {
        if (this.f207844c0 == 2) {
            if (z16) {
                this.noResultLayout.setVisibility(0);
                this.centerLoadingLayout.setVisibility(8);
                this.headerLayout.setVisibility(8);
                showNoMoreResult(false);
                return;
            }
            this.noResultLayout.setVisibility(8);
            return;
        }
        super.showNoResultLayout(z16);
    }
}
