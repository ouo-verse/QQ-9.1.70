package com.qzone.common.activities.base;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTransparentFragmentHolderActivity extends QZoneFragmentHolderActivity {
    @Override // com.qzone.common.activities.base.QZoneFragmentHolderActivity, com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.qzone.common.activities.base.QZoneFragmentHolderActivity, com.qzone.common.activities.base.BaseActivity
    protected int getFeedListBackgroundId() {
        return -1;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected boolean isNeedQZoneStyleActivityAnim() {
        return false;
    }
}
