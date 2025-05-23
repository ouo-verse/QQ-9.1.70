package com.tencent.mobileqq.guild.discover.widget;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class a extends RecyclerView.ViewHolder {
    a(@NonNull FrameLayout frameLayout) {
        super(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static a l(@NonNull ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(ViewCompat.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new a(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
