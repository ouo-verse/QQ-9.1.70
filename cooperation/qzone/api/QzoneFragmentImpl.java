package cooperation.qzone.api;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface QzoneFragmentImpl {
    void attachQQContext(Activity activity, AppRuntime appRuntime);

    void clearCache();

    void clearMemoryCache();

    void forceRefresh();

    void onSwitchOutofQzone();

    void onSwitchToQzone();

    void resetReportFlag();

    void setQzoneSwitchlistener(OnSwitchQzoneTabListener onSwitchQzoneTabListener);

    void setRightButtonType(int i3);

    int setTitleAlphaAndGetLastValue(int i3);

    void setTitleView(ViewGroup viewGroup);

    void updatePublishBox(Intent intent);
}
