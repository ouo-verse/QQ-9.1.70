package com.tencent.now.app.music.controller;

import android.text.TextUtils;
import com.tencent.component.core.storage.StorageCenter;
import com.tencent.now.app.music.model.data.MusicItem;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f338003a = -999;

    /* renamed from: b, reason: collision with root package name */
    private int f338004b = -999;

    /* renamed from: c, reason: collision with root package name */
    private int f338005c = -999;

    public int a() {
        return this.f338005c;
    }

    public int b() {
        return this.f338003a;
    }

    public int c() {
        return this.f338004b;
    }

    public void d(MusicItem musicItem, int i3) {
        this.f338003a = com.tencent.hy.common.store.a.c("music_play_menu", 0);
        if (musicItem != null && !TextUtils.isEmpty(musicItem.songLyric)) {
            this.f338005c = 0;
        } else {
            this.f338005c = -1;
        }
        if (musicItem != null) {
            this.f338004b = musicItem.getSingFlag();
        } else {
            this.f338004b = 2;
        }
    }

    public void e(int i3) {
        this.f338005c = i3;
    }

    public void f(int i3) {
        this.f338003a = i3;
        StorageCenter.putInt("music_play_menu", i3);
    }

    public void g(int i3) {
        this.f338004b = i3;
    }
}
