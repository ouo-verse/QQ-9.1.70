package com.tencent.mobileqq.location.api;

import android.app.Dialog;
import android.support.annotation.UiThread;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.callback.d;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.i;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes15.dex */
public interface IFloatMapService extends IRuntimeService {
    void addFloatMapCallback(d dVar);

    Dialog createFloatExitConfirmDialog(int i3, String str);

    LocationRoom.b currentFloatWindowVisibleRoomKey();

    boolean enterFloat(QBaseActivity qBaseActivity, LocationRoom.b bVar);

    boolean getBadNetOnFloatWindowDialogShown();

    List<d> getFloatMapCallbacks();

    View getFloatMapView();

    @UiThread
    void quitFloat(int i3);

    void removeFloatMapCallback(d dVar);

    void setBadNetOnFloatWindowDialogShown(boolean z16);

    void setThemeChangedListener(i iVar);

    void showFloatTypeDialog(LocationRoom.b bVar);
}
