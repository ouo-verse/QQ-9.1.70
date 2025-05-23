package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFolderOwnerFragment extends QFSFolderProfileFragment {
    public QFSFolderOwnerFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("qfs_key_bundle_personal_fragment_scene", "qfs_personal_fragment_scene_home_owner");
        setArguments(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment
    public void Xh() {
        this.L = QCirclePluginGlobalInfo.m();
        super.Xh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSFolderProfileFragment, com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFolderOwnerFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (onCreateView != null) {
            onCreateView.setPadding(onCreateView.getPaddingLeft(), onCreateView.getPaddingTop(), onCreateView.getPaddingRight(), onCreateView.getPaddingBottom() + cx.a(56.0f));
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }
}
