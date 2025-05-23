package com.qwallet.activity;

import a4.a;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetHomepageV2Rsp;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletServiceManagerActivity extends QWalletTitleBarActivity {
    private a4.a V;

    private void init(View view) {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("title");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "\u670d\u52a1\u7ba1\u7406";
            }
            setTitle(stringExtra);
        }
        int color = getResources().getColor(R.color.qui_common_bg_middle_light);
        uh(color, color);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.i4m);
        a4.a aVar = new a4.a(getContext());
        this.V = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        xh();
    }

    private LinkedHashMap<String, List<a.c>> wh(LinkedHashMap<String, List<com.qwallet.data.c>> linkedHashMap) {
        LinkedHashMap<String, List<a.c>> linkedHashMap2 = new LinkedHashMap<>();
        for (Map.Entry<String, List<com.qwallet.data.c>> entry : linkedHashMap.entrySet()) {
            ArrayList arrayList = new ArrayList();
            List<com.qwallet.data.c> value = entry.getValue();
            int size = value.size();
            int i3 = 0;
            for (com.qwallet.data.c cVar : value) {
                if (cVar != null && (cVar.f41557d & 16) != 16) {
                    boolean c16 = g.c(QWalletUtils.g(cVar.f41554a), true);
                    QLog.i("QWalletServiceManagerActivity", 1, cVar.f41555b + ",isSwitchOpen = " + c16);
                    arrayList.add(new a.c(cVar, c16, i3, size));
                    i3++;
                }
            }
            if (!arrayList.isEmpty()) {
                linkedHashMap2.put(entry.getKey(), arrayList);
            }
        }
        return linkedHashMap2;
    }

    private void xh() {
        byte[] d16 = g.d("qwallet_home_v2_rsp_bytes_" + QWalletUtils.h());
        if (d16.length > 0) {
            try {
                QWalletHomePage$GetHomepageV2Rsp qWalletHomePage$GetHomepageV2Rsp = new QWalletHomePage$GetHomepageV2Rsp();
                qWalletHomePage$GetHomepageV2Rsp.mergeFrom(d16);
                LinkedHashMap<String, List<com.qwallet.data.c>> linkedHashMap = new LinkedHashMap<>();
                if (qWalletHomePage$GetHomepageV2Rsp.app_list.get() != null && !qWalletHomePage$GetHomepageV2Rsp.app_list.get().isEmpty()) {
                    for (QWalletHomePage$AppGroup qWalletHomePage$AppGroup : qWalletHomePage$GetHomepageV2Rsp.app_list.get()) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<QWalletHomePage$AppInfo> it = qWalletHomePage$AppGroup.apps.get().iterator();
                        while (it.hasNext()) {
                            arrayList.add(com.qwallet.data.c.a(it.next()));
                        }
                        linkedHashMap.put(qWalletHomePage$AppGroup.title.get(), arrayList);
                    }
                }
                this.V.i0(wh(linkedHashMap));
            } catch (Exception e16) {
                QLog.e("QWalletServiceManagerActivity", 1, "getAppInfosFromLocal: ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void doOnBackPressed() {
        onBackEvent();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && keyEvent.getAction() == 0) {
            onBackEvent();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        QLog.i("QWalletServiceManagerActivity", 1, "onCreateView");
        View inflate = layoutInflater.inflate(R.layout.f168985hk2, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HomeLegacyBizManager.f277929d.e().postValue(Boolean.TRUE);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    @Override // com.qwallet.activity.QWalletTitleBarActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        init(view);
    }
}
