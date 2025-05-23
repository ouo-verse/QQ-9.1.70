package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes37.dex */
public class QZonePictureViewerFragment extends BasePartFragment {
    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZonePictureViewerPart());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return new FrameLayout(getContext());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        com.tencent.biz.richframework.compat.f.k(this);
    }

    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
