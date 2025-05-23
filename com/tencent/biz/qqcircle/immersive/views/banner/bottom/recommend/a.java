package com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends RecyclerView.ViewHolder {
    QFSBottomBannerRecItemView E;

    public a(@NonNull @NotNull View view) {
        super(view);
        this.E = (QFSBottomBannerRecItemView) view;
    }

    public void l(e30.b bVar, int i3) {
        this.E.bindData(bVar, i3);
    }
}
