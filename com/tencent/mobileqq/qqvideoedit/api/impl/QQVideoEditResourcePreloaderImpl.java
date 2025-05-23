package com.tencent.mobileqq.qqvideoedit.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditResourcePreloader;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes17.dex */
public class QQVideoEditResourcePreloaderImpl implements IQQVideoEditResourcePreloader {
    private final ConcurrentHashMap<Integer, View> mPreloadViews = new ConcurrentHashMap<>();

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditResourcePreloader
    public View getPreloadView(int i3) {
        return this.mPreloadViews.remove(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditResourcePreloader
    public void preload(Context context) {
    }
}
