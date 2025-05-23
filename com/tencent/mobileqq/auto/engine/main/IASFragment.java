package com.tencent.mobileqq.auto.engine.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IASFragment {
    View getTargetDecorView();

    boolean isAdded();

    boolean isRealFragment();

    void onActivityResult(int i3, int i16, Intent intent);

    void onCreate(Bundle bundle);

    View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void onDestroy();

    void onNewIntent(@NonNull Bundle bundle);

    void onPause();

    void onResume();

    void onStop();

    void setArguments(Bundle bundle);

    void setHostActivity(Activity activity);

    void setIsSelected(boolean z16);
}
