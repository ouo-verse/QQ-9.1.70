package com.qwallet.activity.patternlock;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.sdk.activity.NetBaseActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/qwallet/activity/patternlock/QWalletPatternLockGuardianFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "", "startQWalletUnlockActivity", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "hasFocus", "onWindowFocusChanged", "finish", "intent", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "Lcom/qwallet/activity/patternlock/biz/a;", "patternLockBiz", "Lcom/qwallet/activity/patternlock/biz/a;", "isNeedOpenPatternLock", "Z", "", "intervalTime", "J", "lastLockTime", "canLock", "isAppForeground", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public class QWalletPatternLockGuardianFragment extends NetBaseActivity {

    @NotNull
    public static final String EXTRA_IS_SHOW_PATTRENLOCK = "extra_show_pattern_lock";
    private long intervalTime;
    private boolean isNeedOpenPatternLock;
    private final long lastLockTime;

    @Nullable
    private com.qwallet.activity.patternlock.biz.a patternLockBiz;
    private boolean canLock = true;
    private boolean isAppForeground = true;

    private final void startQWalletUnlockActivity() {
        QwLog.i("mQWalletPLockBgIntervalTime: " + this.intervalTime + " mQWalletPLockLastBgTime: " + this.lastLockTime + " curTime: " + NetConnInfoCenter.getServerTime());
        if (this.intervalTime > 0 && System.currentTimeMillis() - this.lastLockTime < this.intervalTime * 1000) {
            return;
        }
        try {
            com.qwallet.activity.patternlock.biz.a aVar = this.patternLockBiz;
            if (aVar != null) {
                aVar.d();
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    public void finish() {
        super.finish();
        com.qwallet.activity.patternlock.biz.a aVar = this.patternLockBiz;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        com.qwallet.activity.patternlock.biz.a aVar;
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 102 || requestCode == 103) && (aVar = this.patternLockBiz) != null) {
            aVar.g(requestCode, resultCode);
        }
        this.canLock = false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.patternLockBiz = com.qwallet.activity.patternlock.biz.c.a().b(0).e(new WeakReference<>(getActivity()));
            Intent intent = getIntent();
            if (intent != null) {
                boolean booleanExtra = intent.getBooleanExtra(EXTRA_IS_SHOW_PATTRENLOCK, false);
                this.isNeedOpenPatternLock = booleanExtra;
                if (booleanExtra) {
                    com.qwallet.activity.patternlock.biz.a aVar = this.patternLockBiz;
                    if (aVar != null) {
                        aVar.d();
                    }
                    this.intervalTime = PatternLockUtils.getForgroundIntervalTime(getContext(), this.mUin);
                }
            }
        } catch (Throwable th5) {
            QLog.e(((NetBaseActivity) this).TAG, 1, QLog.getStackTraceString(th5));
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.qwallet.activity.patternlock.biz.a aVar = this.patternLockBiz;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.qwallet.activity.patternlock.biz.a aVar = this.patternLockBiz;
        if (aVar != null) {
            aVar.h();
            QwLog.i("isNeedOpenPatternLock: " + this.isNeedOpenPatternLock + " mCanLock: " + this.canLock + " getAppForeground: " + BaseGesturePWDUtil.getAppForground(getContext()));
            boolean appForground = BaseGesturePWDUtil.getAppForground(getContext());
            this.isAppForeground = appForground;
            if (this.isNeedOpenPatternLock && !appForground && !TextUtils.isEmpty(this.mUin) && this.canLock) {
                startQWalletUnlockActivity();
            }
            if (!this.isAppForeground) {
                this.isAppForeground = true;
                ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).setAppForground(getContext(), this.isAppForeground);
            }
            this.canLock = true;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean hasFocus) {
        com.qwallet.activity.patternlock.biz.a aVar;
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && (aVar = this.patternLockBiz) != null) {
            aVar.f();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        this.canLock = false;
    }
}
