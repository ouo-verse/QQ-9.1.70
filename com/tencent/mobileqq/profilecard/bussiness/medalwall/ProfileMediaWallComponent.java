package com.tencent.mobileqq.profilecard.bussiness.medalwall;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileMediaWallComponent extends AbsQQProfileComponent<View> {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_CHECK_MEDAL_GUIDE = 100;
    private static final String TAG = "ProfileMediaWallComponent";
    private View mMedalTargetView;
    private boolean mNeedCheckMedalGuide;
    private Handler.Callback mUICallback;
    private Handler mUIHandler;

    public ProfileMediaWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mUICallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileMediaWallComponent.this);
                    }
                }

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                    }
                    if (message.what == 100) {
                        ProfileMediaWallComponent.this.checkShowMedalGuide(message);
                        return false;
                    }
                    return false;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkShowMedalGuide(Message message) {
        boolean z16;
        try {
            View view = this.mMedalTargetView;
            if (view != null && view.getWidth() > 0 && this.mMedalTargetView.getHeight() > 0) {
                ((MedalWallMng) this.mApp.getManager(QQManagerFactory.MEDAL_WALL_MNG)).e(this.mActivity, this.mMedalTargetView, 2, ((ProfileCardInfo) this.mData).card);
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                try {
                    if (message.arg1 < 2) {
                        Message obtainMessage = this.mUIHandler.obtainMessage();
                        obtainMessage.what = message.what;
                        obtainMessage.arg1 = message.arg1 + 1;
                        this.mUIHandler.sendMessageDelayed(obtainMessage, 1000L);
                    }
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, "checkMedalGuide fail.", e);
                    if (!QLog.isColorLevel()) {
                    }
                }
            }
        } catch (Exception e17) {
            e = e17;
            z16 = true;
        }
        if (!QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("checkMedalGuide needResendMsg=%s", Boolean.valueOf(z16)));
            DATA data = this.mData;
            if (((ProfileCardInfo) data).card != null) {
                Card card = ((ProfileCardInfo) data).card;
                QLog.d(TAG, 2, String.format("checkMedalGuide medalSwitchDisable=%s iMedalCount=%s iNewCount=%s iUpgradeCount=%s", Boolean.valueOf(card.medalSwitchDisable), Integer.valueOf(card.iMedalCount), Integer.valueOf(card.iNewCount), Integer.valueOf(card.iUpgradeCount)));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initViews() {
        QBaseActivity qBaseActivity;
        Resources resources;
        if (this.mViewContainer == 0 || (qBaseActivity = this.mActivity) == null || (resources = qBaseActivity.getResources()) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.f158724ne), resources.getDimensionPixelSize(R.dimen.f158724ne));
        layoutParams.addRule(13);
        if (this.mViewContainer instanceof ViewGroup) {
            View view = new View(this.mActivity);
            this.mMedalTargetView = view;
            ((ViewGroup) this.mViewContainer).addView(view, layoutParams);
            QLog.i(TAG, 1, "initViews success!");
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1025;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        this.mUIHandler = new Handler(Looper.getMainLooper(), this.mUICallback);
        initViews();
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mNeedCheckMedalGuide = true;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            MedalGuideView.d();
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPause();
            this.mUIHandler.removeMessages(100);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        if (this.mNeedCheckMedalGuide) {
            this.mNeedCheckMedalGuide = false;
            this.mUIHandler.removeMessages(100);
            this.mUIHandler.sendEmptyMessageDelayed(100, 2000L);
        }
    }
}
