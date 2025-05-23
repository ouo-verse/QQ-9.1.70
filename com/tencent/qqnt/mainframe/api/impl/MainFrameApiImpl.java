package com.tencent.qqnt.mainframe.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.pad.k;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.mainframe.api.IMainFrameApi;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/mainframe/api/impl/MainFrameApiImpl;", "Lcom/tencent/qqnt/mainframe/api/IMainFrameApi;", "()V", "backToConversation", "", "toMainMsgList", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MainFrameApiImpl implements IMainFrameApi {
    @Override // com.tencent.qqnt.mainframe.api.IMainFrameApi
    public void backToConversation() {
        SplashActivity splashActivity;
        Message obtainMessage;
        if (FrameHelperActivity.Gi()) {
            FrameHelperActivity.cj();
        }
        WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
        if (weakReference == null || (splashActivity = weakReference.get()) == null) {
            return;
        }
        if (SplashActivity.currentFragment != 1) {
            splashActivity.openMainFragment(new Intent());
        }
        k kVar = splashActivity.getqFragmentStackManager();
        if (AppSetting.t(splashActivity) && kVar != null && kVar.i()) {
            kVar.d();
        }
        FragmentManager supportFragmentManager = splashActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "splashActivity.supportFragmentManager");
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
        MainFragment mainFragment = findFragmentByTag instanceof MainFragment ? (MainFragment) findFragmentByTag : null;
        if (mainFragment == null) {
            return;
        }
        FrameFragment.d dVar = mainFragment.mTabIndicator;
        int currentTab = dVar.getCurrentTab();
        int i3 = a.f183038a;
        if (currentTab != i3) {
            dVar.setCurrentTab(i3);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        MqqHandler handler = appInterface != null ? appInterface.getHandler(Conversation.class) : null;
        if (handler == null || (obtainMessage = handler.obtainMessage(Conversation.MSG_CLOSE_MINI_APP_ENTRY, (Runnable) null)) == null) {
            return;
        }
        obtainMessage.sendToTarget();
    }

    @Override // com.tencent.qqnt.mainframe.api.IMainFrameApi
    public void toMainMsgList(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        intent.setComponent(SplashActivity.getAliasComponent(activity));
        intent.setFlags(335544320);
        intent.putExtra("tab_index", a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra(SplashActivity.CLEAR_FUNCTION_FRAGMENT, true);
        activity.startActivity(intent);
    }
}
