package com.qzone.proxy.covercomponent.model;

import java.lang.ref.SoftReference;

/* loaded from: classes39.dex */
public class LoadPhotoState {
    public int alian;
    public SoftReference<PhotoLoadedListener> listener;
    public int orientation;
    public String url;

    public LoadPhotoState(String str, int i3, int i16, PhotoLoadedListener photoLoadedListener) {
        this.url = str;
        this.orientation = i3;
        this.alian = i16;
        this.listener = new SoftReference<>(photoLoadedListener);
    }

    public LoadPhotoState(String str, int i3, PhotoLoadedListener photoLoadedListener) {
        this(str, i3, 0, photoLoadedListener);
    }
}
