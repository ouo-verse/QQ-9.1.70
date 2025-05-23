package com.qzone.reborn.feedx.widget.header;

import android.content.res.Configuration;
import android.os.Message;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.business.result.QZoneResult;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface b {
    void M();

    void a0(QZoneResult qZoneResult);

    void b(RecyclerView recyclerView, int i3, int i16);

    boolean c(float f16, float f17);

    void delayShow();

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onHandleMessage(Message message);

    void onPause();

    void onPostThemeChanged();

    void onResume();

    void onStart();

    void onStop();

    void onWindowFocusChanged(boolean z16);

    void r(RecyclerView recyclerView);
}
