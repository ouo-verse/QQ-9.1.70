package com.tencent.mobileqq.mutualmark.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import hx3.b;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NTMutualDataFragment extends QPublicBaseFragment {
    private View C;
    TextView D;
    TextView E;
    TextView F;
    private b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> G = new a();
    private b<kx3.a> H = new b<kx3.a>() { // from class: com.tencent.mobileqq.mutualmark.fragment.NTMutualDataFragment.2
        @Override // hx3.b
        public void onQueryResult(e<kx3.a> eVar) {
            if (eVar.a() != 0) {
                return;
            }
            ArrayList<kx3.a> b16 = eVar.b();
            int size = b16.size();
            QLog.d(QPublicBaseFragment.TAG, 2, "friendsCategoryInfo.arrayList.size:" + size);
            final StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < size; i3++) {
                kx3.a aVar = b16.get(i3);
                QLog.d(QPublicBaseFragment.TAG, 2, "i:" + i3 + " ntVasDetailInfo:" + aVar.toString());
                sb5.append(aVar.toString());
            }
            final String sb6 = sb5.toString();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.fragment.NTMutualDataFragment.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (sb6.length() == 0) {
                        NTMutualDataFragment.this.E.setText("\u597d\u53cb\u589e\u503c\u6570\u636e\u4e3a\u7a7a");
                    } else {
                        NTMutualDataFragment.this.E.setText(sb5.toString());
                    }
                }
            });
        }
    };
    private b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> I = new b<com.tencent.qqnt.ntrelation.otherinfo.bean.a>() { // from class: com.tencent.mobileqq.mutualmark.fragment.NTMutualDataFragment.3
        @Override // hx3.b
        public void onQueryResult(e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
            if (eVar.a() != 0) {
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b16 = eVar.b();
            int size = b16.size();
            QLog.d(QPublicBaseFragment.TAG, 2, "friendsCategoryInfo.arrayList.size:" + size);
            final StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = b16.get(i3);
                QLog.d(QPublicBaseFragment.TAG, 2, "i:" + i3 + " ntOtherDetailInfo:" + aVar.toString());
                sb5.append(aVar.toString());
            }
            final String sb6 = sb5.toString();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.fragment.NTMutualDataFragment.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (sb6.length() == 0) {
                        NTMutualDataFragment.this.F.setText("\u5176\u4ed6\u670d\u52a1\u6570\u636e\u4e3a\u7a7a");
                    } else {
                        NTMutualDataFragment.this.F.setText(sb5.toString());
                    }
                }
            });
        }
    };

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
        a() {
        }

        @Override // hx3.b
        public void onQueryResult(e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
            if (eVar.a() != 0) {
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16 = eVar.b();
            int size = b16.size();
            QLog.d(QPublicBaseFragment.TAG, 2, "friendsCategoryInfo.arrayList.size:" + size);
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = b16.get(i3);
                QLog.d(QPublicBaseFragment.TAG, 2, "i:" + i3 + " CategoryId:" + bVar.d() + " CategoryName:" + bVar.f());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.f167359cw2, viewGroup, false);
        this.C = inflate;
        this.D = (TextView) inflate.findViewById(R.id.ohs);
        this.E = (TextView) this.C.findViewById(R.id.ohx);
        this.F = (TextView) this.C.findViewById(R.id.oht);
        return this.C;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
