package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IBaseActivityInjectInterface {
    boolean dispatchTouchEvent(QBaseActivity qBaseActivity, MotionEvent motionEvent);

    void startActivity(QBaseActivity qBaseActivity, Intent intent);

    void startActivity(QBaseActivity qBaseActivity, Intent intent, Bundle bundle);

    void startActivityForResult(QBaseActivity qBaseActivity, Intent intent, int i3);

    boolean startActivityForResult(QBaseActivity qBaseActivity, Intent intent, int i3, Bundle bundle);

    Intent startUnlockActivityIntent(Activity activity);
}
