package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSTroopBindFeedPart;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public class QFSPersonalFeedBindQQGroupFragment extends QCircleBaseFragment {
    private static final String TAG = "QFSPersonalFeedBindQQGroupFragment";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreatedAfterPartInit$0(View view, BaseAction baseAction) {
        if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
            onBackEvent();
            return null;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QFSTroopBindFeedPart());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168727gm2;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SET_SHOW_GROUP_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
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

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return true;
        }
        return super.onBackEvent();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.f55572i_);
        qUISecNavBar.setAutoAdaptTransparent(true);
        qUISecNavBar.setLeftImageRes(R.drawable.qui_chevron_left);
        qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        qUISecNavBar.setTitleAlpha(0.0f);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.l
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$onViewCreatedAfterPartInit$0;
                lambda$onViewCreatedAfterPartInit$0 = QFSPersonalFeedBindQQGroupFragment.this.lambda$onViewCreatedAfterPartInit$0((View) obj, (BaseAction) obj2);
                return lambda$onViewCreatedAfterPartInit$0;
            }
        });
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
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
