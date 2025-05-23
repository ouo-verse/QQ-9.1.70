package com.tencent.mobileqq.share.api;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShareActionSheetApi extends QRouteApi {
    void dismiss();

    Window getWindow();

    void init(Context context);

    boolean isShowing();

    void setActionSheetClickListener(ShareActionSheetClickListener shareActionSheetClickListener);

    void setActionSheetItems(ShareConfig shareConfig);

    void setActionSheetItems(List<ShareConfig> list, List<ShareConfig> list2);

    void setBottomView(View view);

    void setCancelListener(DialogInterface.OnCancelListener onCancelListener);

    void setExtras(Bundle bundle);

    void setIntentForStartForwardRecentActivity(Intent intent);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOnShowListener(DialogInterface.OnShowListener onShowListener);

    void setQCircleActionSheetClickListener(QCircleActionSheetClickListener qCircleActionSheetClickListener);

    void setRecentlyUserSorter(a aVar);

    void setRowVisibility(int i3, int i16, int i17);

    void show();
}
