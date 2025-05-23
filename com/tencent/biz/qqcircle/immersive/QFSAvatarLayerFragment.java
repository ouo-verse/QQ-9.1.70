package com.tencent.biz.qqcircle.immersive;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleAvatarLayerBean;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAvatarLayerFragment extends QFSBaseFragment {
    private QCircleAvatarLayerBean E;

    private void parseIntent() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.e(getTAG(), 1, "[parseIntent]");
            return;
        }
        if (activity.getIntent() == null) {
            QLog.e(getTAG(), 1, "[parseIntent] intent == null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            this.E = (QCircleAvatarLayerBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new z50.e(this.E));
        arrayList.add(new z50.a(this.E));
        arrayList.add(new z50.d());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168657g82;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_AVATAR_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAvatarLayerFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent();
    }
}
