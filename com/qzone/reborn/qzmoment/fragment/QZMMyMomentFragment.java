package com.qzone.reborn.qzmoment.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import com.qzone.reborn.qzmoment.bean.QZMMyMomentInitBean;
import com.qzone.reborn.qzmoment.part.QZMCommentPanelPart;
import com.qzone.reborn.qzmoment.part.ab;
import com.qzone.reborn.qzmoment.part.j;
import com.qzone.reborn.qzmoment.part.s;
import com.qzone.reborn.qzmoment.part.t;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import gn.b;
import hn.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMMyMomentFragment extends QZMBaseFragment {
    private QZMMyMomentInitBean C;
    private b D;

    private void initIoc() {
        a aVar = new a();
        this.D = aVar;
        registerIoc(aVar, b.class);
    }

    private void parseIntent() {
        if (getActivity() == null) {
            QLog.e("QZoneBaseFragment", 1, "qzm activity is null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("QZoneBaseFragment", 1, "qzm activity intent is null");
            return;
        }
        if (intent.hasExtra("key_bundle_common_init_bean")) {
            this.C = (QZMMyMomentInitBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        }
        intent.putExtra("key_bundle_fragment_page_id", "pg_bas_personal_history");
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
        arrayList.add(new t());
        arrayList.add(new s());
        arrayList.add(new QZMCommentPanelPart());
        arrayList.add(new ab());
        arrayList.add(new j());
        arrayList.add(new cc("qzm_page_launch_my_moment"));
        return arrayList;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("author_id", LoginData.getInstance().getUinString());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f1283333;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_bas_personal_history";
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent();
        ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        initIoc();
    }
}
