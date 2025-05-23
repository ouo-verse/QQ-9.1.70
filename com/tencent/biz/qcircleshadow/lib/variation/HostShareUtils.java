package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActionSheetApi;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.mobileqq.share.api.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostShareUtils {
    private static final String IS_FORCE_NIGHT_THEME_KEY = "is_force_night_theme";
    private IShareActionSheetApi mInstance;

    public HostShareUtils(Context context) {
        IShareActionSheetApi iShareActionSheetApi = (IShareActionSheetApi) QRoute.api(IShareActionSheetApi.class);
        this.mInstance = iShareActionSheetApi;
        iShareActionSheetApi.init(context);
    }

    public void dismiss() {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.dismiss();
        }
    }

    public Window getWindow() {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            return iShareActionSheetApi.getWindow();
        }
        return null;
    }

    public boolean isShowing() {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            return iShareActionSheetApi.isShowing();
        }
        return false;
    }

    public void setActionSheetClickListener(ShareActionSheetClickListener shareActionSheetClickListener) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setActionSheetClickListener(shareActionSheetClickListener);
        }
    }

    public void setActionSheetItems(ShareConfig shareConfig) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setActionSheetItems(shareConfig);
        }
    }

    public void setBottomView(View view) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setBottomView(view);
        }
    }

    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setCancelListener(onCancelListener);
        }
    }

    public void setIntentForStartForwardRecentActivity(Intent intent) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setIntentForStartForwardRecentActivity(intent);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setOnDismissListener(onDismissListener);
        }
    }

    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setOnShowListener(onShowListener);
        }
    }

    public void setRecentlyUserSorter(a aVar) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setRecentlyUserSorter(aVar);
        }
    }

    public void setRowVisibility(int i3, int i16, int i17) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setRowVisibility(i3, i16, i17);
        }
    }

    public void show() {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.show();
        }
    }

    public void setActionSheetItems(List<ShareConfig> list, List<ShareConfig> list2) {
        IShareActionSheetApi iShareActionSheetApi = this.mInstance;
        if (iShareActionSheetApi != null) {
            iShareActionSheetApi.setActionSheetItems(list, list2);
        }
    }

    public void show(boolean z16) {
        if (this.mInstance != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(IS_FORCE_NIGHT_THEME_KEY, z16);
            this.mInstance.setExtras(bundle);
            this.mInstance.show();
        }
    }
}
