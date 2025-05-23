package com.qzone.reborn.feedx.activity;

import android.content.Intent;
import android.os.Bundle;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.fragment.QZoneFriendFeedXFragment;
import com.qzone.util.ToastUtil;
import com.tencent.gdtad.IGdtActivityHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.refresh.c;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import com.tencent.richframework.argus.node.ArgusTag;
import common.config.service.QzoneConfig;
import ho.h;
import yo.d;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_qzone_feed", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes37.dex */
public class QZoneFriendFeedXActivity extends QZoneBaseActivity {
    private static final String TAG = "QZoneFriendFeedXActivity";
    private String mJumpSchema;
    private Boolean mShowReturnFeedToast;

    private void handleReturnFeedToast() {
        Boolean bool = this.mShowReturnFeedToast;
        if (bool != null && bool.booleanValue() && d.i(this.mJumpSchema, "returnactive=1")) {
            this.mShowReturnFeedToast = Boolean.FALSE;
            this.mJumpSchema = "";
            ToastUtil.r(QzoneConfig.getInstance().getConfig("qzonesetting", "TextViewReturnFeedToast", "\u8fd8\u6709\u66f4\u591a\u7cbe\u5f69\u52a8\u6001\uff0c\u53bb\u770b\u770b\u5427"));
            return;
        }
        this.mShowReturnFeedToast = Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.QZoneBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        jumpOtherPageIfNeed(getIntent());
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.QZoneBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.f450705a = false;
        if (get_viewModelStore() != null && isChangingConfigurations() && g.f53821a.b().l()) {
            get_viewModelStore().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        handleReturnFeedToast();
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z16) {
        super.onTopResumedActivityChanged(z16);
        ((IGdtActivityHandler) QRoute.api(IGdtActivityHandler.class)).onTopResumedActivityChanged(new c(this), z16);
    }

    private void jumpOtherPageIfNeed(Intent intent) {
        d.f450705a = true;
        this.mJumpSchema = intent.getStringExtra(ChatsRevealApiImpl.KEY_JUMP_SCHEME);
        QLog.d(TAG, 1, "mJumpSchema:" + this.mJumpSchema);
        h.d(this, this.mJumpSchema);
        intent.putExtra("public_fragment_class", QZoneFriendFeedXFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        QLog.d(TAG, 1, "onNewIntent");
        if (g.f53821a.b().M1()) {
            jumpOtherPageIfNeed(intent);
        }
        super.onNewIntent(intent);
    }
}
