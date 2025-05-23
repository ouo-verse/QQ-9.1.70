package com.tencent.mobileqq.activity.photo;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.RegionDrawableData;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface c {
    View onCreateView(int i3, View view, ViewGroup viewGroup);

    void onDestroyView(int i3, View view, ViewGroup viewGroup);

    void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData);

    void onSlot(int i3, View view, ViewGroup viewGroup);

    void onViewDetached(int i3, View view, ViewGroup viewGroup, boolean z16);

    void onscaleBegin(int i3, View view, ViewGroup viewGroup);
}
