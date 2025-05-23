package com.tencent.biz.qqcircle.immersive;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import b60.l;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSCommentPicLayerFragment extends QFSBaseFragment {
    QCircleCommentPicLayerBean E;

    private void parseIntent() {
        if (getActivity() == null) {
            QLog.e(getTAG(), 1, "[parseIntent] ");
            return;
        }
        if (getActivity().getIntent() == null) {
            QLog.e(getTAG(), 1, "[parseIntent] intent == null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            this.E = (QCircleCommentPicLayerBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        }
    }

    private void rh() {
        Window window;
        if (getActivity() != null) {
            window = getActivity().getWindow();
        } else {
            window = null;
        }
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b60.f(this.E));
        arrayList.add(new b60.k(this.E));
        arrayList.add(new b60.h());
        arrayList.add(new QCircleRichMediaDownLoadPart());
        arrayList.add(new b60.a());
        arrayList.add(new l(this.E));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g9y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_LARGE_PIC_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPicLayerFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 57;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        rh();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RFWThemeUtil.setStatusBarColor(getActivity(), QCircleSkinHelper.getInstance().getColor(R.color.cje));
    }
}
