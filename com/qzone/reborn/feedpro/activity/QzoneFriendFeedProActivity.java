package com.qzone.reborn.feedpro.activity;

import android.content.Intent;
import android.os.Bundle;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedpro.fragment.QzoneFriendFeedProFragment;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.IGdtActivityHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.refresh.c;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import com.tencent.richframework.argus.node.ArgusTag;
import common.config.service.QzoneConfig;
import ho.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import yo.d;

@ArgusTag(testConfigKey = "argus_qzone_feed", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/feedpro/activity/QzoneFriendFeedProActivity;", "Lcom/qzone/reborn/base/QZoneBaseActivity;", "Landroid/content/Intent;", "intent", "", "jumpOtherPageIfNeed", "handleReturnFeedToast", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onNewIntent", "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isTopResumedActivity", "onTopResumedActivityChanged", "", "a0", "Ljava/lang/String;", "mJumpSchema", "b0", "Z", "mShowReturnFeedToast", "<init>", "()V", "c0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFriendFeedProActivity extends QZoneBaseActivity {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String mJumpSchema = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mShowReturnFeedToast;

    private final void handleReturnFeedToast() {
        if (this.mShowReturnFeedToast && d.i(this.mJumpSchema, "returnactive=1")) {
            this.mShowReturnFeedToast = false;
            this.mJumpSchema = "";
            ToastUtil.r(QzoneConfig.getInstance().getConfig("qzonesetting", "TextViewReturnFeedToast", "\u8fd8\u6709\u66f4\u591a\u7cbe\u5f69\u52a8\u6001\uff0c\u53bb\u770b\u770b\u5427"));
            return;
        }
        this.mShowReturnFeedToast = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.QZoneBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        jumpOtherPageIfNeed(intent);
        super.onCreate(savedInstanceState);
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
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.d("QzoneFriendFeedProActivity", 1, "onNewIntent");
        if (g.f53821a.b().M1()) {
            jumpOtherPageIfNeed(intent);
        }
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        handleReturnFeedToast();
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        super.onTopResumedActivityChanged(isTopResumedActivity);
        ((IGdtActivityHandler) QRoute.api(IGdtActivityHandler.class)).onTopResumedActivityChanged(new c(this), isTopResumedActivity);
    }

    private final void jumpOtherPageIfNeed(Intent intent) {
        d.f450705a = true;
        String stringExtra = intent.getStringExtra(ChatsRevealApiImpl.KEY_JUMP_SCHEME);
        this.mJumpSchema = stringExtra;
        QLog.d("QzoneFriendFeedProActivity", 1, "mJumpSchema:" + stringExtra);
        h.d(this, this.mJumpSchema);
        intent.putExtra("public_fragment_class", QzoneFriendFeedProFragment.class.getName());
    }
}
