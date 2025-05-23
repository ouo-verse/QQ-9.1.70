package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.comm.adevent.ADListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IADI {
    void closePopupWindow();

    void destory();

    void loadAd();

    void setAdListener(ADListener aDListener);

    void show();

    void show(Activity activity);

    void showAsPopupWindown();

    void showAsPopupWindown(Activity activity);
}
