package com.tencent.filament.zplan.animation;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bR$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplan/animation/b;", "", "Lcom/tencent/filament/zplan/animation/a;", "track", "", "a", "", "c", "()[Lcom/tencent/filament/zplan/animation/a;", "", "b", "Lorg/json/JSONObject;", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "trackList", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<a> trackList = new ArrayList<>();

    public final void a(@NotNull a track) {
        Intrinsics.checkNotNullParameter(track, "track");
        this.trackList.add(track);
    }

    public final double b() {
        double d16 = 0.0d;
        for (a aVar : c()) {
            d16 = Math.max(d16, aVar.d());
        }
        return d16;
    }

    @NotNull
    public final a[] c() {
        Object[] array = this.trackList.toArray(new a[0]);
        if (array != null) {
            return (a[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = this.trackList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(((a) it.next()).e());
        }
        jSONObject.put("tracks", jSONArray);
        return jSONObject;
    }
}
