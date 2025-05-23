package com.tencent.mobileqq.apollo.store;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.a;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloGuestsStateActivity extends BaseActivity implements a {
    public static final int MSG_INIT_DRESS_TAG = 1;
    public static final int MSG_SET_ROLE_BACKGROUND = 5;
    public static final int MSG_VISIBLE_PAAISENUM = 2;
    public static final int MSG_ZAN_COUNT_GET = 0;
    public static final String TAG = "ApolloGuestsStateActivity";
    protected ActionSheet actionSheet;
    View mDialog;
    private ObjectAnimator mFlowScaleAnimator;
    private ObjectAnimator mFlowShrinkAnimator;
    Handler mHandler;
    List<View> dressTag = new ArrayList();
    int mRoleId = 0;
    float mDensity = 0.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        getWindow().addFlags(16777216);
        super.doOnCreate(bundle);
        this.mHandler = PngFrameManager.a(this);
        this.mDensity = super.getResources().getDisplayMetrics().density;
        SystemBarActivityModule.setImmersiveStatus(this);
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setStatusColor(0);
            systemBarComp.setStatusBarColor(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.dressTag.clear();
        this.dressTag = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
        ObjectAnimator objectAnimator = this.mFlowScaleAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.mFlowScaleAnimator = null;
        }
        ObjectAnimator objectAnimator2 = this.mFlowShrinkAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.mFlowShrinkAnimator = null;
        }
    }

    @Override // com.tencent.mobileqq.magicface.drawable.a
    public void handleMsg(Message message) {
        Bitmap bitmap;
        if (message.what == 5 && (bitmap = (Bitmap) message.obj) != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            this.mDialog.setBackgroundDrawable(bitmapDrawable);
            ImageCacheHelper.f98636a.i(this.mRoleId + "apollo_cmshow_background", bitmapDrawable, Business.AIO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (isFinishing()) {
            return true;
        }
        finish();
        overridePendingTransition(0, 0);
        return true;
    }
}
