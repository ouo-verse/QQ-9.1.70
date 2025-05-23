package com.tencent.biz.qqcircle.immersive.tab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSRefreshSubTabEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSKuiklyView;
import com.tencent.biz.qqcircle.lazyload.QFSNotifyLazyLoadEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StTabOpInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSKuiklyFragment extends QFSFolderTabFragment implements t40.b {
    private String R;
    private String S;
    private String T;
    private Map<String, String> U;
    private QFSKuiklyView V;
    private boolean W;

    public QFSKuiklyFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        if (qCircleTabInfo != null && qCircleTabInfo.getTabDiyConfig() != null) {
            QQCircleFeedBase$StTabOpInfo tabDiyConfig = qCircleTabInfo.getTabDiyConfig();
            this.R = qCircleTabInfo.getTabTaskId();
            ti(ri(tabDiyConfig.jumpUrlInfo.jumpUrl.get()));
        }
        QFSActivityTabFragment.yi(this.R);
    }

    private boolean pi() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_kuikly_tab_preload", false);
    }

    private int qi() {
        QLog.d("QFSKuiklyFragment", 1, "getDefaultTopBarHeight");
        return ImmersiveUtils.getStatusBarHeight(getContext()) + ImmersiveUtils.dpToPx(48.0f);
    }

    public static String ri(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("mqqapi://kuikly/open")) {
            return null;
        }
        return str;
    }

    private int si() {
        if (!this.P) {
            return 0;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return qi();
        }
        View findViewById = activity.findViewById(R.id.vg5);
        if (findViewById != null && findViewById.getMeasuredHeight() != 0) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            if (i3 == 0) {
                return qi();
            }
            return i3 + findViewById.getMeasuredHeight();
        }
        return qi();
    }

    private void ti(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                RFWLog.e("QFSKuiklyFragment", RFWLog.USR, "[initPageConfig] jumpUrl:" + str);
                return;
            }
            HashMap<String, String> c16 = com.tencent.biz.qqcircle.d.c(str);
            if (c16 != null && !c16.isEmpty()) {
                this.U = c16;
                this.S = String.valueOf(c16.get("page_name"));
                this.T = String.valueOf(c16.get("bundle_name"));
                if (TextUtils.isEmpty(this.R)) {
                    this.R = String.valueOf(c16.get(QCircleSchemeAttr.WebView.KEY_BUSINESS_ID));
                    return;
                }
                return;
            }
            RFWLog.e("QFSKuiklyFragment", RFWLog.USR, "[initPageConfig] kuiklyPageConfig is null;jumpUrl" + str);
        } catch (Exception e16) {
            RFWLog.e("QFSKuiklyFragment", RFWLog.USR, "[initPageConfig] error:" + e16);
        }
    }

    private void ui() {
        QFSKuiklyView qFSKuiklyView = this.V;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.q0();
        }
    }

    private void vi() {
        RFWLog.d("QFSKuiklyFragment", RFWLog.USR, "[realLoadData] mPageName:" + this.S + ",mBundleName:" + this.T);
        if (!TextUtils.isEmpty(this.S) && !TextUtils.isEmpty(this.T)) {
            Map<String, String> map = this.U;
            if (map == null) {
                map = new HashMap<>();
            }
            Map<String, String> map2 = map;
            map2.put("qfsTobBarPos", String.valueOf(ImmersiveUtils.pxToDp(si())));
            QFSKuiklyView qFSKuiklyView = this.V;
            if (qFSKuiklyView != null) {
                qFSKuiklyView.n0(this.S, this.T, null, -1, true, map2);
            }
        }
    }

    private void wi() {
        QFSKuiklyView qFSKuiklyView;
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (!(qCircleInitBean instanceof QCircleFolderBean)) {
            return;
        }
        QCircleFolderBean qCircleFolderBean = (QCircleFolderBean) qCircleInitBean;
        int assignShowTabType = qCircleFolderBean.getAssignShowTabType();
        int assignShowSubTabType = qCircleFolderBean.getAssignShowSubTabType();
        long enterTime = qCircleFolderBean.getEnterTime();
        if (Uh(assignShowTabType, assignShowSubTabType) && (qFSKuiklyView = this.V) != null) {
            qFSKuiklyView.w0(qCircleFolderBean.getLastPageScheme(), enterTime);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    protected void Hh(QFSNotifyLazyLoadEvent qFSNotifyLazyLoadEvent) {
        super.Hh(qFSNotifyLazyLoadEvent);
        if (qFSNotifyLazyLoadEvent.getNotifyId() == 8 && pi()) {
            RFWLog.d("QFSKuiklyFragment", RFWLog.USR, "[doPreload]");
            load();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return Collections.emptyList();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void fi() {
        RFWLog.d("QFSKuiklyFragment", RFWLog.USR, "[scrollToTopAndRefresh]");
        Map<String, String> map = this.U;
        if (map != null && TextUtils.equals(map.get("refresh_by_client"), String.valueOf(1))) {
            vi();
        } else {
            ui();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        String titleName = getTitleName();
        if (!TextUtils.isEmpty(titleName)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, titleName);
        }
        if (!TextUtils.isEmpty(this.R)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_ID, this.R);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gdk;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        if (TextUtils.isEmpty(this.Q)) {
            return QCircleDaTongConstant.PageId.PG_XSJ_OPERATION_TAB_PAGE;
        }
        return this.Q;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSRefreshSubTabEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSKuiklyFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        if (this.W) {
            return;
        }
        this.W = true;
        vi();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QFSKuiklyView qFSKuiklyView = this.V;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onDestroy();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QFSKuiklyView qFSKuiklyView = this.V;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QFSRefreshSubTabEvent) && ((QFSRefreshSubTabEvent) simpleBaseEvent).getCurrentPos() == this.G) {
            fi();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSKuiklyView qFSKuiklyView = this.V;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onResume();
            wi();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        this.V = (QFSKuiklyView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f363414a);
    }

    public QFSKuiklyFragment(String str, QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        ti(str);
        QFSActivityTabFragment.yi(this.R);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void di() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void scrollToTop() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void sh() {
    }

    @Override // t40.b
    public void onHandlerMessage(String str, Object... objArr) {
    }
}
