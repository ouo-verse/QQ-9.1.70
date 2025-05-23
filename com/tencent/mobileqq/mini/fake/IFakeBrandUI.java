package com.tencent.mobileqq.mini.fake;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IFakeBrandUI {
    boolean doBeforeOnCreate(BaseActivity baseActivity, Bundle bundle);

    boolean doDispatchKeyEvent(KeyEvent keyEvent);

    void doOnActivityResult(BaseActivity baseActivity, int i3, int i16, Intent intent);

    void doOnBackPressed(BaseActivity baseActivity, boolean z16);

    boolean doOnCreate(BaseActivity baseActivity, Bundle bundle);

    void doOnDestroy(BaseActivity baseActivity);

    void doOnNewIntent(BaseActivity baseActivity, Intent intent);

    void doOnPause(BaseActivity baseActivity);

    void doOnResume(BaseActivity baseActivity);

    void doOnStart(BaseActivity baseActivity);

    void doOnStop(BaseActivity baseActivity);

    void doRefreshMiniBadge(BaseActivity baseActivity, Bundle bundle);

    void finish(BaseActivity baseActivity);

    boolean isWrapContent(BaseActivity baseActivity);

    boolean moveTaskToBack(BaseActivity baseActivity, boolean z16, boolean z17);

    void onProcessBackground(BaseActivity baseActivity, Bundle bundle);

    void onProcessForeGround(BaseActivity baseActivity, Bundle bundle);

    void onRefreshMiniBadge(BaseActivity baseActivity, Bundle bundle);
}
