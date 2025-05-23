package com.tencent.mobileqq.profilecard.vas.misc;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase;
import com.tencent.mobileqq.vip.diy.template.a;
import com.tencent.mobileqq.vip.diy.template.c;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DiyMoreInfoManagerImpl implements IDiyMoreInfoManager {
    private static final String TAG = "DiyMoreInfoViewHelper";
    private QQAppInterface mApp;
    private ProfileTemplateBase mBodyCreator;
    private String mCurrentJson = null;
    private HashMap<String, View> mDIYProfileMoreViewMap;
    private ProfileCardInfo mProfileCardInfo;
    private HashMap<String, View> mProfileMoreViewMap;

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public <T extends View> T getPhotoWallDiyView(ProfileCardInfo profileCardInfo) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return null;
        }
        return (T) profileTemplateBase.j(this.mApp, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public <T extends View> T getQZoneDiyView(String str) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return null;
        }
        profileTemplateBase.o(this.mDIYProfileMoreViewMap);
        return (T) this.mDIYProfileMoreViewMap.get(str);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void initDiyTemplate(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        if (qBaseActivity != null && profileCardInfo != null && ProfileTemplateApi.isDiyTemplateStyleID(profileCardInfo.curUseStyleId) && !TextUtils.isEmpty(profileCardInfo.card.diyComplicatedInfo)) {
            if (TextUtils.equals(this.mCurrentJson, profileCardInfo.card.diyComplicatedInfo)) {
                return;
            }
            this.mProfileCardInfo = profileCardInfo;
            this.mCurrentJson = profileCardInfo.card.diyComplicatedInfo;
            try {
                VasDiyData vasDiyData = (VasDiyData) profileCardInfo.getBusinessInfo(VasDiyData.class);
                this.mBodyCreator = a.a(qBaseActivity, vasDiyData.getBodyJson(), profileCardInfo, vasDiyData.getUrlPrefix());
                this.mDIYProfileMoreViewMap = new HashMap<>();
                this.mApp = (QQAppInterface) qBaseActivity.getAppRuntime();
                QLog.i(TAG, 1, "initDiyTemplate sucess");
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, new RuntimeException("diy info is illegal :" + e16), new Object[0]);
                this.mBodyCreator = null;
                this.mCurrentJson = null;
                return;
            }
        }
        this.mBodyCreator = null;
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public boolean isDiy() {
        if (this.mBodyCreator != null) {
            return true;
        }
        return false;
    }

    public void onDestroy() {
        HashMap<String, View> hashMap = this.mProfileMoreViewMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mApp = null;
        this.mBodyCreator = null;
        this.mProfileMoreViewMap = null;
        this.mDIYProfileMoreViewMap = null;
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateAccountInfoForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.v(view);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateBaseInfoForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.w(view);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateItemThemeForDIYTemplate(TextView textView, View view, ImageView imageView, View view2, View view3, View view4) {
        View view5;
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase != null) {
            if (profileTemplateBase instanceof c) {
                view5 = view3;
            } else {
                view5 = view2;
            }
            profileTemplateBase.x(null, textView, view, imageView, view5, view4);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateLevelForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.y(view);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateMetalForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.z(view);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updatePhotoWallForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.A(view);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateQzoneForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.D(view);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateSignForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.E(view);
    }

    @Override // com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager
    public void updateTroopMemInfoForDeepDiy(View view) {
        ProfileTemplateBase profileTemplateBase = this.mBodyCreator;
        if (profileTemplateBase == null) {
            return;
        }
        profileTemplateBase.F(view);
    }
}
