package com.tencent.mobileqq.doodle;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.scribble.b;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IScribbleResMgr extends QRouteApi {
    ArrayList<Integer> GetGifVisibleIdList();

    ArrayList<Integer> GetPaintVisibleIdList();

    String GetResIconPath(int i3, int i16);

    String GetResPath(int i3, int i16);

    void StartDownloadRes(int i3, int i16, View view, b bVar);
}
