package com.qzone.preview;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.qzone.preview.BasePictureViewer;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.widget.ListView;
import cooperation.qzone.remote.Callback;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface b {
    void H0(int i3);

    void S0(boolean z16);

    void S7(boolean z16);

    void U7();

    boolean X();

    void d1(boolean z16);

    Handler getHandler();

    Activity getHostActivity();

    ListView getListView();

    int getShowType();

    GalleryManager h7();

    View h8();

    boolean h9();

    int j0();

    void k0(View view);

    Callback n7();

    TextView o3();

    void o5();

    void q1();

    void updateUI();

    void w1();

    void x2(BasePictureViewer.n nVar);

    void y1();

    boolean z0();
}
