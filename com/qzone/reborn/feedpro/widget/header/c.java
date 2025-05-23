package com.qzone.reborn.feedpro.widget.header;

import android.content.res.Configuration;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface c {
    void L(RecyclerView recyclerView);

    void M();

    void N(RecyclerView.ViewHolder viewHolder);

    void b(RecyclerView recyclerView, int i3, int i16);

    boolean c(float f16, float f17);

    void g0(RecyclerView.ViewHolder viewHolder);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();

    void onInit();

    void onPostThemeChanged();
}
