package com.qzone.reborn.qzmoment.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import com.qzone.reborn.qzmoment.bean.QZMMessageInitBean;
import com.qzone.reborn.qzmoment.part.QZMMessageListPart;
import com.qzone.reborn.qzmoment.part.r;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import rn.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMMessageListFragment extends QZMBaseFragment {
    private QZMMessageInitBean C;

    private void parseIntent() {
        if (getActivity() == null) {
            QLog.e("QZMMessageListFragment", 1, "qzm activity is null");
            return;
        }
        if (getActivity().getIntent() == null) {
            QLog.e("QZMMessageListFragment", 1, "qzm activity intent is null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null || !intent.hasExtra("key_bundle_common_init_bean")) {
            return;
        }
        this.C = (QZMMessageInitBean) intent.getSerializableExtra("key_bundle_common_init_bean");
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r());
        arrayList.add(new QZMMessageListPart());
        arrayList.add(new cc("qzm_page_launch_message"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128222s;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getTabReportPageId() {
        return "pg_bas_msglist";
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent();
        ph();
    }

    private void ph() {
        b.e(67);
        b.e(68);
        b.e(66);
        QLog.d("QZMMessageListFragment", 1, "clear all moment red count");
    }
}
