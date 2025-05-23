package com.tencent.biz.qqcircle.immersive.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.richframework.widget.video.QFSAudioFocusManager;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSSearchBaseFragment extends QFSBaseFragment {
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View preloadView = p90.b.a().b().getPreloadView(getContext(), getContentLayoutId(), false);
        ((QCircleBaseFragment) this).mContentView = preloadView;
        if (preloadView == null) {
            ((QCircleBaseFragment) this).mContentView = layoutInflater.inflate(getContentLayoutId(), viewGroup, false);
        }
        View view = ((QCircleBaseFragment) this).mContentView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSAudioFocusManager.f().i(getContext());
    }
}
