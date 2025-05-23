package com.tencent.mobileqq.activity.history;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.api.IChatHistoryInnerApi;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/history/NTChatHistoryActivity;", "Lcom/tencent/mobileqq/app/BaseActivity;", "()V", "doOnCreate", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onActivityResult", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "setSystemUI", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class NTChatHistoryActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        setSystemUI();
        Fragment facadeChatHistoryFragment = ((IChatHistoryInnerApi) QRoute.api(IChatHistoryInnerApi.class)).getFacadeChatHistoryFragment();
        facadeChatHistoryFragment.setArguments(getIntent().getExtras());
        if (getSupportFragmentManager().findFragmentByTag("/base/chathistory/main/fragment") != null) {
            return true;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.content, facadeChatHistoryFragment, "/base/chathistory/main/fragment").commitAllowingStateLoss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 21) {
            return;
        }
        QLog.d("qqBaseActivity", 1, "onActivityResult resultCode=" + resultCode + ", data=" + data);
        if (resultCode != -1 || data == null || data.getIntExtra("forward_type", Integer.MAX_VALUE) == Integer.MAX_VALUE || !data.getBooleanExtra(AppConstants.Key.FORWARD_NT_CHAT_HISTORY, false)) {
            return;
        }
        RealNTChatHistoryMsgForwardSingleton.INSTANCE.doChatHistoryMsgForward(data);
    }

    private final void setSystemUI() {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        SystemBarActivityModule.setImmersiveStatus(this);
        LiuHaiUtils.initLiuHaiProperty(this);
        LiuHaiUtils.enableNotch(this);
    }
}
