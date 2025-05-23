package com.tencent.qqmini.minigame.model;

import androidx.annotation.NonNull;

/* loaded from: classes23.dex */
public class GamePluginInfo {

    /* renamed from: id, reason: collision with root package name */
    @NonNull
    public final String f346538id;

    @NonNull
    public final String name;

    @NonNull
    public final String path;

    @NonNull
    public final String version;

    public GamePluginInfo(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        this.name = str;
        this.f346538id = str2;
        this.version = str3;
        this.path = str4;
    }
}
