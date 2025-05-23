package com.tencent.tencentmap.mapsdk.maps.interfaces;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface Selectable {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnSelectedListener<T> {
        void onSelected(T t16);
    }

    boolean isSelected();

    void setSelected(boolean z16);

    <T> void setSelectedListener(OnSelectedListener<T> onSelectedListener);
}
