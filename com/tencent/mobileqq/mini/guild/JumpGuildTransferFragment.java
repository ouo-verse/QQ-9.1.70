package com.tencent.mobileqq.mini.guild;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/guild/JumpGuildTransferFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "appId", "", "isFirst", "", "onCreate", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onResume", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class JumpGuildTransferFragment extends QPublicBaseFragment {
    private static final String TAG = "JumpGuildTransferFragment";
    private boolean isFirst = true;
    private String appId = "";

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.d(TAG, 2, "onCreate");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String stringExtra = activity.getIntent().getStringExtra("url");
            String stringExtra2 = activity.getIntent().getStringExtra("mini_app_id");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra2, "fragmentActivity.intent.\u2026NT_KEY_MINI_APP_ID) ?: \"\"");
            }
            this.appId = stringExtra2;
            Intent intent = new Intent();
            intent.putExtra("url", stringExtra);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra(JoinGuildHelper.INTENT_KEY_JUMP_FROM_MINI_APP, true);
            intent.putExtra("mini_app_id", this.appId);
            intent.putExtra(JoinGuildHelper.INTENT_KEY_JUMP_GUILD_REQUEST, 100000);
            if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).shouldInterceptQQBrowserDelegationActivity(activity, stringExtra, intent)) {
                QLog.i(TAG, 1, "jumpToShareUrl shouldInterceptQQBrowserDelegationActivity");
                return;
            }
            QLog.i(TAG, 1, "jumpToShareUrl QQBrowserDelegationActivity");
            Intent intent2 = new Intent();
            intent2.setClass(activity, QQBrowserDelegationActivity.class);
            intent2.putExtra("url", stringExtra);
            intent2.putExtra("key_isReadModeEnabled", true);
            intent2.putExtra(JoinGuildHelper.INTENT_KEY_JUMP_FROM_MINI_APP, true);
            activity.startActivity(intent2);
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.d(TAG, 2, "onResume");
        if (!this.isFirst) {
            QRouteApi api = QRoute.api(IMiniAppService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
            ((IMiniAppService) api).startAppByAppid(getContext(), this.appId, "", "", LaunchScene.LAUNCH_SCENE_GAME_CENTER_FROM_GUILD, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        this.isFirst = false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
