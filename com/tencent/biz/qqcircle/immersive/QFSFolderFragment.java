package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.bk;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager;
import com.tencent.biz.qqcircle.immersive.part.QFSDrawerPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart;
import com.tencent.biz.qqcircle.immersive.part.teenmode.QFSTeenModeChangePart;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.qqcircle.utils.bo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.node.ArgusTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_qcircle_915_fabu_folder_activity", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes4.dex */
public class QFSFolderFragment extends QFSBaseFragment {
    private List<Part> E;
    private xa0.d F;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (HostAppSettingUtil.isDebugVersion() && bo.b(view)) {
                throw new IllegalStateException("couldn't set fitSystemWindows true below folder decorView");
            }
            return windowInsetsCompat;
        }
    }

    private boolean rh() {
        if (QCirclePluginUtil.isFromPadNavigation(getActivity())) {
            return true;
        }
        if (QCirclePluginUtil.isNewFolderPage(getActivity())) {
            return false;
        }
        boolean isOnThirdTab = ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        QLog.d("ASDynamicEngine_back_qcircle", 1, "QCircleFolder back isPluginTab:" + isOnThirdTab + "_");
        return isOnThirdTab;
    }

    private boolean sh() {
        HashMap<String, String> schemeAttrs;
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (qCircleInitBean == null || (schemeAttrs = qCircleInitBean.getSchemeAttrs()) == null) {
            return false;
        }
        return TextUtils.equals(schemeAttrs.get("IS_PRELOAD"), "true");
    }

    private boolean th() {
        return !uq3.c.M6();
    }

    private void uh(ASEngineTabBackEvent aSEngineTabBackEvent) {
        if (!aSEngineTabBackEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            return;
        }
        boolean onBackEvent = onBackEvent();
        if (ASInject.g().getOnBackEventListener() != null) {
            ASInject.g().getOnBackEventListener().onBackEvent(onBackEvent, ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        }
    }

    private void vh(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (!aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            return;
        }
        if (aSEngineTabStatusEvent.isSelected()) {
            QLog.d("QFSFolderFragment", 1, "receive onTab selected event");
            QCirclePluginGlobalInfo.L();
        } else {
            QCirclePluginGlobalInfo.M(getContext());
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101873", false)) {
                QFSEcommercePreloadManager.j().r(getContext());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        boolean sh5 = sh();
        if (this.E == null) {
            ArrayList arrayList = new ArrayList();
            this.E = arrayList;
            arrayList.add(new QFSDrawerPart());
            if (!QCirclePluginUtil.isNewFolderPage(getActivity()) && QCirclePluginUtil.isTabMode()) {
                QLog.d("QFSFolderFragment", 1, "assembleParts in tab mode");
                this.E.add(new g60.a(getPartManager(), sh5));
            } else {
                QLog.d("QFSFolderFragment", 1, "assembleParts in dynamic page mode");
                this.E.add(new d60.a(getPartManager()));
                this.E.add(new k60.a(false));
            }
            this.E.add(new bk());
            this.E.add(new QFSMainTabTipExpPart(false));
            this.E.add(new QFSTeenModeChangePart());
        }
        return this.E;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public boolean enableReleaseAudioFocus() {
        if (ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && QCirclePluginUtil.isTabMode() && (QCirclePluginUtil.isTopActivityInQCircle(getActivity()) || !QCirclePluginUtil.isTabMode())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gc6;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(ASEngineTabBackEvent.class);
        eventClass.add(ASEngineTabStatusEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFolderFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (rh() && ASInject.g().getOnBackEventListener() != null) {
            boolean onBackEvent = super.onBackEvent();
            QLog.d("ASDynamicEngine_back_qcircle", 1, "FsFolder back onBackEvent:" + onBackEvent);
            ASInject.g().getOnBackEventListener().onBackEvent(onBackEvent, ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        try {
            xa0.d dVar = this.F;
            if (dVar != null) {
                dVar.b(configuration);
            }
            super.onConfigurationChanged(configuration);
            xa0.d dVar2 = this.F;
            if (dVar2 != null) {
                dVar2.a(configuration);
            }
        } catch (Exception e16) {
            QLog.e("QFSFolderFragment", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (QCirclePluginUtil.isQFSTabNativeFragmentMode(getContext())) {
            xa0.d dVar = new xa0.d((Activity) getContext());
            this.F = dVar;
            dVar.d(bundle);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.e("QFSFolderFragment", 1, "fs_lifecycle onDestroy");
        super.onDestroy();
        Map<String, String> f16 = QCircleNetWorkTestHelper.f();
        QCircleNetWorkTestHelper.d(f16);
        QCircleFolderFunnelCollect.recordNetWorkSpeedInfo(f16);
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_EXIT_CIRCLE);
        xa0.d dVar = this.F;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.d("QFSFolderFragment", 1, "fs_lifecycle onPause");
        super.onPause();
        xa0.d dVar = this.F;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        xa0.d dVar = this.F;
        if (dVar != null) {
            dVar.g(simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof ASEngineTabBackEvent) {
            uh((ASEngineTabBackEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            vh((ASEngineTabStatusEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d("QFSFolderFragment", 1, "fs_lifecycle onResume");
        QCircleFolderFunnelCollect.setExpFastPlay(l40.i.I());
        super.onResume();
        xa0.d dVar = this.F;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        xa0.d dVar = this.F;
        if (dVar != null) {
            dVar.i();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.d("QFSFolderFragment", 1, "fs_lifecycle onStop");
        super.onStop();
        xa0.d dVar = this.F;
        if (dVar != null) {
            dVar.j();
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (HostAppSettingUtil.isDebugVersion()) {
            ViewCompat.setOnApplyWindowInsetsListener(view, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        View view2;
        super.onViewCreatedBeforePartInit(view, bundle);
        if (th() && (view2 = ((QCircleBaseFragment) this).mContentView) != null) {
            view2.setBackgroundColor(getResources().getColor(R.color.bjg));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment
    protected boolean qh() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    protected void pushPageScene() {
    }
}
