package com.tencent.qqlive.superplayer.player;

import androidx.annotation.NonNull;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKMediaSource {

    /* renamed from: b, reason: collision with root package name */
    private TVKPlayerVideoInfo f345370b;

    /* renamed from: a, reason: collision with root package name */
    private int f345369a = 0;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f345371c = new HashMap(1);

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface Type {
    }

    public TVKMediaSource(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.f345370b = tVKPlayerVideoInfo;
    }

    public void a(Map<String, String> map) {
        this.f345371c.clear();
        if (map != null) {
            this.f345371c.putAll(map);
        }
    }
}
