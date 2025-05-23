package com.qzone.reborn.feedx.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.app.QZoneRunInQQEnv;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.reborn.feedx.part.bz;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.OnSwitchQzoneTabListener;
import cooperation.qzone.api.QzoneFragmentImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import ve.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedXOldFrameFragment extends QZoneFriendFeedXFragment implements QzoneFragmentImpl {
    private static final float QQ_TAB_WIDGET_HEIGHT = 53.0f;
    public static final String TAG = "QZoneFeedXOldFrameFragment";

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        bz bzVar = new bz(R.id.n2d, buildBlockList(true), true);
        this.mListBlockPart = bzVar;
        arrayList.add(bzVar);
        arrayList.addAll(new ve.h().c(new i().g("1").e(getMFromDtPageId())));
        return arrayList;
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void attachQQContext(Activity activity, AppRuntime appRuntime) {
        u5.a.g(AccessibilityUtil.i(activity));
        if (QZoneRunInQQEnv.init(appRuntime)) {
            un.c.e();
            return;
        }
        throw new IllegalStateException("fained to init qzone env");
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void clearCache() {
        QZoneFeedService U = QZoneFeedService.U();
        if (U != null) {
            U.O();
        }
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void clearMemoryCache() {
        try {
            RFWThreadManager.getInstance().execOnSubThread(new c());
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void forceRefresh() {
        bz bzVar = this.mListBlockPart;
        if (bzVar != null) {
            bzVar.scrollToTop();
        }
        this.mFeedDataViewModel.P1();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_session_id", com.tencent.mobileqq.leba.report.d.c().f());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, com.tencent.mobileqq.leba.report.d.e());
        hashMap.put("SourceID", "");
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDS_PATTERN, "qzone");
        hashMap.put("is_avatar_display", "0");
        return hashMap;
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_discover_feeds_page";
    }

    @Override // com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment, com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 12;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onThemeColorChange();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        bz bzVar = this.mListBlockPart;
        if (bzVar != null && bzVar.getBlockContainer() != null) {
            this.mListBlockPart.getBlockContainer().setPadding(0, 0, 0, ar.d(53.0f));
        } else {
            com.tencent.xaction.log.b.a(TAG, 1, "change bottom padding fail");
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public int setTitleAlphaAndGetLastValue(int i3) {
        return 0;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void onSwitchOutofQzone() {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void onSwitchToQzone() {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void resetReportFlag() {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void setQzoneSwitchlistener(OnSwitchQzoneTabListener onSwitchQzoneTabListener) {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void setRightButtonType(int i3) {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void setTitleView(ViewGroup viewGroup) {
    }

    @Override // cooperation.qzone.api.QzoneFragmentImpl
    public void updatePublishBox(Intent intent) {
    }
}
