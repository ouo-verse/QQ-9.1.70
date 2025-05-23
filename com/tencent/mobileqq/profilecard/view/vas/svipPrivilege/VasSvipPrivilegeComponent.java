package com.tencent.mobileqq.profilecard.view.vas.svipPrivilege;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.SvipPrivilegeShow;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.view.vas.svipPrivilege.VasSvipPrivilegeComponent;
import com.tencent.mobileqq.vas.pendant.PendantBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes35.dex */
public class VasSvipPrivilegeComponent extends AbsProfileComponent<FrameLayout> {
    public static final int DIMISS_DELAY_MILLIS = 8000;
    private static final String TAG = "VasSvipPrivilegeComponent";
    private VasSvipPrivilegePopupWindow mSvipPrivilegeWindow;
    private Handler mUIHandler;

    public VasSvipPrivilegeComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doShowPrivilegePopWindow(List<SvipPrivilegeShow> list) {
        VasSvipPrivilegePopupWindow vasSvipPrivilegePopupWindow = this.mSvipPrivilegeWindow;
        if (vasSvipPrivilegePopupWindow != null && vasSvipPrivilegePopupWindow.isShowing()) {
            QLog.d(TAG, 1, "doShowPrivilegePopWindow already showing");
            return;
        }
        VasSvipPrivilegePopupWindow vasSvipPrivilegePopupWindow2 = new VasSvipPrivilegePopupWindow(((FrameLayout) this.mViewContainer).getContext(), (ProfileCardInfo) this.mData, list);
        this.mSvipPrivilegeWindow = vasSvipPrivilegePopupWindow2;
        vasSvipPrivilegePopupWindow2.setAnimationStyle(R.style.f173293c);
        this.mSvipPrivilegeWindow.showAtLocation((View) this.mViewContainer, 17, 0, 0);
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: rd2.a
                @Override // java.lang.Runnable
                public final void run() {
                    VasSvipPrivilegeComponent.this.lambda$doShowPrivilegePopWindow$1();
                }
            }, 8000L);
        }
        QLog.d(TAG, 1, "doShowPrivilegePopWindow");
    }

    private boolean isAllMaterialDownloaded(List<SvipPrivilegeShow> list) {
        boolean z16 = false;
        if (list != null && !list.isEmpty()) {
            boolean z17 = true;
            for (SvipPrivilegeShow svipPrivilegeShow : list) {
                int i3 = svipPrivilegeShow.appId;
                if (i3 != 34 && i3 != 48) {
                    QQVasUpdateBusiness business = QQVasUpdateBusiness.getBusiness(i3);
                    if (business instanceof PendantBusiness) {
                        if (!business.isFileExists(svipPrivilegeShow.itemId)) {
                            QLog.d(TAG, 1, "isAllMaterialDownloaded download:" + svipPrivilegeShow.itemId);
                            business.startDownload(svipPrivilegeShow.itemId);
                            z17 = false;
                        }
                    } else {
                        String scid = business.getScid(svipPrivilegeShow.itemId);
                        if (!business.isFileExist(scid)) {
                            QLog.d(TAG, 1, "isAllMaterialDownloaded download:" + scid);
                            business.startDownload(scid);
                            z17 = false;
                        }
                    }
                }
            }
            z16 = z17;
        }
        QLog.d(TAG, 1, "isAllMaterialDownloaded:" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doShowPrivilegePopWindow$1() {
        VasSvipPrivilegePopupWindow vasSvipPrivilegePopupWindow = this.mSvipPrivilegeWindow;
        if (vasSvipPrivilegePopupWindow == null || !vasSvipPrivilegePopupWindow.isShowing()) {
            return;
        }
        this.mSvipPrivilegeWindow.dismiss();
        QLog.d(TAG, 1, "doShowPrivilegePopWindow over time");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPrivilegePopWindow$0(List list) {
        if (isAllMaterialDownloaded(list)) {
            doShowPrivilegePopWindow(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showPrivilegePopWindow() {
        DATA data = this.mData;
        final List<SvipPrivilegeShow> list = ((ProfileCardInfo) data).card.svipPrivilegeShowItems;
        long j3 = ((ProfileCardInfo) data).card.svipPrivilegeLimitTime;
        if (isAllMaterialDownloaded(list)) {
            doShowPrivilegePopWindow(list);
            return;
        }
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: rd2.b
                @Override // java.lang.Runnable
                public final void run() {
                    VasSvipPrivilegeComponent.this.lambda$showPrivilegePopWindow$0(list);
                }
            }, j3);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1045;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mUIHandler = null;
        }
        VasSvipPrivilegePopupWindow vasSvipPrivilegePopupWindow = this.mSvipPrivilegeWindow;
        if (vasSvipPrivilegePopupWindow != null) {
            vasSvipPrivilegePopupWindow.dismiss();
            this.mSvipPrivilegeWindow = null;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((VasSvipPrivilegeComponent) profileCardInfo);
        DATA data = this.mData;
        if (((ProfileCardInfo) data).allInOne.f260789pa == 0 && ((ProfileCardInfo) data).card != null && ((ProfileCardInfo) data).card.svipPrivilegeNeedShow) {
            QLog.d(TAG, 1, "onDataUpdate need show svip privilege:" + ((ProfileCardInfo) this.mData).card.svipPrivilegeShowItems.size() + "-" + ((ProfileCardInfo) this.mData).card.svipPrivilegeLimitTime);
            showPrivilegePopWindow();
            ((ProfileCardInfo) this.mData).card.svipPrivilegeNeedShow = false;
        }
        return lambda$checkValidComponent$3;
    }
}
