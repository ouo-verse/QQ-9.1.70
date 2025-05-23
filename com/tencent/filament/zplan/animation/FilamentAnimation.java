package com.tencent.filament.zplan.animation;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "", "()V", "duration", "", "getDuration", "()D", "setDuration", "(D)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "toJSON", "Lorg/json/JSONObject;", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentAnimation {
    private double duration;
    private int index;

    @Nullable
    private String path;

    public final double getDuration() {
        return this.duration;
    }

    public final int getIndex() {
        return this.index;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final void setDuration(double d16) {
        this.duration = d16;
    }

    public final void setIndex(int i3) {
        this.index = i3;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    @NativeMethodProxy(enabled = false)
    @NotNull
    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", this.path);
        jSONObject.put("index", this.index);
        jSONObject.put("duration", this.duration);
        return jSONObject;
    }
}
