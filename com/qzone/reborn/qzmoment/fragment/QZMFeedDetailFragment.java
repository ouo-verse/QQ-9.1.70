package com.qzone.reborn.qzmoment.fragment;

import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import com.qzone.reborn.qzmoment.part.QZMCommentPanelPart;
import com.qzone.reborn.qzmoment.part.ab;
import com.qzone.reborn.qzmoment.part.h;
import com.qzone.reborn.qzmoment.part.i;
import com.qzone.reborn.qzmoment.part.j;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import gn.b;
import hn.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFeedDetailFragment extends QZMBaseFragment {
    private b C;

    private void initIoc() {
        a aVar = new a();
        this.C = aVar;
        registerIoc(aVar, b.class);
    }

    private void ph() {
        if (getActivity() == null) {
            QLog.e("QZoneBaseFragment", 1, "qzm activity is null");
        } else if (getActivity().getWindow() == null) {
            QLog.e("QZoneBaseFragment", 1, "qzm activity window is null");
        } else {
            getActivity().getWindow().setSoftInputMode(48);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i());
        arrayList.add(new h());
        arrayList.add(new QZMCommentPanelPart());
        arrayList.add(new ab());
        arrayList.add(new j());
        arrayList.add(new cc("qzm_page_launch_feed_detail"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128092f;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        initIoc();
    }
}
