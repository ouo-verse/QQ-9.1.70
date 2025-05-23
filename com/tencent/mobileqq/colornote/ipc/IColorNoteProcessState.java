package com.tencent.mobileqq.colornote.ipc;

import android.graphics.Point;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.colornote.smallscreen.o;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IColorNoteProcessState extends QRouteApi {
    boolean getCanAddColorNote();

    Point getFloatingWindowPosition();

    boolean getSyncState();

    boolean isColorNoteExist(int i3, String str);

    boolean isRecentColorNoteTurnOn(AppRuntime appRuntime);

    void registerBroadcast();

    void setCanAddColorNote(boolean z16);

    void setColorNoteCurdListener(g gVar);

    void setRecentColorNoteSwitch(AppRuntime appRuntime, boolean z16);

    void setServiceSyncListener(o oVar);

    void setSyncState(boolean z16);

    void unregisterBroadcast();

    void updateColorNoteSet(int i3, String str, boolean z16);

    void updateFloatingWindowPosition(Point point);
}
