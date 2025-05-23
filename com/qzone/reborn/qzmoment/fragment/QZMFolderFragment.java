package com.qzone.reborn.qzmoment.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.feedx.part.QZoneFeedxUndealCountPart;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import com.qzone.reborn.qzmoment.bean.QZMFolderInitBean;
import com.qzone.reborn.qzmoment.part.QZMCommentPanelPart;
import com.qzone.reborn.qzmoment.part.QZMFolderFeedListPart;
import com.qzone.reborn.qzmoment.part.QZMFolderTitlePart;
import com.qzone.reborn.qzmoment.part.ab;
import com.qzone.reborn.qzmoment.part.j;
import com.qzone.reborn.qzmoment.part.l;
import com.qzone.reborn.qzmoment.part.n;
import com.qzone.reborn.qzmoment.part.p;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import gn.b;
import hn.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFolderFragment extends QZMBaseFragment {
    private QZMFolderInitBean C;
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
            this.C = (QZMFolderInitBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        }
        intent.putExtra("key_bundle_fragment_page_id", "pg_bas_consumption");
    }

    private void qh() {
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
        arrayList.add(new QZMFolderTitlePart());
        arrayList.add(new p());
        arrayList.add(new QZMFolderFeedListPart());
        arrayList.add(new QZMCommentPanelPart());
        arrayList.add(new l());
        arrayList.add(new ab());
        arrayList.add(new j());
        arrayList.add(new cc("qzm_page_launch_folder"));
        arrayList.add(new QZoneFeedxUndealCountPart());
        arrayList.add(new n());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f128192p;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_bas_consumption";
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent();
        qh();
        ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        initIoc();
    }

    private void ph() {
        rn.b.e(67);
        rn.b.e(68);
        QLog.d("QZoneBaseFragment", 1, "clear moment update red count");
    }
}
